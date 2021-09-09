package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.xiaomi.smarthome.R;

public class BtnAndProgressView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f9143O000000o = false;
    public long O00000Oo;
    public int O00000o = 0;
    public int O00000o0 = 1;
    public Handler O00000oO = new Handler() {
        /* class com.xiaomi.smarthome.library.common.widget.BtnAndProgressView.AnonymousClass1 */

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 10) {
                BtnAndProgressView.this.invalidate();
                BtnAndProgressView.this.O00000oO.sendEmptyMessageDelayed(10, 50);
            } else if (i == 11) {
                BtnAndProgressView.this.invalidate();
            }
        }
    };
    private Bitmap O00000oo;
    private NinePatch O0000O0o;
    private Paint O0000OOo = new Paint();
    private int O0000Oo;
    private int O0000Oo0;
    private Bitmap O0000OoO;
    private String O0000Ooo;
    private boolean O0000o = false;
    private Paint O0000o0 = new Paint();
    private Paint O0000o00;
    private Paint O0000o0O = new Paint();
    private O000000o O0000o0o;

    public interface O000000o {
        void O000000o();

        void O00000Oo();

        void O00000o();

        void O00000o0();

        void O00000oO();

        void O00000oo();

        void O0000O0o();
    }

    public BtnAndProgressView(Context context) {
        super(context);
        O00000o0();
    }

    public BtnAndProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O00000o0();
    }

    public BtnAndProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O00000o0();
    }

    private void O00000o0() {
        this.O00000oo = BitmapFactory.decodeResource(getResources(), R.drawable.kuailian_btn_bg);
        Bitmap bitmap = this.O00000oo;
        this.O0000O0o = new NinePatch(bitmap, bitmap.getNinePatchChunk(), null);
        this.O0000Oo0 = this.O0000O0o.getWidth();
        this.O0000Oo = this.O0000O0o.getHeight();
        this.O0000OoO = BitmapFactory.decodeResource(getResources(), R.drawable.kuailian_loading);
        this.O0000Ooo = getResources().getString(R.string.next_button);
        this.O0000o00 = new Paint();
        this.O0000o00.setTextSize(getResources().getDimension(R.dimen.font_size_4));
        this.O0000o00.setColor(getResources().getColor(R.color.mj_color_white));
        this.O0000o0.setFlags(5);
        this.O0000OOo.setFlags(5);
        this.O0000o0O.setFlags(5);
        this.O0000o0O.setStyle(Paint.Style.STROKE);
        this.O0000o0O.setStrokeWidth(4.0f);
        this.O0000o0O.setColor(getResources().getColor(R.color.mj_color_white));
    }

    public void setListener(O000000o o000000o) {
        this.O0000o0o = o000000o;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0 || action == 1 || action == 3) {
            this.O00000oO.sendEmptyMessage(11);
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void O000000o() {
        this.O00000o = 0;
        this.O0000o = false;
        this.O00000oO.removeMessages(10);
        this.O00000oO.sendEmptyMessage(11);
        this.O00000o0 = 1;
        this.f9143O000000o = false;
    }

    public final void O00000Oo() {
        this.O00000o = 0;
        this.f9143O000000o = true;
        if (!this.O00000oO.hasMessages(10)) {
            this.O00000oO.sendEmptyMessage(10);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        O000000o o000000o;
        O000000o o000000o2;
        long j;
        long j2;
        Canvas canvas2 = canvas;
        super.onDraw(canvas);
        int i = this.O00000o0;
        if (i == 1) {
            this.O0000o00.setAlpha(255);
            if (!isEnabled()) {
                this.O0000o00.setAlpha(153);
                this.O0000OOo.setAlpha(153);
            } else if (isPressed()) {
                this.O0000o00.setAlpha(153);
                this.O0000OOo.setAlpha(153);
            } else {
                this.O0000o00.setAlpha(255);
                this.O0000OOo.setAlpha(255);
            }
            this.O0000O0o.draw(canvas2, new Rect(0, (getHeight() - this.O0000Oo) / 2, getWidth(), (getHeight() + this.O0000Oo) / 2), this.O0000OOo);
            canvas2.drawText(this.O0000Ooo, (((float) getWidth()) - this.O0000o00.measureText(this.O0000Ooo)) / 2.0f, ((float) (getHeight() / 2)) + (getResources().getDimension(R.dimen.font_size_4) / 2.0f), this.O0000o00);
            if (this.f9143O000000o) {
                this.O00000o += 15;
                this.O00000o %= 360;
                canvas.save();
                canvas2.translate(((((float) (getWidth() / 2)) + this.O0000o00.measureText(this.O0000Ooo)) / 2.0f) + ((float) (this.O0000OoO.getWidth() / 2)), (float) (getHeight() / 2));
                canvas2.rotate((float) this.O00000o);
                Bitmap bitmap = this.O0000OoO;
                canvas2.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), this.O0000OoO.getHeight()), new RectF((float) ((-this.O0000OoO.getWidth()) / 2), (float) ((-this.O0000OoO.getHeight()) / 2), (float) (this.O0000OoO.getWidth() / 2), (float) (this.O0000OoO.getHeight() / 2)), this.O0000o0);
                canvas.restore();
            }
        } else if (i == 2) {
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = this.O00000Oo;
            if (currentTimeMillis - j3 < 500) {
                int width = (int) (((long) getWidth()) - ((((long) (getWidth() - this.O0000Oo0)) * (currentTimeMillis - this.O00000Oo)) / 500));
                canvas.save();
                canvas2.translate((float) (getWidth() / 2), 0.0f);
                this.O0000OOo.setAlpha(153);
                this.O0000O0o.draw(canvas2, new Rect((-width) / 2, (getHeight() - this.O0000Oo) / 2, width / 2, (getHeight() + this.O0000Oo) / 2), this.O0000OOo);
                float measureText = this.O0000o00.measureText(this.O0000Ooo);
                this.O0000o00.setAlpha(255);
                if (((float) width) < measureText) {
                    canvas2.drawText("0%", (-this.O0000o00.measureText(this.O0000Ooo)) / 2.0f, ((float) (getHeight() / 2)) + (getResources().getDimension(R.dimen.font_size_4) / 2.0f), this.O0000o00);
                } else {
                    String str = this.O0000Ooo;
                    canvas2.drawText(str, (-this.O0000o00.measureText(str)) / 2.0f, ((float) (getHeight() / 2)) + (getResources().getDimension(R.dimen.font_size_4) / 2.0f), this.O0000o00);
                }
                canvas.restore();
            } else if ((currentTimeMillis - j3) - 500 < 300) {
                long j4 = (long) this.O0000Oo0;
                if ((currentTimeMillis - j3) - 500 < 150) {
                    j2 = 10;
                    j = (currentTimeMillis - j3) - 500;
                } else {
                    j2 = 10;
                    j = 300 - ((currentTimeMillis - j3) - 500);
                }
                int i2 = (int) (j4 + (((j * j2) * 2) / 300));
                canvas.save();
                canvas2.translate((float) (getWidth() / 2), 0.0f);
                this.O0000OOo.setAlpha(153);
                this.O0000O0o.draw(canvas2, new Rect((-i2) / 2, (getHeight() - this.O0000Oo) / 2, i2 / 2, (getHeight() + this.O0000Oo) / 2), this.O0000OOo);
                this.O0000o00.setAlpha(255);
                canvas2.drawText("0%", (-this.O0000o00.measureText("0%")) / 2.0f, ((float) (getHeight() / 2)) + (getResources().getDimension(R.dimen.font_size_4) / 2.0f), this.O0000o00);
                canvas.restore();
            } else {
                canvas.save();
                canvas2.translate((float) (getWidth() / 2), 0.0f);
                this.O0000OOo.setAlpha(153);
                this.O0000O0o.draw(canvas2, new Rect((-this.O0000Oo0) / 2, (getHeight() - this.O0000Oo) / 2, this.O0000Oo0 / 2, (getHeight() + this.O0000Oo) / 2), this.O0000OOo);
                canvas2.drawText("0%", (-this.O0000o00.measureText("0%")) / 2.0f, ((float) (getHeight() / 2)) + (getResources().getDimension(R.dimen.font_size_4) / 2.0f), this.O0000o00);
                canvas.restore();
                this.O00000o0 = 3;
                this.O00000Oo = System.currentTimeMillis();
                if (!this.O00000oO.hasMessages(10)) {
                    this.O00000oO.sendEmptyMessage(10);
                }
                if (!this.O0000o) {
                    this.O0000o = true;
                    O000000o o000000o3 = this.O0000o0o;
                    if (o000000o3 != null) {
                        o000000o3.O000000o();
                    }
                }
            }
        } else if (i == 3) {
            long currentTimeMillis2 = System.currentTimeMillis() - this.O00000Oo;
            int i3 = -((int) ((360 * currentTimeMillis2) / 50000));
            long j5 = (currentTimeMillis2 * 100) / 50000;
            int i4 = (int) j5;
            if (i4 > 100) {
                O000000o o000000o4 = this.O0000o0o;
                if (o000000o4 != null) {
                    o000000o4.O00000oo();
                }
                this.O00000oO.removeMessages(10);
            }
            if (i4 > 75) {
                O000000o o000000o5 = this.O0000o0o;
                if (o000000o5 != null) {
                    o000000o5.O00000oO();
                }
            } else if (i4 > 50) {
                O000000o o000000o6 = this.O0000o0o;
                if (o000000o6 != null) {
                    o000000o6.O00000o();
                }
            } else if (i4 > 25) {
                O000000o o000000o7 = this.O0000o0o;
                if (o000000o7 != null) {
                    o000000o7.O00000o0();
                }
            } else if (i4 > 0 && (o000000o2 = this.O0000o0o) != null) {
                o000000o2.O00000Oo();
            }
            String str2 = String.valueOf(j5) + "%";
            canvas.save();
            canvas2.translate((float) (getWidth() / 2), 0.0f);
            this.O0000OOo.setAlpha(153);
            this.O0000O0o.draw(canvas2, new Rect((-this.O0000Oo0) / 2, (getHeight() - this.O0000Oo) / 2, this.O0000Oo0 / 2, (getHeight() + this.O0000Oo) / 2), this.O0000OOo);
            this.O0000o00.setAlpha(255);
            canvas2.drawText(str2, (-this.O0000o00.measureText(str2)) / 2.0f, ((float) (getHeight() / 2)) + (getResources().getDimension(R.dimen.font_size_4) / 2.0f), this.O0000o00);
            canvas.drawArc(new RectF((float) (((-this.O0000Oo0) / 2) + 2), (float) ((getHeight() - this.O0000Oo) / 2), (float) ((this.O0000Oo0 / 2) - 2), (float) ((getHeight() + this.O0000Oo) / 2)), 270.0f, (float) i3, false, this.O0000o0O);
            canvas.restore();
        } else if (i == 4) {
            long currentTimeMillis3 = System.currentTimeMillis() - this.O00000Oo;
            if (currentTimeMillis3 >= DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS && (o000000o = this.O0000o0o) != null) {
                o000000o.O0000O0o();
            }
            String valueOf = String.valueOf((DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS - currentTimeMillis3) / 1000);
            int i5 = (int) ((currentTimeMillis3 * 360) / DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS);
            canvas.save();
            canvas2.translate((float) (getWidth() / 2), 0.0f);
            this.O0000OOo.setAlpha(153);
            this.O0000O0o.draw(canvas2, new Rect((-this.O0000Oo0) / 2, (getHeight() - this.O0000Oo) / 2, this.O0000Oo0 / 2, (getHeight() + this.O0000Oo) / 2), this.O0000OOo);
            this.O0000o00.setAlpha(255);
            canvas2.drawText(valueOf, (-this.O0000o00.measureText(valueOf)) / 2.0f, ((float) (getHeight() / 2)) + (getResources().getDimension(R.dimen.font_size_4) / 2.0f), this.O0000o00);
            canvas.drawArc(new RectF((float) (((-this.O0000Oo0) / 2) + 2), (float) ((getHeight() - this.O0000Oo) / 2), (float) ((this.O0000Oo0 / 2) - 2), (float) ((getHeight() + this.O0000Oo) / 2)), 270.0f, (float) i5, false, this.O0000o0O);
            canvas.restore();
        }
    }
}
