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
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;


public class FightScreen extends JPanel{
	private Window w;//Window of the app
	private Philosopher philosopher;// A philosopher 
	private MainCharacter mainCharacter;// A mainCharacter
	private JPanel argumentPanel; // Panel that will have the arguments of the mainCharacter as buttons
	private JTextArea editorPane; // Editor pane will have the arguments of the philosopher
	private Argument philosopherBest; //Philosopher Arguments
    private JTextPane diogenesText; // represents the arguments that are chosen in a textPane

    
    /**
     * Main constructor of the class
     * @param w
     */
	public FightScreen(Window w) {
		super();
		setLayout(null);	
		this.w = w;
	
		JLabel descartes = new JLabel("");
		descartes.setIcon(new ImageIcon("C:\\GIT\\proyecto_Diogenes\\img\\descartes.png"));
		descartes.setBounds(830, 20, 900, 300);
		add(descartes);
		
		JLabel diogenes = new JLabel("");
		diogenes.setIcon(new ImageIcon("C:\\GIT\\proyecto_Diogenes\\img\\diogenes.png"));
		diogenes.setBounds(10, 200, 400, 300);
		add(diogenes);
		
		this.diogenesText = new JTextPane();
		diogenesText.setBackground(new Color(255, 255, 153));
		diogenesText.setBounds(220, 150, 250, 150);
		diogenesText.setEditable(false);
		add(diogenesText);



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



		//------------ADD JLABEL BACKGROUND-----------------
		JLabel imagenLabel = new JLabel("");
		imagenLabel.setIcon(new ImageIcon("C:\\GIT\\proyecto_Diogenes\\img\\fondo1.png"));
		imagenLabel.setBounds(0, 0, 1200, 800);
		add(imagenLabel);
	}
	
	/**
	 * Function that will manage the Fight
	 */
	
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
						
						diogenesText.setText(characterArgument.getText());
						try {			
							Argument winner = MainCharacter.winnerArgument(philosopherBest, characterArgument);

							ArrayList<Argument> philosopherArguments = philosopher.getArguments();
							
							if (!arguments.contains(winner)) {
								mainCharacter.setTimesLost(mainCharacter.getTimesLost() + 1);
								characterArgument.setTimesLost(characterArgument.getTimesLost() + 1);
							} else if (!(philosopherArguments.contains(winner))) {
								philosopher.setTimesLost(philosopher.getTimesLost() + 1);
								philosopherBest.setTimesLost(philosopherBest.getTimesLost() + 1);
								 File archivo = new File("./hasPerdido.txt");
								 String perdido = "Has perdido";
							        archivo.createNewFile();
							        FileWriter writer = new FileWriter(archivo);
							        writer.write(perdido);
							        writer.flush();
							        writer.close();
							} else {
								throw new NotFoundArgumentException("Ha habido un error en la batalla");
							}
						} catch (TypeException ex) {
							ex.printStackTrace();
						} catch (NotFoundArgumentException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						
					}
				}
				
				//---------END OF THE FIGHT---------------------
				if (philosopher.getTimesLost() >= 5) {
					
					editorPane.setText("Hurrita");
					JOptionPane.showMessageDialog(w, "Hurrita");
					w.transition();
				} else if(mainCharacter.getTimesLost() >= 5) {
					
					//-------------- EXCHANGE OF ARGUMENTS-------------------
					for (int i = 0; i < arguments.size(); i++) {
						Argument argumentLoser = arguments.get(i);
						if(argumentLoser.getTimesLost() >= 2) {
							Argument philosopherA = philosopher.getRdArgument();
							arguments.remove(argumentLoser);
							arguments.add(i, philosopherA);
							
						}
					}
					JOptionPane.showMessageDialog(w, "Mecachis");
					w.transition();
				} else {
					philosopherBest = philosopher.getRdArgument();
					editorPane.setText(philosopherBest.getText());
				}
			}
		};

		//------------------------INTRODUCING BUTTONS-----------------------
		for (int i = 0; i < arguments.size(); i++) {
			Argument argument = arguments.get(i);

			JButton argumentButton = new JButton(argument.getWeapon());
			argumentButton.setActionCommand(argument.getWeapon());
			argumentButton.addActionListener(myListener);

			argumentPanel.add(argumentButton);
		}

	}
	
	//----------------GETTERS AND SETTERS----------------------
	
	
	/**
	 * returns a philosopher
	 * @return philosopher
	 */
	
	public Philosopher getPhilosopher() {
		return philosopher;
	}
	
	/**
	 * sets a philosopher
	 * @param philosopher
	 */

	public void setPhilosopher(Philosopher philosopher) {
		this.philosopher = philosopher;
	}

	/**
	 * returns a mainCharacter
	 * @return mainCharacter
	 */
	public MainCharacter getMainCharacter() {
		return mainCharacter;
	}
	
	/**
	 * sets a mainCharacter
	 * @param mainCharacter
	 */

	public void setMainCharacter(MainCharacter mainCharacter) {
		this.mainCharacter = mainCharacter;
	}
}
