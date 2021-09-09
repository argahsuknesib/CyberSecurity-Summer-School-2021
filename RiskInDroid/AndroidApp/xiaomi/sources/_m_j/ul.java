package _m_j;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import com.brentvatne.exoplayer.ExoPlayerView;
import com.brentvatne.receiver.AudioBecomingNoisyReceiver;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MergingMediaSource;
import com.google.android.exoplayer2.source.SingleSampleMediaSource;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.dash.DefaultDashChunkSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.source.smoothstreaming.DefaultSsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.upstream.FileDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.xiaomi.smarthome.R;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

@SuppressLint({"ViewConstructor"})
public class ul extends FrameLayout implements un, AudioManager.OnAudioFocusChangeListener, LifecycleEventListener, Player.EventListener, MetadataOutput, BandwidthMeter.EventListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final DefaultBandwidthMeter f2534O000000o = new DefaultBandwidthMeter();
    private static final CookieManager O000O0Oo;
    boolean O00000Oo = false;
    PlayerControlView O00000o;
    public final um O00000o0;
    public View O00000oO;
    public Player.EventListener O00000oo;
    public ExoPlayerView O0000O0o;
    public SimpleExoPlayer O0000OOo;
    public boolean O0000Oo;
    public DefaultTrackSelector O0000Oo0;
    public int O0000OoO;
    public long O0000Ooo;
    public long O0000o = -9223372036854775807L;
    public boolean O0000o0;
    public boolean O0000o00;
    public float O0000o0O = 1.0f;
    public int O0000o0o = 0;
    public int O0000oO = 50000;
    public int O0000oO0 = 50000;
    public int O0000oOO = 2500;
    public int O0000oOo = 5000;
    public String O0000oo;
    public Uri O0000oo0;
    boolean O0000ooO;
    public float O0000ooo = 250.0f;
    public boolean O000O00o = false;
    private boolean O000O0o;
    private DataSource.Factory O000O0o0;
    private boolean O000O0oO;
    private boolean O000O0oo;
    private String O000OO;
    private float O000OO00 = 1.0f;
    private int O000OO0o = 3;
    private Dynamic O000OOOo;
    private Dynamic O000OOo;
    private String O000OOo0;
    private String O000OOoO;
    private Dynamic O000OOoo;
    private boolean O000Oo0;
    private ReadableArray O000Oo00;
    private boolean O000Oo0O = false;
    private Map<String, String> O000Oo0o;
    private final AudioManager O000OoO;
    private boolean O000OoO0 = false;
    private final Handler O000OoOO = new Handler() {
        /* class _m_j.ul.AnonymousClass1 */

        public final void handleMessage(Message message) {
            if (message.what == 1 && ul.this.O0000OOo != null && ul.this.O0000OOo.getPlaybackState() == 3 && ul.this.O0000OOo.getPlayWhenReady()) {
                long currentPosition = ul.this.O0000OOo.getCurrentPosition();
                um umVar = ul.this.O00000o0;
                double d = (double) currentPosition;
                double bufferedPercentage = (double) ((((long) ul.this.O0000OOo.getBufferedPercentage()) * ul.this.O0000OOo.getDuration()) / 100);
                double duration = (double) ul.this.O0000OOo.getDuration();
                WritableMap createMap = Arguments.createMap();
                Double.isNaN(d);
                createMap.putDouble("currentTime", d / 1000.0d);
                Double.isNaN(bufferedPercentage);
                createMap.putDouble("playableDuration", bufferedPercentage / 1000.0d);
                Double.isNaN(duration);
                createMap.putDouble("seekableDuration", duration / 1000.0d);
                umVar.O000000o("onVideoProgress", createMap);
                sendMessageDelayed(obtainMessage(1), (long) Math.round(ul.this.O0000ooo));
            }
        }
    };
    private final ThemedReactContext O00O0Oo;
    private Handler O00oOoOo;
    public boolean O00oOooO;
    public final AudioBecomingNoisyReceiver O00oOooo;

    public boolean O000000o() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean O000000o(Uri uri) {
        return false;
    }

    public /* synthetic */ void onIsLoadingChanged(boolean z) {
        Player.EventListener.CC.$default$onIsLoadingChanged(this, z);
    }

    public /* synthetic */ void onIsPlayingChanged(boolean z) {
        Player.EventListener.CC.$default$onIsPlayingChanged(this, z);
    }

    public void onLoadingChanged(boolean z) {
    }

    public /* synthetic */ void onPlayWhenReadyChanged(boolean z, int i) {
        Player.EventListener.CC.$default$onPlayWhenReadyChanged(this, z, i);
    }

    public /* synthetic */ void onPlaybackSpeedChanged(float f) {
        Player.EventListener.CC.$default$onPlaybackSpeedChanged(this, f);
    }

    public /* synthetic */ void onPlaybackStateChanged(int i) {
        Player.EventListener.CC.$default$onPlaybackStateChanged(this, i);
    }

    public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
        Player.EventListener.CC.$default$onPlaybackSuppressionReasonChanged(this, i);
    }

    public void onRepeatModeChanged(int i) {
    }

    public void onShuffleModeEnabledChanged(boolean z) {
    }

    public /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
        Player.EventListener.CC.$default$onTimelineChanged(this, timeline, i);
    }

    public void onTimelineChanged(Timeline timeline, Object obj, int i) {
    }

    public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
    }

    static {
        CookieManager cookieManager = new CookieManager();
        O000O0Oo = cookieManager;
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ORIGINAL_SERVER);
    }

    public ul(ThemedReactContext themedReactContext) {
        super(themedReactContext);
        this.O00O0Oo = themedReactContext;
        this.O00000o0 = new um(themedReactContext);
        O0000Oo();
        this.O000O0o0 = O000000o(true);
        this.O00oOoOo = new Handler();
        CookieHandler cookieHandler = CookieHandler.getDefault();
        CookieManager cookieManager = O000O0Oo;
        if (cookieHandler != cookieManager) {
            CookieHandler.setDefault(cookieManager);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.O0000O0o = new ExoPlayerView(getContext());
        this.O0000O0o.setLayoutParams(layoutParams);
        addView(this.O0000O0o, 0, layoutParams);
        this.O000OoO = (AudioManager) themedReactContext.getSystemService("audio");
        this.O00O0Oo.addLifecycleEventListener(this);
        this.O00oOooo = new AudioBecomingNoisyReceiver(this.O00O0Oo);
        O00000Oo();
    }

    public ExoPlayerView getExoPlayerView() {
        return this.O0000O0o;
    }

    public void setId(int i) {
        super.setId(i);
        this.O00000o0.f2539O000000o = i;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        O00000Oo();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void onHostResume() {
        if (!this.O000Oo0O || !this.O000O0oO) {
            setPlayWhenReady(!this.O0000o0);
        }
        this.O000O0oO = false;
    }

    public void onHostPause() {
        this.O000O0oO = true;
        if (!this.O000Oo0O) {
            setPlayWhenReady(false);
        }
    }

    public void onHostDestroy() {
        O00000oO();
    }

    public void onBandwidthSample(int i, long j, long j2) {
        if (this.O000OoO0) {
            um umVar = this.O00000o0;
            double d = (double) j2;
            WritableMap createMap = Arguments.createMap();
            createMap.putDouble("bitrate", d);
            umVar.O000000o("onVideoBandwidthUpdate", createMap);
        }
    }

    public final void O000000o(View view) {
        if (view != null) {
            view.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
            view.layout(view.getLeft(), view.getTop(), view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    public final void O00000Oo() {
        new Handler().postDelayed(new Runnable() {
            /* class _m_j.ul.AnonymousClass4 */

            public final void run() {
                if (ul.this.O0000OOo == null) {
                    ul.this.O0000Oo0 = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(ul.f2534O000000o));
                    ul.this.O0000Oo0.setParameters(ul.this.O0000Oo0.buildUponParameters().setMaxVideoBitrate(ul.this.O0000o0o == 0 ? Integer.MAX_VALUE : ul.this.O0000o0o));
                    DefaultLoadControl defaultLoadControl = new DefaultLoadControl(new DefaultAllocator(true, 65536), ul.this.O0000oO0, ul.this.O0000oO, ul.this.O0000oOO, ul.this.O0000oOo, -1, true);
                    uk ukVar = new uk(ul.this.getContext(), ul.this.O000000o() || ul.this.O000O00o);
                    ul ulVar = ul.this;
                    ulVar.O0000OOo = ExoPlayerFactory.newSimpleInstance(ulVar.getContext(), ukVar, ul.this.O0000Oo0, defaultLoadControl);
                    ul.this.O0000OOo.addListener(this);
                    ul.this.O0000OOo.setMetadataOutput(this);
                    ul.this.O0000O0o.setPlayer(ul.this.O0000OOo);
                    AudioBecomingNoisyReceiver audioBecomingNoisyReceiver = ul.this.O00oOooo;
                    audioBecomingNoisyReceiver.O00000Oo = this;
                    audioBecomingNoisyReceiver.f3570O000000o.registerReceiver(audioBecomingNoisyReceiver, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
                    ul.f2534O000000o.addEventListener(new Handler(), this);
                    ul ulVar2 = ul.this;
                    ulVar2.setPlayWhenReady(!ulVar2.O0000o0);
                    ul ulVar3 = ul.this;
                    ulVar3.O0000Oo = true;
                    ul.this.O0000OOo.setPlaybackParameters(new PlaybackParameters(ulVar3.O0000o0O));
                    Log.d("ReactExoplayerView", "initializePlayer isPaused:" + ul.this.O0000o0);
                }
                if (ul.this.O0000Oo && ul.this.O0000oo0 != null) {
                    ArrayList<MediaSource> O00000o0 = ul.this.O00000o0();
                    ul ulVar4 = ul.this;
                    MediaSource O000000o2 = ulVar4.O000000o(ulVar4.O0000oo0, ul.this.O0000oo);
                    if (O00000o0.size() != 0) {
                        O00000o0.add(0, O000000o2);
                        O000000o2 = new MergingMediaSource((MediaSource[]) O00000o0.toArray(new MediaSource[O00000o0.size()]));
                    }
                    boolean z = ul.this.O0000OoO != -1;
                    if (z) {
                        ul.this.O0000OOo.seekTo(ul.this.O0000OoO, ul.this.O0000Ooo);
                    }
                    ul.this.O0000OOo.prepare(O000000o2, !z, false);
                    ul ulVar5 = ul.this;
                    ulVar5.O0000Oo = false;
                    ulVar5.O00000o0.O000000o("onVideoLoadStart", null);
                    ul.this.O0000o00 = true;
                }
                ul ulVar6 = ul.this;
                if (ulVar6.O00000o == null) {
                    ulVar6.O00000o = new PlayerControlView(ulVar6.getContext());
                }
                ulVar6.O00000o.setPlayer(ulVar6.O0000OOo);
                ulVar6.O00000o.show();
                ulVar6.O00000oO = ulVar6.O00000o.findViewById(R.id.exo_play_pause_container);
                ulVar6.O0000O0o.setOnClickListener(new View.OnClickListener() {
                    /* class _m_j.ul.AnonymousClass2 */

                    public final void onClick(View view) {
                        ul ulVar = ul.this;
                        if (ulVar.O0000OOo != null) {
                            ulVar.O000000o(ulVar.O00000o);
                            if (ulVar.O00000o.isVisible()) {
                                ulVar.O00000o.hide();
                            } else {
                                ulVar.O00000o.show();
                            }
                        }
                    }
                });
                ulVar6.O00000oo = new Player.EventListener() {
                    /* class _m_j.ul.AnonymousClass3 */

                    public /* synthetic */ void onIsLoadingChanged(boolean z) {
                        Player.EventListener.CC.$default$onIsLoadingChanged(this, z);
                    }

                    public /* synthetic */ void onIsPlayingChanged(boolean z) {
                        Player.EventListener.CC.$default$onIsPlayingChanged(this, z);
                    }

                    @Deprecated
                    public /* synthetic */ void onLoadingChanged(boolean z) {
                        Player.EventListener.CC.$default$onLoadingChanged(this, z);
                    }

                    public /* synthetic */ void onPlayWhenReadyChanged(boolean z, int i) {
                        Player.EventListener.CC.$default$onPlayWhenReadyChanged(this, z, i);
                    }

                    @Deprecated
                    public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
                        Player.EventListener.CC.$default$onPlaybackParametersChanged(this, playbackParameters);
                    }

                    public /* synthetic */ void onPlaybackSpeedChanged(float f) {
                        Player.EventListener.CC.$default$onPlaybackSpeedChanged(this, f);
                    }

                    public /* synthetic */ void onPlaybackStateChanged(int i) {
                        Player.EventListener.CC.$default$onPlaybackStateChanged(this, i);
                    }

                    public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
                        Player.EventListener.CC.$default$onPlaybackSuppressionReasonChanged(this, i);
                    }

                    public /* synthetic */ void onPlayerError(ExoPlaybackException exoPlaybackException) {
                        Player.EventListener.CC.$default$onPlayerError(this, exoPlaybackException);
                    }

                    public /* synthetic */ void onPositionDiscontinuity(int i) {
                        Player.EventListener.CC.$default$onPositionDiscontinuity(this, i);
                    }

                    public /* synthetic */ void onRepeatModeChanged(int i) {
                        Player.EventListener.CC.$default$onRepeatModeChanged(this, i);
                    }

                    public /* synthetic */ void onSeekProcessed() {
                        Player.EventListener.CC.$default$onSeekProcessed(this);
                    }

                    public /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
                        Player.EventListener.CC.$default$onShuffleModeEnabledChanged(this, z);
                    }

                    public /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
                        Player.EventListener.CC.$default$onTimelineChanged(this, timeline, i);
                    }

                    @Deprecated
                    public /* synthetic */ void onTimelineChanged(Timeline timeline, Object obj, int i) {
                        Player.EventListener.CC.$default$onTimelineChanged(this, timeline, obj, i);
                    }

                    public /* synthetic */ void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
                        Player.EventListener.CC.$default$onTracksChanged(this, trackGroupArray, trackSelectionArray);
                    }

                    public final void onPlayerStateChanged(boolean z, int i) {
                        ul ulVar = ul.this;
                        ulVar.O000000o(ulVar.O00000oO);
                        if (ul.this.O0000OOo != null) {
                            ul.this.O0000OOo.removeListener(ul.this.O00000oo);
                        }
                    }
                };
                ulVar6.O0000OOo.addListener(ulVar6.O00000oo);
                ul ulVar7 = ul.this;
                ulVar7.setControls(ulVar7.O00oOooO);
                ul ulVar8 = ul.this;
                ulVar8.setRepeatModifier(ulVar8.O0000ooO);
                ulVar8.setMutedModifier(ulVar8.O00000Oo);
            }
        }, 1);
    }

    public final MediaSource O000000o(Uri uri, String str) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            str2 = ".".concat(String.valueOf(str));
        } else {
            str2 = uri.getLastPathSegment();
        }
        int inferContentType = Util.inferContentType(str2);
        if (O000000o(uri)) {
            inferContentType = 17;
        }
        if (inferContentType == 0) {
            return new DashMediaSource(uri, O000000o(false), new DefaultDashChunkSource.Factory(this.O000O0o0), this.O000OO0o, DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS, this.O00oOoOo, null);
        } else if (inferContentType == 1) {
            return new SsMediaSource(uri, O000000o(false), new DefaultSsChunkSource.Factory(this.O000O0o0), this.O000OO0o, DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS, this.O00oOoOo, null);
        } else if (inferContentType == 2) {
            return new HlsMediaSource.Factory(this.O000O0o0).createMediaSource(uri);
        } else {
            if (inferContentType == 3) {
                return new ExtractorMediaSource(uri, this.O000O0o0, new DefaultExtractorsFactory(), this.O00oOoOo, null);
            } else if (inferContentType == 17) {
                return O000000o(this.O00O0Oo, uri);
            } else {
                throw new IllegalStateException("Unsupported type: ".concat(String.valueOf(inferContentType)));
            }
        }
    }

    private MediaSource O000000o(ThemedReactContext themedReactContext, Uri uri) {
        if (!(themedReactContext == null || uri == null)) {
            try {
                if (!TextUtils.isEmpty(uri.getScheme()) && (uri.getScheme().equals("http") || uri.getScheme().equals("https"))) {
                    return new HlsMediaSource.Factory(this.O000O0o0).createMediaSource(uri);
                }
                if (uri != null && uri.getPath().endsWith(".m3u8")) {
                    return new HlsMediaSource.Factory(this.O000O0o0).createMediaSource(uri);
                }
                return new ExtractorMediaSource(uri, this.O000O0o0, new DefaultExtractorsFactory(), null, null);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final ArrayList<MediaSource> O00000o0() {
        String str;
        ArrayList<MediaSource> arrayList = new ArrayList<>();
        if (this.O000Oo00 == null) {
            return arrayList;
        }
        for (int i = 0; i < this.O000Oo00.size(); i++) {
            ReadableMap map = this.O000Oo00.getMap(i);
            String string = map.getString("language");
            if (map.hasKey("title")) {
                str = map.getString("title");
            } else {
                str = string + " " + i;
            }
            arrayList.add(new SingleSampleMediaSource(Uri.parse(map.getString("uri")), this.O000O0o0, Format.createTextSampleFormat(str, map.getString("type"), -1, string), -9223372036854775807L));
        }
        return arrayList;
    }

    public final void O00000o() {
        if (this.O0000OOo != null) {
            O0000Oo0();
            this.O0000OOo.release();
            this.O0000OOo.setMetadataOutput(null);
            this.O0000Oo0 = null;
            this.O0000OOo = null;
        }
        this.O000OoOO.removeMessages(1);
        this.O00O0Oo.removeLifecycleEventListener(this);
        AudioBecomingNoisyReceiver audioBecomingNoisyReceiver = this.O00oOooo;
        audioBecomingNoisyReceiver.O00000Oo = un.O000O0OO;
        try {
            audioBecomingNoisyReceiver.f3570O000000o.unregisterReceiver(audioBecomingNoisyReceiver);
        } catch (Exception unused) {
        }
        f2534O000000o.removeEventListener(this);
    }

    public void setPlayWhenReady(boolean z) {
        SimpleExoPlayer simpleExoPlayer = this.O0000OOo;
        if (simpleExoPlayer != null) {
            boolean z2 = false;
            if (z) {
                if (this.O000Oo0 || this.O0000oo0 == null || this.O000OoO.requestAudioFocus(this, 3, 1) == 1) {
                    z2 = true;
                }
                if (z2) {
                    this.O0000OOo.setPlayWhenReady(true);
                    return;
                }
                return;
            }
            simpleExoPlayer.setPlayWhenReady(false);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        if (r0 != 4) goto L_0x0028;
     */
    private void O0000O0o() {
        SimpleExoPlayer simpleExoPlayer = this.O0000OOo;
        if (simpleExoPlayer != null) {
            int playbackState = simpleExoPlayer.getPlaybackState();
            if (playbackState != 1) {
                if (playbackState == 2 || playbackState == 3) {
                    if (!this.O0000OOo.getPlayWhenReady()) {
                        setPlayWhenReady(true);
                    }
                }
            }
            O00000Oo();
        } else {
            O00000Oo();
        }
        if (!this.O000Oo0) {
            setKeepScreenOn(true);
        }
    }

    public final void O00000oO() {
        O0000OOo();
        O00000o();
    }

    private void O0000OOo() {
        if (this.O000O0o) {
            setFullscreen(false);
        }
        setKeepScreenOn(false);
        this.O000OoO.abandonAudioFocus(this);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    private void O0000Oo0() {
        this.O0000OoO = this.O0000OOo.getCurrentWindowIndex();
        this.O0000Ooo = this.O0000OOo.isCurrentWindowSeekable() ? Math.max(0L, this.O0000OOo.getCurrentPosition()) : -9223372036854775807L;
    }

    private void O0000Oo() {
        this.O0000OoO = -1;
        this.O0000Ooo = -9223372036854775807L;
    }

    private DataSource.Factory O000000o(boolean z) {
        return uj.O000000o(this.O00O0Oo, z ? f2534O000000o : null, this.O000Oo0o);
    }

    public void onAudioFocusChange(int i) {
        if (i == -1) {
            this.O00000o0.O00000Oo(false);
        } else if (i == 1) {
            this.O00000o0.O00000Oo(true);
        }
        SimpleExoPlayer simpleExoPlayer = this.O0000OOo;
        if (simpleExoPlayer == null) {
            return;
        }
        if (i == -3) {
            if (!this.O00000Oo) {
                simpleExoPlayer.setVolume(this.O000OO00 * 0.8f);
            }
        } else if (i == 1 && !this.O00000Oo) {
            simpleExoPlayer.setVolume(this.O000OO00 * 1.0f);
        }
    }

    public final void O00000oo() {
        this.O00000o0.O000000o("onVideoAudioBecomingNoisy", null);
    }

    public void onPlayerStateChanged(boolean z, int i) {
        String str;
        int i2 = i;
        String str2 = "onStateChanged: playWhenReady=" + z + ", playbackState=";
        if (i2 == 1) {
            str = str2 + "idle";
            this.O00000o0.O000000o("onVideoIdle", null);
        } else if (i2 == 2) {
            str = str2 + "buffering";
            O00000Oo(true);
        } else if (i2 == 3) {
            str = str2 + "ready";
            this.O00000o0.O000000o("onReadyForDisplay", null);
            int i3 = 0;
            O00000Oo(false);
            this.O000OoOO.sendEmptyMessage(1);
            if (this.O0000o00) {
                this.O0000o00 = false;
                O00000Oo(this.O000OO, this.O000OOOo);
                O000000o(this.O000OOo0, this.O000OOo);
                O00000o0(this.O000OOoO, this.O000OOoo);
                Format videoFormat = this.O0000OOo.getVideoFormat();
                int i4 = videoFormat != null ? videoFormat.width : 0;
                if (videoFormat != null) {
                    i3 = videoFormat.height;
                }
                um umVar = this.O00000o0;
                double duration = (double) this.O0000OOo.getDuration();
                double currentPosition = (double) this.O0000OOo.getCurrentPosition();
                WritableArray audioTrackInfo = getAudioTrackInfo();
                WritableArray textTrackInfo = getTextTrackInfo();
                WritableArray videoTrackInfo = getVideoTrackInfo();
                WritableMap createMap = Arguments.createMap();
                Double.isNaN(duration);
                createMap.putDouble("duration", duration / 1000.0d);
                Double.isNaN(currentPosition);
                createMap.putDouble("currentTime", currentPosition / 1000.0d);
                WritableMap createMap2 = Arguments.createMap();
                createMap2.putInt("width", i4);
                createMap2.putInt("height", i3);
                if (i4 > i3) {
                    createMap2.putString("orientation", "landscape");
                } else {
                    createMap2.putString("orientation", "portrait");
                }
                createMap.putMap("naturalSize", createMap2);
                createMap.putArray("videoTracks", videoTrackInfo);
                createMap.putArray("audioTracks", audioTrackInfo);
                createMap.putArray("textTracks", textTrackInfo);
                createMap.putBoolean("canPlayFastForward", true);
                createMap.putBoolean("canPlaySlowForward", true);
                createMap.putBoolean("canPlaySlowReverse", true);
                createMap.putBoolean("canPlayReverse", true);
                createMap.putBoolean("canPlayFastForward", true);
                createMap.putBoolean("canStepBackward", true);
                createMap.putBoolean("canStepForward", true);
                umVar.O000000o("onVideoLoad", createMap);
            }
            PlayerControlView playerControlView = this.O00000o;
            if (playerControlView != null) {
                playerControlView.show();
            }
        } else if (i2 != 4) {
            str = str2 + "unknown";
        } else {
            str = str2 + "ended";
            this.O00000o0.O000000o("onVideoEnd", null);
            O0000OOo();
        }
        Log.d("ReactExoplayerView", str);
    }

    private WritableArray getAudioTrackInfo() {
        WritableArray createArray = Arguments.createArray();
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = this.O0000Oo0.getCurrentMappedTrackInfo();
        int O000000o2 = O000000o(1);
        if (!(currentMappedTrackInfo == null || O000000o2 == -1)) {
            TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(O000000o2);
            for (int i = 0; i < trackGroups.length; i++) {
                Format format = trackGroups.get(i).getFormat(0);
                WritableMap createMap = Arguments.createMap();
                createMap.putInt("index", i);
                String str = "";
                createMap.putString("title", format.id != null ? format.id : str);
                createMap.putString("type", format.sampleMimeType);
                createMap.putString("language", format.language != null ? format.language : str);
                if (format.bitrate != -1) {
                    str = String.format(Locale.US, "%.2fMbps", Float.valueOf(((float) format.bitrate) / 1000000.0f));
                }
                createMap.putString("bitrate", str);
                createArray.pushMap(createMap);
            }
        }
        return createArray;
    }

    private WritableArray getVideoTrackInfo() {
        WritableArray createArray = Arguments.createArray();
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = this.O0000Oo0.getCurrentMappedTrackInfo();
        int O000000o2 = O000000o(2);
        if (!(currentMappedTrackInfo == null || O000000o2 == -1)) {
            TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(O000000o2);
            for (int i = 0; i < trackGroups.length; i++) {
                TrackGroup trackGroup = trackGroups.get(i);
                for (int i2 = 0; i2 < trackGroup.length; i2++) {
                    Format format = trackGroup.getFormat(i2);
                    WritableMap createMap = Arguments.createMap();
                    createMap.putInt("width", format.width == -1 ? 0 : format.width);
                    createMap.putInt("height", format.height == -1 ? 0 : format.height);
                    createMap.putInt("bitrate", format.bitrate == -1 ? 0 : format.bitrate);
                    createMap.putString("codecs", format.codecs != null ? format.codecs : "");
                    createMap.putString("trackId", format.id == null ? String.valueOf(i2) : format.id);
                    createArray.pushMap(createMap);
                }
            }
        }
        return createArray;
    }

    private WritableArray getTextTrackInfo() {
        WritableArray createArray = Arguments.createArray();
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = this.O0000Oo0.getCurrentMappedTrackInfo();
        int O000000o2 = O000000o(3);
        if (!(currentMappedTrackInfo == null || O000000o2 == -1)) {
            TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(O000000o2);
            for (int i = 0; i < trackGroups.length; i++) {
                Format format = trackGroups.get(i).getFormat(0);
                WritableMap createMap = Arguments.createMap();
                createMap.putInt("index", i);
                String str = "";
                createMap.putString("title", format.id != null ? format.id : str);
                createMap.putString("type", format.sampleMimeType);
                if (format.language != null) {
                    str = format.language;
                }
                createMap.putString("language", str);
                createArray.pushMap(createMap);
            }
        }
        return createArray;
    }

    private void O00000Oo(boolean z) {
        if (this.O000O0oo != z) {
            this.O000O0oo = z;
            if (z) {
                this.O00000o0.O000000o(true);
            } else {
                this.O00000o0.O000000o(false);
            }
        }
    }

    public void onPositionDiscontinuity(int i) {
        if (this.O0000Oo) {
            O0000Oo0();
        }
        if (i == 0 && this.O0000OOo.getRepeatMode() == 1) {
            this.O00000o0.O000000o("onVideoEnd", null);
        }
    }

    public void onSeekProcessed() {
        um umVar = this.O00000o0;
        long currentPosition = this.O0000OOo.getCurrentPosition();
        long j = this.O0000o;
        WritableMap createMap = Arguments.createMap();
        double d = (double) currentPosition;
        Double.isNaN(d);
        createMap.putDouble("currentTime", d / 1000.0d);
        double d2 = (double) j;
        Double.isNaN(d2);
        createMap.putDouble("seekTime", d2 / 1000.0d);
        umVar.O000000o("onVideoSeek", createMap);
        this.O0000o = -9223372036854775807L;
    }

    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        um umVar = this.O00000o0;
        float f = playbackParameters.speed;
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("playbackRate", (double) f);
        umVar.O000000o("onPlaybackRateChange", createMap);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e7  */
    public void onPlayerError(ExoPlaybackException exoPlaybackException) {
        Exception exc;
        String str = null;
        boolean z = false;
        if (exoPlaybackException.type == 1) {
            Exception rendererException = exoPlaybackException.getRendererException();
            if (!this.O000O00o && !O000000o() && (rendererException instanceof MediaCodecRenderer.DecoderInitializationException)) {
                Log.d("ReactExoplayerView", "DecoderInitializationException and trans to soft decoder");
                this.O000O00o = true;
                SimpleExoPlayer simpleExoPlayer = this.O0000OOo;
                if (simpleExoPlayer != null) {
                    simpleExoPlayer.removeListener(this.O00000oo);
                    this.O0000OOo.release();
                    this.O0000OOo = null;
                }
                O0000O0o();
                return;
            } else if (rendererException instanceof MediaCodecRenderer.DecoderInitializationException) {
                MediaCodecRenderer.DecoderInitializationException decoderInitializationException = (MediaCodecRenderer.DecoderInitializationException) rendererException;
                if (decoderInitializationException.mimeType != null) {
                    str = getResources().getString(R.string.error_instantiating_decoder, decoderInitializationException.mimeType);
                } else if (decoderInitializationException.getCause() instanceof MediaCodecUtil.DecoderQueryException) {
                    str = getResources().getString(R.string.error_querying_decoders);
                } else if (decoderInitializationException.secureDecoderRequired) {
                    str = getResources().getString(R.string.error_no_secure_decoder, decoderInitializationException.mimeType);
                } else {
                    str = getResources().getString(R.string.error_no_decoder, decoderInitializationException.mimeType);
                }
            }
        } else if (exoPlaybackException.type == 0) {
            exc = exoPlaybackException.getSourceException();
            str = getResources().getString(R.string.unrecognized_media_format);
            if (str != null) {
                um umVar = this.O00000o0;
                WritableMap createMap = Arguments.createMap();
                createMap.putString("errorString", str);
                createMap.putString("errorException", exc.getMessage());
                WritableMap createMap2 = Arguments.createMap();
                createMap2.putMap("error", createMap);
                umVar.O000000o("onVideoError", createMap2);
            }
            this.O0000Oo = true;
            if (exoPlaybackException.type == 0) {
                Throwable sourceException = exoPlaybackException.getSourceException();
                while (true) {
                    if (sourceException == null) {
                        break;
                    } else if (sourceException instanceof BehindLiveWindowException) {
                        z = true;
                        break;
                    } else {
                        sourceException = sourceException.getCause();
                    }
                }
            }
            if (!z) {
                O0000Oo();
                O00000Oo();
                return;
            }
            O0000Oo0();
            return;
        }
        exc = exoPlaybackException;
        if (str != null) {
        }
        this.O0000Oo = true;
        if (exoPlaybackException.type == 0) {
        }
        if (!z) {
        }
    }

    private int O000000o(int i) {
        int rendererCount = this.O0000OOo.getRendererCount();
        for (int i2 = 0; i2 < rendererCount; i2++) {
            if (this.O0000OOo.getRendererType(i2) == i) {
                return i2;
            }
        }
        return -1;
    }

    public void onMetadata(Metadata metadata) {
        um umVar = this.O00000o0;
        WritableArray createArray = Arguments.createArray();
        for (int i = 0; i < metadata.length(); i++) {
            Id3Frame id3Frame = (Id3Frame) metadata.get(i);
            String str = id3Frame instanceof TextInformationFrame ? ((TextInformationFrame) id3Frame).value : "";
            String str2 = id3Frame.id;
            WritableMap createMap = Arguments.createMap();
            createMap.putString("identifier", str2);
            createMap.putString("value", str);
            createArray.pushMap(createMap);
        }
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putArray("metadata", createArray);
        umVar.O000000o("onTimedMetadata", createMap2);
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:30:0x00b2 */
    /* JADX INFO: additional move instructions added (3) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: com.google.android.exoplayer2.upstream.DefaultDataSourceFactory} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: com.google.android.exoplayer2.upstream.FileDataSourceFactory} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory} */
    /* JADX WARNING: Multi-variable type inference failed */
    public void O000000o(Uri uri, String str, Map<String, String> map) {
        DefaultHttpDataSourceFactory defaultHttpDataSourceFactory;
        if (uri != null) {
            boolean z = this.O0000oo0 == null;
            boolean equals = uri.equals(this.O0000oo0);
            this.O0000oo0 = uri;
            this.O0000oo = str;
            this.O000Oo0o = map;
            if (O000000o(this.O0000oo0)) {
                ThemedReactContext themedReactContext = this.O00O0Oo;
                String uri2 = uri.toString();
                Uri parse = Uri.parse(uri2);
                if (!TextUtils.isEmpty(parse.getScheme()) && (parse.getScheme().equals("http") || parse.getScheme().equals("https"))) {
                    defaultHttpDataSourceFactory = new DefaultHttpDataSourceFactory(Util.getUserAgent(themedReactContext, "SmartHome;Android"), new DefaultBandwidthMeter());
                    defaultHttpDataSourceFactory = defaultHttpDataSourceFactory;
                    if (map != null) {
                        defaultHttpDataSourceFactory = defaultHttpDataSourceFactory;
                        if (map.size() > 0) {
                            for (Map.Entry next : map.entrySet()) {
                                defaultHttpDataSourceFactory.setDefaultRequestProperty(((String) next.getKey()), ((String) next.getValue()));
                            }
                        }
                    }
                } else if (uri2.endsWith("m3u8")) {
                    defaultHttpDataSourceFactory = new FileDataSourceFactory();
                } else {
                    defaultHttpDataSourceFactory = new DefaultDataSourceFactory(this.O00O0Oo, "SmartHome;Android");
                }
                this.O000O0o0 = defaultHttpDataSourceFactory;
            } else {
                this.O000O0o0 = uj.O000000o(this.O00O0Oo, f2534O000000o, this.O000Oo0o);
            }
            if (!z && !equals) {
                O0000OoO();
            }
        }
    }

    public void setProgressUpdateInterval(float f) {
        this.O0000ooo = f;
    }

    public void setReportBandwidth(boolean z) {
        this.O000OoO0 = z;
    }

    public final void O00000Oo(Uri uri, String str) {
        if (uri != null) {
            boolean z = this.O0000oo0 == null;
            boolean equals = uri.equals(this.O0000oo0);
            this.O0000oo0 = uri;
            this.O0000oo = str;
            this.O000O0o0 = O000000o(true);
            if (!z && !equals) {
                O0000OoO();
            }
        }
    }

    public void setTextTracks(ReadableArray readableArray) {
        this.O000Oo00 = readableArray;
        O0000OoO();
    }

    private void O0000OoO() {
        this.O0000Oo = true;
        O00000Oo();
    }

    public void setResizeModeModifier(int i) {
        this.O0000O0o.setResizeMode(i);
    }

    public void setRepeatModifier(boolean z) {
        SimpleExoPlayer simpleExoPlayer = this.O0000OOo;
        if (simpleExoPlayer != null) {
            if (z) {
                simpleExoPlayer.setRepeatMode(1);
            } else {
                simpleExoPlayer.setRepeatMode(0);
            }
        }
        this.O0000ooO = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x011e A[LOOP:4: B:73:0x011a->B:75:0x011e, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x012c  */
    private void O000000o(int i, String str, Dynamic dynamic) {
        int O000000o2;
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo;
        int i2;
        TrackGroup trackGroup;
        int i3;
        if (this.O0000OOo != null && (O000000o2 = O000000o(i)) != -1 && (currentMappedTrackInfo = this.O0000Oo0.getCurrentMappedTrackInfo()) != null) {
            TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(O000000o2);
            int[] iArr = {0};
            if (TextUtils.isEmpty(str)) {
                str = "default";
            }
            DefaultTrackSelector.Parameters build = this.O0000Oo0.getParameters().buildUpon().setRendererDisabled(O000000o2, true).build();
            if (str.equals("disabled")) {
                this.O0000Oo0.setParameters(build);
                return;
            }
            if (str.equals("language")) {
                i2 = 0;
                while (true) {
                    if (i2 >= trackGroups.length) {
                        break;
                    }
                    Format format = trackGroups.get(i2).getFormat(0);
                    if (format.language != null && format.language.equals(dynamic.asString())) {
                        break;
                    }
                    i2++;
                }
                if (i2 == -1 && i == 2 && trackGroups.length != 0) {
                    trackGroup = trackGroups.get(0);
                    iArr = new int[trackGroup.length];
                    for (i3 = 0; i3 < trackGroup.length; i3++) {
                        iArr[i3] = i3;
                    }
                    i2 = 0;
                }
                if (i2 != -1) {
                    this.O0000Oo0.setParameters(build);
                    return;
                } else {
                    this.O0000Oo0.setParameters(this.O0000Oo0.getParameters().buildUpon().setRendererDisabled(O000000o2, false).setSelectionOverride(O000000o2, trackGroups, new DefaultTrackSelector.SelectionOverride(i2, iArr)).build());
                    return;
                }
            } else if (str.equals("title")) {
                int i4 = 0;
                while (true) {
                    if (i2 >= trackGroups.length) {
                        break;
                    }
                    Format format2 = trackGroups.get(i2).getFormat(0);
                    if (format2.id != null && format2.id.equals(dynamic.asString())) {
                        break;
                    }
                    i4 = i2 + 1;
                }
            } else if (!str.equals("index")) {
                if (str.equals("resolution")) {
                    int asInt = dynamic.asInt();
                    int i5 = -1;
                    for (int i6 = 0; i6 < trackGroups.length; i6++) {
                        TrackGroup trackGroup2 = trackGroups.get(i6);
                        int i7 = 0;
                        while (true) {
                            if (i7 >= trackGroup2.length) {
                                break;
                            } else if (trackGroup2.getFormat(i7).height == asInt) {
                                iArr[0] = i7;
                                i5 = i6;
                                break;
                            } else {
                                i7++;
                            }
                        }
                    }
                    i2 = i5;
                } else if (O000000o2 == 3 && Util.SDK_INT > 18) {
                    CaptioningManager captioningManager = (CaptioningManager) this.O00O0Oo.getSystemService("captioning");
                    if (captioningManager != null && captioningManager.isEnabled()) {
                        i2 = O000000o(trackGroups);
                    }
                } else if (O000000o2 == 1) {
                    i2 = O000000o(trackGroups);
                }
                trackGroup = trackGroups.get(0);
                iArr = new int[trackGroup.length];
                while (i3 < trackGroup.length) {
                }
                i2 = 0;
                if (i2 != -1) {
                }
            } else if (dynamic.asInt() < trackGroups.length) {
                i2 = dynamic.asInt();
                trackGroup = trackGroups.get(0);
                iArr = new int[trackGroup.length];
                while (i3 < trackGroup.length) {
                }
                i2 = 0;
                if (i2 != -1) {
                }
            }
            i2 = -1;
            trackGroup = trackGroups.get(0);
            iArr = new int[trackGroup.length];
            while (i3 < trackGroup.length) {
            }
            i2 = 0;
            if (i2 != -1) {
            }
        }
    }

    private static int O000000o(TrackGroupArray trackGroupArray) {
        if (trackGroupArray.length == 0) {
            return -1;
        }
        String language = Locale.getDefault().getLanguage();
        String iSO3Language = Locale.getDefault().getISO3Language();
        for (int i = 0; i < trackGroupArray.length; i++) {
            String str = trackGroupArray.get(i).getFormat(0).language;
            if (str != null && (str.equals(language) || str.equals(iSO3Language))) {
                return i;
            }
        }
        return 0;
    }

    public final void O000000o(String str, Dynamic dynamic) {
        this.O000OOo0 = str;
        this.O000OOo = dynamic;
        O000000o(2, this.O000OOo0, this.O000OOo);
    }

    public final void O00000Oo(String str, Dynamic dynamic) {
        this.O000OO = str;
        this.O000OOOo = dynamic;
        O000000o(1, this.O000OO, this.O000OOOo);
    }

    public final void O00000o0(String str, Dynamic dynamic) {
        this.O000OOoO = str;
        this.O000OOoo = dynamic;
        O000000o(3, this.O000OOoO, this.O000OOoo);
    }

    public void setPausedModifier(boolean z) {
        this.O0000o0 = z;
        SimpleExoPlayer simpleExoPlayer = this.O0000OOo;
        if (simpleExoPlayer == null) {
            return;
        }
        if (!z) {
            O0000O0o();
            return;
        }
        if (simpleExoPlayer != null && simpleExoPlayer.getPlayWhenReady()) {
            setPlayWhenReady(false);
        }
        setKeepScreenOn(false);
    }

    public void setMutedModifier(boolean z) {
        this.O00000Oo = z;
        this.O000OO00 = z ? 0.0f : 1.0f;
        SimpleExoPlayer simpleExoPlayer = this.O0000OOo;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setVolume(this.O000OO00);
        }
    }

    public void setVolumeModifier(float f) {
        this.O000OO00 = f;
        SimpleExoPlayer simpleExoPlayer = this.O0000OOo;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setVolume(this.O000OO00);
        }
    }

    public void setRateModifier(float f) {
        this.O0000o0O = f;
        if (this.O0000OOo != null) {
            this.O0000OOo.setPlaybackParameters(new PlaybackParameters(this.O0000o0O));
        }
    }

    public void setMaxBitRateModifier(int i) {
        this.O0000o0o = i;
        if (this.O0000OOo != null) {
            DefaultTrackSelector defaultTrackSelector = this.O0000Oo0;
            DefaultTrackSelector.ParametersBuilder buildUponParameters = defaultTrackSelector.buildUponParameters();
            int i2 = this.O0000o0o;
            if (i2 == 0) {
                i2 = Integer.MAX_VALUE;
            }
            defaultTrackSelector.setParameters(buildUponParameters.setMaxVideoBitrate(i2));
        }
    }

    public void setMinLoadRetryCountModifier(int i) {
        this.O000OO0o = i;
        O00000o();
        O00000Oo();
    }

    public void setPlayInBackground(boolean z) {
        this.O000Oo0O = z;
    }

    public void setDisableFocus(boolean z) {
        this.O000Oo0 = z;
    }

    public void setFullscreen(boolean z) {
        if (z != this.O000O0o) {
            this.O000O0o = z;
            Activity currentActivity = this.O00O0Oo.getCurrentActivity();
            if (currentActivity != null) {
                View decorView = currentActivity.getWindow().getDecorView();
                if (this.O000O0o) {
                    int i = Util.SDK_INT >= 19 ? 4102 : 6;
                    this.O00000o0.O000000o("onVideoFullscreenPlayerWillPresent", null);
                    decorView.setSystemUiVisibility(i);
                    this.O00000o0.O000000o("onVideoFullscreenPlayerDidPresent", null);
                    return;
                }
                this.O00000o0.O000000o("onVideoFullscreenPlayerWillDismiss", null);
                decorView.setSystemUiVisibility(0);
                this.O00000o0.O000000o("onVideoFullscreenPlayerDidDismiss", null);
            }
        }
    }

    public void setUseTextureView(boolean z) {
        this.O0000O0o.setUseTextureView(z);
    }

    public void setHideShutterView(boolean z) {
        this.O0000O0o.setHideShutterView(z);
    }

    public void setControls(boolean z) {
        this.O00oOooO = z;
        SimpleExoPlayer simpleExoPlayer = this.O0000OOo;
        if (simpleExoPlayer != null && this.O0000O0o != null) {
            if (!z) {
                int indexOfChild = indexOfChild(this.O00000o);
                if (indexOfChild != -1) {
                    removeViewAt(indexOfChild);
                }
            } else if (simpleExoPlayer != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                this.O00000o.setLayoutParams(layoutParams);
                int indexOfChild2 = indexOfChild(this.O00000o);
                if (indexOfChild2 != -1) {
                    removeViewAt(indexOfChild2);
                }
                addView(this.O00000o, 1, layoutParams);
            }
        }
    }
}
