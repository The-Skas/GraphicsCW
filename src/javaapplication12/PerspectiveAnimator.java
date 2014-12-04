/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication12;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author skas
 */
public class PerspectiveAnimator extends ParallelAnimator
{
  private int x;
  public PerspectiveAnimator()
  {
      super();
      addKeyListener(new KeyListener() {
        public void keyPressed(KeyEvent e){
            PerspectiveCamera cam = (PerspectiveCamera) PerspectiveAnimator.this.camera;
            if(e.getKeyCode() == 39)
            {

                cam.cop.y -= 1;
                
                System.out.println("new Cop - "+cam.cop.x);
            }
            if(e.getKeyCode() == 37)
            {
                cam.cop.y += 1;
                
                System.out.println("new Cop - "+cam.cop.x);
            }
            
            if(e.getKeyCode() == 40)
            {
                
                cam.cop.x += 1;
                
                System.out.println("new Cop - "+cam.cop.x);
            }
            if(e.getKeyCode() == 38)
            {
                
                cam.cop.x -=1;
                
                System.out.println("new Cop - "+cam.cop.x);
            }
            
            if(e.getKeyChar() == 'w')
            {
                cam.cop.z -= 1;
            }
            else if(e.getKeyChar() == 's')
            {
                cam.cop.z += 1;
            }
                
            System.out.println("VPNZ is -" +cam.vpn.z);
            
            if(e.getKeyChar() == 'e')
            {
                cam.vpn.z -= 0.2;
            }
            else if(e.getKeyChar() == 'q')
            {
                cam.vpn.z += 0.2;
            }
        }

        public void keyReleased(KeyEvent e) { System.out.println("2test2"); }

        public void keyTyped(KeyEvent e) { System.out.println("3test3"); }
        });
      
  }
  protected void setupCamera()
  {
    camera= new PerspectiveCamera(-5,5,-5,5);
    ((PerspectiveCamera)camera).setupUVN(new Point3D(0,0,0), new Vector3D(0,0,1), new Vector3D(0,1,0));
    ((PerspectiveCamera)camera).setupCOP(new Point3D(0,0,3));
  }
  
  public static void main(String[] args)
  { 
    new PerspectiveAnimator().loop();
    
  }
  
  public static void keyPressed(KeyEvent e) 
  {
  }
}
