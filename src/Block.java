import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.omg.CORBA.PRIVATE_MEMBER;

public class Block {
	

	
public void update() {} 

private int[][] valueOfBlock; 
public Integer[][] block1; 
private Integer[][] block2; 
private Integer[][] block3; 
private Integer[][] block4; 
public Integer[][] currentBlock; 

private Board theBoard = new Board(); 
//private int currentCounter=1; 
public int counter; 
private BlockData  getBlockData= new BlockData(); 



	
    
	public Integer[][] getPiece(Integer[][] blockID, int counterID, JPanel blockHolderP1, Color color)
	{ 
		

	    	
		blockHolderP1.removeAll(); 
		blockHolderP1.revalidate(); 
		blockHolderP1.repaint();
		blockID = getBlockData.Piece(counterID);
					
		getBlockData.paintBlocksButtons(blockID, color,
										blockHolderP1); 
					
		   
		  return blockID;
		   
	}
	
	public Integer[][] getRotatedPiece(Integer[][] blockID, JPanel blockHolderP1, Color color)
	{
		
		
		blockID = rotate(blockID);
		
		blockHolderP1.removeAll(); 
		blockHolderP1.revalidate(); 
		blockHolderP1.repaint(); 
		getBlockData.paintBlocksButtons(
				blockID,color,
				blockHolderP1);
		

		return blockID; 
	}
	public Integer[][] getFlippedPiece(Integer[][] blockID, JPanel blockHolderP1, Color color)
	{
		blockHolderP1.removeAll(); 
		blockHolderP1.revalidate(); 
		blockHolderP1.repaint(); 
		
		blockID = flipHorizontal(blockID);
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.print(blockID[i][j] + " ");
			}
			System.out.print("/n");
		}
				
			
		getBlockData.paintBlocksButtons(
				blockID,color,
				blockHolderP1);
		

		return blockID; 
	}
	
	public Integer[][] getFVPiece(Integer[][] blockID, JPanel blockHolderP1, Color color)
	{
		blockHolderP1.removeAll(); 
		blockHolderP1.revalidate(); 
		blockHolderP1.repaint(); 
		
		blockID = flipVertical(blockID);
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.print(blockID[i][j] + " ");
			}
			System.out.print("/n");
		}
				
			
		getBlockData.paintBlocksButtons(
				blockID,color,
				blockHolderP1);
		

		return blockID; 
	}
	
	public Integer[][] flipHorizontal(Integer[][] matrix) {
		
		    Integer[][] flippedMatrix = new Integer[5][5];
		    for(int i = 0; i < matrix.length; i++) {
		        for(int j = matrix[i].length-1; j >= 0; j--) {
		            flippedMatrix[i][j] = matrix[i][matrix[i].length-1-j];
		        }
		    }
		    return flippedMatrix;
		}
		
	public Integer[][] flipVertical(Integer[][] matrix) { 
		Integer[][] flippedMatrix = new Integer[5][5];
		matrix = rotate(matrix); 
		matrix = rotate(matrix);
		for(int i = 0; i < matrix.length; i++) {
	        for(int j = matrix[i].length-1; j >= 0; j--) {
	            flippedMatrix[i][j] = matrix[i][matrix[i].length-1-j];
	        }
	    }
		return flippedMatrix;
		
	}
	public Integer[][] rotate(Integer[][] matrix) { 
		
		
		int totalRowsOfRotatedMatrix = matrix[0].length; 
		int totalColsOfRotatedMatrix = matrix.length; 
		
		Integer[][] rotatedMatrix = new Integer[totalRowsOfRotatedMatrix][totalColsOfRotatedMatrix];
		for(int i=0; i<matrix.length; i++)
		{
			for(int j=0; j<matrix[0].length; j++)
			{
				 rotatedMatrix[(totalRowsOfRotatedMatrix-1)-j][i] = matrix[i][j]; 
		
			}
		}
		return rotatedMatrix;
	}
	

	public JButton[][] remainingBlocks(JButton[][] rPButtons, int PLAYER_NUM, Integer blockID, boolean isUsed) {

		if(PLAYER_NUM==1) {
			if(blockID == 1 ) {
				rPButtons = theBoard.remainingPiece(0,0,rPButtons, getBlockData.Piece(1), Color.blue, isUsed );} 
			if(blockID == 2 ) {
				rPButtons = theBoard.remainingPiece(0,5,rPButtons, getBlockData.Piece(2), Color.blue, isUsed );}
			
			if(blockID==3) {
				rPButtons = theBoard.remainingPiece(0, 10, rPButtons, getBlockData.Piece(3),Color.blue, isUsed);}
			
			if(blockID==4) {
				rPButtons = theBoard.remainingPiece(0, 15, rPButtons, getBlockData.Piece(4),Color.blue, isUsed);}
			
			if(blockID==5) {
				rPButtons = theBoard.remainingPiece(0, 20, rPButtons, getBlockData.Piece(5),Color.blue, isUsed);}
			
			if(blockID==6) {
				rPButtons = theBoard.remainingPiece(0, 25, rPButtons, getBlockData.Piece(6),Color.blue, isUsed);}
			
			if(blockID==7) {
				rPButtons = theBoard.remainingPiece(5, 0, rPButtons, getBlockData.Piece(7),Color.blue, isUsed);}
			
			if(blockID==8) {
				rPButtons = theBoard.remainingPiece(5, 5, rPButtons, getBlockData.Piece(8),Color.blue, isUsed);}
			
			if(blockID==9) {
				rPButtons = theBoard.remainingPiece(5, 10, rPButtons, getBlockData.Piece(9),Color.blue, isUsed);}
			
			if(blockID==10) {
				rPButtons = theBoard.remainingPiece(5, 15, rPButtons, getBlockData.Piece(10),Color.blue, isUsed);}
			
			if(blockID==11) {
				rPButtons = theBoard.remainingPiece(5, 20, rPButtons, getBlockData.Piece(11),Color.blue, isUsed);}
			
			if(blockID==12) {
				rPButtons = theBoard.remainingPiece(5, 25, rPButtons, getBlockData.Piece(12),Color.blue, isUsed);}
			
			if(blockID==13) {
				rPButtons = theBoard.remainingPiece(10, 0, rPButtons, getBlockData.Piece(13),Color.blue, isUsed);}
			
			if(blockID==14) {
				rPButtons = theBoard.remainingPiece(10, 5, rPButtons, getBlockData.Piece(14),Color.blue, isUsed);}
			
			if(blockID==15) {
				rPButtons = theBoard.remainingPiece(10, 10, rPButtons, getBlockData.Piece(15),Color.blue, isUsed);}
			
			if(blockID==16) {
				rPButtons = theBoard.remainingPiece(10, 15, rPButtons, getBlockData.Piece(16),Color.blue, isUsed);}
			
			if(blockID==17) {
				rPButtons = theBoard.remainingPiece(10, 20, rPButtons, getBlockData.Piece(17),Color.blue, isUsed);}
			
			if(blockID==18) {
				rPButtons = theBoard.remainingPiece(10, 25, rPButtons, getBlockData.Piece(18),Color.blue, isUsed);}
			
			if(blockID==19) {
				rPButtons = theBoard.remainingPiece(15, 0, rPButtons, getBlockData.Piece(19),Color.blue, isUsed);}
			
			if(blockID==20) {
				rPButtons = theBoard.remainingPiece(15, 5, rPButtons, getBlockData.Piece(20),Color.blue, isUsed);}
			
			if(blockID==21) {
				rPButtons = theBoard.remainingPiece(15, 10, rPButtons, getBlockData.Piece(21),Color.blue, isUsed);}
			
		} 
		if(PLAYER_NUM==2) {
			if(blockID == 1 ) {
				rPButtons = theBoard.remainingPiece(0,0,rPButtons, getBlockData.Piece(1), Color.red, isUsed );} 
			if(blockID == 2 ) {
				rPButtons = theBoard.remainingPiece(0,5,rPButtons, getBlockData.Piece(2), Color.red, isUsed );}
			
			if(blockID==3) {
				rPButtons = theBoard.remainingPiece(0, 10, rPButtons, getBlockData.Piece(3),Color.red, isUsed);}
			
			if(blockID==4) {
				rPButtons = theBoard.remainingPiece(0, 15, rPButtons, getBlockData.Piece(4),Color.red, isUsed);}
			
			if(blockID==5) {
				rPButtons = theBoard.remainingPiece(0, 20, rPButtons, getBlockData.Piece(5),Color.red, isUsed);}
			
			if(blockID==6) {
				rPButtons = theBoard.remainingPiece(0, 25, rPButtons, getBlockData.Piece(6),Color.red, isUsed);}
			
			if(blockID==7) {
				rPButtons = theBoard.remainingPiece(5, 0, rPButtons, getBlockData.Piece(7),Color.red, isUsed);}
			
			if(blockID==8) {
				rPButtons = theBoard.remainingPiece(5, 5, rPButtons, getBlockData.Piece(8),Color.red, isUsed);}
			
			if(blockID==9) {
				rPButtons = theBoard.remainingPiece(5, 10, rPButtons, getBlockData.Piece(9),Color.red, isUsed);}
			
			if(blockID==10) {
				rPButtons = theBoard.remainingPiece(5, 15, rPButtons, getBlockData.Piece(10),Color.red, isUsed);}
			
			if(blockID==11) {
				rPButtons = theBoard.remainingPiece(5, 20, rPButtons, getBlockData.Piece(11),Color.red, isUsed);}
			
			if(blockID==12) {
				rPButtons = theBoard.remainingPiece(5, 25, rPButtons, getBlockData.Piece(12),Color.red, isUsed);}
			
			if(blockID==13) {
				rPButtons = theBoard.remainingPiece(10, 0, rPButtons, getBlockData.Piece(13),Color.red, isUsed);}
			
			if(blockID==14) {
				rPButtons = theBoard.remainingPiece(10, 5, rPButtons, getBlockData.Piece(14),Color.red, isUsed);}
			
			if(blockID==15) {
				rPButtons = theBoard.remainingPiece(10, 15, rPButtons, getBlockData.Piece(15),Color.red, isUsed);}
			
			if(blockID==16) {
				rPButtons = theBoard.remainingPiece(10, 20, rPButtons, getBlockData.Piece(16),Color.red, isUsed);}
			
			if(blockID==17) {
				rPButtons = theBoard.remainingPiece(10, 25, rPButtons, getBlockData.Piece(17),Color.red, isUsed);}
			
			if(blockID==18) {
				rPButtons = theBoard.remainingPiece(15, 0, rPButtons, getBlockData.Piece(18),Color.red, isUsed);}
			
			if(blockID==19) {
				rPButtons = theBoard.remainingPiece(15, 5, rPButtons, getBlockData.Piece(19),Color.red, isUsed);}
			
			if(blockID==20) {
				rPButtons = theBoard.remainingPiece(15, 10, rPButtons, getBlockData.Piece(20),Color.red, isUsed);}
			
			if(blockID==21) {
				rPButtons = theBoard.remainingPiece(15, 15, rPButtons, getBlockData.Piece(21),Color.red, isUsed);}
		}
		if(PLAYER_NUM==3) {
			if(blockID == 1 ) {
				rPButtons = theBoard.remainingPiece(0,0,rPButtons, getBlockData.Piece(1), Color.yellow, isUsed );} 
			if(blockID == 2 ) {
				rPButtons = theBoard.remainingPiece(0,5,rPButtons, getBlockData.Piece(2), Color.yellow, isUsed );}
			
			if(blockID==3) {
				rPButtons = theBoard.remainingPiece(0, 10, rPButtons, getBlockData.Piece(3),Color.yellow, isUsed);}
			
			if(blockID==4) {
				rPButtons = theBoard.remainingPiece(0, 15, rPButtons, getBlockData.Piece(4),Color.yellow, isUsed);}
			
			if(blockID==5) {
				rPButtons = theBoard.remainingPiece(0, 20, rPButtons, getBlockData.Piece(5),Color.yellow, isUsed);}
			
			if(blockID==6) {
				rPButtons = theBoard.remainingPiece(0, 25, rPButtons, getBlockData.Piece(6),Color.yellow, isUsed);}
			
			if(blockID==7) {
				rPButtons = theBoard.remainingPiece(5, 0, rPButtons, getBlockData.Piece(7),Color.yellow, isUsed);}
			
			if(blockID==8) {
				rPButtons = theBoard.remainingPiece(5, 5, rPButtons, getBlockData.Piece(8),Color.yellow, isUsed);}
			
			if(blockID==9) {
				rPButtons = theBoard.remainingPiece(5, 10, rPButtons, getBlockData.Piece(9),Color.yellow, isUsed);}
			
			if(blockID==10) {
				rPButtons = theBoard.remainingPiece(5, 15, rPButtons, getBlockData.Piece(10),Color.yellow, isUsed);}
			
			if(blockID==11) {
				rPButtons = theBoard.remainingPiece(5, 20, rPButtons, getBlockData.Piece(11),Color.yellow, isUsed);}
			
			if(blockID==12) {
				rPButtons = theBoard.remainingPiece(5, 25, rPButtons, getBlockData.Piece(12),Color.yellow, isUsed);}
			
			if(blockID==13) {
				rPButtons = theBoard.remainingPiece(10, 0, rPButtons, getBlockData.Piece(13),Color.yellow, isUsed);}
			
			if(blockID==14) {
				rPButtons = theBoard.remainingPiece(10, 5, rPButtons, getBlockData.Piece(14),Color.yellow, isUsed);}
			
			if(blockID==15) {
				rPButtons = theBoard.remainingPiece(10, 15, rPButtons, getBlockData.Piece(15),Color.yellow, isUsed);}
			
			if(blockID==16) {
				rPButtons = theBoard.remainingPiece(10, 20, rPButtons, getBlockData.Piece(16),Color.yellow, isUsed);}
			
			if(blockID==17) {
				rPButtons = theBoard.remainingPiece(10, 25, rPButtons, getBlockData.Piece(17),Color.yellow, isUsed);}
			
			if(blockID==18) {
				rPButtons = theBoard.remainingPiece(15, 0, rPButtons, getBlockData.Piece(18),Color.yellow, isUsed);}
			
			if(blockID==19) {
				rPButtons = theBoard.remainingPiece(15, 5, rPButtons, getBlockData.Piece(19),Color.yellow, isUsed);}
			
			if(blockID==20) {
				rPButtons = theBoard.remainingPiece(15, 10, rPButtons, getBlockData.Piece(20),Color.yellow, isUsed);}
			
			if(blockID==21) {
				rPButtons = theBoard.remainingPiece(15, 15, rPButtons, getBlockData.Piece(21),Color.yellow, isUsed);}
		}
		if(PLAYER_NUM==4) {
			if(blockID == 1 ) {
				rPButtons = theBoard.remainingPiece(0,0,rPButtons, getBlockData.Piece(1), Color.green, isUsed );} 
			if(blockID == 2 ) {
				rPButtons = theBoard.remainingPiece(0,5,rPButtons, getBlockData.Piece(2), Color.green, isUsed );}
			
			if(blockID==3) {
				rPButtons = theBoard.remainingPiece(0, 10, rPButtons, getBlockData.Piece(3),Color.green, isUsed);}
			
			if(blockID==4) {
				rPButtons = theBoard.remainingPiece(0, 15, rPButtons, getBlockData.Piece(4),Color.green, isUsed);}
			
			if(blockID==5) {
				rPButtons = theBoard.remainingPiece(0, 20, rPButtons, getBlockData.Piece(5),Color.green, isUsed);}
			
			if(blockID==6) {
				rPButtons = theBoard.remainingPiece(0, 25, rPButtons, getBlockData.Piece(6),Color.green, isUsed);}
			
			if(blockID==7) {
				rPButtons = theBoard.remainingPiece(5, 0, rPButtons, getBlockData.Piece(7),Color.green, isUsed);}
			
			if(blockID==8) {
				rPButtons = theBoard.remainingPiece(5, 5, rPButtons, getBlockData.Piece(8),Color.green, isUsed);}
			
			if(blockID==9) {
				rPButtons = theBoard.remainingPiece(5, 10, rPButtons, getBlockData.Piece(9),Color.green, isUsed);}
			
			if(blockID==10) {
				rPButtons = theBoard.remainingPiece(5, 15, rPButtons, getBlockData.Piece(10),Color.green, isUsed);}
			
			if(blockID==11) {
				rPButtons = theBoard.remainingPiece(5, 20, rPButtons, getBlockData.Piece(11),Color.green, isUsed);}
			
			if(blockID==12) {
				rPButtons = theBoard.remainingPiece(5, 25, rPButtons, getBlockData.Piece(12),Color.green, isUsed);}
			
			if(blockID==13) {
				rPButtons = theBoard.remainingPiece(10, 0, rPButtons, getBlockData.Piece(13),Color.green, isUsed);}
			
			if(blockID==14) {
				rPButtons = theBoard.remainingPiece(10, 5, rPButtons, getBlockData.Piece(14),Color.green, isUsed);}
			
			if(blockID==15) {
				rPButtons = theBoard.remainingPiece(10, 15, rPButtons, getBlockData.Piece(15),Color.green, isUsed);}
			
			if(blockID==16) {
				rPButtons = theBoard.remainingPiece(10, 20, rPButtons, getBlockData.Piece(16),Color.green, isUsed);}
			
			if(blockID==17) {
				rPButtons = theBoard.remainingPiece(10, 25, rPButtons, getBlockData.Piece(17),Color.green, isUsed);}
			
			if(blockID==18) {
				rPButtons = theBoard.remainingPiece(15, 0, rPButtons, getBlockData.Piece(18),Color.green, isUsed);}
			
			if(blockID==19) {
				rPButtons = theBoard.remainingPiece(15, 5, rPButtons, getBlockData.Piece(19),Color.green, isUsed);}
			
			if(blockID==20) {
				rPButtons = theBoard.remainingPiece(15, 10, rPButtons, getBlockData.Piece(20),Color.green, isUsed);}
			
			if(blockID==21) {
				rPButtons = theBoard.remainingPiece(15, 15, rPButtons, getBlockData.Piece(21),Color.green, isUsed);}
		}
		
		return rPButtons;
	}


	public void place() {
		
	}
	public void checkPlacement() { 
		
	}
}
