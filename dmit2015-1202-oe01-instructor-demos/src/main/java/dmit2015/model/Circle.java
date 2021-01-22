package dmit2015.model;

/**
 * This class models a Circle shape.
 *
 * @author Sam Wu
 * @version 2021.01.13
 */
public class Circle {

    /** The radius of the Circle */
    private double radius;

    /** Construct a circle with a radius of 1 */
    public Circle() {
        radius = 1;
    }

    /** Construct a circle with a specific radius */
    public Circle(double newRadius) {
        radius = newRadius;
    }

    /**
     * Return the radius of the circle
     * @return the radius of the circle
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Set the radius of the circle
     * @param radius The new radius of the circle
     */
    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            throw new RuntimeException("Radius value must be greater than 0");
        }
    }

    /**
     * Calculate and return the area of the circle
     *
     * @return the area of the circle
     */
    public double area() {
        return Math.PI * radius * radius;
    }

    /**
     * Calculate and return the circumference of the circle
     * @return the circumference of the circle
     */
    public double circumference() {
        return 2 * Math.PI * radius;
    }

    /**
     * Calculate and return the diameter of the circle
     * @return the diameter of the cirlce
     */
    public double diameter() {
        return 2 * radius;
    }
}
