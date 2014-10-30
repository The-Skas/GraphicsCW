/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication12;

/**
 *
 * @author skas
 */
public class JavaApplication12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        // TODO code application logic here
        
        //test Point3D;
        Point3D p1 = new Point3D(3,4,6.5);
        
        System.out.println("p1 - distance: "+p1.distance(new Point3D(1,1,1)));
        
        System.out.println(p1);
        
        //Test Vector3D
        Vector3D v1 = new Vector3D(2,1,-3);
        Vector3D v2 = new Vector3D(0, 4,5);
        
        System.out.println("CROSS Product of v1 x v2 = "+v1.crossProduct(v2));
        
        //CALCULATE Dot product
        
        Vector3D v3 = new Vector3D(1,2,3);
        Vector3D v4 = new Vector3D(4,-5,6);
        
        System.out.println("Dot Product of v3 . v4 = "+v3.dotProduct(v4));
        
        //Calculate Unit for vecror
        Vector3D v5 = new Vector3D(1,2,2);
        v5.normalize();
        System.out.println("Unit Vector of v5 = "+ v5);
    }
    
}
