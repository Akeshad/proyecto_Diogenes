package screen;


import javax.swing.*;

import classes.Actions;
import classes.ConnectionBD;
import classes.Fight;
import classes.Game;
import classes.Sequence;
import java.awt.Font;
import java.awt.Color;
import components.MyMenuItem;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;


public class Window extends JFrame {

	private CreditsScreen creditsScreen;//Credits JPanel 
	private MenuScreen menuScreen;//Menu JPanel 
	private SequenceScreen sequenceScreen;///Game's sequence JPanel 
	private FightScreen fightScreen;//Fight event JPanel 
	private Game game;//Game 
	private ConnectionBD conn;

	
	/**
	 * Principal constructor of this class
	 */
	public Window() {
		super();
		menuScreen = new MenuScreen(this);
		fightScreen = new FightScreen(this);
		sequenceScreen = new SequenceScreen(this);
		this.conn = new ConnectionBD();

		//--------------WINDOWS CONFIGURATION-------------------
		setTitle("Bizarre Adventures ");//
		setSize(1200, 700);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);//
		setUndecorated(true);//
		this.setContentPane(menuScreen);


		//--------------JMENUBAR CONFIGURATION-------------------
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 215, 0));
		menuBar.setForeground(new Color(255, 215, 0));
		setJMenuBar(menuBar);


		//--------------JMENU CONFIGURATION-------------------
		JMenu optionMenu = new JMenu("Opciones");
		optionMenu.setBackground(new Color(255, 215, 0));
		optionMenu.setFont(new Font("Dialog", Font.PLAIN, 16));
		menuBar.add(optionMenu);


		//--------------JMENUITEM CONFIGURATION-------------------
		//------------------------------------------------------
						//------SAVING GAME-------
		MyMenuItem saveMenu = new MyMenuItem("Guardar Partida");
		saveMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conn.saveGame(game);
		 
					//---CREATE A FILE WRITER OF THE SAVED GAME---
				File file = new File("./partidaGuardada.txt");
				String saved = "Partida guardada";
				
				try {
					file.createNewFile();
					FileWriter writer = new FileWriter(file);
					writer.write(saved);
					writer.flush();
					writer.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		});
		saveMenu.setIcon(new ImageIcon(Window.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		optionMenu.add(saveMenu);

		MyMenuItem backMenu = new MyMenuItem("Men\u00FA Principal");
		backMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadMenuScreen();
			}
		});;
		backMenu.setIcon(new ImageIcon(Window.class.getResource("/javax/swing/plaf/metal/icons/ocean/homeFolder.gif")));
		optionMenu.add(backMenu);

		MyMenuItem exitMenu = new MyMenuItem("Salir del Juego");
		exitMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				System.exit(EXIT_ON_CLOSE);				
			}
		});
		exitMenu.setIcon(new ImageIcon(Window.class.getResource("/javax/swing/plaf/metal/icons/ocean/close-pressed.gif")));
		optionMenu.add(exitMenu);
		this.setVisible(true);

	}





	//--------------TRANSITION CONFIGURATION-------------------
	/**
	 * This function does a transitions of the screens
	 */
	public void transition() {		

		int index = this.game.getIndex();
		index++;
		game.setIndex(index);

		if(index >= this.game.getStory().size()) {
			System.exit(EXIT_ON_CLOSE);			
		}else {
			Actions action = this.game.getStory().get(index);
			if(action instanceof Sequence ) {
				Sequence seq = (Sequence) action;
				loadSequenceScreen(seq);
			}else if(action instanceof Fight){
				Fight fig = (Fight) action;
				loadFightScreen(fig);
			}
		}
	}


	//--------------SEQUENCESCREEN CONFIGURATION-------------------

	/**
	 * Function that load a Sequence Screen
	 * @param sequence
	 */
	public void loadSequenceScreen(Sequence sequence) {

		if(this.menuScreen != null) {
			this.sequenceScreen.loadNextSequence(sequence);
			this.menuScreen.setVisible(false);

		}else if(this.fightScreen != null ) {
			this.sequenceScreen.loadNextSequence(sequence);
			this.fightScreen.setVisible(false);

		}

		this.sequenceScreen.setVisible(true);
		this.setContentPane(this.sequenceScreen);

	}
	
	
	/**
	 * Function that load a Fight Screen
	 * @param fight
	 */
	public void loadFightScreen(Fight fight) {
		if(this.menuScreen != null) {
			this.menuScreen.setVisible(false);

		} else if(this.sequenceScreen != null ) {
			this.sequenceScreen.setVisible(false);
		}
		
		this.fightScreen.setPhilosopher(fight.getPhilosopher());
		this.fightScreen.setMainCharacter(game.getCharacter());
		this.fightScreen.initArgument();
		this.sequenceScreen.setVisible(false);
		this.fightScreen.setVisible(true);
		this.setContentPane(this.fightScreen);
	}
	
	/**
	 * This function loads a menu Screen
	 */
	public void loadMenuScreen() {
		if(this.fightScreen != null) {
			this.fightScreen.setVisible(false);

		} else if(this.sequenceScreen != null ) {
			this.sequenceScreen.setVisible(false);
		}
		
		this.menuScreen.setVisible(true);
		this.setContentPane(this.menuScreen);
	}



	//--------------GETTERS AND SETTERS-------------------
	/**
	 *  returns a creditsScreen
	 * @return creditsScreen
	 */
	public CreditsScreen getCreditsScreen() {
		return creditsScreen;
	}

	public void setCreditsScreen(CreditsScreen creditsScreen) {
		this.creditsScreen = creditsScreen;
	}

	/**
	 * returns a creditsScreen
	 * @return
	 */
	public MenuScreen getMenuScreen() {
		return menuScreen;
	}

	public void setMenuScreen(MenuScreen menuScreen) {
		this.menuScreen = menuScreen;
	}



	/**
	 * returns a SequenceScreen
	 * @return
	 */
	public SequenceScreen getSequenceScreen() {
		return sequenceScreen;
	}

	/**
	 * 
	 * @param sequenceScreen
	 */
	public void setSequenceScreen(SequenceScreen sequenceScreen) {
		this.sequenceScreen = sequenceScreen;
	}

	/**
	 * returns a fightScreen
	 * @return
	 */
	public FightScreen getFightScreen() {
		return fightScreen;
	}
	
	/**
	 * 
	 * @param fightScreen
	 */
	public void setFightScreen(FightScreen fightScreen) {
		this.fightScreen = fightScreen;
	}
	
	/**
	 * returns a game
	 * @return
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * 
	 * @param game
	 */
	public void setGame(Game game) {
		this.game = game;
	}



}//End class
