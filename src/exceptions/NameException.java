package exceptions;

public class NameException extends Exception {
	
	/**
	 * This exception is throws when you try to introduce an philosopher without name
	 * @param msg
	 */
    public NameException(String msg) {
        super(msg);
    }

 

}
