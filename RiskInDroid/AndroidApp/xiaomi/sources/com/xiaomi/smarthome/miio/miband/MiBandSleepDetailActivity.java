package com.xiaomi.smarthome.miio.miband;

import _m_j.gwd;
import _m_j.gxg;
import _m_j.gxh;
import _m_j.hte;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseWhiteActivity;
import com.xiaomi.smarthome.miio.miband.adpter.SimpleStackedRecyclerAdapter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MiBandSleepDetailActivity extends BaseWhiteActivity implements gxg.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    private LinearLayoutManager f9743O000000o;
    private RecyclerView O00000Oo;
    private int O00000o = 2;
    private SimpleStackedRecyclerAdapter O00000o0;
    private float O00000oO = -1.0f;
    private float O00000oo = -1.0f;
    private TextView O0000O0o;
    private TextView O0000OOo;
    private TextView O0000Oo;
    private TextView O0000Oo0;
    private TextView O0000OoO;
    private TextView O0000Ooo;
    private TextView O0000o;
    private TextView O0000o0;
    private TextView O0000o00;
    private TextView O0000o0O;
    private TextView O0000o0o;
    private TextView O0000oO0;

    public void onStepDataChanged() {
    }

    public void onUserDataChanged() {
    }

    public void handleMessage(Message message) {
        if (!isFinishing()) {
            if ((Build.VERSION.SDK_INT < 18 || !isDestroyed()) && message.what == 0) {
                SimpleStackedRecyclerAdapter simpleStackedRecyclerAdapter = this.O00000o0;
                simpleStackedRecyclerAdapter.O00000o = this.O00000o;
                if (simpleStackedRecyclerAdapter.O00000o == 3) {
                    simpleStackedRecyclerAdapter.O00000o0 = 34;
                } else if (simpleStackedRecyclerAdapter.O00000o == 2) {
                    simpleStackedRecyclerAdapter.O00000o0 = 34;
                } else if (simpleStackedRecyclerAdapter.O00000o == 1) {
                    simpleStackedRecyclerAdapter.O00000o0 = 34;
                } else if (simpleStackedRecyclerAdapter.O00000o == 0) {
                    simpleStackedRecyclerAdapter.O00000o0 = 34;
                }
                this.O00000o0.O00000Oo();
                updateDetail(this.O00000o0.O000000o());
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.miband_sleep_detail_layout);
        this.O00000Oo = (RecyclerView) findViewById(R.id.recycler_view);
        this.O0000O0o = (TextView) findViewById(R.id.all_sleep_hour_id);
        this.O0000OOo = (TextView) findViewById(R.id.all_sleep_minute_id);
        this.O0000Oo0 = (TextView) findViewById(R.id.deep_sleep_hour_id);
        this.O0000Oo = (TextView) findViewById(R.id.deep_sleep_minute_id);
        this.O0000OoO = (TextView) findViewById(R.id.shallow_sleep_hour_id);
        this.O0000Ooo = (TextView) findViewById(R.id.shallow_sleep_minute_id);
        this.O0000o00 = (TextView) findViewById(R.id.start_sleep_hour_id);
        this.O0000o0 = (TextView) findViewById(R.id.start_sleep_minute_id);
        this.O0000o0O = (TextView) findViewById(R.id.end_sleep_hour_id);
        this.O0000o0o = (TextView) findViewById(R.id.end_sleep_minute_id);
        this.O0000o = (TextView) findViewById(R.id.wake_time_hour_id);
        this.O0000oO0 = (TextView) findViewById(R.id.wake_time_minute_id);
        View findViewById = findViewById(R.id.module_a_3_return_transparent_btn);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.miband.MiBandSleepDetailActivity.AnonymousClass1 */

                public final void onClick(View view) {
                    MiBandSleepDetailActivity.this.finish();
                }
            });
        }
        TextView textView = (TextView) findViewById(R.id.module_a_3_return_transparent_title);
        if (textView != null) {
            textView.setText((int) R.string.sleep_detail_title);
        }
        View findViewById2 = findViewById(R.id.module_a_3_return_more_more_transparent_btn);
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.miband.MiBandSleepDetailActivity.AnonymousClass2 */

                /* JADX WARNING: Removed duplicated region for block: B:10:0x002e  */
                /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
                public final void onClick(View view) {
                    MiBandSleepDetailActivity miBandSleepDetailActivity = MiBandSleepDetailActivity.this;
                    if (gwd.O000000o(miBandSleepDetailActivity, "com.xiaomi.hm.health", miBandSleepDetailActivity.getResources().getString(R.string.not_found_bracelet_app))) {
                        Intent launchIntentForPackage = MiBandSleepDetailActivity.this.getPackageManager().getLaunchIntentForPackage("com.xiaomi.hm.health");
                        boolean z = true;
                        if (launchIntentForPackage != null) {
                            gwd.O000000o(launchIntentForPackage);
                            try {
                                MiBandSleepDetailActivity.this.startActivity(launchIntentForPackage);
                            } catch (Exception unused) {
                            }
                            if (z) {
                                hte.O00000Oo(MiBandSleepDetailActivity.this.getContext(), R.string.start_mi_band_app_failed);
                                return;
                            }
                            return;
                        }
                        z = false;
                        if (z) {
                        }
                    }
                }
            });
        }
        this.f9743O000000o = new LinearLayoutManager(this);
        this.f9743O000000o.setOrientation(0);
        this.f9743O000000o.setReverseLayout(true);
        this.f9743O000000o.scrollToPosition(0);
        this.O00000Oo.setLayoutManager(this.f9743O000000o);
        this.O00000o0 = new SimpleStackedRecyclerAdapter(this);
        this.O00000o0.O00000oo = new SimpleStackedRecyclerAdapter.O000000o() {
            /* class com.xiaomi.smarthome.miio.miband.MiBandSleepDetailActivity.AnonymousClass3 */

            public final void O000000o(gxh gxh) {
                MiBandSleepDetailActivity.this.updateDetail(gxh);
            }
        };
        SimpleStackedRecyclerAdapter simpleStackedRecyclerAdapter = this.O00000o0;
        simpleStackedRecyclerAdapter.O00000Oo = 1;
        this.O00000Oo.setAdapter(simpleStackedRecyclerAdapter);
        updateDetail(this.O00000o0.O000000o());
    }

    public void onResume() {
        super.onResume();
        gxg.O000000o().O000000o((gxg.O000000o) this);
        O000000o(gxg.O000000o().O00000oO);
    }

    public void onPause() {
        super.onPause();
        gxg.O000000o().O00000Oo(this);
    }

    private void O000000o(float f) {
        if (f > this.O00000oO) {
            this.O00000oO = f;
        }
        if (f < this.O00000oo) {
            this.O00000oo = f;
        }
    }

    private void O000000o(List<gxh> list) {
        if (list == null || list.size() == 0) {
            this.O00000o0.O000000o(null);
            this.O00000o0.O000000o(0.0f, 0.0f);
            this.mHandler.sendEmptyMessage(0);
            return;
        }
        gxh gxh = list.get(list.size() - 1);
        this.O00000oO = (float) (gxh.f18464O000000o + gxh.f18464O000000o);
        this.O00000oo = (float) (gxh.f18464O000000o + gxh.f18464O000000o);
        Date date = new Date(gxh.O0000O0o);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        int i = 11;
        int i2 = this.O00000o;
        if (i2 == 2) {
            i = 6;
        } else if (i2 == 1) {
            i = 3;
        } else if (i2 == 0) {
            i = 2;
        }
        instance.get(i);
        instance.setTime(gxg.O000000o(instance, new Date(list.get(list.size() - 1).O0000O0o)));
        for (int i3 = 0; i3 < list.size(); i3++) {
            gxh gxh2 = list.get(i3);
            O000000o((float) (gxh2.f18464O000000o + gxh2.O00000Oo));
        }
        this.O00000o0.O000000o(list);
        this.O00000o0.O000000o(this.O00000oO, this.O00000oo);
        this.mHandler.sendEmptyMessage(0);
    }

    public void updateDetail(gxh gxh) {
        if (gxh != null) {
            int i = gxh.O00000Oo + gxh.f18464O000000o;
            this.O0000O0o.setText(String.valueOf(i / 60));
            this.O0000OOo.setText(String.valueOf(i % 60));
            this.O0000Oo0.setText(String.valueOf(gxh.O00000Oo / 60));
            this.O0000Oo.setText(String.valueOf(gxh.O00000Oo % 60));
            this.O0000OoO.setText(String.valueOf(gxh.f18464O000000o / 60));
            this.O0000Ooo.setText(String.valueOf(gxh.f18464O000000o % 60));
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(gxh.O00000o * 1000);
            this.O0000o00.setText(String.valueOf(instance.get(11)));
            this.O0000o0.setText(String.format("%02d", Integer.valueOf(instance.get(12))));
            instance.setTimeInMillis(gxh.O00000oO * 1000);
            this.O0000o0O.setText(String.valueOf(instance.get(11)));
            this.O0000o0o.setText(String.format("%02d", Integer.valueOf(instance.get(12))));
            this.O0000o.setText(String.valueOf(gxh.O00000o0 / 60));
            this.O0000oO0.setText(String.valueOf(gxh.O00000o0 % 60));
        }
    }

    public void onSleepDataChanged() {
        O000000o(gxg.O000000o().O00000oO);
    }
}
