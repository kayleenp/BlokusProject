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
//private int currentCounter=1; 
public int counter; 
private BlockData  getBlockData= new BlockData(); 



	public void render(Graphics g) {}
    
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
		blockHolderP1.removeAll(); 
		blockHolderP1.revalidate(); 
		blockHolderP1.repaint(); 
		
		blockID = rotate(blockID);
		

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
	
	public void rotateButtonController(JPanel panel, JButton rotateButton, Integer[][] block1) {
		rotateButton.addActionListener(new ActionListener() { 	
			@Override
			public void actionPerformed(ActionEvent e ) {
				panel.removeAll();
				panel.revalidate();
				panel.repaint();
				
				
				getBlockData.paintBlocksButtons(
						rotate(block1), Color.blue,
						panel);
				
			
			}
});
	}
	

	public void place() {
		
	}
	public void checkPlacement() { 
		
	}
}
