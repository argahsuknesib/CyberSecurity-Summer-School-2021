package com.xiaomi.smarthome.framework.plugin.rn.viewmanager;

import _m_j.fyc;
import _m_j.htc;
import _m_j.iqe;
import _m_j.iqf;
import _m_j.iqg;
import _m_j.iqh;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import com.facebook.react.uimanager.ThemedReactContext;
import dk.madslee.imageCapInsets.RCTImageCapInsetManager;
import dk.madslee.imageCapInsets.RCTImageCapInsetView;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MiotImageCapInsetManager extends RCTImageCapInsetManager {
    public RCTImageCapInsetView createViewInstance(ThemedReactContext themedReactContext) {
        return new RCTImageCapInsetView(themedReactContext) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.MiotImageCapInsetManager.AnonymousClass1 */
            public boolean isLocalFile = false;
            private Rect mCapInsets = new Rect();
            public String mUri;

            public void setCapInsets(Rect rect) {
                this.mCapInsets = rect;
                reload();
            }

            public void setSource(String str) {
                this.isLocalFile = str.startsWith("file://");
                this.mUri = str;
                reload();
            }

            public void reload() {
                if (TextUtils.isEmpty(this.mUri)) {
                    fyc.O00000o0("MiotImageCapInsetManager", "MiotImageCapInsetManager.RCTImageCapInsetView,reload error: mUri is empty");
                    return;
                }
                final String str = this.mUri + "-" + this.mCapInsets.toShortString();
                final iqe O000000o2 = iqe.O000000o();
                if (O000000o2.O00000Oo(str)) {
                    setBackground(O000000o2.O000000o(str).getConstantState().newDrawable());
                } else {
                    new iqh(this.mUri, getContext(), new iqg() {
                        /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.MiotImageCapInsetManager.AnonymousClass1.AnonymousClass1 */

                        public final void O000000o(Bitmap bitmap) {
                            AnonymousClass1.this.reloadImage(O000000o2, str, bitmap);
                        }
                    }) {
                        /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.MiotImageCapInsetManager.AnonymousClass1.AnonymousClass2 */

                        /* renamed from: O000000o */
                        public final Bitmap doInBackground(String... strArr) {
                            if (!AnonymousClass1.this.isLocalFile) {
                                return super.doInBackground(strArr);
                            }
                            AnonymousClass1 r2 = AnonymousClass1.this;
                            return r2.loadBitmap(r2.mUri);
                        }
                    }.execute(new String[0]);
                }
            }

            public void reloadImage(iqe iqe, String str, Bitmap bitmap) {
                int round = Math.round((float) (bitmap.getDensity() / 160));
                int i = this.mCapInsets.top * round;
                int width = bitmap.getWidth() - (this.mCapInsets.right * round);
                int height = bitmap.getHeight() - (this.mCapInsets.bottom * round);
                NinePatchDrawable O000000o2 = iqf.O000000o(getResources(), bitmap, i, this.mCapInsets.left * round, height, width);
                setBackground(O000000o2);
                iqe.O000000o(str, O000000o2);
            }

            /* JADX INFO: additional move instructions added (1) to help type inference */
            /* JADX WARN: Type inference failed for: r0v0 */
            /* JADX WARN: Type inference failed for: r0v1, types: [java.io.Closeable] */
            /* JADX WARN: Type inference failed for: r0v2, types: [android.graphics.Bitmap] */
            /* JADX WARN: Type inference failed for: r0v4 */
            /* JADX WARN: Type inference failed for: r0v6 */
            /* JADX WARNING: Multi-variable type inference failed */
            /* JADX WARNING: Unknown variable types count: 1 */
            public Bitmap loadBitmap(String str) {
                Throwable th;
                InputStream inputStream;
                ? r0 = 0;
                try {
                    inputStream = new URL(str).openStream();
                    try {
                        r0 = BitmapFactory.decodeStream(inputStream);
                    } catch (IOException e) {
                        e = e;
                        try {
                            e.printStackTrace();
                            htc.O000000o(inputStream);
                            return r0;
                        } catch (Throwable th2) {
                            Throwable th3 = th2;
                            r0 = inputStream;
                            th = th3;
                            htc.O000000o(r0);
                            throw th;
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    inputStream = null;
                    e.printStackTrace();
                    htc.O000000o(inputStream);
                    return r0;
                } catch (Throwable th4) {
                    th = th4;
                    htc.O000000o(r0);
                    throw th;
                }
                htc.O000000o(inputStream);
                return r0;
            }
        };
    }
}
