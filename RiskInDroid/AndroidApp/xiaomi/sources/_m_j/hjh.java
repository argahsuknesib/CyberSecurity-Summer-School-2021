package _m_j;

import _m_j.hjf;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.notishortcut.inward.QuickOpServiceNew;
import java.util.ArrayList;
import java.util.List;

final class hjh {

    /* renamed from: O000000o  reason: collision with root package name */
    private static int[] f18984O000000o = {R.id.noti_0, R.id.noti_1, R.id.noti_2, R.id.noti_3};
    private static int[] O00000Oo = {R.id.txt_device_name_0, R.id.txt_device_name_1, R.id.txt_device_name_2, R.id.txt_device_name_3};
    private static int[] O00000o = {R.id.pb_is_loading_0, R.id.pb_is_loading_1, R.id.pb_is_loading_2, R.id.pb_is_loading_3};
    private static int[] O00000o0 = {R.id.iv_on_status_0, R.id.iv_on_status_1, R.id.iv_on_status_2, R.id.iv_on_status_3};

    public static RemoteViews O000000o(Context context, List<hjf.O000000o> list) {
        String str;
        int i;
        PendingIntent pendingIntent;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), (int) R.layout.remote_device_notification);
        int[] iArr = {16842904};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(16973928, iArr);
        if (Build.VERSION.SDK_INT >= 21) {
            obtainStyledAttributes.recycle();
            obtainStyledAttributes = context.obtainStyledAttributes(16974339, iArr);
        }
        int color = obtainStyledAttributes.getColor(0, -1);
        double red = (double) Color.red(color);
        Double.isNaN(red);
        double green = (double) Color.green(color);
        Double.isNaN(green);
        double d = (red * 0.299d) + (green * 0.587d);
        double blue = (double) Color.blue(color);
        Double.isNaN(blue);
        boolean z = 1.0d - ((d + (blue * 0.114d)) / 255.0d) >= 0.5d;
        int i2 = 0;
        while (true) {
            if (i2 >= (arrayList.size() < 4 ? arrayList.size() : 4)) {
                break;
            }
            remoteViews.setViewVisibility(f18984O000000o[i2], 0);
            if (((hjf.O000000o) arrayList.get(i2)).O0000O0o != 2 || TextUtils.isEmpty(((hjf.O000000o) arrayList.get(i2)).O0000OOo)) {
                i = O00000Oo[i2];
                str = TextUtils.isEmpty(((hjf.O000000o) arrayList.get(i2)).O00000Oo) ? "" : ((hjf.O000000o) arrayList.get(i2)).O00000Oo;
            } else {
                i = O00000Oo[i2];
                str = ((hjf.O000000o) arrayList.get(i2)).O0000OOo;
            }
            remoteViews.setTextViewText(i, str);
            if (z) {
                remoteViews.setTextColor(O00000Oo[i2], context.getResources().getColor(R.color.mj_color_gray_heavier));
            } else {
                remoteViews.setTextColor(O00000Oo[i2], context.getResources().getColor(R.color.mj_color_white));
            }
            remoteViews.setViewVisibility(O00000o[i2], ((hjf.O000000o) arrayList.get(i2)).O0000O0o == 1 ? 0 : 8);
            if (!((hjf.O000000o) arrayList.get(i2)).O00000o) {
                Bitmap bitmap = hjf.O000000o(context).O00000o.get(((hjf.O000000o) arrayList.get(i2)).O0000OoO);
                if (bitmap == null || bitmap.isRecycled()) {
                    if (bitmap != null && bitmap.isRecycled()) {
                        hjf.O000000o(context).O00000o.remove(((hjf.O000000o) arrayList.get(i2)).O0000OoO);
                    }
                    remoteViews.setImageViewResource(O00000o0[i2], R.drawable.ic_noti_defualt_offline);
                } else {
                    remoteViews.setImageViewBitmap(O00000o0[i2], hjf.O000000o(context).O00000o.get(((hjf.O000000o) arrayList.get(i2)).O0000OoO));
                }
            } else if (((hjf.O000000o) arrayList.get(i2)).O00000oO) {
                Bitmap bitmap2 = hjf.O000000o(context).O00000o.get(((hjf.O000000o) arrayList.get(i2)).O0000Oo0);
                if (bitmap2 == null || bitmap2.isRecycled()) {
                    if (bitmap2 != null && bitmap2.isRecycled()) {
                        hjf.O000000o(context).O00000o.remove(((hjf.O000000o) arrayList.get(i2)).O0000Oo0);
                    }
                    remoteViews.setImageViewResource(O00000o0[i2], R.drawable.ic_noti_defualt_on);
                } else {
                    remoteViews.setImageViewBitmap(O00000o0[i2], hjf.O000000o(context).O00000o.get(((hjf.O000000o) arrayList.get(i2)).O0000Oo0));
                }
            } else {
                Bitmap bitmap3 = hjf.O000000o(context).O00000o.get(((hjf.O000000o) arrayList.get(i2)).O0000Oo);
                if (bitmap3 == null || bitmap3.isRecycled()) {
                    if (bitmap3 != null && bitmap3.isRecycled()) {
                        hjf.O000000o(context).O00000o.remove(((hjf.O000000o) arrayList.get(i2)).O0000Oo);
                    }
                    remoteViews.setImageViewResource(O00000o0[i2], R.drawable.ic_noti_defualt_off);
                } else {
                    remoteViews.setImageViewBitmap(O00000o0[i2], hjf.O000000o(context).O00000o.get(((hjf.O000000o) arrayList.get(i2)).O0000Oo));
                }
            }
            Intent intent = new Intent(context, QuickOpServiceNew.class);
            intent.setAction("notification_click");
            intent.putExtra("device_index", i2);
            if (Build.VERSION.SDK_INT >= 26) {
                pendingIntent = PendingIntent.getForegroundService(context, i2, intent, 134217731);
            } else {
                pendingIntent = PendingIntent.getService(context, i2, intent, 134217731);
            }
            remoteViews.setOnClickPendingIntent(f18984O000000o[i2], pendingIntent);
            i2++;
        }
        for (int size = arrayList.size(); size < 4; size++) {
            remoteViews.setViewVisibility(f18984O000000o[size], 4);
        }
        obtainStyledAttributes.recycle();
        return remoteViews;
    }
}
