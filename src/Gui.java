import javax.swing.JFrame;
import java.util.Arrays;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicArrowButton;

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
	
	
	public Integer[][] block1= new Integer[5][5]; 
	public Integer[][] block2= new Integer[5][5]; 
	public Integer[][] block3= new Integer[5][5]; 
	public Integer[][] block4= new Integer[5][5]; 

	public Integer counter1 =1;
	public Integer counter2 =1; 
	public Integer counter3 =1; 
	public Integer counter4 =1;
	
	public int PLAYER_ONE = 1;
	public int PLAYER_TWO = 2; 
	public int PLAYER_THREE=3; 
	public int PLAYER_FOUR=4; 
	
	public boolean blockUsed1[] = new boolean[22]; 
	public boolean blockUsed2[] = new boolean[21]; 
	public boolean blockUsed3[] = new boolean[21]; 
	public boolean blockUsed4[] = new boolean[21]; 
	
    public Integer[][] blockTestIntegers = new Integer[30][30]; 
    public Integer[][] blockTestIntegers2 = new Integer[30][30]; 
	public int currentCounter = 1; 
	public int currentCounter2 = 1; 
	public JButton[][] boardGridValue = new JButton[30][30];
	public JButton[][] boardGridValue2 = new JButton[30][30];
	public BlockData getBlockData = new BlockData(); 
	public Board theBoard = new Board(); 
	private int counter = 0;
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
		JButton playerOneButton = new JButton("Choose Piece"); 
		playerOneButton.setPreferredSize(new Dimension(350,30));
		JButton playerTwoButton = new JButton("Choose Piece"); 
		playerTwoButton.setPreferredSize(new Dimension(350,30));
		JButton playerThreeButton = new JButton("Choose Piece"); 
		playerThreeButton.setPreferredSize(new Dimension(350,30));
		JButton playerFourButton = new JButton("Choose Piece");
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
		    JButton playerOneTestButton = new JButton ("Player 1");
		    JButton playerTwoTestButton = new JButton ("Player 2");
		    JButton playerThreeTestButton= new JButton ("Player 3");
		    JButton playerFourTestButton = new JButton ("Player 4");
		    playerOnePanel.add(nextTurnP2);
		    playerOnePanel.add(passP2);
		    playerTwoPanel.add(nextTurnP3);
		    playerTwoPanel.add(passP3);
		    playerThreePanel.add(nextTurnP4);
		    playerThreePanel.add(passP4);
		    playerFourPanel.add(nextTurnP1);
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
									 if(i>5 && j>5 && i<25 && j<25) {
									boardGridValue[i][j].setText("" + blockTestIntegers[i][j]);
										 }
									
									final int row=i; 
									final int col=j;
									
								  boardGridValue[i][j].addMouseListener(new java.awt.event.MouseAdapter() {
											public Color oldColor;
											
								 	   public void mouseClicked(MouseEvent evt) {
								 		   if(blockUsed1[counter1]==false) {
								 	   theBoard.gridClicked(evt, boardGridValue, blockTestIntegers, block1, 
								 			   Color.blue, row, col, PLAYER_ONE,  blockUsed1, counter1, nextP1);
								 	  // nextP1.doClick(); 
										 
								 	   System.out.println("BLOCK PLAYER 1 :" + counter1);
								 	   
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
						counter1++;
						if(counter1>21 ) {
							counter1=0;
						}
					if(blockUsed1[counter1]==false) {
						
							block1 = blocksTools.getPiece(block1, counter1, playerOneBlockHolder, Color.blue);
							
						  }
						
					else if(blockUsed1[counter1]==true) {
						counter1++;
						
						}
					
					
					
						
						 
							
							
						
						 System.out.println(counter1); 
						
						 
						
						
						//when grid is clicked 
					}}

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
					
				   }});
		    
		     
		 
		    
		     	
				
				
		    
		    
		    playerTwoTestButton.addActionListener(new ActionListener() {  
		    @Override
		    public void actionPerformed(ActionEvent e ) {
			   
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
								 if(i>5 && j>5 && i<25 && j<25) {
										boardGridValue[i][j].setText("" + blockTestIntegers[i][j]);
											 }
										
								
								
								final int row=i; 
								final int col=j;
								
							  boardGridValue[i][j].addMouseListener(new java.awt.event.MouseAdapter() {
										public Color oldColor;
										
							 	   public void mouseClicked(MouseEvent evt) {
							 	   theBoard.gridClicked(evt, boardGridValue, blockTestIntegers, block2, Color.RED, row, col, PLAYER_TWO,  blockUsed2, counter2, nextP2);
								 	  
							 	  
							 	  
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
						if(counter2>20) {
							counter2=1;
							  
							
						}
						else {
							{
								counter2++;
								 
							}
						}
						 System.out.println(counter2); 
						 block2 = blocksTools.getPiece(block2, counter2, playerTwoBlockHolder, Color.RED);
						
						//theBoard.gridClicked(boardPanel, boardGridValue, blockTestIntegers, block2, Color.RED);	
						}
					  } 
				});
				  rotateLP2.addActionListener(new ActionListener() { 	
						
						@Override
						public void actionPerformed(ActionEvent e ) {		
							if(e.getSource()==rotateLP2) {
							block2 = blocksTools.getRotatedPiece(block2,  playerTwoBlockHolder, Color.red);
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
		       
		    
		    }
		    
		   });
		    
		    playerThreeTestButton.addActionListener(new ActionListener() {  
			    @Override
			    public void actionPerformed(ActionEvent e ) {
				   
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
									 if(i>5 && j>5 && i<25 && j<25) {
											boardGridValue[i][j].setText("" + blockTestIntegers[i][j]);
												 }
											
									
									
									final int row=i; 
									final int col=j;
									
								  boardGridValue[i][j].addMouseListener(new java.awt.event.MouseAdapter() {
											public Color oldColor;
											
								 	   public void mouseClicked(MouseEvent evt) {
								 	   theBoard.gridClicked(evt, boardGridValue, blockTestIntegers, block3, Color.YELLOW, row, col, PLAYER_THREE,  blockUsed3, counter3, 
								 			  nextP3);
								 
								 	 
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
						  block3 = blocksTools.getPiece(block3, counter3, playerThreeBlockHolder, Color.yellow);

							counter3++; 
							if(counter3>21) {
								counter3=1;
								

							}
							//theBoard.gridClicked(boardPanel, boardGridValue, blockTestIntegers, block2, Color.RED);	
							}
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
			 
			      
			    }
			    
			   });
		   
		   nextTurnP3.addActionListener(new ActionListener() { 
		     @Override
		     public void actionPerformed(ActionEvent e ) {
		   
		  	
				nextP3.addActionListener(new ActionListener() { 
					@Override
					public void actionPerformed(ActionEvent e ) {
					if(e.getSource()==nextP3) {
					  block3= blocksTools.getPiece(block3, counter3, playerThreeBlockHolder, Color.yellow);

						counter3++; 
						if(counter3>21) {
							counter3=1;
						}
						
					//	theBoard.gridClicked(boardPanel, boardGridValue, blockTestIntegers, block3, Color.YELLOW);	 
						}
				

					  } 
				});
				  rotateLP3.addActionListener(new ActionListener() { 	
						
						@Override
						public void actionPerformed(ActionEvent e ) {		
							if(e.getSource()==rotateLP3) {
							block3 = blocksTools.getRotatedPiece(block3,  playerThreeBlockHolder, Color.yellow);
						//	theBoard.gridClicked(boardPanel, boardGridValue, blockTestIntegers, block3, Color.YELLOW);	 
						}}	
					});
					mirrorP3.addActionListener(new ActionListener() { 	
						
						@Override
						public void actionPerformed(ActionEvent e ) {
							
							if(e.getSource()==mirrorP3) {
								block3 = blocksTools.getFlippedPiece(block3,  playerThreeBlockHolder,  Color.yellow);	
						//		theBoard.gridClicked(boardPanel, boardGridValue, blockTestIntegers, block3, Color.YELLOW);	 
							}
						}	
					});
				 
		     }
		   });
		   playerFourTestButton.addActionListener(new ActionListener() {  
			    @Override
			    public void actionPerformed(ActionEvent e ) {
				   
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
									 if(i>5 && j>5 && i<25 && j<25) {
											boardGridValue[i][j].setText("" + blockTestIntegers[i][j]);
												 }
											
									
									
									final int row=i; 
									final int col=j;
									
								  boardGridValue[i][j].addMouseListener(new java.awt.event.MouseAdapter() {
											public Color oldColor;
											
								 	   public void mouseClicked(MouseEvent evt) {
								 	   theBoard.gridClicked(evt, boardGridValue, blockTestIntegers, block4, Color.GREEN, row, col, PLAYER_FOUR,  
								 			   blockUsed4, counter4, nextP4);
								 	   
									 
									   
									   
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
						  block4 = blocksTools.getPiece(block4, counter4, playerFourBlockHolder, Color.GREEN);

							counter4++; 
							if(counter4>21) {
								counter4=1;
								

							}
							//theBoard.gridClicked(boardPanel, boardGridValue, blockTestIntegers, block2, Color.RED);	
							}
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
			 
			      
			    }
			    
			   });
		   
		   
		

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