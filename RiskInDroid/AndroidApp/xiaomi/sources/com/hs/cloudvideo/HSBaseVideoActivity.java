package com.hs.cloudvideo;

import _m_j.bas;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.upstream.FileDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoDecoderOutputBuffer;
import com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer;
import com.xiaomi.smarthome.R;
import com.xiaovv.player.HSVideoView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public abstract class HSBaseVideoActivity extends AppCompatActivity implements bas, View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    private LinearLayout assistantLayout;
    private LinearLayout bottomMenuLayout;
    private ImageButton btnCylinder;
    private ImageButton btnDisplayMode;
    private ImageButton btnDouble;
    private ImageButton btnFixType;
    private ImageButton btnFour;
    private ImageButton btnFullScreenshot;
    private ImageButton btnFullVoice;
    private ImageButton btnFullscreen;
    private ImageButton btnGoBack;
    private ImageButton btnMultiple;
    private ImageButton btnOriginal;
    private ImageButton btnPlayStop;
    private ImageButton btnRestore;
    private ImageButton btnScreenshot;
    private ImageButton btnScreenshotTips;
    private Button btnSpeed;
    private ImageButton btnStretch;
    private ImageButton btnVoice;
    private String deviceDid;
    public LinearLayout fixSelectorLayout;
    public boolean isClickStop;
    public boolean isCompleted;
    public boolean isFullScreen;
    private boolean isOnPause;
    public boolean isPlaySucceed;
    private boolean isSeekBarTouch;
    private boolean isVoice;
    private FrameLayout mContainer;
    public SimpleExoPlayer mExoPlayer;
    public final Handler mHandler = new Handler(new O000000o(this, (byte) 0));
    private String mScreenshotPath;
    public HSVideoView mVideoView;
    public LinearLayout modeSelectorLayout;
    private ProgressBar pbLoadingView;
    private int playSpeed = 1;
    private SeekBar sbVideoProgress;
    public LinearLayout screenshotTipsLayout;
    private LinearLayout titleBarLayout;
    private TextView tvDuration;
    public TextView tvErrorMsg;
    private TextView tvPosition;
    public TextView tvTimeOsd;
    private TextView tvTitle;
    public LinearLayout videoProgressLayout;

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.hs_cloud_video_activity);
        findId();
        setListener();
        startLoading();
        initPlayer();
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            int intExtra = intent.getIntExtra("key_hs_video_type", 0);
            this.deviceDid = intent.getStringExtra("key_hs_device_did");
            if (intExtra == 1) {
                this.tvTitle.setText(intent.getStringExtra("key_hs_video_title"));
                startPlay(getVideoUrl());
            } else if (intExtra == 2) {
                String parseM3U8Folder = parseM3U8Folder(intent.getStringExtra("key_hs_m3u8_local_path"));
                if (parseM3U8Folder == null || TextUtils.isEmpty(parseM3U8Folder)) {
                    stopLoading();
                    this.tvErrorMsg.setText("Path empty");
                    return;
                }
                this.tvTitle.setText(parseM3U8Folder.substring(parseM3U8Folder.lastIndexOf("/") + 1));
                startPlay(parseM3U8Folder);
            } else if (intExtra == 3) {
                String stringExtra = intent.getStringExtra("key_hs_video_path");
                if (stringExtra == null || TextUtils.isEmpty(stringExtra)) {
                    stopLoading();
                    this.tvErrorMsg.setText("Path empty");
                    return;
                }
                this.tvTitle.setText(stringExtra.substring(stringExtra.lastIndexOf("/") + 1));
                startPlay(stringExtra);
            }
        }
    }

    public void onResume() {
        super.onResume();
        if (this.isOnPause && !this.isCompleted && !this.isClickStop) {
            this.mExoPlayer.play();
        }
        this.isOnPause = false;
    }

    public void onPause() {
        super.onPause();
        this.isOnPause = true;
        this.mExoPlayer.pause();
    }

    public void onDestroy() {
        super.onDestroy();
        releasePlayer();
    }

    public void onBackPressed() {
        if (this.isFullScreen) {
            setFullscreen(false);
        } else {
            super.onBackPressed();
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_go_back) {
            onBackPressed();
        } else if (id == R.id.btn_fix_type) {
            if (this.mVideoView.getFixType() == 1) {
                this.mVideoView.setFixType(0);
            } else {
                this.mVideoView.setFixType(1);
            }
            showFixSelectorLayout();
            hideModeSelectorLayout();
        } else if (id == R.id.btn_pano_mode) {
            if (this.modeSelectorLayout.getVisibility() != 0) {
                showModeSelectorLayout();
            } else {
                hideModeSelectorLayout();
            }
        } else if (id == R.id.btn_mode_original) {
            setDisplayMode(0);
        } else if (id == R.id.btn_mode_cylinder) {
            setDisplayMode(3);
        } else if (id == R.id.btn_mode_multiple) {
            setDisplayMode(11);
        } else if (id == R.id.btn_mode_double) {
            setDisplayMode(6);
        } else if (id == R.id.btn_mode_four) {
            setDisplayMode(7);
        } else if (id == R.id.btn_mode_stretch) {
            setDisplayMode(4);
        } else if (id == R.id.btn_screenshot || id == R.id.btn_full_screenshot) {
            if (!isLoading()) {
                doScreenshot();
            }
        } else if (id == R.id.btn_play_stop) {
            if (!isLoading()) {
                if (this.mExoPlayer.isPlaying()) {
                    this.isClickStop = true;
                    this.mExoPlayer.pause();
                } else {
                    this.isClickStop = false;
                    if (this.isCompleted) {
                        seekTo(0);
                    }
                    this.mExoPlayer.play();
                }
                updatePlayerState();
            }
        } else if (id == R.id.btn_play_speed) {
            changePlaySpeed();
        } else if (id == R.id.btn_video_voice || id == R.id.btn_full_video_voice) {
            this.isVoice = !this.isVoice;
            setVolume();
            updateVoiceState();
        } else if (id == R.id.btn_full_screen) {
            setFullscreen(!this.isFullScreen);
        } else if (id == R.id.btn_restore_play) {
            if (this.isCompleted) {
                seekTo(0);
                this.mExoPlayer.play();
            }
        } else if (id == R.id.btn_screenshot_tips) {
            this.mHandler.removeMessages(3073);
            this.screenshotTipsLayout.setVisibility(8);
            pictureBrowser(this.mScreenshotPath);
        }
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        this.isSeekBarTouch = true;
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        this.isSeekBarTouch = false;
        int progress = seekBar.getProgress();
        if (this.mExoPlayer.getDuration() > 0) {
            seekTo((((long) progress) * this.mExoPlayer.getDuration()) / 100);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        changeScreenView(configuration.orientation == 2);
    }

    private void initPlayer() {
        this.mExoPlayer = new SimpleExoPlayer.Builder(this, new HSExoRenderersFactory(this, new VideoDecoderOutputBufferRenderer() {
            /* class com.hs.cloudvideo.HSBaseVideoActivity.AnonymousClass1 */

            public final void setOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
                if (videoDecoderOutputBuffer != null && videoDecoderOutputBuffer.data != null) {
                    videoDecoderOutputBuffer.data.position(0);
                    if (videoDecoderOutputBuffer.data.remaining() <= 0) {
                        videoDecoderOutputBuffer.release();
                        return;
                    }
                    final String str = videoDecoderOutputBuffer.videoParams;
                    final int i = videoDecoderOutputBuffer.width;
                    final int i2 = videoDecoderOutputBuffer.height;
                    final long j = videoDecoderOutputBuffer.timestamp;
                    final byte[] bArr = new byte[videoDecoderOutputBuffer.data.remaining()];
                    videoDecoderOutputBuffer.data.get(bArr, 0, bArr.length);
                    videoDecoderOutputBuffer.videoParams = null;
                    videoDecoderOutputBuffer.release();
                    HSBaseVideoActivity.this.runOnUiThread(new Runnable() {
                        /* class com.hs.cloudvideo.HSBaseVideoActivity.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            if (HSBaseVideoActivity.this.mVideoView != null) {
                                HSBaseVideoActivity.this.stopLoading();
                                HSBaseVideoActivity.this.tvErrorMsg.setVisibility(8);
                                if (str != null) {
                                    HSBaseVideoActivity.this.mVideoView.setCamParam(str);
                                }
                                if (!HSBaseVideoActivity.this.isPlaySucceed) {
                                    if (!(HSBaseVideoActivity.this.mVideoView.getCamType() == 1 || HSBaseVideoActivity.this.mVideoView.getCamType() == 2)) {
                                        HSBaseVideoActivity.this.tvTimeOsd.setVisibility(8);
                                    }
                                    if (HSBaseVideoActivity.this.mVideoView.getCamType() == -1 && HSVideoView.getPanoType() != -1) {
                                        HSBaseVideoActivity.this.mVideoView.O000000o(HSVideoView.getPanoType(), HSVideoView.getPanoX(), HSVideoView.getPanoY(), HSVideoView.getPanoR());
                                    }
                                    HSBaseVideoActivity.this.showFixSelectorLayout();
                                }
                                HSBaseVideoActivity.this.isPlaySucceed = true;
                                HSBaseVideoActivity.this.mVideoView.setTimestamp_ms(j);
                                HSBaseVideoActivity.this.mVideoView.O000000o(bArr, i, i2);
                                if (!HSBaseVideoActivity.this.tvTimeOsd.getText().toString().equals(HSBaseVideoActivity.this.mVideoView.getTimeOsd()) && HSBaseVideoActivity.this.tvTimeOsd.getVisibility() == 0) {
                                    HSBaseVideoActivity.this.tvTimeOsd.setText(HSBaseVideoActivity.this.mVideoView.getTimeOsd());
                                }
                                HSBaseVideoActivity.this.updateProgress(HSBaseVideoActivity.this.mExoPlayer.getCurrentPosition());
                            }
                        }
                    });
                }
            }
        })).build();
        this.mExoPlayer.setPlayWhenReady(true);
        setVolume();
        this.mExoPlayer.setPlaybackSpeed((float) this.playSpeed);
        this.mExoPlayer.addListener(new Player.EventListener() {
            /* class com.hs.cloudvideo.HSBaseVideoActivity.AnonymousClass2 */

            public final void onLoadingChanged(boolean z) {
            }

            public final void onPlayWhenReadyChanged(boolean z, int i) {
            }

            public final void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            }

            public final void onPlaybackSpeedChanged(float f) {
            }

            public final void onPlaybackSuppressionReasonChanged(int i) {
            }

            public final void onPlayerStateChanged(boolean z, int i) {
            }

            public final void onPositionDiscontinuity(int i) {
            }

            public final void onRepeatModeChanged(int i) {
            }

            public final void onSeekProcessed() {
            }

            public final void onShuffleModeEnabledChanged(boolean z) {
            }

            public final void onTimelineChanged(Timeline timeline, int i) {
            }

            public final void onTimelineChanged(Timeline timeline, Object obj, int i) {
            }

            public final void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            }

            public final void onIsLoadingChanged(boolean z) {
                if (z) {
                    HSBaseVideoActivity.this.mHandler.postDelayed(new Runnable() {
                        /* class com.hs.cloudvideo.HSBaseVideoActivity.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            if (HSBaseVideoActivity.this.mExoPlayer != null && !HSBaseVideoActivity.this.mExoPlayer.isPlaying() && !HSBaseVideoActivity.this.isLoading() && !HSBaseVideoActivity.this.isClickStop && !HSBaseVideoActivity.this.isCompleted) {
                                HSBaseVideoActivity.this.startLoading();
                            }
                        }
                    }, 1000);
                } else {
                    HSBaseVideoActivity.this.stopLoading();
                }
            }

            public final void onPlaybackStateChanged(int i) {
                if (i == 4) {
                    HSBaseVideoActivity hSBaseVideoActivity = HSBaseVideoActivity.this;
                    hSBaseVideoActivity.isCompleted = true;
                    hSBaseVideoActivity.updateProgress(hSBaseVideoActivity.mExoPlayer.getDuration());
                    HSBaseVideoActivity.this.updatePlayerState();
                } else if (i == 2) {
                    HSBaseVideoActivity.this.startLoading();
                }
            }

            public final void onIsPlayingChanged(boolean z) {
                if (z) {
                    HSBaseVideoActivity hSBaseVideoActivity = HSBaseVideoActivity.this;
                    hSBaseVideoActivity.isCompleted = false;
                    hSBaseVideoActivity.isClickStop = false;
                    hSBaseVideoActivity.stopLoading();
                    HSBaseVideoActivity.this.updatePlayerState();
                }
            }

            public final void onPlayerError(ExoPlaybackException exoPlaybackException) {
                HSBaseVideoActivity.this.stopLoading();
                HSBaseVideoActivity.this.tvErrorMsg.setVisibility(0);
                HSBaseVideoActivity.this.tvErrorMsg.setText(exoPlaybackException.getMessage());
            }
        });
        this.mVideoView.setOnVideoViewListener(new HSVideoView.O000000o() {
            /* class com.hs.cloudvideo.HSBaseVideoActivity.AnonymousClass3 */

            public final void onVideoViewClick() {
                if (HSBaseVideoActivity.this.fixSelectorLayout.getVisibility() == 0 || HSBaseVideoActivity.this.modeSelectorLayout.getVisibility() == 0) {
                    HSBaseVideoActivity.this.hideFixSelectorLayout();
                    HSBaseVideoActivity.this.hideModeSelectorLayout();
                } else if (!HSBaseVideoActivity.this.isFullScreen && HSBaseVideoActivity.this.isPlaySucceed) {
                    HSBaseVideoActivity.this.showFixSelectorLayout();
                }
                if (!HSBaseVideoActivity.this.isFullScreen) {
                    return;
                }
                if (HSBaseVideoActivity.this.videoProgressLayout.getVisibility() == 0) {
                    HSBaseVideoActivity.this.videoProgressLayout.setVisibility(8);
                } else {
                    HSBaseVideoActivity.this.videoProgressLayout.setVisibility(0);
                }
            }
        });
    }

    private void releasePlayer() {
        this.mExoPlayer.release();
        this.mExoPlayer = null;
        this.mVideoView.O0000Oo();
        this.mVideoView = null;
    }

    private void startPlay(String str) {
        this.mExoPlayer.setMediaSource(buildMediaSource(this, str, getPlayHeads()));
        this.mExoPlayer.prepare();
    }

    private void seekTo(long j) {
        if (!isLoading() && j >= 0) {
            startLoading();
            this.isCompleted = false;
            this.isClickStop = false;
            this.btnRestore.setVisibility(8);
            SimpleExoPlayer simpleExoPlayer = this.mExoPlayer;
            simpleExoPlayer.seekTo(simpleExoPlayer.getCurrentWindowIndex(), j);
            if (!this.mExoPlayer.isPlaying()) {
                this.mExoPlayer.play();
            }
        }
    }

    private void setVolume() {
        this.mExoPlayer.setVolume(this.isVoice ? 1.0f : 0.0f);
    }

    private void doScreenshot() {
        this.mHandler.removeMessages(3073);
        this.screenshotTipsLayout.setVisibility(8);
        Bitmap O00000o0 = this.mVideoView.O00000o0();
        if (O00000o0 != null) {
            String screenshotPath = getScreenshotPath();
            if (saveBitmapToDisk(O00000o0, screenshotPath)) {
                HSMediaStoreUtils.O000000o(this, screenshotPath, this.deviceDid, screenshotPath.substring(screenshotPath.lastIndexOf("/") + 1));
                showScreenshotTips(screenshotPath);
            }
        }
    }

    public void updateProgress(long j) {
        long duration = this.mExoPlayer.getDuration();
        if (duration > 0 && j <= duration) {
            int i = (int) ((100 * j) / duration);
            String formatTime = formatTime(j);
            String formatTime2 = formatTime(duration);
            if (!formatTime.equals(this.tvPosition.getText().toString())) {
                this.tvPosition.setText(formatTime);
            }
            if (!formatTime2.equals(this.tvDuration.getText().toString())) {
                this.tvDuration.setText(formatTime2);
            }
            if (i != this.sbVideoProgress.getProgress() && !this.isSeekBarTouch) {
                this.sbVideoProgress.setProgress(i);
            }
        }
    }

    public void updatePlayerState() {
        if (this.mExoPlayer.isPlaying()) {
            this.btnPlayStop.setBackgroundResource(R.drawable.replay_btn_stop_white_nor);
        } else {
            this.btnPlayStop.setBackgroundResource(R.drawable.replay_btn_play_white_nor);
        }
        if (this.isCompleted) {
            this.btnRestore.setVisibility(0);
        } else {
            this.btnRestore.setVisibility(8);
        }
    }

    private void updateVoiceState() {
        if (this.isVoice) {
            this.btnVoice.setBackgroundResource(R.drawable.preview_btn_voiceon_white_nor);
            this.btnFullVoice.setBackgroundResource(R.drawable.preview_btn_voiceon_white_nor);
            return;
        }
        this.btnVoice.setBackgroundResource(R.drawable.preview_btn_voiceoff_white_nor);
        this.btnFullVoice.setBackgroundResource(R.drawable.preview_btn_voiceoff_white_nor);
    }

    private void changePlaySpeed() {
        int i = this.playSpeed;
        if (i == 1) {
            this.playSpeed = 2;
        } else if (i == 2) {
            this.playSpeed = 1;
        }
        this.mExoPlayer.setPlaybackSpeed((float) this.playSpeed);
        updateSpeedState();
        if (this.playSpeed == 1) {
            this.btnVoice.setEnabled(true);
            this.btnFullVoice.setEnabled(true);
            return;
        }
        this.btnVoice.setEnabled(false);
        this.btnFullVoice.setEnabled(false);
        if (this.isVoice) {
            this.isVoice = false;
            setVolume();
            updateVoiceState();
        }
    }

    private void updateSpeedState() {
        int i = this.playSpeed;
        if (i == 1) {
            this.btnSpeed.setText("1X");
        } else if (i == 2) {
            this.btnSpeed.setText("2X");
        }
    }

    private void updateScreenshotTips() {
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams.O0000o = this.mContainer.getId();
        if (this.isFullScreen) {
            layoutParams.O0000Oo = this.videoProgressLayout.getId();
        } else {
            layoutParams.O0000OoO = this.mContainer.getId();
        }
        layoutParams.bottomMargin = dpToPx(getApplicationContext(), 5.0f);
        layoutParams.leftMargin = dpToPx(getApplicationContext(), 8.0f);
        this.screenshotTipsLayout.setLayoutParams(layoutParams);
    }

    private void showModeSelectorLayout() {
        if (this.mVideoView.getCamType() == 1 || this.mVideoView.getCamType() == 2) {
            if (this.mVideoView.getFixType() == 1) {
                this.btnCylinder.setVisibility(8);
                this.btnMultiple.setVisibility(8);
                this.btnDouble.setVisibility(8);
                this.btnFour.setVisibility(8);
                this.btnStretch.setVisibility(0);
            } else {
                this.btnCylinder.setVisibility(0);
                this.btnMultiple.setVisibility(0);
                this.btnDouble.setVisibility(0);
                this.btnFour.setVisibility(0);
                this.btnStretch.setVisibility(8);
            }
            this.btnOriginal.setSelected(false);
            this.btnCylinder.setSelected(false);
            this.btnMultiple.setSelected(false);
            this.btnDouble.setSelected(false);
            this.btnFour.setSelected(false);
            this.btnStretch.setSelected(false);
            this.btnOriginal.setEnabled(true);
            this.btnCylinder.setEnabled(true);
            this.btnMultiple.setEnabled(true);
            this.btnDouble.setEnabled(true);
            this.btnFour.setEnabled(true);
            this.btnStretch.setEnabled(true);
            int mode = this.mVideoView.getMode();
            if (mode == 0) {
                this.btnOriginal.setSelected(true);
                this.btnOriginal.setEnabled(false);
            } else if (mode == 11) {
                this.btnMultiple.setSelected(true);
                this.btnMultiple.setEnabled(false);
            } else if (mode == 3) {
                this.btnCylinder.setSelected(true);
                this.btnCylinder.setEnabled(false);
            } else if (mode == 4) {
                this.btnStretch.setSelected(true);
                this.btnStretch.setEnabled(false);
            } else if (mode == 6) {
                this.btnDouble.setSelected(true);
                this.btnDouble.setEnabled(false);
            } else if (mode == 7) {
                this.btnFour.setSelected(true);
                this.btnFour.setEnabled(false);
            }
            this.modeSelectorLayout.setVisibility(0);
            this.mHandler.removeMessages(3073);
            this.screenshotTipsLayout.setVisibility(8);
        }
    }

    public void hideModeSelectorLayout() {
        this.modeSelectorLayout.setVisibility(8);
    }

    public void showFixSelectorLayout() {
        if (this.mVideoView.getCamType() == 1 || this.mVideoView.getCamType() == 2) {
            if (this.mVideoView.getFixType() == 1) {
                this.btnFixType.setBackgroundResource(R.drawable.replay_btn_installationmode2_nor);
            } else {
                this.btnFixType.setBackgroundResource(R.drawable.replay_btn_installationmode1_nor);
            }
            int i = R.drawable.hs_selector_display_model_1;
            int mode = this.mVideoView.getMode();
            if (mode == 3) {
                i = R.drawable.hs_selector_display_model_2;
            } else if (mode == 4) {
                i = R.drawable.hs_selector_display_model_6;
            } else if (mode == 6) {
                i = R.drawable.hs_selector_display_model_4;
            } else if (mode == 7) {
                i = R.drawable.hs_selector_display_model_5;
            } else if (mode == 11) {
                i = R.drawable.hs_selector_display_model_3;
            }
            this.btnDisplayMode.setBackgroundResource(i);
            this.fixSelectorLayout.setVisibility(0);
        }
    }

    public void hideFixSelectorLayout() {
        this.fixSelectorLayout.setVisibility(8);
    }

    private void setDisplayMode(int i) {
        this.mVideoView.setMode(i);
        showFixSelectorLayout();
        showModeSelectorLayout();
    }

    private void setFullscreen(boolean z) {
        if (z) {
            setRequestedOrientation(0);
        } else {
            setRequestedOrientation(1);
        }
    }

    private void changeScreenView(boolean z) {
        this.isFullScreen = z;
        if (z) {
            getWindow().setFlags(1024, 1024);
            this.assistantLayout.setVisibility(8);
            this.titleBarLayout.setVisibility(8);
            this.bottomMenuLayout.setVisibility(8);
            this.btnFullscreen.setBackgroundResource(R.drawable.preview_btn_exitfullscreen_white_nor);
            this.btnFullVoice.setVisibility(0);
            this.btnFullScreenshot.setVisibility(0);
        } else {
            getWindow().clearFlags(1024);
            this.assistantLayout.setVisibility(0);
            this.titleBarLayout.setVisibility(0);
            this.bottomMenuLayout.setVisibility(0);
            this.btnFullscreen.setBackgroundResource(R.drawable.preview_btn_fullscreen_white_nor);
            this.btnFullVoice.setVisibility(8);
            this.btnFullScreenshot.setVisibility(8);
            this.videoProgressLayout.setVisibility(0);
        }
        changeFullDisplay(z);
        hideModeSelectorLayout();
        hideFixSelectorLayout();
        this.mHandler.removeMessages(3073);
        this.screenshotTipsLayout.setVisibility(8);
        updateScreenshotTips();
    }

    private void changeFullDisplay(boolean z) {
        if ((this.mVideoView.getCamType() != 1 && this.mVideoView.getCamType() != 2) || this.mVideoView.getFixType() == 1) {
            return;
        }
        if (z) {
            this.mVideoView.setMode(12);
            return;
        }
        HSVideoView hSVideoView = this.mVideoView;
        hSVideoView.setMode(hSVideoView.getMode());
    }

    public boolean isLoading() {
        return this.pbLoadingView.getVisibility() == 0 || this.tvErrorMsg.getVisibility() == 0;
    }

    public void startLoading() {
        if (this.pbLoadingView.getVisibility() != 0) {
            this.tvErrorMsg.setVisibility(8);
            this.pbLoadingView.setVisibility(0);
        }
    }

    public void stopLoading() {
        if (this.pbLoadingView.getVisibility() == 0) {
            this.pbLoadingView.setVisibility(8);
        }
    }

    private static String formatTime(long j) {
        long j2 = j / 1000;
        int i = (int) (j2 / 60);
        int i2 = (int) (j2 % 60);
        StringBuilder sb = new StringBuilder();
        sb.append(i < 10 ? "0".concat(String.valueOf(i)) : Integer.valueOf(i));
        sb.append(":");
        sb.append(i2 < 10 ? "0".concat(String.valueOf(i2)) : Integer.valueOf(i2));
        return sb.toString();
    }

    private MediaSource buildMediaSource(Context context, String str, Map<String, String> map) {
        Uri parse = Uri.parse(str);
        if (!TextUtils.isEmpty(parse.getScheme()) && (parse.getScheme().equals("http") || parse.getScheme().equals("https"))) {
            return buildMediaSourceHTTP(context, parse, map);
        }
        if (str.endsWith("m3u8")) {
            return buildMediaSourceLocalHls(parse);
        }
        return buildMediaSourceLocalMp4(parse);
    }

    private MediaSource buildMediaSourceHTTP(Context context, Uri uri, Map<String, String> map) {
        DefaultHttpDataSourceFactory defaultHttpDataSourceFactory = new DefaultHttpDataSourceFactory(Util.getUserAgent(context, "SmartHome;Android"), new DefaultBandwidthMeter());
        if (map != null && map.size() > 0) {
            for (Map.Entry next : map.entrySet()) {
                defaultHttpDataSourceFactory.setDefaultRequestProperty(((String) next.getKey()), ((String) next.getValue()));
            }
        }
        if (uri.getPath() == null || !uri.getPath().endsWith("mp4")) {
            return new HlsMediaSource.Factory(defaultHttpDataSourceFactory).createMediaSource(uri);
        }
        return new ExtractorMediaSource.Factory(defaultHttpDataSourceFactory).createMediaSource(uri);
    }

    private MediaSource buildMediaSourceLocalHls(Uri uri) {
        return new HlsMediaSource.Factory(new FileDataSourceFactory()).createMediaSource(uri);
    }

    private MediaSource buildMediaSourceLocalMp4(Uri uri) {
        return new ExtractorMediaSource.Factory(new FileDataSourceFactory()).createMediaSource(uri);
    }

    private void findId() {
        this.mContainer = (FrameLayout) findViewById(R.id.fl_display_container);
        this.mVideoView = (HSVideoView) findViewById(R.id.hs_video_view);
        this.btnGoBack = (ImageButton) findViewById(R.id.btn_go_back);
        this.tvTimeOsd = (TextView) findViewById(R.id.tv_time_osd);
        this.tvTitle = (TextView) findViewById(R.id.tv_title);
        this.tvErrorMsg = (TextView) findViewById(R.id.tv_error_msg);
        this.assistantLayout = (LinearLayout) findViewById(R.id.layout_assistant);
        this.titleBarLayout = (LinearLayout) findViewById(R.id.layout_title_bar);
        this.modeSelectorLayout = (LinearLayout) findViewById(R.id.layout_pano_mode_selector);
        this.fixSelectorLayout = (LinearLayout) findViewById(R.id.layout_pano_fix_selector);
        this.videoProgressLayout = (LinearLayout) findViewById(R.id.layout_video_progress);
        this.bottomMenuLayout = (LinearLayout) findViewById(R.id.layout_bottom_menu);
        this.screenshotTipsLayout = (LinearLayout) findViewById(R.id.layout_screenshot_tips);
        this.btnFixType = (ImageButton) findViewById(R.id.btn_fix_type);
        this.btnDisplayMode = (ImageButton) findViewById(R.id.btn_pano_mode);
        this.btnOriginal = (ImageButton) findViewById(R.id.btn_mode_original);
        this.btnCylinder = (ImageButton) findViewById(R.id.btn_mode_cylinder);
        this.btnMultiple = (ImageButton) findViewById(R.id.btn_mode_multiple);
        this.btnDouble = (ImageButton) findViewById(R.id.btn_mode_double);
        this.btnFour = (ImageButton) findViewById(R.id.btn_mode_four);
        this.btnStretch = (ImageButton) findViewById(R.id.btn_mode_stretch);
        this.btnVoice = (ImageButton) findViewById(R.id.btn_video_voice);
        this.btnScreenshot = (ImageButton) findViewById(R.id.btn_screenshot);
        this.btnScreenshotTips = (ImageButton) findViewById(R.id.btn_screenshot_tips);
        this.btnPlayStop = (ImageButton) findViewById(R.id.btn_play_stop);
        this.btnFullVoice = (ImageButton) findViewById(R.id.btn_full_video_voice);
        this.btnFullScreenshot = (ImageButton) findViewById(R.id.btn_full_screenshot);
        this.btnFullscreen = (ImageButton) findViewById(R.id.btn_full_screen);
        this.btnRestore = (ImageButton) findViewById(R.id.btn_restore_play);
        this.btnSpeed = (Button) findViewById(R.id.btn_play_speed);
        this.tvPosition = (TextView) findViewById(R.id.tv_video_position);
        this.tvDuration = (TextView) findViewById(R.id.tv_video_duration);
        this.sbVideoProgress = (SeekBar) findViewById(R.id.sb_video_progress);
        this.pbLoadingView = (ProgressBar) findViewById(R.id.pb_loading_view);
        updateVoiceState();
        updateSpeedState();
        updateScreenshotTips();
    }

    private void setListener() {
        this.btnGoBack.setOnClickListener(this);
        this.btnFixType.setOnClickListener(this);
        this.btnDisplayMode.setOnClickListener(this);
        this.btnOriginal.setOnClickListener(this);
        this.btnCylinder.setOnClickListener(this);
        this.btnMultiple.setOnClickListener(this);
        this.btnDouble.setOnClickListener(this);
        this.btnFour.setOnClickListener(this);
        this.btnStretch.setOnClickListener(this);
        this.btnVoice.setOnClickListener(this);
        this.btnScreenshot.setOnClickListener(this);
        this.btnPlayStop.setOnClickListener(this);
        this.btnFullVoice.setOnClickListener(this);
        this.btnFullScreenshot.setOnClickListener(this);
        this.btnFullscreen.setOnClickListener(this);
        this.btnRestore.setOnClickListener(this);
        this.btnSpeed.setOnClickListener(this);
        this.btnScreenshotTips.setOnClickListener(this);
        this.sbVideoProgress.setOnSeekBarChangeListener(this);
    }

    private void showScreenshotTips(String str) {
        this.mScreenshotPath = str;
        this.btnScreenshotTips.setImageURI(Uri.parse(str));
        this.screenshotTipsLayout.setVisibility(0);
        this.mHandler.sendEmptyMessageDelayed(3073, 3000);
    }

    private void showScreenshotTips(Uri uri) {
        this.btnScreenshotTips.setImageURI(uri);
        this.screenshotTipsLayout.setVisibility(0);
        this.mHandler.sendEmptyMessageDelayed(3073, 3000);
    }

    private static String parseM3U8Folder(String str) {
        File[] listFiles;
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null) {
                return null;
            }
            for (File file2 : listFiles) {
                if (file2.getAbsolutePath().endsWith("plain.m3u8")) {
                    return file2.getAbsolutePath();
                }
            }
        }
        return null;
    }

    private static int dpToPx(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0045 A[SYNTHETIC, Splitter:B:22:0x0045] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0050 A[SYNTHETIC, Splitter:B:28:0x0050] */
    private static boolean saveBitmapToDisk(Bitmap bitmap, String str) {
        if (bitmap == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(new File(str));
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream2);
                fileOutputStream2.flush();
                try {
                    fileOutputStream2.close();
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                    return true;
                }
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = fileOutputStream2;
                try {
                    Log.i("HSCloudVideoActivity", "saveBitmapToDisk: exception = " + e.toString());
                    if (fileOutputStream != null) {
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            Log.i("HSCloudVideoActivity", "saveBitmapToDisk: exception = " + e.toString());
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            return false;
        }
    }

    class O000000o implements Handler.Callback {
        private O000000o() {
        }

        /* synthetic */ O000000o(HSBaseVideoActivity hSBaseVideoActivity, byte b) {
            this();
        }

        public final boolean handleMessage(Message message) {
            if (message.what != 3073) {
                return false;
            }
            HSBaseVideoActivity.this.screenshotTipsLayout.setVisibility(8);
            return false;
        }
    }
}
