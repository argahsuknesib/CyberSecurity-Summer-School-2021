package com.xiaomi.smarthome.nfctag.ui;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.fnn;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.fuy;
import _m_j.fwq;
import _m_j.goy;
import _m_j.gpy;
import _m_j.grr;
import _m_j.gtx;
import _m_j.gty;
import _m_j.hig;
import _m_j.hih;
import _m_j.hii;
import _m_j.hor;
import _m_j.hte;
import _m_j.hxi;
import _m_j.inc;
import _m_j.ind;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.utils.DeviceTagInterface;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.nfctag.ui.NFCActionListActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class NFCActionListActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    O000000o f10385O000000o;
    List<O00000Oo> O00000Oo = new ArrayList();
    private MLAlertDialog O00000o0 = null;
    @BindView(5075)
    View emptyView;
    @BindView(5685)
    RecyclerView mRecyclerList;
    public Dialog mTmpDialog = null;
    @BindView(5542)
    TextView nfcHint;
    public String supportSpeakerInfo = null;
    public String supportTVInfo = null;

    interface O00000o0 {
        void onClick(Intent intent);
    }

    public class GroupViewHolder0_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private GroupViewHolder0 f10395O000000o;

        public GroupViewHolder0_ViewBinding(GroupViewHolder0 groupViewHolder0, View view) {
            this.f10395O000000o = groupViewHolder0;
            groupViewHolder0.txtTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_title, "field 'txtTitle'", TextView.class);
        }

        public void unbind() {
            GroupViewHolder0 groupViewHolder0 = this.f10395O000000o;
            if (groupViewHolder0 != null) {
                this.f10395O000000o = null;
                groupViewHolder0.txtTitle = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public class HintViewHolder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private HintViewHolder f10397O000000o;

        public HintViewHolder_ViewBinding(HintViewHolder hintViewHolder, View view) {
            this.f10397O000000o = hintViewHolder;
            hintViewHolder.hint = (TextView) Utils.findRequiredViewAsType(view, R.id.nfc_hint, "field 'hint'", TextView.class);
        }

        public void unbind() {
            HintViewHolder hintViewHolder = this.f10397O000000o;
            if (hintViewHolder != null) {
                this.f10397O000000o = null;
                hintViewHolder.hint = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public class ChildViewHolder1_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private ChildViewHolder1 f10393O000000o;

        public ChildViewHolder1_ViewBinding(ChildViewHolder1 childViewHolder1, View view) {
            this.f10393O000000o = childViewHolder1;
            childViewHolder1.txtTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_title, "field 'txtTitle'", TextView.class);
            childViewHolder1.txtSubTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_sub_title, "field 'txtSubTitle'", TextView.class);
            childViewHolder1.imgIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.img_icon, "field 'imgIcon'", ImageView.class);
        }

        public void unbind() {
            ChildViewHolder1 childViewHolder1 = this.f10393O000000o;
            if (childViewHolder1 != null) {
                this.f10393O000000o = null;
                childViewHolder1.txtTitle = null;
                childViewHolder1.txtSubTitle = null;
                childViewHolder1.imgIcon = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        hig.O00000Oo = null;
        String stringExtra = getIntent().getStringExtra("us_id");
        if (stringExtra != null) {
            hig.O00000Oo = stringExtra;
        }
        if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
            gty.O000000o().startLogin(this, 1, new gtx.O000000o() {
                /* class com.xiaomi.smarthome.nfctag.ui.NFCActionListActivity.AnonymousClass1 */

                public final void O000000o() {
                    if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
                        hte.O000000o(NFCActionListActivity.this, (int) R.string.login_fail);
                        NFCActionListActivity.this.finish();
                        return;
                    }
                    NFCActionListActivity.this.doWork();
                }
            });
        } else {
            doWork();
        }
    }

    public void onResume() {
        super.onResume();
        if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
            finish();
        }
    }

    public void doWork() {
        setContentView((int) R.layout.activity_nfc_action_list);
        ButterKnife.bind(this);
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.recommend_nfc_trigger);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.nfctag.ui.$$Lambda$NFCActionListActivity$29F9Zj1ec8am3_78nctjPjks_LM */

            public final void onClick(View view) {
                NFCActionListActivity.this.O00000Oo(view);
            }
        });
        findViewById(R.id.module_a_3_return_more_more_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.nfctag.ui.$$Lambda$NFCActionListActivity$eA6ofdHehyXkuPyq5guceuxfhg */

            public final void onClick(View view) {
                NFCActionListActivity.this.O000000o(view);
            }
        });
        this.mRecyclerList.setLayoutManager(new LinearLayoutManager(this));
        this.f10385O000000o = new O000000o();
        this.mRecyclerList.setAdapter(this.f10385O000000o);
        if (!hig.O00000oo()) {
            this.emptyView.setVisibility(0);
            findViewById(R.id.module_a_3_return_more_more_btn).setVisibility(8);
            this.emptyView.findViewById(R.id.common_white_empty_text_2).setVisibility(0);
            TextView textView = (TextView) this.emptyView.findViewById(R.id.common_white_empty_text_2);
            textView.setSingleLine(false);
            textView.setMaxLines(2);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setText((int) R.string.nfc_no_ablility);
            ((ImageView) this.emptyView.findViewById(R.id.empty_icon)).setImageResource(R.drawable.nfc_no_ability_icon);
        } else if (!fno.O000000o().O0000o00() || fno.O000000o().O0000o0()) {
            fno.O000000o().O0000o0O();
            fno.O000000o().O000000o(new fno.O000000o() {
                /* class com.xiaomi.smarthome.nfctag.ui.NFCActionListActivity.AnonymousClass2 */

                public final void onRefreshClientDeviceChanged(int i, Device device) {
                }

                public final void onRefreshClientDeviceSuccess(int i) {
                    fno.O000000o().O00000Oo(this);
                    NFCActionListActivity.this.getDeviceInfo();
                }
            });
        } else {
            getDeviceInfo();
        }
    }

    public void getDeviceInfo() {
        if (!hor.O000000o().isLiteSceneInited()) {
            hih.O000000o("smarthome-nfc", "scene is not inited");
            CoreApi.O000000o().O000000o(this, $$Lambda$NFCActionListActivity$3UlW6BKqesyIxwhDFlEgZKZug.INSTANCE);
        }
        Map<String, Set<String>> O000000o2 = fnn.O000000o().O00000Oo().O000000o(8);
        DeviceTagInterface.Category O0000Oo0 = fnn.O000000o().O00000Oo().O0000Oo0("46");
        DeviceTagInterface.Category O0000Oo02 = fnn.O000000o().O00000Oo().O0000Oo0("15");
        DeviceTagInterface.Category O0000Oo03 = fnn.O000000o().O00000Oo().O0000Oo0("162");
        final Set<String> hashSet = O0000Oo0 == null ? new HashSet<>() : O000000o2.get(O0000Oo0.name);
        final Set<String> hashSet2 = O0000Oo02 == null ? new HashSet<>() : O000000o2.get(O0000Oo02.name) == null ? new HashSet<>() : O000000o2.get(O0000Oo02.name);
        Collection hashSet3 = O0000Oo03 == null ? new HashSet() : O000000o2.get(O0000Oo03.name);
        if (hashSet3 != null) {
            hashSet2.addAll(hashSet3);
        }
        ArrayList arrayList = new ArrayList();
        if (hashSet != null) {
            for (String str : hashSet) {
                if (!TextUtils.isEmpty(str) && fno.O000000o().O000000o(str) != null) {
                    arrayList.add(str);
                }
            }
        }
        if (hashSet2 != null) {
            for (String str2 : hashSet2) {
                if (!TextUtils.isEmpty(str2) && fno.O000000o().O000000o(str2) != null) {
                    arrayList.add(str2);
                }
            }
        }
        if (hig.O00000oO()) {
            hii.O000000o(this, arrayList, new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.nfctag.ui.NFCActionListActivity.AnonymousClass3 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    hih.O000000o("smarthome-nfc", jSONObject.toString());
                    Iterator<String> keys = jSONObject.keys();
                    JSONObject jSONObject2 = new JSONObject();
                    JSONObject jSONObject3 = new JSONObject();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        Set set = hashSet;
                        if (set != null && set.contains(next)) {
                            try {
                                jSONObject2.put(next, jSONObject.optString(next));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        Set set2 = hashSet2;
                        if (set2 != null && set2.contains(next)) {
                            try {
                                jSONObject3.put(next, jSONObject.optString(next));
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    if (jSONObject2.keys().hasNext()) {
                        NFCActionListActivity.this.supportSpeakerInfo = jSONObject2.toString();
                    }
                    if (jSONObject3.keys().hasNext()) {
                        NFCActionListActivity.this.supportTVInfo = jSONObject3.toString();
                    }
                    NFCActionListActivity.this.makeNFCActionDatas();
                }

                public final void onFailure(fso fso) {
                    hih.O000000o("smarthome-nfc", fso.toString());
                    NFCActionListActivity.this.makeNFCActionDatas();
                }
            });
            this.nfcHint.setVisibility(0);
            bbsLinkSetting(this.nfcHint, getString(R.string.nfc_has_miconnect));
            return;
        }
        this.O00000Oo.clear();
        if (!hig.O0000OOo()) {
            this.O00000Oo.add(new O00000Oo(1, -1, getString(R.string.nfc_trigger_title2), null, -1, null));
            this.O00000Oo.add(new O00000Oo(2, 5, getString(R.string.nfc_trigger_wifi_action), getString(R.string.nfc_trigger_wifi_action_sub), R.drawable.nfc_action_wifi, new O00000o0() {
                /* class com.xiaomi.smarthome.nfctag.ui.$$Lambda$NFCActionListActivity$PcOPCcnwhIveYLLd6iQm5a0EC2s */

                public final void onClick(Intent intent) {
                    NFCActionListActivity.this.O0000OOo(intent);
                }
            }));
            if (this.O00000Oo.size() > 1) {
                List<O00000Oo> list = this.O00000Oo;
                if (list.get(list.size() - 1).O00000Oo == 2) {
                    List<O00000Oo> list2 = this.O00000Oo;
                    list2.get(list2.size() - 1);
                }
            }
        }
        this.O00000Oo.add(new O00000Oo(1, -1, getString(R.string.nfc_trigger_title3), null, -1, null, (byte) 0));
        this.O00000Oo.add(new O00000Oo(2, 6, getString(R.string.nfc_trigger_click_action), getString(R.string.nfc_trigger_click_action_sub), R.drawable.nfc_action_scene, new O00000o0() {
            /* class com.xiaomi.smarthome.nfctag.ui.$$Lambda$NFCActionListActivity$ZU9sBuwbHCUX5oQu6ma_2vgAW3A */

            public final void onClick(Intent intent) {
                NFCActionListActivity.this.O0000O0o(intent);
            }
        }, (byte) 0));
        if (hig.O0000Oo0()) {
            this.O00000Oo.add(new O00000Oo(2, 7, getString(R.string.nfc_trigger_open_device_action), getString(R.string.nfc_trigger_open_device_action_sub), R.drawable.nfc_action_open_device, new O00000o0() {
                /* class com.xiaomi.smarthome.nfctag.ui.$$Lambda$NFCActionListActivity$q7YPtYRuvDk61Ties1HdJ4vVug */

                public final void onClick(Intent intent) {
                    NFCActionListActivity.this.O00000oo(intent);
                }
            }, (byte) 0));
        }
        this.O00000Oo.add(new O00000Oo());
        this.f10385O000000o.notifyDataSetChanged();
        this.nfcHint.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o() {
        hih.O000000o("smarthome-nfc", "core is ready");
        hor.O000000o().updateLiteScene();
    }

    public void onBackPressed() {
        hor.O000000o().setCurrentStepInCreateSceneManager(3);
        hor.O000000o().clearCreateSceneManager();
        hor.O000000o().setSceneInCreateSceneManager(null);
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        hor.O000000o().setCurrentStepInCreateSceneManager(3);
        hor.O000000o().clearCreateSceneManager();
        hor.O000000o().setSceneInCreateSceneManager(null);
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        hxi.O00000o.f952O000000o.O000000o("NFC_have_scene", new Object[0]);
        fbs.O000000o(new fbt(this, "com.xiaomi.smarthome.scene.activity.NFCSceneListActivity"));
    }

    class O000000o extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
        private LayoutInflater O00000Oo;

        public final long getItemId(int i) {
            return (long) i;
        }

        public O000000o() {
            this.O00000Oo = NFCActionListActivity.this.getLayoutInflater();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 2) {
                return new ChildViewHolder1(this.O00000Oo.inflate((int) R.layout.item_nfc_action_child, viewGroup, false));
            }
            if (i == 0) {
                return new GroupViewHolder0(this.O00000Oo.inflate((int) R.layout.item_nfc_action_group0, viewGroup, false));
            }
            if (i == 1) {
                return new GroupViewHolder0(this.O00000Oo.inflate((int) R.layout.item_nfc_action_group1, viewGroup, false));
            }
            if (i == 4) {
                return new HintViewHolder(this.O00000Oo.inflate((int) R.layout.item_nfc_action_hint, viewGroup, false));
            }
            return null;
        }

        public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            if (o000OOo0 instanceof ChildViewHolder1) {
                ChildViewHolder1 childViewHolder1 = (ChildViewHolder1) o000OOo0;
                if (!TextUtils.isEmpty(NFCActionListActivity.this.O00000Oo.get(i).O00000o0)) {
                    childViewHolder1.txtTitle.setText(NFCActionListActivity.this.O00000Oo.get(i).O00000o0);
                }
                if (!TextUtils.isEmpty(NFCActionListActivity.this.O00000Oo.get(i).O00000o)) {
                    childViewHolder1.txtSubTitle.setText(NFCActionListActivity.this.O00000Oo.get(i).O00000o);
                }
                if (NFCActionListActivity.this.O00000Oo.get(i).O00000oO <= 0) {
                    childViewHolder1.imgIcon.setVisibility(8);
                } else {
                    childViewHolder1.imgIcon.setVisibility(0);
                    childViewHolder1.imgIcon.setImageResource(NFCActionListActivity.this.O00000Oo.get(i).O00000oO);
                }
                childViewHolder1.txtTitle.setAlpha(NFCActionListActivity.this.O00000Oo.get(i).O0000OOo);
                childViewHolder1.txtSubTitle.setAlpha(NFCActionListActivity.this.O00000Oo.get(i).O0000OOo);
                childViewHolder1.imgIcon.setAlpha(NFCActionListActivity.this.O00000Oo.get(i).O0000OOo);
                childViewHolder1.itemView.setOnClickListener(new View.OnClickListener(i) {
                    /* class com.xiaomi.smarthome.nfctag.ui.$$Lambda$NFCActionListActivity$O000000o$CBTx_EDzFm0UAFvqMLMald7u0Co */
                    private final /* synthetic */ int f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        NFCActionListActivity.O000000o.this.O000000o(this.f$1, view);
                    }
                });
            } else if (o000OOo0 instanceof GroupViewHolder0) {
                GroupViewHolder0 groupViewHolder0 = (GroupViewHolder0) o000OOo0;
                if (!TextUtils.isEmpty(NFCActionListActivity.this.O00000Oo.get(i).O00000o0)) {
                    groupViewHolder0.txtTitle.setText(NFCActionListActivity.this.O00000Oo.get(i).O00000o0);
                }
            } else if (o000OOo0 instanceof HintViewHolder) {
                NFCActionListActivity.this.bbsLinkSetting(((HintViewHolder) o000OOo0).hint, NFCActionListActivity.this.getString(R.string.nfc_no_miconnect));
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
         arg types: [com.xiaomi.smarthome.nfctag.ui.NFCActionListActivity, java.lang.String, java.lang.String, int]
         candidates:
          _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
          _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean */
        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(int i, View view) {
            if (!hig.O000000o()) {
                new MLAlertDialog.Builder(NFCActionListActivity.this).O00000Oo(NFCActionListActivity.this.getResources().getString(R.string.nfc_not_open)).O00000Oo((int) R.string.sh_common_lib_cancel, (DialogInterface.OnClickListener) null).O000000o((int) R.string.set_now, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.nfctag.ui.NFCActionListActivity.O000000o.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        NFCActionListActivity.this.startActivity(new Intent("android.settings.NFC_SETTINGS"));
                        dialogInterface.dismiss();
                    }
                }).O00000o().show();
            } else if (hig.O00000o0() && !hig.O00000Oo()) {
                new MLAlertDialog.Builder(NFCActionListActivity.this).O00000Oo(NFCActionListActivity.this.getResources().getString(R.string.nfc_not_permit)).O00000Oo((int) R.string.sh_common_lib_cancel, (DialogInterface.OnClickListener) null).O000000o((int) R.string.set_now, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.nfctag.ui.NFCActionListActivity.O000000o.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent();
                        intent.addFlags(268435456);
                        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.setData(Uri.fromParts("package", NFCActionListActivity.this.getPackageName(), null));
                        NFCActionListActivity.this.startActivity(intent);
                        dialogInterface.dismiss();
                    }
                }).O00000o().show();
            } else if (!gpy.O00000o0((Context) NFCActionListActivity.this, "nfc_setting", "is_show_nfc_phone_alert", false)) {
                NFCActionListActivity.this.showTip(i);
            } else {
                NFCActionListActivity.this.goWriteNFC(i);
            }
        }

        public final int getItemCount() {
            if (NFCActionListActivity.this.O00000Oo == null) {
                return 0;
            }
            return NFCActionListActivity.this.O00000Oo.size();
        }

        public final int getItemViewType(int i) {
            return NFCActionListActivity.this.O00000Oo.get(i).O00000Oo;
        }
    }

    public void bbsLinkSetting(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str)) {
            String replace = str.replace("#start#", "").replace("#end#", "");
            AnonymousClass4 r0 = new ClickableSpan() {
                /* class com.xiaomi.smarthome.nfctag.ui.NFCActionListActivity.AnonymousClass4 */

                public final void onClick(View view) {
                    fbt fbt = new fbt(NFCActionListActivity.this, "OperationCommonWebViewActivity");
                    fbt.O000000o("url", "https://home.mi.com/views/article.html?articleId=124609622000000001");
                    fbs.O000000o(fbt);
                }

                public final void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setUnderlineText(true);
                    textPaint.setColor(NFCActionListActivity.this.getResources().getColor(R.color.mj_color_green_normal));
                }
            };
            SpannableString spannableString = new SpannableString(replace);
            spannableString.setSpan(r0, str.indexOf("#start#"), str.indexOf("#end#") - 7, 33);
            textView.setText(spannableString);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public void goWriteNFC(int i) {
        int i2 = this.O00000Oo.get(i).f10401O000000o;
        String str = i2 != 1 ? i2 != 2 ? i2 != 5 ? i2 != 6 ? i2 != 7 ? null : "plugin" : "mihome" : "router" : "tv" : "aispeaker";
        if (!TextUtils.isEmpty(str)) {
            hxi.O00000o.f952O000000o.O000000o("NFC_scene_click", "value", str);
        }
        this.O00000Oo.get(i).O000000o();
    }

    public boolean checkScanWifiLocationPermission(final Activity activity, boolean z, int i) {
        if (!fuy.O00000o()) {
            if (z) {
                new MLAlertDialog.Builder(activity).O00000Oo(activity.getResources().getString(i)).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O000000o((int) R.string.set_now, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.nfctag.ui.NFCActionListActivity.AnonymousClass5 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        activity.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                    }
                }).O00000o().show();
            }
            return false;
        } else if (fuy.O00000oO()) {
            return true;
        } else {
            if (z) {
                View inflate = LayoutInflater.from(activity).inflate((int) R.layout.permisson_request_dialog_view, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.subtitle1)).setText((int) R.string.nfc_permission_location_rational_desc);
                new MLAlertDialog.Builder(activity).O000000o(inflate).O000000o(false).O000000o((int) R.string.next, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.nfctag.ui.NFCActionListActivity.AnonymousClass6 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (grr.O00000oO() || !Build.MANUFACTURER.toLowerCase().contains("xiaomi")) {
                            ind.O000000o(activity).O000000o(20);
                            return;
                        }
                        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.addFlags(268435456);
                        intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
                        activity.startActivityForResult(intent, 20);
                    }
                }).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O00000oo();
            }
            return false;
        }
    }

    public class ChildViewHolder1 extends RecyclerView.O000OOo0 {
        @BindView(5318)
        public ImageView imgIcon;
        @BindView(6032)
        public TextView txtSubTitle;
        @BindView(6034)
        public TextView txtTitle;

        public ChildViewHolder1(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public class HintViewHolder extends RecyclerView.O000OOo0 {
        @BindView(5542)
        public TextView hint;

        public HintViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public class GroupViewHolder0 extends RecyclerView.O000OOo0 {
        @BindView(6034)
        public TextView txtTitle;

        public GroupViewHolder0(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        int f10401O000000o;
        int O00000Oo;
        String O00000o;
        String O00000o0;
        int O00000oO;
        boolean O00000oo;
        O00000o0 O0000O0o;
        float O0000OOo;

        public O00000Oo() {
            this.O00000oo = true;
            this.O00000Oo = 4;
        }

        public O00000Oo(int i, int i2, String str, String str2, int i3, O00000o0 o00000o0) {
            this.O00000oo = true;
            this.O00000Oo = i;
            this.f10401O000000o = i2;
            this.O00000o0 = str;
            this.O00000o = str2;
            this.O00000oO = i3;
            this.O0000O0o = o00000o0;
            this.O0000OOo = 1.0f;
        }

        public O00000Oo(int i, int i2, String str, String str2, int i3, O00000o0 o00000o0, byte b) {
            this.O00000oo = true;
            this.O00000Oo = i;
            this.f10401O000000o = i2;
            this.O00000o0 = str;
            this.O00000o = str2;
            this.O00000oO = i3;
            this.O0000O0o = o00000o0;
            this.O00000oo = false;
            this.O0000OOo = 1.0f;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.fwq.O000000o(android.app.Activity, boolean, _m_j.inc, java.lang.String):boolean
         arg types: [com.xiaomi.smarthome.nfctag.ui.NFCActionListActivity, int, ?[OBJECT, ARRAY], java.lang.String]
         candidates:
          _m_j.fwq.O000000o(android.app.Activity, java.lang.String, java.lang.String, java.util.List<java.lang.String>):void
          _m_j.fwq.O000000o(android.app.Activity, boolean, _m_j.inc, java.lang.String):boolean */
        public final void O000000o() {
            boolean z;
            if (this.O0000O0o != null) {
                Intent intent = new Intent();
                intent.putExtra("write_type", this.f10401O000000o);
                int i = this.f10401O000000o;
                if (i == 1) {
                    intent.putExtra("params", NFCActionListActivity.this.supportSpeakerInfo);
                } else if (i == 2 || i == 3 || i == 4) {
                    intent.putExtra("params", NFCActionListActivity.this.supportTVInfo);
                } else if (i == 5) {
                    try {
                        z = ((WifiManager) NFCActionListActivity.this.getApplicationContext().getSystemService("wifi")).isWifiEnabled();
                    } catch (Exception unused) {
                        z = false;
                    }
                    if (!z) {
                        new MLAlertDialog.Builder(NFCActionListActivity.this).O00000Oo(NFCActionListActivity.this.getResources().getString(R.string.nfc_wlan_not_open)).O00000Oo((int) R.string.sh_common_cancel, $$Lambda$NFCActionListActivity$O00000Oo$wSNyTJoGztMpTbERF9CQLNgqTgc.INSTANCE).O000000o((int) R.string.set_now, new DialogInterface.OnClickListener() {
                            /* class com.xiaomi.smarthome.nfctag.ui.$$Lambda$NFCActionListActivity$O00000Oo$OP2KaazP1J0tgnIXBBKG9HeNxAI */

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                NFCActionListActivity.O00000Oo.this.O000000o(dialogInterface, i);
                            }
                        }).O00000oo();
                        return;
                    }
                    NFCActionListActivity nFCActionListActivity = NFCActionListActivity.this;
                    if (!nFCActionListActivity.checkScanWifiLocationPermission(nFCActionListActivity, false, R.string.nfc_location_disable_hint)) {
                        if (NFCActionListActivity.this.mTmpDialog != null && NFCActionListActivity.this.mTmpDialog.isShowing()) {
                            NFCActionListActivity.this.mTmpDialog.dismiss();
                        }
                        if (goy.O000000o()) {
                            NFCActionListActivity nFCActionListActivity2 = NFCActionListActivity.this;
                            fwq.O000000o((Activity) nFCActionListActivity2, true, (inc) null, nFCActionListActivity2.getString(R.string.nfc_permission_location_rational_desc));
                            return;
                        }
                        NFCActionListActivity nFCActionListActivity3 = NFCActionListActivity.this;
                        nFCActionListActivity3.checkScanWifiLocationPermission(nFCActionListActivity3, true, R.string.nfc_permission_location_rational_desc);
                        return;
                    }
                }
                this.O0000O0o.onClick(intent);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction("android.net.wifi.PICK_WIFI_NETWORK");
            NFCActionListActivity.this.startActivity(intent);
            dialogInterface.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O0000OOo(Intent intent) {
        intent.setClassName(getApplicationContext(), NFCWifiListActivity.class.getName());
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O0000O0o(Intent intent) {
        hor.O000000o().startNFCActionChoose(this, intent);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000oo(Intent intent) {
        intent.setClassName(getApplicationContext(), NFCOpenDeviceListActivity.class.getName());
        startActivity(intent);
    }

    public void makeNFCActionDatas() {
        boolean z;
        boolean z2;
        this.O00000Oo.clear();
        if (!TextUtils.isEmpty(this.supportSpeakerInfo)) {
            this.O00000Oo.add(new O00000Oo(1, -1, getString(R.string.nfc_trigger_title0), getString(R.string.nfc_trigger_click_action_sub), -1, null));
            this.O00000Oo.add(new O00000Oo(2, 1, getString(R.string.nfc_trigger_speaker_action), getString(R.string.nfc_trigger_speaker_action_sub), R.drawable.nfc_action_speaker, new O00000o0() {
                /* class com.xiaomi.smarthome.nfctag.ui.$$Lambda$NFCActionListActivity$eCSh_ET_kbKfgpK_RJIpNCzgrco */

                public final void onClick(Intent intent) {
                    NFCActionListActivity.this.O00000oO(intent);
                }
            }));
            z = false;
        } else {
            z = true;
        }
        if (!TextUtils.isEmpty(this.supportTVInfo)) {
            List<O00000Oo> list = this.O00000Oo;
            O00000Oo o00000Oo = r0;
            O00000Oo o00000Oo2 = new O00000Oo(1, -1, getString(R.string.nfc_trigger_title1), null, -1, null);
            list.add(o00000Oo);
            this.O00000Oo.add(new O00000Oo(2, 2, getString(R.string.nfc_trigger_tv_action0), getString(R.string.nfc_trigger_tv_action_sub0), R.drawable.nfc_action_tv0, new O00000o0() {
                /* class com.xiaomi.smarthome.nfctag.ui.$$Lambda$NFCActionListActivity$tyEmKYSOTZzXxMfcOr2sh8w6sA */

                public final void onClick(Intent intent) {
                    NFCActionListActivity.this.O00000o(intent);
                }
            }));
            z2 = z;
        } else {
            z2 = true;
        }
        this.O00000Oo.add(new O00000Oo(1, -1, getString(R.string.nfc_trigger_title2), null, -1, null));
        this.O00000Oo.add(new O00000Oo(2, 5, getString(R.string.nfc_trigger_wifi_action), getString(R.string.nfc_trigger_wifi_action_sub), R.drawable.nfc_action_wifi, new O00000o0() {
            /* class com.xiaomi.smarthome.nfctag.ui.$$Lambda$NFCActionListActivity$PCnwztQqB4dciJP2ltdGvIxQ0RE */

            public final void onClick(Intent intent) {
                NFCActionListActivity.this.O00000o0(intent);
            }
        }));
        if (this.O00000Oo.size() > 1) {
            List<O00000Oo> list2 = this.O00000Oo;
            if (list2.get(list2.size() - 1).O00000Oo == 2) {
                List<O00000Oo> list3 = this.O00000Oo;
                list3.get(list3.size() - 1);
            }
        }
        List<O00000Oo> list4 = this.O00000Oo;
        O00000Oo o00000Oo3 = r0;
        O00000Oo o00000Oo4 = new O00000Oo(1, -1, getString(R.string.nfc_trigger_title3), null, -1, null, (byte) 0);
        list4.add(o00000Oo3);
        this.O00000Oo.add(new O00000Oo(2, 6, getString(R.string.nfc_trigger_click_action), getString(R.string.nfc_trigger_click_action_sub), R.drawable.nfc_action_scene, new O00000o0() {
            /* class com.xiaomi.smarthome.nfctag.ui.$$Lambda$NFCActionListActivity$OLcmmlqNERxjciDy6GiHGdcm4oM */

            public final void onClick(Intent intent) {
                NFCActionListActivity.this.O00000Oo(intent);
            }
        }, (byte) 0));
        if (hig.O0000Oo0()) {
            this.O00000Oo.add(new O00000Oo(2, 7, getString(R.string.nfc_trigger_open_device_action), getString(R.string.nfc_trigger_open_device_action_sub), R.drawable.nfc_action_open_device, new O00000o0() {
                /* class com.xiaomi.smarthome.nfctag.ui.$$Lambda$NFCActionListActivity$ybzxkHJ8P1mQU5MwfVjjYoIQYe0 */

                public final void onClick(Intent intent) {
                    NFCActionListActivity.this.O000000o(intent);
                }
            }, (byte) 0));
        }
        if (z2) {
            this.O00000Oo.add(new O00000Oo(0, -1, getString(R.string.nfc_action_not_support), null, -1, null, (byte) 0));
        }
        if (TextUtils.isEmpty(this.supportSpeakerInfo)) {
            if (this.O00000Oo.size() > 1) {
                List<O00000Oo> list5 = this.O00000Oo;
                if (list5.get(list5.size() - 1).O00000Oo == 2) {
                    List<O00000Oo> list6 = this.O00000Oo;
                    list6.get(list6.size() - 1);
                }
            }
            this.O00000Oo.add(new O00000Oo(1, -1, getString(R.string.nfc_trigger_title0), getString(R.string.nfc_trigger_click_action_sub), -1, null));
            List<O00000Oo> list7 = this.O00000Oo;
            list7.get(list7.size() - 1).O0000OOo = 0.3f;
            this.O00000Oo.add(new O00000Oo(2, -1, getString(R.string.nfc_trigger_speaker_action), getString(R.string.nfc_trigger_speaker_action_sub), R.drawable.nfc_action_speaker, null));
            List<O00000Oo> list8 = this.O00000Oo;
            list8.get(list8.size() - 1).O0000OOo = 0.3f;
        }
        if (TextUtils.isEmpty(this.supportTVInfo)) {
            if (this.O00000Oo.size() > 1) {
                List<O00000Oo> list9 = this.O00000Oo;
                if (list9.get(list9.size() - 1).O00000Oo == 2) {
                    List<O00000Oo> list10 = this.O00000Oo;
                    list10.get(list10.size() - 1);
                }
            }
            this.O00000Oo.add(new O00000Oo(1, -1, getString(R.string.nfc_trigger_title1), null, -1, null));
            List<O00000Oo> list11 = this.O00000Oo;
            list11.get(list11.size() - 1).O0000OOo = 0.3f;
            this.O00000Oo.add(new O00000Oo(2, -1, getString(R.string.nfc_trigger_tv_action0), getString(R.string.nfc_trigger_tv_action_sub0), R.drawable.nfc_action_tv0, null));
            List<O00000Oo> list12 = this.O00000Oo;
            list12.get(list12.size() - 1).O0000OOo = 0.3f;
        }
        this.f10385O000000o.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000oO(Intent intent) {
        intent.setClassName(getApplicationContext(), NFCDeviceListActivity.class.getName());
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o(Intent intent) {
        intent.setClassName(getApplicationContext(), NFCDeviceListActivity.class.getName());
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(Intent intent) {
        intent.setClassName(getApplicationContext(), NFCWifiListActivity.class.getName());
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(Intent intent) {
        hor.O000000o().startNFCActionChoose(this, intent);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(Intent intent) {
        intent.setClassName(getApplicationContext(), NFCOpenDeviceListActivity.class.getName());
        startActivity(intent);
    }

    public void showTip(int i) {
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
        View inflate = LayoutInflater.from(this).inflate((int) R.layout.nfc_alert_dialog, (ViewGroup) null);
        inflate.findViewById(R.id.positive_btn).setOnClickListener(new View.OnClickListener(i) {
            /* class com.xiaomi.smarthome.nfctag.ui.$$Lambda$NFCActionListActivity$f_ElOr6jl8n_S3mgWdZ6rLmHuVQ */
            private final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                NFCActionListActivity.this.O000000o(this.f$1, view);
            }
        });
        builder.O000000o(inflate);
        this.O00000o0 = builder.O00000oo();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void
     arg types: [com.xiaomi.smarthome.nfctag.ui.NFCActionListActivity, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, float):float
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, int):int
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, long):void
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void */
    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(int i, View view) {
        MLAlertDialog mLAlertDialog = this.O00000o0;
        if (mLAlertDialog != null) {
            mLAlertDialog.dismiss();
            this.O00000o0 = null;
        }
        gpy.O000000o((Context) this, "nfc_setting", "is_show_nfc_phone_alert", true);
        goWriteNFC(i);
    }
}
