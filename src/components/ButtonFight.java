package components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class ButtonFight extends JButton {
	public ButtonFight(String txt) {
		super(txt);
		this.setBackground(new Color(153, 204, 255));
		this.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
	}
}
