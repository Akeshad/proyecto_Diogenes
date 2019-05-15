package components;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.DebugGraphics;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class MenuPrincipal extends JMenuItem {
	public MenuPrincipal(String txt){
		super(txt);
		this.setFont(new Font("Verdana", Font.PLAIN, 17));
		this.setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.setAlignmentY(Component.TOP_ALIGNMENT);
		this.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.setHorizontalAlignment(SwingConstants.LEFT);
	}
}
