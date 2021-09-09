package com.hannto.print.pickimage.activity;

import O000000o.O000000o.O00000Oo.d;
import _m_j.O00O00o;
import _m_j.awb;
import _m_j.cpn;
import android.content.Intent;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.hannto.print.entity.PickPhotoEntity;
import com.hannto.print.widget.IdCardMaskView;
import com.otaliastudios.cameraview.CameraView;
import com.otaliastudios.cameraview.Facing;
import com.otaliastudios.cameraview.Flash;
import com.xiaomi.smarthome.R;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class CameraActivity extends AppCompatActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public CameraView f4348a;
    public ImageView b;
    public ImageView c;
    public Handler d;
    public RelativeLayout e;
    public RelativeLayout f;
    public View g;
    public FrameLayout h;
    public FrameLayout i;
    public TextView j;
    public int k;
    public int l;
    public List<String> m;
    public boolean n;
    public IdCardMaskView o;
    public PickPhotoEntity p;
    public int q;
    public cpn r = new O00000Oo();

    public class O000000o implements Runnable {
        public O000000o() {
        }

        public final void run() {
            CameraActivity.this.i.setVisibility(0);
            CameraActivity.this.j.setText(String.valueOf(Integer.parseInt(CameraActivity.this.j.getText().toString()) + 1));
            CameraActivity.d(CameraActivity.this);
        }
    }

    public class O00000Oo extends cpn {

        public class O000000o implements Runnable {

            /* renamed from: O000000o  reason: collision with root package name */
            public final /* synthetic */ byte[] f4351O000000o;

            public O000000o(byte[] bArr) {
                this.f4351O000000o = bArr;
            }

            /* JADX WARNING: Removed duplicated region for block: B:24:0x0080 A[SYNTHETIC, Splitter:B:24:0x0080] */
            /* JADX WARNING: Removed duplicated region for block: B:34:0x00bd A[SYNTHETIC, Splitter:B:34:0x00bd] */
            /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
            public final void run() {
                FileOutputStream fileOutputStream = null;
                File externalFilesDir = CameraActivity.this.getExternalFilesDir(null);
                File file = new File(externalFilesDir, System.currentTimeMillis() + "pic.jpg");
                file.getAbsolutePath();
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(this.f4351O000000o);
                        fileOutputStream2.close();
                        try {
                            fileOutputStream2.close();
                            CameraActivity.this.m.add(file.getAbsolutePath());
                            if (CameraActivity.this.k >= CameraActivity.this.l - 1) {
                                CameraActivity.this.b();
                            } else {
                                CameraActivity.this.c();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (IOException e2) {
                        IOException iOException = e2;
                        fileOutputStream = fileOutputStream2;
                        e = iOException;
                        try {
                            e.printStackTrace();
                            if (fileOutputStream == null) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                    CameraActivity.this.m.add(file.getAbsolutePath());
                                    if (CameraActivity.this.k >= CameraActivity.this.l - 1) {
                                        CameraActivity.this.b();
                                    } else {
                                        CameraActivity.this.c();
                                    }
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        fileOutputStream = fileOutputStream2;
                        th = th3;
                        if (fileOutputStream != null) {
                        }
                        throw th;
                    }
                } catch (IOException e4) {
                    e = e4;
                    e.printStackTrace();
                    if (fileOutputStream == null) {
                        try {
                            fileOutputStream.close();
                            CameraActivity.this.m.add(file.getAbsolutePath());
                            if (CameraActivity.this.k >= CameraActivity.this.l - 1) {
                                CameraActivity.this.b();
                            } else {
                                CameraActivity.this.c();
                            }
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                }
            }
        }

        public O00000Oo() {
        }

        public final void O000000o(byte[] bArr) {
            super.O000000o(bArr);
            CameraActivity.i(CameraActivity.this).post(new O000000o(bArr));
        }
    }

    public static /* synthetic */ int d(CameraActivity cameraActivity) {
        int i2 = cameraActivity.k;
        cameraActivity.k = i2 + 1;
        return i2;
    }

    public static /* synthetic */ Handler i(CameraActivity cameraActivity) {
        if (cameraActivity.d == null) {
            HandlerThread handlerThread = new HandlerThread("background");
            handlerThread.start();
            cameraActivity.d = new Handler(handlerThread.getLooper());
        }
        return cameraActivity.d;
    }

    public boolean a() {
        Resources resources = getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        boolean z = identifier > 0 ? resources.getBoolean(identifier) : false;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Method method = cls.getMethod("get", String.class);
            Object[] objArr = new Object[1];
            objArr[0] = "qemu.hw.mainkeys";
            String str = (String) method.invoke(cls, objArr);
            if ("1".equals(str)) {
                return false;
            }
            if ("0".equals(str)) {
                return true;
            }
            return z;
        } catch (Exception unused) {
            return z;
        }
    }

    public final void b() {
        List<String> list = this.m;
        Intent intent = new Intent();
        intent.putExtra("photo_paths", (String[]) list.toArray(new String[list.size()]));
        setResult(1003, intent);
        finish();
    }

    public final void c() {
        runOnUiThread(new O000000o());
    }

    public void onClick(View view) {
        int id = view.getId();
        boolean z = false;
        if (id == R.id.camera_id_background_color) {
            CameraView cameraView = this.f4348a;
            if (cameraView != null) {
                Facing facing = cameraView.getFacing();
                CameraView cameraView2 = this.f4348a;
                Facing facing2 = Facing.BACK;
                if (facing == facing2) {
                    facing2 = Facing.FRONT;
                }
                cameraView2.setFacing(facing2);
                Flash flash = this.f4348a.getFlash();
                RelativeLayout relativeLayout = this.f;
                if (facing != Facing.BACK) {
                    z = true;
                }
                relativeLayout.setClickable(z);
                if (facing == Facing.BACK && flash == Flash.ON) {
                    this.f.setBackgroundResource(R.drawable.ht_picture_header);
                    this.c.setImageDrawable(getResources().getDrawable(R.drawable.ht_selector_flashlight_close));
                } else if (facing == Facing.FRONT && flash == Flash.ON) {
                    this.c.setImageDrawable(getResources().getDrawable(R.mipmap.flashlight_blue));
                }
            }
        } else if (id == R.id.picture) {
            try {
                if (this.f4348a != null) {
                    int ringerMode = ((AudioManager) getSystemService("audio")).getRingerMode();
                    if ((ringerMode != 0 ? ringerMode != 1 ? ringerMode == 2 ? (char) 1 : 0 : 2 : 3) > 1) {
                        ((AudioManager) getSystemService("audio")).setMicrophoneMute(false);
                        this.f4348a.setPlaySounds(false);
                    } else {
                        this.f4348a.setPlaySounds(true);
                    }
                    this.f4348a.O0000Oo.O0000OOo();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (id == R.id.title_bar_return) {
            setResult(1003);
            finish();
        } else if (id == R.id.flashlight_id_background_color) {
            Facing facing3 = this.f4348a.getFacing();
            Flash flash2 = this.f4348a.getFlash();
            if (facing3 == Facing.BACK) {
                Flash flash3 = Flash.OFF;
                if (flash2 == flash3) {
                    this.f4348a.setFlash(Flash.ON);
                    this.c.setImageDrawable(getResources().getDrawable(R.mipmap.flashlight_blue));
                    return;
                }
                this.f4348a.setFlash(flash3);
                this.f.setBackgroundResource(R.drawable.ht_picture_header);
                this.c.setImageDrawable(getResources().getDrawable(R.drawable.ht_selector_flashlight_close));
            }
        } else if (id == R.id.title_bar_next) {
            b();
        }
    }

    public void onCreate(Bundle bundle) {
        TextView textView;
        String string;
        super.onCreate(bundle);
        setContentView((int) R.layout.ht_activity_camera);
        this.p = (PickPhotoEntity) getIntent().getParcelableExtra("intent_pick_photo_config");
        this.n = this.p.O00000oO;
        this.q = this.p.O0000O0o;
        this.l = d.O000000o().O0000Oo;
        this.m = new ArrayList();
        int i2 = 0;
        this.k = 0;
        d.O000000o().O00000o0.clear();
        awb.O000000o(this).O00000Oo(findViewById(R.id.title_bar)).O000000o(false, 0.2f).O000000o();
        this.g = getWindow().getDecorView();
        this.h = (FrameLayout) findViewById(R.id.title_bar_return);
        this.h.setOnClickListener(new O00O00o(this));
        this.i = (FrameLayout) findViewById(R.id.title_bar_next);
        this.i.setOnClickListener(new O00O00o(this));
        findViewById(R.id.title_bar);
        this.f = (RelativeLayout) findViewById(R.id.flashlight_id_background_color);
        this.f.setOnClickListener(new O00O00o(this));
        this.f4348a = (CameraView) findViewById(R.id.camera_view);
        this.c = (ImageView) findViewById(R.id.flashlight_id);
        CameraView cameraView = this.f4348a;
        if (cameraView != null) {
            cameraView.O000000o(this.r);
        }
        this.b = (ImageView) findViewById(R.id.picture);
        this.b.setOnClickListener(new O00O00o(this));
        this.e = (RelativeLayout) findViewById(R.id.camera_id_background_color);
        this.e.setOnClickListener(new O00O00o(this));
        getResources().getDisplayMetrics();
        this.j = (TextView) findViewById(R.id.text_hint);
        boolean z = d.O000000o().O0000Oo0 == d.a.Single;
        findViewById(R.id.title_bar_title);
        this.o = (IdCardMaskView) findViewById(R.id.imv_mask);
        if (this.q != 1) {
            this.o.setVisibility(8);
            TextView textView2 = this.j;
            if (z) {
                i2 = 4;
            }
            textView2.setVisibility(i2);
            textView = this.j;
            string = "1";
        } else {
            this.o.setVisibility(0);
            textView = this.j;
            string = getString(R.string.ht_id_help_line_txt);
        }
        textView.setText(string);
    }

    public void onPause() {
        if (!this.n) {
            overridePendingTransition(0, 0);
        }
        super.onPause();
        CameraView cameraView = this.f4348a;
        if (cameraView != null) {
            cameraView.stop();
        }
    }

    public void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= 19 && a()) {
            this.g.setSystemUiVisibility(5890);
        }
        CameraView cameraView = this.f4348a;
        if (cameraView == null) {
            return;
        }
        if (cameraView.O000000o()) {
            this.f4348a.stop();
            this.f4348a.start();
            return;
        }
        this.f4348a.start();
    }
}
