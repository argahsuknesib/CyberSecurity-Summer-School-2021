package com.xiaomi.smarthome.camera.v4.view;

import _m_j.chz;
import _m_j.cjh;
import _m_j.goq;
import _m_j.me;
import _m_j.wd;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.XmVideoViewGl;
import com.xiaomi.smarthome.camera.v4.view.PreSetPositionView;
import com.xiaomi.smarthome.library.common.widget.RoundedImageView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Locale;

public class PreSetPositionView extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TAG = "PreSetPositionView";
    public View back_ground;
    private Context context;
    public boolean editEnable;
    private boolean isEmptyAdd;
    private ImageView iv_del;
    public RoundedImageView iv_pic;
    private LinearLayout ll_add_pic;
    private int mGravity;
    private cjh mVideoView;
    private chz.O00000o preSetPosition;
    private TextView tv_ID;

    public interface OnDeletePicListener {
        void onDelete(chz.O00000o o00000o);
    }

    public interface OnUpdatePicListener {
        void onUpdate(chz.O00000o o00000o);
    }

    public void setmVideoView(cjh cjh) {
        this.mVideoView = cjh;
    }

    public PreSetPositionView(Context context2) {
        this(context2, null);
    }

    public PreSetPositionView(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public PreSetPositionView(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.mGravity = 1;
        this.isEmptyAdd = true;
        this.editEnable = false;
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, new int[]{R.attr.child_gravity});
        this.mGravity = obtainStyledAttributes.getInt(0, 1);
        init(context2);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context2) {
        this.context = context2;
        View inflate = inflate(context2, R.layout.layout_yuzhiwei_item, this);
        this.iv_pic = (RoundedImageView) inflate.findViewById(R.id.iv_pic);
        this.ll_add_pic = (LinearLayout) inflate.findViewById(R.id.ll_add_pic);
        this.tv_ID = (TextView) inflate.findViewById(R.id.tv_ID);
        this.iv_del = (ImageView) inflate.findViewById(R.id.iv_del);
        this.back_ground = inflate.findViewById(R.id.back_ground);
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate.findViewById(R.id.root_container);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) constraintLayout.getLayoutParams();
        int i = this.mGravity;
        if (i == 0) {
            layoutParams.gravity = 8388611;
        } else if (i == 1) {
            layoutParams.gravity = 17;
        } else if (i == 2) {
            layoutParams.gravity = 8388613;
        }
        constraintLayout.setLayoutParams(layoutParams);
    }

    public void updateImg(String str, String str2, int i) {
        wd.O000000o(TAG, "updateIma......");
        postDelayed(new Runnable(str, str2, i) {
            /* class com.xiaomi.smarthome.camera.v4.view.$$Lambda$PreSetPositionView$k19XOvQnGvCiipa1TayGKihvc */
            private final /* synthetic */ String f$1;
            private final /* synthetic */ String f$2;
            private final /* synthetic */ int f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void run() {
                PreSetPositionView.this.lambda$updateImg$0$PreSetPositionView(this.f$1, this.f$2, this.f$3);
            }
        }, 1000);
    }

    public /* synthetic */ void lambda$updateImg$0$PreSetPositionView(final String str, final String str2, final int i) {
        this.mVideoView.O000000o(new XmVideoViewGl.PhotoSnapCallback() {
            /* class com.xiaomi.smarthome.camera.v4.view.PreSetPositionView.AnonymousClass1 */
            static final /* synthetic */ boolean $assertionsDisabled = false;

            static {
                Class<PreSetPositionView> cls = PreSetPositionView.class;
            }

            public void onSnap(Bitmap bitmap) {
                if (bitmap != null) {
                    PreSetPositionView.this.post(new Runnable(bitmap, str, str2, i) {
                        /* class com.xiaomi.smarthome.camera.v4.view.$$Lambda$PreSetPositionView$1$Pn40bmanAcI9Ib3PTJiBxFr_KBs */
                        private final /* synthetic */ Bitmap f$1;
                        private final /* synthetic */ String f$2;
                        private final /* synthetic */ String f$3;
                        private final /* synthetic */ int f$4;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                            this.f$4 = r5;
                        }

                        public final void run() {
                            PreSetPositionView.AnonymousClass1.this.lambda$onSnap$1$PreSetPositionView$1(this.f$1, this.f$2, this.f$3, this.f$4);
                        }
                    });
                }
            }

            public /* synthetic */ void lambda$onSnap$1$PreSetPositionView$1(Bitmap bitmap, String str, String str2, int i) {
                PreSetPositionView.this.iv_pic.setImageBitmap(bitmap);
                PreSetPositionView.this.back_ground.setVisibility(4);
                goq.O000000o(new Runnable(str, str2, i, bitmap) {
                    /* class com.xiaomi.smarthome.camera.v4.view.$$Lambda$PreSetPositionView$1$OwfaxykvaqWcpZb6UIQL912kTH8 */
                    private final /* synthetic */ String f$0;
                    private final /* synthetic */ String f$1;
                    private final /* synthetic */ int f$2;
                    private final /* synthetic */ Bitmap f$3;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                    }

                    public final void run() {
                        PreSetPositionView.AnonymousClass1.lambda$null$0(this.f$0, this.f$1, this.f$2, this.f$3);
                    }
                });
            }

            static /* synthetic */ void lambda$null$0(String str, String str2, int i, Bitmap bitmap) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(me.O000000o(str, str2, i)));
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (Exception e) {
                    wd.O00000o0(PreSetPositionView.TAG, e.toString());
                }
            }
        });
    }

    public void setNormalState(String str, String str2, OnUpdatePicListener onUpdatePicListener) {
        this.isEmptyAdd = false;
        this.preSetPosition = (chz.O00000o) getTag();
        this.tv_ID.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(this.preSetPosition.f13873O000000o)));
        this.iv_pic.setVisibility(0);
        this.back_ground.setVisibility(0);
        try {
            File file = new File(me.O000000o(str, str2, this.preSetPosition.f13873O000000o));
            if (file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                this.iv_pic.setImageBitmap(BitmapFactory.decodeStream(fileInputStream));
                this.back_ground.setVisibility(4);
                fileInputStream.close();
            }
        } catch (Exception e) {
            wd.O00000o0(TAG, e.toString());
        }
        if (!this.editEnable) {
            this.iv_del.setVisibility(4);
        } else {
            this.iv_del.setVisibility(0);
        }
        this.tv_ID.setVisibility(0);
        this.ll_add_pic.setVisibility(4);
        this.iv_pic.setOnClickListener(new View.OnClickListener(onUpdatePicListener) {
            /* class com.xiaomi.smarthome.camera.v4.view.$$Lambda$PreSetPositionView$PwxUJXEumB0vXOvuMVGVv_VAo */
            private final /* synthetic */ PreSetPositionView.OnUpdatePicListener f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                PreSetPositionView.this.lambda$setNormalState$1$PreSetPositionView(this.f$1, view);
            }
        });
    }

    public /* synthetic */ void lambda$setNormalState$1$PreSetPositionView(OnUpdatePicListener onUpdatePicListener, View view) {
        if (onUpdatePicListener != null) {
            onUpdatePicListener.onUpdate(this.preSetPosition);
        }
    }

    public void setAddState(View.OnClickListener onClickListener) {
        this.isEmptyAdd = true;
        this.iv_pic.setVisibility(4);
        this.iv_del.setVisibility(4);
        this.tv_ID.setVisibility(4);
        this.ll_add_pic.setVisibility(0);
        this.ll_add_pic.setOnClickListener(onClickListener);
    }

    public void setEditStateListener(OnDeletePicListener onDeletePicListener) {
        this.preSetPosition = (chz.O00000o) getTag();
        this.iv_del.setOnClickListener(new View.OnClickListener(onDeletePicListener) {
            /* class com.xiaomi.smarthome.camera.v4.view.$$Lambda$PreSetPositionView$1vWIzn5jqQaShy3ynPa6UiHRg7E */
            private final /* synthetic */ PreSetPositionView.OnDeletePicListener f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                PreSetPositionView.this.lambda$setEditStateListener$2$PreSetPositionView(this.f$1, view);
            }
        });
    }

    public /* synthetic */ void lambda$setEditStateListener$2$PreSetPositionView(OnDeletePicListener onDeletePicListener, View view) {
        if (onDeletePicListener != null) {
            onDeletePicListener.onDelete(this.preSetPosition);
        }
    }

    public void setEditEnable(boolean z) {
        this.editEnable = z;
        if (!z || this.isEmptyAdd) {
            this.iv_del.setVisibility(4);
        } else {
            this.iv_del.setVisibility(0);
        }
    }
}
