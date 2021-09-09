package com.xiaomi.qrcode2;

import _m_j.eti;
import _m_j.etj;
import _m_j.etk;
import _m_j.etm;
import _m_j.etn;
import _m_j.eto;
import _m_j.etp;
import _m_j.ft;
import _m_j.ict;
import _m_j.icv;
import _m_j.icw;
import _m_j.idf;
import _m_j.idg;
import _m_j.ioi;
import _m_j.ioj;
import _m_j.ipw;
import android.app.Activity;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.xiaomi.qrcode2.CaptureActivityHandler;
import com.xiaomi.qrcode2.camera.CameraManager;
import com.xiaomi.smarthome.R;
import com.xiaomi.youpin.log.LogUtils;
import com.xiaomi.zxing.BarcodeFormat;
import com.xiaomiyoupin.toast.YPDToast;
import com.xiaomiyoupin.toast.dialog.MLAlertDialog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScanBarcodeActivity extends Activity {
    public static final String TAG = "ScanBarcodeActivity";

    /* renamed from: O000000o  reason: collision with root package name */
    public CameraManager f6601O000000o;
    ViewfinderView O00000Oo;
    private CaptureActivityHandler O00000o;
    private Context O00000o0;
    private idf O00000oO;
    private ViewGroup O00000oo;
    private SurfaceView O0000O0o;
    private idf O0000OOo;
    private etj O0000Oo;
    private etn O0000Oo0;
    private eti O0000OoO;
    private boolean O0000Ooo = false;
    private boolean O0000o0 = false;
    private SurfaceHolder.Callback O0000o00;
    public boolean hasSurface;
    public boolean mHasCameraPerms = false;
    public boolean mHasResume = false;

    public Handler getHandler() {
        return this.O00000o;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00f5  */
    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT < 24 || !isInMultiWindowMode()) {
            this.O00000o0 = this;
            getWindow().addFlags(NotificationCompat.FLAG_HIGH_PRIORITY);
            setContentView((int) R.layout.zxing_scan_barcode_activity);
            View findViewById = findViewById(R.id.zxing_title_bar);
            boolean z2 = false;
            if (findViewById != null) {
                int O000000o2 = etp.O000000o(findViewById.getContext());
                if (O000000o2 == -1) {
                    O000000o2 = findViewById.getResources().getDimensionPixelSize(R.dimen.title_bar_top_padding);
                }
                Window window = getWindow();
                if (!Build.BRAND.equalsIgnoreCase("htc") || !Build.MODEL.contains("M8w")) {
                    if (Build.VERSION.SDK_INT >= 19 && etp.O00000Oo(window, true)) {
                        window.setFlags(67108864, 67108864);
                        window.addFlags(Integer.MIN_VALUE);
                        window.getDecorView().setSystemUiVisibility(8192);
                    } else if (Build.VERSION.SDK_INT >= 19 && etp.O000000o(window, true)) {
                        window.setFlags(67108864, 67108864);
                    } else if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
                        window.addFlags(67108864);
                    } else if (Build.VERSION.SDK_INT >= 21) {
                        window.clearFlags(67108864);
                        if (Build.VERSION.SDK_INT >= 23) {
                            window.getDecorView().setSystemUiVisibility(9472);
                        } else {
                            window.getDecorView().setSystemUiVisibility(1280);
                        }
                        window.addFlags(Integer.MIN_VALUE);
                        if (Build.BRAND.equalsIgnoreCase("oppo") || Build.BRAND.equalsIgnoreCase("vivo")) {
                            window.setStatusBarColor(33554431);
                        } else {
                            window.setStatusBarColor(0);
                        }
                    }
                    z = true;
                    if (z && findViewById != null) {
                        if (findViewById.getLayoutParams().height >= 0) {
                            findViewById.getLayoutParams().height += O000000o2;
                        }
                        findViewById.setPadding(0, O000000o2, 0, 0);
                        findViewById.setLayoutParams(findViewById.getLayoutParams());
                    }
                }
                z = false;
                if (findViewById.getLayoutParams().height >= 0) {
                }
                findViewById.setPadding(0, O000000o2, 0, 0);
                findViewById.setLayoutParams(findViewById.getLayoutParams());
            }
            findViewById(R.id.zxing_back).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.qrcode2.ScanBarcodeActivity.AnonymousClass1 */

                public final void onClick(View view) {
                    ScanBarcodeActivity.this.onBackPressed();
                }
            });
            TextView textView = (TextView) findViewById(R.id.zxing_title);
            String stringExtra = getIntent().getStringExtra("title");
            if (TextUtils.isEmpty(stringExtra)) {
                textView.setText((int) R.string.scan_title);
            } else {
                textView.setText(stringExtra);
            }
            findViewById(R.id.scan_file).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.qrcode2.ScanBarcodeActivity.AnonymousClass2 */

                public final void onClick(View view) {
                    try {
                        ScanBarcodeActivity.this.startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 100);
                    } catch (ActivityNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            this.O00000Oo = (ViewfinderView) findViewById(R.id.viewfinder_view);
            this.O00000oo = (ViewGroup) findViewById(R.id.preview_view_group);
            this.hasSurface = false;
            this.O0000Oo0 = new etn(this);
            this.O0000Oo = new etj(this);
            this.O0000OoO = new eti(this);
            this.O0000o00 = new SurfaceHolder.Callback() {
                /* class com.xiaomi.qrcode2.ScanBarcodeActivity.AnonymousClass3 */

                public final void surfaceCreated(SurfaceHolder surfaceHolder) {
                    LogUtils.e(ScanBarcodeActivity.TAG, "surfaceCreated");
                    if (surfaceHolder == null) {
                        LogUtils.e(ScanBarcodeActivity.TAG, "*** WARNING *** surfaceCreated() gave us a null surface!");
                    }
                    if (!ScanBarcodeActivity.this.hasSurface) {
                        ScanBarcodeActivity scanBarcodeActivity = ScanBarcodeActivity.this;
                        scanBarcodeActivity.hasSurface = true;
                        scanBarcodeActivity.initCamera(surfaceHolder);
                    }
                }

                public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                    LogUtils.e(ScanBarcodeActivity.TAG, "surfaceChanged");
                }

                public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                    LogUtils.e(ScanBarcodeActivity.TAG, "surfaceDestroyed");
                    ScanBarcodeActivity.this.hasSurface = false;
                }
            };
            if (ContextCompat.O000000o(this, "android.permission.CAMERA") == 0) {
                z2 = true;
            }
            if (z2) {
                this.mHasCameraPerms = true;
                return;
            }
            TextView textView2 = new TextView(this);
            textView2.setPadding(30, 30, 30, 30);
            textView2.setText(getResources().getString(R.string.camera_permission_explain));
            new MLAlertDialog.Builder(this).setNegativeButton("取消", $$Lambda$ScanBarcodeActivity$hCEIa76cEF1PDvempyab_veGP8.INSTANCE).setPositiveButton("允许", new DialogInterface.OnClickListener() {
                /* class com.xiaomi.qrcode2.$$Lambda$ScanBarcodeActivity$AeiSHL2_ZnT6T3BdP_Hb46kKmQ */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ScanBarcodeActivity.this.O000000o(dialogInterface, i);
                }
            }).setView(textView2).create().show();
            return;
        }
        YPDToast.getInstance().toast(this, "该页面不支持分屏");
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        AnonymousClass4 r5 = new ict() {
            /* class com.xiaomi.qrcode2.ScanBarcodeActivity.AnonymousClass4 */

            public final void O000000o() {
                ScanBarcodeActivity scanBarcodeActivity = ScanBarcodeActivity.this;
                scanBarcodeActivity.mHasCameraPerms = true;
                if (scanBarcodeActivity.mHasResume) {
                    ScanBarcodeActivity.this.initCameraOnResume();
                }
            }

            public final void O000000o(boolean z) {
                ScanBarcodeActivity.this.mHasCameraPerms = false;
                if (!z) {
                    YPDToast.getInstance().toast(ScanBarcodeActivity.this.getBaseContext(), "未授予相机权限，扫一扫暂不可用");
                    ScanBarcodeActivity.this.O000000o();
                }
            }

            public final void O00000Oo() {
                ScanBarcodeActivity.this.mHasCameraPerms = false;
                YPDToast.getInstance().toast(ScanBarcodeActivity.this.getBaseContext(), "未授予相机权限，扫一扫暂不可用");
                ScanBarcodeActivity.this.O000000o();
            }
        };
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.CAMERA");
        icw icw = new icw(r5);
        icv icv = new icv(this, r5);
        ipw O000000o2 = ioj.O000000o(this).O000000o();
        String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        O000000o2.O000000o(strArr);
        ipw.f1544O000000o.O000000o(O000000o2.O00000Oo).O000000o(strArr).O000000o(icw).O000000o(new ioi<List<String>>(r5) {
            /* class _m_j.icu.AnonymousClass2 */

            /* renamed from: O000000o */
            final /* synthetic */ ict f1196O000000o;

            {
                this.f1196O000000o = r1;
            }

            public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
                ict ict = this.f1196O000000o;
                if (ict != null) {
                    ict.O000000o();
                }
            }
        }).O00000Oo(new ioi<List<String>>(this, icv, r5) {
            /* class _m_j.icu.AnonymousClass1 */

            /* renamed from: O000000o */
            final /* synthetic */ Activity f1195O000000o;
            final /* synthetic */ icv O00000Oo;
            final /* synthetic */ ict O00000o0;

            {
                this.f1195O000000o = r1;
                this.O00000Oo = r2;
                this.O00000o0 = r3;
            }

            public final /* synthetic */ void O000000o(Object obj) {
                List list = (List) obj;
                if (ioj.O000000o(this.f1195O000000o, list)) {
                    icv icv = this.O00000Oo;
                    Activity activity = icv.f1197O000000o.get();
                    if (activity != null && !activity.isFinishing()) {
                        List<String> O000000o2 = iol.O000000o(icv.O00000Oo, list);
                        new MLAlertDialog.Builder(activity).setCancelable(false).setTitle("需要允许授权").setMessage("请在设置中允许小米有品访问" + TextUtils.join(",", O000000o2)).setPositiveButton("去设置", new DialogInterface.OnClickListener(new ipx(ioj.O000000o(activity).O000000o().O00000Oo)) {
                            /* class _m_j.icv.AnonymousClass2 */

                            /* renamed from: O000000o */
                            final /* synthetic */ ioo f1199O000000o;

                            {
                                this.f1199O000000o = r2;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.f1199O000000o.O00000Oo();
                                if (icv.this.O00000o0 != null) {
                                    icv.this.O00000o0.O00000Oo();
                                }
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            /* class _m_j.icv.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                if (icv.this.O00000o0 != null) {
                                    icv.this.O00000o0.O00000Oo();
                                }
                            }
                        }).create().show();
                    }
                    ict ict = this.O00000o0;
                    if (ict != null) {
                        ict.O000000o(true);
                        return;
                    }
                    return;
                }
                ict ict2 = this.O00000o0;
                if (ict2 != null) {
                    ict2.O000000o(false);
                }
            }
        }).J_();
    }

    public void onMultiWindowModeChanged(boolean z, Configuration configuration) {
        super.onMultiWindowModeChanged(z, configuration);
        if (Build.VERSION.SDK_INT >= 24 && z) {
            YPDToast.getInstance().toast(this, "该页面不支持分屏");
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        String str = TAG;
        LogUtils.d(str, "onResume mHasCameraPerms " + this.mHasCameraPerms);
        super.onResume();
        this.mHasResume = true;
        if (this.mHasCameraPerms) {
            initCameraOnResume();
        }
    }

    public void initCameraOnResume() {
        if (!this.O0000o0) {
            this.O0000o0 = true;
            if (this.O0000O0o == null) {
                this.O0000O0o = new SurfaceView(this);
                this.O00000oo.addView(this.O0000O0o);
            }
            this.f6601O000000o = new CameraManager(getApplication());
            this.O00000Oo.setCameraManager(this.f6601O000000o);
            this.O00000Oo.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.qrcode2.ScanBarcodeActivity.AnonymousClass5 */

                public final void onClick(View view) {
                    etk.f15797O000000o = true;
                }
            });
            this.O00000o = null;
            this.O0000OOo = null;
            O00000o0();
            this.O0000Oo.O000000o();
            this.O0000OoO.O00000Oo = this.f6601O000000o;
            this.O0000Oo0.O00000o0();
            SurfaceHolder holder = this.O0000O0o.getHolder();
            if (this.hasSurface) {
                LogUtils.d(TAG, "hasSurface initCamera");
                initCamera(holder);
            } else {
                LogUtils.d(TAG, "no hasSurface addCallback");
                holder.addCallback(this.O0000o00);
            }
            this.O0000Ooo = true;
            this.O0000o0 = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        this.mHasResume = false;
        String str = TAG;
        LogUtils.d(str, "onPause mHasInitCamera " + this.O0000Ooo);
        if (this.O0000Ooo) {
            CaptureActivityHandler captureActivityHandler = this.O00000o;
            if (captureActivityHandler != null) {
                captureActivityHandler.O00000Oo = CaptureActivityHandler.State.DONE;
                captureActivityHandler.O00000o0.O00000o();
                Message.obtain(captureActivityHandler.f6600O000000o.O000000o(), 9).sendToTarget();
                try {
                    captureActivityHandler.f6600O000000o.join(500);
                } catch (InterruptedException unused) {
                }
                captureActivityHandler.removeMessages(7);
                captureActivityHandler.removeMessages(6);
                this.O00000o = null;
            }
            this.O0000Oo0.O00000Oo();
            eti eti = this.O0000OoO;
            if (eti.O00000o0 != null) {
                ((SensorManager) eti.f15795O000000o.getSystemService("sensor")).unregisterListener(eti);
                eti.O00000Oo = null;
                eti.O00000o0 = null;
            }
            this.O0000Oo.close();
            CameraManager cameraManager = this.f6601O000000o;
            if (cameraManager != null) {
                cameraManager.O00000Oo();
            }
            if (!this.hasSurface) {
                this.O0000O0o.getHolder().removeCallback(this.O0000o00);
            }
            this.O0000Ooo = false;
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        etn etn = this.O0000Oo0;
        if (etn != null) {
            etn.O00000o();
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            if (!(i == 27 || i == 80)) {
                if (i == 24) {
                    CameraManager cameraManager = this.f6601O000000o;
                    if (cameraManager != null) {
                        cameraManager.O000000o(true);
                    }
                } else if (i != 25) {
                    return super.onKeyDown(i, keyEvent);
                } else {
                    CameraManager cameraManager2 = this.f6601O000000o;
                    if (cameraManager2 != null) {
                        cameraManager2.O000000o(false);
                    }
                    return true;
                }
            }
            return true;
        }
        O000000o();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 100 && i2 == -1 && intent != null) {
            try {
                Uri data = intent.getData();
                if (data != null) {
                    String uri = data.toString();
                    if (!TextUtils.isEmpty(uri)) {
                        new AsyncTask<String, Integer, idf>() {
                            /* class com.xiaomi.qrcode2.ScanBarcodeActivity.AnonymousClass6 */

                            /* access modifiers changed from: protected */
                            /* JADX WARNING: Removed duplicated region for block: B:51:0x0149  */
                            /* JADX WARNING: Removed duplicated region for block: B:54:0x0154 A[RETURN] */
                            /* JADX WARNING: Removed duplicated region for block: B:55:0x0155  */
                            public final /* synthetic */ Object doInBackground(Object[] objArr) {
                                String str;
                                int i;
                                Bitmap decodeFile;
                                Uri uri;
                                String str2 = ((String[]) objArr)[0];
                                if (TextUtils.isEmpty(str2)) {
                                    return null;
                                }
                                Uri parse = Uri.parse(str2);
                                Context applicationContext = ScanBarcodeActivity.this.getApplicationContext();
                                if (Build.VERSION.SDK_INT >= 19) {
                                    if (!(Build.VERSION.SDK_INT >= 19) || !DocumentsContract.isDocumentUri(applicationContext, parse)) {
                                        if ("content".equalsIgnoreCase(parse.getScheme())) {
                                            if ("com.google.android.apps.photos.content".equals(parse.getAuthority())) {
                                                str = parse.getLastPathSegment();
                                            } else {
                                                str = eto.O000000o(applicationContext, parse, null, null);
                                            }
                                        } else if ("file".equalsIgnoreCase(parse.getScheme())) {
                                            str = parse.getPath();
                                        }
                                        BitmapFactory.Options options = new BitmapFactory.Options();
                                        options.inJustDecodeBounds = true;
                                        BitmapFactory.decodeFile(str, options);
                                        i = (int) (((float) options.outHeight) / 800.0f);
                                        if (i <= 0) {
                                            i = 1;
                                        }
                                        options.inJustDecodeBounds = false;
                                        options.inSampleSize = i;
                                        decodeFile = BitmapFactory.decodeFile(str, options);
                                        if (decodeFile == null) {
                                            return null;
                                        }
                                        int width = decodeFile.getWidth();
                                        int height = decodeFile.getHeight();
                                        int i2 = width * height;
                                        int[] iArr = new int[i2];
                                        decodeFile.getPixels(iArr, 0, width, 0, 0, width, height);
                                        decodeFile.recycle();
                                        byte[] bArr = new byte[(i2 + (((width % 2 == 0 ? width : width + 1) * (height % 2 == 0 ? height : height + 1)) / 2))];
                                        etp.O000000o(bArr, iArr, width, height);
                                        idf O000000o2 = etp.O000000o(bArr, width, height);
                                        if (O000000o2 != null) {
                                            return O000000o2;
                                        }
                                        Log.e("qrcode", "new scan no result");
                                        return etp.O000000o(iArr, width, height);
                                    } else if ("com.android.externalstorage.documents".equals(parse.getAuthority())) {
                                        String[] split = DocumentsContract.getDocumentId(parse).split(":");
                                        if ("primary".equalsIgnoreCase(split[0])) {
                                            str = Environment.getExternalStorageDirectory() + "/" + split[1];
                                            BitmapFactory.Options options2 = new BitmapFactory.Options();
                                            options2.inJustDecodeBounds = true;
                                            BitmapFactory.decodeFile(str, options2);
                                            i = (int) (((float) options2.outHeight) / 800.0f);
                                            if (i <= 0) {
                                            }
                                            options2.inJustDecodeBounds = false;
                                            options2.inSampleSize = i;
                                            decodeFile = BitmapFactory.decodeFile(str, options2);
                                            if (decodeFile == null) {
                                            }
                                        }
                                    } else {
                                        if ("com.android.providers.downloads.documents".equals(parse.getAuthority())) {
                                            str = eto.O000000o(applicationContext, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(parse)).longValue()), null, null);
                                        } else if ("com.android.providers.media.documents".equals(parse.getAuthority())) {
                                            String[] split2 = DocumentsContract.getDocumentId(parse).split(":");
                                            String str3 = split2[0];
                                            if ("image".equals(str3)) {
                                                uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                                            } else if ("video".equals(str3)) {
                                                uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                                            } else {
                                                uri = "audio".equals(str3) ? MediaStore.Audio.Media.EXTERNAL_CONTENT_URI : null;
                                            }
                                            str = eto.O000000o(applicationContext, uri, "_id=?", new String[]{split2[1]});
                                        }
                                        BitmapFactory.Options options22 = new BitmapFactory.Options();
                                        options22.inJustDecodeBounds = true;
                                        BitmapFactory.decodeFile(str, options22);
                                        i = (int) (((float) options22.outHeight) / 800.0f);
                                        if (i <= 0) {
                                        }
                                        options22.inJustDecodeBounds = false;
                                        options22.inSampleSize = i;
                                        decodeFile = BitmapFactory.decodeFile(str, options22);
                                        if (decodeFile == null) {
                                        }
                                    }
                                } else {
                                    String[] strArr = {"_data"};
                                    Cursor query = applicationContext.getContentResolver().query(parse, strArr, null, null, null);
                                    if (query != null) {
                                        query.moveToFirst();
                                        String string = query.getString(query.getColumnIndex(strArr[0]));
                                        query.close();
                                        str = string;
                                        BitmapFactory.Options options222 = new BitmapFactory.Options();
                                        options222.inJustDecodeBounds = true;
                                        BitmapFactory.decodeFile(str, options222);
                                        i = (int) (((float) options222.outHeight) / 800.0f);
                                        if (i <= 0) {
                                        }
                                        options222.inJustDecodeBounds = false;
                                        options222.inSampleSize = i;
                                        decodeFile = BitmapFactory.decodeFile(str, options222);
                                        if (decodeFile == null) {
                                        }
                                    }
                                }
                                str = null;
                                BitmapFactory.Options options2222 = new BitmapFactory.Options();
                                options2222.inJustDecodeBounds = true;
                                BitmapFactory.decodeFile(str, options2222);
                                i = (int) (((float) options2222.outHeight) / 800.0f);
                                if (i <= 0) {
                                }
                                options2222.inJustDecodeBounds = false;
                                options2222.inSampleSize = i;
                                decodeFile = BitmapFactory.decodeFile(str, options2222);
                                if (decodeFile == null) {
                                }
                            }

                            /* access modifiers changed from: protected */
                            public final /* synthetic */ void onPostExecute(Object obj) {
                                idf idf = (idf) obj;
                                if (idf != null) {
                                    ScanBarcodeActivity.this.O000000o(idf.f1208O000000o);
                                } else {
                                    YPDToast.getInstance().toast(ScanBarcodeActivity.this, "无法识别二维码");
                                }
                            }
                        }.execute(uri);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        O000000o();
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(String str) {
        Intent intent = new Intent();
        if (TextUtils.isEmpty(str)) {
            setResult(0);
        } else {
            intent.putExtra("scan_result", str);
            setResult(-1, intent);
        }
        intent.setAction("com.xiaomi.ScanBarcodeResultBroadCast");
        ft.O000000o(getApplicationContext()).O000000o(intent);
        finish();
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        Intent intent = new Intent();
        setResult(0);
        intent.setAction("com.xiaomi.ScanBarcodeResultBroadCast");
        ft.O000000o(getApplicationContext()).O000000o(intent);
        finish();
    }

    public void handleDecode(idf idf, Bitmap bitmap, float f) {
        this.O0000Oo0.O000000o();
        this.O0000OOo = idf;
        if (bitmap != null) {
            this.O0000Oo.O00000Oo();
            idg[] idgArr = idf.O00000o0;
            if (idgArr != null && idgArr.length > 0) {
                Canvas canvas = new Canvas(bitmap);
                Paint paint = new Paint();
                paint.setColor(getResources().getColor(R.color.result_points));
                if (idgArr.length == 2) {
                    paint.setStrokeWidth(4.0f);
                    etp.O000000o(canvas, paint, idgArr[0], idgArr[1], f);
                } else if (idgArr.length == 4 && (idf.O00000o == BarcodeFormat.UPC_A || idf.O00000o == BarcodeFormat.EAN_13)) {
                    etp.O000000o(canvas, paint, idgArr[0], idgArr[1], f);
                    etp.O000000o(canvas, paint, idgArr[2], idgArr[3], f);
                } else {
                    paint.setStrokeWidth(10.0f);
                    for (idg idg : idgArr) {
                        if (idg != null) {
                            canvas.drawPoint(idg.f1209O000000o * f, idg.O00000Oo * f, paint);
                        }
                    }
                }
            }
        }
        O000000o(idf.f1208O000000o);
    }

    public void initCamera(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            throw new IllegalStateException("No SurfaceHolder provided");
        } else if (this.f6601O000000o.O000000o()) {
            LogUtils.d(TAG, "initCamera() while already open -- late SurfaceView callback?");
        } else {
            try {
                this.f6601O000000o.O000000o(surfaceHolder);
                if (this.O00000o == null) {
                    Intent intent = getIntent();
                    ArrayList arrayList = new ArrayList();
                    if (intent != null) {
                        BarcodeFormat[] values = BarcodeFormat.values();
                        int[] intArrayExtra = intent.getIntArrayExtra("barcode_format");
                        if (intArrayExtra != null) {
                            for (int i = 0; i < intArrayExtra.length; i++) {
                                if (intArrayExtra[i] >= 0 && intArrayExtra[i] < values.length) {
                                    arrayList.add(values[intArrayExtra[i]]);
                                }
                            }
                        } else {
                            int intExtra = intent.getIntExtra("barcode_format", -1);
                            if (intExtra >= 0 && intExtra < values.length) {
                                arrayList.add(values[intExtra]);
                            }
                        }
                    }
                    if (arrayList.size() == 0) {
                        arrayList.add(BarcodeFormat.QR_CODE);
                    }
                    this.O00000o = new CaptureActivityHandler(this, arrayList, this.f6601O000000o);
                }
                if (this.O00000o == null) {
                    this.O00000oO = null;
                    return;
                }
                if (this.O00000oO != null) {
                    this.O00000o.sendMessage(Message.obtain(this.O00000o, 7, this.O00000oO));
                }
                this.O00000oO = null;
            } catch (IOException e) {
                e.printStackTrace();
                LogUtils.e(TAG, e);
                O00000Oo();
            } catch (RuntimeException e2) {
                e2.printStackTrace();
                LogUtils.e(TAG, "Unexpected error initializing camera", e2);
                O00000Oo();
            }
        }
    }

    private void O00000Oo() {
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
        final Application application = getApplication();
        builder.setMessage(getString(R.string.msg_camera_framework_bug_new, new Object[]{etp.O00000Oo(application)}));
        builder.setNegativeButton("去设置", new DialogInterface.OnClickListener() {
            /* class com.xiaomi.qrcode2.ScanBarcodeActivity.AnonymousClass7 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                ScanBarcodeActivity.this.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + application.getPackageName())));
                ScanBarcodeActivity.this.finish();
            }
        });
        builder.setPositiveButton("取消", new etm(this));
        builder.setOnCancelListener(new etm(this));
        builder.show();
    }

    public void restartPreviewAfterDelay(long j) {
        CaptureActivityHandler captureActivityHandler = this.O00000o;
        if (captureActivityHandler != null) {
            captureActivityHandler.sendEmptyMessageDelayed(10, j);
        }
        O00000o0();
    }

    private void O00000o0() {
        this.O00000Oo.setVisibility(0);
        this.O0000OOo = null;
    }

    public void drawViewfinder() {
        ViewfinderView viewfinderView = this.O00000Oo;
        Bitmap bitmap = viewfinderView.f6609O000000o;
        viewfinderView.f6609O000000o = null;
        if (bitmap != null) {
            bitmap.recycle();
        }
        viewfinderView.invalidate();
    }
}
