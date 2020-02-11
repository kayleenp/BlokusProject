import java.awt.Color;
import java.awt.Frame;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Board {

	public int[][] board;
	
	public int showNewPoints(Player blokusPlayer) {
		return 0;  
	}
	
	public JButton[][] boardGrid(JPanel panel)
	{
		//GRID 
		
				JButton[][] grid= new JButton[20][20];
				Integer[][] gridValue = new Integer[20][20]; 
				for (int i =0; i<(20); i++){
					for(int j =0; j<20; j++) {
						gridValue[i][j] = 0; 
						grid[i][j] = new JButton(); 
						// final JButton square = new JButton();
						 grid[i][j].setBackground(Color.white);
						 
						    grid[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
						    panel.add(grid[i][j]);
					}
				   
				}
				
				
				
				return grid; 
				
	}
	
	public void gridValue(JButton[][] grid, int x, int y, Integer[][] block)
	{
		Integer[][] gridValue = new Integer[20][20]; 
		for(int i=x; i<x+5; i++)
		{
			
			for (int j=y; j<y+5; j++)
			{
				gridValue[i][j] = 0; 
				gridValue[i][j] = block[i-x][j-y]; 
				
				if(gridValue[i][j]==1)
				{
					grid[i][j].setBackground(Color.BLUE);
				}	
			}
		}
	}
}
