
/*
 * This is the test driver for our "progress bar". It tests to ensure that:
 *     - BLUE is returned trivially when no progress has been made
 *     - RED is returned trivially when any progress has been made and the
 *       center point is used
 *     - BLUE is returned trivially when the point lies in any of the screen's
 *       corners
 *     - RED and BLUE are returned when the point lies inside or outside,
 *       respectively, of the shaded region when progress is 1/8, 3/8, 5/8, 7/8
 *       complete.
 *
 * Compile: `gcc test_driver.c -lm -o test_driver`
 * Run: `./test_driver`
 */

#include "progress_bar.h"

int main() {
    char * color;
    double p;
    int x, y;

    /*
     * Testing when non-positive progress has been made.
     * Should return BLUE.
     */
    p = 0, x = 50, y = 50;
    color = red_or_blue(p, x, y);
    printf("Testing when non-positive progress has been made.\nShould return BLUE.\np=%f, x=%d, y=%d: %s\n\n", p, x, y, color);

    /*
     * Testing when the center point is used for any amount of progress.
     * Should return RED.
     */
    p = 0.0001, x = 50, y = 50;
    color = red_or_blue(p, x, y);
    printf("Testing when the center point is used for any amount of progress.\nShould return RED.\np=%f, x=%d, y=%d: %s\n\n", p, x, y, color);

    /*
     * Testing when the progress circle is 1/8 shaded and the point lies
     * within the shaded region.
     * Should return RED.
     */
    p = 0.125, x = 75, y = 75;
    color = red_or_blue(p, x, y);
    printf("Testing when the progress circle is 1/8 shaded and the point lies within the shaded region.\nShould return RED.\np=%f, x=%d, y=%d: %s\n\n", p, x, y, color);

    /*
     * Testing when the progress circle is 1/8 shaded and the point lies
     * outside of the shaded region.
     * Should return BLUE.
     */
    p = 0.125, x = 75, y = 74;
    color = red_or_blue(p, x, y);
    printf("Testing when the progress circle is 1/8 shaded and the point lies outside of the shaded region.\nShould return BLUE.\np=%f, x=%d, y=%d: %s\n\n", p, x, y, color);

    /*
     * Testing when the progress circle is 3/8 shaded and the point lies
     * within the shaded region.
     * Should return RED.
     */
    p = 0.375, x = 75, y = 25;
    color = red_or_blue(p, x, y);
    printf("Testing when the progress circle is 3/8 shaded and the point lies within the shaded region.\nShould return RED.\np=%f, x=%d, y=%d: %s\n\n", p, x, y, color);

    /*
     * Testing when the progress circle is 3/8 shaded and the point lies
     * outside of the shaded region.
     * Should return BLUE.
     */
    p = 0.375, x = 75, y = 24;
    color = red_or_blue(p, x, y);
    printf("Testing when the progress circle is 3/8 shaded and the point lies outside of the shaded region.\nShould return BLUE.\np=%f, x=%d, y=%d: %s\n\n", p, x, y, color);

    /*
     * Testing when the progress circle is 5/8 shaded and the point lies
     * within the shaded region.
     * Should return RED.
     */
    p = 0.625, x = 25, y = 25;
    color = red_or_blue(p, x, y);
    printf("Testing when the progress circle is 5/8 shaded and the point lies within the shaded region.\nShould return RED.\np=%f, x=%d, y=%d: %s\n\n", p, x, y, color);

    /*
     * Testing when the progress circle is 5/8 shaded and the point lies
     * outside of the shaded region.
     * Should return BLUE.
     */
    p = 0.625, x = 25, y = 26;
    color = red_or_blue(p, x, y);
    printf("Testing when the progress circle is 5/8 shaded and the point lies outside of the shaded region.\nShould return BLUE.\np=%f, x=%d, y=%d: %s\n\n", p, x, y, color);

    /*
     * Testing when the progress circle is 7/8 shaded and the point lies
     * within the shaded region.
     * Should return RED.
     */
    p = 0.875, x = 25, y = 75;
    color = red_or_blue(p, x, y);
    printf("Testing when the progress circle is 7/8 shaded and the point lies within the shaded region.\nShould return RED.\np=%f, x=%d, y=%d: %s\n\n", p, x, y, color);

    /*
     * Testing when the progress circle is 7/8 shaded and the point lies
     * outside of the shaded region.
     * Should return BLUE.
     */
    p = 0.875, x = 25, y = 76;
    color = red_or_blue(p, x, y);
    printf("Testing when the progress circle is 7/8 shaded and the point lies outside of the shaded region.\nShould return BLUE.\np=%f, x=%d, y=%d: %s\n\n", p, x, y, color);

    /*
     * Testing when the point lies in the top-left corner of the screen.
     * Should return BLUE.
     */
    p = 1, x = 0, y = 100;
    color = red_or_blue(p, x, y);
    printf("Testing when the point lies in the top-left corner of the screen.\nShould return BLUE\np=%f, x=%d, y=%d: %s\n\n", p, x, y, color);

    /*
     * Testing when the point lies in the top-right corner of the screen.
     * Should return BLUE.
     */
    p = 1, x = 100, y = 100;
    color = red_or_blue(p, x, y);
    printf("Testing when the point lies in the top-right corner of the screen.\nShould return BLUE.\np=%f, x=%d, y=%d: %s\n\n", p, x, y, color);

    /*
     * Testing when the point lies in the bottom-right corner of the
     * screen.
     * Should return BLUE.
     */
    p = 1, x = 100, y = 0;
    color = red_or_blue(p, x, y);
    printf("Testing when the point lies in the bottom-right corner of the screen.\nShould return BLUE.\np=%f, x=%d, y=%d: %s\n\n", p, x, y, color);

    /*
     * Testing when the point lies in the bottom-left corner of the
     * screen.
     * Should return BLUE.
     */
    p = 1, x = 0, y = 0;
    color = red_or_blue(p, x, y);
    printf("Testing when the point lies in the bottom-left corner of the screen.\nShould return BLUE.\np=%f, x=%d, y=%d: %s\n\n", p, x, y, color);

    return 0;
}
