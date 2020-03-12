import java.awt.Color;
import java.awt.Event;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicArrowButton;
public class Board {

	public int initialScore=0;


	public int showNewPoints(Player blokusPlayer) {
		return 0;  
	}
	
	public JButton[][] boardGrid(JPanel panel, Integer[][] blockOnBoard)
	{
		JButton[][] grid= new JButton[30][30];
		Integer[][] gridValue = new Integer[30][30]; 
				
				for (int i =0; i<30; i++){
					for(int j =0; j<30; j++) {
						
						grid[i][j] = new JButton(); 
						
						//grid[i][j].setText("" + gridValue[i][j]);
						// final JButton square = new JButton();
						 if(i<=3 || j<=3 || i>=26 || j>=26) {
							
							 grid[i][j].setBackground(Color.white);
							 grid[i][j].setBorder(BorderFactory.createLineBorder(Color.white));
							 gridValue[i][j] = 0;
							grid[i][j].setEnabled(false);
						 }
						 
						 else if(i==4 && j==4) {
							 grid[i][j].setBackground(Color.blue);
							 grid[i][j].setBorder(BorderFactory.createLineBorder(Color.white));
								blockOnBoard[i][j] = 1; 
								gridValue[i][j] = 1; 
						     grid[i][j].setOpaque(true);
						 }
						 else if(i==4 && j==25) {
							 grid[i][j].setBackground(Color.yellow);
							 grid[i][j].setBorder(BorderFactory.createLineBorder(Color.white));
							 grid[i][j].setContentAreaFilled(false);
								blockOnBoard[i][j] = 3; 
								gridValue[i][j] = 3; 
						     grid[i][j].setOpaque(true);
						 }
						 else if(i==25 && j==4) {
							 grid[i][j].setBackground(Color.red);
							 grid[i][j].setBorder(BorderFactory.createLineBorder(Color.white));
							 grid[i][j].setContentAreaFilled(false);
								blockOnBoard[i][j] = 2; 
								gridValue[i][j] = 2; 
						     grid[i][j].setOpaque(true);
						 }
						 else if(i==25 && j==25) {
							 grid[i][j].setBackground(Color.green);
							 grid[i][j].setBorder(BorderFactory.createLineBorder(Color.white));
							 grid[i][j].setContentAreaFilled(false);
								blockOnBoard[i][j] = 4; 
								gridValue[i][j] = 4; 
						     grid[i][j].setOpaque(true);
						 }
					     
						 else {
						 grid[i][j].setBackground(Color.white);
						 grid[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
						 //grid[i][j].setContentAreaFilled(false);
							blockOnBoard[i][j] = 0; 
							gridValue[i][j] = 0; 
					     grid[i][j].setOpaque(true);
						 }
						
						panel.add(grid[i][j]);
					}
					
				}
				
				return grid; 
				
	}
	
	public void gridClicked(MouseEvent evt, JButton[][] grid,  Integer[][] boardValueInteger, 
			Integer[][] pieceIntegers , Color color, int row, int col, int playerValue, 
			boolean checkPiece[], int currentPiece, BasicArrowButton nextButton, int remainingPieceCounter, JButton nextPlayerButton, 
			JButton remainingPieceButton[][], JLabel scoreLabel, int scoreInt)
	{
	
	
	
		 Block remainingBlockData = new Block();
			int singleCounter =0; 
			boolean adaPiece = false; 
			
			int checkCounter = 25;
			 int sudut=0;
			 
		 			 //INI DIBUAT FUNGSI YOW
			    	if(evt.getSource() == grid[row][col])
			    	{
			    		if(row<=26 && col<=26 && col>=3 && row>=3 ) {
			    			
			    		for(int i=0; i<5; i++)
						{
							for (int j=0; j<5; j++)
							{
						
								if(pieceIntegers[i][j]==1)
								{	// check kesalahan
									if(boardValueInteger[row+i-1][col+j-2]==playerValue)
									{
										checkCounter= checkCounter-1;
									} 
									if(boardValueInteger[row+i-2][col+j-1]==playerValue)
									{
										checkCounter= checkCounter-1;
									}
									if(boardValueInteger[row+i-2][col+j-3]==playerValue)
									{
										checkCounter= checkCounter-1;
									}
									if(boardValueInteger[row+i-3][col+j-2]==playerValue)
									{
										checkCounter= checkCounter-1;
									}
									//check tempat awal mulai
									if(boardValueInteger[row+i-1][col+j-1]==playerValue) {
										sudut=sudut+1;
									}
									if(boardValueInteger[row+i-3][col+j-1]==playerValue) {
										sudut=sudut+1;
									}
									if(boardValueInteger[row+i-1][col+j-3]==playerValue) {
										sudut=sudut+1;
									}
									if(boardValueInteger[row+i-3][col+j-3]==playerValue) {
										sudut=sudut+1;
									}
								}
								
								} 
								}
						
								}
									
								}
			    	// check kalo udah perfect/ gaada kesalahan
					if(checkCounter==25 && sudut>0) {
						// check kalo memenuhi syarat awal mulai
			    		for(int i=0; i<5; i++)
						{
							for (int j=0; j<5; j++)
							{		
										if(pieceIntegers[i][j]==1) {
											boardValueInteger[row+i-2][col+j-2] = playerValue;
											grid[row+i-2][col+j-2].setText("" + boardValueInteger[row+i-2][col+j-2]);
											grid[row+i-2][col+j-2].setBackground(color);
											
											
											
	singleCounter++; 
											if(singleCounter==1) {
											nextButton.doClick(1);
											
											remainingPieceButton =  remainingBlockData.remainingBlocks(remainingPieceButton, playerValue, currentPiece, false);
											checkPiece[currentPiece]=true;
											nextPlayerButton.doClick(1);
											}//untuk yg 5/4 block ujungnya gaada tulisan	
											if(playerValue==1) {
											if(boardValueInteger[row+i-1][col+j-1]==0) {
												grid[row+i-1][col+j-1].setBackground(Color.cyan);
											}
											if(boardValueInteger[row+i-3][col+j-1]==0) {
												grid[row+i-3][col+j-1].setBackground(Color.cyan);
											}
											if(boardValueInteger[row+i-1][col+j-3]==0) {
												grid[row+i-1][col+j-3].setBackground(Color.cyan);
											}
											if(boardValueInteger[row+i-3][col+j-3]==0) {
												grid[row+i-3][col+j-3].setBackground(Color.cyan);
											} }
											else if(playerValue==2) {
												if(boardValueInteger[row+i-1][col+j-1]==0) {
													grid[row+i-1][col+j-1].setBackground(Color.pink);
												}
												if(boardValueInteger[row+i-3][col+j-1]==0) {
													grid[row+i-3][col+j-1].setBackground(Color.pink);
												}
												if(boardValueInteger[row+i-1][col+j-3]==0) {
													grid[row+i-1][col+j-3].setBackground(Color.pink);
												}
												if(boardValueInteger[row+i-3][col+j-3]==0) {
													grid[row+i-3][col+j-3].setBackground(Color.pink);
												}
											}
											
											// untuk ujungnya yg gaada yg gaboleh
											if(boardValueInteger[row+i-3][col+j-2]==0) {
												boardValueInteger[row+i-3][col+j-2]=-playerValue;
											}
											if(boardValueInteger[row+i-2][col+j-3]==0) {
												boardValueInteger[row+i-2][col+j-3]=-playerValue;
											}
											if(boardValueInteger[row+i-2][col+j-1]==0) {
												boardValueInteger[row+i-2][col+j-1]=-playerValue;
											}
											if(boardValueInteger[row+i-1][col+j-2]==0) {
												boardValueInteger[row+i-1][col+j-2]=-playerValue;
											}
										}
										if(pieceIntegers[i][j]==-1) {
									          if(playerValue==1) {
									          if(boardValueInteger[row+i-2][col+j-2]==0) {
									           grid[row+i-2][col+j-2].setBackground(Color.cyan);
									           }
									          if(boardValueInteger[row+i-2][col+j-2]==-playerValue) {
									           grid[row+i-2][col+j-2].setBackground(Color.white);
									          }
									          }
									          else if(playerValue==2) {
									           if(boardValueInteger[row+i-2][col+j-2]==0) {
									            grid[row+i-2][col+j-2].setBackground(Color.pink);
									            }
									           if(boardValueInteger[row+i-2][col+j-2]==-playerValue) {
									            grid[row+i-2][col+j-2].setBackground(Color.white);
									           } 
									          }
									         }
									          
									         if(pieceIntegers[i][j]==-1) {
									          boardValueInteger[row+i-2][col+j-2]= -playerValue;
									          grid[row+i-2][col+j-2].setBackground(Color.white);
									         }
									
										
										}
									}
						}
	
			   }
	
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
	
	
	public JButton[][] remainingPieceGrid (int baris, int kolom, JPanel remainingPiecePanel) { 
		JButton remainingPieceButton[][] = new JButton[25][30]; 

		int counter = 0; 
		for(int i=0; i<25; i++) {
			for(int j=0; j<30; j++) {
				
				remainingPieceButton[i][j] = new JButton();
			   
				remainingPieceButton[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
				remainingPieceButton[i][j].setBackground(Color.white);
					
				remainingPiecePanel.add(remainingPieceButton[i][j]);
			}	
			
		}

		return remainingPieceButton; 
	} 
	
		public  JButton[][] remainingPiece (int baris, int kolom, JButton[][] rpGrid, Integer[][] piece, Color color, boolean isUsed) { 
			
			//int counter = 0; 
			
			for(int i=0; i<25; i++) {
				for(int j=0; j<30; j++) {
		
						
					for(int k=0; k<5; k++) {
						for(int l=0; l<5; l++) {

							if(piece[k][l]>=1) {	
								
								if(isUsed == true) {
								rpGrid[baris+k][kolom+l].setBackground(color);}
								else { 
									piece[k][l]=0;
								}
								
							}
							else { 
								rpGrid[baris+k][kolom+l].setBackground(Color.WHITE);}
							}
						}
							
								
						
						}
				
			}
			
				
			 return rpGrid;
			 
		 
			
			 
		}
		
		
		
		
}	
	
	

