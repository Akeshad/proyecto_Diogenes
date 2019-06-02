package components;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class ButtonsMenu extends JButton {
	public ButtonsMenu(String txt) {
		super(txt);
		
		this.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		this.setBounds(480, 480, 180, 50);
		this.setHorizontalTextPosition(SwingConstants.CENTER);
		this.setForeground(new Color(0, 0, 0));
		this.setFont(new Font("Malgun Gothic", Font.PLAIN, 22));
		this.setBackground(new Color(255, 215, 0));
	}
}
