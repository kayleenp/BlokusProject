import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Block {
	

	
public void update() {} 

private int[][] valueOfBlock; 
private Integer[][] block1; 
private Integer[][] block2; 
private Integer[][] block3; 
private Integer[][] block4; 
private Integer[][] currentBlock; 
private int counter = 1 ;
public int currentCounter ;
public BlockData getBlockData = new BlockData(); 



	public void render(Graphics g) {}
    
	public Integer[][] addBlockTools(Integer[][] blockID, int counterID,  JButton rotateLP1, JButton flipBlock, JButton nextP1, JButton prevP1, JPanel blockHolderP1, Color color)
	{ 
		block1 = getBlockData.Piece(counter); 
		currentBlock = block1; 
		currentCounter = counter++; 
		//BLOCK HOLDER FOR PLAYER 1
		getBlockData.paintBlocksButtons(
				block1, color,
				blockHolderP1);
		
			
		/*rotateLP1.addActionListener(new ActionListener() { 	
			
			@Override
			public void actionPerformed(ActionEvent e ) {
				
				blockHolderP1.removeAll(); 
				blockHolderP1.revalidate(); 
				blockHolderP1.repaint(); 
				
				block1 = rotate(block1); 
				
				getBlockData.paintBlocksButtons(
						block1, color,
						blockHolderP1);
				currentBlock = block1;
			}
			
		});
		flipBlock.addActionListener(new ActionListener() { 	
			@Override
			public void actionPerformed(ActionEvent e ) {
				
				blockHolderP1.removeAll(); 
				blockHolderP1.revalidate(); 
				blockHolderP1.repaint(); 
				
				block1 = flipHorizontal(block1); 
				currentBlock = block1;
				getBlockData.paintBlocksButtons(
						block1, color,
						blockHolderP1);
				
			}
			
		});*/
		nextP1.addActionListener(new ActionListener() {
			@Override 
			public void actionPerformed(ActionEvent e) {
				blockHolderP1.removeAll(); 
				blockHolderP1.revalidate(); 
				blockHolderP1.repaint(); 
				block1 = getBlockData.Piece(counter); 
				currentBlock = block1;
				getBlockData.paintBlocksButtons(
						block1, color,
						blockHolderP1);
				
				
				counter++;
				currentCounter = counter++; 
				if(counter>21) {
					counter=1;
				}
				
			}});
		   prevP1.addActionListener(new ActionListener() {
			@Override 
			public void actionPerformed(ActionEvent e) {
				blockHolderP1.removeAll(); 
				blockHolderP1.revalidate(); 
				blockHolderP1.repaint(); 
				block1 = getBlockData.Piece(counter);
				currentBlock = block1; 
				getBlockData.paintBlocksButtons(
						block1, Color.blue,
						blockHolderP1);
				 
				
				counter--;
				currentCounter = counter--; 
				if(counter<1) {
					counter=21;
				}}});
		   
		   return getBlockData.Piece(currentCounter);
		   
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
