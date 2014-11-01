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
public class Camera
{
  private double xmin, xmax, ymin, ymax;
  private double fcp, bcp;  //NOT USED: front & back clippling planes
  private double ax, bx, ay, by;
  
  public Camera(double xmin_, double xmax_, double ymin_, double ymax_){
      xmin = xmin_;
      xmax = xmax_;
      ymin = ymin_;
      ymax = ymax_;
  }
  
  public void setViewport(int width, int height)
  {
      double dWx = this.xmax - this.xmin;
      double dWy = this.ymax - this.ymin;
      
      this.bx = ((double)width) / dWx;
      this.by = ((double)height)/ dWy;
      
      this.ax = -(bx*xmin);
      this.ay = -(by*ymin);
      
  }
  
  public Vector3D getVPN(){
    //Could be horribly wrong
    return new Vector3D(0,0,1);
  }

  protected Point3D cameraTransform(final Point3D p){
      return p;
  }

  protected Point3D projectionTransform(final Point3D p){
      return p;
  } 

  private final Point3D viewportTransform(final Point3D p){
      double _x = ax + bx*p.x;
      double _y = ay + by*p.y;
      
      return new Point3D(_x, _y, 0);
  }

  public final Point3D project(final Point3D p){
    Point3D temp=cameraTransform(p);
    temp=projectionTransform(temp);
    return viewportTransform(temp);
  }

  public String toString(){
      return "Some pretty debugging string.";
  }

  
}