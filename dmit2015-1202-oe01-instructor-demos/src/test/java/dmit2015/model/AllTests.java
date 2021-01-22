package dmit2015.model;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
//@SelectClasses({CircleTest.class, RectangleTest.class})
@SelectPackages("dmit2015.model")
public class AllTests {

}
