package _m_j;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import java.util.List;

public class hla extends hkw {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f19028O000000o = false;
    private String O00000Oo;

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (this.f19028O000000o) {
            return false;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (!this.f19028O000000o) {
            this.O00000Oo = null;
            ViewGroup viewGroup = (ViewGroup) webView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(viewGroup.findViewById(R.id.webview_error_page));
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00ad  */
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        int i2;
        int i3;
        gsy.O000000o(3, "ErrorInterceptor", "onReceivedError: ".concat(String.valueOf(str)));
        this.f19028O000000o = true;
        String url = webView.getUrl();
        if (this.O00000Oo == null) {
            this.O00000Oo = url;
        }
        ViewGroup viewGroup = (ViewGroup) webView.getParent();
        if (viewGroup.findViewById(R.id.webview_error_page) == null) {
            int width = webView.getWidth();
            int height = webView.getHeight();
            final Context context = webView.getContext();
            ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(context).inflate((int) R.layout.webview_error_page, viewGroup, false);
            viewGroup2.findViewById(R.id.refresh).setOnClickListener(new View.OnClickListener(webView) {
                /* class _m_j.$$Lambda$hla$QSZau0ekD9t31rG9X556Ny3uqE */
                private final /* synthetic */ WebView f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    hla.this.O000000o(this.f$1, view);
                }
            });
            final TextView textView = (TextView) viewGroup2.findViewById(R.id.desc);
            String string = context.getString(R.string.webview_reconnect_network_tip);
            String str3 = null;
            try {
                int indexOf = string.indexOf("%");
                int i4 = indexOf + 1;
                int indexOf2 = string.indexOf("%", i4);
                String substring = string.substring(i4, indexOf2);
                str3 = string.substring(0, indexOf);
                i3 = str3.length();
                try {
                    str3 = str3 + substring + string.substring(indexOf2 + 1);
                    i2 = i3 + substring.length();
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    i2 = 0;
                    if (i2 == 0) {
                    }
                    SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(str3);
                    valueOf.setSpan(new ClickableSpan() {
                        /* class _m_j.hla.AnonymousClass1 */

                        public final void onClick(View view) {
                            Intent intent = new Intent("android.settings.SETTINGS");
                            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
                            if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                                hte.O000000o(context, (int) R.string.failed);
                            } else {
                                context.startActivity(intent);
                            }
                        }

                        public final void updateDrawState(TextPaint textPaint) {
                            super.updateDrawState(textPaint);
                            textPaint.setColor(textView.getResources().getColor(R.color.mj_color_green_normal));
                        }
                    }, i3, i2, 33);
                    textView.setText(valueOf);
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                    ViewGroup.LayoutParams layoutParams = viewGroup2.getLayoutParams();
                    layoutParams.width = width;
                    layoutParams.height = height;
                    viewGroup2.setLayoutParams(layoutParams);
                    viewGroup.addView(viewGroup2);
                    viewGroup2.setX(webView.getX());
                    viewGroup2.setY(webView.getY());
                    super.onReceivedError(webView, i, str, str2);
                }
            } catch (Exception e2) {
                e = e2;
                i3 = 0;
                e.printStackTrace();
                i2 = 0;
                if (i2 == 0) {
                }
                SpannableStringBuilder valueOf2 = SpannableStringBuilder.valueOf(str3);
                valueOf2.setSpan(new ClickableSpan() {
                    /* class _m_j.hla.AnonymousClass1 */

                    public final void onClick(View view) {
                        Intent intent = new Intent("android.settings.SETTINGS");
                        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
                        if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                            hte.O000000o(context, (int) R.string.failed);
                        } else {
                            context.startActivity(intent);
                        }
                    }

                    public final void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setColor(textView.getResources().getColor(R.color.mj_color_green_normal));
                    }
                }, i3, i2, 33);
                textView.setText(valueOf2);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                ViewGroup.LayoutParams layoutParams2 = viewGroup2.getLayoutParams();
                layoutParams2.width = width;
                layoutParams2.height = height;
                viewGroup2.setLayoutParams(layoutParams2);
                viewGroup.addView(viewGroup2);
                viewGroup2.setX(webView.getX());
                viewGroup2.setY(webView.getY());
                super.onReceivedError(webView, i, str, str2);
            }
            if (i2 == 0) {
                str3 = string.replaceAll("%", "");
                i2 = str3.length();
            }
            SpannableStringBuilder valueOf22 = SpannableStringBuilder.valueOf(str3);
            valueOf22.setSpan(new ClickableSpan() {
                /* class _m_j.hla.AnonymousClass1 */

                public final void onClick(View view) {
                    Intent intent = new Intent("android.settings.SETTINGS");
                    List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
                    if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                        hte.O000000o(context, (int) R.string.failed);
                    } else {
                        context.startActivity(intent);
                    }
                }

                public final void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(textView.getResources().getColor(R.color.mj_color_green_normal));
                }
            }, i3, i2, 33);
            textView.setText(valueOf22);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            ViewGroup.LayoutParams layoutParams22 = viewGroup2.getLayoutParams();
            layoutParams22.width = width;
            layoutParams22.height = height;
            viewGroup2.setLayoutParams(layoutParams22);
            viewGroup.addView(viewGroup2);
            viewGroup2.setX(webView.getX());
            viewGroup2.setY(webView.getY());
        }
        super.onReceivedError(webView, i, str, str2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(WebView webView, View view) {
        O000000o(webView);
    }

    public final void O000000o(WebView webView) {
        try {
            this.f19028O000000o = false;
            webView.stopLoading();
            if (this.O00000Oo != null) {
                webView.loadUrl(this.O00000Oo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
