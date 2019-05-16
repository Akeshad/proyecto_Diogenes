package screen;

import java.util.ArrayList;
import javax.swing.JPanel;
import classes.MainCharacter;
import classes.Philosopher;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;


public class FightScreen extends JPanel{
	private Window w;
	private Philosopher philosopher;//
	private MainCharacter mainCharacter;//
	
	public FightScreen(Window w) {
		super();
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 450, 223);
		add(lblNewLabel);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(0, 224, 450, 36);
		add(textPane);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(0, 259, 450, 41);
		add(btnNewButton);
		
		
		
	}
}
