package com.xiaomi.smarthome.framework.page;

import _m_j.fsm;
import _m_j.fso;
import _m_j.ft;
import _m_j.fvy;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.ArrayList;
import java.util.List;

public class SelectServerEnvActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    Context f7783O000000o;
    O000000o O00000Oo = new O000000o();
    fvy O00000o = new fvy("release");
    List<fvy> O00000o0 = new ArrayList();
    fvy O00000oO = new fvy("preview");

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7783O000000o = this;
        setContentView((int) R.layout.select_server_env_activity);
        findViewById(R.id.empty).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.SelectServerEnvActivity.AnonymousClass1 */

            public final void onClick(View view) {
                SelectServerEnvActivity.this.doCancel();
            }
        });
        ((ListView) findViewById(R.id.listview)).setAdapter((ListAdapter) this.O00000Oo);
        this.O00000o0.add(this.O00000o);
        this.O00000o0.add(this.O00000oO);
        CoreApi.O000000o().O000000o(this, new CoreApi.O0000o0() {
            /* class com.xiaomi.smarthome.framework.page.SelectServerEnvActivity.AnonymousClass2 */

            public final void onCoreReady() {
                SelectServerEnvActivity.this.O00000Oo.notifyDataSetChanged();
            }
        });
        this.O00000Oo.notifyDataSetChanged();
    }

    public void onBackPressed() {
        doCancel();
        super.onBackPressed();
    }

    public void doOK(final fvy fvy, fsm<Void, fso> fsm) {
        if (TextUtils.isEmpty(fvy.f17293O000000o)) {
            doCancel();
            return;
        }
        CoreApi.O000000o().O000000o(this.f7783O000000o, new CoreApi.O0000o0() {
            /* class com.xiaomi.smarthome.framework.page.SelectServerEnvActivity.AnonymousClass3 */

            public final void onCoreReady() {
                CoreApi.O000000o().O00000o0(fvy.f17293O000000o);
            }
        });
        finish();
        overridePendingTransition(0, 0);
        ft O000000o2 = ft.O000000o(this.f7783O000000o);
        Intent intent = new Intent("action_select_server_env_local_broadcast_complete");
        intent.putExtra("param_key", 1);
        O000000o2.O000000o(intent);
    }

    public void doCancel() {
        finish();
        overridePendingTransition(0, 0);
        ft O000000o2 = ft.O000000o(this.f7783O000000o);
        Intent intent = new Intent("action_select_server_env_local_broadcast_complete");
        intent.putExtra("param_key", 2);
        O000000o2.O000000o(intent);
    }

    class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        TextView f7789O000000o;

        O00000Oo() {
        }
    }

    class O000000o extends BaseAdapter {
        public final long getItemId(int i) {
            return (long) i;
        }

        O000000o() {
        }

        public final int getCount() {
            return SelectServerEnvActivity.this.O00000o0.size();
        }

        public final Object getItem(int i) {
            return SelectServerEnvActivity.this.O00000o0.get(i);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final View getView(final int i, View view, ViewGroup viewGroup) {
            O00000Oo o00000Oo;
            if (view == null) {
                view = SelectServerEnvActivity.this.getLayoutInflater().inflate((int) R.layout.international_item, viewGroup, false);
                o00000Oo = new O00000Oo();
                o00000Oo.f7789O000000o = (TextView) view.findViewById(R.id.text);
                view.setTag(o00000Oo);
            } else {
                o00000Oo = (O00000Oo) view.getTag();
                o00000Oo.f7789O000000o.setText("");
            }
            o00000Oo.f7789O000000o.setText(SelectServerEnvActivity.this.O00000o0.get(i).f17293O000000o);
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.SelectServerEnvActivity.O000000o.AnonymousClass1 */

                public final void onClick(View view) {
                    SelectServerEnvActivity.this.doOK(SelectServerEnvActivity.this.O00000o0.get(i), null);
                }
            });
            return view;
        }
    }
}
