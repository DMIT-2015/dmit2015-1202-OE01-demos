package dmit2015.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @Test
    void area() {
        // Create a Circle object with a radius of 5
        Circle circle1 = new Circle(5);
        // The area of the circle should be 78.54
        assertEquals(78.54, circle1.area(), 0.005);
    }

    @Test
    void circumference() {
        // Create a Circle object with a radius of 1
        Circle circle1 = new Circle();
        // Change the radius of the Circle to 10
        circle1.setRadius(10);
        // The new radius should be 10
        assertEquals(10, circle1.getRadius());
        // The circumference should be 62.83
        assertEquals(62.83, circle1.circumference(), 0.005);
    }

    @Test
    void diameter() {
        // Create a Circle object with radius of 15
        Circle circle1 = new Circle(15);
        // The diameter of the circle should be
        assertEquals(30, circle1.diameter(), 0);
    }

    @Test
    void invalidRadius() {
        Circle circle1 = new Circle();
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> circle1.setRadius(-10));
        assertEquals("Radius value must be greater than 0", exception.getMessage());
    }
}