package com.xiaomi.smarthome.feedback.view;

import _m_j.fsj;
import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import java.util.HashSet;

public class BatchBar {

    /* renamed from: O000000o  reason: collision with root package name */
    public fsj f7420O000000o = null;
    public Context O00000Oo;
    public boolean O00000o = false;
    public boolean O00000o0 = false;
    public View O00000oO = null;
    public View O00000oo = null;
    public ImageView O0000O0o;
    public TextView O0000OOo;
    public O000000o O0000Oo = null;
    public View O0000Oo0;
    public boolean O0000OoO = false;
    public BaseAdapter O0000Ooo = null;
    public int O0000o0 = 0;
    public HashSet<Integer> O0000o00 = new HashSet<>();
    public fsj.O00000Oo O0000o0O = new fsj.O00000Oo() {
        /* class com.xiaomi.smarthome.feedback.view.BatchBar.AnonymousClass4 */

        public final void O000000o() {
            if (BatchBar.this.O0000Oo != null) {
                BatchBar.this.O0000Oo.onStartBatchMode();
            }
            BatchBar.this.O000000o();
            BatchBar.this.O0000Ooo.notifyDataSetChanged();
        }
    };
    public fsj.O000000o O0000o0o = new fsj.O000000o() {
        /* class com.xiaomi.smarthome.feedback.view.BatchBar.AnonymousClass5 */

        public final void O000000o() {
            if (BatchBar.this.O0000Oo != null) {
                BatchBar.this.O0000Oo.onExitBatchMode(BatchBar.this.O0000o0, BatchBar.this.O0000Ooo);
            }
            BatchBar batchBar = BatchBar.this;
            batchBar.O0000o0 = 0;
            batchBar.O0000o00.clear();
            BatchBar batchBar2 = BatchBar.this;
            batchBar2.O0000OoO = false;
            batchBar2.O0000Ooo.notifyDataSetChanged();
            BatchBar.this.f7420O000000o.O000000o();
        }
    };

    public interface O000000o {
        View getContentViewOfBatchActionBar();

        View getContentViewOfBatchSelectBar();

        void onExitBatchMode(int i, BaseAdapter baseAdapter);

        void onStartBatchMode();

        void onUpdateBatchBarViewState(int i);
    }

    public BatchBar(Context context) {
        this.O00000Oo = context;
    }

    public final void O000000o(int i) {
        this.O0000o0 = i;
        this.f7420O000000o.O00000Oo();
    }

    public final void O000000o(Integer num) {
        if (this.O0000o00.contains(num)) {
            this.O0000o00.remove(num);
        } else {
            this.O0000o00.add(num);
        }
        O000000o();
        this.O0000Ooo.notifyDataSetChanged();
    }

    public final void O000000o() {
        int size = this.O0000o00.size();
        if (size > 0) {
            if (this.O00000o0) {
                this.O0000OOo.setText(this.O00000Oo.getResources().getQuantityString(R.plurals.selected_cnt_tips, size, Integer.valueOf(size)));
                if (size >= this.O0000Ooo.getCount()) {
                    this.O0000O0o.setImageResource(R.drawable.un_select_selector);
                    this.O0000O0o.setContentDescription(this.O00000Oo.getString(R.string.unselect_all));
                    this.O0000O0o.setTag(Boolean.FALSE);
                } else {
                    this.O0000O0o.setImageResource(R.drawable.all_select_selector);
                    this.O0000O0o.setContentDescription(this.O00000Oo.getString(R.string.select_all));
                    this.O0000O0o.setTag(Boolean.TRUE);
                }
            }
            if (this.O00000o) {
                this.O0000Oo0.setEnabled(true);
            }
        } else {
            if (this.O00000o0) {
                this.O0000OOo.setText((int) R.string.selected_0_cnt_tips);
                this.O0000O0o.setImageResource(R.drawable.all_select_selector);
                this.O0000O0o.setContentDescription(this.O00000Oo.getString(R.string.select_all));
                this.O0000O0o.setTag(Boolean.TRUE);
            }
            if (this.O00000o) {
                this.O0000Oo0.setEnabled(false);
            }
        }
        O000000o o000000o = this.O0000Oo;
        if (o000000o != null) {
            o000000o.onUpdateBatchBarViewState(size);
        }
    }
}
