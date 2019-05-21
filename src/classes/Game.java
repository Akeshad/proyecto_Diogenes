
package classes;

import java.util.ArrayList;

/**
 *
 * @author SaraPdrui
 */
public class Game {
    
    private String nombre; //
    private MainCharacter personaje;//
    private Actions actions; 
    private ArrayList<Actions> index;
    
    
    
	public Game(String nombre, MainCharacter personaje, Actions actions, ArrayList<Actions> index) {
		super();
		this.nombre = nombre;
		this.personaje = personaje;
		this.actions = actions;
		this.index = index;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public MainCharacter getPersonaje() {
		return personaje;
	}



	public void setPersonaje(MainCharacter personaje) {
		this.personaje = personaje;
	}



	public Actions getActions() {
		return actions;
	}



	public void setActions(Actions actions) {
		this.actions = actions;
	}



	public ArrayList<Actions> getIndex() {
		return index;
	}



	public void setIndex(ArrayList<Actions> index) {
		this.index = index;
	}
    
    
    
    
}//Fin clase
