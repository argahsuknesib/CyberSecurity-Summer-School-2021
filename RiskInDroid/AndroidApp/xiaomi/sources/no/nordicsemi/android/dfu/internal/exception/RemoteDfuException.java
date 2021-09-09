package no.nordicsemi.android.dfu.internal.exception;

public class RemoteDfuException extends Exception {
    private static final long serialVersionUID = -6901728550661937942L;
    private final int mState;

    public RemoteDfuException(String str, int i) {
        super(str);
        this.mState = i;
    }

    public int getErrorNumber() {
        return this.mState;
    }

    public String getMessage() {
        return super.getMessage() + " (error " + this.mState + ")";
    }
}
