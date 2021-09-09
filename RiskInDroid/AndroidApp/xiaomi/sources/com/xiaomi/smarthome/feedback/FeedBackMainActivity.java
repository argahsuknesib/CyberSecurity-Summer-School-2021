package com.xiaomi.smarthome.feedback;

import _m_j.fcn;
import _m_j.fno;
import _m_j.ftn;
import _m_j.ggb;
import _m_j.gup;
import _m_j.gva;
import _m_j.hte;
import _m_j.hxi;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FeedBackMainActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private GridView f7371O000000o;
    private GridView O00000Oo;
    private List<String> O00000o = new ArrayList();
    private List<String> O00000o0 = new ArrayList();
    private gup O00000oO = new gup() {
        /* class com.xiaomi.smarthome.feedback.FeedBackMainActivity.AnonymousClass1 */

        public final void O000000o(int i) {
        }

        public final void O000000o(boolean z, boolean z2) {
        }

        public final void O00000Oo(boolean z, boolean z2) {
        }

        public final void O00000Oo(int i) {
            FeedBackMainActivity feedBackMainActivity = FeedBackMainActivity.this;
            feedBackMainActivity.mRedCount = i;
            if (feedBackMainActivity.mRedView != null) {
                FeedBackMainActivity.this.mRedView.setVisibility(FeedBackMainActivity.this.mRedCount == 0 ? 8 : 0);
            }
        }
    };
    public FeedBackAdapter mMyDeviceFeedbackAdapter;
    public FeedBackAdapter mOtherFeedbackAdapter;
    public int mRedCount = 0;
    public View mRedView;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.feed_back_main_layout);
        this.mMyDeviceFeedbackAdapter = new FeedBackAdapter(this);
        this.mOtherFeedbackAdapter = new FeedBackAdapter(this);
        this.mRedCount = getIntent().getIntExtra("red_count", 0);
        ArrayList<Device> arrayList = new ArrayList<>();
        Home O0000Oo0 = ggb.O00000Oo().O0000Oo0();
        if (O0000Oo0 == null || O0000Oo0.isOwner()) {
            arrayList.addAll(fno.O000000o().O0000O0o().values());
        } else {
            arrayList.addAll(ggb.O00000Oo().O0000Oo(ggb.O00000Oo().O0000OOo()));
        }
        for (Device device : arrayList) {
            if (!device.isSubDevice() && !device.isVirtualDevice() && !this.O00000o0.contains(device.model)) {
                this.O00000o0.add(device.model);
            }
        }
        this.O00000o.add("exp");
        if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
            this.O00000o.add("shop");
        }
        this.O00000o.add("automation");
        this.O00000o.add("blegateway");
        if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
            this.O00000o.add("account");
        }
        this.O00000o.add("other");
        TextView textView = (TextView) findViewById(R.id.module_a_3_return_title);
        if (textView != null) {
            textView.setText((int) R.string.feedback_title);
        }
        View findViewById = findViewById(R.id.module_a_3_return_btn);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.feedback.FeedBackMainActivity.AnonymousClass2 */

                public final void onClick(View view) {
                    FeedBackMainActivity.this.finish();
                }
            });
        }
        View findViewById2 = findViewById(R.id.image_button);
        if (findViewById2 != null) {
            findViewById2.setVisibility(0);
            findViewById2.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.feedback.FeedBackMainActivity.AnonymousClass3 */

                public final void onClick(View view) {
                    Intent intent = new Intent();
                    FeedBackMainActivity feedBackMainActivity = FeedBackMainActivity.this;
                    feedBackMainActivity.mRedCount = 0;
                    intent.setClass(feedBackMainActivity.getContext(), FeedbackHistoryActivity.class);
                    FeedBackMainActivity.this.startActivity(intent);
                }
            });
        }
        this.f7371O000000o = (GridView) findViewById(R.id.feed_back_my_device_grid_view);
        this.O00000Oo = (GridView) findViewById(R.id.feed_back_more_grid_view);
        this.f7371O000000o.setAdapter((ListAdapter) this.mMyDeviceFeedbackAdapter);
        this.mMyDeviceFeedbackAdapter.O000000o(this.O00000o0);
        this.mRedView = findViewById(R.id.image_new_tag);
        this.f7371O000000o.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.xiaomi.smarthome.feedback.FeedBackMainActivity.AnonymousClass4 */

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                String str = (String) FeedBackMainActivity.this.mMyDeviceFeedbackAdapter.getItem(i);
                if (str != null && !str.isEmpty()) {
                    Intent intent = new Intent();
                    intent.setClass(FeedBackMainActivity.this.getContext(), FeedbackCommonProblemActivity.class);
                    intent.putExtra("extra_model", str);
                    intent.putExtra("did", FeedBackMainActivity.this.getOnlyOneDeviceDidByModel(str));
                    intent.putExtra("extra_type", 0);
                    FeedBackMainActivity.this.startActivity(intent);
                }
            }
        });
        this.O00000Oo.setAdapter((ListAdapter) this.mOtherFeedbackAdapter);
        this.mOtherFeedbackAdapter.O000000o(this.O00000o);
        this.O00000Oo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.xiaomi.smarthome.feedback.FeedBackMainActivity.AnonymousClass5 */

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                String str = (String) FeedBackMainActivity.this.mOtherFeedbackAdapter.getItem(i);
                if (str != null && !str.isEmpty()) {
                    if (str.equals("account")) {
                        hxi.O00000o.f952O000000o.O000000o("faq_zhanghao.clk", "time", Long.valueOf(System.currentTimeMillis()), "uid", fcn.O000000o().O00000Oo());
                    }
                    Intent intent = new Intent();
                    intent.setClass(FeedBackMainActivity.this.getContext(), FeedbackCommonProblemActivity.class);
                    intent.putExtra("extra_model", str);
                    intent.putExtra("extra_type", i + 1);
                    FeedBackMainActivity.this.startActivity(intent);
                }
            }
        });
        this.O00000Oo.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* class com.xiaomi.smarthome.feedback.FeedBackMainActivity.AnonymousClass6 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
             arg types: [java.lang.String, int]
             candidates:
              ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i != 0) {
                    return false;
                }
                FeedBackMainActivity.this.sendBroadcast(new Intent("mijia_log_greydeveloper").putExtra("showlog", true));
                hte.O000000o(FeedBackMainActivity.this, (int) R.string.enable_greylog);
                return false;
            }
        });
    }

    public void onResume() {
        super.onResume();
        gva.O000000o().registerListener("new_feedback", this.O00000oO);
        gva.O000000o().checkFeedback();
    }

    public void onPause() {
        super.onPause();
        gva.O000000o().unregisterListener("new_feedback", this.O00000oO);
    }

    public String getOnlyOneDeviceDidByModel(String str) {
        int i = 0;
        String str2 = "";
        for (Map.Entry next : fno.O000000o().O00000oO().entrySet()) {
            if (next.getValue() != null && TextUtils.equals(((Device) next.getValue()).model, str)) {
                i++;
                str2 = ((Device) next.getValue()).did;
            }
        }
        if (i != 1 || TextUtils.isEmpty(str2)) {
            return "";
        }
        return str2;
    }
}
