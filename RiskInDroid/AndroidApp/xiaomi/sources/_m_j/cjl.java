package _m_j;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import com.Utils.MediaStoreUtil;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public final class cjl {

    /* renamed from: O000000o  reason: collision with root package name */
    public static volatile ImageView f13944O000000o;
    private static Runnable O00000Oo = $$Lambda$cjl$RmswTWW3BHVFDmAnQg09K3Z5Bs.INSTANCE;

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o() {
        try {
            ((View) f13944O000000o.getParent()).setVisibility(8);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void O000000o(Activity activity, String str, String str2, ckc ckc, ImageView imageView, Intent intent) {
        cjm.O000000o(str, "plg.4gw.zv6.f98");
        if (ckc != null) {
            Bitmap O00000oO = ckc.O00000oO();
            if (O00000oO != null) {
                new Thread(new Runnable(str2, O00000oO, str, activity, imageView, intent) {
                    /* class _m_j.$$Lambda$cjl$8uzDxSuPc2O9u73eGoohP0RlkbI */
                    private final /* synthetic */ String f$0;
                    private final /* synthetic */ Bitmap f$1;
                    private final /* synthetic */ String f$2;
                    private final /* synthetic */ Activity f$3;
                    private final /* synthetic */ ImageView f$4;
                    private final /* synthetic */ Intent f$5;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                        this.f$4 = r5;
                        this.f$5 = r6;
                    }

                    public final void run() {
                        cjl.O000000o(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
                    }
                }).start();
            } else {
                cki.O00000oO("CloudVideoActionUtils", "bitmap null");
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    public static /* synthetic */ void O000000o(String str, Bitmap bitmap, String str2, Activity activity, ImageView imageView, Intent intent) {
        File file;
        try {
            String O000000o2 = cjn.O000000o(str);
            FileOutputStream fileOutputStream = new FileOutputStream(O000000o2);
            bitmap.compress(Bitmap.CompressFormat.PNG, 0, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            try {
                if (Build.MODEL.equals("HM 1SC") || DeviceConstant.shouldInsertIntoNonDidAlbum(str2)) {
                    ContentValues contentValues = new ContentValues(4);
                    contentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
                    contentValues.put("_data", O000000o2);
                    contentValues.put("mime_type", "image/jpeg");
                    if (!Build.MODEL.equals("HM 1SC")) {
                        activity.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                    }
                } else {
                    File file2 = new File(O000000o2);
                    MediaStoreUtil.O000000o(activity, O000000o2, str, file2.getName());
                    String replaceFirst = O000000o2.replaceFirst("/Xiaomi/local", "").replaceFirst("file://", "");
                    if (new File(replaceFirst).exists()) {
                        file = new File(replaceFirst);
                    } else {
                        file = new File(replaceFirst + ".png");
                    }
                    file2.delete();
                    O000000o2 = file.getAbsolutePath();
                }
                String str3 = O000000o2;
                cki.O00000o("CloudVideoActionUtils", "snap success");
                activity.runOnUiThread(new Runnable(imageView, bitmap, intent, str3, activity) {
                    /* class _m_j.$$Lambda$cjl$M3C1uGVbECiLjCilGhLjUXWxKzo */
                    private final /* synthetic */ ImageView f$0;
                    private final /* synthetic */ Bitmap f$1;
                    private final /* synthetic */ Intent f$2;
                    private final /* synthetic */ String f$3;
                    private final /* synthetic */ Activity f$4;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                        this.f$4 = r5;
                    }

                    public final void run() {
                        cjl.O000000o(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
                    }
                });
            } catch (Throwable unused) {
            }
        } catch (IOException e) {
            cki.O00000o("CloudVideoActionUtils", "IOException:" + e.getLocalizedMessage());
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(ImageView imageView, Bitmap bitmap, Intent intent, String str, Activity activity) {
        imageView.setImageBitmap(bitmap);
        View view = (View) imageView.getParent();
        if (view != null) {
            view.bringToFront();
            view.setVisibility(0);
            imageView.setOnClickListener(new View.OnClickListener(intent, str, activity, view) {
                /* class _m_j.$$Lambda$cjl$F85YhE2ABDiDZ8mkknAKCYWMWU */
                private final /* synthetic */ Intent f$0;
                private final /* synthetic */ String f$1;
                private final /* synthetic */ Activity f$2;
                private final /* synthetic */ View f$3;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void onClick(View view) {
                    cjl.O000000o(this.f$0, this.f$1, this.f$2, this.f$3, view);
                }
            });
            f13944O000000o = imageView;
            imageView.removeCallbacks(O00000Oo);
            imageView.postDelayed(O00000Oo, 5000);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(Intent intent, String str, Activity activity, View view, View view2) {
        if (intent != null) {
            intent.putExtra("file_path", str);
            intent.putExtra("noScroll", true);
            activity.startActivity(intent);
            view.setVisibility(8);
        }
    }
}
