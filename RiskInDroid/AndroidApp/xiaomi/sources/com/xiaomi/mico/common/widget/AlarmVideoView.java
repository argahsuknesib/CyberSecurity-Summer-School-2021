package com.xiaomi.mico.common.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import com.squareup.picasso.Picasso;
import com.xiaomi.mico.api.AccountInfo;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.LoginManager;
import com.xiaomi.mico.common.threadpool.Threadpool;
import com.xiaomi.mico.common.util.DisplayUtils;
import com.xiaomi.mico.common.widget.AlarmVideoView;
import com.xiaomi.smarthome.R;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class AlarmVideoView extends LinearLayout {
    CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener;
    ImageView playStateView;
    public boolean prepared;
    private String previewUrl;
    CheckBox selectedStateView;
    TextView videoLengthView;
    private String videoPath;
    ImageView videoPreview;
    RelativeLayout videoRoot;
    VideoView videoView;

    public AlarmVideoView(Context context) {
        super(context);
    }

    public AlarmVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet, 0);
    }

    public AlarmVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet, i);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        LayoutInflater.from(context).inflate((int) R.layout.widget_alarm_video, this);
        this.videoRoot = (RelativeLayout) findViewById(R.id.video_root);
        this.videoView = (VideoView) findViewById(R.id.video_view);
        this.videoLengthView = (TextView) findViewById(R.id.video_length);
        this.selectedStateView = (CheckBox) findViewById(R.id.selected_state);
        this.playStateView = (ImageView) findViewById(R.id.play_state);
        this.playStateView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.common.widget.$$Lambda$AlarmVideoView$IpRB1pNuINYH6s8ADkqMQEa73mw */

            public final void onClick(View view) {
                AlarmVideoView.this.lambda$init$0$AlarmVideoView(view);
            }
        });
        this.videoPreview = (ImageView) findViewById(R.id.video_preview_iv);
        this.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            /* class com.xiaomi.mico.common.widget.AlarmVideoView.AnonymousClass1 */

            public void onCompletion(MediaPlayer mediaPlayer) {
                if (AlarmVideoView.this.playStateView != null) {
                    AlarmVideoView.this.playStateView.setVisibility(0);
                }
            }
        });
        this.videoRoot.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.common.widget.AlarmVideoView.AnonymousClass2 */

            public void onClick(View view) {
                if (AlarmVideoView.this.videoView.isPlaying()) {
                    AlarmVideoView.this.videoView.pause();
                    AlarmVideoView.this.playStateView.setVisibility(0);
                }
            }
        });
        this.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            /* class com.xiaomi.mico.common.widget.AlarmVideoView.AnonymousClass3 */

            public void onPrepared(MediaPlayer mediaPlayer) {
                if (AlarmVideoView.this.playStateView != null) {
                    AlarmVideoView alarmVideoView = AlarmVideoView.this;
                    alarmVideoView.prepared = true;
                    alarmVideoView.setVideoLength((long) (mediaPlayer.getDuration() / 1000));
                    AlarmVideoView.this.playStateView.setVisibility(0);
                    mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                        /* class com.xiaomi.mico.common.widget.AlarmVideoView.AnonymousClass3.AnonymousClass1 */

                        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                            if (i != 3) {
                                return true;
                            }
                            AlarmVideoView.this.videoView.setBackgroundColor(0);
                            return true;
                        }
                    });
                }
            }
        });
        ViewGroup.LayoutParams layoutParams = this.videoRoot.getLayoutParams();
        layoutParams.height = (int) (((float) (DisplayUtils.getScreenWidthPixels(context) - DisplayUtils.dip2px(context, 20.0f))) * 0.462f);
        this.videoRoot.setLayoutParams(layoutParams);
    }

    public /* synthetic */ void lambda$init$0$AlarmVideoView(View view) {
        onClick();
    }

    public void setVideoLength(long j) {
        long j2 = j / 60;
        long j3 = j % 60;
        String str = "";
        if (j2 > 0) {
            str = (str + j2) + getContext().getString(R.string.picker_minute);
        }
        this.videoLengthView.setText((str + j3) + getContext().getString(R.string.common_second));
    }

    public void setVideoPath(String str) {
        String str2 = this.videoPath;
        if (str2 == null || !str2.equals(str)) {
            new Object[1][0] = "videoPath=".concat(String.valueOf(str));
            this.videoPath = str;
            if (TextUtils.isEmpty(str) || !str.startsWith("http")) {
                playUserRingtoneVideo(str);
            } else {
                this.videoView.setVideoPath(str);
            }
        }
    }

    public void setVideoPath(Uri uri) {
        if (uri != null) {
            String str = this.videoPath;
            if (str == null || !str.equals(uri.toString())) {
                this.videoPath = uri.toString();
                this.videoView.setVideoURI(uri);
                new Object[1][0] = "videoPath=" + this.videoPath;
                this.videoPreview.setVisibility(8);
                setFirstFrameDrawable(uri);
            }
        }
    }

    private void playUserRingtoneVideo(String str) {
        ApiHelper.getAlarmVideoFileUrl(str, new ApiRequest.Listener<String>() {
            /* class com.xiaomi.mico.common.widget.AlarmVideoView.AnonymousClass4 */

            public void onSuccess(String str) {
                new Object[1][0] = "video url=".concat(String.valueOf(str));
                AccountInfo.ServiceInfo serviceInfo = LoginManager.getInstance().getServiceInfo("ai-service");
                if (serviceInfo == null || !serviceInfo.isServiceTokenValid()) {
                    LoginManager.getInstance().refreshServiceToken("ai-service").observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1(str) {
                        /* class com.xiaomi.mico.common.widget.$$Lambda$AlarmVideoView$4$XniooKOmYOIAOTZ4EiLVhhOEEec */
                        private final /* synthetic */ String f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void call(Object obj) {
                            AlarmVideoView.AnonymousClass4.this.lambda$onSuccess$0$AlarmVideoView$4(this.f$1, (String) obj);
                        }
                    }, $$Lambda$AlarmVideoView$4$NC36l07OQFK67LzhXt0S8Yo7k_M.INSTANCE);
                } else {
                    AlarmVideoView.this.setVideoURI(str, serviceInfo.getServiceToken());
                }
            }

            public /* synthetic */ void lambda$onSuccess$0$AlarmVideoView$4(String str, String str2) {
                if (!TextUtils.isEmpty(str2)) {
                    AlarmVideoView.this.setVideoURI(str, str2);
                } else {
                    new Object[1][0] = "refresh service token is empty:";
                }
            }

            static /* synthetic */ void lambda$onSuccess$1(Throwable th) {
                Object[] objArr = {"refresh service token error:", th};
            }

            public void onFailure(ApiError apiError) {
                Object[] objArr = {"load video url file:", apiError};
            }
        });
    }

    public void setVideoURI(String str, String str2) {
        HashMap hashMap = new HashMap();
        String format = String.format("serviceToken=%s;userId=%s", str2, LoginManager.getInstance().getPassportInfo().getUserId());
        hashMap.put("Cookie", format + "\r\n");
        if (Build.VERSION.SDK_INT >= 21) {
            this.videoView.setVideoURI(Uri.parse(str), hashMap);
        } else {
            try {
                Field declaredField = VideoView.class.getDeclaredField("mHeaders");
                declaredField.setAccessible(true);
                declaredField.set(this.videoView, hashMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.videoView.setVideoURI(Uri.parse(str));
        }
        setFirstFrameDrawable(str, hashMap);
    }

    private void setFirstFrameDrawable(String str, Map<String, String> map) {
        Threadpool.getSharedThreadPool().submit(new Runnable(str, map) {
            /* class com.xiaomi.mico.common.widget.$$Lambda$AlarmVideoView$ZjZOAqeeldnp6KDjQ978ezX15sc */
            private final /* synthetic */ String f$1;
            private final /* synthetic */ Map f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                AlarmVideoView.this.lambda$setFirstFrameDrawable$2$AlarmVideoView(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$setFirstFrameDrawable$2$AlarmVideoView(String str, Map map) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str, map);
        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
        ImageView imageView = this.videoPreview;
        if (imageView != null) {
            imageView.post(new Runnable(frameAtTime) {
                /* class com.xiaomi.mico.common.widget.$$Lambda$AlarmVideoView$yD50nS4jsjsV2a7ffkui1H_7wE */
                private final /* synthetic */ Bitmap f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    AlarmVideoView.this.lambda$null$1$AlarmVideoView(this.f$1);
                }
            });
        }
        mediaMetadataRetriever.close();
    }

    public /* synthetic */ void lambda$null$1$AlarmVideoView(Bitmap bitmap) {
        this.videoPreview.setImageBitmap(bitmap);
        this.videoPreview.setVisibility(0);
    }

    private void setFirstFrameDrawable(Uri uri) {
        Threadpool.getSharedThreadPool().submit(new Runnable(uri) {
            /* class com.xiaomi.mico.common.widget.$$Lambda$AlarmVideoView$xLgGMnBfDPnKG48sWU5L4gZ0pEc */
            private final /* synthetic */ Uri f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                AlarmVideoView.this.lambda$setFirstFrameDrawable$4$AlarmVideoView(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$setFirstFrameDrawable$4$AlarmVideoView(Uri uri) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(getContext(), uri);
        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
        ImageView imageView = this.videoPreview;
        if (imageView != null) {
            imageView.post(new Runnable(frameAtTime) {
                /* class com.xiaomi.mico.common.widget.$$Lambda$AlarmVideoView$lK707PCCHSvY_OPmZ99f5pdOLOs */
                private final /* synthetic */ Bitmap f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    AlarmVideoView.this.lambda$null$3$AlarmVideoView(this.f$1);
                }
            });
        }
        mediaMetadataRetriever.close();
    }

    public /* synthetic */ void lambda$null$3$AlarmVideoView(Bitmap bitmap) {
        this.videoPreview.setImageBitmap(bitmap);
        this.videoPreview.setVisibility(0);
    }

    public void setVideoPreview(String str) {
        if (!TextUtils.isEmpty(str) && !"null".equalsIgnoreCase(str) && !str.equals(this.previewUrl)) {
            new Object[1][0] = "previewUrl=".concat(String.valueOf(str));
            this.previewUrl = str;
            this.videoPreview.setVisibility(0);
            Picasso.get().load(str).into(this.videoPreview);
        }
    }

    public void onClick() {
        if (this.prepared) {
            this.videoPreview.setVisibility(8);
            this.playStateView.setVisibility(8);
            this.videoView.start();
        }
    }

    public void pauseVideo() {
        VideoView videoView2 = this.videoView;
        if (videoView2 != null && this.prepared && videoView2.isPlaying()) {
            this.playStateView.setVisibility(0);
            this.videoPreview.setVisibility(0);
            this.videoView.pause();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        pauseVideo();
    }

    public void setVideoSelected(boolean z) {
        this.selectedStateView.setOnCheckedChangeListener(null);
        this.selectedStateView.setChecked(z);
        this.selectedStateView.setOnCheckedChangeListener(this.mOnCheckedChangeListener);
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.mOnCheckedChangeListener = onCheckedChangeListener;
        this.selectedStateView.setOnCheckedChangeListener(this.mOnCheckedChangeListener);
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.videoRoot.setOnLongClickListener(onLongClickListener);
    }
}
