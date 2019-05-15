/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

import exceptions.LenghtArgumentException;
import exceptions.LenghtCharacterArgumentException;
import exceptions.NameException;

/**
 *
 * @author SaraPdrui
 */
public class Philosopher {
     protected static String name; // Philosopher´s name 
     protected static ArrayList<Argument> arguments = new ArrayList<Argument>();// Philosopher´s arguments 
	
    
    /**
     * 
     * @param name
     * @param arguments
     * @throws LenghtCharacterArgumentException 
     * @throws NameException 
     * @throws LenghtArgumentException 
     */
    public Philosopher(String name, ArrayList<Argument> arguments) throws LenghtCharacterArgumentException, NameException, LenghtArgumentException {
		super();
		this.setName(name);
		this.setArguments(arguments);
	}
    
    /**
     * 
     * @return
     */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @param name
	 * @throws NameException 
	 */
	public void setName(String name) throws NameException {
		if(name != null) {
			this.name = name;
		}else {
			throw new NameException("You have to introduce a name");
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Argument> getArguments() {
		return arguments;
	}
	
	/**
	 * 
	 * @param arguments
	 * @throws LenghtCharacterArgumentException 
	 * @throws LenghtArgumentException 
	 */
	public void setArguments(ArrayList<Argument> arguments) throws LenghtCharacterArgumentException, LenghtArgumentException {
		if (arguments.size()<=4) {
			this.arguments = arguments;
		}else {
			throw new LenghtArgumentException("You cannot introduce more than 5 arguments");
		}

	}
    
	//LUCHAR()
	
	/**
	 * This function calculate the best argument for a fight
	 * @param argument
	 */
	/*public void useBestArgument(ArrayList<Argumento> argument) {

		for (int i = 0; i < argumento.size(); i++) {

			byte arg = argumento.get(i).getFuerza();
			
			si el mejor argumento ha perdido dos veces usar el mejor siguiente
		}

	}*/
    
    
    
    
}