
package screen;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import classes.Argument;
import classes.MainCharacter;
import classes.Message;
import classes.Philosopher;
import classes.Sequence;
import classes.Argument.Type1;
import classes.Argument.Type2;
import classes.ConnectionBD;
import classes.Fight;
import classes.Game;
import components.ButtonsMenu;
import exceptions.LenghtArgumentException;
import exceptions.LenghtCharacterArgumentException;
import exceptions.NameException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author SaraPdrui
 */
public class MenuScreen extends JPanel{

	private Game game; // Game
	private ConnectionBD conn; //Game connection
	public static final File gameMusic = new File("./audio/SolveThePuzzle.wav");//This file contains the music of the game

	public MenuScreen(Window w) {
		 soundON();
		this.conn = new ConnectionBD();
		//--------------JBUTTONS CONFIGURATION-------------------
		ButtonsMenu newGame = new ButtonsMenu("Nueva Partida");

		newGame.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				Philosopher descartes = null;
				MainCharacter diogenes = null;
				Philosopher skinner = null;
				game = new Game();


				//------------ADD PHILOSOPHER DESCARTES ARGUMENTS-----------------
				Argument argumentoD0 = new Argument("Escopeta", "la verdad no se encuentra en la Naturaleza", (byte)1,(byte)0,
						Type1.DUALISTA, Type2.MECANICISTA);

				Argument argumentoD1 = new Argument("Cuchillo", "La verdad se encuentra en el interior del individuo", (byte)2,(byte)0,
						Type1.DUALISTA, Type2.MECANICISTA);

				Argument argumentoD2 = new Argument("Hacha", "Los sentidos nos han enga�ado ciertas\r\n" + 
						"veces. Bastar� con que nos hayan enga�ado una sola vez para no fiarnos de ellos", (byte)3,(byte)0,
						Type1.DUALISTA, Type2.MECANICISTA);

				Argument argumentoD4 = new Argument("Tanque del Dualismo", "Dios todo lo puede", (byte)7,(byte)0,
						Type1.DUALISTA, Type2.MECANICISTA);
			

				//------------ADD PHILOSOPHER DESCARTES ARRAYLIST ARGUMENTS-----------------
				ArrayList<Argument> argumentoL = new ArrayList<Argument>();
				argumentoL.add(argumentoD0);
				argumentoL.add(argumentoD1);
				argumentoL.add(argumentoD2);
				argumentoL.add(argumentoD4);


				//------------ADD PHILOSOPHER SKYNNER ARGUMENTS-----------------
				Argument argumentoS0 = new Argument("Radio asesina", "Todo aquello que necesitamos conocer est� en el exterior", (byte)2,(byte)0,
						Type1.MATERIALISTA, Type2.CONDUCTISTA);

				Argument argumentoS1 = new Argument("Atropellar", "Esa filosof�a es rancia y depende de un Dios no demostrable", (byte)2,(byte)0,
						Type1.MATERIALISTA, Type2.CONDUCTISTA);

				Argument argumentoS2 = new Argument("Franco Tirador", "El interior del individuo no nos dice nada de �l\r\n" + 
						"Para saber qu� es lo que piensa debemos observar su comportamiento", (byte)8,(byte)0,
						Type1.MATERIALISTA, Type2.CONDUCTISTA);

				Argument argumentoS4 = new Argument("Subfusil desestimador", "Los perror de Pablov son la clave, tronco", (byte)7,(byte)0,
						Type1.MATERIALISTA, Type2.CONDUCTISTA);


				//------------ADD PHILOSOPHER SKYNNER ARRAYLIST ARGUMENTS-----------------
				ArrayList<Argument> argumentoSL = new ArrayList<Argument>();
				argumentoSL.add(argumentoS0);
				argumentoSL.add(argumentoS1);
				argumentoSL.add(argumentoS2);
				argumentoSL.add(argumentoS4);


				//------------ADD MAIN CHARACTER ARGUMENTS-----------------
				Argument argumentoP0 = new Argument("Espada", "La naturaleza es, en primer lugar, el conjunto o totalidad de los seres del \n" + 
						"universo, en ella est� la verdad", (byte)1,(byte)0,
						Type1.DUALISTA, Type2.MONISTA);

				Argument argumentoP2 = new Argument("Cabezaso Divino", ".El universo es un todo ordenado o cosmos, los hombres pueden leer sus leyes, basta con observar la naturaleza", (byte)3,(byte)0,
						Type1.DUALISTA, Type2.MONISTA);

				Argument argumentoP3 = new Argument("Calcet�n sucio", "Te voy a matar", (byte)3,(byte)0,
						Type1.DUALISTA, Type2.MONISTA);

				//------------ADD MAIN CHARACTER ARRAYLIST ARGUMENTS-----------------
				ArrayList<Argument> argumentoLP = new ArrayList<Argument>();
				argumentoLP.add(argumentoP0);
				argumentoLP.add(argumentoP2);
				argumentoLP.add(argumentoP3);

				//------------ADD  PHILOSOPHER AND MAIN CHARACTER-----------------
				try {


					diogenes = new MainCharacter("Diogenes", argumentoLP, "./img/diogenes.png");
					game.setCharacter(diogenes);


					Sequence sequence = new Sequence();
					sequence.getMessages().add(new Message("./img/tr1.jpg", "DI�GENES --\nQue te he dicho que Plat�n es un pamplinoso... �Hip!",5000));
					sequence.getMessages().add(new Message("./img/tr1.jpg", "DISC�PULO --\nCreo que ya ha bebido suficiente, es hora de que vayamos a descansar",10000));
					sequence.getMessages().add(new Message("./img/tr1.jpg", "DI�GENES --\nNo me digas lo que tengo que hacer... �Hip!",15000));
					sequence.getMessages().add(new Message("./img/tr1.jpg", "DIOGENES --\nTrae m�s vino, que ma�ana vamos a darle pal pelo en el �gora a ese idealista fantasm�n",20000));
					sequence.getMessages().add(new Message("./img/tr4.jpg", "Al d�a siguiente...",25000));
					sequence.getMessages().add(new Message("./img/tr5.jpg", "DIOGENES --\n...",30000));
					sequence.getMessages().add(new Message("./img/tr6.jpg", "DIOGENES --\n�D�nde demonios estoy?",33000));
					sequence.getMessages().add(new Message("./img/tr5.jpg", "DIOGENES --\nParece que ayer beb� demasiado, maldito Antinoo, no volver� a engatusarme con ese vino espartano",36000));
					sequence.getMessages().add(new Message("./img/tr7.jpg", "Tres horas m�s tarde",39500));
					sequence.getMessages().add(new Message("./img/tr7.jpg", "DIOGENES --\nMaldita sea, �pero que llevaba ese vino?",42000));
					sequence.getMessages().add(new Message("./img/tr8.jpg", "DIOGENES --\nParece que hay alguien andando en el camino, a ver si sabe d�nde est� la ciudad",46000));
					sequence.getMessages().add(new Message("./img/tr8.jpg", "DI�GENES --\n�Buenos d�as! �Sabes por d�nde se va a Atenas? Llevo perdido horas y este maldito bosque cada vez es m�s grande",51000));
					sequence.getMessages().add(new Message("./img/tr9.jpg", "DESCARTES --\nBuegnos d�as, buen hombre. No se donde est�, de hecho llevo horas pegdido sin sabeg d�nde estoy",55000));
					sequence.getMessages().add(new Message("./img/tr9.jpg", "DIOGENES --\nVaya, entonces los dos estamos jodidos. Lo peor es que tengo bastante hambre, si al menos encontr�semos comida...",58000));
					sequence.getMessages().add(new Message("./img/tr9.jpg", "DESCARTES --\nMonsieur, yo tengo pan y queso si quieres podemos sentarnos y de paso te cuento los pensamientos que he estado desarrollando",62000));
					sequence.getMessages().add(new Message("./img/tr9.jpg", "DESCARTES --\nHe escgito un libgo llamado La M�taphysique, y me muego de ganas pog compagtig mis pensamientos",66000));
					sequence.getMessages().add(new Message("./img/tr9.jpg", "DIOGENES --\n�Parece que este d�a va a ser bueno despu�s de todo, conversermos mi buen amigo!",70000));
					sequence.getMessages().add(new Message("./img/tr10.png", " ",73000));
					sequence.getMessages().add(new Message("./img/tr11.png", " ",76000));
					sequence.getMessages().add(new Message("./img/tr12.png", " ",80000));
					sequence.getMessages().add(new Message("./img/tr13.jpg", "�CONOCEG�S MI IGAAAAA! ",84000));
					game.getStory().add(sequence);

					descartes = new Philosopher("Descartes", argumentoL, "./img/descartes.png");
					Fight fight = new Fight(descartes);
					game.getStory().add(fight);

					Sequence sequence2 = new Sequence();//This second sequence does not work, because of
					// this I did not created more sequence. The problem is that this sequence is mixed
					//with the firts one. 

					sequence2.getMessages().add(new Message(" ", "DIOGENES --\n�Qu� acaba de ocurrir? Me siento un poco raro, algo ha cambiado en mi... ",5000));
					sequence2.getMessages().add(new Message(" ", "DIOGENES --\nEs como si ya no supiese qu� creer, espero volver pronto a casa para hablar con mis disc�pulos ",10000));
					sequence2.getMessages().add(new Message(" ", "DIOGENES --\nAdem�s, no quiero volver a encontrarme con ese tipo de antes, es incluso m�s pesado que Plat�n ",15000));
					sequence2.getMessages().add(new Message(" ", "SKINER --\n�Espere!, �Necesito ayuda!",84000));
					sequence2.getMessages().add(new Message(" ", "�CONOCEG�S MI IGAAAAA! ",84000));
					game.getStory().add(sequence2);
					
					//Second and last battle
					skinner = new Philosopher("Skinner", argumentoSL, "./img/skinner.png");
					Fight fight2 = new Fight(skinner);
					game.getStory().add(fight2);

					conn.saveGame(game);

				} catch (NameException| LenghtArgumentException  e) {

					e.printStackTrace();
				}
				
				//We create the game
				w.setGame(game);
				//we call the function that manage the transitions of screen
				w.transition();
			}
		});
		setLayout(null);
		add(newGame);		


		ButtonsMenu loadGame = new ButtonsMenu("Cargar Partida");
		loadGame.addMouseListener(new MouseAdapter() {
			
			/**
			 * This function get the game
			 */
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Game game = conn.loadGame();
				game.setIndex(game.getIndex() - 1);
				w.setGame(game);
				w.transition();
			}
		});
		loadGame.setBounds(480, 581, 180, 50);
		loadGame.setHorizontalTextPosition(SwingConstants.CENTER);
		add(loadGame);

		//--------------JLABEL CONFIGURATION-------------------
		JLabel iconoMenuP = new JLabel("");
		iconoMenuP.setIcon(new ImageIcon(".\\img\\icono1.png"));
		iconoMenuP.setBounds(223, 141, 536, 386);
		add(iconoMenuP);

		JLabel fondoMenuP = new JLabel("");
		fondoMenuP.setBounds(0, 0, 1280, 700);
		fondoMenuP.setIcon(new ImageIcon(".\\img\\fondo1.png"));
		add(fondoMenuP);
		setVisible(true);

	}

	
	/**
	 * Function that will play the sound in a loop for the game
	 */
	public static void soundON() {
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(gameMusic); 
			AudioFormat format = audioStream.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format); // 
			Clip music = (Clip)AudioSystem.getLine(info);
			music.open(audioStream);
			music.start();
			int loop = music.LOOP_CONTINUOUSLY;
			music.loop(loop);

		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e ) {
			e.printStackTrace();

		}

	}
}
