package com.xiaomi.smarthome.ad.view;

import _m_j.etx;
import _m_j.eyy;
import _m_j.eyz;
import _m_j.fsp;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.ad.api.Advertisement;
import com.xiaomi.smarthome.framework.page.BaseActivity;

public class PopAdActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private eyz f4162O000000o;
    private View O00000Oo;
    public Advertisement mAd;

    public void onBackPressed() {
    }

    public static void start(Activity activity, Advertisement advertisement) {
        Intent intent = new Intent(activity, PopAdActivity.class);
        intent.putExtra("advertisement", advertisement);
        activity.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_ad_pop);
        this.mAd = (Advertisement) getIntent().getParcelableExtra("advertisement");
        this.f4162O000000o = new eyz(this);
        eyz eyz = this.f4162O000000o;
        Advertisement advertisement = this.mAd;
        ((TextView) eyz.getContentView().findViewById(R.id.title)).setText(advertisement.O00000Oo);
        eyz.getContentView().findViewById(R.id.pop_ad_close).setOnClickListener(new View.OnClickListener(advertisement) {
            /* class _m_j.eyz.AnonymousClass1 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ Advertisement f15965O000000o;

            {
                this.f15965O000000o = r2;
            }

            public final void onClick(View view) {
                eyy.O00000Oo(this.f15965O000000o);
                eyz.this.dismiss();
            }
        });
        if (etx.O000000o().O00000Oo() != null) {
            try {
                etx.O000000o().O00000Oo().loadBitmap(advertisement.O00000o, new PopAdView$2(eyz));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        eyz.getContentView().findViewById(R.id.jump_to_product).setOnClickListener(new View.OnClickListener() {
            /* class _m_j.eyz.AnonymousClass2 */

            public final void onClick(View view) {
                if (eyz.this.f15964O000000o != null) {
                    eyz.this.f15964O000000o.onClick(view);
                }
            }
        });
        this.f4162O000000o.f15964O000000o = new View.OnClickListener() {
            /* class com.xiaomi.smarthome.ad.view.PopAdActivity.AnonymousClass1 */

            public final void onClick(View view) {
                fsp.O000000o().O0000Oo.loadWebView(PopAdActivity.this.mAd.O00000oO, "");
                eyy.O000000o();
                PopAdActivity.this.finish();
            }
        };
        this.f4162O000000o.setOnDismissListener(new PopupWindow.OnDismissListener() {
            /* class com.xiaomi.smarthome.ad.view.PopAdActivity.AnonymousClass2 */

            public final void onDismiss() {
                PopAdActivity.this.finish();
            }
        });
        this.O00000Oo = findViewById(R.id.float_ad_ancher);
    }

    public void onWindowFocusChanged(boolean z) {
        eyz eyz;
        super.onWindowFocusChanged(z);
        if (z && (eyz = this.f4162O000000o) != null && !eyz.isShowing()) {
            this.f4162O000000o.showAtLocation(this.O00000Oo, 17, 0, 0);
            eyy.O000000o(this.mAd);
        }
    }

    public void onResume() {
        overridePendingTransition(R.anim.float_ad_enter, R.anim.float_ad_exist);
        super.onResume();
    }

    public void onPause() {
        overridePendingTransition(R.anim.float_ad_enter, R.anim.float_ad_exist);
        super.onPause();
    }
}
