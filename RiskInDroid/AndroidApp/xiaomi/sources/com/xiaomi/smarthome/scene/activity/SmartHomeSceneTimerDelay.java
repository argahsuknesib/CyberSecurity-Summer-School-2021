package com.xiaomi.smarthome.scene.activity;

import _m_j.hpq;
import _m_j.hpt;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.widget.MinSecTimerPicker;
import com.xiaomi.smarthome.scene.api.SceneApi;
import java.util.GregorianCalendar;

public class SmartHomeSceneTimerDelay extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    Context f10989O000000o;
    TextView O00000Oo;
    View O00000o;
    View O00000o0;
    MinSecTimerPicker O00000oO;
    SceneApi.Action O00000oo;

    public static String getRemainTimeHint(Context context, SceneApi.O0000o o0000o) {
        return null;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.smarthome_scene_timedelay);
        this.f10989O000000o = this;
        this.O00000Oo = (TextView) findViewById(R.id.module_a_3_return_title);
        this.O00000Oo.setText((int) R.string.smarthome_scene_delay);
        this.O00000o0 = findViewById(R.id.module_a_3_return_btn);
        this.O00000o0.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneTimerDelay.AnonymousClass1 */

            public final void onClick(View view) {
                SmartHomeSceneTimerDelay.this.finish();
            }
        });
        this.O00000o = findViewById(R.id.module_a_3_right_text_btn);
        ((TextView) this.O00000o).setText((int) R.string.ok_button);
        if (!getIntent().getBooleanExtra("is_from_recommend", false)) {
            this.O00000oo = hpq.O000000o().O00000oo;
        } else {
            this.O00000oo = hpt.O000000o().O0000OOo.O00000oo.get(getIntent().getIntExtra("delay_action_pos", 0));
        }
        this.O00000oO = (MinSecTimerPicker) findViewById(R.id.smarthome_scene_time_picker);
        this.O00000oO.setOnTimeChangedListener(new MinSecTimerPicker.O000000o() {
            /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneTimerDelay.AnonymousClass2 */

            public final void O000000o(MinSecTimerPicker minSecTimerPicker) {
                if (minSecTimerPicker.getCurrentMin().intValue() == 0 && minSecTimerPicker.getCurrentSec().intValue() == 0) {
                    SmartHomeSceneTimerDelay.this.O00000o.setEnabled(false);
                } else {
                    SmartHomeSceneTimerDelay.this.O00000o.setEnabled(true);
                }
            }
        });
        if (this.O00000oO.getCurrentMin().intValue() == 0 && this.O00000oO.getCurrentSec().intValue() == 0) {
            this.O00000o.setEnabled(false);
        } else {
            this.O00000o.setEnabled(true);
        }
        this.O00000o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneTimerDelay.AnonymousClass3 */

            public final void onClick(View view) {
                SmartHomeSceneTimerDelay.this.saveTimerSettings();
            }
        });
        new GregorianCalendar().getTimeZone();
        SceneApi.Action action = this.O00000oo;
        if (action != null) {
            int i = action.O0000O0o.O00000oo;
            this.O00000oO.setCurrentMin(Integer.valueOf(i / 60));
            this.O00000oO.setCurrentSec(Integer.valueOf(i % 60));
        }
    }

    public void saveTimerSettings() {
        int intValue = this.O00000oO.getCurrentMin().intValue();
        int intValue2 = this.O00000oO.getCurrentSec().intValue();
        SceneApi.Action action = this.O00000oo;
        if (action != null) {
            action.O0000O0o.O00000oo = (intValue * 60) + intValue2;
            setResult(-1);
        } else {
            Intent intent = new Intent();
            intent.putExtra("value", (intValue * 60) + intValue2);
            setResult(-1, intent);
        }
        finish();
    }
}
