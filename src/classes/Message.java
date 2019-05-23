package classes;

public class Message {
	String link;
	String txt;
	int ms;

	public Message(String link, String txt, int ms) {
		super();
		this.link = link;
		this.txt = txt;
		this.ms = ms;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getTxt() {
		return txt;
	}
	public void setTxt(String txt) {
		this.txt = txt;
	}
	public int getMs() {
		return ms;
	}
	public void setMs(int ms) {
		this.ms = ms;
	}
}
