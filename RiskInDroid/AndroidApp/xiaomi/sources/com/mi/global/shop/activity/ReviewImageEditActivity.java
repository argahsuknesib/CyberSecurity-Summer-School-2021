package com.mi.global.shop.activity;

import _m_j.cbb;
import _m_j.cec;
import _m_j.cee;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.content.FileProvider;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.mi.global.shop.widget.CustomButtonView;
import com.xiaomi.smarthome.R;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class ReviewImageEditActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private Uri f4672O000000o;
    private String O00000Oo;
    @BindView(2131493026)
    CustomButtonView btnDone;
    @BindView(2131493363)
    RelativeLayout footer;
    @BindView(2131493543)
    ImageView ivEditCrop;
    @BindView(2131493544)
    ImageView ivEditDelete;
    @BindView(2131493550)
    ImageView ivImage;
    @BindView(2131493961)
    RelativeLayout rlEditCrop;
    @BindView(2131493962)
    RelativeLayout rlEditDelete;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        O000000o((int) R.layout.shop_order_review_image_edit);
        ButterKnife.bind(this);
        setTitle(getString(R.string.order_review_edit));
        this.mBackView.setVisibility(0);
        this.mCartView.setVisibility(8);
        if (TextUtils.isEmpty(getIntent().getStringExtra("path"))) {
            cec.O000000o(this, getString(R.string.error_invalid_data), 3000);
            finish();
        }
        initView();
        initListener();
    }

    public void initView() {
        String stringExtra = getIntent().getStringExtra("path");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.ivImage.setImageBitmap(cbb.O000000o(stringExtra, 600, 600));
        }
    }

    public void initListener() {
        this.rlEditCrop.setOnClickListener(this);
        this.ivEditCrop.setOnClickListener(this);
        this.rlEditDelete.setOnClickListener(this);
        this.ivEditDelete.setOnClickListener(this);
        this.btnDone.setOnClickListener(this);
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
        Uri uri;
        int id = view.getId();
        if (id == R.id.rl_edit_crop || id == R.id.iv_edit_crop) {
            File file = new File(getIntent().getStringExtra("path"));
            this.O00000Oo = addRandomNumber(getIntent().getStringExtra("path"));
            if (!TextUtils.isEmpty(this.O00000Oo)) {
                File file2 = new File(this.O00000Oo);
                if (!file2.exists()) {
                    file2.mkdir();
                }
                copyfile(file, file2, Boolean.TRUE);
                this.f4672O000000o = Uri.fromFile(file2);
                if (Build.VERSION.SDK_INT >= 24) {
                    uri = FileProvider.getUriForFile(this, cee.O000000o("file_provider_authorities"), file2);
                } else {
                    uri = Uri.fromFile(file2);
                }
                Intent intent = new Intent("com.android.camera.action.CROP");
                if (Build.VERSION.SDK_INT >= 24) {
                    intent.addFlags(1);
                }
                intent.setDataAndType(uri, "image/*");
                intent.putExtra("crop", "true");
                intent.putExtra("aspectX", 1);
                intent.putExtra("aspectY", 1);
                intent.putExtra("outputX", 400);
                intent.putExtra("outputY", 400);
                intent.putExtra("scale", false);
                intent.putExtra("output", this.f4672O000000o);
                intent.putExtra("return-data", false);
                intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
                intent.putExtra("noFaceDetection", true);
                startActivityForResult(intent, 1);
                Intent intent2 = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                intent2.setData(Uri.fromFile(file2));
                sendBroadcast(intent2);
                return;
            }
            return;
        }
        if (id == R.id.rl_edit_delete || id == R.id.iv_edit_delete) {
            Intent intent3 = new Intent();
            intent3.putExtra("deleteUrl", getIntent().getStringExtra("path"));
            setResult(100, intent3);
        } else if (id != R.id.btn_done) {
            return;
        } else {
            if (!TextUtils.isEmpty(this.O00000Oo)) {
                Intent intent4 = new Intent();
                intent4.putExtra("currentPath", getIntent().getStringExtra("path"));
                intent4.putExtra("newPath", this.O00000Oo);
                setResult(101, intent4);
            }
        }
        finish();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.f4672O000000o != null && intent != null && i == 1) {
            try {
                this.ivImage.setImageBitmap(MediaStore.Images.Media.getBitmap(getContentResolver(), this.f4672O000000o));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void copyfile(File file, File file2, Boolean bool) {
        if (file.exists() && file.isFile() && file.canRead()) {
            if (!file2.getParentFile().exists()) {
                file2.getParentFile().mkdirs();
            }
            if (file2.exists() && bool.booleanValue()) {
                file2.delete();
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read > 0) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileInputStream.close();
                        fileOutputStream.close();
                        return;
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public String addRandomNumber(String str) {
        Random random = new Random();
        if (!str.contains(".")) {
            return "";
        }
        String substring = str.substring(0, str.lastIndexOf(46));
        String substring2 = str.substring(str.lastIndexOf(46) + 1, str.length());
        return substring + random.nextInt(100000) + '.' + substring2;
    }
}
