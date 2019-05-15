/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.Collection;
import clases.Argument;
import clases.Argument.Type1;
import clases.Argument.Type2;
import clases.MainCharacter;
import clases.Philosopher;
import exceptions.LenghtArgumentException;
import exceptions.LenghtCharacterArgumentException;
import exceptions.NameException;
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
		Window window = new Window();

		Argument argumento0 = new Argument("Escopeta", "Eres Feo", (byte)1,(byte)0,
				Type1.DUALISTA, Type2.MECANICISTA);

		Argument argumento1 = new Argument("Cuchillo", "Eres un gato", (byte)2,(byte)0,
				Type1.DUALISTA, Type2.MECANICISTA);

		Argument argumento2 = new Argument("Hacha", "Las Salchichas son buenas", (byte)3,(byte)0,
				Type1.DUALISTA, Type2.MECANICISTA);

		Argument argumento3 = new Argument("Metralleta", "Te voy a matar", (byte)4,(byte)0,
				Type1.DUALISTA, Type2.MECANICISTA);
		Argument argumento4 = new Argument("Tanque del Dualismo", "Dios todo lo puede", (byte)7,(byte)0,
				Type1.DUALISTA, Type2.MECANICISTA);

		ArrayList<Argument> argumentoL = new ArrayList<Argument>();
		argumentoL.add(argumento0);
		argumentoL.add(argumento1);
		argumentoL.add(argumento2);
		argumentoL.add(argumento3);
		argumentoL.add(argumento4);
		Argument argumentoP0 = new Argument("Espada", "Eres Feo", (byte)1,(byte)0,
				Type1.DUALISTA, Type2.MONISTA);

		Argument argumentoP1 = new Argument("Jarronazo", "Eres un gato", (byte)2,(byte)0,
				Type1.DUALISTA, Type2.MONISTA);

		Argument argumentoP2 = new Argument("Cabezaso Dividno", "Las Salchichas son buenas", (byte)3,(byte)0,
				Type1.DUALISTA, Type2.MONISTA);

		Argument argumentoP3 = new Argument("Calcetín sucio", "Te voy a matar", (byte)4,(byte)0,
				Type1.DUALISTA, Type2.MONISTA);


		ArrayList<Argument> argumentoLP = new ArrayList<Argument>();
		argumentoLP.add(argumentoP0);
		argumentoLP.add(argumentoP1);
		argumentoLP.add(argumentoP2);
		argumentoLP.add(argumentoP3);



		try {	
			Philosopher descartes = new Philosopher("Decartes", argumentoL);
			MainCharacter diogenes = new MainCharacter("Diogenes", argumentoLP);

			//System.out.println(descartes.mayorArgumento(argumentoL));
		} catch (LenghtArgumentException e) {
			e.getMessage();
		} catch (LenghtCharacterArgumentException e) {
			e.getMessage();
		} catch (NameException e) {
			e.getMessage();
		}





		/*
	public void lucha(Personaje p, Filosofo f) {


		String bienvenida = "Esto es una prueba de la batalla por turnos";
		do {




		} while ((p.comprobarArgumentosExisten && f.comprobarArgumentosExisten) == true);


		Se comprueba que ambos personajes tienen argumentos y despues se procede a la batalla. 

		//if(comprobarArgumentos(p,f)==true) {

		//}else {

		//}



	}


		 */	

	}
}

