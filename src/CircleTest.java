/*
 * TCSS 305
 * Assignment 1 - Testing
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;


import java.awt.Color;
import java.awt.Point;

import org.junit.Before;
import org.junit.Test;


/**
 *  This class tests the Circle class.
 * 
 * @author Yaro Salo
 * @version Oct 8 2016
 */
public class CircleTest {

    /** The accuracy to which doubles will be compared. */
    private static final double DELTA = 0.000001;
    
    /** A circle to use in tests. */ 
    private Circle myCircle;
    
    /**
     * Method to initialize an instance of the class before each test. 
     */
    @Before
    public void setUp() {
        myCircle = new Circle(); // (1.0, (0,0), BLACK)
    }
    
    /** 
     * Test the default constructor.
     */
    @Test
    public void testDefaultConstructor() {
        assertEquals(1.0, myCircle.getRadius(), DELTA);
        assertEquals(new Point(0, 0), myCircle.getCenter());
        assertEquals(Color.BLACK, myCircle.getColor());
        
    }
    
    /**
     * Test the overloaded constructor.
     */
    @Test
    public void testOverLoadedConstructor() {
        final Circle c1 = new Circle(4.0, new Point(4, 4), Color.GREEN);
        assertEquals(4.0, c1.getRadius() , DELTA);
        assertEquals(new Point(4, 4), c1.getCenter());
        assertEquals(Color.GREEN, c1.getColor());
    }
    
    /** Test the constructor with an illegal argument
     *  radius = -1.
     *  
     */
    @Test(expected = IllegalArgumentException.class) 
    public void testConstructorRadiusLessZero() {
        new Circle(-1, new Point(0, 0) , Color.BLACK);
        
    }
    
    /** Test the constructor with illegal argument 
     * raidus = 0.
     * 
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorRadiusZero() {
        new Circle(0 , new Point(0, 0) , Color.BLACK);
        
    }

    /** Test constructor with a null point.
     * 
     */
    @Test(expected = NullPointerException.class)
    public void testConstructorNullPoint() {
        new Circle(1.0, null, Color.BLACK);
    }
    
    /** Test the constructor with a null color.
     * 
     */
    @Test(expected = NullPointerException.class)
    public void testConstructorNullColor() {
        new Circle(1.0 , new Point(0, 0), null);
        
    }

    /**
     * Test setRadius().
     */
    @Test
    public void testSetRadius() {
        myCircle.setRadius(5.0);
        assertEquals(5.0, myCircle.getRadius(), DELTA);
        
    }
   
    /** Test the setRadius() method with illegal argument 
     * radius = -1.
     * 
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetRadiusLessZero() { 
        myCircle.setRadius(-1);
    }
   
    /** Test the setRadius() method with illegal argument 
     * radius = 0.
     * 
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetRadiusZero() { 
        myCircle.setRadius(0);
    }
   
    /**
     * Test setCenter().
     */
    @Test
    public void testSetCenter() {
        myCircle.setCenter(new Point(1, 1));
        assertEquals(new Point(1, 1), myCircle.getCenter());
        
    }
    
    /** Test the testCenter() method with a null point.
     * 
     */
    @Test(expected = NullPointerException.class)
    public void testSetCenterNull() { 
        myCircle.setCenter(null);
    }
   

    /**
     * Test method setColor().
     */
    @Test
    public void testSetColor() {
        myCircle.setColor(Color.CYAN);
        assertEquals(Color.CYAN , myCircle.getColor());

    }
    
    /** Test the setColor() method with a null color.
     * 
     */
    @Test(expected = NullPointerException.class)
    public void testSetColorNull() {
        myCircle.setColor(null);
        
    }

    /**
     * Test if the diameter is being calculated correctly.
     */
    @Test
    public void testCalculateDiameter() {
        //my circle should have diameter of 2.0.
        assertEquals(2.0, myCircle.calculateDiameter(), DELTA);
        
        
    }

    /**
     * Test if the circumference is being calculated correctly.
     */
    @Test
    public void testCalculateCircumference() { 
        final double circum1 = 2 * Math.PI * myCircle.getRadius();
        assertEquals(circum1, myCircle.calculateCircumference(), DELTA);
        
    }

    /**
     * Test if the area is being calculated properly.
     */
    @Test
    public void testCalculateArea() { // This is the test that caught the bug
       
        final double area1 = Math.PI * myCircle.getRadius() * myCircle.getRadius();
        assertEquals(area1, myCircle.calculateArea(), DELTA);
        
    }

    /**
     * Test the toString().
     */
    @Test
    public void testToString() {
        assertEquals("toString() produced an unexpected result!", 
                     "Circle [radius=1.00, center=java.awt.Point[x=0,y=0], "
                     + "color=java.awt.Color[r=0,g=0,b=0]]",
                     myCircle.toString());
    }
    /** 
     * Test the getCenter() method.
     */
    @Test 
    public void testMyCenterCopy() {
        // Make sure that a defensive copy is returned.
        final Point t1 = myCircle.getCenter();
        assertNotSame(myCircle.getRadius(), t1);
    }

}
