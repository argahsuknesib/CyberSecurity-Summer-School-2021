package com.xiaomi.passport.ui.internal;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SectionIndexer;
import android.widget.TextView;
import android.widget.WrapperListAdapter;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.gms.common.ConnectionResult;
import com.xiaomi.passport.ui.R$id;
import com.xiaomi.smarthome.R;
import java.lang.ref.WeakReference;
import java.util.Arrays;

@SuppressLint({"NewApi"})
public class AlphabetFastIndexer extends AppCompatTextView {
    private Handler mHandler;
    private int mLastAlphabetIndex;
    public int mListScrollState;
    private AdapterView<?> mListView;
    public TextView mOverlay;
    private Runnable mRefreshMaskRunnable;
    private int mState;
    private ValueAnimator.AnimatorUpdateListener mTextHilightAnimListener;
    public O00000Oo mTextHilighter;

    public AlphabetFastIndexer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlphabetFastIndexer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTextHilightAnimListener = new ValueAnimator.AnimatorUpdateListener() {
            /* class com.xiaomi.passport.ui.internal.AlphabetFastIndexer.AnonymousClass1 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AlphabetFastIndexer.this.mTextHilighter.O000000o(((float) AlphabetFastIndexer.this.getWidth()) / 2.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue());
                AlphabetFastIndexer.this.postInvalidate();
            }
        };
        this.mListScrollState = 0;
        this.mState = 0;
        this.mRefreshMaskRunnable = new Runnable() {
            /* class com.xiaomi.passport.ui.internal.AlphabetFastIndexer.AnonymousClass2 */

            public final void run() {
                AlphabetFastIndexer.this.refreshMask();
            }
        };
        this.mHandler = new Handler() {
            /* class com.xiaomi.passport.ui.internal.AlphabetFastIndexer.AnonymousClass3 */

            public final void handleMessage(Message message) {
                if (message.what == 1 && AlphabetFastIndexer.this.mOverlay != null) {
                    AlphabetFastIndexer.this.mOverlay.setVisibility(8);
                }
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.indexerBackground, R.attr.indexerTable, R.attr.indexerTextActivatedColor, R.attr.indexerTextColor, R.attr.indexerTextHighlightColor, R.attr.indexerTextHighligtBackground, R.attr.indexerTextSize, R.attr.overlayBackground, R.attr.overlayMarginLeft, R.attr.overlayMarginTop, R.attr.overlayTextColor, R.attr.overlayTextSize}, i, 0);
        this.mTextHilighter = new O00000Oo(context, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mLastAlphabetIndex = -1;
        post(this.mRefreshMaskRunnable);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        super.onDraw(canvas);
        int paddingTop = getPaddingTop();
        int height = (getHeight() - paddingTop) - getPaddingBottom();
        if (height > 0) {
            String[] strArr = this.mTextHilighter.O0000OoO;
            float length = ((float) height) / ((float) strArr.length);
            float width = ((float) getWidth()) / 2.0f;
            O00000Oo o00000Oo = this.mTextHilighter;
            Paint paint = o00000Oo.O00000Oo;
            Xfermode xfermode = paint.getXfermode();
            paint.setXfermode(o00000Oo.O0000Oo0);
            o00000Oo.O00000o.drawPaint(paint);
            paint.setXfermode(xfermode);
            int i = 0;
            o00000Oo.f6235O000000o.setBounds(0, 0, o00000Oo.O00000oo.width(), o00000Oo.O00000oo.height());
            o00000Oo.f6235O000000o.draw(o00000Oo.O00000o);
            o00000Oo.O0000O0o.set(o00000Oo.O00000oo);
            float f = ((float) paddingTop) + (length / 2.0f);
            int i2 = 0;
            while (i2 < strArr.length) {
                O00000Oo o00000Oo2 = this.mTextHilighter;
                boolean isPressed = isPressed();
                Paint paint2 = o00000Oo2.O00000Oo;
                String str = TextUtils.equals(o00000Oo2.O0000OoO[i2], "!") ? "★" : o00000Oo2.O0000OoO[i2];
                paint2.getTextBounds(str, i, str.length(), o00000Oo2.O0000OOo);
                float width2 = (float) o00000Oo2.O0000OOo.width();
                float height2 = (float) o00000Oo2.O0000OOo.height();
                paint2.setColor(isPressed ? o00000Oo2.O0000o00 : o00000Oo2.O0000Ooo);
                canvas2.drawText(str, width, f - (((float) (o00000Oo2.O0000OOo.top + o00000Oo2.O0000OOo.bottom)) / 2.0f), paint2);
                float f2 = width2 / 2.0f;
                float f3 = height2 / 2.0f;
                if (o00000Oo2.O0000O0o.intersect((int) (width - f2), (int) (f - f3), (int) (f2 + width), (int) (f3 + f))) {
                    paint2.setColor(o00000Oo2.O0000o0);
                    o00000Oo2.O00000o.drawText(str, width - ((float) o00000Oo2.O00000oo.left), (f - ((float) o00000Oo2.O00000oo.top)) - (((float) (o00000Oo2.O0000OOo.top + o00000Oo2.O0000OOo.bottom)) / 2.0f), paint2);
                    o00000Oo2.O0000O0o.set(o00000Oo2.O00000oo);
                }
                f += length;
                i2++;
                i = 0;
            }
            O00000Oo o00000Oo3 = this.mTextHilighter;
            Paint paint3 = o00000Oo3.f6235O000000o.getPaint();
            Xfermode xfermode2 = paint3.getXfermode();
            paint3.setXfermode(o00000Oo3.O0000Oo);
            o00000Oo3.f6235O000000o.draw(o00000Oo3.O00000o);
            paint3.setXfermode(xfermode2);
            canvas2.drawBitmap(o00000Oo3.O00000o0, (Rect) null, o00000Oo3.O00000oo, (Paint) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        attatch();
    }

    public void attatch() {
        this.mLastAlphabetIndex = -1;
        FrameLayout frameLayout = (FrameLayout) getParent();
        this.mOverlay = (TextView) frameLayout.findViewById(R$id.fast_indexer_high_light);
        this.mListView = (AdapterView) frameLayout.findViewById(R$id.fast_indexer_list);
        this.mOverlay.setVisibility(8);
        refreshMask();
    }

    public void drawThumb(CharSequence charSequence) {
        if (this.mState == 0 && this.mListScrollState == 2) {
            drawThumbInternal(charSequence);
        }
    }

    public void refreshMask() {
        int sectionForPosition;
        if (this.mListView != null) {
            int i = 0;
            SectionIndexer sectionIndexer = getSectionIndexer();
            if (!(sectionIndexer == null || (sectionForPosition = sectionIndexer.getSectionForPosition(this.mListView.getFirstVisiblePosition() - getListOffset())) == -1)) {
                String str = (String) sectionIndexer.getSections()[sectionForPosition];
                if (!TextUtils.isEmpty(str)) {
                    i = Arrays.binarySearch(this.mTextHilighter.O0000OoO, str);
                }
            }
            if (this.mLastAlphabetIndex != i) {
                this.mLastAlphabetIndex = i;
                if (1 != this.mState) {
                    slidTextHilightBackground(this.mLastAlphabetIndex);
                }
                invalidate();
            }
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x001b  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    private SectionIndexer getSectionIndexer() {
        boolean z;
        AdapterView<?> adapterView = this.mListView;
        if (adapterView == null) {
            return null;
        }
        ListAdapter listAdapter = adapterView.getAdapter();
        while (true) {
            z = listAdapter instanceof SectionIndexer;
            if (!z && (listAdapter instanceof WrapperListAdapter)) {
                listAdapter = ((WrapperListAdapter) listAdapter).getWrappedAdapter();
            } else if (!z) {
                return (SectionIndexer) listAdapter;
            } else {
                return null;
            }
        }
        if (!z) {
        }
    }

    private int getListOffset() {
        AdapterView<?> adapterView = this.mListView;
        if (adapterView instanceof ListView) {
            return ((ListView) adapterView).getHeaderViewsCount();
        }
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0022, code lost:
        if (r2 != 3) goto L_0x002a;
     */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mListView == null) {
            stop(0);
            return false;
        }
        SectionIndexer sectionIndexer = getSectionIndexer();
        if (sectionIndexer == null) {
            stop(0);
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                }
            }
            slidTextHilightBackground(this.mLastAlphabetIndex);
            stop(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
            return true;
        }
        this.mState = 1;
        setPressed(true);
        int postion = getPostion(motionEvent.getY(), sectionIndexer);
        if (postion < 0) {
            this.mListView.setSelection(0);
        } else {
            scrollTo(sectionIndexer, postion);
            if (this.mTextHilighter != null && motionEvent.getY() > ((float) (getTop() + getPaddingTop())) && motionEvent.getY() < ((float) (getBottom() - getPaddingBottom()))) {
                this.mTextHilighter.O000000o((float) (getWidth() / 2), motionEvent.getY());
                postInvalidate();
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void stop(int i) {
        setPressed(false);
        this.mState = 0;
        postInvalidate();
        this.mHandler.removeMessages(1);
        if (i <= 0) {
            TextView textView = this.mOverlay;
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), (long) i);
    }

    private int getPostion(float f, SectionIndexer sectionIndexer) {
        Object[] sections = sectionIndexer.getSections();
        if (sections == null) {
            return -1;
        }
        int paddingTop = getPaddingTop();
        int height = (getHeight() - paddingTop) - getPaddingBottom();
        if (height <= 0) {
            return -1;
        }
        int length = (int) (((float) this.mTextHilighter.O0000OoO.length) * ((f - ((float) paddingTop)) / ((float) height)));
        if (length < 0) {
            return -1;
        }
        if (length >= this.mTextHilighter.O0000OoO.length) {
            return sections.length;
        }
        int binarySearch = Arrays.binarySearch(sections, this.mTextHilighter.O0000OoO[length]);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        }
        if (binarySearch < 0) {
            return 0;
        }
        return binarySearch;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x009d  */
    private void scrollTo(SectionIndexer sectionIndexer, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        float f;
        float f2;
        int i7;
        AdapterView<?> adapterView;
        SectionIndexer sectionIndexer2 = sectionIndexer;
        int i8 = i;
        int count = this.mListView.getCount();
        int listOffset = getListOffset();
        float f3 = (1.0f / ((float) count)) / 8.0f;
        Object[] sections = sectionIndexer.getSections();
        if (sections == null || sections.length <= 1) {
            int round = Math.round((float) (i8 * count));
            AdapterView<?> adapterView2 = this.mListView;
            if (adapterView2 instanceof ExpandableListView) {
                ExpandableListView expandableListView = (ExpandableListView) adapterView2;
                expandableListView.setSelectionFromTop(expandableListView.getFlatListPosition(ExpandableListView.getPackedPositionForGroup(round + listOffset)), 0);
            } else if (adapterView2 instanceof ListView) {
                ((ListView) adapterView2).setSelectionFromTop(round + listOffset, 0);
            } else {
                adapterView2.setSelection(round + listOffset);
            }
            i2 = -1;
        } else {
            int length = sections.length;
            int i9 = i8 >= length ? length - 1 : i8;
            int positionForSection = sectionIndexer2.getPositionForSection(i9);
            int i10 = i9 + 1;
            int positionForSection2 = i9 < length + -1 ? sectionIndexer2.getPositionForSection(i10) : count;
            if (positionForSection2 == positionForSection) {
                i4 = i9;
                i3 = positionForSection;
                while (true) {
                    if (i4 > 0) {
                        i4--;
                        i3 = sectionIndexer2.getPositionForSection(i4);
                        if (i3 == positionForSection) {
                            if (i4 == 0) {
                                i4 = i9;
                                i2 = 0;
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        i2 = i9;
                        i4 = i2;
                        break;
                    }
                }
                i5 = i10;
                i6 = i10 + 1;
                while (i6 < length && sectionIndexer2.getPositionForSection(i6) == positionForSection2) {
                    i6++;
                    i5++;
                }
                float f4 = (float) length;
                f = ((float) i4) / f4;
                float f5 = ((float) i5) / f4;
                f2 = ((float) i8) / f4;
                if (i4 != i9 || f2 - f >= f3) {
                    i3 += Math.round((((float) (positionForSection2 - i3)) * (f2 - f)) / (f5 - f));
                }
                i7 = count - 1;
                if (i3 > i7) {
                    i3 = i7;
                }
                adapterView = this.mListView;
                if (!(adapterView instanceof ExpandableListView)) {
                    ExpandableListView expandableListView2 = (ExpandableListView) adapterView;
                    expandableListView2.setSelectionFromTop(expandableListView2.getFlatListPosition(ExpandableListView.getPackedPositionForGroup(i3 + listOffset)), 0);
                } else if (adapterView instanceof ListView) {
                    ((ListView) adapterView).setSelectionFromTop(i3 + listOffset, 0);
                } else {
                    adapterView.setSelection(i3 + listOffset);
                }
            } else {
                i4 = i9;
                i3 = positionForSection;
            }
            i2 = i4;
            i5 = i10;
            i6 = i10 + 1;
            while (i6 < length) {
                i6++;
                i5++;
            }
            float f42 = (float) length;
            f = ((float) i4) / f42;
            float f52 = ((float) i5) / f42;
            f2 = ((float) i8) / f42;
            i3 += Math.round((((float) (positionForSection2 - i3)) * (f2 - f)) / (f52 - f));
            i7 = count - 1;
            if (i3 > i7) {
            }
            adapterView = this.mListView;
            if (!(adapterView instanceof ExpandableListView)) {
            }
        }
        if (i2 >= 0 && sections != null) {
            String obj = sections[i2].toString();
            if (!TextUtils.isEmpty(obj)) {
                drawThumbInternal(obj.subSequence(0, 1));
            }
        }
    }

    private void drawThumbInternal(CharSequence charSequence) {
        if (this.mListView != null) {
            if (TextUtils.equals(charSequence, "!")) {
                charSequence = "★";
            }
            this.mOverlay.setText(charSequence);
            if (getVisibility() == 0) {
                this.mOverlay.setVisibility(0);
                this.mHandler.removeMessages(1);
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 1500);
            }
        }
    }

    private void slidTextHilightBackground(int i) {
        float f;
        if (this.mTextHilighter != null) {
            if (i < 0) {
                i = 0;
            }
            int paddingTop = getPaddingTop();
            float height = ((float) ((getHeight() - paddingTop) - getPaddingBottom())) / ((float) this.mTextHilighter.O0000OoO.length);
            float f2 = (((float) i) * height) + ((float) paddingTop) + (height / 2.0f) + 1.0f;
            O00000Oo o00000Oo = this.mTextHilighter;
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.mTextHilightAnimListener;
            if (o00000Oo.O00000oO != null) {
                o00000Oo.O00000oO.cancel();
            }
            if (o00000Oo.O00000oo == null) {
                f = f2;
            } else {
                f = ((float) (o00000Oo.O00000oo.top + o00000Oo.O00000oo.bottom)) / 2.0f;
            }
            o00000Oo.O00000oO = ValueAnimator.ofFloat(f, f2);
            o00000Oo.O00000oO.addUpdateListener(animatorUpdateListener);
            o00000Oo.O00000oO.setDuration(200L);
            o00000Oo.O00000oO.start();
        }
    }

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        BitmapDrawable f6235O000000o;
        Paint O00000Oo = new Paint();
        Canvas O00000o;
        Bitmap O00000o0;
        ValueAnimator O00000oO;
        Rect O00000oo = new Rect();
        Rect O0000O0o;
        Rect O0000OOo = new Rect();
        Xfermode O0000Oo;
        Xfermode O0000Oo0;
        String[] O0000OoO;
        int O0000Ooo;
        int O0000o0;
        int O0000o00;

        O00000Oo(Context context, TypedArray typedArray) {
            Resources resources = context.getResources();
            CharSequence[] textArray = typedArray.getTextArray(1);
            if (textArray != null) {
                this.O0000OoO = new String[textArray.length];
                int length = textArray.length;
                int i = 0;
                int i2 = 0;
                while (i < length) {
                    this.O0000OoO[i2] = textArray[i].toString();
                    i++;
                    i2++;
                }
            } else {
                this.O0000OoO = resources.getStringArray(R.array.alphabet_table);
            }
            this.O0000Ooo = typedArray.getColor(3, 0);
            this.O0000o00 = typedArray.getColor(2, 0);
            this.O0000o0 = typedArray.getColor(4, 0);
            this.f6235O000000o = (BitmapDrawable) typedArray.getDrawable(5);
            this.O00000Oo.setTextSize(typedArray.getDimension(6, 0.0f));
            this.O00000Oo.setAntiAlias(true);
            this.O00000Oo.setTextAlign(Paint.Align.CENTER);
            this.O00000Oo.setTypeface(Typeface.DEFAULT_BOLD);
            this.O00000o0 = this.f6235O000000o.getBitmap().copy(Bitmap.Config.ARGB_8888, true);
            this.O00000o = new Canvas(this.O00000o0);
            this.O0000O0o = new Rect();
            this.O0000Oo0 = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
            this.O0000Oo = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
            O000000o(0.0f, 0.0f);
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(float f, float f2) {
            float intrinsicWidth = ((float) this.f6235O000000o.getIntrinsicWidth()) / 2.0f;
            float intrinsicHeight = ((float) this.f6235O000000o.getIntrinsicHeight()) / 2.0f;
            this.O00000oo.set((int) ((f - intrinsicWidth) + 1.0f), (int) (f2 - intrinsicHeight), (int) (f + intrinsicWidth + 1.0f), (int) (f2 + intrinsicHeight));
        }
    }

    public static class O000000o implements AbsListView.OnScrollListener {

        /* renamed from: O000000o  reason: collision with root package name */
        private final AbsListView.OnScrollListener f6234O000000o;
        private final WeakReference<AlphabetFastIndexer> O00000Oo;
        private String O00000o0 = "";

        /* access modifiers changed from: protected */
        public String O000000o(Object obj) {
            return null;
        }

        public O000000o(AlphabetFastIndexer alphabetFastIndexer, AbsListView.OnScrollListener onScrollListener) {
            this.O00000Oo = new WeakReference<>(alphabetFastIndexer);
            this.f6234O000000o = null;
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            AlphabetFastIndexer alphabetFastIndexer = this.O00000Oo.get();
            if (alphabetFastIndexer != null) {
                alphabetFastIndexer.refreshMask();
                String O000000o2 = O000000o(((ListAdapter) absListView.getAdapter()).getItem(i));
                if (TextUtils.isEmpty(O000000o2)) {
                    String upperCase = O000000o2.substring(0, 1).toUpperCase();
                    if (!TextUtils.equals(upperCase, this.O00000o0)) {
                        alphabetFastIndexer.drawThumb(upperCase);
                        this.O00000o0 = upperCase;
                    }
                }
            }
            AbsListView.OnScrollListener onScrollListener = this.f6234O000000o;
            if (onScrollListener != null) {
                onScrollListener.onScroll(absListView, i, i2, i3);
            }
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            AlphabetFastIndexer alphabetFastIndexer = this.O00000Oo.get();
            if (alphabetFastIndexer != null) {
                alphabetFastIndexer.mListScrollState = i;
            }
            AbsListView.OnScrollListener onScrollListener = this.f6234O000000o;
            if (onScrollListener != null) {
                onScrollListener.onScrollStateChanged(absListView, i);
            }
        }
    }
}
