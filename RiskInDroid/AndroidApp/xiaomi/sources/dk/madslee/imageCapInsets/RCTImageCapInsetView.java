package dk.madslee.imageCapInsets;

import _m_j.iqe;
import _m_j.iqf;
import _m_j.iqg;
import _m_j.iqh;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;

public class RCTImageCapInsetView extends ImageView {
    public Rect mCapInsets = new Rect();
    private String mUri;

    public RCTImageCapInsetView(Context context) {
        super(context);
    }

    public void setCapInsets(Rect rect) {
        this.mCapInsets = rect;
        reload();
    }

    public void setSource(String str) {
        this.mUri = str;
        reload();
    }

    public void reload() {
        if (TextUtils.isEmpty(this.mUri)) {
            Log.w("RCTImageCapInsetView", "reload error: mUri is empty");
            return;
        }
        final String str = this.mUri + "-" + this.mCapInsets.toShortString();
        final iqe O000000o2 = iqe.O000000o();
        if (O000000o2.O00000Oo(str)) {
            setBackground(O000000o2.O000000o(str).getConstantState().newDrawable());
        } else {
            new iqh(this.mUri, getContext(), new iqg() {
                /* class dk.madslee.imageCapInsets.RCTImageCapInsetView.AnonymousClass1 */

                public final void O000000o(Bitmap bitmap) {
                    int round = Math.round((float) (bitmap.getDensity() / 160));
                    int i = RCTImageCapInsetView.this.mCapInsets.top * round;
                    int width = bitmap.getWidth() - (RCTImageCapInsetView.this.mCapInsets.right * round);
                    int height = bitmap.getHeight() - (RCTImageCapInsetView.this.mCapInsets.bottom * round);
                    NinePatchDrawable O000000o2 = iqf.O000000o(RCTImageCapInsetView.this.getResources(), bitmap, i, RCTImageCapInsetView.this.mCapInsets.left * round, height, width);
                    RCTImageCapInsetView.this.setBackground(O000000o2);
                    O000000o2.O000000o(str, O000000o2);
                }
            }).execute(new String[0]);
        }
    }
}
