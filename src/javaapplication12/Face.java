/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication12;

import java.awt.Color;

/**
 *
 * @author skas
 */
public class Face {
  public int[] index;
  public Color color;

  public Face(int[] i, Color c)
  {
      this.index = i;
      this.color = c;
  }

  @Override
  public String toString(){
      return "Face: Color - "+this.color;
  }

}
