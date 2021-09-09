package com.xiaomi.smarthome.ad.view;

import _m_j.eyx;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.widget.ImageView;
import com.xiaomi.router.miio.miioplugin.IPluginCallback3;

public class BottomFlowAdView$3 extends IPluginCallback3.Stub {
    final /* synthetic */ eyx this$0;
    final /* synthetic */ ImageView val$imageView;

    public void onFailed() throws RemoteException {
    }

    public BottomFlowAdView$3(eyx eyx, ImageView imageView) {
        this.this$0 = eyx;
        this.val$imageView = imageView;
    }

    public void onSuccess(final Bitmap bitmap) throws RemoteException {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            /* class com.xiaomi.smarthome.ad.view.BottomFlowAdView$3.AnonymousClass1 */

            public final void run() {
                BottomFlowAdView$3.this.val$imageView.setImageBitmap(bitmap);
            }
        });
    }
}
