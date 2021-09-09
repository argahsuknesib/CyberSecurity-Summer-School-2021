package com.xiaomi.smarthome.miui10;

import _m_j.chu;
import _m_j.cub;
import _m_j.cuh;
import _m_j.fbn;
import _m_j.fbp;
import _m_j.fbr;
import _m_j.fml;
import _m_j.fno;
import _m_j.frb;
import _m_j.frd;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ft;
import _m_j.fvk;
import _m_j.gfr;
import _m_j.gpc;
import _m_j.gsy;
import _m_j.gwg;
import _m_j.gzb;
import _m_j.gzc;
import _m_j.hbz;
import _m_j.hcc;
import _m_j.hcc.O000000o;
import _m_j.hcd;
import _m_j.hcf;
import _m_j.hcg;
import _m_j.hch;
import _m_j.hcv;
import _m_j.hcz;
import _m_j.hda;
import _m_j.hdg;
import _m_j.hdr;
import _m_j.heb;
import _m_j.hep;
import _m_j.hfa;
import _m_j.hhd;
import _m_j.hhe;
import _m_j.hhi;
import _m_j.hhk;
import _m_j.hte;
import _m_j.htt;
import _m_j.hxi;
import _m_j.hyg;
import _m_j.hzf;
import _m_j.izb;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.cardbridge.PluginDownloadingRecordWrapper;
import com.xiaomi.smarthome.core.entity.Error;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.MiTVDevice;
import com.xiaomi.smarthome.device.api.spec.instance.Spec;
import com.xiaomi.smarthome.device.api.spec.operation.PropertyParam;
import com.xiaomi.smarthome.frame.plugin.SendMessageHandle;
import com.xiaomi.smarthome.framework.page.CommonActivity;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.miui10.MIUI10CardActivity;
import com.xiaomi.smarthome.newui.card.BaseCardRender;
import com.xiaomi.smarthome.newui.card.DeviceCardApi;
import com.xiaomi.smarthome.newui.widget.micards.DownloadProgressProcessor;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MIUI10CardActivity<C extends hcc<E, T>, E extends hcc.O000000o<T>, T> extends CommonActivity implements fvk.O000000o, hhe, DownloadProgressProcessor {
    public static String sRoomName = "";
    private boolean backProcessing = false;
    public boolean fromMiUI = false;
    public boolean isDownloading = false;
    public boolean isInstalling = false;
    public long lastClickDealTime = -1;
    public long lastInstallFinishTime = -1;
    public gzb mActivityControler = new gzb(this);
    public boolean mAnimationStart = false;
    public RectF mCachedRect = null;
    public Pair<C, T[][]> mCard;
    protected Device mDevice;
    private frb mDevicePropSubscriber;
    public hhd mDownloadWrapper;
    public boolean mEnable = true;
    public fvk mHandler;
    public String mModel;
    public View mProcessEnterDevice;
    public hhk mProgressDownload;
    private hda mPropListener = new hda() {
        /* class com.xiaomi.smarthome.miui10.MIUI10CardActivity.AnonymousClass3 */

        public final void onStateChanged(String str, String str2, Object obj) {
            if (MIUI10CardActivity.this.render != null && !TextUtils.isEmpty(str) && MIUI10CardActivity.this.mDevice != null && str.equals(MIUI10CardActivity.this.mDevice.did) && !MIUI10CardActivity.this.mIsPaused) {
                MIUI10CardActivity.this.render.O000000o(str2, obj);
            }
        }
    };
    SendMessageHandle mSendMessageHandle;
    private ViewGroup mViewRoot;
    O000000o pointHandler;
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.miui10.MIUI10CardActivity.AnonymousClass2 */

        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null) {
                if (action.equals("miui.action_refresh_success")) {
                    MIUI10CardActivity.this.mHandler.post(new Runnable() {
                        /* class com.xiaomi.smarthome.miui10.$$Lambda$MIUI10CardActivity$2$d6bxIqWWAuLTY4sj5YrnYPt3pR4 */

                        public final void run() {
                            MIUI10CardActivity.AnonymousClass2.this.O00000o0();
                        }
                    });
                } else if (action.equals("miui.action_refresh_failed")) {
                    MIUI10CardActivity.this.mHandler.post(new Runnable() {
                        /* class com.xiaomi.smarthome.miui10.$$Lambda$MIUI10CardActivity$2$Hw1Ld17mhIUVmozpCXnj8ka2SU0 */

                        public final void run() {
                            MIUI10CardActivity.AnonymousClass2.this.O00000Oo();
                        }
                    });
                } else {
                    MIUI10CardActivity.this.mHandler.post(new Runnable() {
                        /* class com.xiaomi.smarthome.miui10.$$Lambda$MIUI10CardActivity$2$Rho94rQNc49d0aPRM3QS0EcObhE */

                        public final void run() {
                            MIUI10CardActivity.AnonymousClass2.this.O000000o();
                        }
                    });
                }
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O00000o0() {
            MIUI10CardActivity.this.mEnable = true;
            hcv.getInstance().loadPropsFromServer(true, new fsm<Object, fso>() {
                /* class com.xiaomi.smarthome.miui10.MIUI10CardActivity.AnonymousClass2.AnonymousClass1 */

                public final void onFailure(fso fso) {
                }

                public final void onSuccess(Object obj) {
                    if (MIUI10CardActivity.this.render != null && !MIUI10CardActivity.this.mIsPaused) {
                        MIUI10CardActivity.this.render.O000000o((String) null, (Object) null);
                    }
                }
            }, "updatePropValue");
            hcz.getInstance().refreshDeviceProps(true, new fsm<Object, fso>() {
                /* class com.xiaomi.smarthome.miui10.MIUI10CardActivity.AnonymousClass2.AnonymousClass2 */

                public final void onFailure(fso fso) {
                }

                public final void onSuccess(Object obj) {
                    if (MIUI10CardActivity.this.render != null && !MIUI10CardActivity.this.mIsPaused) {
                        MIUI10CardActivity.this.render.O000000o((String) null, (Object) null);
                    }
                }
            });
            if (MIUI10CardActivity.this.render != null) {
                MIUI10CardActivity.this.render.O000000o(BaseCardRender.DataInitState.DONE);
                MIUI10CardActivity.this.render.O000000o((Object) null, (Object) null);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O00000Oo() {
            MIUI10CardActivity mIUI10CardActivity = MIUI10CardActivity.this;
            mIUI10CardActivity.mEnable = false;
            if (mIUI10CardActivity.render != null) {
                MIUI10CardActivity.this.render.O000000o(BaseCardRender.DataInitState.NOT);
                MIUI10CardActivity.this.render.O000000o((Object) null, (Object) null);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o() {
            if (MIUI10CardActivity.this.render != null) {
                MIUI10CardActivity.this.render.O000000o((Object) null, (Object) null);
            }
        }
    };
    private BroadcastReceiver receiver2 = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.miui10.MIUI10CardActivity.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null && action.equals("miui.action_open_floating_window") && MIUI10CardActivity.this.mCard != null && hcg.O000000o(((hcc) MIUI10CardActivity.this.mCard.first).O00000Oo()) && MIUI10CardActivity.this.mHandler != null) {
                MIUI10CardActivity.this.onBackPressed();
            }
        }
    };
    public hbz<C, E, T> render;

    public hdg<C, E, T> getRequestSender() {
        return null;
    }

    public void handleMessage(Message message) {
    }

    public boolean retryNetwork() {
        return true;
    }

    public boolean shouldInstallNow(Device device) {
        return true;
    }

    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHandler = new fvk(this);
        gwg.O00000Oo(getWindow());
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("from");
        if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals("miui")) {
            this.fromMiUI = true;
            getWindow().addFlags(4);
        }
        if (this.fromMiUI) {
            hxi.O00000o.O000000o(true);
        }
        setContentView((int) R.layout.miui10_card_activity);
        this.mViewRoot = (ViewGroup) findViewById(R.id.fl_root);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("miui.action_refresh_success");
        intentFilter.addAction("miui.action_refresh_failed");
        hcv.getInstance().registerStateChangedListener(this.mPropListener);
        hcz.getInstance().registerStateChangedListener(this.mPropListener);
        ft.O000000o(getContext()).O000000o(this.receiver, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("miui.action_open_floating_window");
        registerReceiver(this.receiver2, intentFilter2);
        matchCard(intent);
    }

    public Pair<C, T[][]> getCard() {
        return this.mCard;
    }

    public void matchCard(Intent intent) {
        heb cardInfo;
        String stringExtra = intent.getStringExtra("from");
        String stringExtra2 = intent.getStringExtra("model");
        String stringExtra3 = intent.getStringExtra("did");
        sRoomName = intent.getStringExtra("room_name");
        if (this.mDevice == null) {
            this.mDevice = fno.O000000o().O000000o(stringExtra3);
        }
        if (this.mDevice == null && stringExtra2 == null) {
            hte.O000000o(this, getString(R.string.spec_nodevice_error));
            finish();
            return;
        }
        boolean z = true;
        if (this.mDevice == null) {
            this.mDevice = new Device();
            Device device = this.mDevice;
            device.model = stringExtra2;
            device.did = stringExtra3;
            device.name = intent.getStringExtra("device_name");
            this.mDevice.isOnline = true;
            this.mEnable = false;
        } else {
            hxi.O0000Oo.O000000o(this.mDevice.model, this.fromMiUI, this.mDevice.isOnline, this.mDevice.getPid(), this.mDevice.did);
        }
        this.mModel = this.mDevice.model;
        if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals("miui")) {
            ft.O000000o(this).O000000o(new Intent("miui.action_open_card").putExtra("param_did", stringExtra3));
            try {
                getWindow().setNavigationBarColor(0);
            } catch (Exception unused) {
            }
        }
        this.mViewRoot.setOnClickListener(getCancelListener());
        if (this.mCard == null && !TextUtils.isEmpty(this.mDevice.model) && (cardInfo = hcv.getInstance().getCardInfo(this.mDevice.model)) != null) {
            this.mCard = new Pair<>(cardInfo, (Object[][]) cardInfo.O00000o());
        }
        if (this.mCard == null) {
            if (fml.O000000o().equals(this.mDevice.did)) {
                hdr hdr = new hdr();
                hdr.O00000Oo = 8;
                this.mCard = new Pair<>(hdr, hdr.O00000o());
                gsy.O00000Oo("mijia-card", "OtherCard createIRType model:" + this.mDevice.model + " did:" + this.mDevice.did + " card:" + hdr);
            } else if (this.mDevice instanceof MiTVDevice) {
                hdr hdr2 = new hdr();
                hdr2.O00000Oo = 9;
                this.mCard = new Pair<>(hdr2, hdr.O00000o());
                gsy.O00000Oo("mijia-card", "OtherCard createTVType model:" + this.mDevice.model + " did:" + this.mDevice.did + " card:" + hdr2);
            }
        }
        Pair<C, T[][]> pair = this.mCard;
        if (pair == null || ((hcc) pair.first).O00000Oo == -1) {
            hcz instance = hcz.getInstance();
            Device device2 = this.mDevice;
            if (getRequestSender() == null) {
                z = false;
            }
            Pair<hep, Spec.SpecItem[][]> activityCardPair = instance.getActivityCardPair(device2, z);
            if (activityCardPair == null) {
                gsy.O00000Oo("mijia-card", "no card model:" + this.mModel + " did:" + this.mDevice.did);
            } else {
                this.mCard = new Pair<>((hcc) activityCardPair.first, (Object[][]) activityCardPair.second);
                gsy.O00000Oo("mijia-card", "show card model:" + this.mModel + " specLayoutType:" + ((hcc) this.mCard.first).O00000Oo + " did:" + this.mDevice.did);
            }
            showCard(hch.f18778O000000o);
            return;
        }
        showCard(hch.f18778O000000o);
        gsy.O00000Oo("mijia-card", "show card model:" + this.mModel + " jsonlayoutType:" + this.mCard + " did:" + this.mDevice.did);
    }

    /* access modifiers changed from: protected */
    public View.OnClickListener getCancelListener() {
        return new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miui10.$$Lambda$MIUI10CardActivity$F0llBjGa4LsUiGIpJcBuspYN40E */

            public final void onClick(View view) {
                MIUI10CardActivity.this.lambda$getCancelListener$0$MIUI10CardActivity(view);
            }
        };
    }

    public /* synthetic */ void lambda$getCancelListener$0$MIUI10CardActivity(View view) {
        onBackPressed();
    }

    public void onDestroy() {
        super.onDestroy();
        hcv.getInstance().unregisterStateChangedListener(this.mPropListener);
        hcz.getInstance().unregisterStateChangedListener(this.mPropListener);
        ft.O000000o(getContext()).O000000o(this.receiver);
        try {
            unregisterReceiver(this.receiver2);
        } catch (Exception unused) {
        }
        hbz<C, E, T> hbz = this.render;
        if (hbz != null) {
            Iterator<? extends hcf<C, E, T>> it = hbz.f10206O000000o.iterator();
            while (it.hasNext()) {
                ((hcf) it.next()).O00000o0();
            }
        }
        frb frb = this.mDevicePropSubscriber;
        if (frb != null) {
            frb.destroy();
            this.mDevicePropSubscriber = null;
        }
        sRoomName = "";
    }

    public boolean isInstalling() {
        if (this.isInstalling) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.lastInstallFinishTime;
        if (j <= 0 || currentTimeMillis - j >= 1000) {
            return this.isInstalling;
        }
        return true;
    }

    public void onBackPressed() {
        if (!this.backProcessing) {
            this.backProcessing = true;
            View view = null;
            hbz<C, E, T> hbz = this.render;
            if (hbz != null) {
                view = hbz.O00000o();
            }
            if (view != null) {
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                hzf.O000000o(this.render.O00000o(), this.mCachedRect, new RectF((float) iArr[0], (float) iArr[1], (float) (iArr[0] + view.getWidth()), (float) (iArr[1] + view.getHeight())), new Runnable() {
                    /* class com.xiaomi.smarthome.miui10.$$Lambda$MIUI10CardActivity$gcqFqmDpEJTx1KeSmxLKVUDyJ4Y */

                    public final void run() {
                        MIUI10CardActivity.this.lambda$onBackPressed$1$MIUI10CardActivity();
                    }
                });
                return;
            }
            setResult(20);
            finish();
        }
    }

    public /* synthetic */ void lambda$onBackPressed$1$MIUI10CardActivity() {
        setResult(20);
        finish();
        overridePendingTransition(0, 0);
    }

    public void finish() {
        super.finish();
        SendMessageHandle sendMessageHandle = this.mSendMessageHandle;
        if (sendMessageHandle != null) {
            sendMessageHandle.cancel();
        }
    }

    public void onResume() {
        super.onResume();
        gsy.O000000o(6, "MIUI10CardActivity", "show model - " + this.mModel);
        boolean z = this.fromMiUI;
        hyg hyg = hxi.O00000oO.f958O000000o;
        int i = 2;
        Object[] objArr = new Object[2];
        objArr[0] = "type";
        if (!z) {
            i = 1;
        }
        objArr[1] = Integer.valueOf(i);
        hyg.O000000o("miui_mijia_card", objArr);
        hbz<C, E, T> hbz = this.render;
        if (hbz != null) {
            hbz.O00000oO();
        }
        this.mActivityControler.f18610O000000o = true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        hbz<C, E, T> hbz = this.render;
        int i3 = 0;
        if (i2 == -1) {
            i3 = 2;
        }
        hbz.O0000O0o = i3;
    }

    public void onPause() {
        super.onPause();
        hbz<C, E, T> hbz = this.render;
        if (hbz != null) {
            Iterator<? extends hcf<C, E, T>> it = hbz.f10206O000000o.iterator();
            while (it.hasNext()) {
                ((hcf) it.next()).O00000Oo();
            }
        }
        stopLoading();
        this.mActivityControler.O00000Oo();
    }

    /* access modifiers changed from: protected */
    public hbz<C, E, T> showCard(hch.O000000o o000000o) {
        hdg requestSender = getRequestSender();
        Pair<C, T[][]> pair = this.mCard;
        if (pair == null) {
            this.render = hch.O000000o(null, null, this.mViewRoot, this, this.mDevice, o000000o);
            showToast("nocard", null, null);
        } else {
            this.render = hch.O000000o((hcc) pair.first, (Object[][]) this.mCard.second, this.mViewRoot, this, this.mDevice, o000000o);
            if (this.mCard.first instanceof heb) {
                AnonymousClass4 r4 = new gzc<Object>() {
                    /* class com.xiaomi.smarthome.miui10.MIUI10CardActivity.AnonymousClass4 */

                    public final void O000000o(Object obj) {
                        if (!MIUI10CardActivity.this.mIsPaused) {
                            MIUI10CardActivity.this.render.O000000o((String) null, (Object) null);
                        }
                        MIUI10CardActivity.this.subscribeDeviceProp(hcv.getInstance());
                        MIUI10CardActivity.this.showToast("profile", null, null);
                    }

                    public final void O000000o(fso fso) {
                        MIUI10CardActivity.this.showToast("profile", fso, null);
                    }
                };
                if (requestSender == null) {
                    hcv.getInstance().loadCardPropsFromServerAsync(this.mDevice, r4, "updatePropValue");
                } else {
                    if (retryNetwork()) {
                        hcv.getInstance().loadCardPropsFromServerAsync(this.mDevice, r4, "updatePropValue");
                    }
                    requestSender.getProfilePropsFromServer(false, this.mDevice, hcv.getInstance().getPropsParams(this.mDevice), r4, "updatePropValue");
                }
            } else if (this.mCard.first instanceof hep) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < this.render.f10206O000000o.size(); i++) {
                    try {
                        hcf hcf = (hcf) this.render.f10206O000000o.get(i);
                        hfa.O000000o(this.mDevice.did, hcf.O00000Oo, (Spec.SpecItem[]) hcf.f18773O000000o, arrayList);
                    } catch (Throwable th) {
                        gsy.O00000Oo(LogType.CARD, "mijia-card", Log.getStackTraceString(th));
                    }
                }
                LinkedList linkedList = new LinkedList();
                Collections.addAll(linkedList, 2, 3);
                AnonymousClass5 r2 = new gzc<List<PropertyParam>>() {
                    /* class com.xiaomi.smarthome.miui10.MIUI10CardActivity.AnonymousClass5 */

                    public final /* synthetic */ void O000000o(Object obj) {
                        List<PropertyParam> list = (List) obj;
                        UwbLogUtil.d("mijia-card", "UWBPERFORMANCE-9-mijia-card-ready " + System.currentTimeMillis());
                        if (!MIUI10CardActivity.this.mIsPaused) {
                            MIUI10CardActivity.this.render.O000000o((String) null, (Object) null);
                        }
                        MIUI10CardActivity.this.subscribeDeviceProp(hcz.getInstance());
                        for (PropertyParam propertyParam : list) {
                            if (propertyParam.getResultCode() != 0) {
                                MIUI10CardActivity mIUI10CardActivity = MIUI10CardActivity.this;
                                mIUI10CardActivity.showToast("spec", null, DeviceCardApi.O000000o(mIUI10CardActivity.getContext(), propertyParam));
                                return;
                            }
                        }
                        MIUI10CardActivity.this.showToast("spec", null, null);
                    }

                    public final void O000000o(fso fso) {
                        if (!MIUI10CardActivity.this.mIsPaused) {
                            MIUI10CardActivity.this.render.O000000o((String) null, (Object) null);
                        }
                        MIUI10CardActivity.this.showToast("spec", fso, null);
                    }
                };
                if (requestSender == null) {
                    hcz.getInstance().getDevicePropFromServer(arrayList, linkedList, r2);
                } else {
                    if (retryNetwork()) {
                        hcz.getInstance().getDevicePropFromServer(arrayList, linkedList, r2);
                    }
                    requestSender.getSpecPropsFromServer(false, this.mDevice, arrayList, r2);
                }
            }
        }
        if (!this.mEnable) {
            this.render.O000000o(BaseCardRender.DataInitState.DOING);
        } else {
            this.render.O000000o(BaseCardRender.DataInitState.DONE);
        }
        this.render.O000000o(requestSender);
        this.render.O000000o();
        View O00000o = this.render.O00000o();
        if (O00000o != null) {
            O00000o.getLayoutParams().width = Math.min(getResources().getDisplayMetrics().widthPixels - gpc.O000000o(20.0f), gpc.O000000o(360.0f));
            O00000o.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                /* class com.xiaomi.smarthome.miui10.MIUI10CardActivity.AnonymousClass6 */

                public final boolean onPreDraw() {
                    if (!MIUI10CardActivity.this.mAnimationStart) {
                        MIUI10CardActivity mIUI10CardActivity = MIUI10CardActivity.this;
                        mIUI10CardActivity.mAnimationStart = true;
                        View O00000o = mIUI10CardActivity.render.O00000o();
                        RectF rectF = new RectF((float) O00000o.getLeft(), (float) O00000o.getTop(), (float) (O00000o.getLeft() + O00000o.getWidth()), (float) (O00000o.getTop() + O00000o.getHeight()));
                        MIUI10CardActivity mIUI10CardActivity2 = MIUI10CardActivity.this;
                        mIUI10CardActivity2.mCachedRect = (RectF) mIUI10CardActivity2.getIntent().getParcelableExtra("view_position");
                        if (MIUI10CardActivity.this.mCachedRect == null) {
                            MIUI10CardActivity.this.mCachedRect = rectF;
                        }
                        MIUI10CardActivity.this.overridePendingTransition(0, 0);
                        hzf.O000000o(MIUI10CardActivity.this.render.O00000o(), MIUI10CardActivity.this.mCachedRect, rectF);
                        ObjectAnimator.ofFloat(MIUI10CardActivity.this.findViewById(R.id.card_mask), "alpha", 1.0f, 0.0f).setDuration(300L).start();
                    }
                    return true;
                }
            });
            O00000o.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miui10.MIUI10CardActivity.AnonymousClass7 */

                public final void onClick(View view) {
                }
            });
        }
        this.mProgressDownload = this.render.O00000Oo();
        this.mProcessEnterDevice = this.render.O00000o0();
        hhk hhk = this.mProgressDownload;
        if (hhk == null) {
            return this.render;
        }
        this.mDownloadWrapper = new hhd(this, hhk, this.mDevice);
        this.render.O000000o(this.mDownloadWrapper);
        boolean O000000o2 = fbn.O000000o(this.mDevice.model);
        this.mProcessEnterDevice.findViewById(R.id.three_point_loading).setVisibility(8);
        if (O000000o2) {
            this.mDownloadWrapper.O00000Oo();
        }
        this.mProcessEnterDevice.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miui10.MIUI10CardActivity.AnonymousClass8 */

            public final void onClick(View view) {
                List<Device> O00000oO;
                gsy.O00000Oo("mijia-card", "click more action mEnable:" + MIUI10CardActivity.this.mEnable);
                if (!htt.O000000o(MIUI10CardActivity.this.mDevice.model) || !((O00000oO = fno.O000000o().O00000oO(MIUI10CardActivity.this.mDevice.did)) == null || O00000oO.size() == 0)) {
                    boolean z = MIUI10CardActivity.this.fromMiUI;
                    hyg hyg = hxi.O00000o.f952O000000o;
                    int i = 2;
                    Object[] objArr = new Object[2];
                    boolean z2 = false;
                    objArr[0] = "type";
                    objArr[1] = Integer.valueOf(z ? 2 : 1);
                    hyg.O000000o("miui_card_more", objArr);
                    if (MIUI10CardActivity.this.mEnable) {
                        long currentTimeMillis = System.currentTimeMillis() - MIUI10CardActivity.this.lastClickDealTime;
                        if (MIUI10CardActivity.this.isDownloading || MIUI10CardActivity.this.isInstalling() || (MIUI10CardActivity.this.lastClickDealTime > 0 && currentTimeMillis < 1000)) {
                            gsy.O000000o(6, "mijia-card", "click more action isDownloading:" + MIUI10CardActivity.this.isDownloading);
                            return;
                        }
                        MIUI10CardActivity.this.lastClickDealTime = System.currentTimeMillis();
                        if (!TextUtils.isEmpty(MIUI10CardActivity.sRoomName)) {
                            String str = MIUI10CardActivity.this.mModel;
                            String str2 = MIUI10CardActivity.sRoomName;
                            boolean O000000o2 = fml.O000000o(MIUI10CardActivity.this.mDevice);
                            hyg hyg2 = hxi.O00000o.f952O000000o;
                            Object[] objArr2 = new Object[6];
                            objArr2[0] = "model";
                            objArr2[1] = str;
                            objArr2[2] = "room";
                            objArr2[3] = str2;
                            objArr2[4] = "share";
                            if (!O000000o2) {
                                i = 1;
                            }
                            objArr2[5] = Integer.valueOf(i);
                            hyg2.O000000o("home_device_more", objArr2);
                        }
                        if (!fbn.O000000o(MIUI10CardActivity.this.mDevice.model) && !fbn.O00000Oo(MIUI10CardActivity.this.mDevice.model)) {
                            String str3 = MIUI10CardActivity.this.mDevice.model;
                            chu chu = chu.O000000o.f13841O000000o;
                            if (!chu.O000000o(str3)) {
                                hhd hhd = MIUI10CardActivity.this.mDownloadWrapper;
                                MIUI10CardActivity mIUI10CardActivity = MIUI10CardActivity.this;
                                hhd.O00000oo = mIUI10CardActivity;
                                hhd hhd2 = mIUI10CardActivity.mDownloadWrapper;
                                MIUI10CardActivity mIUI10CardActivity2 = MIUI10CardActivity.this;
                                hhd2.O0000O0o = mIUI10CardActivity2;
                                mIUI10CardActivity2.mDownloadWrapper.setCallback(new hhi() {
                                    /* class com.xiaomi.smarthome.miui10.MIUI10CardActivity.AnonymousClass8.AnonymousClass2 */

                                    public final void O000000o() {
                                        MIUI10CardActivity.this.isDownloading = false;
                                    }

                                    public final void O00000Oo() {
                                        MIUI10CardActivity.this.isDownloading = false;
                                    }

                                    public final void O00000o0() {
                                        MIUI10CardActivity.this.isDownloading = false;
                                    }
                                });
                                MIUI10CardActivity mIUI10CardActivity3 = MIUI10CardActivity.this;
                                hhd hhd3 = mIUI10CardActivity3.mDownloadWrapper;
                                Device device = hhd3.O00000Oo;
                                Intent intent = new Intent();
                                device.setLaunchParams(intent);
                                if (!fbn.O000000o(device.model) && !fbn.O00000Oo(device.model)) {
                                    z2 = true;
                                }
                                mIUI10CardActivity3.mSendMessageHandle = fbn.O000000o(hhd3.O00000o, device.model, intent, fbr.O000000o(device), new fbp(device, z2) {
                                    /* class _m_j.hhd.AnonymousClass3 */

                                    /* renamed from: O000000o  reason: collision with root package name */
                                    ValueAnimator f18934O000000o;
                                    final /* synthetic */ Device O00000Oo;
                                    final /* synthetic */ boolean O00000o0;
                                    private float O00000oO = 0.0f;
                                    private long O00000oo;
                                    private final Interpolator O0000O0o = new DecelerateInterpolator();

                                    {
                                        this.O00000Oo = r2;
                                        this.O00000o0 = r3;
                                    }

                                    public final void O000000o(Bundle bundle) {
                                        super.O000000o(bundle);
                                    }

                                    public final void O00000Oo() {
                                        super.O00000Oo();
                                    }

                                    public final void O000000o(fso fso) {
                                        super.O000000o(fso);
                                        hte.O000000o(hhd.this.O00000o, fso.O00000Oo);
                                    }

                                    public final void O000000o(String str, fbo fbo) {
                                        super.O000000o(str, fbo);
                                        if (hhd.f18930O000000o.get(this.O00000Oo) == null) {
                                            PluginDownloadingRecordWrapper pluginDownloadingRecordWrapper = new PluginDownloadingRecordWrapper();
                                            pluginDownloadingRecordWrapper.f6715O000000o = this.O00000Oo.model;
                                            pluginDownloadingRecordWrapper.O00000Oo = PluginDownloadingRecordWrapper.Status.DOWNLOADING;
                                            hhd.f18930O000000o.put(this.O00000Oo, pluginDownloadingRecordWrapper);
                                        }
                                        if (hhd.this.O00000o0 != null) {
                                            hhd.this.O00000o0.O000000o();
                                        }
                                        this.O00000oO = 0.0f;
                                    }

                                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                                     method: ClspMth{java.lang.Math.min(float, float):float}
                                     arg types: [int, float]
                                     candidates:
                                      ClspMth{java.lang.Math.min(double, double):double}
                                      ClspMth{java.lang.Math.min(long, long):long}
                                      ClspMth{java.lang.Math.min(int, int):int}
                                      ClspMth{java.lang.Math.min(float, float):float} */
                                    public final void O000000o(String str, float f) {
                                        super.O000000o(str, f);
                                        if (((double) (f - this.O00000oO)) >= 0.005d || f >= 1.0f) {
                                            PluginDownloadingRecordWrapper pluginDownloadingRecordWrapper = hhd.f18930O000000o.get(this.O00000Oo);
                                            if (pluginDownloadingRecordWrapper != null) {
                                                if (this.O00000o0 && ((double) f) >= 0.99d) {
                                                    f = 0.99f;
                                                }
                                                pluginDownloadingRecordWrapper.O00000o0 = f;
                                            }
                                            int i = (int) (100.0f * f);
                                            if (i == 99) {
                                                if (this.O00000oo == 0) {
                                                    this.O00000oo = System.currentTimeMillis();
                                                }
                                                if (this.f18934O000000o == null) {
                                                    double min = (double) Math.min(1.0f, ((float) (System.currentTimeMillis() - this.O00000oo)) / 4000.0f);
                                                    Double.isNaN(min);
                                                    this.f18934O000000o = ValueAnimator.ofFloat((float) ((min * 0.14d) + 0.85d), 0.99f);
                                                    this.f18934O000000o.setDuration(4000L);
                                                    this.f18934O000000o.setInterpolator(this.O0000O0o);
                                                    this.f18934O000000o.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                                        /* class _m_j.hhd.AnonymousClass3.AnonymousClass1 */

                                                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                                            if (hhd.this.O00000o0 != null) {
                                                                hhd.this.O00000o0.setPercent((float) ((int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 100.0f)));
                                                            }
                                                        }
                                                    });
                                                    this.f18934O000000o.start();
                                                }
                                                ((Float) this.f18934O000000o.getAnimatedValue()).floatValue();
                                            } else if (hhd.this.O00000o0 != null) {
                                                hhk hhk = hhd.this.O00000o0;
                                                double d = (double) i;
                                                Double.isNaN(d);
                                                hhk.setPercent((float) (d * 0.85d));
                                            }
                                            this.O00000oO = f;
                                        }
                                    }

                                    public final void O000000o(String str) {
                                        super.O000000o(str);
                                        if (!this.O00000o0) {
                                            hhd.f18930O000000o.remove(this.O00000Oo);
                                        }
                                        if (hhd.this.O00000oo == null || (hhd.this.O00000oo != null && !hhd.this.O00000oo.shouldInstallNow(this.O00000Oo))) {
                                            hhd.this.O00000Oo();
                                            if (hhd.this.O00000oO != null) {
                                                hhd.this.O00000oO.O000000o();
                                                return;
                                            }
                                            return;
                                        }
                                        if (hhd.this.O0000O0o != null) {
                                            hhd.this.O0000O0o.install(hhd.this.O00000Oo, new hhe.O000000o() {
                                                /* class _m_j.hhd.AnonymousClass3.AnonymousClass2 */

                                                public final void O000000o() {
                                                    hhd.this.O00000Oo();
                                                    if (hhd.this.O00000oO != null) {
                                                        hhd.this.O00000oO.O000000o();
                                                    }
                                                    hhd.this.O00000oo();
                                                }
                                            });
                                        }
                                        hhd.this.O00000oO();
                                    }

                                    public final void O000000o(Error error) {
                                        super.O000000o(error);
                                        if (!this.O00000o0) {
                                            hhd.f18930O000000o.remove(this.O00000Oo);
                                        }
                                        if (hhd.this.O00000oO != null) {
                                            hhd.this.O00000oO.O00000Oo();
                                        }
                                        hhd.this.O00000o0.O00000o0();
                                    }

                                    public final void O000000o() {
                                        super.O000000o();
                                        if (!this.O00000o0) {
                                            hhd.f18930O000000o.remove(this.O00000Oo);
                                        }
                                        if (hhd.this.O00000oO != null) {
                                            hhd.this.O00000oO.O00000o0();
                                        }
                                        hhd.this.O00000o0.O00000o();
                                    }
                                });
                                MIUI10CardActivity.this.isDownloading = true;
                                return;
                            }
                        }
                        Intent intent2 = new Intent();
                        MIUI10CardActivity.this.mDevice.setLaunchParams(intent2);
                        MIUI10CardActivity mIUI10CardActivity4 = MIUI10CardActivity.this;
                        mIUI10CardActivity4.startLoading(mIUI10CardActivity4.mProcessEnterDevice);
                        MIUI10CardActivity.this.mProcessEnterDevice.findViewById(R.id.three_point_loading).setVisibility(0);
                        MIUI10CardActivity.this.mProcessEnterDevice.findViewById(R.id.bottom_text).setVisibility(8);
                        MIUI10CardActivity mIUI10CardActivity5 = MIUI10CardActivity.this;
                        fbn.O000000o(mIUI10CardActivity5, mIUI10CardActivity5.mDevice.model, intent2, fbr.O000000o(MIUI10CardActivity.this.mDevice), new fbp() {
                            /* class com.xiaomi.smarthome.miui10.MIUI10CardActivity.AnonymousClass8.AnonymousClass1 */

                            public final void O000000o(Bundle bundle) {
                                super.O000000o(bundle);
                                MIUI10CardActivity.this.mActivityControler.O000000o();
                                MIUI10CardActivity.this.mProcessEnterDevice.post(new Runnable() {
                                    /* class com.xiaomi.smarthome.miui10.MIUI10CardActivity.AnonymousClass8.AnonymousClass1.AnonymousClass1 */

                                    public final void run() {
                                        MIUI10CardActivity.this.stopLoading();
                                        if (MIUI10CardActivity.this.mProcessEnterDevice != null && MIUI10CardActivity.this.isValid()) {
                                            MIUI10CardActivity.this.mProcessEnterDevice.findViewById(R.id.three_point_loading).setVisibility(8);
                                            MIUI10CardActivity.this.mProcessEnterDevice.findViewById(R.id.bottom_text).setVisibility(0);
                                        }
                                    }
                                });
                            }

                            public final void O00000Oo() {
                                super.O00000Oo();
                                MIUI10CardActivity.this.mProcessEnterDevice.post(new Runnable() {
                                    /* class com.xiaomi.smarthome.miui10.MIUI10CardActivity.AnonymousClass8.AnonymousClass1.AnonymousClass2 */

                                    public final void run() {
                                        MIUI10CardActivity.this.stopLoading();
                                        if (MIUI10CardActivity.this.mProcessEnterDevice != null && MIUI10CardActivity.this.isValid()) {
                                            MIUI10CardActivity.this.mProcessEnterDevice.findViewById(R.id.three_point_loading).setVisibility(8);
                                            MIUI10CardActivity.this.mProcessEnterDevice.findViewById(R.id.bottom_text).setVisibility(0);
                                        }
                                    }
                                });
                            }

                            public final void O000000o(fso fso) {
                                hte.O000000o(MIUI10CardActivity.this.getContext(), fso.O00000Oo);
                                MIUI10CardActivity.this.mProcessEnterDevice.post(new Runnable() {
                                    /* class com.xiaomi.smarthome.miui10.MIUI10CardActivity.AnonymousClass8.AnonymousClass1.AnonymousClass3 */

                                    public final void run() {
                                        MIUI10CardActivity.this.stopLoading();
                                        if (MIUI10CardActivity.this.mProcessEnterDevice != null && MIUI10CardActivity.this.isValid()) {
                                            MIUI10CardActivity.this.mProcessEnterDevice.findViewById(R.id.three_point_loading).setVisibility(8);
                                            MIUI10CardActivity.this.mProcessEnterDevice.findViewById(R.id.bottom_text).setVisibility(0);
                                        }
                                    }
                                });
                            }
                        });
                        return;
                    }
                    return;
                }
                cuh cuh = new cuh(MIUI10CardActivity.this, "ConfigRouterSubDeviceActivity");
                cuh.O000000o("station_model", MIUI10CardActivity.this.mDevice.model);
                cuh.O000000o("station_did", MIUI10CardActivity.this.mDevice.did);
                cuh.O000000o();
                cub.O000000o(cuh);
            }
        });
        return this.render;
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* access modifiers changed from: protected */
    public void showToast(String str, fso fso, String str2) {
        if (gfr.f17662O000000o) {
            String pushId = CommonApplication.getApplication().getPushId();
            Context context = getContext();
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (fso == null) {
                fso = str2;
            }
            sb.append(fso);
            sb.append("\nmodel:");
            sb.append(this.mDevice.model);
            sb.append("\ndid:");
            sb.append(this.mDevice.did);
            sb.append(TextUtils.isEmpty(pushId) ? "\n订阅失败，请重启 app" : "");
            izb.O000000o(context, sb.toString(), 1).show();
        } else if (fso != null || !TextUtils.isEmpty(str2)) {
            LogType logType = LogType.CARD;
            gsy.O00000o0(logType, "mijia-card", "showToast " + fso + Log.getStackTraceString(new Exception()));
            String str3 = str2;
            if (fso != null) {
                str3 = getString(R.string.network_not_stable);
            }
            hte.O000000o(this, str3);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        View O00000o;
        super.onConfigurationChanged(configuration);
        hbz<C, E, T> hbz = this.render;
        if (hbz != null && (O00000o = hbz.O00000o()) != null) {
            O00000o.getLayoutParams().width = Math.min(getResources().getDisplayMetrics().widthPixels - gpc.O000000o(20.0f), gpc.O000000o(360.0f));
            O00000o.requestLayout();
        }
    }

    public void install(Device device, final hhe.O000000o o000000o) {
        device.setLaunchParams(new Intent());
        fbn.O000000o(this, device.model, new fbp() {
            /* class com.xiaomi.smarthome.miui10.MIUI10CardActivity.AnonymousClass9 */

            public final void O00000Oo(String str) {
                super.O00000Oo(str);
                MIUI10CardActivity.this.isInstalling = true;
            }

            public final void O00000o0(String str) {
                MIUI10CardActivity.this.lastInstallFinishTime = System.currentTimeMillis();
                super.O00000o0(str);
                MIUI10CardActivity.this.isInstalling = false;
                hhe.O000000o o000000o = o000000o;
                if (o000000o != null) {
                    o000000o.O000000o();
                }
            }

            public final void O00000Oo(Error error) {
                super.O00000Oo(error);
                MIUI10CardActivity.this.lastInstallFinishTime = System.currentTimeMillis();
                MIUI10CardActivity mIUI10CardActivity = MIUI10CardActivity.this;
                mIUI10CardActivity.isInstalling = false;
                mIUI10CardActivity.mProgressDownload.O00000Oo();
            }

            public final void O000000o(Bundle bundle) {
                super.O000000o(bundle);
                MIUI10CardActivity.this.mActivityControler.O000000o();
                MIUI10CardActivity.this.lastInstallFinishTime = System.currentTimeMillis();
                MIUI10CardActivity.this.isInstalling = false;
                CommonApplication.getGlobalHandler().postDelayed(new Runnable() {
                    /* class com.xiaomi.smarthome.miui10.MIUI10CardActivity.AnonymousClass9.AnonymousClass1 */

                    public final void run() {
                        MIUI10CardActivity.this.mProgressDownload.O00000Oo();
                    }
                }, 800);
            }

            public final void O000000o(fso fso) {
                super.O000000o(fso);
                MIUI10CardActivity.this.lastInstallFinishTime = System.currentTimeMillis();
                MIUI10CardActivity mIUI10CardActivity = MIUI10CardActivity.this;
                mIUI10CardActivity.isInstalling = false;
                mIUI10CardActivity.mProgressDownload.O00000Oo();
            }

            public final void O00000Oo() {
                super.O00000Oo();
                MIUI10CardActivity.this.lastInstallFinishTime = System.currentTimeMillis();
                MIUI10CardActivity mIUI10CardActivity = MIUI10CardActivity.this;
                mIUI10CardActivity.isInstalling = false;
                mIUI10CardActivity.mProgressDownload.O00000Oo();
            }
        });
    }

    public float progress(float f, Device device) {
        if (f <= 90.0f || !shouldInstallNow(device) || fbn.O00000Oo(device.model)) {
            return f;
        }
        return 90.0f;
    }

    static class O000000o extends Handler {

        /* renamed from: O000000o  reason: collision with root package name */
        int f10042O000000o = 0;
        Drawable[] O00000Oo;
        boolean O00000o = false;
        ImageView[] O00000o0;

        O000000o() {
        }

        public final void handleMessage(Message message) {
            if (!this.O00000o) {
                for (int i = 0; i < 3; i++) {
                    this.O00000o0[i].setImageDrawable(this.O00000Oo[(this.f10042O000000o + i) % 3]);
                }
                sendEmptyMessageDelayed(0, 500);
            }
        }
    }

    public void startLoading(View view) {
        if (this.pointHandler == null) {
            this.pointHandler = new O000000o();
            O000000o o000000o = this.pointHandler;
            Resources resources = getResources();
            o000000o.O00000Oo = new Drawable[]{resources.getDrawable(R.drawable.loading_first_point), resources.getDrawable(R.drawable.loading_second_point), resources.getDrawable(R.drawable.loading_third_point)};
            o000000o.O00000o0 = new ImageView[]{(ImageView) view.findViewById(R.id.first), (ImageView) view.findViewById(R.id.second), (ImageView) view.findViewById(R.id.third)};
        }
        O000000o o000000o2 = this.pointHandler;
        o000000o2.O00000o = false;
        o000000o2.f10042O000000o = 0;
        o000000o2.sendEmptyMessage(0);
    }

    public void stopLoading() {
        O000000o o000000o = this.pointHandler;
        if (o000000o != null) {
            o000000o.O00000o = true;
        }
    }

    public void subscribeDeviceProp(hcd hcd) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mDevice);
        if (this.mDevicePropSubscriber == null) {
            this.mDevicePropSubscriber = createDevicePropSubscriber();
        }
        this.mDevicePropSubscriber.init(arrayList, new hcd.O000000o(hcd));
    }

    public frb createDevicePropSubscriber() {
        return new frd();
    }
}
