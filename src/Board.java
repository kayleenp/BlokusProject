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
	
	public JButton[][] boardGrid(JPanel panel)
	{
		
		//GRID 
		
				JButton[][] clickedGrid = new JButton[20][20];
				
				JButton[][] grid= new JButton[20][20];
				Integer[][] gridValue = new Integer[20][20]; 
				
				
				for (int i =0; i<(20); i++){
					for(int j =0; j<20; j++) {
						
						gridValue[i][j] = 0; 
						grid[i][j] = new JButton(); 
						final int row=i; 
						final int col=j;
					
						
						// final JButton square = new JButton();
						 grid[i][j].setBackground(Color.white);
						 grid[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
						 grid[i][j].setContentAreaFilled(false);
					     grid[i][j].setOpaque(true);
						    panel.add(grid[i][j]);
						 	
						
//							   grid[i][j].addChangeListener(new ChangeListener() {
//						            @Override
//						            public void stateChanged(ChangeEvent evt) {
//						            	if(evt.getSource() == grid[row][col])
//										{
//											for(int i=row; i<row+5; i++)
//											{
//												
//												for (int j=col; j<col+5; j++)
//												{
//													gridValue[i][j] = 0; 
//													gridValue[i][j] = block[i-row][j-col]; 
//													if(gridValue[i][j]==1)
//													{
//													if (grid[row][col].getModel().isPressed()) {
//									                    grid[i][j].setBackground(Color.blue);}
//									               }
//													
//											}
//										}
//						                
//						            }}});
//						   
//						grid[i][j].addMouseListener(new java.awt.event.MouseAdapter() {
//						 		Color color = grid[row][col].getForeground();
//						 	    public void mouseReleased(MouseEvent evt) {
//							    	if(evt.getSource() == grid[row][col])
//							    	{
//							    		for(int i=row; i<row+5; i++)
//										{
//											
//											for (int j=col; j<col+5; j++)
//											{
//												
//												gridValue[i][j] = block[i-row][j-col]; 
//												if(gridValue[i][j]==1)
//												{
//													grid[i][j].setBackground(Color.BLUE);
//												}	
//											}
//										}
//							    	}}
//						 	   public void mouseClicked(MouseEvent evt) {
//							    	if(evt.getSource() == grid[row][col])
//							    	{
//							    		for(int i=row; i<row+5; i++)
//										{
//											
//											for (int j=col; j<col+5; j++)
//											{
//												
//												gridValue[i][j] = block[i-row][j-col]; 
//												if(gridValue[i][j]==1)
//												{
//													grid[i][j].setBackground(Color.BLUE);
//													color = grid[i][j].getBackground();
//												}	
//											}
//										}
//							    	}
//							    }
//						});
//						    
					}
				}
				
				
				
				return grid; 
				
	}
	
	/*public void gridValue(JButton[][] grid, int x, int y, Integer[][] block)
	{
		
		Integer[][] gridValue = new Integer[20][20]; 
		for(int i=x; i<x+5; i++)
		{
			
			for (int j=y; j<y+5; j++)
			{
				row = x; 
				col = y; 
				gridValue[i][j] = 0; 
				gridValue[i][j] = block[i-x][j-y]; 
				
				/*
				if(gridValue[i][j]==1)
				{
					grid[i][j].setBackground(Color.BLUE);
				}	
			}
		}
	}*/
}
