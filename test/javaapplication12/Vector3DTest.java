/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication12;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author skas
 */
public class Vector3DTest {
    private Vector3D vector;
    
    public Vector3DTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.vector = new Vector3D(5,5,5);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of toString method, of class Vector3D.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Vector3D instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clone method, of class Vector3D.
     * @throws java.lang.Exception
     */
    @Test
    public void testClone() throws Exception {
        
        Vector3D result = vector.clone();
        assertEquals(vector, result);
    }

    /**
     * Test of L2norm method, of class Vector3D.
     */
    @Test
    public void testL2norm() {
        System.out.println("L2norm");
        Vector3D instance = null;
        double expResult = 0.0;
        double result = instance.L2norm();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dotProduct method, of class Vector3D.
     */
    @Test
    public void testDotProduct() {
        System.out.println("dotProduct");
        Vector3D v = null;
        Vector3D instance = null;
        double expResult = 0.0;
        double result = instance.dotProduct(v);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crossProduct method, of class Vector3D.
     */
    @Test
    public void testCrossProduct() {
        System.out.println("crossProduct");
        Vector3D v = null;
        Vector3D instance = null;
        Vector3D expResult = null;
        Vector3D result = instance.crossProduct(v);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of normalize method, of class Vector3D.
     */
    @Test
    public void testNormalize() {
        this.vector.normalize();
        assertEquals(vector.magnitude(), 1.0, 0.00001);
    }

    /**
     * Test of magnitude method, of class Vector3D.
     */
    @Test
    public void testMagnitude() {
        Vector3D vecMagnitude;
    }

    /**
     * Test of transform method, of class Vector3D.
     */
    @Test
    public void testTransform() {
        
    }

    /**
     * Test of equals method, of class Vector3D.
     */
    @Test
    public void testEquals() {
        assertEquals(this.equals(this), true);
      
    }
    
}
