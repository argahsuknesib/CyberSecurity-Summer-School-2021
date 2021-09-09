package com.xiaomi.smarthome.miio.activity;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gft;
import _m_j.gfu;
import _m_j.gjh;
import _m_j.gkm;
import _m_j.gqg;
import _m_j.gwc;
import _m_j.hje;
import _m_j.hjf;
import _m_j.hxi;
import _m_j.hxk;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.plugin.PluginRuntimeManager;
import com.xiaomi.smarthome.frame.plugin.RunningProcess;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LanguageSettingActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    RecyclerView f9679O000000o;
    boolean O00000Oo;
    private RecyclerView.O000000o O00000o0;
    public int mOldLanguageNameId = -1;
    public XQProgressDialog mProcessDialog;

    class O00000o0 extends RecyclerView.O000000o<O00000Oo> implements View.OnClickListener {
        private List<gkm> O00000Oo;
        private Locale O00000o = CoreApi.O000000o().O00oOooo();
        private LayoutInflater O00000o0;

        public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            O00000Oo o00000Oo = (O00000Oo) o000OOo0;
            o00000Oo.itemView.setTag(Integer.valueOf(i));
            o00000Oo.itemView.setOnClickListener(this);
            int i2 = this.O00000Oo.get(i).O00000o;
            o00000Oo.f9683O000000o.setText(i2);
            if (gwc.O000000o(gwc.O0000Oo, this.O00000o)) {
                if (LanguageSettingActivity.this.O00000Oo && i == 0) {
                    o00000Oo.f9683O000000o.setTextColor(-13452608);
                    return;
                } else if (!LanguageSettingActivity.this.O00000Oo && gwc.O000000o(this.O00000Oo.get(i).f17944O000000o, Locale.US)) {
                    o00000Oo.f9683O000000o.setTextColor(-13452608);
                    return;
                }
            }
            if (gwc.O000000o(this.O00000Oo.get(i).f17944O000000o, this.O00000o)) {
                o00000Oo.f9683O000000o.setTextColor(-13452608);
                LanguageSettingActivity.this.mOldLanguageNameId = i2;
            }
        }

        public O00000o0(Context context) {
            Locale locale;
            this.O00000o0 = LayoutInflater.from(context.getApplicationContext());
            ArrayList arrayList = new ArrayList();
            arrayList.add(new gkm(null, 0, R.string.settings_language_default, ""));
            arrayList.add(new gkm(Locale.CHINA, 1, R.string.settings_language_zh, "zh"));
            arrayList.add(new gkm(Locale.TRADITIONAL_CHINESE, 2, R.string.settings_language_zh_rtw, "tw"));
            arrayList.add(new gkm(gwc.f18401O000000o, 4, R.string.settings_language_zh_hk, "hk"));
            arrayList.add(new gkm(Locale.US, 3, R.string.settings_language_us, "us"));
            arrayList.add(new gkm(gwc.O00000o0, 6, R.string.settings_language_es, "es"));
            arrayList.add(new gkm(gwc.O00000o, 7, R.string.settings_language_ru, "ru"));
            arrayList.add(new gkm(gwc.O00000Oo, 5, R.string.settings_language_ko, "ko"));
            arrayList.add(new gkm(Locale.ITALY, 9, R.string.settings_language_it, "it"));
            arrayList.add(new gkm(Locale.FRANCE, 8, R.string.settings_language_fr, "fr"));
            arrayList.add(new gkm(Locale.GERMANY, 10, R.string.settings_language_de, "de"));
            arrayList.add(new gkm(gwc.O0000Oo0, 11, R.string.settings_language_id, "id"));
            arrayList.add(new gkm(gwc.O00000oO, 12, R.string.settings_language_pl, "pl"));
            arrayList.add(new gkm(gwc.O00000oo, 13, R.string.settings_language_vi, "vi"));
            arrayList.add(new gkm(Locale.JAPAN, 14, R.string.settings_language_ja, "ja"));
            arrayList.add(new gkm(gwc.O0000O0o, 15, R.string.settings_language_th, "th"));
            arrayList.add(new gkm(gwc.O0000o00, 16, R.string.settings_language_nl, "nl"));
            arrayList.add(new gkm(gwc.O0000OoO, 17, R.string.settings_language_pt, "pt_BR"));
            arrayList.add(new gkm(gwc.O0000Ooo, 18, R.string.settings_language_tr, "tr"));
            this.O00000Oo = arrayList;
            if (Build.VERSION.SDK_INT >= 24) {
                locale = Resources.getSystem().getConfiguration().getLocales().get(0);
            } else {
                locale = Locale.getDefault();
            }
            boolean O000000o2 = gwc.O000000o(context);
            if (gwc.O0000o0.contains(locale)) {
                if (O000000o2) {
                    this.O00000o = gwc.O0000Oo;
                } else if (gwc.O000000o(Locale.US, this.O00000o)) {
                    this.O00000o = gwc.O0000Oo;
                }
            } else if (!gwc.O000000o(gwc.O0000Oo, this.O00000o)) {
            } else {
                if (O000000o2) {
                    this.O00000o = locale;
                } else {
                    this.O00000o = Locale.US;
                }
            }
        }

        public final int getItemCount() {
            List<gkm> list = this.O00000Oo;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public final void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (intValue >= 0 && intValue < this.O00000Oo.size()) {
                LanguageSettingActivity languageSettingActivity = LanguageSettingActivity.this;
                int i = this.O00000Oo.get(intValue).O00000o0;
                int i2 = this.O00000Oo.get(intValue).O00000o;
                languageSettingActivity.mProcessDialog = new XQProgressDialog(languageSettingActivity);
                languageSettingActivity.mProcessDialog.setCancelable(false);
                languageSettingActivity.mProcessDialog.setMessage(languageSettingActivity.getResources().getString(R.string.loading_share_info));
                languageSettingActivity.mProcessDialog.show();
                gwc.O000000o(i, new O000000o(languageSettingActivity, i2, (byte) 0));
                CommonApplication.getAppContext();
                hje.O000000o();
                if (!TextUtils.isEmpty(CoreApi.O000000o().O0000o0()) && hjf.O000000o(ServiceApplication.getAppContext()).O00000o0) {
                    hjf.O000000o(ServiceApplication.getAppContext()).O000000o();
                }
                gjh.O000000o();
                gjh.O000000o(true);
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            View inflate = this.O00000o0.inflate((int) R.layout.item_language_setting, viewGroup, false);
            inflate.setOnClickListener(this);
            return new O00000Oo(inflate);
        }
    }

    class O00000Oo extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public TextView f9683O000000o;

        public O00000Oo(View view) {
            super(view);
            this.f9683O000000o = (TextView) view.findViewById(R.id.text);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.language_setting_layout);
        this.O00000Oo = gwc.O000000o((Context) this);
        this.O00000o0 = new O00000o0(this);
        this.f9679O000000o = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        this.f9679O000000o.setLayoutManager(linearLayoutManager);
        this.f9679O000000o.setAdapter(this.O00000o0);
        this.f9679O000000o.setHasFixedSize(true);
        this.f9679O000000o.setFocusable(false);
        ((NestedScrollView) findViewById(R.id.nested_scroll_parent)).requestFocus();
        gfu O000000o2 = gft.O000000o();
        if (O000000o2 == null || !O000000o2.isShowGlobalShop(ServiceApplication.getAppContext())) {
            findViewById(R.id.shop_tip).setVisibility(8);
        } else {
            findViewById(R.id.shop_tip).setVisibility(0);
            findViewById(R.id.shop_tip_close).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.activity.LanguageSettingActivity.AnonymousClass1 */

                public final void onClick(View view) {
                    LanguageSettingActivity.this.findViewById(R.id.shop_tip).setVisibility(8);
                }
            });
        }
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.LanguageSettingActivity.AnonymousClass2 */

            public final void onClick(View view) {
                LanguageSettingActivity.this.finish();
            }
        });
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.settings_language);
    }

    static class O000000o extends fsm<Void, fso> {

        /* renamed from: O000000o  reason: collision with root package name */
        private final WeakReference<LanguageSettingActivity> f9682O000000o;
        private final int O00000Oo;

        /* synthetic */ O000000o(LanguageSettingActivity languageSettingActivity, int i, byte b) {
            this(languageSettingActivity, i);
        }

        private O000000o(LanguageSettingActivity languageSettingActivity, int i) {
            this.f9682O000000o = new WeakReference<>(languageSettingActivity);
            this.O00000Oo = i;
        }

        public final void onFailure(fso fso) {
            LanguageSettingActivity languageSettingActivity = this.f9682O000000o.get();
            if (languageSettingActivity.isValid()) {
                if (languageSettingActivity.mProcessDialog != null) {
                    languageSettingActivity.mProcessDialog.dismiss();
                }
                gqg.O00000Oo((int) R.string.mi_brain_setting_fail);
            }
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            LanguageSettingActivity languageSettingActivity = this.f9682O000000o.get();
            if (languageSettingActivity.isValid()) {
                PluginApi.getInstance().exitProcess(RunningProcess.PLUGIN0);
                PluginApi.getInstance().exitProcess(RunningProcess.PLUGIN1);
                PluginApi.getInstance().exitProcess(RunningProcess.PLUGIN2);
                PluginApi.getInstance().exitProcess(RunningProcess.PLUGIN3);
                PluginRuntimeManager.getInstance().exitAllFrameProcess();
                PluginApi.getInstance().exitProcess(RunningProcess.CAMERA);
                if (languageSettingActivity.mProcessDialog != null) {
                    languageSettingActivity.mProcessDialog.dismiss();
                }
                languageSettingActivity.setResult(-1);
                fbt fbt = new fbt(ServiceApplication.getAppContext(), "SmartHomeMainActivity");
                fbt.O00000Oo(335544320);
                fbs.O000000o(fbt);
                if (!(this.O00000Oo == languageSettingActivity.mOldLanguageNameId || languageSettingActivity.mOldLanguageNameId == -1)) {
                    hxk hxk = hxi.O00000o;
                    String string = languageSettingActivity.getString(languageSettingActivity.mOldLanguageNameId);
                    String string2 = languageSettingActivity.getString(this.O00000Oo);
                    hxk.f952O000000o.O000000o("set_language_click", "old", string, "new", string2);
                }
                languageSettingActivity.finish();
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.mProcessDialog != null) {
                this.mProcessDialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
