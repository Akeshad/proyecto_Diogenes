
package screen;


import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

import javax.swing.*;
import java.awt.*;



//sound + file opening
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sound.sampled.*;

import classes.Argument;
import classes.MainCharacter;
import classes.Message;
import classes.Philosopher;
import classes.Sequence;
import classes.Argument.Type1;
import classes.Argument.Type2;
import classes.ConnectionBD;
import classes.Fight;
import classes.Game;
import components.ButtonsMenu;
import exceptions.LenghtArgumentException;
import exceptions.LenghtCharacterArgumentException;
import exceptions.NameException;

import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author SaraPdrui
 */
public class MenuScreen extends JPanel{

	private Window w;//Window 
	private Game game; // Game
	private ConnectionBD conn; //Game connection

	public MenuScreen(Window w) {
		
		
		
		this.conn = new ConnectionBD();
		//--------------JBUTTONS CONFIGURATION-------------------
		ButtonsMenu newGame = new ButtonsMenu("Nueva Partida");
		
		newGame.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Philosopher descartes = null;
				MainCharacter diogenes = null;
				game = new Game();
				
				
				
				
				
				//------------ADD PHILOSOPHER ARGUMENTS-----------------
				Argument argumento0 = new Argument("Escopeta", "la verdad no se encuentra en la Naturaleza", (byte)1,(byte)0,
						Type1.DUALISTA, Type2.MECANICISTA);

				Argument argumento1 = new Argument("Cuchillo", "La verdad se encuentra en el interior del individuo", (byte)2,(byte)0,
						Type1.DUALISTA, Type2.MECANICISTA);

				Argument argumento2 = new Argument("Hacha", "Los sentidos nos han engañado ciertas\r\n" + 
						"veces. Bastará con que nos hayan engañado una sola vez para no fiarnos de ellos", (byte)3,(byte)0,
						Type1.DUALISTA, Type2.MECANICISTA);

				Argument argumento4 = new Argument("Tanque del Dualismo", "Dios todo lo puede", (byte)7,(byte)0,
						Type1.DUALISTA, Type2.MECANICISTA);
				Argument argumento5 = new Argument("Subfusil evidente", "No debemos admitir jamás como verdadera cosa\r\n" + 
						"alguna sin saber con evidencia que lo era…”", (byte)6,(byte)0,
						Type1.DUALISTA, Type2.MECANICISTA);

				//------------ADD PHILOSOPHER ARRAYLIST ARGUMENTS-----------------
				ArrayList<Argument> argumentoL = new ArrayList<Argument>();
				argumentoL.add(argumento0);
				argumentoL.add(argumento1);
				argumentoL.add(argumento2);
				argumentoL.add(argumento4);

				//------------ADD MAIN CHARACTER ARGUMENTS-----------------
				Argument argumentoP0 = new Argument("Espada", "La naturaleza es, en primer lugar, el conjunto o totalidad de los seres del \n" + 
						"universo, en ella está la verdad", (byte)1,(byte)0,
						Type1.DUALISTA, Type2.MONISTA);

				Argument argumentoP2 = new Argument("Cabezaso Dividno", ".El universo es un todo ordenado o cosmos, los hombres pueden leer sus leyes, basta con observar la naturaleza", (byte)3,(byte)0,
						Type1.DUALISTA, Type2.MONISTA);

				Argument argumentoP3 = new Argument("Calcetín sucio", "Te voy a matar", (byte)4,(byte)0,
						Type1.DUALISTA, Type2.MONISTA);

				//------------ADD MAIN CHARACTER ARRAYLIST ARGUMENTS-----------------
				ArrayList<Argument> argumentoLP = new ArrayList<Argument>();
				argumentoLP.add(argumentoP0);
				argumentoLP.add(argumentoP2);
				argumentoLP.add(argumentoP3);

				//------------ADD  PHILOSOPHER AND MAIN CHARACTER-----------------
				try {
					
					
					diogenes = new MainCharacter("Diogenes", argumentoLP);
					game.setCharacter(diogenes);
					

					Sequence sequence = new Sequence();
					sequence.getMessages().add(new Message("C:\\GIT\\proyecto_Diogenes\\img\\fondo1.png", "Creo que ya ha bebido suficiente, es hora de que vayamos a descansar",1000));
					sequence.getMessages().add(new Message("C:\\GIT\\proyecto_Diogenes\\img\\fondo1.png", "Nooooooo",1000));
					game.getStory().add(sequence);

					descartes = new Philosopher("Decartes", argumentoL);
					Fight fight = new Fight(descartes);
					game.getStory().add(fight);
					
					sequence = new Sequence();
					game.getStory().add(sequence);
					
					
					
					conn.saveGame(game);
					
				} catch (LenghtCharacterArgumentException e) {

					e.printStackTrace();
				} catch (NameException e) {

					e.printStackTrace();
				} catch (LenghtArgumentException e) {

					e.printStackTrace();
				}

				w.setGame(game);
				w.transition();
			}
		});
		setLayout(null);
		add(newGame);		
		
		
		ButtonsMenu loadGame = new ButtonsMenu("Cargar Partida");
		loadGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Game game = conn.loadGame();
				game.setIndex(game.getIndex() - 1);
				w.setGame(game);
				w.transition();
			}
		});
		loadGame.setBounds(480, 581, 180, 50);
		loadGame.setHorizontalTextPosition(SwingConstants.CENTER);
		add(loadGame);
		
		//--------------JLABEL CONFIGURATION-------------------
		JLabel iconoMenuP = new JLabel("");
		iconoMenuP.setIcon(new ImageIcon("C:\\GIT\\proyecto_Diogenes\\img\\icono1.png"));
		iconoMenuP.setBounds(223, 141, 536, 386);
		add(iconoMenuP);
		
		JLabel fondoMenuP = new JLabel("");
		fondoMenuP.setBounds(0, 0, 1280, 700);
		fondoMenuP.setIcon(new ImageIcon("C:\\GIT\\proyecto_Diogenes\\img\\fondo1.png"));
		add(fondoMenuP);
		setVisible(true);

	}
	
	


}
