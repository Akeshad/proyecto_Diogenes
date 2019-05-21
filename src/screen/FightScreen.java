package screen;

import java.util.ArrayList;
import javax.swing.JPanel;

import classes.Argument;
import classes.MainCharacter;
import classes.Philosopher;
import classes.Argument.Type1;
import classes.Argument.Type2;
import exceptions.LenghtArgumentException;
import exceptions.LenghtCharacterArgumentException;
import exceptions.NameException;
import exceptions.NotFoundArgumentException;
import exceptions.TypeException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JEditorPane;

import java.awt.Color;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;


public class FightScreen extends JPanel{
	private Window w;
	private Philosopher philosopher;//
	private MainCharacter mainCharacter;//
	private JPanel argumentPanel;
	private JTextArea editorPane;
	private Argument philosopherBest;


	public FightScreen(Window w) {
		super();
		setLayout(null);	



		//------------ADD EDITORPANE-----------------

		this.editorPane = new JTextArea();
		editorPane.setBackground(Color.BLACK);
		editorPane.setEditable(false);
		editorPane.setForeground(Color.WHITE);
		editorPane.setFont(new Font("Malgun Gothic", Font.PLAIN, 19));
		editorPane.setBounds(0, 500, 1200, 120);
		//editorPane.setText(argumento1.getText());
		add(editorPane);

		//------------ADD ARGUMENT PANEL-----------------
		this.argumentPanel = new JPanel();
		argumentPanel.setBounds(0, 620, 1200, 48);
		add(argumentPanel);		
		//argumentPanel.setLayout(new GridLayout(1, argumentoLP.size()));



		//------------ADD JLABEL BACKGROUND-----------------
		JLabel imagenLabel = new JLabel("");
		imagenLabel.setIcon(new ImageIcon("C:\\GIT\\proyecto_Diogenes\\img\\fondo1.png"));
		imagenLabel.setBounds(0, 0, 1200, 800);
		add(imagenLabel);
	}
	
	public void initArgument() {
		
		ArrayList<Argument> arguments = mainCharacter.getArguments();
		
		philosopherBest = philosopher.getRdArgument();
		
		editorPane.setText(philosopherBest.getText());

		ActionListener myListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for	(int i = 0; i < arguments.size(); i++) {
					Argument characterArgument = arguments.get(i);

					if (e.getActionCommand() == characterArgument.getWeapon()) {
						
						try {			
							Argument winner = MainCharacter.winnerArgument(philosopherBest, characterArgument);

							ArrayList<Argument> philosopherArguments = philosopher.getArguments();
							
							if (!arguments.contains(winner)) {
								mainCharacter.setTimesLost(mainCharacter.getTimesLost() + 1);
							} else if (!(philosopherArguments.contains(winner))) {
								philosopher.setTimesLost(philosopher.getTimesLost() + 1);
							} else {
								throw new NotFoundArgumentException("Ha habido un error en la batalla");
							}
						} catch (TypeException ex) {
							ex.printStackTrace();
						} catch (NotFoundArgumentException e1) {
							e1.printStackTrace();
						}

						if (philosopher.getTimesLost() >= 5) {
							editorPane.setText("Hurrita");
							JOptionPane.showMessageDialog(w, "Hurrita");
							//pasar siguiente pantalla
						} else if(mainCharacter.getTimesLost() >= 5) {
							JOptionPane.showMessageDialog(w, "Mecachis");
						} else {
							philosopherBest = philosopher.getRdArgument();
							editorPane.setText(philosopherBest.getText());
						}
					}
				}
			}
		};

		for (int i = 0; i < arguments.size(); i++) {
			Argument argument = arguments.get(i);

			JButton argumentButton = new JButton(argument.getWeapon());
			argumentButton.setActionCommand(argument.getWeapon());
			argumentButton.addActionListener(myListener);

			argumentPanel.add(argumentButton);
		}

	}
	
	//----------------
	
	public Philosopher getPhilosopher() {
		return philosopher;
	}

	public void setPhilosopher(Philosopher philosopher) {
		this.philosopher = philosopher;
	}

	public MainCharacter getMainCharacter() {
		return mainCharacter;
	}

	public void setMainCharacter(MainCharacter mainCharacter) {
		this.mainCharacter = mainCharacter;
	}
}
