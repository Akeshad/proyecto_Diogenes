package classes;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import screen.SequenceScreen;
import screen.Window;

public class Sequence  extends Actions{

	ArrayList<Message> messages = new ArrayList<Message>();
	
	public Sequence() {
		super();
	}

	public ArrayList<Message> getMessages() {
		return messages;
	}


}
