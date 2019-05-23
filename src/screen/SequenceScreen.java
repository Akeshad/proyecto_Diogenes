package screen;

import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.Timer;

import classes.Message;
import classes.Sequence;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SequenceScreen extends JPanel{

	private Window w;
	private JLabel backgroundImage;
	private JTextPane textBox;
	private Sequence sequence;

	public SequenceScreen(Window w) {
		super();
		this.w = w;
		setLayout(null);
		
		JButton nextButton = new JButton("Saltar Intro");
		nextButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				w.transition();
			}
		});
		nextButton.setBackground(new Color(153, 204, 255));
		nextButton.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
		nextButton.setBounds(1100, 625, 102, 50);
		add(nextButton);
		
		this.textBox = new JTextPane();
		textBox.setFont(new Font("Malgun Gothic", Font.PLAIN, 24));
		textBox.setText("Un día cualquiera en la antigua Hélade...");
		textBox.setBackground(new Color(255, 204, 102));
		textBox.setBounds(0, 581, 1100, 94);
		add(textBox);
		
		this.backgroundImage = new JLabel("");
		backgroundImage.setIcon(new ImageIcon("C:\\GIT\\proyecto_Diogenes\\img\\fondo1.png"));
		backgroundImage.setBounds(0, 0, 1200, 700);
		add(backgroundImage);		
		
	}
	
	
	public void loadNextSequence(Sequence sequence) {
		 ArrayList<Message> messages = sequence.getMessages();
		 
		 for (int i = 0; i < messages.size(); i++) {
			Message messageShow = messages.get(i);
			new Thread(new ImageTextChanger(this, this.backgroundImage, this.textBox, messageShow.getLink(), messageShow.getTxt(), messageShow.getMs())).start();
		}
		
		//new Thread(new ImageTextChanger(this, this.backgroundImage, this.textBox, sequence.getLink(), sequence.getTxt(), sequence.getMs())).start();
		
		//hacer un nuevo hilo al final que dure más que todo y cambiar el texto de saltar intro
		}
	
	
	public void secondSequence() {
		new Thread(new ImageTextChanger(this, this.backgroundImage, this.textBox, "C:\\GIT\\proyecto_Diogenes\\img\\icono1.png", "-Te he dicho que Platón es un pamplinas, se nota que procede de la alta cuna...¡Hip! \n"
				+ "-Creo que ha bebido demasiado, vayamos a dormir y ya mañana vamos a tirarle fruta al Ágora"
				+ "",8000)).start();
		new Thread(new ImageTextChanger(this, this.backgroundImage, this.textBox, "C:\\GIT\\proyecto_Diogenes\\img\\fondo1.png", "Creo que ya ha bebido suficiente, es hora de que vayamos a descansar",16000)).start();
	}
	
}



	


	 

