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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author skas
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({javaapplication12.Vector3DTest.class, javaapplication12.GObjectTest.class, javaapplication12.Point3DTest.class, javaapplication12.FaceTest.class, javaapplication12.JavaApplication12Test.class})
public class Javaapplication12Suite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
