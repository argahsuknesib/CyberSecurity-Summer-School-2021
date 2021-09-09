package com.xiaomi.smarthome.smartconfig.initdevice;

import _m_j.fnn;
import _m_j.fno;
import _m_j.fqv;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gfx;
import _m_j.ggb;
import _m_j.gge;
import _m_j.gof;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.gue;
import _m_j.gvd;
import _m_j.gvf;
import _m_j.gvk;
import _m_j.haf;
import _m_j.hog;
import _m_j.hor;
import _m_j.htr;
import _m_j.hxi;
import _m_j.hxk;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.facebook.drawee.view.SimpleDraweeView;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.api.DeviceApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.plugin.SendMessageCallback;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.CommonFlowGroup;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.multikey.PowerMultikeyActivity;
import com.xiaomi.smarthome.smartconfig.initdevice.InitDeviceRoomActivity;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RouterService
public class InitDeviceRoomActivity extends BaseActivity {
    private String leftCurtain;
    public boolean mCanJumpMiBrain = false;
    public boolean mCanJumpShare = false;
    public boolean mCanSwicthMiSoundGateway = false;
    public List<String> mCreateTagList = new ArrayList();
    @BindView(7220)
    RelativeLayout mCurrentHome;
    public String mCurrentHomeId;
    public int mCurrentRoomType = 1;
    public List<String> mDefaultTagList = new ArrayList();
    public Device mDevice;
    @BindView(6425)
    SimpleDraweeView mDeviceImg;
    private String mDeviceName;
    private List<String> mDidList = new ArrayList();
    public int mHomeIndex = 0;
    public boolean mHomeSelectFlag = false;
    @BindView(6640)
    CommonFlowGroup mHomeTag;
    private List<String> mHomeTagList = new ArrayList();
    @BindView(6653)
    ImageView mIconImg;
    @BindView(6797)
    LinearLayout mLLCommonCamera;
    @BindView(6803)
    LinearLayout mLlHomes;
    private String mOriginHomeId;
    public XQProgressDialog mProcessDialog;
    @BindView(7169)
    CommonFlowGroup mRecommendFlowView;
    public List<String> mRecommendTagList = new ArrayList();
    @BindView(7241)
    CommonFlowGroup mRoomFlowView;
    @BindView(7263)
    SwitchButton mSbCommon;
    @BindView(7262)
    SwitchButton mSbCommonCamera;
    public String mSelectRoomName;
    @BindView(7365)
    View mSkipTv;
    public int mStepCount = 2;
    @BindView(7614)
    TextView mTvHomeName;
    @BindView(7416)
    TextView mTvStep;
    @BindView(7721)
    View mViewMark;
    private String rightCurtain;
    private String type;

    public void onBackPressed() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_init_device_room);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        if (intent == null) {
            gsy.O00000Oo(LogType.HOME_ROOM, "InitDeviceRoomActivity", "intent is null");
            finish();
            return;
        }
        ArrayList arrayList = new ArrayList();
        String stringExtra = intent.getStringExtra("device_id");
        this.type = intent.getStringExtra("type");
        if (TextUtils.isEmpty(stringExtra)) {
            this.mDidList = intent.getStringArrayListExtra("device_did_list");
            if (isMultiDeviceInit()) {
                arrayList.addAll(this.mDidList);
                this.mDevice = fno.O000000o().O000000o(this.mDidList.get(0));
            }
        } else {
            Room O0000o00 = ggb.O00000Oo().O0000o00(stringExtra);
            Device O000000o2 = fno.O000000o().O000000o(stringExtra);
            if (O0000o00 == null || O000000o2 == null) {
                arrayList.add(stringExtra);
                this.mDevice = fno.O000000o().O000000o(stringExtra);
            } else {
                gsy.O00000o0(LogType.KUAILIAN, "wugan", "ready choose room,but found device has set room, finish it");
                launchPlugin(this, O000000o2);
                finish();
                return;
            }
        }
        if ("group.curtain".equals(this.type)) {
            this.leftCurtain = intent.getStringExtra("device_id_left");
            this.rightCurtain = intent.getStringExtra("device_id_right");
            arrayList.add(this.leftCurtain);
            arrayList.add(this.rightCurtain);
        }
        if (this.mDevice == null) {
            String stringExtra2 = intent.getStringExtra("device_mac");
            if (!TextUtils.isEmpty(stringExtra2)) {
                this.mDevice = fno.O000000o().O00000o(stringExtra2);
            }
        }
        Device device = (Device) htr.O000000o().O000000o("connected_device");
        if (this.mDevice == null && device != null && TextUtils.equals(stringExtra, device.did)) {
            this.mDevice = device;
        }
        if (this.mDevice == null) {
            gsy.O00000o0(LogType.KUAILIAN, "InitDeviceRoomActivity", "mDevice is null");
            showDialog(getString(R.string.mj_loading));
            DeviceApi.getInstance().getDeviceDetail(getContext(), (String[]) arrayList.toArray(new String[0]), new fsm<List<Device>, fso>() {
                /* class com.xiaomi.smarthome.smartconfig.initdevice.InitDeviceRoomActivity.AnonymousClass1 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    List list = (List) obj;
                    InitDeviceRoomActivity.this.dismissDialog();
                    if (list.size() > 0) {
                        fno.O000000o().O000000o(list);
                        InitDeviceRoomActivity.this.mDevice = (Device) list.get(0);
                        InitDeviceRoomActivity.this.initView();
                        return;
                    }
                    InitDeviceRoomActivity.this.finish();
                    gqg.O00000Oo((int) R.string.toast_failed_retry);
                }

                public final void onFailure(fso fso) {
                    InitDeviceRoomActivity.this.dismissDialog();
                    InitDeviceRoomActivity.this.finish();
                    gqg.O00000Oo((int) R.string.cs_network_error);
                }
            });
            return;
        }
        initView();
    }

    private void launchPlugin(Activity activity, Device device) {
        Activity activity2 = activity;
        PluginApi.getInstance().sendMessage(activity2, device.model, 1, new Intent(), DeviceRouterFactory.getDeviceWrapper().newDeviceStat(device), null, false, new SendMessageCallback() {
            /* class com.xiaomi.smarthome.smartconfig.initdevice.InitDeviceRoomActivity.AnonymousClass7 */
        });
    }

    public void initView() {
        ggb.O00000Oo().O000000o((ggb.O00000o) null);
        DeviceFactory.O00000Oo(this.mDevice.model, this.mDeviceImg);
        this.mLLCommonCamera.setVisibility(gge.O00000Oo(this.mDevice) ? 0 : 8);
        this.mSkipTv.setEnabled(false);
        this.mSkipTv.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.initdevice.$$Lambda$InitDeviceRoomActivity$Rep3_kPYc0ZLqkjFbMNqY1Rp9Q */

            public final void onClick(View view) {
                InitDeviceRoomActivity.this.lambda$initView$0$InitDeviceRoomActivity(view);
            }
        });
        initFlowGroup();
        initHomeSelect();
        initStepNumble();
        this.mSbCommon.setChecked(true);
        this.mSbCommonCamera.setChecked(gge.O00000Oo(this.mDevice));
    }

    public /* synthetic */ void lambda$initView$0$InitDeviceRoomActivity(View view) {
        Home O00000o;
        doSaveDeviceRoom();
        if (!this.mSbCommon.isChecked()) {
            ArrayList arrayList = new ArrayList();
            if (isMultiDeviceInit()) {
                arrayList.addAll(this.mDidList);
            } else {
                Device device = this.mDevice;
                arrayList.add(device != null ? device.did : "");
            }
            gfx.O000000o().O00000Oo(arrayList, new fsm[0]);
        }
        if (gge.O00000Oo(this.mDevice) && (O00000o = ggb.O00000Oo().O00000o(this.mCurrentHomeId)) != null) {
            ArrayList arrayList2 = new ArrayList();
            if (isMultiDeviceInit()) {
                arrayList2.addAll(this.mDidList);
            } else {
                arrayList2.add(this.mDevice.did);
            }
            if (this.mSbCommonCamera.isChecked()) {
                Observable<Boolean> markAsFreq = gue.O000000o().markAsFreq(O00000o, arrayList2);
                if (markAsFreq != null) {
                    markAsFreq.subscribe();
                    return;
                }
                return;
            }
            Observable<Boolean> markAsUnFreq = gue.O000000o().markAsUnFreq(O00000o, arrayList2);
            if (markAsUnFreq != null) {
                markAsUnFreq.subscribe();
            }
        }
    }

    private void initHomeSelect() {
        List<Home> list = ggb.O00000Oo().O0000OoO.O00000Oo;
        final ArrayList arrayList = new ArrayList();
        this.mHomeTagList.clear();
        for (Home next : list) {
            if (next.getShareflag() == 0) {
                arrayList.add(next);
                ggb.O00000Oo();
                String O000000o2 = ggb.O000000o(next);
                if (!TextUtils.isEmpty(O000000o2)) {
                    this.mHomeTagList.add(O000000o2);
                }
            }
        }
        if (arrayList.size() > 1) {
            Home O0000Oo0 = ggb.O00000Oo().O0000Oo0();
            if (O0000Oo0 != null) {
                this.mHomeIndex = arrayList.indexOf(O0000Oo0);
                TextView textView = this.mTvHomeName;
                ggb.O00000Oo();
                textView.setText(ggb.O000000o(O0000Oo0));
                this.mOriginHomeId = O0000Oo0.getId();
            }
            this.mCurrentHomeId = this.mOriginHomeId;
            this.mHomeTag.setData(this.mHomeTagList);
            this.mHomeTag.setSelectIndex(this.mHomeIndex);
            this.mHomeTag.O000000o(Boolean.FALSE);
            this.mHomeTag.setOnTagClickListener(new CommonFlowGroup.O000000o() {
                /* class com.xiaomi.smarthome.smartconfig.initdevice.InitDeviceRoomActivity.AnonymousClass8 */

                public final void O000000o() {
                }

                public final void O000000o(int i) {
                    if (i == InitDeviceRoomActivity.this.mHomeIndex) {
                        hxi.O00000o.O0000Oo("1");
                        return;
                    }
                    List list = arrayList;
                    if (list != null && list.size() > i) {
                        hxi.O00000o.O0000Oo("2");
                        InitDeviceRoomActivity.this.mHomeIndex = i;
                        Home home = (Home) arrayList.get(i);
                        if (home != null) {
                            TextView textView = InitDeviceRoomActivity.this.mTvHomeName;
                            ggb.O00000Oo();
                            textView.setText(ggb.O000000o(home));
                            InitDeviceRoomActivity.this.mCurrentHomeId = home.getId();
                            InitDeviceRoomActivity.this.mCreateTagList.clear();
                            InitDeviceRoomActivity.this.mSkipTv.setEnabled(false);
                            InitDeviceRoomActivity.this.refreshFlowView();
                        }
                        InitDeviceRoomActivity initDeviceRoomActivity = InitDeviceRoomActivity.this;
                        initDeviceRoomActivity.mHomeSelectFlag = !initDeviceRoomActivity.mHomeSelectFlag;
                        InitDeviceRoomActivity.this.mIconImg.setImageResource(R.drawable.icon_select_expand);
                        InitDeviceRoomActivity.this.mLlHomes.setVisibility(8);
                    }
                }
            });
            this.mCurrentHome.setVisibility(0);
            this.mCurrentHome.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.smartconfig.initdevice.InitDeviceRoomActivity.AnonymousClass9 */

                public final void onClick(View view) {
                    InitDeviceRoomActivity initDeviceRoomActivity = InitDeviceRoomActivity.this;
                    initDeviceRoomActivity.mHomeSelectFlag = !initDeviceRoomActivity.mHomeSelectFlag;
                    if (InitDeviceRoomActivity.this.mHomeSelectFlag) {
                        InitDeviceRoomActivity.this.mIconImg.setImageResource(R.drawable.icon_select_pickup);
                        InitDeviceRoomActivity.this.mLlHomes.setVisibility(0);
                        return;
                    }
                    hxi.O00000o.O0000Oo("1");
                    InitDeviceRoomActivity.this.mIconImg.setImageResource(R.drawable.icon_select_expand);
                    InitDeviceRoomActivity.this.mLlHomes.setVisibility(8);
                }
            });
            this.mViewMark.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.smartconfig.initdevice.InitDeviceRoomActivity.AnonymousClass10 */

                public final void onClick(View view) {
                    hxi.O00000o.O0000Oo("1");
                    InitDeviceRoomActivity initDeviceRoomActivity = InitDeviceRoomActivity.this;
                    initDeviceRoomActivity.mHomeSelectFlag = !initDeviceRoomActivity.mHomeSelectFlag;
                    InitDeviceRoomActivity.this.mIconImg.setImageResource(R.drawable.icon_select_expand);
                    InitDeviceRoomActivity.this.mLlHomes.setVisibility(8);
                }
            });
        }
    }

    private void initStepNumble() {
        boolean z;
        showDialog(getString(R.string.mj_loading));
        if (isMultiDeviceInit()) {
            int i = 0;
            while (true) {
                if (i >= this.mDidList.size()) {
                    z = false;
                    break;
                }
                Device O000000o2 = fno.O000000o().O000000o(this.mDidList.get(i));
                if (O000000o2 != null && DeviceRouterFactory.getDeviceWrapper().canBeShared(O000000o2)) {
                    z = true;
                    break;
                }
                i++;
            }
            if (z) {
                this.mStepCount++;
                this.mCanJumpShare = true;
            } else {
                this.mCanJumpShare = false;
            }
        } else if (DeviceRouterFactory.getDeviceWrapper().canBeShared(this.mDevice)) {
            this.mStepCount++;
            this.mCanJumpShare = true;
        } else {
            this.mCanJumpShare = false;
        }
        if (isMultiDeviceInit()) {
            this.mStepCount--;
        }
        final AnonymousClass11 r0 = new fsm<ArrayList<hog>, fso>() {
            /* class com.xiaomi.smarthome.smartconfig.initdevice.InitDeviceRoomActivity.AnonymousClass11 */

            public final void onFailure(fso fso) {
                InitDeviceRoomActivity.this.dismissDialog();
                TextView textView = InitDeviceRoomActivity.this.mTvStep;
                textView.setText("1/" + InitDeviceRoomActivity.this.mStepCount);
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                if (hor.O000000o().isShowRecSceneInitDeviceStep(InitDeviceRoomActivity.this.mDevice)) {
                    InitDeviceRoomActivity.this.mStepCount++;
                }
                InitDeviceRoomActivity.this.dismissDialog();
                InitDeviceRoomActivity.this.mTvStep.setText("1/" + InitDeviceRoomActivity.this.mStepCount);
            }
        };
        ArrayList arrayList = new ArrayList();
        if (isMultiDeviceInit()) {
            arrayList.addAll(this.mDidList);
        } else {
            arrayList.add(this.mDevice.did);
        }
        gvd O000000o3 = gvf.O000000o();
        if (O000000o3 != null) {
            O000000o3.syncDeviceIsMiBrain(arrayList, false, new fsm() {
                /* class com.xiaomi.smarthome.smartconfig.initdevice.InitDeviceRoomActivity.AnonymousClass12 */

                public final void onSuccess(Object obj) {
                    if (obj != null && (obj instanceof gvk)) {
                        gvk gvk = (gvk) obj;
                        if (gvk.f18378O000000o != null) {
                            Iterator<gvk.O000000o> it = gvk.f18378O000000o.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    gvk.O000000o next = it.next();
                                    if (next != null && TextUtils.equals(InitDeviceRoomActivity.this.mDevice.did, next.f18379O000000o)) {
                                        InitDeviceRoomActivity.this.mCanJumpMiBrain = true;
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                        }
                        InitDeviceRoomActivity.this.mCanSwicthMiSoundGateway = gvk.O00000Oo;
                    }
                    if (!InitDeviceRoomActivity.this.mCanJumpShare && (InitDeviceRoomActivity.this.mCanJumpMiBrain || InitDeviceRoomActivity.this.mCanSwicthMiSoundGateway)) {
                        InitDeviceRoomActivity.this.mStepCount++;
                    }
                    InitDeviceRoomActivity.this.getRecommendScene(r0);
                }

                public final void onFailure(fso fso) {
                    InitDeviceRoomActivity initDeviceRoomActivity = InitDeviceRoomActivity.this;
                    initDeviceRoomActivity.mCanJumpMiBrain = false;
                    initDeviceRoomActivity.mCanSwicthMiSoundGateway = false;
                    initDeviceRoomActivity.getRecommendScene(r0);
                }
            });
            return;
        }
        r0.onFailure(null);
        gsy.O00000o0(LogType.KUAILIAN, "initStepNumble", "miBrainManagerApi == null");
    }

    public void getRecommendScene(fsm<ArrayList<hog>, fso> fsm) {
        hor.O000000o().clearInitDeviceRecommendSceneHelper();
        if (isMultiDeviceInit()) {
            fsm.onFailure(null);
        } else {
            hor.O000000o().getPluginRecommendSceneInitDevice(this.mCurrentHomeId, this.mDevice.did, fsm);
        }
    }

    private void initFlowGroup() {
        if (this.mDevice != null) {
            this.mRecommendFlowView.O000000o(Boolean.FALSE);
            this.mRoomFlowView.setOnTagClickListener(new CommonFlowGroup.O000000o() {
                /* class com.xiaomi.smarthome.smartconfig.initdevice.InitDeviceRoomActivity.AnonymousClass13 */

                public final void O000000o() {
                    hxi.O00000o.f952O000000o.O000000o("adddevice_addroom_click", new Object[0]);
                    if (InitDeviceRoomActivity.this.mDefaultTagList.size() >= 50) {
                        gqg.O00000Oo((int) R.string.exceed_room_max_count);
                    } else {
                        haf.O000000o(InitDeviceRoomActivity.this, new haf.O000000o() {
                            /* class com.xiaomi.smarthome.smartconfig.initdevice.$$Lambda$InitDeviceRoomActivity$13$hqNNRQhHvqiWDQk7vCMqkzqeNLI */

                            public final void onSuccess(String str) {
                                InitDeviceRoomActivity.AnonymousClass13.this.O000000o(str);
                            }
                        });
                    }
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O000000o(String str) {
                    InitDeviceRoomActivity.this.runOnUiThread(new Runnable(str) {
                        /* class com.xiaomi.smarthome.smartconfig.initdevice.$$Lambda$InitDeviceRoomActivity$13$u7auXyPIqLhiDwxPGu4zXo3TLEk */
                        private final /* synthetic */ String f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            InitDeviceRoomActivity.AnonymousClass13.this.O00000Oo(this.f$1);
                        }
                    });
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O00000Oo(String str) {
                    hxi.O00000o.f952O000000o.O000000o("adddevice_addroom_submit", new Object[0]);
                    String trim = str == null ? "" : str.trim();
                    InitDeviceRoomActivity initDeviceRoomActivity = InitDeviceRoomActivity.this;
                    initDeviceRoomActivity.mSelectRoomName = trim;
                    initDeviceRoomActivity.mRecommendFlowView.setSelectIndex(-1);
                    if (InitDeviceRoomActivity.this.mDefaultTagList.contains(trim)) {
                        InitDeviceRoomActivity.this.mRoomFlowView.setSelectIndex(InitDeviceRoomActivity.this.mDefaultTagList.indexOf(trim));
                    } else {
                        InitDeviceRoomActivity.this.mCreateTagList.add(trim);
                        InitDeviceRoomActivity.this.refreshFlowView();
                        InitDeviceRoomActivity.this.mRoomFlowView.setSelectIndex(InitDeviceRoomActivity.this.mDefaultTagList.size() - 1);
                    }
                    InitDeviceRoomActivity initDeviceRoomActivity2 = InitDeviceRoomActivity.this;
                    initDeviceRoomActivity2.mCurrentRoomType = 2;
                    initDeviceRoomActivity2.mSkipTv.setEnabled(true);
                }

                public final void O000000o(int i) {
                    if (InitDeviceRoomActivity.this.mDefaultTagList.size() > i) {
                        InitDeviceRoomActivity initDeviceRoomActivity = InitDeviceRoomActivity.this;
                        initDeviceRoomActivity.mSelectRoomName = initDeviceRoomActivity.mDefaultTagList.get(i);
                    }
                    InitDeviceRoomActivity.this.mRecommendFlowView.setSelectIndex(-1);
                    InitDeviceRoomActivity.this.mSkipTv.setEnabled(true);
                    InitDeviceRoomActivity.this.mCurrentRoomType = 1;
                    hxi.O00000o.f952O000000o.O000000o("adddevice_myroom_click", new Object[0]);
                }
            });
            this.mRecommendFlowView.setOnTagClickListener(new CommonFlowGroup.O000000o() {
                /* class com.xiaomi.smarthome.smartconfig.initdevice.InitDeviceRoomActivity.AnonymousClass14 */

                public final void O000000o() {
                }

                public final void O000000o(int i) {
                    if (InitDeviceRoomActivity.this.mDefaultTagList.size() >= 50) {
                        gqg.O00000Oo((int) R.string.exceed_room_max_count);
                        InitDeviceRoomActivity.this.mRecommendFlowView.setSelectIndex(-1);
                    } else if (InitDeviceRoomActivity.this.mRecommendTagList.get(i) != null) {
                        InitDeviceRoomActivity initDeviceRoomActivity = InitDeviceRoomActivity.this;
                        initDeviceRoomActivity.mSelectRoomName = initDeviceRoomActivity.mRecommendTagList.get(i);
                        hxk hxk = hxi.O00000o;
                        String str = InitDeviceRoomActivity.this.mSelectRoomName;
                        hxk.f952O000000o.O000000o("adddevice_suggestroom_click", "name", str);
                        InitDeviceRoomActivity.this.mRoomFlowView.setSelectIndex(-1);
                        InitDeviceRoomActivity initDeviceRoomActivity2 = InitDeviceRoomActivity.this;
                        initDeviceRoomActivity2.mCurrentRoomType = 3;
                        initDeviceRoomActivity2.mSkipTv.setEnabled(true);
                    }
                }
            });
            refreshFlowView();
            Room room = ggb.O00000Oo().O0000o0;
            if ("group.curtain".equals(this.type)) {
                room = ggb.O00000Oo().O0000o00(this.leftCurtain);
            }
            if (room == null) {
                this.mRoomFlowView.setSelectIndex(-1);
                return;
            }
            for (int i = 0; i < this.mDefaultTagList.size(); i++) {
                String str = this.mDefaultTagList.get(i);
                if (str.equals(room.getName())) {
                    this.mRoomFlowView.setSelectIndex(i);
                    this.mSelectRoomName = str;
                    this.mCurrentRoomType = 1;
                    this.mSkipTv.setEnabled(true);
                    return;
                }
            }
        }
    }

    public void refreshFlowView() {
        updateRoomDate();
        this.mRoomFlowView.setData(this.mDefaultTagList);
        this.mRecommendFlowView.setData(this.mRecommendTagList);
    }

    private void updateRoomDate() {
        if (TextUtils.isEmpty(this.mCurrentHomeId)) {
            this.mCurrentHomeId = ggb.O00000Oo().O0000OOo();
        }
        List<Room> O000000o2 = ggb.O00000Oo().O000000o(this.mCurrentHomeId);
        ArrayList arrayList = new ArrayList();
        for (Room name : O000000o2) {
            arrayList.add(name.getName());
        }
        this.mCreateTagList.removeAll(arrayList);
        arrayList.addAll(this.mCreateTagList);
        this.mDefaultTagList = arrayList;
        fnn.O000000o().O00000Oo();
        List<String> O0000o = fqv.O0000o();
        for (String remove : this.mDefaultTagList) {
            O0000o.remove(remove);
        }
        this.mRecommendTagList = O0000o;
    }

    private void doSaveDeviceRoom() {
        if (!isMultiDeviceInit()) {
            goNext();
            return;
        }
        XQProgressDialog xQProgressDialog = this.mProcessDialog;
        if (xQProgressDialog == null || !xQProgressDialog.isShowing()) {
            this.mProcessDialog = new XQProgressDialog(this);
            this.mProcessDialog.setCancelable(true);
            this.mProcessDialog.setMessage(getResources().getString(R.string.loading_share_info));
            this.mProcessDialog.show();
        }
        List<Room> O000000o2 = ggb.O00000Oo().O000000o(ggb.O00000Oo().O0000OOo());
        ArrayList arrayList = new ArrayList();
        for (Room name : O000000o2) {
            arrayList.add(name.getName());
        }
        LogType logType = LogType.HOME_ROOM;
        gsy.O00000Oo(logType, "InitDeviceRoomActivity", "multi init doSaveDeviceRoom  RoomName:" + this.mSelectRoomName + " names:" + arrayList);
        if (arrayList.contains(this.mSelectRoomName)) {
            doSaveDeviceToRoom();
        } else if (TextUtils.isEmpty(this.mSelectRoomName) || getString(R.string.default_room).equals(this.mSelectRoomName)) {
            doSaveDeviceToDefaultRoom();
        } else {
            createRoom();
        }
    }

    private void createRoom() {
        LogType logType = LogType.HOME_ROOM;
        gsy.O00000Oo(logType, "InitDeviceRoomActivity", "multi init createRoom  did:" + this.mDevice.did);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.mDidList);
        ggb.O00000Oo().O000000o(this.mSelectRoomName, arrayList, (String) null, new ggb.O00000o() {
            /* class com.xiaomi.smarthome.smartconfig.initdevice.InitDeviceRoomActivity.AnonymousClass2 */

            public final void O000000o() {
                if (InitDeviceRoomActivity.this.isValid()) {
                    InitDeviceRoomActivity.this.doSaveDeviceToRoom();
                }
            }

            public final void O000000o(int i, fso fso) {
                if (fso != null && fso.f17063O000000o == -35) {
                    O000000o();
                } else if (InitDeviceRoomActivity.this.isValid()) {
                    gqg.O00000Oo((int) R.string.set_room_fail);
                    gsy.O00000Oo(LogType.HOME_ROOM, "InitDeviceRoomActivity", "error".concat(String.valueOf(fso)));
                    if (InitDeviceRoomActivity.this.mProcessDialog != null && InitDeviceRoomActivity.this.mProcessDialog.isShowing()) {
                        InitDeviceRoomActivity.this.mProcessDialog.dismiss();
                    }
                }
            }
        });
    }

    public void doSaveDeviceToRoom() {
        Room room = null;
        for (Room next : ggb.O00000Oo().O000000o(ggb.O00000Oo().O0000OOo())) {
            if (TextUtils.equals(next.getName(), this.mSelectRoomName)) {
                room = next;
            }
        }
        gsy.O00000Oo(LogType.HOME_ROOM, "InitDeviceRoomActivity", "multi init doSaveDeviceToRoom  room:".concat(String.valueOf(room)));
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.mDidList);
        if (room == null || TextUtils.isEmpty(room.getId())) {
            doSaveDeviceToDefaultRoom();
        } else {
            ggb.O00000Oo().O000000o(room, arrayList, (List<String>) null, new ggb.O00000o() {
                /* class com.xiaomi.smarthome.smartconfig.initdevice.InitDeviceRoomActivity.AnonymousClass3 */

                public final void O000000o() {
                    gsy.O00000Oo(LogType.HOME_ROOM, "InitDeviceRoomActivity", "multi init doSaveDeviceToRoom.editRoom  onSuccess");
                    if (InitDeviceRoomActivity.this.isValid()) {
                        InitDeviceRoomActivity.this.goNext();
                    }
                }

                public final void O000000o(int i, fso fso) {
                    if (InitDeviceRoomActivity.this.isValid()) {
                        gsy.O00000Oo(LogType.HOME_ROOM, "InitDeviceRoomActivity", " multi init error".concat(String.valueOf(fso)));
                        gqg.O00000Oo((int) R.string.multikey_noroom_hint);
                        if (InitDeviceRoomActivity.this.mProcessDialog != null && InitDeviceRoomActivity.this.mProcessDialog.isShowing()) {
                            InitDeviceRoomActivity.this.mProcessDialog.dismiss();
                        }
                    }
                }
            });
        }
    }

    private void doSaveDeviceToDefaultRoom() {
        ggb.O00000Oo().O000000o(ggb.O00000Oo().O0000Oo0(), this.mDidList, new ggb.O00000o() {
            /* class com.xiaomi.smarthome.smartconfig.initdevice.InitDeviceRoomActivity.AnonymousClass4 */

            public final void O000000o() {
                gsy.O00000Oo(LogType.HOME_ROOM, "InitDeviceRoomActivity", "multi init doSaveDeviceToDefaultRoom  bindDeviceToRoom.onSuccess");
                if (InitDeviceRoomActivity.this.isValid()) {
                    InitDeviceRoomActivity.this.goNext();
                }
            }

            public final void O000000o(int i, fso fso) {
                if (InitDeviceRoomActivity.this.isValid()) {
                    gsy.O00000Oo(LogType.HOME_ROOM, "InitDeviceRoomActivity", "multi init error".concat(String.valueOf(fso)));
                    gqg.O00000Oo((int) R.string.tag_recommend_room);
                    if (InitDeviceRoomActivity.this.mProcessDialog != null && InitDeviceRoomActivity.this.mProcessDialog.isShowing()) {
                        InitDeviceRoomActivity.this.mProcessDialog.dismiss();
                    }
                }
            }
        });
    }

    public void goNext() {
        if (!TextUtils.isEmpty(this.mSelectRoomName)) {
            Intent intent = null;
            if (!TextUtils.isEmpty(this.mOriginHomeId) && !TextUtils.isEmpty(this.mCurrentHomeId) && !TextUtils.equals(this.mOriginHomeId, this.mCurrentHomeId)) {
                ggb.O00000Oo().O000000o(this.mCurrentHomeId, (fsm) null);
            }
            hxk hxk = hxi.O00000o;
            StringBuilder sb = new StringBuilder();
            sb.append(this.mCurrentRoomType);
            byte b = 0;
            hxk.f952O000000o.O000000o("adddevice_selectroom_nextstep", "type", sb.toString(), "favorite_device_setting", Integer.valueOf(this.mSbCommon.isChecked() ? 1 : 2), "favorite_bigcard_show", Integer.valueOf(this.mSbCommonCamera.isChecked() ? 1 : 2));
            if (!isMultiDeviceInit()) {
                b = CoreApi.O000000o().O00000oO(this.mDevice.model).O0000oOo;
            }
            if (b <= 1) {
                if (isMultiDeviceInit()) {
                    if (this.mCanJumpMiBrain || this.mCanJumpShare || this.mCanSwicthMiSoundGateway) {
                        intent = new Intent(this, InitShareAndMibrainActivity.class);
                    }
                    if (intent != null) {
                        intent.putExtras(getIntent());
                        setIntentStep(intent);
                        startActivity(intent);
                        finish();
                        return;
                    }
                    InitShareAndMibrainActivity.O000000o(this);
                } else if ("group.curtain".equals(this.type)) {
                    Intent intent2 = new Intent(this, InitCurtainGroupActivity.class);
                    intent2.putExtras(getIntent());
                    setIntentStep(intent2);
                    intent2.putExtra("device_room", this.mSelectRoomName);
                    startActivityForResult(intent2, 102);
                    finish();
                } else {
                    Intent intent3 = new Intent(this, InitDeviceNameActivity.class);
                    intent3.putExtras(getIntent());
                    intent3.putExtra("device_room", this.mSelectRoomName);
                    if (!TextUtils.isEmpty(this.mDeviceName)) {
                        intent3.putExtra("device_name", this.mDeviceName);
                    }
                    setIntentStep(intent3);
                    startActivityForResult(intent3, 100);
                    finish();
                }
            } else if (!gof.O00000o0()) {
                gqg.O00000Oo((int) R.string.popup_select_loc_no_network);
            } else {
                showDialog(getString(R.string.loading_share_info));
                final Intent intent4 = new Intent(this, PowerMultikeyActivity.class);
                intent4.putExtras(getIntent());
                setIntentStep(intent4);
                this.mRoomFlowView.getSelectIndex();
                String str = this.mSelectRoomName;
                Room roomExits = roomExits(str);
                if (roomExits != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.mDevice.did);
                    ggb.O00000Oo().O000000o(roomExits, arrayList, (List<String>) null, new ggb.O00000o() {
                        /* class com.xiaomi.smarthome.smartconfig.initdevice.InitDeviceRoomActivity.AnonymousClass5 */

                        public final void O000000o() {
                            if (InitDeviceRoomActivity.this.isValid()) {
                                InitDeviceRoomActivity.this.startActivityForResult(intent4, 101);
                                InitDeviceRoomActivity.this.dismissDialog();
                                InitDeviceRoomActivity.this.finish();
                            }
                        }

                        public final void O000000o(int i, fso fso) {
                            if (InitDeviceRoomActivity.this.isValid()) {
                                InitDeviceRoomActivity.this.dismissDialog();
                            }
                        }
                    });
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(this.mDevice.did);
                ggb.O00000Oo().O000000o(str, arrayList2, (String) null, new ggb.O00000o() {
                    /* class com.xiaomi.smarthome.smartconfig.initdevice.InitDeviceRoomActivity.AnonymousClass6 */

                    public final void O000000o() {
                        if (InitDeviceRoomActivity.this.isValid()) {
                            InitDeviceRoomActivity.this.startActivityForResult(intent4, 101);
                            InitDeviceRoomActivity.this.dismissDialog();
                            InitDeviceRoomActivity.this.finish();
                        }
                    }

                    public final void O000000o(int i, fso fso) {
                        if (fso != null && fso.f17063O000000o == -35) {
                            O000000o();
                        } else if (InitDeviceRoomActivity.this.isValid()) {
                            InitDeviceRoomActivity.this.dismissDialog();
                        }
                    }
                });
            }
        }
    }

    private void setIntentStep(Intent intent) {
        intent.putExtra("step_count", this.mStepCount);
        intent.putExtra("can_jump_share", this.mCanJumpShare);
        intent.putExtra("can_jump_mibrain", this.mCanJumpMiBrain);
        intent.putExtra("can_show_misound_gateway_switch", this.mCanSwicthMiSoundGateway);
        intent.putExtra("current_step", 1);
    }

    public void dismissDialog() {
        XQProgressDialog xQProgressDialog = this.mProcessDialog;
        if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
            this.mProcessDialog.dismiss();
        }
    }

    private void showDialog(String str) {
        XQProgressDialog xQProgressDialog = this.mProcessDialog;
        if (xQProgressDialog == null || !xQProgressDialog.isShowing()) {
            this.mProcessDialog = new XQProgressDialog(this);
            this.mProcessDialog.setCancelable(true);
            this.mProcessDialog.show();
        }
        this.mProcessDialog.setMessage(str);
    }

    private Room roomExits(String str) {
        for (Room next : ggb.O00000Oo().O000000o(ggb.O00000Oo().O0000OOo())) {
            if (TextUtils.equals(next.getName(), str)) {
                return next;
            }
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 100) {
                startActivity(intent);
            }
            finish();
        }
        if (101 == i) {
            ArrayList arrayList = new ArrayList(this.mDefaultTagList);
            updateRoomDate();
            if (!arrayList.equals(this.mDefaultTagList)) {
                int selectIndex = this.mRoomFlowView.getSelectIndex();
                String str = null;
                if (selectIndex >= 0 && selectIndex < arrayList.size()) {
                    str = arrayList.get(selectIndex);
                }
                this.mRoomFlowView.setData(this.mDefaultTagList);
                this.mRoomFlowView.setSelectIndex(this.mDefaultTagList.indexOf(str));
            }
        }
        if (intent != null) {
            this.mDeviceName = intent.getStringExtra("device_name");
        }
    }

    public void onResume() {
        super.onResume();
        if (this.mDevice != null) {
            int size = ggb.O00000Oo().O0000OoO.O00000Oo != null ? ggb.O00000Oo().O0000OoO.O00000Oo.size() : 1;
            hxi.O00000o0.f957O000000o.O000000o("adddevice_selectroom_show", "model", this.mDevice.model, "familynumber", Integer.valueOf(size));
        }
    }

    public void onPause() {
        super.onPause();
    }

    private boolean isMultiDeviceInit() {
        List<String> list = this.mDidList;
        return list != null && list.size() > 0;
    }
}
