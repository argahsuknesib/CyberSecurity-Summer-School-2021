package com.xiaomi.smarthome.operation.js_sdk.statistics;

import _m_j.ez;
import _m_j.fa;
import _m_j.fi;
import _m_j.fm;
import _m_j.fo;
import _m_j.gsy;
import _m_j.hlc;
import _m_j.hxi;
import _m_j.hxr;
import _m_j.ixe;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.xiaomi.smarthome.operation.js_sdk.lifecycle.LifeCycleEvent;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 !2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002!\"B\u0005¢\u0006\u0002\u0010\u0004J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0018\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\rH\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\b\u0010\u001c\u001a\u00020\u000bH\u0002J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J\b\u0010\u001f\u001a\u00020\u000bH\u0002J\b\u0010 \u001a\u00020\u000bH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/xiaomi/smarthome/operation/js_sdk/statistics/WebViewDurationStatManager;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/xiaomi/smarthome/operation/js_sdk/lifecycle/WebViewLifeCycleDispatcher$onPageChangeListener;", "()V", "lastNode", "Lcom/xiaomi/smarthome/operation/js_sdk/statistics/WebViewDurationStatManager$DurationNode;", "lastRecordNode", "stack", "Ljava/util/Stack;", "changeTo", "", "webview", "Landroid/webkit/WebView;", "url", "", "notifyVisible", "isVisible", "", "onDestroy", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onPageChange", "event", "Lcom/xiaomi/smarthome/operation/js_sdk/lifecycle/LifeCycleEvent;", "target", "onPause", "onResume", "recordAndPopTopNode", "recordNode", "node", "recordTopNode", "updateTopNodeTimeStamp", "Companion", "DurationNode", "smarthome-webview_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class WebViewDurationStatManager extends fm implements ez, hlc.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f10524O000000o = new O000000o((byte) 0);
    public final Stack<O00000Oo> O00000Oo = new Stack<>();
    private O00000Oo O00000o;
    public O00000Oo O00000o0;

    public static final WebViewDurationStatManager O000000o(FragmentActivity fragmentActivity) {
        return O000000o.O000000o(fragmentActivity);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/xiaomi/smarthome/operation/js_sdk/statistics/WebViewDurationStatManager$Companion;", "", "()V", "TAG", "", "singletonWith", "Lcom/xiaomi/smarthome/operation/js_sdk/statistics/WebViewDurationStatManager;", "activity", "Landroidx/fragment/app/FragmentActivity;", "smarthome-webview_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }

        public static WebViewDurationStatManager O000000o(FragmentActivity fragmentActivity) {
            ixe.O00000o(fragmentActivity, "activity");
            fm O000000o2 = fo.O000000o(fragmentActivity).O000000o(WebViewDurationStatManager.class);
            ixe.O00000Oo(O000000o2, "of(activity).get(WebViewDurationStatManager::class.java)");
            return (WebViewDurationStatManager) O000000o2;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/xiaomi/smarthome/operation/js_sdk/statistics/WebViewDurationStatManager$DurationNode;", "", "pageId", "", "url", "", "stamp", "", "(ILjava/lang/String;J)V", "getPageId", "()I", "getStamp", "()J", "getUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "smarthome-webview_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public final int f10525O000000o;
        public final String O00000Oo;
        final long O00000o0;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof O00000Oo)) {
                return false;
            }
            O00000Oo o00000Oo = (O00000Oo) obj;
            return this.f10525O000000o == o00000Oo.f10525O000000o && ixe.O000000o(this.O00000Oo, o00000Oo.O00000Oo) && this.O00000o0 == o00000Oo.O00000o0;
        }

        public final int hashCode() {
            return (((Integer.valueOf(this.f10525O000000o).hashCode() * 31) + this.O00000Oo.hashCode()) * 31) + Long.valueOf(this.O00000o0).hashCode();
        }

        public final String toString() {
            return "DurationNode(pageId=" + this.f10525O000000o + ", url=" + this.O00000Oo + ", stamp=" + this.O00000o0 + ')';
        }

        public O00000Oo(int i, String str, long j) {
            ixe.O00000o(str, "url");
            this.f10525O000000o = i;
            this.O00000Oo = str;
            this.O00000o0 = j;
        }
    }

    public final void O000000o(LifeCycleEvent lifeCycleEvent, WebView webView) {
        int i;
        boolean z;
        ixe.O00000o(lifeCycleEvent, "event");
        ixe.O00000o(webView, "target");
        gsy.O00000Oo("WebViewDurationStatMana", "onPageChange: " + lifeCycleEvent + " , " + webView.hashCode());
        if (lifeCycleEvent == LifeCycleEvent.PAGE_PAUSE) {
            O00000o0();
        } else if (lifeCycleEvent == LifeCycleEvent.PAGE_RESUME && (!this.O00000Oo.isEmpty())) {
            List list = this.O00000Oo;
            ListIterator listIterator = list.listIterator(list.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    i = -1;
                    break;
                }
                if (((O00000Oo) listIterator.previous()).f10525O000000o == webView.hashCode()) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    i = listIterator.nextIndex();
                    break;
                }
            }
            if (i == this.O00000Oo.size() - 2) {
                O000000o();
                O00000Oo();
            }
        }
    }

    private final void O000000o(O00000Oo o00000Oo) {
        if (!ixe.O000000o(o00000Oo, this.O00000o)) {
            this.O00000o = o00000Oo;
            long currentTimeMillis = System.currentTimeMillis() - o00000Oo.O00000o0;
            hxr hxr = hxi.O00000oO;
            String str = o00000Oo.O00000Oo;
            hxr.f958O000000o.O000000o("web_h5_popup", "url", str, "duration", Long.valueOf(currentTimeMillis));
            gsy.O00000Oo("WebViewDurationStatMana", "log: " + o00000Oo + " ,duration: " + currentTimeMillis);
        }
    }

    @fi(O000000o = Lifecycle.Event.ON_RESUME)
    public final void onResume(fa faVar) {
        ixe.O00000o(faVar, "owner");
        gsy.O00000Oo("WebViewDurationStatMana", "onResume: ");
        O00000Oo();
    }

    @fi(O000000o = Lifecycle.Event.ON_PAUSE)
    public final void onPause(fa faVar) {
        ixe.O00000o(faVar, "owner");
        gsy.O00000Oo("WebViewDurationStatMana", "onPause: ");
        O00000o0();
    }

    @fi(O000000o = Lifecycle.Event.ON_DESTROY)
    public final void onDestroy(fa faVar) {
        ixe.O00000o(faVar, "owner");
        gsy.O00000Oo("WebViewDurationStatMana", "onDestroy: ");
        O00000o0();
        this.O00000Oo.clear();
    }

    private final void O00000Oo() {
        if (!this.O00000Oo.isEmpty()) {
            O00000Oo pop = this.O00000Oo.pop();
            this.O00000Oo.add(new O00000Oo(pop.f10525O000000o, pop.O00000Oo, System.currentTimeMillis()));
        }
    }

    private final void O00000o0() {
        if (!this.O00000Oo.isEmpty()) {
            O00000Oo peek = this.O00000Oo.peek();
            ixe.O00000Oo(peek, "stack.peek()");
            O000000o(peek);
        }
    }

    public final void O000000o() {
        if (!this.O00000Oo.isEmpty()) {
            O00000Oo pop = this.O00000Oo.pop();
            ixe.O00000Oo(pop, "stack.pop()");
            O000000o(pop);
        }
    }

    public final void O000000o(boolean z) {
        if (!this.O00000Oo.isEmpty()) {
            if (z) {
                O00000Oo();
            } else {
                O00000o0();
            }
        }
    }
}
