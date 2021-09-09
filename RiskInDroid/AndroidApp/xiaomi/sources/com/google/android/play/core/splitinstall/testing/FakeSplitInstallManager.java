package com.google.android.play.core.splitinstall.testing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.internal.aq;
import com.google.android.play.core.internal.bs;
import com.google.android.play.core.splitcompat.q;
import com.google.android.play.core.splitinstall.SplitInstallException;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallRequest;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import com.google.android.play.core.splitinstall.c;
import com.google.android.play.core.splitinstall.f;
import com.google.android.play.core.splitinstall.w;
import com.google.android.play.core.splitinstall.z;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class FakeSplitInstallManager implements SplitInstallManager {
    /* access modifiers changed from: private */
    public static final long b = TimeUnit.SECONDS.toMillis(1);

    /* renamed from: a  reason: collision with root package name */
    private final Handler f3829a;
    private final Context c;
    private final z d;
    private final bs e;
    /* access modifiers changed from: private */
    public final com.google.android.play.core.internal.z<SplitInstallSessionState> f;
    private final Executor g;
    private final c h;
    private final File i;
    private final AtomicReference<SplitInstallSessionState> j;
    /* access modifiers changed from: private */
    public final Set<String> k;
    /* access modifiers changed from: private */
    public final Set<String> l;
    /* access modifiers changed from: private */
    public final AtomicBoolean m;
    private final a n;

    @Deprecated
    public FakeSplitInstallManager(Context context, File file) {
        this(context, file, q.a());
    }

    public FakeSplitInstallManager(Context context, File file, Executor executor) {
        z zVar = new z(context, context.getPackageName());
        bs bsVar = new bs(context);
        a aVar = new a();
        this.f3829a = new Handler(Looper.getMainLooper());
        this.j = new AtomicReference<>();
        this.k = Collections.synchronizedSet(new HashSet());
        this.l = Collections.synchronizedSet(new HashSet());
        this.m = new AtomicBoolean(false);
        this.n = aVar;
        this.f = new com.google.android.play.core.internal.z<>();
        this.c = context;
        this.i = file;
        this.d = zVar;
        this.e = bsVar;
        this.g = executor;
        this.h = w.f3839a;
    }

    private final SplitInstallSessionState a(i iVar) {
        SplitInstallSessionState c2 = c();
        SplitInstallSessionState a2 = iVar.a(c2);
        if (!this.j.compareAndSet(c2, a2)) {
            return null;
        }
        return a2;
    }

    private static String a(String str) {
        return str.split("\\.config\\.", 2)[0];
    }

    private final void a(SplitInstallSessionState splitInstallSessionState) {
        this.f3829a.post(new f(this, splitInstallSessionState));
    }

    static /* synthetic */ void a(FakeSplitInstallManager fakeSplitInstallManager, List list, List list2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            File file = (File) list.get(i2);
            String a2 = aq.a(file);
            Uri fromFile = Uri.fromFile(file);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(fromFile, fakeSplitInstallManager.c.getContentResolver().getType(fromFile));
            intent.addFlags(1);
            intent.putExtra("module_name", a(a2));
            intent.putExtra("split_id", a2);
            arrayList.add(intent);
            arrayList2.add(a(aq.a(file)));
        }
        SplitInstallSessionState c2 = fakeSplitInstallManager.c();
        if (c2 != null) {
            fakeSplitInstallManager.g.execute(new g(fakeSplitInstallManager, c2.totalBytesToDownload(), arrayList, arrayList2, list2));
        }
    }

    /* access modifiers changed from: private */
    public final void a(List<Intent> list, List<String> list2, List<String> list3, long j2, boolean z) {
        this.h.a().a(list, new h(this, list2, list3, j2, z, list));
    }

    /* access modifiers changed from: private */
    public final boolean a(int i2, int i3, Long l2, Long l3, List<String> list, Integer num, List<String> list2) {
        SplitInstallSessionState a2 = a(new b(num, i2, i3, l2, l3, list, list2));
        if (a2 == null) {
            return false;
        }
        a(a2);
        return true;
    }

    private final SplitInstallSessionState c() {
        return this.j.get();
    }

    private final f d() {
        f c2 = this.d.c();
        if (c2 != null) {
            return c2;
        }
        throw new IllegalStateException("Language information could not be found. Make sure you are using the target application context, not the tests context, and the app is built as a bundle.");
    }

    /* access modifiers changed from: package-private */
    public final File a() {
        return this.i;
    }

    public final Task<Void> cancelInstall(int i2) {
        try {
            SplitInstallSessionState a2 = a(new e(i2));
            if (a2 != null) {
                a(a2);
            }
            return Tasks.a((Object) null);
        } catch (SplitInstallException e2) {
            return Tasks.a((Exception) e2);
        }
    }

    public final Task<Void> deferredInstall(List<String> list) {
        return Tasks.a((Exception) new SplitInstallException(-5));
    }

    public final Task<Void> deferredLanguageInstall(List<Locale> list) {
        return Tasks.a((Exception) new SplitInstallException(-5));
    }

    public final Task<Void> deferredLanguageUninstall(List<Locale> list) {
        return Tasks.a((Exception) new SplitInstallException(-5));
    }

    public final Task<Void> deferredUninstall(List<String> list) {
        return Tasks.a((Exception) new SplitInstallException(-5));
    }

    public final Set<String> getInstalledLanguages() {
        return new HashSet(this.l);
    }

    public final Set<String> getInstalledModules() {
        return new HashSet(this.k);
    }

    public final Task<SplitInstallSessionState> getSessionState(int i2) {
        SplitInstallSessionState c2 = c();
        return (c2 == null || c2.sessionId() != i2) ? Tasks.a((Exception) new SplitInstallException(-4)) : Tasks.a(c2);
    }

    public final Task<List<SplitInstallSessionState>> getSessionStates() {
        SplitInstallSessionState c2 = c();
        return Tasks.a(c2 == null ? Collections.emptyList() : Collections.singletonList(c2));
    }

    public final void registerListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.f.a(splitInstallStateUpdatedListener);
    }

    public void setShouldNetworkError(boolean z) {
        this.m.set(z);
    }

    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, Activity activity, int i2) throws IntentSender.SendIntentException {
        return false;
    }

    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, IntentSenderForResultStarter intentSenderForResultStarter, int i2) throws IntentSender.SendIntentException {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x01c9, code lost:
        if (r4.contains(r6) == false) goto L_0x01cb;
     */
    public final Task<Integer> startInstall(SplitInstallRequest splitInstallRequest) {
        int i2;
        File[] fileArr;
        String str;
        int i3;
        int i4;
        try {
            SplitInstallSessionState a2 = a(new d(splitInstallRequest));
            if (a2 == null) {
                return Tasks.a((Exception) new SplitInstallException(-100));
            }
            int sessionId = a2.sessionId();
            ArrayList arrayList = new ArrayList();
            for (Locale language : splitInstallRequest.getLanguages()) {
                arrayList.add(language.getLanguage());
            }
            HashSet hashSet = new HashSet();
            ArrayList arrayList2 = new ArrayList();
            File[] listFiles = this.i.listFiles();
            String str2 = "FakeSplitInstallManager";
            if (listFiles == null) {
                Log.w(str2, "Specified splits directory does not exist.");
                return Tasks.a((Exception) new SplitInstallException(-5));
            }
            int length = listFiles.length;
            long j2 = 0;
            long j3 = 0;
            int i5 = 0;
            while (i5 < length) {
                File file = listFiles[i5];
                String a3 = aq.a(file);
                if (!splitInstallRequest.getModuleNames().contains(a(a3))) {
                    i3 = sessionId;
                    fileArr = listFiles;
                    str = str2;
                    i2 = length;
                } else {
                    String a4 = a(a3);
                    i3 = sessionId;
                    HashSet<String> hashSet2 = new HashSet<>(this.e.a());
                    Map<String, Set<String>> a5 = d().a(Arrays.asList(a4));
                    HashSet hashSet3 = new HashSet();
                    for (Set<String> addAll : a5.values()) {
                        hashSet3.addAll(addAll);
                        listFiles = listFiles;
                    }
                    fileArr = listFiles;
                    HashSet hashSet4 = new HashSet();
                    for (String str3 : hashSet2) {
                        String str4 = str2;
                        if (str3.contains("_")) {
                            i4 = length;
                            str3 = str3.split("_", -1)[0];
                        } else {
                            i4 = length;
                        }
                        hashSet4.add(str3);
                        str2 = str4;
                        length = i4;
                    }
                    str = str2;
                    i2 = length;
                    hashSet4.addAll(this.l);
                    hashSet4.addAll(arrayList);
                    HashSet hashSet5 = new HashSet();
                    for (Map.Entry next : a5.entrySet()) {
                        if (hashSet4.contains(next.getKey())) {
                            hashSet5.addAll((Collection) next.getValue());
                        }
                    }
                    if (hashSet3.contains(a3)) {
                    }
                    j3 += file.length();
                    hashSet.add(aq.a(file));
                    arrayList2.add(file);
                    i5++;
                    sessionId = i3;
                    str2 = str;
                    listFiles = fileArr;
                    length = i2;
                    j2 = 0;
                }
                List<Locale> languages = splitInstallRequest.getLanguages();
                ArrayList arrayList3 = new ArrayList(this.k);
                arrayList3.addAll(Arrays.asList("", "base"));
                Map<String, Set<String>> a6 = d().a(arrayList3);
                Iterator<Locale> it = languages.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Locale next2 = it.next();
                    if (a6.containsKey(next2.getLanguage()) && a6.get(next2.getLanguage()).contains(a3)) {
                        break;
                    }
                }
                j3 += file.length();
                hashSet.add(aq.a(file));
                arrayList2.add(file);
                i5++;
                sessionId = i3;
                str2 = str;
                listFiles = fileArr;
                length = i2;
                j2 = 0;
            }
            String valueOf = String.valueOf(hashSet);
            String valueOf2 = String.valueOf(splitInstallRequest.getModuleNames());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 21 + String.valueOf(valueOf2).length());
            sb.append("availableSplits");
            sb.append(valueOf);
            sb.append(" want ");
            sb.append(valueOf2);
            Log.i(str2, sb.toString());
            if (!hashSet.containsAll(new HashSet(splitInstallRequest.getModuleNames()))) {
                return Tasks.a((Exception) new SplitInstallException(-2));
            }
            Long valueOf3 = Long.valueOf(j2);
            Long valueOf4 = Long.valueOf(j3);
            List<String> moduleNames = splitInstallRequest.getModuleNames();
            Integer valueOf5 = Integer.valueOf(sessionId);
            a(1, 0, valueOf3, valueOf4, moduleNames, valueOf5, arrayList);
            this.g.execute(new c(this, arrayList2, arrayList));
            return Tasks.a(valueOf5);
        } catch (SplitInstallException e2) {
            return Tasks.a((Exception) e2);
        }
    }

    public final void unregisterListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.f.b(splitInstallStateUpdatedListener);
    }
}
