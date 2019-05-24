package classes;
/**
 * 
 * @author SaraPdrui
 * This class represents the information of the fight screen
 *
 */
public class Fight extends Actions {

	private Philosopher philosopher; // philosopher that will appear in the fight screen

	/**
	 * Main constructor of the class	
	 */
	public Fight() {
		super();
	}
	
	/**
	 * Constructor of the class that asks for a philosopher
	 * @param philosopher
	 */
	public Fight(Philosopher philosopher) {
		this();
		this.philosopher = philosopher;
	}

	/**
	 * returns a philosopher
	 * @return philosopher
	 */
	public Philosopher getPhilosopher() {
		return philosopher;
	}

	/**
	 * sets a philosopher
	 * @param philosopher
	 */
	public void setPhilosopher(Philosopher philosopher) {
		this.philosopher = philosopher;
	}
	
}
