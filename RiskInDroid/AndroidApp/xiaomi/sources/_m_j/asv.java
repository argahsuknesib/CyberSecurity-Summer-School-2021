package _m_j;

public final class asv {
    public static String O000000o(ann ann, String str) {
        if (!str.startsWith("get")) {
            return null;
        }
        if ("getCallbacks".equals(str)) {
            if (O000000o(ann)) {
                return null;
            }
        } else if ("getMetaClass".equals(str) && O00000Oo(ann)) {
            return null;
        }
        return O000000o(str.substring(3));
    }

    public static String O00000Oo(ann ann, String str) {
        if (!str.startsWith("is")) {
            return null;
        }
        Class<?> O00000o = ann.O00000o();
        if (O00000o == Boolean.class || O00000o == Boolean.TYPE) {
            return O000000o(str.substring(2));
        }
        return null;
    }

    public static String O00000o0(ann ann, String str) {
        String O00000Oo = ann.O00000Oo();
        if (O00000Oo.startsWith(str)) {
            return O000000o(O00000Oo.substring(str.length()));
        }
        return null;
    }

    private static boolean O000000o(ann ann) {
        Package packageR;
        Class<?> O00000o = ann.O00000o();
        if (!(O00000o == null || !O00000o.isArray() || (packageR = O00000o.getComponentType().getPackage()) == null)) {
            String name = packageR.getName();
            if (name.startsWith("net.sf.cglib") || name.startsWith("org.hibernate.repackage.cglib")) {
                return true;
            }
        }
        return false;
    }

    private static boolean O00000Oo(ann ann) {
        Package packageR;
        Class<?> O00000o = ann.O00000o();
        if (O00000o == null || O00000o.isArray() || (packageR = O00000o.getPackage()) == null || !packageR.getName().startsWith("groovy.lang")) {
            return false;
        }
        return true;
    }

    private static String O000000o(String str) {
        int length = str.length();
        StringBuilder sb = null;
        if (length == 0) {
            return null;
        }
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            char lowerCase = Character.toLowerCase(charAt);
            if (charAt == lowerCase) {
                break;
            }
            if (sb == null) {
                sb = new StringBuilder(str);
            }
            sb.setCharAt(i, lowerCase);
        }
        if (sb == null) {
            return str;
        }
        return sb.toString();
    }
}
