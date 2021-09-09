package com.xiaomi.smarthome.miio.activity;

import _m_j.fju;
import _m_j.fjw;
import _m_j.fsm;
import _m_j.fso;
import _m_j.fuj;
import _m_j.gqg;
import _m_j.hal;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class UnitSettingActivity extends BaseActivity {
    public String current = ((String) fju.O000000o().O00000Oo("℃").first);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.unit_setting_layout);
        TextView textView = (TextView) findViewById(R.id.temp_content);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.$$Lambda$UnitSettingActivity$YfRxKIsz7JrwcGBtUgnUZVr6ZXA */

            public final void onClick(View view) {
                UnitSettingActivity.this.O000000o(view);
            }
        });
        textView.setText(fjw.O00000o0.get(this.current).intValue());
        ArrayList arrayList = new ArrayList(fjw.O00000Oo.get("℃").keySet());
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(getString(fjw.O00000o0.get((String) it.next()).intValue()));
        }
        textView.setOnClickListener(new View.OnClickListener(textView, arrayList2, arrayList) {
            /* class com.xiaomi.smarthome.miio.activity.$$Lambda$UnitSettingActivity$7_AyGPNHv3QuGzEirNt5bvWL_4 */
            private final /* synthetic */ TextView f$1;
            private final /* synthetic */ ArrayList f$2;
            private final /* synthetic */ ArrayList f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void onClick(View view) {
                UnitSettingActivity.this.O000000o(this.f$1, this.f$2, this.f$3, view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        onBackPressed();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(TextView textView, ArrayList arrayList, ArrayList arrayList2, View view) {
        new hal(textView, arrayList, arrayList2.indexOf(this.current), new AdapterView.OnItemClickListener(arrayList2, textView) {
            /* class com.xiaomi.smarthome.miio.activity.$$Lambda$UnitSettingActivity$51oY7pkOLhFZVuzsDKV_G1fCZgs */
            private final /* synthetic */ ArrayList f$1;
            private final /* synthetic */ TextView f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                UnitSettingActivity.this.O000000o(this.f$1, this.f$2, adapterView, view, i, j);
            }
        }).O000000o();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(ArrayList arrayList, final TextView textView, AdapterView adapterView, View view, int i, long j) {
        this.current = (String) arrayList.get(i);
        fuj.O000000o();
        fuj.O000000o(getContext(), "miot_temperature_style", this.current.equals("℃") ? "c" : "f", new fsm<JSONObject, fso>() {
            /* class com.xiaomi.smarthome.miio.activity.UnitSettingActivity.AnonymousClass1 */

            public final void onFailure(fso fso) {
                gqg.O00000Oo((int) R.string.retry_network);
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                fju.O000000o().O000000o("℃", UnitSettingActivity.this.current);
                textView.setText(fjw.O00000o0.get(UnitSettingActivity.this.current).intValue());
            }
        });
    }
}
