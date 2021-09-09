package _m_j;

public final class jaj {
    public static String O00000Oo(int i) {
        switch (i) {
            case 1026:
                return "Wrong command format";
            case 1027:
                return "Unknown command";
            case 1028:
                return "Init command invalid";
            case 1029:
                return "FW version failure";
            case 1030:
                return "HW version failure";
            case 1031:
                return "SD version failure";
            case 1032:
                return "Signature mismatch";
            case 1033:
                return "Wrong hash type";
            case 1034:
                return "Hash failed";
            case 1035:
                return "Wrong signature type";
            case 1036:
                return "Verification failed";
            case 1037:
                return "Insufficient space";
            default:
                return "Reserved for future use";
        }
    }

    public static String O000000o(int i) {
        switch (i) {
            case 514:
                return "OP CODE NOT SUPPORTED";
            case 515:
                return "INVALID PARAM";
            case 516:
                return "INSUFFICIENT RESOURCES";
            case 517:
                return "INVALID OBJECT";
            case 518:
            case 521:
            default:
                return "UNKNOWN (" + i + ")";
            case 519:
                return "UNSUPPORTED TYPE";
            case 520:
                return "OPERATION NOT PERMITTED";
            case 522:
                return "OPERATION FAILED";
            case 523:
                return "EXTENDED ERROR";
        }
    }

    public static String O00000o0(int i) {
        if (i == 2050) {
            return "OP CODE NOT SUPPORTED";
        }
        if (i == 2052) {
            return "OPERATION FAILED";
        }
        return "UNKNOWN (" + i + ")";
    }
}
