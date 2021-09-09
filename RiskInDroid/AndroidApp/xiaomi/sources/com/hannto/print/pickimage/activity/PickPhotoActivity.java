package com.hannto.print.pickimage.activity;

import O000000o.O000000o.O00000Oo.O0000OoO.a;
import O000000o.O000000o.O00000Oo.d;
import _m_j.O000o;
import _m_j.O00O00o;
import _m_j.O00O0OOo;
import _m_j.O00O0Oo;
import _m_j.O00O0Oo0;
import _m_j.O00O0o00;
import _m_j.O00Oo0;
import _m_j.O00Oo00o;
import _m_j.O00Oo0OO;
import _m_j.O00oo000;
import _m_j.awb;
import _m_j.ayy;
import _m_j.ayz;
import _m_j.dz;
import _m_j.oOOO00o0;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.hannto.print.bean.PhotoBean;
import com.hannto.print.entity.PickPhotoEntity;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeMap;

public class PickPhotoActivity extends AppCompatActivity implements d.O000000o, View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public ViewPager f4352a;
    public O00Oo0OO b;
    public O00Oo00o c;
    public ImageView d;
    public ImageView e;
    public RadioGroup f;
    public a g;
    public dz h;
    public boolean i = false;
    public ArrayList<String> j = new ArrayList<>();
    public int k;
    public boolean l;
    public boolean m;
    public String n;
    public PickPhotoEntity o;

    public class O000000o implements Runnable {

        /* renamed from: com.hannto.print.pickimage.activity.PickPhotoActivity$O000000o$O000000o  reason: collision with other inner class name */
        public class C0034O000000o implements ayy.O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            public final /* synthetic */ ArrayList f4354O000000o;

            public C0034O000000o(ArrayList arrayList) {
                this.f4354O000000o = arrayList;
            }

            public final void O000000o(int i, String str) {
                PickPhotoActivity.this.b(str);
            }

            public final void O000000o(String str) {
                this.f4354O000000o.add(str);
            }
        }

        public class O00000Oo implements Runnable {
            public O00000Oo() {
            }

            public final void run() {
                PickPhotoActivity.this.h.dismissAllowingStateLoss();
                PickPhotoActivity.this.finish();
            }
        }

        public O000000o() {
        }

        public final void run() {
            ArrayList arrayList = new ArrayList();
            Iterator it = PickPhotoActivity.this.j.iterator();
            while (it.hasNext()) {
                PickPhotoActivity pickPhotoActivity = PickPhotoActivity.this;
                ayy.O000000o(ayz.O000000o(pickPhotoActivity, pickPhotoActivity.n, ayz.O00000o0(pickPhotoActivity, (String) it.next())).getPath(), PickPhotoActivity.this.n, Long.toString(System.currentTimeMillis()), PickPhotoActivity.this.o.O0000OOo, PickPhotoActivity.this.o.O0000Oo0, PickPhotoActivity.this.o.O0000Oo, new C0034O000000o(arrayList));
            }
            Intent intent = new Intent();
            intent.putExtra("intent_pick_image_path", arrayList);
            PickPhotoActivity.this.setResult(-1, intent);
            PickPhotoActivity.this.runOnUiThread(new O00000Oo());
        }
    }

    public class O00000Oo implements DialogInterface.OnClickListener {
        public O00000Oo() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            PickPhotoActivity.f(PickPhotoActivity.this);
        }
    }

    public class O00000o0 implements DialogInterface.OnClickListener {
        public O00000o0() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            oOOO00o0.O000000o(PickPhotoActivity.this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 10001);
        }
    }

    public static /* synthetic */ void f(PickPhotoActivity pickPhotoActivity) {
        pickPhotoActivity.i = true;
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", pickPhotoActivity.getPackageName(), null));
        pickPhotoActivity.startActivity(intent);
    }

    public void a(String str) {
        this.g.dismiss();
        b(str);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.core.content.ContextCompat.O000000o(android.content.Context, java.lang.String):int
     arg types: [com.hannto.print.pickimage.activity.PickPhotoActivity, java.lang.String]
     candidates:
      _m_j.oOOO00o0.O000000o(android.app.Activity, _m_j.d):void
      _m_j.oOOO00o0.O000000o(android.app.Activity, java.lang.String):boolean
      androidx.core.content.ContextCompat.O000000o(android.content.Context, int):android.graphics.drawable.Drawable
      androidx.core.content.ContextCompat.O000000o(android.content.Context, java.lang.Class):T
      androidx.core.content.ContextCompat.O000000o(android.content.Context, java.lang.String):int */
    public final void b() {
        if (oOOO00o0.O000000o((Context) this, "android.permission.READ_EXTERNAL_STORAGE") != 0) {
            oOOO00o0.O000000o(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 10001);
        } else {
            c();
        }
    }

    public final void b(String str) {
        Intent intent = new Intent();
        intent.putExtra("intent_pick_image_error", str);
        setResult(1005, intent);
        finish();
    }

    public final void c() {
        this.g = new a(this);
        this.g.O00000Oo = getString(R.string.ht_toast_process);
        this.g.show();
        d O000000o2 = d.O000000o();
        O000000o2.O00000Oo.clear();
        O000000o2.O00000o0.clear();
        O000000o2.O00000o.clear();
        O000000o2.O00000oO.clear();
        O000000o2.O00000oo = false;
        O000000o2.O0000OOo = null;
        O000000o2.O0000Oo = 1;
        O000000o2.O0000Oo0 = d.a.Single;
        O000000o2.O0000OOo = new Thread(new O00oo000(O000000o2, this));
        int i2 = this.k;
        if (i2 > 1) {
            O000000o2.O0000Oo0 = d.a.Multiple;
            O000000o2.O0000Oo = i2;
        }
        O000000o2.O00000oo = this.l;
        O000000o2.O0000OoO = this;
        Thread thread = O000000o2.O0000OOo;
        if (thread != null) {
            thread.start();
        }
    }

    public final void d() {
        ArrayList<PhotoBean> arrayList = d.O000000o().O00000o0;
        if (arrayList.size() <= 0) {
            Toast.makeText(this, getString(R.string.ht_toast_job_lower_limit), 0).show();
            return;
        }
        Iterator<PhotoBean> it = arrayList.iterator();
        while (it.hasNext()) {
            this.j.add(it.next().imagePath);
        }
        e();
    }

    public final void e() {
        this.h = new O00O0Oo.O000000o(this).O000000o(new O00O0o00()).O00000Oo().O000000o().O00000o0();
        new Thread(new O000000o()).start();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
        if (r6.getBooleanExtra("intent_finish", false) != false) goto L_0x002e;
     */
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 2001 && i3 == 1002) {
            this.b.O0000Oo.notifyDataSetChanged();
            if (intent == null || !intent.getBooleanExtra("intent_finish", false)) {
                return;
            }
        } else {
            if (i3 == 1001 && i2 == 2000) {
                if (intent != null) {
                }
            } else if (!(i2 == 3001 && i3 == 1003)) {
                return;
            }
            a(intent);
            return;
        }
        d();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.iv_return) {
            finish();
        } else if (id == R.id.iv_next) {
            d();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.ht_activity_pick_photo);
        this.o = (PickPhotoEntity) getIntent().getParcelableExtra("intent_pick_photo_config");
        this.k = this.o.f4346O000000o;
        this.l = this.o.O00000o;
        this.m = this.o.O00000oO;
        this.n = this.o.O000000o();
        this.f4352a = (ViewPager) findViewById(R.id.viewpager_layout);
        this.d = (ImageView) findViewById(R.id.iv_return);
        this.e = (ImageView) findViewById(R.id.iv_next);
        this.f = (RadioGroup) findViewById(R.id.pick_radio_group);
        awb.O000000o(this).O00000Oo(findViewById(R.id.title_layout)).O000000o(true, 0.2f).O000000o();
        this.b = new O00Oo0OO();
        this.c = new O00Oo00o();
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.b);
        arrayList.add(this.c);
        this.f4352a.setAdapter(new O000o(getSupportFragmentManager(), arrayList));
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(new O00O00o(this, 2000));
        this.f.setOnCheckedChangeListener(new O00O0OOo(this));
        this.f4352a.addOnPageChangeListener(new O00O0Oo0(this));
        b();
    }

    public void onPause() {
        if (!this.m) {
            overridePendingTransition(0, 0);
        }
        super.onPause();
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 != 10001) {
            return;
        }
        if (iArr.length > 0 && iArr[0] == 0) {
            c();
        } else if (!shouldShowRequestPermissionRationale(strArr[0])) {
            new AlertDialog.Builder(this).setTitle("帮助").setMessage("当前应用缺少【读取手机存储】权限\n\n请前往手机设置授权").setNegativeButton("前往设置", new O00000Oo()).show();
        } else {
            new AlertDialog.Builder(this).setTitle("帮助").setMessage("当前应用缺少【读取手机存储】权限\n\n请点击允许授权").setNegativeButton("重新授权", new O00000o0()).show();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.i) {
            this.i = false;
            b();
        }
    }

    public final void a(Intent intent) {
        if (intent != null) {
            String[] stringArrayExtra = intent.getStringArrayExtra("photo_paths");
            if (stringArrayExtra == null) {
                this.b.O0000Oo.notifyDataSetChanged();
                return;
            }
            this.j.addAll(Arrays.asList(stringArrayExtra));
            e();
        }
    }

    public void a() {
        this.g.dismiss();
        O00Oo0OO o00Oo0OO = this.b;
        o00Oo0OO.O00000oO = d.O000000o();
        o00Oo0OO.O00000oo = o00Oo0OO.O00000oO.O00000oO;
        o00Oo0OO.O0000O0o = new O00Oo0();
        new TreeMap(o00Oo0OO.O0000O0o);
        o00Oo0OO.O0000Oo0 = d.O000000o().O00000o0;
        o00Oo0OO.O0000o0o.sendEmptyMessage(2);
        new Handler(Looper.getMainLooper()).post(new O00Oo00o.O000000o());
    }
}
