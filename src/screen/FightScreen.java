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
import java.awt.GridLayout;


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
		
		JPanel panelArgumentos = new JPanel();
		panelArgumentos.setBounds(0, 0, 10, 10);
		add(panelArgumentos);
		panelArgumentos.setLayout(new GridLayout(1, 0, 0, 0));
		//ArrayList args=this.ventana.getJugador().getArgumentos()
		//for(i=0; i<args.size()
			//	panelArgumentos.add(comp)
		JLabel imagenLabel = new JLabel("");
		imagenLabel.setIcon(new ImageIcon("C:\\GIT\\proyecto_Diogenes\\img\\fondo1.png"));
		imagenLabel.setBounds(0, 0, 450, 300);
		add(imagenLabel);
		
		
		
	}
}
