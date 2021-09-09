package com.mi.global.shop.activity;

import _m_j.byl;
import _m_j.cak;
import _m_j.cal;
import _m_j.cam;
import _m_j.cav;
import _m_j.cec;
import _m_j.ced;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.ReplacementTransformationMethod;
import android.view.View;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.android.volley.Request;
import com.mi.global.shop.newmodel.BaseResult;
import com.mi.global.shop.newmodel.user.address.GSTResult;
import com.mi.global.shop.widget.CustomEditTextView;
import com.mi.global.shop.widget.XEditText;
import com.xiaomi.smarthome.R;

public class GSTActivity extends BaseActivity implements View.OnClickListener {
    private static final String O00000o = "GSTActivity";

    /* renamed from: O000000o  reason: collision with root package name */
    Context f4625O000000o;
    O000000o O00000Oo;
    cak O00000o0;
    public String bgString = "22  AAAAA0000A  1Z5";
    @BindView(2131492987)
    CustomEditTextView bg_gst;
    @BindView(2131493009)
    Button bt_gst;
    @BindView(2131493010)
    Button bt_gst_cancel;
    @BindView(2131493283)
    XEditText ed_gst;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4625O000000o = this;
        O000000o((int) R.layout.shop_activity_gst);
        ButterKnife.bind(this);
        setTitle(getString(R.string.gst_title));
        this.mBackView.setVisibility(0);
        this.mCartView.setVisibility(4);
        this.ed_gst.setInputLength(15);
        this.ed_gst.setSeparator(" ", 2);
        this.ed_gst.setPattern(new int[]{2, 10, 3});
        if (this.O00000Oo == null) {
            this.O00000Oo = new O000000o();
        }
        this.bg_gst.setTransformationMethod(this.O00000Oo);
        this.bg_gst.setText(this.bgString);
        this.ed_gst.setTransformationMethod(this.O00000Oo);
        this.ed_gst.setFinishedEditListener(new XEditText.O000000o() {
            /* class com.mi.global.shop.activity.GSTActivity.AnonymousClass1 */

            public final void O000000o(boolean z) {
                if (z) {
                    GSTActivity.this.bt_gst.setBackgroundResource(R.color.orange_red);
                    GSTActivity.this.bt_gst.setClickable(true);
                } else {
                    GSTActivity.this.bt_gst.setBackgroundResource(R.color.order_grey);
                    GSTActivity.this.bt_gst.setClickable(false);
                }
                int length = GSTActivity.this.ed_gst.getText().toString().trim().length();
                if (length == 0) {
                    GSTActivity.this.bg_gst.setText(GSTActivity.this.bgString);
                    return;
                }
                GSTActivity.this.bg_gst.setText(GSTActivity.this.ed_gst.getText().toString().trim() + GSTActivity.this.bgString.substring(length, GSTActivity.this.bgString.length()));
            }
        });
        this.bt_gst_cancel.setOnClickListener(this);
        this.bt_gst.setOnClickListener(this);
        String stringExtra = getIntent().getStringExtra(CheckoutActivity.GST_CODE_S);
        if (!TextUtils.isEmpty(stringExtra)) {
            this.ed_gst.setText(stringExtra);
        } else {
            this.bt_gst.setClickable(false);
        }
    }

    public String getGSTUrl(String str) {
        Uri.Builder buildUpon = Uri.parse(cav.O0000o0o()).buildUpon();
        buildUpon.appendQueryParameter("invoice_company_code", str);
        if (byl.O0000OoO()) {
            buildUpon.appendQueryParameter("ot", "5");
        }
        return buildUpon.toString();
    }

    public void onStop() {
        this.O00000o0 = null;
        super.onStop();
    }

    public void onClick(View view) {
        Request request;
        int id = view.getId();
        if (id == R.id.bt_gst_cancel) {
            Intent intent = new Intent();
            intent.putExtra(CheckoutActivity.GST_CODE_S, "");
            setResult(-1, intent);
            finish();
        } else if (id == R.id.bt_gst) {
            final String replaceAll = this.ed_gst.getText().toString().trim().toUpperCase().replaceAll(" ", "");
            showLoading();
            String gSTUrl = getGSTUrl(replaceAll);
            if (this.O00000o0 == null) {
                this.O00000o0 = new cak<GSTResult>() {
                    /* class com.mi.global.shop.activity.GSTActivity.AnonymousClass2 */

                    public final /* synthetic */ void O000000o(BaseResult baseResult) {
                        GSTResult gSTResult = (GSTResult) baseResult;
                        GSTActivity.this.hideLoading();
                        if (gSTResult.data.valid) {
                            Intent intent = new Intent();
                            intent.putExtra(CheckoutActivity.GST_CODE_S, replaceAll);
                            GSTActivity.this.setResult(-1, intent);
                            GSTActivity.this.finish();
                            return;
                        }
                        cec.O000000o(GSTActivity.this.f4625O000000o, gSTResult.errmsg, 1);
                    }

                    public final void O000000o(String str) {
                        super.O000000o(str);
                        GSTActivity.this.hideLoading();
                        cec.O000000o(GSTActivity.this.f4625O000000o, str, 0);
                    }
                };
            }
            if (byl.O0000OoO()) {
                request = new cam(gSTUrl, GSTResult.class, this.O00000o0);
            } else {
                request = new cal(gSTUrl, GSTResult.class, this.O00000o0);
            }
            request.setTag(O00000o);
            ced.f13683O000000o.add(request);
        }
    }

    class O000000o extends ReplacementTransformationMethod {
        O000000o() {
        }

        /* access modifiers changed from: protected */
        public final char[] getOriginal() {
            return new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        }

        /* access modifiers changed from: protected */
        public final char[] getReplacement() {
            return new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        }
    }
}
