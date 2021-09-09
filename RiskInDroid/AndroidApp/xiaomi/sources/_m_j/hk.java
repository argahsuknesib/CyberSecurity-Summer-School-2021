package _m_j;

import android.renderscript.RSDriverException;
import android.renderscript.RSIllegalArgumentException;
import android.renderscript.RSInvalidStateException;
import androidx.renderscript.RSRuntimeException;

final class hk {
    static RuntimeException O000000o(RuntimeException runtimeException) {
        if (runtimeException instanceof RSIllegalArgumentException) {
            return new androidx.renderscript.RSIllegalArgumentException(runtimeException.getMessage());
        }
        if (runtimeException instanceof RSInvalidStateException) {
            return new androidx.renderscript.RSInvalidStateException(runtimeException.getMessage());
        }
        if (runtimeException instanceof RSDriverException) {
            return new androidx.renderscript.RSDriverException(runtimeException.getMessage());
        }
        return new RSRuntimeException(runtimeException.getMessage());
    }
}
