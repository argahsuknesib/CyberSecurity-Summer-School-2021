package com.xiaomi.smarthome.messagecenter.ui;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.hxi;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.family.api.MessageApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.BottomBaseDialog;
import com.xiaomi.smarthome.library.log.LogType;

public class FastConnectFAQActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    BottomBaseDialog f9425O000000o = null;
    private String O00000Oo = null;
    public String mDid = null;

    public static void invokeResultActivity(Activity activity, String str, String str2, int i) {
        Intent intent = new Intent(activity, FastConnectFAQActivity.class);
        intent.putExtra("device_id", str);
        intent.putExtra("router_device_id", str2);
        activity.startActivityForResult(intent, i);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_fast_connect_faq);
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.about_faq);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(this);
        findViewById(R.id.module_a_3_return_more_more_btn).setVisibility(4);
        findViewById(R.id.txt_unregister_fast_connect).setOnClickListener(this);
        findViewById(R.id.txt_fast_connect_define).setOnClickListener(this);
        this.mDid = getIntent().getStringExtra("device_id");
        this.O00000Oo = getIntent().getStringExtra("router_device_id");
        hxi.O00000o0.f957O000000o.O000000o("zerolink_common_show", new Object[0]);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.module_a_3_return_btn) {
            setResult(-1);
            finish();
        } else if (id == R.id.txt_unregister_fast_connect) {
            hxi.O00000o.f952O000000o.O000000o("zerolink_common_click", "type", 2);
            this.f9425O000000o = new BottomBaseDialog(this) {
                /* class com.xiaomi.smarthome.messagecenter.ui.FastConnectFAQActivity.AnonymousClass1 */

                public final View O000000o() {
                    View inflate = LayoutInflater.from(FastConnectFAQActivity.this).inflate((int) R.layout.dialog_confirm_unregister_fast_connect, (ViewGroup) null);
                    ((TextView) inflate.findViewById(R.id.tv_cancel)).setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.messagecenter.ui.FastConnectFAQActivity.AnonymousClass1.AnonymousClass1 */

                        public final void onClick(View view) {
                            hxi.O00000oO.O000000o(2, FastConnectFAQActivity.this.mDid);
                            if (FastConnectFAQActivity.this.f9425O000000o != null) {
                                FastConnectFAQActivity.this.f9425O000000o.dismiss();
                                FastConnectFAQActivity.this.f9425O000000o = null;
                            }
                        }
                    });
                    ((TextView) inflate.findViewById(R.id.tv_ok)).setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.messagecenter.ui.FastConnectFAQActivity.AnonymousClass1.AnonymousClass2 */

                        public final void onClick(View view) {
                            hxi.O00000oO.O000000o(1, FastConnectFAQActivity.this.mDid);
                            FastConnectFAQActivity.this.unregisterFastConnect();
                            if (FastConnectFAQActivity.this.f9425O000000o != null) {
                                FastConnectFAQActivity.this.f9425O000000o.dismiss();
                                FastConnectFAQActivity.this.f9425O000000o = null;
                            }
                        }
                    });
                    return inflate;
                }
            };
            hxi.O00000oO.f958O000000o.O000000o("zerolink_pop_show", new Object[0]);
            this.f9425O000000o.show();
        } else if (id == R.id.txt_fast_connect_define) {
            fbs.O000000o(new fbt(this, "CommonWebViewActivity").O000000o("url", "https://home.mi.com/webapp/common/auto-add.html").O000000o("title", getString(R.string.faq_what_is_fast_connect)));
        }
    }

    public void unregisterFastConnect() {
        MessageApi.instance.unregisterFastConnect(this, this.mDid, this.O00000Oo, new fsm<Boolean, fso>() {
            /* class com.xiaomi.smarthome.messagecenter.ui.FastConnectFAQActivity.AnonymousClass2 */

            public final void onFailure(fso fso) {
                hxi.O00000oO.O00000Oo(2, FastConnectFAQActivity.this.mDid);
                LogType logType = LogType.KUAILIAN;
                StringBuilder sb = new StringBuilder("wugan: unregister fast connect http fail:");
                sb.append(fso != null ? fso.toString() : "");
                gsy.O00000o0(logType, "FastConnectFAQActivity", sb.toString());
                if (fso == null || fso.f17063O000000o != -40130001) {
                    FastConnectFAQActivity.this.showUnregisterFailDialog();
                } else {
                    gqg.O00000Oo((int) R.string.had_unregistered_fast_connect);
                }
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                hxi.O00000oO.O00000Oo(1, FastConnectFAQActivity.this.mDid);
                gsy.O00000o0(LogType.KUAILIAN, "FastConnectFAQActivity", "wugan: unregister fast connect http success");
                FastConnectFAQActivity.this.mHandler.postDelayed(new Runnable() {
                    /* class com.xiaomi.smarthome.messagecenter.ui.FastConnectFAQActivity.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        FastConnectFAQActivity.this.setResult(9);
                        FastConnectFAQActivity.this.finish();
                    }
                }, 800);
            }
        });
    }

    public void showUnregisterFailDialog() {
        this.f9425O000000o = new BottomBaseDialog(this) {
            /* class com.xiaomi.smarthome.messagecenter.ui.FastConnectFAQActivity.AnonymousClass3 */

            public final View O000000o() {
                View inflate = LayoutInflater.from(FastConnectFAQActivity.this).inflate((int) R.layout.dialog_confirm_unregister_fast_connect, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.tv_ok);
                textView.setText((int) R.string.common_retry);
                TextView textView2 = (TextView) inflate.findViewById(R.id.tv_tips_desc);
                ((TextView) inflate.findViewById(R.id.tv_tips_title)).setText((int) R.string.unregister_fast_connect_fail_title);
                textView2.setText((int) R.string.unregister_fast_connect_fail_desc);
                textView2.setGravity(1);
                ((TextView) inflate.findViewById(R.id.tv_cancel)).setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.messagecenter.ui.FastConnectFAQActivity.AnonymousClass3.AnonymousClass1 */

                    public final void onClick(View view) {
                        if (FastConnectFAQActivity.this.f9425O000000o != null) {
                            FastConnectFAQActivity.this.f9425O000000o.dismiss();
                            FastConnectFAQActivity.this.f9425O000000o = null;
                        }
                    }
                });
                textView.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.messagecenter.ui.FastConnectFAQActivity.AnonymousClass3.AnonymousClass2 */

                    public final void onClick(View view) {
                        FastConnectFAQActivity.this.unregisterFastConnect();
                        if (FastConnectFAQActivity.this.f9425O000000o != null) {
                            FastConnectFAQActivity.this.f9425O000000o.dismiss();
                        }
                    }
                });
                return inflate;
            }
        };
        this.f9425O000000o.show();
    }
}
