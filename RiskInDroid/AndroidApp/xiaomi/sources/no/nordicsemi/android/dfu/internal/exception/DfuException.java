package no.nordicsemi.android.dfu.internal.exception;

public class DfuException extends Exception {
    private static final long serialVersionUID = -6901728550661937942L;
    private final int mError;

    public DfuException(String str, int i) {
        super(str);
        this.mError = i;
    }

    public int getErrorNumber() {
        return this.mError;
    }

    public String getMessage() {
        return super.getMessage() + " (error " + (this.mError & -16385) + ")";
    }
}
