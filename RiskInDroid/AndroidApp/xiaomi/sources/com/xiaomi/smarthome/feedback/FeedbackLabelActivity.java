package com.xiaomi.smarthome.feedback;

import _m_j.ezb;
import _m_j.ezc;
import _m_j.fsm;
import _m_j.fso;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FeedbackLabelActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    List<FeedbackLabelEntity> f7415O000000o = new ArrayList();
    private RecyclerView O00000Oo;
    private String O00000o0;
    public List<FeedbackLabelEntity> mResult = new ArrayList();
    public String tid;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_feedbacklabel);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(this);
        Intent intent = getIntent();
        this.O00000o0 = intent.getStringExtra("Wid");
        this.tid = intent.getStringExtra("tagid");
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.feedback_type_title);
        this.O00000Oo = (RecyclerView) findViewById(R.id.rv);
        this.O00000Oo.setLayoutManager(new LinearLayoutManager(this));
        this.O00000Oo.setAdapter(new O000000o(this, this.f7415O000000o));
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("data");
        if (parcelableArrayListExtra == null) {
            FeedbackApi.INSTANCE.requestLabels(this, getIntent().getStringExtra("model"), new fsm<ArrayList<FeedbackLabelEntity>, fso>() {
                /* class com.xiaomi.smarthome.feedback.FeedbackLabelActivity.AnonymousClass1 */

                public final void onFailure(fso fso) {
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    ArrayList arrayList = (ArrayList) obj;
                    if (arrayList != null) {
                        FeedbackLabelActivity.this.mResult.addAll(arrayList);
                    }
                    FeedbackLabelActivity.this.transformData();
                }
            });
            return;
        }
        this.mResult.addAll(parcelableArrayListExtra);
        transformData();
    }

    public void transformData() {
        this.f7415O000000o.clear();
        boolean z = this.mResult.size() == 1;
        for (FeedbackLabelEntity next : this.mResult) {
            if (!z) {
                this.f7415O000000o.add(next);
            }
            if (next.O00000oO == null) {
                next.O00000o = 3;
            } else {
                if (TextUtils.equals(this.O00000o0, next.f7417O000000o) || z) {
                    next.O00000o = 1;
                    this.f7415O000000o.addAll(next.O00000oO);
                } else {
                    next.O00000o = 2;
                }
                Iterator<FeedbackLabelEntity> it = next.O00000oO.iterator();
                while (it.hasNext()) {
                    it.next().O00000o = 3;
                }
            }
        }
        this.O00000Oo.getAdapter().notifyDataSetChanged();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.module_a_3_return_btn) {
            onBackPressed();
        }
    }

    class O000000o extends ezb<FeedbackLabelEntity> implements ezb.O000000o {
        public final int O00000o0(int i) {
            return i != 0 ? (i == 1 || i == 2 || i != 3) ? R.layout.item_feedback_label_categroy : R.layout.item_feedback_label_child : R.layout.item_feedback_title;
        }

        public final /* synthetic */ void O000000o(ezc ezc, Object obj, int i) {
            FeedbackLabelEntity feedbackLabelEntity = (FeedbackLabelEntity) obj;
            if (feedbackLabelEntity != null) {
                TextView textView = (TextView) ezc.O000000o((int) R.id.tv_name);
                if (textView != null) {
                    textView.setText(feedbackLabelEntity.O00000o0);
                }
                View O000000o2 = ezc.O000000o((int) R.id.v_background);
                if (O000000o2 != null && textView != null) {
                    int i2 = feedbackLabelEntity.O00000o;
                    if (i2 == 1) {
                        O000000o2.setBackgroundResource(R.drawable.drop_down_up);
                    } else if (i2 == 2) {
                        O000000o2.setBackgroundResource(R.drawable.drop_down_arrow);
                    } else if (i2 == 3) {
                        if (TextUtils.equals(feedbackLabelEntity.O00000Oo, FeedbackLabelActivity.this.tid)) {
                            O000000o2.setBackgroundResource(R.drawable.feedback_choose_hig);
                            textView.setTextColor(textView.getContext().getResources().getColor(R.color.mj_color_green_normal));
                            return;
                        }
                        O000000o2.setBackgroundResource(R.drawable.home_control_choose_nor);
                        textView.setTextColor(textView.getContext().getResources().getColor(R.color.mj_color_gray_heavier));
                    }
                }
            }
        }

        public O000000o(Context context, List<FeedbackLabelEntity> list) {
            super(context, list);
            this.O00000o0 = this;
        }

        public final void onItemClick(RecyclerView recyclerView, View view, int i) {
            FeedbackLabelEntity O00000o = O000000o(i);
            if (O00000o != null) {
                int i2 = O00000o.O00000o;
                if (i2 == 1) {
                    O00000o.O00000o = 2;
                    if (O00000o.O00000oO != null) {
                        this.O00000Oo.removeAll(O00000o.O00000oO);
                    }
                } else if (i2 == 2) {
                    O00000o.O00000o = 1;
                    if (O00000o.O00000oO != null) {
                        this.O00000Oo.addAll(this.O00000Oo.indexOf(O00000o) + 1, O00000o.O00000oO);
                    }
                } else if (i2 == 3) {
                    if (TextUtils.equals(O00000o.O00000Oo, FeedbackLabelActivity.this.tid)) {
                        FeedbackLabelActivity.this.tid = null;
                    } else {
                        FeedbackLabelActivity.this.tid = O00000o.O00000Oo;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("Wid", O00000o.f7417O000000o);
                    intent.putExtra("tagid", O00000o.O00000Oo);
                    intent.putExtra("name", O00000o.O00000o0);
                    FeedbackLabelActivity.this.setResult(-1, intent);
                    FeedbackLabelActivity.this.onBackPressed();
                }
                notifyDataSetChanged();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: O00000o */
        public FeedbackLabelEntity O000000o(int i) {
            if (i < 0) {
                return null;
            }
            return (FeedbackLabelEntity) super.O000000o(i + 0);
        }

        public final int getItemCount() {
            return super.getItemCount() + 0;
        }

        public final int O00000Oo(int i) {
            if (i < 0) {
                return 0;
            }
            return O000000o(i).O00000o;
        }
    }
}
