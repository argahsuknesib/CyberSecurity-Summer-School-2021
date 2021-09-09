package _m_j;

import _m_j.gsj;
import android.util.Log;
import com.xiaomi.smarthome.DownLoadQueue$Companion$instance$2;
import com.xiaomi.smarthome.device.api.ProgressCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SafePublicationLazyImpl;
import kotlin.SynchronizedLazyImpl;
import kotlin.UnsafeLazyImpl;
import kotlin.jvm.internal.PropertyReference1Impl;
import okhttp3.Response;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007J$\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J*\u0010\u000e\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007R(\u0010\u0003\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/xiaomi/smarthome/DownLoadQueue;", "", "()V", "requestCache", "", "", "", "Lcom/xiaomi/smarthome/device/api/ProgressCallback;", "Ljava/io/File;", "down", "", "file", "url", "callback", "downWithCache", "c", "Landroid/content/Context;", "Companion", "common-utils_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class exu {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f15933O000000o = new O000000o((byte) 0);
    public static final itz<exu> O00000o0;
    public final Map<String, List<ProgressCallback<File>>> O00000Oo;

    public /* synthetic */ exu(byte b) {
        this();
    }

    private exu() {
        this.O00000Oo = new LinkedHashMap();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/xiaomi/smarthome/DownLoadQueue$Companion;", "", "()V", "instance", "Lcom/xiaomi/smarthome/DownLoadQueue;", "getInstance", "()Lcom/xiaomi/smarthome/DownLoadQueue;", "instance$delegate", "Lkotlin/Lazy;", "common-utils_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ ixy<Object>[] f15934O000000o = {ixf.O000000o(new PropertyReference1Impl(ixf.O000000o(O000000o.class), "instance", "getInstance()Lcom/xiaomi/smarthome/DownLoadQueue;"))};

        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }

        public static exu O000000o() {
            return exu.O00000o0.O000000o();
        }
    }

    static {
        itz<exu> itz;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        iwb iwb = DownLoadQueue$Companion$instance$2.f4010O000000o;
        ixe.O00000o0(lazyThreadSafetyMode, "mode");
        ixe.O00000o0(iwb, "initializer");
        int i = iub.f1629O000000o[lazyThreadSafetyMode.ordinal()];
        if (i == 1) {
            itz = new SynchronizedLazyImpl<>(iwb);
        } else if (i == 2) {
            itz = new SafePublicationLazyImpl<>(iwb);
        } else if (i == 3) {
            itz = new UnsafeLazyImpl<>(iwb);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        O00000o0 = itz;
    }

    public final void O000000o(File file, String str, ProgressCallback<File> progressCallback) {
        if (file.exists()) {
            progressCallback.onSuccess(file);
            return;
        }
        ixe.O00000o(file, "file");
        if (str != null) {
            List list = this.O00000Oo.get(str);
            if (list == null) {
                List arrayList = new ArrayList();
                ((ArrayList) arrayList).add(progressCallback);
                this.O00000Oo.put(str, arrayList);
                try {
                    gsj.O000000o o000000o = new gsj.O000000o();
                    o000000o.f18212O000000o = "GET";
                    gsg.O000000o(o000000o.O00000Oo(str).O000000o(), new O00000Oo(this, str, file));
                } catch (Throwable th) {
                    file.delete();
                    if (progressCallback != null) {
                        progressCallback.onFailure(-2, Log.getStackTraceString(th));
                    }
                }
            } else if (progressCallback != null) {
                list.add(progressCallback);
            }
        } else if (progressCallback != null) {
            progressCallback.onFailure(-1, "url is null");
        }
    }

    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u001c\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u0011"}, d2 = {"com/xiaomi/smarthome/DownLoadQueue$down$1", "Lcom/xiaomi/smarthome/library/http/async/FileAsyncHandler;", "onFailure", "", "error", "Lcom/xiaomi/smarthome/library/http/Error;", "e", "Ljava/lang/Exception;", "response", "Lokhttp3/Response;", "onProgress", "bytesWritten", "", "totalSize", "onSuccess", "result", "Ljava/io/File;", "common-utils_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000Oo extends gsm {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ exu f15935O000000o;
        final /* synthetic */ String O00000Oo;
        final /* synthetic */ File O00000o0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        O00000Oo(exu exu, String str, File file) {
            super(file);
            this.f15935O000000o = exu;
            this.O00000Oo = str;
            this.O00000o0 = file;
        }

        public final /* synthetic */ void onSuccess(Object obj, Response response) {
            O000000o((File) obj);
        }

        public final void O000000o(File file) {
            List<ProgressCallback> remove = this.f15935O000000o.O00000Oo.remove(this.O00000Oo);
            if (remove != null) {
                for (ProgressCallback progressCallback : remove) {
                    if (progressCallback != null) {
                        progressCallback.onSuccess(file);
                    }
                }
            }
        }

        public final void onProgress(long j, long j2) {
            List<ProgressCallback> list = this.f15935O000000o.O00000Oo.get(this.O00000Oo);
            if (list != null) {
                for (ProgressCallback progressCallback : list) {
                    if (progressCallback != null) {
                        progressCallback.onProgress(j, j2);
                    }
                }
            }
        }

        public final void onFailure(gsf gsf, Exception exc, Response response) {
            this.O00000o0.delete();
            List<ProgressCallback> remove = this.f15935O000000o.O00000Oo.remove(this.O00000Oo);
            if (remove != null) {
                for (ProgressCallback progressCallback : remove) {
                    if (progressCallback != null) {
                        progressCallback.onFailure(-3, gsf + ' ' + Log.getStackTraceString(exc));
                    }
                }
            }
        }
    }
}
