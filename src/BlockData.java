import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.util.function.IntPredicate;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.omg.PortableServer.ForwardRequest;

public class BlockData {

 protected enum Tetrominoe { 
  NoShape, block1, block2, block3, 
  block4, block5, block6; 
 }
 
 public int ID; 
 public int[] shapes; 
 public int[][] coords; 
 public int[] edges;


   
   public Integer[][] Piece(Integer choosePiece) 
   {
    Integer[][] block = new Integer[5][5];
    
    for(int i=0; i<5; i++)
    {
     for(int j=0; j<5; j++)
     {
      block[i][j] = 0;
     }
    }
    
    if(choosePiece == 1)
    {
    
      block[2][2]=1;
    }
    
    
    if(choosePiece == 2)
    {
     block[2][1]=1;
     block[2][2]=1;
    }
    
    if(choosePiece == 3)
    {
     block[2][1]=1;
     block[2][2]=1;
     block[3][2]=1;
    }
    
    if(choosePiece == 4)
    {
     block[2][1]=1;
     block[2][2]=1;
     block[2][3]=1;
    }
    if(choosePiece == 5)
    {
     block[2][1]=1;
     block[2][2]=1;
     block[3][1]=1;
     block[3][2]=1;
    }
    if(choosePiece == 6)
    {
     block[2][2]=1;
     block[3][2]=1;
     block[3][1]=1;
     block[3][3]=1;
    }
    if(choosePiece == 7)
    {
     block[2][0]=1;
     block[2][1]=1;
     block[2][2]=1;
     block[2][3]=1;
    }
    
    if(choosePiece == 8)
    {
     block[3][0]=1;
     block[3][1]=1;
     block[3][2]=1;
     block[2][2]=1;
    }
    
    if(choosePiece == 9)
    {
     block[3][1]=1;
     block[3][2]=1;
     block[2][2]=1;
     block[2][3]=1;
    }
    
    if(choosePiece == 10)
    {
     block[3][0]=1;
     block[2][0]=1;
     block[3][1]=1;
     block[3][2]=1;
     block[3][3]=1;
    }
    
    if(choosePiece == 11)
    {
     block[0][2]=1;
     block[1][2]=1;
     block[2][1]=1;
     block[2][3]=1;
     block[2][2]=1;
    }
    
    if(choosePiece == 12)
    {
     block[1][1]=1;
     block[2][1]=1;
     block[3][1]=1;
     block[3][2]=1;
     block[3][3]=1;
    }
    
    if(choosePiece == 13)
    {
     block[3][0]=1;
     block[3][1]=1;
     block[2][1]=1;
     block[2][2]=1;
     block[2][3]=1;
    }
    
    if(choosePiece == 14)
    {
     block[3][1]=1;
     block[2][1]=1;
     block[2][2]=1;
     block[2][3]=1;
     block[1][3]=1;
    }
    
    if(choosePiece == 15)
    {
     block[2][2]=1;
     block[0][2]=1;
     block[1][2]=1;
     block[3][2]=1;
     block[4][2]=1;
    }
    
    if(choosePiece == 16)
    {
     block[1][1]=1;
     block[2][1]=1;
     block[3][1]=1;
     block[2][2]=1;
     block[3][2]=1;
    }
    
    if(choosePiece == 17)
    {
     block[3][1]=1;
     block[2][1]=1;
     block[2][2]=1;
     block[1][2]=1;
     block[1][3]=1;
    }
    
    if(choosePiece == 18)
    {
     block[1][1]=1;
     block[1][2]=1;
     block[2][1]=1;
     block[3][1]=1;
     block[3][2]=1;
    }
    
    if(choosePiece == 19)
    {
     block[2][1]=1;
     block[2][2]=1;
     block[3][2]=1;
     block[1][2]=1;
     block[1][3]=1;
    }
    
    if(choosePiece == 20)
    {
     block[1][2]=1;
     block[2][2]=1;
     block[2][1]=1;
     block[2][3]=1;
     block[3][2]=1;
    }
    
    if(choosePiece == 21)
    {
     block[2][1]=1;
     block[3][0]=1;
     block[3][1]=1;
     block[3][2]=1;
     block[3][3]=1;
    }
    
    return block;

   }
 
 
 public void paintBlocksButtons(Integer[][] blockValues, Color color, JPanel panel) {
  JButton[][] blocksPainted = new JButton[5][5]; 
  Integer[][] tempIntegers =  {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}}; 
  
  tempIntegers = blockValues;
  blocksPainted = new JButton[5][5]; 
  panel.setLayout(new GridLayout(5,5));
  
      for (int i =0; i<(5); i++){
       for(int j =0; j<5; j++) {
        
        blocksPainted[i][j] = new JButton();
        //blocksPainted[i][j].setVisible(false);
        blocksPainted[i][j].setText(""+tempIntegers[i][j]);
        blocksPainted[i][j].setBackground(Color.WHITE);
        
        
           if(tempIntegers[i][j]==1) {
           
        blocksPainted[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
           blocksPainted[i][j].setBackground(color);
           blocksPainted[i][j].setVisible(true);
           blocksPainted[i][j].setText(""+tempIntegers[i][j]);
           
           
           }
           else if(tempIntegers[i][j]==2)
           {
            blocksPainted[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            blocksPainted[i][j].setBackground(Color.lightGray);
            blocksPainted[i][j].setVisible(true); 
           }
           else if(tempIntegers[i][j]==3)
           {
            blocksPainted[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            blocksPainted[i][j].setBackground(Color.gray);
            blocksPainted[i][j].setVisible(true); 
           }
          
           panel.add(blocksPainted[i][j]);
           blocksPainted[i][j].removeAll();
        blocksPainted[i][j].revalidate();
        blocksPainted[i][j].repaint();
         
         
       }
     
       }
 
 }}