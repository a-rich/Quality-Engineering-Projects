
/*
 * This is a program that, when provided with P (progress), X (x-coordinate),
 * and Y (y-coordinate), determines whether or not the pixel at (X, Y) is BLUE
 * (not shaded) or RED (shaded). The shading represents the fullness of a
 * "progress bar" that is in the shape of a circle. This circle shades in
 * clockwise order going through quandrants 1, 2, 3, then 4 of the screen in
 * that order.
 *
 * The function RED_OR_BLUE completes this task by first checking the trivial
 * cases (no progress, any progress with the (X, Y) point being in the center,
 * (X, Y) point lying in one of the screen's corners). Once the trivial cases
 * are enumerated, the variable boundary line of the shaded region is modeled
 * as the hypotenuse of a triangle located in one of the four quandrants
 * (depending on the input P). Once it is determined which quandrant the
 * boundary line exists in, we can solve for the y-coordinate of the hypotenuse
 * at the input point X and compare this with the input point Y to see if the
 * point (X, Y) lies inside or outside of the shaded region.
 *
 *
 * Compile: `gcc test_driver.c -lm -o test_driver`
 * Run: `./test_driver`
 */

#include <stdio.h>
#include <math.h>

char * red_or_blue(double p, int x, int y) {
    /*
     * Given the percentage of the circle shaded P and the coordinates for the
     * point in question (X, Y), return whether or not the point lies inside
     * the shaded sector of the circle.
     */

    if (p <= 0) {
        /*
         * If no progress has been made, then every pixel is trivially blue.
         */

        return "BLUE";
    }

    /*
     * Radius of the circle. Also used as the center pixel's (x,y) value when
     * calculating HEIGHT_FROM_CENTER.
     */
    int r = 50;

    // Apply Pythagorean theorem to solve for the missing side at point X.
    double height_from_center = sqrt(pow(r, 2) - pow((x-r), 2));

    if ((y > r + height_from_center) || (y < r - height_from_center)) {
        /*
         * Given the radius of the circle, we can calculate where the "corners"
         * of the screen are. If our (X,Y) point lies in one of these
         * regions, we can trivially determine that the pixel corresponding to
         * the point (X, Y) is blue.
         */

        return "BLUE";
    }

    /*
     * At this point we know that our point (X, Y) does not lie in one of the
     * screen's "corners" and we know that at least some portion of the
     * progress circle is shaded.
     *
     * We separate the circle into quandrants so we can apply Pythagoras'
     * theorem and exploit the rules of right triangles. For each triangle, we
     * calculate the equation for its hypotenuse and solve for the y at the
     * given X value. Then we check if the given point Y is above or below this
     * point y allowing us to conclude for certain whether or not the given
     * point (X, Y) is within the shaded sector.
     */

    double theta;
    double line(double theta, int x) {
        return tan(theta)*(x-50) + 50;
    }

    if (p <= 0.25) {
        /*
         * The boundary line lies in the first quandrant.
         */

        theta = (90 - (p*360)) * M_PI / 180.0;
        if (y >= (int) line(theta, x) && x >= 50)
            return "RED";
    } else if (p <= 0.5) {
        /*
         * The boundary line lies in the second quandrant.
         */

        theta = -((p*360) - 90) * M_PI / 180.0;
        if (y >= (int) line(theta, x) && x >= 50)
            return "RED";
    } else if (p <= 0.75) {
        /*
         * The boundary line lies in the third quandrant.
         */

        theta = (270 - (p*360)) * M_PI / 180.0;
        if (y <= (int) line(theta, x) || x >= 50)
            return "RED";
    } else {
        /*
         * The boundary line lies in the fourth quandrant.
         */

        theta = -((p*360) - 270) * M_PI / 180.0;
        if (y <= (int) line(theta, x) || x >= 50)
            return "RED";
    }

    return "BLUE";
}
