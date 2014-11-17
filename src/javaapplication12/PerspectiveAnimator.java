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
public class PerspectiveAnimator extends ParallelAnimator
{
  protected void setupCamera()
  {
    camera= new PerspectiveCamera(-5,5,-5,5);
    ((PerspectiveCamera)camera).setupCOP(new Point3D(0,0,3));
  }

  public static void main(String[] args)
  { 
    new PerspectiveAnimator().loop();
  }
}
