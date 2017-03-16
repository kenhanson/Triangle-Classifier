package us.flexion.challenge.coding.developer.triangle_classifier.exception;


public class InvalidArguementsException extends Exception {

    private static final long serialVersionUID = -7343466250533044354L;

    public InvalidArguementsException(String message) {
        super(message);        
    }

    public InvalidArguementsException(Throwable cause) {
        super(cause);        
    }

    public InvalidArguementsException(String message, Throwable cause) {
        super(message, cause);        
    }
}
