package classes;

public class Message {
	String link;//Link of an image
	String txt;//Text of narration
	int ms;// mili second of image text changer 

	public Message() {
		
	}
	/**
	 * Principal constructor of this class
	 * @param link
	 * @param txt
	 * @param ms
	 */
	public Message(String link, String txt, int ms) {
		super();
		this.link = link;
		this.txt = txt;
		this.ms = ms;
	}
	
	/**
	 * Returns a link
	 * @return link
	 */
	public String getLink() {
		return link;
	}
	
	/**
	 * sets a link
	 * @param link
	 */
	public void setLink(String link) {
		this.link = link;
	}
	
	/**
	 *  Returns a text
	 * @return txt
	 */
	public String getTxt() {
		return txt;
	}
	
	/**
	 * sets a txt
	 * @param txt
	 */
	public void setTxt(String txt) {
		this.txt = txt;
	}
	
	/**
	 * Returns a time ms
	 * @return ms
	 */
	public int getMs() {
		return ms;
	}
	
	/**
	 * sets  a time ms
	 * @param ms
	 */
	public void setMs(int ms) {
		this.ms = ms;
	}
}
