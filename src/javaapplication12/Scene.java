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
import java.awt.*;

public class Scene
{
  private GObject[] obj;

  public Scene(String[] fileName){
      
      //Obj.length will always be equal to fileName.length
      obj = new GObject[fileName.length];
      
      //Loads all GObject data into Objects.
      for(int i = 0; i < obj.length; i++)
      {
          obj[i] = new GObject(fileName[i]);
      }
  }

  public void transform(Matrix m)
  {
      for(int i = 0; i < obj.length; i++)
      {
          obj[i].transform(m);
      }
  }

  //wait until next lab for Camera
  public void draw(Camera c, Graphics g){
      //Map through each Object
      for(int i = 0; i <  obj.length; i++)
      {
          
          Point3D [] array_of_vertices = obj[i].vertex;
          
          //For each Object has faces, loop through
          for(int j = 0; j < obj[i].face.length; j++)
          {
              Face curr_face = obj[i].face[j];
              
              int [] vertices_indices_in_face = curr_face.index;
              int num_of_vertices_indices_in_face = vertices_indices_in_face.length;
              
              //Each face as N, vertices, keep order and map to an array.
              int [] xArr = new int[num_of_vertices_indices_in_face];
              int [] yArr = new int[num_of_vertices_indices_in_face];
              
              for(int k = 0; k < num_of_vertices_indices_in_face; k++)
              {
                  Point3D vertex = array_of_vertices[vertices_indices_in_face[k]];
                  
                  //Project (translate) 'vertex' 
                  vertex = c.project(vertex);
                  
                  //Use mutateed  vertex
                  xArr[k] =(int) vertex.x;
                  yArr[k] =(int) vertex.y;
              }
              
              //set color then draw
              g.setColor(curr_face.color);
              
              
              boolean isFrontFace = Point3D.isFrontFace(array_of_vertices[vertices_indices_in_face[0]], array_of_vertices[vertices_indices_in_face[1]], array_of_vertices[vertices_indices_in_face[2]], c.getVPN());
              
              if(isFrontFace)
              {
                g.fillPolygon(xArr, yArr, num_of_vertices_indices_in_face);
              }
          }
           
            
          
      }
      
  }

  public String toString(){
      return "Some text";
  }
}
