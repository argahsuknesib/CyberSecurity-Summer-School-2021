package com.xiaomi.smarthome.scene.activity;

import _m_j.eyk;
import _m_j.eys;
import _m_j.fbs;
import _m_j.fbt;
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
import _m_j.hpq;
import _m_j.hsl;
import _m_j.izb;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.api.DeviceApi;
import com.xiaomi.smarthome.device.api.RecommendSceneItem;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.scene.api.SceneApi;
import com.xiaomi.smarthome.scene.bean.DefaultSceneItemSet;
import com.xiaomi.smarthome.scene.bean.LAUNCH_TYPE;
import com.xiaomi.smarthome.scene.model.CorntabUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class GoLeaveHomeSceneCreateEditActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    boolean[] f10690O000000o;
    View O00000Oo;
    MLAlertDialog O00000o = null;
    View O00000o0;
    private ArrayList<DefaultSceneItemSet> O00000oO;
    private ArrayList<DefaultSceneItemSet> O00000oo;
    private int[] O0000O0o;
    private ActionsAdapter O0000OOo;
    public boolean isGoHomeRecommend;
    public boolean isNewScene;
    @BindView(6323)
    ListView mActionListView;
    @BindView(5070)
    View mAddAction;
    @BindView(5074)
    View mAddCondition;
    @BindView(5925)
    SwitchButton mCheckBox;
    public ConditionsAdapter mConditionAdapter;
    @BindView(6243)
    LinearLayout mConditionExpress;
    @BindView(5274)
    View mConditionLayout;
    @BindView(5275)
    ListView mConditionListView;
    @BindView(5277)
    TextView mConditionTitle;
    @BindView(5837)
    Button mConfirmBtn;
    @BindView(6242)
    LinearLayout mContainer;
    public Context mContext;
    @BindView(5381)
    View mDivider2;
    @BindView(5383)
    View mDivider4;
    @BindView(5836)
    TextView mModuleA4Commit;
    @BindView(5842)
    TextView mModuleA4ReturnTitle;
    @BindView(5897)
    TextView mNoActionTitle;
    @BindView(5898)
    TextView mNoConditionTitle;
    public ArrayList<DefaultSceneItemSet> mNoDeviceActionItems = new ArrayList<>();
    public boolean[] mOnlineItems;
    public XQProgressDialog mPD;
    public SceneApi.O000OOOo mScene;
    public String mSceneID;
    public SceneApi.O000OOOo mSceneSrc;
    @BindView(5927)
    View mSwitchContainer;
    @BindView(6322)
    View mTaskLayout;
    @BindView(6370)
    View mTitleBar;
    @BindView(6579)
    View mViewTag;

    public class ActionsAdapter_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private ActionsAdapter f10720O000000o;

        public ActionsAdapter_ViewBinding(ActionsAdapter actionsAdapter, View view) {
            this.f10720O000000o = actionsAdapter;
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
            ActionsAdapter actionsAdapter = this.f10720O000000o;
            if (actionsAdapter != null) {
                this.f10720O000000o = null;
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
        private ConditionsAdapter f10731O000000o;

        public ConditionsAdapter_ViewBinding(ConditionsAdapter conditionsAdapter, View view) {
            this.f10731O000000o = conditionsAdapter;
            conditionsAdapter.mIcon = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.icon, "field 'mIcon'", SimpleDraweeView.class);
            conditionsAdapter.mName = (TextView) Utils.findRequiredViewAsType(view, R.id.name, "field 'mName'", TextView.class);
            conditionsAdapter.mKeyName = (TextView) Utils.findRequiredViewAsType(view, R.id.key_name, "field 'mKeyName'", TextView.class);
            conditionsAdapter.mTimeSpan = (TextView) Utils.findRequiredViewAsType(view, R.id.add_timesp, "field 'mTimeSpan'", TextView.class);
            conditionsAdapter.mTimeSetButton = (ImageView) Utils.findRequiredViewAsType(view, R.id.set_time_btn, "field 'mTimeSetButton'", ImageView.class);
            conditionsAdapter.mOffline = (TextView) Utils.findRequiredViewAsType(view, R.id.offline, "field 'mOffline'", TextView.class);
            conditionsAdapter.mBuyButton = (TextView) Utils.findRequiredViewAsType(view, R.id.buy_button, "field 'mBuyButton'", TextView.class);
        }

        public void unbind() {
            ConditionsAdapter conditionsAdapter = this.f10731O000000o;
            if (conditionsAdapter != null) {
                this.f10731O000000o = null;
                conditionsAdapter.mIcon = null;
                conditionsAdapter.mName = null;
                conditionsAdapter.mKeyName = null;
                conditionsAdapter.mTimeSpan = null;
                conditionsAdapter.mTimeSetButton = null;
                conditionsAdapter.mOffline = null;
                conditionsAdapter.mBuyButton = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x02e2  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0214  */
    public void onCreate(Bundle bundle) {
        View findViewById;
        String str;
        boolean[] zArr;
        String str2;
        super.onCreate(bundle);
        setContentView((int) R.layout.smarthome_scene_create_edit);
        ButterKnife.bind(this);
        if (!hod.O0000OoO().O0000Oo0) {
            finish();
            return;
        }
        this.mContext = this;
        Intent intent = getIntent();
        this.mSceneID = intent.getStringExtra("scene_id");
        this.O00000oO = intent.getParcelableArrayListExtra("extra_default_action_items");
        this.O00000oo = intent.getParcelableArrayListExtra("extra_default_condition_items");
        this.isGoHomeRecommend = intent.getBooleanExtra("go_home_recommend_flag", true);
        String str3 = "";
        if (!TextUtils.isEmpty(this.mSceneID)) {
            this.mSceneSrc = hod.O0000OoO().O00000Oo(this.mSceneID);
            SceneApi.O000OOOo o000OOOo = this.mSceneSrc;
            if (o000OOOo != null) {
                try {
                    this.mScene = SceneApi.O000OOOo.O000000o(o000OOOo.O000000o(), false);
                    hod.O0000OoO();
                    this.isGoHomeRecommend = hod.O000000o(this.mSceneSrc);
                    this.isNewScene = false;
                } catch (JSONException e) {
                    gsy.O00000o0(LogType.GENERAL, str3, e.getMessage());
                }
            }
        } else {
            if (this.isGoHomeRecommend) {
                HomeSceneFactory homeSceneFactory = HomeSceneFactory.INSTANCE;
                hod.O0000OoO();
                this.mScene = homeSceneFactory.createDefaultGoHomeScene(this, null);
                HomeSceneFactory homeSceneFactory2 = HomeSceneFactory.INSTANCE;
                hod.O0000OoO();
                this.mSceneSrc = homeSceneFactory2.createDefaultGoHomeScene(this, null);
            } else {
                HomeSceneFactory homeSceneFactory3 = HomeSceneFactory.INSTANCE;
                hod.O0000OoO();
                this.mScene = homeSceneFactory3.createDefaultLeaveHomeScene(this, null);
                HomeSceneFactory homeSceneFactory4 = HomeSceneFactory.INSTANCE;
                hod.O0000OoO();
                this.mSceneSrc = homeSceneFactory4.createDefaultLeaveHomeScene(this, null);
            }
            this.isNewScene = true;
            this.mScene.O0000OOo = false;
            ArrayList<Device> arrayList = new ArrayList<>(fno.O000000o().O0000O0o().values());
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((Device) arrayList.get(size)).isSubDevice()) {
                    arrayList.remove(size);
                }
            }
            arrayList.addAll(fno.O000000o().O00000Oo().values());
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList<DefaultSceneItemSet> arrayList4 = this.O00000oO;
            if (arrayList4 == null || arrayList4.size() <= 0) {
                zArr = null;
            } else {
                this.mNoDeviceActionItems.addAll(this.O00000oO);
                zArr = new boolean[this.O00000oO.size()];
            }
            for (Device device : arrayList) {
                if (device.isOwner() && this.O00000oO != null) {
                    int i = 0;
                    while (true) {
                        if (i >= this.O00000oO.size()) {
                            break;
                        }
                        DefaultSceneItemSet defaultSceneItemSet = this.O00000oO.get(i);
                        if (defaultSceneItemSet.O00000Oo == null || !DeviceFactory.O000000o(device.model, defaultSceneItemSet.O00000Oo)) {
                            i++;
                        } else {
                            if (defaultSceneItemSet.f11135O000000o.booleanValue()) {
                                arrayList2.add(device);
                                arrayList3.add(defaultSceneItemSet);
                            } else if (!zArr[i]) {
                                arrayList2.add(device);
                                arrayList3.add(defaultSceneItemSet);
                                zArr[i] = true;
                            }
                            this.mNoDeviceActionItems.remove(defaultSceneItemSet);
                        }
                    }
                }
            }
            if (this.mScene.O00000oo.size() == 0) {
                for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                    hnm O000000o2 = hnu.O000000o(arrayList2.get(i2));
                    if (O000000o2 != null) {
                        if (((DefaultSceneItemSet) arrayList3.get(i2)).O00000o0 != null) {
                            RecommendSceneItem.Key key = (((DefaultSceneItemSet) arrayList3.get(0)).O00000o0 == null || ((DefaultSceneItemSet) arrayList3.get(0)).O00000o0.length <= 0) ? null : ((DefaultSceneItemSet) arrayList3.get(0)).O00000o0[0];
                            if (key != null) {
                                if (!key.mKey.contains(((Device) arrayList2.get(i2)).model)) {
                                    String[] strArr = ((DefaultSceneItemSet) arrayList3.get(i2)).O00000Oo;
                                    int length = strArr.length;
                                    int i3 = 0;
                                    while (true) {
                                        if (i3 >= length) {
                                            break;
                                        }
                                        String str4 = strArr[i3];
                                        if (key.mKey.contains(str4)) {
                                            str2 = String.valueOf(key.mKey).replace(str4, ((Device) arrayList2.get(i2)).model);
                                            break;
                                        }
                                        i3++;
                                    }
                                } else {
                                    str2 = key.mKey;
                                }
                                if (str2 != null) {
                                    this.mScene.O00000oo.add(O000000o2.O000000o(O000000o2.f19096O000000o[0], O000000o2.O00000Oo[0], arrayList2.get(i2), null));
                                } else {
                                    Object obj = key.mValues;
                                    arrayList2.get(i2);
                                    int O000000o3 = O000000o2.O000000o(str2, obj);
                                    if (O000000o3 != -1) {
                                        this.mScene.O00000oo.add(O000000o2.O000000o(O000000o2.f19096O000000o[O000000o3], O000000o2.O00000Oo[O000000o3], arrayList2.get(i2), null));
                                    } else {
                                        this.mScene.O00000oo.add(O000000o2.O000000o(O000000o2.f19096O000000o[0], O000000o2.O00000Oo[0], arrayList2.get(i2), null));
                                    }
                                }
                            }
                            str2 = null;
                            if (str2 != null) {
                            }
                        } else {
                            this.mScene.O00000oo.add(O000000o2.O000000o(O000000o2.f19096O000000o[0], O000000o2.O00000Oo[0], arrayList2.get(i2), null));
                        }
                    }
                }
            }
            if (this.mScene.O00000oo.size() > 0) {
                this.mSceneSrc.O00000oo.clear();
                for (SceneApi.Action O000000o4 : this.mScene.O00000oo) {
                    try {
                        this.mSceneSrc.O00000oo.add(SceneApi.Action.O000000o(O000000o4.O000000o()));
                    } catch (JSONException unused) {
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(this.mSceneID)) {
            if (!this.mScene.O00000Oo.isEmpty()) {
                str = this.mScene.O00000Oo;
            }
            this.mModuleA4ReturnTitle.setText(str3);
            this.mConditionTitle.setText((int) R.string.scene_any_condition_satified);
            O00000oO();
            findViewById = findViewById(R.id.module_a_4_return_btn);
            if (findViewById != null) {
                findViewById.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.AnonymousClass15 */

                    public final void onClick(View view) {
                        GoLeaveHomeSceneCreateEditActivity.this.tryToBack();
                    }
                });
            }
            this.mConditionAdapter = new ConditionsAdapter();
            this.O0000OOo = new ActionsAdapter();
            this.mConditionListView.setAdapter((ListAdapter) this.mConditionAdapter);
            this.mActionListView.setAdapter((ListAdapter) this.O0000OOo);
            this.mConditionExpress.setVisibility(8);
            this.mDivider2.setVisibility(8);
            this.mNoConditionTitle.setVisibility(8);
            this.mModuleA4Commit.setVisibility(8);
            this.mConfirmBtn.setText((int) R.string.confirm);
            this.mConfirmBtn.setVisibility(0);
            this.mConfirmBtn.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.AnonymousClass16 */

                public final void onClick(View view) {
                    GoLeaveHomeSceneCreateEditActivity.this.completeScene();
                }
            });
            this.mAddAction.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.AnonymousClass17 */

                public final void onClick(View view) {
                    GoLeaveHomeSceneCreateEditActivity.this.O00000Oo();
                }
            });
            this.mAddCondition.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.AnonymousClass18 */

                public final void onClick(View view) {
                    GoLeaveHomeSceneCreateEditActivity.this.O000000o();
                }
            });
            this.mConditionLayout.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.AnonymousClass19 */

                public final void onClick(View view) {
                    GoLeaveHomeSceneCreateEditActivity.this.O000000o();
                }
            });
            this.mTaskLayout.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.AnonymousClass20 */

                public final void onClick(View view) {
                    GoLeaveHomeSceneCreateEditActivity.this.O00000Oo();
                }
            });
            this.mCheckBox.setChecked(this.mSceneSrc.O0000Oo0);
            this.mCheckBox.setOnPerformCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.AnonymousClass21 */

                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    GoLeaveHomeSceneCreateEditActivity.this.mSceneSrc.O0000Oo0 = z;
                    GoLeaveHomeSceneCreateEditActivity.this.mScene.O0000Oo0 = z;
                    if (!TextUtils.isEmpty(GoLeaveHomeSceneCreateEditActivity.this.mSceneID)) {
                        final XQProgressDialog O000000o2 = XQProgressDialog.O000000o(GoLeaveHomeSceneCreateEditActivity.this.mContext, null, GoLeaveHomeSceneCreateEditActivity.this.getString(R.string.smarthome_scene_saving_scene));
                        if (eys.f15955O000000o) {
                            hob O000000o3 = hob.O000000o();
                            GoLeaveHomeSceneCreateEditActivity.this.getContext();
                            O000000o3.O000000o(GoLeaveHomeSceneCreateEditActivity.this.mSceneSrc, new fsm<Void, fso>() {
                                /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.AnonymousClass21.AnonymousClass1 */

                                public final void onFailure(fso fso) {
                                    O000000o2.dismiss();
                                    izb.O000000o(GoLeaveHomeSceneCreateEditActivity.this.mContext, (int) R.string.smarthome_scene_update_fail, 0).show();
                                }

                                public final /* synthetic */ void onSuccess(Object obj) {
                                    O000000o2.dismiss();
                                }
                            });
                        }
                    }
                }
            });
            if (!TextUtils.isEmpty(this.mSceneID) || hnw.O00000Oo(this.mScene)) {
                this.mSwitchContainer.setVisibility(8);
            } else {
                this.mSwitchContainer.setVisibility(0);
                return;
            }
        } else {
            str = getString(this.isGoHomeRecommend ? R.string.condition_come_home : R.string.condition_leave_home);
        }
        str3 = str;
        this.mModuleA4ReturnTitle.setText(str3);
        this.mConditionTitle.setText((int) R.string.scene_any_condition_satified);
        O00000oO();
        findViewById = findViewById(R.id.module_a_4_return_btn);
        if (findViewById != null) {
        }
        this.mConditionAdapter = new ConditionsAdapter();
        this.O0000OOo = new ActionsAdapter();
        this.mConditionListView.setAdapter((ListAdapter) this.mConditionAdapter);
        this.mActionListView.setAdapter((ListAdapter) this.O0000OOo);
        this.mConditionExpress.setVisibility(8);
        this.mDivider2.setVisibility(8);
        this.mNoConditionTitle.setVisibility(8);
        this.mModuleA4Commit.setVisibility(8);
        this.mConfirmBtn.setText((int) R.string.confirm);
        this.mConfirmBtn.setVisibility(0);
        this.mConfirmBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.AnonymousClass16 */

            public final void onClick(View view) {
                GoLeaveHomeSceneCreateEditActivity.this.completeScene();
            }
        });
        this.mAddAction.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.AnonymousClass17 */

            public final void onClick(View view) {
                GoLeaveHomeSceneCreateEditActivity.this.O00000Oo();
            }
        });
        this.mAddCondition.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.AnonymousClass18 */

            public final void onClick(View view) {
                GoLeaveHomeSceneCreateEditActivity.this.O000000o();
            }
        });
        this.mConditionLayout.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.AnonymousClass19 */

            public final void onClick(View view) {
                GoLeaveHomeSceneCreateEditActivity.this.O000000o();
            }
        });
        this.mTaskLayout.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.AnonymousClass20 */

            public final void onClick(View view) {
                GoLeaveHomeSceneCreateEditActivity.this.O00000Oo();
            }
        });
        this.mCheckBox.setChecked(this.mSceneSrc.O0000Oo0);
        this.mCheckBox.setOnPerformCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.AnonymousClass21 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                GoLeaveHomeSceneCreateEditActivity.this.mSceneSrc.O0000Oo0 = z;
                GoLeaveHomeSceneCreateEditActivity.this.mScene.O0000Oo0 = z;
                if (!TextUtils.isEmpty(GoLeaveHomeSceneCreateEditActivity.this.mSceneID)) {
                    final XQProgressDialog O000000o2 = XQProgressDialog.O000000o(GoLeaveHomeSceneCreateEditActivity.this.mContext, null, GoLeaveHomeSceneCreateEditActivity.this.getString(R.string.smarthome_scene_saving_scene));
                    if (eys.f15955O000000o) {
                        hob O000000o3 = hob.O000000o();
                        GoLeaveHomeSceneCreateEditActivity.this.getContext();
                        O000000o3.O000000o(GoLeaveHomeSceneCreateEditActivity.this.mSceneSrc, new fsm<Void, fso>() {
                            /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.AnonymousClass21.AnonymousClass1 */

                            public final void onFailure(fso fso) {
                                O000000o2.dismiss();
                                izb.O000000o(GoLeaveHomeSceneCreateEditActivity.this.mContext, (int) R.string.smarthome_scene_update_fail, 0).show();
                            }

                            public final /* synthetic */ void onSuccess(Object obj) {
                                O000000o2.dismiss();
                            }
                        });
                    }
                }
            }
        });
        if (!TextUtils.isEmpty(this.mSceneID)) {
        }
        this.mSwitchContainer.setVisibility(8);
    }

    public void tryToBack() {
        SceneApi.O000OOOo o000OOOo;
        SceneApi.O000OOOo o000OOOo2 = this.mSceneSrc;
        boolean z = o000OOOo2 == null || (o000OOOo = this.mScene) == null || !o000OOOo.O000000o(o000OOOo2);
        SceneApi.O000OOOo o000OOOo3 = this.mScene;
        if (o000OOOo3 != null && o000OOOo3.O0000oo0.O00000oO.size() <= 0 && this.isNewScene) {
            z = false;
        }
        if (z) {
            new MLAlertDialog.Builder(this.mContext).O00000Oo((int) R.string.smarthome_scene_quit).O000000o((int) R.string.smarthome_scene_quest_ok, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.AnonymousClass10 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    GoLeaveHomeSceneCreateEditActivity.this.finish();
                }
            }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            }).O00000oo();
        } else {
            finish();
        }
    }

    public void onBackPressed() {
        tryToBack();
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        if (this.mScene.O0000O0o.size() >= 5) {
            izb.O000000o(this, (int) R.string.add_condition_error, 0).show();
            return;
        }
        Intent intent = new Intent(this.mContext, StartConditionActivity.class);
        intent.putParcelableArrayListExtra("extra_exclude_conditions", this.O00000oo);
        startActivityForResult(intent, 1);
        hpq.O000000o().O00000o0();
        hpq.O000000o().O000000o(this.mScene);
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo() {
        startActivityForResult(new Intent(this.mContext, SmartHomeSceneActionChooseActivity.class), 8193);
        hpq.O000000o().O00000o0();
        hpq.O000000o().O000000o(this.mScene);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0074  */
    public void completeScene() {
        boolean z;
        Iterator<SceneApi.Action> it = this.mScene.O00000oo.iterator();
        while (true) {
            z = true;
            if (!it.hasNext()) {
                break;
            }
            SceneApi.Action next = it.next();
            if (next.f11120O000000o == 1) {
                String str = null;
                Iterator<SceneApi.O000000o> it2 = this.mScene.O0000O0o.iterator();
                if (it2.hasNext()) {
                    str = hnw.O00000oO(ServiceApplication.getAppContext(), it2.next());
                }
                if (str == null && this.mScene.O0000oo0.O00000oO.size() > 0) {
                    if (this.isGoHomeRecommend) {
                        str = getString(R.string.condition_come_home);
                    } else {
                        str = getString(R.string.condition_leave_home);
                    }
                }
                ((SceneApi.O000OO) next.O0000O0o).O00000Oo = str;
            }
        }
        SceneApi.O000OOOo o000OOOo = this.mScene;
        if (o000OOOo != null && o000OOOo.O0000O0o != null) {
            Iterator<SceneApi.O000000o> it3 = this.mScene.O0000O0o.iterator();
            while (it3.hasNext() && it3.next().f11121O000000o != LAUNCH_TYPE.MIKEY) {
                while (it3.hasNext()) {
                    while (it3.hasNext()) {
                    }
                }
            }
        }
        if (fcb.O000000o().O000000o("show_scene_user_lincense") != -1) {
            z = false;
        }
        fcb.O000000o().O00000o0("show_scene_user_lincense");
        if (!z) {
            checkLicenseUpdate();
        } else {
            DeviceApi.getInstance().getUserLicenseConfig(ServiceApplication.getAppContext(), "scene_privacy_did", new fsm<Boolean, fso>() {
                /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.AnonymousClass2 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    if (((Boolean) obj).booleanValue()) {
                        GoLeaveHomeSceneCreateEditActivity.this.checkLicenseUpdate();
                    } else {
                        GoLeaveHomeSceneCreateEditActivity.this.showLicense(null);
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
            /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.AnonymousClass3 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                int optInt = jSONObject.optInt("pop_type");
                String optString = jSONObject.optString("change_log");
                String optString2 = jSONObject.optString("ver");
                if (optInt != 0) {
                    GoLeaveHomeSceneCreateEditActivity.this.showLicense(optString);
                    return;
                }
                if (!TextUtils.equals(O000000o2, optString2)) {
                    gpv.O00000Oo("scene_privacy_version", optString2);
                    DeviceApi.getInstance().setUserLicenseConfig(ServiceApplication.getAppContext(), "scene_privacy_did", "accept", null);
                }
                GoLeaveHomeSceneCreateEditActivity.this.doCompleteScene();
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
     arg types: [com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity, ?, ?, com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity$4]
     candidates:
      _m_j.gqb.O000000o(android.content.Context, int, int, java.lang.Object):java.lang.String
      _m_j.gqb.O000000o(android.app.Activity, java.util.Locale, int, android.widget.TextView):boolean
      _m_j.gqb.O000000o(android.content.Context, int, int, android.text.style.ClickableSpan):android.text.SpannableStringBuilder */
    public void showLicense(String str) {
        new MLAlertDialog.Builder(this).O00000o0().O000000o(gqb.O000000o((Context) this, (int) R.string.scene_user_license_title_1_underline, (int) R.string.scene_user_license_title_1_tpl, (ClickableSpan) new ClickableSpan() {
            /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.AnonymousClass4 */

            public final void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(GoLeaveHomeSceneCreateEditActivity.this.getResources().getColor(R.color.mj_color_class_text_27));
                textPaint.setUnderlineText(true);
            }

            public final void onClick(View view) {
                Locale O0000O0o = fju.O000000o().O0000O0o();
                if (O0000O0o == null) {
                    O0000O0o = Locale.getDefault();
                }
                String O000000o2 = flk.O000000o(O0000O0o);
                Context context = GoLeaveHomeSceneCreateEditActivity.this.getContext();
                eyk.O000000o(context, "https://g.home.mi.com/views/user-terms.html?locale=" + O000000o2 + "&type=scenePrivacy");
            }
        })).O000000o((int) R.string.scene_user_license_title).O000000o((int) R.string.smarthome_share_accept, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.$$Lambda$GoLeaveHomeSceneCreateEditActivity$BN_L6yv0U2AaErgphXbhzuzNeU */

            public final void onClick(DialogInterface dialogInterface, int i) {
                GoLeaveHomeSceneCreateEditActivity.this.O00000Oo(dialogInterface, i);
            }
        }).O00000Oo((int) R.string.smarthome_share_reject, $$Lambda$GoLeaveHomeSceneCreateEditActivity$SD0aRQabMWo1wYP0Ua66NLXC3Uw.INSTANCE).O000000o(false).O00000o().show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(DialogInterface dialogInterface, int i) {
        DeviceApi.getInstance().setUserLicenseConfig(ServiceApplication.getAppContext(), "scene_privacy_did", "accept", null);
        doCompleteScene();
    }

    public void doCompleteScene() {
        if (this.isNewScene) {
            if ((this.mScene.O0000O0o.size() > 0 || this.mScene.O0000oo0.O00000oO.size() > 0) && this.mScene.O00000oo.size() > 0) {
                saveNewScene();
            } else if (this.mScene.O0000O0o.size() == 0 && this.mScene.O0000oo0.O00000oO.size() == 0) {
                izb.O000000o(this.mContext, (int) R.string.smarthome_scene_add_start_condition, 0).show();
            } else {
                izb.O000000o(this.mContext, (int) R.string.smarthome_scene_set_fail_at_least_0, 0).show();
            }
        } else if ((this.mScene.O0000O0o.size() <= 0 && this.mScene.O0000oo0.O00000oO.size() <= 0) || this.mScene.O00000oo.size() <= 0) {
            izb.O000000o(this.mContext, (int) R.string.smarthome_scene_set_fail_at_least_0, 0).show();
        } else if (this.mScene.O000000o(this.mSceneSrc)) {
            finish();
        } else {
            final XQProgressDialog O000000o2 = XQProgressDialog.O000000o(this.mContext, null, getString(R.string.smarthome_scene_saving_scene));
            if (eys.f15955O000000o) {
                hob O000000o3 = hob.O000000o();
                getContext();
                O000000o3.O000000o(this.mScene, new fsm<Void, fso>() {
                    /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.AnonymousClass5 */

                    public final void onFailure(fso fso) {
                        O000000o2.dismiss();
                        izb.O000000o(GoLeaveHomeSceneCreateEditActivity.this.mContext, (int) R.string.smarthome_scene_update_fail, 0).show();
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        O000000o2.dismiss();
                        if (!TextUtils.isEmpty(GoLeaveHomeSceneCreateEditActivity.this.mSceneID)) {
                            hod.O0000OoO().O00000o0(GoLeaveHomeSceneCreateEditActivity.this.mSceneID);
                        }
                        hod.O0000OoO().O00000o0(GoLeaveHomeSceneCreateEditActivity.this.mScene);
                        hod.O0000OoO().O00000o();
                        GoLeaveHomeSceneCreateEditActivity.this.finish();
                    }
                });
                return;
            }
            O000000o2.dismiss();
        }
    }

    @OnClick({5836})
    public void gotoMorePage() {
        if (!TextUtils.isEmpty(this.mSceneID) && this.mScene.O000000o(this.mSceneSrc)) {
            Intent intent = new Intent(this, SceneMoreActivity.class);
            intent.putExtra("extra_scene_id", this.mSceneID);
            startActivityForResult(intent, 1000);
        }
    }

    public void saveNewScene() {
        if (this.mScene.O000000o(this.mSceneSrc)) {
            finish();
            return;
        }
        this.mPD = XQProgressDialog.O000000o(this.mContext, null, getString(R.string.smarthome_scene_saving_scene));
        if (eys.f15955O000000o) {
            hob.O000000o().O000000o(this, this.mScene, new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.AnonymousClass6 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    String optString = ((JSONObject) obj).optString("us_id");
                    GoLeaveHomeSceneCreateEditActivity.this.mPD.dismiss();
                    String str = GoLeaveHomeSceneCreateEditActivity.this.mScene.f11131O000000o;
                    GoLeaveHomeSceneCreateEditActivity.this.mScene.f11131O000000o = optString;
                    if (!TextUtils.isEmpty(GoLeaveHomeSceneCreateEditActivity.this.mSceneID)) {
                        hod.O0000OoO().O00000o0(GoLeaveHomeSceneCreateEditActivity.this.mSceneID);
                    }
                    hod.O0000OoO().O00000o0(GoLeaveHomeSceneCreateEditActivity.this.mScene);
                    hod.O0000OoO().O00000o();
                    izb.O000000o(GoLeaveHomeSceneCreateEditActivity.this.mContext, (int) R.string.smarthome_scene_set_succ, 0).show();
                    Intent intent = new Intent();
                    intent.putExtra("old_id", str);
                    intent.putExtra("new_id", GoLeaveHomeSceneCreateEditActivity.this.mScene.f11131O000000o);
                    GoLeaveHomeSceneCreateEditActivity.this.setResult(-1, intent);
                    GoLeaveHomeSceneCreateEditActivity.this.finish();
                }

                public final void onFailure(fso fso) {
                    GoLeaveHomeSceneCreateEditActivity.this.mPD.dismiss();
                    izb.O000000o(GoLeaveHomeSceneCreateEditActivity.this.mContext, (int) R.string.smarthome_scene_set_fail, 0).show();
                }
            });
        } else {
            this.mPD.dismiss();
        }
    }

    class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public ImageView f10732O000000o;
        public SwitchButton O00000Oo;
        public TextView O00000o;
        public TextView O00000o0;
        public TextView O00000oO;
        public ImageView O00000oo;
        public TextView O0000O0o;
        public TextView O0000OOo;

        private O000000o() {
        }

        /* synthetic */ O000000o(GoLeaveHomeSceneCreateEditActivity goLeaveHomeSceneCreateEditActivity, byte b) {
            this();
        }
    }

    private View O00000o() {
        View inflate = getLayoutInflater().inflate((int) R.layout.scene_add_scene_condition_item, (ViewGroup) null);
        if (inflate != null) {
            O000000o o000000o = new O000000o(this, (byte) 0);
            o000000o.f10732O000000o = (ImageView) inflate.findViewById(R.id.icon);
            o000000o.O00000Oo = (SwitchButton) inflate.findViewById(R.id.item_enable);
            o000000o.O00000oO = (TextView) inflate.findViewById(R.id.add_timesp);
            o000000o.O00000oO.setVisibility(8);
            o000000o.O00000oo = (ImageView) inflate.findViewById(R.id.set_time_btn);
            o000000o.O00000oo.setVisibility(8);
            o000000o.O00000o0 = (TextView) inflate.findViewById(R.id.name);
            o000000o.O00000o = (TextView) inflate.findViewById(R.id.key_name);
            o000000o.O0000O0o = (TextView) inflate.findViewById(R.id.offline);
            o000000o.O0000O0o.setVisibility(8);
            o000000o.O0000OOo = (TextView) inflate.findViewById(R.id.buy_button);
            o000000o.O0000OOo.setVisibility(8);
            inflate.setTag(o000000o);
        }
        return inflate;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 1000 && intent.getBooleanExtra("scene_deleted", false)) {
            finish();
        } else if (i == 8192) {
            this.mScene = SceneDataCache.INSTANCE.getCahcedScene();
            if (this.mScene.O0000oo0.O00000oO.size() > 0 && this.isNewScene) {
                this.mScene.O0000oo0.O00000Oo = true;
                this.O00000o0.getTag();
            }
        } else if (i != 102) {
            refreshUI(false);
        } else if (i2 == -1 && intent != null) {
            CorntabUtils.CorntabParam corntabParam = (CorntabUtils.CorntabParam) intent.getParcelableExtra("time_param");
            String stringExtra = intent.getStringExtra("time_filter");
            SceneApi.O0000o o0000o = null;
            Iterator<SceneApi.O000000o> it = this.mScene.O0000O0o.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SceneApi.O000000o next = it.next();
                if (next.O00000Oo != null) {
                    next.O00000Oo.f11124O000000o = corntabParam;
                    SceneApi.O0000o o0000o2 = next.O00000Oo;
                    if (TextUtils.isEmpty(stringExtra)) {
                        stringExtra = "";
                    }
                    o0000o2.O00000Oo = stringExtra;
                    o0000o = next.O00000Oo;
                }
            }
            O000000o o000000o = (O000000o) this.O00000Oo.getTag();
            if (o0000o != null) {
                this.mScene.O0000O0o.add(HomeSceneFactory.INSTANCE.createTimerCondition(corntabParam));
            }
            if (o000000o != null) {
                o000000o.O00000o.setText(SmartHomeSceneTimerActivity.getTimerHint(getContext(), o0000o));
            }
        }
    }

    private void O00000oO() {
        SceneApi.O0000o o0000o;
        this.O00000Oo = O00000o();
        O000000o o000000o = (O000000o) this.O00000Oo.getTag();
        o000000o.O00000o0.setText((int) R.string.smarthome_scene_start_timer);
        o000000o.f10732O000000o.setImageResource(R.drawable.std_scene_icon_timing);
        if (this.isGoHomeRecommend) {
            o0000o = HomeSceneFactory.INSTANCE.getDefaultGoHomeTimer();
        } else {
            o0000o = HomeSceneFactory.INSTANCE.getDefaultLeaveHomeTimer();
        }
        if (!this.isNewScene) {
            Iterator<SceneApi.O000000o> it = this.mScene.O0000O0o.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SceneApi.O000000o next = it.next();
                if (next.f11121O000000o.equals(LAUNCH_TYPE.TIMER) && next.O00000Oo != null) {
                    o0000o = next.O00000Oo;
                    break;
                }
            }
        }
        o000000o.O00000o.setText(SmartHomeSceneTimerActivity.getTimerHint(this, o0000o));
        this.O00000Oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.AnonymousClass7 */

            public final void onClick(View view) {
                SceneApi.O0000o o0000o;
                Intent intent = new Intent(GoLeaveHomeSceneCreateEditActivity.this.getContext(), SmartHomeSceneTimerActivity.class);
                if (GoLeaveHomeSceneCreateEditActivity.this.isGoHomeRecommend) {
                    o0000o = HomeSceneFactory.INSTANCE.getDefaultGoHomeTimer();
                } else {
                    o0000o = HomeSceneFactory.INSTANCE.getDefaultLeaveHomeTimer();
                }
                Iterator<SceneApi.O000000o> it = GoLeaveHomeSceneCreateEditActivity.this.mScene.O0000O0o.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    SceneApi.O000000o next = it.next();
                    if (next.f11121O000000o.equals(LAUNCH_TYPE.TIMER) && next.O00000Oo != null) {
                        o0000o = next.O00000Oo;
                        break;
                    }
                }
                intent.putExtra("time_param", o0000o.f11124O000000o);
                intent.putExtra("time_filter", o0000o.O00000Oo);
                GoLeaveHomeSceneCreateEditActivity.this.startActivityForResult(intent, 102);
            }
        });
        this.O00000o0 = O00000o();
        O000000o o000000o2 = (O000000o) this.O00000o0.getTag();
        if (this.isGoHomeRecommend) {
            o000000o2.O00000o0.setText((int) R.string.scene2_device_group_condition_come);
        } else {
            o000000o2.O00000o0.setText((int) R.string.scene2_device_group_condition_leave);
        }
        o000000o2.O00000o.setText((int) R.string.scene2_device_group_condition_desc);
        o000000o2.f10732O000000o.setImageResource(R.drawable.std_sence_icon_judgment);
        this.O00000o0.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.AnonymousClass8 */

            public final void onClick(View view) {
                Intent intent = new Intent(GoLeaveHomeSceneCreateEditActivity.this.getContext(), GoLeaveHomeGroupConditionActivity.class);
                SceneDataCache.INSTANCE.setCachedScene(GoLeaveHomeSceneCreateEditActivity.this.mScene);
                if (GoLeaveHomeSceneCreateEditActivity.this.isNewScene) {
                    intent.putExtra("go_home_recommend_flag", GoLeaveHomeSceneCreateEditActivity.this.isGoHomeRecommend);
                } else {
                    hod.O0000OoO();
                    intent.putExtra("go_home_recommend_flag", hod.O000000o(GoLeaveHomeSceneCreateEditActivity.this.mScene));
                }
                GoLeaveHomeSceneCreateEditActivity.this.startActivityForResult(intent, 8192);
            }
        });
        this.mConditionListView.addHeaderView(this.O00000o0);
    }

    class ConditionsAdapter extends BaseAdapter {

        /* renamed from: O000000o  reason: collision with root package name */
        int f10721O000000o;
        @BindView(5185)
        TextView mBuyButton;
        @BindView(5583)
        SimpleDraweeView mIcon;
        @BindView(5665)
        TextView mKeyName;
        @BindView(5883)
        TextView mName;
        @BindView(5915)
        TextView mOffline;
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

        ConditionsAdapter() {
        }

        public int getCount() {
            if (!(GoLeaveHomeSceneCreateEditActivity.this.mScene == null || GoLeaveHomeSceneCreateEditActivity.this.mScene.O0000O0o == null)) {
                this.f10721O000000o = GoLeaveHomeSceneCreateEditActivity.this.mScene.O0000O0o.size();
            }
            return this.f10721O000000o;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = GoLeaveHomeSceneCreateEditActivity.this.getLayoutInflater().inflate((int) R.layout.scene_add_scene_condition_item, (ViewGroup) null);
            }
            ButterKnife.bind(this, view);
            if (i < GoLeaveHomeSceneCreateEditActivity.this.mScene.O0000O0o.size()) {
                final SceneApi.O000000o o000000o = GoLeaveHomeSceneCreateEditActivity.this.mScene.O0000O0o.get(i);
                if (o000000o.f11121O000000o == LAUNCH_TYPE.DEVICE) {
                    this.mKeyName.setVisibility(0);
                    this.mKeyName.setText(o000000o.O00000o0.O00000Oo);
                } else if (o000000o.f11121O000000o == LAUNCH_TYPE.TIMER) {
                    this.mKeyName.setVisibility(0);
                    this.mKeyName.setText(SmartHomeSceneTimerActivity.getTimerHint(GoLeaveHomeSceneCreateEditActivity.this.getContext(), o000000o.O00000Oo != null ? o000000o.O00000Oo : null));
                } else {
                    this.mKeyName.setVisibility(8);
                }
                this.mName.setText(hnw.O00000Oo(GoLeaveHomeSceneCreateEditActivity.this.mContext, o000000o));
                hnw.O000000o(this.mIcon, o000000o);
                if (o000000o == null || !(o000000o.f11121O000000o == LAUNCH_TYPE.DEVICE || o000000o.f11121O000000o == LAUNCH_TYPE.MIKEY || o000000o.f11121O000000o == LAUNCH_TYPE.MIBAND)) {
                    this.mTimeSetButton.setVisibility(8);
                    this.mTimeSpan.setVisibility(8);
                    this.mOffline.setVisibility(8);
                    view.setOnClickListener(null);
                    view.setOnLongClickListener(new View.OnLongClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.ConditionsAdapter.AnonymousClass6 */

                        public final boolean onLongClick(View view) {
                            new MLAlertDialog.Builder(GoLeaveHomeSceneCreateEditActivity.this.mContext).O000000o(new String[]{GoLeaveHomeSceneCreateEditActivity.this.getString(R.string.delete)}, new DialogInterface.OnClickListener() {
                                /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.ConditionsAdapter.AnonymousClass6.AnonymousClass1 */

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    GoLeaveHomeSceneCreateEditActivity.this.mScene.O0000O0o.remove(o000000o);
                                    GoLeaveHomeSceneCreateEditActivity.this.mConditionAdapter.notifyDataSetChanged();
                                    GoLeaveHomeSceneCreateEditActivity.this.refreshUI(false);
                                    dialogInterface.cancel();
                                }
                            }).O00000o().show();
                            return true;
                        }
                    });
                } else {
                    this.mTimeSpan.setVisibility(8);
                    this.mOffline.setVisibility(8);
                    this.mTimeSetButton.setVisibility(8);
                    if (!GoLeaveHomeSceneCreateEditActivity.this.f10690O000000o[i]) {
                        this.mOffline.setVisibility(0);
                        this.mTimeSetButton.setVisibility(8);
                        this.mTimeSpan.setVisibility(8);
                        view.setOnClickListener(new View.OnClickListener() {
                            /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.ConditionsAdapter.AnonymousClass1 */

                            public final void onClick(View view) {
                                GoLeaveHomeSceneCreateEditActivity.this.O00000o0();
                            }
                        });
                    } else if (o000000o.O00000o0 != null) {
                        this.mTimeSetButton.setVisibility(0);
                        if (o000000o.O00000o0.O00000oO != -1) {
                            this.mTimeSpan.setVisibility(0);
                            TextView textView = this.mTimeSpan;
                            textView.setText(o000000o.O00000o0.O00000oO + ":00-" + o000000o.O00000o0.O00000oo + ":00");
                            this.mTimeSetButton.setOnClickListener(new View.OnClickListener() {
                                /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.ConditionsAdapter.AnonymousClass2 */

                                public final void onClick(View view) {
                                    int[] iArr = {R.string.smarthome_delete_timespan, R.string.smarthome_modify_timespan, R.string.smarthome_cancel_timespan};
                                    String[] strArr = new String[3];
                                    for (int i = 0; i < 3; i++) {
                                        strArr[i] = GoLeaveHomeSceneCreateEditActivity.this.getString(iArr[i]);
                                    }
                                    new MLAlertDialog.Builder(GoLeaveHomeSceneCreateEditActivity.this.getContext()).O000000o(strArr, new DialogInterface.OnClickListener() {
                                        /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.ConditionsAdapter.AnonymousClass2.AnonymousClass1 */

                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            if (i == 0) {
                                                GoLeaveHomeSceneCreateEditActivity goLeaveHomeSceneCreateEditActivity = GoLeaveHomeSceneCreateEditActivity.this;
                                                SceneApi.O000000o o000000o = o000000o;
                                                o000000o.O00000o0.O00000oO = -1;
                                                o000000o.O00000o0.O00000oo = -1;
                                                o000000o.O00000o0.O0000O0o = -1;
                                                o000000o.O00000o0.O0000OOo = -1;
                                                o000000o.O00000o0.O0000Oo0 = null;
                                                goLeaveHomeSceneCreateEditActivity.refreshUI(false);
                                            } else if (i == 1) {
                                                Intent intent = new Intent(GoLeaveHomeSceneCreateEditActivity.this.mContext, SmartHomeSceneTimeSpan.class);
                                                hpq.O000000o().O00000Oo(o000000o);
                                                GoLeaveHomeSceneCreateEditActivity.this.startActivityForResult(intent, 8193);
                                            }
                                        }
                                    }).O00000oo();
                                }
                            });
                        } else {
                            this.mTimeSpan.setVisibility(8);
                            this.mOffline.setVisibility(8);
                            this.mTimeSetButton.setOnClickListener(new View.OnClickListener() {
                                /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.ConditionsAdapter.AnonymousClass3 */

                                public final void onClick(View view) {
                                    GoLeaveHomeSceneCreateEditActivity.this.startActivityForResult(new Intent(GoLeaveHomeSceneCreateEditActivity.this.mContext, SmartHomeSceneTimeSpan.class), 8193);
                                    hpq.O000000o().O00000Oo(o000000o);
                                }
                            });
                        }
                        view.setOnClickListener(new View.OnClickListener() {
                            /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.ConditionsAdapter.AnonymousClass4 */

                            public final void onClick(View view) {
                                Intent intent = new Intent(GoLeaveHomeSceneCreateEditActivity.this.mContext, StartConditionActivity.class);
                                hpq.O000000o().O00000Oo(o000000o);
                                hpq.O000000o().O000000o(GoLeaveHomeSceneCreateEditActivity.this.mScene);
                                GoLeaveHomeSceneCreateEditActivity.this.startActivityForResult(intent, 1);
                            }
                        });
                    }
                    view.setOnLongClickListener(new View.OnLongClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.ConditionsAdapter.AnonymousClass5 */

                        public final boolean onLongClick(View view) {
                            new MLAlertDialog.Builder(GoLeaveHomeSceneCreateEditActivity.this.mContext).O000000o(new String[]{GoLeaveHomeSceneCreateEditActivity.this.getString(R.string.delete)}, new DialogInterface.OnClickListener() {
                                /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.ConditionsAdapter.AnonymousClass5.AnonymousClass1 */

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    GoLeaveHomeSceneCreateEditActivity.this.mScene.O0000O0o.remove(o000000o);
                                    GoLeaveHomeSceneCreateEditActivity.this.mConditionAdapter.notifyDataSetChanged();
                                    GoLeaveHomeSceneCreateEditActivity.this.refreshUI(false);
                                    dialogInterface.cancel();
                                }
                            }).O00000o().show();
                            return true;
                        }
                    });
                }
            }
            return view;
        }
    }

    class ActionsAdapter extends BaseAdapter {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f10713O000000o = 0;
        private int O00000o0 = 0;
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

        ActionsAdapter() {
        }

        public int getCount() {
            if (GoLeaveHomeSceneCreateEditActivity.this.mNoDeviceActionItems != null) {
                this.O00000o0 = GoLeaveHomeSceneCreateEditActivity.this.mNoDeviceActionItems.size();
            }
            if (!(GoLeaveHomeSceneCreateEditActivity.this.mScene == null || GoLeaveHomeSceneCreateEditActivity.this.mScene.O00000oo == null)) {
                this.f10713O000000o = GoLeaveHomeSceneCreateEditActivity.this.mScene.O00000oo.size();
            }
            return this.O00000o0 + this.f10713O000000o;
        }

        public View getView(final int i, View view, ViewGroup viewGroup) {
            String str;
            if (view == null) {
                view = GoLeaveHomeSceneCreateEditActivity.this.getLayoutInflater().inflate((int) R.layout.smarthome_scene_condition_task_item, (ViewGroup) null);
            }
            ButterKnife.bind(this, view);
            if (i >= this.f10713O000000o) {
                this.mTaskLayout.setVisibility(0);
                this.mDelayLayout.setVisibility(8);
                Device O0000o0O = DeviceFactory.O0000o0O(GoLeaveHomeSceneCreateEditActivity.this.mNoDeviceActionItems.get(i - this.f10713O000000o).O00000Oo[0]);
                this.mTitle.setText(O0000o0O.name);
                this.mOffline.setVisibility(8);
                this.mTitle.setTextColor(GoLeaveHomeSceneCreateEditActivity.this.mContext.getResources().getColor(R.color.mj_color_gray_heavy));
                DeviceFactory.O00000o0(O0000o0O.model, this.mImage);
                if (i == 0 && i == GoLeaveHomeSceneCreateEditActivity.this.mScene.O00000oo.size() - 1) {
                    this.mIconTopLine.setVisibility(4);
                    this.mIconBottomLine.setVisibility(4);
                    this.mBottomline.setVisibility(4);
                } else if (i == 0) {
                    this.mBottomline.setVisibility(0);
                    this.mIconTopLine.setVisibility(4);
                    this.mIconBottomLine.setVisibility(0);
                } else if (i == GoLeaveHomeSceneCreateEditActivity.this.mScene.O00000oo.size() - 1) {
                    this.mIconTopLine.setVisibility(0);
                    this.mIconBottomLine.setVisibility(4);
                    this.mBottomline.setVisibility(4);
                } else {
                    this.mIconTopLine.setVisibility(0);
                    this.mIconBottomLine.setVisibility(0);
                    this.mBottomline.setVisibility(0);
                }
                view.setOnClickListener(null);
                view.setOnLongClickListener(null);
                this.mBuyButton.setVisibility(0);
                this.mBuyButton.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.ActionsAdapter.AnonymousClass1 */

                    public final void onClick(View view) {
                        if (TextUtils.isEmpty(GoLeaveHomeSceneCreateEditActivity.this.mNoDeviceActionItems.get(i - ActionsAdapter.this.f10713O000000o).O00000o)) {
                            GoLeaveHomeSceneCreateEditActivity goLeaveHomeSceneCreateEditActivity = GoLeaveHomeSceneCreateEditActivity.this;
                            new MLAlertDialog.Builder(goLeaveHomeSceneCreateEditActivity).O00000Oo((int) R.string.no_device_title).O000000o((int) R.string.go_to_buy, new DialogInterface.OnClickListener() {
                                /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.AnonymousClass11 */

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    GoLeaveHomeSceneCreateEditActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://m.mi.com")));
                                }
                            }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                                /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.AnonymousClass9 */

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            }).O00000oo();
                            return;
                        }
                        hjp.O000000o("https://home.mi.com/shop/detail?gid=" + GoLeaveHomeSceneCreateEditActivity.this.mNoDeviceActionItems.get(i - ActionsAdapter.this.f10713O000000o).O00000o);
                    }
                });
                this.mAnchor.setVisibility(8);
                return view;
            }
            final SceneApi.Action action = GoLeaveHomeSceneCreateEditActivity.this.mScene.O00000oo.get(i);
            this.mBuyButton.setVisibility(8);
            if (action.O0000O0o instanceof SceneApi.O000O0o0) {
                this.mTaskLayout.setVisibility(8);
                this.mDelayLayout.setVisibility(0);
                if (i == 0 && i == GoLeaveHomeSceneCreateEditActivity.this.mScene.O00000oo.size() - 1) {
                    this.mDelayTimeLine.setVisibility(4);
                    this.mDelayTopLine.setVisibility(4);
                    this.mDelayBottomLine.setVisibility(4);
                } else if (i == 0) {
                    this.mDelayTimeLine.setVisibility(4);
                    this.mDelayTopLine.setVisibility(4);
                    this.mDelayBottomLine.setVisibility(0);
                } else if (i == GoLeaveHomeSceneCreateEditActivity.this.mScene.O00000oo.size() - 1) {
                    this.mDelayTimeLine.setVisibility(4);
                    this.mDelayTopLine.setVisibility(0);
                    this.mDelayBottomLine.setVisibility(4);
                } else {
                    this.mDelayTimeLine.setVisibility(0);
                    this.mDelayTopLine.setVisibility(0);
                    this.mDelayBottomLine.setVisibility(0);
                }
                if (action.O0000O0o.O00000oo < 60) {
                    str = GoLeaveHomeSceneCreateEditActivity.this.getResources().getQuantityString(R.plurals.smarthome_scene_delay_detal_sec, action.O0000O0o.O00000oo % 60, Integer.valueOf(action.O0000O0o.O00000oo % 60));
                } else if (action.O0000O0o.O00000oo % 60 == 0) {
                    str = GoLeaveHomeSceneCreateEditActivity.this.getResources().getQuantityString(R.plurals.smarthome_scene_delay_detal_min, action.O0000O0o.O00000oo / 60, Integer.valueOf(action.O0000O0o.O00000oo / 60));
                } else {
                    String quantityString = GoLeaveHomeSceneCreateEditActivity.this.getResources().getQuantityString(R.plurals.automation_minute, action.O0000O0o.O00000oo / 60, Integer.valueOf(action.O0000O0o.O00000oo / 60));
                    String quantityString2 = GoLeaveHomeSceneCreateEditActivity.this.getResources().getQuantityString(R.plurals.automation_seconds, action.O0000O0o.O00000oo % 60, Integer.valueOf(action.O0000O0o.O00000oo % 60));
                    str = String.format(GoLeaveHomeSceneCreateEditActivity.this.getString(R.string.smarthome_scene_delay_detal_min_sec), quantityString, quantityString2);
                }
                this.mDelayTimeText.setText(str);
                view.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.ActionsAdapter.AnonymousClass2 */

                    public final void onClick(View view) {
                        Intent intent = new Intent(GoLeaveHomeSceneCreateEditActivity.this.mContext, SmartHomeSceneTimerDelay.class);
                        hpq.O000000o().O000000o(GoLeaveHomeSceneCreateEditActivity.this.mScene);
                        hpq.O000000o().O00000Oo(action);
                        GoLeaveHomeSceneCreateEditActivity.this.startActivityForResult(intent, 1);
                    }
                });
            } else {
                this.mTaskLayout.setVisibility(0);
                this.mDelayLayout.setVisibility(8);
                if (i == 0 && i == GoLeaveHomeSceneCreateEditActivity.this.mScene.O00000oo.size() - 1) {
                    this.mIconTopLine.setVisibility(4);
                    this.mIconBottomLine.setVisibility(4);
                    this.mBottomline.setVisibility(4);
                } else if (i == 0) {
                    this.mBottomline.setVisibility(0);
                    this.mIconTopLine.setVisibility(4);
                    this.mIconBottomLine.setVisibility(0);
                } else if (i == GoLeaveHomeSceneCreateEditActivity.this.mScene.O00000oo.size() - 1) {
                    this.mIconTopLine.setVisibility(0);
                    this.mIconBottomLine.setVisibility(4);
                    this.mBottomline.setVisibility(4);
                } else {
                    this.mIconTopLine.setVisibility(0);
                    this.mIconBottomLine.setVisibility(0);
                    this.mBottomline.setVisibility(0);
                }
                if (i != 0 && (GoLeaveHomeSceneCreateEditActivity.this.mScene.O00000oo.get(i).O0000O0o instanceof SceneApi.O000O0o0)) {
                    this.mBottomline.setVisibility(4);
                } else if (i == GoLeaveHomeSceneCreateEditActivity.this.mScene.O00000oo.size() - 1) {
                    this.mBottomline.setVisibility(4);
                } else {
                    this.mBottomline.setVisibility(0);
                }
                this.mOffline.setVisibility(8);
                this.mAnchor.setVisibility(8);
                hnw.O000000o(this.mImage, this.mTitle, action);
                this.mSubTitle.setText(action.O00000o0);
                if (GoLeaveHomeSceneCreateEditActivity.this.mOnlineItems == null || GoLeaveHomeSceneCreateEditActivity.this.mOnlineItems.length <= i || !GoLeaveHomeSceneCreateEditActivity.this.mOnlineItems[i]) {
                    this.mOffline.setVisibility(0);
                    this.mAnchor.setVisibility(8);
                    view.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.ActionsAdapter.AnonymousClass4 */

                        public final void onClick(View view) {
                            GoLeaveHomeSceneCreateEditActivity.this.O00000o0();
                        }
                    });
                } else {
                    view.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.ActionsAdapter.AnonymousClass3 */

                        public final void onClick(View view) {
                            Intent intent = new Intent(GoLeaveHomeSceneCreateEditActivity.this.mContext, SmartHomeSceneActionChooseActivity.class);
                            hpq.O000000o().O00000Oo(action);
                            hpq.O000000o().O000000o(GoLeaveHomeSceneCreateEditActivity.this.mScene);
                            GoLeaveHomeSceneCreateEditActivity.this.startActivityForResult(intent, 1);
                        }
                    });
                }
            }
            view.setOnLongClickListener(new View.OnLongClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.ActionsAdapter.AnonymousClass5 */

                public final boolean onLongClick(View view) {
                    new MLAlertDialog.Builder(GoLeaveHomeSceneCreateEditActivity.this.mContext).O000000o(new String[]{GoLeaveHomeSceneCreateEditActivity.this.getString(R.string.delete)}, new DialogInterface.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.ActionsAdapter.AnonymousClass5.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (i == 0) {
                                GoLeaveHomeSceneCreateEditActivity.this.mScene.O00000oo.remove(i);
                                GoLeaveHomeSceneCreateEditActivity.this.refreshUI(false);
                            }
                        }
                    }).O00000oo();
                    return true;
                }
            });
            return view;
        }
    }

    public void onResume() {
        super.onResume();
        refreshUI(false);
    }

    /* access modifiers changed from: package-private */
    public final void O00000o0() {
        this.O00000o = new MLAlertDialog.Builder(this.mContext).O000000o((int) R.string.device_offline).O000000o(getOffLineText(this.mContext, this.O00000o, null), gpc.O000000o(20.0f), 0, gpc.O000000o(20.0f), gpc.O000000o(20.0f)).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.AnonymousClass13 */

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }).O000000o((int) R.string.refresh_list, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.AnonymousClass12 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                fno.O000000o().O0000Oo0();
            }
        }).O00000oo();
    }

    public TextView getOffLineText(Context context, final MLAlertDialog mLAlertDialog, final String str) {
        Locale O00oOooo = CoreApi.O000000o().O00oOooo();
        if (O00oOooo == null) {
            O00oOooo = Locale.getDefault();
        }
        if (!O00oOooo.getLanguage().equalsIgnoreCase(Locale.ENGLISH.getLanguage())) {
            O00oOooo.getLanguage().equalsIgnoreCase(Locale.SIMPLIFIED_CHINESE.getLanguage());
        }
        TextView textView = (TextView) LayoutInflater.from(context).inflate((int) R.layout.ml_alert_reset_textview, (ViewGroup) null);
        String string = context.getString(R.string.device_offline_check);
        int indexOf = string.indexOf("#start#");
        int indexOf2 = string.indexOf("#end#") - 7;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String replace = string.replace("#start#", "").replace("#end#", "");
        spannableStringBuilder.append((CharSequence) replace);
        if (indexOf < 0 || indexOf2 < 0) {
            textView.setText(replace);
            return textView;
        }
        spannableStringBuilder.setSpan(new ClickableSpan() {
            /* class com.xiaomi.smarthome.scene.activity.GoLeaveHomeSceneCreateEditActivity.AnonymousClass14 */

            public final void onClick(View view) {
                fbt fbt = new fbt(GoLeaveHomeSceneCreateEditActivity.this, "WebShellActivity");
                String str = str;
                if (str != null) {
                    fbt.O000000o("url", str);
                } else {
                    fbt.O000000o("url", "https://io.mi.com/device/reset");
                }
                fbs.O000000o(fbt);
                MLAlertDialog mLAlertDialog = mLAlertDialog;
                if (mLAlertDialog != null) {
                    mLAlertDialog.dismiss();
                }
            }

            public final void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
            }
        }, indexOf, indexOf2, 33);
        textView.setText(spannableStringBuilder);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setLineSpacing(0.0f, 1.5f);
        return textView;
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
    public void refreshUI(boolean z) {
        SceneApi.O000OOOo o000OOOo = this.mScene;
        if (!(o000OOOo == null || o000OOOo.O00000oo == null)) {
            this.mOnlineItems = new boolean[this.mScene.O00000oo.size()];
            this.O0000O0o = new int[this.mScene.O00000oo.size()];
            Arrays.fill(this.mOnlineItems, false);
            Arrays.fill(this.O0000O0o, (int) R.drawable.device_list_phone_no);
            for (int i = 0; i < this.mScene.O00000oo.size(); i++) {
                hnw.O000000o O000000o2 = hnw.O000000o(this.mScene.O00000oo.get(i));
                if (O000000o2.O00000Oo) {
                    this.mOnlineItems[i] = true;
                }
                this.O0000O0o[i] = O000000o2.f397O000000o;
            }
            if (this.mScene.O0000O0o != null) {
                this.f10690O000000o = new boolean[this.mScene.O0000O0o.size()];
                for (int i2 = 0; i2 < this.mScene.O0000O0o.size(); i2++) {
                    if (this.mScene.O0000O0o.get(i2).O00000o0 == null && this.mScene.O0000O0o.get(i2).O00000oO == null && this.mScene.O0000O0o.get(i2).O00000oo == null) {
                        this.f10690O000000o[i2] = true;
                    } else {
                        String str = null;
                        if (this.mScene.O0000O0o.get(i2).O00000o0 != null) {
                            str = this.mScene.O0000O0o.get(i2).O00000o0.f11122O000000o;
                        }
                        if (this.mScene.O0000O0o.get(i2).O00000oO != null) {
                            str = this.mScene.O0000O0o.get(i2).O00000oO.f11122O000000o;
                        }
                        if (this.mScene.O0000O0o.get(i2).O00000oo != null) {
                            str = this.mScene.O0000O0o.get(i2).O00000oo.f11122O000000o;
                        }
                        if (str != null) {
                            Device O000000o3 = fno.O000000o().O000000o(str);
                            if (O000000o3 == null) {
                                O000000o3 = fno.O000000o().O00000Oo(str);
                            }
                            this.f10690O000000o[i2] = O000000o3 != null && O000000o3.did.equalsIgnoreCase(str) && O000000o3.isOnline;
                        } else {
                            this.f10690O000000o[i2] = true;
                        }
                    }
                }
            }
        }
        if (this.mScene.O00000oo.size() > 0 || this.mNoDeviceActionItems.size() > 0) {
            this.mNoActionTitle.setVisibility(8);
            this.mDivider4.setVisibility(0);
            this.mConfirmBtn.setEnabled(true);
        } else {
            this.mNoActionTitle.setVisibility(0);
            this.mDivider4.setVisibility(0);
            this.mConfirmBtn.setEnabled(false);
        }
        if (TextUtils.isEmpty(this.mSceneID) || !this.mScene.O000000o(this.mSceneSrc)) {
            this.mConfirmBtn.setVisibility(0);
            this.mModuleA4Commit.setVisibility(8);
            this.mConfirmBtn.setText((int) R.string.confirm);
        } else {
            this.mModuleA4Commit.setVisibility(0);
            this.mConfirmBtn.setVisibility(8);
            this.mModuleA4Commit.setText("");
            this.mModuleA4Commit.setBackgroundResource(R.drawable.std_tittlebar_main_device_more);
        }
        this.O0000OOo.notifyDataSetChanged();
        this.mConditionAdapter.notifyDataSetChanged();
    }
}
