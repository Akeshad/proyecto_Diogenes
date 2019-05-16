/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import classes.Argument;
import classes.MainCharacter;
import classes.Philosopher;
import classes.Argument.Type1;
import classes.Argument.Type2;
import exceptions.LenghtArgumentException;
import exceptions.LenghtCharacterArgumentException;
import exceptions.NameException;
import exceptions.NotFoundArgumentException;
import exceptions.TypeException;
import screen.Window;

/**
 *
 * @author SaraPdrui
 */
public class ProjectDiogenes {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
		//Window window = new Window();

		Argument argumento0 = new Argument("Escopeta", "Eres Feo", (byte)1,(byte)0,
				Type1.DUALISTA, Type2.MECANICISTA);

		Argument argumento1 = new Argument("Cuchillo", "Eres un gato", (byte)2,(byte)0,
				Type1.DUALISTA, Type2.MECANICISTA);

		Argument argumento2 = new Argument("Hacha", "Las Salchichas son buenas", (byte)3,(byte)0,
				Type1.DUALISTA, Type2.MECANICISTA);

		Argument argumento4 = new Argument("Tanque del Dualismo", "Dios todo lo puede", (byte)7,(byte)0,
				Type1.DUALISTA, Type2.MECANICISTA);

		ArrayList<Argument> argumentoL = new ArrayList<Argument>();
		argumentoL.add(argumento0);
		argumentoL.add(argumento1);
		argumentoL.add(argumento2);
		argumentoL.add(argumento4);
		Argument argumentoP0 = new Argument("Espada", "Eres Feo", (byte)1,(byte)0,
				Type1.DUALISTA, Type2.MONISTA);

		Argument argumentoP2 = new Argument("Cabezaso Dividno", "Las Salchichas son buenas", (byte)3,(byte)0,
				Type1.DUALISTA, Type2.MONISTA);

		Argument argumentoP3 = new Argument("Calcetín sucio", "Te voy a matar", (byte)4,(byte)0,
				Type1.DUALISTA, Type2.MONISTA);


		ArrayList<Argument> argumentoLP = new ArrayList<Argument>();
		argumentoLP.add(argumentoP0);
		argumentoLP.add(argumentoP2);
		argumentoLP.add(argumentoP3);



		try {	
			Philosopher descartes = new Philosopher("Decartes", argumentoL);
			MainCharacter diogenes = new MainCharacter("Diogenes", argumentoLP);

			System.out.println(fight(diogenes, descartes));
		} catch (LenghtArgumentException e) {
			e.getMessage();
		} catch (LenghtCharacterArgumentException e) {
			e.getMessage();
		} catch (NameException e) {
			e.getMessage();
		} catch (NotFoundArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	/**
	 * fight 
	 * @param m
	 * @param p
	 * @throws NotFoundArgumentException 
	 */
	public static Philosopher fight(MainCharacter m, Philosopher p) throws NotFoundArgumentException {

		System.out.println("Esto es una prueba de la batalla por turnos");
		
		do {
			try {				
			Argument winner = winnerArgument(p.getBestArgument(), getArgument(m));
			
			
			 ArrayList <Argument> argumentoFilosofo = p.getArguments();
			 ArrayList <Argument> argumentoProta = m.getArguments();
			
			if(argumentoProta.contains(winner)) {
				m.setTimesLost(+1);
			}if(argumentoFilosofo.contains(winner)) {
				p.setTimesLost(+1);
			}else {
				throw new NotFoundArgumentException("Ha habido un error en la batalla");
			}
				
			} catch (TypeException e) {
				e.printStackTrace();
			}
			
		} while (p.getTimesLost() == 4 || m.getTimesLost() == 4);
			
		if(p.getTimesLost() >= 4) {
			return p;
		}else if(m.getTimesLost() >= 4) {
			return m;
		}else {
			throw new NotFoundArgumentException("Ha habido un error en la batalla");
		}
	}
	
	/**
	 * Function that returns a random argument of the main character
	 * @param m
	 * @return Argument
	 */	
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
}

