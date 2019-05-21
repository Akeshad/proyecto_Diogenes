
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





	public static void descartarArgumento() {

	}



}
