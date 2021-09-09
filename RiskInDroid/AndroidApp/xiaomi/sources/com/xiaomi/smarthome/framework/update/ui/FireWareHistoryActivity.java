package com.xiaomi.smarthome.framework.update.ui;

import _m_j.fsm;
import _m_j.fso;
import _m_j.gfb;
import _m_j.gff;
import _m_j.gsy;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.log.LogType;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class FireWareHistoryActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    RecyclerView.O000000o f8693O000000o = new RecyclerView.O000000o() {
        /* class com.xiaomi.smarthome.framework.update.ui.FireWareHistoryActivity.AnonymousClass3 */

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new O000000o(LayoutInflater.from(FireWareHistoryActivity.this.getContext()).inflate((int) R.layout.fireware_update_history_reycler_item, viewGroup, false));
        }

        public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            O000000o o000000o = (O000000o) o000OOo0;
            gff gff = FireWareHistoryActivity.this.mDatas.get(i);
            o000000o.f8697O000000o.setText(String.valueOf(gff.O00000o));
            o000000o.O00000Oo.setText(new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(gff.O00000o0 * 1000)));
            if (gff.O00000Oo == 0) {
                o000000o.O00000o0.setText((int) R.string.update_manual);
            } else {
                o000000o.O00000o0.setText((int) R.string.update_auto);
            }
            o000000o.O00000o.setText(gff.O00000oo);
        }

        public final int getItemCount() {
            return FireWareHistoryActivity.this.mDatas.size();
        }

        /* renamed from: com.xiaomi.smarthome.framework.update.ui.FireWareHistoryActivity$3$O000000o */
        class O000000o extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            public TextView f8697O000000o;
            public TextView O00000Oo;
            public TextView O00000o;
            public TextView O00000o0;

            public O000000o(View view) {
                super(view);
                this.f8697O000000o = (TextView) view.findViewById(R.id.tv_version);
                this.O00000Oo = (TextView) view.findViewById(R.id.tv_date);
                this.O00000o0 = (TextView) view.findViewById(R.id.tv_update_type);
                this.O00000o = (TextView) view.findViewById(R.id.tv_change_log);
            }
        }
    };
    private String O00000Oo;
    private RecyclerView O00000o0;
    public List<gff> mDatas = new ArrayList();
    public TextView mNoUpdateHistory;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_fireware_history);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.update.ui.FireWareHistoryActivity.AnonymousClass1 */

            public final void onClick(View view) {
                FireWareHistoryActivity.this.finish();
            }
        });
        this.O00000Oo = getIntent().getStringExtra("did");
        this.O00000o0 = (RecyclerView) findViewById(R.id.recycler);
        this.O00000o0.setLayoutManager(new LinearLayoutManager(this));
        this.O00000o0.setAdapter(this.f8693O000000o);
        this.mNoUpdateHistory = (TextView) findViewById(R.id.txt_no_update_history);
        gfb.O000000o();
        gfb.O00000o0(this, this.O00000Oo, new fsm<List<gff>, fso>() {
            /* class com.xiaomi.smarthome.framework.update.ui.FireWareHistoryActivity.AnonymousClass2 */

            public final /* synthetic */ void onSuccess(Object obj) {
                List list = (List) obj;
                FireWareHistoryActivity fireWareHistoryActivity = FireWareHistoryActivity.this;
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf((list == null || list.isEmpty()) ? 0 : list.size());
                fireWareHistoryActivity.writeLog("requestData:getUpgradeHistory onSuccess, result list size=%d", objArr);
                FireWareHistoryActivity.this.mDatas.clear();
                FireWareHistoryActivity.this.mDatas.addAll(list);
                FireWareHistoryActivity.this.f8693O000000o.notifyDataSetChanged();
                if (FireWareHistoryActivity.this.mDatas.isEmpty()) {
                    FireWareHistoryActivity.this.mNoUpdateHistory.setVisibility(0);
                } else {
                    FireWareHistoryActivity.this.mNoUpdateHistory.setVisibility(8);
                }
            }

            public final void onFailure(fso fso) {
                if (fso != null) {
                    FireWareHistoryActivity.this.writeLog("requestData:getUpgradeHistory onFailure, code=%d,detail=%s", Integer.valueOf(fso.f17063O000000o), fso.O00000Oo);
                    return;
                }
                FireWareHistoryActivity.this.writeLog("requestData:getUpgradeHistory onFailure, error is null", new Object[0]);
            }
        });
    }

    public void writeLog(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(str, objArr);
        }
        gsy.O00000o0(LogType.OTA, "FireWareHistoryActivity", str);
    }
}
