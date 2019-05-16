package screen;

import java.util.ArrayList;
import javax.swing.JPanel;
import classes.MainCharacter;
import classes.Philosopher;
import components.ButtonFight;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class FightScreen extends JPanel{
	private Window w;
	private Philosopher philosopher;//
	private MainCharacter mainCharacter;//
	
	public FightScreen(Window w) {
		super();
		setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(new Color(255, 204, 51));
		textPane.setBounds(0, 225, 450, 27);
		add(textPane);
		
		ButtonFight argumento1 = new ButtonFight("Argumento1");
		argumento1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
			}
		});
		argumento1.setBounds(0, 255, 104, 45);
		add(argumento1);
		
		ButtonFight argumento2 = new ButtonFight("Argumento2");
		argumento2.setBounds(114, 255, 107, 45);
		add(argumento2);
		
		ButtonFight argumento3 = new ButtonFight("Argumento3");
		argumento3.setBounds(231, 255, 104, 45);
		add(argumento3);
		
		ButtonFight argumento4 = new ButtonFight("Argumento4");
		
		argumento4.setBounds(340, 255, 110, 45);
		add(argumento4);
		
		JLabel imagenLabel = new JLabel("");
		imagenLabel.setIcon(new ImageIcon("C:\\GIT\\proyecto_Diogenes\\img\\fondo1.png"));
		imagenLabel.setBounds(0, 0, 450, 300);
		add(imagenLabel);
		
		
		
	}
}
