package _m_j;

import android.text.TextUtils;
import com.mijia.camera.nas.NASServer;
import java.io.File;
import java.util.ArrayList;

public final class ciu {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f13927O000000o;
    public String O00000Oo;
    public NASServer O00000o;
    ArrayList<ciu> O00000o0 = new ArrayList<>();
    private ciu O00000oO;

    public ciu(ciu ciu, String str) {
        this.O00000oO = ciu;
        this.O00000o = ciu.O00000o;
        this.O00000Oo = str;
        if (!TextUtils.isEmpty(ciu.f13927O000000o)) {
            str = ciu.f13927O000000o + File.separator + str;
        }
        this.f13927O000000o = str;
    }

    public ciu(NASServer nASServer, String str) {
        String str2;
        this.O00000o = nASServer;
        if (TextUtils.isEmpty(str)) {
            this.O00000Oo = "";
        } else {
            this.O00000Oo = str;
        }
        if (TextUtils.isEmpty(this.O00000Oo)) {
            str2 = this.O00000o.O0000O0o;
        } else {
            str2 = this.O00000o.O0000O0o + File.separator + this.O00000Oo;
        }
        this.f13927O000000o = str2;
    }
}
