package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.text.CaptionStyleCompat;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.ui.SubtitleView;
import com.google.android.exoplayer2.util.Util;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

final class SubtitleWebView extends FrameLayout implements SubtitleView.Output {
    private boolean applyEmbeddedFontSizes;
    private boolean applyEmbeddedStyles;
    private float bottomPaddingFraction;
    private List<Cue> cues;
    private CaptionStyleCompat style;
    private float textSize;
    private int textSizeType;
    private final WebView webView;

    private static int anchorTypeToTranslatePercent(int i) {
        if (i != 1) {
            return i != 2 ? 0 : -100;
        }
        return -50;
    }

    private String convertVerticalTypeToCss(int i) {
        return i != 1 ? i != 2 ? "horizontal-tb" : "vertical-lr" : "vertical-rl";
    }

    public SubtitleWebView(Context context) {
        this(context, null);
    }

    public SubtitleWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cues = Collections.emptyList();
        this.textSizeType = 0;
        this.textSize = 0.0533f;
        this.applyEmbeddedStyles = true;
        this.applyEmbeddedFontSizes = true;
        this.style = CaptionStyleCompat.DEFAULT;
        this.bottomPaddingFraction = 0.08f;
        this.webView = new WebView(context, attributeSet) {
            /* class com.google.android.exoplayer2.ui.SubtitleWebView.AnonymousClass1 */

            public boolean onTouchEvent(MotionEvent motionEvent) {
                super.onTouchEvent(motionEvent);
                return false;
            }

            public boolean performClick() {
                super.performClick();
                return false;
            }
        };
        this.webView.setBackgroundColor(0);
        addView(this.webView);
    }

    public final void onCues(List<Cue> list) {
        this.cues = list;
        updateWebView();
    }

    public final void setTextSize(int i, float f) {
        if (this.textSizeType != i || this.textSize != f) {
            this.textSizeType = i;
            this.textSize = f;
            updateWebView();
        }
    }

    public final void setApplyEmbeddedStyles(boolean z) {
        if (this.applyEmbeddedStyles != z || this.applyEmbeddedFontSizes != z) {
            this.applyEmbeddedStyles = z;
            this.applyEmbeddedFontSizes = z;
            updateWebView();
        }
    }

    public final void setApplyEmbeddedFontSizes(boolean z) {
        if (this.applyEmbeddedFontSizes != z) {
            this.applyEmbeddedFontSizes = z;
            updateWebView();
        }
    }

    public final void setStyle(CaptionStyleCompat captionStyleCompat) {
        if (this.style != captionStyleCompat) {
            this.style = captionStyleCompat;
            updateWebView();
        }
    }

    public final void setBottomPaddingFraction(float f) {
        if (this.bottomPaddingFraction != f) {
            this.bottomPaddingFraction = f;
            updateWebView();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00bc  */
    private void updateWebView() {
        int i;
        int i2;
        String str;
        int i3;
        String str2;
        int i4;
        StringBuilder sb = new StringBuilder();
        sb.append("<html><body><div style=\"-webkit-user-select:none;position:fixed;");
        sb.append("top:0;bottom:0;left:0;right:0;");
        sb.append("font-size:20px;color:red;\">");
        char c = 0;
        int i5 = 0;
        while (i5 < this.cues.size()) {
            Cue cue = this.cues.get(i5);
            float f = cue.position != -3.4028235E38f ? cue.position * 100.0f : 50.0f;
            int anchorTypeToTranslatePercent = anchorTypeToTranslatePercent(cue.positionAnchor);
            float f2 = 0.0f;
            if (cue.line != -3.4028235E38f) {
                if (cue.lineType != 1) {
                    f2 = cue.line * 100.0f;
                    i = 0;
                } else if (cue.line >= 0.0f) {
                    i = Math.round(cue.line) * 100;
                } else {
                    i = Math.round(cue.line + 1.0f) * 100;
                }
                if (cue.verticalType != 1) {
                    i2 = -anchorTypeToTranslatePercent(cue.lineAnchor);
                } else {
                    i2 = anchorTypeToTranslatePercent(cue.lineAnchor);
                }
                if (cue.size == -3.4028235E38f) {
                    Object[] objArr = new Object[1];
                    objArr[c] = Float.valueOf(cue.size * 100.0f);
                    str = Util.formatInvariant("%.2f%%", objArr);
                } else {
                    str = "fit-content";
                }
                String convertAlignmentToCss = convertAlignmentToCss(cue.textAlignment);
                String convertVerticalTypeToCss = convertVerticalTypeToCss(cue.verticalType);
                i3 = cue.verticalType;
                String str3 = "left";
                String str4 = "top";
                if (i3 != 1) {
                    str3 = "right";
                } else if (i3 != 2) {
                    String str5 = str4;
                    str4 = str3;
                    str3 = str5;
                }
                if (cue.verticalType != 2 || cue.verticalType == 1) {
                    int i6 = i + i2;
                    str2 = "height";
                    int i7 = i6;
                    i4 = anchorTypeToTranslatePercent;
                    anchorTypeToTranslatePercent = i7;
                } else {
                    i4 = i + i2;
                    str2 = "width";
                }
                sb.append(Util.formatInvariant("<div style=\"position:absolute;%s:%.2f%%;%s:%.2f%%;%s:%s;text-align:%s;writing-mode:%s;transform:translate(%s%%,%s%%);\">", str4, Float.valueOf(f), str3, Float.valueOf(f2), str2, str, convertAlignmentToCss, convertVerticalTypeToCss, Integer.valueOf(anchorTypeToTranslatePercent), Integer.valueOf(i4)));
                sb.append(SpannedToHtmlConverter.convert(cue.text));
                sb.append("</div>");
                i5++;
                c = 0;
            } else {
                i = 0;
            }
            f2 = 100.0f;
            if (cue.verticalType != 1) {
            }
            if (cue.size == -3.4028235E38f) {
            }
            String convertAlignmentToCss2 = convertAlignmentToCss(cue.textAlignment);
            String convertVerticalTypeToCss2 = convertVerticalTypeToCss(cue.verticalType);
            i3 = cue.verticalType;
            String str32 = "left";
            String str42 = "top";
            if (i3 != 1) {
            }
            if (cue.verticalType != 2) {
            }
            int i62 = i + i2;
            str2 = "height";
            int i72 = i62;
            i4 = anchorTypeToTranslatePercent;
            anchorTypeToTranslatePercent = i72;
            sb.append(Util.formatInvariant("<div style=\"position:absolute;%s:%.2f%%;%s:%.2f%%;%s:%s;text-align:%s;writing-mode:%s;transform:translate(%s%%,%s%%);\">", str42, Float.valueOf(f), str32, Float.valueOf(f2), str2, str, convertAlignmentToCss2, convertVerticalTypeToCss2, Integer.valueOf(anchorTypeToTranslatePercent), Integer.valueOf(i4)));
            sb.append(SpannedToHtmlConverter.convert(cue.text));
            sb.append("</div>");
            i5++;
            c = 0;
        }
        sb.append("</div></body></html>");
        this.webView.loadData(Base64.encodeToString(sb.toString().getBytes(Charset.forName("UTF-8")), 1), "text/html", "base64");
    }

    /* renamed from: com.google.android.exoplayer2.ui.SubtitleWebView$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$android$text$Layout$Alignment = new int[Layout.Alignment.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            $SwitchMap$android$text$Layout$Alignment[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            $SwitchMap$android$text$Layout$Alignment[Layout.Alignment.ALIGN_CENTER.ordinal()] = 2;
            try {
                $SwitchMap$android$text$Layout$Alignment[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private String convertAlignmentToCss(Layout.Alignment alignment) {
        if (alignment == null) {
            return "unset";
        }
        int i = AnonymousClass2.$SwitchMap$android$text$Layout$Alignment[alignment.ordinal()];
        if (i == 1) {
            return "start";
        }
        if (i != 2) {
            return i != 3 ? "unset" : "end";
        }
        return "center";
    }
}
