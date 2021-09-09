package com.xiaomi.smarthome.scene.ui.sleep;

import _m_j.ezb;
import _m_j.ezc;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ggb;
import _m_j.gpl;
import _m_j.gqg;
import _m_j.grr;
import _m_j.gsf;
import _m_j.gsy;
import _m_j.hrk;
import _m_j.hxi;
import _m_j.hxt;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.AppConfigHelper;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.controls.AllReadyCallback;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.scene.ui.sleep.SleepModeActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

public class SleepModeActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private TextView f11306O000000o;
    public final ArrayList<Pair<String, Boolean>> list = new ArrayList<>();
    public String mHomeId;
    public XQProgressDialog mProcessDialog;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.mj_activity_sleepmode);
        this.f11306O000000o = (TextView) findViewById(R.id.tvTime);
        View findViewById = findViewById(R.id.llNodata);
        View findViewById2 = findViewById(R.id.mjSleepTitle);
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.mj_scene_sleep_mode);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.ui.sleep.$$Lambda$SleepModeActivity$kemmWgBAy9k9K9HZog7kVhUl3Jk */

            public final void onClick(View view) {
                SleepModeActivity.this.O00000Oo(view);
            }
        });
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.clDeviceList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.mProcessDialog = new XQProgressDialog(this);
        this.mProcessDialog.setCancelable(true);
        this.mProcessDialog.setMessage(getResources().getString(R.string.loading_share_info));
        this.mProcessDialog.show();
        O000000o o000000o = new O000000o(this, this.list);
        recyclerView.setAdapter(o000000o);
        this.mHomeId = ggb.O00000Oo().O0000OOo();
        findViewById(R.id.clTimeSet).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.ui.sleep.$$Lambda$SleepModeActivity$Zj1THSFV5gshDnj6XR7xhBGVjHo */

            public final void onClick(View view) {
                SleepModeActivity.this.O000000o(view);
            }
        });
        o000000o.O000000o(findViewById2, o000000o.O00000oo);
        new AllReadyCallback(6, new Runnable((TextView) findViewById(R.id.tvHInt), findViewById, o000000o) {
            /* class com.xiaomi.smarthome.scene.ui.sleep.$$Lambda$SleepModeActivity$XESUCJZvOo_CH0uKd33DfslcuS4 */
            private final /* synthetic */ TextView f$1;
            private final /* synthetic */ View f$2;
            private final /* synthetic */ SleepModeActivity.O000000o f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void run() {
                SleepModeActivity.this.O000000o(this.f$1, this.f$2, this.f$3);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        onBackPressed();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        Intent intent = new Intent(getContext(), SleepTimeActivity.class);
        String[] time = getTime();
        if (time.length == 2) {
            intent.putExtra("start", time[0]);
            intent.putExtra("end", time[1]);
        }
        startActivityForResult(intent, 1);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(final TextView textView, final View view, final O000000o o000000o) {
        hrk.O000000o(this.mHomeId, new fsm<JSONObject, fso>() {
            /* class com.xiaomi.smarthome.scene.ui.sleep.SleepModeActivity.AnonymousClass1 */

            public final /* synthetic */ void onSuccess(Object obj) {
                final JSONObject jSONObject = (JSONObject) obj;
                gsy.O00000o0(LogType.SCENE, "SleepModeActivity", "getDeviceSleep onSuccess:".concat(String.valueOf(jSONObject)));
                SleepModeActivity.this.setTimeShow(jSONObject.optString("start_time"), jSONObject.optString("end_time"));
                new AppConfigHelper(SleepModeActivity.this.getContext()).O000000o("sleep_mode_language", "1", "en", null, new AppConfigHelper.O00000Oo() {
                    /* class com.xiaomi.smarthome.scene.ui.sleep.SleepModeActivity.AnonymousClass1.AnonymousClass1 */

                    public final boolean O000000o(String str) throws Exception {
                        return AnonymousClass1.this.O000000o(jSONObject, str);
                    }

                    public final boolean O00000Oo(String str) throws Exception {
                        return AnonymousClass1.this.O000000o(jSONObject, str);
                    }
                }, new AppConfigHelper.O000000o() {
                    /* class com.xiaomi.smarthome.scene.ui.sleep.SleepModeActivity.AnonymousClass1.AnonymousClass2 */

                    /* renamed from: O000000o */
                    public final void onSuccess(String str, Response response) {
                        AnonymousClass1.this.O000000o(jSONObject, str);
                    }

                    public final void onFailure(gsf gsf, Exception exc, Response response) {
                        gsy.O00000o0(LogType.SCENE, "SleepModeActivity", "requestConfigWitchCache onFailure:".concat(String.valueOf(gsf)));
                        SleepModeActivity.this.mProcessDialog.dismiss();
                        gqg.O00000Oo((int) R.string.load_data_error);
                    }
                }, $$Lambda$_14QHG018Z6p13d3hzJuGTWnNeo.INSTANCE);
            }

            public final boolean O000000o(JSONObject jSONObject, String str) {
                if (AppConfigHelper.O000000o(str)) {
                    SleepModeActivity.this.mProcessDialog.dismiss();
                    try {
                        JSONArray optJSONArray = jSONObject.optJSONArray("devices");
                        JSONObject jSONObject2 = new JSONObject(str);
                        textView.setText(gpl.O000000o(jSONObject2.optJSONObject("sleep_hint")));
                        JSONObject optJSONObject = jSONObject2.optJSONObject("type_name");
                        TreeMap treeMap = new TreeMap(Collections.reverseOrder());
                        HashSet hashSet = new HashSet(ggb.O00000Oo().O000000o(SleepModeActivity.this.mHomeId, true));
                        if (!(optJSONArray == null || optJSONArray.length() == 0)) {
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                                String optString = optJSONObject2.optString("did");
                                if (hashSet.contains(optString)) {
                                    int optInt = optJSONObject2.optInt("type", 1);
                                    ArrayList arrayList = (ArrayList) treeMap.get(Integer.valueOf(optInt));
                                    if (arrayList == null) {
                                        Integer valueOf = Integer.valueOf(optInt);
                                        arrayList = new ArrayList();
                                        treeMap.put(valueOf, arrayList);
                                    }
                                    arrayList.add(new Pair(optString, Boolean.valueOf(optJSONObject2.optBoolean("switch"))));
                                } else {
                                    gsy.O00000o0(LogType.DEVICE_LIST, "SleepModeActivity", "not contain ".concat(String.valueOf(optString)));
                                }
                            }
                        }
                        SleepModeActivity.this.list.clear();
                        for (Map.Entry entry : treeMap.entrySet()) {
                            SleepModeActivity.this.list.add(new Pair(gpl.O000000o(optJSONObject.optJSONObject(String.valueOf(entry.getKey()))), null));
                            SleepModeActivity.this.list.addAll((Collection) entry.getValue());
                        }
                        hxt hxt = hxi.O0000Oo;
                        int size = SleepModeActivity.this.list.size();
                        hxt.f960O000000o.O000000o("sleep_speaker_num", "count", Integer.valueOf(size));
                        if (SleepModeActivity.this.list.size() == 0) {
                            view.setVisibility(0);
                            O000000o o000000o = o000000o;
                            o000000o.O000000o(view, o000000o.O0000O0o);
                        } else {
                            SleepModeActivity.this.list.add(new Pair("", null));
                            view.setVisibility(8);
                            O000000o o000000o2 = o000000o;
                            o000000o2.O0000O0o.remove(view);
                            o000000o2.notifyDataSetChanged();
                        }
                        o000000o.notifyDataSetChanged();
                        return true;
                    } catch (Throwable th) {
                        LogType logType = LogType.SCENE;
                        gsy.O00000o0(logType, "SleepModeActivity", "parseJson onFailure:" + Log.getStackTraceString(th));
                    }
                }
                return false;
            }

            public final void onFailure(fso fso) {
                gsy.O00000o0(LogType.SCENE, "SleepModeActivity", "getDeviceSleep onFailure:".concat(String.valueOf(fso)));
                SleepModeActivity.this.mProcessDialog.dismiss();
                gqg.O00000Oo((int) R.string.load_data_error);
            }
        });
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (1 == i && i2 == -1) {
            final String stringExtra = intent.getStringExtra("start");
            final String stringExtra2 = intent.getStringExtra("end");
            String[] time = getTime();
            if (stringExtra == null || !stringExtra.contains(":") || stringExtra2 == null || !stringExtra2.contains(":")) {
                LogType logType = LogType.DEVICE_LIST;
                gsy.O00000o0(logType, "SleepModeActivity", "onActivityResult  sleepTime:" + stringExtra + " wakeTime:" + stringExtra2 + " current:" + ((Object) this.f11306O000000o.getText()));
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<Pair<String, Boolean>> it = this.list.iterator();
            while (it.hasNext()) {
                Pair next = it.next();
                if (next.second != null && ((Boolean) next.second).booleanValue()) {
                    arrayList.add(next.first);
                }
            }
            LogType logType2 = LogType.DEVICE_LIST;
            gsy.O00000o0(logType2, "SleepModeActivity", "onActivityResult setDeviceSleep  list:" + this.list + " sleepTime:" + stringExtra + " wakeTime:" + stringExtra2);
            if (time.length < 2 || !stringExtra.equals(time[0]) || !stringExtra2.equals(time[1])) {
                this.mProcessDialog.show();
                hrk.O000000o(this.mHomeId, stringExtra, stringExtra2, arrayList, new fsm<JSONObject, fso>() {
                    /* class com.xiaomi.smarthome.scene.ui.sleep.SleepModeActivity.AnonymousClass2 */

                    public final void onFailure(fso fso) {
                        SleepModeActivity.this.mProcessDialog.dismiss();
                        gqg.O00000Oo((int) R.string.load_data_error);
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        SleepModeActivity.this.mProcessDialog.dismiss();
                        SleepModeActivity.this.setTimeShow(stringExtra, stringExtra2);
                    }
                });
                return;
            }
            setTimeShow(stringExtra, stringExtra2);
        }
    }

    public String[] getTime() {
        String charSequence = this.f11306O000000o.getText().toString();
        String[] split = charSequence.split(" \\| ");
        if (split.length == 2) {
            return split[1].split("-");
        }
        return charSequence.split("-");
    }

    public void setTimeShow(String str, String str2) {
        if (grr.O00000oO()) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                this.f11306O000000o.setText((int) R.string.mj_scene_sleepnotime_miui);
            } else if (hrk.O000000o().getStringSet("auto_clock", new HashSet()).contains(this.mHomeId)) {
                TextView textView = this.f11306O000000o;
                textView.setText(getString(R.string.mj_scene_sleeptime_miui) + " | " + str + "-" + str2);
            } else {
                TextView textView2 = this.f11306O000000o;
                textView2.setText(getString(R.string.sleep_auto_times_sef_define) + " | " + str + "-" + str2);
            }
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            this.f11306O000000o.setText((int) R.string.mj_scene_sleepnotime);
        } else {
            TextView textView3 = this.f11306O000000o;
            textView3.setText(str + "-" + str2);
        }
    }

    public class O000000o extends ezb<Pair<String, Boolean>> implements fno.O000000o {
        public final int O00000o0(int i) {
            return i == 1 ? R.layout.mj_item_sleepmode_type : R.layout.mj_item_sleepmode;
        }

        public final /* synthetic */ void O000000o(ezc ezc, Object obj, int i) {
            Pair pair = (Pair) obj;
            if (pair.second == null) {
                TextView textView = (TextView) ezc.O000000o((int) R.id.sleepHint);
                View O000000o2 = ezc.O000000o((int) R.id.vFooterBg);
                View O000000o3 = ezc.O000000o((int) R.id.vHeaderBg);
                if (i == 0) {
                    O000000o2.setVisibility(8);
                    O000000o3.setVisibility(0);
                    textView.setVisibility(0);
                } else if (i == SleepModeActivity.this.list.size() - 1) {
                    O000000o3.setVisibility(8);
                    textView.setVisibility(8);
                    O000000o2.setVisibility(0);
                } else {
                    O000000o3.setVisibility(0);
                    textView.setVisibility(0);
                    O000000o2.setVisibility(0);
                }
                textView.setText((CharSequence) pair.first);
                return;
            }
            Device O000000o4 = fno.O000000o().O000000o((String) pair.first);
            TextView textView2 = (TextView) ezc.O000000o((int) R.id.device_name);
            TextView textView3 = (TextView) ezc.O000000o((int) R.id.home);
            View O000000o5 = ezc.O000000o((int) R.id.offline);
            SwitchButton switchButton = (SwitchButton) ezc.O000000o((int) R.id.sbSync);
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) ezc.O000000o((int) R.id.device_icon);
            if (O000000o4 != null) {
                DeviceFactory.O00000Oo(O000000o4.model, simpleDraweeView);
                textView2.setText(O000000o4.name);
                Room O0000o00 = ggb.O00000Oo().O0000o00(O000000o4.did);
                String string = O0000o00 == null ? this.f15968O000000o.getResources().getString(R.string.room_default) : O0000o00.getName();
                switchButton.setChecked(((Boolean) pair.second).booleanValue(), false);
                if (O000000o4.isOnline) {
                    textView3.setText(string);
                    textView2.setAlpha(1.0f);
                    textView3.setAlpha(1.0f);
                    O000000o5.setVisibility(8);
                    switchButton.setOnTouchEnable(true);
                    switchButton.setEnabled(true);
                    switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(pair, i, switchButton) {
                        /* class com.xiaomi.smarthome.scene.ui.sleep.$$Lambda$SleepModeActivity$O000000o$em_7szwbopvnuKUCYNlLIRJ3_1M */
                        private final /* synthetic */ Pair f$1;
                        private final /* synthetic */ int f$2;
                        private final /* synthetic */ SwitchButton f$3;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                        }

                        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                            SleepModeActivity.O000000o.this.O000000o(this.f$1, this.f$2, this.f$3, compoundButton, z);
                        }
                    });
                    return;
                }
                textView3.setText(string + " |");
                textView2.setAlpha(0.5f);
                textView3.setAlpha(0.5f);
                O000000o5.setVisibility(0);
                switchButton.setOnCheckedChangeListener(null);
                switchButton.setOnTouchEnable(false);
                switchButton.setEnabled(false);
                return;
            }
            DeviceFactory.O00000Oo("", simpleDraweeView);
            textView2.setText("");
            textView3.setText("");
        }

        public O000000o(Context context, List<Pair<String, Boolean>> list) {
            super(context, list);
            fno.O000000o().O000000o(this);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(Pair pair, int i, SwitchButton switchButton, CompoundButton compoundButton, boolean z) {
            Pair pair2 = pair;
            LogType logType = LogType.DEVICE_LIST;
            gsy.O00000o0(logType, "SleepModeActivity", "setOnCheckedChangeListener  item:" + pair + " check:" + z);
            String[] time = SleepModeActivity.this.getTime();
            hxi.O00000o.f952O000000o.O000000o("sleep_speaker_click", "type", Integer.valueOf(z ? 1 : 0), "position", Integer.valueOf(i));
            if (time.length == 2) {
                final int i2 = i;
                final Pair pair3 = pair;
                final boolean z2 = z;
                final SwitchButton switchButton2 = switchButton;
                hrk.O000000o(SleepModeActivity.this.mHomeId, (String) pair2.first, z, time[0], time[1], new fsm<JSONObject, fso>() {
                    /* class com.xiaomi.smarthome.scene.ui.sleep.SleepModeActivity.O000000o.AnonymousClass1 */

                    public final void onFailure(fso fso) {
                        switchButton2.setChecked(!z2, false);
                        gqg.O00000Oo((int) R.string.load_data_error);
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        O000000o.this.O00000Oo.set(i2, new Pair(pair3.first, Boolean.valueOf(z2)));
                    }
                });
                return;
            }
            gqg.O00000Oo((int) R.string.mj_scene_sleepnotime_error);
        }

        public final int O00000Oo(int i) {
            return ((Pair) O000000o(i)).second == null ? 1 : 2;
        }

        public final void onRefreshClientDeviceSuccess(int i) {
            notifyDataSetChanged();
        }

        public final void onRefreshClientDeviceChanged(int i, Device device) {
            notifyDataSetChanged();
        }
    }
}
