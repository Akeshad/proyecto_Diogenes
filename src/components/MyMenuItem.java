package components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

import screen.Window;

public class MyMenuItem extends JMenuItem{
	
	public MyMenuItem(String txt) {
		super(txt);
		this.setFont(new Font("Dialog", Font.PLAIN, 19));		
		this.setBackground(new Color(255, 215, 0));
	}
}
