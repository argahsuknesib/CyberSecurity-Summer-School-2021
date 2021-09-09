package com.xiaomi.smarthome.device.choosedevice;

import _m_j.ei;
import _m_j.exo;
import _m_j.eyr;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fmg;
import _m_j.fni;
import _m_j.fpq;
import _m_j.fpr;
import _m_j.fps;
import _m_j.fpt;
import _m_j.fpu;
import _m_j.fpv;
import _m_j.fpw;
import _m_j.fqy;
import _m_j.fsr;
import _m_j.ftn;
import _m_j.fvo;
import _m_j.fwq;
import _m_j.gfr;
import _m_j.gsy;
import _m_j.gty;
import _m_j.hmv;
import _m_j.hna;
import _m_j.hte;
import _m_j.htx;
import _m_j.hty;
import _m_j.hvg;
import _m_j.hxc;
import _m_j.hxi;
import _m_j.hxk;
import _m_j.hxp;
import _m_j.hyg;
import _m_j.hzf;
import _m_j.inc;
import _m_j.izb;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.RemoteException;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.facebook.drawee.view.SimpleDraweeView;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.qrcode.ScanBarcodeActivity;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager;
import com.xiaomi.smarthome.device.ChooseConnectDevice;
import com.xiaomi.smarthome.device.ChooseDeviceNestedParent;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.DeviceScanManager;
import com.xiaomi.smarthome.device.ScanBleDeviceActivity;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.ListItemView;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.sdk.SyncConfigCallback;
import com.xiaomi.smarthome.service.DeviceObserveService;
import com.xiaomi.smarthome.smartconfig.DevicePushBindManager;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@RouterService
public class ChooseDeviceActivity extends BaseActivity implements fmg.O000000o, fmg.O00000o, fmg.O00000o0, hmv {
    public static boolean isShowManually = true;
    public static boolean mIsActivityResumed = false;
    public static List<PluginDeviceInfo> selectSubCategoryPluginDeviceInfo = new ArrayList();
    private ChooseConnectDevice chooseConnectDevice;
    private boolean handleWeChatJump = false;
    private boolean is3DeviceLogged = false;
    private boolean isFromMiui = false;
    private boolean isLogged = false;
    private boolean isMessageSending = false;
    public boolean isSearchClearBtnVisible;
    private XQProgressDialog loadingDialog;
    @BindView(4988)
    TextView mAddDeviceHeadTitle;
    private String mCameraCategoryName;
    private String mCameraMainCategoryName;
    private ArrayList<PluginDeviceInfo> mCameraPluginDeviceInfos = new ArrayList<>();
    public fpu mChooseDeviceSearchApi = new fpu();
    public fmg mChooseManuallyFragment;
    @BindView(5159)
    ImageView mCommonHelpImg;
    public fpq mDeviceHelper = new fpq();
    private DeviceScanManager mDeviceScanHelper;
    public Dialog mDialog;
    private Disposable mDisposable;
    @BindView(5297)
    View mExitSearchBtn;
    @BindView(5326)
    ViewGroup mHistoryTextFitlineLayout;
    private boolean mIsScanFromMainPage;
    private int mLastScanCnt = 0;
    public O000000o mListAdapter;
    @BindView(5639)
    ImageView mMoreBackImg;
    @BindView(5641)
    View mMoreHeader;
    @BindView(5685)
    View mNoSearchResultView;
    @BindView(5688)
    ImageView mNormalBackImg;
    @BindView(5689)
    View mNormalHeader;
    private int mOrientation;
    public List<PluginDeviceInfo> mPluginList = new ArrayList();
    @BindView(5609)
    ImageView mSearchBtn;
    @BindView(5929)
    View mSearchConentLayout;
    @BindView(5489)
    View mSearchContainerView;
    @BindView(5933)
    EditText mSearchEt;
    @BindView(5934)
    View mSearchEtClearBtn;
    private View mSearchHeaderView = null;
    @BindView(5937)
    View mSearchHistoryTv;
    @BindView(5216)
    ListView mSearchListView;
    @BindView(5606)
    View mSearchTextTitle;
    private long mStartTime;
    private final TextWatcher mTextWatcher = new TextWatcher() {
        /* class com.xiaomi.smarthome.device.choosedevice.ChooseDeviceActivity.AnonymousClass8 */

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            String str;
            Editable text = ChooseDeviceActivity.this.mSearchEt.getText();
            if (text == null) {
                str = "";
            } else {
                str = text.toString();
            }
            boolean isEmpty = TextUtils.isEmpty(str);
            ChooseDeviceActivity.this.mSearchEtClearBtn.setVisibility(isEmpty ? 4 : 0);
            if (!isEmpty) {
                ChooseDeviceActivity.this.addSearchHeaderView();
                ChooseDeviceActivity.this.mChooseDeviceSearchApi.O000000o(str);
                return;
            }
            ChooseDeviceActivity.this.removeSearchHeaderView();
            List<PluginDeviceInfo> searchHistoryRecords = ChooseDeviceActivity.this.getSearchHistoryRecords();
            if (searchHistoryRecords == null || searchHistoryRecords.isEmpty()) {
                ChooseDeviceActivity.this.mNoSearchResultView.setVisibility(8);
                ChooseDeviceActivity.this.mSearchConentLayout.setVisibility(8);
                return;
            }
            ChooseDeviceActivity chooseDeviceActivity = ChooseDeviceActivity.this;
            chooseDeviceActivity.showSearchResult(searchHistoryRecords, false, fps.O000000o(chooseDeviceActivity));
        }
    };
    @BindView(6104)
    ViewGroup mTitleBar;
    @BindView(5713)
    View mViewPager;
    private Handler mWorkerHandler;
    private HandlerThread mWorkerThread = new HandlerThread(ChooseDeviceActivity.class.getName());

    private void initSubCategoryPage() {
    }

    public static void setSource(Intent intent, View.OnClickListener onClickListener) {
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public void onCreate(Bundle bundle) {
        htx O000000o2;
        super.onCreate(bundle);
        this.mStartTime = System.currentTimeMillis();
        getWindow().setSoftInputMode(34);
        setContentView((int) R.layout.activity_choose_device);
        ButterKnife.bind(this);
        this.mOrientation = getRequestedOrientation();
        Intent intent = getIntent();
        if (intent != null) {
            this.isFromMiui = intent.getBooleanExtra("from_miui", false);
            int intExtra = intent.getIntExtra("category", 0);
            if (intExtra > 0 && (O000000o2 = hty.O000000o()) != null) {
                O000000o2.setDeviceSource(intExtra);
            }
            this.mIsScanFromMainPage = intent.getBooleanExtra("from_mainpage", false);
            if (this.mIsScanFromMainPage) {
                hxi.O00000o.f952O000000o.O000000o("adddevice_addhome_scan", new Object[0]);
                hxi.O00000o.f952O000000o.O000000o("adddevice_devicelist_scan_click", new Object[0]);
                this.mDeviceHelper.O00000Oo = this;
                Intent intent2 = new Intent();
                intent2.setClass(this, ScanBarcodeActivity.class);
                intent2.putExtra("from", 200);
                intent2.putExtra("from_mainpage", true);
                startActivityForResult(intent2, 1000);
                return;
            }
        }
        DeviceObserveService.O000000o().O000000o((String) null);
        this.mWorkerThread.start();
        this.mWorkerHandler = new Handler(this.mWorkerThread.getLooper());
        this.mChooseManuallyFragment = new fmg();
        fmg fmg = this.mChooseManuallyFragment;
        fmg.O00000Oo = this;
        fmg.O0000OoO = this;
        fmg.O000O00o = new ChooseDeviceNestedParent.O000000o() {
            /* class com.xiaomi.smarthome.device.choosedevice.ChooseDeviceActivity.AnonymousClass1 */

            public final void O000000o() {
                hzf.O0000Oo0(ChooseDeviceActivity.this.mAddDeviceHeadTitle);
            }

            public final void O00000Oo() {
                hzf.O0000Oo(ChooseDeviceActivity.this.mAddDeviceHeadTitle);
            }
        };
        changeFragment(this.mChooseManuallyFragment, false);
        initSearchView();
        this.mNormalBackImg.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.choosedevice.$$Lambda$ChooseDeviceActivity$Y5HJazmIj4ZVV_1iKatOZLlGUwk */

            public final void onClick(View view) {
                ChooseDeviceActivity.this.lambda$onCreate$0$ChooseDeviceActivity(view);
            }
        });
        this.mMoreBackImg.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.choosedevice.$$Lambda$ChooseDeviceActivity$DKRf2OemvOTy6oqgi8q8QKs7dLo */

            public final void onClick(View view) {
                ChooseDeviceActivity.this.lambda$onCreate$1$ChooseDeviceActivity(view);
            }
        });
        this.mExitSearchBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.choosedevice.$$Lambda$ChooseDeviceActivity$kEAFlO50jtbrHGW0v3LqjcZMP_o */

            public final void onClick(View view) {
                ChooseDeviceActivity.this.lambda$onCreate$2$ChooseDeviceActivity(view);
            }
        });
        this.mCommonHelpImg.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.choosedevice.$$Lambda$ChooseDeviceActivity$_0ouX6HZwsKSq1RV2fKW9OUUoTY */

            public final void onClick(View view) {
                ChooseDeviceActivity.this.lambda$onCreate$3$ChooseDeviceActivity(view);
            }
        });
        this.mDeviceHelper.O000000o(this, new fpq.O000000o() {
            /* class com.xiaomi.smarthome.device.choosedevice.ChooseDeviceActivity.AnonymousClass10 */

            public final void O000000o() {
                fmg fmg = ChooseDeviceActivity.this.mChooseManuallyFragment;
                if (fmg.O0000O0o != null) {
                    fmg.O0000O0o.setVisibility(0);
                } else {
                    fmg.O0000OOo = true;
                }
            }

            public final void O000000o(List<fni> list, List<PluginDeviceInfo> list2) {
                ChooseDeviceActivity.this.mChooseManuallyFragment.O0000Oo0 = list;
                ChooseDeviceActivity.this.mChooseManuallyFragment.O000000o(list2);
                ChooseDeviceActivity.this.mPluginList.addAll(list2);
                ChooseDeviceActivity.this.checkFromWeChat();
            }
        });
        SmartConfigRouterFactory.getSmartConfigManager().getLocalMiRouterDetail(null);
        this.mDeviceScanHelper = DeviceScanManager.instance;
        fmg fmg2 = this.mChooseManuallyFragment;
        DeviceScanManager deviceScanManager = this.mDeviceScanHelper;
        fmg2.O0000oOO = deviceScanManager;
        if (fmg2.O0000o0o != null) {
            fmg2.O0000o0o.O00000oo = deviceScanManager;
        }
        this.mDeviceScanHelper.checkAll(this);
        if (intent == null) {
            isShowManually = true;
        } else if (intent.getIntExtra("extra_show", 0) != 1) {
            isShowManually = true;
        }
        eyr.O00000Oo().O000000o(new SyncConfigCallback.Stub() {
            /* class com.xiaomi.smarthome.device.choosedevice.ChooseDeviceActivity.AnonymousClass3 */

            public void onResponse(int i, String str) throws RemoteException {
            }
        });
        initSubCategoryPage();
        DeviceRouterFactory.getBleManager().clearExpiredDevice();
        boolean z = fwq.O00000Oo() && fwq.O000000o();
        hyg hyg = hxi.O00000o0.f957O000000o;
        int i = 2;
        Object[] objArr = new Object[2];
        objArr[0] = "type";
        if (z) {
            i = 1;
        }
        objArr[1] = Integer.valueOf(i);
        hyg.O000000o("location_auth_on", objArr);
    }

    public /* synthetic */ void lambda$onCreate$0$ChooseDeviceActivity(View view) {
        onBackPressed();
    }

    public /* synthetic */ void lambda$onCreate$1$ChooseDeviceActivity(View view) {
        onBackPressed();
    }

    public /* synthetic */ void lambda$onCreate$2$ChooseDeviceActivity(View view) {
        exitSearch();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
     arg types: [java.lang.String, int]
     candidates:
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt */
    public /* synthetic */ void lambda$onCreate$3$ChooseDeviceActivity(View view) {
        String str;
        fbt fbt = new fbt(this, "WebShellActivity");
        ServerBean O0000ooO = CoreApi.O000000o().O0000ooO();
        if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
            StringBuilder sb = new StringBuilder("https://");
            if (O0000ooO != null) {
                str = O0000ooO.f7546O000000o + ".";
            } else {
                str = "";
            }
            sb.append(str);
            sb.append("home.mi.com/views/faqDetail.html?question=");
            sb.append(getString(R.string.param_question_cannot_find_near_device));
            fbt.O000000o("url", sb.toString());
        } else {
            fbt.O000000o("url", "https://home.mi.com/views/faqDetail.html?question=" + getString(R.string.param_question_cannot_find_near_device));
        }
        fbt.O000000o("show_feedback", false);
        fbs.O000000o(fbt);
        hxi.O00000o.f952O000000o.O000000o("home_adddevice_question_ck", new Object[0]);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            if (intent.getIntExtra("extra_show", 0) == 1) {
                addFragment();
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("search_word"))) {
                enterSearch();
                String stringExtra = intent.getStringExtra("search_word");
                gsy.O00000o0(LogType.PAGE_SWITCH, "ChooseDeviceActivity", "onNewIntent searchWord = ".concat(String.valueOf(stringExtra)));
                this.mSearchEt.setText(stringExtra);
                return;
            }
            gsy.O00000o0(LogType.PAGE_SWITCH, "ChooseDeviceActivity", "ChooseDevice onNewIntent searchWord = null");
            exitSearch();
        }
    }

    public void showLoading() {
        this.loadingDialog = new XQProgressDialog(getContext());
        this.loadingDialog.setMessage(getString(R.string.mj_loading));
        this.loadingDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.xiaomi.smarthome.device.choosedevice.ChooseDeviceActivity.AnonymousClass11 */

            public final void onCancel(DialogInterface dialogInterface) {
                fpq fpq = ChooseDeviceActivity.this.mDeviceHelper;
                if (fpq.O00000o0 != null) {
                    gsy.O000000o(4, "guid", "cancel go to ble reset");
                    fpq.O00000o0.dispose();
                    fpq.O00000o = null;
                    fpq.O00000o0 = null;
                }
            }
        });
        this.loadingDialog.show();
    }

    public void hideLoading() {
        XQProgressDialog xQProgressDialog = this.loadingDialog;
        if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
            this.loadingDialog.dismiss();
        }
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 3000:
                showLoading();
                return;
            case 3001:
                hideLoading();
                return;
            case 3002:
                hideLoading();
                fpq fpq = this.mDeviceHelper;
                if (fpq.O00000o != null) {
                    gsy.O000000o(4, "guid", "time limit, goto scan directly");
                    fpq.O00000o.onSuccess(Boolean.FALSE);
                    fpq.O00000o = null;
                    if (fpq.O00000o0 != null) {
                        fpq.O00000o0.dispose();
                        fpq.O00000o0 = null;
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void log_enter_scan_device_count() {
        if (!this.isLogged) {
            this.isLogged = true;
            hxp hxp = hxi.O00000o0;
            int i = this.mLastScanCnt;
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            hxp.f957O000000o.O000000o("adddevice_devicelist_show", "nearby-device", Integer.valueOf(i), "time", Long.valueOf(currentTimeMillis));
        }
    }

    private void log_enter_scan_3device_count() {
        if (!this.is3DeviceLogged) {
            this.is3DeviceLogged = true;
            hxp hxp = hxi.O00000o0;
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            hxp.f957O000000o.O000000o("home_adddevice_three_time", "time", Long.valueOf(currentTimeMillis));
        }
    }

    public void onScan(List<?> list) {
        fmg fmg = this.mChooseManuallyFragment;
        if (fmg != null) {
            fmg.onScan(list);
        }
        ChooseConnectDevice chooseConnectDevice2 = this.chooseConnectDevice;
        if (chooseConnectDevice2 != null) {
            chooseConnectDevice2.onScan(list);
        }
        this.mLastScanCnt = list.size();
        log_enter_scan_device_count();
        log_enter_scan_3device_count();
    }

    public void addFragment() {
        this.chooseConnectDevice = new ChooseConnectDevice();
        ChooseConnectDevice chooseConnectDevice2 = this.chooseConnectDevice;
        DeviceScanManager deviceScanManager = this.mDeviceScanHelper;
        chooseConnectDevice2.O00000Oo = deviceScanManager;
        if (chooseConnectDevice2.f6900O000000o != null) {
            chooseConnectDevice2.f6900O000000o.O00000oo = deviceScanManager;
        }
        changeFragment(this.chooseConnectDevice, true);
        isShowManually = false;
        DevicePushBindManager.instance.resetPopStatus();
        this.mMoreHeader.setVisibility(0);
    }

    private void changeFragment(Fragment fragment, boolean z) {
        ei O000000o2 = getSupportFragmentManager().O000000o();
        O000000o2.O000000o((int) R.id.pager, fragment);
        O000000o2.O000000o((int) R.anim.fragment_right_in, (int) R.anim.fragment_left_out, (int) R.anim.fragment_left_in, (int) R.anim.fragment_right_out);
        if (O000000o2.O0000Ooo && z) {
            O000000o2.O000000o(fragment.getClass().getName());
        }
        fragment.setUserVisibleHint(true);
        O000000o2.O00000o0();
    }

    public Handler getWorkerHandler() {
        return this.mWorkerHandler;
    }

    public void onDestroy() {
        super.onDestroy();
        if (!this.mIsScanFromMainPage) {
            Dialog dialog = this.mDialog;
            if (dialog != null && dialog.isShowing()) {
                this.mDialog.dismiss();
            }
            HandlerThread handlerThread = this.mWorkerThread;
            if (handlerThread != null) {
                handlerThread.quit();
            }
            this.mDisposable.dispose();
            fpu fpu = this.mChooseDeviceSearchApi;
            fpu.f16887O000000o.onComplete();
            fpu.O00000Oo.onComplete();
            fpv.O000000o();
            fpv.O00000Oo = null;
            if (fpt.O00000Oo != null) {
                if (fpt.O00000Oo.f16886O000000o != null) {
                    fpt.O00000Oo.f16886O000000o.O000000o();
                }
                fpt.O00000Oo.f16886O000000o = null;
                fpt.O00000Oo = null;
            }
        }
    }

    public void onResume() {
        super.onResume();
        if (!this.mIsScanFromMainPage) {
            mIsActivityResumed = true;
            this.mDeviceScanHelper.onResume(this);
            this.mDeviceScanHelper.addDeviceOnResume();
            if (this.isFromMiui) {
                exo stateNotifier = hna.O00000Oo().getStateNotifier();
                if (stateNotifier == null) {
                    gsy.O00000o0(LogType.KUAILIAN, "ChooseDeviceActivity", "stateNotifier is null!");
                    return;
                }
                int i = stateNotifier.f15923O000000o;
                if (i == 2) {
                    showWaitLoginDialog(stateNotifier);
                } else if (i == 3) {
                    showLoginDialog();
                }
            }
        }
    }

    private void showWaitLoginDialog(exo exo) {
        Dialog dialog = this.mDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mDialog.dismiss();
        }
        this.mDialog = new XQProgressDialog(this);
        this.mDialog.setCancelable(false);
        ((XQProgressDialog) this.mDialog).setMessage(getResources().getString(R.string.logining_please_wait));
        this.mDialog.show();
        exo.O000000o(new exo.O000000o() {
            /* class com.xiaomi.smarthome.device.choosedevice.ChooseDeviceActivity.AnonymousClass12 */

            public final void onLoginSuccess() {
                ChooseDeviceActivity.this.mDialog.dismiss();
                ChooseDeviceActivity chooseDeviceActivity = ChooseDeviceActivity.this;
                izb.O000000o(chooseDeviceActivity, chooseDeviceActivity.getString(R.string.login_success), 0).show();
            }

            public final void onLoginFailed() {
                ChooseDeviceActivity.this.mDialog.dismiss();
                ChooseDeviceActivity chooseDeviceActivity = ChooseDeviceActivity.this;
                izb.O000000o(chooseDeviceActivity, chooseDeviceActivity.getString(R.string.login_fail), 0).show();
                ChooseDeviceActivity.this.showLoginDialog();
            }
        });
    }

    public void showLoginDialog() {
        Dialog dialog = this.mDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mDialog.dismiss();
            this.mDialog = null;
        }
        Dialog dialog2 = this.mDialog;
        if (dialog2 == null) {
            this.mDialog = gty.O000000o().showLoginDialog(this, true);
            Dialog dialog3 = this.mDialog;
            if (dialog3 == null) {
                gsy.O00000o0(LogType.KUAILIAN, "ChooseDeviceActivity", "showLoginDialog is null!");
                return;
            }
            dialog3.setOnCancelListener(new DialogInterface.OnCancelListener() {
                /* class com.xiaomi.smarthome.device.choosedevice.ChooseDeviceActivity.AnonymousClass13 */

                public final void onCancel(DialogInterface dialogInterface) {
                    ChooseDeviceActivity.this.finish();
                }
            });
            this.mDialog.setCanceledOnTouchOutside(false);
        } else if (!dialog2.isShowing()) {
            this.mDialog.show();
        }
    }

    public void clearHistory() {
        new MLAlertDialog.Builder(this).O00000Oo((int) R.string.device_choose_search_clear_history_dialog_title).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O000000o((int) R.string.clear_content, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.device.choosedevice.ChooseDeviceActivity.AnonymousClass14 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                Context context = ChooseDeviceActivity.this.getContext();
                context.getSharedPreferences(fpr.O00000Oo(context), 0).edit().clear().apply();
                Context context2 = ChooseDeviceActivity.this.getContext();
                context2.getSharedPreferences(fps.O00000Oo(context2), 0).edit().clear().apply();
                ChooseDeviceActivity.this.showSearchResult(new ArrayList(), false, null);
                dialogInterface.dismiss();
            }
        }).O00000oo();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void initSearchView() {
        this.mSearchEtClearBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.choosedevice.ChooseDeviceActivity.AnonymousClass15 */

            public final void onClick(View view) {
                ChooseDeviceActivity.this.mSearchEt.setText("");
                ChooseDeviceActivity.this.mSearchEt.setFocusable(true);
                ChooseDeviceActivity.this.mSearchEt.requestFocus();
                ChooseDeviceActivity.this.mSearchEt.setFocusableInTouchMode(true);
                ChooseDeviceActivity.this.mSearchEt.requestFocusFromTouch();
                InputMethodManager inputMethodManager = (InputMethodManager) ChooseDeviceActivity.this.getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.showSoftInput(ChooseDeviceActivity.this.mSearchEt, 0);
                }
            }
        });
        this.mSearchEtClearBtn.setVisibility(4);
        this.mSearchContainerView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.choosedevice.ChooseDeviceActivity.AnonymousClass16 */

            public final void onClick(View view) {
            }
        });
        this.mListAdapter = new O000000o(this, (byte) 0);
        this.mListAdapter.f7236O000000o = new ArrayList();
        this.mSearchListView.setAdapter((ListAdapter) this.mListAdapter);
        final int scaledTouchSlop = ViewConfiguration.get(this).getScaledTouchSlop();
        this.mSearchListView.setOnTouchListener(new View.OnTouchListener() {
            /* class com.xiaomi.smarthome.device.choosedevice.ChooseDeviceActivity.AnonymousClass2 */

            /* renamed from: O000000o  reason: collision with root package name */
            float f7229O000000o;

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                InputMethodManager inputMethodManager;
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f7229O000000o = motionEvent.getY();
                } else if (action == 1 || action == 2 || action == 3) {
                    float y = motionEvent.getY() - this.f7229O000000o;
                    if (y < 0.0f && Math.abs(y) > ((float) scaledTouchSlop) && ChooseDeviceActivity.this.mListAdapter.getCount() > 0 && (inputMethodManager = (InputMethodManager) ChooseDeviceActivity.this.getSystemService("input_method")) != null && inputMethodManager.isActive(ChooseDeviceActivity.this.mSearchEt)) {
                        inputMethodManager.hideSoftInputFromWindow(ChooseDeviceActivity.this.mSearchEt.getWindowToken(), 0);
                        ChooseDeviceActivity.this.mNormalBackImg.requestFocus();
                    }
                }
                return false;
            }
        });
        this.mSearchEt.addTextChangedListener(this.mTextWatcher);
        this.mSearchBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.choosedevice.ChooseDeviceActivity.AnonymousClass4 */

            public final void onClick(View view) {
                ChooseDeviceActivity.this.enterSearch();
                hxi.O00000o.f952O000000o.O000000o("adddevice_search_click", new Object[0]);
                hxk hxk = hxi.O00000o;
                long currentTimeMillis = System.currentTimeMillis();
                hxk.f952O000000o.O000000o("home_adddevice_in_time", "time", Long.valueOf(currentTimeMillis));
            }
        });
        this.mSearchEt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.xiaomi.smarthome.device.choosedevice.ChooseDeviceActivity.AnonymousClass5 */

            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    ChooseDeviceActivity.this.enterSearch();
                }
            }
        });
        this.mDisposable = this.mChooseDeviceSearchApi.O00000Oo.hide().observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<fpu.O000000o>() {
            /* class com.xiaomi.smarthome.device.choosedevice.ChooseDeviceActivity.AnonymousClass6 */

            public final /* synthetic */ void accept(Object obj) throws Exception {
                fpu.O000000o o000000o = (fpu.O000000o) obj;
                Editable text = ChooseDeviceActivity.this.mSearchEt.getText();
                if (text != null) {
                    String str = o000000o.f16890O000000o;
                    if (!text.toString().contains(str)) {
                        return;
                    }
                    if (o000000o.O00000o0) {
                        List<Integer> list = o000000o.O00000Oo;
                        ChooseDeviceActivity.this.mNoSearchResultView.setVisibility(8);
                        ChooseDeviceActivity.this.mSearchConentLayout.setVisibility(0);
                        ArrayList arrayList = new ArrayList();
                        for (Integer intValue : list) {
                            PluginDeviceInfo findRecordByPid = ChooseDeviceActivity.this.findRecordByPid(intValue.intValue());
                            if (findRecordByPid != null) {
                                arrayList.add(findRecordByPid);
                            }
                        }
                        if (arrayList.isEmpty()) {
                            hxi.O00000o.f952O000000o.O000000o("adddevice_search_noresult", "query", str);
                        }
                        ChooseDeviceActivity.this.showSearchResult(arrayList, false, null);
                    } else if (!TextUtils.isEmpty(o000000o.O00000o)) {
                        hte.O000000o(ChooseDeviceActivity.this.getContext(), o000000o.O00000o);
                    }
                }
            }
        });
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra("search_word");
            if (!TextUtils.isEmpty(stringExtra)) {
                gsy.O00000o0(LogType.PAGE_SWITCH, "ChooseDeviceActivity", "onCreate searchWord =".concat(String.valueOf(stringExtra)));
                enterSearch();
                this.mSearchEt.setText(stringExtra);
                return;
            }
            gsy.O00000o0(LogType.PAGE_SWITCH, "ChooseDeviceActivity", " onCreate searchWord = null");
            exitSearch();
        }
    }

    public PluginDeviceInfo findRecordByPid(int i) {
        for (PluginDeviceInfo next : this.mPluginList) {
            if (next.O00000o0() == i) {
                return next;
            }
        }
        return null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.widget.ListView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public void addSearchHeaderView() {
        if (!gfr.O0000Oo0) {
            removeSearchHeaderView();
            this.mSearchHeaderView = LayoutInflater.from(this).inflate((int) R.layout.search_device_listview_header, (ViewGroup) this.mSearchListView, false);
            this.mSearchHeaderView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.device.choosedevice.ChooseDeviceActivity.AnonymousClass7 */

                public final void onClick(View view) {
                    CannotFindDeviceActivity.invokeActivity(CoreApi.O000000o().O0000o0(), ChooseDeviceActivity.this);
                }
            });
            this.mSearchListView.addHeaderView(this.mSearchHeaderView);
        }
    }

    public boolean removeSearchHeaderView() {
        View view;
        if (gfr.O0000Oo0 || this.mSearchListView.getHeaderViewsCount() <= 0 || (view = this.mSearchHeaderView) == null) {
            return false;
        }
        this.mSearchListView.removeHeaderView(view);
        this.mSearchHeaderView = null;
        return true;
    }

    public void checkFromWeChat() {
        if (!this.handleWeChatJump) {
            try {
                String stringExtra = getIntent().getStringExtra("url");
                if (!TextUtils.isEmpty(stringExtra)) {
                    Uri parse = Uri.parse(stringExtra.replaceAll("\\+", "%2B"));
                    String queryParameter = parse.getQueryParameter("model");
                    String queryParameter2 = parse.getQueryParameter("O");
                    if (TextUtils.isEmpty(queryParameter)) {
                        int i = -1;
                        try {
                            i = Integer.parseInt(parse.getQueryParameter("p"));
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                        queryParameter = CoreApi.O000000o().O00000Oo(i);
                        if (TextUtils.isEmpty(queryParameter)) {
                            return;
                        }
                    }
                    Intent intent = new Intent();
                    intent.putExtra("key_qrcode_oob", queryParameter2);
                    PluginDeviceInfo pluginInfo = PluginDeviceManager.instance.getPluginInfo(queryParameter);
                    if (pluginInfo != null) {
                        htx O000000o2 = hty.O000000o();
                        if (O000000o2 != null) {
                            O000000o2.setDeviceSource(4);
                        }
                        this.handleWeChatJump = true;
                        chooseDevice(pluginInfo, intent, 3);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    class O000000o extends BaseAdapter {

        /* renamed from: O000000o  reason: collision with root package name */
        List<PluginDeviceInfo> f7236O000000o;

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        private O000000o() {
        }

        /* synthetic */ O000000o(ChooseDeviceActivity chooseDeviceActivity, byte b) {
            this();
        }

        public final int getCount() {
            return this.f7236O000000o.size() + 1;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final View getView(final int i, View view, ViewGroup viewGroup) {
            int i2 = 0;
            if (i >= getCount() - 1) {
                View inflate = LayoutInflater.from(CommonApplication.getAppContext()).inflate((int) R.layout.choose_device_search_clear_item, viewGroup, false);
                if (!ChooseDeviceActivity.this.isSearchClearBtnVisible) {
                    i2 = 8;
                }
                inflate.setVisibility(i2);
                inflate.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.device.choosedevice.ChooseDeviceActivity.O000000o.AnonymousClass1 */

                    public final void onClick(View view) {
                        ChooseDeviceActivity.this.clearHistory();
                    }
                });
                return inflate;
            }
            if (!(view instanceof ListItemView)) {
                view = LayoutInflater.from(CommonApplication.getAppContext()).inflate((int) R.layout.choose_device_search_list_item, viewGroup, false);
            }
            final PluginDeviceInfo pluginDeviceInfo = this.f7236O000000o.get(i);
            TextView textView = (TextView) view.findViewById(R.id.name);
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.image);
            String O0000Oo0 = pluginDeviceInfo.O0000Oo0();
            if (CoreApi.O000000o().O00oOooo() == null) {
                Locale.getDefault();
            }
            textView.setText(O0000Oo0);
            DeviceFactory.O00000Oo(pluginDeviceInfo.O00000Oo(), simpleDraweeView);
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.device.choosedevice.ChooseDeviceActivity.O000000o.AnonymousClass2 */

                public final void onClick(View view) {
                    hxk hxk = hxi.O00000o;
                    String obj = ChooseDeviceActivity.this.mSearchEt.getText().toString();
                    String O00000Oo2 = pluginDeviceInfo.O00000Oo();
                    hxk.f952O000000o.O000000o("add_search_device", "search", obj, "model", O00000Oo2);
                    if (TextUtils.isEmpty(ChooseDeviceActivity.this.mSearchEt.getText().toString())) {
                        hxk hxk2 = hxi.O00000o;
                        String O00000Oo3 = pluginDeviceInfo.O00000Oo();
                        int i = fpw.O00000oO;
                        hxk2.f952O000000o.O000000o("adddevice_search_defaultlist_click", "model", O00000Oo3, "type", Integer.valueOf(i));
                    } else {
                        hxk hxk3 = hxi.O00000o;
                        String obj2 = ChooseDeviceActivity.this.mSearchEt.getText().toString();
                        String O00000Oo4 = pluginDeviceInfo.O00000Oo();
                        int i2 = i;
                        int count = O000000o.this.getCount();
                        int min = Math.min(i2, 3);
                        hxk3.f952O000000o.O000000o("adddevice_search_result_click", "query", obj2, "model", O00000Oo4, "serial", Integer.valueOf(i2), "total", Integer.valueOf(count), "type", Integer.valueOf(min));
                    }
                    ChooseDeviceActivity.this.chooseDevice(pluginDeviceInfo, null, 4);
                    Context context = ChooseDeviceActivity.this.getContext();
                    context.getSharedPreferences(fpr.O00000Oo(context), 0).edit().putString(pluginDeviceInfo.O00000Oo(), String.valueOf(System.currentTimeMillis())).apply();
                    Context context2 = ChooseDeviceActivity.this.getContext();
                    context2.getSharedPreferences(fps.O00000Oo(context2), 0).edit().putString(ChooseDeviceActivity.this.mSearchEt.getText().toString(), "").apply();
                }
            });
            if (fsr.O0000Oo0 || fsr.O0000O0o) {
                fvo.O000000o();
                if (fvo.O00000o0()) {
                    view.setOnLongClickListener(new View.OnLongClickListener() {
                        /* class com.xiaomi.smarthome.device.choosedevice.ChooseDeviceActivity.O000000o.AnonymousClass3 */

                        public final boolean onLongClick(View view) {
                            fbt fbt = new fbt(ChooseDeviceActivity.this, "HideDeviceEntranceAct");
                            fbt.O000000o("model", pluginDeviceInfo.O00000Oo());
                            fbs.O000000o(fbt);
                            return true;
                        }
                    });
                }
            }
            ((ListItemView) view).setPosition(i);
            return view;
        }
    }

    public void chooseDevice(PluginDeviceInfo pluginDeviceInfo, Intent intent, int i) {
        PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(pluginDeviceInfo.O00000Oo());
        if (O00000oO != null) {
            if (this.isMessageSending) {
                gsy.O000000o(6, "click_device_list", "isMessageSending=" + this.isMessageSending);
                return;
            }
            if (this.mDeviceHelper.O000000o(O00000oO, fqy.O000000o(intent, i), this.isFromMiui)) {
                hxc.O000000o().O000000o(O00000oO.O00000Oo(), i);
            }
            hvg.O000000o(CommonApplication.getAppContext()).O000000o(O00000oO.O00000Oo());
            hvg.O000000o(CommonApplication.getAppContext()).O000000o("from", String.valueOf(i));
        }
    }

    public List<PluginDeviceInfo> getSearchHistoryRecords() {
        List<String> O000000o2 = fpr.O000000o(this);
        ArrayList arrayList = new ArrayList();
        if (O000000o2.isEmpty()) {
            return arrayList;
        }
        for (String next : O000000o2) {
            Iterator<PluginDeviceInfo> it = this.mPluginList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PluginDeviceInfo next2 = it.next();
                if (TextUtils.equals(next, next2.O00000Oo()) && !arrayList.contains(next2)) {
                    arrayList.add(next2);
                    break;
                }
            }
        }
        return arrayList;
    }

    public void showSearchResult(List<PluginDeviceInfo> list, boolean z, List<String> list2) {
        if (z) {
            this.mHistoryTextFitlineLayout.removeAllViews();
            if (list2 == null || list2.size() <= 0) {
                this.mHistoryTextFitlineLayout.setVisibility(8);
            } else {
                this.mHistoryTextFitlineLayout.setVisibility(0);
                for (final String next : list2) {
                    TextView textView = new TextView(this);
                    if (Build.VERSION.SDK_INT >= 21) {
                        textView.setBackground(getDrawable(R.drawable.fast_connect_unregister_btn_bg));
                    }
                    textView.setText(next);
                    textView.setTextSize(14.0f);
                    textView.setGravity(17);
                    textView.setPadding(15, 5, 15, 5);
                    this.mHistoryTextFitlineLayout.addView(textView);
                    textView.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.device.choosedevice.ChooseDeviceActivity.AnonymousClass9 */

                        public final void onClick(View view) {
                            ChooseDeviceActivity.this.mSearchEt.setText(next);
                            ChooseDeviceActivity.this.mChooseDeviceSearchApi.O000000o(next);
                        }
                    });
                }
            }
        } else {
            this.mHistoryTextFitlineLayout.setVisibility(8);
        }
        O000000o o000000o = this.mListAdapter;
        o000000o.f7236O000000o = list;
        o000000o.notifyDataSetChanged();
        if (!list.isEmpty() || !(list2 == null || list2.size() == 0)) {
            this.mNoSearchResultView.setVisibility(8);
            this.mSearchConentLayout.setVisibility(0);
            this.mSearchHistoryTv.setVisibility(0);
            this.isSearchClearBtnVisible = true;
            return;
        }
        this.mNoSearchResultView.setVisibility(0);
        this.mSearchConentLayout.setVisibility(8);
        this.mSearchHistoryTv.setVisibility(8);
        this.isSearchClearBtnVisible = false;
    }

    public void enterSearch() {
        if (this.mSearchContainerView.getVisibility() != 0) {
            this.mSearchTextTitle.setVisibility(0);
            hxi.O00000o0.f957O000000o.O000000o("page_search", new Object[0]);
            hxi.O00000o0.f957O000000o.O000000o("adddevice_search_show", new Object[0]);
            this.mSearchContainerView.setVisibility(0);
            this.mNoSearchResultView.setVisibility(8);
            this.mCommonHelpImg.setEnabled(false);
            this.mMoreHeader.setVisibility(4);
            List<PluginDeviceInfo> searchHistoryRecords = getSearchHistoryRecords();
            if (searchHistoryRecords != null && !searchHistoryRecords.isEmpty()) {
                showSearchResult(searchHistoryRecords, false, fps.O000000o(this));
            }
            this.mSearchEt.setFocusable(true);
            this.mSearchEt.requestFocus();
            this.mSearchEt.setFocusableInTouchMode(true);
            this.mSearchEt.requestFocusFromTouch();
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this.mSearchEt, 0);
            }
        }
    }

    public void exitSearch() {
        this.mSearchTextTitle.setVisibility(4);
        this.mSearchEt.setText("");
        this.mSearchContainerView.setVisibility(8);
        this.mSearchConentLayout.setVisibility(0);
        this.mNoSearchResultView.setVisibility(8);
        this.mCommonHelpImg.setEnabled(true);
        this.mListAdapter.f7236O000000o = new ArrayList();
        this.mListAdapter.notifyDataSetChanged();
        this.mSearchEt.setFocusable(false);
        this.mSearchEt.setFocusableInTouchMode(false);
        this.mNormalBackImg.requestFocus();
        if (!isShowManually) {
            this.mMoreHeader.setVisibility(0);
        }
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.mSearchEt.getWindowToken(), 0);
        }
    }

    public void onBackPressed() {
        if (this.mSearchContainerView.getVisibility() == 0) {
            exitSearch();
        } else {
            super.onBackPressed();
        }
        if (this.mMoreHeader.getVisibility() == 0) {
            this.mMoreHeader.setVisibility(8);
            isShowManually = true;
            this.mNormalHeader.setVisibility(0);
        }
        DevicePushBindManager.instance.resetPopStatus();
    }

    public void chooseCategory(String str, String str2, List<PluginDeviceInfo> list) {
        if (list.get(0).O0000oo0 == 3) {
            this.mCameraMainCategoryName = str;
            this.mCameraCategoryName = str2;
            this.mCameraPluginDeviceInfos.clear();
            this.mCameraPluginDeviceInfos.addAll(list);
            hna.O000000o().checkPassedForCamera(this, true, new inc() {
                /* class com.xiaomi.smarthome.device.choosedevice.$$Lambda$ChooseDeviceActivity$3BbIJGG3ETFYtWCVrNRY2k8quc */

                public final void onAction(List list) {
                    ChooseDeviceActivity.this.lambda$chooseCategory$4$ChooseDeviceActivity(list);
                }
            });
            return;
        }
        gotoSubCategoryPage(str, str2, (ArrayList) list);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public /* synthetic */ void lambda$chooseCategory$4$ChooseDeviceActivity(List list) {
        Intent intent = new Intent();
        intent.setClass(this, ScanBarcodeActivity.class);
        intent.putExtra("from", 200);
        intent.putExtra("from_category_entry", true);
        startActivityForResult(intent, 1002);
    }

    private void gotoSubCategoryPage(String str, String str2, ArrayList<PluginDeviceInfo> arrayList) {
        LogType logType = LogType.KUAILIAN;
        gsy.O00000o0(logType, "ChooseDeviceActivity", "gotoSubCategoryPage start:" + System.currentTimeMillis());
        selectSubCategoryPluginDeviceInfo.clear();
        selectSubCategoryPluginDeviceInfo.addAll(arrayList);
        hxi.O00000o.O00000o0(this.mChooseManuallyFragment.O000000o(str), this.mChooseManuallyFragment.O00000Oo(str2));
        LogType logType2 = LogType.KUAILIAN;
        gsy.O00000o0(logType2, "ChooseDeviceActivity", "gotoSubCategoryPage end:" + System.currentTimeMillis());
        Intent intent = new Intent();
        intent.setClass(this, ChooseSubCategoryDeviceActivity.class);
        intent.putExtra("from_miui", this.isFromMiui);
        intent.putExtra("sub_category_name", str2);
        intent.putExtra("sub_category_id", this.mChooseManuallyFragment.O00000Oo(str2));
        intent.putExtra("category_id", this.mChooseManuallyFragment.O000000o(str));
        startActivityForResult(intent, 1003);
    }

    public void chooseConnectDevice(PluginDeviceInfo pluginDeviceInfo) {
        chooseDevice(pluginDeviceInfo, null, 2);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        boolean z = false;
        if (i != 1002 || intent == null || !intent.getBooleanExtra("camera_mannal_select", false)) {
            if (i2 == -1) {
                String stringExtra = intent.getStringExtra("scan_mitv_result");
                if (!TextUtils.isEmpty(stringExtra)) {
                    gsy.O00000Oo("ChooseDeviceActivity", "qrCodeMiTVDevice = ".concat(String.valueOf(stringExtra)));
                    Uri parse = Uri.parse(stringExtra);
                    String queryParameter = parse.getQueryParameter("a");
                    String queryParameter2 = parse.getQueryParameter("pid");
                    String queryParameter3 = parse.getQueryParameter("did");
                    String queryParameter4 = parse.getQueryParameter("blemac");
                    parse.getQueryParameter("loginurl");
                    DeviceRouterFactory.getBleManager().stopSearchBleDevice();
                    Intent intent2 = new Intent(this, ScanBleDeviceActivity.class);
                    intent2.putExtra("ble_mac", queryParameter4);
                    intent2.putExtra("aType", queryParameter);
                    intent2.putExtra("did", queryParameter3);
                    intent2.putExtra("pid", Integer.parseInt(queryParameter2));
                    startActivity(intent2);
                    finish();
                    return;
                }
                String stringExtra2 = intent.getStringExtra("sc_device");
                if (!TextUtils.isEmpty(stringExtra2)) {
                    fbt fbt = new fbt(this, "ScDeviceScanBarCodeActivity");
                    fbt.O000000o("qrCode", stringExtra2);
                    fbs.O000000o(fbt);
                    return;
                }
                String stringExtra3 = intent.getStringExtra("QRDebug");
                if (!TextUtils.isEmpty(stringExtra3)) {
                    Intent intent3 = new Intent();
                    intent3.putExtra("QRDebug", stringExtra3);
                    setResult(-1, intent3);
                    finish();
                    return;
                } else if (!TextUtils.isEmpty(intent.getStringExtra("TO_B"))) {
                    finish();
                    return;
                } else {
                    String stringExtra4 = intent.getStringExtra("scan_result");
                    hxi.O00000o.f952O000000o.O000000o("scan_success", "model", stringExtra4);
                    PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(stringExtra4);
                    if (O00000oO != null) {
                        htx O000000o2 = hty.O000000o();
                        if (O000000o2 != null) {
                            O000000o2.setDeviceSource(4);
                        }
                        Intent intent4 = new Intent();
                        if (intent.hasExtra("mac")) {
                            intent4.putExtra("mac", intent.getStringExtra("mac"));
                        }
                        if (intent.hasExtra("key_qrcode_oob")) {
                            intent4.putExtra("key_qrcode_oob", intent.getStringExtra("key_qrcode_oob"));
                        }
                        chooseDevice(O00000oO, intent4, 3);
                        finish();
                        return;
                    } else if (i == 1000) {
                        if (intent.getBooleanExtra("camera_mannal_select", false)) {
                            startActivity(new Intent(this, ChooseDeviceActivity.class));
                            finish();
                        } else {
                            izb.O000000o(this, getString(R.string.qr_cannot_find_device), 0).show();
                            finish();
                            return;
                        }
                    }
                }
            } else if (i == 1000) {
                finish();
                return;
            }
            if (intent != null) {
                z = intent.getBooleanExtra("finish", true);
            }
            if (z) {
                finish();
                return;
            }
            return;
        }
        gotoSubCategoryPage(this.mCameraMainCategoryName, this.mCameraCategoryName, this.mCameraPluginDeviceInfos);
    }

    public void onPause() {
        super.onPause();
        if (!this.mIsScanFromMainPage) {
            mIsActivityResumed = false;
            this.mDeviceScanHelper.onPause(this);
            DeviceObserveService.O000000o().O000000o(null, true);
        }
    }

    public void onStop() {
        super.onStop();
        if (!this.mIsScanFromMainPage) {
            DevicePushBindManager.instance.resetPopStatus();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.mIsScanFromMainPage && this.mOrientation != configuration.orientation) {
            DeviceScanManager.instance.onOrientaionChanged();
        }
    }
}
