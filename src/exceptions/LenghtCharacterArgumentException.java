package exceptions;

public class LenghtCharacterArgumentException extends Exception {
	
	/**
	 * This exception is throws when you try to introude more than 4 arguments int the main Character
	 * @param msg
	 */
    public LenghtCharacterArgumentException(String msg) {
        super(msg);
    }

}