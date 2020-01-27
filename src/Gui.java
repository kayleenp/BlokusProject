import javax.swing.JFrame;
import javax.swing.JPanel;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

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

public class Gui {
	public static void main(String[] args) {
		new Gui();
	}
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
		JButton playerTwoButton = new JButton("Player Two"); 
		JButton playerThreeButton = new JButton("Player Three"); 
		JButton playerFourButton = new JButton("Player Four");
		
		BorderLayout panelLayoutWest  = new BorderLayout(); 
		BorderLayout panelLayoutEast  = new BorderLayout(); 
		
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
		
		//BLOCKS HOLDER
		playerOnePanel.setPreferredSize(new Dimension(1000,400));
		playerOnePanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
		playerOnePanel.add(playerOneHolder);
		
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
		
	
		
		}
}



		