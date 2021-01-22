package dmit2015.model;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void area() {
        // Construct a Rectangle with a length of 10 and width 20
        Rectangle rectangle1 = new Rectangle(10, 20);
        // The area should be 200
        assertEquals(200, rectangle1.area());
    }

    @Test
    void perimeter() {
        // Construct a Rectangle with a length of 10 and width 20
        Rectangle rectangle1 = new Rectangle(10, 20);
        // The perimeter should be 60
        assertEquals(60, rectangle1.perimeter());
    }

    @Test
    void shouldThrowException() {
        // Construct a default Rectangle
        Rectangle rectangle1 = new Rectangle();
        // Should throw a RuntimeException when you set the length to a value of zero or less
        RuntimeException lengthException = assertThrows(
                RuntimeException.class,
                () -> rectangle1.setLength(-10)
        );
        // lengthException should not be null
        assertNotNull(lengthException);
        // The message of the lengthException should be "Length must be greater than zero."
        assertEquals("Length must be greater than zero.", lengthException.getMessage());

        // Set the length to 640
        rectangle1.setLength(640);
        // The length should be 640
        assertEquals(640, rectangle1.getLength());
    }

    @Test
    void shouldCreateImageFile() throws IOException {
        // Construct a Rectangle with width of 640 and length of 480
        Rectangle rectangle1 = new Rectangle(480, 640);
        // Create the ImageFile for the rectangle
        File rectangleImageFile = rectangle1.createImageFile("/home/user2015/Pictures/rectangle.png");
        // The image file should not be null
        assertNotNull(rectangleImageFile);
    }

}