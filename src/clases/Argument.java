
package clases;

/**
 *
 * @author SaraPdrui
 * this class represents an argument that is used by one philosopher
 */
public final class Argument {
    
   private String weapon;//String que recoge el nombre de un argumento, este hombre corresponder√° a un arma
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

	/**
	 * 
	 * @param strength
	 */
	public void setStrength(byte strength) {
		this.strength = strength;
	}
    
  
}//End of the class M¡S ADELANTE QUITAREMOS LOS SETTER, PARA QUE NO SE LE PUEDA METER NADA 
//TAMBIEN, SI EL ENUM ES NULL, NO SE PUEDE METER ARGUMENTOS