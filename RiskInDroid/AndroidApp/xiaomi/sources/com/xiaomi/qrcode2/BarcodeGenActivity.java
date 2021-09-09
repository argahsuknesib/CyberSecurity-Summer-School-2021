package com.xiaomi.qrcode2;

import _m_j.idm;
import _m_j.igw;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.ImageView;
import com.xiaomi.smarthome.R;
import com.xiaomi.zxing.BarcodeFormat;
import com.xiaomi.zxing.EncodeHintType;
import java.util.Hashtable;

public class BarcodeGenActivity extends Activity {

    /* renamed from: O000000o  reason: collision with root package name */
    Bitmap f6599O000000o;
    String O00000Oo;

    public void onBackPressed() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(NotificationCompat.FLAG_HIGH_PRIORITY);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.screenBrightness = 1.0f;
        getWindow().setAttributes(attributes);
        this.O00000Oo = getIntent().getStringExtra("barcode");
        if (TextUtils.isEmpty(this.O00000Oo)) {
            setResult(0);
            finish();
            return;
        }
        setContentView((int) R.layout.barcode_gen_activity);
        ImageView imageView = (ImageView) findViewById(R.id.barcode_image);
        this.f6599O000000o = O000000o(this.O00000Oo);
        Bitmap bitmap = this.f6599O000000o;
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            return;
        }
        setResult(0);
        finish();
    }

    private Bitmap O000000o(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int i = (int) (((float) displayMetrics.widthPixels) - (displayMetrics.density * 0.0f));
            Hashtable hashtable = new Hashtable();
            hashtable.put(EncodeHintType.CHARACTER_SET, "utf-8");
            new igw();
            idm O000000o2 = igw.O000000o(str, BarcodeFormat.QR_CODE, i, i, hashtable);
            int[] iArr = new int[(i * i)];
            for (int i2 = 0; i2 < i; i2++) {
                for (int i3 = 0; i3 < i; i3++) {
                    if (O000000o2.O000000o(i3, i2)) {
                        iArr[(i2 * i) + i3] = -16777216;
                    } else {
                        iArr[(i2 * i) + i3] = -1;
                    }
                }
            }
            this.f6599O000000o = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
            this.f6599O000000o.setPixels(iArr, 0, i, 0, 0, i, i);
            return this.f6599O000000o;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        Bitmap bitmap = this.f6599O000000o;
        if (bitmap != null) {
            bitmap.recycle();
            this.f6599O000000o = null;
        }
    }
}
