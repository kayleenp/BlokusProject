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
			block[2][1] = 1 ;
			block[2][2] =1; 
		}
		
		return block;
	}
	
	
	
	public void paintBlocksButtons(Integer[][] blockValues, Color color, JPanel panel) {
		JButton[][] blocksPainted = new JButton[5][5]; 
		Integer[][] tempIntegers = new Integer[5][5]; 
		tempIntegers = blockValues;
		blocksPainted = new JButton[5][5]; 
		
			   for (int i =0; i<(5); i++){
			    for(int j =0; j<5; j++) {
			    	blocksPainted[i][j] = new JButton();
			    	blocksPainted[i][j].setVisible(false);
			    	
			    	
			    	blocksPainted[i][j].setBackground(Color.WHITE);
			       	if(tempIntegers[i][j]==1) {
			    	blocksPainted[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			        blocksPainted[i][j].setBackground(color);
			        blocksPainted[i][j].setVisible(true);
			        
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
			    	 }
			  
			    }
			panel.setLayout(new GridLayout(5,5));
			      
			   }	   
			   
	}
	
		
		
	
		
	
	

