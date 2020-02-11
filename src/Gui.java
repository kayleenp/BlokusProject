import javax.swing.JFrame;
import java.util.Arrays;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicArrowButton;

import org.omg.CORBA.DynamicImplementation;
import org.w3c.dom.css.Counter;

import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.event.ActionListener;
import java.awt.image.AreaAveragingScaleFilter;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;


public class Gui {
	public static void main(String[] args) {
		new Gui();
	}

	
	public Block blocksTools = new Block(); 
	public Block blockData = new Block(); 
	public Integer[][] block1= new Integer[5][5]; 
	public Integer[][] block2= new Integer[5][5]; 
	public Integer[][] block3= new Integer[5][5]; 
	public Integer[][] block4= new Integer[5][5]; 
	public Integer[][] block5 = new Integer[5][5];
	public Integer counter1 =1;
	public Integer counter2 =1; 
	public Integer counter3 =1; 
	public Integer counter4 =1;

	public JButton[][] boardGridValue = new JButton[20][20];
	public BlockData getBlockData = new BlockData(); 
	public Board theBoard = new Board(); 
	private int counter = 1;
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
		boardGridValue = theBoard.boardGrid(boardPanel); 
		
		//GRID 
		
		//Players Button 
		JButton playerOneButton = new JButton("Place"); 
		playerOneButton.setPreferredSize(new Dimension(350,30));
		JButton playerTwoButton = new JButton("Player Two"); 
		playerTwoButton.setPreferredSize(new Dimension(350,30));
		JButton playerThreeButton = new JButton("Player Three"); 
		playerThreeButton.setPreferredSize(new Dimension(350,30));
		JButton playerFourButton = new JButton("Player Four");
		playerFourButton.setPreferredSize(new Dimension(350,30));

		// Blocks Button
		JButton mirrorP1 = new JButton("FLIP");
		JButton rotateLP1 = new JButton("ROTATE");
		BasicArrowButton nextP1 = new BasicArrowButton(BasicArrowButton.EAST);
		BasicArrowButton prevP1 = new BasicArrowButton(BasicArrowButton.WEST);
		
		JButton mirrorP2 = new JButton("FLIP");
		JButton rotateLP2 = new JButton("ROTATE");
		BasicArrowButton nextP2 = new BasicArrowButton(BasicArrowButton.EAST);
		BasicArrowButton prevP2 = new BasicArrowButton(BasicArrowButton.WEST);
		
		JButton mirrorP3 = new JButton("FLIP");
		JButton rotateLP3 = new JButton("ROTATE");
		BasicArrowButton nextP3 = new BasicArrowButton(BasicArrowButton.EAST);
		BasicArrowButton prevP3 = new BasicArrowButton(BasicArrowButton.WEST);
		
		JButton mirrorP4 = new JButton("FLIP");
		JButton rotateLP4 = new JButton("ROTATE");
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
		JPanel playerTwoBlockHolder = new JPanel();
		JPanel playerThreeBlockHolder = new JPanel();
		JPanel playerFourBlockHolder = new JPanel();
		playerOneHolder.add(playerOneBlockHolder, BorderLayout.CENTER);
		playerTwoHolder.add(playerTwoBlockHolder, BorderLayout.CENTER);
		playerThreeHolder.add(playerThreeBlockHolder, BorderLayout.CENTER);
		playerFourHolder.add(playerFourBlockHolder, BorderLayout.CENTER);
		
		///BLOCKS//
		Block controlBlock = new Block(); 
	
		
		
		
		
	
		//BLOCK HOLDER FOR PLAYER 1
		
		block1 = controlBlock.addBlockTools(block1, counter1, rotateLP1,mirrorP1, nextP1, prevP1, playerOneBlockHolder, Color.BLUE);
		block2 = controlBlock.addBlockTools(block2, counter2, rotateLP2,mirrorP2, nextP2, prevP2, playerTwoBlockHolder, Color.red);
		block3 = controlBlock.addBlockTools(block3, counter3, rotateLP3,mirrorP3, nextP3, prevP3, playerThreeBlockHolder, Color.yellow);
		block4 = controlBlock.addBlockTools(block4, counter4, rotateLP4,mirrorP4, nextP4, prevP4, playerFourBlockHolder, Color.green);
	
	block5 = getBlockData.Piece(7);
	block5 = blocksTools.rotate(block5);
	
		playerOneButton.addActionListener(new ActionListener() { 	
			
			@Override
			public void actionPerformed(ActionEvent e ) {
			
				theBoard.gridValue(boardGridValue, 2, 2, block1);
				
			}
			
		});
		 
	/*	for(int i=0; i<20; i++)
		{
			for(int j=0; j<20; j++)
			{
				final row = i;
				final col = j;
				boardGridValue[i][j].addActionListener(new ActionListener() { 	
					@Override
					public void actionPerformed(ActionEvent e ) {
						theBoard.gridValue(boardGridValue, i, j, block1);
					}
			
				});
				
		}}*/
		
		theBoard.gridValue(boardGridValue, 0, 5, block2);

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
       
		
		playerOnePanel.add(mirrorP1);
		playerOnePanel.add(rotateLP1);
		playerOnePanel.add(playerOneHolder);
		playerOneHolder.setPreferredSize(new Dimension(350,250));
		playerOneHolder.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		playerOneHolder.add(nextP1, BorderLayout.EAST);
		playerOneHolder.add(prevP1, BorderLayout.WEST);
		
		
		playerTwoPanel.add(mirrorP2);
		playerTwoPanel.add(rotateLP2);
		playerTwoPanel.add(playerTwoHolder);
		playerTwoHolder.setPreferredSize(new Dimension(350,250));
		playerTwoHolder.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		playerTwoHolder.add(nextP2, BorderLayout.EAST);
		playerTwoHolder.add(prevP2, BorderLayout.WEST);

		playerThreePanel.add(mirrorP3);
		playerThreePanel.add(rotateLP3);
		playerThreePanel.add(playerThreeHolder);
		playerThreeHolder.setPreferredSize(new Dimension(350,250));
		playerThreeHolder.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		playerThreeHolder.add(nextP3, BorderLayout.EAST);
		playerThreeHolder.add(prevP3, BorderLayout.WEST);
		
		playerFourPanel.add(mirrorP4);
		playerFourPanel.add(rotateLP4);
		playerFourPanel.add(playerFourHolder);
		playerFourHolder.setPreferredSize(new Dimension(350,250));
		playerFourHolder.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		playerFourHolder.add(nextP4, BorderLayout.EAST);
		playerFourHolder.add(prevP4, BorderLayout.WEST);

		
		}
}



		