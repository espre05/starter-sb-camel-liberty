package orca;

/**
 * @author pro
 * Use for business related exceptional scenario. 
 * e.g : User wants to HOLD-approval of an Insurance, when it has already been approved.
 */
public class OrcaBusinessException extends Exception{

    /**
     * 
     */
    public OrcaBusinessException() {
        super();
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public OrcaBusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * @param message
     * @param cause
     */
    public OrcaBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public OrcaBusinessException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public OrcaBusinessException(Throwable cause) {
        super(cause);
    }

    private static final long serialVersionUID = 1L;
    
}
