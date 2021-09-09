package _m_j;

import _m_j.evc;
import _m_j.ewr;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.shopviews.adapter.countdown.CountDownListAdapter;
import com.xiaomi.shopviews.adapter.countdown.CountdownView;
import com.xiaomi.shopviews.widget.customfont.CustomTextView;
import com.xiaomi.smarthome.R;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public final class eve extends euk<ewr, vr> {
    public static long O00000o0 = 7200000;
    private eum O00000o;
    private eul O00000oO;
    private String[] O00000oo = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    public final int O000000o() {
        return 6;
    }

    public final int O00000Oo() {
        return R.layout.count_down_list_item;
    }

    public final /* synthetic */ void O000000o(vr vrVar, Object obj, int i) {
        long j;
        long j2;
        String str;
        String str2;
        final ewr ewr = (ewr) obj;
        View view = vrVar.itemView;
        CustomTextView customTextView = (CustomTextView) view.findViewById(R.id.countdown_title);
        customTextView.setText(ewr.O00000o);
        if (!TextUtils.isEmpty(ewr.O0000Oo0)) {
            customTextView.setTextColor(Color.parseColor(ewr.O0000Oo0));
        }
        final CustomTextView customTextView2 = (CustomTextView) view.findViewById(R.id.countdown_txt);
        if (!TextUtils.isEmpty(ewr.O0000Oo)) {
            customTextView2.setTextColor(Color.parseColor(ewr.O0000Oo));
        }
        final CountdownView countdownView = (CountdownView) view.findViewById(R.id.cv_countdownView);
        long j3 = this.O00000oO.O0000oO0 * 1000;
        if (TextUtils.isEmpty(ewr.O00000oO) || !TextUtils.isDigitsOnly(ewr.O00000oO)) {
            j2 = 0;
            j = 0;
        } else {
            j = 1000 * Long.parseLong(ewr.O00000oO);
            j2 = j - j3;
        }
        long j4 = O00000o0;
        if (j2 > j4) {
            ewr.O0000oOo = ewr.O0000oO0;
            if (j <= 0) {
                str = "";
            } else {
                Calendar instance = Calendar.getInstance();
                instance.setTime(new Date(j));
                int i2 = instance.get(2);
                int i3 = instance.get(5);
                int i4 = instance.get(11);
                int i5 = instance.get(12);
                if (instance.get(9) == 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(i4);
                    sb.append(":");
                    sb.append(i5 < 10 ? "0".concat(String.valueOf(i5)) : Integer.valueOf(i5));
                    sb.append(" AM");
                    str2 = sb.toString();
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i4);
                    sb2.append(":");
                    sb2.append(i5 < 10 ? "0".concat(String.valueOf(i5)) : Integer.valueOf(i5));
                    sb2.append(" PM");
                    str2 = sb2.toString();
                }
                str = String.format(this.f2565O000000o.getString(R.string.count_down_pre), Integer.valueOf(i3), this.O00000oo[i2], str2);
            }
            customTextView2.setText(str);
            countdownView.setVisibility(8);
            countdownView.O000000o(j2);
        } else if (j2 <= 0 || j2 >= j4) {
            ewr.O0000oOo = ewr.O0000oOO;
            customTextView2.setText(this.f2565O000000o.getString(R.string.count_down_end));
            countdownView.setVisibility(8);
            countdownView.O000000o();
        } else {
            ewr.O0000oOo = ewr.O0000oO;
            customTextView2.setText(this.f2565O000000o.getString(R.string.count_down_start));
            countdownView.setVisibility(0);
            countdownView.O000000o(j2);
        }
        countdownView.setOnCountdownIntervalListener$2fa15284(new CountdownView.O00000Oo() {
            /* class _m_j.eve.AnonymousClass1 */

            public final void O000000o(CountdownView countdownView, long j) {
                if (j < eve.O00000o0 && ewr.O0000oOo != ewr.O0000oO) {
                    ewr.O0000oOo = ewr.O0000oO;
                    customTextView2.setText(eve.this.f2565O000000o.getString(R.string.count_down_start));
                    countdownView.setVisibility(0);
                }
            }
        });
        countdownView.setOnCountdownEndListener(new CountdownView.O000000o() {
            /* class _m_j.eve.AnonymousClass2 */

            public final void O000000o(CountdownView countdownView) {
                customTextView2.setText(eve.this.f2565O000000o.getString(R.string.count_down_end));
                countdownView.setVisibility(8);
                countdownView.O000000o();
            }
        });
        evc.O00000Oo o00000Oo = new evc.O00000Oo();
        evc.O000000o o000000o = new evc.O000000o();
        if (!TextUtils.isEmpty(ewr.O0000o00)) {
            o000000o.O000000o(Integer.valueOf(Color.parseColor(ewr.O0000o00)));
        }
        if (!TextUtils.isEmpty(ewr.O0000Ooo)) {
            o000000o.O000000o(Integer.valueOf(Color.parseColor(ewr.O0000Ooo)));
        }
        o00000Oo.O0000o0 = o000000o;
        countdownView.O000000o(o00000Oo.O000000o());
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(0);
        recyclerView.setLayoutManager(linearLayoutManager);
        CountDownListAdapter countDownListAdapter = new CountDownListAdapter(view.getContext(), ewr, this.O00000o);
        recyclerView.setAdapter(countDownListAdapter);
        List<ewr.O000000o> list = ewr.O0000oo0;
        if (list != null) {
            countDownListAdapter.f3898O000000o.clear();
            countDownListAdapter.f3898O000000o.addAll(list);
            countDownListAdapter.notifyDataSetChanged();
        }
    }

    public final /* bridge */ /* synthetic */ void O00000Oo(vr vrVar, Object obj, int i) {
        super.O00000Oo(vrVar, (ewr) obj, i);
    }

    public eve(eum eum, eul eul) {
        this.O00000o = eum;
        this.O00000oO = eul;
    }
}
