package com.tencent.connect.avatar;

import _m_j.dig;
import _m_j.dij;
import _m_j.din;
import _m_j.dio;
import _m_j.diw;
import _m_j.djk;
import _m_j.djp;
import _m_j.djx;
import _m_j.djz;
import _m_j.dkb;
import _m_j.jdn;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.open.utils.HttpUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class ImageActivity extends Activity {

    /* renamed from: O000000o  reason: collision with root package name */
    RelativeLayout f5841O000000o;
    /* access modifiers changed from: private */
    public dij O00000Oo;
    /* access modifiers changed from: private */
    public Handler O00000o;
    /* access modifiers changed from: private */
    public String O00000o0;
    /* access modifiers changed from: private */
    public c O00000oO;
    /* access modifiers changed from: private */
    public Button O00000oo;
    /* access modifiers changed from: private */
    public Button O0000O0o;
    /* access modifiers changed from: private */
    public b O0000OOo;
    /* access modifiers changed from: private */
    public ProgressBar O0000Oo;
    private TextView O0000Oo0;
    /* access modifiers changed from: private */
    public int O0000OoO = 0;
    /* access modifiers changed from: private */
    public boolean O0000Ooo = false;
    /* access modifiers changed from: private */
    public Rect O0000o = new Rect();
    private int O0000o0 = 0;
    /* access modifiers changed from: private */
    public long O0000o00 = 0;
    private final int O0000o0O = 640;
    private final int O0000o0o = 640;
    private Bitmap O0000oO;
    private String O0000oO0;
    private final View.OnClickListener O0000oOO = new View.OnClickListener() {
        /* class com.tencent.connect.avatar.ImageActivity.AnonymousClass2 */

        public final void onClick(View view) {
            ImageActivity.this.O0000Oo.setVisibility(0);
            ImageActivity.this.O0000O0o.setEnabled(false);
            ImageActivity.this.O0000O0o.setTextColor(Color.rgb(21, 21, 21));
            ImageActivity.this.O00000oo.setEnabled(false);
            ImageActivity.this.O00000oo.setTextColor(Color.rgb(36, 94, 134));
            new Thread(new Runnable() {
                /* class com.tencent.connect.avatar.ImageActivity.AnonymousClass2.AnonymousClass1 */

                public final void run() {
                    ImageActivity.O0000O0o(ImageActivity.this);
                }
            }).start();
            if (ImageActivity.this.O0000Ooo) {
                ImageActivity.this.a("10657", 0);
                return;
            }
            ImageActivity.this.a("10655", System.currentTimeMillis() - ImageActivity.this.O0000o00);
            if (ImageActivity.this.O00000oO.b) {
                ImageActivity.this.a("10654", 0);
            }
        }
    };
    private final View.OnClickListener O0000oOo = new View.OnClickListener() {
        /* class com.tencent.connect.avatar.ImageActivity.AnonymousClass3 */

        public final void onClick(View view) {
            ImageActivity.this.a("10656", System.currentTimeMillis() - ImageActivity.this.O0000o00);
            ImageActivity.this.setResult(0);
            ImageActivity.this.O000000o();
        }
    };
    private final djz O0000oo = new djx() {
        /* class com.tencent.connect.avatar.ImageActivity.AnonymousClass6 */

        public final void onCancel() {
        }

        public final void onError(dkb dkb) {
            O000000o();
        }

        public final void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            int i = -1;
            try {
                i = jSONObject.getInt("ret");
                if (i == 0) {
                    final String string = jSONObject.getString("nickname");
                    ImageActivity.this.O00000o.post(new Runnable() {
                        /* class com.tencent.connect.avatar.ImageActivity.AnonymousClass6.AnonymousClass1 */

                        public final void run() {
                            ImageActivity.O00000o0(ImageActivity.this, string);
                        }
                    });
                    ImageActivity.this.a("10659", 0);
                } else {
                    ImageActivity.this.a("10661", 0);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (i != 0) {
                O000000o();
            }
        }

        private void O000000o() {
            if (ImageActivity.this.O0000OoO < 2) {
                ImageActivity.this.O00000Oo();
            }
        }
    };
    private final djz O0000oo0 = new djx() {
        /* class com.tencent.connect.avatar.ImageActivity.AnonymousClass5 */

        public final void onCancel() {
        }

        public final void onError(dkb dkb) {
            ImageActivity.this.O0000O0o.setEnabled(true);
            ImageActivity.this.O0000O0o.setTextColor(-1);
            ImageActivity.this.O00000oo.setEnabled(true);
            ImageActivity.this.O00000oo.setTextColor(-1);
            ImageActivity.this.O00000oo.setText("重试");
            ImageActivity.this.O0000Oo.setVisibility(8);
            boolean unused = ImageActivity.this.O0000Ooo = true;
            ImageActivity.this.O000000o(dkb.O00000Oo, 1);
            ImageActivity.this.a("10660", 0);
        }

        public final void onComplete(Object obj) {
            ImageActivity.this.O0000O0o.setEnabled(true);
            int i = -1;
            ImageActivity.this.O0000O0o.setTextColor(-1);
            ImageActivity.this.O00000oo.setEnabled(true);
            ImageActivity.this.O00000oo.setTextColor(-1);
            ImageActivity.this.O0000Oo.setVisibility(8);
            JSONObject jSONObject = (JSONObject) obj;
            try {
                i = jSONObject.getInt("ret");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (i == 0) {
                ImageActivity.this.O000000o("设置成功", 0);
                ImageActivity.this.a("10658", 0);
                diw.O000000o();
                diw.O000000o(ImageActivity.this.O00000Oo.O00000o0, ImageActivity.this.O00000Oo.f14674O000000o, "ANDROIDSDK.SETAVATAR.SUCCEED", "12", "3", "0");
                ImageActivity imageActivity = ImageActivity.this;
                if (imageActivity.O00000o0 != null && !"".equals(ImageActivity.this.O00000o0)) {
                    Intent intent = new Intent();
                    intent.setClassName(imageActivity, ImageActivity.this.O00000o0);
                    if (imageActivity.getPackageManager().resolveActivity(intent, 0) != null) {
                        imageActivity.startActivity(intent);
                    }
                }
                ImageActivity.this.O000000o(0, jSONObject.toString(), null, null);
                ImageActivity.this.O000000o();
                return;
            }
            ImageActivity.this.O000000o("设置出错了，请重新登录再尝试下呢：）", 1);
            diw.O000000o();
            diw.O000000o(ImageActivity.this.O00000Oo.O00000o0, ImageActivity.this.O00000Oo.f14674O000000o, "ANDROIDSDK.SETAVATAR.SUCCEED", "12", "19", "1");
        }
    };

    private Bitmap O000000o(String str) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i = 1;
        options.inJustDecodeBounds = true;
        Uri parse = Uri.parse(str);
        InputStream openInputStream = getContentResolver().openInputStream(parse);
        if (openInputStream == null) {
            return null;
        }
        try {
            BitmapFactory.decodeStream(openInputStream, null, options);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
        openInputStream.close();
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        while (i2 * i3 > 4194304) {
            i2 /= 2;
            i3 /= 2;
            i *= 2;
        }
        options.inJustDecodeBounds = false;
        options.inSampleSize = i;
        try {
            return BitmapFactory.decodeStream(getContentResolver().openInputStream(parse), null, options);
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            return null;
        }
    }

    class O00000Oo extends View {
        public O00000Oo(Context context) {
            super(context);
        }

        public final void O000000o(Button button) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable O000000o2 = djp.O000000o("com.tencent.plus.blue_normal.png", ImageActivity.this);
            Drawable O000000o3 = djp.O000000o("com.tencent.plus.blue_down.png", ImageActivity.this);
            Drawable O000000o4 = djp.O000000o("com.tencent.plus.blue_disable.png", ImageActivity.this);
            stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, O000000o3);
            stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, O000000o2);
            stateListDrawable.addState(View.ENABLED_STATE_SET, O000000o2);
            stateListDrawable.addState(View.FOCUSED_STATE_SET, O000000o2);
            stateListDrawable.addState(View.EMPTY_STATE_SET, O000000o4);
            button.setBackgroundDrawable(stateListDrawable);
        }

        public final void O00000Oo(Button button) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable O000000o2 = djp.O000000o("com.tencent.plus.gray_normal.png", ImageActivity.this);
            Drawable O000000o3 = djp.O000000o("com.tencent.plus.gray_down.png", ImageActivity.this);
            Drawable O000000o4 = djp.O000000o("com.tencent.plus.gray_disable.png", ImageActivity.this);
            stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, O000000o3);
            stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, O000000o2);
            stateListDrawable.addState(View.ENABLED_STATE_SET, O000000o2);
            stateListDrawable.addState(View.FOCUSED_STATE_SET, O000000o2);
            stateListDrawable.addState(View.EMPTY_STATE_SET, O000000o4);
            button.setBackgroundDrawable(stateListDrawable);
        }
    }

    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setRequestedOrientation(1);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
        ViewGroup.LayoutParams layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
        this.f5841O000000o = new RelativeLayout(this);
        this.f5841O000000o.setLayoutParams(layoutParams);
        this.f5841O000000o.setBackgroundColor(-16777216);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(layoutParams3);
        this.f5841O000000o.addView(relativeLayout);
        this.O00000oO = new c(this);
        this.O00000oO.setLayoutParams(layoutParams2);
        this.O00000oO.setScaleType(ImageView.ScaleType.MATRIX);
        relativeLayout.addView(this.O00000oO);
        this.O0000OOo = new b(this);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(layoutParams2);
        layoutParams4.addRule(14, -1);
        layoutParams4.addRule(15, -1);
        this.O0000OOo.setLayoutParams(layoutParams4);
        relativeLayout.addView(this.O0000OOo);
        LinearLayout linearLayout = new LinearLayout(this);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, din.O000000o(this, 80.0f));
        layoutParams5.addRule(14, -1);
        linearLayout.setLayoutParams(layoutParams5);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        this.f5841O000000o.addView(linearLayout);
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(din.O000000o(this, 24.0f), din.O000000o(this, 24.0f)));
        imageView.setImageDrawable(djp.O000000o("com.tencent.plus.logo.png", this));
        linearLayout.addView(imageView);
        this.O0000Oo0 = new TextView(this);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(layoutParams3);
        layoutParams6.leftMargin = din.O000000o(this, 7.0f);
        this.O0000Oo0.setLayoutParams(layoutParams6);
        this.O0000Oo0.setEllipsize(TextUtils.TruncateAt.END);
        this.O0000Oo0.setSingleLine();
        this.O0000Oo0.setTextColor(-1);
        this.O0000Oo0.setTextSize(24.0f);
        this.O0000Oo0.setVisibility(8);
        linearLayout.addView(this.O0000Oo0);
        RelativeLayout relativeLayout2 = new RelativeLayout(this);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, din.O000000o(this, 60.0f));
        layoutParams7.addRule(12, -1);
        layoutParams7.addRule(9, -1);
        relativeLayout2.setLayoutParams(layoutParams7);
        relativeLayout2.setBackgroundDrawable(djp.O000000o("com.tencent.plus.bar.png", this));
        int O000000o2 = din.O000000o(this, 10.0f);
        relativeLayout2.setPadding(O000000o2, O000000o2, O000000o2, 0);
        this.f5841O000000o.addView(relativeLayout2);
        O00000Oo o00000Oo = new O00000Oo(this);
        int O000000o3 = din.O000000o(this, 14.0f);
        int O000000o4 = din.O000000o(this, 7.0f);
        this.O0000O0o = new Button(this);
        this.O0000O0o.setLayoutParams(new RelativeLayout.LayoutParams(din.O000000o(this, 78.0f), din.O000000o(this, 45.0f)));
        this.O0000O0o.setText("取消");
        this.O0000O0o.setTextColor(-1);
        this.O0000O0o.setTextSize(18.0f);
        this.O0000O0o.setPadding(O000000o3, O000000o4, O000000o3, O000000o4);
        o00000Oo.O00000Oo(this.O0000O0o);
        relativeLayout2.addView(this.O0000O0o);
        this.O00000oo = new Button(this);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(din.O000000o(this, 78.0f), din.O000000o(this, 45.0f));
        layoutParams8.addRule(11, -1);
        this.O00000oo.setLayoutParams(layoutParams8);
        this.O00000oo.setTextColor(-1);
        this.O00000oo.setTextSize(18.0f);
        this.O00000oo.setPadding(O000000o3, O000000o4, O000000o3, O000000o4);
        this.O00000oo.setText("选取");
        o00000Oo.O000000o(this.O00000oo);
        relativeLayout2.addView(this.O00000oo);
        TextView textView = new TextView(this);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(layoutParams3);
        layoutParams9.addRule(13, -1);
        textView.setLayoutParams(layoutParams9);
        textView.setText("移动和缩放");
        textView.setPadding(0, din.O000000o(this, 3.0f), 0, 0);
        textView.setTextSize(18.0f);
        textView.setTextColor(-1);
        relativeLayout2.addView(textView);
        this.O0000Oo = new ProgressBar(this);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(layoutParams3);
        layoutParams10.addRule(14, -1);
        layoutParams10.addRule(15, -1);
        this.O0000Oo.setLayoutParams(layoutParams10);
        this.O0000Oo.setVisibility(8);
        this.f5841O000000o.addView(this.O0000Oo);
        setContentView(this.f5841O000000o);
        this.O00000o = new Handler();
        Bundle bundleExtra = getIntent().getBundleExtra("key_params");
        this.O0000oO0 = bundleExtra.getString("picture");
        this.O00000o0 = bundleExtra.getString("return_activity");
        String string = bundleExtra.getString("appid");
        String string2 = bundleExtra.getString("access_token");
        long j = bundleExtra.getLong("expires_in");
        String string3 = bundleExtra.getString("openid");
        this.O0000o0 = bundleExtra.getInt("exitAnim");
        this.O00000Oo = new dij(string);
        dij dij = this.O00000Oo;
        StringBuilder sb = new StringBuilder();
        sb.append((j - System.currentTimeMillis()) / 1000);
        dij.O000000o(string2, sb.toString());
        this.O00000Oo.O00000o0 = string3;
        try {
            this.O0000oO = O000000o(this.O0000oO0);
            if (this.O0000oO != null) {
                this.O00000oO.setImageBitmap(this.O0000oO);
                this.O00000oo.setOnClickListener(this.O0000oOO);
                this.O0000O0o.setOnClickListener(this.O0000oOo);
                this.f5841O000000o.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    /* class com.tencent.connect.avatar.ImageActivity.AnonymousClass1 */

                    public final void onGlobalLayout() {
                        ImageActivity.this.f5841O000000o.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                        ImageActivity imageActivity = ImageActivity.this;
                        Rect unused = imageActivity.O0000o = imageActivity.O0000OOo.O000000o();
                        ImageActivity.this.O00000oO.a(ImageActivity.this.O0000o);
                    }
                });
                O00000Oo();
                this.O0000o00 = System.currentTimeMillis();
                a("10653", 0);
                return;
            }
            throw new IOException("cannot read picture: '" + this.O0000oO0 + "'!");
        } catch (IOException e) {
            e.printStackTrace();
            O000000o("图片读取失败，请检查该图片是否有效", 1);
            O000000o(-5, null, "图片读取失败，请检查该图片是否有效", e.getMessage());
            O000000o();
        }
    }

    public void onBackPressed() {
        setResult(0);
        O000000o();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.O00000oO.setImageBitmap(null);
        Bitmap bitmap = this.O0000oO;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.O0000oO.recycle();
        }
    }

    class O000000o extends dio {
        public O000000o(dij dij) {
            super(dij, (byte) 0);
        }

        public final void O000000o(Bitmap bitmap, djz djz) {
            Bundle O000000o2 = O000000o();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 40, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            bitmap.recycle();
            dio.O000000o o000000o = new dio.O000000o(djz);
            O000000o2.putByteArray("picture", byteArray);
            HttpUtils.O000000o(this.O00000oO, djk.O000000o(), "user/set_user_face", O000000o2, "POST", o000000o);
            diw.O000000o();
            diw.O000000o(this.O00000oO.O00000o0, this.O00000oO.f14674O000000o, "ANDROIDSDK.SETAVATAR.SUCCEED", "12", "19", "0");
        }
    }

    /* access modifiers changed from: private */
    public void O000000o(final String str, final int i) {
        this.O00000o.post(new Runnable() {
            /* class com.tencent.connect.avatar.ImageActivity.AnonymousClass4 */

            public final void run() {
                ImageActivity.O000000o(ImageActivity.this, str, i);
            }
        });
    }

    /* access modifiers changed from: private */
    public void O000000o(int i, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.putExtra("key_error_code", i);
        intent.putExtra("key_error_msg", str2);
        intent.putExtra("key_error_detail", str3);
        intent.putExtra("key_response", str);
        setResult(-1, intent);
    }

    /* access modifiers changed from: private */
    public void O000000o() {
        finish();
        int i = this.O0000o0;
        if (i != 0) {
            overridePendingTransition(0, i);
        }
    }

    /* access modifiers changed from: private */
    public void O00000Oo() {
        this.O0000OoO++;
        new dig(this.O00000Oo).O000000o(this.O0000oo);
    }

    public void a(String str, long j) {
        djp.O000000o(this, str, j, this.O00000Oo.f14674O000000o);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
     arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
     candidates:
      ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
      ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
    static /* synthetic */ void O0000O0o(ImageActivity imageActivity) {
        Matrix imageMatrix = imageActivity.O00000oO.getImageMatrix();
        float[] fArr = new float[9];
        imageMatrix.getValues(fArr);
        float f = fArr[2];
        float f2 = fArr[5];
        float f3 = fArr[0];
        float width = 640.0f / ((float) imageActivity.O0000o.width());
        int i = (int) ((((float) imageActivity.O0000o.left) - f) / f3);
        int i2 = i < 0 ? 0 : i;
        int i3 = (int) ((((float) imageActivity.O0000o.top) - f2) / f3);
        int i4 = i3 < 0 ? 0 : i3;
        Matrix matrix = new Matrix();
        matrix.set(imageMatrix);
        matrix.postScale(width, width);
        int i5 = (int) (650.0f / f3);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(imageActivity.O0000oO, i2, i4, Math.min(imageActivity.O0000oO.getWidth() - i2, i5), Math.min(imageActivity.O0000oO.getHeight() - i4, i5), matrix, true);
            Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 0, 0, 640, 640);
            createBitmap.recycle();
            new O000000o(imageActivity.O00000Oo).O000000o(createBitmap2, imageActivity.O0000oo0);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            imageActivity.O000000o("图片读取失败，请检查该图片是否有效", 1);
            imageActivity.O000000o(-5, null, "图片读取失败，请检查该图片是否有效", e.getMessage());
            imageActivity.O000000o();
        }
    }

    static /* synthetic */ void O000000o(ImageActivity imageActivity, String str, int i) {
        Toast makeText = Toast.makeText(imageActivity, str, 1);
        LinearLayout linearLayout = (LinearLayout) makeText.getView();
        ((TextView) linearLayout.getChildAt(0)).setPadding(8, 0, 0, 0);
        ImageView imageView = new ImageView(imageActivity);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(din.O000000o(imageActivity, 16.0f), din.O000000o(imageActivity, 16.0f)));
        if (i == 0) {
            imageView.setImageDrawable(djp.O000000o("com.tencent.plus.ic_success.png", imageActivity));
        } else {
            imageView.setImageDrawable(djp.O000000o("com.tencent.plus.ic_error.png", imageActivity));
        }
        linearLayout.addView(imageView, 0);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        makeText.setView(linearLayout);
        makeText.setGravity(17, 0, 0);
        makeText.show();
    }

    static /* synthetic */ void O00000o0(ImageActivity imageActivity, String str) {
        String replaceAll = str.replaceAll("&gt;", ">").replaceAll("&lt;", "<").replaceAll("&quot;", jdn.f1779O000000o).replaceAll("&#39;", "'").replaceAll("&amp;", "&");
        if (!"".equals(replaceAll)) {
            imageActivity.O0000Oo0.setText(replaceAll);
            imageActivity.O0000Oo0.setVisibility(0);
        }
    }
}
