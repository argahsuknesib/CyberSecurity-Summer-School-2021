package com.hannto.print.pickimage.activity;

import O000000o.O000000o.O00000Oo.d;
import _m_j.O00O00Oo;
import _m_j.O00O00o;
import _m_j.O00O0o;
import _m_j.O00O0o0;
import _m_j.awb;
import _m_j.ayy;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.hannto.print.bean.PhotoBean;
import com.hannto.print.entity.PickPhotoEntity;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

public class PickPhotoPreviewActivity extends AppCompatActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public ViewPager f4358a;
    public O00O00Oo b;
    public Button c;
    public ArrayList<PhotoBean> d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public boolean j;
    public TextView k;
    public FrameLayout l;
    public PickPhotoEntity m;

    public final void a(int i2) {
        this.e = i2;
        PhotoBean photoBean = this.d.get(i2);
        ArrayList<PhotoBean> arrayList = d.O000000o().O00000o0;
        if (arrayList == null || !arrayList.contains(photoBean)) {
            this.c.setBackgroundResource(R.mipmap.ht_photo_unselected_white);
            this.c.setText("");
        } else {
            this.c.setTextColor(-1);
            this.c.setBackgroundResource(R.mipmap.ht_photo_selected);
        }
        TextView textView = this.k;
        String str = photoBean.imagePath;
        textView.setText(str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".")));
    }

    public void onBackPressed() {
        setResult(1002);
        finish();
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
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.title_bar_return) {
            onBackPressed();
        } else if (id == R.id.checkbox_preview_pick_photo) {
            PhotoBean photoBean = this.d.get(this.e);
            ArrayList<PhotoBean> arrayList = d.O000000o().O00000o0;
            if (arrayList.contains(photoBean)) {
                arrayList.remove(photoBean);
            } else {
                int i2 = d.O000000o().O0000Oo;
                if (arrayList.size() >= i2) {
                    Toast.makeText(this, "选择的照片数量不能超过" + i2 + "张", 0).show();
                    return;
                } else if (ayy.O000000o(photoBean.imagePath, this.h, this.i)) {
                    ayy.O000000o(this, this.h, this.i, new O00O0o(this, arrayList, photoBean));
                    return;
                } else {
                    arrayList.add(photoBean);
                }
            }
            a(this.e);
        } else if (id != R.id.title_bar_next) {
        } else {
            if (d.O000000o().O00000o0.size() <= 0) {
                Toast.makeText(this, getString(R.string.ht_toast_job_lower_limit), 0).show();
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("intent_finish", true);
            setResult(1002, intent);
            finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.ht_activity_pick_photo_preview);
        this.m = (PickPhotoEntity) getIntent().getParcelableExtra("intent_pick_photo_config");
        this.j = this.m.O00000oO;
        this.h = this.m.O00000Oo;
        this.i = this.m.O00000o0;
        Intent intent = getIntent();
        this.g = intent.getIntExtra("intent_selected_album_num", 0);
        this.f = intent.getIntExtra("intent_selected_position_in_all", 0);
        ArrayList<PhotoBean> arrayList = d.O000000o().O00000oO.get(this.g).O00000o;
        PhotoBean photoBean = arrayList.get(this.f);
        ArrayList<PhotoBean> arrayList2 = new ArrayList<>();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (!arrayList.get(i2).isHeader && !arrayList.get(i2).isCameraView) {
                arrayList2.add(arrayList.get(i2));
            }
        }
        int indexOf = arrayList2.indexOf(photoBean);
        if (indexOf == -1) {
            indexOf = 0;
        }
        this.e = indexOf;
        this.d = arrayList2;
        boolean z = true;
        awb.O000000o(this).O00000Oo(findViewById(R.id.title_bar)).O000000o(true, 0.2f).O000000o();
        findViewById(R.id.title_bar_return).setOnClickListener(new O00O00o(this));
        this.k = (TextView) findViewById(R.id.title_bar_title);
        this.l = (FrameLayout) findViewById(R.id.title_bar_next);
        this.l.setVisibility(0);
        this.l.setOnClickListener(new O00O00o(this));
        View findViewById = findViewById(R.id.action_bar);
        if (d.O000000o().O0000Oo0 != d.a.Single) {
            z = false;
        }
        findViewById.setVisibility(z ? 8 : 0);
        this.f4358a = (ViewPager) findViewById(R.id.viewpager_preview_pickphoto);
        this.b = new O00O00Oo(this, this.d);
        this.f4358a.setAdapter(this.b);
        this.f4358a.setOffscreenPageLimit(5);
        this.f4358a.addOnPageChangeListener(new O00O0o0(this));
        this.c = (Button) findViewById(R.id.checkbox_preview_pick_photo);
        this.c.setOnClickListener(new O00O00o(this));
        this.f4358a.setCurrentItem(this.e, false);
        a(this.e);
    }

    public void onPause() {
        if (!this.j) {
            overridePendingTransition(0, 0);
        }
        super.onPause();
    }
}
