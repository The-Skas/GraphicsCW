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
public class Point3D implements Transformable<Point3D>
{
  public double x,y,z;

  public Point3D(double X,double Y,double Z)
  {
      this.x = X;
      this.y = Y;
      this.z = Z;
  }

  public double distance(Point3D p){
      double distX = this.x - p.x;
      double distY = this.y - p.y;
      double distZ = this.z - p.z;
      return Math.sqrt(distX*distX + distY*distY + distZ*distZ);
  }
  
  @Override
    public Point3D transform(Matrix m) {
        //Code for transforming a point by a matrix
        
        double dstX = this.x * m.m[0][0] + this.y * m.m[1][0] + this.z * m.m[2][0] + m.m[3][0];
        double dstY = this.x * m.m[0][1] + this.y * m.m[1][1] + this.z * m.m[2][1] + m.m[3][1];
        double dstZ = this.x * m.m[0][2] + this.y * m.m[1][2] + this.z * m.m[2][2] + m.m[3][2];
        
        double w = this.x * m.m[0][3] + this.y * m.m[1][3] + this.z * m.m[2][3] + m.m[3][3];
        
        if(w != 1 && w != 0)
        {
            dstX /= w;
            dstY /= w;
            dstZ /= w;
        }
        
        return new Point3D(dstX, dstY, dstZ);
    }
  public String toString(){
      return "P( x= "+this.x+" , y= "+this.y+" , z= "+this.z+" )";
  }

}
