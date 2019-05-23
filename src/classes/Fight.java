package classes;

public class Fight extends Actions {

	private Philosopher philosopher; // philosopher 

	public Fight() {
		super();
	}
	
	public Fight(Philosopher philosopher) {
		this();
		this.philosopher = philosopher;
	}

	public Philosopher getPhilosopher() {
		return philosopher;
	}

	public void setPhilosopher(Philosopher philosopher) {
		this.philosopher = philosopher;
	}
	
}
