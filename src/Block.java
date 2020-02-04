import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Block {
public void update() {} 

private int[][] valueOfBlock; 





	
	public void render(Graphics g) {}

	public void mirror() {
		
	}
	public Integer[][] rotate(Integer[][] matrix) { 
		int size = matrix.length; 
		
		for(int i=0; i<size; i++)
		{
			for(int j=0; j<size; j++)
			{
				matrix[i][j]= matrix[size-j-1][i]; 
		
			}
		}
		return matrix; 
	}
	public void place() {
		
	}
	public void checkPlacement() { 
		
	}
}
