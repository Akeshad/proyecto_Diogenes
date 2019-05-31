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

	private Window w;//A window
	private JLabel backgroundImage;//The image of the background of this screen
	private JTextPane textBox;// A text box for the messages

	/**
	 * Principal constructor of this class
	 * @param w
	 */
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
	
	/**
	 * Load the next Sequence
	 * @param sequence
	 */
	public void loadNextSequence(Sequence sequence) {
		 ArrayList<Message> messages = sequence.getMessages();
		 
		 for (int i = 0; i < messages.size(); i++) {
			Message messageShow = messages.get(i);
			new Thread(new ImageTextChanger(this, this.backgroundImage, this.textBox, messageShow.getLink(), messageShow.getTxt(), messageShow.getMs())).start();
		}
		
		}
	
	
}



	


	 

