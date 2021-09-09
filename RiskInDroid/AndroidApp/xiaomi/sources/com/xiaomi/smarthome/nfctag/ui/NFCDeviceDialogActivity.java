package com.xiaomi.smarthome.nfctag.ui;

import _m_j.ext;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fea;
import _m_j.fod;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gqd;
import _m_j.gsy;
import _m_j.hlz;
import _m_j.hxi;
import _m_j.hxk;
import _m_j.hxp;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.bluetooth.XmBluetoothDevice;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.framework.statistic.BindStep;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.wificonfig.RescanWifiActivity;
import java.util.ArrayList;

public class NFCDeviceDialogActivity extends BaseActivity implements View.OnClickListener {
    public static final String TAG = "NFCDeviceDialogActivity";
    public static boolean sResumed = false;

    /* renamed from: O000000o  reason: collision with root package name */
    private LinearLayout f10403O000000o;
    private TextView O00000Oo;
    private Button O00000o;
    private LinearLayout O00000o0;
    private String O00000oO;
    private String O00000oo;
    private XmBluetoothDevice O0000O0o;
    private boolean O0000OOo;
    public View mIconContainer;
    public SimpleDraweeView mImageIcon;
    public String mModel;
    public boolean mPlayVideo = false;
    public VideoView mVideoIcon;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.mModel = intent.getStringExtra("model");
        this.O00000oO = intent.getStringExtra("did");
        this.O0000O0o = (XmBluetoothDevice) intent.getParcelableExtra("ble_device");
        if (this.mModel == null || this.O00000oO == null) {
            gsy.O00000o0(LogType.SCENE, TAG, "mBleDevice null return");
            finish();
            return;
        }
        this.O00000oo = intent.getStringExtra("mac");
        this.O0000OOo = intent.getBooleanExtra("isFindTarget", false);
        setContentView((int) R.layout.activity_nfc_find_device_dialog);
        this.f10403O000000o = (LinearLayout) findViewById(R.id.dialog);
        this.f10403O000000o.setOnTouchListener(new View.OnTouchListener() {
            /* class com.xiaomi.smarthome.nfctag.ui.NFCDeviceDialogActivity.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 4) {
                    hxk hxk = hxi.O00000o;
                    String str = NFCDeviceDialogActivity.this.mModel;
                    hxk.f952O000000o.O000000o("NFC_new_outside", "model", str);
                }
                return true;
            }
        });
        TextView textView = (TextView) findViewById(R.id.title);
        this.O00000Oo = (TextView) findViewById(R.id.tv_device_name);
        this.mImageIcon = (SimpleDraweeView) findViewById(R.id.icon_static);
        this.mVideoIcon = (VideoView) findViewById(R.id.icon_video);
        this.mIconContainer = findViewById(R.id.icon_container);
        this.O00000o0 = (LinearLayout) findViewById(R.id.ll_button);
        this.O00000o = (Button) findViewById(R.id.btn_know);
        PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(this.mModel);
        if (O00000oO2 == null) {
            finish();
        } else if (O00000oO2.O00000o() == 2 || O00000oO2.O00000o() == 3) {
            textView.setText((int) R.string.wifi_scan_new_device_title);
            if (!TextUtils.isEmpty(O00000oO2.O0000Oo0())) {
                this.O00000Oo.setVisibility(0);
                this.O00000Oo.setText(O00000oO2.O0000Oo0());
            }
            if (this.mImageIcon.getHierarchy() == null) {
                this.mImageIcon.setHierarchy(new GenericDraweeHierarchyBuilder(this.mImageIcon.getResources()).setFadeDuration(200).setActualImageScaleType(ScalingUtils.ScaleType.FIT_START).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_START).build());
            }
            hlz.O000000o(this.mModel, new fsm<hlz.O000000o, fso>() {
                /* class com.xiaomi.smarthome.nfctag.ui.NFCDeviceDialogActivity.AnonymousClass3 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    hlz.O000000o o000000o = (hlz.O000000o) obj;
                    NFCDeviceDialogActivity.this.setImage(o000000o.f19057O000000o, o000000o.O00000Oo);
                }

                public final void onFailure(fso fso) {
                    NFCDeviceDialogActivity.this.setImage("", "");
                }
            });
            if (!this.O0000OOo || this.O0000O0o == null) {
                hxp hxp = hxi.O00000o0;
                String str = this.mModel;
                hxp.f957O000000o.O000000o("NFC_open_device", "model", str);
                this.O00000o0.setVisibility(8);
                this.O00000o.setVisibility(0);
                this.O00000o.setOnClickListener(this);
                String string = getResources().getString(R.string.nfc_no_scan_result_tips);
                String string2 = getResources().getString(R.string.miconnect_reset_device);
                SpannableString spannableString = new SpannableString(string + string2);
                spannableString.setSpan(new ForegroundColorSpan(-16737793), string.length(), spannableString.length(), 17);
                spannableString.setSpan(new ClickableSpan() {
                    /* class com.xiaomi.smarthome.nfctag.ui.NFCDeviceDialogActivity.AnonymousClass4 */

                    public final void updateDrawState(TextPaint textPaint) {
                        textPaint.setUnderlineText(false);
                    }

                    public final void onClick(View view) {
                        hxk hxk = hxi.O00000o;
                        String str = NFCDeviceDialogActivity.this.mModel;
                        hxk.f952O000000o.O000000o("NFC_open_reset", "model", str);
                        fbt fbt = new fbt(NFCDeviceDialogActivity.this, "ResetDevicePage");
                        fbt.O000000o("model", NFCDeviceDialogActivity.this.mModel);
                        fbs.O000000o(fbt);
                    }
                }, string.length(), spannableString.length(), 17);
                this.O00000Oo.setMovementMethod(LinkMovementMethod.getInstance());
                this.O00000Oo.setText(spannableString);
                return;
            }
            findViewById(R.id.btn_cancel).setOnClickListener(this);
            findViewById(R.id.btn_confirm).setOnClickListener(this);
            hxp hxp2 = hxi.O00000o0;
            String str2 = this.mModel;
            hxp2.f957O000000o.O000000o("NFC_new_device", "model", str2);
        } else {
            finish();
        }
    }

    public void onPause() {
        super.onPause();
        sResumed = false;
        gsy.O00000o0(LogType.KUAILIAN, TAG, "onPause");
    }

    public void onResume() {
        super.onResume();
        sResumed = true;
        gsy.O00000o0(LogType.KUAILIAN, TAG, "onResume");
    }

    public void setImage(String str, String str2) {
        LogType logType = LogType.KUAILIAN;
        String str3 = TAG;
        gsy.O00000Oo(logType, str3, "setImage iconUrl:" + str + " videoUrl:" + str2);
        this.mVideoIcon.setZOrderOnTop(true);
        AudioManager audioManager = (AudioManager) getSystemService("audio");
        if (!TextUtils.isEmpty(str2) && audioManager != null && !audioManager.isMusicActive()) {
            this.mImageIcon.setVisibility(8);
            this.mVideoIcon.setVisibility(0);
            this.mPlayVideo = true;
            O000000o(Uri.parse(str));
            this.mVideoIcon.setVideoURI(Uri.parse(str2));
            this.mVideoIcon.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                /* class com.xiaomi.smarthome.nfctag.ui.NFCDeviceDialogActivity.AnonymousClass5 */

                public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    return true;
                }
            });
            this.mVideoIcon.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                /* class com.xiaomi.smarthome.nfctag.ui.NFCDeviceDialogActivity.AnonymousClass6 */

                public final void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                        /* class com.xiaomi.smarthome.nfctag.ui.NFCDeviceDialogActivity.AnonymousClass6.AnonymousClass1 */

                        public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                            if (i != 3) {
                                return true;
                            }
                            NFCDeviceDialogActivity.this.mImageIcon.setVisibility(8);
                            return true;
                        }
                    });
                }
            });
            this.mVideoIcon.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                /* class com.xiaomi.smarthome.nfctag.ui.NFCDeviceDialogActivity.AnonymousClass7 */

                public final void onCompletion(final MediaPlayer mediaPlayer) {
                    NFCDeviceDialogActivity.this.mVideoIcon.postDelayed(new Runnable() {
                        /* class com.xiaomi.smarthome.nfctag.ui.NFCDeviceDialogActivity.AnonymousClass7.AnonymousClass1 */

                        public final void run() {
                            try {
                                if (!NFCDeviceDialogActivity.this.isFinishing() && !NFCDeviceDialogActivity.this.isDestroyed()) {
                                    mediaPlayer.start();
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }, 2000);
                }
            });
        } else if (!TextUtils.isEmpty(str)) {
            this.mVideoIcon.setVisibility(8);
            O000000o(Uri.parse(str));
        } else {
            this.mVideoIcon.setVisibility(8);
            this.mImageIcon.setImageURI(gqd.O000000o((int) R.drawable.defaule_icon_default_nor));
        }
    }

    private void O000000o(Uri uri) {
        ImagePipelineFactory.getInstance().getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(uri).build(), null).subscribe(new BaseBitmapDataSubscriber() {
            /* class com.xiaomi.smarthome.nfctag.ui.NFCDeviceDialogActivity.AnonymousClass8 */

            public final void onNewResultImpl(Bitmap bitmap) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    final Bitmap createBitmap = Bitmap.createBitmap(bitmap);
                    NFCDeviceDialogActivity.this.mIconContainer.post(new Runnable() {
                        /* class com.xiaomi.smarthome.nfctag.ui.NFCDeviceDialogActivity.AnonymousClass8.AnonymousClass1 */

                        public final void run() {
                            NFCDeviceDialogActivity.this.mImageIcon.setImageBitmap(createBitmap);
                            NFCDeviceDialogActivity nFCDeviceDialogActivity = NFCDeviceDialogActivity.this;
                            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f);
                            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(nFCDeviceDialogActivity.mIconContainer, "alpha", 0.0f, 1.0f);
                            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                /* class com.xiaomi.smarthome.nfctag.ui.NFCDeviceDialogActivity.AnonymousClass9 */

                                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                }
                            });
                            ofFloat.setDuration(300L);
                            ofFloat2.setDuration(300L);
                            ofFloat2.addListener(new AnimatorListenerAdapter() {
                                /* class com.xiaomi.smarthome.nfctag.ui.NFCDeviceDialogActivity.AnonymousClass10 */

                                public final void onAnimationEnd(Animator animator) {
                                    if (NFCDeviceDialogActivity.this.mPlayVideo) {
                                        NFCDeviceDialogActivity.this.mVideoIcon.setVisibility(0);
                                        NFCDeviceDialogActivity.this.mVideoIcon.start();
                                    }
                                }
                            });
                            ofFloat.addListener(new AnimatorListenerAdapter(ofFloat2) {
                                /* class com.xiaomi.smarthome.nfctag.ui.NFCDeviceDialogActivity.AnonymousClass2 */

                                /* renamed from: O000000o  reason: collision with root package name */
                                final /* synthetic */ ObjectAnimator f10406O000000o;

                                {
                                    this.f10406O000000o = r2;
                                }

                                public final void onAnimationEnd(Animator animator) {
                                    this.f10406O000000o.start();
                                }
                            });
                            ofFloat.start();
                            gsy.O000000o(6, NFCDeviceDialogActivity.TAG, "start animation");
                        }
                    });
                }
            }

            public final void onCancellation(DataSource<CloseableReference<CloseableImage>> dataSource) {
                super.onCancellation(dataSource);
                gsy.O000000o(6, NFCDeviceDialogActivity.TAG, "cancel download");
            }

            public final void onFailureImpl(DataSource dataSource) {
                gsy.O000000o(6, NFCDeviceDialogActivity.TAG, "download failed");
            }
        }, CallerThreadExecutor.getInstance());
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fod.O000000o(android.content.Context, com.xiaomi.smarthome.device.BleDevice, android.content.Intent, java.util.ArrayList<java.lang.String>):void
     arg types: [com.xiaomi.smarthome.nfctag.ui.NFCDeviceDialogActivity, com.xiaomi.smarthome.device.BleDevice, ?[OBJECT, ARRAY], ?[OBJECT, ARRAY]]
     candidates:
      _m_j.fod.O000000o(android.app.Activity, com.xiaomi.smarthome.device.BleDevice, android.content.Intent, int):void
      _m_j.fod.O000000o(android.app.Activity, com.xiaomi.smarthome.device.BleDevice, android.content.Intent, java.util.ArrayList<java.lang.String>):void
      _m_j.fod.O000000o(android.content.Context, com.xiaomi.smarthome.device.BleDevice, android.content.Intent, java.util.ArrayList<java.lang.String>):void */
    public void onClick(View view) {
        int i;
        int id = view.getId();
        boolean z = true;
        if (id == R.id.btn_cancel) {
            hxk hxk = hxi.O00000o;
            String str = this.mModel;
            hxk.f952O000000o.O000000o("NFC_new_cancel", "model", str);
            if (this.mVideoIcon.getVisibility() == 0) {
                this.mVideoIcon.pause();
            }
            finish();
            overridePendingTransition(0, 0);
        } else if (id == R.id.btn_confirm) {
            hxk hxk2 = hxi.O00000o;
            String str2 = this.mModel;
            hxk2.f952O000000o.O000000o("NFC_new_begin", "model", str2);
            PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(this.mModel);
            BleDevice O000000o2 = BleDevice.O000000o(this.O0000O0o);
            if (O00000oO2.O00000o() == 2) {
                if (CoreApi.O000000o().O00000o(O000000o2.model)) {
                    fod.O000000o((Context) this, O000000o2, (Intent) null, (ArrayList<String>) null);
                } else {
                    Intent action = ext.O000000o(O000000o2).getAction(O000000o2, getContext().getApplicationContext(), null, false, null);
                    if (action != null) {
                        startActivity(action);
                    }
                }
                finish();
            } else if (O00000oO2.O00000o() == 3) {
                gsy.O000000o(4, RescanWifiActivity.TAG, "Config Comb device BEGIN.");
                if (O000000o2.O00000Oo() == null || O000000o2.O00000Oo().f6871O000000o == null) {
                    i = 0;
                } else {
                    i = O000000o2.O00000Oo().f6871O000000o.O0000OOo;
                    if (!fea.O000000o(O000000o2.O00000Oo().f6871O000000o.O0000Oo0)) {
                        z = false;
                    }
                }
                if ((i == 0 || i == 2) && z) {
                    SmartConfigRouterFactory.getStatBindManager().endBindStep(O000000o2.model, BindStep.STEP_SCAN_DEVICE);
                    fbt fbt = new fbt(this, "SmartConfigMainActivity");
                    fbt.O000000o("strategy_id", 13);
                    fbt.O000000o("model", O000000o2.model);
                    fbt.O000000o("combo_ble_mac", O000000o2.mac);
                    if (O000000o2.O00000Oo() != null) {
                        fbt.O000000o("combo_ble_key", O000000o2.O00000Oo().O00000oo);
                    }
                    fbs.O000000o(fbt);
                } else {
                    gsy.O000000o(6, TAG, "don't support authMode: ".concat(String.valueOf(i)));
                }
                finish();
            }
        } else if (id == R.id.btn_know) {
            hxk hxk3 = hxi.O00000o;
            String str3 = this.mModel;
            hxk3.f952O000000o.O000000o("NFC_open_got", "model", str3);
            finish();
        }
    }
}
