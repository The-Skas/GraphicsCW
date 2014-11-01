/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication12;

import java.util.Scanner;
import java.io.*;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author skas
 */
public class GObject {
  public int IND_OF_VERTICES_SIZE = 0;
  public int IND_OF_FACES_SIZE;
  
  public Point3D[] vertex;
  public Face[] face;
  
  private int number_of_vertices;
  private int number_of_faces;
  public GObject(Point3D[] v, Face[] f){
      this.vertex = v;
      this.face = f;
  }

  public GObject(String fileName) 
  {
 
    String fileContent = readFile(fileName);
    String[] lines = fileContent.split(System.getProperty("line.separator"));
    
    //For each line;
    for(int i = 0; i < lines.length; i++)
    {
        lines[i]=lines[i].replace("\n", "").replace("\r", "");
    }
   
    
    parseVertices(lines);
    
    //Now set Faces
    IND_OF_FACES_SIZE = this.number_of_vertices + 2;
    
    parseFaces(lines);
   
  }
  
  /**
   * Parses Faces of the line
   * @param lines 
   */
  private void parseFaces(String [] lines)
  {
      this.number_of_faces = Integer.parseInt(lines[IND_OF_FACES_SIZE].trim());
      face = new Face[number_of_faces];
      
      for(int i = 0; i < face.length; i++)
      {
          int ind_number_of_vertices_in_face = IND_OF_FACES_SIZE+1 + 3 * i;
          int ind_vertices_in_face = IND_OF_FACES_SIZE+2 + 3 * i;
          int ind_colour_in_face = IND_OF_FACES_SIZE+3 + 3 * i;
          
          System.out.println(lines[ind_number_of_vertices_in_face]+ "Should be 4" );
          System.out.println(lines[ind_vertices_in_face]+ "Should be '0 1 5 4'" );
          System.out.println(lines[ind_colour_in_face]+ "Should be '1.0 0.0 0.0'" );
          
          /**
           * Parse Vertex indices that the face uses
           */
          String[] vertices_indexes = lines[ind_vertices_in_face].split(" ");
          
          int size_vert = Integer.parseInt(lines[ind_number_of_vertices_in_face].trim());
          int [] vert_indices = new int[size_vert];
          
          
          for(int j = 0; j < vert_indices.length; j++)
          {
              vert_indices[j] = Integer.parseInt(vertices_indexes[j].trim());
          }
          
          /**
           * Parse Color
           */
          String [] color_float_values = lines[ind_colour_in_face].split(" ");
          
          float c1 = Float.parseFloat(color_float_values[0].trim());
          float c2 = Float.parseFloat(color_float_values[1].trim());
          float c3 = Float.parseFloat(color_float_values[2].trim());
          
          Color color = new Color(c1,c2,c3);
          
          face[i] = new Face(vert_indices, color);
         
        
      }
      
  }
  private void parseVertices(String [] lines)
  {
      //intialises vertex array size
    this.number_of_vertices = Integer.parseInt(lines[IND_OF_VERTICES_SIZE].trim());
    this.vertex = new Point3D[number_of_vertices];
    
    System.out.println("array length of vertexes is - "+ this.vertex.length);
    
    /**
     * Iterate over the vertex array and construct the vertices.
     */
    
    //We set ind to be right after the index of vertices size
    int ind = IND_OF_VERTICES_SIZE + 1;
    for(int i = 0; i < this.vertex.length; i++, ind++)
    {  
       String[] floats = lines[ind].split(" ");
       System.out.println("Should be three array of X: "+ floats[0] + 
                                                   " Y: "+ floats[1] +
                                                   " Z: "+ floats[2]);
       float x = Float.parseFloat(floats[0].trim());
       float y = Float.parseFloat(floats[1].trim());
       float z = Float.parseFloat(floats[2].trim());
       
       this.vertex[i] = new Point3D(x,y,z);
    }
    
    System.out.println("---------------------------------");
    System.out.println("Vertices should be all populated");
    System.out.println("---------------------------------");
    
    for(int i = 0; i < this.vertex.length; i++)
    {
        System.out.println(this.vertex[i]);
    }
  }
  /**
   * This function is responsable to abstract the task of reading a file.
   * Although, its not as easy as it seems.. Hm. The user still needs to call close.
   * 
   * @param fileName
   * @return 
   */
  public String readFile(String fileName){
    BufferedReader br = null;
    String everything = null;
    try {
        br = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        everything = sb.toString();
    } catch(IOException ex){
        System.out.println("Uh Oh.");
    } finally {
        try {
            br.close();
        } catch (IOException ex) {
           System.out.println("Yikes, couldnt close file.");
        }
    }
    return everything;
  }

  public void transform(Matrix m)
  {
      //Transform all vertices
      for(int i = 0; i < this.vertex.length; i++)
      {
          this.vertex[i] = this.vertex[i].transform(m);
      }
  }
  
  public String toString(){
      return "";
  }
  
  public static void main(String []args)
  {
      System.out.println("Working Directory = " +
              System.getProperty("user.dir"));
      GObject object = new GObject("pyramid.dat");
  }


}
