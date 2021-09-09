package _m_j;

public final class btm extends btp {

    /* renamed from: O000000o  reason: collision with root package name */
    private StringBuilder f13274O000000o = new StringBuilder();
    private boolean O00000Oo = true;

    public btm() {
    }

    public btm(btp btp) {
        super(btp);
    }

    /* access modifiers changed from: protected */
    public final byte[] O000000o(byte[] bArr) {
        byte[] O000000o2 = brs.O000000o(this.f13274O000000o.toString());
        this.O00000o = O000000o2;
        this.O00000Oo = true;
        StringBuilder sb = this.f13274O000000o;
        sb.delete(0, sb.length());
        return O000000o2;
    }

    public final void O00000Oo(byte[] bArr) {
        String O000000o2 = brs.O000000o(bArr);
        if (this.O00000Oo) {
            this.O00000Oo = false;
        } else {
            this.f13274O000000o.append(",");
        }
        StringBuilder sb = this.f13274O000000o;
        sb.append("{\"log\":\"");
        sb.append(O000000o2);
        sb.append("\"}");
    }
}
