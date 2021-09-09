package com.xiaomi.smarthome.miio.camera.face.activity;

import _m_j.civ;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.gwg;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.miio.camera.face.FaceManager;
import com.xiaomi.smarthome.miio.camera.face.util.CameraUtils;
import com.xiaomi.smarthome.miio.camera.face.util.ImageUtils;
import com.xiaomi.smarthome.miio.camera.face.widget.CameraCircleView;
import com.xiaomi.smarthome.miio.camera.face.widget.CameraSurfaceView;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class FaceCameraActivity extends FaceManagerBaseActivity implements View.OnClickListener {
    public static final String TAG = "FaceCameraActivity";
    private TextView btn_take;
    public String filePath;
    private ImageView icon_close;
    public ImageView iv_take_ed_photo;
    public FrameLayout mAspectLayout;
    private Button mBtnSwitch;
    private boolean mCameraRequested;
    public CameraSurfaceView mCameraSurfaceView;
    public int mOrientation;
    public CameraCircleView mask;
    public boolean taked = false;
    private TextView tv_confirm;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_face_camera);
        initView();
        gwg.O000000o(this.icon_close);
    }

    private void initView() {
        this.iv_take_ed_photo = (ImageView) findViewById(R.id.iv_take_ed_photo);
        this.icon_close = (ImageView) findViewById(R.id.icon_close);
        this.icon_close.setOnClickListener(this);
        this.mask = (CameraCircleView) findViewById(R.id.mask);
        this.mAspectLayout = (FrameLayout) findViewById(R.id.layout_aspect);
        this.tv_confirm = (TextView) findViewById(R.id.tv_confirm);
        this.tv_confirm.setOnClickListener(this);
        this.btn_take = (TextView) findViewById(R.id.btn_take);
        this.btn_take.setOnClickListener(this);
        this.mBtnSwitch = (Button) findViewById(R.id.btn_switch);
        this.mBtnSwitch.setOnClickListener(this);
        CameraUtils.openFrontalCamera(30);
        final Camera.Size previewSize = CameraUtils.getPreviewSize();
        String str = TAG;
        civ.O000000o(str, "size.width=" + previewSize.width + "  size.height=" + previewSize.height);
        this.mCameraSurfaceView = (CameraSurfaceView) findViewById(R.id.camera_surface);
        this.mOrientation = CameraUtils.calculateCameraPreviewOrientation(this);
        this.mAspectLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceCameraActivity.AnonymousClass1 */

            public void onGlobalLayout() {
                FaceCameraActivity.this.mAspectLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) FaceCameraActivity.this.mCameraSurfaceView.getLayoutParams();
                layoutParams.width = (int) (FaceCameraActivity.this.mask.circleR * 2.0f);
                layoutParams.height = (int) (((float) layoutParams.width) * (((float) previewSize.width) / ((float) previewSize.height)));
                layoutParams.leftMargin = (int) (FaceCameraActivity.this.mask.circleX - FaceCameraActivity.this.mask.circleR);
                layoutParams.topMargin = (int) (FaceCameraActivity.this.mask.circleY - FaceCameraActivity.this.mask.circleR);
                String str = FaceCameraActivity.TAG;
                civ.O000000o(str, layoutParams.width + "-" + layoutParams.height);
                FaceCameraActivity.this.mCameraSurfaceView.setLayoutParams(layoutParams);
                FaceCameraActivity.this.mCameraSurfaceView.getHolder().setFixedSize(layoutParams.width, layoutParams.height);
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) FaceCameraActivity.this.iv_take_ed_photo.getLayoutParams();
                layoutParams2.width = layoutParams.width;
                layoutParams2.height = layoutParams2.width;
                layoutParams2.leftMargin = layoutParams.leftMargin;
                layoutParams2.topMargin = layoutParams.topMargin;
                FaceCameraActivity.this.iv_take_ed_photo.setLayoutParams(layoutParams2);
            }
        });
    }

    public void onResume() {
        super.onResume();
        if (this.mCameraRequested) {
            CameraUtils.startPreview();
        }
    }

    public void onPause() {
        super.onPause();
        CameraUtils.stopPreview();
        CameraUtils.releaseCamera();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_take) {
            takePicture();
        } else if (id == R.id.btn_switch) {
            switchCamera();
        } else if (id == R.id.icon_close) {
            if (this.taked) {
                this.taked = false;
                refreshUI();
                return;
            }
            finish();
        } else if (id == R.id.tv_confirm) {
            confirm();
        }
    }

    private void confirm() {
        gqg.O00000Oo((int) R.string.face_recognitioning);
        mFaceManager.uploadImageFile(this, this.filePath, new FaceManager.IFaceCallback() {
            /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceCameraActivity.AnonymousClass2 */

            public void onSuccess(Object obj, Object obj2) {
                try {
                    String string = ((JSONObject) ((JSONObject) obj).getJSONObject("data").getJSONArray("faceInfoMetas").get(0)).getString("faceId");
                    Intent intent = new Intent();
                    intent.putExtra("faceId", string);
                    FaceCameraActivity.this.setResult(-1, intent);
                    FaceCameraActivity.this.finish();
                } catch (JSONException e) {
                    gqg.O00000Oo((int) R.string.face_recognition_fail_tips);
                    e.printStackTrace();
                    FaceCameraActivity faceCameraActivity = FaceCameraActivity.this;
                    faceCameraActivity.taked = false;
                    faceCameraActivity.refreshUI();
                }
            }

            public void onFailure(int i, String str) {
                gqg.O00000Oo((int) R.string.face_recognition_fail_tips);
                FaceCameraActivity faceCameraActivity = FaceCameraActivity.this;
                faceCameraActivity.taked = false;
                faceCameraActivity.refreshUI();
            }
        });
    }

    private void takePicture() {
        if (CameraUtils.getCameraID() != 1) {
            CameraUtils.startPreview();
            CameraUtils.takePicture(new Camera.ShutterCallback() {
                /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceCameraActivity.AnonymousClass3 */

                public void onShutter() {
                    civ.O000000o(FaceCameraActivity.TAG, "shutterCallback onShutter");
                }
            }, new Camera.PictureCallback() {
                /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceCameraActivity.AnonymousClass4 */

                public void onPictureTaken(byte[] bArr, Camera camera) {
                    if (bArr != null) {
                        String str = FaceCameraActivity.TAG;
                        civ.O000000o(str, "rawCallback onPictureTaken data=" + bArr.length);
                    }
                }
            }, new Camera.PictureCallback() {
                /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceCameraActivity.AnonymousClass5 */

                public void onPictureTaken(byte[] bArr, Camera camera) {
                    if (bArr != null) {
                        String str = FaceCameraActivity.TAG;
                        civ.O000000o(str, "postviewCallback onPictureTaken data=" + bArr.length);
                    }
                }
            }, new Camera.PictureCallback() {
                /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceCameraActivity.AnonymousClass6 */

                public void onPictureTaken(byte[] bArr, Camera camera) {
                    civ.O000000o(FaceCameraActivity.TAG, "pictureCallback onPictureTaken");
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                    if (decodeByteArray != null) {
                        Bitmap croped = ImageUtils.getCroped(ImageUtils.getRotatedBitmap(decodeByteArray, FaceCameraActivity.this.mOrientation), FaceCameraActivity.this.mask, FaceCameraActivity.this.mCameraSurfaceView);
                        String str = Environment.getExternalStorageDirectory() + "/DCIM/Camera/" + System.currentTimeMillis() + ".jpg";
                        FaceCameraActivity.this.filePath = str;
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(str);
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                            croped.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
                            bufferedOutputStream.flush();
                            bufferedOutputStream.close();
                            fileOutputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        } else if (CameraUtils.yuvData == null || CameraUtils.mPreviewWidth <= 0 || CameraUtils.mPreviewHeight <= 0) {
            gsy.O000000o(6, TAG, "yuvData data invalid width:" + CameraUtils.mPreviewWidth + " height:" + CameraUtils.mPreviewHeight);
            return;
        } else {
            YuvImage yuvImage = new YuvImage(CameraUtils.yuvData, CameraUtils.getPreviewFormat(), CameraUtils.mPreviewWidth, CameraUtils.mPreviewHeight, null);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(CameraUtils.yuvData.length);
            if (yuvImage.compressToJpeg(new Rect(0, 0, CameraUtils.mPreviewWidth, CameraUtils.mPreviewHeight), 100, byteArrayOutputStream)) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                if (decodeByteArray != null) {
                    Bitmap flipBitmap = ImageUtils.getFlipBitmap(decodeByteArray);
                    civ.O000000o(TAG, "mOrientation=" + this.mOrientation);
                    Bitmap croped = ImageUtils.getCroped(ImageUtils.getRotatedBitmap(flipBitmap, this.mOrientation), this.mask, this.mCameraSurfaceView);
                    this.iv_take_ed_photo.setImageBitmap(croped);
                    String str = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM) + "/Camera/";
                    String str2 = str + System.currentTimeMillis() + ".jpg";
                    this.filePath = str2;
                    try {
                        File file = new File(str);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        File file2 = new File(str2);
                        if (!file2.exists()) {
                            file2.createNewFile();
                        }
                        FileOutputStream fileOutputStream = new FileOutputStream(file2);
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                        croped.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                return;
            }
        }
        this.taked = true;
        refreshUI();
    }

    public void refreshUI() {
        CameraCircleView cameraCircleView = this.mask;
        cameraCircleView.taked = this.taked;
        cameraCircleView.invalidate();
        if (this.taked) {
            this.btn_take.setVisibility(8);
            this.tv_confirm.setVisibility(0);
            this.iv_take_ed_photo.setVisibility(0);
            return;
        }
        this.btn_take.setVisibility(0);
        this.tv_confirm.setVisibility(8);
        this.iv_take_ed_photo.setVisibility(4);
    }

    private void switchCamera() {
        if (this.mCameraSurfaceView != null) {
            CameraUtils.switchCamera(1 - CameraUtils.getCameraID(), this.mCameraSurfaceView.getHolder());
            this.mOrientation = CameraUtils.calculateCameraPreviewOrientation(this);
        }
    }
}
