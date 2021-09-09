package _m_j;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.xiaomi.push.ex;
import com.xiaomi.push.g;
import com.xiaomi.push.service.af;
import com.xiaomi.push.service.ar;
import com.xiaomi.push.service.as;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class epm extends ex {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f15704O000000o;
    private String O00000Oo;
    RemoteViews O00000o;
    public boolean O00000oO;
    protected Bitmap O00000oo;
    protected CharSequence O0000O0o;
    protected CharSequence O0000OOo;
    private boolean O0000Oo;
    protected Map<String, String> O0000Oo0;
    private ArrayList<Notification.Action> O0000OoO;
    private int O0000Ooo;

    public epm(Context context, String str) {
        this(context, 0, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public epm addAction(Notification.Action action) {
        if (action != null) {
            this.O0000OoO.add(action);
        }
        this.O0000Ooo++;
        return this;
    }

    protected static Bitmap O00000Oo(Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        canvas.drawRoundRect(new RectF(rect), 30.0f, 30.0f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    protected static boolean O00000Oo(int i) {
        double red = (double) Color.red(i);
        Double.isNaN(red);
        double green = (double) Color.green(i);
        Double.isNaN(green);
        double d = (red * 0.299d) + (green * 0.587d);
        double blue = (double) Color.blue(i);
        Double.isNaN(blue);
        return d + (blue * 0.114d) < 192.0d;
    }

    private boolean O00000oo() {
        return !TextUtils.isEmpty(O00000Oo()) && !TextUtils.isEmpty(this.O00000Oo);
    }

    /* renamed from: O000000o */
    public final epm addAction(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        if (Build.VERSION.SDK_INT >= 19) {
            addAction(new Notification.Action(i, charSequence, pendingIntent));
        }
        return this;
    }

    /* renamed from: O000000o */
    public epm setLargeIcon(Bitmap bitmap) {
        this.O00000oo = bitmap;
        return this;
    }

    public final ex O000000o(Map<String, String> map) {
        this.O0000Oo0 = map;
        return this;
    }

    /* access modifiers changed from: protected */
    public abstract String O000000o();

    /* access modifiers changed from: protected */
    public abstract String O00000Oo();

    /* access modifiers changed from: protected */
    public abstract boolean O00000o0();

    /* access modifiers changed from: protected */
    public final void O00000oO() {
        if (Build.VERSION.SDK_INT >= 11) {
            super.setContentTitle(this.O0000O0o);
            super.setContentText(this.O0000OOo);
            Bitmap bitmap = this.O00000oo;
            if (bitmap != null) {
                super.setLargeIcon(bitmap);
            }
        }
    }

    public epm(Context context, int i, String str) {
        super(context);
        this.O0000OoO = new ArrayList<>();
        boolean z = false;
        this.O0000Ooo = 0;
        this.O00000Oo = str;
        this.f15704O000000o = i;
        Resources resources = this.O00000o0.getResources();
        if (O00000oo() && O0000O0o()) {
            z = true;
        }
        this.O0000Oo = z;
        int O000000o2 = O000000o(resources, this.O0000Oo ? O00000Oo() : O000000o(), "layout", this.O00000o0.getPackageName());
        if (O000000o2 != 0) {
            this.O00000o = new RemoteViews(this.O00000o0.getPackageName(), O000000o2);
            this.O00000oO = O00000o0();
            return;
        }
        duv.O000000o("create RemoteViews failed, no such layout resource was found");
    }

    public void O00000o() {
        super.O00000o();
        Bundle bundle = new Bundle();
        if (O00000oo()) {
            bundle.putBoolean("mipush.customCopyLayout", this.O0000Oo);
        } else {
            bundle.putBoolean("mipush.customCopyLayout", false);
        }
        bundle.putBoolean("miui.customHeight", false);
        boolean z = true;
        bundle.putBoolean("mipush.customNotification", true);
        bundle.putInt("mipush.customLargeIconId", ex.O000000o(this.O00000o0.getResources(), "large_icon", "id", this.O00000o0.getPackageName()));
        if (this.O0000OoO.size() > 0) {
            Notification.Action[] actionArr = new Notification.Action[this.O0000OoO.size()];
            this.O0000OoO.toArray(actionArr);
            bundle.putParcelableArray("mipush.customActions", actionArr);
        }
        Map<String, String> map = this.O0000Oo0;
        if (map == null || !Boolean.parseBoolean(map.get("custom_builder_set_title"))) {
            z = false;
        }
        if (!z && as.m173a(this.O00000o0.getContentResolver())) {
            bundle.putCharSequence("mipush.customTitle", this.O0000O0o);
            bundle.putCharSequence("mipush.customContent", this.O0000OOo);
        } else if (Build.VERSION.SDK_INT >= 11) {
            super.setContentTitle(this.O0000O0o);
            super.setContentText(this.O0000OOo);
        }
        addExtras(bundle);
    }

    /* access modifiers changed from: protected */
    public final void O000000o(int i) {
        Bitmap a2 = af.a(g.O0000O0o(this.O00000o0, this.O00000Oo));
        if (a2 != null) {
            this.O00000o.setImageViewBitmap(i, a2);
            return;
        }
        int O00000oo2 = g.O00000oo(this.O00000o0, this.O00000Oo);
        if (O00000oo2 != 0) {
            this.O00000o.setImageViewResource(i, O00000oo2);
        }
    }

    private boolean O0000O0o() {
        List<StatusBarNotification> b;
        if (Build.VERSION.SDK_INT >= 20 && (b = ar.a(this.O00000o0, this.O00000Oo).m171b()) != null && !b.isEmpty()) {
            Iterator<StatusBarNotification> it = b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                StatusBarNotification next = it.next();
                if (next.getId() == this.f15704O000000o) {
                    Notification notification = next.getNotification();
                    if (notification != null && !notification.extras.getBoolean("mipush.customCopyLayout", true)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final int O000000o(float f) {
        return (int) ((f * this.O00000o0.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public /* synthetic */ Notification.Builder setContentText(CharSequence charSequence) {
        this.O0000OOo = charSequence;
        return this;
    }

    public /* synthetic */ Notification.Builder setContentTitle(CharSequence charSequence) {
        this.O0000O0o = charSequence;
        return this;
    }
}
