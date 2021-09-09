package com.xiaomi.smarthome.ad.view;

import _m_j.eyz;
import _m_j.goy;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.widget.ImageView;
import com.xiaomi.router.miio.miioplugin.IPluginCallback3;
import com.xiaomi.smarthome.R;

public class PopAdView$2 extends IPluginCallback3.Stub {
    final /* synthetic */ eyz this$0;

    public void onFailed() throws RemoteException {
    }

    PopAdView$2(eyz eyz) {
        this.this$0 = eyz;
    }

    public void onSuccess(final Bitmap bitmap) throws RemoteException {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            /* class com.xiaomi.smarthome.ad.view.PopAdView$2.AnonymousClass1 */

            public final void run() {
                Bitmap bitmap = bitmap;
                Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                Paint paint = new Paint();
                Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                RectF rectF = new RectF(rect);
                float O000000o2 = (float) ((int) goy.O000000o(PopAdView$2.this.this$0.getContentView().getContext(), 4.0f));
                paint.setAntiAlias(true);
                canvas.drawARGB(0, 0, 0, 0);
                paint.setColor(-12434878);
                canvas.drawRoundRect(rectF, O000000o2, O000000o2, paint);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                canvas.drawBitmap(bitmap, rect, rect, paint);
                ((ImageView) PopAdView$2.this.this$0.getContentView().findViewById(R.id.pop_ad_pic)).setImageBitmap(createBitmap);
            }
        });
    }
}
