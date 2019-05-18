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

import javax.swing.JLabel;
import javax.swing.JEditorPane;

import java.awt.Color;
import javax.swing.ImageIcon;

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
			Philosopher descartes = new Philosopher("Decartes", argumentoL);
			MainCharacter diogenes = new MainCharacter("Diogenes", argumentoLP);


			//------------ADD EDITORPANE-----------------

			JEditorPane editorPane = new JEditorPane();
			editorPane.setBackground(Color.BLACK);
			editorPane.setEditable(false);
			editorPane.setForeground(Color.WHITE);
			editorPane.setFont(new Font("Malgun Gothic", Font.PLAIN, 19));
			editorPane.setBounds(0, 500, 1200, 120);
			editorPane.setText(argumento1.toString());
			add(editorPane);

			//------------ADD ARGUMENT PANEL-----------------
			JPanel argumentPanel = new JPanel();
			argumentPanel.setBounds(0, 620, 1200, 48);
			add(argumentPanel);
			argumentPanel.setLayout(new GridLayout(1, argumentoLP.size()));
			argumentPanel.add(argumentoP0);
			argumentPanel.add(argumentoP2);
			argumentPanel.add(argumentoP3);

			//ArrayList args=this.ventana.getJugador().getArgumentos()
			//for(i=0; i<args.size()
			//	panelArgumentos.add(comp)

			//------------ADD JLABEL BACKGROUND-----------------
			JLabel imagenLabel = new JLabel("");
			imagenLabel.setIcon(new ImageIcon("C:\\GIT\\proyecto_Diogenes\\img\\fondo1.png"));
			imagenLabel.setBounds(0, 0, 1200, 800);
			add(imagenLabel);

		} catch (LenghtCharacterArgumentException e) {

			e.printStackTrace();
		} catch (NameException e) {

			e.printStackTrace();
		} catch (LenghtArgumentException e) {

			e.printStackTrace();
		}



	}
}
