package screen;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class ImageTextChanger implements Runnable{
	private SequenceScreen ss;
	private JLabel backGround;
	private JTextPane textBox;
	private String link;
	private String txt;
	private int ms;

	public ImageTextChanger(SequenceScreen ss,JLabel backGround,JTextPane textBox,String link, String txt,int ms) {
		this.ss=ss;
		this.backGround=backGround;
		this.textBox = textBox;
		this.link = link;
		this.txt = txt;
		this.ms = ms;


	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {

			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		backGround.setIcon(new ImageIcon(link));
		backGround.repaint();
		textBox.setText(txt);
		textBox.repaint();
		ss.repaint();

	}

}
