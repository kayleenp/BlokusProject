import javax.swing.JFrame;
import java.util.Arrays;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;


public class Gui {
	public static void main(String[] args) {
		new Gui();
	}

	
	public Block blocksTools = new Block(); 
	public Block blockData = new Block(); 
	
		public Gui()
		
		{
		
		
		//Blokus Window
		JFrame blokusFrame = new JFrame();
		BorderLayout frameLayout = new BorderLayout();
		blokusFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		blokusFrame.setTitle("Blokus");
		blokusFrame.setSize(600,600);
		blokusFrame.setLayout(frameLayout);
		blokusFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//blokusFrame.setUndecorated(true);
		//blokusFrame.setResizable(resizable);
		blokusFrame.setLocationRelativeTo(null);
		blokusFrame.setVisible(true);
		
		//Grid
		GridLayout gridLayout= new GridLayout(20,20);
		
		//Blokus Panel 
		JPanel playerOnePanel = new JPanel(); 
		JPanel playerTwoPanel = new JPanel(); 
		JPanel playerThreePanel = new JPanel(); 
		JPanel playerFourPanel = new JPanel();
		JPanel boardPanel = new JPanel(); 
		JPanel playerOneTwoPanel = new JPanel(); 
		JPanel playerThreeFourPanel = new JPanel(); 
		JPanel playerOneHolder = new JPanel(); 
		JPanel playerTwoHolder = new JPanel(); 
		JPanel playerThreeHolder = new JPanel(); 
		JPanel playerFourHolder = new JPanel(); 
		JPanel menuBarJPanel = new JPanel(); 
		menuBarJPanel.setBackground(Color.LIGHT_GRAY);
		JLabel menuBarJLabel = new JLabel("Menu");
		boardPanel.setPreferredSize(new Dimension(400,600));
		boardPanel.setBackground(Color.white);
		boardPanel.setLayout(gridLayout);
		
		boardPanel.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
		
		
		
		//GRID 
		
		JButton[][] grid= new JButton[20][20];
		for (int i =0; i<(20); i++){
			for(int j =0; j<20; j++) {
				
				grid[i][j] = new JButton(); 
				// final JButton square = new JButton();
				 grid[i][j].setBackground(Color.white);
				
				    grid[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				    boardPanel.add(grid[i][j]);
			}
		   
		}
		
		
		//Players Button 
		JButton playerOneButton = new JButton("Player One"); 
		playerOneButton.setPreferredSize(new Dimension(350,30));
		JButton playerTwoButton = new JButton("Player Two"); 
		playerTwoButton.setPreferredSize(new Dimension(350,30));
		JButton playerThreeButton = new JButton("Player Three"); 
		playerThreeButton.setPreferredSize(new Dimension(350,30));
		JButton playerFourButton = new JButton("Player Four");
		playerFourButton.setPreferredSize(new Dimension(350,30));

		// Blocks Button
		JButton mirrorP1 = new JButton("FLIP");
		JButton rotateLP1 = new JButton("ROTATE LEFT");
		JButton rotateRP1 = new JButton("ROTATE RIGHT");
		BasicArrowButton nextP1 = new BasicArrowButton(BasicArrowButton.EAST);
		BasicArrowButton prevP1 = new BasicArrowButton(BasicArrowButton.WEST);
		
		JButton mirrorP2 = new JButton("FLIP");
		JButton rotateLP2 = new JButton("ROTATE LEFT");
		JButton rotateRP2 = new JButton("ROTATE RIGHT");
		BasicArrowButton nextP2 = new BasicArrowButton(BasicArrowButton.EAST);
		BasicArrowButton prevP2 = new BasicArrowButton(BasicArrowButton.WEST);
		
		JButton mirrorP3 = new JButton("FLIP");
		JButton rotateLP3 = new JButton("ROTATE LEFT");
		JButton rotateRP3 = new JButton("ROTATE RIGHT");
		BasicArrowButton nextP3 = new BasicArrowButton(BasicArrowButton.EAST);
		BasicArrowButton prevP3 = new BasicArrowButton(BasicArrowButton.WEST);
		
		JButton mirrorP4 = new JButton("FLIP");
		JButton rotateLP4 = new JButton("ROTATE LEFT");
		JButton rotateRP4 = new JButton("ROTATE RIGHT");
		BasicArrowButton nextP4 = new BasicArrowButton(BasicArrowButton.EAST);
		BasicArrowButton prevP4 = new BasicArrowButton(BasicArrowButton.WEST);
		
		BorderLayout panelLayoutWest  = new BorderLayout(); 
		BorderLayout panelLayoutEast  = new BorderLayout(); 
		BorderLayout panelLayoutOne = new BorderLayout();
		BorderLayout panelLayoutTwo = new BorderLayout();
		BorderLayout panelLayoutThree = new BorderLayout();
		BorderLayout panelLayoutFour = new BorderLayout();
		
		//Panel and Button Placement 
		playerOneTwoPanel.setLayout(panelLayoutWest);
		playerOneTwoPanel.setPreferredSize(new Dimension(400, 400));
		playerThreeFourPanel.setLayout(panelLayoutEast);
		playerThreeFourPanel.setPreferredSize(new Dimension(400, 400));
		playerOneTwoPanel.setBackground(Color.white);
		playerThreeFourPanel.setBackground(Color.white);
		playerOneTwoPanel.add(playerOnePanel, panelLayoutWest.NORTH); 
		playerOneTwoPanel.add(playerTwoPanel, panelLayoutWest.SOUTH); 
		playerThreeFourPanel.add(playerThreePanel, panelLayoutEast.NORTH); 
		playerThreeFourPanel.add(playerFourPanel, panelLayoutEast.SOUTH); 
		
		playerOneHolder.setLayout(panelLayoutOne);
		playerTwoHolder.setLayout(panelLayoutTwo);
		playerThreeHolder.setLayout(panelLayoutThree);
		playerFourHolder.setLayout(panelLayoutFour);
		JPanel playerOneBlockHolder = new JPanel();
		playerOneHolder.add(playerOneBlockHolder, BorderLayout.CENTER);
		CardLayout cardLayout = new CardLayout();
		playerOneBlockHolder.setLayout(cardLayout);
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		
		playerOneBlockHolder.add(panel1); 
		playerOneBlockHolder.add(panel2);
		playerOneBlockHolder.add(panel3); 
		playerOneBlockHolder.add(panel4);
		playerOneBlockHolder.add(panel5);
		
		BlockData getBlockData = new BlockData(); 
		Integer[][] block1= new Integer[5][5]; 
	
		//BLOCK TEST INITIALIZER
		
		//block1 
		
	
		block1 = getBlockData.Piece(1);
	
		getBlockData.paintBlocksButtons(
				block1, Color.blue,
				panel1);
		
		
	
		
		nextP1.addActionListener(new ActionListener() {
								@Override 
								public void actionPerformed(ActionEvent e) {
								cardLayout.next(playerOneBlockHolder);}});
		prevP1.addActionListener(new ActionListener() {
			@Override 
			public void actionPerformed(ActionEvent e) {
			cardLayout.previous(playerOneBlockHolder);}});
		


		//BLOCKS HOLDER
		playerOnePanel.setPreferredSize(new Dimension(1000,400));
		playerOnePanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
		
		playerTwoPanel.setPreferredSize(new Dimension(900,400));
		playerTwoPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
		playerTwoPanel.add(playerTwoHolder);
		
		playerThreePanel.setPreferredSize(new Dimension(900,400));
		playerThreePanel.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
		playerThreePanel.add(playerThreeHolder);
		
		playerFourPanel.setPreferredSize(new Dimension(900,400));
		playerFourPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
		playerFourPanel.add(playerFourHolder);
		
		
		
		blokusFrame.add(playerOneTwoPanel,frameLayout.WEST);
		blokusFrame.add(playerThreeFourPanel,frameLayout.EAST);
		
		
		playerOnePanel.add(playerOneButton); 
		playerTwoPanel.add(playerTwoButton); 
		playerThreePanel.add(playerThreeButton); 
		playerFourPanel.add(playerFourButton); 
		
		blokusFrame.add(boardPanel,frameLayout.CENTER); 
		menuBarJPanel.add(menuBarJLabel); 
		blokusFrame.add(menuBarJPanel, frameLayout.NORTH); 
		
		Integer save_value[] = new Integer[21]; 
       



//blocksTools.paintBlocksButtons(block[0], blocksPainted)
///////////////////////////////////////////////////////////////////////////////////////	
		
		
		playerOnePanel.add(mirrorP1);
		playerOnePanel.add(rotateRP1);
		playerOnePanel.add(rotateLP1);
		playerOnePanel.add(playerOneHolder);
		playerOneHolder.setPreferredSize(new Dimension(350,250));
		playerOneHolder.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		playerOneHolder.add(nextP1, BorderLayout.EAST);
		playerOneHolder.add(prevP1, BorderLayout.WEST);
		
		
		playerTwoPanel.add(mirrorP2);
		playerTwoPanel.add(rotateRP2);
		playerTwoPanel.add(rotateLP2);
		playerTwoPanel.add(playerTwoHolder);
		playerTwoHolder.setPreferredSize(new Dimension(350,250));
		playerTwoHolder.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		playerTwoHolder.add(nextP2, BorderLayout.EAST);
		playerTwoHolder.add(prevP2, BorderLayout.WEST);

		playerThreePanel.add(mirrorP3);
		playerThreePanel.add(rotateRP3);
		playerThreePanel.add(rotateLP3);
		playerThreePanel.add(playerThreeHolder);
		playerThreeHolder.setPreferredSize(new Dimension(350,250));
		playerThreeHolder.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		playerThreeHolder.add(nextP3, BorderLayout.EAST);
		playerThreeHolder.add(prevP3, BorderLayout.WEST);
		
		playerFourPanel.add(mirrorP4);
		playerFourPanel.add(rotateRP4);
		playerFourPanel.add(rotateLP4);
		playerFourPanel.add(playerFourHolder);
		playerFourHolder.setPreferredSize(new Dimension(350,250));
		playerFourHolder.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		playerFourHolder.add(nextP4, BorderLayout.EAST);
		playerFourHolder.add(prevP4, BorderLayout.WEST);

		
		}
}



		