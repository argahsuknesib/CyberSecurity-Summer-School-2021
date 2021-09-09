package com.xiaomi.smarthome.library.common.widget.crop;

import _m_j.gpj;
import _m_j.gqy;
import _m_j.gsy;
import _m_j.izb;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.media.FaceDetector;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.widget.crop.BitmapManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.CountDownLatch;

public class CropImageActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    final int f9300O000000o = 1024;
    protected TextTitleBar O00000Oo;
    boolean O00000o;
    boolean O00000o0;
    HighlightView O00000oO;
    Runnable O00000oo = new Runnable() {
        /* class com.xiaomi.smarthome.library.common.widget.crop.CropImageActivity.AnonymousClass5 */

        /* renamed from: O000000o  reason: collision with root package name */
        float f9306O000000o = 1.0f;
        Matrix O00000Oo;
        int O00000o;
        FaceDetector.Face[] O00000o0 = new FaceDetector.Face[3];

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
         arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
         candidates:
          ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
          ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
        public final void run() {
            Bitmap bitmap;
            this.O00000Oo = CropImageActivity.this.mImageView.getImageMatrix();
            if (CropImageActivity.this.mBitmap == null) {
                bitmap = null;
            } else {
                if (CropImageActivity.this.mBitmap.getWidth() > 256) {
                    this.f9306O000000o = 256.0f / ((float) CropImageActivity.this.mBitmap.getWidth());
                }
                Matrix matrix = new Matrix();
                float f = this.f9306O000000o;
                matrix.setScale(f, f);
                bitmap = Bitmap.createBitmap(CropImageActivity.this.mBitmap, 0, 0, CropImageActivity.this.mBitmap.getWidth(), CropImageActivity.this.mBitmap.getHeight(), matrix, true);
            }
            this.f9306O000000o = 1.0f / this.f9306O000000o;
            if (bitmap != null && CropImageActivity.this.mDoFaceDetection) {
                this.O00000o = new FaceDetector(bitmap.getWidth(), bitmap.getHeight(), this.O00000o0.length).findFaces(bitmap, this.O00000o0);
            }
            if (!(bitmap == null || bitmap == CropImageActivity.this.mBitmap)) {
                bitmap.recycle();
            }
            CropImageActivity.this.mHandler.post(new Runnable() {
                /* class com.xiaomi.smarthome.library.common.widget.crop.CropImageActivity.AnonymousClass5.AnonymousClass1 */

                public final void run() {
                    int i;
                    CropImageActivity.this.O00000o0 = AnonymousClass5.this.O00000o > 1;
                    if (AnonymousClass5.this.O00000o > 0) {
                        for (int i2 = 0; i2 < AnonymousClass5.this.O00000o; i2++) {
                            AnonymousClass5 r1 = AnonymousClass5.this;
                            FaceDetector.Face face = r1.O00000o0[i2];
                            PointF pointF = new PointF();
                            face.getMidPoint(pointF);
                            pointF.x *= r1.f9306O000000o;
                            pointF.y *= r1.f9306O000000o;
                            HighlightView highlightView = new HighlightView(CropImageActivity.this.mImageView);
                            Rect rect = new Rect(0, 0, CropImageActivity.this.mBitmap.getWidth(), CropImageActivity.this.mBitmap.getHeight());
                            float f = (float) ((int) pointF.x);
                            float f2 = (float) ((int) pointF.y);
                            RectF rectF = new RectF(f, f2, f, f2);
                            float f3 = (float) (-(((int) (face.eyesDistance() * r1.f9306O000000o)) * 2));
                            rectF.inset(f3, f3);
                            if (rectF.left < 0.0f) {
                                rectF.inset(-rectF.left, -rectF.left);
                            }
                            if (rectF.top < 0.0f) {
                                rectF.inset(-rectF.top, -rectF.top);
                            }
                            if (rectF.right > ((float) rect.right)) {
                                rectF.inset(rectF.right - ((float) rect.right), rectF.right - ((float) rect.right));
                            }
                            if (rectF.bottom > ((float) rect.bottom)) {
                                rectF.inset(rectF.bottom - ((float) rect.bottom), rectF.bottom - ((float) rect.bottom));
                            }
                            highlightView.O000000o(r1.O00000Oo, rect, rectF, CropImageActivity.this.mCircleCrop, (CropImageActivity.this.mAspectX == 0 || CropImageActivity.this.mAspectY == 0) ? false : true);
                            CropImageActivity.this.mImageView.add(highlightView);
                        }
                    } else {
                        AnonymousClass5 r0 = AnonymousClass5.this;
                        HighlightView highlightView2 = new HighlightView(CropImageActivity.this.mImageView);
                        int width = CropImageActivity.this.mBitmap.getWidth();
                        int height = CropImageActivity.this.mBitmap.getHeight();
                        Rect rect2 = new Rect(0, 0, width, height);
                        int min = (Math.min(width, height) * 2) / 3;
                        if (CropImageActivity.this.mAspectX == 0 || CropImageActivity.this.mAspectY == 0) {
                            i = min;
                        } else if (CropImageActivity.this.mAspectX > CropImageActivity.this.mAspectY) {
                            i = (CropImageActivity.this.mAspectY * min) / CropImageActivity.this.mAspectX;
                        } else {
                            i = min;
                            min = (CropImageActivity.this.mAspectX * min) / CropImageActivity.this.mAspectY;
                        }
                        int i3 = (width - min) / 2;
                        int i4 = (height - i) / 2;
                        highlightView2.O000000o(r0.O00000Oo, rect2, new RectF((float) i3, (float) i4, (float) (i3 + min), (float) (i4 + i)), CropImageActivity.this.mCircleCrop, (CropImageActivity.this.mAspectX == 0 || CropImageActivity.this.mAspectY == 0) ? false : true);
                        CropImageActivity.this.mImageView.mHighlightViews.clear();
                        CropImageActivity.this.mImageView.add(highlightView2);
                    }
                    CropImageActivity.this.mImageView.invalidate();
                    if (CropImageActivity.this.mImageView.mHighlightViews.size() == 1) {
                        CropImageActivity.this.O00000oO = CropImageActivity.this.mImageView.mHighlightViews.get(0);
                        CropImageActivity.this.O00000oO.O00000Oo = true;
                    }
                    if (AnonymousClass5.this.O00000o > 1) {
                        izb.O000000o(CropImageActivity.this, "Multi face crop help", 0).show();
                    }
                }
            });
        }
    };
    private Bitmap.CompressFormat O0000O0o = Bitmap.CompressFormat.JPEG;
    private Uri O0000OOo = null;
    private int O0000Oo;
    private int O0000Oo0;
    private boolean O0000OoO;
    private ContentResolver O0000Ooo;
    private Uri O0000o0;
    private String O0000o00;
    private boolean O0000o0O = true;
    private final BitmapManager.O000000o O0000o0o = new BitmapManager.O000000o();
    public int mAspectX;
    public int mAspectY;
    public Bitmap mBitmap;
    public boolean mCircleCrop = false;
    public boolean mDoFaceDetection = true;
    public final Handler mHandler = new Handler();
    public CropImageView mImageView;

    public void onCreate(Bundle bundle) {
        Uri uri;
        super.onCreate(bundle);
        this.O0000Ooo = getContentResolver();
        setContentView((int) R.layout.cropimage);
        this.O00000Oo = (TextTitleBar) findViewById(R.id.title_bar);
        this.mImageView = (CropImageView) findViewById(R.id.image);
        showStorageToast(this);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            if (extras.getString("circleCrop") != null) {
                if (Build.VERSION.SDK_INT > 11) {
                    this.mImageView.setLayerType(1, null);
                }
                this.mCircleCrop = true;
                this.mAspectX = 1;
                this.mAspectY = 1;
            }
            this.O0000o00 = extras.getString("image-path");
            this.O0000o0 = intent.getData();
            if (TextUtils.isEmpty(this.O0000o00) && (uri = this.O0000o0) != null) {
                this.O0000o00 = uri.getPath();
            }
            this.O0000OOo = (Uri) extras.getParcelable("output");
            this.mBitmap = O000000o(this.O0000o0);
            if (!extras.containsKey("aspectX") || !(extras.get("aspectX") instanceof Integer)) {
                throw new IllegalArgumentException("aspect_x must be integer");
            }
            this.mAspectX = extras.getInt("aspectX");
            if (!extras.containsKey("aspectY") || !(extras.get("aspectY") instanceof Integer)) {
                throw new IllegalArgumentException("aspect_y must be integer");
            }
            this.mAspectY = extras.getInt("aspectY");
            this.O0000Oo0 = extras.getInt("outputX");
            this.O0000Oo = extras.getInt("outputY");
            this.O0000OoO = extras.getBoolean("scale", true);
            this.O0000o0O = extras.getBoolean("scaleUpIfNeeded", true);
        }
        if (this.mBitmap == null) {
            finish();
            return;
        }
        this.O00000Oo.setTitle((int) R.string.crop_image_title);
        this.O00000Oo.getLeftView().setText((int) R.string.sh_common_cancel);
        this.O00000Oo.getLeftView().setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.library.common.widget.crop.CropImageActivity.AnonymousClass1 */

            public final void onClick(View view) {
                CropImageActivity.this.finish();
            }
        });
        this.O00000Oo.getRightView().setText((int) R.string.crop_image_next);
        this.O00000Oo.getRightView().setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.library.common.widget.crop.CropImageActivity.AnonymousClass2 */

            public final void onClick(View view) {
                try {
                    CropImageActivity.this.onSaveClicked();
                } catch (Exception unused) {
                    CropImageActivity.this.finish();
                }
            }
        });
        if (!isFinishing()) {
            this.mImageView.setImageBitmapResetBase(this.mBitmap, true);
            gqy.O000000o(this, getResources().getString(R.string.mj_please_wait), new Runnable() {
                /* class com.xiaomi.smarthome.library.common.widget.crop.CropImageActivity.AnonymousClass3 */

                public final void run() {
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    final Bitmap bitmap = CropImageActivity.this.mBitmap;
                    CropImageActivity.this.mHandler.post(new Runnable() {
                        /* class com.xiaomi.smarthome.library.common.widget.crop.CropImageActivity.AnonymousClass3.AnonymousClass1 */

                        public final void run() {
                            if (!(bitmap == CropImageActivity.this.mBitmap || bitmap == null)) {
                                CropImageActivity.this.mImageView.setImageBitmapResetBase(bitmap, true);
                                CropImageActivity.this.mBitmap.recycle();
                                CropImageActivity.this.mBitmap = bitmap;
                            }
                            if (CropImageActivity.this.mImageView.getScale() == 1.0f) {
                                CropImageActivity.this.mImageView.center(true, true);
                            }
                            countDownLatch.countDown();
                        }
                    });
                    try {
                        countDownLatch.await();
                        CropImageActivity.this.O00000oo.run();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }, this.mHandler);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
     arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
     candidates:
      ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
      ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
    private Bitmap O000000o(Uri uri) {
        try {
            InputStream openInputStream = this.O0000Ooo.openInputStream(uri);
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i = 1;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(openInputStream, null, options);
            openInputStream.close();
            if (options.outHeight > 1024 || options.outWidth > 1024) {
                double max = (double) Math.max(options.outHeight, options.outWidth);
                Double.isNaN(max);
                i = (int) Math.pow(2.0d, (double) ((int) Math.round(Math.log(1024.0d / max) / Math.log(0.5d))));
            }
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inSampleSize = i;
            InputStream openInputStream2 = this.O0000Ooo.openInputStream(uri);
            Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream2, null, options2);
            openInputStream2.close();
            int O00000Oo2 = gpj.O00000Oo(this.O0000o00);
            if (O00000Oo2 > 0) {
                Matrix matrix = new Matrix();
                matrix.postRotate((float) O00000Oo2);
                Bitmap createBitmap = Bitmap.createBitmap(decodeStream, 0, 0, decodeStream.getWidth(), decodeStream.getHeight(), matrix, true);
                if (createBitmap != null) {
                    if (createBitmap == decodeStream) {
                        return createBitmap;
                    }
                    decodeStream.recycle();
                    return createBitmap;
                }
            }
            return decodeStream;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void onSaveClicked() throws Exception {
        HighlightView highlightView;
        final Bitmap bitmap;
        int i;
        if (!this.O00000o && (highlightView = this.O00000oO) != null) {
            this.O00000o = true;
            Rect O000000o2 = highlightView.O000000o();
            int width = O000000o2.width();
            int height = O000000o2.height();
            try {
                Bitmap createBitmap = Bitmap.createBitmap(width, height, this.mCircleCrop ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
                if (createBitmap != null) {
                    new Canvas(createBitmap).drawBitmap(this.mBitmap, O000000o2, new Rect(0, 0, width, height), (Paint) null);
                    if (this.mCircleCrop) {
                        Canvas canvas = new Canvas(createBitmap);
                        Path path = new Path();
                        float f = ((float) width) / 2.0f;
                        path.addCircle(f, ((float) height) / 2.0f, f, Path.Direction.CW);
                        canvas.clipPath(path, Region.Op.DIFFERENCE);
                        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    }
                    int i2 = this.O0000Oo0;
                    if (i2 == 0 || (i = this.O0000Oo) == 0) {
                        bitmap = createBitmap;
                    } else if (this.O0000OoO) {
                        bitmap = gqy.O000000o(new Matrix(), createBitmap, this.O0000Oo0, this.O0000Oo, this.O0000o0O);
                        if (createBitmap != bitmap) {
                            createBitmap.recycle();
                        }
                    } else {
                        bitmap = Bitmap.createBitmap(i2, i, Bitmap.Config.RGB_565);
                        Canvas canvas2 = new Canvas(bitmap);
                        Rect O000000o3 = this.O00000oO.O000000o();
                        Rect rect = new Rect(0, 0, this.O0000Oo0, this.O0000Oo);
                        int width2 = (O000000o3.width() - rect.width()) / 2;
                        int height2 = (O000000o3.height() - rect.height()) / 2;
                        O000000o3.inset(Math.max(0, width2), Math.max(0, height2));
                        rect.inset(Math.max(0, -width2), Math.max(0, -height2));
                        canvas2.drawBitmap(this.mBitmap, O000000o3, rect, (Paint) null);
                        createBitmap.recycle();
                    }
                    Bundle extras = getIntent().getExtras();
                    if (extras == null || (extras.getParcelable("data") == null && !extras.getBoolean("return-data"))) {
                        gqy.O000000o(this, getString(R.string.saving_image), new Runnable() {
                            /* class com.xiaomi.smarthome.library.common.widget.crop.CropImageActivity.AnonymousClass4 */

                            public final void run() {
                                CropImageActivity.this.saveOutput(bitmap);
                            }
                        }, this.mHandler);
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("data", bitmap);
                    setResult(-1, new Intent().setAction("inline-data").putExtras(bundle));
                    finish();
                }
            } catch (Exception e) {
                throw e;
            }
        }
    }

    public void saveOutput(Bitmap bitmap) {
        Uri uri = this.O0000OOo;
        if (uri != null) {
            try {
                OutputStream openOutputStream = this.O0000Ooo.openOutputStream(uri);
                if (openOutputStream != null) {
                    bitmap.compress(this.O0000O0o, 90, openOutputStream);
                }
                gqy.O000000o(openOutputStream);
                Bundle bundle = new Bundle();
                Intent intent = new Intent(this.O0000OOo.toString());
                intent.putExtras(bundle);
                intent.putExtra("image-path", this.O0000o00);
                setResult(-1, intent);
            } catch (IOException e) {
                Log.e("CropImage", "Cannot open file: " + this.O0000OOo, e);
                setResult(0);
                finish();
                gqy.O000000o(null);
                return;
            } catch (Throwable th) {
                gqy.O000000o(null);
                throw th;
            }
        } else {
            gsy.O000000o(6, "CropImage", "not defined image url");
        }
        bitmap.recycle();
        finish();
    }

    public void onPause() {
        super.onPause();
        BitmapManager.O000000o().O000000o(this.O0000o0o);
    }

    public void onDestroy() {
        super.onDestroy();
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
    }

    public static void showStorageToast(Activity activity) {
        showStorageToast(activity, calculatePicturesRemaining(activity));
    }

    public static void showStorageToast(Activity activity, int i) {
        String str;
        if (i == -1) {
            str = Environment.getExternalStorageState().equals("checking") ? activity.getString(R.string.preparing_card) : activity.getString(R.string.no_storage_card);
        } else {
            str = i <= 0 ? activity.getString(R.string.not_enough_space) : null;
        }
        if (str != null) {
            izb.O000000o(activity, str, 0).show();
        }
    }

    public static int calculatePicturesRemaining(Activity activity) {
        String str;
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                str = Environment.getExternalStorageDirectory().toString();
            } else {
                str = activity.getFilesDir().toString();
            }
            StatFs statFs = new StatFs(str);
            return (int) ((((float) statFs.getAvailableBlocks()) * ((float) statFs.getBlockSize())) / 400000.0f);
        } catch (Exception unused) {
            return -2;
        }
    }
}
