package com.xiaomi.smarthome.light.group;

import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ggb;
import _m_j.gp;
import _m_j.gsy;
import _m_j.gtf;
import _m_j.hte;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.api.DeviceApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.light.group.LightGroupInitActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class LightGroupInitActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    String f9342O000000o;
    fno.O000000o O00000Oo = new fno.O000000o() {
        /* class com.xiaomi.smarthome.light.group.LightGroupInitActivity.AnonymousClass5 */

        public final void onRefreshClientDeviceChanged(int i, Device device) {
        }

        public final void onRefreshClientDeviceSuccess(int i) {
            if (i == 3 && fno.O000000o().O000000o(LightGroupInitActivity.this.f9342O000000o) != null) {
                fno.O000000o().O00000Oo(LightGroupInitActivity.this.O00000Oo);
                LightGroupInitActivity.this.finishPage(-1);
            }
        }
    };
    private ArrayList<String> O00000o;
    private HandlerThread O00000o0;
    private Device O00000oO;
    private TextView O00000oo;
    private TextView O0000O0o;
    private XQProgressDialog O0000OOo;
    public boolean isUpdateInfo;
    public O00000Oo lightGroupAdapter;
    public Handler mCheckMsgHandler;
    public String mGroupStatus = "0";
    public Handler mHandler = new Handler();

    public static void open(Activity activity, String str, int i) {
        Intent intent = new Intent();
        intent.setClass(activity, LightGroupInitActivity.class);
        intent.putExtra("did", str);
        activity.startActivityForResult(intent, i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x003a, code lost:
        if (_m_j.gtf.O00000Oo(r4.O00000oO) == false) goto L_0x003c;
     */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_light_group_init);
        this.f9342O000000o = getIntent().getStringExtra("did");
        if (TextUtils.isEmpty(this.f9342O000000o)) {
            finishPage(0);
        }
        this.O00000oO = fno.O000000o().O000000o(this.f9342O000000o);
        if (this.O00000oO != null) {
            gtf.O000000o();
        }
        finishPage(0);
        this.O00000o = new ArrayList<>();
        this.O00000o.add(this.f9342O000000o);
        this.O00000o0 = new HandlerThread("check-message-coming");
        this.O00000o0.start();
        this.mCheckMsgHandler = new Handler(this.O00000o0.getLooper()) {
            /* class com.xiaomi.smarthome.light.group.LightGroupInitActivity.AnonymousClass1 */

            public final void handleMessage(Message message) {
                if (LightGroupInitActivity.this.isUpdateInfo && message.what == 272) {
                    LightGroupInitActivity.this.checkForUpdate();
                }
                if (message.what == 256) {
                    LightGroupInitActivity.this.stopPolling();
                    for (int i = 0; i < LightGroupInitActivity.this.lightGroupAdapter.f9349O000000o.size(); i++) {
                        if (TextUtils.equals(LightGroupInitActivity.this.lightGroupAdapter.f9349O000000o.get(i).O00000Oo, "0")) {
                            LightGroupInitActivity.this.lightGroupAdapter.f9349O000000o.get(i).O00000Oo = "3";
                        }
                    }
                    LightGroupInitActivity.this.mHandler.post(new Runnable() {
                        /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupInitActivity$1$oKrMF8q9xjpcpB9qd5gcmwzV3eU */

                        public final void run() {
                            LightGroupInitActivity.AnonymousClass1.this.O000000o();
                        }
                    });
                    gsy.O00000Oo("zxt", "timeout!");
                }
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o() {
                LightGroupInitActivity.this.lightGroupAdapter.notifyDataSetChanged();
                LightGroupInitActivity lightGroupInitActivity = LightGroupInitActivity.this;
                lightGroupInitActivity.setJumpButtonEnable(lightGroupInitActivity.canJumpOver());
                LightGroupInitActivity.this.setRetryButtonEnable(true);
            }
        };
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        findViewById(R.id.module_a_3_right_img_btn).setVisibility(8);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupInitActivity$kjtmIkFOCi6DkIz5fUQ2krM1Tnk */

            public final void onClick(View view) {
                LightGroupInitActivity.this.O00000o0(view);
            }
        });
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.light_group_init);
        this.O0000O0o = (TextView) findViewById(R.id.tv_jump_over);
        setJumpButtonEnable(false);
        this.O0000O0o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupInitActivity$ifzojt1qtnblpgOXWlOr60fFvI */

            public final void onClick(View view) {
                LightGroupInitActivity.this.O00000Oo(view);
            }
        });
        this.O00000oo = (TextView) findViewById(R.id.tv_all_retry);
        setRetryButtonEnable(false);
        this.O00000oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupInitActivity$tV6giZvv2vDJKfMimqnw8cCZt3Q */

            public final void onClick(View view) {
                LightGroupInitActivity.this.O000000o(view);
            }
        });
        this.lightGroupAdapter = new O00000Oo(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(this.lightGroupAdapter);
        O00000Oo();
    }

    public void countdownTimer() {
        long j = 0;
        for (int i = 0; i < this.lightGroupAdapter.f9349O000000o.size(); i++) {
            if (!TextUtils.equals(this.lightGroupAdapter.f9349O000000o.get(i).O00000Oo, "1")) {
                j += 5000;
            }
        }
        if (j < 20000) {
            j = 20000;
        }
        gsy.O00000Oo("zxt", "countdownTimer: ".concat(String.valueOf(j)));
        this.mCheckMsgHandler.removeMessages(256);
        this.mCheckMsgHandler.sendEmptyMessageDelayed(256, j);
    }

    public void onResume() {
        super.onResume();
        countdownTimer();
        startPolling();
    }

    public void onPause() {
        super.onPause();
        this.mCheckMsgHandler.removeMessages(256);
        stopPolling();
    }

    public void onDestroy() {
        super.onDestroy();
        O000000o();
        this.mCheckMsgHandler.removeCallbacksAndMessages(null);
        this.O00000o0.quit();
        fno.O000000o().O00000Oo(this.O00000Oo);
    }

    public void onBackPressed() {
        if (this.lightGroupAdapter.f9349O000000o.size() <= 0 || !O00000o0().isEmpty()) {
            finishPage(0);
        } else {
            finishPage(-1);
        }
    }

    public void finishPage(int i) {
        setResult(i);
        finish();
    }

    public void startPolling() {
        this.isUpdateInfo = true;
        this.mCheckMsgHandler.sendEmptyMessage(272);
    }

    public void stopPolling() {
        this.isUpdateInfo = false;
        this.mCheckMsgHandler.removeMessages(272);
    }

    private void O00000Oo() {
        ArrayList arrayList = new ArrayList();
        List<Device> O0000O0o2 = fno.O000000o().O0000O0o(this.f9342O000000o);
        for (int i = 0; i < O0000O0o2.size(); i++) {
            Device device = O0000O0o2.get(i);
            if (device != null) {
                arrayList.add(new O00000o0(device, "0"));
            }
        }
        this.lightGroupAdapter.f9349O000000o = arrayList;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(View view) {
        onBackPressed();
    }

    public void checkForUpdate() {
        try {
            final ArrayList arrayList = new ArrayList();
            DeviceApi.getInstance().queryLightGroup(this, this.O00000o, new fsm<String, fso>() {
                /* class com.xiaomi.smarthome.light.group.LightGroupInitActivity.AnonymousClass2 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    try {
                        JSONArray optJSONArray = new JSONObject((String) obj).optJSONArray("result");
                        if (optJSONArray != null) {
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                                String optString = optJSONObject.optString("group_did");
                                if (TextUtils.equals(optString, LightGroupInitActivity.this.f9342O000000o)) {
                                    LightGroupInitActivity.this.mGroupStatus = optJSONObject.optString("status", "0");
                                    fno O000000o2 = fno.O000000o();
                                    O000000o2.f16707O000000o.setVirtualGroupStatus(optString, LightGroupInitActivity.this.mGroupStatus);
                                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("member_ship");
                                    if (optJSONObject2 != null) {
                                        Iterator<String> keys = optJSONObject2.keys();
                                        while (keys.hasNext()) {
                                            String next = keys.next();
                                            String optString2 = optJSONObject2.optString(next, "3");
                                            Device O00000oo = fno.O000000o().O00000oo(next);
                                            if (O00000oo != null) {
                                                arrayList.add(new O00000o0(O00000oo, optString2));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (TextUtils.equals(LightGroupInitActivity.this.mGroupStatus, "0")) {
                            LightGroupInitActivity.this.mCheckMsgHandler.sendEmptyMessageDelayed(272, 5000);
                        } else {
                            LightGroupInitActivity.this.stopPolling();
                            if (TextUtils.equals(LightGroupInitActivity.this.mGroupStatus, "1")) {
                                hte.O000000o(LightGroupInitActivity.this, (int) R.string.light_group_init_success);
                                LightGroupInitActivity.this.mCheckMsgHandler.removeMessages(256);
                                LightGroupInitActivity.this.mHandler.postDelayed(new Runnable() {
                                    /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupInitActivity$2$Dut35Be54yf5nQHvR8zBAPjeQM */

                                    public final void run() {
                                        LightGroupInitActivity.AnonymousClass2.this.O00000o0();
                                    }
                                }, 1000);
                            } else {
                                LightGroupInitActivity.this.mHandler.post(new Runnable() {
                                    /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupInitActivity$2$212Fo3ULZuBdW5_LTA2YaTxcV5c */

                                    public final void run() {
                                        LightGroupInitActivity.AnonymousClass2.this.O00000Oo();
                                    }
                                });
                            }
                        }
                        if (!LightGroupInitActivity.this.lightGroupAdapter.f9349O000000o.isEmpty()) {
                            gp.O000000o(new O000000o(LightGroupInitActivity.this.lightGroupAdapter.f9349O000000o, arrayList), false).O000000o(LightGroupInitActivity.this.lightGroupAdapter);
                            LightGroupInitActivity.this.lightGroupAdapter.f9349O000000o = arrayList;
                        } else {
                            LightGroupInitActivity.this.mHandler.post(new Runnable(arrayList) {
                                /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupInitActivity$2$81fOFqezw8ug4qqLTPv0P7HWZY8 */
                                private final /* synthetic */ ArrayList f$1;

                                {
                                    this.f$1 = r2;
                                }

                                public final void run() {
                                    LightGroupInitActivity.AnonymousClass2.this.O000000o(this.f$1);
                                }
                            });
                        }
                        LightGroupInitActivity.this.mHandler.post(new Runnable() {
                            /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupInitActivity$2$El13n3euYMETgMuLrIsRgyP9MzU */

                            public final void run() {
                                LightGroupInitActivity.AnonymousClass2.this.O000000o();
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O00000o0() {
                    LightGroupInitActivity.this.finishPage(-1);
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O00000Oo() {
                    LightGroupInitActivity.this.setRetryButtonEnable(true);
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O000000o(ArrayList arrayList) {
                    LightGroupInitActivity.this.lightGroupAdapter.f9349O000000o = arrayList;
                    LightGroupInitActivity.this.lightGroupAdapter.notifyDataSetChanged();
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O000000o() {
                    LightGroupInitActivity lightGroupInitActivity = LightGroupInitActivity.this;
                    lightGroupInitActivity.setJumpButtonEnable(lightGroupInitActivity.canJumpOver());
                }

                public final void onFailure(fso fso) {
                    hte.O000000o(LightGroupInitActivity.this, fso.O00000Oo);
                    LightGroupInitActivity.this.mCheckMsgHandler.sendEmptyMessageDelayed(272, 5000);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setRetryButtonEnable(boolean z) {
        int i;
        this.O00000oo.setEnabled(z);
        TextView textView = this.O00000oo;
        if (z) {
            i = getResources().getColor(R.color.mj_color_gray_heavier);
        } else {
            i = getResources().getColor(R.color.mj_color_gray_normal);
        }
        textView.setTextColor(i);
    }

    public void setJumpButtonEnable(boolean z) {
        int i;
        this.O0000O0o.setEnabled(z);
        TextView textView = this.O0000O0o;
        if (z) {
            i = getResources().getColor(R.color.mj_color_gray_heavier);
        } else {
            i = getResources().getColor(R.color.mj_color_gray_normal);
        }
        textView.setTextColor(i);
    }

    public void retry(ArrayList<String> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            stopPolling();
            this.mCheckMsgHandler.removeMessages(256);
            gsy.O00000Oo("zxt", "retry: " + arrayList.size());
            ArrayList arrayList2 = new ArrayList();
            DeviceApi.getInstance().modLightGroup(this, this.f9342O000000o, arrayList, arrayList2, new fsm<String, fso>() {
                /* class com.xiaomi.smarthome.light.group.LightGroupInitActivity.AnonymousClass3 */

                public final void onFailure(fso fso) {
                    hte.O000000o(LightGroupInitActivity.this, fso.O00000Oo);
                    LightGroupInitActivity.this.startPolling();
                    LightGroupInitActivity.this.countdownTimer();
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    LightGroupInitActivity.this.startPolling();
                    LightGroupInitActivity.this.countdownTimer();
                }
            }, true);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(DialogInterface dialogInterface, int i) {
        startPolling();
    }

    private ArrayList<String> O00000o0() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < this.lightGroupAdapter.f9349O000000o.size(); i++) {
            if (!TextUtils.equals(this.lightGroupAdapter.f9349O000000o.get(i).O00000Oo, "1")) {
                arrayList.add(this.lightGroupAdapter.f9349O000000o.get(i).f9351O000000o.did);
            }
        }
        return arrayList;
    }

    public boolean canJumpOver() {
        int i = 0;
        for (int i2 = 0; i2 < this.lightGroupAdapter.f9349O000000o.size(); i2++) {
            if (!TextUtils.equals(this.lightGroupAdapter.f9349O000000o.get(i2).O00000Oo, "1")) {
                i++;
            }
        }
        if (i <= 0 || this.lightGroupAdapter.f9349O000000o.size() <= i) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final void O000000o() {
        XQProgressDialog xQProgressDialog = this.O0000OOo;
        if (xQProgressDialog != null) {
            xQProgressDialog.dismiss();
        }
    }

    class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        Device f9351O000000o;
        String O00000Oo;

        O00000o0(Device device, String str) {
            this.f9351O000000o = device;
            this.O00000Oo = str;
        }
    }

    public class O00000Oo extends RecyclerView.O000000o<O00000o> {

        /* renamed from: O000000o  reason: collision with root package name */
        public List<O00000o0> f9349O000000o = new ArrayList();
        private LayoutInflater O00000o0;

        public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            O00000o o00000o = (O00000o) o000OOo0;
            O00000o0 o00000o0 = this.f9349O000000o.get(i);
            if (o00000o0.f9351O000000o != null && o00000o != null) {
                if (TextUtils.equals(o00000o0.O00000Oo, "1")) {
                    o00000o.O00000oO.setBackgroundResource(R.drawable.icon_light_group_checked);
                    o00000o.O00000oO.setVisibility(0);
                    o00000o.O00000oo.setVisibility(8);
                    o00000o.O00000oo.clearAnimation();
                    o00000o.O00000oO.setOnClickListener(null);
                } else if (TextUtils.equals(o00000o0.O00000Oo, "3")) {
                    o00000o.O00000oO.setBackgroundResource(R.drawable.icon_light_group_failed);
                    o00000o.O00000oO.setVisibility(0);
                    o00000o.O00000oo.setVisibility(8);
                    o00000o.O00000oo.clearAnimation();
                    o00000o.O00000oO.setOnClickListener(new View.OnClickListener(o00000o0, i) {
                        /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupInitActivity$O00000Oo$1lQLlmkfC6bjfPNx1emng22MeOc */
                        private final /* synthetic */ LightGroupInitActivity.O00000o0 f$1;
                        private final /* synthetic */ int f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void onClick(View view) {
                            LightGroupInitActivity.O00000Oo.this.O000000o(this.f$1, this.f$2, view);
                        }
                    });
                } else {
                    o00000o.O00000oO.setVisibility(8);
                    o00000o.O00000oo.setVisibility(0);
                    o00000o.O00000oO.setOnClickListener(null);
                }
                o00000o.O00000Oo.setText(o00000o0.f9351O000000o.name);
                o00000o.O00000o0.setText(ggb.O00000Oo().O0000o0O(o00000o0.f9351O000000o.did) + "  " + ((Object) DeviceRouterFactory.getDeviceWrapper().getStatusDescription(o00000o0.f9351O000000o, LightGroupInitActivity.this)));
                DeviceFactory.O00000Oo(o00000o0.f9351O000000o.model, o00000o.O00000o);
            }
        }

        public final /* synthetic */ void onViewAttachedToWindow(RecyclerView.O000OOo0 o000OOo0) {
            O00000o o00000o = (O00000o) o000OOo0;
            super.onViewAttachedToWindow(o00000o);
            if (o00000o.O00000oo.getVisibility() == 0) {
                o00000o.O00000oo.startAnimation(AnimationUtils.loadAnimation(LightGroupInitActivity.this.getContext(), R.anim.rotate_infinite));
            }
        }

        public final /* synthetic */ void onViewDetachedFromWindow(RecyclerView.O000OOo0 o000OOo0) {
            O00000o o00000o = (O00000o) o000OOo0;
            super.onViewDetachedFromWindow(o00000o);
            o00000o.O00000oo.clearAnimation();
        }

        O00000Oo(Context context) {
            this.O00000o0 = LayoutInflater.from(context);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(O00000o0 o00000o0, int i, View view) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(o00000o0.f9351O000000o.did);
            o00000o0.O00000Oo = "0";
            notifyItemChanged(i);
            LightGroupInitActivity.this.retry(arrayList);
        }

        public final int getItemCount() {
            return this.f9349O000000o.size();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new O00000o(this.O00000o0.inflate((int) R.layout.item_light_group_init, viewGroup, false));
        }
    }

    class O00000o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        View f9350O000000o;
        TextView O00000Oo;
        SimpleDraweeView O00000o;
        TextView O00000o0;
        ImageView O00000oO;
        ImageView O00000oo;

        public O00000o(View view) {
            super(view);
            this.f9350O000000o = view;
            this.O00000Oo = (TextView) view.findViewById(R.id.title);
            this.O00000o0 = (TextView) view.findViewById(R.id.desc);
            this.O00000o = (SimpleDraweeView) view.findViewById(R.id.icon);
            this.O00000oO = (ImageView) view.findViewById(R.id.iv_status);
            this.O00000oo = (ImageView) view.findViewById(R.id.iv_loading);
        }
    }

    class O000000o extends gp.O000000o {
        private List<O00000o0> O00000Oo;
        private List<O00000o0> O00000o0;

        O000000o(List<O00000o0> list, List<O00000o0> list2) {
            this.O00000Oo = list;
            this.O00000o0 = list2;
        }

        public final int O000000o() {
            List<O00000o0> list = this.O00000Oo;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public final int O00000Oo() {
            List<O00000o0> list = this.O00000o0;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public final boolean O000000o(int i, int i2) {
            O00000o0 o00000o0 = this.O00000Oo.get(i);
            O00000o0 o00000o02 = this.O00000o0.get(i2);
            if (o00000o0 == null || o00000o02 == null) {
                return false;
            }
            return TextUtils.equals(o00000o0.f9351O000000o.did, o00000o02.f9351O000000o.did);
        }

        public final boolean O00000Oo(int i, int i2) {
            O00000o0 o00000o0 = this.O00000Oo.get(i);
            O00000o0 o00000o02 = this.O00000o0.get(i2);
            if (TextUtils.equals(o00000o0.O00000Oo, o00000o02.O00000Oo) && TextUtils.equals(DeviceRouterFactory.getDeviceWrapper().getStatusDescription(o00000o0.f9351O000000o, LightGroupInitActivity.this), DeviceRouterFactory.getDeviceWrapper().getStatusDescription(o00000o02.f9351O000000o, LightGroupInitActivity.this))) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(DialogInterface dialogInterface, int i) {
        if (isValid()) {
            this.O0000OOo = new XQProgressDialog(this);
            this.O0000OOo.setMessage(getString(R.string.device_more_security_loading_operation));
            this.O0000OOo.show();
        }
        stopPolling();
        this.mCheckMsgHandler.removeMessages(256);
        ArrayList arrayList = new ArrayList();
        DeviceApi.getInstance().modLightGroup(this, this.f9342O000000o, arrayList, O00000o0(), new fsm<String, fso>() {
            /* class com.xiaomi.smarthome.light.group.LightGroupInitActivity.AnonymousClass4 */

            public final void onFailure(fso fso) {
                hte.O000000o(LightGroupInitActivity.this, (int) R.string.code_default_error);
                LightGroupInitActivity.this.startPolling();
                LightGroupInitActivity.this.countdownTimer();
                LightGroupInitActivity.this.O000000o();
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                fno.O000000o().O000000o(LightGroupInitActivity.this.O00000Oo);
                fno.O000000o().O0000Oo0();
                LightGroupInitActivity.this.O000000o();
            }
        }, true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.lightGroupAdapter.f9349O000000o.size(); i++) {
            if (TextUtils.equals(this.lightGroupAdapter.f9349O000000o.get(i).O00000Oo, "3")) {
                arrayList.add(this.lightGroupAdapter.f9349O000000o.get(i).f9351O000000o.did);
                this.lightGroupAdapter.f9349O000000o.get(i).O00000Oo = "0";
            }
        }
        if (arrayList.size() > 0) {
            this.lightGroupAdapter.notifyDataSetChanged();
        }
        retry(arrayList);
        setRetryButtonEnable(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        new MLAlertDialog.Builder(this).O00000Oo(getString(R.string.light_grouped_jump_over)).O000000o((int) R.string.jump_over, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupInitActivity$EwrEJhmiUwzCwx_qtJlyHGkIC0A */

            public final void onClick(DialogInterface dialogInterface, int i) {
                LightGroupInitActivity.this.O00000Oo(dialogInterface, i);
            }
        }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupInitActivity$tR2dANGthacVGxvlRfHePcOqdMs */

            public final void onClick(DialogInterface dialogInterface, int i) {
                LightGroupInitActivity.this.O000000o(dialogInterface, i);
            }
        }).O000000o(getResources().getColor(R.color.mj_color_red_normal), -1).O00000oo().getButton(-1).setBackgroundResource(R.drawable.normal_denied_button);
    }
}
