
package classes;

import javax.swing.JButton;

import classes.Argument.Type1;
import classes.Argument.Type2;
import exceptions.TypeException;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 *
 * @author SaraPdrui
 * this class represents an argument that is used by one philosopher
 */
public final class Argument{
    
   private String weapon;//String que recoge el nombre de un argumento, este hombre corresponderá a un arma
   private String text;//String que recoge el contenido del argumento
   private byte strength;
   private byte timesLost; // 
   private Type1 type1;//enum que representa una etiqueta de una corriente de pensamiento principal
   private Type2 type2; // enum que representa una etiqueta de una corriente de pensamiento secundaria
   
   
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
    
	/**
	 * Function that established a witch is the strongest Type1
	 * @param tp
	 * @return int
	 * @throws TypeException
	 */

	public  int type1Strenght() throws TypeException {
		switch (this.type1) {
		case DUALISTA:
			return 0;
		case MATERIALISTA:
			return 1;
		default:
			throw new TypeException("Tipo no reconocido");
		}
	}

	/**
	 * Function that established a witch is the strongest Type2 
	 * @param tp
	 * @return int
	 * @throws TypeException
	 */

	public  int type2Strenght() throws TypeException {
		switch (this.type2) {
		case MONISTA:
			return 0;
		case MECANICISTA:
			return 1;
		case CONDUCTISTA:
			return 2;
		case FUNCIONALISTA:
			return 3;
		case IDENTIDAD:
			return 4;
		case ELIMINATIVO:
			return 5;
		case NATURALISTA:
			return 6;
		default:
			throw new TypeException("Tipo no reconocido");
		}
	}


  
    /**
     * Principal constructor de la clase Argumento
     * @param arma String 
     * @param text String 
     * @param corriente1 
     * @param corriente2 
     */
   
   
   
    /**
     * Devuelve un enum TipoArgumentoPrincipal
     * @return type1
     */
    public Type1 getType1() {
        return type1;
    }
    
    public Argument(String weapon, String text, byte strength, byte timesLost, Type1 type1, Type2 type2) {
		super();
		this.weapon = weapon;
		this.text = text;
		this.strength = strength;
		this.timesLost = timesLost;
		this.type1 = type1;
		this.type2 = type2;		
	}

	/**
     * 
     * @param type1 
     */
    public void setType1(Type1 type1) {
        this.type1 = type1;
    }
    
    /**
     * Devuelve un String arma
     * @return type2
     */
    public Type2 getType2() {
        return type2;
    }
    
    /**
     * Devuelve un String arma
     * @param type2 
     */
    public void setType2(Type2 type2) {
        this.type2 = type2;
    }

    /**
     * 
     * @return
     */
	public String getWeapon() {
		return weapon;
	}
	/**
	 * 
	 * @param weapon
	 */
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	/**
	 * 
	 * @return
	 */
	public String getText() {
		return text;
	}

	/**
	 * 
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * 
	 * @return
	 */
	public byte getStrength() {
		return strength;
	}
	
	public boolean beats(Argument r) throws TypeException {

		if(this.strength >strength) {
			return true;
		}else if(strength < r.strength){
			return false;			
		}else if(this.type1Strenght() > r.type1Strenght()){
			return true;
		}else if(type1Strenght() < r.type1Strenght()){
			return false;
		}else if(type2Strenght() > r.type2Strenght()){
			return true;
		}else if(type2Strenght() < r.type2Strenght()){
			return false;

			//if everything fails, we throw a coin
		}else {
			Random rd = new Random();
			boolean resultado = rd.nextBoolean();

			if(resultado) {
				return true;
			}
				return false;
			
		}
	}

	/**
	 * 
	 * @param strength
	 */
	public void setStrength(byte strength) {
		this.strength = strength;
	}
	
	
    
  
}//End of the class 