package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import com.google.android.play.core.assetpacks.model.AssetPackStatus;
import com.google.android.play.core.common.LocalTestingException;
import com.google.android.play.core.internal.aa;
import com.google.android.play.core.internal.aq;
import com.google.android.play.core.internal.ce;
import com.google.android.play.core.internal.h;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import com.google.android.play.core.tasks.i;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

final class db implements x {

    /* renamed from: a  reason: collision with root package name */
    private static final aa f3696a = new aa("FakeAssetPackService");
    private static final AtomicInteger h = new AtomicInteger(1);
    private final String b;
    private final ax c;
    private final cb d;
    private final Context e;
    private final dl f;
    private final ce<Executor> g;
    private final Handler i = new Handler(Looper.getMainLooper());

    db(File file, ax axVar, cb cbVar, Context context, dl dlVar, ce<Executor> ceVar) {
        this.b = file.getAbsolutePath();
        this.c = axVar;
        this.d = cbVar;
        this.e = context;
        this.f = dlVar;
        this.g = ceVar;
    }

    static long a(@AssetPackStatus int i2, long j) {
        if (i2 == 2) {
            return j / 2;
        }
        if (i2 == 3 || i2 == 4) {
            return j;
        }
        return 0;
    }

    private final AssetPackState a(String str, @AssetPackStatus int i2) throws LocalTestingException {
        long j = 0;
        for (File length : b(str)) {
            j += length.length();
        }
        return AssetPackState.a(str, i2, 0, a(i2, j), j, this.d.b(str));
    }

    private static String a(File file) throws LocalTestingException {
        try {
            return dd.a(Arrays.asList(file));
        } catch (NoSuchAlgorithmException e2) {
            throw new LocalTestingException("SHA256 algorithm not supported.", e2);
        } catch (IOException e3) {
            throw new LocalTestingException(String.format("Could not digest file: %s.", file), e3);
        }
    }

    private final void a(int i2, String str, @AssetPackStatus int i3) throws LocalTestingException {
        Bundle bundle = new Bundle();
        bundle.putInt("app_version_code", this.f.a());
        bundle.putInt("session_id", i2);
        File[] b2 = b(str);
        ArrayList arrayList = new ArrayList();
        long j = 0;
        for (File file : b2) {
            j += file.length();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(i3 == 3 ? new Intent().setData(Uri.EMPTY) : null);
            String a2 = aq.a(file);
            bundle.putParcelableArrayList(h.a("chunk_intents", str, a2), arrayList2);
            bundle.putString(h.a("uncompressed_hash_sha256", str, a2), a(file));
            bundle.putLong(h.a("uncompressed_size", str, a2), file.length());
            arrayList.add(a2);
        }
        bundle.putStringArrayList(h.a("slice_ids", str), arrayList);
        bundle.putLong(h.a("pack_version", str), (long) this.f.a());
        bundle.putInt(h.a("status", str), i3);
        bundle.putInt(h.a("error_code", str), 0);
        bundle.putLong(h.a("bytes_downloaded", str), a(i3, j));
        bundle.putLong(h.a("total_bytes_to_download", str), j);
        bundle.putStringArrayList("pack_names", new ArrayList(Arrays.asList(str)));
        bundle.putLong("bytes_downloaded", a(i3, j));
        bundle.putLong("total_bytes_to_download", j);
        this.i.post(new da(this, new Intent("com.google.android.play.core.assetpacks.receiver.ACTION_SESSION_UPDATE").putExtra("com.google.android.play.core.assetpacks.receiver.EXTRA_SESSION_STATE", bundle)));
    }

    private final File[] b(String str) throws LocalTestingException {
        File file = new File(this.b);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles(new cz(str));
            if (listFiles != null) {
                if (r1 != 0) {
                    for (File a2 : listFiles) {
                        if (aq.a(a2).equals(str)) {
                            return listFiles;
                        }
                    }
                    throw new LocalTestingException(String.format("No master slice available for pack '%s'.", str));
                }
                throw new LocalTestingException(String.format("No APKs available for pack '%s'.", str));
            }
            throw new LocalTestingException(String.format("Failed fetching APKs for pack '%s'.", str));
        }
        throw new LocalTestingException(String.format("Local testing directory '%s' not found.", file));
    }

    public final Task<AssetPackStates> a(List<String> list, ba baVar, Map<String, Long> map) {
        f3696a.c("getPackStates(%s)", list);
        i iVar = new i();
        this.g.a().execute(new cx(this, list, baVar, iVar));
        return iVar.a();
    }

    public final Task<AssetPackStates> a(List<String> list, List<String> list2, Map<String, Long> map) {
        f3696a.c("startDownload(%s)", list2);
        i iVar = new i();
        this.g.a().execute(new cw(this, list2, iVar, list));
        return iVar.a();
    }

    public final Task<List<String>> a(Map<String, Long> map) {
        f3696a.c("syncPacks()", new Object[0]);
        return Tasks.a(new ArrayList());
    }

    public final void a() {
        f3696a.c("keepAlive", new Object[0]);
    }

    public final void a(int i2) {
        f3696a.c("notifySessionFailed", new Object[0]);
    }

    public final void a(int i2, String str) {
        f3696a.c("notifyModuleCompleted", new Object[0]);
        this.g.a().execute(new cy(this, i2, str));
    }

    public final void a(int i2, String str, String str2, int i3) {
        f3696a.c("notifyChunkTransferred", new Object[0]);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void a(Intent intent) {
        this.c.a(this.e, intent);
    }

    public final void a(String str) {
        f3696a.c("removePack(%s)", str);
    }

    public final void a(List<String> list) {
        f3696a.c("cancelDownload(%s)", list);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void a(List list, ba baVar, i iVar) {
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        long j = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                AssetPackState a2 = a(str, baVar.a(8, str));
                j += a2.totalBytesToDownload();
                hashMap.put(str, a2);
            } catch (LocalTestingException e2) {
                iVar.a((Exception) e2);
                return;
            }
        }
        iVar.a(AssetPackStates.a(j, hashMap));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void a(List list, i iVar, List list2) {
        List list3 = list;
        i iVar2 = iVar;
        HashMap hashMap = new HashMap();
        int size = list.size();
        long j = 0;
        int i2 = 0;
        while (i2 < size) {
            String str = (String) list3.get(i2);
            try {
                AssetPackState a2 = a(str, 1);
                j += a2.totalBytesToDownload();
                hashMap.put(str, a2);
                i2++;
            } catch (LocalTestingException e2) {
                iVar2.a((Exception) e2);
                return;
            }
        }
        int size2 = list.size();
        int i3 = 0;
        while (i3 < size2) {
            String str2 = (String) list3.get(i3);
            try {
                int andIncrement = h.getAndIncrement();
                a(andIncrement, str2, 1);
                a(andIncrement, str2, 2);
                a(andIncrement, str2, 3);
                i3++;
            } catch (LocalTestingException e3) {
                iVar2.a((Exception) e3);
                return;
            }
        }
        int size3 = list2.size();
        for (int i4 = 0; i4 < size3; i4++) {
            String str3 = (String) list2.get(i4);
            hashMap.put(str3, AssetPackState.a(str3, 4, 0, 0, 0, 0.0d));
        }
        iVar2.a(AssetPackStates.a(j, hashMap));
    }

    public final Task<ParcelFileDescriptor> b(int i2, String str, String str2, int i3) {
        f3696a.c("getChunkFileDescriptor(session=%d, %s, %s, %d)", Integer.valueOf(i2), str, str2, Integer.valueOf(i3));
        i iVar = new i();
        try {
            File[] b2 = b(str);
            int length = b2.length;
            int i4 = 0;
            while (i4 < length) {
                File file = b2[i4];
                if (!aq.a(file).equals(str2)) {
                    i4++;
                } else {
                    iVar.a(ParcelFileDescriptor.open(file, 268435456));
                    return iVar.a();
                }
            }
            throw new LocalTestingException(String.format("Local testing slice for '%s' not found.", str2));
        } catch (FileNotFoundException e2) {
            f3696a.d("getChunkFileDescriptor failed", e2);
            iVar.a((Exception) new LocalTestingException("Asset Slice file not found.", e2));
        } catch (LocalTestingException e3) {
            f3696a.d("getChunkFileDescriptor failed", e3);
            iVar.a((Exception) e3);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void b(int i2, String str) {
        try {
            a(i2, str, 4);
        } catch (LocalTestingException e2) {
            f3696a.d("notifyModuleCompleted failed", e2);
        }
    }
}
