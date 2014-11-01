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
public class Vector3D implements Cloneable, Transformable<Vector3D>    
{
  public double x,y,z;
  
  public Vector3D(Point3D p)
  {
      this.x = p.x;
      this.y = p.y;
      this.z = p.z;
  }
  public Vector3D(double X, double Y, double Z)
  {
      this.x = X;
      this.y = Y;
      this.z = Z;
  }

  public String toString(){
      return "Vector - X: "+this.x+" Y: "+this.y+" Z: "+this.z;
  }

  public Vector3D clone() throws CloneNotSupportedException
  {
      return new Vector3D(x,y,z);
  }
  
  public double L2norm(){
      return Math.sqrt( x*x + y*y + z*z );
  }

  public double dotProduct(Vector3D v){
      return (this.x*v.x + this.y*v.y + this.z*v.z);
  }

  //calculate cross product
  public Vector3D crossProduct(Vector3D v){
      double ox = this.y * v.z - this.z * v.y;
      double oy = this.z * v.x - this.x * v.z;
      double oz = this.x * v.y - this.y * v.x;
      
      return new Vector3D(ox, oy, oz);
  }
  
  //Return a Normalized Vector.
  public void normalize()
  {
      double magnitude = this.magnitude();
      
      this.x /= magnitude;
      this.y /= magnitude;
      this.z /= magnitude;
  } 
  
  public double magnitude(){
      return (Math.sqrt(x*x + y*y + z*z));
  }

    @Override
    public Vector3D transform(Matrix m) 
    {
        double dstX = this.x * m.m[0][0] + this.y * m.m[1][0] + this.z * m.m[2][0] + m.m[3][0];
        double dstY = this.x * m.m[0][1] + this.y * m.m[1][1] + this.z * m.m[2][1] + m.m[3][1];
        double dstZ = this.x * m.m[0][2] + this.y * m.m[1][2] + this.z * m.m[2][2] + m.m[3][2];
        
        return new Vector3D(dstX, dstY, dstZ);
    }
   

  @Override
    public boolean equals(Object o)
    {
        if (o instanceof Vector3D)
        {
            Vector3D v2 = (Vector3D) o;
            
            return (this.x == v2.x && this.y == v2.y && this.z == v2.z);
        }
        
        return false;
    }
    
    
}