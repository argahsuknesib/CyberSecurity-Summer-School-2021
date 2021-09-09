package _m_j;

import android.content.Context;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.ad.api.AdPosition;
import com.xiaomi.smarthome.ad.api.Advertisement;
import com.xiaomi.smarthome.ad.view.BottomFlowAdView$3;

public final class eyx extends PopupWindow {
    public eyx(Context context, AdPosition adPosition) {
        super(LayoutInflater.from(context.getApplicationContext()).inflate((int) R.layout.view_ad_bottom_flow, (ViewGroup) null), -1, -2);
        final Advertisement O000000o2 = eyy.O000000o(adPosition);
        setTouchable(true);
        setFocusable(false);
        setOutsideTouchable(false);
        ((TextView) getContentView().findViewById(R.id.title)).setText(O000000o2.O0000O0o);
        ((TextView) getContentView().findViewById(R.id.message)).setText(O000000o2.O0000OOo);
        ImageView imageView = (ImageView) getContentView().findViewById(R.id.image);
        if (etx.O000000o().O00000Oo() != null) {
            try {
                etx.O000000o().O00000Oo().loadBitmap(O000000o2.O00000o, new BottomFlowAdView$3(this, imageView));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        getContentView().findViewById(R.id.close_image).setOnClickListener(new View.OnClickListener() {
            /* class _m_j.eyx.AnonymousClass1 */

            public final void onClick(View view) {
                eyy.O00000Oo(O000000o2);
                eyx.this.dismiss();
            }
        });
        getContentView().setOnClickListener(new View.OnClickListener() {
            /* class _m_j.eyx.AnonymousClass2 */

            public final void onClick(View view) {
                fsp.O000000o().O0000Oo.loadWebView(O000000o2.O00000oO, "");
                eyy.O000000o();
                eyx.this.dismiss();
            }
        });
        eyy.O000000o(O000000o2);
    }
}
