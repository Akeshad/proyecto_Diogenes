package screen;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class ImageTextChanger implements Runnable{
	private SequenceScreen ss;//An SequenceScreen
	private JLabel backGround;//A Jlabel that is going to be the background
	private JTextPane textBox;//A JTextPane that is going to be the place where the dialogue will be shows 
	private String link;//the link of the background image
	private String txt;//the text of the dialoge
	private int ms;//the milisecond that is going to be a thread in the screen

	/**
	 * Principal constructor of this class
	 * @param ss
	 * @param backGround
	 * @param textBox
	 * @param link
	 * @param txt
	 * @param ms
	 */
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
