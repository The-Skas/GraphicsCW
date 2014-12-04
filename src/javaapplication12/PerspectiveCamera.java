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
  public Point3D cop=new Point3D(0,0,-4); //centre of projection
  public Point3D vrp=new Point3D(0,0,0); //view reference point: the origin of camera coordinating system
 
  public Vector3D vpn=new Vector3D(0,0,0);
  public Vector3D vuv=new Vector3D(0,1,0);  //view plane normal (axis n) and the view up vector (axis v)

  public PerspectiveCamera(double xmin_, double xmax_, double ymin_, double ymax_)
  {
      super( xmin_,  xmax_,  ymin_,  ymax_);
  }
  @Override
  public Vector3D getVPN()
  {
      return (vpn.normalize().multiply(this.cop.vector()));
  }

  @Override
  protected Point3D projectionTransform(final Point3D p){
//      return super.projectionTransform(p);
      //double d = this.cop.distance(p);
      Vector3D diffV = this.cop.subtract(p).vector();
      Vector3D d = diffV.clone();
     
//      Vector3D d = diffV.clone();
      d.x= Math.cos(vpn.y)* (Math.sin(vpn.z)*diffV.y + Math.cos(vpn.z)*diffV.x) - Math.sin(vpn.y)*diffV.z;
      d.y = Math.sin(vpn.x) * (Math.cos(vpn.y)*diffV.z + Math.sin(vpn.y)*(Math.sin(vpn.z)*diffV.y + Math.cos(vpn.z)*diffV.x)) + Math.cos(vpn.x)*(Math.cos(vpn.z)*diffV.y - Math.sin(vpn.z)*diffV.x); 
      d.z = Math.cos(vpn.x) * (Math.cos(vpn.y)*diffV.z + Math.sin(vpn.y)*(Math.sin(vpn.z)*diffV.y + Math.cos(vpn.z)*diffV.x)) - Math.sin(vpn.x)*(Math.cos(vpn.z)*diffV.y - Math.sin(vpn.z)*diffV.x);
//      double trans_X = -diffV.x/diffV.z;
//      double trans_X = -diffV.y/diffV.z;
      double trans_X = d.x/d.z;
      double trans_Y = d.y/d.z;
      return new Point3D(trans_X, trans_Y, d.z);
  }
  
  @Override
  protected Point3D cameraTransform(final Point3D p)
  {
      return p;
  }
  public void setupCOP(Point3D cop_)
  {
      this.cop = cop_;
  }     

  public void setupUVN(Point3D vrp_, Vector3D vpn_, Vector3D vuv_)
  {
      this.vrp =vrp_;
      this.vpn = vpn_;
      this.vuv = vuv_;
  }
}
