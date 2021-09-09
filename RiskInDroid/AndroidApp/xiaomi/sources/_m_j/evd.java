package _m_j;

import _m_j.evc;
import _m_j.ewr;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.shopviews.adapter.countdown.CountDownListCfgAdapter;
import com.xiaomi.shopviews.adapter.countdown.CountdownView;
import com.xiaomi.shopviews.widget.customfont.CustomTextView;
import com.xiaomi.smarthome.R;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public final class evd extends euk<ewr, vr> {
    public static long O00000o = 600000;
    public static long O00000o0 = 7200000;
    public eum O00000oO;
    public eul O00000oo;
    private String[] O0000O0o = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    public final int O000000o() {
        return 30;
    }

    public final int O00000Oo() {
        return R.layout.count_down_list_item_cfg;
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0220  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0262  */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    public final /* synthetic */ void O000000o(vr vrVar, Object obj, int i) {
        long j;
        long j2;
        View view;
        int i2;
        List<ewr.O000000o> list;
        String str;
        String str2;
        final ewr ewr = (ewr) obj;
        View view2 = vrVar.itemView;
        CustomTextView customTextView = (CustomTextView) view2.findViewById(R.id.countdown_title);
        customTextView.setText(ewr.O00000o);
        if (!TextUtils.isEmpty(ewr.O0000Oo0)) {
            customTextView.setTextColor(Color.parseColor(ewr.O0000Oo0));
        }
        final CustomTextView customTextView2 = (CustomTextView) view2.findViewById(R.id.countdown_txt);
        if (!TextUtils.isEmpty(ewr.O0000Oo)) {
            customTextView2.setTextColor(Color.parseColor(ewr.O0000Oo));
        }
        final ImageButton imageButton = (ImageButton) view2.findViewById(R.id.remind_btn);
        if (ewr.O00oOooO) {
            imageButton.setBackground(imageButton.getContext().getResources().getDrawable(R.drawable.remind));
        } else {
            imageButton.setBackground(imageButton.getContext().getResources().getDrawable(R.drawable.unremind));
        }
        final LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.remind_group);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.evd.AnonymousClass1 */

            public final void onClick(View view) {
                if (evd.this.O00000oO != null) {
                    evd.this.O00000oO.O000000o(ewr, "slider_flash_sale_cfg", imageButton);
                }
            }
        });
        CountdownView countdownView = (CountdownView) view2.findViewById(R.id.cv_countdownView);
        long j3 = this.O00000oo.O0000oO0 * 1000;
        if (TextUtils.isEmpty(ewr.O00000oO) || !TextUtils.isDigitsOnly(ewr.O00000oO)) {
            j2 = 0;
            j = 0;
        } else {
            long parseLong = Long.parseLong(ewr.O00000oO) * 1000;
            j = parseLong;
            j2 = parseLong - j3;
        }
        long j4 = ewr.O0000ooo > 0 ? ewr.O0000ooo * 1000 : 0;
        long j5 = O00000o0;
        if (j2 > j5) {
            ewr.O0000oOo = ewr.O0000oO0;
            long j6 = j;
            if (j6 <= 0) {
                str = "";
                view = view2;
            } else {
                Calendar instance = Calendar.getInstance();
                instance.setTime(new Date(j6));
                int i3 = instance.get(2);
                int i4 = instance.get(5);
                int i5 = instance.get(11);
                int i6 = instance.get(12);
                view = view2;
                if (instance.get(9) == 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(i5);
                    sb.append(":");
                    sb.append(i6 < 10 ? "0".concat(String.valueOf(i6)) : Integer.valueOf(i6));
                    sb.append(" AM");
                    str2 = sb.toString();
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i5);
                    sb2.append(":");
                    sb2.append(i6 < 10 ? "0".concat(String.valueOf(i6)) : Integer.valueOf(i6));
                    sb2.append(" PM");
                    str2 = sb2.toString();
                }
                str = String.format(this.f2565O000000o.getString(R.string.count_down_pre), Integer.valueOf(i4), this.O0000O0o[i3], str2);
            }
            customTextView2.setText(str);
            countdownView.setVisibility(8);
            countdownView.O000000o(j2);
        } else {
            view = view2;
            if (j2 <= 0 || j2 >= j5) {
                if (j3 < j4) {
                    ewr.O0000oOo = ewr.O0000oOO;
                    customTextView2.setText(this.f2565O000000o.getString(R.string.count_down_end_in));
                    i2 = 0;
                    countdownView.setVisibility(0);
                    countdownView.O000000o(j4 - j3);
                } else {
                    i2 = 0;
                    ewr.O0000oOo = ewr.O0000oOO;
                    customTextView2.setText(this.f2565O000000o.getString(R.string.count_down_end_in));
                    countdownView.setVisibility(0);
                    countdownView.O000000o();
                }
                countdownView.setOnCountdownIntervalListener$2fa15284(new CountdownView.O00000Oo() {
                    /* class _m_j.evd.AnonymousClass2 */

                    public final void O000000o(CountdownView countdownView, long j) {
                        if (j < evd.O00000o0 && ewr.O0000oOo == ewr.O0000oO0) {
                            ewr.O0000oOo = ewr.O0000oO;
                            customTextView2.setText(evd.this.f2565O000000o.getString(R.string.count_down_start));
                            countdownView.setVisibility(0);
                        }
                        if (j < evd.O00000o) {
                            linearLayout.setVisibility(8);
                        }
                    }
                });
                final ewr ewr2 = ewr;
                final long j7 = j4;
                final CountdownView countdownView2 = countdownView;
                countdownView.setOnCountdownEndListener(new CountdownView.O000000o() {
                    /* class _m_j.evd.AnonymousClass3 */

                    public final void O000000o(CountdownView countdownView) {
                        customTextView2.setText(evd.this.f2565O000000o.getString(R.string.count_down_end_in));
                        ewr2.O0000oOo = ewr.O0000oOO;
                        long j = evd.this.O00000oo.O0000oO0 * 1000;
                        long j2 = j7;
                        if (j < j2) {
                            countdownView2.O000000o(j2 - j);
                        } else {
                            countdownView.O000000o();
                        }
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
                View view3 = view;
                RecyclerView recyclerView = (RecyclerView) view3.findViewById(R.id.recycler_view);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view3.getContext());
                linearLayoutManager.setOrientation(i2);
                recyclerView.setLayoutManager(linearLayoutManager);
                CountDownListCfgAdapter countDownListCfgAdapter = new CountDownListCfgAdapter(view3.getContext(), ewr, this.O00000oO);
                recyclerView.setAdapter(countDownListCfgAdapter);
                list = ewr.O0000oo0;
                if (list == null) {
                    countDownListCfgAdapter.f3902O000000o.clear();
                    countDownListCfgAdapter.f3902O000000o.addAll(list);
                    countDownListCfgAdapter.notifyDataSetChanged();
                    return;
                }
                return;
            }
            ewr.O0000oOo = ewr.O0000oO;
            customTextView2.setText(this.f2565O000000o.getString(R.string.count_down_start));
            countdownView.setVisibility(0);
            countdownView.O000000o(j2);
        }
        i2 = 0;
        countdownView.setOnCountdownIntervalListener$2fa15284(new CountdownView.O00000Oo() {
            /* class _m_j.evd.AnonymousClass2 */

            public final void O000000o(CountdownView countdownView, long j) {
                if (j < evd.O00000o0 && ewr.O0000oOo == ewr.O0000oO0) {
                    ewr.O0000oOo = ewr.O0000oO;
                    customTextView2.setText(evd.this.f2565O000000o.getString(R.string.count_down_start));
                    countdownView.setVisibility(0);
                }
                if (j < evd.O00000o) {
                    linearLayout.setVisibility(8);
                }
            }
        });
        final ewr ewr22 = ewr;
        final long j72 = j4;
        final CountdownView countdownView22 = countdownView;
        countdownView.setOnCountdownEndListener(new CountdownView.O000000o() {
            /* class _m_j.evd.AnonymousClass3 */

            public final void O000000o(CountdownView countdownView) {
                customTextView2.setText(evd.this.f2565O000000o.getString(R.string.count_down_end_in));
                ewr22.O0000oOo = ewr.O0000oOO;
                long j = evd.this.O00000oo.O0000oO0 * 1000;
                long j2 = j72;
                if (j < j2) {
                    countdownView22.O000000o(j2 - j);
                } else {
                    countdownView.O000000o();
                }
            }
        });
        evc.O00000Oo o00000Oo2 = new evc.O00000Oo();
        evc.O000000o o000000o2 = new evc.O000000o();
        if (!TextUtils.isEmpty(ewr.O0000o00)) {
        }
        if (!TextUtils.isEmpty(ewr.O0000Ooo)) {
        }
        o00000Oo2.O0000o0 = o000000o2;
        countdownView.O000000o(o00000Oo2.O000000o());
        View view32 = view;
        RecyclerView recyclerView2 = (RecyclerView) view32.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(view32.getContext());
        linearLayoutManager2.setOrientation(i2);
        recyclerView2.setLayoutManager(linearLayoutManager2);
        CountDownListCfgAdapter countDownListCfgAdapter2 = new CountDownListCfgAdapter(view32.getContext(), ewr, this.O00000oO);
        recyclerView2.setAdapter(countDownListCfgAdapter2);
        list = ewr.O0000oo0;
        if (list == null) {
        }
    }

    public evd(eum eum, eul eul) {
        this.O00000oO = eum;
        this.O00000oo = eul;
    }
}
