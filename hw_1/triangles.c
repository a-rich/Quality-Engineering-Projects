/*
 * Should properly state whether or not 3 sides form a triangle and, if so,
 * what type the triangle is. Please check this for accuracy!
 *
 * Compile: `gcc -std=c99 -o triangles triangles.c`
 * Run: `./triangles`
 */

#include <stdio.h>
#include <string.h>

#define EXPAND_ARGS(args) args[0], args[1], args[2]

int find_largest_side(int a, int b, int c, int * other_sides) {
    /*
     * Finds the largest of three lines, isolates the two remaining lines by
     * copying them into an array, and then returns the largest line.
     */

    int largest = (a > b && a >c ) ? a : (b > c ? b : c);
    memcpy(other_sides,
            (a == largest) ? (int [2]){b, c} :
                    ((b == largest) ? (int [2]){a, c} : (int [2]){a, b}),
            2*sizeof(int));
    return largest;
}

int is_triangle(int a, int b, int c) {
    /*
     * Tests the triangle inequality which states that the largest side of a
     * triangle must be less than the sum of the two remaining sides.
     */

    int others[2];
    if (find_largest_side(a, b, c, others) < others[0] + others[1])
        return 1;
    return 0;
}

char * triangle_type(int a, int b, int c) {
    /*
     * Checks if all sides of the triangle are equal (equilateral), else if any
     * two sides are equal (isosceles), else no sides are equal (scalene).
     * Returns a string stating which type the triangle is.
     */

    return (a == b && b == c) ? "n equilateral" : ((a == b || a == c || b == c)
            ? "n isosceles" : " scalene");
}

int main() {
    /*
     * Defines an array of independent tests where each test contains three
     * integers representing the lengths of the sides of a supposed triangle.
     * Prints whether or not the sides form a triangle for each test.
     */

    int tests[4][3] = {
        {2, 4, 5},
        {2, 5, 5},
        {5, 5, 5},
        {2, 3, 5}
    };

    for (int i=0; i < sizeof(tests)/sizeof(tests[0]); i++)
        if (is_triangle(EXPAND_ARGS(tests[i])))
            printf("Sides %d, %d, and %d form a%s triangle.\n",
                    EXPAND_ARGS(tests[i]),
                    triangle_type(EXPAND_ARGS(tests[i])));
        else
            printf("Sides %d, %d, and %d do not form a triangle.\n",
                    EXPAND_ARGS(tests[i]));
}
