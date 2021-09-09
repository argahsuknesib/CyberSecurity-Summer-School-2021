package _m_j;

import _m_j.co;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.xiaomi.smarthome.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class cl {
    private static int O00000o;

    /* renamed from: O000000o  reason: collision with root package name */
    public final AccessibilityNodeInfo f13980O000000o;
    public int O00000Oo = -1;
    public int O00000o0 = -1;

    private static String O00000Oo(int i) {
        if (i == 1) {
            return "ACTION_FOCUS";
        }
        if (i == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i) {
            case 4:
                return "ACTION_SELECT";
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case NotificationCompat.FLAG_HIGH_PRIORITY:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case 16908354:
                return "ACTION_MOVE_WINDOW";
            default:
                switch (i) {
                    case 16908342:
                        return "ACTION_SHOW_ON_SCREEN";
                    case 16908343:
                        return "ACTION_SCROLL_TO_POSITION";
                    case 16908344:
                        return "ACTION_SCROLL_UP";
                    case 16908345:
                        return "ACTION_SCROLL_LEFT";
                    case 16908346:
                        return "ACTION_SCROLL_DOWN";
                    case 16908347:
                        return "ACTION_SCROLL_RIGHT";
                    case 16908348:
                        return "ACTION_CONTEXT_CLICK";
                    case 16908349:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i) {
                            case 16908356:
                                return "ACTION_SHOW_TOOLTIP";
                            case 16908357:
                                return "ACTION_HIDE_TOOLTIP";
                            case 16908358:
                                return "ACTION_PAGE_UP";
                            case 16908359:
                                return "ACTION_PAGE_DOWN";
                            case 16908360:
                                return "ACTION_PAGE_LEFT";
                            case 16908361:
                                return "ACTION_PAGE_RIGHT";
                            default:
                                return "ACTION_UNKNOWN";
                        }
                }
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final O000000o f13981O000000o = new O000000o(1, (CharSequence) null);
        public static final O000000o O00000Oo = new O000000o(2, (CharSequence) null);
        public static final O000000o O00000o = new O000000o(8, (CharSequence) null);
        public static final O000000o O00000o0 = new O000000o(4, (CharSequence) null);
        public static final O000000o O00000oO = new O000000o(16, (CharSequence) null);
        public static final O000000o O00000oo = new O000000o(32, (CharSequence) null);
        public static final O000000o O0000O0o = new O000000o(64, (CharSequence) null);
        public static final O000000o O0000OOo = new O000000o((int) NotificationCompat.FLAG_HIGH_PRIORITY, (CharSequence) null);
        public static final O000000o O0000Oo = new O000000o(512, co.O00000Oo.class);
        public static final O000000o O0000Oo0 = new O000000o(256, co.O00000Oo.class);
        public static final O000000o O0000OoO = new O000000o(1024, co.O00000o0.class);
        public static final O000000o O0000Ooo = new O000000o(2048, co.O00000o0.class);
        public static final O000000o O0000o = new O000000o(65536, (CharSequence) null);
        public static final O000000o O0000o0 = new O000000o(8192, (CharSequence) null);
        public static final O000000o O0000o00 = new O000000o(4096, (CharSequence) null);
        public static final O000000o O0000o0O = new O000000o(16384, (CharSequence) null);
        public static final O000000o O0000o0o = new O000000o(32768, (CharSequence) null);
        public static final O000000o O0000oO = new O000000o(262144, (CharSequence) null);
        public static final O000000o O0000oO0 = new O000000o(131072, co.O0000Oo0.class);
        public static final O000000o O0000oOO = new O000000o(524288, (CharSequence) null);
        public static final O000000o O0000oOo = new O000000o((int) ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES, (CharSequence) null);
        public static final O000000o O0000oo;
        public static final O000000o O0000oo0 = new O000000o(2097152, co.O0000Oo.class);
        public static final O000000o O0000ooO = new O000000o(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, 16908343, null, null, co.O0000O0o.class);
        public static final O000000o O0000ooo = new O000000o(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, 16908344, null, null, null);
        public static final O000000o O000O00o = new O000000o(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, 16908347, null, null, null);
        public static final O000000o O000O0OO = new O000000o(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, 16908358, null, null, null);
        public static final O000000o O000O0Oo = new O000000o(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, 16908359, null, null, null);
        public static final O000000o O000O0o;
        public static final O000000o O000O0o0 = new O000000o(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, 16908361, null, null, null);
        public static final O000000o O000O0oO;
        public static final O000000o O000O0oo = new O000000o(Build.VERSION.SDK_INT >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, 16908354, null, null, co.O00000o.class);
        public static final O000000o O000OO00 = new O000000o(Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, 16908356, null, null, null);
        public static final O000000o O000OO0o;
        public static final O000000o O00oOoOo = new O000000o(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, 16908360, null, null, null);
        public static final O000000o O00oOooO = new O000000o(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, 16908345, null, null, null);
        public static final O000000o O00oOooo = new O000000o(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, 16908346, null, null, null);
        final Object O000OO;
        public final int O000OOOo;
        protected final co O000OOo;
        public final Class<? extends co.O000000o> O000OOo0;

        static {
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction2;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction3;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction4 = null;
            if (Build.VERSION.SDK_INT >= 23) {
                accessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN;
            } else {
                accessibilityAction = null;
            }
            O0000oo = new O000000o(accessibilityAction, 16908342, null, null, null);
            if (Build.VERSION.SDK_INT >= 23) {
                accessibilityAction2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;
            } else {
                accessibilityAction2 = null;
            }
            O000O0o = new O000000o(accessibilityAction2, 16908348, null, null, null);
            if (Build.VERSION.SDK_INT >= 24) {
                accessibilityAction3 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
            } else {
                accessibilityAction3 = null;
            }
            O000O0oO = new O000000o(accessibilityAction3, 16908349, null, null, co.O0000OOo.class);
            if (Build.VERSION.SDK_INT >= 28) {
                accessibilityAction4 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
            }
            O000OO0o = new O000000o(accessibilityAction4, 16908357, null, null, null);
        }

        public O000000o(int i, CharSequence charSequence) {
            this(null, i, charSequence, null, null);
        }

        public O000000o(int i, CharSequence charSequence, co coVar) {
            this(null, i, charSequence, coVar, null);
        }

        O000000o(Object obj) {
            this(obj, 0, null, null, null);
        }

        private O000000o(int i, Class<? extends co.O000000o> cls) {
            this(null, i, null, null, cls);
        }

        public O000000o(Object obj, int i, CharSequence charSequence, co coVar, Class<? extends co.O000000o> cls) {
            this.O000OOOo = i;
            this.O000OOo = coVar;
            if (Build.VERSION.SDK_INT < 21 || obj != null) {
                this.O000OO = obj;
            } else {
                this.O000OO = new AccessibilityNodeInfo.AccessibilityAction(i, charSequence);
            }
            this.O000OOo0 = cls;
        }

        public final int O000000o() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.O000OO).getId();
            }
            return 0;
        }

        public final CharSequence O00000Oo() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.O000OO).getLabel();
            }
            return null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0024  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0027  */
        public final boolean O000000o(View view, Bundle bundle) {
            Class<? extends co.O000000o> cls;
            String str;
            if (this.O000OOo == null) {
                return false;
            }
            co.O000000o o000000o = null;
            Class<? extends co.O000000o> cls2 = this.O000OOo0;
            if (cls2 != null) {
                try {
                    co.O000000o o000000o2 = (co.O000000o) cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    try {
                        o000000o2.f14162O000000o = bundle;
                        o000000o = o000000o2;
                    } catch (Exception e) {
                        e = e;
                        o000000o = o000000o2;
                        cls = this.O000OOo0;
                        if (cls != null) {
                        }
                        Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: ".concat(String.valueOf(str)), e);
                        return this.O000OOo.perform(view, o000000o);
                    }
                } catch (Exception e2) {
                    e = e2;
                    cls = this.O000OOo0;
                    if (cls != null) {
                        str = "null";
                    } else {
                        str = cls.getName();
                    }
                    Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: ".concat(String.valueOf(str)), e);
                    return this.O000OOo.perform(view, o000000o);
                }
            }
            return this.O000OOo.perform(view, o000000o);
        }

        public final int hashCode() {
            Object obj = this.O000OO;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof O000000o)) {
                return false;
            }
            O000000o o000000o = (O000000o) obj;
            Object obj2 = this.O000OO;
            if (obj2 == null) {
                if (o000000o.O000OO != null) {
                    return false;
                }
                return true;
            } else if (!obj2.equals(o000000o.O000OO)) {
                return false;
            } else {
                return true;
            }
        }
    }

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        final Object f13982O000000o;

        public static O00000Oo O000000o(int i, int i2, boolean z, int i3) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new O00000Oo(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                return new O00000Oo(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z));
            }
            return new O00000Oo(null);
        }

        public O00000Oo(Object obj) {
            this.f13982O000000o = obj;
        }
    }

    public static class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        final Object f13984O000000o;

        public static O00000o0 O000000o(int i, int i2, int i3, int i4, boolean z) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new O00000o0(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, false, z));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                return new O00000o0(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, false));
            }
            return new O00000o0(null);
        }

        public O00000o0(Object obj) {
            this.f13984O000000o = obj;
        }
    }

    public static class O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final Object f13983O000000o;

        public O00000o(Object obj) {
            this.f13983O000000o = obj;
        }
    }

    private cl(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f13980O000000o = accessibilityNodeInfo;
    }

    public static cl O000000o(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new cl(accessibilityNodeInfo);
    }

    public static cl O000000o(View view) {
        return O000000o(AccessibilityNodeInfo.obtain(view));
    }

    public static cl O000000o() {
        return O000000o(AccessibilityNodeInfo.obtain());
    }

    public static cl O000000o(cl clVar) {
        return O000000o(AccessibilityNodeInfo.obtain(clVar.f13980O000000o));
    }

    public final void O00000Oo(View view) {
        this.O00000o0 = -1;
        this.f13980O000000o.setSource(view);
    }

    public final void O00000o0(View view) {
        this.f13980O000000o.addChild(view);
    }

    public final void O000000o(int i) {
        this.f13980O000000o.addAction(i);
    }

    public final List<Integer> O000000o(String str) {
        if (Build.VERSION.SDK_INT < 19) {
            return new ArrayList();
        }
        ArrayList<Integer> integerArrayList = this.f13980O000000o.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList arrayList = new ArrayList();
        this.f13980O000000o.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    public final void O000000o(O000000o o000000o) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f13980O000000o.addAction((AccessibilityNodeInfo.AccessibilityAction) o000000o.O000OO);
        }
    }

    public final boolean O00000Oo(O000000o o000000o) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.f13980O000000o.removeAction((AccessibilityNodeInfo.AccessibilityAction) o000000o.O000OO);
        }
        return false;
    }

    public final void O00000o(View view) {
        this.O00000Oo = -1;
        this.f13980O000000o.setParent(view);
    }

    @Deprecated
    public final void O000000o(Rect rect) {
        this.f13980O000000o.getBoundsInParent(rect);
    }

    @Deprecated
    public final void O00000Oo(Rect rect) {
        this.f13980O000000o.setBoundsInParent(rect);
    }

    public final void O00000o0(Rect rect) {
        this.f13980O000000o.getBoundsInScreen(rect);
    }

    public final void O00000o(Rect rect) {
        this.f13980O000000o.setBoundsInScreen(rect);
    }

    public final void O000000o(boolean z) {
        this.f13980O000000o.setCheckable(z);
    }

    public final void O00000Oo(boolean z) {
        this.f13980O000000o.setChecked(z);
    }

    public final void O00000o0(boolean z) {
        this.f13980O000000o.setFocusable(z);
    }

    public final void O00000o(boolean z) {
        this.f13980O000000o.setFocused(z);
    }

    public final boolean O00000Oo() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f13980O000000o.isVisibleToUser();
        }
        return false;
    }

    public final void O00000oO(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f13980O000000o.setVisibleToUser(z);
        }
    }

    public final boolean O00000o0() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f13980O000000o.isAccessibilityFocused();
        }
        return false;
    }

    public final void O00000oo(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f13980O000000o.setAccessibilityFocused(z);
        }
    }

    public final void O0000O0o(boolean z) {
        this.f13980O000000o.setSelected(z);
    }

    public final void O0000OOo(boolean z) {
        this.f13980O000000o.setClickable(z);
    }

    public final void O0000Oo0(boolean z) {
        this.f13980O000000o.setLongClickable(z);
    }

    public final void O0000Oo(boolean z) {
        this.f13980O000000o.setEnabled(z);
    }

    public final void O0000OoO(boolean z) {
        this.f13980O000000o.setScrollable(z);
    }

    public final void O000000o(CharSequence charSequence) {
        this.f13980O000000o.setPackageName(charSequence);
    }

    public final void O00000Oo(CharSequence charSequence) {
        this.f13980O000000o.setClassName(charSequence);
    }

    public final void O00000o0(CharSequence charSequence) {
        this.f13980O000000o.setText(charSequence);
    }

    public static SparseArray<WeakReference<ClickableSpan>> O00000oO(View view) {
        return (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
    }

    public static ClickableSpan[] O00000o(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    public static int O000000o(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i = 0; i < sparseArray.size(); i++) {
                if (clickableSpan.equals((ClickableSpan) sparseArray.valueAt(i).get())) {
                    return sparseArray.keyAt(i);
                }
            }
        }
        int i2 = O00000o;
        O00000o = i2 + 1;
        return i2;
    }

    public final void O00000oO(CharSequence charSequence) {
        this.f13980O000000o.setContentDescription(charSequence);
    }

    public final void O000000o(Object obj) {
        AccessibilityNodeInfo.CollectionInfo collectionInfo;
        if (Build.VERSION.SDK_INT >= 19) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.f13980O000000o;
            if (obj == null) {
                collectionInfo = null;
            } else {
                collectionInfo = (AccessibilityNodeInfo.CollectionInfo) ((O00000Oo) obj).f13982O000000o;
            }
            accessibilityNodeInfo.setCollectionInfo(collectionInfo);
        }
    }

    public final void O00000Oo(Object obj) {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo;
        if (Build.VERSION.SDK_INT >= 19) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.f13980O000000o;
            if (obj == null) {
                collectionItemInfo = null;
            } else {
                collectionItemInfo = (AccessibilityNodeInfo.CollectionItemInfo) ((O00000o0) obj).f13984O000000o;
            }
            accessibilityNodeInfo.setCollectionItemInfo(collectionItemInfo);
        }
    }

    private List<O000000o> O00000oo() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = Build.VERSION.SDK_INT >= 21 ? this.f13980O000000o.getActionList() : null;
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new O000000o(actionList.get(i)));
        }
        return arrayList;
    }

    public final void O00000oo(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f13980O000000o.setHintText(charSequence);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.f13980O000000o.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    public final Bundle O00000oO() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.f13980O000000o.getExtras();
        }
        return new Bundle();
    }

    public final void O0000Ooo(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f13980O000000o.setDismissable(z);
        }
    }

    public final void O0000O0o(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f13980O000000o.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", charSequence);
        }
    }

    public final int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f13980O000000o;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof cl)) {
            return false;
        }
        cl clVar = (cl) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f13980O000000o;
        if (accessibilityNodeInfo == null) {
            if (clVar.f13980O000000o != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(clVar.f13980O000000o)) {
            return false;
        }
        return this.O00000o0 == clVar.O00000o0 && this.O00000Oo == clVar.O00000Oo;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        O000000o(rect);
        sb.append("; boundsInParent: ".concat(String.valueOf(rect)));
        O00000o0(rect);
        sb.append("; boundsInScreen: ".concat(String.valueOf(rect)));
        sb.append("; packageName: ");
        sb.append(this.f13980O000000o.getPackageName());
        sb.append("; className: ");
        sb.append(this.f13980O000000o.getClassName());
        sb.append("; text: ");
        sb.append(O00000o());
        sb.append("; contentDescription: ");
        sb.append(this.f13980O000000o.getContentDescription());
        sb.append("; viewId: ");
        sb.append(Build.VERSION.SDK_INT >= 18 ? this.f13980O000000o.getViewIdResourceName() : null);
        sb.append("; checkable: ");
        sb.append(this.f13980O000000o.isCheckable());
        sb.append("; checked: ");
        sb.append(this.f13980O000000o.isChecked());
        sb.append("; focusable: ");
        sb.append(this.f13980O000000o.isFocusable());
        sb.append("; focused: ");
        sb.append(this.f13980O000000o.isFocused());
        sb.append("; selected: ");
        sb.append(this.f13980O000000o.isSelected());
        sb.append("; clickable: ");
        sb.append(this.f13980O000000o.isClickable());
        sb.append("; longClickable: ");
        sb.append(this.f13980O000000o.isLongClickable());
        sb.append("; enabled: ");
        sb.append(this.f13980O000000o.isEnabled());
        sb.append("; password: ");
        sb.append(this.f13980O000000o.isPassword());
        sb.append("; scrollable: " + this.f13980O000000o.isScrollable());
        sb.append("; [");
        if (Build.VERSION.SDK_INT >= 21) {
            List<O000000o> O00000oo = O00000oo();
            for (int i = 0; i < O00000oo.size(); i++) {
                O000000o o000000o = O00000oo.get(i);
                String O00000Oo2 = O00000Oo(o000000o.O000000o());
                if (O00000Oo2.equals("ACTION_UNKNOWN") && o000000o.O00000Oo() != null) {
                    O00000Oo2 = o000000o.O00000Oo().toString();
                }
                sb.append(O00000Oo2);
                if (i != O00000oo.size() - 1) {
                    sb.append(", ");
                }
            }
        } else {
            int actions = this.f13980O000000o.getActions();
            while (actions != 0) {
                int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(actions);
                actions &= numberOfTrailingZeros ^ -1;
                sb.append(O00000Oo(numberOfTrailingZeros));
                if (actions != 0) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public final void O000000o(int i, boolean z) {
        Bundle O00000oO = O00000oO();
        if (O00000oO != null) {
            int i2 = O00000oO.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (i ^ -1);
            if (!z) {
                i = 0;
            }
            O00000oO.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i | i2);
        }
    }

    public final CharSequence O00000o() {
        if (!(!O000000o("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty())) {
            return this.f13980O000000o.getText();
        }
        List<Integer> O000000o2 = O000000o("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List<Integer> O000000o3 = O000000o("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List<Integer> O000000o4 = O000000o("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List<Integer> O000000o5 = O000000o("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f13980O000000o.getText(), 0, this.f13980O000000o.getText().length()));
        for (int i = 0; i < O000000o2.size(); i++) {
            spannableString.setSpan(new cj(O000000o5.get(i).intValue(), this, O00000oO().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), O000000o2.get(i).intValue(), O000000o3.get(i).intValue(), O000000o4.get(i).intValue());
        }
        return spannableString;
    }
}
