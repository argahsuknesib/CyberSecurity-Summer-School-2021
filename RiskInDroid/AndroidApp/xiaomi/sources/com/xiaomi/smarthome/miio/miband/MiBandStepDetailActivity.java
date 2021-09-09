package com.xiaomi.smarthome.miio.miband;

import _m_j.gwd;
import _m_j.gxf;
import _m_j.gxg;
import _m_j.gxi;
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
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MiBandStepDetailActivity extends BaseWhiteActivity implements gxg.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    private LinearLayoutManager f9747O000000o;
    private RecyclerView O00000Oo;
    private int O00000o = 2;
    private gxf O00000o0;
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
    private TextView O0000oO;
    private TextView O0000oO0;
    private TextView O0000oOO;

    public void onSleepDataChanged() {
    }

    public void onUserDataChanged() {
    }

    public void handleMessage(Message message) {
        if (!isFinishing()) {
            if ((Build.VERSION.SDK_INT < 18 || !isDestroyed()) && message.what == 0) {
                gxf gxf = this.O00000o0;
                gxf.O00000o = this.O00000o;
                if (gxf.O00000o == 3) {
                    gxf.O00000o0 = 34;
                } else if (gxf.O00000o == 2) {
                    gxf.O00000o0 = 34;
                } else if (gxf.O00000o == 1) {
                    gxf.O00000o0 = 34;
                } else if (gxf.O00000o == 0) {
                    gxf.O00000o0 = 34;
                }
                this.O00000o0.O00000Oo();
                updateDetail(this.O00000o0.O000000o());
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.miband_step_detail_layout);
        this.O00000Oo = (RecyclerView) findViewById(R.id.recycler_view);
        this.O0000O0o = (TextView) findViewById(R.id.day_total_distance_id);
        this.O0000OOo = (TextView) findViewById(R.id.day_total_distance_symbol);
        this.O0000Oo0 = (TextView) findViewById(R.id.day_total_step_id);
        this.O0000Oo = (TextView) findViewById(R.id.day_total_calorie_id);
        this.O0000OoO = (TextView) findViewById(R.id.walk_distance_id);
        this.O0000Ooo = (TextView) findViewById(R.id.walk_distance_symbol);
        this.O0000o00 = (TextView) findViewById(R.id.walk_time_hour_id);
        this.O0000o0 = (TextView) findViewById(R.id.walk_time_minute_id);
        this.O0000o0O = (TextView) findViewById(R.id.walk_calorie_id);
        this.O0000o0o = (TextView) findViewById(R.id.run_distance_id);
        this.O0000o = (TextView) findViewById(R.id.run_distance_symbol);
        this.O0000oO0 = (TextView) findViewById(R.id.run_time_hour_id);
        this.O0000oO = (TextView) findViewById(R.id.run_time_minute_id);
        this.O0000oOO = (TextView) findViewById(R.id.run_calorie_id);
        View findViewById = findViewById(R.id.module_a_3_return_transparent_btn);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.miband.MiBandStepDetailActivity.AnonymousClass1 */

                public final void onClick(View view) {
                    MiBandStepDetailActivity.this.finish();
                }
            });
        }
        TextView textView = (TextView) findViewById(R.id.module_a_3_return_transparent_title);
        if (textView != null) {
            textView.setText((int) R.string.sport_detail_title);
        }
        View findViewById2 = findViewById(R.id.module_a_3_return_more_more_transparent_btn);
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.miband.MiBandStepDetailActivity.AnonymousClass2 */

                /* JADX WARNING: Removed duplicated region for block: B:10:0x002e  */
                /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
                public final void onClick(View view) {
                    MiBandStepDetailActivity miBandStepDetailActivity = MiBandStepDetailActivity.this;
                    if (gwd.O000000o(miBandStepDetailActivity, "com.xiaomi.hm.health", miBandStepDetailActivity.getResources().getString(R.string.not_found_bracelet_app))) {
                        Intent launchIntentForPackage = MiBandStepDetailActivity.this.getPackageManager().getLaunchIntentForPackage("com.xiaomi.hm.health");
                        boolean z = true;
                        if (launchIntentForPackage != null) {
                            gwd.O000000o(launchIntentForPackage);
                            try {
                                MiBandStepDetailActivity.this.startActivity(launchIntentForPackage);
                            } catch (Exception unused) {
                            }
                            if (z) {
                                hte.O00000Oo(MiBandStepDetailActivity.this.getContext(), R.string.start_mi_band_app_failed);
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
        this.f9747O000000o = new LinearLayoutManager(this);
        this.f9747O000000o.setOrientation(0);
        this.f9747O000000o.setReverseLayout(true);
        this.f9747O000000o.scrollToPosition(0);
        this.O00000Oo.setLayoutManager(this.f9747O000000o);
        this.O00000o0 = new gxf(this, this.f9747O000000o);
        this.O00000o0.O00000oo = new gxf.O000000o() {
            /* class com.xiaomi.smarthome.miio.miband.MiBandStepDetailActivity.AnonymousClass3 */

            public final void O000000o(gxi gxi) {
                MiBandStepDetailActivity.this.updateDetail(gxi);
            }
        };
        gxf gxf = this.O00000o0;
        gxf.O00000Oo = 1;
        this.O00000Oo.setAdapter(gxf);
        updateDetail(this.O00000o0.O000000o());
    }

    public void onResume() {
        super.onResume();
        gxg.O000000o().O000000o((gxg.O000000o) this);
        O000000o(gxg.O000000o().O00000oo);
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

    private void O000000o(List<gxi> list) {
        if (list == null || list.size() == 0) {
            this.O00000o0.O000000o(null);
            this.O00000o0.O000000o(0.0f, 0.0f);
            this.mHandler.sendEmptyMessage(0);
            return;
        }
        gxi gxi = list.get(list.size() - 1);
        this.O00000oO = (float) gxi.O0000O0o;
        this.O00000oo = (float) gxi.O0000O0o;
        Date date = new Date(gxi.O0000Oo0);
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
        instance.setTime(gxg.O000000o(instance, new Date(list.get(list.size() - 1).O0000Oo0)));
        for (int i3 = 0; i3 < list.size(); i3++) {
            O000000o((float) list.get(i3).O0000O0o);
        }
        this.O00000o0.O000000o(list);
        this.O00000o0.O000000o(this.O00000oO, this.O00000oo);
        this.mHandler.sendEmptyMessage(0);
    }

    public void updateDetail(gxi gxi) {
        if (gxi != null) {
            int i = gxi.O00000Oo;
            if (i / 1000 > 0) {
                this.O0000OOo.setText((int) R.string.symbol_kilometer);
                TextView textView = this.O0000O0o;
                double d = (double) i;
                Double.isNaN(d);
                textView.setText(String.format("%1.2f", Double.valueOf(d / 1000.0d)));
            } else {
                this.O0000OOo.setText((int) R.string.symbol_meter);
                this.O0000O0o.setText(String.valueOf(i));
            }
            this.O0000Oo0.setText(String.valueOf(gxi.O0000O0o));
            this.O0000Oo.setText(String.valueOf(gxi.O00000oo));
            int i2 = gxi.O00000Oo - gxi.O00000o;
            if (i2 / 1000 > 0) {
                this.O0000Ooo.setText((int) R.string.symbol_kilometer);
                TextView textView2 = this.O0000OoO;
                double d2 = (double) i2;
                Double.isNaN(d2);
                textView2.setText(String.format("%1.2f", Double.valueOf(d2 / 1000.0d)));
            } else {
                this.O0000Ooo.setText((int) R.string.symbol_meter);
                this.O0000OoO.setText(String.valueOf(i2));
            }
            this.O0000o00.setText(String.valueOf(gxi.f18465O000000o / 60));
            this.O0000o0.setText(String.valueOf(gxi.f18465O000000o % 60));
            this.O0000o0O.setText(String.valueOf(gxi.O00000oo - gxi.O00000oO));
            int i3 = gxi.O00000o;
            if (i3 / 1000 > 0) {
                this.O0000o.setText((int) R.string.symbol_kilometer);
                TextView textView3 = this.O0000o0o;
                double d3 = (double) i3;
                Double.isNaN(d3);
                textView3.setText(String.format("%1.2f", Double.valueOf(d3 / 1000.0d)));
            } else {
                this.O0000o.setText((int) R.string.symbol_meter);
                this.O0000o0o.setText(String.valueOf(i3));
            }
            this.O0000oO0.setText(String.valueOf(gxi.O00000o0 / 60));
            this.O0000oO.setText(String.valueOf(gxi.O00000o0 % 60));
            this.O0000oOO.setText(String.valueOf(gxi.O00000oO));
        }
    }

    public void onStepDataChanged() {
        O000000o(gxg.O000000o().O00000oo);
    }
}
