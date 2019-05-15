/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;

import exceptions.LenghtArgumentException;
import exceptions.LenghtCharacterArgumentException;
import exceptions.NameException;

/**
 *
 * @author SaraPdrui
 */
public class Philosopher {
     protected String name; // Philosopher�s name 
     protected ArrayList<Argument> arguments = new ArrayList<Argument>();// Philosopher�s arguments 
     protected int timesLost;
     

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
	
	   public int getTimesLost() {
			return timesLost;
		}

		public void setTimesLost(int timesLost) {
			this.timesLost = timesLost;
		}
    
	
	
	/**
	 * This function calculate the best argument for a fight
	 * @param argument
	 */
	public Argument getBestArgument() {
		Argument max = null;
		for (int i = 0; i < arguments.size(); i++) {
			Argument arg = arguments.get(i);
			
			if (i == 0 || arg.getStrength() > max.getStrength()) {
				max = arg;
			}
		}
		return max;
	}
    
    
    
    
}