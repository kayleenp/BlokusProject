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


	
	public int showNewPoints(Player blokusPlayer) {
		return 0;  
	}
	
	public JButton[][] boardGrid(JPanel panel, Integer[][] blockOnBoard)
	{
		JButton[][] grid= new JButton[30][30];
		Integer[][] gridValue = new Integer[30][30]; 
				
				for (int i =0; i<(30); i++){
					for(int j =0; j<30; j++) {
						
					
						
						grid[i][j] = new JButton(); 
						
						
						//grid[i][j].setText("" + gridValue[i][j]);
						// final JButton square = new JButton();
						 if(i<=5 || j<=5 || i>=25 || j>=25) {
							 grid[i][j].setBackground(Color.white);
							 grid[i][j].setBorder(BorderFactory.createLineBorder(Color.white));
							grid[i][j].setEnabled(false);
							
							
						 }
					     
						 else {
						 grid[i][j].setBackground(Color.white);
						 grid[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
						 grid[i][j].setContentAreaFilled(false);
							blockOnBoard[i][j] = 0; 
							gridValue[i][j] = 0; 
					     grid[i][j].setOpaque(true);
						 }
						
						panel.add(grid[i][j]);
					}
					
				}
				
				return grid; 
				
	}
	
	public void gridClicked(MouseEvent evt, JButton[][] grid,  Integer[][] boardValueInteger, Integer[][] pieceIntegers , Color color, int row, int col, int playerValue)
	{
		

		   boolean adaPiece = false; 
		
		   if(evt.getClickCount()==1) {
 			   
 			   
	 			 //INI DIBUAT FUNGSI YOW
		    	if(evt.getSource() == grid[row][col])
		    	{
		    		if(row<=25 && col<=25 && col>=5 && row>=5 ) {
		    		
		    		for(int i=0; i<5; i++)
					{
						
						for (int j=0; j<5; j++)
						{
							
							if(pieceIntegers[i][j]>=1 || pieceIntegers[i][j]==-2)
							{
								if(boardValueInteger[row+i-2][col+j-2]!=0) {
									System.out.println("GABISA WOY");
									adaPiece = true; 
								}
								
								
							}
							
							
							}
								
							}
		    		for(int i=0; i<5; i++)
					{
						
						for (int j=0; j<5; j++)
						{
							if(adaPiece==false) {
								if(pieceIntegers[i][j]>=1) {
									boardValueInteger[row+i-2][col+j-2] = playerValue;
						
									grid[row+i-2][col+j-2].setText("" + boardValueInteger[row+i-2][col+j-2]);
								
									grid[i+row-2][j+col-2].setBackground(color);}
								if(pieceIntegers[i][j]==-2) {
									boardValueInteger[row+i-2][col+j-2] = -2;
						
									grid[row+i-2][col+j-2].setText("" + boardValueInteger[row+i-2][col+j-2]);
								
									}
								
							}
							
							else { 
								System.out.println("GABISA WOY");
							}
						}

					} } } } }
		    	
		 
		
	
	public void gridMouseEntered(MouseEvent evt, JButton[][] grid, Integer[][] boardValueIntegers, Integer[][] pieceIntegers, Color color, int row, int col)	  
	{
		if(evt.getSource() == grid[row][col])
    	{
    		if(row<=25 && col<=25 && col>=5 && row>=5) {
    		for(int i=row; i<row+5; i++)
			{
				
				for (int j=col; j<col+5; j++)	
				{
						
					if(pieceIntegers[i-row][j-col] == 1)
					{
						
						if(boardValueIntegers[i-2][j-2] == 0 ){
						{
						if(grid[i-2][j-2].getBackground()==Color.white) {
						grid[i-2][j-2].setBackground(Color.gray);
						
						}
						
					}
						
					
					
					}
					else {
						if(grid[i-2][j-2].getBackground()==Color.gray) {
							grid[i-2][j-2].setBackground(Color.white);
							
							}
					}
					}
					
				}
			}}
    	
    }
	}
	public void gridMouseExited(MouseEvent evt, JButton[][] grid, Integer[][] boardValueIntegers, Integer[][] pieceIntegers, Color color, int row, int col)	{
	   	if(evt.getSource() == grid[row][col])
    	{
	   		if(row<=25 && col<=25 && col>=5 && row>=5) {
    		for(int i=row; i<row+5; i++)
			{
				
				for (int j=col; j<col+5; j++)
				{
						 if(grid[i-2][j-2].getBackground()==Color.gray) {
						grid[i-2][j-2].setBackground(Color.white);
						}
		
				}
			}}
    	
    }
	}
	}
	

