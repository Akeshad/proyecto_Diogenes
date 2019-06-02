
package classes;

import java.util.ArrayList;
import java.util.Random;

import classes.Argument.Type1;
import classes.Argument.Type2;
import exceptions.LenghtArgumentException;
import exceptions.LenghtCharacterArgumentException;
import exceptions.NameException;
import exceptions.NotFoundArgumentException;
import exceptions.TypeException;

/**
 *
 * @author SaraPdrui
 */
public class MainCharacter extends Philosopher {


	
	public MainCharacter() {
		super();
	}
	/**
	 * Principal constructor of this class
	 * @param name
	 * @param arguments
	 * @throws LenghtCharacterArgumentException
	 * @throws NameException
	 * @throws LenghtArgumentException
	 */
	public MainCharacter(String name, ArrayList<Argument> arguments, String linkImage) throws LenghtCharacterArgumentException, NameException, LenghtArgumentException {
		super(name, arguments,linkImage);
	}
	
	
	/**
	 * Sets an argument
	 */
	@Override
	public void setArguments(ArrayList<Argument> arguments) throws LenghtArgumentException, LenghtCharacterArgumentException {
		if (arguments.size()<=3) {
			super.setArguments(arguments);
			
		} else {
			throw new LenghtCharacterArgumentException("You cannot introduce more than 4 arguments");
		}

	}
	
	/**
	 * Function that established witch is the winner argument 
	 * @param p
	 * @param m
	 * @return Argument
	 * @throws TypeException
	 */
	public static Argument winnerArgument(Argument p, Argument m) throws TypeException {

		if(p.getStrength() > m.getStrength()) {
			return p;
		}else if(p.getStrength() < m.getStrength()){
			return m;			
		}else if(type1Strenght(p.getType1()) > type1Strenght(m.getType1())){
			return p;
		}else if(type1Strenght(p.getType1()) < type1Strenght(m.getType1())){
			return m;
		}else if(type2Strenght(p.getType2()) > type2Strenght(m.getType2())){
			return p;
		}else if(type2Strenght(p.getType2()) < type2Strenght(m.getType2())){
			return m;

			//if everything fails, we throw a coin
		}else {
			Random rd = new Random();
			boolean resultado = rd.nextBoolean();

			if(resultado) {
				return p;
			}else {
				return m;
			}
		}
	}

	/**
	 * Function that established a witch is the strongest Type1
	 * @param tp
	 * @return int
	 * @throws TypeException
	 */

	public static int type1Strenght(Type1 tp) throws TypeException {
		switch (tp) {
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

	public static int type2Strenght(Type2 tp) throws TypeException {
		switch (tp) {
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


	public void descartarArgumento() {

	}



}
