package orca;
//Use in scenarios where clients can not do anthind about it - 
//i.e consumer can not route their business behavior
public class OrcaRuntimeException extends RuntimeException{

    /**
     * 
     */
    public OrcaRuntimeException() {
        super();
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public OrcaRuntimeException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * @param message
     * @param cause
     */
    public OrcaRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public OrcaRuntimeException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public OrcaRuntimeException(Throwable cause) {
        super(cause);
    }

    private static final long serialVersionUID = 1L;

}
