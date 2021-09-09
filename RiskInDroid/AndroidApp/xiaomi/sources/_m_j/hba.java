package _m_j;

import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import java.util.Arrays;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/FakeProgress;", "", "did", "", "progressTv", "Landroid/widget/TextView;", "(Ljava/lang/String;Landroid/widget/TextView;)V", "getDid", "()Ljava/lang/String;", "progressAnim", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "end", "", "start", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hba {

    /* renamed from: O000000o  reason: collision with root package name */
    private final String f18732O000000o;
    private final TextView O00000Oo;
    private final ValueAnimator O00000o0;

    public hba(String str, TextView textView) {
        ixe.O00000o(str, "did");
        ixe.O00000o(textView, "progressTv");
        this.f18732O000000o = str;
        this.O00000Oo = textView;
        ValueAnimator ofInt = ValueAnimator.ofInt(1, 91);
        ofInt.setDuration(10000L);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        String string = this.O00000Oo.getResources().getString(R.string.loading_progress);
        ixe.O00000Oo(string, "progressTv.resources.getString(R.string.loading_progress)");
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(string) {
            /* class _m_j.$$Lambda$hba$HZGQqU9AStAw8BsOsfD8F74GLPU */
            private final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                hba.O000000o(hba.this, this.f$1, valueAnimator);
            }
        });
        iuh iuh = iuh.f1631O000000o;
        this.O00000o0 = ofInt;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.String, java.lang.Object]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    /* access modifiers changed from: private */
    public static final void O000000o(hba hba, String str, ValueAnimator valueAnimator) {
        ixe.O00000o(hba, "this$0");
        ixe.O00000o(str, "$format");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (ixe.O000000o((Object) hba.f18732O000000o, hba.O00000Oo.getTag())) {
            TextView textView = hba.O00000Oo;
            ixh ixh = ixh.f1644O000000o;
            String format = String.format(str, Arrays.copyOf(new Object[]{animatedValue}, 1));
            ixe.O00000Oo(format, "java.lang.String.format(format, *args)");
            textView.setText(format);
        }
    }

    public final void O000000o() {
        this.O00000o0.setIntValues(1, 91);
        this.O00000o0.start();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.String, java.lang.Object]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    public final void O00000Oo() {
        if (this.O00000o0.isStarted()) {
            this.O00000o0.end();
        }
        if (ixe.O000000o((Object) this.f18732O000000o, this.O00000Oo.getTag())) {
            this.O00000Oo.setVisibility(4);
        }
    }
}
