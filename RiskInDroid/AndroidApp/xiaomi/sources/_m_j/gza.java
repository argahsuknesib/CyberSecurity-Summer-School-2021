package _m_j;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.RemoteViews;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public abstract class gza {
    private static Random O0000OoO = new Random();

    /* renamed from: O000000o  reason: collision with root package name */
    protected int[] f18607O000000o = {R.id.ll_widget_row1, R.id.ll_widget_row2, R.id.ll_widget_row3, R.id.ll_widget_row4};
    protected int[] O00000Oo = {R.id.ll_widget_item1, R.id.ll_widget_item2, R.id.ll_widget_item3, R.id.ll_widget_item4, R.id.ll_widget_item5, R.id.ll_widget_item6, R.id.ll_widget_item7, R.id.ll_widget_item8};
    protected int[] O00000o = {R.id.tv_widget_room_name1, R.id.tv_widget_room_name2, R.id.tv_widget_room_name3, R.id.tv_widget_room_name4, R.id.tv_widget_room_name5, R.id.tv_widget_room_name6, R.id.tv_widget_room_name7, R.id.tv_widget_room_name8};
    protected int[] O00000o0 = {R.id.tv_widget_device_name1, R.id.tv_widget_device_name2, R.id.tv_widget_device_name3, R.id.tv_widget_device_name4, R.id.tv_widget_device_name5, R.id.tv_widget_device_name6, R.id.tv_widget_device_name7, R.id.tv_widget_device_name8};
    protected int[] O00000oO = {R.id.tv_widget_device_state_split1, R.id.tv_widget_device_state_split2, R.id.tv_widget_device_state_split3, R.id.tv_widget_device_state_split4, R.id.tv_widget_device_state_split5, R.id.tv_widget_device_state_split6, R.id.tv_widget_device_state_split7, R.id.tv_widget_device_state_split8};
    protected int[] O00000oo = {R.id.tv_widget_device_state_online1, R.id.tv_widget_device_state_online2, R.id.tv_widget_device_state_online3, R.id.tv_widget_device_state_online4, R.id.tv_widget_device_state_online5, R.id.tv_widget_device_state_online6, R.id.tv_widget_device_state_online7, R.id.tv_widget_device_state_online8};
    protected int[] O0000O0o = {R.id.tv_widget_device_state_offline1, R.id.tv_widget_device_state_offline2, R.id.tv_widget_device_state_offline3, R.id.tv_widget_device_state_offline4, R.id.tv_widget_device_state_offline5, R.id.tv_widget_device_state_offline6, R.id.tv_widget_device_state_offline7, R.id.tv_widget_device_state_offline8};
    protected int[] O0000OOo = {R.id.iv_widget_switch1, R.id.iv_widget_switch2, R.id.iv_widget_switch3, R.id.iv_widget_switch4, R.id.iv_widget_switch5, R.id.iv_widget_switch6, R.id.iv_widget_switch7, R.id.iv_widget_switch8};
    public File O0000Oo = new File(ServiceApplication.getAppContext().getFilesDir(), "widget_icon");
    protected int[] O0000Oo0 = {R.id.iv_widget_item1, R.id.iv_widget_item2, R.id.iv_widget_item3, R.id.iv_widget_item4, R.id.iv_widget_item5, R.id.iv_widget_item6, R.id.iv_widget_item7, R.id.iv_widget_item8};

    public abstract void O000000o(RemoteViews remoteViews, int i);

    public abstract boolean O00000Oo();

    public static String O000000o(String str) {
        String str2;
        if (fad.O000000o().isEnableMiuiWidgetMemoryOpt()) {
            str2 = fad.O000000o().getRoomNameByDid(str);
        } else {
            str2 = ggb.O00000Oo().O0000o0O(str);
        }
        return str2 == null ? "" : str2;
    }

    public static int O00000o0() {
        return O0000OoO.nextInt();
    }

    public final int[] O00000o() {
        return this.f18607O000000o;
    }

    public final int O000000o(int i) {
        return this.O00000Oo[i];
    }

    public final int O00000Oo(int i) {
        return this.O00000o0[i];
    }

    public final int O00000o0(int i) {
        return this.O00000o[i];
    }

    public final int O00000o(int i) {
        return this.O00000oO[i];
    }

    public final int O00000oO(int i) {
        return this.O00000oo[i];
    }

    public final int O00000oo(int i) {
        return this.O0000O0o[i];
    }

    public final int O0000O0o(int i) {
        return this.O0000OOo[i];
    }

    public final int O0000OOo(int i) {
        return this.O0000Oo0[i];
    }

    public final void O00000Oo(RemoteViews remoteViews, int i) {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int[] iArr = this.f18607O000000o;
            if (i3 >= iArr.length) {
                break;
            }
            remoteViews.setViewVisibility(iArr[i3], 8);
            i3++;
        }
        O000000o(remoteViews, i);
        while (true) {
            int[] iArr2 = this.O00000Oo;
            if (i2 < iArr2.length) {
                remoteViews.setViewVisibility(iArr2[i2], 4);
                i2++;
            } else {
                return;
            }
        }
    }

    public final void O000000o(final int i, Device device, final RemoteViews remoteViews) {
        remoteViews.setImageViewResource(this.O0000Oo0[i], R.drawable.device_list_phone_no);
        final String O0000oOO = DeviceFactory.O0000oOO(device.model);
        if (O0000oOO == null || O0000oOO.length() == 0) {
            O0000oOO = device.model;
        }
        try {
            if (!this.O0000Oo.exists()) {
                this.O0000Oo.mkdirs();
            }
            File[] listFiles = this.O0000Oo.listFiles();
            if (listFiles != null) {
                for (int i2 = 0; i2 < listFiles.length; i2++) {
                    if (listFiles[i2].getName().contains(grv.O000000o(O0000oOO))) {
                        remoteViews.setImageViewBitmap(this.O0000Oo0[i], BitmapFactory.decodeFile(listFiles[i2].getAbsolutePath()));
                        return;
                    }
                }
            }
            goq.O00000oO(new Runnable() {
                /* class _m_j.gza.AnonymousClass1 */

                public final void run() {
                    try {
                        URL url = new URL(O0000oOO);
                        dxx.O000000o();
                        final Bitmap decodeStream = BitmapFactory.decodeStream(((HttpURLConnection) dxx.O000000o(url)).getInputStream());
                        gos.O000000o(decodeStream, new File(gza.this.O0000Oo, grv.O000000o(O0000oOO)).getAbsolutePath());
                        ServiceApplication.getGlobalHandler().post(new Runnable() {
                            /* class _m_j.gza.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                remoteViews.setImageViewBitmap(gza.this.O0000OOo(i), decodeStream);
                            }
                        });
                    } catch (Exception unused) {
                    }
                }
            });
        } catch (Exception e) {
            LogType logType = LogType.MIJIA_WIDGET;
            gsy.O00000o0(logType, "zhudong_glide_bitmap", "load-bitmap-exception:" + e.getMessage());
        }
    }

    public final void O000000o(RemoteViews remoteViews, int i, boolean z, CharSequence charSequence) {
        if (z) {
            remoteViews.setViewVisibility(this.O00000oo[i], 0);
            remoteViews.setViewVisibility(this.O0000O0o[i], 8);
            remoteViews.setTextViewText(this.O00000oo[i], charSequence);
            return;
        }
        remoteViews.setViewVisibility(this.O00000oo[i], 8);
        remoteViews.setViewVisibility(this.O0000O0o[i], 0);
        remoteViews.setTextViewText(this.O0000O0o[i], charSequence);
    }
}
