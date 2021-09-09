package com.xiaomi.smarthome.newui;

import _m_j.ixe;
import androidx.viewpager.widget.ViewPager;
import java.util.Arrays;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nH\u0016J \u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aH&R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/xiaomi/smarthome/newui/OnPageChangeListenerWithIdleType;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "()V", "haveDragging", "", "getHaveDragging", "()Z", "setHaveDragging", "(Z)V", "lastPageScrollState", "", "getLastPageScrollState", "()I", "setLastPageScrollState", "(I)V", "onPageScrollStateChanged", "", "state", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "onStop", "reason", "Lcom/xiaomi/smarthome/newui/OnPageChangeListenerWithIdleType$Reason;", "Reason", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class OnPageChangeListenerWithIdleType implements ViewPager.O0000O0o {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f10116O000000o;
    private boolean O00000Oo;

    public abstract void O000000o(Reason reason);

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
    }

    public void onPageScrollStateChanged(int i) {
        if (!this.O00000Oo) {
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            this.O00000Oo = z;
        }
        if (i == 0) {
            if (this.O00000Oo) {
                O000000o(Reason.Slide);
            } else {
                O000000o(Reason.Click);
            }
            this.O00000Oo = false;
        }
        this.f10116O000000o = i;
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/smarthome/newui/OnPageChangeListenerWithIdleType$Reason;", "", "(Ljava/lang/String;I)V", "Click", "Slide", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Reason extends Enum<Reason> {
        private static final /* synthetic */ Reason[] $VALUES = $values();
        public static final Reason Click = new Reason("Click", 0);
        public static final Reason Slide = new Reason("Slide", 1);

        private static final /* synthetic */ Reason[] $values() {
            return new Reason[]{Click, Slide};
        }

        private Reason(String str, int i) {
        }

        public static Reason valueOf(String str) {
            ixe.O00000o(str, "value");
            return (Reason) Enum.valueOf(Reason.class, str);
        }

        public static Reason[] values() {
            Reason[] reasonArr = $VALUES;
            return (Reason[]) Arrays.copyOf(reasonArr, reasonArr.length);
        }
    }
}
