package _m_j;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

public class cm {

    /* renamed from: O000000o  reason: collision with root package name */
    public final Object f14116O000000o;

    public cl O000000o(int i) {
        return null;
    }

    public boolean O000000o(int i, int i2, Bundle bundle) {
        return false;
    }

    public cl O00000Oo(int i) {
        return null;
    }

    static class O000000o extends AccessibilityNodeProvider {

        /* renamed from: O000000o  reason: collision with root package name */
        final cm f14117O000000o;

        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            return null;
        }

        O000000o(cm cmVar) {
            this.f14117O000000o = cmVar;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            cl O000000o2 = this.f14117O000000o.O000000o(i);
            if (O000000o2 == null) {
                return null;
            }
            return O000000o2.f13980O000000o;
        }

        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.f14117O000000o.O000000o(i, i2, bundle);
        }
    }

    static class O00000Oo extends O000000o {
        O00000Oo(cm cmVar) {
            super(cmVar);
        }

        public final AccessibilityNodeInfo findFocus(int i) {
            cl O00000Oo = this.f14117O000000o.O00000Oo(i);
            if (O00000Oo == null) {
                return null;
            }
            return O00000Oo.f13980O000000o;
        }
    }

    public cm() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f14116O000000o = new O00000Oo(this);
        } else if (Build.VERSION.SDK_INT >= 16) {
            this.f14116O000000o = new O000000o(this);
        } else {
            this.f14116O000000o = null;
        }
    }

    public cm(Object obj) {
        this.f14116O000000o = obj;
    }
}
