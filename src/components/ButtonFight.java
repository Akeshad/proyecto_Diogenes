package components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class ButtonFight extends JButton {
	public ButtonFight(String txt) {
		super(txt);
		this.setForeground(new Color(0, 0, 0));
		this.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		this.setBackground(new Color(255, 215, 0));
	}
}
