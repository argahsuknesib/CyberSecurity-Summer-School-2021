package com.drew.metadata.gif;

import _m_j.abv;
import _m_j.xr;
import java.util.HashMap;

public final class GifControlDirectory extends xr {
    protected static final HashMap<Integer, String> O0000O0o;

    public final String O000000o() {
        return "GIF Control";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        O0000O0o = hashMap;
        hashMap.put(1, "Delay");
        O0000O0o.put(2, "Disposal Method");
        O0000O0o.put(3, "User Input Flag");
        O0000O0o.put(4, "Transparent Color Flag");
        O0000O0o.put(5, "Transparent Color Index");
    }

    public GifControlDirectory() {
        O000000o(new abv(this));
    }

    public final HashMap<Integer, String> O00000Oo() {
        return O0000O0o;
    }

    public enum DisposalMethod {
        NOT_SPECIFIED,
        DO_NOT_DISPOSE,
        RESTORE_TO_BACKGROUND_COLOR,
        RESTORE_TO_PREVIOUS,
        TO_BE_DEFINED,
        INVALID;

        public static DisposalMethod typeOf(int i) {
            switch (i) {
                case 0:
                    return NOT_SPECIFIED;
                case 1:
                    return DO_NOT_DISPOSE;
                case 2:
                    return RESTORE_TO_BACKGROUND_COLOR;
                case 3:
                    return RESTORE_TO_PREVIOUS;
                case 4:
                case 5:
                case 6:
                case 7:
                    return TO_BE_DEFINED;
                default:
                    return INVALID;
            }
        }

        public final String toString() {
            switch (this) {
                case DO_NOT_DISPOSE:
                    return "Don't Dispose";
                case INVALID:
                    return "Invalid value";
                case NOT_SPECIFIED:
                    return "Not Specified";
                case RESTORE_TO_BACKGROUND_COLOR:
                    return "Restore to Background Color";
                case RESTORE_TO_PREVIOUS:
                    return "Restore to Previous";
                case TO_BE_DEFINED:
                    return "To Be Defined";
                default:
                    return super.toString();
            }
        }
    }
}
