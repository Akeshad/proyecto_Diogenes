
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


	public MainCharacter(String name, ArrayList<Argument> arguments) throws LenghtCharacterArgumentException, NameException, LenghtArgumentException {
		super(name, arguments);
	}


	@Override
	public void setArguments(ArrayList<Argument> arguments) throws LenghtCharacterArgumentException {
		if (arguments.size()<=3) {
			this.arguments = arguments;
		}else {
			throw new LenghtCharacterArgumentException("You cannot introduce more than 4 arguments");
		}

	}

	public static Philosopher fight(MainCharacter m, Philosopher p) throws NotFoundArgumentException {

		System.out.println("Esto es una prueba de la batalla por turnos");

		do {
			try {				
				Argument winner = winnerArgument(p.getBestArgument(), getArgument(m));


				ArrayList <Argument> argumentoFilosofo = p.getArguments();
				ArrayList <Argument> argumentoProta = m.getArguments();

				if(!argumentoProta.contains(winner)) {
					m.setTimesLost(m.getTimesLost() + 1);

				} else if(!(argumentoFilosofo.contains(winner))) {

					p.setTimesLost(p.getTimesLost() + 1);
				}else {
					throw new NotFoundArgumentException("Ha habido un error en la batalla");
				}

			} catch (TypeException e) {
				e.printStackTrace();
			}

		} while (p.getTimesLost() <= 4 && m.getTimesLost() <= 4);

		if(p.getTimesLost() >= 5) {
			return p;
		}else if(m.getTimesLost() >= 5) {
			return m;
		}else {
			throw new NotFoundArgumentException("Ha habido un error en la batalla");
		}
	}


	public static Argument getArgument(MainCharacter m) {
		Random rd = new Random();
		ArrayList<Argument> argumentsLs = m.getArguments();

		return argumentsLs.get(rd.nextInt(argumentsLs.size()));	
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


	public static void descartarArgumento() {

	}



}
