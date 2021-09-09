package com.xiaomi.smarthome.camera.activity.local;

import _m_j.clj;
import _m_j.izb;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.XmVideoViewGl;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.activity.utils.CameraJumpUtils;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;

public class LocalPicReviewActivity extends CameraBaseActivity {
    View mBottomViewContainer;
    public boolean mFullScreen;
    ImageView mFullScreenView;
    clj.O000000o mLocalFile;
    clj mLocalFileManager;
    public int mRotation = 0;
    View mTopViewContainer;
    FrameLayout mVideoViewFrame;
    public int mVideoViewFrameHeight;
    public XmVideoViewGl xmVideoViewGl;

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        this.mLocalFileManager = this.mCameraDevice.O0000O0o();
        this.mLocalFile = this.mLocalFileManager.O00000Oo(getIntent().getStringExtra("file_path"));
        if (this.mLocalFile == null) {
            finish();
            return;
        }
        setContentView((int) R.layout.camera_activity_local_pic_review);
        ((TextView) findViewById(R.id.title_bar_title)).setText(this.mLocalFile.O00000o0.getName());
        findViewById(R.id.title_bar_return).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.local.LocalPicReviewActivity.AnonymousClass1 */

            public void onClick(View view) {
                LocalPicReviewActivity.this.finish();
            }
        });
        findViewById(R.id.title_bar_more).setVisibility(8);
        this.mVideoViewFrame = (FrameLayout) findViewById(R.id.video_frame);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        FrameLayout frameLayout = new FrameLayout(activity());
        this.mVideoViewFrame.addView(frameLayout, 0, layoutParams);
        this.xmVideoViewGl = XmPluginHostApi.instance().createVideoView(activity(), frameLayout, false, 1);
        this.xmVideoViewGl.setMiniScale(true);
        findViewById(R.id.local_share).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.local.LocalPicReviewActivity.AnonymousClass2 */

            public void onClick(View view) {
                CameraJumpUtils.openShareActivity(LocalPicReviewActivity.this.activity(), "", "", LocalPicReviewActivity.this.mLocalFile.O00000o0.getAbsolutePath());
            }
        });
        findViewById(R.id.local_delete).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.local.LocalPicReviewActivity.AnonymousClass3 */

            public void onClick(View view) {
                MLAlertDialog.Builder builder = new MLAlertDialog.Builder(LocalPicReviewActivity.this.activity());
                builder.O000000o((int) R.string.delete_title);
                builder.O000000o((int) R.string.delete, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.camera.activity.local.LocalPicReviewActivity.AnonymousClass3.AnonymousClass1 */

                    public void onClick(DialogInterface dialogInterface, int i) {
                        LocalPicReviewActivity.this.mLocalFileManager.O000000o(LocalPicReviewActivity.this.mLocalFile);
                        izb.O000000o(LocalPicReviewActivity.this.activity(), (int) R.string.local_file_delete_success, 0).show();
                        LocalPicReviewActivity.this.finish();
                    }
                });
                builder.O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null);
                builder.O00000oo();
            }
        });
        this.mTopViewContainer = findViewById(R.id.top_tools_container);
        findViewById(R.id.flip).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.local.LocalPicReviewActivity.AnonymousClass4 */

            public void onClick(View view) {
                LocalPicReviewActivity.this.mRotation += 90;
                LocalPicReviewActivity.this.mRotation %= 360;
                LocalPicReviewActivity.this.xmVideoViewGl.setRotation(LocalPicReviewActivity.this.mRotation);
            }
        });
        this.mFullScreenView = (ImageView) findViewById(R.id.full_screen);
        this.mFullScreenView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.local.LocalPicReviewActivity.AnonymousClass5 */

            public void onClick(View view) {
                LocalPicReviewActivity localPicReviewActivity = LocalPicReviewActivity.this;
                localPicReviewActivity.setFullScreen(!localPicReviewActivity.mFullScreen);
            }
        });
        this.mBottomViewContainer = findViewById(R.id.bottom_tools_container);
        this.xmVideoViewGl.setVideoViewListener(new XmVideoViewGl.IVideoViewListener() {
            /* class com.xiaomi.smarthome.camera.activity.local.LocalPicReviewActivity.AnonymousClass6 */

            public void onVideoViewClick() {
                if (LocalPicReviewActivity.this.mTopViewContainer.isShown()) {
                    Animation loadAnimation = AnimationUtils.loadAnimation(LocalPicReviewActivity.this.activity(), R.anim.slide_out_top);
                    loadAnimation.setFillAfter(true);
                    LocalPicReviewActivity.this.mTopViewContainer.startAnimation(loadAnimation);
                    return;
                }
                Animation loadAnimation2 = AnimationUtils.loadAnimation(LocalPicReviewActivity.this.activity(), R.anim.slide_in_top);
                loadAnimation2.setFillAfter(true);
                LocalPicReviewActivity.this.mTopViewContainer.startAnimation(loadAnimation2);
            }
        });
        setFullScreen(false);
        this.xmVideoViewGl.initial();
        Bitmap decodeFile = BitmapFactory.decodeFile(this.mLocalFile.O00000o0.getAbsolutePath());
        if (decodeFile != null) {
            this.xmVideoViewGl.setFirstBitmap(decodeFile);
        }
    }

    public void onStop() {
        super.onStop();
    }

    public void onDestroy() {
        super.onDestroy();
        XmVideoViewGl xmVideoViewGl2 = this.xmVideoViewGl;
        if (xmVideoViewGl2 != null) {
            xmVideoViewGl2.release();
        }
    }

    public void onBackPressed() {
        if (this.mFullScreen) {
            runMainThread(new Runnable() {
                /* class com.xiaomi.smarthome.camera.activity.local.LocalPicReviewActivity.AnonymousClass7 */

                public void run() {
                    LocalPicReviewActivity.this.setFullScreen(false);
                }
            });
        } else {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: package-private */
    public void setFullScreen(boolean z) {
        this.mFullScreen = z;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        if (i > i2) {
            i = displayMetrics.heightPixels;
            i2 = displayMetrics.widthPixels;
        }
        if (this.mFullScreen) {
            setRequestedOrientation(6);
            this.mFullScreenView.setImageResource(R.drawable.camera_icon_mixscreen_land);
            findViewById(R.id.title_bar).setVisibility(8);
            this.xmVideoViewGl.setVideoFrameSize(i2, i, true);
            this.mBottomViewContainer.setVisibility(8);
            this.mTopViewContainer.setPadding(0, getResources().getDimensionPixelOffset(R.dimen.full_screen_top_bar_padding), 0, 0);
            return;
        }
        this.mFullScreenView.setImageResource(R.drawable.camera_icon_fullscreen2);
        this.mTopViewContainer.setPadding(0, 0, 0, 0);
        if (this.mVideoViewFrameHeight == 0) {
            this.mHandler.postDelayed(new Runnable() {
                /* class com.xiaomi.smarthome.camera.activity.local.LocalPicReviewActivity.AnonymousClass8 */

                public void run() {
                    LocalPicReviewActivity localPicReviewActivity = LocalPicReviewActivity.this;
                    localPicReviewActivity.mVideoViewFrameHeight = localPicReviewActivity.mVideoViewFrame.getHeight();
                    LocalPicReviewActivity localPicReviewActivity2 = LocalPicReviewActivity.this;
                    localPicReviewActivity2.setFullScreen(localPicReviewActivity2.mFullScreen);
                }
            }, 300);
            return;
        }
        setRequestedOrientation(1);
        findViewById(R.id.title_bar).setVisibility(0);
        this.xmVideoViewGl.setVideoFrameSize(i, this.mVideoViewFrameHeight, false);
        this.mBottomViewContainer.setVisibility(0);
    }

    public void onResume() {
        super.onResume();
    }
}
