package _m_j;

import _m_j.jof;
import android.os.Build;

final class joh implements jof.O00000Oo {
    joh() {
    }

    public final void O000000o(String str) {
        System.loadLibrary(str);
    }

    public final void O00000Oo(String str) {
        System.load(str);
    }

    public final String O00000o0(String str) {
        if (!str.startsWith("lib") || !str.endsWith(".so")) {
            return System.mapLibraryName(str);
        }
        return str;
    }

    public final String O00000o(String str) {
        return str.substring(3, str.length() - 3);
    }

    public final String[] O000000o() {
        if (Build.VERSION.SDK_INT >= 21 && Build.SUPPORTED_ABIS.length > 0) {
            return Build.SUPPORTED_ABIS;
        }
        if (!joi.O000000o(Build.CPU_ABI2)) {
            return new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        }
        return new String[]{Build.CPU_ABI};
    }
}
