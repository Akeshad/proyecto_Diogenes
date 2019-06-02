
package classes;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author SaraPdrui
 * this class represents an argument that is used by one philosopher
 */
public final class Argument{
    
   private String weapon;//Name of a weapon
   private String text;//Text of the argument
   private byte strength;// strength of the argument
   private int timesLost; // times that the argument has lost
   private Type1 type1;//represents one argument´s principal type
   private Type2 type2; //represents one argument´s sub-type
   
/**
 */
  public enum Type1{
        MATERIALISTA,
        DUALISTA
        
    };
  
  
  public enum Type2{
        NATURALISTA,
        ELIMINATIVO,
        FUNCIONALISTA,
        MONISTA,
        MECANICISTA,
        IDENTIDAD,
        CONDUCTISTA
    };
    
    
    public Argument() {
    	
    }
   
    /**
     * Constructor of this Argument class
     * @param weapon
     * @param text
     * @param strength
     * @param timesLost
     * @param type1
     * @param type2
     */
    
    public Argument(String weapon, String text, byte strength, byte timesLost, Type1 type1, Type2 type2) {
		this.weapon = weapon;
		this.text = text;
		this.strength = strength;
		this.timesLost = timesLost;
		this.type1 = type1;
		this.type2 = type2;
	}
   
    /**
     * returns a type1
     * @return type1
     */
    public Type1 getType1() {
        return type1;
    }
    
   

	/**
     * 
     * @param sets a type1 
     */
    public void setType1(Type1 type1) {
        this.type1 = type1;
    }
    
    /**
     * sets a type2
     * @param type2 
     */
    public void setType2(Type2 type2) {
        this.type2 = type2;
    }
    
    /**
     * retuns a tyoe2 
     * @return type2
     */
    public Type2 getType2() {
        return type2;
    }
    
    /**
     * retuns a weapon
     * @return weapon
     */
	public String getWeapon() {
		return weapon;
	}
	/**
	 * sets a weapon
	 * @param weapon
	 */
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	/**
	 * returns a text
	 * @return text
	 */
	public String getText() {
		return text;
	}

	/**
	 * sets a text
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * gets how many times has lost an argument
	 * @return timesLost
	 */
	public int getTimesLost() {
		return timesLost;
	}
	/**
	 * sets how many times has lost an argument
	 * @param timesLost
	 */
	public void setTimesLost(int timesLost) {
		this.timesLost = timesLost;
	}

	/**
	 * gets the strength of an argument
	 * @return strength
	 */
	public byte getStrength() {
		return strength;
	}

	/**
	 * sets the strength of an argument
	 * @param strength
	 */
	public void setStrength(byte strength) {
		this.strength = strength;
	}
	
	
    
  
}//End of the class 