package components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Background  extends JLabel{
	
	private String txt;
	
	public Background( String txt) {
		super(txt);
		this.setBackground(new Color(153, 204, 255));
		this.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
		this.setBounds(0, 0, 1280, 700);
		this.setIcon(new ImageIcon(txt));
		setVisible(true);
	}
}

