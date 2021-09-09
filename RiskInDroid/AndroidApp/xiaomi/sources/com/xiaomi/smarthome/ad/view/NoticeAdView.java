package com.xiaomi.smarthome.ad.view;

import _m_j.eyy;
import _m_j.fsp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.ad.api.AdPosition;
import com.xiaomi.smarthome.ad.api.Advertisement;

public class NoticeAdView extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public Advertisement f4159O000000o;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.smarthome.ad.view.NoticeAdView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public NoticeAdView(Context context) {
        super(context);
        LayoutInflater.from(getContext().getApplicationContext()).inflate((int) R.layout.view_ad_notice, (ViewGroup) this, true);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    }

    public void setNotice(AdPosition adPosition) {
        this.f4159O000000o = eyy.O000000o(adPosition);
        ((TextView) findViewById(R.id.title)).setText(this.f4159O000000o.O00000oo);
        findViewById(R.id.title).requestFocus();
        setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.ad.view.NoticeAdView.AnonymousClass1 */

            public final void onClick(View view) {
                fsp.O000000o().O0000Oo.loadWebView(NoticeAdView.this.f4159O000000o.O00000oO, "");
                eyy.O000000o();
            }
        });
        findViewById(R.id.ad_notice_close).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.ad.view.NoticeAdView.AnonymousClass2 */

            public final void onClick(View view) {
                ViewGroup viewGroup = (ViewGroup) NoticeAdView.this.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(NoticeAdView.this);
                }
                eyy.O00000Oo(NoticeAdView.this.f4159O000000o);
            }
        });
        eyy.O000000o(this.f4159O000000o);
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
