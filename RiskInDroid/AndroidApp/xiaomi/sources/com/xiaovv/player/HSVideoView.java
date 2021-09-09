package com.xiaovv.player;

import _m_j.ihs;
import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.hs.hyfisheyepano.GLFisheyeView;
import com.hs.hyfisheyepano.OnPanoParamListener;
import com.hs.hyfisheyepano.OnPlayProgressListener;
import com.hs.hyfisheyepano.OnPlayStateListener;
import com.hs.hyfisheyepano.OnRenderListener;
import com.hs.hyfisheyepano.OnYuvDataListener;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONObject;

public class HSVideoView extends FrameLayout implements View.OnTouchListener {
    public static int O0000o = 0;
    public static int O0000o0o = -1;
    public static int O0000oO;
    public static int O0000oO0;

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f12121O000000o;
    O000000o O00000Oo;
    public OnPlayStateListener O00000o;
    public OnPlayProgressListener O00000o0;
    public OnRenderListener O00000oO;
    public OnPanoParamListener O00000oo;
    public GLFisheyeView O0000O0o;
    public HSMediaPlayer O0000OOo;
    public int O0000Oo;
    public int O0000Oo0;
    public int O0000OoO = -1;
    public int O0000Ooo = 0;
    public boolean O0000o0;
    public boolean O0000o00;
    public boolean O0000o0O;
    private GestureDetector O0000oOO;
    private byte[] O0000oOo;
    private int O0000oo;
    private int O0000oo0;
    private int O0000ooO;
    private int O0000ooo;
    private long O000O00o;
    private boolean O000O0OO;
    private boolean O000O0Oo;
    private String O00oOoOo;
    private int O00oOooO;
    private long O00oOooo;

    public interface O000000o {
        void onVideoViewClick();
    }

    public HSVideoView(Context context) {
        super(context);
        O000000o(context);
    }

    public HSVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context);
    }

    public HSVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(context);
    }

    private void O000000o(Context context) {
        this.f12121O000000o = context;
        this.O0000o0 = true;
        this.O0000O0o = new GLFisheyeView(context);
        this.O0000O0o.setOnTouchListener(this);
        setVisibility(8);
        this.O0000O0o.clearSurface();
        O000000o();
        setKeepScreenOn(true);
        this.O0000oOO = new GestureDetector(context, new O00000Oo(this));
        addView(this.O0000O0o);
        setMode(13);
        this.O0000O0o.setOnRenderListener(new OnRenderListener() {
            /* class com.xiaovv.player.HSVideoView.AnonymousClass1 */

            public final void onRender(int i, int i2) {
                ihs.O000000o("HSVideoView", "onRender: " + i + " " + i2 + " " + HSVideoView.this.getVisibility());
                if (HSVideoView.this.O0000OoO == -1 && HSVideoView.O0000o0o != -1) {
                    HSVideoView hSVideoView = HSVideoView.this;
                    hSVideoView.O0000o0O = false;
                    hSVideoView.O000000o(HSVideoView.O0000o0o, HSVideoView.O0000o, HSVideoView.O0000oO0, HSVideoView.O0000oO);
                }
                if (HSVideoView.this.getVisibility() != 0) {
                    HSVideoView.this.setVisibility(0);
                }
            }
        });
    }

    public final void O000000o() {
        GLFisheyeView gLFisheyeView = this.O0000O0o;
        if (gLFisheyeView != null) {
            gLFisheyeView.resetZoomView();
        }
    }

    public final void O00000Oo() {
        if (this.O0000O0o != null) {
            post(new Runnable() {
                /* class com.xiaovv.player.HSVideoView.AnonymousClass5 */

                public final void run() {
                    HSVideoView.this.setVisibility(8);
                    HSVideoView.this.O0000O0o.clearSurface();
                }
            });
        }
    }

    public void setCamParam(String str) {
        if (str != null) {
            try {
                ihs.O000000o("HSVideoView", "setCamParam: params = ".concat(String.valueOf(str)));
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("camType");
                int optInt2 = jSONObject.optInt("panoX");
                int optInt3 = jSONObject.optInt("panoY");
                int optInt4 = jSONObject.optInt("panoR");
                long optLong = jSONObject.optLong("timestamp");
                O000000o(optInt, optInt2, optInt3, optInt4);
                setTimestamp(optLong);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void O000000o(int i, int i2, int i3, int i4) {
        if (this.O0000O0o != null && !this.O0000o0O && i != -1) {
            ihs.O000000o("HSVideoView", "setCamParam: " + i + " " + i2 + " " + i3 + " " + i4);
            this.O0000o0O = true;
            this.O0000OoO = i;
            this.O0000ooO = i2;
            this.O0000ooo = i3;
            this.O00oOooO = i4;
            int i5 = this.O0000OoO;
            if (i5 == 0) {
                this.O0000ooO = 0;
                this.O0000ooo = 0;
                this.O00oOooO = 0;
                setMode(13);
            } else if (i5 == 1) {
                setMode(0);
                setFixType(1);
            } else if (i5 == 2) {
                setMode(0);
                setFixType(0);
            }
            O0000o0o = i;
            O0000o = this.O0000ooO;
            O0000oO0 = this.O0000ooo;
            O0000oO = this.O00oOooO;
        }
    }

    public void setExternalParams(Map<String, Object> map) {
        if (map != null) {
            if (map.containsKey("logcat")) {
                ihs.O000000o(((Boolean) map.get("logcat")).booleanValue());
            }
            ihs.O000000o("HSVideoView", "setExternalParams: " + map.toString());
            if (map.containsKey("camType") && map.containsKey("panoX") && map.containsKey("panoY") && map.containsKey("panoR")) {
                O000000o((int) ((Double) map.get("camType")).doubleValue(), (int) ((Double) map.get("panoX")).doubleValue(), (int) ((Double) map.get("panoY")).doubleValue(), (int) ((Double) map.get("panoR")).doubleValue());
            }
            if (map.containsKey("fixType")) {
                setFixType((int) ((Double) map.get("fixType")).doubleValue());
            }
            if (map.containsKey("isHasParams")) {
                setHasParams(((Boolean) map.get("isHasParams")).booleanValue());
            }
            if (map.containsKey("displayMode")) {
                setMode((int) ((Double) map.get("displayMode")).doubleValue());
            }
            if (map.containsKey("visibility")) {
                if (((Boolean) map.get("visibility")).booleanValue()) {
                    ihs.O000000o("HSVideoView", "showSurfaceView: ");
                    if (this.O0000O0o != null) {
                        post(new Runnable() {
                            /* class com.xiaovv.player.HSVideoView.AnonymousClass4 */

                            public final void run() {
                                if (HSVideoView.this.O0000O0o != null) {
                                    HSVideoView.this.O0000O0o.setVisibility(0);
                                }
                            }
                        });
                    }
                } else {
                    ihs.O000000o("HSVideoView", "hideSurfaceView: ");
                    if (this.O0000O0o != null) {
                        post(new Runnable() {
                            /* class com.xiaovv.player.HSVideoView.AnonymousClass3 */

                            public final void run() {
                                if (HSVideoView.this.O0000O0o != null) {
                                    HSVideoView.this.O0000O0o.setVisibility(8);
                                }
                            }
                        });
                    }
                }
            }
            if (map.containsKey("source")) {
                setPath((String) map.get("source"));
            }
            if (map.containsKey("isPlaying")) {
                if (((Boolean) map.get("isPlaying")).booleanValue()) {
                    O00000o();
                } else {
                    O0000O0o();
                }
            }
            if (map.containsKey("paused")) {
                if (((Boolean) map.get("paused")).booleanValue()) {
                    O00000oO();
                } else {
                    O00000oo();
                }
            }
            if (map.containsKey("muted")) {
                if (((Boolean) map.get("muted")).booleanValue()) {
                    O0000Oo0();
                } else {
                    O0000OOo();
                }
            }
            if (map.containsKey("isScaleZoom")) {
                setScaleZoom(((Boolean) map.get("isScaleZoom")).booleanValue());
            }
            if (map.containsKey("isFullScale")) {
                setFullScale(((Boolean) map.get("isFullScale")).booleanValue());
            }
        }
    }

    public void setFixType(int i) {
        ihs.O000000o("HSVideoView", "setFixType: type = " + i + " " + this.O0000OoO);
        if (this.O0000OoO >= 0 && this.O0000O0o != null) {
            if (i == 0 || i == 1) {
                this.O0000oo0 = i;
                this.O0000o00 = true;
                if (this.O0000OoO != 0) {
                    setMode(0);
                }
                this.O0000O0o.setImageParam(this.O0000oo0, this.O0000ooO, this.O0000ooo, this.O00oOooO);
            }
        }
    }

    public int getFixType() {
        return this.O0000oo0;
    }

    public void setMode(int i) {
        if (this.O0000O0o != null) {
            ihs.O000000o("HSVideoView", "setMode: mode = ".concat(String.valueOf(i)));
            if (i != 12) {
                this.O0000oo = i;
            }
            this.O0000O0o.setMode(i);
        }
    }

    public int getMode() {
        return this.O0000oo;
    }

    public final void O000000o(byte[] bArr, final int i, final int i2) {
        int i3;
        if (this.O0000O0o != null && bArr != null && bArr.length > 0 && (i3 = i * i2) > 0) {
            if (this.O00000oO != null && this.O0000o0) {
                post(new Runnable() {
                    /* class com.xiaovv.player.HSVideoView.AnonymousClass6 */

                    public final void run() {
                        if (HSVideoView.this.O00000oO != null && HSVideoView.this.O0000o0) {
                            HSVideoView hSVideoView = HSVideoView.this;
                            hSVideoView.O0000o0 = false;
                            hSVideoView.O00000oO.onRender(i, i2);
                        }
                    }
                });
            }
            if (!(!this.O0000o00 && i == this.O0000Oo0 && i2 == this.O0000Oo)) {
                this.O0000Oo0 = i;
                this.O0000Oo = i2;
                int i4 = i / 2;
                int[] iArr = {(i - i2) / 2, i4, i4};
                int[] iArr2 = {i2 / 2, 0, i2};
                int[] iArr3 = {this.O0000ooO};
                int[] iArr4 = {this.O0000ooo};
                int[] iArr5 = {this.O00oOooO};
                if (this.O0000o00) {
                    setMode(0);
                }
                this.O0000o00 = false;
                this.O0000O0o.setImageParam(this.O0000oo0, iArr3[0], iArr4[0], iArr5[0]);
            }
            if ((i3 * 3) / 2 <= bArr.length) {
                this.O0000O0o.setYUVImage(bArr, i, i2, 1);
                this.O0000oOo = bArr;
                this.O000O0Oo = true;
            }
        }
    }

    public final Bitmap O00000o0() {
        if (!this.O000O0Oo || this.O0000oOo == null) {
            return null;
        }
        int i = this.O0000Oo0;
        int i2 = this.O0000Oo;
        if (i * i2 <= 0) {
            return null;
        }
        byte[] bArr = new byte[(i * i2)];
        byte[] bArr2 = new byte[((i * i2) / 4)];
        byte[] bArr3 = new byte[((i * i2) / 4)];
        byte[] bArr4 = new byte[(i * i2 * 3)];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        ByteBuffer wrap2 = ByteBuffer.wrap(bArr2);
        ByteBuffer wrap3 = ByteBuffer.wrap(bArr3);
        ByteBuffer wrap4 = ByteBuffer.wrap(bArr4);
        wrap.put(this.O0000oOo, 0, this.O0000Oo0 * this.O0000Oo);
        byte[] bArr5 = this.O0000oOo;
        int i3 = this.O0000Oo0;
        int i4 = this.O0000Oo;
        wrap2.put(bArr5, i3 * i4, (i3 * i4) / 4);
        byte[] bArr6 = this.O0000oOo;
        int i5 = this.O0000Oo0;
        int i6 = this.O0000Oo;
        wrap3.put(bArr6, ((i5 * i6) * 5) / 4, (i5 * i6) / 4);
        wrap.flip();
        wrap2.flip();
        wrap3.flip();
        if (!HSMediaPlayer.convertYUV2RGB(bArr, bArr2, bArr3, bArr4, this.O0000Oo0, this.O0000Oo)) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(this.O0000Oo0, this.O0000Oo, Bitmap.Config.RGB_565);
        createBitmap.copyPixelsFromBuffer(wrap4);
        wrap4.position(0);
        return createBitmap;
    }

    public GLFisheyeView getFisheyeView() {
        return this.O0000O0o;
    }

    private void O0000OoO() {
        if (this.O0000OOo == null) {
            this.O0000OOo = new HSMediaPlayer(this.f12121O000000o);
            this.O0000OOo.setOnPanoParamListener(new OnPanoParamListener() {
                /* class com.xiaovv.player.HSVideoView.AnonymousClass8 */

                public final void onParam(int i, int i2, int i3, int i4) {
                    ihs.O000000o("HSVideoView", "onParam: " + i + " " + i2 + " " + i3 + " " + i4);
                    final int i5 = i;
                    final int i6 = i2;
                    final int i7 = i3;
                    final int i8 = i4;
                    HSVideoView.this.post(new Runnable() {
                        /* class com.xiaovv.player.HSVideoView.AnonymousClass8.AnonymousClass1 */

                        public final void run() {
                            if (HSVideoView.this.O00000oo != null) {
                                HSVideoView.this.O00000oo.onParam(i5, i6, i7, i8);
                            }
                        }
                    });
                }
            });
            this.O0000OOo.setOnPlayProgressListener(new OnPlayProgressListener() {
                /* class com.xiaovv.player.HSVideoView.AnonymousClass9 */

                public final void onProgress(final int i, final int i2) {
                    HSVideoView.this.post(new Runnable() {
                        /* class com.xiaovv.player.HSVideoView.AnonymousClass9.AnonymousClass1 */

                        public final void run() {
                            if (HSVideoView.this.O00000o0 != null) {
                                HSVideoView.this.O00000o0.onProgress(i, i2);
                            }
                        }
                    });
                }

                public final void onTimestamp(final long j) {
                    HSVideoView.this.post(new Runnable() {
                        /* class com.xiaovv.player.HSVideoView.AnonymousClass9.AnonymousClass2 */

                        public final void run() {
                            if (HSVideoView.this.O00000o0 != null) {
                                HSVideoView.this.O00000o0.onTimestamp(j);
                            }
                        }
                    });
                }
            });
            this.O0000OOo.setOnPlayStateListener(new OnPlayStateListener() {
                /* class com.xiaovv.player.HSVideoView.AnonymousClass10 */

                public final void onTime(int i, long j) {
                }

                public final void onCompleted(final int i, final int i2) {
                    HSVideoView.this.post(new Runnable() {
                        /* class com.xiaovv.player.HSVideoView.AnonymousClass10.AnonymousClass1 */

                        public final void run() {
                            if (HSVideoView.this.O00000o != null) {
                                HSVideoView.this.O00000o.onCompleted(i, i2);
                            }
                        }
                    });
                }

                public final void onError(final int i) {
                    HSVideoView.this.post(new Runnable() {
                        /* class com.xiaovv.player.HSVideoView.AnonymousClass10.AnonymousClass2 */

                        public final void run() {
                            if (HSVideoView.this.O00000o != null) {
                                HSVideoView.this.O00000o.onError(i);
                            }
                        }
                    });
                }
            });
            this.O0000OOo.setOnRenderListener(new OnRenderListener() {
                /* class com.xiaovv.player.HSVideoView.AnonymousClass11 */

                public final void onRender(final int i, final int i2) {
                    ihs.O000000o("HSVideoView", "onRender: from media player " + i + " " + i2);
                    ihs.O000000o("HSVideoView", "onRender: " + i + " " + i2 + " " + HSVideoView.this.getVisibility());
                    if (HSVideoView.this.O0000OoO == -1 && HSVideoView.O0000o0o != -1) {
                        HSVideoView hSVideoView = HSVideoView.this;
                        hSVideoView.O0000o0O = false;
                        hSVideoView.O000000o(HSVideoView.O0000o0o, HSVideoView.O0000o, HSVideoView.O0000oO0, HSVideoView.O0000oO);
                    }
                    if (HSVideoView.this.getVisibility() != 0) {
                        HSVideoView.this.post(new Runnable() {
                            /* class com.xiaovv.player.HSVideoView.AnonymousClass11.AnonymousClass1 */

                            public final void run() {
                                if (HSVideoView.this.getVisibility() != 0) {
                                    HSVideoView.this.setVisibility(0);
                                }
                            }
                        });
                    }
                    HSVideoView.this.post(new Runnable() {
                        /* class com.xiaovv.player.HSVideoView.AnonymousClass11.AnonymousClass2 */

                        public final void run() {
                            if (HSVideoView.this.O00000oO != null) {
                                HSVideoView.this.O00000oO.onRender(i, i2);
                            }
                        }
                    });
                }
            });
            this.O0000OOo.setOnYuvDataListener(new OnYuvDataListener() {
                /* class com.xiaovv.player.HSVideoView.AnonymousClass2 */

                public final void onParam(String str) {
                    HSVideoView.this.setCamParam(str);
                }

                public final void onYuv(byte[] bArr, int i, int i2) {
                    HSVideoView hSVideoView = HSVideoView.this;
                    hSVideoView.O0000o00 = false;
                    hSVideoView.O0000Oo0 = i;
                    hSVideoView.O0000Oo = i2;
                    hSVideoView.O000000o(bArr, i, i2);
                }

                public final void onTimestamp(long j) {
                    HSVideoView.this.setTimestamp_ms(j);
                }
            });
        }
    }

    public void setPath(String str) {
        if (str != null) {
            this.O00oOoOo = str;
            if (this.O0000Ooo != 0) {
                O0000O0o();
                O000000o(str);
            }
        }
    }

    private void O000000o(String str) {
        if (this.O0000OOo == null) {
            O0000OoO();
        }
        if (this.O0000Ooo != 2) {
            this.O0000Ooo = 1;
            if (!TextUtils.isEmpty(str)) {
                this.O0000Ooo = 2;
                O00000Oo();
                String str2 = null;
                if (str.startsWith("content")) {
                    str2 = O000000o(this.f12121O000000o, Uri.parse(str));
                }
                if (str2 != null) {
                    str = str2;
                }
                this.O0000OOo.start(str);
                if (this.O000O0OO) {
                    O0000OOo();
                }
            }
        }
    }

    public final void O00000o() {
        O000000o(this.O00oOoOo);
    }

    public final void O00000oO() {
        HSMediaPlayer hSMediaPlayer = this.O0000OOo;
        if (hSMediaPlayer != null && this.O0000Ooo == 2) {
            this.O0000Ooo = 3;
            hSMediaPlayer.pause();
        }
    }

    public final void O00000oo() {
        HSMediaPlayer hSMediaPlayer = this.O0000OOo;
        if (hSMediaPlayer != null && this.O0000Ooo == 3) {
            this.O0000Ooo = 2;
            hSMediaPlayer.resume();
        }
    }

    public final void O0000O0o() {
        int i;
        HSMediaPlayer hSMediaPlayer = this.O0000OOo;
        if (hSMediaPlayer != null && (i = this.O0000Ooo) != 0 && i != 4) {
            this.O0000Ooo = 4;
            hSMediaPlayer.stop();
        }
    }

    public final void O0000OOo() {
        this.O000O0OO = true;
        HSMediaPlayer hSMediaPlayer = this.O0000OOo;
        if (hSMediaPlayer != null) {
            hSMediaPlayer.playAudio();
        }
    }

    public final void O0000Oo0() {
        this.O000O0OO = false;
        HSMediaPlayer hSMediaPlayer = this.O0000OOo;
        if (hSMediaPlayer != null) {
            hSMediaPlayer.pauseAudio();
        }
    }

    public void setScaleZoom(boolean z) {
        GLFisheyeView gLFisheyeView = this.O0000O0o;
        if (gLFisheyeView != null) {
            gLFisheyeView.setScaleZoom(z);
        }
    }

    public void setFullScale(boolean z) {
        GLFisheyeView gLFisheyeView = this.O0000O0o;
        if (gLFisheyeView != null) {
            gLFisheyeView.setScale(z);
        }
    }

    public final void O0000Oo() {
        GLFisheyeView gLFisheyeView = this.O0000O0o;
        if (gLFisheyeView != null) {
            gLFisheyeView.release();
        }
        if (this.O0000OOo != null) {
            this.O00000o0 = null;
            this.O00000Oo = null;
            this.O00000o = null;
            this.O00000oO = null;
            O0000O0o();
            this.O0000OOo.release();
            this.O0000OOo = null;
        }
    }

    public void setHasParams(boolean z) {
        this.O0000o0O = z;
    }

    public long getTimestamp() {
        return this.O00oOooo;
    }

    public void setTimestamp(long j) {
        this.O00oOooo = j;
    }

    public long getTimestamp_ms() {
        return this.O000O00o;
    }

    public void setTimestamp_ms(long j) {
        this.O000O00o = j;
    }

    public String getTimeOsd() {
        long j = this.O000O00o;
        if (j < 31507200000L) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss", Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Etc/GMT"));
        return simpleDateFormat.format(new Date(j));
    }

    public int getCamType() {
        return this.O0000OoO;
    }

    public void setCamType(int i) {
        this.O0000OoO = i;
    }

    public int getCamX() {
        return this.O0000ooO;
    }

    public void setCamX(int i) {
        this.O0000ooO = i;
    }

    public int getCamY() {
        return this.O0000ooo;
    }

    public void setCamY(int i) {
        this.O0000ooo = i;
    }

    public int getCamR() {
        return this.O00oOooO;
    }

    public static int getPanoType() {
        return O0000o0o;
    }

    public static void setPanoType(int i) {
        O0000o0o = i;
    }

    public static int getPanoX() {
        return O0000o;
    }

    public static void setPanoX(int i) {
        O0000o = i;
    }

    public static int getPanoY() {
        return O0000oO0;
    }

    public static void setPanoY(int i) {
        O0000oO0 = i;
    }

    public static int getPanoR() {
        return O0000oO;
    }

    public static void setPanoR(int i) {
        O0000oO = i;
    }

    public void setOnVideoViewListener(O000000o o000000o) {
        this.O00000Oo = o000000o;
    }

    public void setOnPlayProgressListener(OnPlayProgressListener onPlayProgressListener) {
        this.O00000o0 = onPlayProgressListener;
    }

    public void setOnPlayStateListener(OnPlayStateListener onPlayStateListener) {
        this.O00000o = onPlayStateListener;
    }

    public void setOnRenderListener(OnRenderListener onRenderListener) {
        this.O00000oO = onRenderListener;
    }

    public void setOnPanoParamListener(OnPanoParamListener onPanoParamListener) {
        this.O00000oo = onPanoParamListener;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (!z) {
            this.O0000o0 = true;
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        GLFisheyeView gLFisheyeView = this.O0000O0o;
        if (!(gLFisheyeView == null || (gestureDetector = this.O0000oOO) == null || view != gLFisheyeView)) {
            gestureDetector.onTouchEvent(motionEvent);
        }
        return false;
    }

    static class O00000Oo extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: O000000o  reason: collision with root package name */
        private WeakReference<HSVideoView> f12142O000000o;

        O00000Oo(HSVideoView hSVideoView) {
            this.f12142O000000o = new WeakReference<>(hSVideoView);
        }

        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            HSVideoView hSVideoView = this.f12142O000000o.get();
            if (!(hSVideoView == null || hSVideoView.O00000Oo == null)) {
                hSVideoView.O00000Oo.onVideoViewClick();
            }
            return false;
        }
    }

    @TargetApi(19)
    public static String O000000o(Context context, Uri uri) {
        Uri uri2 = null;
        if (uri != null) {
            if (!(Build.VERSION.SDK_INT >= 19) || !DocumentsContract.isDocumentUri(context, uri)) {
                if ("content".equalsIgnoreCase(uri.getScheme())) {
                    return O000000o(context, uri, (String) null, (String[]) null);
                }
                if ("file".equalsIgnoreCase(uri.getScheme())) {
                    return uri.getPath();
                }
            } else if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                String[] split = DocumentsContract.getDocumentId(uri).split(":");
                String str = split[0];
                if ("image".equals(str)) {
                    uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(str)) {
                    uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(str)) {
                    uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                return O000000o(context, uri2, "_id=?", new String[]{split[1]});
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0035  */
    private static String O000000o(Context context, Uri uri, String str, String[] strArr) {
        Cursor cursor;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                        if (cursor != null) {
                            cursor.close();
                        }
                        return string;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}
