package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import java.util.List;

class MediaBrowserCompatApi21 {

    interface ConnectionCallback {
        void onConnected();

        void onConnectionFailed();

        void onConnectionSuspended();
    }

    interface SubscriptionCallback {
        void onChildrenLoaded(String str, List<?> list);

        void onError(String str);
    }

    public static Object createConnectionCallback(ConnectionCallback connectionCallback) {
        return new ConnectionCallbackProxy(connectionCallback);
    }

    public static Object createBrowser(Context context, ComponentName componentName, Object obj, Bundle bundle) {
        return new MediaBrowser(context, componentName, (MediaBrowser.ConnectionCallback) obj, bundle);
    }

    public static void connect(Object obj) {
        ((MediaBrowser) obj).connect();
    }

    public static void disconnect(Object obj) {
        ((MediaBrowser) obj).disconnect();
    }

    public static boolean isConnected(Object obj) {
        return ((MediaBrowser) obj).isConnected();
    }

    public static ComponentName getServiceComponent(Object obj) {
        return ((MediaBrowser) obj).getServiceComponent();
    }

    public static String getRoot(Object obj) {
        return ((MediaBrowser) obj).getRoot();
    }

    public static Bundle getExtras(Object obj) {
        return ((MediaBrowser) obj).getExtras();
    }

    public static Object getSessionToken(Object obj) {
        return ((MediaBrowser) obj).getSessionToken();
    }

    public static Object createSubscriptionCallback(SubscriptionCallback subscriptionCallback) {
        return new SubscriptionCallbackProxy(subscriptionCallback);
    }

    public static void subscribe(Object obj, String str, Object obj2) {
        ((MediaBrowser) obj).subscribe(str, (MediaBrowser.SubscriptionCallback) obj2);
    }

    public static void unsubscribe(Object obj, String str) {
        ((MediaBrowser) obj).unsubscribe(str);
    }

    static class ConnectionCallbackProxy<T extends ConnectionCallback> extends MediaBrowser.ConnectionCallback {
        protected final T mConnectionCallback;

        public ConnectionCallbackProxy(T t) {
            this.mConnectionCallback = t;
        }

        public void onConnected() {
            this.mConnectionCallback.onConnected();
        }

        public void onConnectionSuspended() {
            this.mConnectionCallback.onConnectionSuspended();
        }

        public void onConnectionFailed() {
            this.mConnectionCallback.onConnectionFailed();
        }
    }

    static class SubscriptionCallbackProxy<T extends SubscriptionCallback> extends MediaBrowser.SubscriptionCallback {
        protected final T mSubscriptionCallback;

        public SubscriptionCallbackProxy(T t) {
            this.mSubscriptionCallback = t;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
            	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
            	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
            	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
            	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
            	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
            	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
            */
        public void onChildrenLoaded(java.lang.String r2, java.util.List<android.media.browse.MediaBrowser.MediaItem> r3) {
            /*
                r1 = this;
                T r0 = r1.mSubscriptionCallback
                r0.onChildrenLoaded(r2, r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserCompatApi21.SubscriptionCallbackProxy.onChildrenLoaded(java.lang.String, java.util.List):void");
        }

        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
            	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
            	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
            	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
            	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
            	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
            	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
            */
        public void onError(java.lang.String r2) {
            /*
                r1 = this;
                T r0 = r1.mSubscriptionCallback
                r0.onError(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserCompatApi21.SubscriptionCallbackProxy.onError(java.lang.String):void");
        }
    }

    static class MediaItem {
        public static int getFlags(Object obj) {
            return ((MediaBrowser.MediaItem) obj).getFlags();
        }

        public static Object getDescription(Object obj) {
            return ((MediaBrowser.MediaItem) obj).getDescription();
        }

        private MediaItem() {
        }
    }

    private MediaBrowserCompatApi21() {
    }
}
