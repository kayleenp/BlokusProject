import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.util.function.IntPredicate;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.omg.PortableServer.ForwardRequest;

public class BlockData {

	protected enum Tetrominoe { 
		NoShape, block1, block2, block3, 
		block4, block5, block6; 
	}
	
	public int ID; 
	public int[] shapes; 
	public int[][] coords; 
	public int[] edges;

	private Tetrominoe pieceBlock; 
	
	public Integer[][] block1() 
	{
		Integer[][] block = {{0,0,0,0,0}, 
         	{0,0,0,0,0}, 
         	{0,0,1,0,0}, 
         	{0,0,0,0,0}, 
         	{0,0,0,0,0}};
		
		return block;
	}
	
	public Integer[][] block2() 
	{
		Integer[][] block = (new Integer[][]{
			{0,0,0,0,0}, 
         	{2,3,3,2,0}, 
         	{3,1,1,3,0}, 
         	{2,3,3,2,0}, 
         	{0,0,0,0,0}});
		
		return block;
	}
	
	public Integer[][] block3() 
	{
		Integer[][] block = (new Integer[][]{
			{0,0,0,0,0}, 
         	{0,0,0,0,0}, 
         	{0,0,1,1,0}, 
         	{0,0,1,0,0}, 
         	{0,0,0,0,0}});
		
		return block;
	}
	
	public Integer[][] block4() 
	{
		Integer[][] block = (new Integer[][]{
			{0,0,0,0,0}, 
         	{0,0,0,0,0}, 
         	{0,1,1,1,0}, 
         	{0,0,0,0,0}, 
         	{0,0,0,0,0}});
		
		return block;
	}
	
	public Integer[][] block5() 
	{
		Integer[][] block = (new Integer[][]{
			{2,3,3,2,0}, 
         	{3,1,1,3,0}, 
         	{3,1,1,3,0}, 
         	{2,3,3,2,0}, 
         	{0,0,0,0,0}});
		
		return block;
	}
	
	public void paintBlocksButtons(Integer[][] blockValues, Color color, JPanel panel) {
		JButton[][] blocksPainted = new JButton[5][5]; 
		Integer[][] tempIntegers = new Integer[5][5]; 
		tempIntegers = blockValues;
		blocksPainted = new JButton[5][5]; 
		
			   for (int i =0; i<(5); i++){
			    for(int j =0; j<5; j++) {
			    	blocksPainted[i][j] = new JButton();
			    	blocksPainted[i][j].setVisible(false);
			    	
			    	
			    	blocksPainted[i][j].setBackground(Color.WHITE);
			       	if(tempIntegers[i][j]==1) {
			    	blocksPainted[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			        blocksPainted[i][j].setBackground(color);
			        blocksPainted[i][j].setVisible(true);
			        
			       	}
			       	else if(tempIntegers[i][j]==2)
			       	{
			       		blocksPainted[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				        blocksPainted[i][j].setBackground(Color.lightGray);
				        blocksPainted[i][j].setVisible(true);	
			       	}
			       	else if(tempIntegers[i][j]==3)
			       	{
			       		blocksPainted[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				        blocksPainted[i][j].setBackground(Color.gray);
				        blocksPainted[i][j].setVisible(true);	
			       	}
			       	panel.add(blocksPainted[i][j]);
			    	 }
			  
			    }
			panel.setLayout(new GridLayout(5,5));
			      
			   }	   
			   
	}
	/*public BlockData() {
		
		coords = new int[5][5]; 
		setBlock(Tetrominoe.NoShape); 
		
	}
	
	public void setBlock(Tetrominoe block) {
		int[][][] coordsTable = new int[][][] { 
			{{0,0},{0,1}, {1,0},{1,1}}, 
			{{0,-1}, {0,0}, {-1,0}, {-1,1}},
			 {{0, -1}, {0, 0}, {1, 0}, {1, 1}},
             {{0, -1}, {0, 0}, {0, 1}, {0, 2}},
             {{-1, 0}, {0, 0}, {1, 0}, {0, 1}},
             {{0, 0}, {1, 0}, {0, 1}, {1, 1}},
             {{-1, -1}, {0, -1}, {0, 0}, {0, 1}},
             {{1, -1}, {0, -1}, {0, 0}, {0, 1}}};
		
             
             for(int i = 0 ; i<4 ; i++) {
            	 System.arraycopy(coordsTable[block.ordinal()],0,coords,0,4);
             }
           pieceBlock = block; 
		}*/
		
		
	
		
	
	

