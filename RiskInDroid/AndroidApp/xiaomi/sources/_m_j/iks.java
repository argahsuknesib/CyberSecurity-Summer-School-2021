package _m_j;

import android.app.Notification;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RemoteViews;
import android.widget.TextView;
import java.util.concurrent.CountDownLatch;

public final class iks {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f1419O000000o = "ximalaya_title";
    public static String O00000Oo = "ximalaya_content";
    public static int O00000o = Color.parseColor("#de000000");
    public static int O00000o0 = 987654321;
    public static int O00000oO = Color.parseColor("#8a000000");
    public static int O00000oo = -1;
    public static int O0000O0o = Color.parseColor("#b3ffffff");
    public static O000000o O0000OOo;
    private static TextView O0000Oo = null;
    public static boolean O0000Oo0 = false;
    private static TextView O0000OoO = null;

    public static void O000000o(Context context, RemoteViews remoteViews, int i) {
        if (O0000OOo == null) {
            O000000o(context);
        }
        if (O0000OOo.f1421O000000o == O00000o0 && Build.VERSION.SDK_INT >= 21) {
            if (O0000OOo.O00000o0) {
                O0000OOo.f1421O000000o = O00000oo;
            } else {
                O0000OOo.f1421O000000o = O00000o;
            }
        }
        remoteViews.setTextColor(i, O0000OOo.f1421O000000o);
    }

    public static void O00000Oo(Context context, RemoteViews remoteViews, int i) {
        if (O0000OOo == null) {
            O000000o(context);
        }
        if (O0000OOo.O00000Oo == O00000o0 && Build.VERSION.SDK_INT >= 21) {
            if (O0000OOo.O00000o0) {
                O0000OOo.O00000Oo = O0000O0o;
            } else {
                O0000OOo.O00000Oo = O00000oO;
            }
        }
        remoteViews.setTextColor(i, O0000OOo.O00000Oo);
    }

    public static synchronized boolean O000000o(final Context context) {
        boolean z;
        synchronized (iks.class) {
            if (O0000OOo == null) {
                O0000OOo = new O000000o();
                boolean z2 = Looper.myLooper() == Looper.getMainLooper();
                final CountDownLatch countDownLatch = null;
                if (!z2) {
                    countDownLatch = new CountDownLatch(1);
                }
                AnonymousClass1 r3 = new Runnable() {
                    /* class _m_j.iks.AnonymousClass1 */

                    public final void run() {
                        try {
                            int O00000Oo2 = iks.O00000Oo(context);
                            if (O00000Oo2 == iks.O00000o0) {
                                iks.O0000OOo.f1421O000000o = iks.O00000o0;
                                iks.O0000OOo.O00000Oo = iks.O00000o0;
                                iks.O0000OOo.O00000o0 = true;
                            } else {
                                iks.O0000OOo.O00000o0 = !iks.O000000o(O00000Oo2);
                            }
                        } catch (Exception unused) {
                            iks.O0000OOo.f1421O000000o = iks.O00000o0;
                            iks.O0000OOo.O00000Oo = iks.O00000o0;
                            iks.O0000OOo.O00000o0 = true;
                        }
                        if (iks.O0000OOo.f1421O000000o == iks.O00000o0 && Build.VERSION.SDK_INT >= 21) {
                            if (iks.O0000OOo.O00000o0) {
                                iks.O0000OOo.f1421O000000o = iks.O00000oo;
                            } else {
                                iks.O0000OOo.f1421O000000o = iks.O00000o;
                            }
                        }
                        if (iks.O0000OOo.O00000Oo == iks.O00000o0 && Build.VERSION.SDK_INT >= 21) {
                            if (iks.O0000OOo.O00000o0) {
                                iks.O0000OOo.O00000Oo = iks.O0000O0o;
                            } else {
                                iks.O0000OOo.O00000Oo = iks.O00000oO;
                            }
                        }
                        CountDownLatch countDownLatch = countDownLatch;
                        if (countDownLatch != null) {
                            countDownLatch.countDown();
                        }
                    }
                };
                if (z2) {
                    r3.run();
                } else {
                    new Handler(Looper.getMainLooper()).post(r3);
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            z = O0000OOo.O00000o0;
        }
        return z;
    }

    public static int O00000Oo(Context context) {
        ViewGroup viewGroup;
        int i = 0;
        if (Build.VERSION.SDK_INT >= 24 && O0000Oo0) {
            return 0;
        }
        if (Build.VERSION.SDK_INT <= 15) {
            return O00000o0;
        }
        try {
            i = context.getResources().getIdentifier("notification_default", "drawable", context.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Notification.Builder contentText = new Notification.Builder(context).setSmallIcon(i).setContentTitle(f1419O000000o).setContentText(O00000Oo);
        Notification build = contentText.build();
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        if (Build.VERSION.SDK_INT >= 24) {
            viewGroup = (ViewGroup) contentText.createContentView().apply(context, linearLayout);
        } else {
            viewGroup = (ViewGroup) build.contentView.apply(context, linearLayout);
        }
        O000000o(viewGroup, f1419O000000o, O00000Oo);
        TextView textView = O0000Oo;
        if (textView == null) {
            return O00000o0;
        }
        int currentTextColor = textView.getCurrentTextColor();
        O0000OOo.f1421O000000o = currentTextColor;
        TextView textView2 = O0000OoO;
        if (textView2 != null) {
            O0000OOo.O00000Oo = textView2.getCurrentTextColor();
        }
        return currentTextColor;
    }

    private static TextView O000000o(ViewGroup viewGroup, String str, String str2) {
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (textView.getText().equals(f1419O000000o)) {
                    O0000Oo = textView;
                }
                if (textView.getText().equals(O00000Oo)) {
                    O0000OoO = textView;
                }
            } else if (childAt instanceof ViewGroup) {
                O000000o((ViewGroup) childAt, str, str2);
            }
        }
        return null;
    }

    public static boolean O000000o(int i) {
        int i2 = i | -16777216;
        int red = Color.red(-16777216) - Color.red(i2);
        int green = Color.green(-16777216) - Color.green(i2);
        int blue = Color.blue(-16777216) - Color.blue(i2);
        return Math.sqrt((double) (((red * red) + (green * green)) + (blue * blue))) < 180.0d;
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        int f1421O000000o = iks.O00000o0;
        int O00000Oo = iks.O00000o0;
        boolean O00000o0 = true;

        O000000o() {
        }
    }
}
