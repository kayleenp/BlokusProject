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
		
		//GRID 
		
				
				
		JButton[][] grid= new JButton[30][30];
		Integer[][] gridValue = new Integer[30][30]; 
				
				for (int i =0; i<(30); i++){
					for(int j =0; j<30; j++) {
						
						gridValue[i][j] = 0; 
						blockOnBoard[i][j] = 0; 
						
						grid[i][j] = new JButton(); 
						
						
						//grid[i][j].setText("" + gridValue[i][j]);
						// final JButton square = new JButton();
						 if(i<=5 || j<=5 || i>=25 || j>=25) {
							 grid[i][j].setBackground(Color.white);
							 grid[i][j].setBorder(BorderFactory.createLineBorder(Color.white));
							
						 }
					     
						 else {
						 grid[i][j].setBackground(Color.white);
						 grid[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
						 grid[i][j].setContentAreaFilled(false);
					     grid[i][j].setOpaque(true);
						 }
						
						panel.add(grid[i][j]);
					}
					
				}
				
				return grid; 
				
	}
	
	public void gridClicked(JPanel panel, JButton[][] grid,  Integer[][] blockOnBoard, Integer[][] piece, Color color)
	{
		
		
			Boolean[][] flagBoolean = new Boolean[30][30];
		 
		}
	
		  
		 
	}
	

