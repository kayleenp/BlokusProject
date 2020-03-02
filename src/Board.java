import java.awt.Color;
import java.awt.Event;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
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
		
				
				
		JButton[][] grid= new JButton[30][30];
		Integer[][] gridValue = new Integer[30][30]; 
				
				for (int i =0; i<(30); i++){
					for(int j =0; j<30; j++) {
						
						gridValue[i][j] = 0; 
						blockOnBoard[i][j] = 0; 
						
						grid[i][j] = new JButton(); 
						
						if(i>5 && j>5 && i<25 && j<25) {
						//grid[i][j].setText("" + gridValue[i][j]);
						// final JButton square = new JButton();
						 grid[i][j].setBackground(Color.white);
						 grid[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
						 grid[i][j].setContentAreaFilled(false);
					     grid[i][j].setOpaque(true);
						}
						 
						 	
						 else {
								grid[i][j].setBackground(Color.white);
							
								grid[i][j].setBorder(BorderFactory.createLineBorder(Color.white));
							}
						panel.add(grid[i][j]);
					}
					
				}
				
				return grid; 
				
	}
	
	public void gridClicked(JPanel panel, JButton[][] grid,  Integer[][] blockOnBoard, Integer[][] piece, Color color)
	{
		
			Boolean[][] flagBoolean = new Boolean[30][30];
		  for (int i =0; i<(30); i++){
				for(int j =0; j<30; j++) {
					
					
					blockOnBoard[i][j] = 0;
					final int row=i; 
					final int col=j;
				    if(blockOnBoard[i][j] == 1)
				    {
				    	flagBoolean[i][j]=false; 
				    }
				    else 
				    {
				    	flagBoolean[i][j]=false; 
				    }
					   grid[i][j].addMouseListener(new java.awt.event.MouseAdapter() {
							public Color oldColor;
							
				 	   public void mouseClicked(MouseEvent evt) {
				 		   
				 		   if(evt.getClickCount()==2) {
				 			 
					    	if(evt.getSource() == grid[row][col])
					    	{
					    		if(row+5 <=30 && col+5<=30) {
					    		for(int i=row; i<row+5; i++)
								{
									
									for (int j=col; j<col+5; j++)
									{
										
										
										
										if(blockOnBoard[i][j] == 0)
										{
										
										if(piece[i-row][j-col]==1)
										{
											
											blockOnBoard[row][col] = 1; 
											
											grid[i][j].setBackground(color);
											oldColor = grid[i][j].getBackground(); 
											
											grid[i][j].setText("" + blockOnBoard[row][col]);
											grid[i][j].setEnabled(false);
										}
										else if(piece[i-row][j-col]!=1 && blockOnBoard[row][col]!=1){
											{
												grid[i][j].setBackground(Color.white);
												blockOnBoard[row][col] = 0; 
												grid[i][j].setText("" + blockOnBoard[row][col]);
												
											}
											
										}
										
										
										
										
										}
									
									
										
										
									}
									
								}}
					    	}System.out.print("NEXT PLAYER"); 
					    	
					    	//next player and remove piece 
					    }}
				 	  public void mouseEntered(MouseEvent evt) {
				 		 
				 			 
					    	if(evt.getSource() == grid[row][col])
					    	{
					    		if(row+5 <=30 && col+5<=30) {
					    		for(int i=row; i<row+5; i++)
								{
									
									for (int j=col; j<col+5; j++)
									{
											
										
											
											
										if(piece[i-row][j-col] == 1)
										{
											
											if(blockOnBoard[i][j] == 0 && (i<30 && j<30))
											{
											if(grid[i][j].getBackground()==Color.white) {
											grid[i][j].setBackground(Color.gray);
											
											}
											
										}
											
										
										
										}
										else {
											if(grid[i][j].getBackground()==Color.gray) {
												grid[i][j].setBackground(Color.white);
												
												}
										}
										
										
									}
								}}
					    	
					    }}
				 	  
					  public void mouseExited(MouseEvent evt) {
					 		 
				 			 
					    	if(evt.getSource() == grid[row][col])
					    	{
					    		if(row+5 <=30 && col+5<=30) {
					    		for(int i=row; i<row+5; i++)
								{
									
									for (int j=col; j<col+5; j++)
									{
										if(piece[i-row][j-col] == 1 && (i<30&& j<30))
										{
											
											 if(grid[i][j].getBackground()==Color.gray) {
											grid[i][j].setBackground(Color.white);
											}
											
										}
										
									
									
										
										
										
									}
								}}
					    	
					    }}
			
				});

				}
					
					   
					   
					
				}}
		  
		 
	}
	

