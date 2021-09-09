package com.miui.tsmclient.smartcard.terminal;

import android.os.Parcel;
import android.os.Parcelable;
import com.tsmclient.smartcard.exception.NfcEeIOException;
import java.io.IOException;
import java.security.AccessControlException;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class SmartMxError implements Parcelable {
    private static final Class[] ALLOWED_EXCEPTIONS = {NfcEeIOException.class, IOException.class, InterruptedException.class, SecurityException.class, NoSuchElementException.class, IllegalStateException.class, IllegalArgumentException.class, UnsupportedOperationException.class, NullPointerException.class};
    public static final Parcelable.Creator<SmartMxError> CREATOR = new Parcelable.Creator<SmartMxError>() {
        /* class com.miui.tsmclient.smartcard.terminal.SmartMxError.AnonymousClass1 */

        public final SmartMxError createFromParcel(Parcel parcel) {
            return new SmartMxError(parcel);
        }

        public final SmartMxError[] newArray(int i) {
            return new SmartMxError[i];
        }
    };
    private String mClazz;
    private int mErrorCode;
    private String mMessage;

    public int describeContents() {
        return 0;
    }

    public SmartMxError() {
        this.mClazz = "";
        this.mMessage = "";
    }

    private SmartMxError(Parcel parcel) {
        readFromParcel(parcel);
    }

    public void set(Exception exc) throws IllegalArgumentException {
        if (exc != null) {
            Class<?> cls = exc.getClass();
            if (Arrays.asList(ALLOWED_EXCEPTIONS).contains(cls)) {
                this.mClazz = cls.getCanonicalName();
                this.mMessage = exc.getMessage() != null ? exc.getMessage() : "";
                return;
            }
            throw new IllegalArgumentException("Unexpected exception class: " + cls.getCanonicalName());
        }
        throw new IllegalArgumentException("Cannot set a null exception");
    }

    public void setError(Class cls, String str) {
        this.mClazz = cls == null ? "" : cls.getName();
        if (str == null) {
            str = "";
        }
        this.mMessage = str;
    }

    public void throwException() throws NfcEeIOException, IOException, InterruptedException, SecurityException, NoSuchElementException, IllegalStateException, IllegalArgumentException, UnsupportedOperationException, NullPointerException {
        if (this.mClazz.equals(NfcEeIOException.class.getCanonicalName())) {
            throw new NfcEeIOException(this.mMessage, this.mErrorCode);
        } else if (this.mClazz.equals(IOException.class.getCanonicalName())) {
            throw new IOException(this.mMessage);
        } else if (this.mClazz.equals(InterruptedException.class.getCanonicalName())) {
            throw new InterruptedException(this.mMessage);
        } else if (this.mClazz.equals(SecurityException.class.getCanonicalName())) {
            throw new SecurityException(this.mMessage);
        } else if (this.mClazz.equals(AccessControlException.class.getCanonicalName())) {
            throw new SecurityException(this.mMessage);
        } else if (this.mClazz.equals(NoSuchElementException.class.getCanonicalName())) {
            throw new NoSuchElementException(this.mMessage);
        } else if (this.mClazz.equals(IllegalStateException.class.getCanonicalName())) {
            throw new IllegalStateException(this.mMessage);
        } else if (this.mClazz.equals(IllegalArgumentException.class.getCanonicalName())) {
            throw new IllegalArgumentException(this.mMessage);
        } else if (this.mClazz.equals(UnsupportedOperationException.class.getCanonicalName())) {
            throw new UnsupportedOperationException(this.mMessage);
        } else if (this.mClazz.equals(NullPointerException.class.getCanonicalName())) {
            throw new NullPointerException(this.mMessage);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mClazz);
        parcel.writeString(this.mMessage);
        parcel.writeInt(this.mErrorCode);
    }

    public void readFromParcel(Parcel parcel) {
        this.mClazz = parcel.readString();
        this.mMessage = parcel.readString();
        this.mErrorCode = parcel.readInt();
    }
}
