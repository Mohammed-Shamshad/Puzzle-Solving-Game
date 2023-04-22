/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maze_solver_mini_project;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author SHAMSHAD SAMEER
 */
public class MAZE_SOLVER_MINI_PROJECT extends JFrame {
    
    
    private int[][] maze = 
            
{ {1,1,1,1,1,1,1,1,1,1,1,1,1},
  {1,0,1,0,1,0,1,0,0,0,0,0,1},
  {1,0,1,0,0,0,1,0,1,1,1,0,1},
  {1,0,0,0,1,1,1,0,0,0,0,0,1},
  {1,0,1,0,0,0,0,0,1,1,1,0,1},
  {1,0,1,0,1,1,1,0,1,0,0,0,1},
  {1,0,1,0,1,0,0,0,1,1,1,0,1},
  {1,0,1,0,1,1,1,0,1,0,9,0,1},
  {1,0,0,0,0,0,0,0,0,0,1,0,1},
  {1,1,1,1,1,1,1,1,1,1,1,1,1}

};
    
    
    public ArrayList<Integer> pathToDestination = new ArrayList<>();
    
    
    public MAZE_SOLVER_MINI_PROJECT(){
        
        setTitle("Maze Solver Game");
        setSize(640 , 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DFS.searchPath(maze, 1, 1, pathToDestination);
        System.out.println(pathToDestination);
    }
    
    @Override
    public void paint(Graphics g){
        g.translate(60, 60);
        
        for(int i =0 ; i<maze.length ; i++){
            for(int j =0 ; j<maze[0].length ;j++){
                
                
                Color color;
                
                switch(maze[i][j]){
                
                case 1: color = Color.BLACK ; break;
                case 9: color = Color.GREEN; break;
                default: color= Color.WHITE; break;
            }
                
                g.setColor(color);
                g.fillRect(30*j, 30*i, 30,30 );
                g.setColor(Color.BLACK);
                g.drawRect(30*j, 30*i, 30,30 );
                
                
            }
            
        }
        for(int i=0;i<pathToDestination.size() ;i+=2){
                
                int pathx = pathToDestination.get(i);
                int pathy = pathToDestination.get(i+1);
                
                System.out.println("X Coordinates" +pathx);
                System.out.println("Y Coordinates" +pathy);
                
                g.setColor(Color.YELLOW);
                g.fillRect(30*pathx, 30*pathy, 30,30 );
            }
    }
    public static void main(String[] args) {
        MAZE_SOLVER_MINI_PROJECT view = new MAZE_SOLVER_MINI_PROJECT();
        
        view.setVisible(true);
    }
}
