package com.sdu.didi.openapi.ss;

import android.content.Context;
import android.content.res.Resources;

public class d {

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f5606O000000o;
    public final Resources O00000Oo = this.f5606O000000o.getResources();

    public d(Context context) {
        this.f5606O000000o = context;
    }

    public final int O000000o(String str) {
        int identifier = this.O00000Oo.getIdentifier(str, "id", this.f5606O000000o.getPackageName());
        if (identifier != 0) {
            return identifier;
        }
        throw new Resources.NotFoundException(str);
    }

    public final int O00000Oo(String str) {
        int identifier = this.O00000Oo.getIdentifier(str, "drawable", this.f5606O000000o.getPackageName());
        if (identifier != 0) {
            return identifier;
        }
        throw new Resources.NotFoundException(str);
    }
}
