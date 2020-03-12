import javax.swing.JFrame;
import java.util.Arrays;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicArrowButton;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;
import org.w3c.dom.css.Counter;


import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.AreaAveragingScaleFilter;
import java.rmi.server.ServerCloneException;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;


public class Gui {
	public static void main(String[] args) {
		new Gui();
	}

	
	public Block blocksTools = new Block(); 
	public Block blockData = new Block(); 
	
	public JButton RPTest[][] = new JButton[25][30];
	public JButton RPTest2[][] = new JButton[25][30];
	public JButton RPTest3[][] = new JButton[25][30];
	public JButton RPTest4[][] = new JButton[25][30];
	public Integer[][] block1= new Integer[5][5]; 
	public Integer[][] block2= new Integer[5][5]; 
	public Integer[][] block3= new Integer[5][5]; 
	public Integer[][] block4= new Integer[5][5]; 

   public JLabel p1Score = new JLabel();
	
   public JLabel p2Score = new JLabel();

   public JLabel p3Score = new JLabel();

   public	JLabel p4Score = new JLabel();
	
			
	public Integer counter1 =1;
	public Integer counter2 =1; 
	public Integer counter3 =1; 
	public Integer counter4 =1;
	
	public int PLAYER_ONE = 1;
	public int PLAYER_TWO = 2; 
	public int PLAYER_THREE=3; 
	public int PLAYER_FOUR=4; 
	
	public int remainingPieceCounterP1 = 0; 
	public int remainingPieceCounterP2 = 0; 
	public int remainingPieceCounterP3 = 0; 
	public int remainingPieceCounterP4 = 0; 
	
	public boolean blockUsed1[] = new boolean[23]; 
	public boolean blockUsed2[] = new boolean[23]; 
	public boolean blockUsed3[] = new boolean[23]; 
	public boolean blockUsed4[] = new boolean[23]; 
	
    public Integer[][] blockTestIntegers = new Integer[30][30]; 
    public Integer[][] blockTestIntegers2 = new Integer[30][30]; 
	public int currentCounter = 1; 
	public int currentCounter2 = 1; 
	public JButton[][] boardGridValue = new JButton[30][30];
	public JButton[][] boardGridValue2 = new JButton[30][30];
	public BlockData getBlockData = new BlockData(); 
	public Board theBoard = new Board(); 
	private int counter = 0;
	
	public int player1Score=0;
	public int player2Score=0;
	public int player3Score=0;
	public int player4Score=0;

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
		GridLayout gridLayout= new GridLayout(30,30);
		p1Score.setText("SCORE =" + player1Score);
		p2Score.setText("SCORE = "+ player2Score); 
		p3Score.setText("SCORE =" + player3Score);
		p4Score.setText("SCORE = "+ player4Score); 
		
		p1Score.setPreferredSize(new Dimension(350,30));
		p2Score.setPreferredSize(new Dimension(350,30));
		p3Score.setPreferredSize(new Dimension(350,30));
		p4Score.setPreferredSize(new Dimension(350,30));
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
		
		//Players Button 
		JLabel playerOneButton = new JLabel("Choose Piece"); 
		playerOneButton.setPreferredSize(new Dimension(350,30));
		JLabel playerTwoButton = new JLabel("Choose Piece"); 
		playerTwoButton.setPreferredSize(new Dimension(350,30));
		JLabel playerThreeButton = new JLabel("Choose Piece"); 
		playerThreeButton.setPreferredSize(new Dimension(350,30));
		JLabel playerFourButton = new JLabel("Choose Piece");
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
		
		JButton flipVerticalP1 = new JButton("Flip Vertical");
		JButton flipVerticalP2 = new JButton("Flip Vertical");
		JButton flipVerticalP3 = new JButton("Flip Vertical");
		JButton flipVerticalP4 = new JButton("Flip Vertical");
		
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
	
		JPanel remainingPieceGrid1 = new JPanel();
		JPanel remainingPieceGrid2 = new JPanel();
		JPanel remainingPieceGrid3 = new JPanel();
		JPanel remainingPieceGrid4 = new JPanel();
		JFrame remainingPiece1 = new JFrame();
		
		remainingPiece1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		remainingPiece1.setTitle("Player 1");
		remainingPiece1.setSize(800,550);
	
		JFrame remainingPiece2 = new JFrame();
		remainingPiece2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		remainingPiece2.setTitle("Player 2");
		remainingPiece2.setSize(800,550);
		
		JFrame remainingPiece3 = new JFrame();
		remainingPiece3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		remainingPiece3.setTitle("Player 3");
		remainingPiece3.setSize(800,550);
		
		JFrame remainingPiece4 = new JFrame();
		remainingPiece4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		remainingPiece4.setTitle("Player 4");
		remainingPiece4.setSize(800,550);
		
		GridLayout rpGrid = new GridLayout(25,30);
		
		
		
		remainingPieceGrid2.setBackground(Color.white);
		remainingPieceGrid3.setBackground(Color.white);
		remainingPieceGrid4.setBackground(Color.white);
		
		remainingPieceGrid1.setLayout(rpGrid);
		remainingPieceGrid2.setLayout(rpGrid);
		remainingPieceGrid3.setLayout(rpGrid);
		remainingPieceGrid4.setLayout(rpGrid);
		
		remainingPieceGrid1.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
		RPTest = theBoard.remainingPieceGrid(0, 0, remainingPieceGrid1);
		
		JFrame gameOverFrame = new JFrame();
		gameOverFrame.setVisible(false);
		gameOverFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		gameOverFrame.setTitle("GameOver");
		gameOverFrame.setSize(800,550);
		gameOverFrame.setLocationRelativeTo(null);
		
			
		
		RPTest = theBoard.remainingPiece(0,0,RPTest, getBlockData.Piece(1), Color.blue, true );
		RPTest = theBoard.remainingPiece(0,5,RPTest, getBlockData.Piece(2), Color.blue , true); 
		RPTest = theBoard.remainingPiece(0,10,RPTest, getBlockData.Piece(3), Color.blue, true ); 
		RPTest =theBoard.remainingPiece(0,15,RPTest, getBlockData.Piece(4), Color.blue, true ); 
		RPTest = theBoard.remainingPiece(0,20,RPTest, getBlockData.Piece(5), Color.blue, true ); 
		RPTest = theBoard.remainingPiece(0, 25, RPTest,  getBlockData.Piece(6),Color.blue, true);
		RPTest = theBoard.remainingPiece(5, 0, RPTest,  getBlockData.Piece(7),Color.blue, true);
		RPTest = theBoard.remainingPiece(5, 5, RPTest,  getBlockData.Piece(8),Color.blue, true);
		RPTest = theBoard.remainingPiece(5, 10, RPTest,  getBlockData.Piece(9),Color.blue, true);
		RPTest = theBoard.remainingPiece(5, 15, RPTest,  getBlockData.Piece(10),Color.blue, true);
		RPTest = theBoard.remainingPiece(5, 20, RPTest,  getBlockData.Piece(11),Color.blue, true);
		RPTest = theBoard.remainingPiece(5, 25, RPTest,  getBlockData.Piece(12),Color.blue, true);
		RPTest = theBoard.remainingPiece(10, 0, RPTest,  getBlockData.Piece(13),Color.blue, true);
		RPTest = theBoard.remainingPiece(10, 5, RPTest,  getBlockData.Piece(14),Color.blue, true);
		RPTest = theBoard.remainingPiece(10, 10, RPTest,  getBlockData.Piece(15),Color.blue, true);
		RPTest = theBoard.remainingPiece(10, 15, RPTest,  getBlockData.Piece(16),Color.blue, true);
		RPTest = theBoard.remainingPiece(10, 20, RPTest,  getBlockData.Piece(17),Color.blue, true);
		RPTest = theBoard.remainingPiece(10, 25, RPTest,  getBlockData.Piece(18),Color.blue, true);
		RPTest = theBoard.remainingPiece(15, 0, RPTest,  getBlockData.Piece(19),Color.blue, true);
		RPTest = theBoard.remainingPiece(15, 5, RPTest,  getBlockData.Piece(20),Color.blue, true);
		RPTest = theBoard.remainingPiece(15, 10, RPTest,  getBlockData.Piece(21),Color.blue, true);
		

		remainingPieceGrid2.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
		RPTest2 = theBoard.remainingPieceGrid(0, 0, remainingPieceGrid2);
		

			
		RPTest2 = theBoard.remainingPiece(0,0,RPTest2, getBlockData.Piece(1), Color.red, true );
		RPTest2 = theBoard.remainingPiece(0,5,RPTest2, getBlockData.Piece(2), Color.red , true); 
		RPTest2 = theBoard.remainingPiece(0,10,RPTest2, getBlockData.Piece(3), Color.red, true ); 
		RPTest2 = theBoard.remainingPiece(0,15,RPTest2, getBlockData.Piece(4), Color.red, true ); 
		RPTest2 = theBoard.remainingPiece(0,20,RPTest2, getBlockData.Piece(5), Color.red, true ); 
		RPTest2 = theBoard.remainingPiece(0, 25, RPTest2,  getBlockData.Piece(6),Color.red, true);
		RPTest2 = theBoard.remainingPiece(5, 0, RPTest2,  getBlockData.Piece(7),Color.red, true);
		RPTest2 = theBoard.remainingPiece(5, 5, RPTest2,  getBlockData.Piece(8),Color.red, true);
		RPTest2 = theBoard.remainingPiece(5, 10, RPTest2,  getBlockData.Piece(9),Color.red, true);
		RPTest2 = theBoard.remainingPiece(5, 15, RPTest2,  getBlockData.Piece(10),Color.red, true);
		RPTest2 = theBoard.remainingPiece(5, 20, RPTest2,  getBlockData.Piece(11),Color.red, true);
		RPTest2 = theBoard.remainingPiece(5, 25, RPTest2,  getBlockData.Piece(12),Color.red, true);
		RPTest2 = theBoard.remainingPiece(10, 0, RPTest2,  getBlockData.Piece(13),Color.red, true);
		RPTest2 = theBoard.remainingPiece(10, 5, RPTest2,  getBlockData.Piece(14),Color.red, true);
		RPTest2 = theBoard.remainingPiece(10, 10, RPTest2,  getBlockData.Piece(15),Color.red, true);
		RPTest2 = theBoard.remainingPiece(10, 15, RPTest2,  getBlockData.Piece(16),Color.red, true);
		RPTest2 = theBoard.remainingPiece(10, 20, RPTest2,  getBlockData.Piece(17),Color.red, true);
		RPTest2 = theBoard.remainingPiece(10, 25, RPTest2,  getBlockData.Piece(18),Color.red, true);
		RPTest2 = theBoard.remainingPiece(15, 0, RPTest2,  getBlockData.Piece(19),Color.red, true);
		RPTest2 = theBoard.remainingPiece(15, 5, RPTest2,  getBlockData.Piece(20),Color.red, true);
		RPTest2 = theBoard.remainingPiece(15, 10, RPTest2,  getBlockData.Piece(21),Color.red, true);
		
		remainingPieceGrid3.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
		RPTest3 = theBoard.remainingPieceGrid(0, 0, remainingPieceGrid3);
		

			
		RPTest3 = theBoard.remainingPiece(0,0,RPTest3, getBlockData.Piece(1), Color.yellow, true );
		RPTest3 = theBoard.remainingPiece(0,5,RPTest3, getBlockData.Piece(2), Color.yellow , true); 
		RPTest3 = theBoard.remainingPiece(0,10,RPTest3, getBlockData.Piece(3), Color.yellow, true ); 
		RPTest3 = theBoard.remainingPiece(0,15,RPTest3, getBlockData.Piece(4), Color.yellow, true ); 
		RPTest3 = theBoard.remainingPiece(0,20,RPTest3, getBlockData.Piece(5), Color.yellow, true ); 
		RPTest3 = theBoard.remainingPiece(0, 25, RPTest3,  getBlockData.Piece(6),Color.yellow, true);
		RPTest3 = theBoard.remainingPiece(5, 0, RPTest3,  getBlockData.Piece(7),Color.yellow, true);
		RPTest3 = theBoard.remainingPiece(5, 5, RPTest3,  getBlockData.Piece(8),Color.yellow, true);
		RPTest3 = theBoard.remainingPiece(5, 10, RPTest3,  getBlockData.Piece(9),Color.yellow, true);
		RPTest3 = theBoard.remainingPiece(5, 15, RPTest3,  getBlockData.Piece(10),Color.yellow, true);
		RPTest3 = theBoard.remainingPiece(5, 20, RPTest3,  getBlockData.Piece(11),Color.yellow, true);
		RPTest3 = theBoard.remainingPiece(5, 25, RPTest3,  getBlockData.Piece(12),Color.yellow, true);
		RPTest3 = theBoard.remainingPiece(10, 0, RPTest3,  getBlockData.Piece(13),Color.yellow, true);
		RPTest3 = theBoard.remainingPiece(10, 5, RPTest3,  getBlockData.Piece(14),Color.yellow, true);
		RPTest3 = theBoard.remainingPiece(10, 10, RPTest3,  getBlockData.Piece(15),Color.yellow, true);
		RPTest3 = theBoard.remainingPiece(10, 15, RPTest3,  getBlockData.Piece(16),Color.yellow, true);
		RPTest3 = theBoard.remainingPiece(10, 20, RPTest3,  getBlockData.Piece(17),Color.yellow, true);
		RPTest3 = theBoard.remainingPiece(10, 25, RPTest3,  getBlockData.Piece(18),Color.yellow, true);
		RPTest3 = theBoard.remainingPiece(15, 0, RPTest3,  getBlockData.Piece(19),Color.yellow, true);
		RPTest3 = theBoard.remainingPiece(15, 5, RPTest3,  getBlockData.Piece(20),Color.yellow, true);
		RPTest3 = theBoard.remainingPiece(15, 10, RPTest3,  getBlockData.Piece(21),Color.yellow, true);
		
		remainingPieceGrid4.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
		RPTest4 = theBoard.remainingPieceGrid(0, 0, remainingPieceGrid4);
		

			
		RPTest4 = theBoard.remainingPiece(0,0,RPTest4, getBlockData.Piece(1), Color.green, true );
		RPTest4 = theBoard.remainingPiece(0,5,RPTest4, getBlockData.Piece(2), Color.green , true); 
		RPTest4 = theBoard.remainingPiece(0,10,RPTest4, getBlockData.Piece(3), Color.green, true ); 
		RPTest4 = theBoard.remainingPiece(0,15,RPTest4, getBlockData.Piece(4), Color.green, true ); 
		RPTest4 = theBoard.remainingPiece(0,20,RPTest4, getBlockData.Piece(5), Color.green, true ); 
		RPTest4 = theBoard.remainingPiece(0, 25, RPTest4,  getBlockData.Piece(6),Color.green, true);
		RPTest4 = theBoard.remainingPiece(5, 0, RPTest4,  getBlockData.Piece(7),Color.green, true);
		RPTest4 = theBoard.remainingPiece(5, 5, RPTest4,  getBlockData.Piece(8),Color.green, true);
		RPTest4 = theBoard.remainingPiece(5, 10, RPTest4,  getBlockData.Piece(9),Color.green, true);
		RPTest4 = theBoard.remainingPiece(5, 15, RPTest4,  getBlockData.Piece(10),Color.green, true);
		RPTest4 = theBoard.remainingPiece(5, 20, RPTest4,  getBlockData.Piece(11),Color.green, true);
		RPTest4 = theBoard.remainingPiece(5, 25, RPTest4,  getBlockData.Piece(12),Color.green, true);
		RPTest4 = theBoard.remainingPiece(10, 0, RPTest4,  getBlockData.Piece(13),Color.green, true);
		RPTest4 = theBoard.remainingPiece(10, 5, RPTest4,  getBlockData.Piece(14),Color.green, true);
		RPTest4 = theBoard.remainingPiece(10, 10, RPTest4,  getBlockData.Piece(15),Color.green, true);
		RPTest4 = theBoard.remainingPiece(10, 15, RPTest4,  getBlockData.Piece(16),Color.green, true);
		RPTest4 = theBoard.remainingPiece(10, 20, RPTest4,  getBlockData.Piece(17),Color.green, true);
		RPTest4 = theBoard.remainingPiece(10, 25, RPTest4,  getBlockData.Piece(18),Color.green, true);
		RPTest4 = theBoard.remainingPiece(15, 0, RPTest4,  getBlockData.Piece(19),Color.green, true);
		RPTest4 = theBoard.remainingPiece(15, 5, RPTest4,  getBlockData.Piece(20),Color.green, true);
		RPTest4 = theBoard.remainingPiece(15, 10, RPTest4,  getBlockData.Piece(21),Color.green, true);
		
		remainingPiece1.add(remainingPieceGrid1);
		remainingPiece2.add(remainingPieceGrid2);
		remainingPiece3.add(remainingPieceGrid3);
		remainingPiece4.add(remainingPieceGrid4);
		
		
		
		
		
		
		//blokusFrame.setUndecorated(true);
		//blokusFrame.setResizable(resizable);
		remainingPiece1.setLocationRelativeTo(null);
		remainingPiece1.setVisible(false);
		JPanel remainingPieceHolder1 = new JPanel();
		remainingPieceHolder1.setBackground(Color.blue);
		remainingPiece2.setLocationRelativeTo(null);
		remainingPiece2.setVisible(false);
		JPanel remainingPieceHolder2 = new JPanel();
		remainingPiece3.setLocationRelativeTo(null);
		remainingPiece3.setVisible(false);
		JPanel remainingPieceHolder3 = new JPanel();
		remainingPiece4.setLocationRelativeTo(null);
		remainingPiece4.setVisible(false);
		JPanel remainingPieceHolder4 = new JPanel();
		
		
	
		//BLOCK HOLDER FOR PLAYER 1
		
		/*block1 = controlBlock.addBlockTools(block1, counter1, rotateLP1,mirrorP1, nextP1, prevP1, playerOneBlockHolder, Color.BLUE);
		block2 = controlBlock.addBlockTools(block2, counter2, rotateLP2,mirrorP2, nextP2, prevP2, playerTwoBlockHolder, Color.red);
		block3 = controlBlock.addBlockTools(block3, counter3, rotateLP3,mirrorP3, nextP3, prevP3, playerThreeBlockHolder, Color.yellow);
		block4 = controlBlock.addBlockTools(block4, counter4, rotateLP4,mirrorP4, nextP4, prevP4, playerFourBlockHolder, Color.green);*/
		JLabel testJLabel = new JLabel(); 
		boardGridValue = theBoard.boardGrid(boardPanel,blockTestIntegers); 
		
		  JButton nextTurnP1 = new JButton ("NEXT");
		    JButton nextTurnP2 = new JButton ("NEXT");
		    JButton nextTurnP3 = new JButton ("NEXT");
		    JButton nextTurnP4 = new JButton ("NEXT");
		    JButton startBlokus = new JButton ("Start"); 
		    JButton passP1 = new JButton ("PASS");
		    JButton passP2 = new JButton ("PASS");
		    JButton passP3 = new JButton ("PASS");
		    JButton passP4 = new JButton ("PASS");
		    JButton playerOneTestButton = new JButton ("Start");
		    JButton playerTwoTestButton = new JButton ("Player 2");
		    JButton playerThreeTestButton= new JButton ("Player 3");
		    JButton playerFourTestButton = new JButton ("Player 4");
		    
		    playerTwoTestButton.setVisible(false);
		    playerThreeTestButton.setVisible(false);
		    playerFourTestButton.setVisible(false);

		    
		   // playerOnePanel.add(nextTurnP2);
		    playerOnePanel.add(passP2);
		  //  playerTwoPanel.add(nextTurnP3);
		    playerTwoPanel.add(passP3);
		  //  playerThreePanel.add(nextTurnP4);
		    playerThreePanel.add(passP4);
		 //   playerFourPanel.add(nextTurnP1);
		    playerFourPanel.add(passP1);
		 
		    menuBarJPanel.add(playerOneTestButton); 
		    menuBarJPanel.add(playerTwoTestButton); 		     
		    menuBarJPanel.add(playerThreeTestButton); 
		    menuBarJPanel.add(playerFourTestButton); 
		    
		    
		   
		
			
		    for(int i=1; i<22; i++)
		    {
		    	blockUsed1[i] = false; 
		    }
		     playerOneTestButton.addActionListener(new ActionListener() {  
				    @Override
				    
				    public void actionPerformed(ActionEvent e ) {  
				    	
				    	
				    	remainingPiece1.setVisible(true);
				 
				    	 block1 = blocksTools.getPiece(block1, counter1, playerOneBlockHolder, Color.blue);
				    	
				    	 //so it only focus on desired piece
				    	 for(int i=0; i<5;i++) {
				    		 for(int j=0 ;j<5;j++)
				    		 {
				    			 block2[i][j]=0; 
				    			 block3[i][j]=0; 
				    			 block4[i][j]=0; 
				    		 }
				    	 }
				    	 for (int i =0; i<(30); i++){
								for(int j =0; j<30; j++) {
									 if(i>4 && j>4 && i<25 && j<25) {
										 
										 
									
										 
									boardGridValue[i][j].setText("" + blockTestIntegers[i][j]);
										 }
									
									final int row=i; 
									final int col=j;
									
								  boardGridValue[i][j].addMouseListener(new java.awt.event.MouseAdapter() {
											public Color oldColor;
											
								 	   public void mouseClicked(MouseEvent evt) {
								 		   if(blockUsed1[counter1]==false) {							 			 
								 	   theBoard.gridClicked(evt, boardGridValue, blockTestIntegers, block1, 
								 			   Color.blue, row, col, PLAYER_ONE,  blockUsed1, counter1, nextP1, 
								 			   remainingPieceCounterP1, playerTwoTestButton, RPTest,   p1Score, 
								 			   player1Score);
								 		System.out.print("CLICK : " + counter1);
								 	  scoring(boardGridValue, p1Score, player1Score, Color.blue);
								 	  if(player1Score >89) { 
								 		  System.out.print("YOU WIN PLAYER 1");
								 	  }
								 	     
								 	      
								 	  }
								 		  

								 	   }
								 	   
								 	  public void mouseEntered(MouseEvent evt) { 		 
								 		theBoard.gridMouseEntered(evt, boardGridValue, blockTestIntegers, block1, Color.blue, row, col);
									    	}
								 	  
									  public void mouseExited(MouseEvent evt) {
										  theBoard.gridMouseExited(evt, boardGridValue, blockTestIntegers, block1, Color.blue, row, col);
	 
									 }
							
									
								});}}
				    	
		     nextP1.addActionListener(new ActionListener() { 
					@Override
					public void actionPerformed(ActionEvent e ) {
					if(e.getSource()==nextP1) {
						
						if(counter1>21 ) {
							counter1=0;
						}
						
						else { 
							counter1=counter1+1;
						}
							
						
					if(blockUsed1[counter1]==false) {
						
							block1 = blocksTools.getPiece(block1, counter1, playerOneBlockHolder, Color.blue);
						
							
						}
				
						
						
					else if(blockUsed1[counter1]==true) {
						
						nextP1.doClick(1);
						
						}
					
						
						 
						
						
						//when grid is clicked 
					}
					}
				});
		     prevP1.addActionListener(new ActionListener() { 
					@Override
					public void actionPerformed(ActionEvent e ) {
					if(e.getSource()==prevP1) {
						counter1--;
						System.out.print(counter1);
						if(counter1<1 ) {
							counter1=22;
						}
						
					
					
					if(blockUsed1[counter1]==false) {
						
						
							block1 = blocksTools.getPiece(block1, counter1, playerOneBlockHolder, Color.blue);
							
						}
				
						
						
					else if(blockUsed1[counter1]==true) {
						
						prevP1.doClick(1);
						
						}
					
						
						 
					}	
						
						//when grid is clicked 
					}

				});
		   
		     
		   
		     
		     
				  rotateLP1.addActionListener(new ActionListener() { 	
						@Override
						public void actionPerformed(ActionEvent e ) {		
							Integer[][] temp_block1= new Integer[5][5]; 
							
							if(e.getSource()==rotateLP1) {
								block1 = blocksTools.getRotatedPiece(block1,  playerOneBlockHolder, Color.blue);
							
							
							
						//	theBoard.gridClicked(boardPanel, boardGridValue, blockTestIntegers, block1, Color.blue);
							
						}
							}	
					});
					mirrorP1.addActionListener(new ActionListener() { 	
						
						@Override
						public void actionPerformed(ActionEvent e ) {
							
							if(e.getSource()==mirrorP1) {
								block1 = blocksTools.getFlippedPiece(block1,  playerOneBlockHolder, Color.blue);
							
							}
						}	
					});
					flipVerticalP1.addActionListener(new ActionListener() { 	
						
						@Override
						public void actionPerformed(ActionEvent e ) {
							
							if(e.getSource()==flipVerticalP1) {
								block1 = blocksTools.getFVPiece(block1,  playerOneBlockHolder, Color.blue);	
								

							}
						}	
					});
					
				   }
				    
		     
		     });
		    
		     
		 
		    
		     	
				
				
		    
		    
		    playerTwoTestButton.addActionListener(new ActionListener() {  
		    @Override
		    public void actionPerformed(ActionEvent e ) {
		    	remainingPiece2.setVisible(true);
			    	 block2 = blocksTools.getPiece(block2, counter2, playerTwoBlockHolder, Color.red);
			    	 for(int i=0; i<5;i++) {
			    		 for(int j=0 ;j<5;j++)
			    		 {
			    			 block1[i][j]=0; 
			    			 block3[i][j]=0; 
			    			 block4[i][j]=0; 
			    		 }
			    	 }
			    	 
			    	 for (int i =0; i<(30); i++){
							for(int j =0; j<30; j++) {
								 if(i>4 && j>4 && i<25 && j<25) {
										boardGridValue[i][j].setText("" + blockTestIntegers[i][j]);
											 }
										
								
								
								final int row=i; 
								final int col=j;
								
							  boardGridValue[i][j].addMouseListener(new java.awt.event.MouseAdapter() {
										public Color oldColor;
										
							 	   public void mouseClicked(MouseEvent evt) {
							 		   if(blockUsed2[counter2]==false) {
							 			
							 		   theBoard.gridClicked(evt, boardGridValue, blockTestIntegers, block2, Color.RED, row, col, 
							 			   PLAYER_TWO,  blockUsed2, counter2, nextP2, remainingPieceCounterP2, playerThreeTestButton, RPTest2, 
							 			  p2Score, player2Score);
							 		   
							 		  scoring(boardGridValue, p2Score, player2Score, Color.red);
							 		   }
							 	  
							 	  
								    }
							 	  public void mouseEntered(MouseEvent evt) { 		 
							 		 theBoard.gridMouseEntered(evt, boardGridValue, blockTestIntegers, block2, Color.red, row, col);
								    	}
							 	  
								  public void mouseExited(MouseEvent evt) {
									  theBoard.gridMouseExited(evt, boardGridValue, blockTestIntegers, block2, Color.red, row, col);

								 }
						
							});}}
		  
		       nextP2.addActionListener(new ActionListener() { 
					@Override
					public void actionPerformed(ActionEvent e ) {
						if(e.getSource()==nextP2) {
							counter2++;
							if(counter2>21 ) {
								counter2=0;
							}
							
						
								
							}
						if(blockUsed2[counter2]==false) {
								
								block2 = blocksTools.getPiece(block2, counter2, playerTwoBlockHolder, Color.red);
								
							}
					
							
							
						else if(blockUsed2[counter2]==true) {
							
							nextP2.doClick(1);
							
						}
							
							
							//when grid is clicked 
						}
				});
		       
		       prevP2.addActionListener(new ActionListener() { 
					@Override
					public void actionPerformed(ActionEvent e ) {
						
					if(e.getSource()==prevP2) {
						counter2--;
						if(counter2<1 ) {
							counter2=21;
						}
						
					
							
						}
					if(blockUsed2[counter2]==false) {
							
							block2 = blocksTools.getPiece(block2, counter2, playerTwoBlockHolder, Color.red);
							
						}
				
						
						
					else if(blockUsed2[counter2]==true) {
						
						prevP2.doClick(1);
						
						}
					
						
						 
						
						
						//when grid is clicked 
					}

				});
				  rotateLP2.addActionListener(new ActionListener() { 	
						
						@Override
						public void actionPerformed(ActionEvent e ) {		
							if(e.getSource()==rotateLP2) {
							block2 = blocksTools.rotate(block2); 
								playerTwoBlockHolder.removeAll(); 
								playerTwoBlockHolder.revalidate(); 
								playerTwoBlockHolder.repaint(); 
								getBlockData.paintBlocksButtons(
										block2,Color.red,
										playerTwoBlockHolder);
							//block2 = blocksTools.getRotatedPiece(block2,  playerTwoBlockHolder, Color.red);
							//theBoard.gridClicked(boardPanel, boardGridValue, blockTestIntegers, block2, Color.RED);	

							
						}}	
					});
					mirrorP2.addActionListener(new ActionListener() { 	
						
						@Override
						public void actionPerformed(ActionEvent e ) {
							
							if(e.getSource()==mirrorP2) {
								block2 = blocksTools.getFlippedPiece(block2,  playerTwoBlockHolder, Color.red);	
								

							}
						}	
					});
					flipVerticalP2.addActionListener(new ActionListener() { 	
						
						@Override
						public void actionPerformed(ActionEvent e ) {
							
							if(e.getSource()==flipVerticalP2) {
								block2 = blocksTools.getFVPiece(block2,  playerTwoBlockHolder, Color.red);	
								

							}
						}	
					});
		       
		    
		    }
		    
		   });
		    
		    playerThreeTestButton.addActionListener(new ActionListener() {  
			    @Override
			    public void actionPerformed(ActionEvent e ) {
			    	remainingPiece3.setVisible(true);
				    	 block3 = blocksTools.getPiece(block3, counter3, playerThreeBlockHolder, Color.YELLOW);
				    	 for(int i=0; i<5;i++) {
				    		 for(int j=0 ;j<5;j++)
				    		 {
				    			 block2[i][j]=0; 
				    			 block1[i][j]=0; 
				    			 block4[i][j]=0; 
				    		 }
				    	 }
				    	 
				    	 for (int i =0; i<(30); i++){
								for(int j =0; j<30; j++) {
									 if(i>4 && j>4 && i<25 && j<25) {
											boardGridValue[i][j].setText("" + blockTestIntegers[i][j]);
												 }
											
									
									
									final int row=i; 
									final int col=j;
									
								  boardGridValue[i][j].addMouseListener(new java.awt.event.MouseAdapter() {
											public Color oldColor;
											
								 	   public void mouseClicked(MouseEvent evt) {
								 		  if(blockUsed3[counter3]==false) {
									 			 
									 		   theBoard.gridClicked(evt, boardGridValue, blockTestIntegers, block3, Color.YELLOW, row, col, 
									 			   PLAYER_THREE,  blockUsed3, counter3, nextP3, remainingPieceCounterP3, playerFourTestButton, RPTest3, 
									 			   p3Score, player3Score);
									 		  scoring(boardGridValue, p3Score, player3Score, Color.yellow);
									 		   }
								 
								 	 
									    }
								 	  public void mouseEntered(MouseEvent evt) { 		 
								 		 theBoard.gridMouseEntered(evt, boardGridValue, blockTestIntegers, block3, Color.YELLOW, row, col);
									    	}
								 	  
									  public void mouseExited(MouseEvent evt) {
										  theBoard.gridMouseExited(evt, boardGridValue, blockTestIntegers, block3, Color.yellow, row, col);

									 }
							
								});}}
			 
			       nextP3.addActionListener(new ActionListener() { 
						@Override
						public void actionPerformed(ActionEvent e ) {
							if(e.getSource()==nextP3) {
								counter3++;
								if(counter3>21 ) {
									counter3=0;
								}
									
								}
							if(blockUsed3[counter3]==false) {
									
									block3 = blocksTools.getPiece(block3, counter3, playerThreeBlockHolder, Color.YELLOW);
									
								}
						
								
								
							else if(blockUsed3[counter3]==true) {
								
								nextP3.doClick(1);
								
								}
							
								
								 
								
								
								//when grid is clicked 
							}
					});
			       
			       prevP3.addActionListener(new ActionListener() { 
						@Override
						public void actionPerformed(ActionEvent e ) {
						if(e.getSource()==prevP3) {
							counter3--;
							if(counter3<1 ) {
								counter3=21;
							}
							
						
								
							}
						if(blockUsed3[counter3]==false) {
								
								block3 = blocksTools.getPiece(block3, counter3, playerThreeBlockHolder, Color.yellow);
								
							}
					
							
							
						else if(blockUsed3[counter3]==true) {
							
							prevP3.doClick(1);
							
							}
						
							
							 
							
							
							//when grid is clicked 
						}

					});
					  rotateLP3.addActionListener(new ActionListener() { 	
							
							@Override
							public void actionPerformed(ActionEvent e ) {		
								if(e.getSource()==rotateLP3) {
								block3 = blocksTools.getRotatedPiece(block3,  playerThreeBlockHolder, Color.yellow);
								//theBoard.gridClicked(boardPanel, boardGridValue, blockTestIntegers, block2, Color.RED);	

								
							}}	
						});
						mirrorP3.addActionListener(new ActionListener() { 	
							
							@Override
							public void actionPerformed(ActionEvent e ) {
								
								if(e.getSource()==mirrorP3) {
									block3 = blocksTools.getFlippedPiece(block3,  playerThreeBlockHolder, Color.yellow);	
									

								}
							}	
						});
						
						flipVerticalP3.addActionListener(new ActionListener() { 	
							
							@Override
							public void actionPerformed(ActionEvent e ) {
								
								if(e.getSource()==flipVerticalP3) {
									block3 = blocksTools.getFVPiece(block3,  playerThreeBlockHolder, Color.yellow);	
									

								}
							}	
						});
			 
			      
			    }
			    
			   });
		   
		 
		  
		   playerFourTestButton.addActionListener(new ActionListener() {  
			    @Override
			    public void actionPerformed(ActionEvent e ) {
			    	remainingPiece4.setVisible(true);
				    	 block4 = blocksTools.getPiece(block4, counter4, playerFourBlockHolder, Color.GREEN);
				    	 for(int i=0; i<5;i++) {
				    		 for(int j=0 ;j<5;j++)
				    		 {
				    			 block2[i][j]=0; 
				    			 block1[i][j]=0; 
				    			 block3[i][j]=0; 
				    		 }
				    	 }
				    	 
				    	 for (int i =0; i<(30); i++){
								for(int j =0; j<30; j++) {
									 if(i>4 && j>4 && i<25 && j<25) {
											boardGridValue[i][j].setText("" + blockTestIntegers[i][j]);
												 }
											
									
									
									final int row=i; 
									final int col=j;
									
								  boardGridValue[i][j].addMouseListener(new java.awt.event.MouseAdapter() {
											public Color oldColor;
											
								 	   public void mouseClicked(MouseEvent evt) {
								 		  if(blockUsed4[counter4]==false) {
								 			
								 	   theBoard.gridClicked(evt, boardGridValue, blockTestIntegers, block4, Color.GREEN, row, col, PLAYER_FOUR,  
								 			   blockUsed4, counter4, nextP4, remainingPieceCounterP4, playerOneTestButton, RPTest4, 
								 			  p4Score, player4Score);
								 	  scoring(boardGridValue, p4Score, player4Score, Color.green);
								 	   
								 	   
								 		  }
									 
									   
									   
									    }
								 	  public void mouseEntered(MouseEvent evt) { 		 
								 		 theBoard.gridMouseEntered(evt, boardGridValue, blockTestIntegers, block4, Color.GREEN, row, col);
									    	}
								 	  
									  public void mouseExited(MouseEvent evt) {
										  theBoard.gridMouseExited(evt, boardGridValue, blockTestIntegers, block4, Color.GREEN, row, col);

									 }
							
								});}}
			 
			       nextP4.addActionListener(new ActionListener() { 
						@Override
						public void actionPerformed(ActionEvent e ) {
							if(e.getSource()==nextP4) {
								counter4++;
								if(counter4>21 ) {
									counter4=0;
								}
								
							
									
								}
							if(blockUsed4[counter4]==false) {
									
									block4 = blocksTools.getPiece(block4, counter4, playerFourBlockHolder, Color.GREEN);
									
								}
						
								
								
							else if(blockUsed4[counter4]==true) {
								
								nextP4.doClick(1);
								
								}
							
								
								 
								
								
								//when grid is clicked 
							}
					});
			       
			       prevP4.addActionListener(new ActionListener() { 
						@Override
						public void actionPerformed(ActionEvent e ) {
						if(e.getSource()==prevP4) {
							counter4--;
							if(counter4<1 ) {
								counter4=21;
							}
							
						
								
							}
						if(blockUsed4[counter4]==false) {
								
								block4 = blocksTools.getPiece(block4, counter4, playerFourBlockHolder, Color.GREEN);
								
							}
					
							
							
						else if(blockUsed4[counter4]==true) {
							
							prevP4.doClick(1);
							
							}
						
							
							 
							
							
							//when grid is clicked 
						}

					});
					  rotateLP4.addActionListener(new ActionListener() { 	
							
							@Override
							public void actionPerformed(ActionEvent e ) {		
								if(e.getSource()==rotateLP4) {
								block4 = blocksTools.getRotatedPiece(block4,  playerFourBlockHolder, Color.green);
								//theBoard.gridClicked(boardPanel, boardGridValue, blockTestIntegers, block2, Color.RED);	

								
							}}	
						});
						mirrorP4.addActionListener(new ActionListener() { 	
							
							@Override
							public void actionPerformed(ActionEvent e ) {
								
								if(e.getSource()==mirrorP4) {
									block4 = blocksTools.getFlippedPiece(block4,  playerFourBlockHolder, Color.green);	
									

								}
							}	
						});
						flipVerticalP4.addActionListener(new ActionListener() { 	
							
							@Override
							public void actionPerformed(ActionEvent e ) {
								
								if(e.getSource()==flipVerticalP4) {
									block4 = blocksTools.getFVPiece(block4,  playerFourBlockHolder, Color.green);	
									

								}
							}	
						});
			 
			      
			    }
			    
			   });
		   
		  boolean endGame = false; 
		 
		for(int i=0; i<25; i++) { 
			for(int j=0; j<30; j++) { 
				
				if(RPTest[i][j].getBackground()==Color.WHITE){
					endGame = false; 
				}
				else 
				{ 
					endGame = true; 
					i=25; 
					j=30; 
				}
						
			}
		}
		
		if(endGame==true) { 
			gameOverFrame.setVisible(true);
		}
	    passP2.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e ) {
	
				playerTwoTestButton.doClick(1);
			counter3=0;	
			}

		});
	    
	    passP3.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e ) {
	
				playerThreeTestButton.doClick(1);}

		});
	    
	    passP4.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e ) {
	
				playerFourTestButton.doClick(1);}

		});
	    
	    passP1.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e ) {
	
				playerOneTestButton.doClick(1);}

		});
		if(endGame==true) { 
			JFrame endFrame = new JFrame(); 
			endFrame.setBackground(Color.pink);
			endFrame.setVisible(true);
		}

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
		
	
		blokusFrame.add(boardPanel,frameLayout.CENTER); 
		menuBarJPanel.add(menuBarJLabel); 
		blokusFrame.add(menuBarJPanel, frameLayout.NORTH); 
		
		Integer save_value[] = new Integer[21]; 
       
		
		playerOnePanel.add(mirrorP1);
		playerOnePanel.add(rotateLP1);
		playerOnePanel.add(flipVerticalP1);
		playerOnePanel.add(playerOneHolder);
		playerOneHolder.setPreferredSize(new Dimension(350,250));
		playerOneHolder.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		playerOneHolder.add(nextP1, BorderLayout.EAST);
		playerOneHolder.add(prevP1, BorderLayout.WEST);
		
		
		playerOnePanel.add(p1Score);
		playerTwoPanel.add(playerTwoButton); 
		playerTwoPanel.add(p2Score);
		playerThreePanel.add(playerThreeButton); 
		playerThreePanel.add(p3Score);
		playerFourPanel.add(playerFourButton);
		playerFourPanel.add(p4Score);
		
		playerTwoPanel.add(mirrorP2);
		playerTwoPanel.add(rotateLP2);
		playerTwoPanel.add(flipVerticalP2);
		playerTwoPanel.add(playerTwoHolder);
		playerTwoHolder.setPreferredSize(new Dimension(350,250));
		playerTwoHolder.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		playerTwoHolder.add(nextP2, BorderLayout.EAST);
		playerTwoHolder.add(prevP2, BorderLayout.WEST);

		playerThreePanel.add(mirrorP3);
		playerThreePanel.add(rotateLP3);
		playerThreePanel.add(flipVerticalP3);
		playerThreePanel.add(playerThreeHolder);
		playerThreeHolder.setPreferredSize(new Dimension(350,250));
		playerThreeHolder.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		playerThreeHolder.add(nextP3, BorderLayout.EAST);
		playerThreeHolder.add(prevP3, BorderLayout.WEST);
		
		
		playerFourPanel.add(mirrorP4);
		playerFourPanel.add(rotateLP4);
		playerFourPanel.add(playerFourHolder);
		playerFourPanel.add(flipVerticalP4);
		playerFourHolder.setPreferredSize(new Dimension(350,250));
		playerFourHolder.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		playerFourHolder.add(nextP4, BorderLayout.EAST);
		playerFourHolder.add(prevP4, BorderLayout.WEST);

		
		}
		
		 public int scoring(JButton[][] grid, JLabel p1Score, int score, Color color) {
				
				
			
			  for(int i=0 ; i<30; i++) { 
				  for(int j=0; j<30; j++) {
					  if(i<=26 &&  j<=26 && i>=3 && j>=3 ) {
						  
						  if(grid[i][j].getBackground()==color) {
							 score++; 
							 
							 
						  }
					  }
				  }
			  }
				  
					
			    p1Score.setText("SCORE  :" + score);
			    return score;
		  }
		 
		 
		

		
}