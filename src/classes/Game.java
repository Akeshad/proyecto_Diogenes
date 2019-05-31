
package classes;

import java.util.ArrayList;

/**
 *
 * @author SaraPdrui
 */
public class Game {
    
    private MainCharacter character;//
    private ArrayList<Actions> story;//point of the story
    private int index;// index that points the point of the story
    

    
    
    
    /**
     * Empty constructor of this class
     */
    public Game() {
		super();
		this.index = -1;
		this.story = new ArrayList<Actions>();
	}
    /**
     * Constructor of Game class
     * @param character
     * @param actions
     * @param story
     * @param index
     */
	public Game(MainCharacter character, ArrayList<Actions> story, int index) {
		super();
		this.character = character;
		this.story = story;	
		this.index = index;
	}



	public int getIndex() {
		return index;
	}



	public void setIndex(int index) {
		this.index = index;
	}


	public MainCharacter getCharacter() {
		return character;
	}



	public void setCharacter(MainCharacter character) {
		this.character = character;
	}

	
	public ArrayList<Actions> getStory() {
		return story;
	}
    
    
    
}//End
