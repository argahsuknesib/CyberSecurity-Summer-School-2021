package com.xiaomi.smarthome.scene.activity;

import _m_j.awq;
import _m_j.axe;
import _m_j.axj;
import _m_j.axl;
import _m_j.axz;
import _m_j.eyk;
import _m_j.eys;
import _m_j.fcb;
import _m_j.fju;
import _m_j.flk;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ftn;
import _m_j.gfr;
import _m_j.ggb;
import _m_j.ggd;
import _m_j.gge;
import _m_j.gof;
import _m_j.gpc;
import _m_j.gpv;
import _m_j.gqb;
import _m_j.gqd;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.hah;
import _m_j.hja;
import _m_j.hnw;
import _m_j.hny;
import _m_j.hoa;
import _m_j.hob;
import _m_j.hod;
import _m_j.hor;
import _m_j.hot;
import _m_j.hpn;
import _m_j.hpp;
import _m_j.hpq;
import _m_j.hpr;
import _m_j.hpu;
import _m_j.hrg;
import _m_j.hru;
import _m_j.hsl;
import _m_j.hxi;
import _m_j.izb;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.statistic.StatType;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.DeviceApi;
import com.xiaomi.smarthome.device.api.MessageCallback;
import com.xiaomi.smarthome.device.api.SceneInfo;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.device.utils.ClientRemarkInputView;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.widget.EditTextViewWithSingleWatcher;
import com.xiaomi.smarthome.nfctag.ui.NFCActionListActivity;
import com.xiaomi.smarthome.scene.activity.CommonSceneOnline;
import com.xiaomi.smarthome.scene.activity.SmarthomeCreateAutoSceneActivity;
import com.xiaomi.smarthome.scene.api.SceneApi;
import com.xiaomi.smarthome.scene.bean.CommonUsedScene;
import com.xiaomi.smarthome.scene.bean.LAUNCH_TYPE;
import com.xiaomi.smarthome.scene.bean.WeatherConditionType;
import com.xiaomi.smarthome.scene.model.CorntabUtils;
import com.xiaomi.smarthome.scene.pluginrecommend.CreateSceneFromRecommendActivity;
import com.xiaomi.smarthome.scene.pluginrecommend.LightActionStartActivity;
import com.xiaomi.smarthome.scene.view.HomeSceneScrollView;
import com.xiaomi.smarthome.scene.widget.ConditionDeviceFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SmarthomeCreateAutoSceneActivity extends BaseActivity {
    private static long O00oOooO;
    public static boolean isNewScene;
    public static boolean mIsInitStep;
    public static SceneApi.O000OOOo mScene;

    /* renamed from: O000000o  reason: collision with root package name */
    O00000o0 f11005O000000o;
    RecyclerView.O000000o O00000Oo;
    RecyclerView.O000000o O00000o;
    O000000o O00000o0;
    LayoutInflater O00000oO;
    SceneApi.O000OOOo O00000oo;
    SceneApi.O000OOOo O0000O0o;
    Context O0000OOo;
    boolean[] O0000Oo;
    String O0000Oo0;
    boolean[] O0000OoO;
    Handler O0000Ooo = new Handler() {
        /* class com.xiaomi.smarthome.scene.activity.SmarthomeCreateAutoSceneActivity.AnonymousClass15 */

        public final void handleMessage(Message message) {
            gsy.O00000Oo("SmarthomeCreateAutoSceneActivity", "msg.what" + message.what);
            int i = message.what;
            if (i == 100) {
                SmarthomeCreateAutoSceneActivity.this.O0000Ooo.post(new Runnable() {
                    /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$15$g_06QYbQCuzjOSCn6j76IxL_Zqg */

                    public final void run() {
                        SmarthomeCreateAutoSceneActivity.AnonymousClass15.this.O000000o();
                    }
                });
            } else if (i == 101) {
                SmarthomeCreateAutoSceneActivity.this.O000000o(false);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o() {
            if (SmarthomeCreateAutoSceneActivity.this.isValid()) {
                SmarthomeCreateAutoSceneActivity.this.mPD.dismiss();
            }
            izb.O000000o(SmarthomeCreateAutoSceneActivity.this.O0000OOo, (int) R.string.smarthome_scene_set_fail, 0).show();
        }
    };
    private boolean O0000o = false;
    int[] O0000o0 = {R.drawable.intelligence_icon_if_nor, R.drawable.intelligence_icon_ifonly_nor};
    int[] O0000o00 = {R.string.smarthome_scene_support_all, R.string.smarthome_scene_support_any};
    int[] O0000o0O = {R.drawable.intelligence_icon_if_hig, R.drawable.intelligence_icon_ifonly_hig};
    private boolean O0000o0o = true;
    private String O0000oO;
    private ArrayList<String> O0000oO0 = null;
    private boolean O0000oOO = false;
    private int O0000oOo = -1;
    private boolean O0000oo = false;
    private O0000O0o O0000oo0 = new O0000O0o();
    private hny O0000ooO = new hny() {
        /* class com.xiaomi.smarthome.scene.activity.SmarthomeCreateAutoSceneActivity.AnonymousClass16 */

        public final void onRefreshScenceSuccess(int i) {
            if (i == 5) {
                hod.O0000OoO().O00000o0(this);
                SmarthomeCreateAutoSceneActivity.this.completeScene();
            }
        }

        public final void onRefreshScenceFailed(int i) {
            hod.O0000OoO().O00000o0(this);
            gqg.O00000Oo((int) R.string.smarthome_scene_set_fail);
        }
    };
    private SceneApi.O00000Oo O0000ooo = null;
    @BindView(5118)
    RecyclerView mActionRV;
    @BindView(5077)
    TextView mAddActionTV;
    @BindView(5078)
    TextView mAddContionTV;
    @BindView(5120)
    RecyclerView mConditionRV;
    @BindView(5837)
    ImageButton mConfirmBtn;
    public boolean mCreatedWithNotifyEnable;
    @BindView(5401)
    Button mEditCancaelBtn;
    @BindView(5402)
    Button mEditCompleteBtn;
    @BindView(5444)
    TextView mExeTimeHint;
    @BindView(6145)
    RelativeLayout mExeTimeRL;
    @BindView(6146)
    TextView mExeTimeTV;
    public int mFrom = 0;
    @BindView(5545)
    TextView mHandTV;
    @BindView(5244)
    View mImgClearName;
    public boolean mIsInEditMode = false;
    @BindView(6150)
    View mLayoutSceneName;
    @BindView(5836)
    TextView mModuleA4MoreBtn;
    @BindView(5838)
    ImageView mModuleA4ReturnBtn;
    @BindView(5842)
    TextView mModuleA4ReturnTitle;
    public XQProgressDialog mPD;
    @BindView(5575)
    HomeSceneScrollView mScrollView;
    @BindView(5884)
    EditTextViewWithSingleWatcher mTextSceneName;
    @BindView(5885)
    TextView mTextSceneNameErrorMsg;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0341  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x034c  */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_create_auto_scene_layout);
        ButterKnife.bind(this);
        this.O00000oO = LayoutInflater.from(this);
        this.O0000OOo = this;
        if (!hod.O0000OoO().O0000OOo) {
            hod.O0000OoO().O00000o0();
        }
        if (getIntent() != null && getIntent().hasExtra("from")) {
            this.mFrom = getIntent().getIntExtra("from", 0);
        }
        if (getIntent() != null && getIntent().hasExtra("extra_recommend_edit")) {
            this.O0000o0o = getIntent().getBooleanExtra("extra_recommend_edit", true);
        }
        if (getIntent() != null && getIntent().hasExtra("from_main_page")) {
            this.O0000o = getIntent().getBooleanExtra("from_main_page", false);
        }
        Device device = null;
        hpq.O000000o().O0000Oo = null;
        this.O00000oo = hpq.O000000o().O00000Oo;
        Intent intent = getIntent();
        this.O0000Oo0 = intent.getStringExtra("extra_scene_id");
        this.O0000oO = intent.getStringExtra("extra_device_id");
        if (!TextUtils.isEmpty(this.O0000Oo0)) {
            this.O00000oo = hod.O0000OoO().O00000Oo(this.O0000Oo0);
        }
        SceneApi.O000OOOo o000OOOo = this.O00000oo;
        if (o000OOOo == null) {
            isNewScene = true;
            mIsInitStep = true;
            this.O0000Oo0 = null;
            this.O00000oo = new SceneApi.O000OOOo();
            mScene = new SceneApi.O000OOOo();
            if (this.mFrom == 2) {
                this.O00000oo.O0000O0o.clear();
                mScene.O0000O0o.clear();
                this.O00000oo.O0000O0o.add(new hot().O000000o(-1, null));
                mScene.O0000O0o.add(new hot().O000000o(-1, null));
                this.O00000oo.O00000oo.clear();
                mScene.O00000oo.clear();
            }
            this.O00000oo.O0000oO = new SceneApi.O0000o0();
            mScene.O0000oO = new SceneApi.O0000o0();
            gsy.O00000Oo("SmarthomeCreateAutoSceneActivity", "mScene mIsLite:" + mScene.O0000oO0);
            hpq.O000000o().O0000Oo0 = 1;
        } else {
            this.O0000Oo0 = o000OOOo.f11131O000000o;
            try {
                SceneApi.O000OOOo O000000o2 = SceneApi.O000OOOo.O000000o(this.O00000oo.O000000o(), this.O00000oo.O0000oO0);
                mScene = O000000o2;
                if (O000000o2 == null) {
                    finish();
                    this.mModuleA4MoreBtn.setContentDescription(getString(R.string.scene2_more));
                    if (!isNewScene) {
                        this.O0000oOO = true;
                        this.mModuleA4ReturnTitle.setText((int) R.string.smarthome_create_new_auto_scene);
                    } else {
                        this.O0000oOO = false;
                        this.mModuleA4ReturnTitle.setText(mScene.O00000Oo);
                    }
                    this.mAddContionTV.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$iRbjuWSAMG4Ct5EkVQAqLrp_7Oo */

                        public final void onClick(View view) {
                            SmarthomeCreateAutoSceneActivity.this.O0000Oo(view);
                        }
                    });
                    this.mAddActionTV.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$b8lO8Xfx9KKPJhE8K4zPpWsWo */

                        public final void onClick(View view) {
                            SmarthomeCreateAutoSceneActivity.this.O0000Oo0(view);
                        }
                    });
                    this.mModuleA4ReturnBtn.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$a18gugfeq4p4ihpHQAPwXIw8Nww */

                        public final void onClick(View view) {
                            SmarthomeCreateAutoSceneActivity.this.O0000OOo(view);
                        }
                    });
                    this.mEditCancaelBtn.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$FXJGTsgwv9OHCHyXQlH1qXJj1L4 */

                        public final void onClick(View view) {
                            SmarthomeCreateAutoSceneActivity.this.O0000O0o(view);
                        }
                    });
                    this.mEditCompleteBtn.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$dhAo3N07yUjrn_SDiYGHH2fJ1Y */

                        public final void onClick(View view) {
                            SmarthomeCreateAutoSceneActivity.this.O00000oo(view);
                        }
                    });
                    this.mImgClearName.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$ZjkmKH4chbtLHdP34vLXhS410cA */

                        public final void onClick(View view) {
                            SmarthomeCreateAutoSceneActivity.this.O00000oO(view);
                        }
                    });
                    this.mTextSceneName.setEditListener(new EditTextViewWithSingleWatcher.O000000o() {
                        /* class com.xiaomi.smarthome.scene.activity.SmarthomeCreateAutoSceneActivity.AnonymousClass12 */

                        private void O00000o0(String str) {
                            SmarthomeCreateAutoSceneActivity.this.mImgClearName.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
                            if (TextUtils.isEmpty(SmarthomeCreateAutoSceneActivity.this.getErrorMessage(str)) && SmarthomeCreateAutoSceneActivity.mScene != null) {
                                SmarthomeCreateAutoSceneActivity.mScene.O00000Oo = str;
                                SmarthomeCreateAutoSceneActivity.this.refreshTitle();
                            }
                        }

                        public final boolean O000000o(String str) {
                            O00000o0(str);
                            return true;
                        }

                        public final void O00000Oo(String str) {
                            String errorMessage = SmarthomeCreateAutoSceneActivity.this.getErrorMessage(str);
                            if (!TextUtils.isEmpty(errorMessage)) {
                                SmarthomeCreateAutoSceneActivity.this.mTextSceneNameErrorMsg.setVisibility(0);
                                SmarthomeCreateAutoSceneActivity.this.mTextSceneNameErrorMsg.setText(errorMessage);
                            } else {
                                SmarthomeCreateAutoSceneActivity.this.mTextSceneNameErrorMsg.setVisibility(8);
                            }
                            O00000o0(str);
                        }
                    });
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                    axl axl = new axl();
                    axl.O0000o0o = true;
                    axl.O0000Oo0 = (NinePatchDrawable) ContextCompat.O000000o(getContext(), (int) R.drawable.std_list_item_drag_shadow);
                    axl.O0000o00 = true;
                    axl.O0000o0O = (int) (((float) ViewConfiguration.getLongPressTimeout()) * 0.5f);
                    hru hru = new hru();
                    hru.O00000oo = true;
                    hru.O00000Oo();
                    this.f11005O000000o = new O00000o0();
                    this.O00000Oo = axl.O000000o(this.f11005O000000o);
                    this.mConditionRV.setLayoutManager(linearLayoutManager);
                    this.mConditionRV.setAdapter(this.O00000Oo);
                    awq awq = new awq();
                    awq.O0000o00 = false;
                    this.mConditionRV.setItemAnimator(awq);
                    hru.O000000o(this.mConditionRV);
                    axl.O000000o(this.mConditionRV);
                    axl.O0000o0 = true;
                    LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
                    axl axl2 = new axl();
                    axl2.O0000o0o = true;
                    axl2.O0000Oo0 = (NinePatchDrawable) ContextCompat.O000000o(getContext(), (int) R.drawable.std_list_item_drag_shadow);
                    axl2.O0000o00 = true;
                    axl2.O0000o0O = (int) (((float) ViewConfiguration.getLongPressTimeout()) * 0.5f);
                    hru hru2 = new hru();
                    hru2.O00000oo = true;
                    hru2.O00000Oo();
                    this.O00000o0 = new O000000o();
                    this.O00000o = axl2.O000000o(this.O00000o0);
                    this.mActionRV.setLayoutManager(linearLayoutManager2);
                    this.mActionRV.setAdapter(this.O00000o);
                    awq awq2 = new awq();
                    awq2.O0000o00 = false;
                    this.mActionRV.setItemAnimator(awq2);
                    hru2.O000000o(this.mActionRV);
                    axl2.O000000o(this.mActionRV);
                    axl2.O0000o0 = true;
                    this.mScrollView.setListener($$Lambda$SmarthomeCreateAutoSceneActivity$X_EW9lboADTtEh4RbPRi93MQqk.INSTANCE);
                    refreshUI();
                    Editable text = this.mTextSceneName.getText();
                    if (text != null && !TextUtils.isEmpty(getErrorMessage(text.toString()))) {
                        this.mTextSceneName.showSoftInput();
                    }
                    getCommonUseSetting();
                }
                mScene.O0000oO0 = this.O00000oo.O0000oO0;
                gsy.O00000Oo("SmarthomeCreateAutoSceneActivity", "mIsLite:" + mScene.O0000oO0);
                isNewScene = false;
                mIsInitStep = false;
                hpq.O000000o().O0000Oo0 = 0;
                if (this.O0000o0o && this.O00000oo.O00000o > 0) {
                    if (this.O00000oo.O00000o / 1000 == 2) {
                        Intent intent2 = new Intent(this, CreateSceneFromRecommendActivity.class);
                        intent2.putExtra("sr_id", this.O00000oo.O00000o);
                        if (this.O00000oo.O00000o % 2 == 0) {
                            if (!(this.O00000oo.O0000O0o == null || this.O00000oo.O0000O0o.size() <= 0 || this.O00000oo.O0000O0o.get(0).O00000o0 == null)) {
                                device = fno.O000000o().O000000o(this.O00000oo.O0000O0o.get(0).O00000o0.f11122O000000o);
                            }
                        } else if (!(this.O00000oo.O00000oo == null || this.O00000oo.O00000oo.size() <= 0 || this.O00000oo.O00000oo.get(0).O0000O0o == null)) {
                            device = fno.O000000o().O000000o(this.O00000oo.O00000oo.get(0).O0000O0o.O00000o);
                        }
                        if (device != null) {
                            intent2.putExtra("did", device.did);
                            startActivity(intent2);
                            finish();
                            this.mModuleA4MoreBtn.setContentDescription(getString(R.string.scene2_more));
                            if (!isNewScene) {
                            }
                            this.mAddContionTV.setOnClickListener(new View.OnClickListener() {
                                /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$iRbjuWSAMG4Ct5EkVQAqLrp_7Oo */

                                public final void onClick(View view) {
                                    SmarthomeCreateAutoSceneActivity.this.O0000Oo(view);
                                }
                            });
                            this.mAddActionTV.setOnClickListener(new View.OnClickListener() {
                                /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$b8lO8Xfx9KKPJhE8K4zPpWsWo */

                                public final void onClick(View view) {
                                    SmarthomeCreateAutoSceneActivity.this.O0000Oo0(view);
                                }
                            });
                            this.mModuleA4ReturnBtn.setOnClickListener(new View.OnClickListener() {
                                /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$a18gugfeq4p4ihpHQAPwXIw8Nww */

                                public final void onClick(View view) {
                                    SmarthomeCreateAutoSceneActivity.this.O0000OOo(view);
                                }
                            });
                            this.mEditCancaelBtn.setOnClickListener(new View.OnClickListener() {
                                /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$FXJGTsgwv9OHCHyXQlH1qXJj1L4 */

                                public final void onClick(View view) {
                                    SmarthomeCreateAutoSceneActivity.this.O0000O0o(view);
                                }
                            });
                            this.mEditCompleteBtn.setOnClickListener(new View.OnClickListener() {
                                /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$dhAo3N07yUjrn_SDiYGHH2fJ1Y */

                                public final void onClick(View view) {
                                    SmarthomeCreateAutoSceneActivity.this.O00000oo(view);
                                }
                            });
                            this.mImgClearName.setOnClickListener(new View.OnClickListener() {
                                /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$ZjkmKH4chbtLHdP34vLXhS410cA */

                                public final void onClick(View view) {
                                    SmarthomeCreateAutoSceneActivity.this.O00000oO(view);
                                }
                            });
                            this.mTextSceneName.setEditListener(new EditTextViewWithSingleWatcher.O000000o() {
                                /* class com.xiaomi.smarthome.scene.activity.SmarthomeCreateAutoSceneActivity.AnonymousClass12 */

                                private void O00000o0(String str) {
                                    SmarthomeCreateAutoSceneActivity.this.mImgClearName.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
                                    if (TextUtils.isEmpty(SmarthomeCreateAutoSceneActivity.this.getErrorMessage(str)) && SmarthomeCreateAutoSceneActivity.mScene != null) {
                                        SmarthomeCreateAutoSceneActivity.mScene.O00000Oo = str;
                                        SmarthomeCreateAutoSceneActivity.this.refreshTitle();
                                    }
                                }

                                public final boolean O000000o(String str) {
                                    O00000o0(str);
                                    return true;
                                }

                                public final void O00000Oo(String str) {
                                    String errorMessage = SmarthomeCreateAutoSceneActivity.this.getErrorMessage(str);
                                    if (!TextUtils.isEmpty(errorMessage)) {
                                        SmarthomeCreateAutoSceneActivity.this.mTextSceneNameErrorMsg.setVisibility(0);
                                        SmarthomeCreateAutoSceneActivity.this.mTextSceneNameErrorMsg.setText(errorMessage);
                                    } else {
                                        SmarthomeCreateAutoSceneActivity.this.mTextSceneNameErrorMsg.setVisibility(8);
                                    }
                                    O00000o0(str);
                                }
                            });
                            LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(this);
                            axl axl3 = new axl();
                            axl3.O0000o0o = true;
                            axl3.O0000Oo0 = (NinePatchDrawable) ContextCompat.O000000o(getContext(), (int) R.drawable.std_list_item_drag_shadow);
                            axl3.O0000o00 = true;
                            axl3.O0000o0O = (int) (((float) ViewConfiguration.getLongPressTimeout()) * 0.5f);
                            hru hru3 = new hru();
                            hru3.O00000oo = true;
                            hru3.O00000Oo();
                            this.f11005O000000o = new O00000o0();
                            this.O00000Oo = axl3.O000000o(this.f11005O000000o);
                            this.mConditionRV.setLayoutManager(linearLayoutManager3);
                            this.mConditionRV.setAdapter(this.O00000Oo);
                            awq awq3 = new awq();
                            awq3.O0000o00 = false;
                            this.mConditionRV.setItemAnimator(awq3);
                            hru3.O000000o(this.mConditionRV);
                            axl3.O000000o(this.mConditionRV);
                            axl3.O0000o0 = true;
                            LinearLayoutManager linearLayoutManager22 = new LinearLayoutManager(this);
                            axl axl22 = new axl();
                            axl22.O0000o0o = true;
                            axl22.O0000Oo0 = (NinePatchDrawable) ContextCompat.O000000o(getContext(), (int) R.drawable.std_list_item_drag_shadow);
                            axl22.O0000o00 = true;
                            axl22.O0000o0O = (int) (((float) ViewConfiguration.getLongPressTimeout()) * 0.5f);
                            hru hru22 = new hru();
                            hru22.O00000oo = true;
                            hru22.O00000Oo();
                            this.O00000o0 = new O000000o();
                            this.O00000o = axl22.O000000o(this.O00000o0);
                            this.mActionRV.setLayoutManager(linearLayoutManager22);
                            this.mActionRV.setAdapter(this.O00000o);
                            awq awq22 = new awq();
                            awq22.O0000o00 = false;
                            this.mActionRV.setItemAnimator(awq22);
                            hru22.O000000o(this.mActionRV);
                            axl22.O000000o(this.mActionRV);
                            axl22.O0000o0 = true;
                            this.mScrollView.setListener($$Lambda$SmarthomeCreateAutoSceneActivity$X_EW9lboADTtEh4RbPRi93MQqk.INSTANCE);
                            refreshUI();
                            Editable text2 = this.mTextSceneName.getText();
                            this.mTextSceneName.showSoftInput();
                            getCommonUseSetting();
                        }
                    }
                    switch (this.O00000oo.O00000o) {
                        case 1000:
                            if (fno.O000000o().O000000o(this.O00000oo.O0000O0o.get(0).O00000o0.f11122O000000o) != null) {
                                Intent intent3 = new Intent(this, PluginRecommendSceneActivity.class);
                                intent3.putExtra("sr_id", this.O00000oo.O00000o);
                                if (!(this.O00000oo.O0000O0o == null || this.O00000oo.O0000O0o.size() <= 0 || this.O00000oo.O0000O0o.get(0).O00000o0 == null)) {
                                    device = fno.O000000o().O000000o(this.O00000oo.O0000O0o.get(0).O00000o0.f11122O000000o);
                                }
                                if (device != null) {
                                    intent3.putExtra("did", device.did);
                                    startActivity(intent3);
                                    finish();
                                    break;
                                }
                            }
                            break;
                        case 1001:
                        case 1002:
                        case 1003:
                            if (!(this.O00000oo.O00000oo == null || this.O00000oo.O00000oo.size() <= 0 || fno.O000000o().O000000o(this.O00000oo.O00000oo.get(0).O0000O0o.O00000o) == null)) {
                                Intent intent4 = new Intent(this, LightActionStartActivity.class);
                                intent4.putExtra("sr_id", this.O00000oo.O00000o);
                                if (this.O00000oo.O00000oo != null && this.O00000oo.O00000oo.size() > 0 && this.O00000oo.O00000oo.get(0).O0000O0o != null && this.O00000oo.O00000oo.get(0).f11120O000000o == 0) {
                                    device = fno.O000000o().O000000o(this.O00000oo.O00000oo.get(0).O0000O0o.O00000o);
                                }
                                if (device != null) {
                                    intent4.putExtra("did", device.did);
                                    startActivity(intent4);
                                    finish();
                                    break;
                                }
                            }
                            break;
                    }
                    this.mModuleA4MoreBtn.setContentDescription(getString(R.string.scene2_more));
                    if (!isNewScene) {
                    }
                    this.mAddContionTV.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$iRbjuWSAMG4Ct5EkVQAqLrp_7Oo */

                        public final void onClick(View view) {
                            SmarthomeCreateAutoSceneActivity.this.O0000Oo(view);
                        }
                    });
                    this.mAddActionTV.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$b8lO8Xfx9KKPJhE8K4zPpWsWo */

                        public final void onClick(View view) {
                            SmarthomeCreateAutoSceneActivity.this.O0000Oo0(view);
                        }
                    });
                    this.mModuleA4ReturnBtn.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$a18gugfeq4p4ihpHQAPwXIw8Nww */

                        public final void onClick(View view) {
                            SmarthomeCreateAutoSceneActivity.this.O0000OOo(view);
                        }
                    });
                    this.mEditCancaelBtn.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$FXJGTsgwv9OHCHyXQlH1qXJj1L4 */

                        public final void onClick(View view) {
                            SmarthomeCreateAutoSceneActivity.this.O0000O0o(view);
                        }
                    });
                    this.mEditCompleteBtn.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$dhAo3N07yUjrn_SDiYGHH2fJ1Y */

                        public final void onClick(View view) {
                            SmarthomeCreateAutoSceneActivity.this.O00000oo(view);
                        }
                    });
                    this.mImgClearName.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$ZjkmKH4chbtLHdP34vLXhS410cA */

                        public final void onClick(View view) {
                            SmarthomeCreateAutoSceneActivity.this.O00000oO(view);
                        }
                    });
                    this.mTextSceneName.setEditListener(new EditTextViewWithSingleWatcher.O000000o() {
                        /* class com.xiaomi.smarthome.scene.activity.SmarthomeCreateAutoSceneActivity.AnonymousClass12 */

                        private void O00000o0(String str) {
                            SmarthomeCreateAutoSceneActivity.this.mImgClearName.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
                            if (TextUtils.isEmpty(SmarthomeCreateAutoSceneActivity.this.getErrorMessage(str)) && SmarthomeCreateAutoSceneActivity.mScene != null) {
                                SmarthomeCreateAutoSceneActivity.mScene.O00000Oo = str;
                                SmarthomeCreateAutoSceneActivity.this.refreshTitle();
                            }
                        }

                        public final boolean O000000o(String str) {
                            O00000o0(str);
                            return true;
                        }

                        public final void O00000Oo(String str) {
                            String errorMessage = SmarthomeCreateAutoSceneActivity.this.getErrorMessage(str);
                            if (!TextUtils.isEmpty(errorMessage)) {
                                SmarthomeCreateAutoSceneActivity.this.mTextSceneNameErrorMsg.setVisibility(0);
                                SmarthomeCreateAutoSceneActivity.this.mTextSceneNameErrorMsg.setText(errorMessage);
                            } else {
                                SmarthomeCreateAutoSceneActivity.this.mTextSceneNameErrorMsg.setVisibility(8);
                            }
                            O00000o0(str);
                        }
                    });
                    LinearLayoutManager linearLayoutManager32 = new LinearLayoutManager(this);
                    axl axl32 = new axl();
                    axl32.O0000o0o = true;
                    axl32.O0000Oo0 = (NinePatchDrawable) ContextCompat.O000000o(getContext(), (int) R.drawable.std_list_item_drag_shadow);
                    axl32.O0000o00 = true;
                    axl32.O0000o0O = (int) (((float) ViewConfiguration.getLongPressTimeout()) * 0.5f);
                    hru hru32 = new hru();
                    hru32.O00000oo = true;
                    hru32.O00000Oo();
                    this.f11005O000000o = new O00000o0();
                    this.O00000Oo = axl32.O000000o(this.f11005O000000o);
                    this.mConditionRV.setLayoutManager(linearLayoutManager32);
                    this.mConditionRV.setAdapter(this.O00000Oo);
                    awq awq32 = new awq();
                    awq32.O0000o00 = false;
                    this.mConditionRV.setItemAnimator(awq32);
                    hru32.O000000o(this.mConditionRV);
                    axl32.O000000o(this.mConditionRV);
                    axl32.O0000o0 = true;
                    LinearLayoutManager linearLayoutManager222 = new LinearLayoutManager(this);
                    axl axl222 = new axl();
                    axl222.O0000o0o = true;
                    axl222.O0000Oo0 = (NinePatchDrawable) ContextCompat.O000000o(getContext(), (int) R.drawable.std_list_item_drag_shadow);
                    axl222.O0000o00 = true;
                    axl222.O0000o0O = (int) (((float) ViewConfiguration.getLongPressTimeout()) * 0.5f);
                    hru hru222 = new hru();
                    hru222.O00000oo = true;
                    hru222.O00000Oo();
                    this.O00000o0 = new O000000o();
                    this.O00000o = axl222.O000000o(this.O00000o0);
                    this.mActionRV.setLayoutManager(linearLayoutManager222);
                    this.mActionRV.setAdapter(this.O00000o);
                    awq awq222 = new awq();
                    awq222.O0000o00 = false;
                    this.mActionRV.setItemAnimator(awq222);
                    hru222.O000000o(this.mActionRV);
                    axl222.O000000o(this.mActionRV);
                    axl222.O0000o0 = true;
                    this.mScrollView.setListener($$Lambda$SmarthomeCreateAutoSceneActivity$X_EW9lboADTtEh4RbPRi93MQqk.INSTANCE);
                    refreshUI();
                    Editable text22 = this.mTextSceneName.getText();
                    this.mTextSceneName.showSoftInput();
                    getCommonUseSetting();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        hpq.O000000o().O00000o(mScene);
        this.O0000oOo = intent.getIntExtra("extra_recommend_scene_id", -1);
        getFrom(intent);
        this.mModuleA4MoreBtn.setContentDescription(getString(R.string.scene2_more));
        if (!isNewScene) {
        }
        this.mAddContionTV.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$iRbjuWSAMG4Ct5EkVQAqLrp_7Oo */

            public final void onClick(View view) {
                SmarthomeCreateAutoSceneActivity.this.O0000Oo(view);
            }
        });
        this.mAddActionTV.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$b8lO8Xfx9KKPJhE8K4zPpWsWo */

            public final void onClick(View view) {
                SmarthomeCreateAutoSceneActivity.this.O0000Oo0(view);
            }
        });
        this.mModuleA4ReturnBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$a18gugfeq4p4ihpHQAPwXIw8Nww */

            public final void onClick(View view) {
                SmarthomeCreateAutoSceneActivity.this.O0000OOo(view);
            }
        });
        this.mEditCancaelBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$FXJGTsgwv9OHCHyXQlH1qXJj1L4 */

            public final void onClick(View view) {
                SmarthomeCreateAutoSceneActivity.this.O0000O0o(view);
            }
        });
        this.mEditCompleteBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$dhAo3N07yUjrn_SDiYGHH2fJ1Y */

            public final void onClick(View view) {
                SmarthomeCreateAutoSceneActivity.this.O00000oo(view);
            }
        });
        this.mImgClearName.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$ZjkmKH4chbtLHdP34vLXhS410cA */

            public final void onClick(View view) {
                SmarthomeCreateAutoSceneActivity.this.O00000oO(view);
            }
        });
        this.mTextSceneName.setEditListener(new EditTextViewWithSingleWatcher.O000000o() {
            /* class com.xiaomi.smarthome.scene.activity.SmarthomeCreateAutoSceneActivity.AnonymousClass12 */

            private void O00000o0(String str) {
                SmarthomeCreateAutoSceneActivity.this.mImgClearName.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
                if (TextUtils.isEmpty(SmarthomeCreateAutoSceneActivity.this.getErrorMessage(str)) && SmarthomeCreateAutoSceneActivity.mScene != null) {
                    SmarthomeCreateAutoSceneActivity.mScene.O00000Oo = str;
                    SmarthomeCreateAutoSceneActivity.this.refreshTitle();
                }
            }

            public final boolean O000000o(String str) {
                O00000o0(str);
                return true;
            }

            public final void O00000Oo(String str) {
                String errorMessage = SmarthomeCreateAutoSceneActivity.this.getErrorMessage(str);
                if (!TextUtils.isEmpty(errorMessage)) {
                    SmarthomeCreateAutoSceneActivity.this.mTextSceneNameErrorMsg.setVisibility(0);
                    SmarthomeCreateAutoSceneActivity.this.mTextSceneNameErrorMsg.setText(errorMessage);
                } else {
                    SmarthomeCreateAutoSceneActivity.this.mTextSceneNameErrorMsg.setVisibility(8);
                }
                O00000o0(str);
            }
        });
        LinearLayoutManager linearLayoutManager322 = new LinearLayoutManager(this);
        axl axl322 = new axl();
        axl322.O0000o0o = true;
        axl322.O0000Oo0 = (NinePatchDrawable) ContextCompat.O000000o(getContext(), (int) R.drawable.std_list_item_drag_shadow);
        axl322.O0000o00 = true;
        axl322.O0000o0O = (int) (((float) ViewConfiguration.getLongPressTimeout()) * 0.5f);
        hru hru322 = new hru();
        hru322.O00000oo = true;
        hru322.O00000Oo();
        this.f11005O000000o = new O00000o0();
        this.O00000Oo = axl322.O000000o(this.f11005O000000o);
        this.mConditionRV.setLayoutManager(linearLayoutManager322);
        this.mConditionRV.setAdapter(this.O00000Oo);
        awq awq322 = new awq();
        awq322.O0000o00 = false;
        this.mConditionRV.setItemAnimator(awq322);
        hru322.O000000o(this.mConditionRV);
        axl322.O000000o(this.mConditionRV);
        axl322.O0000o0 = true;
        LinearLayoutManager linearLayoutManager2222 = new LinearLayoutManager(this);
        axl axl2222 = new axl();
        axl2222.O0000o0o = true;
        axl2222.O0000Oo0 = (NinePatchDrawable) ContextCompat.O000000o(getContext(), (int) R.drawable.std_list_item_drag_shadow);
        axl2222.O0000o00 = true;
        axl2222.O0000o0O = (int) (((float) ViewConfiguration.getLongPressTimeout()) * 0.5f);
        hru hru2222 = new hru();
        hru2222.O00000oo = true;
        hru2222.O00000Oo();
        this.O00000o0 = new O000000o();
        this.O00000o = axl2222.O000000o(this.O00000o0);
        this.mActionRV.setLayoutManager(linearLayoutManager2222);
        this.mActionRV.setAdapter(this.O00000o);
        awq awq2222 = new awq();
        awq2222.O0000o00 = false;
        this.mActionRV.setItemAnimator(awq2222);
        hru2222.O000000o(this.mActionRV);
        axl2222.O000000o(this.mActionRV);
        axl2222.O0000o0 = true;
        this.mScrollView.setListener($$Lambda$SmarthomeCreateAutoSceneActivity$X_EW9lboADTtEh4RbPRi93MQqk.INSTANCE);
        refreshUI();
        Editable text222 = this.mTextSceneName.getText();
        this.mTextSceneName.showSoftInput();
        getCommonUseSetting();
    }

    public void getCommonUseSetting() {
        SceneApi.O000OOOo o000OOOo = mScene;
        if (o000OOOo == null) {
            return;
        }
        if (!TextUtils.isEmpty(o000OOOo.f11131O000000o)) {
            hoa.O00000o0(this, ggb.O00000Oo().O0000OOo(), new fsm<List<CommonUsedScene>, fso>() {
                /* class com.xiaomi.smarthome.scene.activity.SmarthomeCreateAutoSceneActivity.AnonymousClass1 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    List list = (List) obj;
                    int i = 0;
                    while (true) {
                        if (i >= (list == null ? 0 : list.size())) {
                            break;
                        }
                        try {
                            if (((CommonUsedScene) list.get(i)).f11134O000000o == Long.parseLong(SmarthomeCreateAutoSceneActivity.mScene.f11131O000000o)) {
                                SmarthomeCreateAutoSceneActivity.mScene.O0000o0O = 1;
                                break;
                            }
                            i++;
                        } catch (Exception unused) {
                        }
                    }
                    if (SmarthomeCreateAutoSceneActivity.mScene.O0000o0O == -1) {
                        SmarthomeCreateAutoSceneActivity.mScene.O0000o0O = 0;
                    }
                    if (SmarthomeCreateAutoSceneActivity.this.f11005O000000o != null) {
                        SmarthomeCreateAutoSceneActivity.this.f11005O000000o.notifyDataSetChanged();
                    }
                    SmarthomeCreateAutoSceneActivity.this.O00000oo.O0000o0O = SmarthomeCreateAutoSceneActivity.mScene.O0000o0O;
                }

                public final void onFailure(fso fso) {
                    SmarthomeCreateAutoSceneActivity.mScene.O0000o0O = -2;
                    SmarthomeCreateAutoSceneActivity.this.O00000oo.O0000o0O = SmarthomeCreateAutoSceneActivity.mScene.O0000o0O;
                    if (SmarthomeCreateAutoSceneActivity.this.f11005O000000o != null) {
                        SmarthomeCreateAutoSceneActivity.this.f11005O000000o.notifyDataSetChanged();
                    }
                }
            });
            return;
        }
        SceneApi.O000OOOo o000OOOo2 = mScene;
        o000OOOo2.O0000o0O = 0;
        this.O00000oo.O0000o0O = o000OOOo2.O0000o0O;
        O00000o0 o00000o0 = this.f11005O000000o;
        if (o00000o0 != null) {
            o00000o0.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O0000Oo(View view) {
        if (!isFastClick()) {
            O00000Oo();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O0000Oo0(View view) {
        if (!isFastClick()) {
            O00000o0();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O0000OOo(View view) {
        O000000o();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O0000O0o(View view) {
        O00000Oo(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000oo(View view) {
        O00000Oo(true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000oO(View view) {
        SceneApi.O000OOOo o000OOOo = mScene;
        if (o000OOOo != null) {
            o000OOOo.O00000Oo = null;
            this.mTextSceneName.setText("");
            this.mImgClearName.setVisibility(8);
            refreshTitle();
        }
    }

    public String getErrorMessage(String str) {
        if (str != null && !TextUtils.isEmpty(str.trim())) {
            for (SceneApi.O000OOOo next : hod.O0000OoO().O00000o0) {
                if (!TextUtils.equals(next.f11131O000000o, mScene.f11131O000000o) && TextUtils.equals(next.O00000Oo, str)) {
                    return getString(R.string.scene_modify_name_error);
                }
            }
            for (SceneApi.O000OOOo next2 : hpr.O00000o0().O0000O0o) {
                if (!TextUtils.equals(next2.f11131O000000o, mScene.f11131O000000o) && TextUtils.equals(next2.O00000Oo, str)) {
                    return getString(R.string.scene_modify_name_error);
                }
            }
        }
        return "";
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
        if (intent.getExtras() != null && !TextUtils.isEmpty(intent.getExtras().getString("scene_stat_from", "")) && this.O0000oOo != -1) {
            CoreApi O000000o2 = CoreApi.O000000o();
            StatType statType = StatType.EVENT;
            StringBuilder sb = new StringBuilder();
            sb.append(this.O0000oOo);
            O000000o2.O000000o(statType, "value", sb.toString(), (String) null, false);
        }
    }

    private void O000000o() {
        SceneApi.O000OOOo o000OOOo;
        SceneApi.O000OOOo o000OOOo2 = this.O00000oo;
        if (o000OOOo2 == null || (o000OOOo = mScene) == null || !o000OOOo.O000000o(o000OOOo2)) {
            hrg.O000000o(getContext(), getString(R.string.smarthome_scene_quit), getString(R.string.sh_common_cancel), getString(R.string.smarthome_scene_quest_ok), new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.SmarthomeCreateAutoSceneActivity.AnonymousClass14 */

                public final void onClick(View view) {
                    SmarthomeCreateAutoSceneActivity.this.finish();
                }
            });
        } else {
            finish();
        }
    }

    public void refreshUI() {
        SceneApi.O000OOOo o000OOOo;
        refreshTitle();
        if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO()) || (o000OOOo = mScene) == null || o000OOOo.O0000O0o == null || mScene.O0000O0o.size() != 1 || mScene.O0000O0o.get(0).f11121O000000o != LAUNCH_TYPE.CLICK) {
            this.mLayoutSceneName.setVisibility(8);
        } else {
            this.mLayoutSceneName.setVisibility(0);
            if (!TextUtils.isEmpty(mScene.O00000Oo)) {
                this.mTextSceneName.setText(mScene.O00000Oo);
                this.mImgClearName.setVisibility(0);
            } else {
                if (TextUtils.isEmpty(mScene.f11131O000000o) && mScene.O0000O0o != null && mScene.O0000O0o.size() > 0 && mScene.O00000oo != null && mScene.O00000oo.size() > 0) {
                    SceneApi.O000OOOo o000OOOo2 = mScene;
                    o000OOOo2.O00000Oo = hnw.O000000o(o000OOOo2);
                    if (!TextUtils.isEmpty(mScene.O00000Oo)) {
                        this.mTextSceneName.setText(mScene.O00000Oo);
                        this.mImgClearName.setVisibility(0);
                    }
                }
                this.mTextSceneName.setText("");
                this.mImgClearName.setVisibility(8);
            }
        }
        SceneApi.O000OOOo o000OOOo3 = mScene;
        if (o000OOOo3 == null || o000OOOo3.O0000O0o == null || mScene.O0000O0o.size() != 1 || mScene.O0000O0o.get(0).f11121O000000o != LAUNCH_TYPE.CLICK) {
            this.mAddContionTV.setVisibility(0);
        } else {
            this.mAddContionTV.setVisibility(8);
        }
        SceneApi.O000OOOo o000OOOo4 = mScene;
        if (o000OOOo4 == null || o000OOOo4.O0000O0o == null || mScene.O0000O0o.size() < 2) {
            this.mHandTV.setText((int) R.string.smarthome_scene_create_if);
            Drawable drawable = this.O0000OOo.getResources().getDrawable(this.O0000o0[0]);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.mHandTV.setCompoundDrawables(drawable, null, null, null);
        } else if (mScene.O0000Ooo == 0) {
            this.mHandTV.setText((int) R.string.smarthome_scene_support_all);
            Drawable drawable2 = this.O0000OOo.getResources().getDrawable(this.O0000o0[mScene.O0000Ooo]);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            this.mHandTV.setCompoundDrawables(drawable2, null, null, null);
        } else if (mScene.O0000Ooo == 1) {
            this.mHandTV.setText((int) R.string.smarthome_scene_support_any);
            Drawable drawable3 = this.O0000OOo.getResources().getDrawable(this.O0000o0[mScene.O0000Ooo]);
            drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
            this.mHandTV.setCompoundDrawables(drawable3, null, null, null);
        }
        hpq.O000000o();
        if (hpq.O00000o0(mScene.O0000O0o)) {
            this.mExeTimeRL.setVisibility(8);
            mScene.O0000oO = new SceneApi.O0000o0();
        } else {
            this.mExeTimeRL.setVisibility(0);
            this.mExeTimeTV.setTextColor(getResources().getColor(R.color.mj_color_black_80_transparent));
            this.mExeTimeHint.setTextColor(getResources().getColor(R.color.mj_color_black_80_transparent));
            int O00000oO2 = O00000oO();
            if (mScene.O0000oOO || isNewScene) {
                this.mExeTimeRL.setVisibility(0);
                this.mExeTimeRL.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$5q_y3MvlXtldYS6oUv26cyP2XM */

                    public final void onClick(View view) {
                        SmarthomeCreateAutoSceneActivity.this.O00000o(view);
                    }
                });
            } else if (O00000oO2 == 1) {
                this.mExeTimeRL.setVisibility(0);
                if (this.O0000ooo != null) {
                    mScene.O0000oO = new SceneApi.O0000o0();
                    mScene.O0000oO.f11125O000000o = this.O0000ooo.O00000oO;
                    mScene.O0000oO.O00000o0 = this.O0000ooo.O0000O0o;
                    mScene.O0000oO.O00000Oo = this.O0000ooo.O00000oo;
                    mScene.O0000oO.O00000o = this.O0000ooo.O0000OOo;
                    mScene.O0000oO.O00000oO = new int[this.O0000ooo.O0000Oo0.length];
                    System.arraycopy(this.O0000ooo.O0000Oo0, 0, mScene.O0000oO.O00000oO, 0, this.O0000ooo.O0000Oo0.length);
                    this.O00000oo.O0000oO = new SceneApi.O0000o0();
                    this.O00000oo.O0000oO.f11125O000000o = this.O0000ooo.O00000oO;
                    this.O00000oo.O0000oO.O00000o0 = this.O0000ooo.O0000O0o;
                    this.O00000oo.O0000oO.O00000Oo = this.O0000ooo.O00000oo;
                    this.O00000oo.O0000oO.O00000o = this.O0000ooo.O0000OOo;
                    this.O00000oo.O0000oO.O00000oO = new int[this.O0000ooo.O0000Oo0.length];
                    System.arraycopy(this.O0000ooo.O0000Oo0, 0, this.O00000oo.O0000oO.O00000oO, 0, this.O0000ooo.O0000Oo0.length);
                }
                this.mExeTimeRL.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$NpLNwsOAARdPPwc_KLi_RH49f4 */

                    public final void onClick(View view) {
                        SmarthomeCreateAutoSceneActivity.this.O00000o0(view);
                    }
                });
            } else if (O00000oO2 == 0) {
                this.mExeTimeRL.setVisibility(0);
                this.mExeTimeRL.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$WP9P18MI4mS59BEZEd7T0NFNAck */

                    public final void onClick(View view) {
                        SmarthomeCreateAutoSceneActivity.this.O00000Oo(view);
                    }
                });
            } else {
                this.mExeTimeRL.setVisibility(0);
                this.mExeTimeRL.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$IKRgWhLujSmsPGvAhEpo805zsVo */

                    public final void onClick(View view) {
                        SmarthomeCreateAutoSceneActivity.this.O000000o(view);
                    }
                });
            }
            SceneApi.O000OOOo o000OOOo5 = mScene;
            if (o000OOOo5 == null || o000OOOo5.O0000oO == null) {
                this.mExeTimeTV.setText((int) R.string.scene_exetime_all_day);
            } else if (mScene.O0000oO.f11125O000000o == mScene.O0000oO.O00000Oo && mScene.O0000oO.O00000o0 == mScene.O0000oO.O00000o) {
                this.mExeTimeTV.setText((int) R.string.scene_exetime_all_day);
            } else {
                CorntabUtils.CorntabParam corntabParam = new CorntabUtils.CorntabParam();
                corntabParam.O00000o0 = mScene.O0000oO.f11125O000000o;
                corntabParam.O00000Oo = mScene.O0000oO.O00000o0;
                CorntabUtils.CorntabParam O000000o2 = CorntabUtils.O000000o(TimeZone.getDefault(), TimeZone.getTimeZone("Asia/Shanghai"), corntabParam);
                CorntabUtils.CorntabParam corntabParam2 = new CorntabUtils.CorntabParam();
                corntabParam2.O00000o0 = mScene.O0000oO.O00000Oo;
                corntabParam2.O00000Oo = mScene.O0000oO.O00000o;
                CorntabUtils.CorntabParam O000000o3 = CorntabUtils.O000000o(TimeZone.getDefault(), TimeZone.getTimeZone("Asia/Shanghai"), corntabParam2);
                if (O000000o3.O00000o0 < O000000o2.O00000o0 || (O000000o3.O00000o0 == O000000o2.O00000o0 && O000000o3.O00000Oo < O000000o2.O00000Oo)) {
                    TextView textView = this.mExeTimeTV;
                    textView.setText(O000000o(O000000o2.O00000o0, O000000o2.O00000Oo) + "-" + O000000o(O000000o3.O00000o0, O000000o3.O00000Oo) + "(" + getResources().getString(R.string.scene_exetime_second_day) + ")");
                } else {
                    TextView textView2 = this.mExeTimeTV;
                    textView2.setText(O000000o(O000000o2.O00000o0, O000000o2.O00000Oo) + "-" + O000000o(O000000o3.O00000o0, O000000o3.O00000Oo));
                }
            }
            if (O00000oO() > 1) {
                this.mExeTimeTV.setText((int) R.string.scene_exetime_no_set);
            }
        }
        O00000oo();
        this.f11005O000000o.notifyDataSetChanged();
        this.O00000o0.notifyDataSetChanged();
        if (mScene != null) {
            hpq.O000000o().O00000Oo(mScene);
            hpq.O000000o().O00000o0(mScene);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x009e, code lost:
        if ((com.xiaomi.smarthome.scene.activity.SmarthomeCreateAutoSceneActivity.mScene.O00000oo.get(0).O0000O0o instanceof com.xiaomi.smarthome.scene.api.SceneApi.O000O0o0) != false) goto L_0x00a0;
     */
    public void refreshTitle() {
        SceneApi.O000OOOo o000OOOo;
        if (this.mIsInEditMode) {
            this.mEditCancaelBtn.setVisibility(0);
            this.mEditCompleteBtn.setVisibility(0);
            this.mConfirmBtn.setVisibility(8);
            this.mModuleA4MoreBtn.setVisibility(8);
            this.mModuleA4ReturnBtn.setVisibility(8);
        } else {
            this.mEditCancaelBtn.setVisibility(8);
            this.mEditCompleteBtn.setVisibility(8);
            this.mModuleA4ReturnBtn.setVisibility(0);
            if (mScene != null) {
                if (TextUtils.isEmpty(this.O0000Oo0) || !mScene.O000000o(this.O00000oo)) {
                    this.mConfirmBtn.setVisibility(0);
                    this.mModuleA4MoreBtn.setVisibility(8);
                } else {
                    this.mModuleA4MoreBtn.setVisibility(0);
                    this.mConfirmBtn.setVisibility(8);
                    this.mModuleA4MoreBtn.setText("");
                    this.mModuleA4MoreBtn.setBackgroundResource(R.drawable.common_title_bar_more_black);
                }
            }
        }
        SceneApi.O000OOOo o000OOOo2 = mScene;
        if (o000OOOo2 != null && o000OOOo2.O0000O0o.size() > 0 && mScene.O00000oo.size() > 0) {
            this.mConfirmBtn.setEnabled(true);
            if (mScene.O00000oo.size() == 1) {
            }
            o000OOOo = mScene;
            if (o000OOOo != null && !TextUtils.isEmpty(o000OOOo.O00000Oo)) {
                this.mModuleA4ReturnTitle.setText(mScene.O00000Oo);
                return;
            }
        }
        this.mConfirmBtn.setEnabled(false);
        o000OOOo = mScene;
        if (o000OOOo != null) {
        }
    }

    private void O00000Oo() {
        if (mScene.O0000O0o.size() >= 10) {
            izb.O000000o(this, (int) R.string.add_condition_error, 0).show();
            return;
        }
        hpq.O000000o();
        if (hpq.O00000o0(mScene.O0000O0o)) {
            gqg.O00000Oo(getString(R.string.smarthome_is_lite_scene));
        } else if (mScene.O0000O0o.size() == 1) {
            this.O0000oo0.f11033O000000o = mScene.O0000Ooo;
            new MLAlertDialog.Builder(this).O00000o0().O000000o(this.O0000oo0, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$_iPrv9ak2GextnwW5wjsATBUUrs */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    SmarthomeCreateAutoSceneActivity.this.O00000o0(dialogInterface, i);
                }
            }).O000000o((int) R.string.scene_choose_scene_mode_dialog_title).O00000o().show();
        } else {
            Intent intent = new Intent(this.O0000OOo, StartConditionActivityNew.class);
            intent.putExtra("from", this.mFrom);
            startActivityForResult(intent, 1);
            hpq.O000000o().O00000o0();
        }
    }

    class O0000O0o extends BaseAdapter {

        /* renamed from: O000000o  reason: collision with root package name */
        int f11033O000000o = -1;

        public final long getItemId(int i) {
            return (long) i;
        }

        O0000O0o() {
        }

        public final int getCount() {
            return SmarthomeCreateAutoSceneActivity.this.O0000o00.length;
        }

        public final Object getItem(int i) {
            return Integer.valueOf(SmarthomeCreateAutoSceneActivity.this.O0000o00[i]);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = SmarthomeCreateAutoSceneActivity.this.O00000oO.inflate((int) R.layout.smarthome_select_scene_mode_dialog_item, viewGroup, false);
            }
            ImageView imageView = (ImageView) view.findViewById(R.id.right_arrow);
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.room_icon);
            TextView textView = (TextView) view.findViewById(R.id.room_name);
            textView.setText(SmarthomeCreateAutoSceneActivity.this.O0000o00[i]);
            if (i == this.f11033O000000o) {
                imageView.setVisibility(0);
                simpleDraweeView.setImageURI(gqd.O000000o(SmarthomeCreateAutoSceneActivity.this.O0000o0O[i]));
                textView.setTextColor(ContextCompat.O00000o0(SmarthomeCreateAutoSceneActivity.this.O0000OOo, R.color.class_text_17));
            } else {
                imageView.setVisibility(4);
                simpleDraweeView.setImageURI(gqd.O000000o(SmarthomeCreateAutoSceneActivity.this.O0000o0[i]));
                textView.setTextColor(ContextCompat.O00000o0(SmarthomeCreateAutoSceneActivity.this.O0000OOo, R.color.mj_color_gray_heavier));
            }
            return view;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            mScene.O0000Ooo = 0;
            Intent intent = new Intent(this.O0000OOo, StartConditionActivityNew.class);
            intent.putExtra("from", this.mFrom);
            startActivityForResult(intent, 1);
            hpq.O000000o().O00000o0();
        } else if (i == 1) {
            mScene.O0000Ooo = 1;
            Intent intent2 = new Intent(this.O0000OOo, StartConditionActivityNew.class);
            intent2.putExtra("from", this.mFrom);
            startActivityForResult(intent2, 1);
            hpq.O000000o().O00000o0();
        }
        refreshUI();
    }

    private void O00000o0() {
        if (mScene.O00000oo.size() >= hod.O0000o) {
            izb.O000000o(this, getResources().getQuantityString(R.plurals.add_action_error, hod.O0000o, Integer.valueOf(hod.O0000o)), 0).show();
        } else if (mScene.O0000O0o != null && mScene.O0000O0o.size() == 1 && mScene.O0000O0o.get(0).f11121O000000o == LAUNCH_TYPE.NFC) {
            startActivityForResult(new Intent(getContext(), NFCActionListActivity.class), 2);
            hpq.O000000o().O00000o0();
        } else {
            startActivityForResult(new Intent(this.O0000OOo, SmartHomeSceneActionChooseActivity.class), 2);
            hpq.O000000o().O00000o0();
        }
    }

    class O00000o0 extends RecyclerView.O000000o<O00000o> implements axe<O00000o> {

        /* renamed from: O000000o  reason: collision with root package name */
        AnimationDrawable f11031O000000o;

        public final /* bridge */ /* synthetic */ axj O000000o(RecyclerView.O000OOo0 o000OOo0, int i) {
            return null;
        }

        public final boolean O00000Oo(int i, int i2) {
            return true;
        }

        public final /* synthetic */ boolean O000000o(RecyclerView.O000OOo0 o000OOo0, int i, int i2, int i3) {
            ImageView imageView;
            O00000o o00000o = (O00000o) o000OOo0;
            if (!SmarthomeCreateAutoSceneActivity.this.mIsInEditMode || (imageView = o00000o.O0000OOo) == null) {
                return false;
            }
            Rect rect = new Rect();
            o00000o.itemView.getGlobalVisibleRect(rect);
            Rect rect2 = new Rect();
            imageView.getGlobalVisibleRect(rect2);
            rect2.left -= rect.left;
            rect2.top -= rect.top;
            return rect2.contains(i2, i3);
        }

        public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            String str;
            O00000o o00000o = (O00000o) o000OOo0;
            SceneApi.O000000o o000000o = SmarthomeCreateAutoSceneActivity.mScene.O0000O0o.get(i);
            int itemViewType = getItemViewType(i);
            boolean z = true;
            if (SmarthomeCreateAutoSceneActivity.this.mIsInEditMode) {
                o00000o.O00000Oo.setVisibility(0);
                o00000o.O0000OOo.setVisibility(0);
                if (itemViewType == 0) {
                    o00000o.O0000Oo.setEnabled(false);
                }
            } else {
                o00000o.O00000Oo.setVisibility(8);
                o00000o.O0000OOo.setVisibility(8);
                if (itemViewType == 0) {
                    o00000o.O0000Oo.setEnabled(true);
                }
            }
            if (itemViewType == 0 || itemViewType == 2) {
                o00000o.O0000OoO.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$O00000o0$n20W9T3tNcbYGosZ2YVrCb1ZJok */

                    public final void onClick(View view) {
                        SmarthomeCreateAutoSceneActivity.O00000o.this.O0000Ooo.setChecked(!SmarthomeCreateAutoSceneActivity.O00000o.this.O0000Ooo.isChecked());
                    }
                });
                o00000o.O0000Ooo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$O00000o0$BaaE3fhcjUEDHpDuA3_Q4mfW09Q */

                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        SmarthomeCreateAutoSceneActivity.O00000o0.this.O000000o(compoundButton, z);
                    }
                });
                if (SmarthomeCreateAutoSceneActivity.mScene.O0000o0O == -1) {
                    o00000o.O0000o00.setVisibility(0);
                    o00000o.O0000Ooo.setVisibility(8);
                    o00000o.O0000o00.setImageDrawable(this.f11031O000000o);
                    this.f11031O000000o.start();
                    o00000o.O0000o00.setOnClickListener(null);
                }
                if (SmarthomeCreateAutoSceneActivity.mScene.O0000o0O == -2) {
                    o00000o.O0000o00.setVisibility(0);
                    o00000o.O0000Ooo.setVisibility(8);
                    o00000o.O0000o00.setImageResource(R.drawable.exclamation_mark);
                    o00000o.O0000o00.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$O00000o0$7FnQLCOedw3itJtXFXZpvIjdCSI */

                        public final void onClick(View view) {
                            SmarthomeCreateAutoSceneActivity.O00000o0.this.O00000Oo(view);
                        }
                    });
                } else {
                    o00000o.O0000o00.setVisibility(8);
                    o00000o.O0000Ooo.setVisibility(0);
                    SwitchButton switchButton = o00000o.O0000Ooo;
                    if (SmarthomeCreateAutoSceneActivity.mScene.O0000o0O != 1) {
                        z = false;
                    }
                    switchButton.setChecked(z);
                }
            }
            if (itemViewType == 0) {
                o00000o.O0000Oo0.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.scene.activity.SmarthomeCreateAutoSceneActivity.O00000o0.AnonymousClass1 */

                    public final void onClick(View view) {
                        if (SmarthomeCreateAutoSceneActivity.mScene != null) {
                            if (TextUtils.isEmpty(SmarthomeCreateAutoSceneActivity.mScene.O00000Oo)) {
                                gqg.O00000Oo((int) R.string.scene_name_empty_toast);
                                return;
                            }
                            Intent intent = new Intent(SmarthomeCreateAutoSceneActivity.this, SceneSettingVoiceAliasActivity.class);
                            intent.putExtra("scene_name", SmarthomeCreateAutoSceneActivity.mScene.O00000Oo);
                            intent.putExtra("scene_id", SmarthomeCreateAutoSceneActivity.mScene.f11131O000000o);
                            intent.putExtra("use_title", SmarthomeCreateAutoSceneActivity.mScene.O0000o00);
                            intent.putStringArrayListExtra("alias_list", SmarthomeCreateAutoSceneActivity.mScene.O0000o0);
                            SmarthomeCreateAutoSceneActivity.this.startActivityForResult(intent, 3);
                        }
                    }
                });
            }
            hnw.O000000o(o00000o.O0000O0o, o000000o);
            o00000o.itemView.setOnClickListener(new View.OnClickListener(o000000o) {
                /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$O00000o0$g9_MFj7yP1pRBO1jWXZahRBCzsQ */
                private final /* synthetic */ SceneApi.O000000o f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    SmarthomeCreateAutoSceneActivity.O00000o0.this.O000000o(this.f$1, view);
                }
            });
            o00000o.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$O00000o0$Yi0TBklUuR0CxNYQP5ZC8bq7q30 */

                public final boolean onLongClick(View view) {
                    return SmarthomeCreateAutoSceneActivity.O00000o0.this.O000000o(view);
                }
            });
            o00000o.O00000Oo.setOnClickListener(new View.OnClickListener(i) {
                /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$O00000o0$ARwBl2hzmrcNPMtIexnSuoJ3aHQ */
                private final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    SmarthomeCreateAutoSceneActivity.O00000o0.this.O000000o(this.f$1, view);
                }
            });
            if (o000000o.f11121O000000o == LAUNCH_TYPE.DEVICE) {
                o00000o.O00000oO.setVisibility(0);
                o00000o.O00000oo.setVisibility(0);
                o00000o.O00000oO.setText(hnw.O00000Oo(SmarthomeCreateAutoSceneActivity.this.O0000OOo, o000000o));
                Room O0000o00 = ggb.O00000Oo().O0000o00(o000000o.O00000o0.f11122O000000o);
                o00000o.O00000oo.setText(O0000o00 == null ? SmarthomeCreateAutoSceneActivity.this.getResources().getString(R.string.tag_recommend_defaultroom) : O0000o00.getName());
                o00000o.O00000o0.setText(o000000o.O00000o0.O00000Oo);
            } else if (o000000o.O00000Oo()) {
                o00000o.O00000oO.setVisibility(0);
                o00000o.O00000oo.setVisibility(0);
                if (TextUtils.equals(o000000o.O0000OoO.f11126O000000o, WeatherConditionType.TYPE_SUNRISE.key) || TextUtils.equals(o000000o.O0000OoO.f11126O000000o, WeatherConditionType.TYPE_SUNSET.key)) {
                    str = SmarthomeCreateAutoSceneActivity.this.getString(R.string.condition_weather_sunrise);
                } else if (TextUtils.equals(o000000o.O0000OoO.f11126O000000o, WeatherConditionType.TYPE_ABOVE_TEMPERATURE.key)) {
                    str = SmarthomeCreateAutoSceneActivity.this.getString(R.string.condition_weather_temperature);
                } else {
                    str = TextUtils.equals(o000000o.O0000OoO.f11126O000000o, WeatherConditionType.TYPE_ABOVE_HUMIDITY.key) ? SmarthomeCreateAutoSceneActivity.this.getString(R.string.condition_weather_humidity) : TextUtils.equals(o000000o.O0000OoO.f11126O000000o, WeatherConditionType.TYPE_ABOVE_AQI.key) ? SmarthomeCreateAutoSceneActivity.this.getString(R.string.condition_weather_aqi) : "";
                }
                o00000o.O00000oO.setText(str);
                o00000o.O00000oo.setVisibility(8);
                o00000o.O00000o0.setText(hnw.O00000o0(SmarthomeCreateAutoSceneActivity.this.O0000OOo, o000000o));
            } else if (o000000o.f11121O000000o == LAUNCH_TYPE.COME_LOC || o000000o.f11121O000000o == LAUNCH_TYPE.LEAVE_LOC || o000000o.f11121O000000o == LAUNCH_TYPE.ENTER_FENCE || o000000o.f11121O000000o == LAUNCH_TYPE.LEAVE_FENCE) {
                o00000o.O00000oO.setVisibility(0);
                o00000o.O00000oo.setVisibility(8);
                o00000o.O00000o0.setText(hnw.O00000o0(SmarthomeCreateAutoSceneActivity.this.O0000OOo, o000000o));
                o00000o.O00000oO.setText(hnw.O000000o(SmarthomeCreateAutoSceneActivity.this.O0000OOo, o000000o));
            } else {
                o00000o.O00000oO.setVisibility(0);
                o00000o.O00000o0.setText(hnw.O00000o0(SmarthomeCreateAutoSceneActivity.this.O0000OOo, o000000o));
                o00000o.O00000oo.setVisibility(8);
                o00000o.O00000oO.setText(hnw.O000000o(SmarthomeCreateAutoSceneActivity.this.O0000OOo, o000000o));
            }
            if (o000000o.f11121O000000o == LAUNCH_TYPE.DEVICE && o000000o.O00000o0 != null && !TextUtils.isEmpty(o000000o.O00000o0.f11122O000000o)) {
                o00000o.O00000o.setVisibility(0);
                Device O00000o0 = fno.O000000o().O00000o0(o000000o.O00000o0.f11122O000000o);
                if (O00000o0 == null) {
                    o00000o.O00000o.setImageResource(R.drawable.ic_scene_invalid);
                    o00000o.O0000O0o.setTag(-1);
                } else if (!O00000o0.isOwner()) {
                    o00000o.O00000o.setImageResource(R.drawable.ic_scene_invalid);
                    o00000o.O0000O0o.setTag(-1);
                } else if (SmarthomeCreateAutoSceneActivity.this.O0000Oo != null && SmarthomeCreateAutoSceneActivity.this.O0000Oo.length > i && !SmarthomeCreateAutoSceneActivity.this.O0000Oo[i]) {
                    o00000o.O00000o.setImageResource(R.drawable.ic_scene_offline);
                    o00000o.O0000O0o.setTag(-2);
                } else if (gge.O000000o().O00000Oo(O00000o0.did) == null) {
                    o00000o.O00000o.setImageResource(R.drawable.ic_scene_otherhome);
                    o00000o.O0000O0o.setTag(-3);
                } else {
                    o00000o.O00000o.setVisibility(8);
                    o00000o.O0000O0o.setTag(0);
                }
            } else if (SmarthomeCreateAutoSceneActivity.this.O0000Oo == null || SmarthomeCreateAutoSceneActivity.this.O0000Oo.length <= i || SmarthomeCreateAutoSceneActivity.this.O0000Oo[i]) {
                o00000o.O00000o.setVisibility(8);
                o00000o.O0000O0o.setTag(0);
            } else {
                o00000o.O00000o.setVisibility(0);
                o00000o.O00000o.setImageResource(R.drawable.ic_scene_offline);
                o00000o.O0000O0o.setTag(-2);
            }
            o00000o.O0000O0o.setOnClickListener(new View.OnClickListener(o00000o) {
                /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$O00000o0$qOgUJyP21MXBHjJxXzTSGO1ec */
                private final /* synthetic */ SmarthomeCreateAutoSceneActivity.O00000o f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    SmarthomeCreateAutoSceneActivity.O00000o0.this.O000000o(this.f$1, view);
                }
            });
        }

        O00000o0() {
            setHasStableIds(true);
            this.f11031O000000o = (AnimationDrawable) SmarthomeCreateAutoSceneActivity.this.getResources().getDrawable(R.drawable.camera_loading);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(CompoundButton compoundButton, boolean z) {
            if (SmarthomeCreateAutoSceneActivity.mScene != null) {
                SmarthomeCreateAutoSceneActivity.mScene.O0000o0O = z ? 1 : 0;
                SmarthomeCreateAutoSceneActivity.this.refreshTitle();
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O00000Oo(View view) {
            SmarthomeCreateAutoSceneActivity.this.getCommonUseSetting();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(SceneApi.O000000o o000000o, View view) {
            if (!SmarthomeCreateAutoSceneActivity.this.mIsInEditMode) {
                if (o000000o.f11121O000000o == LAUNCH_TYPE.DEVICE || o000000o.f11121O000000o == LAUNCH_TYPE.MIKEY || o000000o.f11121O000000o == LAUNCH_TYPE.MIBAND) {
                    Intent intent = new Intent(SmarthomeCreateAutoSceneActivity.this.O0000OOo, StartConditionActivityNew.class);
                    intent.putExtra("from", SmarthomeCreateAutoSceneActivity.this.mFrom);
                    hpq.O000000o().O00000Oo(o000000o);
                    SmarthomeCreateAutoSceneActivity.this.startActivityForResult(intent, 1);
                } else if (o000000o.f11121O000000o == LAUNCH_TYPE.TIMER) {
                    SmarthomeCreateAutoSceneActivity.this.startActivity(new Intent(SmarthomeCreateAutoSceneActivity.this.O0000OOo, SmartHomeSceneTimerActivity.class));
                    hpq.O000000o().O00000Oo(o000000o);
                } else if (o000000o.O00000Oo()) {
                    SmarthomeCreateAutoSceneActivity.this.startActivity(new Intent(SmarthomeCreateAutoSceneActivity.this.O0000OOo, SmarthomeChooseWeatherConditionDetailActivity.class));
                    hpq.O000000o().O00000Oo(o000000o);
                } else if (o000000o.f11121O000000o == LAUNCH_TYPE.COME_LOC || o000000o.f11121O000000o == LAUNCH_TYPE.LEAVE_LOC) {
                    Intent intent2 = new Intent(SmarthomeCreateAutoSceneActivity.this.O0000OOo, StartConditionActivityNew.class);
                    intent2.putExtra("from", SmarthomeCreateAutoSceneActivity.this.mFrom);
                    hpq.O000000o().O00000Oo(o000000o);
                    SmarthomeCreateAutoSceneActivity.this.startActivityForResult(intent2, 1);
                } else if (o000000o.f11121O000000o == LAUNCH_TYPE.ENTER_FENCE || o000000o.f11121O000000o == LAUNCH_TYPE.LEAVE_FENCE) {
                    Intent intent3 = new Intent(SmarthomeCreateAutoSceneActivity.this.O0000OOo, StartConditionActivityNew.class);
                    intent3.putExtra("from", SmarthomeCreateAutoSceneActivity.this.mFrom);
                    hpq.O000000o().O00000Oo(o000000o);
                    SmarthomeCreateAutoSceneActivity.this.startActivityForResult(intent3, 1);
                }
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ boolean O000000o(View view) {
            SmarthomeCreateAutoSceneActivity.this.enterEditMode();
            return true;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(int i, View view) {
            hpq O000000o2 = hpq.O000000o();
            SceneApi.O000000o o000000o = SmarthomeCreateAutoSceneActivity.mScene.O0000O0o.get(i);
            if (o000000o != null && o000000o.O00000o0 != null && !TextUtils.isEmpty(o000000o.O00000o0.f11122O000000o) && o000000o.O00000o0.O0000OoO > 0 && O000000o2.O0000Ooo.containsKey(o000000o.O00000o0.f11122O000000o)) {
                Set set = O000000o2.O0000Ooo.get(o000000o.O00000o0.f11122O000000o);
                if (!set.isEmpty()) {
                    set.remove(Integer.valueOf(o000000o.O00000o0.O0000OoO));
                }
                if (set.isEmpty()) {
                    O000000o2.O0000Ooo.remove(o000000o.O00000o0.f11122O000000o);
                }
            }
            SmarthomeCreateAutoSceneActivity.mScene.O0000O0o.remove(i);
            SmarthomeCreateAutoSceneActivity.this.refreshUI();
            hpq.O000000o().O00000o(SmarthomeCreateAutoSceneActivity.mScene);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(O00000o o00000o, View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            int[] iArr = new int[2];
            Rect rect = new Rect();
            SmarthomeCreateAutoSceneActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            o00000o.f11030O000000o.getLocationOnScreen(iArr);
            iArr[0] = 0;
            iArr[1] = (iArr[1] - rect.top) - gpc.O000000o(40.0f);
            gqg.O000000o();
            if (intValue == -4) {
                gqg.O000000o(iArr, (int) R.string.scene_deleted);
            } else if (intValue == -3) {
                gqg.O000000o(iArr, (int) R.string.smarthome_scene_client_otherhome);
            } else if (intValue == -2) {
                gqg.O000000o(iArr, (int) R.string.smarthome_scene_client_offline);
            } else if (intValue == -1) {
                gqg.O000000o(iArr, (int) R.string.smarthome_scene_client_deleted);
            } else if (intValue == 0) {
            }
        }

        public final int getItemCount() {
            return SmarthomeCreateAutoSceneActivity.mScene.O0000O0o.size();
        }

        public final void b_(int i, int i2) {
            SmarthomeCreateAutoSceneActivity.mScene.O0000O0o.add(i2, SmarthomeCreateAutoSceneActivity.mScene.O0000O0o.remove(i));
            notifyItemMoved(i, i2);
            SmarthomeCreateAutoSceneActivity.this.refreshUI();
        }

        public final long getItemId(int i) {
            return (long) SmarthomeCreateAutoSceneActivity.mScene.O0000O0o.get(i).hashCode();
        }

        public final int getItemViewType(int i) {
            if (SmarthomeCreateAutoSceneActivity.mScene == null || SmarthomeCreateAutoSceneActivity.mScene.O0000O0o == null || i >= SmarthomeCreateAutoSceneActivity.mScene.O0000O0o.size() || i >= SmarthomeCreateAutoSceneActivity.mScene.O0000O0o.size() || SmarthomeCreateAutoSceneActivity.mScene.O0000O0o.get(i).f11121O000000o != LAUNCH_TYPE.CLICK) {
                return 1;
            }
            return ftn.O00000Oo(CoreApi.O000000o().O0000ooO()) ? 2 : 0;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 0) {
                return new O00000o(SmarthomeCreateAutoSceneActivity.this.O00000oO.inflate((int) R.layout.item_scene_click_condition, viewGroup, false));
            }
            if (i == 2) {
                return new O00000o(SmarthomeCreateAutoSceneActivity.this.O00000oO.inflate((int) R.layout.item_scene_click_condition_national, viewGroup, false));
            }
            return new O00000o(SmarthomeCreateAutoSceneActivity.this.O00000oO.inflate((int) R.layout.create_auto_scene_item, viewGroup, false));
        }
    }

    static class O00000o extends axz {

        /* renamed from: O000000o  reason: collision with root package name */
        View f11030O000000o;
        ImageView O00000Oo;
        ImageView O00000o;
        TextView O00000o0;
        TextView O00000oO;
        TextView O00000oo;
        SimpleDraweeView O0000O0o;
        ImageView O0000OOo;
        TextView O0000Oo;
        View O0000Oo0;
        View O0000OoO;
        SwitchButton O0000Ooo;
        ImageView O0000o00;

        O00000o(View view) {
            super(view);
            this.f11030O000000o = view;
            this.O00000o0 = (TextView) view.findViewById(R.id.sub_name);
            this.O00000o = (ImageView) view.findViewById(R.id.device_status_img);
            this.O0000O0o = (SimpleDraweeView) view.findViewById(R.id.image);
            this.O0000OOo = (ImageView) view.findViewById(R.id.img_handle);
            this.O00000Oo = (ImageView) view.findViewById(R.id.del_action_item);
            this.O00000oO = (TextView) view.findViewById(R.id.device_name);
            this.O00000oo = (TextView) view.findViewById(R.id.device_room_name);
            this.O0000Oo0 = view.findViewById(R.id.setting_xiaoai);
            this.O0000Oo = (TextView) view.findViewById(R.id.xiaoai_hint);
            this.O0000OoO = view.findViewById(R.id.setting_common_use);
            this.O0000Ooo = (SwitchButton) view.findViewById(R.id.add_common);
            this.O0000o00 = (ImageView) view.findViewById(R.id.mj_loading);
        }

        public final View getSwipeableContainerView() {
            return this.f11030O000000o;
        }
    }

    class O000000o extends RecyclerView.O000000o<O00000Oo> implements axe<O00000Oo> {
        public final /* bridge */ /* synthetic */ axj O000000o(RecyclerView.O000OOo0 o000OOo0, int i) {
            return null;
        }

        public final boolean O00000Oo(int i, int i2) {
            return true;
        }

        public final /* synthetic */ boolean O000000o(RecyclerView.O000OOo0 o000OOo0, int i, int i2, int i3) {
            ImageView imageView;
            O00000Oo o00000Oo = (O00000Oo) o000OOo0;
            if (!SmarthomeCreateAutoSceneActivity.this.mIsInEditMode || (imageView = o00000Oo.O0000OOo) == null) {
                return false;
            }
            Rect rect = new Rect();
            o00000Oo.itemView.getGlobalVisibleRect(rect);
            Rect rect2 = new Rect();
            imageView.getGlobalVisibleRect(rect2);
            rect2.left -= rect.left;
            rect2.top -= rect.top;
            return rect2.contains(i2, i3);
        }

        public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            JSONArray jSONArray;
            JSONObject optJSONObject;
            CommonSceneOnline O00000Oo;
            String str;
            O00000Oo o00000Oo = (O00000Oo) o000OOo0;
            SceneApi.Action action = SmarthomeCreateAutoSceneActivity.mScene.O00000oo.get(i);
            if (SmarthomeCreateAutoSceneActivity.this.mIsInEditMode) {
                o00000Oo.O00000Oo.setVisibility(0);
                o00000Oo.O0000OOo.setVisibility(0);
            } else {
                o00000Oo.O00000Oo.setVisibility(8);
                o00000Oo.O0000OOo.setVisibility(8);
            }
            boolean z = true;
            if (action.O0000O0o instanceof SceneApi.O000O0o0) {
                o00000Oo.O00000oO.setVisibility(8);
                o00000Oo.O00000oo.setVisibility(8);
                o00000Oo.O0000O0o.setImageURI(gqd.O000000o((int) R.drawable.std_scene_icon_delayed));
                if (action.O0000O0o.O00000oo < 60) {
                    str = SmarthomeCreateAutoSceneActivity.this.getResources().getQuantityString(R.plurals.smarthome_scene_delay_detal_sec, action.O0000O0o.O00000oo % 60, Integer.valueOf(action.O0000O0o.O00000oo % 60));
                } else if (action.O0000O0o.O00000oo % 60 == 0) {
                    str = SmarthomeCreateAutoSceneActivity.this.getResources().getQuantityString(R.plurals.smarthome_scene_delay_detal_min, action.O0000O0o.O00000oo / 60, Integer.valueOf(action.O0000O0o.O00000oo / 60));
                } else {
                    str = String.format(SmarthomeCreateAutoSceneActivity.this.getString(R.string.smarthome_scene_delay_detal_min_sec), SmarthomeCreateAutoSceneActivity.this.getResources().getQuantityString(R.plurals.automation_minute, action.O0000O0o.O00000oo / 60, Integer.valueOf(action.O0000O0o.O00000oo / 60)), SmarthomeCreateAutoSceneActivity.this.getResources().getQuantityString(R.plurals.automation_seconds, action.O0000O0o.O00000oo % 60, Integer.valueOf(action.O0000O0o.O00000oo % 60)));
                }
                o00000Oo.O00000o0.setText(str);
                o00000Oo.itemView.setOnClickListener(new View.OnClickListener(action) {
                    /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$O000000o$oo3FppFdvu8ICenGNvjyltHUsoc */
                    private final /* synthetic */ SceneApi.Action f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        SmarthomeCreateAutoSceneActivity.O000000o.this.O00000Oo(this.f$1, view);
                    }
                });
            } else {
                o00000Oo.itemView.setOnClickListener(new View.OnClickListener(action) {
                    /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$O000000o$xh2tRxa5o6Q0CPxC_XHpwLDDdjA */
                    private final /* synthetic */ SceneApi.Action f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        SmarthomeCreateAutoSceneActivity.O000000o.this.O000000o(this.f$1, view);
                    }
                });
                if (action.O0000O0o instanceof SceneApi.O000OO0o) {
                    o00000Oo.O00000oO.setVisibility(0);
                    o00000Oo.O00000oo.setVisibility(0);
                    hnw.O000000o(o00000Oo.O0000O0o, o00000Oo.O00000oO, action);
                    String str2 = "";
                    if (ggd.O000000o(action.O00000oO)) {
                        o00000Oo.O00000oo.setText(str2);
                        o00000Oo.O00000oo.setVisibility(8);
                    } else {
                        Room O0000o00 = ggb.O00000Oo().O0000o00(action.O0000O0o.O00000o);
                        o00000Oo.O00000oo.setText(O0000o00 == null ? SmarthomeCreateAutoSceneActivity.this.getString(R.string.room_default) : O0000o00.getName());
                        o00000Oo.O00000oo.setVisibility(0);
                    }
                    if (action.O00000oO != null && action.O0000O0o != null && (O00000Oo = hod.O0000OoO().O00000Oo(action.O00000oO, action.O0000O0o.O00000o)) != null && O00000Oo.O00000oO != null) {
                        Iterator<CommonSceneOnline.O000000o> it = O00000Oo.O00000oO.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            CommonSceneOnline.O000000o next = it.next();
                            if (TextUtils.equals(next.f10657O000000o, action.O00000o0) && (next.O0000Oo0 instanceof CommonSceneOnline.O0000OOo)) {
                                CommonSceneOnline.O0000OOo o0000OOo = (CommonSceneOnline.O0000OOo) next.O0000Oo0;
                                if (TextUtils.equals("equal", o0000OOo.O00000oo)) {
                                    str2 = o0000OOo.O00000oO;
                                    break;
                                }
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        Object obj = action.O0000O0o.O00000oO;
                        if ((action.O0000O0o.O00000oO instanceof JSONArray) && (jSONArray = (JSONArray) action.O0000O0o.O00000oO) != null && jSONArray.length() > 0 && (optJSONObject = jSONArray.optJSONObject(0)) != null && optJSONObject.has("value")) {
                            obj = optJSONObject.opt("value");
                        }
                        TextView textView = o00000Oo.O00000o0;
                        textView.setText(action.O00000o0 + " " + obj + str2);
                    } else {
                        o00000Oo.O00000o0.setText(action.O00000o0);
                    }
                } else if (action.O0000O0o instanceof SceneApi.O000O00o) {
                    o00000Oo.O00000oO.setVisibility(8);
                    o00000Oo.O00000oo.setVisibility(8);
                    o00000Oo.O00000o0.setText(action.O00000Oo);
                    SceneApi.O000OOOo O000000o2 = hpr.O00000o0().O000000o(((SceneApi.O000O00o) action.O0000O0o).f11127O000000o);
                    if (O000000o2 != null) {
                        o00000Oo.O0000O0o.setImageURI(gqd.O000000o(hnw.O000000o(O000000o2.O00000o)));
                    } else {
                        o00000Oo.O0000O0o.setImageURI(gqd.O000000o((int) R.drawable.intelligence_icon_default_nor));
                    }
                } else {
                    o00000Oo.O00000oo.setVisibility(8);
                    o00000Oo.O00000oO.setVisibility(8);
                    hnw.O000000o(o00000Oo.O0000O0o, o00000Oo.O00000o0, action);
                }
            }
            o00000Oo.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$O000000o$m5XLCqyAaaf5G8xCfWcPoxD8 */

                public final boolean onLongClick(View view) {
                    return SmarthomeCreateAutoSceneActivity.O000000o.this.O000000o(view);
                }
            });
            o00000Oo.O00000Oo.setOnClickListener(new View.OnClickListener(i) {
                /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$O000000o$JvY6BPs7eXj0ud2Y6SrumelqgU */
                private final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    SmarthomeCreateAutoSceneActivity.O000000o.this.O000000o(this.f$1, view);
                }
            });
            if (SmarthomeCreateAutoSceneActivity.this.O0000OoO == null || SmarthomeCreateAutoSceneActivity.this.O0000OoO.length <= i || !SmarthomeCreateAutoSceneActivity.this.O0000OoO[i]) {
                z = false;
            }
            if (action.O0000O0o instanceof SceneApi.O000O0OO) {
                o00000Oo.O00000o.setVisibility(0);
                if (hod.O0000OoO().O00000Oo(((SceneApi.O000O0OO) action.O0000O0o).f11128O000000o) == null) {
                    o00000Oo.O00000oO.setVisibility(8);
                    o00000Oo.O00000oo.setVisibility(8);
                    o00000Oo.O00000o.setImageResource(R.drawable.ic_scene_invalid);
                    o00000Oo.O0000O0o.setTag(-4);
                } else {
                    o00000Oo.O00000o.setVisibility(8);
                    o00000Oo.O0000O0o.setTag(0);
                }
            } else if (action.O0000O0o instanceof SceneApi.O000O00o) {
                o00000Oo.O00000o.setVisibility(0);
                if (hpr.O00000o0().O000000o(((SceneApi.O000O00o) action.O0000O0o).f11127O000000o) == null) {
                    o00000Oo.O00000oO.setVisibility(8);
                    o00000Oo.O00000oo.setVisibility(8);
                    o00000Oo.O00000o.setImageResource(R.drawable.ic_scene_invalid);
                    o00000Oo.O0000O0o.setTag(-4);
                } else {
                    o00000Oo.O00000o.setVisibility(8);
                    o00000Oo.O0000O0o.setTag(0);
                }
            } else if (!(action.O0000O0o instanceof SceneApi.O000OO0o) || TextUtils.isEmpty(action.O0000O0o.O00000o)) {
                o00000Oo.O00000o.setVisibility(8);
                o00000Oo.O0000O0o.setTag(0);
            } else {
                o00000Oo.O00000o.setVisibility(0);
                Device O00000o0 = fno.O000000o().O00000o0(action.O0000O0o.O00000o);
                if (O00000o0 == null) {
                    o00000Oo.O00000o.setImageResource(R.drawable.ic_scene_invalid);
                    o00000Oo.O0000O0o.setTag(-1);
                } else if (!O00000o0.isOwner()) {
                    o00000Oo.O00000o.setImageResource(R.drawable.ic_scene_invalid);
                    o00000Oo.O0000O0o.setTag(-1);
                } else if (!z) {
                    o00000Oo.O00000o.setImageResource(R.drawable.ic_scene_offline);
                    o00000Oo.O0000O0o.setTag(-2);
                } else if (gge.O000000o().O00000Oo(O00000o0.did) == null) {
                    o00000Oo.O00000o.setImageResource(R.drawable.ic_scene_otherhome);
                    o00000Oo.O0000O0o.setTag(-3);
                } else {
                    o00000Oo.O00000o.setVisibility(8);
                    o00000Oo.O0000O0o.setTag(0);
                }
            }
            o00000Oo.O0000O0o.setOnClickListener(new View.OnClickListener(o00000Oo) {
                /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$O000000o$11bnIrusqnPrwHkNDiOkWbkK_gY */
                private final /* synthetic */ SmarthomeCreateAutoSceneActivity.O00000Oo f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    SmarthomeCreateAutoSceneActivity.O000000o.this.O000000o(this.f$1, view);
                }
            });
        }

        O000000o() {
            setHasStableIds(true);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O00000Oo(SceneApi.Action action, View view) {
            if (!SmarthomeCreateAutoSceneActivity.this.mIsInEditMode) {
                Intent intent = new Intent(SmarthomeCreateAutoSceneActivity.this.O0000OOo, SmartHomeSceneTimerDelay.class);
                hpq.O000000o().O00000Oo(action);
                SmarthomeCreateAutoSceneActivity.this.startActivityForResult(intent, 1);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(SceneApi.Action action, View view) {
            if (!SmarthomeCreateAutoSceneActivity.this.mIsInEditMode && action.f11120O000000o != SceneApi.Action.ACTION_TYPE.TYPE_PUSH.value) {
                Intent intent = new Intent(SmarthomeCreateAutoSceneActivity.this.O0000OOo, SmartHomeSceneActionChooseActivity.class);
                hpq.O000000o().O00000Oo(action);
                SmarthomeCreateAutoSceneActivity.this.startActivityForResult(intent, 2);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ boolean O000000o(View view) {
            SmarthomeCreateAutoSceneActivity.this.enterEditMode();
            return true;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(int i, View view) {
            if (SmarthomeCreateAutoSceneActivity.mScene != null && SmarthomeCreateAutoSceneActivity.mScene.O00000oo != null && SmarthomeCreateAutoSceneActivity.mScene.O00000oo.size() != 0) {
                hpq O000000o2 = hpq.O000000o();
                SceneApi.Action action = SmarthomeCreateAutoSceneActivity.mScene.O00000oo.get(i);
                if (action != null && action.O0000O0o != null && !TextUtils.isEmpty(action.O0000O0o.O00000o) && action.O00000oo > 0 && O000000o2.O0000o00.containsKey(action.O0000O0o.O00000o)) {
                    Set set = O000000o2.O0000o00.get(action.O0000O0o.O00000o);
                    if (!set.isEmpty()) {
                        set.remove(Integer.valueOf(action.O00000oo));
                    }
                    if (set.isEmpty()) {
                        O000000o2.O0000o00.remove(action.O0000O0o.O00000o);
                    }
                }
                SmarthomeCreateAutoSceneActivity.mScene.O00000oo.remove(i);
                SmarthomeCreateAutoSceneActivity.this.refreshUI();
                hpq.O000000o().O00000o(SmarthomeCreateAutoSceneActivity.mScene);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(O00000Oo o00000Oo, View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            int[] iArr = new int[2];
            Rect rect = new Rect();
            SmarthomeCreateAutoSceneActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            o00000Oo.f11029O000000o.getLocationOnScreen(iArr);
            iArr[0] = 0;
            iArr[1] = (iArr[1] - rect.top) - gpc.O000000o(40.0f);
            gqg.O000000o();
            if (intValue == -4) {
                gqg.O000000o(iArr, (int) R.string.scene_deleted);
            } else if (intValue == -3) {
                gqg.O000000o(iArr, (int) R.string.smarthome_scene_client_otherhome);
            } else if (intValue == -2) {
                gqg.O000000o(iArr, (int) R.string.smarthome_scene_client_offline);
            } else if (intValue == -1) {
                gqg.O000000o(iArr, (int) R.string.smarthome_scene_client_deleted);
            }
        }

        public final int getItemCount() {
            return SmarthomeCreateAutoSceneActivity.mScene.O00000oo.size();
        }

        public final void b_(int i, int i2) {
            SmarthomeCreateAutoSceneActivity.mScene.O00000oo.add(i2, SmarthomeCreateAutoSceneActivity.mScene.O00000oo.remove(i));
            notifyItemMoved(i, i2);
            SmarthomeCreateAutoSceneActivity.this.refreshUI();
        }

        public final long getItemId(int i) {
            return (long) SmarthomeCreateAutoSceneActivity.mScene.O00000oo.get(i).hashCode();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new O00000Oo(SmarthomeCreateAutoSceneActivity.this.O00000oO.inflate((int) R.layout.create_auto_scene_item, viewGroup, false));
        }
    }

    public void onBackPressed() {
        if (this.mIsInEditMode) {
            O00000Oo(false);
        } else {
            O000000o();
        }
    }

    public void enterEditMode() {
        if (!this.mIsInEditMode) {
            try {
                this.mIsInEditMode = true;
                this.O0000O0o = SceneApi.O000OOOo.O000000o(mScene.O000000o(), mScene.O0000oO0);
                if (this.O0000O0o != null) {
                    refreshTitle();
                    this.O00000o0.notifyDataSetChanged();
                    this.f11005O000000o.notifyDataSetChanged();
                    this.mAddContionTV.setEnabled(false);
                    this.mAddActionTV.setEnabled(false);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void O00000Oo(boolean z) {
        try {
            if (this.mIsInEditMode) {
                this.mIsInEditMode = false;
                if (!z && this.O0000O0o != null) {
                    mScene = SceneApi.O000OOOo.O000000o(this.O0000O0o.O000000o(), this.O0000O0o.O0000oO0);
                }
                hpq.O000000o().O00000o(mScene);
                hpq.O000000o().O00000Oo(mScene);
                hpq.O000000o().O00000o0(mScene);
                refreshTitle();
                this.O00000o0.notifyDataSetChanged();
                this.f11005O000000o.notifyDataSetChanged();
                this.mAddContionTV.setEnabled(true);
                this.mAddActionTV.setEnabled(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class O00000Oo extends axz {

        /* renamed from: O000000o  reason: collision with root package name */
        View f11029O000000o;
        ImageView O00000Oo;
        ImageView O00000o;
        TextView O00000o0;
        TextView O00000oO;
        TextView O00000oo;
        SimpleDraweeView O0000O0o;
        ImageView O0000OOo;

        O00000Oo(View view) {
            super(view);
            this.f11029O000000o = view;
            this.O00000o0 = (TextView) view.findViewById(R.id.sub_name);
            this.O00000o = (ImageView) view.findViewById(R.id.device_status_img);
            this.O0000O0o = (SimpleDraweeView) view.findViewById(R.id.image);
            this.O0000OOo = (ImageView) view.findViewById(R.id.img_handle);
            this.O00000Oo = (ImageView) view.findViewById(R.id.del_action_item);
            this.O00000oO = (TextView) view.findViewById(R.id.device_name);
            this.O00000oo = (TextView) view.findViewById(R.id.device_room_name);
        }

        public final View getSwipeableContainerView() {
            return this.f11029O000000o;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        gsy.O00000Oo("SmarthomeCreateAutoSceneActivity", "onActivityResult requestCode " + i + "  resultCode  " + i2);
        if (i == 1000 && i2 == -1) {
            if (intent == null) {
                refreshUI();
            } else if (intent.hasExtra("scene_deleted") && intent.getBooleanExtra("scene_deleted", false)) {
                finish();
            } else if (!intent.hasExtra("scene_remaned") || !intent.getBooleanExtra("scene_remaned", false)) {
                refreshUI();
            } else {
                String str = mScene.f11131O000000o;
                SceneApi.O000OOOo O00000Oo2 = hod.O0000OoO().O00000Oo(str);
                mScene = O00000Oo2;
                if (O00000Oo2 == null) {
                    mScene = hpr.O00000o0().O000000o(str);
                }
                refreshUI();
            }
        } else if (i == 3 && i2 == -1) {
            SceneApi.O000OOOo o000OOOo = mScene;
            o000OOOo.O0000o00 = intent.getIntExtra("use_title", o000OOOo.O0000o00);
            mScene.O0000o0 = intent.getStringArrayListExtra("alias_list");
            this.O0000oO0 = intent.getStringArrayListExtra("voice_control_deny_list");
            refreshTitle();
        } else if (i2 == -1) {
            refreshUI();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.O0000oo) {
            refreshUI();
        } else {
            this.O0000oo = true;
        }
        int i = this.mFrom;
        if (i != 1 && i != 2) {
            gsy.O00000Oo("SmarthomeCreateAutoSceneActivity", "misinitsetp" + mIsInitStep + "   mCurrentStep  " + hpq.O000000o().O0000Oo0);
            if (!mIsInitStep) {
                return;
            }
            if (hpq.O000000o().O0000Oo0 == 1) {
                if (this.O0000o) {
                    Intent intent = new Intent(this.O0000OOo, StartConditionActivityNew.class);
                    intent.putExtra("from_main_page", this.O0000o);
                    startActivityForResult(intent, 1);
                    overridePendingTransition(0, 0);
                    hpq.O000000o().O00000o0();
                } else {
                    O00000Oo();
                }
                hpq.O000000o().O0000Oo0 = 2;
            } else if (hpq.O000000o().O0000Oo0 == 2) {
                O00000o0();
                hpq.O000000o().O0000Oo0 = 0;
            } else if (hpq.O000000o().O0000Oo0 == 4) {
                mScene.O0000O0o.clear();
                hpq.O000000o().O00000o(mScene);
                if (!this.O0000o) {
                    O00000Oo();
                    hpq.O000000o().O0000Oo0 = 2;
                    return;
                }
                finish();
                hpq.O000000o().O0000Oo0 = 0;
            } else if (hpq.O000000o().O0000Oo0 == 3) {
                finish();
                hpq.O000000o().O0000Oo0 = 0;
            } else if (hpq.O000000o().O0000Oo0 == 0) {
                mIsInitStep = false;
            }
        }
    }

    @OnClick({5837})
    public void completeScene() {
        boolean z = true;
        hxi.O00000o.f952O000000o.O000000o("scene_create_click", "from_type", Integer.valueOf(this.mFrom == 1 ? 1 : 2));
        if (hod.O0000OoO().O00000oo || mScene.O0000O0o == null || mScene.O0000O0o.size() != 1 || mScene.O0000O0o.get(0).f11121O000000o != LAUNCH_TYPE.CLICK) {
            Editable text = this.mTextSceneName.getText();
            if (text != null) {
                String errorMessage = getErrorMessage(text.toString());
                if (!TextUtils.isEmpty(errorMessage)) {
                    gqg.O00000Oo(errorMessage);
                    return;
                }
            }
            if (mScene.O0000O0o == null || mScene.O0000O0o.size() != 1 || mScene.O0000O0o.get(0).f11121O000000o != LAUNCH_TYPE.CLICK || !hpr.O00000o0().O00000oO || hpr.O00000o0().O0000O0o.size() + 1 <= 256) {
                Iterator<SceneApi.Action> it = mScene.O00000oo.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    SceneApi.Action next = it.next();
                    if (next.f11120O000000o == 1 && mScene.O0000O0o != null) {
                        for (SceneApi.O000000o O00000oO2 : mScene.O0000O0o) {
                            ((SceneApi.O000OO) next.O0000O0o).O00000Oo = hnw.O00000oO(ServiceApplication.getAppContext(), O00000oO2);
                        }
                    }
                }
                O00000o();
                if (fcb.O000000o().O000000o("show_scene_user_lincense") != -1) {
                    z = false;
                }
                fcb.O000000o().O00000o0("show_scene_user_lincense");
                if (!z) {
                    checkLicenseUpdate();
                } else {
                    DeviceApi.getInstance().getUserLicenseConfig(ServiceApplication.getAppContext(), "scene_privacy_did", new fsm<Boolean, fso>() {
                        /* class com.xiaomi.smarthome.scene.activity.SmarthomeCreateAutoSceneActivity.AnonymousClass17 */

                        public final /* synthetic */ void onSuccess(Object obj) {
                            if (((Boolean) obj).booleanValue()) {
                                SmarthomeCreateAutoSceneActivity.this.checkLicenseUpdate();
                            } else {
                                SmarthomeCreateAutoSceneActivity.this.showLicense(null);
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
            } else {
                gqg.O00000Oo((int) R.string.add_lite_scene_error);
            }
        } else {
            hod.O0000OoO().O000000o(this.O0000ooO);
        }
    }

    @OnClick({5836})
    public void gotoMorePage() {
        if (!TextUtils.isEmpty(this.O0000Oo0) && mScene.O000000o(this.O00000oo)) {
            Intent intent = new Intent(this, SceneMoreActivity.class);
            intent.putExtra("extra_scene_id", this.O0000Oo0);
            intent.putExtra("from", this.mFrom);
            intent.putExtra("extra_device_id", this.O0000oO);
            intent.putExtra("extra_is_lite", mScene.O0000oO0);
            startActivityForResult(intent, 1000);
        }
    }

    public void checkLicenseUpdate() {
        final String O000000o2 = gpv.O000000o("scene_privacy_version", "");
        hsl.O000000o().checkPrivacy(100, O000000o2, new fsm<JSONObject, fso>() {
            /* class com.xiaomi.smarthome.scene.activity.SmarthomeCreateAutoSceneActivity.AnonymousClass18 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                int optInt = jSONObject.optInt("pop_type");
                String optString = jSONObject.optString("change_log");
                String optString2 = jSONObject.optString("ver");
                if (optInt != 0) {
                    SmarthomeCreateAutoSceneActivity.this.showLicense(optString);
                    return;
                }
                if (!TextUtils.equals(O000000o2, optString2)) {
                    gpv.O00000Oo("scene_privacy_version", optString2);
                    DeviceApi.getInstance().setUserLicenseConfig(ServiceApplication.getAppContext(), "scene_privacy_did", "accept", null);
                }
                SmarthomeCreateAutoSceneActivity.this.doCompleteScene();
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
     arg types: [com.xiaomi.smarthome.scene.activity.SmarthomeCreateAutoSceneActivity, ?, ?, com.xiaomi.smarthome.scene.activity.SmarthomeCreateAutoSceneActivity$19]
     candidates:
      _m_j.gqb.O000000o(android.content.Context, int, int, java.lang.Object):java.lang.String
      _m_j.gqb.O000000o(android.app.Activity, java.util.Locale, int, android.widget.TextView):boolean
      _m_j.gqb.O000000o(android.content.Context, int, int, android.text.style.ClickableSpan):android.text.SpannableStringBuilder */
    public void showLicense(String str) {
        new MLAlertDialog.Builder(this).O00000o0().O000000o(gqb.O000000o((Context) this, (int) R.string.scene_user_license_title_1_underline, (int) R.string.scene_user_license_title_1_tpl, (ClickableSpan) new ClickableSpan() {
            /* class com.xiaomi.smarthome.scene.activity.SmarthomeCreateAutoSceneActivity.AnonymousClass19 */

            public final void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(SmarthomeCreateAutoSceneActivity.this.getResources().getColor(R.color.mj_color_class_text_27));
                textPaint.setUnderlineText(true);
            }

            public final void onClick(View view) {
                Locale O0000O0o = fju.O000000o().O0000O0o();
                if (O0000O0o == null) {
                    O0000O0o = Locale.getDefault();
                }
                String O000000o2 = flk.O000000o(O0000O0o);
                SmarthomeCreateAutoSceneActivity smarthomeCreateAutoSceneActivity = SmarthomeCreateAutoSceneActivity.this;
                eyk.O000000o(smarthomeCreateAutoSceneActivity, "https://g.home.mi.com/views/user-terms.html?locale=" + O000000o2 + "&type=scenePrivacy");
            }
        })).O000000o((int) R.string.scene_user_license_title).O000000o((int) R.string.smarthome_share_accept, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$U_1hKYkUnrfLGpGt_A5LY1fN6zM */

            public final void onClick(DialogInterface dialogInterface, int i) {
                SmarthomeCreateAutoSceneActivity.this.O00000Oo(dialogInterface, i);
            }
        }).O00000Oo((int) R.string.smarthome_share_reject, $$Lambda$SmarthomeCreateAutoSceneActivity$Pi9Y2NSE2dKoY1vmqMZ09iGc3hU.INSTANCE).O000000o(false).O00000o().show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(DialogInterface dialogInterface, int i) {
        DeviceApi.getInstance().setUserLicenseConfig(ServiceApplication.getAppContext(), "scene_privacy_did", "accept", null);
        doCompleteScene();
    }

    public void doCompleteScene() {
        SceneApi.O00000Oo o00000Oo;
        if (isNewScene) {
            if (mScene.O0000O0o.size() > 0 && mScene.O00000oo.size() > 0) {
                String O000000o2 = hnw.O000000o(mScene);
                if (!TextUtils.isEmpty(mScene.O00000Oo)) {
                    O000000o2 = mScene.O00000Oo;
                }
                String O000000o3 = gqb.O000000o(O000000o2, hpq.f480O000000o * 2);
                hah.O000000o(this, R.layout.client_input_view_checkbox, O000000o3, getString(R.string.smarthome_scene_set_name), O000000o3, hpq.f480O000000o, new hah.O00000Oo() {
                    /* class com.xiaomi.smarthome.scene.activity.SmarthomeCreateAutoSceneActivity.AnonymousClass20 */

                    public final void O000000o(String str) {
                    }

                    public final void O000000o(ClientRemarkInputView clientRemarkInputView, String str) {
                        CheckBox checkBox = (CheckBox) clientRemarkInputView.findViewById(R.id.enable_push_checkbox);
                        if (checkBox.isChecked()) {
                            SmarthomeCreateAutoSceneActivity.mScene.O0000Oo = true;
                        }
                        SmarthomeCreateAutoSceneActivity.this.mTextSceneName.setText(str);
                        SmarthomeCreateAutoSceneActivity.this.saveNewScene(str, clientRemarkInputView);
                        SmarthomeCreateAutoSceneActivity.this.mCreatedWithNotifyEnable = checkBox.isChecked();
                    }

                    public final String O00000Oo(String str) {
                        for (SceneApi.O000OOOo next : hod.O0000OoO().O00000o0) {
                            if (!TextUtils.equals(next.f11131O000000o, SmarthomeCreateAutoSceneActivity.mScene.f11131O000000o) && TextUtils.equals(next.O00000Oo, str)) {
                                return SmarthomeCreateAutoSceneActivity.this.getString(R.string.scene_modify_name_error);
                            }
                        }
                        for (SceneApi.O000OOOo next2 : hpr.O00000o0().O0000O0o) {
                            if (!TextUtils.equals(next2.f11131O000000o, SmarthomeCreateAutoSceneActivity.mScene.f11131O000000o) && TextUtils.equals(next2.O00000Oo, str)) {
                                return SmarthomeCreateAutoSceneActivity.this.getString(R.string.scene_modify_name_error);
                            }
                        }
                        return "";
                    }
                });
            } else if (mScene.O0000O0o.size() == 0) {
                izb.O000000o(this.O0000OOo, (int) R.string.smarthome_scene_add_start_condition, 0).show();
            } else {
                izb.O000000o(this.O0000OOo, (int) R.string.smarthome_scene_set_fail_at_least_0, 0).show();
            }
        } else if (mScene.O0000O0o.size() <= 0 || mScene.O00000oo.size() <= 0) {
            izb.O000000o(this.O0000OOo, (int) R.string.smarthome_scene_set_fail_at_least_0, 0).show();
        } else {
            if (O00000oO() == 1 && (o00000Oo = this.O0000ooo) != null) {
                o00000Oo.O00000oO = -1;
                o00000Oo.O00000oo = -1;
                o00000Oo.O0000O0o = -1;
                o00000Oo.O0000OOo = -1;
                o00000Oo.O0000Oo0 = null;
            }
            saveNewScene(mScene.O00000Oo, null);
        }
    }

    public void saveNewScene(String str, ClientRemarkInputView clientRemarkInputView) {
        Device O00000o02;
        String str2;
        Device O00000o03;
        String str3;
        if (!gof.O00000o0()) {
            gqg.O00000Oo((int) R.string.network_fake_connected);
        } else if (TextUtils.isEmpty(str)) {
            gqg.O00000Oo((int) R.string.scene_name_empty_toast);
        } else {
            String str4 = null;
            this.mPD = XQProgressDialog.O000000o(this.O0000OOo, null, getResources().getString(R.string.smarthome_scene_saving_scene));
            mScene.O00000Oo = str;
            if (!TextUtils.isEmpty(str) && !mScene.O00000oo.isEmpty()) {
                Iterator<SceneApi.Action> it = mScene.O00000oo.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    SceneApi.Action next = it.next();
                    if (next.O0000O0o != null && (next.O0000O0o instanceof SceneApi.O000OO)) {
                        ((SceneApi.O000OO) next.O0000O0o).O00000Oo = str;
                        break;
                    }
                }
            }
            if (clientRemarkInputView != null) {
                ((InputMethodManager) this.O0000OOo.getSystemService("input_method")).hideSoftInputFromWindow(clientRemarkInputView.getEditText().getWindowToken(), 0);
            }
            boolean z = false;
            for (SceneApi.O000000o next2 : mScene.O0000O0o) {
                if (!(next2.O00000o0 == null || next2.O00000o0.O00000o == null || (O00000o03 = fno.O000000o().O00000o0(next2.O00000o0.f11122O000000o)) == null)) {
                    if (O00000o03.isSubDevice()) {
                        str3 = O00000o03.parentId;
                    } else {
                        str3 = O00000o03.did;
                    }
                    if (hnw.O000000o(fno.O000000o().O00000o0(str3))) {
                        str4 = str3;
                        z = true;
                    }
                }
            }
            if (!z) {
                for (SceneApi.Action next3 : mScene.O00000oo) {
                    if (!(next3.O00000oO == null || next3.O0000O0o.O00000o == null || (O00000o02 = fno.O000000o().O00000o0(next3.O0000O0o.O00000o)) == null)) {
                        if (O00000o02.isSubDevice()) {
                            str2 = O00000o02.parentId;
                        } else {
                            str2 = O00000o02.did;
                        }
                        if (hnw.O000000o(fno.O000000o().O00000o0(str2))) {
                            str4 = str2;
                            z = true;
                        }
                    }
                }
            }
            if (!z || str4 == null) {
                saveGeoInfo();
                return;
            }
            final Device O00000o04 = fno.O000000o().O00000o0(str4);
            if (O00000o04 == null || O00000o04.isOnline) {
                SceneApi.O000000o(mScene);
                SceneInfo O00000o2 = hod.O00000o(mScene);
                this.O0000Ooo.sendEmptyMessageDelayed(100, 10000);
                gsy.O000000o(4, "lumiscene", "is rn plugin, scene in app exec..");
                hpp.O000000o().O000000o(O00000o2, new Callback<SceneInfo>() {
                    /* class com.xiaomi.smarthome.scene.activity.SmarthomeCreateAutoSceneActivity.AnonymousClass2 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        SceneInfo sceneInfo = (SceneInfo) obj;
                        if (SmarthomeCreateAutoSceneActivity.this.O0000Ooo.hasMessages(100)) {
                            SmarthomeCreateAutoSceneActivity.this.O0000Ooo.removeMessages(100);
                            if (sceneInfo != null) {
                                int i = 0;
                                for (int i2 = 0; i2 < sceneInfo.mLaunchList.size(); i2++) {
                                    if (SmarthomeCreateAutoSceneActivity.mScene.O0000O0o.get(i2).O00000o0 != null && (SmarthomeCreateAutoSceneActivity.mScene.O0000O0o.get(i2).O00000o0 instanceof SceneApi.O00000o0)) {
                                        ((SceneApi.O00000o0) SmarthomeCreateAutoSceneActivity.mScene.O0000O0o.get(i2).O00000o0).O0000o00 = sceneInfo.mLaunchList.get(i2).mExtra;
                                    }
                                }
                                if (gfr.O0000Ooo && sceneInfo.mActions.size() != SmarthomeCreateAutoSceneActivity.mScene.O00000oo.size()) {
                                    LogType logType = LogType.GENERAL;
                                    gsy.O00000o0(logType, "lumi_buid_extra", "action length not equal " + O00000o04.did);
                                }
                                while (i < sceneInfo.mActions.size() && i < SmarthomeCreateAutoSceneActivity.mScene.O00000oo.size()) {
                                    if (SmarthomeCreateAutoSceneActivity.mScene.O00000oo.get(i).O0000O0o != null && (SmarthomeCreateAutoSceneActivity.mScene.O00000oo.get(i).O0000O0o instanceof SceneApi.O000OO0o)) {
                                        ((SceneApi.O000OO0o) SmarthomeCreateAutoSceneActivity.mScene.O00000oo.get(i).O0000O0o).f11130O000000o = sceneInfo.mActions.get(i).mExtra;
                                    }
                                    i++;
                                }
                            }
                            SmarthomeCreateAutoSceneActivity.this.saveGeoInfo();
                        }
                    }

                    public final void onFailure(int i, String str) {
                        gsy.O000000o(6, "lumiscene", str);
                        if (SmarthomeCreateAutoSceneActivity.this.O0000Ooo.hasMessages(100)) {
                            SmarthomeCreateAutoSceneActivity.this.O0000Ooo.removeMessages(100);
                        }
                        SmarthomeCreateAutoSceneActivity.this.O0000Ooo.post(new Runnable() {
                            /* class com.xiaomi.smarthome.scene.activity.SmarthomeCreateAutoSceneActivity.AnonymousClass2.AnonymousClass1 */

                            public final void run() {
                                if (SmarthomeCreateAutoSceneActivity.this.isValid()) {
                                    SmarthomeCreateAutoSceneActivity.this.mPD.dismiss();
                                }
                                izb.O000000o(SmarthomeCreateAutoSceneActivity.this.O0000OOo, (int) R.string.smarthome_scene_set_fail, 0).show();
                            }
                        });
                    }
                });
                return;
            }
            this.mPD.dismiss();
            izb.O000000o(this, (int) R.string.smarthome_scene_getway_offline, 0).show();
        }
    }

    public void saveGeoInfo() {
        SceneApi.O0000O0o o0000O0o;
        final int i = 0;
        while (true) {
            if (i < (mScene.O0000O0o == null ? 0 : mScene.O0000O0o.size())) {
                if (mScene.O0000O0o.get(i) != null && mScene.O0000O0o.get(i) != null) {
                    o0000O0o = mScene.O0000O0o.get(i).O0000Oo;
                    break;
                }
                i++;
            } else {
                o0000O0o = null;
                i = -1;
                break;
            }
        }
        if (o0000O0o != null) {
            hob.O000000o().O000000o(this, o0000O0o.O0000o0, o0000O0o.O0000o0o, o0000O0o.O0000o, o0000O0o.O0000Ooo, new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.scene.activity.SmarthomeCreateAutoSceneActivity.AnonymousClass3 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    if (SmarthomeCreateAutoSceneActivity.this.isValid()) {
                        if (jSONObject != null && jSONObject.has("po_id") && i >= 0 && SmarthomeCreateAutoSceneActivity.mScene != null && SmarthomeCreateAutoSceneActivity.mScene.O0000O0o != null && i < SmarthomeCreateAutoSceneActivity.mScene.O0000O0o.size()) {
                            SmarthomeCreateAutoSceneActivity.mScene.O0000O0o.get(i).O0000Oo.O0000o0 = jSONObject.optLong("po_id");
                        }
                        SmarthomeCreateAutoSceneActivity.this.startSaveScene();
                    }
                }

                public final void onFailure(fso fso) {
                    if (SmarthomeCreateAutoSceneActivity.this.isValid()) {
                        SmarthomeCreateAutoSceneActivity.this.mPD.dismiss();
                        izb.O000000o(SmarthomeCreateAutoSceneActivity.this.O0000OOo, (int) R.string.smarthome_scene_set_fail, 0).show();
                    }
                }
            });
        } else {
            startSaveScene();
        }
    }

    public void startSaveScene() {
        if (eys.f15955O000000o) {
            SceneApi.O000OOOo o000OOOo = mScene;
            if (o000OOOo != null) {
                o000OOOo.O00000o = 0;
            }
            hob.O000000o().O000000o(this, mScene, new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.scene.activity.SmarthomeCreateAutoSceneActivity.AnonymousClass4 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    SmarthomeCreateAutoSceneActivity.this.processSaveResponse((JSONObject) obj);
                }

                public final void onFailure(fso fso) {
                    SmarthomeCreateAutoSceneActivity.this.mPD.dismiss();
                    if (fso.f17063O000000o == -23) {
                        izb.O000000o(SmarthomeCreateAutoSceneActivity.this.O0000OOo, (int) R.string.dead_loop_error, 0).show();
                    } else if (fso.f17063O000000o == -22) {
                        izb.O000000o(SmarthomeCreateAutoSceneActivity.this.O0000OOo, (int) R.string.reach_maximum_number, 0).show();
                    } else if (fso.f17063O000000o == -1) {
                        izb.O000000o(SmarthomeCreateAutoSceneActivity.this.getContext(), (int) R.string.smarthome_scene_has_deleted_device, 0).show();
                    } else if (fso.f17063O000000o == -38) {
                        gqg.O00000Oo((int) R.string.scene_create_fail_by_change_hand_auto);
                    } else {
                        izb.O000000o(SmarthomeCreateAutoSceneActivity.this.O0000OOo, (int) R.string.smarthome_scene_set_fail, 0).show();
                    }
                }
            });
            return;
        }
        this.mPD.dismiss();
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(boolean z) {
        if (isValid()) {
            this.O0000Ooo.post(new Runnable(z) {
                /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$kXbYJL0fuecLMREF1XDU2MJuDL4 */
                private final /* synthetic */ boolean f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    SmarthomeCreateAutoSceneActivity.this.O00000o0(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(boolean z) {
        JSONObject jSONObject;
        JSONArray optJSONArray;
        if (this.O0000oOO) {
            try {
                jSONObject = mScene.O000000o();
            } catch (JSONException e) {
                e.printStackTrace();
                jSONObject = null;
            }
            int length = (jSONObject == null || !jSONObject.has("authed") || (optJSONArray = jSONObject.optJSONArray("authed")) == null) ? 0 : optJSONArray.length();
            if (this.mFrom == 1) {
                hxi.O00000o.O000000o(1, System.currentTimeMillis() - this.mEnterTime, mScene.O0000O0o.size(), mScene.O00000oo.size(), length);
            } else {
                hxi.O00000o.O000000o(2, System.currentTimeMillis() - this.mEnterTime, mScene.O0000O0o.size(), mScene.O00000oo.size(), length);
            }
        }
        SceneApi.O000000o O00000o2 = O00000o();
        if (O00000o2 != null) {
            Intent intent = new Intent();
            String str = O00000o2.O00000oO.f11122O000000o;
            String str2 = O00000o2.O00000oO.O0000Oo;
            intent.putExtra("extra_did", str);
            intent.putExtra("extra_event", str2);
            setResult(-1, intent);
        }
        if (z) {
            hpq.O000000o();
            if (hpq.O00000o0(mScene.O0000O0o)) {
                mScene.O0000oO0 = true;
            } else {
                mScene.O0000oO0 = false;
            }
            if (this.mFrom == 1) {
                if (isNewScene) {
                    notifyPlugin(this, true, mScene, this.O0000oO);
                } else {
                    O000000o(this, this.O0000o, true);
                }
            }
            if (!isNewScene) {
                hpq.O000000o();
                boolean O00000o02 = hpq.O00000o0(mScene.O0000O0o);
                hpq.O000000o();
                if (O00000o02 != hpq.O00000o0(this.O00000oo.O0000O0o)) {
                    hpq.O000000o();
                    if (hpq.O00000o0(mScene.O0000O0o)) {
                        if (!TextUtils.isEmpty(this.O0000Oo0)) {
                            hod.O0000OoO().O00000o0(this.O0000Oo0);
                        }
                        CoreApi.O000000o().O00oOoOo();
                        hod.O0000OoO().O00000o();
                        hpr.O00000o0().O000000o(mScene, new fsm() {
                            /* class com.xiaomi.smarthome.scene.activity.SmarthomeCreateAutoSceneActivity.AnonymousClass5 */

                            public final void onSuccess(Object obj) {
                                SmarthomeCreateAutoSceneActivity.this.mPD.dismiss();
                                hpr.O00000o0().O00000Oo();
                            }

                            public final void onFailure(fso fso) {
                                SmarthomeCreateAutoSceneActivity.this.mPD.dismiss();
                            }
                        });
                    } else {
                        hpr O00000o03 = hpr.O00000o0();
                        SceneApi.O000OOOo o000OOOo = mScene;
                        AnonymousClass6 r5 = new fsm() {
                            /* class com.xiaomi.smarthome.scene.activity.SmarthomeCreateAutoSceneActivity.AnonymousClass6 */

                            public final void onSuccess(Object obj) {
                                SmarthomeCreateAutoSceneActivity.this.mPD.dismiss();
                                hpr.O00000o0().O00000Oo();
                                hod.O0000OoO().O00000o0(SmarthomeCreateAutoSceneActivity.mScene);
                                CoreApi.O000000o().O00oOoOo();
                                hod.O0000OoO().O00000o();
                            }

                            public final void onFailure(fso fso) {
                                SmarthomeCreateAutoSceneActivity.this.mPD.dismiss();
                            }
                        };
                        if (O00000o03.O0000O0o.contains(o000OOOo)) {
                            O00000o03.O0000O0o.remove(o000OOOo);
                            O00000o03.O000000o((fsm) null);
                        } else {
                            r5.onSuccess(null);
                        }
                    }
                    izb.O000000o(this.O0000OOo, (int) R.string.smarthome_scene_set_succ, 0).show();
                    setResult(-1);
                    finish();
                    return;
                }
            }
            if (!isNewScene) {
                hpq.O000000o();
                if (hpq.O00000o0(mScene.O0000O0o)) {
                    hpr.O00000o0().O000000o(this.O0000Oo0, mScene);
                    hpr.O00000o0().O00000Oo();
                } else {
                    if (!TextUtils.isEmpty(this.O0000Oo0)) {
                        hod.O0000OoO().O000000o(this.O0000Oo0, mScene);
                    }
                    CoreApi.O000000o().O00oOoOo();
                    hod.O0000OoO().O00000o();
                }
                this.mPD.dismiss();
                izb.O000000o(this.O0000OOo, (int) R.string.smarthome_scene_set_succ, 0).show();
                setResult(-1);
                finish();
                return;
            }
            hpq.O000000o();
            if (hpq.O00000o0(mScene.O0000O0o)) {
                hpr.O00000o0().O000000o(mScene, new fsm() {
                    /* class com.xiaomi.smarthome.scene.activity.SmarthomeCreateAutoSceneActivity.AnonymousClass7 */

                    public final void onSuccess(Object obj) {
                        SmarthomeCreateAutoSceneActivity.this.mPD.dismiss();
                        hpr.O00000o0().O00000Oo();
                    }

                    public final void onFailure(fso fso) {
                        SmarthomeCreateAutoSceneActivity.this.mPD.dismiss();
                    }
                });
            } else {
                hod.O0000OoO().O00000o0(mScene);
                CoreApi.O000000o().O00oOoOo();
                hod.O0000OoO().O00000o();
            }
            hpu.O000000o().O00000o = mScene.f11131O000000o;
            this.mPD.dismiss();
            izb.O000000o(this.O0000OOo, (int) R.string.smarthome_scene_set_succ, 0).show();
            if (this.mFrom == 2) {
                setResult(-1);
            }
        } else {
            izb.O000000o(this.O0000OOo, (int) R.string.local_sync_failed, 0).show();
        }
        finish();
    }

    private static void O000000o(Context context, boolean z, boolean z2) {
        if (z && z2) {
            context.sendBroadcast(new Intent("scene_status_update"));
        }
    }

    public void saveCommonUseSetting(SceneApi.O000OOOo o000OOOo) {
        if (o000OOOo == null) {
            gsy.O00000o0(LogType.SCENE, "createScene", "save clod sucess,commonsetting fail 1");
            O000000o(true);
        } else if (o000OOOo.O0000o0O == -1) {
            gsy.O00000o0(LogType.SCENE, "createScene", "save clod sucess,commonsetting fail 2");
            O000000o(true);
        } else {
            ArrayList arrayList = new ArrayList();
            CommonUsedScene O00000Oo2 = o000OOOo.O00000Oo();
            if (O00000Oo2 == null) {
                gsy.O00000o0(LogType.SCENE, "createScene", "save clod sucess,commonsetting fail 3");
                O000000o(true);
                return;
            }
            arrayList.add(O00000Oo2);
            if (o000OOOo.O0000o0O == 1) {
                hoa.O000000o(this, ggb.O00000Oo().O0000OOo(), arrayList, new fsm<JSONObject, fso>() {
                    /* class com.xiaomi.smarthome.scene.activity.SmarthomeCreateAutoSceneActivity.AnonymousClass8 */

                    public final void onFailure(fso fso) {
                        SmarthomeCreateAutoSceneActivity.this.O000000o(true);
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        SmarthomeCreateAutoSceneActivity.this.O000000o(true);
                    }
                });
            } else {
                hoa.O00000Oo(this, ggb.O00000Oo().O0000OOo(), arrayList, new fsm<JSONObject, fso>() {
                    /* class com.xiaomi.smarthome.scene.activity.SmarthomeCreateAutoSceneActivity.AnonymousClass9 */

                    public final void onFailure(fso fso) {
                        SmarthomeCreateAutoSceneActivity.this.O000000o(true);
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        SmarthomeCreateAutoSceneActivity.this.O000000o(true);
                    }
                });
            }
        }
    }

    public void processSaveResponse(JSONObject jSONObject) {
        String optString = jSONObject.optString("us_id");
        boolean optBoolean = jSONObject.optBoolean("local");
        String optString2 = jSONObject.optString("local_dev");
        mScene.f11131O000000o = optString;
        if (TextUtils.isEmpty(optString2) || !optBoolean) {
            DeviceApi.getInstance().updateSceneAuthData(this, this.O0000oO0, mScene.f11131O000000o, new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.scene.activity.SmarthomeCreateAutoSceneActivity.AnonymousClass10 */

                public final void onFailure(fso fso) {
                    if (SmarthomeCreateAutoSceneActivity.mScene.O0000oO0) {
                        SmarthomeCreateAutoSceneActivity.this.saveCommonUseSetting(SmarthomeCreateAutoSceneActivity.mScene);
                    } else {
                        SmarthomeCreateAutoSceneActivity.this.O000000o(true);
                    }
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    if (SmarthomeCreateAutoSceneActivity.mScene.O0000oO0) {
                        SmarthomeCreateAutoSceneActivity.this.saveCommonUseSetting(SmarthomeCreateAutoSceneActivity.mScene);
                    } else {
                        SmarthomeCreateAutoSceneActivity.this.O000000o(true);
                    }
                }
            });
            return;
        }
        Device O00000o02 = fno.O000000o().O00000o0(optString2);
        if (O00000o02 != null) {
            hpn.O000000o().O000000o(XmPluginHostApi.instance().getDeviceByDid(O00000o02.did), jSONObject.optJSONObject("data").toString(), new MessageCallback() {
                /* class com.xiaomi.smarthome.scene.activity.SmarthomeCreateAutoSceneActivity.AnonymousClass11 */

                public final void onSuccess(Intent intent) {
                    hob.O000000o();
                    hob.O00000Oo(SmarthomeCreateAutoSceneActivity.this, SmarthomeCreateAutoSceneActivity.mScene, new fsm<Void, fso>() {
                        /* class com.xiaomi.smarthome.scene.activity.SmarthomeCreateAutoSceneActivity.AnonymousClass11.AnonymousClass1 */

                        public final void onFailure(fso fso) {
                            SmarthomeCreateAutoSceneActivity.this.O000000o(false);
                        }

                        public final /* synthetic */ void onSuccess(Object obj) {
                            SmarthomeCreateAutoSceneActivity.this.O000000o(true);
                        }
                    });
                }

                public final void onFailure(int i, String str) {
                    gsy.O000000o(6, "lumiscene", str);
                    SmarthomeCreateAutoSceneActivity.this.O000000o(false);
                }
            });
            this.O0000Ooo.sendEmptyMessageDelayed(101, 10000);
        }
    }

    private static SceneApi.O000000o O00000o() {
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

    private int O00000oO() {
        SceneApi.O000OOOo o000OOOo = mScene;
        int i = 0;
        if (o000OOOo == null) {
            return 0;
        }
        for (SceneApi.O000000o next : o000OOOo.O0000O0o) {
            if (!(next.O00000o0 == null || next.O00000o0.O00000oO == -1)) {
                i++;
                this.O0000ooo = next.O00000o0;
            }
        }
        return i;
    }

    public void onDestroy() {
        super.onDestroy();
        hpq.O000000o().O000000o((SceneApi.O000OOOo) null);
        hpq.O000000o().O0000o0 = null;
        Handler handler = this.O0000Ooo;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (isNewScene && this.mCreatedWithNotifyEnable) {
            hja.O000000o o000000o = hja.f18973O000000o;
            if (hja.O000000o.O000000o() && hor.O000000o().toSceneListTabInSceneTab()) {
                hor.O000000o().showNotifyOpenGuideDialogForSmartInSceneTab();
            }
        }
        ConditionDeviceFilter.O000000o(this);
    }

    public void onPause() {
        super.onPause();
        gqg.O000000o();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o(View view) {
        gsy.O000000o(LogType.SCENE, "scene", "启动生效时间段页面");
        startActivity(new Intent(this.O0000OOo, SceneCreateTimeEdit2Activity.class));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(View view) {
        gsy.O000000o(LogType.SCENE, "scene", "启动生效时间段页面");
        startActivity(new Intent(this.O0000OOo, SceneCreateTimeEdit2Activity.class));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        gsy.O000000o(LogType.SCENE, "scene", "启动生效时间段页面");
        startActivity(new Intent(this.O0000OOo, SceneCreateTimeEdit2Activity.class));
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
    private void O00000oo() {
        SceneApi.O000OOOo o000OOOo = mScene;
        if (o000OOOo != null && o000OOOo.O00000oo != null) {
            this.O0000OoO = new boolean[mScene.O00000oo.size()];
            Arrays.fill(this.O0000OoO, false);
            for (int i = 0; i < mScene.O00000oo.size(); i++) {
                if (hnw.O000000o(mScene.O00000oo.get(i)).O00000Oo) {
                    this.O0000OoO[i] = true;
                }
            }
            if (mScene.O0000O0o != null) {
                this.O0000Oo = new boolean[mScene.O0000O0o.size()];
                for (int i2 = 0; i2 < mScene.O0000O0o.size(); i2++) {
                    if (mScene.O0000O0o.get(i2).O00000o0 == null && mScene.O0000O0o.get(i2).O00000oO == null && mScene.O0000O0o.get(i2).O00000oo == null) {
                        this.O0000Oo[i2] = true;
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
                            Device O000000o2 = fno.O000000o().O000000o(str);
                            if (O000000o2 == null) {
                                O000000o2 = fno.O000000o().O00000Oo(str);
                            }
                            this.O0000Oo[i2] = O000000o2 != null && O000000o2.did.equalsIgnoreCase(str) && O000000o2.isOnline;
                        } else {
                            this.O0000Oo[i2] = true;
                        }
                    }
                }
            }
        }
    }

    public boolean isFastClick() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = currentTimeMillis - O00oOooO < 1000;
        O00oOooO = currentTimeMillis;
        return z;
    }

    public static void notifyPlugin(Context context, boolean z, SceneApi.O000OOOo o000OOOo, String str) {
        boolean z2 = true;
        if (!TextUtils.isEmpty(str) && o000OOOo != null) {
            if (o000OOOo.O0000O0o != null) {
                Iterator<SceneApi.O000000o> it = o000OOOo.O0000O0o.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    SceneApi.O000000o next = it.next();
                    if ((next.O00000o0 != null && TextUtils.equals(next.O00000o0.f11122O000000o, str)) || ((next.O00000oo != null && TextUtils.equals(next.O00000oo.f11122O000000o, str)) || (next.O00000oO != null && TextUtils.equals(next.O00000oO.f11122O000000o, str)))) {
                        break;
                    }
                }
                O000000o(context, z, z2);
            }
            if (o000OOOo.O00000oo != null) {
                Iterator<SceneApi.Action> it2 = o000OOOo.O00000oo.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    SceneApi.Action next2 = it2.next();
                    if (next2.O0000O0o != null && TextUtils.equals(next2.O0000O0o.O00000o, str)) {
                        break;
                    }
                }
                O000000o(context, z, z2);
            }
        }
        z2 = false;
        O000000o(context, z, z2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        hrg.O000000o(this, getString(R.string.delete_old_time_span_tips), getString(R.string.sh_common_cancel), getString(R.string.delete), new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SmarthomeCreateAutoSceneActivity.AnonymousClass13 */

            public final void onClick(View view) {
                for (SceneApi.O000000o next : SmarthomeCreateAutoSceneActivity.mScene.O0000O0o) {
                    if (next.O00000o0 != null) {
                        next.O00000o0.O00000oO = -1;
                        next.O00000o0.O00000oo = -1;
                        next.O00000o0.O0000O0o = -1;
                        next.O00000o0.O0000OOo = -1;
                        next.O00000o0.O0000Oo0 = null;
                    }
                }
                if (SmarthomeCreateAutoSceneActivity.mScene.O0000oO == null) {
                    SmarthomeCreateAutoSceneActivity.mScene.O0000oO = new SceneApi.O0000o0();
                }
                SmarthomeCreateAutoSceneActivity.mScene.O0000oOO = true;
                SmarthomeCreateAutoSceneActivity.this.mExeTimeRL.setVisibility(0);
                SmarthomeCreateAutoSceneActivity.this.mExeTimeRL.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeCreateAutoSceneActivity$13$3uWxzyz6S9tqIXbizH0pvbbN9g */

                    public final void onClick(View view) {
                        SmarthomeCreateAutoSceneActivity.AnonymousClass13.this.O000000o(view);
                    }
                });
                SmarthomeCreateAutoSceneActivity.this.refreshUI();
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o(View view) {
                gsy.O000000o(LogType.SCENE, "scene", "启动生效时间段页面");
                SmarthomeCreateAutoSceneActivity.this.startActivity(new Intent(SmarthomeCreateAutoSceneActivity.this.O0000OOo, SceneCreateTimeEdit2Activity.class));
            }
        });
    }
}
