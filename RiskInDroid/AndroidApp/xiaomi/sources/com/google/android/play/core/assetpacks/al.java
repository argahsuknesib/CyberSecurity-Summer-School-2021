package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.t;
import com.google.android.play.core.tasks.i;
import java.util.List;

class al<T> extends t {

    /* renamed from: a  reason: collision with root package name */
    final i<T> f3637a;
    final /* synthetic */ as b;

    al(as asVar, i<T> iVar) {
        this.b = asVar;
        this.f3637a = iVar;
    }

    al(as asVar, i iVar, byte[] bArr) {
        this(asVar, iVar);
    }

    al(as asVar, i iVar, char[] cArr) {
        this(asVar, iVar);
    }

    al(as asVar, i iVar, int[] iArr) {
        this(asVar, iVar);
    }

    al(as asVar, i iVar, short[] sArr) {
        this(asVar, iVar);
    }

    public void a() {
        this.b.e.a();
        as.f3638a.c("onCancelDownloads()", new Object[0]);
    }

    public final void a(int i) {
        this.b.e.a();
        as.f3638a.c("onCancelDownload(%d)", Integer.valueOf(i));
    }

    public void a(int i, Bundle bundle) {
        this.b.e.a();
        as.f3638a.c("onStartDownload(%d)", Integer.valueOf(i));
    }

    public void a(Bundle bundle) {
        this.b.e.a();
        int i = bundle.getInt("error_code");
        as.f3638a.b("onError(%d)", Integer.valueOf(i));
        this.f3637a.b((Exception) new AssetPackException(i));
    }

    public void a(Bundle bundle, Bundle bundle2) {
        this.b.f.a();
        as.f3638a.c("onKeepAlive(%b)", Boolean.valueOf(bundle.getBoolean("keep_alive")));
    }

    public void a(List<Bundle> list) {
        this.b.e.a();
        as.f3638a.c("onGetSessionStates", new Object[0]);
    }

    public void b() {
        this.b.e.a();
        as.f3638a.c("onRemoveModule()", new Object[0]);
    }

    public final void b(int i) {
        this.b.e.a();
        as.f3638a.c("onGetSession(%d)", Integer.valueOf(i));
    }

    public void b(Bundle bundle) {
        this.b.e.a();
        as.f3638a.c("onNotifyChunkTransferred(%s, %s, %d, session=%d)", bundle.getString("module_name"), bundle.getString("slice_id"), Integer.valueOf(bundle.getInt("chunk_number")), Integer.valueOf(bundle.getInt("session_id")));
    }

    public void b(Bundle bundle, Bundle bundle2) throws RemoteException {
        this.b.e.a();
        as.f3638a.c("onGetChunkFileDescriptor", new Object[0]);
    }

    public void c(Bundle bundle) {
        this.b.e.a();
        as.f3638a.c("onNotifyModuleCompleted(%s, sessionId=%d)", bundle.getString("module_name"), Integer.valueOf(bundle.getInt("session_id")));
    }

    public void c(Bundle bundle, Bundle bundle2) {
        this.b.e.a();
        as.f3638a.c("onRequestDownloadInfo()", new Object[0]);
    }

    public void d(Bundle bundle) {
        this.b.e.a();
        as.f3638a.c("onNotifySessionFailed(%d)", Integer.valueOf(bundle.getInt("session_id")));
    }
}
