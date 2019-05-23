
package classes;

import java.util.ArrayList;

/**
 *
 * @author SaraPdrui
 */
public class Game {
    
    private String name; //name of the game
    private MainCharacter character;//
    private ArrayList<Actions> story;//point of the story
    private int index;// index that points the point of the story
    

    
    
    
    
    public Game() {
		super();
		
		this.story = new ArrayList<Actions>();
	}
    /**
     * Constructor of Game class
     * @param nombre
     * @param character
     * @param actions
     * @param story
     * @param index
     */
	public Game(String name, MainCharacter character, ArrayList<Actions> story, int index) {
		super();
		this.name = name;
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



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
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
