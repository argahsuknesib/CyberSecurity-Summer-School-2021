package com.xiaomi.qrcode;

import _m_j.cjo;
import _m_j.ekq;
import _m_j.esy;
import _m_j.etb;
import _m_j.etd;
import _m_j.ete;
import _m_j.etg;
import _m_j.eyr;
import _m_j.fao;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.foc;
import _m_j.fpw;
import _m_j.fqy;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ftn;
import _m_j.fvo;
import _m_j.gnk;
import _m_j.gos;
import _m_j.gpc;
import _m_j.gsy;
import _m_j.hjp;
import _m_j.hna;
import _m_j.htt;
import _m_j.hxi;
import _m_j.hxy;
import _m_j.iue;
import _m_j.iuh;
import _m_j.ivz;
import _m_j.ixe;
import _m_j.izb;
import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.common.GlobalHistogramBinarizer;
import com.google.zxing.multi.qrcode.QRCodeMultiReader;
import com.mijia.generalplayer.config.CameraPlayerConfig;
import com.tencent.mmkv.MMKVRecoverStrategic;
import com.xiaomi.qrcode.CaptureActivityHandler;
import com.xiaomi.qrcode.camera.CameraTextureView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.ChooseGatewayDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.ResetDevicePage;
import com.xiaomi.smarthome.device.api.FDDeviceApi;
import com.xiaomi.smarthome.device.utils.MoxiangOOBInfo;
import com.xiaomi.smarthome.feedback.view.ScanDeviceImagePickerPreview;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Locale;
import java.util.Stack;
import java.util.UUID;
import kotlin.Result;
import org.json.JSONObject;

public class ScanBarcodeActivity extends BaseActivity implements TextureView.SurfaceTextureListener {

    /* renamed from: O000000o  reason: collision with root package name */
    protected Stack<hxy> f6586O000000o = new Stack<>();
    protected boolean O00000Oo = false;
    private esy O00000o;
    private etb O00000o0;
    private ObjectAnimator O00000oO;
    private XQProgressDialog O00000oo;
    private TextView O0000O0o;
    private boolean O0000OOo = false;
    private TextView O0000Oo;
    private int O0000Oo0;
    private View O0000OoO;
    private ScanDeviceImagePickerPreview O0000Ooo;
    private TextView O0000o;
    private long O0000o0;
    private CaptureActivityHandler O0000o00;
    private MoxiangOOBInfo O0000o0O;
    private String O0000o0o;
    private boolean O0000oO;
    private TextView O0000oO0;
    private boolean O0000oOO;
    private etg.O000000o O0000oOo = new etg.O000000o() {
        /* class com.xiaomi.qrcode.ScanBarcodeActivity.AnonymousClass6 */

        public final void O000000o(int i, int i2, int i3) {
            ScanBarcodeActivity.this.mTextureView.O000000o(i, i2, i3);
            ScanBarcodeActivity.this.mCameraScanner.O000000o(ScanBarcodeActivity.this.mRect);
        }

        public final void O000000o() {
            gsy.O00000o0(LogType.CAMERA, com.xiaomi.qrcode2.ScanBarcodeActivity.TAG, "openCameraError");
        }
    };
    private String O0000oo0;
    public etg mCameraScanner;
    public String mModel;
    public Rect mRect;
    public View mScanLine;
    public CameraTextureView mTextureView;
    public ImageView mTorchIv;
    public long startTime;
    public ViewfinderView viewfinderView;

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0190, code lost:
        if (_m_j.fvo.O0000oo() != false) goto L_0x01ad;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0268  */
    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        this.O0000o0 = System.currentTimeMillis();
        getWindow().addFlags(NotificationCompat.FLAG_HIGH_PRIORITY);
        setContentView((int) R.layout.scan_barcode_activity);
        ((ImageView) findViewById(R.id.module_a_3_return_btn)).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.qrcode.$$Lambda$ScanBarcodeActivity$fneyKTeISJrrM_DJml4x5IVg_rI */

            public final void onClick(View view) {
                ScanBarcodeActivity.this.O000000o(view);
            }
        });
        this.O0000Oo0 = getIntent().getIntExtra("from", 0);
        this.mModel = getIntent().getStringExtra("model");
        String stringExtra = getIntent().getStringExtra("desc");
        this.O0000o = (TextView) findViewById(R.id.module_a_3_return_title);
        this.O0000Oo = (TextView) findViewById(R.id.tips);
        this.O0000o.setText((int) R.string.sc_scan_btn_text);
        if (!TextUtils.isEmpty(stringExtra)) {
            this.O0000Oo.setText(stringExtra);
        }
        this.mScanLine = findViewById(R.id.scan_line);
        this.O0000O0o = (TextView) findViewById(R.id.add_manully);
        if (getIntent().getBooleanExtra("show_add_manully", false)) {
            this.O0000O0o.setVisibility(0);
            this.O0000O0o.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.qrcode.ScanBarcodeActivity.AnonymousClass1 */

                public final void onClick(View view) {
                    ScanBarcodeActivity.this.setResult(-3, new Intent());
                    ScanBarcodeActivity.this.finish();
                }
            });
        }
        this.O00000o0 = new etb(this);
        this.O00000o = new esy(this);
        int O00000Oo2 = (gpc.O00000Oo(this) * 6) / 9;
        this.mScanLine.getLayoutParams().width = O00000Oo2;
        ViewGroup.LayoutParams layoutParams = ((ViewGroup) this.mScanLine.getParent()).getLayoutParams();
        layoutParams.width = O00000Oo2;
        layoutParams.height = O00000Oo2;
        View view = this.mScanLine;
        this.O00000oO = ObjectAnimator.ofFloat(view, "translationY", view.getTranslationY(), (float) O00000Oo2);
        this.O00000oO.setDuration(3000L);
        this.O00000oO.setRepeatCount(-1);
        this.O00000oO.setInterpolator(new LinearInterpolator());
        this.viewfinderView = (ViewfinderView) findViewById(R.id.viewfinder_view);
        this.mTextureView = (CameraTextureView) findViewById(R.id.preview_view);
        this.mTextureView.setSurfaceTextureListener(this);
        this.mScanLine.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.xiaomi.qrcode.ScanBarcodeActivity.AnonymousClass3 */

            public final void onGlobalLayout() {
                ViewGroup viewGroup = (ViewGroup) ScanBarcodeActivity.this.mScanLine.getParent();
                Rect rect = new Rect(viewGroup.getLeft(), viewGroup.getTop(), viewGroup.getRight(), viewGroup.getBottom());
                ScanBarcodeActivity.this.viewfinderView.setRect(rect);
                ScanBarcodeActivity.this.viewfinderView.invalidate();
                ScanBarcodeActivity.this.mRect = rect;
            }
        });
        cjo O000000o2 = cjo.O000000o();
        String str = Build.MANUFACTURER;
        LogType logType = LogType.CAMERA;
        gsy.O00000o0(logType, "CameraPlayerConfigManager", "manufacturer:" + str + ",product:" + Build.PRODUCT);
        CameraPlayerConfig O00000Oo3 = O000000o2.O00000Oo();
        if (O00000Oo3 == null) {
            gsy.O00000o0(LogType.CAMERA, "CameraPlayerConfigManager", "cameraPlayerConfig is null");
        } else if (cjo.O00000Oo(O00000Oo3.scan_camera_api2_not_support_manufacturer)) {
            gsy.O00000o0(LogType.CAMERA, "CameraPlayerConfigManager", "isNotSupportApi2 inManufacturerList");
        } else if (cjo.O000000o(O00000Oo3.scan_camera_api2_not_support_devices)) {
            gsy.O00000o0(LogType.CAMERA, "CameraPlayerConfigManager", "isNotSupportApi2 inDevicesList");
        } else {
            z = false;
            if (!z) {
                fvo.O000000o();
                if (fvo.O0000oo0()) {
                    fvo.O000000o();
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    this.mCameraScanner = new ete(this.O0000oOo);
                } else {
                    this.mCameraScanner = new etd(this.O0000oOo);
                }
                this.O0000o00 = new CaptureActivityHandler(this);
                this.mCameraScanner.O000000o(this.O0000o00);
                if (getIntent() != null) {
                    try {
                        this.O0000o0O = MoxiangOOBInfo.valueOf(getIntent().getStringExtra("moxiang_oob_info"));
                    } catch (Exception unused) {
                    }
                    if (this.O0000o0O != null) {
                        int i = AnonymousClass2.f6589O000000o[this.O0000o0O.ordinal()];
                        if (i == 1 || i == 2) {
                            this.O0000o.setText((int) R.string.moxiang_scan_station_title);
                            this.O0000o0o = getIntent().getStringExtra("station_did");
                        } else if (i == 3) {
                            this.O0000o.setText((int) R.string.moxiang_scan_device_title);
                        }
                    }
                }
                this.O0000OoO = findViewById(R.id.bottom_menu_layout);
                this.mTorchIv = (ImageView) findViewById(R.id.torch_img);
                this.O0000Ooo = (ScanDeviceImagePickerPreview) findViewById(R.id.image_pick_preview);
                this.O0000oO0 = (TextView) findViewById(R.id.mannual_add_device_btn);
                this.O0000oO = getIntent().getBooleanExtra("from_mainpage", false);
                this.O0000oOO = getIntent().getBooleanExtra("from_category_entry", false);
                if (!this.O0000oO && !this.O0000oOO) {
                    this.O0000OoO.setVisibility(4);
                    this.O0000oO0.setVisibility(4);
                }
                if (this.O0000o0O == MoxiangOOBInfo.ONLY_STAION_OOB_EXIST) {
                    this.O0000oO0.setVisibility(0);
                }
                this.O0000oO0.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.qrcode.ScanBarcodeActivity.AnonymousClass4 */

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
                    public final void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra("camera_mannal_select", true);
                        intent.putExtra("finish", false);
                        ScanBarcodeActivity.this.setResult(-1, intent);
                        ScanBarcodeActivity.this.finish();
                    }
                });
                this.mTorchIv.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.qrcode.ScanBarcodeActivity.AnonymousClass5 */

                    public final void onClick(View view) {
                        if (ScanBarcodeActivity.this.mCameraScanner == null) {
                            return;
                        }
                        if (!ScanBarcodeActivity.this.mCameraScanner.O00000oO()) {
                            ScanBarcodeActivity.this.mCameraScanner.O00000o0();
                            if (Build.VERSION.SDK_INT >= 21) {
                                ScanBarcodeActivity.this.mTorchIv.setBackground(ScanBarcodeActivity.this.getDrawable(R.drawable.mj_scan_torch_open));
                                return;
                            }
                            return;
                        }
                        ScanBarcodeActivity.this.mCameraScanner.O00000o();
                        if (Build.VERSION.SDK_INT >= 21) {
                            ScanBarcodeActivity.this.mTorchIv.setBackground(ScanBarcodeActivity.this.getDrawable(R.drawable.mj_scan_torch_closed));
                        }
                    }
                });
            }
            this.mCameraScanner = new etd(this.O0000oOo);
            this.O0000o00 = new CaptureActivityHandler(this);
            this.mCameraScanner.O000000o(this.O0000o00);
            if (getIntent() != null) {
            }
            this.O0000OoO = findViewById(R.id.bottom_menu_layout);
            this.mTorchIv = (ImageView) findViewById(R.id.torch_img);
            this.O0000Ooo = (ScanDeviceImagePickerPreview) findViewById(R.id.image_pick_preview);
            this.O0000oO0 = (TextView) findViewById(R.id.mannual_add_device_btn);
            this.O0000oO = getIntent().getBooleanExtra("from_mainpage", false);
            this.O0000oOO = getIntent().getBooleanExtra("from_category_entry", false);
            this.O0000OoO.setVisibility(4);
            this.O0000oO0.setVisibility(4);
            if (this.O0000o0O == MoxiangOOBInfo.ONLY_STAION_OOB_EXIST) {
            }
            this.O0000oO0.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.qrcode.ScanBarcodeActivity.AnonymousClass4 */

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
                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("camera_mannal_select", true);
                    intent.putExtra("finish", false);
                    ScanBarcodeActivity.this.setResult(-1, intent);
                    ScanBarcodeActivity.this.finish();
                }
            });
            this.mTorchIv.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.qrcode.ScanBarcodeActivity.AnonymousClass5 */

                public final void onClick(View view) {
                    if (ScanBarcodeActivity.this.mCameraScanner == null) {
                        return;
                    }
                    if (!ScanBarcodeActivity.this.mCameraScanner.O00000oO()) {
                        ScanBarcodeActivity.this.mCameraScanner.O00000o0();
                        if (Build.VERSION.SDK_INT >= 21) {
                            ScanBarcodeActivity.this.mTorchIv.setBackground(ScanBarcodeActivity.this.getDrawable(R.drawable.mj_scan_torch_open));
                            return;
                        }
                        return;
                    }
                    ScanBarcodeActivity.this.mCameraScanner.O00000o();
                    if (Build.VERSION.SDK_INT >= 21) {
                        ScanBarcodeActivity.this.mTorchIv.setBackground(ScanBarcodeActivity.this.getDrawable(R.drawable.mj_scan_torch_closed));
                    }
                }
            });
        }
        z = true;
        if (!z) {
        }
        this.mCameraScanner = new etd(this.O0000oOo);
        this.O0000o00 = new CaptureActivityHandler(this);
        this.mCameraScanner.O000000o(this.O0000o00);
        if (getIntent() != null) {
        }
        this.O0000OoO = findViewById(R.id.bottom_menu_layout);
        this.mTorchIv = (ImageView) findViewById(R.id.torch_img);
        this.O0000Ooo = (ScanDeviceImagePickerPreview) findViewById(R.id.image_pick_preview);
        this.O0000oO0 = (TextView) findViewById(R.id.mannual_add_device_btn);
        this.O0000oO = getIntent().getBooleanExtra("from_mainpage", false);
        this.O0000oOO = getIntent().getBooleanExtra("from_category_entry", false);
        this.O0000OoO.setVisibility(4);
        this.O0000oO0.setVisibility(4);
        if (this.O0000o0O == MoxiangOOBInfo.ONLY_STAION_OOB_EXIST) {
        }
        this.O0000oO0.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.qrcode.ScanBarcodeActivity.AnonymousClass4 */

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
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("camera_mannal_select", true);
                intent.putExtra("finish", false);
                ScanBarcodeActivity.this.setResult(-1, intent);
                ScanBarcodeActivity.this.finish();
            }
        });
        this.mTorchIv.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.qrcode.ScanBarcodeActivity.AnonymousClass5 */

            public final void onClick(View view) {
                if (ScanBarcodeActivity.this.mCameraScanner == null) {
                    return;
                }
                if (!ScanBarcodeActivity.this.mCameraScanner.O00000oO()) {
                    ScanBarcodeActivity.this.mCameraScanner.O00000o0();
                    if (Build.VERSION.SDK_INT >= 21) {
                        ScanBarcodeActivity.this.mTorchIv.setBackground(ScanBarcodeActivity.this.getDrawable(R.drawable.mj_scan_torch_open));
                        return;
                    }
                    return;
                }
                ScanBarcodeActivity.this.mCameraScanner.O00000o();
                if (Build.VERSION.SDK_INT >= 21) {
                    ScanBarcodeActivity.this.mTorchIv.setBackground(ScanBarcodeActivity.this.getDrawable(R.drawable.mj_scan_torch_closed));
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        O000000o();
    }

    /* renamed from: com.xiaomi.qrcode.ScanBarcodeActivity$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f6589O000000o = new int[MoxiangOOBInfo.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            f6589O000000o[MoxiangOOBInfo.NONE_OOB_EXIST.ordinal()] = 1;
            f6589O000000o[MoxiangOOBInfo.ONLY_DEVICE_OOB_EXIST.ordinal()] = 2;
            try {
                f6589O000000o[MoxiangOOBInfo.ONLY_STAION_OOB_EXIST.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
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
    private void O000000o() {
        Intent intent = new Intent();
        intent.putExtra("finish", false);
        setResult(0, intent);
        finish();
    }

    public void onResume() {
        super.onResume();
        O00000o0();
        this.O00000o.O000000o();
        this.O00000o0.O00000o0();
        this.mScanLine.setVisibility(0);
        this.O00000oO.start();
        this.startTime = System.currentTimeMillis();
        hxi.O00000o0.f957O000000o.O000000o("adddevice_scan_show", new Object[0]);
    }

    public void onPause() {
        this.O00000o0.O00000Oo();
        this.O00000o.close();
        this.O00000oO.cancel();
        super.onPause();
    }

    public void onStop() {
        super.onStop();
        gsy.O00000Oo(com.xiaomi.qrcode2.ScanBarcodeActivity.TAG, "onStop");
        this.mCameraScanner.O00000Oo();
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        if (this.mTextureView.isAvailable()) {
            O00000Oo();
        }
        super.onRestart();
    }

    public void onDestroy() {
        this.O00000o0.O00000o();
        if (!this.O00000Oo && !this.f6586O000000o.isEmpty()) {
            hxy pop = this.f6586O000000o.pop();
            if (pop != null && pop.O00000oO && eyr.O00000Oo().O00000o0(pop.O00000Oo)) {
                SmartConfigRouterFactory.getStatPageV2Manager().pageDeviceFail(pop);
            }
            this.f6586O000000o.clear();
        }
        this.mCameraScanner.O00000oo();
        CaptureActivityHandler captureActivityHandler = this.O0000o00;
        captureActivityHandler.O00000Oo = CaptureActivityHandler.State.DONE;
        Message.obtain(captureActivityHandler.f6583O000000o.O000000o(), (int) R.id.quit).sendToTarget();
        try {
            captureActivityHandler.f6583O000000o.join(500);
        } catch (InterruptedException unused) {
        }
        captureActivityHandler.removeMessages(R.id.decode_succeeded);
        captureActivityHandler.removeMessages(R.id.decode_failed);
        captureActivityHandler.removeMessages(R.id.decode_next);
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            if (!(i == 27 || i == 80)) {
                if (i == 24) {
                    this.mCameraScanner.O00000o0();
                } else if (i != 25) {
                    return super.onKeyDown(i, keyEvent);
                } else {
                    this.mCameraScanner.O00000o();
                    return true;
                }
            }
            return true;
        }
        O000000o();
        return true;
    }

    private void O00000Oo() {
        this.mCameraScanner.O000000o(this.mTextureView.getSurfaceTexture());
        this.mCameraScanner.O000000o(this.mTextureView.getWidth(), this.mTextureView.getHeight());
        this.mCameraScanner.O000000o(this);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        gsy.O00000Oo(com.xiaomi.qrcode2.ScanBarcodeActivity.TAG, getClass().getName() + ".onSurfaceTextureAvailable() width = " + i + " , height = " + i2);
        O00000Oo();
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.mCameraScanner.O000000o(this.mTextureView.getWidth(), this.mTextureView.getHeight());
        this.mCameraScanner.O000000o(this.mRect);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        gsy.O00000Oo(com.xiaomi.qrcode2.ScanBarcodeActivity.TAG, "onSurfaceTextureDestroyed");
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:122:0x0332  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0344  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0296  */
    public void handleDecode(String str, Bitmap bitmap, float f) {
        int i;
        boolean z;
        int i2;
        boolean z2;
        String str2 = str;
        this.O00000o0.O000000o();
        this.O00000oO.cancel();
        gsy.O00000o0(LogType.CAMERA, com.xiaomi.qrcode2.ScanBarcodeActivity.TAG, "scan total time:".concat(String.valueOf(System.currentTimeMillis() - this.startTime)));
        if (!TextUtils.isEmpty(str)) {
            hxi.O00000o0.f957O000000o.O000000o("home_scan_QRCode_sw", new Object[0]);
        }
        if (str2 != null && ekq.O00000Oo(str) && ftn.O00000oo(this)) {
            fao.O000000o(this, str);
            hxi.O00000o0.O00000oO(fpw.O00000Oo);
            finish();
        } else if (this.O0000Oo0 != 0) {
            if (!this.O0000OOo) {
                boolean z3 = true;
                this.O0000OOo = true;
                String stringExtra = getIntent().getStringExtra("pid");
                int i3 = this.O0000Oo0;
                if (i3 == 100) {
                    if (this.mModel == null) {
                        O000000o();
                    }
                    showDialog();
                    if (!TextUtils.isEmpty(this.mModel) && DeviceFactory.O0000oo0(this.mModel)) {
                        gnk.O00000o0(String.format("verifyQrcode qrCode = %s, model = %s", str2, this.mModel));
                        FDDeviceApi.getInstance().verifyQrcode(this, str2, this.mModel, new fsm<JSONObject, fso>(100) {
                            /* class com.xiaomi.qrcode.ScanBarcodeActivity.AnonymousClass7 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ int f6594O000000o = 100;

                            public final /* synthetic */ void onSuccess(Object obj) {
                                JSONObject jSONObject = (JSONObject) obj;
                                gnk.O00000o0(String.format(">>> onSuccess: %s", jSONObject));
                                if (jSONObject == null) {
                                    ScanBarcodeActivity.this.verifyFailed();
                                    return;
                                }
                                String optString = jSONObject.optString("sid");
                                int optInt = jSONObject.optInt("bindType", -1);
                                if (TextUtils.isEmpty(optString) || optInt == -1) {
                                    ScanBarcodeActivity.this.f6586O000000o.push(new hxy(0, ScanBarcodeActivity.this.mModel, 6102, "", true));
                                    ScanBarcodeActivity.this.verifyFailed();
                                    return;
                                }
                                ScanBarcodeActivity.this.dismissDialog();
                                ScanBarcodeActivity scanBarcodeActivity = ScanBarcodeActivity.this;
                                scanBarcodeActivity.O00000Oo = true;
                                int i = this.f6594O000000o;
                                if (i == 100) {
                                    Intent intent = new Intent();
                                    intent.putExtra("scan_result", jSONObject.toString());
                                    ScanBarcodeActivity.this.setResult(-1, intent);
                                } else if (i == 200) {
                                    fbt fbt = new fbt(scanBarcodeActivity, "SmartConfigMainActivity");
                                    fbt.O000000o("connect_source", 3);
                                    fbt.O000000o("connect_unique", UUID.randomUUID().toString());
                                    fbt.O000000o("strategy_id", 5);
                                    fbt.O000000o("scan_result", jSONObject.toString());
                                    fbs.O000000o(fbt);
                                }
                                ScanBarcodeActivity.this.finish();
                                hxi.O00000o0.O00000oO(fpw.O00000o);
                                hxi.O00000o.O000000o(1, System.currentTimeMillis() - ScanBarcodeActivity.this.startTime, ScanBarcodeActivity.this.mModel);
                            }

                            public final void onFailure(fso fso) {
                                gnk.O00000o0(String.format(">>> onFailure: %s", fso));
                                ScanBarcodeActivity.this.f6586O000000o.push(new hxy(0, ScanBarcodeActivity.this.mModel, 6101, "", true));
                                ScanBarcodeActivity.this.verifyFailed();
                            }
                        });
                    } else {
                        QrCodeParser qrCodeParser = new QrCodeParser(str2, stringExtra);
                        if (qrCodeParser.f6584O000000o != null) {
                            O000000o(qrCodeParser, stringExtra);
                        } else {
                            O000000o(str2, 100);
                        }
                    }
                } else if (i3 == 200) {
                    QrCodeParser qrCodeParser2 = new QrCodeParser(str2, stringExtra);
                    if (qrCodeParser2.f6584O000000o != null) {
                        O000000o(qrCodeParser2, stringExtra);
                    } else if (O000000o(str)) {
                        Uri parse = Uri.parse(str2.replaceAll("\\+", "%2B"));
                        String queryParameter = parse.getQueryParameter("m");
                        String queryParameter2 = parse.getQueryParameter("p");
                        String queryParameter3 = parse.getQueryParameter("O");
                        String queryParameter4 = parse.getQueryParameter("d");
                        gsy.O00000Oo(com.xiaomi.qrcode2.ScanBarcodeActivity.TAG, "processStandardQrCode pid = " + queryParameter2 + "\nmac = " + queryParameter + "\nobb = " + queryParameter3 + "\n");
                        try {
                            i2 = Integer.parseInt(queryParameter2);
                        } catch (Exception e) {
                            gsy.O000000o(6, com.xiaomi.qrcode2.ScanBarcodeActivity.TAG, e.getLocalizedMessage());
                            i2 = 0;
                        }
                        String O00000Oo2 = CoreApi.O000000o().O00000Oo(i2);
                        if (TextUtils.isEmpty(O00000Oo2)) {
                            O00000o0(getString(R.string.device_choose_scan_qr_invalid));
                        } else {
                            PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(O00000Oo2);
                            if (htt.O000000o(O00000Oo2) || htt.O00000Oo(O00000Oo2)) {
                                gsy.O00000Oo(com.xiaomi.qrcode2.ScanBarcodeActivity.TAG, queryParameter + O00000Oo2 + queryParameter3);
                                foc.O0000OOo(queryParameter4, queryParameter3);
                                if (this.O0000o0O == null) {
                                    Intent intent = new Intent();
                                    intent.putExtra("scan_result", O00000Oo2);
                                    intent.putExtra("mac", queryParameter);
                                    if (!TextUtils.isEmpty(queryParameter3)) {
                                        intent.putExtra("key_qrcode_oob", queryParameter3);
                                    }
                                    setResult(-1, intent);
                                    finish();
                                } else {
                                    String string = getString(R.string.moxiang_scan_device_toast_error);
                                    int i4 = AnonymousClass2.f6589O000000o[this.O0000o0O.ordinal()];
                                    if (i4 == 1) {
                                        gsy.O00000Oo(com.xiaomi.qrcode2.ScanBarcodeActivity.TAG, "NONE_OOB_EXIST");
                                        if (htt.O000000o(O00000Oo2) && TextUtils.equals(queryParameter4, this.O0000o0o)) {
                                            this.O0000oo0 = queryParameter3;
                                            this.O0000o.setText((int) R.string.moxiang_scan_device_title);
                                            this.O0000o0O = MoxiangOOBInfo.ONLY_STAION_OOB_EXIST;
                                            z2 = false;
                                            this.O0000oO0.setVisibility(0);
                                            string = getString(R.string.moxiang_scan_device_toast_half);
                                            this.O0000OOo = z2;
                                            if (isValid()) {
                                                restartPreviewAfterDelay(3000);
                                                getWindow().getDecorView().postDelayed(new Runnable(string) {
                                                    /* class com.xiaomi.qrcode.$$Lambda$ScanBarcodeActivity$jsSY47JMTP5VKTTPdfc7wOlYc */
                                                    private final /* synthetic */ String f$1;

                                                    {
                                                        this.f$1 = r2;
                                                    }

                                                    public final void run() {
                                                        ScanBarcodeActivity.this.O00000o(this.f$1);
                                                    }
                                                }, 0);
                                            }
                                        }
                                    } else if (i4 == 2) {
                                        gsy.O00000Oo(com.xiaomi.qrcode2.ScanBarcodeActivity.TAG, "ONLY_DEVICE_OOB_EXIST");
                                        if (htt.O000000o(O00000Oo2) && TextUtils.equals(queryParameter4, this.O0000o0o)) {
                                            Intent intent2 = new Intent();
                                            intent2.putExtra("device_model", O00000Oo2);
                                            intent2.putExtra("mac", queryParameter);
                                            if (!TextUtils.isEmpty(queryParameter3)) {
                                                intent2.putExtra("station_pin_code", queryParameter3);
                                            }
                                            setResult(-1, intent2);
                                            finish();
                                        }
                                    } else if (i4 == 3) {
                                        gsy.O00000Oo(com.xiaomi.qrcode2.ScanBarcodeActivity.TAG, "ONLY_STAION_OOB_EXIST");
                                        if (htt.O00000Oo(O00000Oo2)) {
                                            Intent intent3 = new Intent();
                                            intent3.putExtra("device_model", O00000Oo2);
                                            intent3.putExtra("station_pin_code", this.O0000oo0);
                                            intent3.putExtra("mac", queryParameter);
                                            if (!TextUtils.isEmpty(queryParameter3)) {
                                                intent3.putExtra("key_qrcode_oob", queryParameter3);
                                            }
                                            setResult(-1, intent3);
                                            finish();
                                        }
                                    }
                                    z2 = false;
                                    this.O0000OOo = z2;
                                    if (isValid()) {
                                    }
                                }
                            } else if (O00000oO2 == null || O00000oO2.O0000o() != Device.PID_SUBDEVICE) {
                                Intent intent4 = new Intent(this, ResetDevicePage.class);
                                intent4.putExtra("model", O00000Oo2);
                                intent4.putExtra("mac", queryParameter);
                                if (!TextUtils.isEmpty(queryParameter3)) {
                                    intent4.putExtra("key_qrcode_oob", queryParameter3);
                                }
                                startActivity(intent4);
                                finish();
                                hxi.O00000o0.O00000oO(fpw.f16892O000000o);
                            } else {
                                ChooseGatewayDevice.selectActivity(this, O00000oO2, 1001, null);
                                finish();
                            }
                        }
                    } else {
                        if (!TextUtils.isEmpty(str) && str2.contains("home.mi.com")) {
                            gsy.O00000Oo(com.xiaomi.qrcode2.ScanBarcodeActivity.TAG, "checkMiTvBindQrValidity qrCode = ".concat(String.valueOf(str)));
                            Uri parse2 = Uri.parse(str);
                            String queryParameter5 = parse2.getQueryParameter("a");
                            if (queryParameter5 != null) {
                                String queryParameter6 = parse2.getQueryParameter("pid");
                                String queryParameter7 = parse2.getQueryParameter("did");
                                String queryParameter8 = parse2.getQueryParameter("blemac");
                                String queryParameter9 = parse2.getQueryParameter("loginurl");
                                if (!TextUtils.equals(queryParameter5, "bind") ? !(TextUtils.isEmpty(queryParameter5) || TextUtils.isEmpty(queryParameter6) || TextUtils.isEmpty(queryParameter7) || TextUtils.isEmpty(queryParameter8)) : !(TextUtils.isEmpty(queryParameter5) || TextUtils.isEmpty(queryParameter6) || TextUtils.isEmpty(queryParameter7) || TextUtils.isEmpty(queryParameter8) || TextUtils.isEmpty(queryParameter9))) {
                                    z = true;
                                    if (!z) {
                                        Intent intent5 = new Intent();
                                        intent5.putExtra("scan_mitv_result", str2);
                                        setResult(-1, intent5);
                                        finish();
                                    } else if (O00000Oo(str)) {
                                        Intent intent6 = new Intent();
                                        intent6.putExtra("sc_device", str2);
                                        setResult(-1, intent6);
                                        finish();
                                    } else if (!TextUtils.isEmpty(str) && (str2.contains("url.cn/5kZjV2P") || str2.contains("home.mi.com"))) {
                                        try {
                                            String decode = URLDecoder.decode(str2, "utf-8");
                                            Uri parse3 = Uri.parse(decode);
                                            String queryParameter10 = parse3.getQueryParameter("model");
                                            String queryParameter11 = parse3.getQueryParameter("ticket");
                                            if (!TextUtils.isEmpty(queryParameter10)) {
                                                Intent intent7 = new Intent();
                                                intent7.putExtra("scan_result", queryParameter10);
                                                String queryParameter12 = parse3.getQueryParameter("OOB");
                                                if (!TextUtils.isEmpty(queryParameter12)) {
                                                    intent7.putExtra("key_qrcode_oob", queryParameter12);
                                                }
                                                setResult(-1, intent7);
                                                finish();
                                                hxi.O00000o.O000000o(1, System.currentTimeMillis() - this.startTime, queryParameter10);
                                            } else if (!TextUtils.isEmpty(queryParameter11)) {
                                                Intent intent8 = new Intent();
                                                intent8.putExtra("TO_B", queryParameter11);
                                                hjp.O000000o(decode, "", false);
                                                setResult(-1, intent8);
                                                finish();
                                            } else {
                                                verifyFailed();
                                            }
                                        } catch (Exception e2) {
                                            verifyFailed();
                                            e2.printStackTrace();
                                        }
                                    } else if (hna.O00000Oo().isRNDebugQRCode(str2)) {
                                        Intent intent9 = new Intent();
                                        intent9.putExtra("QRDebug", str2);
                                        setResult(-1, intent9);
                                        finish();
                                    } else {
                                        eyr O00000Oo3 = eyr.O00000Oo();
                                        if (eyr.O000000o(O00000Oo3.O0000ooO, O00000Oo3.O0000ooo)) {
                                            if (TextUtils.isEmpty(str) || !str2.contains("app.imiwear.com")) {
                                                z3 = false;
                                            }
                                            if (z3) {
                                                verifyFailed();
                                            } else {
                                                O000000o(str2, 200);
                                            }
                                        } else {
                                            verifyFailed();
                                        }
                                    }
                                }
                            }
                        }
                        z = false;
                        if (!z) {
                        }
                    }
                } else if (i3 == 300) {
                    if (O00000Oo(str)) {
                        Intent intent10 = new Intent();
                        intent10.putExtra("sc_device", str2);
                        setResult(-1, intent10);
                        finish();
                    } else {
                        verifyFailed();
                    }
                } else if (i3 == 400) {
                    Intent intent11 = new Intent();
                    intent11.putExtra("rn_plugin", str2);
                    setResult(-1, intent11);
                    finish();
                } else if (i3 == 500) {
                    if (O000000o(str)) {
                        Uri parse4 = Uri.parse(str2.replaceAll("\\+", "%2B"));
                        String queryParameter13 = parse4.getQueryParameter("O");
                        if (!TextUtils.isEmpty(queryParameter13)) {
                            String queryParameter14 = parse4.getQueryParameter("p");
                            String queryParameter15 = parse4.getQueryParameter("d");
                            try {
                                i = Integer.parseInt(queryParameter14);
                            } catch (Exception e3) {
                                gsy.O000000o(6, com.xiaomi.qrcode2.ScanBarcodeActivity.TAG, e3.getLocalizedMessage());
                                i = 0;
                            }
                            String O00000Oo4 = CoreApi.O000000o().O00000Oo(i);
                            if (htt.O000000o(O00000Oo4) || htt.O00000Oo(O00000Oo4)) {
                                foc.O0000OOo(queryParameter15, queryParameter13);
                            }
                            Intent intent12 = new Intent();
                            intent12.putExtra("key_qrcode_oob", queryParameter13);
                            setResult(-1, intent12);
                            finish();
                        } else {
                            verifyFailed();
                        }
                    } else {
                        try {
                            String queryParameter16 = Uri.parse(URLDecoder.decode(str2, "utf-8")).getQueryParameter("OOB");
                            if (!TextUtils.isEmpty(queryParameter16)) {
                                Intent intent13 = new Intent();
                                intent13.putExtra("key_qrcode_oob", queryParameter16);
                                setResult(-1, intent13);
                                finish();
                            } else {
                                verifyFailed();
                            }
                        } catch (UnsupportedEncodingException e4) {
                            e4.printStackTrace();
                            verifyFailed();
                        }
                    }
                }
            }
            hxi.O00000o0.O00000oO(fpw.O00000Oo);
        } else {
            Intent intent14 = new Intent();
            intent14.putExtra("scan_result", str2);
            setResult(-1, intent14);
            hxi.O00000o0.O00000oO(fpw.O00000Oo);
            finish();
        }
    }

    private static boolean O000000o(String str) {
        if (!TextUtils.isEmpty(str) && str.contains("home.mi.com")) {
            gsy.O00000Oo(com.xiaomi.qrcode2.ScanBarcodeActivity.TAG, "checkStandardQrValidity qrCode = ".concat(String.valueOf(str)));
            if (!TextUtils.isEmpty(Uri.parse(str).getQueryParameter("p"))) {
                return true;
            }
        }
        return false;
    }

    private static boolean O00000Oo(String str) {
        if (!TextUtils.isEmpty(str) && str.contains("home.mi.com")) {
            gsy.O00000Oo(com.xiaomi.qrcode2.ScanBarcodeActivity.TAG, "checkScBindQrValidity qrCode = ".concat(String.valueOf(str)));
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("did");
            if (queryParameter == null) {
                return false;
            }
            gsy.O00000Oo(com.xiaomi.qrcode2.ScanBarcodeActivity.TAG, "checkScBindQrValidity did = ".concat(String.valueOf(queryParameter)));
            String queryParameter2 = parse.getQueryParameter("url");
            if (queryParameter2 == null) {
                return false;
            }
            String str2 = new String(Base64.decode(queryParameter2, 0));
            gsy.O00000Oo(com.xiaomi.qrcode2.ScanBarcodeActivity.TAG, "checkScBindQrValidity loginUrl = ".concat(str2));
            if (TextUtils.isEmpty(queryParameter) || TextUtils.isEmpty(str2) || !str2.contains("account.xiaomi.com")) {
                return false;
            }
            return true;
        }
        return false;
    }

    private void O000000o(String str, final int i) {
        gnk.O00000o0(String.format("verifyQrCode qrcode = %s", str));
        FDDeviceApi.getInstance().verifyQrcodeNew(this, str, new fsm<JSONObject, fso>() {
            /* class com.xiaomi.qrcode.ScanBarcodeActivity.AnonymousClass8 */

            public final /* synthetic */ void onSuccess(Object obj) {
                int i;
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject != null) {
                    i = jSONObject.optInt("ret", -1);
                    if (i == 0) {
                        ScanBarcodeActivity.this.dismissDialog();
                        String optString = jSONObject.optString("bind_did");
                        int i2 = i;
                        if (i2 == 100) {
                            Intent intent = new Intent();
                            intent.putExtra("scan_result", optString);
                            ScanBarcodeActivity.this.setResult(-1, intent);
                        } else if (i2 == 200) {
                            fbt fbt = new fbt(ScanBarcodeActivity.this, "SmartConfigMainActivity");
                            fbt.O000000o("connect_source", 3);
                            fbt.O000000o("connect_unique", UUID.randomUUID().toString());
                            fbt.O000000o("strategy_id", 5);
                            fbt.O000000o("scan_result", optString);
                            fbs.O000000o(fbt);
                        }
                        ScanBarcodeActivity scanBarcodeActivity = ScanBarcodeActivity.this;
                        scanBarcodeActivity.O00000Oo = true;
                        scanBarcodeActivity.finish();
                        hxi.O00000o0.O00000oO(fpw.O00000o);
                        hxi.O00000o.O000000o(1, System.currentTimeMillis() - ScanBarcodeActivity.this.startTime, ScanBarcodeActivity.this.mModel);
                        return;
                    }
                } else {
                    i = -10;
                }
                ScanBarcodeActivity.this.f6586O000000o.push(new hxy(0, ScanBarcodeActivity.this.mModel, 6300 - i, "", true));
                ScanBarcodeActivity.this.verifyFailed();
            }

            public final void onFailure(fso fso) {
                ScanBarcodeActivity.this.f6586O000000o.push(new hxy(0, ScanBarcodeActivity.this.mModel, 6201, "", true));
                ScanBarcodeActivity.this.verifyFailed();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o(String str) {
        dismissDialog();
        this.O0000OOo = false;
        if (!this.O00000oO.isRunning()) {
            this.O00000oO.start();
        }
        O00000o0(str);
    }

    public void verifyFailed() {
        if (isValid()) {
            restartPreviewAfterDelay(3000);
            getWindow().getDecorView().postDelayed(new Runnable() {
                /* class com.xiaomi.qrcode.$$Lambda$ScanBarcodeActivity$3qfCFVShrMZNaetiLvw416pjBKE */

                public final void run() {
                    ScanBarcodeActivity.this.O00000o();
                }
            }, 0);
            long currentTimeMillis = System.currentTimeMillis() - this.startTime;
            LogType logType = LogType.CAMERA;
            gsy.O00000o0(logType, com.xiaomi.qrcode2.ScanBarcodeActivity.TAG, "decode time from create:" + (System.currentTimeMillis() - this.O0000o0));
            hxi.O00000o.O000000o(2, currentTimeMillis, "");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o() {
        dismissDialog();
        this.O0000OOo = false;
        if (!this.O00000oO.isRunning()) {
            this.O00000oO.start();
        }
        O00000o0(getString(R.string.device_choose_scan_qr_invalid));
    }

    private void O00000o0(String str) {
        if (this.O0000oO || this.O0000oOO) {
            Locale O00oOooo = CoreApi.O000000o().O00oOooo();
            if (O00oOooo == null) {
                O00oOooo = Locale.getDefault();
            }
            String language = O00oOooo.getLanguage();
            MLAlertDialog.Builder O000000o2 = new MLAlertDialog.Builder(getContext()).O000000o((int) R.string.device_choose_scan_qr_invalid);
            if (TextUtils.equals(language, Locale.CHINESE.getLanguage()) || TextUtils.equals(language, Locale.ENGLISH.getLanguage())) {
                O000000o2.O000000o((int) R.string.device_choose_scan_qr_failed_title);
                O000000o2.O00000Oo((int) R.string.device_choose_scan_qr_failed_message);
            }
            O000000o2.O000000o((int) R.string.add_device_manually2, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.qrcode.ScanBarcodeActivity.AnonymousClass10 */

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
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    Intent intent = new Intent();
                    intent.putExtra("camera_mannal_select", true);
                    intent.putExtra("finish", false);
                    ScanBarcodeActivity.this.setResult(-1, intent);
                    ScanBarcodeActivity.this.finish();
                    hxi.O00000o.O00oOoOo(1);
                }
            }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.qrcode.ScanBarcodeActivity.AnonymousClass9 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    hxi.O00000o.O00oOoOo(2);
                }
            }).O00000oo();
            if (this.O0000oO) {
                hxi.O00000o0.O0000O0o(1);
            } else if (this.O0000oOO) {
                hxi.O00000o0.O0000O0o(2);
            }
        } else {
            izb.O000000o(this, str, 0).show();
        }
    }

    public void showDialog() {
        dismissDialog();
        this.O00000oo = XQProgressDialog.O000000o(this, "", getString(R.string.verifying_qrcode));
    }

    public void dismissDialog() {
        XQProgressDialog xQProgressDialog = this.O00000oo;
        if (xQProgressDialog != null) {
            xQProgressDialog.dismiss();
            this.O00000oo = null;
        }
    }

    private void O000000o(QrCodeParser qrCodeParser, String str) {
        dismissDialog();
        if (TextUtils.isEmpty(str)) {
            String O00000Oo2 = CoreApi.O000000o().O00000Oo(Integer.parseInt(qrCodeParser.O00000Oo.O00000Oo));
            PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(O00000Oo2);
            if (O00000oO2 == null) {
                verifyFailed();
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("model", O00000Oo2);
                bundle.putString("nbiot", qrCodeParser.toString());
                int O00000o2 = O00000oO2.O00000o();
                if (O00000o2 == 14) {
                    ChooseGatewayDevice.selectActivity(this, O00000oO2, 12, bundle);
                } else if (O00000o2 == 15) {
                    Intent intent = new Intent(this, ResetDevicePage.class);
                    fqy.O000000o(intent, this);
                    startActivityForResult(intent.putExtras(bundle), 11);
                    hxi.O00000o0.O00000oO(fpw.f16892O000000o);
                }
                hxi.O00000o.O000000o(1, System.currentTimeMillis() - this.startTime, this.mModel);
            }
        } else {
            Intent intent2 = new Intent();
            intent2.putExtra("nbiot", qrCodeParser.toString());
            setResult(-2, intent2);
            finish();
        }
        hxi.O00000o0.O00000oO(fpw.f16892O000000o);
    }

    public void restartPreviewAfterDelay(long j) {
        CaptureActivityHandler captureActivityHandler = this.O0000o00;
        if (captureActivityHandler != null) {
            captureActivityHandler.sendEmptyMessageDelayed(R.id.restart_preview, j);
        }
        O00000o0();
    }

    private void O00000o0() {
        this.viewfinderView.setVisibility(0);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Cursor query;
        Closeable closeable;
        super.onActivityResult(i, i2, intent);
        if (i == 11) {
            if (i2 == -1) {
                setResult(-2, intent);
            }
            finish();
        } else if (i == 12) {
            if (i2 == -1) {
                setResult(-2, intent);
            }
            finish();
        } else if (i == 703) {
            ScanDeviceImagePickerPreview scanDeviceImagePickerPreview = this.O0000Ooo;
            ixe.O00000o(this, "activity");
            if (i == 703 && i2 == -1) {
                Uri data = intent == null ? null : intent.getData();
                if (!(data == null || TextUtils.isEmpty(data.getAuthority()) || (query = getContentResolver().query(data, new String[]{"_data"}, null, null, null)) == null)) {
                    try {
                        Result.O000000o o000000o = Result.f15374O000000o;
                        closeable = query;
                        query.moveToFirst();
                        String string = query.getString(query.getColumnIndex("_data"));
                        if (!TextUtils.isEmpty(string)) {
                            ixe.O00000Oo(string, "picPath");
                            ixe.O00000o(string, "filePath");
                            if (!scanDeviceImagePickerPreview.O00000Oo.O000000o()) {
                                BitmapFactory.Options options = new BitmapFactory.Options();
                                options.inJustDecodeBounds = true;
                                BitmapFactory.decodeFile(string, options);
                                int O000000o2 = gos.O000000o(options.outWidth, options.outHeight, 150, 22500);
                                BitmapFactory.Options options2 = new BitmapFactory.Options();
                                options2.inJustDecodeBounds = false;
                                options2.inSampleSize = O000000o2;
                                Bitmap decodeFile = BitmapFactory.decodeFile(string, options2);
                                scanDeviceImagePickerPreview.O00000Oo.clear();
                                scanDeviceImagePickerPreview.O00000Oo.add(new Pair(string, decodeFile));
                                scanDeviceImagePickerPreview.O000000o();
                            }
                        }
                        iuh iuh = iuh.f1631O000000o;
                        ivz.O000000o(closeable, null);
                        Result.O00000o0(iuh.f1631O000000o);
                    } catch (Throwable th) {
                        Result.O000000o o000000o2 = Result.f15374O000000o;
                        Result.O00000o0(iue.O000000o(th));
                    }
                }
            }
            if (this.O0000Ooo.getPickedItems().length > 0) {
                decodeQR(this.O0000Ooo.getPickedItems()[0]);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.Map.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
     arg types: [com.google.zxing.DecodeHintType, java.util.ArrayList]
     candidates:
      ClspMth{java.util.EnumMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
      ClspMth{java.util.Map.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V} */
    public void decodeQR(String str) {
        Bitmap bitmap;
        try {
            bitmap = loadBitmap(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            bitmap = null;
        }
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[(width * height)];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            BinaryBitmap binaryBitmap = new BinaryBitmap(new GlobalHistogramBinarizer(new RGBLuminanceSource(width, height, iArr)));
            QRCodeMultiReader qRCodeMultiReader = new QRCodeMultiReader();
            MultiFormatReader multiFormatReader = new MultiFormatReader();
            ArrayList arrayList = new ArrayList();
            arrayList.add(BarcodeFormat.QR_CODE);
            EnumMap enumMap = new EnumMap(DecodeHintType.class);
            enumMap.put((MMKVRecoverStrategic) DecodeHintType.POSSIBLE_FORMATS, (Integer) arrayList);
            multiFormatReader.setHints(enumMap);
            String str2 = "";
            try {
                com.google.zxing.Result[] decodeMultiple = qRCodeMultiReader.decodeMultiple(binaryBitmap);
                gsy.O00000o0(LogType.KUAILIAN, com.xiaomi.qrcode2.ScanBarcodeActivity.TAG, "scan text0:".concat(String.valueOf(decodeMultiple)));
                if (!(decodeMultiple == null || decodeMultiple.length <= 0 || decodeMultiple[0] == null)) {
                    str2 = decodeMultiple[0].getText();
                    handleDecode(str2, null, 0.0f);
                    multiFormatReader.reset();
                }
            } catch (NotFoundException e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                qRCodeMultiReader.reset();
                throw th;
            }
            qRCodeMultiReader.reset();
            if (TextUtils.isEmpty(str2)) {
                try {
                    com.google.zxing.Result decodeWithState = multiFormatReader.decodeWithState(binaryBitmap);
                    gsy.O00000o0(LogType.KUAILIAN, com.xiaomi.qrcode2.ScanBarcodeActivity.TAG, "scan text1:".concat(String.valueOf(decodeWithState)));
                    if (decodeWithState != null) {
                        handleDecode(decodeWithState.getText(), null, 0.0f);
                    } else {
                        verifyFailed();
                    }
                } catch (NotFoundException e3) {
                    e3.printStackTrace();
                    verifyFailed();
                } finally {
                    multiFormatReader.reset();
                }
            }
        }
    }

    public static Bitmap loadBitmap(String str) throws FileNotFoundException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        int i = options.outWidth;
        int i2 = options.outHeight;
        options.inSampleSize = 1;
        if (i > i2) {
            if (i > 360) {
                options.inSampleSize = i / 360;
            }
        } else if (i2 > 360) {
            options.inSampleSize = i2 / 360;
        }
        options.inJustDecodeBounds = false;
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        if (decodeFile != null) {
            return decodeFile;
        }
        throw new FileNotFoundException("Couldn't open ".concat(String.valueOf(str)));
    }
}
