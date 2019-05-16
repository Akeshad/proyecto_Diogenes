
package screen;


import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.*;
import java.awt.*;



//sound + file opening
import java.io.*;
import javax.sound.sampled.*;
import com.jgoodies.forms.layout.FormSpecs;

import components.ButtonsMenu;

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

