/*
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;
import java.util.Random;

import exceptions.LenghtArgumentException;
import exceptions.LenghtCharacterArgumentException;
import exceptions.NameException;

/**
 *
 * @author SaraPdrui
 */
public class Philosopher {
     private String name; // Philosopher´s name 
     private ArrayList<Argument> arguments = new ArrayList<Argument>();// Philosopher´s arguments 
     private int timesLost;
     private String linkImage;
     

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
    
    
    public Philosopher() {
		super();
		
	}
    
    
    /**
     * Returns a name
     * @return name
     */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets a philosopher name
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
	 * returns a philosopher argument
	 * @return
	 */
	public ArrayList<Argument> getArguments() {
		return arguments;
	}
	
	/**
	 * sets a philosopher argument
	 * @param arguments
	 * @throws LenghtCharacterArgumentException 
	 * @throws LenghtArgumentException 
	 */
	public void setArguments(ArrayList<Argument> arguments) throws LenghtArgumentException {
		if (arguments.size()<=4) {
			this.arguments = arguments;
		}else {
			throw new LenghtArgumentException("You cannot introduce more than 5 arguments");
		}

	}
	
	/**
	 *  returns how many times has a philosopher lost
	 * @return timesLost
	 */
	   public int getTimesLost() {
			return timesLost;
		}

	   /**
	    * sets how many times has a philosopher lost
	    * @param timesLost
	    */
		public void setTimesLost(int timesLost) {
			this.timesLost = timesLost;
		}
	
		
		/**
		 * Function that returns a random argument
		 * @return Argument
		 */
		public  Argument getRdArgument() {
			Random rd = new Random();
			ArrayList<Argument> argumentsLs = this.getArguments();

			return argumentsLs.get(rd.nextInt(argumentsLs.size()));	
		}

	/**
	 * This function calculate the best argument for a fight
	 * @param Argument
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