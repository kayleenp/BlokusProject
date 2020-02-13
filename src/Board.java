import java.awt.Color;
import java.awt.Event;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Board {

	public int[][] board;

	
	public int showNewPoints(Player blokusPlayer) {
		return 0;  
	}
	
	public JButton[][] boardGrid(JPanel panel, Integer[][] blockOnBoard)
	{
		
		//GRID 
		
				
				JButton[][] grid= new JButton[20][20];
				Integer[][] gridValue = new Integer[20][20]; 
				
				
				for (int i =0; i<(20); i++){
					for(int j =0; j<20; j++) {
						
						gridValue[i][j] = 0; 
						blockOnBoard[i][j] = 0; 
						
						grid[i][j] = new JButton(); 
						//grid[i][j].setText("" + gridValue[i][j]);
						// final JButton square = new JButton();
						 grid[i][j].setBackground(Color.white);
						 grid[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
						 grid[i][j].setContentAreaFilled(false);
					     grid[i][j].setOpaque(true);
						    panel.add(grid[i][j]);
						 	

					}
				}
				
				return grid; 
				
	}
	
	public void gridClicked(JPanel panel, JButton[][] grid,  Integer[][] blockOnBoard, Integer[][] piece, Color color)
	{
		 
		  for (int i =0; i<(20); i++){
				for(int j =0; j<20; j++) {
					
					
				//	grid[i][j].setText(""+blockOnBoard[i][j]);
					final int row=i; 
					final int col=j;
				    
					 
					   grid[i][j].addMouseListener(new java.awt.event.MouseAdapter() {
				
				 	   public void mouseClicked(MouseEvent evt) {
				 		   if(evt.getClickCount()==2) {
				 			 
					    	if(evt.getSource() == grid[row][col])
					    	{
					    		
					    		for(int i=row; i<row+5; i++)
								{
									
									for (int j=col; j<col+5; j++)
									{
											
										 blockOnBoard[i][j] = piece[i-row][j-col]; 
										
									
										if(blockOnBoard[i][j]==1)
										{
											grid[i][j].setBackground(color);
											piece[i-row][j-col] = 0; 
										//    grid[i][j].setText("" + blockOnBoard[i][j]);
										  
										}
										 
										
										
									}
								}
					    	}
					    }}
				 	  public void mouseEntered(MouseEvent evt) {
				 		 
				 			 
					    	if(evt.getSource() == grid[row][col])
					    	{
					    		
					    		for(int i=row; i<row+5; i++)
								{
									
									for (int j=col; j<col+5; j++)
									{
											
										
										
										blockOnBoard[i][j] = piece[i-row][j-col]; 
										if( blockOnBoard[i][j]==1)
										{
											grid[i][j].setBackground(Color.gray);
											
											
											 
										}
										
									
										
										
										
									}
								}
					    	
					    }}
				 	  
					  public void mouseExited(MouseEvent evt) {
					 		 
				 			 
					    	if(evt.getSource() == grid[row][col])
					    	{
					    		
					    		for(int i=row; i<row+5; i++)
								{
									
									for (int j=col; j<col+5; j++)
									{
										blockOnBoard[i][j] = piece[i-row][j-col];
										if(blockOnBoard[i][j] == 1)
										{
											grid[i][j].setBackground(Color.white);
										}
								
									
									
										
										
										
									}
								}
					    	
					    }}
			
				}); }
					
					   
					   
					
				}}
		  
		 
	}
	

