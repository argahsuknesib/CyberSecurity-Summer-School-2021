package com.hannto.print.pickimage.activity;

import O000000o.O000000o.O00000Oo.d;
import _m_j.O00OO0O;
import _m_j.O00OOOo;
import _m_j.awb;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.hannto.print.entity.PickPhotoEntity;
import com.xiaomi.smarthome.R;
import java.util.TreeMap;

public class AlbumDetailActivity extends AppCompatActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public int f4347a;
    public String b;
    public O00OOOo c;
    public boolean d;
    public PickPhotoEntity e;
    public FrameLayout f;

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == 1002 && i == 2001) {
            if (intent == null || !intent.getBooleanExtra("intent_finish", false)) {
                this.c.O0000Oo0.notifyDataSetChanged();
                return;
            }
        } else if (i2 != 1003 || i != 3001 || intent == null) {
            return;
        } else {
            if (intent.getStringArrayExtra("photo_paths") == null) {
                this.c.O0000Oo0.notifyDataSetChanged();
                return;
            }
        }
        setResult(1001, intent);
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
            setResult(1001);
            finish();
        } else if (id != R.id.title_bar_next) {
        } else {
            if (d.O000000o().O00000o0.size() <= 0) {
                Toast.makeText(this, getString(R.string.ht_toast_job_lower_limit), 0).show();
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("intent_finish", true);
            setResult(1001, intent);
            finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.ht_activity_album_detail);
        this.e = (PickPhotoEntity) getIntent().getParcelableExtra("intent_pick_photo_config");
        this.d = this.e.O00000oO;
        this.f4347a = getIntent().getIntExtra("item_index", 0);
        this.b = getIntent().getStringExtra("folder_name");
        ((TextView) findViewById(R.id.title_bar_title)).setText(this.b);
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        this.f = (FrameLayout) findViewById(R.id.title_bar_next);
        this.f.setVisibility(0);
        this.f.setOnClickListener(this);
        this.c = new O00OOOo();
        getSupportFragmentManager().O000000o().O000000o((int) R.id.framelayout_layout, this.c).O00000Oo();
        O00OOOo o00OOOo = this.c;
        o00OOOo.O0000O0o = this.f4347a;
        o00OOOo.O00000o = d.O000000o();
        o00OOOo.O00000oO = o00OOOo.O00000o.O00000oO;
        o00OOOo.O00000oo = new O00OO0O();
        new TreeMap(o00OOOo.O00000oo);
        o00OOOo.O0000OOo = d.O000000o().O00000o0;
        o00OOOo.O0000o0.sendEmptyMessage(2);
        awb.O000000o(this).O00000Oo(findViewById(R.id.title_bar)).O000000o(true, 0.2f).O000000o();
    }

    public void onPause() {
        if (!this.d) {
            overridePendingTransition(0, 0);
        }
        super.onPause();
    }
}
