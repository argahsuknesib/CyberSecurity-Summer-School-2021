package com.hannto.print.scan.activity;

import O000000o.O000000o.O00000Oo.O0000OoO.a;
import O000000o.O000000o.O00000Oo.e;
import _m_j.O00O00o;
import _m_j.O00O0Oo;
import _m_j.O00Ooo00;
import _m_j.awb;
import _m_j.ayz;
import _m_j.cpn;
import _m_j.cpu;
import _m_j.cpw;
import android.content.Intent;
import android.graphics.Path;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.hannto.circledialog.params.TextParams;
import com.hannto.opencv.SmartCropper;
import com.hannto.print.entity.PickPhotoEntity;
import com.hannto.print.pickimage.activity.PickPhotoActivity;
import com.hannto.print.widget.ScanCameraView;
import com.otaliastudios.cameraview.Flash;
import com.xiaomi.smarthome.R;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class CameraScanActivity extends AppCompatActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f4359a;
    public ScanCameraView b;
    public Point[] c;
    public int d;
    public double e;
    public a f;
    public ImageView g;
    public FrameLayout h;
    public FrameLayout i;
    public e j;
    public boolean k = false;
    public int l;
    public boolean m;
    public String n;
    public boolean o;
    public cpn p = new O000000o();
    public cpw q = new O00000Oo();

    public class O000000o extends cpn {
        public O000000o() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:29:0x0066 A[SYNTHETIC, Splitter:B:29:0x0066] */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x007a A[SYNTHETIC, Splitter:B:36:0x007a] */
        public final void O000000o(byte[] bArr) {
            super.O000000o(bArr);
            String b = CameraScanActivity.this.n;
            File file = new File(b, System.currentTimeMillis() + ".jpg");
            try {
                file.getCanonicalPath();
            } catch (IOException e) {
                e.printStackTrace();
            }
            File parentFile = file.getParentFile();
            if (parentFile == null || parentFile.exists() || parentFile.mkdirs()) {
                ayz.O000000o(parentFile);
                FileOutputStream fileOutputStream = null;
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(bArr);
                        fileOutputStream2.close();
                    } catch (IOException e2) {
                        e = e2;
                        fileOutputStream = fileOutputStream2;
                        try {
                            e.printStackTrace();
                            if (fileOutputStream != null) {
                            }
                            CameraScanActivity.this.a(file.getAbsolutePath());
                            return;
                        } catch (Throwable th) {
                            th = th;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            CameraScanActivity.this.a(file.getAbsolutePath());
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                        }
                        CameraScanActivity.this.a(file.getAbsolutePath());
                        throw th;
                    }
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                } catch (IOException e5) {
                    e = e5;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    CameraScanActivity.this.a(file.getAbsolutePath());
                    return;
                }
                CameraScanActivity.this.a(file.getAbsolutePath());
                return;
            }
            CameraScanActivity.a(CameraScanActivity.this, "parentFile does not exist or parentFile.mkdirs failed");
        }
    }

    public class O00000o0 implements View.OnClickListener {
        public O00000o0() {
        }

        public final void onClick(View view) {
            CameraScanActivity.this.finish();
        }
    }

    public static /* synthetic */ void a(CameraScanActivity cameraScanActivity, String str) {
        cameraScanActivity.a();
        Intent intent = new Intent();
        intent.putExtra("error_message", str);
        intent.putExtra("result_code", -1);
        cameraScanActivity.setResult(-1, intent);
        cameraScanActivity.finish();
    }

    public final void a() {
        a aVar = this.f;
        if (aVar != null && aVar.isShowing()) {
            this.f.dismiss();
        }
    }

    public final void a(String str) {
        a();
        Intent intent = new Intent();
        intent.putExtra("photo_path", str);
        intent.putExtra("scan_points", this.c);
        intent.putExtra("result_code", 0);
        setResult(-1, intent);
        finish();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 1101) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("intent_pick_image_path");
            this.c = new Point[]{new Point(0, 0), new Point(0, 0), new Point(0, 0), new Point(0, 0)};
            a(stringArrayListExtra.get(0));
        }
    }

    public void onBackPressed() {
        if (this.o) {
            O00O0Oo.O000000o o000000o = new O00O0Oo.O000000o(this);
            String string = getString(R.string.ht_save_cancel_sub);
            o000000o.O00000o();
            o000000o.O00000o0.O00000o.O00000Oo = string;
            o000000o.O00000o();
            TextParams textParams = o000000o.O00000o0.O00000o;
            textParams.O00000o0 = 210;
            textParams.f4344O000000o = new int[]{108, 75, 108, 75};
            O00O0Oo.O000000o O000000o2 = o000000o.O00000Oo(getString(R.string.ht_button_discard), new O00000o0()).O000000o(getString(R.string.ht_button_continue), null);
            O000000o2.O00000o0.O00000Oo.O00000oo = new int[]{0, 0, 0, 0};
            O000000o2.O00000o0.O00000Oo.O0000o00 = 0;
            O000000o2.O00000o0();
            return;
        }
        super.onBackPressed();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.printer_take_picture) {
            ScanCameraView scanCameraView = this.b;
            if (scanCameraView != null && scanCameraView.O000000o()) {
                this.f = new a(this);
                this.f.O00000Oo = getString(R.string.ht_toast_process);
                this.f.setCanceledOnTouchOutside(false);
                this.f.show();
                this.b.O0000Oo.O0000OOo();
            }
        } else if (id == R.id.title_bar_return) {
            onBackPressed();
        } else if (id == R.id.fl_flash) {
            ScanCameraView scanCameraView2 = this.b;
            if (scanCameraView2 != null && scanCameraView2.O000000o()) {
                this.k = !this.k;
                this.g.setImageResource(this.k ? R.mipmap.ic_flash_torch_normal : R.mipmap.ic_flash_off_normal);
                this.b.setFlash(this.k ? Flash.TORCH : Flash.OFF);
            }
        } else if (id == R.id.fl_album) {
            Intent intent = new Intent(this, PickPhotoActivity.class);
            intent.putExtra("intent_pick_photo_config", new PickPhotoEntity(1, 0, 0, false, true, this.n, 0, 2400, 3600, 10240));
            startActivityForResult(intent, 1101);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.ht_activity_scan_camera);
        this.o = getIntent().getBooleanExtra("isGaveUp", false);
        this.m = getIntent().getBooleanExtra("isPushAnimated", true);
        this.n = getIntent().getStringExtra("sandBoxFolder");
        awb.O000000o(this).O00000Oo(findViewById(R.id.title_bar)).O000000o(false, 0.2f).O000000o();
        ((TextView) findViewById(R.id.title_bar_title)).setText("手机扫描");
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        this.l = getResources().getDisplayMetrics().widthPixels;
        this.f4359a = (RelativeLayout) findViewById(R.id.layout_camera);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f4359a.getLayoutParams();
        layoutParams.height = (this.l * 4) / 3;
        this.f4359a.setLayoutParams(layoutParams);
        this.b = (ScanCameraView) findViewById(R.id.camera);
        ScanCameraView scanCameraView = this.b;
        if (scanCameraView != null) {
            scanCameraView.O000000o(this.p);
            ScanCameraView scanCameraView2 = this.b;
            cpw cpw = this.q;
            if (cpw != null) {
                scanCameraView2.O0000o00.add(cpw);
            }
            this.b.setFlash(Flash.OFF);
        }
        ((ImageView) findViewById(R.id.printer_take_picture)).setOnClickListener(new O00O00o(this, 1000));
        this.g = (ImageView) findViewById(R.id.iv_flash);
        this.h = (FrameLayout) findViewById(R.id.fl_flash);
        this.h.setOnClickListener(this);
        this.i = (FrameLayout) findViewById(R.id.fl_album);
        this.i.setOnClickListener(this);
        if (e.f384O000000o == null) {
            e.f384O000000o = new e(this);
        }
        this.j = e.f384O000000o;
        this.j.O0000Ooo = new O00Ooo00(this);
        this.d = getResources().getDisplayMetrics().widthPixels;
    }

    public void onDestroy() {
        super.onDestroy();
        ScanCameraView scanCameraView = this.b;
        if (scanCameraView != null) {
            scanCameraView.destroy();
        }
        a();
    }

    public void onPause() {
        if (!this.m) {
            overridePendingTransition(0, 0);
        }
        super.onPause();
        ScanCameraView scanCameraView = this.b;
        if (scanCameraView != null) {
            scanCameraView.stop();
        }
        e eVar = this.j;
        if (eVar != null) {
            eVar.O00000Oo.unregisterListener(eVar, eVar.O00000o0);
        }
    }

    public void onResume() {
        super.onResume();
        ScanCameraView scanCameraView = this.b;
        if (scanCameraView != null && !scanCameraView.O000000o()) {
            this.b.start();
        }
        e eVar = this.j;
        if (eVar != null) {
            eVar.O000000o();
            eVar.O00000Oo.registerListener(eVar, eVar.O00000o0, 3);
        }
    }

    public class O00000Oo implements cpw {

        public class O000000o implements Runnable {

            /* renamed from: O000000o  reason: collision with root package name */
            public final /* synthetic */ Path f4362O000000o;

            public O000000o(Path path) {
                this.f4362O000000o = path;
            }

            public final void run() {
                CameraScanActivity.this.b.setPath(this.f4362O000000o);
            }
        }

        public O00000Oo() {
        }

        public final void O000000o(cpu cpu) {
            if (cpu.O00000oO != null) {
                int i = cpu.O00000oO.f14222O000000o;
                int i2 = cpu.O00000oO.O00000Oo;
                int min = Math.min(i, i2);
                Point[] unused = CameraScanActivity.this.c = SmartCropper.O000000o(min, Math.max(i, i2), cpu.O00000Oo);
                StringBuilder sb = new StringBuilder("points ==> {");
                sb.append(CameraScanActivity.this.c[0]);
                sb.append(" -- ");
                sb.append(CameraScanActivity.this.c[1]);
                sb.append(" -- ");
                sb.append(CameraScanActivity.this.c[2]);
                sb.append(" -- ");
                sb.append(CameraScanActivity.this.c[3]);
                sb.append("}");
                CameraScanActivity cameraScanActivity = CameraScanActivity.this;
                double e = (double) cameraScanActivity.d;
                double d = (double) min;
                Double.isNaN(e);
                Double.isNaN(d);
                double unused2 = cameraScanActivity.e = e / d;
                if (CameraScanActivity.this.e != 1.0d && SmartCropper.O000000o(CameraScanActivity.this.c)) {
                    for (Point point : CameraScanActivity.this.c) {
                        double d2 = (double) point.x;
                        double d3 = CameraScanActivity.this.e;
                        Double.isNaN(d2);
                        point.x = (int) (d3 * d2);
                        double d4 = (double) point.y;
                        double d5 = CameraScanActivity.this.e;
                        Double.isNaN(d4);
                        point.y = (int) (d5 * d4);
                    }
                }
                Path path = new Path();
                if (SmartCropper.O000000o(CameraScanActivity.this.c)) {
                    path.moveTo((float) CameraScanActivity.this.c[0].x, (float) CameraScanActivity.this.c[0].y);
                    path.lineTo((float) CameraScanActivity.this.c[1].x, (float) CameraScanActivity.this.c[1].y);
                    path.lineTo((float) CameraScanActivity.this.c[2].x, (float) CameraScanActivity.this.c[2].y);
                    path.lineTo((float) CameraScanActivity.this.c[3].x, (float) CameraScanActivity.this.c[3].y);
                    path.lineTo((float) CameraScanActivity.this.c[0].x, (float) CameraScanActivity.this.c[0].y);
                }
                CameraScanActivity.this.runOnUiThread(new O000000o(path));
            }
        }
    }
}
