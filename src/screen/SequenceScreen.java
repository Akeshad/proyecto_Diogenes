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

	public SequenceScreen(Window w) {
		super();
		this.w = w;
		setLayout(null);
		
		JButton nextButton = new JButton("Siguiente");
		nextButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				w.loadFightScreen();
			}
		});
		nextButton.setBackground(new Color(153, 204, 255));
		nextButton.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
		nextButton.setBounds(1100, 625, 102, 50);
		add(nextButton);
		
		JTextPane textBox = new JTextPane();
		textBox.setText("Buenos días");
		textBox.setBackground(new Color(255, 204, 102));
		textBox.setBounds(0, 625, 1100, 50);
		add(textBox);
		
		JLabel backgroundImage = new JLabel("");
		backgroundImage.setIcon(new ImageIcon("C:\\GIT\\proyecto_Diogenes\\img\\fondo1.png"));
		backgroundImage.setBounds(0, 0, 1200, 700);
		add(backgroundImage);

		new Thread(new ImageTextChanger(this, backgroundImage, textBox, "\\img\\icono1.png", "Hola de nuevo",2000)).start();
		new Thread(new ImageTextChanger(this, backgroundImage, textBox, "\\img\\fondo1.png", "Ñeñeñeñeñe",2000)).start();
		
		
	}
	
}



	


	 

