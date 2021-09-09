package _m_j;

import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;

public final class epk extends epm {

    /* renamed from: O000000o  reason: collision with root package name */
    public Bitmap f15702O000000o;
    public Bitmap O00000Oo;
    private int O0000Oo = 16777216;

    public epk(Context context, String str) {
        super(context, str);
    }

    public final epm O000000o(Bitmap bitmap) {
        return this;
    }

    /* access modifiers changed from: protected */
    public final String O000000o() {
        return "notification_banner";
    }

    /* access modifiers changed from: protected */
    public final String O00000Oo() {
        return null;
    }

    public final /* synthetic */ Notification.Builder setLargeIcon(Bitmap bitmap) {
        return this;
    }

    /* access modifiers changed from: protected */
    public final boolean O00000o0() {
        if (!esl.O000000o()) {
            return false;
        }
        Resources resources = this.O00000o0.getResources();
        String packageName = this.O00000o0.getPackageName();
        int O000000o2 = O000000o(this.O00000o0.getResources(), "bg", "id", this.O00000o0.getPackageName());
        int O000000o3 = O000000o(resources, "icon", "id", packageName);
        int O000000o4 = O000000o(resources, "title", "id", packageName);
        if (O000000o2 == 0 || O000000o3 == 0 || O000000o4 == 0 || esl.O0000O0o() < 9) {
            return false;
        }
        return true;
    }

    private epk O00000Oo(String str) {
        if (this.O00000oO && !TextUtils.isEmpty(str)) {
            try {
                this.O0000Oo = Color.parseColor(str);
            } catch (Exception unused) {
                duv.O000000o("parse banner notification image text color error");
            }
        }
        return this;
    }

    public final void O00000o() {
        if (!this.O00000oO || this.f15702O000000o == null) {
            O00000oO();
            return;
        }
        super.O00000o();
        Resources resources = this.O00000o0.getResources();
        String packageName = this.O00000o0.getPackageName();
        int O000000o2 = O000000o(resources, "bg", "id", packageName);
        if (esl.O0000O0o() >= 10) {
            this.O00000o.setImageViewBitmap(O000000o2, O00000Oo(this.f15702O000000o));
        } else {
            this.O00000o.setImageViewBitmap(O000000o2, this.f15702O000000o);
        }
        int O000000o3 = O000000o(resources, "icon", "id", packageName);
        if (this.O00000Oo != null) {
            this.O00000o.setImageViewBitmap(O000000o3, this.O00000Oo);
        } else {
            O000000o(O000000o3);
        }
        int O000000o4 = O000000o(resources, "title", "id", packageName);
        this.O00000o.setTextViewText(O000000o4, this.O0000O0o);
        if (this.O0000Oo0 != null && this.O0000Oo == 16777216) {
            O00000Oo((String) this.O0000Oo0.get("notification_image_text_color"));
        }
        RemoteViews remoteViews = this.O00000o;
        int i = this.O0000Oo;
        remoteViews.setTextColor(O000000o4, (i == 16777216 || !O00000Oo(i)) ? -1 : -16777216);
        setCustomContentView(this.O00000o);
        Bundle bundle = new Bundle();
        bundle.putBoolean("miui.customHeight", true);
        addExtras(bundle);
    }
}
