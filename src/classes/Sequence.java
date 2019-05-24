package classes;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import screen.SequenceScreen;
import screen.Window;
/**
 * 
 * @author SaraPdrui
 * This class represents the information of the sequence screen
 *
 */
public class Sequence  extends Actions{

	ArrayList<Message> messages = new ArrayList<Message>();//The messages and images that will appear in the sequence screen
	
	
	/**
	 * Main constructor of the class
	 */
	public Sequence() {
		super();
	}

	/**
	 * returns the messages
	 * @return messages
	 */
	public ArrayList<Message> getMessages() {
		return messages;
	}


}
