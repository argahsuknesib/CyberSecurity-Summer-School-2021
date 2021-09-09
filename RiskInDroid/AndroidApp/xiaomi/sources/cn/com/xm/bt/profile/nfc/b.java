package cn.com.xm.bt.profile.nfc;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private c f3109a = null;

    public b(cn.com.xm.bt.c.b bVar) {
        this.f3109a = new c(bVar);
    }

    public synchronized HMNFCStatus a(d dVar) {
        if (!this.f3109a.a()) {
            return null;
        }
        this.f3109a.a(dVar);
        return new HMNFCStatus(this.f3109a.c());
    }

    public synchronized HMNFCStatus a() {
        int d;
        d = this.f3109a.d();
        this.f3109a.b();
        this.f3109a.a((d) null);
        return new HMNFCStatus(d);
    }

    public synchronized ApduResponse a(byte[] bArr, int i, boolean z) {
        if (bArr != null) {
            if (bArr.length != 0) {
                return this.f3109a.a(bArr, i, z);
            }
        }
        return null;
    }
}
