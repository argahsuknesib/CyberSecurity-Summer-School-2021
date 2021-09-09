package _m_j;

public final class aos extends aor {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final String f12505O000000o;
    protected final String O00000Oo;

    protected aos(ajv ajv, asq asq) {
        super(ajv, asq);
        String name = ajv.O00000Oo().getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf < 0) {
            this.f12505O000000o = "";
            this.O00000Oo = ".";
            return;
        }
        this.O00000Oo = name.substring(0, lastIndexOf + 1);
        this.f12505O000000o = name.substring(0, lastIndexOf);
    }

    public final String O000000o(Object obj) {
        String name = obj.getClass().getName();
        return name.startsWith(this.O00000Oo) ? name.substring(this.O00000Oo.length() - 1) : name;
    }

    public final ajv O000000o(String str) {
        if (str.startsWith(".")) {
            StringBuilder sb = new StringBuilder(str.length() + this.f12505O000000o.length());
            if (this.f12505O000000o.length() == 0) {
                sb.append(str.substring(1));
            } else {
                sb.append(this.f12505O000000o);
                sb.append(str);
            }
            str = sb.toString();
        }
        return super.O000000o(str);
    }
}
