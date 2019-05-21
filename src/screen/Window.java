package screen;


import javax.swing.*;

import classes.Argument;
import classes.Game;
import classes.MainCharacter;
import classes.Philosopher;
import java.awt.Font;
import java.awt.Color;

import components.MyMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Window extends JFrame {

	private CreditsScreen creditsScreen;//Credits JPanel 
	private MenuScreen menuScreen;//Menu JPanel 
	private Argument philosopherBest;
	private SequenceScreen sequenceScreen;///Game's sequence JPanel 
	private FightScreen fightScreen;//Fight event JPanel 
	private CreationScreen creationScreen;
	private Game game;
	private MainCharacter mainCharacter;
	private Philosopher philosopher;


	public Window() {
		super();
		//mainCharacter = new MainCharacter();
		menuScreen = new MenuScreen(this);
		creationScreen = new CreationScreen(this);
		fightScreen = new FightScreen(this);

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
		MyMenuItem saveMenu = new MyMenuItem("Guardar Partida");
		saveMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		saveMenu.setIcon(new ImageIcon(Window.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		optionMenu.add(saveMenu);

		MyMenuItem backMenu = new MyMenuItem("Men\u00FA Principal");
		backMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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

	public void transition() {

	}
	
	
	//--------------SEQUENCESCREEN CONFIGURATION-------------------
	
	public void loadSequenceScreen() {
		sequenceScreen = new SequenceScreen(this);
		this.menuScreen.setVisible(false);
		this.sequenceScreen.setVisible(true);
		this.setContentPane(this.sequenceScreen);

	}

	public void loadFightScreen() {

		this.fightScreen.setPhilosopher(philosopher);
		this.fightScreen.setMainCharacter(mainCharacter);
		this.fightScreen.initArgument();
		this.sequenceScreen.setVisible(false);
		this.fightScreen.setVisible(true);
		this.setContentPane(this.fightScreen);


	}



	//--------------GETTERS AND SETTERS-------------------
	public CreditsScreen getCreditsScreen() {
		return creditsScreen;
	}

	public void setCreditsScreen(CreditsScreen creditsScreen) {
		this.creditsScreen = creditsScreen;
	}

	public MenuScreen getMenuScreen() {
		return menuScreen;
	}

	public void setMenuScreen(MenuScreen menuScreen) {
		this.menuScreen = menuScreen;
	}

	public CreationScreen getCreationScreen() {
		return creationScreen;
	}

	public void setCreationScreen(CreationScreen creationScreen) {
		this.creationScreen = creationScreen;
	}

	public SequenceScreen getSequenceScreen() {
		return sequenceScreen;
	}

	public void setSequenceScreen(SequenceScreen sequenceScreen) {
		this.sequenceScreen = sequenceScreen;
	}

	public FightScreen getFightScreen() {
		return fightScreen;
	}

	public void setFightScreen(FightScreen fightScreen) {
		this.fightScreen = fightScreen;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public MainCharacter getMainCharacter() {
		return mainCharacter;
	}

	public void setMainCharacter(MainCharacter mainCharacter) {
		this.mainCharacter = mainCharacter;
	}

	public Philosopher getPhilosopher() {
		return philosopher;

	}

	public void setPhilosopher(Philosopher philosopher) {
		this.philosopher = philosopher;
	}



}
