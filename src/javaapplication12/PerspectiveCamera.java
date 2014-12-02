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
public class PerspectiveCamera extends Camera
{
  private Point3D cop=new Point3D(0,0,-4); //centre of projection
  public PerspectiveCamera(double xmin_, double xmax_, double ymin_, double ymax_)
  {
      super( xmin_,  xmax_,  ymin_,  ymax_);
  }
  @Override
  public Vector3D getVPN()
  {
      return new Vector3D(0,0,1);
  }

  @Override
  protected Point3D projectionTransform(final Point3D p){
//      return super.projectionTransform(p);
      double d = this.cop.distance(p);
      
      
      double trans_X = p.x/d;
      double trans_Y = p.y/d;
      
     
      return new Point3D(trans_X, trans_Y, 0);
  }

  public void setupCOP(Point3D cop_)
  {
      this.cop = cop_;
  }     

  
}
