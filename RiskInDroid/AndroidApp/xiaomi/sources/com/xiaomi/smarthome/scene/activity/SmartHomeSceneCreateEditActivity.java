package com.xiaomi.smarthome.scene.activity;

import _m_j.eyk;
import _m_j.eys;
import _m_j.fcb;
import _m_j.fju;
import _m_j.flk;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gof;
import _m_j.gpc;
import _m_j.gpv;
import _m_j.gqb;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.hjp;
import _m_j.hnm;
import _m_j.hnu;
import _m_j.hnw;
import _m_j.hob;
import _m_j.hod;
import _m_j.hox;
import _m_j.hpq;
import _m_j.hpr;
import _m_j.hsl;
import _m_j.izb;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.statistic.StatType;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.api.DeviceApi;
import com.xiaomi.smarthome.device.api.RecommendSceneItem;
import com.xiaomi.smarthome.device.api.SceneInfo;
import com.xiaomi.smarthome.device.utils.ClientRemarkInputView;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.SendMessageCallback;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.framework.plugin.mpk.MpkPluginApi;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.scene.api.SceneApi;
import com.xiaomi.smarthome.scene.bean.DefaultSceneItemSet;
import com.xiaomi.smarthome.scene.bean.LAUNCH_TYPE;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class SmartHomeSceneCreateEditActivity extends BaseActivity {
    public static boolean isNewScene;
    public static SceneApi.O000OOOo mScene;

    /* renamed from: O000000o  reason: collision with root package name */
    Context f10900O000000o;
    String O00000Oo;
    boolean[] O00000o;
    SceneApi.O000OOOo O00000o0;
    int[] O00000oO;
    boolean[] O00000oo;
    BaseAdapter O0000O0o;
    BaseAdapter O0000OOo;
    fno.O000000o O0000Oo = new fno.O000000o() {
        /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.AnonymousClass12 */

        public final void onRefreshClientDeviceChanged(int i, Device device) {
        }

        public final void onRefreshClientDeviceSuccess(int i) {
            if (i == 3) {
                SmartHomeSceneCreateEditActivity.this.O00000o0();
                if (SmartHomeSceneCreateEditActivity.this.O0000O0o != null) {
                    SmartHomeSceneCreateEditActivity.this.O0000O0o.notifyDataSetChanged();
                    SmartHomeSceneCreateEditActivity.this.O0000OOo.notifyDataSetChanged();
                }
            }
        }
    };
    Handler O0000Oo0 = new Handler() {
        /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.AnonymousClass1 */

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 100) {
                SmartHomeSceneCreateEditActivity.this.startSaveScene(null);
            } else if (i == 101) {
                SmartHomeSceneCreateEditActivity.this.O000000o(false);
            }
        }
    };
    MLAlertDialog O0000OoO = null;
    private boolean O0000Ooo = false;
    private List<O000000o> O0000o;
    private String O0000o0;
    private boolean O0000o00 = false;
    private TextView O0000o0O;
    private int O0000o0o = -1;
    private boolean O0000oO = false;
    private SceneApi.O00000Oo O0000oO0 = null;
    @BindView(5925)
    SwitchButton mCheckBox;
    @BindView(5275)
    ListView mConditionListView;
    @BindView(5277)
    TextView mConditionTitle;
    @BindView(5837)
    Button mConfirmBtn;
    @BindView(6242)
    LinearLayout mContainer;
    public ArrayList<DefaultSceneItemSet> mDefaultActionSceneItems = new ArrayList<>();
    public ArrayList<DefaultSceneItemSet> mDefaultConditionSceneItems = new ArrayList<>();
    public boolean mDisableScene = false;
    @BindView(5380)
    View mDivider1;
    @BindView(5381)
    View mDivider2;
    @BindView(5382)
    View mDivider3;
    @BindView(5383)
    View mDivider4;
    @BindView(6145)
    RelativeLayout mExeTimeRL;
    @BindView(6146)
    TextView mExeTimeTV;
    @BindView(5461)
    TextView mExpressAll;
    @BindView(5462)
    TextView mExpressAny;
    @BindView(6243)
    View mExpressView;
    @BindView(5096)
    View mLockView;
    @BindView(5836)
    TextView mModuleA4Commit;
    @BindView(5838)
    ImageView mModuleA4ReturnBtn;
    @BindView(5842)
    TextView mModuleA4ReturnTitle;
    @BindView(5897)
    TextView mNoActionTitle;
    @BindView(5898)
    TextView mNoConditionTitle;
    public ArrayList<DefaultSceneItemSet> mNoDeviceActionItems = new ArrayList<>();
    public ArrayList<DefaultSceneItemSet> mNoDeviceConditionItems = new ArrayList<>();
    public XQProgressDialog mPD;
    @BindView(6162)
    ScrollView mScrollVIew;
    public DefaultSceneItemSet mSelectedActionItems = null;
    public DefaultSceneItemSet mSelectedConditionItems = null;
    @BindView(5927)
    View mSwitchContainer;
    @BindView(6322)
    View mTaskLayout;
    @BindView(6323)
    ListView mTaskListView;
    @BindView(6370)
    View mTitleBar;
    @BindView(6579)
    View mViewTag;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f10955O000000o = -1;
        public SceneApi.Action O00000Oo;
    }

    public class ActionsAdapter_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private ActionsAdapter f10937O000000o;

        public ActionsAdapter_ViewBinding(ActionsAdapter actionsAdapter, View view) {
            this.f10937O000000o = actionsAdapter;
            actionsAdapter.mImage = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.image, "field 'mImage'", SimpleDraweeView.class);
            actionsAdapter.mTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'mTitle'", TextView.class);
            actionsAdapter.mSubTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.sub_title, "field 'mSubTitle'", TextView.class);
            actionsAdapter.mOffline = (TextView) Utils.findRequiredViewAsType(view, R.id.offline, "field 'mOffline'", TextView.class);
            actionsAdapter.mAnchor = (ImageView) Utils.findRequiredViewAsType(view, R.id.anchor, "field 'mAnchor'", ImageView.class);
            actionsAdapter.mBuyButton = (TextView) Utils.findRequiredViewAsType(view, R.id.buy_button, "field 'mBuyButton'", TextView.class);
            actionsAdapter.mBottomline = Utils.findRequiredView(view, R.id.bottom_line, "field 'mBottomline'");
            actionsAdapter.mTaskLayout = Utils.findRequiredView(view, R.id.task_layout, "field 'mTaskLayout'");
            actionsAdapter.mDelayLayout = Utils.findRequiredView(view, R.id.delay_timer_layout, "field 'mDelayLayout'");
            actionsAdapter.mDelayTimeText = (TextView) Utils.findRequiredViewAsType(view, R.id.delay_time_text, "field 'mDelayTimeText'", TextView.class);
            actionsAdapter.mDelayTimeLine = Utils.findRequiredView(view, R.id.delay_time_line, "field 'mDelayTimeLine'");
            actionsAdapter.mDelayTopLine = Utils.findRequiredView(view, R.id.delay_top_line, "field 'mDelayTopLine'");
            actionsAdapter.mDelayBottomLine = Utils.findRequiredView(view, R.id.delay_bottom_line, "field 'mDelayBottomLine'");
            actionsAdapter.mIconBottomLine = Utils.findRequiredView(view, R.id.icon_bottom_line, "field 'mIconBottomLine'");
            actionsAdapter.mIconTopLine = Utils.findRequiredView(view, R.id.icon_top_line, "field 'mIconTopLine'");
        }

        public void unbind() {
            ActionsAdapter actionsAdapter = this.f10937O000000o;
            if (actionsAdapter != null) {
                this.f10937O000000o = null;
                actionsAdapter.mImage = null;
                actionsAdapter.mTitle = null;
                actionsAdapter.mSubTitle = null;
                actionsAdapter.mOffline = null;
                actionsAdapter.mAnchor = null;
                actionsAdapter.mBuyButton = null;
                actionsAdapter.mBottomline = null;
                actionsAdapter.mTaskLayout = null;
                actionsAdapter.mDelayLayout = null;
                actionsAdapter.mDelayTimeText = null;
                actionsAdapter.mDelayTimeLine = null;
                actionsAdapter.mDelayTopLine = null;
                actionsAdapter.mDelayBottomLine = null;
                actionsAdapter.mIconBottomLine = null;
                actionsAdapter.mIconTopLine = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public class ConditionsAdapter_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private ConditionsAdapter f10954O000000o;

        public ConditionsAdapter_ViewBinding(ConditionsAdapter conditionsAdapter, View view) {
            this.f10954O000000o = conditionsAdapter;
            conditionsAdapter.mIcon = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.icon, "field 'mIcon'", SimpleDraweeView.class);
            conditionsAdapter.mName = (TextView) Utils.findRequiredViewAsType(view, R.id.name, "field 'mName'", TextView.class);
            conditionsAdapter.mKeyName = (TextView) Utils.findRequiredViewAsType(view, R.id.key_name, "field 'mKeyName'", TextView.class);
            conditionsAdapter.mTimeSpan = (TextView) Utils.findRequiredViewAsType(view, R.id.add_timesp, "field 'mTimeSpan'", TextView.class);
            conditionsAdapter.mTimeSetButton = (ImageView) Utils.findRequiredViewAsType(view, R.id.set_time_btn, "field 'mTimeSetButton'", ImageView.class);
            conditionsAdapter.mOffline = (TextView) Utils.findRequiredViewAsType(view, R.id.offline, "field 'mOffline'", TextView.class);
            conditionsAdapter.mBuyButton = (TextView) Utils.findRequiredViewAsType(view, R.id.buy_button, "field 'mBuyButton'", TextView.class);
            conditionsAdapter.mExpandHint = (ImageView) Utils.findRequiredViewAsType(view, R.id.expand_hint, "field 'mExpandHint'", ImageView.class);
            conditionsAdapter.mRunTV = (TextView) Utils.findRequiredViewAsType(view, R.id.right_view_btn, "field 'mRunTV'", TextView.class);
        }

        public void unbind() {
            ConditionsAdapter conditionsAdapter = this.f10954O000000o;
            if (conditionsAdapter != null) {
                this.f10954O000000o = null;
                conditionsAdapter.mIcon = null;
                conditionsAdapter.mName = null;
                conditionsAdapter.mKeyName = null;
                conditionsAdapter.mTimeSpan = null;
                conditionsAdapter.mTimeSetButton = null;
                conditionsAdapter.mOffline = null;
                conditionsAdapter.mBuyButton = null;
                conditionsAdapter.mExpandHint = null;
                conditionsAdapter.mRunTV = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.smarthome_scene_create_edit);
        ButterKnife.bind(this);
        this.f10900O000000o = this;
        gqg.O00000Oo((int) R.string.scene_edit_no_support);
        finish();
    }

    public int countConditionTime() {
        SceneApi.O000OOOo o000OOOo = mScene;
        int i = 0;
        if (o000OOOo == null) {
            return 0;
        }
        for (SceneApi.O000000o next : o000OOOo.O0000O0o) {
            if (!(next.O00000o0 == null || next.O00000o0.O00000oO == -1)) {
                i++;
                this.O0000oO0 = next.O00000o0;
            }
        }
        return i;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, boolean):void
     arg types: [com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, ?[OBJECT, ARRAY], int]
     candidates:
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, boolean, long, long):int
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, com.xiaomi.smarthome.core.entity.net.Crypto, _m_j.fsm):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String, _m_j.fsm<org.json.JSONObject, _m_j.fso>, boolean):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions, _m_j.gle):com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String[], boolean, com.xiaomi.smarthome.core.client.IClientCallback):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, boolean):void */
    public void getFrom(Intent intent) {
        if (intent.getExtras() != null && !TextUtils.isEmpty(intent.getExtras().getString("scene_stat_from", "")) && this.O0000o0o != -1) {
            CoreApi O000000o2 = CoreApi.O000000o();
            StatType statType = StatType.EVENT;
            StringBuilder sb = new StringBuilder();
            sb.append(this.O0000o0o);
            O000000o2.O000000o(statType, "value", sb.toString(), (String) null, false);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        fno.O000000o().O00000Oo(this.O0000Oo);
        Handler handler = this.O0000Oo0;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    private void O00000oO() {
        SceneApi.O000OOOo o000OOOo;
        SceneApi.O000OOOo o000OOOo2 = this.O00000o0;
        boolean z = o000OOOo2 == null || (o000OOOo = mScene) == null || !o000OOOo.O000000o(o000OOOo2);
        ArrayList<DefaultSceneItemSet> arrayList = this.mDefaultActionSceneItems;
        if (!(arrayList == null && arrayList == null) && mScene.O0000OOo) {
            z = false;
        }
        if (z) {
            new MLAlertDialog.Builder(this.f10900O000000o).O00000Oo((int) R.string.smarthome_scene_quit).O000000o((int) R.string.smarthome_scene_quest_ok, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.AnonymousClass25 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    SmartHomeSceneCreateEditActivity.this.finish();
                }
            }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.AnonymousClass24 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            }).O00000oo();
        } else {
            finish();
        }
    }

    public void onBackPressed() {
        O00000oO();
    }

    @OnClick({5838})
    public void back() {
        O00000oO();
    }

    @OnClick({5074})
    public void startConditionForCondition() {
        O000000o();
    }

    @OnClick({5274})
    public void startConditionBar() {
        O000000o();
    }

    @OnClick({6322})
    public void startTaskBar() {
        O00000Oo();
    }

    private static SceneApi.O000000o O00000oo() {
        SceneApi.O000OOOo o000OOOo = mScene;
        if (o000OOOo == null || o000OOOo.O0000O0o == null) {
            return null;
        }
        for (SceneApi.O000000o next : mScene.O0000O0o) {
            if (next.f11121O000000o == LAUNCH_TYPE.MIKEY) {
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        if (!this.mDisableScene) {
            if (mScene.O0000O0o.size() >= 5) {
                izb.O000000o(this, (int) R.string.add_condition_error, 0).show();
                return;
            }
            Intent intent = new Intent(this.f10900O000000o, StartConditionActivity.class);
            if (this.mSelectedConditionItems != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.mSelectedConditionItems);
                intent.putParcelableArrayListExtra("extra_default_conditions", arrayList);
            } else {
                intent.putParcelableArrayListExtra("extra_default_conditions", this.mDefaultConditionSceneItems);
            }
            startActivityForResult(intent, 1);
            hpq.O000000o().O00000o0();
        }
    }

    @OnClick({5070})
    public void startAddActionForTaskBtn() {
        O00000Oo();
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo() {
        if (!this.mDisableScene) {
            Intent intent = new Intent(this.f10900O000000o, SmartHomeSceneActionChooseActivity.class);
            if (this.mSelectedActionItems != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.mSelectedActionItems);
                intent.putParcelableArrayListExtra("extra_default_actions", arrayList);
            } else {
                intent.putParcelableArrayListExtra("extra_default_actions", this.mDefaultActionSceneItems);
            }
            startActivityForResult(intent, 2);
            hpq.O000000o().O00000o0();
        }
    }

    public void doCompleteScene() {
        SceneApi.O00000Oo o00000Oo;
        if (isNewScene) {
            if (mScene.O0000O0o.size() > 0 && mScene.O00000oo.size() > 0) {
                String str = this.O0000o0;
                if (str != null) {
                    saveNewScene(str, null);
                    return;
                }
                String O000000o2 = hnw.O000000o(mScene);
                int i = 30;
                if (O000000o2.length() > 30) {
                    O000000o2 = O000000o2.substring(0, 30);
                }
                final ClientRemarkInputView clientRemarkInputView = (ClientRemarkInputView) getLayoutInflater().inflate((int) R.layout.client_input_view_checkbox, (ViewGroup) null);
                final CheckBox checkBox = (CheckBox) clientRemarkInputView.findViewById(R.id.enable_push_checkbox);
                MLAlertDialog O00000oo2 = new MLAlertDialog.Builder(this.f10900O000000o).O000000o((int) R.string.smarthome_scene_set_name).O000000o(clientRemarkInputView).O00000Oo(false).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.AnonymousClass3 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        boolean z;
                        dialogInterface.dismiss();
                        Iterator<SceneApi.O000OOOo> it = hod.O0000OoO().O00000o0.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (it.next().O00000Oo.equals(clientRemarkInputView.getEditText().getText().toString())) {
                                    z = true;
                                    break;
                                }
                            } else {
                                z = false;
                                break;
                            }
                        }
                        if (z) {
                            izb.O000000o(SmartHomeSceneCreateEditActivity.this.f10900O000000o, SmartHomeSceneCreateEditActivity.this.getString(R.string.scene_modify_name_error), 0).show();
                            return;
                        }
                        if (checkBox.isChecked()) {
                            SmartHomeSceneCreateEditActivity.mScene.O0000Oo = true;
                        }
                        SmartHomeSceneCreateEditActivity.this.saveNewScene(clientRemarkInputView.getEditText().getText().toString(), clientRemarkInputView);
                    }
                }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ((MLAlertDialog) dialogInterface).setAudoDismiss(true);
                    }
                }).O00000oo();
                clientRemarkInputView.O00000o = null;
                clientRemarkInputView.f7297O000000o = null;
                clientRemarkInputView.O00000Oo = O00000oo2;
                String O0000O0o2 = gqb.O0000O0o(O000000o2);
                clientRemarkInputView.O00000o0.setText(O0000O0o2);
                if (clientRemarkInputView.O00000o0.length() > 0) {
                    EditText editText = clientRemarkInputView.O00000o0;
                    if (clientRemarkInputView.O00000o0.length() <= 30) {
                        i = clientRemarkInputView.O00000o0.length();
                    }
                    editText.setSelection(i);
                }
                clientRemarkInputView.O00000o0.setHint(O0000O0o2);
                clientRemarkInputView.O000000o();
            } else if (mScene.O0000O0o.size() == 0) {
                izb.O000000o(this.f10900O000000o, (int) R.string.smarthome_scene_add_start_condition, 0).show();
            } else {
                izb.O000000o(this.f10900O000000o, (int) R.string.smarthome_scene_set_fail_at_least_0, 0).show();
            }
        } else if (mScene.O0000O0o.size() <= 0 || mScene.O00000oo.size() <= 0) {
            izb.O000000o(this.f10900O000000o, (int) R.string.smarthome_scene_set_fail_at_least_0, 0).show();
        } else {
            if (countConditionTime() == 1 && (o00000Oo = this.O0000oO0) != null) {
                o00000Oo.O00000oO = -1;
                o00000Oo.O00000oo = -1;
                o00000Oo.O0000O0o = -1;
                o00000Oo.O0000OOo = -1;
                o00000Oo.O0000Oo0 = null;
            }
            saveNewScene(mScene.O00000Oo, null);
        }
    }

    @OnClick({5837})
    public void completeScene() {
        boolean z;
        Iterator<SceneApi.Action> it = mScene.O00000oo.iterator();
        while (true) {
            z = true;
            if (!it.hasNext()) {
                break;
            }
            SceneApi.Action next = it.next();
            if (next.f11120O000000o == 1) {
                for (SceneApi.O000000o O00000oO2 : mScene.O0000O0o) {
                    ((SceneApi.O000OO) next.O0000O0o).O00000Oo = hnw.O00000oO(ServiceApplication.getAppContext(), O00000oO2);
                }
            }
        }
        O00000oo();
        if (fcb.O000000o().O000000o("show_scene_user_lincense") != -1) {
            z = false;
        }
        fcb.O000000o().O00000o0("show_scene_user_lincense");
        if (!z) {
            checkLicenseUpdate();
        } else {
            DeviceApi.getInstance().getUserLicenseConfig(ServiceApplication.getAppContext(), "scene_privacy_did", new fsm<Boolean, fso>() {
                /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.AnonymousClass4 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    if (((Boolean) obj).booleanValue()) {
                        SmartHomeSceneCreateEditActivity.this.checkLicenseUpdate();
                    } else {
                        SmartHomeSceneCreateEditActivity.this.showLicense(null);
                    }
                }

                public final void onFailure(fso fso) {
                    if (!gof.O00000o0()) {
                        gqg.O00000Oo((int) R.string.network_fake_connected);
                    } else {
                        gqg.O00000Oo((int) R.string.smarthome_scene_set_fail);
                    }
                }
            });
        }
    }

    public void checkLicenseUpdate() {
        final String O000000o2 = gpv.O000000o("scene_privacy_version", "");
        hsl.O000000o().checkPrivacy(100, O000000o2, new fsm<JSONObject, fso>() {
            /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.AnonymousClass5 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                int optInt = jSONObject.optInt("pop_type");
                String optString = jSONObject.optString("change_log");
                String optString2 = jSONObject.optString("ver");
                if (optInt != 0) {
                    SmartHomeSceneCreateEditActivity.this.showLicense(optString);
                    return;
                }
                if (!TextUtils.equals(O000000o2, optString2)) {
                    gpv.O00000Oo("scene_privacy_version", optString2);
                    DeviceApi.getInstance().setUserLicenseConfig(ServiceApplication.getAppContext(), "scene_privacy_did", "accept", null);
                }
                SmartHomeSceneCreateEditActivity.this.doCompleteScene();
            }

            public final void onFailure(fso fso) {
                if (!gof.O00000o0()) {
                    gqg.O00000Oo((int) R.string.network_fake_connected);
                } else {
                    gqg.O00000Oo((int) R.string.smarthome_scene_set_fail);
                }
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gqb.O000000o(android.content.Context, int, int, android.text.style.ClickableSpan):android.text.SpannableStringBuilder
     arg types: [com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity, ?, ?, com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity$6]
     candidates:
      _m_j.gqb.O000000o(android.content.Context, int, int, java.lang.Object):java.lang.String
      _m_j.gqb.O000000o(android.app.Activity, java.util.Locale, int, android.widget.TextView):boolean
      _m_j.gqb.O000000o(android.content.Context, int, int, android.text.style.ClickableSpan):android.text.SpannableStringBuilder */
    public void showLicense(String str) {
        new MLAlertDialog.Builder(this).O00000o0().O000000o(gqb.O000000o((Context) this, (int) R.string.scene_user_license_title_1_underline, (int) R.string.scene_user_license_title_1_tpl, (ClickableSpan) new ClickableSpan() {
            /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.AnonymousClass6 */

            public final void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(SmartHomeSceneCreateEditActivity.this.getResources().getColor(R.color.mj_color_class_text_27));
                textPaint.setUnderlineText(true);
            }

            public final void onClick(View view) {
                Locale O0000O0o = fju.O000000o().O0000O0o();
                if (O0000O0o == null) {
                    O0000O0o = Locale.getDefault();
                }
                String O000000o2 = flk.O000000o(O0000O0o);
                Context context = SmartHomeSceneCreateEditActivity.this.getContext();
                eyk.O000000o(context, "https://g.home.mi.com/views/user-terms.html?locale=" + O000000o2 + "&type=scenePrivacy");
            }
        })).O000000o((int) R.string.scene_user_license_title).O000000o((int) R.string.smarthome_share_accept, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmartHomeSceneCreateEditActivity$NBgM8VUYEaagBzr9P8LpUKQ7e0o */

            public final void onClick(DialogInterface dialogInterface, int i) {
                SmartHomeSceneCreateEditActivity.this.O00000Oo(dialogInterface, i);
            }
        }).O00000Oo((int) R.string.smarthome_share_reject, $$Lambda$SmartHomeSceneCreateEditActivity$brJKcxvLsMwGQjZMBRRTZu219bs.INSTANCE).O000000o(false).O00000o().show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(DialogInterface dialogInterface, int i) {
        DeviceApi.getInstance().setUserLicenseConfig(ServiceApplication.getAppContext(), "scene_privacy_did", "accept", null);
        doCompleteScene();
    }

    @OnClick({5836})
    public void gotoMorePage() {
        if (!TextUtils.isEmpty(this.O00000Oo) && mScene.O000000o(this.O00000o0)) {
            Intent intent = new Intent(this, SceneMoreActivity.class);
            intent.putExtra("extra_scene_id", this.O00000Oo);
            startActivityForResult(intent, 1000);
        }
    }

    public void saveNewScene(String str, ClientRemarkInputView clientRemarkInputView) {
        Device O00000o02;
        String str2;
        String str3;
        this.mPD = XQProgressDialog.O000000o(this.f10900O000000o, null, getString(R.string.smarthome_scene_saving_scene));
        mScene.O00000Oo = str;
        if (clientRemarkInputView != null) {
            ((InputMethodManager) this.f10900O000000o.getSystemService("input_method")).hideSoftInputFromWindow(clientRemarkInputView.getEditText().getWindowToken(), 0);
        }
        String str4 = null;
        boolean z = false;
        for (SceneApi.O000000o next : mScene.O0000O0o) {
            if (!(next.O00000o0 == null || next.O00000o0.O00000o == null)) {
                Device O00000o03 = fno.O000000o().O00000o0(next.O00000o0.f11122O000000o);
                if (O00000o03 != null) {
                    if (O00000o03.isSubDevice()) {
                        str3 = O00000o03.parentId;
                    } else {
                        str3 = O00000o03.did;
                    }
                    Device O00000o04 = fno.O000000o().O00000o0(str3);
                    if (O00000o04.model.equalsIgnoreCase("lumi.gateway.v1") || O00000o04.model.equalsIgnoreCase("lumi.gateway.v2") || O00000o04.model.equalsIgnoreCase("lumi.gateway.v3") || O00000o04.model.equalsIgnoreCase("lumi.acpartner.v1") || O00000o04.model.equalsIgnoreCase("lumi.acpartner.v2") || O00000o04.model.equalsIgnoreCase("lumi.camera.v1") || O00000o04.model.equalsIgnoreCase("lumi.camera.aq1") || O00000o04.model.equalsIgnoreCase("lumi.acpartner.v3")) {
                        str4 = str3;
                        z = true;
                    }
                }
            }
        }
        if (!z) {
            for (SceneApi.Action next2 : mScene.O00000oo) {
                if (!(next2.O00000oO == null || next2.O0000O0o.O00000o == null || (O00000o02 = fno.O000000o().O00000o0(next2.O0000O0o.O00000o)) == null)) {
                    if (O00000o02.isSubDevice()) {
                        str2 = O00000o02.parentId;
                    } else {
                        str2 = O00000o02.did;
                    }
                    Device O00000o05 = fno.O000000o().O00000o0(str2);
                    if (O00000o05.model.equalsIgnoreCase("lumi.gateway.v1") || O00000o05.model.equalsIgnoreCase("lumi.gateway.v2") || O00000o05.model.equalsIgnoreCase("lumi.gateway.v3") || O00000o05.model.equalsIgnoreCase("lumi.acpartner.v1") || O00000o05.model.equalsIgnoreCase("lumi.acpartner.v2") || O00000o05.model.equalsIgnoreCase("lumi.camera.v1") || O00000o05.model.equalsIgnoreCase("lumi.camera.aq1") || O00000o05.model.equalsIgnoreCase("lumi.acpartner.v3")) {
                        str4 = str2;
                        z = true;
                    }
                }
            }
        }
        if (!z || str4 == null) {
            startSaveScene(null);
            return;
        }
        final Device O00000o06 = fno.O000000o().O00000o0(str4);
        if (O00000o06 == null || O00000o06.isOnline) {
            Intent intent = new Intent();
            SceneApi.O000000o(mScene);
            intent.putExtra("scene_info", hod.O00000o(mScene));
            this.O0000Oo0.sendEmptyMessageDelayed(100, 1000);
            MpkPluginApi.callPlugin(O00000o06.did, 10, intent, DeviceRouterFactory.getDeviceWrapper().newDeviceStat(O00000o06), new SendMessageCallback() {
                /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.AnonymousClass7 */

                public final void onMessageSuccess(Intent intent) {
                    if (SmartHomeSceneCreateEditActivity.this.O0000Oo0.hasMessages(100)) {
                        SmartHomeSceneCreateEditActivity.this.O0000Oo0.removeMessages(100);
                        SceneInfo sceneInfo = (SceneInfo) intent.getParcelableExtra("scene_info");
                        if (sceneInfo != null) {
                            for (int i = 0; i < sceneInfo.mLaunchList.size(); i++) {
                                if (SmartHomeSceneCreateEditActivity.mScene.O0000O0o.get(i).O00000o0 != null && (SmartHomeSceneCreateEditActivity.mScene.O0000O0o.get(i).O00000o0 instanceof SceneApi.O00000o0)) {
                                    ((SceneApi.O00000o0) SmartHomeSceneCreateEditActivity.mScene.O0000O0o.get(i).O00000o0).O0000o00 = sceneInfo.mLaunchList.get(i).mExtra;
                                }
                            }
                            for (int i2 = 0; i2 < sceneInfo.mActions.size(); i2++) {
                                if (SmartHomeSceneCreateEditActivity.mScene.O00000oo.get(i2).O0000O0o != null && (SmartHomeSceneCreateEditActivity.mScene.O00000oo.get(i2).O0000O0o instanceof SceneApi.O000OO0o)) {
                                    ((SceneApi.O000OO0o) SmartHomeSceneCreateEditActivity.mScene.O00000oo.get(i2).O0000O0o).f11130O000000o = sceneInfo.mActions.get(i2).mExtra;
                                }
                            }
                        }
                        SmartHomeSceneCreateEditActivity.this.startSaveScene(O00000o06.did);
                    }
                }

                public final void onMessageFailure(int i, String str) {
                    if (SmartHomeSceneCreateEditActivity.this.O0000Oo0.hasMessages(100)) {
                        SmartHomeSceneCreateEditActivity.this.O0000Oo0.removeMessages(100);
                        SmartHomeSceneCreateEditActivity.this.startSaveScene(null);
                    }
                }

                public final void onMessageHandle(boolean z) {
                    if (!z) {
                        SmartHomeSceneCreateEditActivity.this.startSaveScene(null);
                    }
                }
            });
            return;
        }
        this.mPD.dismiss();
        izb.O000000o(this, (int) R.string.smarthome_scene_getway_offline, 0).show();
    }

    public void startSaveScene(final String str) {
        if (eys.f15955O000000o) {
            int i = this.O0000o0o;
            if (i != -1) {
                mScene.O00000o = i;
            }
            hob.O000000o().O000000o(this, mScene, new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.AnonymousClass8 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    SmartHomeSceneCreateEditActivity smartHomeSceneCreateEditActivity = SmartHomeSceneCreateEditActivity.this;
                    String optString = jSONObject.optString("us_id");
                    boolean optBoolean = jSONObject.optBoolean("local");
                    String optString2 = jSONObject.optString("local_dev");
                    SmartHomeSceneCreateEditActivity.mScene.f11131O000000o = optString;
                    if (TextUtils.isEmpty(optString2) || !optBoolean) {
                        smartHomeSceneCreateEditActivity.O000000o(true);
                        return;
                    }
                    Device O00000o0 = fno.O000000o().O00000o0(optString2);
                    Intent intent = new Intent();
                    intent.putExtra("extra", jSONObject.optJSONObject("data").toString());
                    MpkPluginApi.callPlugin(O00000o0.did, 14, intent, DeviceRouterFactory.getDeviceWrapper().newDeviceStat(O00000o0), new SendMessageCallback() {
                        /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.AnonymousClass10 */

                        public final void onMessageSuccess(Intent intent) {
                            hob.O000000o();
                            hob.O00000Oo(SmartHomeSceneCreateEditActivity.this, SmartHomeSceneCreateEditActivity.mScene, new fsm<Void, fso>() {
                                /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.AnonymousClass10.AnonymousClass1 */

                                public final void onFailure(fso fso) {
                                    SmartHomeSceneCreateEditActivity.this.O000000o(false);
                                }

                                public final /* synthetic */ void onSuccess(Object obj) {
                                    SmartHomeSceneCreateEditActivity.this.O000000o(true);
                                }
                            });
                        }

                        public final void onMessageFailure(int i, String str) {
                            SmartHomeSceneCreateEditActivity.this.O000000o(false);
                        }

                        public final void onMessageHandle(boolean z) {
                            if (!z) {
                                SmartHomeSceneCreateEditActivity.this.O000000o(false);
                            }
                        }
                    });
                    smartHomeSceneCreateEditActivity.O0000Oo0.sendEmptyMessageDelayed(101, 10000);
                }

                public final void onFailure(fso fso) {
                    SmartHomeSceneCreateEditActivity.this.mPD.dismiss();
                    if (fso.f17063O000000o == -23) {
                        izb.O000000o(SmartHomeSceneCreateEditActivity.this.f10900O000000o, (int) R.string.dead_loop_error, 0).show();
                    } else if (fso.f17063O000000o == -1) {
                        izb.O000000o(SmartHomeSceneCreateEditActivity.this.getContext(), (int) R.string.smarthome_scene_has_deleted_device, 0).show();
                    } else {
                        izb.O000000o(SmartHomeSceneCreateEditActivity.this.f10900O000000o, (int) R.string.smarthome_scene_set_fail, 0).show();
                    }
                }
            });
            return;
        }
        this.mPD.dismiss();
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(final boolean z) {
        this.O0000Oo0.post(new Runnable() {
            /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.AnonymousClass9 */

            public final void run() {
                SmartHomeSceneCreateEditActivity.this.mPD.dismiss();
                SmartHomeSceneCreateEditActivity.this.registerBleEventIfNeeded();
                if (z) {
                    if (!TextUtils.isEmpty(SmartHomeSceneCreateEditActivity.this.O00000Oo)) {
                        hod.O0000OoO().O00000o0(SmartHomeSceneCreateEditActivity.this.O00000Oo);
                    }
                    hod.O0000OoO().O00000o0(SmartHomeSceneCreateEditActivity.mScene);
                    CoreApi.O000000o().O00oOoOo();
                    hod.O0000OoO().O00000o();
                    izb.O000000o(SmartHomeSceneCreateEditActivity.this.f10900O000000o, (int) R.string.smarthome_scene_set_succ, 0).show();
                } else {
                    izb.O000000o(SmartHomeSceneCreateEditActivity.this.f10900O000000o, (int) R.string.local_sync_failed, 0).show();
                }
                SmartHomeSceneCreateEditActivity.this.finish();
            }
        });
    }

    public void registerBleEventIfNeeded() {
        SceneApi.O000000o O00000oo2 = O00000oo();
        if (O00000oo2 != null) {
            Intent intent = new Intent();
            String str = O00000oo2.O00000oO.f11122O000000o;
            String str2 = O00000oo2.O00000oO.O0000Oo;
            intent.putExtra("extra_did", str);
            intent.putExtra("extra_event", str2);
            setResult(-1, intent);
        }
    }

    public void sortActions() {
        Collections.sort(mScene.O00000oo, new Comparator<SceneApi.Action>() {
            /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.AnonymousClass11 */

            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                SceneApi.Action action = (SceneApi.Action) obj;
                SceneApi.Action action2 = (SceneApi.Action) obj2;
                if (action.O0000O0o == null || action2.O0000O0o == null) {
                    return 0;
                }
                return action.O0000O0o.O00000oo - action2.O0000O0o.O00000oo;
            }
        });
        for (int i = 0; i < mScene.O00000oo.size(); i++) {
            O000000o o000000o = new O000000o();
            if (i != 0) {
                int i2 = i - 1;
                if (mScene.O00000oo.get(i).O0000O0o.O00000oo != mScene.O00000oo.get(i2).O0000O0o.O00000oo) {
                    o000000o.f10955O000000o = mScene.O00000oo.get(i).O0000O0o.O00000oo - mScene.O00000oo.get(i2).O0000O0o.O00000oo;
                    this.O0000o.add(o000000o);
                    O000000o o000000o2 = new O000000o();
                    o000000o2.O00000Oo = mScene.O00000oo.get(i);
                    this.O0000o.add(o000000o2);
                }
            }
            o000000o.O00000Oo = mScene.O00000oo.get(i);
            this.O0000o.add(o000000o);
        }
    }

    class ConditionsAdapter extends BaseAdapter {

        /* renamed from: O000000o  reason: collision with root package name */
        int f10938O000000o;
        int O00000Oo;
        final /* synthetic */ SmartHomeSceneCreateEditActivity O00000o0;
        @BindView(5185)
        TextView mBuyButton;
        @BindView(5457)
        ImageView mExpandHint;
        @BindView(5583)
        SimpleDraweeView mIcon;
        @BindView(5665)
        TextView mKeyName;
        @BindView(5883)
        TextView mName;
        @BindView(5915)
        TextView mOffline;
        @BindView(6099)
        TextView mRunTV;
        @BindView(6204)
        ImageView mTimeSetButton;
        @BindView(5080)
        TextView mTimeSpan;

        public Object getItem(int i) {
            return null;
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public int getCount() {
            if (!(SmartHomeSceneCreateEditActivity.mScene == null || SmartHomeSceneCreateEditActivity.mScene.O0000O0o == null)) {
                this.O00000Oo = SmartHomeSceneCreateEditActivity.mScene.O0000O0o.size();
            }
            if (this.O00000o0.mNoDeviceConditionItems != null) {
                this.f10938O000000o = this.O00000o0.mNoDeviceConditionItems.size();
            }
            return this.f10938O000000o + this.O00000Oo;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = this.O00000o0.getLayoutInflater().inflate((int) R.layout.scene_add_scene_condition_item, (ViewGroup) null);
            }
            ButterKnife.bind(this, view);
            if (i < SmartHomeSceneCreateEditActivity.mScene.O0000O0o.size()) {
                final SceneApi.O000000o o000000o = SmartHomeSceneCreateEditActivity.mScene.O0000O0o.get(i);
                this.mBuyButton.setVisibility(8);
                if (o000000o.f11121O000000o == LAUNCH_TYPE.DEVICE) {
                    this.mKeyName.setVisibility(0);
                    this.mKeyName.setText(o000000o.O00000o0.O00000Oo);
                } else if (o000000o.f11121O000000o == LAUNCH_TYPE.TIMER) {
                    this.mKeyName.setVisibility(0);
                    this.mKeyName.setText(SmartHomeSceneTimerActivity.getTimerHint(this.O00000o0, o000000o.O00000Oo != null ? o000000o.O00000Oo : null));
                } else if (o000000o.f11121O000000o == LAUNCH_TYPE.LEAVE_LOC || o000000o.f11121O000000o == LAUNCH_TYPE.COME_LOC) {
                    this.mKeyName.setVisibility(0);
                    this.mKeyName.setText(o000000o.O0000Oo0.O00000Oo);
                } else if (o000000o.f11121O000000o == LAUNCH_TYPE.LEAVE_FENCE || o000000o.f11121O000000o == LAUNCH_TYPE.ENTER_FENCE) {
                    this.mKeyName.setVisibility(0);
                    this.mKeyName.setText(o000000o.O0000Oo.O00000Oo);
                } else if (o000000o.f11121O000000o == LAUNCH_TYPE.PHONE_CALL || o000000o.f11121O000000o == LAUNCH_TYPE.PHONE_SMS) {
                    this.mKeyName.setVisibility(8);
                }
                if (o000000o.f11121O000000o != LAUNCH_TYPE.CLICK || !SmartHomeSceneCreateEditActivity.mScene.O0000Oo0) {
                    this.mRunTV.setVisibility(8);
                } else {
                    this.mRunTV.setVisibility(0);
                    this.mRunTV.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.ConditionsAdapter.AnonymousClass1 */

                        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                         method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, boolean):void
                         arg types: [com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, ?[OBJECT, ARRAY], int]
                         candidates:
                          com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, boolean, long, long):int
                          com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, com.xiaomi.smarthome.core.entity.net.Crypto, _m_j.fsm):_m_j.fsn
                          com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String, _m_j.fsm<org.json.JSONObject, _m_j.fso>, boolean):_m_j.fsn
                          com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions, _m_j.gle):com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler
                          com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String[], boolean, com.xiaomi.smarthome.core.client.IClientCallback):void
                          com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, boolean):void */
                        public final void onClick(View view) {
                            hob.O000000o();
                            hob.O000000o(ConditionsAdapter.this.O00000o0.getApplicationContext(), SmartHomeSceneCreateEditActivity.mScene.f11131O000000o, new fsm<Void, fso>() {
                                /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.ConditionsAdapter.AnonymousClass1.AnonymousClass1 */

                                public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                                }

                                public final void onFailure(fso fso) {
                                    izb.O000000o(ConditionsAdapter.this.O00000o0.getApplicationContext(), (int) R.string.smarthome_scene_start_error, 0).show();
                                }
                            });
                            CoreApi.O000000o().O000000o(StatType.EVENT, "run_button_click", "smart_home_scene_create_edit_activity", (String) null, false);
                        }
                    });
                }
                this.mName.setText(hnw.O00000Oo(this.O00000o0.f10900O000000o, o000000o));
                this.mExpandHint.setVisibility(8);
                hnw.O000000o(this.mIcon, o000000o);
                if (o000000o.f11121O000000o == LAUNCH_TYPE.DEVICE || o000000o.f11121O000000o == LAUNCH_TYPE.MIKEY || o000000o.f11121O000000o == LAUNCH_TYPE.MIBAND) {
                    this.mTimeSpan.setVisibility(8);
                    this.mOffline.setVisibility(8);
                    this.mTimeSetButton.setVisibility(8);
                    if (!this.O00000o0.O00000oo[i]) {
                        this.mOffline.setVisibility(0);
                        this.mOffline.setText((int) R.string.smarthome_scene_client_offline);
                        if (o000000o.f11121O000000o == LAUNCH_TYPE.DEVICE && o000000o.O00000o0 != null && !TextUtils.isEmpty(o000000o.O00000o0.f11122O000000o)) {
                            Device O00000o02 = fno.O000000o().O00000o0(o000000o.O00000o0.f11122O000000o);
                            if (O00000o02 == null) {
                                this.mOffline.setText((int) R.string.smarthome_scene_client_deleted);
                            } else if (!O00000o02.isOwner()) {
                                this.mOffline.setText((int) R.string.smarthome_scene_client_deleted);
                            }
                        }
                        this.mTimeSetButton.setVisibility(8);
                        this.mTimeSpan.setVisibility(8);
                        view.setOnClickListener(new View.OnClickListener() {
                            /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.ConditionsAdapter.AnonymousClass4 */

                            public final void onClick(View view) {
                                if (!ConditionsAdapter.this.O00000o0.mDisableScene) {
                                    Intent intent = new Intent(ConditionsAdapter.this.O00000o0.f10900O000000o, StartConditionActivity.class);
                                    if (ConditionsAdapter.this.O00000o0.mSelectedConditionItems != null) {
                                        ArrayList arrayList = new ArrayList();
                                        arrayList.add(ConditionsAdapter.this.O00000o0.mSelectedConditionItems);
                                        intent.putParcelableArrayListExtra("extra_default_conditions", arrayList);
                                    } else {
                                        intent.putParcelableArrayListExtra("extra_default_conditions", ConditionsAdapter.this.O00000o0.mDefaultConditionSceneItems);
                                    }
                                    hpq.O000000o().O00000Oo(o000000o);
                                    ConditionsAdapter.this.O00000o0.startActivityForResult(intent, 1);
                                }
                            }
                        });
                    } else if (o000000o.O00000o0 != null) {
                        if (o000000o.O00000o0.O00000oO == -1) {
                            this.mTimeSpan.setVisibility(8);
                            this.mOffline.setVisibility(8);
                            this.mTimeSetButton.setVisibility(8);
                        } else if (this.O00000o0.countConditionTime() > 1) {
                            this.mTimeSetButton.setVisibility(0);
                            this.mTimeSpan.setVisibility(0);
                            TextView textView = this.mTimeSpan;
                            textView.setText(o000000o.O00000o0.O00000oO + ":00-" + o000000o.O00000o0.O00000oo + ":00");
                            this.mTimeSetButton.setOnClickListener(new View.OnClickListener() {
                                /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.ConditionsAdapter.AnonymousClass5 */

                                public final void onClick(View view) {
                                    if (!ConditionsAdapter.this.O00000o0.mDisableScene) {
                                        ConditionsAdapter.this.O00000o0.showDeleteAllTimeDialog();
                                    }
                                }
                            });
                        } else {
                            this.mTimeSetButton.setVisibility(8);
                            this.mTimeSpan.setVisibility(8);
                        }
                        view.setOnClickListener(new View.OnClickListener() {
                            /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.ConditionsAdapter.AnonymousClass6 */

                            public final void onClick(View view) {
                                if (!ConditionsAdapter.this.O00000o0.mDisableScene) {
                                    Intent intent = new Intent(ConditionsAdapter.this.O00000o0.f10900O000000o, StartConditionActivity.class);
                                    if (ConditionsAdapter.this.O00000o0.mSelectedConditionItems != null) {
                                        ArrayList arrayList = new ArrayList();
                                        arrayList.add(ConditionsAdapter.this.O00000o0.mSelectedConditionItems);
                                        intent.putParcelableArrayListExtra("extra_default_conditions", arrayList);
                                    } else {
                                        intent.putParcelableArrayListExtra("extra_default_conditions", ConditionsAdapter.this.O00000o0.mDefaultConditionSceneItems);
                                    }
                                    hpq.O000000o().O00000Oo(o000000o);
                                    ConditionsAdapter.this.O00000o0.startActivityForResult(intent, 1);
                                }
                            }
                        });
                    }
                    view.setOnLongClickListener(new View.OnLongClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.ConditionsAdapter.AnonymousClass7 */

                        public final boolean onLongClick(View view) {
                            if (ConditionsAdapter.this.O00000o0.mDisableScene) {
                                return false;
                            }
                            new MLAlertDialog.Builder(ConditionsAdapter.this.O00000o0.f10900O000000o).O000000o(new String[]{ConditionsAdapter.this.O00000o0.getString(R.string.delete)}, new DialogInterface.OnClickListener() {
                                /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.ConditionsAdapter.AnonymousClass7.AnonymousClass1 */

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    SmartHomeSceneCreateEditActivity.mScene.O0000O0o.remove(o000000o);
                                    hpq.O000000o().O00000o(SmartHomeSceneCreateEditActivity.mScene);
                                    ConditionsAdapter.this.O00000o0.O0000O0o.notifyDataSetChanged();
                                    ConditionsAdapter.this.O00000o0.O00000o();
                                    dialogInterface.cancel();
                                }
                            }).O00000o().show();
                            return true;
                        }
                    });
                    return view;
                } else if (o000000o.f11121O000000o == LAUNCH_TYPE.COME_LOC || o000000o.f11121O000000o == LAUNCH_TYPE.LEAVE_LOC || o000000o.f11121O000000o == LAUNCH_TYPE.ENTER_FENCE || o000000o.f11121O000000o == LAUNCH_TYPE.LEAVE_FENCE) {
                    this.mTimeSpan.setVisibility(8);
                    this.mOffline.setVisibility(8);
                    this.mTimeSetButton.setVisibility(8);
                    this.mTimeSetButton.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.ConditionsAdapter.AnonymousClass8 */

                        public final void onClick(View view) {
                            if (!ConditionsAdapter.this.O00000o0.mDisableScene) {
                                ConditionsAdapter.this.O00000o0.startActivityForResult(new Intent(ConditionsAdapter.this.O00000o0.f10900O000000o, SmartHomeSceneTimeSpan.class), 2);
                                hpq.O000000o().O00000Oo(o000000o);
                            }
                        }
                    });
                    view.setOnLongClickListener(new View.OnLongClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.ConditionsAdapter.AnonymousClass9 */

                        public final boolean onLongClick(View view) {
                            if (ConditionsAdapter.this.O00000o0.mDisableScene) {
                                return false;
                            }
                            new MLAlertDialog.Builder(ConditionsAdapter.this.O00000o0.f10900O000000o).O000000o(new String[]{ConditionsAdapter.this.O00000o0.getString(R.string.delete)}, new DialogInterface.OnClickListener() {
                                /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.ConditionsAdapter.AnonymousClass9.AnonymousClass1 */

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    SmartHomeSceneCreateEditActivity.mScene.O0000O0o.remove(o000000o);
                                    hpq.O000000o().O00000o(SmartHomeSceneCreateEditActivity.mScene);
                                    ConditionsAdapter.this.O00000o0.O0000O0o.notifyDataSetChanged();
                                    ConditionsAdapter.this.O00000o0.O00000o();
                                    dialogInterface.cancel();
                                }
                            }).O00000o().show();
                            return true;
                        }
                    });
                    view.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.ConditionsAdapter.AnonymousClass10 */

                        public final void onClick(View view) {
                            if (!ConditionsAdapter.this.O00000o0.mDisableScene) {
                                Intent intent = new Intent(ConditionsAdapter.this.O00000o0.f10900O000000o, StartConditionActivity.class);
                                hpq.O000000o().O00000Oo(o000000o);
                                ConditionsAdapter.this.O00000o0.startActivityForResult(intent, 1);
                            }
                        }
                    });
                } else {
                    this.mTimeSetButton.setVisibility(8);
                    this.mTimeSpan.setVisibility(8);
                    this.mOffline.setVisibility(8);
                    if (o000000o.f11121O000000o == LAUNCH_TYPE.TIMER) {
                        this.mExpandHint.setVisibility(0);
                        view.setOnClickListener(new View.OnClickListener() {
                            /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.ConditionsAdapter.AnonymousClass11 */

                            public final void onClick(View view) {
                                if (!ConditionsAdapter.this.O00000o0.mDisableScene) {
                                    ConditionsAdapter.this.O00000o0.startActivity(new Intent(ConditionsAdapter.this.O00000o0, SmartHomeSceneTimerActivity.class));
                                    hpq.O000000o().O00000Oo(o000000o);
                                }
                            }
                        });
                    } else {
                        this.mExpandHint.setVisibility(8);
                        view.setOnClickListener(null);
                    }
                    view.setOnLongClickListener(new View.OnLongClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.ConditionsAdapter.AnonymousClass2 */

                        public final boolean onLongClick(View view) {
                            if (ConditionsAdapter.this.O00000o0.mDisableScene) {
                                return false;
                            }
                            new MLAlertDialog.Builder(ConditionsAdapter.this.O00000o0.f10900O000000o).O000000o(new String[]{ConditionsAdapter.this.O00000o0.getString(R.string.delete)}, new DialogInterface.OnClickListener() {
                                /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.ConditionsAdapter.AnonymousClass2.AnonymousClass1 */

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    SmartHomeSceneCreateEditActivity.mScene.O0000O0o.remove(o000000o);
                                    ConditionsAdapter.this.O00000o0.O0000O0o.notifyDataSetChanged();
                                    hpq.O000000o().O00000o(SmartHomeSceneCreateEditActivity.mScene);
                                    ConditionsAdapter.this.O00000o0.O00000o();
                                    dialogInterface.cancel();
                                }
                            }).O00000o().show();
                            return true;
                        }
                    });
                }
            } else {
                final Device O0000o0O = DeviceFactory.O0000o0O(this.O00000o0.mNoDeviceConditionItems.get(i - this.O00000Oo).O00000Oo[0]);
                if (O0000o0O != null) {
                    this.mName.setText(O0000o0O.name);
                    this.mExpandHint.setVisibility(8);
                    this.mName.setTextColor(this.O00000o0.f10900O000000o.getResources().getColor(R.color.mj_color_gray_heavy));
                    if (!TextUtils.isEmpty(this.O00000o0.mNoDeviceConditionItems.get(i - this.O00000Oo).O00000o0[0].mName)) {
                        this.mKeyName.setText(this.O00000o0.mNoDeviceConditionItems.get(i - this.O00000Oo).O00000o0[0].mName);
                    } else {
                        this.mKeyName.setVisibility(8);
                    }
                    DeviceFactory.O00000Oo(O0000o0O.model, this.mIcon);
                    view.setOnClickListener(null);
                    view.setOnLongClickListener(null);
                    this.mBuyButton.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.ConditionsAdapter.AnonymousClass3 */

                        public final void onClick(View view) {
                            ConditionsAdapter.this.O00000o0.goToShop(O0000o0O.name);
                        }
                    });
                    this.mBuyButton.setVisibility(0);
                    this.mTimeSetButton.setVisibility(8);
                    this.mTimeSpan.setVisibility(8);
                }
            }
            return view;
        }
    }

    public void goToShop(String str) {
        if (!TextUtils.isEmpty(str)) {
            hjp.O000000o("https://home.mi.com/shop/search?keyword=".concat(String.valueOf(str)));
        } else {
            hjp.O000000o("https://home.mi.com/shop/main");
        }
    }

    class ActionsAdapter extends BaseAdapter {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f10930O000000o;
        final /* synthetic */ SmartHomeSceneCreateEditActivity O00000Oo;
        private int O00000o0;
        @BindView(5099)
        ImageView mAnchor;
        @BindView(5150)
        View mBottomline;
        @BindView(5185)
        TextView mBuyButton;
        @BindView(5318)
        View mDelayBottomLine;
        @BindView(5322)
        View mDelayLayout;
        @BindView(5320)
        View mDelayTimeLine;
        @BindView(5321)
        TextView mDelayTimeText;
        @BindView(5323)
        View mDelayTopLine;
        @BindView(5587)
        View mIconBottomLine;
        @BindView(5603)
        View mIconTopLine;
        @BindView(5609)
        SimpleDraweeView mImage;
        @BindView(5915)
        TextView mOffline;
        @BindView(6292)
        TextView mSubTitle;
        @BindView(6322)
        View mTaskLayout;
        @BindView(6366)
        TextView mTitle;

        public Object getItem(int i) {
            return null;
        }

        public long getItemId(int i) {
            return 0;
        }

        public int getCount() {
            if (this.O00000Oo.mNoDeviceActionItems != null) {
                this.O00000o0 = this.O00000Oo.mNoDeviceActionItems.size();
            }
            if (!(SmartHomeSceneCreateEditActivity.mScene == null || SmartHomeSceneCreateEditActivity.mScene.O00000oo == null)) {
                this.f10930O000000o = SmartHomeSceneCreateEditActivity.mScene.O00000oo.size();
            }
            return this.O00000o0 + this.f10930O000000o;
        }

        public View getView(final int i, View view, ViewGroup viewGroup) {
            String str;
            if (view == null) {
                view = this.O00000Oo.getLayoutInflater().inflate((int) R.layout.smarthome_scene_condition_task_item, (ViewGroup) null);
            }
            ButterKnife.bind(this, view);
            if (i >= this.f10930O000000o) {
                this.mTaskLayout.setVisibility(0);
                this.mDelayLayout.setVisibility(8);
                final Device O0000o0O = DeviceFactory.O0000o0O(this.O00000Oo.mNoDeviceActionItems.get(i - this.f10930O000000o).O00000Oo[0]);
                this.mTitle.setText(O0000o0O.name);
                this.mOffline.setVisibility(8);
                this.mTitle.setTextColor(this.O00000Oo.f10900O000000o.getResources().getColor(R.color.mj_color_gray_heavy));
                DeviceFactory.O00000Oo(O0000o0O.model, this.mImage);
                this.mSubTitle.setText(this.O00000Oo.mNoDeviceActionItems.get(i - this.f10930O000000o).O00000o0[0].mName);
                view.setOnClickListener(null);
                view.setOnLongClickListener(null);
                if (i == 0 && i == (this.O00000o0 + this.f10930O000000o) - 1) {
                    this.mIconTopLine.setVisibility(4);
                    this.mIconBottomLine.setVisibility(4);
                    this.mBottomline.setVisibility(4);
                } else if (i == 0) {
                    this.mBottomline.setVisibility(4);
                    this.mIconTopLine.setVisibility(4);
                    this.mIconBottomLine.setVisibility(0);
                } else if (i == (this.O00000o0 + this.f10930O000000o) - 1) {
                    this.mIconTopLine.setVisibility(0);
                    this.mIconBottomLine.setVisibility(4);
                    this.mBottomline.setVisibility(4);
                } else {
                    this.mIconTopLine.setVisibility(0);
                    this.mIconBottomLine.setVisibility(0);
                    this.mBottomline.setVisibility(4);
                }
                this.mBuyButton.setVisibility(0);
                this.mBuyButton.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.ActionsAdapter.AnonymousClass1 */

                    public final void onClick(View view) {
                        if (TextUtils.isEmpty(ActionsAdapter.this.O00000Oo.mNoDeviceActionItems.get(i - ActionsAdapter.this.f10930O000000o).O00000o)) {
                            SmartHomeSceneCreateEditActivity smartHomeSceneCreateEditActivity = ActionsAdapter.this.O00000Oo;
                            new MLAlertDialog.Builder(smartHomeSceneCreateEditActivity).O00000Oo((int) R.string.no_device_title).O000000o((int) R.string.go_to_buy, new DialogInterface.OnClickListener() {
                                /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.AnonymousClass21 */

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    SmartHomeSceneCreateEditActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://m.mi.com")));
                                }
                            }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                                /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.AnonymousClass20 */

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            }).O00000oo();
                            return;
                        }
                        ActionsAdapter.this.O00000Oo.goToShop(O0000o0O.name);
                    }
                });
                this.mAnchor.setVisibility(8);
                return view;
            }
            final SceneApi.Action action = SmartHomeSceneCreateEditActivity.mScene.O00000oo.get(i);
            this.mBuyButton.setVisibility(8);
            if (action.O0000O0o instanceof SceneApi.O000O0o0) {
                this.mTaskLayout.setVisibility(8);
                this.mDelayLayout.setVisibility(0);
                if (i == 0 && i == (this.O00000o0 + this.f10930O000000o) - 1) {
                    this.mDelayTimeLine.setVisibility(4);
                    this.mDelayTopLine.setVisibility(4);
                    this.mDelayBottomLine.setVisibility(4);
                } else if (i == 0) {
                    this.mDelayTimeLine.setVisibility(4);
                    this.mDelayTopLine.setVisibility(4);
                    this.mDelayBottomLine.setVisibility(0);
                } else if (i == (this.O00000o0 + this.f10930O000000o) - 1) {
                    this.mDelayTimeLine.setVisibility(4);
                    this.mDelayTopLine.setVisibility(0);
                    this.mDelayBottomLine.setVisibility(4);
                } else {
                    this.mDelayTimeLine.setVisibility(0);
                    this.mDelayTopLine.setVisibility(0);
                    this.mDelayBottomLine.setVisibility(0);
                }
                if (action.O0000O0o.O00000oo < 60) {
                    str = this.O00000Oo.getResources().getQuantityString(R.plurals.smarthome_scene_delay_detal_sec, action.O0000O0o.O00000oo % 60, Integer.valueOf(action.O0000O0o.O00000oo % 60));
                } else if (action.O0000O0o.O00000oo % 60 == 0) {
                    str = this.O00000Oo.getResources().getQuantityString(R.plurals.smarthome_scene_delay_detal_min, action.O0000O0o.O00000oo / 60, Integer.valueOf(action.O0000O0o.O00000oo / 60));
                } else {
                    String quantityString = this.O00000Oo.getResources().getQuantityString(R.plurals.automation_minute, action.O0000O0o.O00000oo / 60, Integer.valueOf(action.O0000O0o.O00000oo / 60));
                    String quantityString2 = this.O00000Oo.getResources().getQuantityString(R.plurals.automation_seconds, action.O0000O0o.O00000oo % 60, Integer.valueOf(action.O0000O0o.O00000oo % 60));
                    str = String.format(this.O00000Oo.getString(R.string.smarthome_scene_delay_detal_min_sec), quantityString, quantityString2);
                }
                this.mDelayTimeText.setText(str);
                view.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.ActionsAdapter.AnonymousClass2 */

                    public final void onClick(View view) {
                        if (!ActionsAdapter.this.O00000Oo.mDisableScene) {
                            Intent intent = new Intent(ActionsAdapter.this.O00000Oo.f10900O000000o, SmartHomeSceneTimerDelay.class);
                            hpq.O000000o().O00000Oo(action);
                            ActionsAdapter.this.O00000Oo.startActivityForResult(intent, 1);
                        }
                    }
                });
            } else {
                this.mTaskLayout.setVisibility(0);
                this.mDelayLayout.setVisibility(8);
                if (i == 0 && i == SmartHomeSceneCreateEditActivity.mScene.O00000oo.size() - 1) {
                    this.mIconTopLine.setVisibility(4);
                    this.mIconBottomLine.setVisibility(4);
                    this.mBottomline.setVisibility(4);
                } else if (i == 0) {
                    this.mBottomline.setVisibility(4);
                    this.mIconTopLine.setVisibility(4);
                    this.mIconBottomLine.setVisibility(0);
                } else if (i == SmartHomeSceneCreateEditActivity.mScene.O00000oo.size() - 1) {
                    this.mIconTopLine.setVisibility(0);
                    this.mIconBottomLine.setVisibility(4);
                    this.mBottomline.setVisibility(4);
                } else {
                    this.mIconTopLine.setVisibility(0);
                    this.mIconBottomLine.setVisibility(0);
                    this.mBottomline.setVisibility(4);
                }
                if (i == 0 || !(SmartHomeSceneCreateEditActivity.mScene.O00000oo.get(i).O0000O0o instanceof SceneApi.O000O0o0)) {
                    SmartHomeSceneCreateEditActivity.mScene.O00000oo.size();
                }
                this.mBottomline.setVisibility(4);
                this.mOffline.setVisibility(8);
                this.mAnchor.setVisibility(8);
                hnw.O000000o(this.mImage, this.mTitle, action);
                if (action.O0000O0o instanceof SceneApi.O000OO) {
                    this.mSubTitle.setVisibility(8);
                    this.mSubTitle.setText(action.O00000o0);
                } else {
                    this.mSubTitle.setVisibility(0);
                    this.mSubTitle.setText(action.O00000o0);
                }
                view.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.ActionsAdapter.AnonymousClass3 */

                    public final void onClick(View view) {
                        if (!ActionsAdapter.this.O00000Oo.mDisableScene) {
                            Intent intent = new Intent(ActionsAdapter.this.O00000Oo.f10900O000000o, SmartHomeSceneActionChooseActivity.class);
                            hpq.O000000o().O00000Oo(action);
                            if (ActionsAdapter.this.O00000Oo.mSelectedActionItems != null) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(ActionsAdapter.this.O00000Oo.mSelectedActionItems);
                                intent.putParcelableArrayListExtra("extra_default_actions", arrayList);
                            } else {
                                intent.putParcelableArrayListExtra("extra_default_actions", ActionsAdapter.this.O00000Oo.mDefaultActionSceneItems);
                            }
                            ActionsAdapter.this.O00000Oo.startActivityForResult(intent, 1);
                        }
                    }
                });
                if ((action.O0000O0o instanceof SceneApi.O000O0OO) || (action.O0000O0o instanceof SceneApi.O000OO) || (action.O0000O0o instanceof SceneApi.O000O00o) || (this.O00000Oo.O00000o != null && this.O00000Oo.O00000o.length > i && this.O00000Oo.O00000o[i])) {
                    this.mOffline.setVisibility(8);
                    this.mAnchor.setVisibility(8);
                    if (action.O0000O0o instanceof SceneApi.O000O00o) {
                        if (hpr.O00000o0().O000000o(((SceneApi.O000O00o) action.O0000O0o).f11127O000000o) == null) {
                            this.mOffline.setVisibility(0);
                            this.mOffline.setText((int) R.string.scene_invalid);
                        }
                    } else if ((action.O0000O0o instanceof SceneApi.O000O0OO) && hod.O0000OoO().O00000Oo(((SceneApi.O000O0OO) action.O0000O0o).f11128O000000o) == null) {
                        this.mOffline.setVisibility(0);
                        this.mOffline.setText((int) R.string.auto_scene_invalid);
                    }
                } else {
                    this.mOffline.setVisibility(0);
                    this.mOffline.setText((int) R.string.smarthome_scene_client_offline);
                    if (!TextUtils.isEmpty(action.O0000O0o.O00000o)) {
                        Device O00000o02 = fno.O000000o().O00000o0(action.O0000O0o.O00000o);
                        if (O00000o02 == null) {
                            this.mOffline.setText((int) R.string.smarthome_scene_client_deleted);
                        } else if (!O00000o02.isOwner()) {
                            this.mOffline.setText((int) R.string.smarthome_scene_client_deleted);
                        }
                    }
                    this.mAnchor.setVisibility(8);
                    view.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.ActionsAdapter.AnonymousClass4 */

                        public final void onClick(View view) {
                            if (!ActionsAdapter.this.O00000Oo.mDisableScene) {
                                Intent intent = new Intent(ActionsAdapter.this.O00000Oo.f10900O000000o, SmartHomeSceneActionChooseActivity.class);
                                hpq.O000000o().O00000Oo(action);
                                if (ActionsAdapter.this.O00000Oo.mSelectedActionItems != null) {
                                    ArrayList arrayList = new ArrayList();
                                    arrayList.add(ActionsAdapter.this.O00000Oo.mSelectedActionItems);
                                    intent.putParcelableArrayListExtra("extra_default_actions", arrayList);
                                } else {
                                    intent.putParcelableArrayListExtra("extra_default_actions", ActionsAdapter.this.O00000Oo.mDefaultActionSceneItems);
                                }
                                ActionsAdapter.this.O00000Oo.startActivityForResult(intent, 1);
                            }
                        }
                    });
                }
            }
            this.mBuyButton.setVisibility(8);
            view.setOnLongClickListener(new View.OnLongClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.ActionsAdapter.AnonymousClass5 */

                public final boolean onLongClick(View view) {
                    if (ActionsAdapter.this.O00000Oo.mDisableScene) {
                        return false;
                    }
                    new MLAlertDialog.Builder(ActionsAdapter.this.O00000Oo.f10900O000000o).O000000o(new String[]{ActionsAdapter.this.O00000Oo.getString(R.string.delete)}, new DialogInterface.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.ActionsAdapter.AnonymousClass5.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (i == 0) {
                                SmartHomeSceneCreateEditActivity.mScene.O00000oo.remove(i);
                                hpq.O000000o().O00000o(SmartHomeSceneCreateEditActivity.mScene);
                                ActionsAdapter.this.O00000Oo.O00000o();
                            }
                        }
                    }).O00000oo();
                    return true;
                }
            });
            return view;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.Arrays.fill(boolean[], boolean):void}
     arg types: [boolean[], int]
     candidates:
      ClspMth{java.util.Arrays.fill(double[], double):void}
      ClspMth{java.util.Arrays.fill(byte[], byte):void}
      ClspMth{java.util.Arrays.fill(long[], long):void}
      ClspMth{java.util.Arrays.fill(char[], char):void}
      ClspMth{java.util.Arrays.fill(short[], short):void}
      ClspMth{java.util.Arrays.fill(java.lang.Object[], java.lang.Object):void}
      ClspMth{java.util.Arrays.fill(int[], int):void}
      ClspMth{java.util.Arrays.fill(float[], float):void}
      ClspMth{java.util.Arrays.fill(boolean[], boolean):void} */
    /* access modifiers changed from: package-private */
    public final void O00000o0() {
        SceneApi.O000OOOo o000OOOo = mScene;
        if (o000OOOo != null && o000OOOo.O00000oo != null) {
            this.O00000o = new boolean[mScene.O00000oo.size()];
            this.O00000oO = new int[mScene.O00000oo.size()];
            Arrays.fill(this.O00000o, false);
            Arrays.fill(this.O00000oO, (int) R.drawable.device_list_phone_no);
            for (int i = 0; i < mScene.O00000oo.size(); i++) {
                hnw.O000000o O000000o2 = hnw.O000000o(mScene.O00000oo.get(i));
                if (O000000o2.O00000Oo) {
                    this.O00000o[i] = true;
                }
                this.O00000oO[i] = O000000o2.f397O000000o;
            }
            if (mScene.O0000O0o != null) {
                this.O00000oo = new boolean[mScene.O0000O0o.size()];
                for (int i2 = 0; i2 < mScene.O0000O0o.size(); i2++) {
                    if (mScene.O0000O0o.get(i2).O00000o0 == null && mScene.O0000O0o.get(i2).O00000oO == null && mScene.O0000O0o.get(i2).O00000oo == null) {
                        this.O00000oo[i2] = true;
                    } else {
                        String str = null;
                        if (mScene.O0000O0o.get(i2).O00000o0 != null) {
                            str = mScene.O0000O0o.get(i2).O00000o0.f11122O000000o;
                        }
                        if (mScene.O0000O0o.get(i2).O00000oO != null) {
                            str = mScene.O0000O0o.get(i2).O00000oO.f11122O000000o;
                        }
                        if (mScene.O0000O0o.get(i2).O00000oo != null) {
                            str = mScene.O0000O0o.get(i2).O00000oo.f11122O000000o;
                        }
                        if (str != null) {
                            Device O000000o3 = fno.O000000o().O000000o(str);
                            if (O000000o3 == null) {
                                O000000o3 = fno.O000000o().O00000Oo(str);
                            }
                            this.O00000oo[i2] = O000000o3 != null && O000000o3.did.equalsIgnoreCase(str) && O000000o3.isOnline;
                        } else {
                            this.O00000oo[i2] = true;
                        }
                    }
                }
            }
        }
    }

    public void onResume() {
        super.onResume();
        if (this.O0000oO) {
            O00000o();
        } else {
            this.O0000oO = true;
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 1000 && intent.getBooleanExtra("scene_deleted", false)) {
            finish();
        } else if (i2 == -1) {
            O00000o();
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000o() {
        boolean z;
        O00000o0();
        if (TextUtils.isEmpty(this.O00000Oo) || !mScene.O000000o(this.O00000o0)) {
            this.mConfirmBtn.setVisibility(0);
            this.mModuleA4Commit.setVisibility(8);
            this.mConfirmBtn.setText((int) R.string.confirm);
        } else {
            this.mModuleA4Commit.setVisibility(0);
            this.mConfirmBtn.setVisibility(8);
            this.mModuleA4Commit.setText("");
            this.mModuleA4Commit.setBackgroundResource(R.drawable.std_tittlebar_main_device_more);
        }
        O0000OOo();
        for (int size = mScene.O00000oo.size() - 1; size >= 0; size--) {
            if (size != mScene.O00000oo.size() - 1 && (mScene.O00000oo.get(size).O0000O0o instanceof SceneApi.O000O0o0)) {
                int i = size + 1;
                if (mScene.O00000oo.get(i).O0000O0o instanceof SceneApi.O000O0o0) {
                    mScene.O00000oo.get(size).O0000O0o.O00000oo += mScene.O00000oo.get(i).O0000O0o.O00000oo;
                    mScene.O00000oo.remove(i);
                }
            }
        }
        if (mScene.O0000O0o.size() > 0 || this.mNoDeviceConditionItems.size() > 0) {
            this.mNoConditionTitle.setVisibility(8);
            this.mDivider2.setVisibility(8);
            this.mConfirmBtn.setEnabled(true);
        } else {
            this.mNoConditionTitle.setVisibility(0);
            this.mNoConditionTitle.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.AnonymousClass13 */

                public final void onClick(View view) {
                    SmartHomeSceneCreateEditActivity.this.O000000o();
                }
            });
            this.mDivider2.setVisibility(0);
            this.mConfirmBtn.setEnabled(false);
        }
        if (mScene.O00000oo.size() > 0 || this.mNoDeviceActionItems.size() > 0) {
            if (mScene.O00000oo.size() != 1 || !(mScene.O00000oo.get(0).O0000O0o instanceof SceneApi.O000O0o0)) {
                this.mConfirmBtn.setEnabled(true);
            } else {
                this.mConfirmBtn.setEnabled(false);
            }
            this.mNoActionTitle.setVisibility(8);
            this.mDivider4.setVisibility(0);
        } else {
            this.mNoActionTitle.setVisibility(0);
            this.mNoActionTitle.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.AnonymousClass14 */

                public final void onClick(View view) {
                    SmartHomeSceneCreateEditActivity.this.O00000Oo();
                }
            });
            this.mDivider4.setVisibility(0);
            this.mConfirmBtn.setEnabled(false);
        }
        Iterator<SceneApi.O000000o> it = mScene.O0000O0o.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            SceneApi.O000000o next = it.next();
            if (next.O00000o0 != null && O000000o(next.O00000o0.O00000o)) {
                z = true;
                break;
            }
        }
        if (!z) {
            Iterator<SceneApi.Action> it2 = mScene.O00000oo.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                SceneApi.Action next2 = it2.next();
                if (next2.O00000oO != null && O000000o(next2.O00000oO)) {
                    z = true;
                    break;
                }
            }
        }
        if (!z || !TextUtils.isEmpty(this.O00000Oo)) {
            this.O0000o0O.setVisibility(8);
        } else {
            this.O0000o0O.setVisibility(0);
        }
        O0000O0o();
        this.O0000O0o.notifyDataSetChanged();
        this.O0000OOo.notifyDataSetChanged();
    }

    private void O0000O0o() {
        int countConditionTime = countConditionTime();
        if (mScene.O0000oOO || isNewScene) {
            this.mExeTimeRL.setVisibility(0);
            this.mExeTimeRL.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.AnonymousClass15 */

                public final void onClick(View view) {
                    gsy.O000000o(LogType.SCENE, "scene", "启动生效时间段页面");
                    SmartHomeSceneCreateEditActivity.this.startActivity(new Intent(SmartHomeSceneCreateEditActivity.this.f10900O000000o, SceneCreateTimeEdit2Activity.class));
                }
            });
        } else if (countConditionTime == 1) {
            this.mExeTimeRL.setVisibility(0);
            if (this.O0000oO0 != null) {
                mScene.O0000oO = new SceneApi.O0000o0();
                mScene.O0000oO.f11125O000000o = this.O0000oO0.O00000oO;
                mScene.O0000oO.O00000Oo = this.O0000oO0.O00000oo;
                mScene.O0000oO.O00000oO = new int[this.O0000oO0.O0000Oo0.length];
                for (int i = 0; i < this.O0000oO0.O0000Oo0.length; i++) {
                    mScene.O0000oO.O00000oO[i] = this.O0000oO0.O0000Oo0[i];
                }
                this.O00000o0.O0000oO = new SceneApi.O0000o0();
                this.O00000o0.O0000oO.f11125O000000o = this.O0000oO0.O00000oO;
                this.O00000o0.O0000oO.O00000Oo = this.O0000oO0.O00000oo;
                this.O00000o0.O0000oO.O00000oO = new int[this.O0000oO0.O0000Oo0.length];
                for (int i2 = 0; i2 < this.O0000oO0.O0000Oo0.length; i2++) {
                    this.O00000o0.O0000oO.O00000oO[i2] = this.O0000oO0.O0000Oo0[i2];
                }
            }
            this.mExeTimeRL.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.AnonymousClass16 */

                public final void onClick(View view) {
                    gsy.O000000o(LogType.SCENE, "scene", "启动生效时间段页面");
                    SmartHomeSceneCreateEditActivity.this.startActivity(new Intent(SmartHomeSceneCreateEditActivity.this.f10900O000000o, SceneCreateTimeEdit2Activity.class));
                }
            });
        } else if (countConditionTime == 0) {
            this.mExeTimeRL.setVisibility(0);
            this.mExeTimeRL.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.AnonymousClass17 */

                public final void onClick(View view) {
                    gsy.O000000o(LogType.SCENE, "scene", "启动生效时间段页面");
                    SmartHomeSceneCreateEditActivity.this.startActivity(new Intent(SmartHomeSceneCreateEditActivity.this.f10900O000000o, SceneCreateTimeEdit2Activity.class));
                }
            });
        } else {
            this.mExeTimeRL.setVisibility(0);
            this.mExeTimeRL.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.AnonymousClass18 */

                public final void onClick(View view) {
                    SmartHomeSceneCreateEditActivity.this.showDeleteAllTimeDialog();
                }
            });
        }
        SceneApi.O000OOOo o000OOOo = mScene;
        if (o000OOOo == null || o000OOOo.O0000oO == null) {
            this.mExeTimeTV.setText((int) R.string.scene_exetime_all_day);
        } else if (mScene.O0000oO.f11125O000000o == mScene.O0000oO.O00000Oo && mScene.O0000oO.O00000o0 == mScene.O0000oO.O00000o) {
            this.mExeTimeTV.setText((int) R.string.scene_exetime_all_day);
        } else if (mScene.O0000oO.O00000Oo <= mScene.O0000oO.f11125O000000o) {
            TextView textView = this.mExeTimeTV;
            textView.setText(O000000o(mScene.O0000oO.f11125O000000o, mScene.O0000oO.O00000o0) + "-(" + getResources().getString(R.string.scene_exetime_second_day) + ")" + O000000o(mScene.O0000oO.O00000Oo, mScene.O0000oO.O00000o));
        } else {
            TextView textView2 = this.mExeTimeTV;
            textView2.setText(O000000o(mScene.O0000oO.f11125O000000o, mScene.O0000oO.O00000o0) + "-" + O000000o(mScene.O0000oO.O00000Oo, mScene.O0000oO.O00000o));
        }
        if (countConditionTime() > 1) {
            this.mExeTimeTV.setText((int) R.string.scene_exetime_no_set);
        }
    }

    private static boolean O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.equalsIgnoreCase("chuangmi.plug.mi") || str.equalsIgnoreCase("chuangmi.plug.v1") || str.equalsIgnoreCase("chuangmi.plug.v2") || str.equalsIgnoreCase("chuangmi.plug.m1") || str.equalsIgnoreCase("lumi.plug.v1") || str.equalsIgnoreCase("chuangmi.ir.v2") || str.equalsIgnoreCase("qmi.powerstrip.v1") || str.equalsIgnoreCase("zimi.powerstrip.v2")) {
            return true;
        }
        return false;
    }

    private void O0000OOo() {
        this.mConditionTitle.setCompoundDrawablesWithIntrinsicBounds(0, 0, (int) R.drawable.std_home_icon_drop_down_arrow_r, 0);
        this.mConditionTitle.setCompoundDrawablePadding(gpc.O000000o(3.0f));
        this.mConditionTitle.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.AnonymousClass19 */

            public final void onClick(View view) {
                if (!SmartHomeSceneCreateEditActivity.this.mDisableScene) {
                    if (SmartHomeSceneCreateEditActivity.this.mExpressView.getVisibility() == 8) {
                        ViewGroup.LayoutParams layoutParams = SmartHomeSceneCreateEditActivity.this.mExpressView.getLayoutParams();
                        layoutParams.height = SmartHomeSceneCreateEditActivity.this.mContainer.getHeight() - SmartHomeSceneCreateEditActivity.this.mTitleBar.getHeight();
                        SmartHomeSceneCreateEditActivity.this.mExpressView.setLayoutParams(layoutParams);
                        SmartHomeSceneCreateEditActivity.this.mExpressView.setVisibility(0);
                        if (SmartHomeSceneCreateEditActivity.mScene.O0000Ooo == 0) {
                            SmartHomeSceneCreateEditActivity.this.mExpressAll.setSelected(true);
                            SmartHomeSceneCreateEditActivity.this.mExpressAny.setSelected(false);
                        } else {
                            SmartHomeSceneCreateEditActivity.this.mExpressAll.setSelected(false);
                            SmartHomeSceneCreateEditActivity.this.mExpressAny.setSelected(true);
                        }
                        if (hpq.O000000o().O0000O0o || SmartHomeSceneCreateEditActivity.mScene.O0000Ooo == 0) {
                            SmartHomeSceneCreateEditActivity.this.mExpressAll.setEnabled(true);
                            SmartHomeSceneCreateEditActivity.this.mLockView.setVisibility(8);
                            SmartHomeSceneCreateEditActivity.this.mExpressAll.setOnClickListener(new View.OnClickListener() {
                                /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.AnonymousClass19.AnonymousClass1 */

                                public final void onClick(View view) {
                                    SmartHomeSceneCreateEditActivity.mScene.O0000Ooo = 0;
                                    SmartHomeSceneCreateEditActivity.this.mConditionTitle.setText((int) R.string.scene_all_condition_satified);
                                    SmartHomeSceneCreateEditActivity.this.mExpressView.setVisibility(8);
                                    SmartHomeSceneCreateEditActivity.this.O00000o();
                                }
                            });
                            return;
                        }
                        SmartHomeSceneCreateEditActivity.this.mExpressAll.setEnabled(true);
                        SmartHomeSceneCreateEditActivity.this.mLockView.setVisibility(0);
                        SmartHomeSceneCreateEditActivity.this.mExpressAll.setOnClickListener(new View.OnClickListener() {
                            /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.AnonymousClass19.AnonymousClass2 */

                            public final void onClick(View view) {
                                izb.O000000o(SmartHomeSceneCreateEditActivity.this, (int) R.string.scene_unclickable_toast_1, 0).show();
                            }
                        });
                        return;
                    }
                    SmartHomeSceneCreateEditActivity.this.mExpressView.setVisibility(8);
                }
            }
        });
        if (mScene.O0000Ooo == 0) {
            this.mConditionTitle.setText((int) R.string.scene_add_condition);
        } else {
            this.mConditionTitle.setText((int) R.string.scene_any_condition_satified);
        }
        this.O0000o0O = (TextView) findViewById(R.id.warnning_text);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.O0000o0O.getText().toString());
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getResources().getColor(R.color.mj_color_red_normal));
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(getResources().getColor(R.color.mj_color_black_50_transparent));
        spannableStringBuilder.setSpan(foregroundColorSpan, 0, 5, 33);
        spannableStringBuilder.setSpan(foregroundColorSpan2, 5, this.O0000o0O.getText().toString().length(), 33);
        this.O0000o0O.setText(spannableStringBuilder);
    }

    /* JADX WARNING: Removed duplicated region for block: B:133:0x0314  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x032c  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0202  */
    public void initDefaultScenes() {
        boolean[] zArr;
        boolean[] zArr2;
        String str;
        String str2;
        mScene.O0000OOo = false;
        ArrayList<Device> arrayList = new ArrayList<>();
        arrayList.addAll(fno.O000000o().O0000O0o().values());
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((Device) arrayList.get(size)).isSubDevice()) {
                arrayList.remove(size);
            }
        }
        arrayList.addAll(fno.O000000o().O00000Oo().values());
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList<DefaultSceneItemSet> arrayList6 = this.mDefaultConditionSceneItems;
        if (arrayList6 == null || arrayList6.size() <= 0) {
            zArr = null;
        } else {
            this.mNoDeviceConditionItems.addAll(this.mDefaultConditionSceneItems);
            zArr = new boolean[this.mDefaultConditionSceneItems.size()];
        }
        ArrayList<DefaultSceneItemSet> arrayList7 = this.mDefaultActionSceneItems;
        if (arrayList7 == null || arrayList7.size() <= 0) {
            zArr2 = null;
        } else {
            this.mNoDeviceActionItems.addAll(this.mDefaultActionSceneItems);
            zArr2 = new boolean[this.mDefaultActionSceneItems.size()];
        }
        for (Device device : arrayList) {
            if (device.isOwner()) {
                if (this.mDefaultConditionSceneItems != null) {
                    int i = 0;
                    while (true) {
                        if (i >= this.mDefaultConditionSceneItems.size()) {
                            break;
                        }
                        DefaultSceneItemSet defaultSceneItemSet = this.mDefaultConditionSceneItems.get(i);
                        if (defaultSceneItemSet.O00000Oo == null || !DeviceFactory.O000000o(device.model, defaultSceneItemSet.O00000Oo)) {
                            i++;
                        } else {
                            if (defaultSceneItemSet.f11135O000000o.booleanValue()) {
                                arrayList2.add(device);
                                arrayList4.add(defaultSceneItemSet);
                            } else if (!zArr[i]) {
                                arrayList2.add(device);
                                arrayList4.add(defaultSceneItemSet);
                                zArr[i] = true;
                            }
                            this.mNoDeviceConditionItems.remove(defaultSceneItemSet);
                        }
                    }
                }
                if (this.mDefaultActionSceneItems != null) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= this.mDefaultActionSceneItems.size()) {
                            break;
                        }
                        DefaultSceneItemSet defaultSceneItemSet2 = this.mDefaultActionSceneItems.get(i2);
                        if (defaultSceneItemSet2.O00000Oo == null || TextUtils.isEmpty(device.model) || !DeviceFactory.O000000o(device.model, defaultSceneItemSet2.O00000Oo)) {
                            i2++;
                        } else {
                            if (defaultSceneItemSet2.f11135O000000o.booleanValue()) {
                                arrayList3.add(device);
                                arrayList5.add(defaultSceneItemSet2);
                            } else if (!zArr2[i2]) {
                                arrayList3.add(device);
                                arrayList5.add(defaultSceneItemSet2);
                                zArr2[i2] = true;
                            }
                            this.mNoDeviceActionItems.remove(defaultSceneItemSet2);
                        }
                    }
                }
            }
        }
        if (mScene.O0000O0o.size() == 0) {
            mScene.O0000OOo = true;
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                Device device2 = (Device) arrayList2.get(i3);
                hox hox = (hod.O0000OoO().O00000Oo(device2.model, device2.did) == null || hod.O0000OoO().O00000Oo(device2.model, device2.did).O00000o.size() <= 0) ? null : new hox(device2, null);
                if (hox != null) {
                    if (((DefaultSceneItemSet) arrayList4.get(0)).O00000o0 != null) {
                        RecommendSceneItem.Key key = (((DefaultSceneItemSet) arrayList4.get(0)).O00000o0 == null || ((DefaultSceneItemSet) arrayList4.get(0)).O00000o0.length <= 0) ? null : ((DefaultSceneItemSet) arrayList4.get(0)).O00000o0[0];
                        if (key != null) {
                            if (!key.mKey.contains(((Device) arrayList2.get(0)).model)) {
                                String[] strArr = ((DefaultSceneItemSet) arrayList4.get(0)).O00000Oo;
                                int length = strArr.length;
                                int i4 = 0;
                                while (true) {
                                    if (i4 >= length) {
                                        break;
                                    }
                                    String str3 = strArr[i4];
                                    if (key.mKey.contains(str3)) {
                                        str2 = String.valueOf(key.mKey).replace(str3, ((Device) arrayList2.get(0)).model);
                                        break;
                                    }
                                    i4++;
                                }
                            } else {
                                str2 = key.mKey;
                            }
                            if (str2 != null) {
                                mScene.O0000O0o.add(hox.O000000o(hox.O00000oO()[0], (Intent) null));
                            } else {
                                int O000000o2 = hox.O000000o(str2, key.mValues);
                                if (O000000o2 != -1) {
                                    mScene.O0000O0o.add(hox.O000000o(hox.O00000oO()[O000000o2], (Intent) null));
                                } else {
                                    mScene.O0000O0o.add(hox.O000000o(hox.O00000oO()[0], (Intent) null));
                                }
                            }
                        }
                        str2 = null;
                        if (str2 != null) {
                        }
                    } else {
                        mScene.O0000O0o.add(hox.O000000o(hox.O00000oO()[0], (Intent) null));
                    }
                    if (!this.O0000Ooo) {
                        this.mNoDeviceConditionItems.clear();
                    }
                }
            }
            for (SceneApi.O000000o next : mScene.O0000O0o) {
                hpq.O000000o().O000000o(hod.O0000OoO().O000000o(next.O0000Ooo));
                hpq.O000000o().O00000Oo(hod.O0000OoO().O00000Oo(next.O0000Ooo));
            }
        } else {
            mScene.O0000OOo = false;
        }
        if (mScene.O00000oo.size() == 0) {
            for (int i5 = 0; i5 < arrayList3.size(); i5++) {
                hnm O000000o3 = hnu.O000000o(arrayList3.get(i5));
                if (O000000o3 != null) {
                    if (((DefaultSceneItemSet) arrayList5.get(i5)).O00000o0 != null) {
                        RecommendSceneItem.Key key2 = (((DefaultSceneItemSet) arrayList5.get(0)).O00000o0 == null || ((DefaultSceneItemSet) arrayList5.get(0)).O00000o0.length <= 0) ? null : ((DefaultSceneItemSet) arrayList5.get(0)).O00000o0[0];
                        if (key2 != null) {
                            if (!key2.mKey.contains(((Device) arrayList3.get(i5)).model)) {
                                String[] strArr2 = ((DefaultSceneItemSet) arrayList5.get(i5)).O00000Oo;
                                int length2 = strArr2.length;
                                int i6 = 0;
                                while (true) {
                                    if (i6 >= length2) {
                                        break;
                                    }
                                    String str4 = strArr2[i6];
                                    if (key2.mKey.contains(str4)) {
                                        str = String.valueOf(key2.mKey).replace(str4, ((Device) arrayList3.get(i5)).model);
                                        break;
                                    }
                                    i6++;
                                }
                            } else {
                                str = key2.mKey;
                            }
                            if (str != null) {
                                mScene.O00000oo.add(O000000o3.O000000o(O000000o3.f19096O000000o[0], O000000o3.O00000Oo[0], arrayList3.get(i5), null));
                            } else {
                                Object obj = key2.mValues;
                                arrayList3.get(i5);
                                int O000000o4 = O000000o3.O000000o(str, obj);
                                if (O000000o4 != -1) {
                                    mScene.O00000oo.add(O000000o3.O000000o(O000000o3.f19096O000000o[O000000o4], O000000o3.O00000Oo[O000000o4], arrayList3.get(i5), null));
                                } else {
                                    mScene.O00000oo.add(O000000o3.O000000o(O000000o3.f19096O000000o[0], O000000o3.O00000Oo[0], arrayList3.get(i5), null));
                                }
                            }
                        }
                        str = null;
                        if (str != null) {
                        }
                    } else {
                        mScene.O00000oo.add(O000000o3.O000000o(O000000o3.f19096O000000o[0], O000000o3.O00000Oo[0], arrayList3.get(i5), null));
                    }
                }
            }
            for (SceneApi.Action next2 : mScene.O00000oo) {
                hpq.O000000o().O000000o(hod.O0000OoO().O000000o(next2.O00000o));
                hpq.O000000o().O00000Oo(hod.O0000OoO().O00000Oo(next2.O00000o));
            }
            if (arrayList3.size() > 0 && !this.O0000o00) {
                this.mNoDeviceActionItems.clear();
            }
        }
        if (mScene.O0000O0o.size() > 0) {
            this.O00000o0.O0000O0o.clear();
            for (SceneApi.O000000o O000000o5 : mScene.O0000O0o) {
                try {
                    this.O00000o0.O0000O0o.add(SceneApi.O000000o.O000000o(O000000o5.O000000o()));
                } catch (JSONException unused) {
                }
            }
        }
        if (mScene.O00000oo.size() > 0) {
            this.O00000o0.O00000oo.clear();
            for (SceneApi.Action O000000o6 : mScene.O00000oo) {
                try {
                    this.O00000o0.O00000oo.add(SceneApi.Action.O000000o(O000000o6.O000000o()));
                } catch (JSONException unused2) {
                }
            }
        }
    }

    public void showDeleteAllTimeDialog() {
        new MLAlertDialog.Builder(this).O00000Oo((int) R.string.delete_old_time_span_tips).O000000o((int) R.string.delete, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.AnonymousClass23 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                for (SceneApi.O000000o next : SmartHomeSceneCreateEditActivity.mScene.O0000O0o) {
                    if (next.O00000o0 != null) {
                        next.O00000o0.O00000oO = -1;
                        next.O00000o0.O00000oo = -1;
                        next.O00000o0.O0000O0o = -1;
                        next.O00000o0.O0000OOo = -1;
                        next.O00000o0.O0000Oo0 = null;
                    }
                }
                if (SmartHomeSceneCreateEditActivity.mScene.O0000oO == null) {
                    SmartHomeSceneCreateEditActivity.mScene.O0000oO = new SceneApi.O0000o0();
                }
                SmartHomeSceneCreateEditActivity.mScene.O0000oOO = true;
                SmartHomeSceneCreateEditActivity.this.mExeTimeRL.setVisibility(0);
                SmartHomeSceneCreateEditActivity.this.mExeTimeRL.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.AnonymousClass23.AnonymousClass1 */

                    public final void onClick(View view) {
                        gsy.O000000o(LogType.SCENE, "scene", "启动生效时间段页面");
                        SmartHomeSceneCreateEditActivity.this.startActivity(new Intent(SmartHomeSceneCreateEditActivity.this.f10900O000000o, SceneCreateTimeEdit2Activity.class));
                    }
                });
                SmartHomeSceneCreateEditActivity.this.O00000o();
            }
        }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneCreateEditActivity.AnonymousClass22 */

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }).O00000o().show();
    }

    private static String O000000o(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        if (i >= 0 && i <= 9) {
            sb.append("0");
        }
        sb.append(i);
        sb.append(":");
        if (i2 >= 0 && i2 <= 9) {
            sb.append("0");
        }
        sb.append(i2);
        return sb.toString();
    }
}
