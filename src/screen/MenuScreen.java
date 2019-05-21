
package screen;


import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

import javax.swing.*;
import java.awt.*;



//sound + file opening
import java.io.*;
import java.util.ArrayList;

import javax.sound.sampled.*;

import classes.Argument;
import classes.MainCharacter;
import classes.Philosopher;
import classes.Argument.Type1;
import classes.Argument.Type2;
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

	public MenuScreen(Window w) {
		
		
		//--------------JBUTTONS CONFIGURATION-------------------
		ButtonsMenu newGame = new ButtonsMenu("Nueva Partida");
		
		newGame.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Philosopher descartes = null;
				MainCharacter diogenes = null;
				
				//------------ADD PHILOSOPHER ARGUMENTS-----------------
				Argument argumento0 = new Argument("Escopeta", "Eres Feo", (byte)1,(byte)0,
						Type1.DUALISTA, Type2.MECANICISTA);

				Argument argumento1 = new Argument("Cuchillo", "Eres un gato", (byte)2,(byte)0,
						Type1.DUALISTA, Type2.MECANICISTA);

				Argument argumento2 = new Argument("Hacha", "Las Salchichas son buenas", (byte)3,(byte)0,
						Type1.DUALISTA, Type2.MECANICISTA);

				Argument argumento4 = new Argument("Tanque del Dualismo", "Dios todo lo puede", (byte)7,(byte)0,
						Type1.DUALISTA, Type2.MECANICISTA);

				//------------ADD PHILOSOPHER ARRAYLIST ARGUMENTS-----------------
				ArrayList<Argument> argumentoL = new ArrayList<Argument>();
				argumentoL.add(argumento0);
				argumentoL.add(argumento1);
				argumentoL.add(argumento2);
				argumentoL.add(argumento4);

				//------------ADD MAIN CHARACTER ARGUMENTS-----------------
				Argument argumentoP0 = new Argument("Espada", "Eres Feo", (byte)1,(byte)0,
						Type1.DUALISTA, Type2.MONISTA);

				Argument argumentoP2 = new Argument("Cabezaso Dividno", "Las Salchichas son buenas", (byte)3,(byte)0,
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
					descartes = new Philosopher("Decartes", argumentoL);
					diogenes = new MainCharacter("Diogenes", argumentoLP);
					w.setMainCharacter(diogenes);
					w.setPhilosopher(descartes);

				} catch (LenghtCharacterArgumentException e) {

					e.printStackTrace();
				} catch (NameException e) {

					e.printStackTrace();
				} catch (LenghtArgumentException e) {

					e.printStackTrace();
				}

				w.loadSequenceScreen();
			}
		});
		setLayout(null);
		add(newGame);		
		
		
		ButtonsMenu loadGame = new ButtonsMenu("Cargar Partida");
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
