package no.nordicsemi.android.dfu.internal.exception;

public class DeviceDisconnectedException extends Exception {
    private static final long serialVersionUID = -6901728550661937942L;

    public DeviceDisconnectedException(String str) {
        super(str);
    }
}
