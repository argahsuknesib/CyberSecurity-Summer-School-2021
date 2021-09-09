package _m_j;

public abstract class jks {
    public abstract void O000000o(String str);

    public abstract void O00000Oo(String str);

    public abstract void O00000o0(String str);

    public static jks O000000o(Class cls) {
        if (System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik")) {
            return new jkq(cls.getSimpleName());
        }
        return new jkr(cls.getSimpleName());
    }
}
