package _m_j;

import _m_j.ile;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest$1;
import com.ximalaya.ting.android.opensdk.httputil.Config;
import com.ximalaya.ting.android.opensdk.httputil.XimalayaException;
import com.ximalaya.ting.android.opensdk.model.advertis.AdvertisList;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayListControl;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerService;
import com.ximalaya.ting.android.opensdk.util.EncryptUtilForSDK;
import com.ximalaya.ting.android.opensdk.util.NetworkType;
import com.ximalaya.ting.android.opensdk.util.dh.DhKeyPair;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class iit {
    public static int O00000o0 = 20;
    public static Handler O00000oo = new Handler(Looper.getMainLooper());
    public static ijb O0000O0o = new ijb(O00000oo);
    private static iit O0000Ooo;
    private static O000000o<ijy> O0000oOo = new O000000o<ijy>() {
        /* class _m_j.iit.AnonymousClass11 */

        public final /* synthetic */ Object O000000o(String str) throws Exception {
            return O00000Oo(str);
        }

        private static ijy O00000Oo(String str) throws Exception {
            byte[] bArr;
            DhKeyPair O000000o2;
            ijy ijy = (ijy) new Gson().fromJson(str, ijy.class);
            boolean z = ijy != null && ijy.f1379O000000o;
            ijg O000000o3 = ijg.O000000o();
            if (ijy != null) {
                if (!O000000o3.O00000Oo() && (O000000o2 = ilh.O000000o()) != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("c_pub_key", O000000o2.publicKey.toString());
                    O000000o3.O000000o(iit.O00000o0(hashMap));
                }
                if (z) {
                    bArr = Base64.decode("E0kmVeFAbSqiuv2ZSi0AKw==", 0);
                } else if (O000000o3.O00000Oo()) {
                    bArr = ijg.O000000o(ilh.O000000o(O000000o3.f1360O000000o, ilh.O000000o())).getBytes();
                }
                if (bArr != null) {
                    try {
                        ijy.O00000oO = ild.O000000o(ijg.O00000Oo(ijy.O00000oO), bArr);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    try {
                        ijy.O00000Oo = ild.O000000o(ijg.O00000Oo(ijy.O00000Oo), bArr);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    try {
                        ijy.O00000o0 = ild.O000000o(ijg.O00000Oo(ijy.O00000o0), bArr);
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                    try {
                        ijy.O00000o = ild.O000000o(ijg.O00000Oo(ijy.O00000o), bArr);
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                    try {
                        ijy.O00000oo = ild.O000000o(ijg.O00000Oo(ijy.O00000oo), bArr);
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                    try {
                        ijy.O0000O0o = ild.O000000o(ijg.O00000Oo(ijy.O0000O0o), bArr);
                    } catch (Throwable th6) {
                        th6.printStackTrace();
                    }
                }
            }
            return ijy;
        }
    };
    private static String O0000oo0;

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f1325O000000o = null;
    public String O00000Oo;
    public String O00000o = "";
    public String O00000oO = "";
    public Config O0000OOo = null;
    public O00000o0 O0000Oo;
    public Set<String> O0000Oo0 = new HashSet();
    public String O0000OoO;
    private String O0000o = "";
    private String O0000o0 = "";
    private String O0000o00 = "";
    private String O0000o0O = "";
    private String O0000o0o = "";
    private final Set<String> O0000oO = new CommonRequest$1(this);
    private String O0000oO0 = "";
    private boolean O0000oOO = false;

    public interface O000000o<T> {
        T O000000o(String str) throws Exception;
    }

    public interface O00000Oo {
        boolean O000000o();

        boolean O00000Oo();

        void O00000o0();
    }

    public static class O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static String f1349O000000o = "http://api.ximalaya.com/openapi-gateway-app/albums/browse";
        public static String O00000Oo = "http://api.ximalaya.com/openapi-gateway-app/tracks/hot";
        public static String O00000o = "http://api.ximalaya.com/openapi-gateway-app/tracks/get_batch";
        public static String O00000o0 = "http://api.ximalaya.com/openapi-gateway-app/search/tracks";
    }

    private iit() {
    }

    public static String O000000o(String str) {
        return str.substring(str.indexOf("/", 7), str.length());
    }

    public static iit O000000o() {
        if (O0000Ooo == null) {
            synchronized (iit.class) {
                if (O0000Ooo == null) {
                    O0000Ooo = new iit();
                }
            }
        }
        return O0000Ooo;
    }

    public final void O000000o(O00000Oo o00000Oo) {
        if (o00000Oo != null) {
            this.O0000Oo = new O00000o0(o00000Oo);
            if (ilg.O000000o(this.f1325O000000o)) {
                ikd O000000o2 = ikd.O000000o(this.f1325O000000o);
                O00000o0 o00000o0 = this.O0000Oo;
                if (!O000000o2.O000000o()) {
                    return;
                }
                if (o00000o0 != null) {
                    try {
                        O000000o2.f1381O000000o.setTokenInvalidForSDK(O000000o2.O0000o0O);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                } else {
                    O000000o2.f1381O000000o.setTokenInvalidForSDK(null);
                }
            }
        } else {
            this.O0000Oo = null;
        }
    }

    public static class O00000o0 implements O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        private O00000Oo f1350O000000o;
        private long O00000Oo;

        public O00000o0(O00000Oo o00000Oo) {
            this.f1350O000000o = o00000Oo;
        }

        public final boolean O000000o() {
            O00000Oo o00000Oo = this.f1350O000000o;
            if (o00000Oo != null) {
                return o00000Oo.O000000o();
            }
            return false;
        }

        public final boolean O00000Oo() {
            O00000Oo o00000Oo = this.f1350O000000o;
            if (o00000Oo != null) {
                return o00000Oo.O00000Oo();
            }
            return false;
        }

        public final void O00000o0() {
            if (System.currentTimeMillis() - this.O00000Oo > 1000) {
                this.O00000Oo = System.currentTimeMillis();
                O00000Oo o00000Oo = this.f1350O000000o;
                if (o00000Oo != null) {
                    o00000Oo.O00000o0();
                }
            }
        }
    }

    public final void O000000o(Context context, String str) {
        this.f1325O000000o = context.getApplicationContext();
        this.O00000Oo = str;
        iis O000000o2 = iis.O000000o();
        O000000o2.O00000o0 = this.O0000Oo;
        O000000o2.O000000o(context);
        if (ikz.O000000o(context).O00000oO()) {
            iiz.O000000o().O000000o(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0026: INVOKE  
                  (wrap: _m_j.iiz : 0x001d: INVOKE  (r2v5 _m_j.iiz) =  type: STATIC call: _m_j.iiz.O000000o():_m_j.iiz)
                  (wrap: _m_j.ijc$2 : 0x0023: CONSTRUCTOR  (r3v4 _m_j.ijc$2) =  call: _m_j.ijc.2.<init>():void type: CONSTRUCTOR)
                 type: VIRTUAL call: _m_j.iiz.O000000o(okhttp3.Interceptor):void in method: _m_j.iit.O000000o(android.content.Context, java.lang.String):void, dex: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0023: CONSTRUCTOR  (r3v4 _m_j.ijc$2) =  call: _m_j.ijc.2.<init>():void type: CONSTRUCTOR in method: _m_j.iit.O000000o(android.content.Context, java.lang.String):void, dex: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 36 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: _m_j.ijc, state: NOT_LOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 42 more
                */
            /*
                this = this;
                android.content.Context r0 = r2.getApplicationContext()
                r1.f1325O000000o = r0
                r1.O00000Oo = r3
                _m_j.iis r3 = _m_j.iis.O000000o()
                _m_j.iit$O00000o0 r0 = r1.O0000Oo
                r3.O00000o0 = r0
                r3.O000000o(r2)
                _m_j.ikz r2 = _m_j.ikz.O000000o(r2)
                boolean r2 = r2.O00000oO()
                if (r2 == 0) goto L_0x0029
                _m_j.iiz r2 = _m_j.iiz.O000000o()
                _m_j.ijc$2 r3 = new _m_j.ijc$2
                r3.<init>()
                r2.O000000o(r3)
            L_0x0029:
                com.ximalaya.ting.android.opensdk.util.EncryptUtilForSDK r2 = com.ximalaya.ting.android.opensdk.util.EncryptUtilForSDK.O00000Oo()
                android.content.Context r3 = r1.f1325O000000o
                r2.O000000o(r3)
                _m_j.ijg r2 = _m_j.ijg.O000000o()
                android.content.Context r3 = r1.f1325O000000o
                r2.O000000o(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: _m_j.iit.O000000o(android.content.Context, java.lang.String):void");
        }

        private Context O0000Oo0() throws XimalayaException {
            Context context = this.f1325O000000o;
            if (context != null) {
                return context.getApplicationContext();
            }
            throw XimalayaException.getExceptionByCode(1004);
        }

        public final String O00000Oo() throws XimalayaException {
            if (TextUtils.isEmpty(this.O00000o)) {
                try {
                    this.O00000o = O0000Oo0().getPackageManager().getApplicationInfo(O0000Oo0().getPackageName(), NotificationCompat.FLAG_HIGH_PRIORITY).metaData.getString("app_key");
                } catch (XimalayaException e) {
                    throw e;
                } catch (Exception e2) {
                    ilk.O000000o(e2);
                    throw XimalayaException.getExceptionByCode(1005);
                }
            }
            if (!TextUtils.isEmpty(this.O00000o)) {
                return this.O00000o;
            }
            throw XimalayaException.getExceptionByCode(1005);
        }

        @SuppressLint({"WifiManagerLeak"})
        private String O0000Oo() throws XimalayaException {
            if (TextUtils.isEmpty(this.O0000o0)) {
                this.O0000o0 = ((WifiManager) O0000Oo0().getSystemService("wifi")).getConnectionInfo().getMacAddress();
            }
            if (!TextUtils.isEmpty(this.O0000o0)) {
                return this.O0000o0;
            }
            throw new XimalayaException(1006, "get mac address error");
        }

        public final String O00000o0() {
            if (!TextUtils.isEmpty(this.O0000OoO)) {
                return this.O0000OoO;
            }
            try {
                String str = Build.MANUFACTURER;
                if (!TextUtils.isEmpty(str)) {
                    this.O0000OoO = URLEncoder.encode(str, "utf-8");
                }
            } catch (Exception unused) {
            }
            return this.O0000OoO;
        }

        public static String O00000Oo(String str) {
            if (str == null || str.startsWith("https") || !str.startsWith("http") || ilg.O000000o() || !O000000o().O0000oOO) {
                return str;
            }
            for (String contains : O000000o().O0000oO) {
                if (str.contains(contains)) {
                    return str;
                }
            }
            if (O000000o().O0000Oo0 == null) {
                return str;
            }
            for (String contains2 : O000000o().O0000Oo0) {
                if (str.contains(contains2)) {
                    return str;
                }
            }
            return str.replace("http", "https");
        }

        public final String O00000o() throws XimalayaException {
            if (TextUtils.isEmpty(this.O0000o00)) {
                this.O0000o00 = Settings.Secure.getString(O0000Oo0().getContentResolver(), "android_id");
            }
            if (TextUtils.isEmpty(this.O0000o00)) {
                this.O0000o00 = UUID.randomUUID().toString();
            }
            return this.O0000o00;
        }

        public final String O00000oO() throws XimalayaException {
            if (this.O00000oO.equals("")) {
                try {
                    this.O00000oO = O0000Oo0().getPackageManager().getApplicationInfo(O0000Oo0().getPackageName(), NotificationCompat.FLAG_HIGH_PRIORITY).metaData.getString("pack_id");
                } catch (PackageManager.NameNotFoundException unused) {
                    throw new XimalayaException(600, "get packid error");
                }
            }
            return this.O00000oO;
        }

        private String O0000OoO() {
            if (this.O0000o0O.equals("")) {
                this.O0000o0O = this.f1325O000000o.getPackageName();
            }
            return this.O0000o0O;
        }

        private String O0000Ooo() {
            if (TextUtils.isEmpty(this.O0000o0o)) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) this.f1325O000000o.getSystemService("phone");
                    if (telephonyManager.getSimState() == 5) {
                        this.O0000o0o = telephonyManager.getSimOperatorName();
                    } else {
                        this.O0000o0o = "未知";
                    }
                } catch (Exception unused) {
                }
            }
            return this.O0000o0o;
        }

        private String O0000o00() {
            this.O0000o = NetworkType.O000000o(this.f1325O000000o).getName();
            return this.O0000o;
        }

        public static String O00000oo() {
            return iip.O00000Oo;
        }

        public static void O0000O0o() {
            if (!ilg.O000000o()) {
                EncryptUtilForSDK.O000000o();
            }
        }

        public static Map<String, String> O000000o(Map<String, String> map) throws XimalayaException {
            HashMap hashMap = new HashMap();
            iit O000000o2 = O000000o();
            HashMap hashMap2 = new HashMap();
            hashMap2.put("app_key", O000000o().O00000Oo());
            hashMap2.put("device_id", O000000o2.O00000o());
            hashMap2.put("pack_id", O000000o().O00000oO());
            O000000o();
            hashMap2.put("sdk_version", iip.O00000Oo);
            O000000o();
            hashMap2.put("client_os_type", "2");
            hashMap.putAll(hashMap2);
            if (map != null) {
                hashMap.putAll(map);
            }
            hashMap.put("access_token", iis.O000000o().O00000o());
            String O00000oo2 = iis.O000000o().O00000oo();
            if (!TextUtils.isEmpty(O00000oo2) && !iis.O0000OOo()) {
                hashMap.put("uid", O00000oo2);
            }
            return hashMap;
        }

        private static <T> T O000000o(String str, Map<String, String> map, O000000o<T> o000000o) throws Exception {
            try {
                try {
                    return o000000o.O000000o(iir.O000000o(iiy.O000000o(O00000Oo(str), O000000o(map), O000000o().O00000Oo).build(), map, O000000o().O00000Oo, str));
                } catch (Exception e) {
                    throw e;
                } catch (XimalayaException e2) {
                    throw e2;
                }
            } catch (XimalayaException e3) {
                throw e3;
            }
        }

        public static <T extends iix> void O000000o(String str, Map<String, String> map, final iiw<T> iiw, final O000000o<T> o000000o) {
            try {
                iir.O000000o(iiy.O000000o(O00000Oo(str), O000000o(map), O000000o().O00000Oo).build(), new ijf() {
                    /* class _m_j.iit.AnonymousClass6 */

                    public final void O000000o(Response response) {
                        try {
                            String O000000o2 = new ija(response).O000000o();
                            if (o000000o != null) {
                                iit.O0000O0o.O000000o(iiw, o000000o.O000000o(O000000o2));
                            } else {
                                iit.O0000O0o.O000000o(iiw, null);
                            }
                        } catch (Exception e) {
                            if (!TextUtils.isEmpty(e.getMessage())) {
                                iit.O0000O0o.O000000o(1007, e.getMessage(), iiw);
                            } else {
                                iit.O0000O0o.O000000o(1007, "parse response json data error", iiw);
                            }
                        }
                    }

                    public final void O000000o(int i, String str) {
                        iit.O0000O0o.O000000o(i, str, iiw);
                    }
                }, map, O000000o().O00000Oo, str);
            } catch (XimalayaException e) {
                iiw.O000000o(e.getErrorCode(), e.getMessage());
            }
        }

        private static <T> T O00000Oo(String str, Map<String, String> map, O000000o<T> o000000o) throws Exception {
            try {
                try {
                    return o000000o.O000000o(iir.O000000o(iiy.O00000Oo(O00000Oo(str), O000000o(map), O000000o().O00000Oo).build(), map, O000000o().O00000Oo, str));
                } catch (Exception e) {
                    throw e;
                } catch (XimalayaException e2) {
                    throw e2;
                }
            } catch (XimalayaException e3) {
                throw e3;
            }
        }

        public static <T> void O00000Oo(String str, Map<String, String> map, final iiw<T> iiw, final O000000o<T> o000000o) {
            try {
                Request.Builder O00000Oo2 = iiy.O00000Oo(O00000Oo(str), O000000o(map), O000000o().O00000Oo);
                if (str.contains("client_place_order")) {
                    O00000Oo2.header("Accept-Encoding", "danding");
                }
                iir.O000000o(O00000Oo2.build(), new ijf() {
                    /* class _m_j.iit.AnonymousClass9 */

                    public final void O000000o(Response response) {
                        try {
                            String O000000o2 = new ija(response).O000000o();
                            if (o000000o != null) {
                                iit.O0000O0o.O000000o(iiw, o000000o.O000000o(O000000o2));
                            } else {
                                iit.O0000O0o.O000000o(iiw, null);
                            }
                        } catch (Exception e) {
                            if (!TextUtils.isEmpty(e.getMessage())) {
                                iit.O0000O0o.O000000o(1007, e.getMessage(), iiw);
                            } else {
                                iit.O0000O0o.O000000o(1007, "parse response json data error", iiw);
                            }
                        }
                    }

                    public final void O000000o(int i, String str) {
                        iit.O0000O0o.O000000o(i, str, iiw);
                    }
                }, map, O000000o().O00000Oo, str);
            } catch (XimalayaException e) {
                iiw.O000000o(e.getErrorCode(), e.getMessage());
            }
        }

        public static void O000000o(Map<String, String> map, iiw<ijq> iiw) {
            O000000o("http://api.ximalaya.com/openapi-gateway-app/categories/list", map, iiw, new O000000o<ijq>() {
                /* class _m_j.iit.AnonymousClass10 */

                public final /* synthetic */ Object O000000o(String str) throws Exception {
                    ijq ijq = new ijq();
                    ijq.f1373O000000o = (List) ija.O000000o(new TypeToken<List<ijp>>() {
                        /* class _m_j.iit.AnonymousClass10.AnonymousClass1 */
                    }.getType(), str);
                    return ijq;
                }
            });
        }

        public static void O00000Oo(Map<String, String> map, iiw<ijo> iiw) {
            O000000o().O00000oO(map);
            O000000o("http://api.ximalaya.com/openapi-gateway-app/search/albums", map, iiw, new O000000o<ijo>() {
                /* class _m_j.iit.AnonymousClass21 */

                public final /* synthetic */ Object O000000o(String str) throws Exception {
                    return (ijo) ija.O000000o(new TypeToken<ijo>() {
                        /* class _m_j.iit.AnonymousClass21.AnonymousClass1 */
                    }.getType(), str);
                }
            });
        }

        public static void O00000o0(Map<String, String> map, iiw<ijx> iiw) {
            O000000o().O00000oO(map);
            final HashMap hashMap = new HashMap();
            hashMap.put("track_base_url", O00000o.O00000o0);
            hashMap.putAll(map);
            O000000o("http://api.ximalaya.com/openapi-gateway-app/search/tracks", map, iiw, new O000000o<ijx>() {
                /* class _m_j.iit.AnonymousClass23 */

                public final /* synthetic */ Object O000000o(String str) throws Exception {
                    ijx ijx = (ijx) ija.O000000o(new TypeToken<ijx>() {
                        /* class _m_j.iit.AnonymousClass23.AnonymousClass1 */
                    }.getType(), str);
                    hashMap.put("total_page", String.valueOf(ijx.O00000o));
                    ijx.O00000Oo = hashMap;
                    return ijx;
                }
            });
        }

        public static void O00000o(Map<String, String> map, iiw<ijt> iiw) {
            O000000o("https://mpay.ximalaya.com/openapi-payfacade-app/open_pay/get_obfuscated_play_info/" + System.currentTimeMillis(), map, iiw, new O000000o<ijt>() {
                /* class _m_j.iit.AnonymousClass1 */

                public final /* synthetic */ Object O000000o(String str) throws Exception {
                    return (ijt) ija.O000000o(new TypeToken<ijt>() {
                        /* class _m_j.iit.AnonymousClass1.AnonymousClass1 */
                    }.getType(), str);
                }
            });
        }

        public static ijt O00000Oo(Map<String, String> map) {
            try {
                return (ijt) O000000o("https://mpay.ximalaya.com/openapi-payfacade-app/open_pay/get_obfuscated_play_info/" + System.currentTimeMillis(), map, new O000000o<ijt>() {
                    /* class _m_j.iit.AnonymousClass3 */

                    public final /* synthetic */ Object O000000o(String str) throws Exception {
                        return (ijt) ija.O000000o(new TypeToken<ijt>() {
                            /* class _m_j.iit.AnonymousClass3.AnonymousClass1 */
                        }.getType(), str);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public static void O00000oO(Map<String, String> map, iiw<ijz> iiw) {
            final HashMap hashMap = new HashMap();
            hashMap.put("track_base_url", O00000o.O00000Oo);
            hashMap.putAll(map);
            O000000o().O00000oO(map);
            O000000o("http://api.ximalaya.com/openapi-gateway-app/tracks/hot", map, iiw, new O000000o<ijz>() {
                /* class _m_j.iit.AnonymousClass4 */

                public final /* synthetic */ Object O000000o(String str) throws Exception {
                    ijz ijz = (ijz) ija.O000000o(new TypeToken<ijz>() {
                        /* class _m_j.iit.AnonymousClass4.AnonymousClass1 */
                    }.getType(), str);
                    hashMap.put("total_page", String.valueOf(ijz.O00000o));
                    ijz.O00000Oo = hashMap;
                    return ijz;
                }
            });
        }

        @Deprecated
        public static void O00000oo(Map<String, String> map, iiw<ijn> iiw) {
            map.put("calc_dimension", "1");
            O000000o().O00000oO(map);
            O000000o("http://api.ximalaya.com/openapi-gateway-app/v2/albums/list", map, iiw, new O000000o<ijn>() {
                /* class _m_j.iit.AnonymousClass5 */

                public final /* synthetic */ Object O000000o(String str) throws Exception {
                    return (ijn) ija.O000000o(new TypeToken<ijn>() {
                        /* class _m_j.iit.AnonymousClass5.AnonymousClass1 */
                    }.getType(), str);
                }
            });
        }

        public static void O0000O0o(Map<String, String> map, iiw<ijw> iiw) {
            final HashMap hashMap = new HashMap();
            hashMap.put("track_base_url", O00000o.f1349O000000o);
            hashMap.putAll(map);
            hashMap.remove("pid");
            hashMap.remove("track_id");
            O000000o().O00000oO(map);
            O000000o("http://api.ximalaya.com/openapi-gateway-app/tracks/get_last_play_tracks", map, iiw, new O000000o<ijw>() {
                /* class _m_j.iit.AnonymousClass7 */

                public final /* synthetic */ Object O000000o(String str) throws Exception {
                    ijw ijw = (ijw) ija.O000000o(new TypeToken<ijw>() {
                        /* class _m_j.iit.AnonymousClass7.AnonymousClass1 */
                    }.getType(), str);
                    hashMap.put("page", String.valueOf(ijw.O00000oO));
                    hashMap.put("pre_page", String.valueOf(ijw.O00000oO - 1));
                    hashMap.put("total_page", String.valueOf(ijw.O00000o));
                    ijw.O00000Oo = hashMap;
                    return ijw;
                }
            });
        }

        public static void O0000OOo(Map<String, String> map, iiw<ika> iiw) {
            final HashMap hashMap = new HashMap();
            hashMap.put("track_base_url", O00000o.f1349O000000o);
            hashMap.putAll(map);
            O000000o().O00000oO(map);
            O000000o("http://api.ximalaya.com/openapi-gateway-app/albums/browse", map, iiw, new O000000o<ika>() {
                /* class _m_j.iit.AnonymousClass8 */

                public final /* synthetic */ Object O000000o(String str) throws Exception {
                    ika ika = (ika) ija.O000000o(new TypeToken<ika>() {
                        /* class _m_j.iit.AnonymousClass8.AnonymousClass1 */
                    }.getType(), str);
                    hashMap.put("total_page", String.valueOf(ika.O00000o));
                    ika.O00000Oo = hashMap;
                    return ika;
                }
            });
        }

        public static void O0000Oo0(Map<String, String> map, iiw<ijy> iiw) {
            O000000o("http://api.ximalaya.com/openapi-gateway-app/tracks/get_play_info", map, iiw, O0000oOo);
        }

        public static void O0000Oo(Map<String, String> map, iiw<ijm> iiw) {
            O00000Oo("http://api.ximalaya.com/openapi-gateway-app/encrypt/exchange", map, iiw, new O000000o<ijm>() {
                /* class _m_j.iit.AnonymousClass12 */

                public final /* synthetic */ Object O000000o(String str) throws Exception {
                    ijm ijm = (ijm) new Gson().fromJson(str, ijm.class);
                    if (ijm == null || !ijm.O00000o0) {
                        return ijm;
                    }
                    return null;
                }
            });
        }

        public static ijm O00000o0(Map<String, String> map) {
            try {
                return (ijm) O00000Oo("http://api.ximalaya.com/openapi-gateway-app/encrypt/exchange", map, new O000000o<ijm>() {
                    /* class _m_j.iit.AnonymousClass13 */

                    public final /* synthetic */ Object O000000o(String str) throws Exception {
                        return (ijm) new Gson().fromJson(str, ijm.class);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public static void O0000OoO(Map<String, String> map, final iiw<AdvertisList> iiw) {
            int i;
            try {
                map.put("appid", "-2");
                map.put("version", iip.f1320O000000o);
                map.put("device", "android");
                String O00000oo2 = iis.O000000o().O00000oo();
                if (TextUtils.isEmpty(O00000oo2)) {
                    O00000oo2 = "-1";
                }
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                map.put("xt", sb.toString());
                map.put("uid", O00000oo2);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(ikk.O00000oO(O000000o().f1325O000000o));
                map.put("operator", sb2.toString());
                map.put("network", O000000o().O0000o00());
                map.put("deviceId", O000000o().O00000o());
                map.put("appKey", O000000o().O00000Oo());
                if (XmPlayerService.getPlayerSrvice() != null) {
                    XmPlayListControl.PlayMode playMode = XmPlayerService.getPlayerSrvice().getPlayMode();
                    if (playMode != XmPlayListControl.PlayMode.PLAY_MODEL_LIST) {
                        if (playMode == XmPlayListControl.PlayMode.PLAY_MODEL_SINGLE_LOOP) {
                            i = 1;
                        } else if (playMode == XmPlayListControl.PlayMode.PLAY_MODEL_RANDOM) {
                            i = 2;
                        } else if (playMode == XmPlayListControl.PlayMode.PLAY_MODEL_LIST_LOOP) {
                            i = 3;
                        } else if (playMode == XmPlayListControl.PlayMode.PLAY_MODEL_SINGLE) {
                            i = 4;
                        }
                        map.put("playMode", String.valueOf(i));
                    }
                    i = 0;
                    map.put("playMode", String.valueOf(i));
                }
                Request.Builder O000000o2 = iiy.O000000o(O00000Oo("http://adse.ximalaya.com/soundPatch"), map);
                O000000o2.addHeader("User-Agent", O0000OOo());
                try {
                    O000000o(O000000o2, new StringBuilder());
                    Request build = O000000o2.build();
                    iiz O000000o3 = iiz.O000000o();
                    AnonymousClass14 r1 = new ijf() {
                        /* class _m_j.iit.AnonymousClass14 */

                        /* JADX WARNING: Removed duplicated region for block: B:12:0x004a  */
                        /* JADX WARNING: Removed duplicated region for block: B:14:0x0056  */
                        public final void O000000o(Response response) {
                            String str;
                            ija ija = new ija(response);
                            Type type = new TypeToken<AdvertisList>() {
                                /* class _m_j.iit.AnonymousClass14.AnonymousClass1 */
                            }.getType();
                            if (ija.f1355O000000o.code() == 200) {
                                try {
                                    str = ija.O000000o();
                                    try {
                                        iit.O0000O0o.O000000o(iiw, (AdvertisList) ija.O000000o(type, str));
                                    } catch (Exception e) {
                                        e = e;
                                        ilk.O000000o("XIMALAYASDK", "response json str:".concat(String.valueOf(str)));
                                        if (TextUtils.isEmpty(e.getMessage())) {
                                        }
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    str = "";
                                    ilk.O000000o("XIMALAYASDK", "response json str:".concat(String.valueOf(str)));
                                    if (TextUtils.isEmpty(e.getMessage())) {
                                        iit.O0000O0o.O000000o(1007, e.getMessage(), iiw);
                                    } else {
                                        iit.O0000O0o.O000000o(1007, "parse response json data error", iiw);
                                    }
                                }
                            } else {
                                iit.O0000O0o.O000000o(ija.f1355O000000o.code(), ija.f1355O000000o.message(), iiw);
                            }
                        }

                        public final void O000000o(int i, String str) {
                            iit.O0000O0o.O000000o(i, str, iiw);
                        }
                    };
                    OkHttpClient O000000o4 = O000000o3.O000000o(build);
                    if (1500 != iiz.f1352O000000o) {
                        OkHttpClient.Builder newBuilder = O000000o4.newBuilder();
                        newBuilder.connectTimeout(1500, TimeUnit.MILLISECONDS);
                        newBuilder.readTimeout(1500, TimeUnit.MILLISECONDS);
                        newBuilder.writeTimeout(1500, TimeUnit.MILLISECONDS);
                        O000000o4 = newBuilder.build();
                    }
                    if (O000000o4 == null) {
                        O000000o3.O000000o(build, r1);
                        return;
                    }
                    try {
                        O000000o4.newCall(build).enqueue(new Callback(r1) {
                            /* class _m_j.iiz.AnonymousClass1 */

                            /* renamed from: O000000o */
                            final /* synthetic */ ijf f1353O000000o;

                            {
                                this.f1353O000000o = r2;
                            }

                            public final void onResponse(Call call, Response response) {
                                if (this.f1353O000000o == null) {
                                    response.body().close();
                                    return;
                                }
                                if (response != null) {
                                    String header = response.header(iiz.O00000oo);
                                    String header2 = response.header(iiz.O0000O0o);
                                    ilk.O00000Oo("SAVE_LIFE", header + "   " + header2);
                                    if (!TextUtils.isEmpty(header)) {
                                        if (header.equals("on")) {
                                            iiz.O0000OOo = true;
                                        } else if (header.equals("off")) {
                                            iiz.O0000OOo = false;
                                        }
                                    }
                                    if (!TextUtils.isEmpty(header2)) {
                                        if (header2.equals("on")) {
                                            iiz.O0000Oo0 = true;
                                        } else if (header2.equals("off")) {
                                            iiz.O0000Oo0 = false;
                                        }
                                    }
                                }
                                if (!ilg.O000000o()) {
                                    this.f1353O000000o.O000000o(response);
                                } else if (response.code() >= 400) {
                                    String O000000o2 = new ija(response).O000000o();
                                    if (TextUtils.isEmpty(O000000o2) || !O000000o2.contains("ret")) {
                                        ijf ijf = this.f1353O000000o;
                                        int code = response.code();
                                        ijf.O000000o(code, "网络请求失败(" + response.code() + ")");
                                    } else {
                                        this.f1353O000000o.O000000o(response.code(), O000000o2);
                                    }
                                } else {
                                    this.f1353O000000o.O000000o(response);
                                }
                                response.body().close();
                            }

                            public final void onFailure(Call call, IOException iOException) {
                                if (this.f1353O000000o != null) {
                                    String str = "网络请求失败";
                                    if (iio.f1319O000000o) {
                                        String message = iOException.getMessage();
                                        if (!TextUtils.isEmpty(message)) {
                                            str = message;
                                        }
                                    }
                                    this.f1353O000000o.O000000o(604, str);
                                }
                            }
                        });
                    } catch (Exception unused) {
                        r1.O000000o(604, "网络请求失败");
                    }
                } catch (UnsupportedEncodingException e) {
                    iiw.O000000o(1008, "UnsupportedEncodingException :" + e.getMessage());
                } catch (XimalayaException e2) {
                    iiw.O000000o(e2.getErrorCode(), e2.getErrorMessage());
                } catch (Exception e3) {
                    iiw.O000000o(0, e3.getMessage());
                }
            } catch (XimalayaException e4) {
                iiw.O000000o(e4.getErrorCode(), e4.getMessage());
            } catch (Exception e5) {
                iiw.O000000o(0, e5.getMessage());
            }
        }

        private static void O000000o(Request.Builder builder, StringBuilder sb) throws UnsupportedEncodingException, XimalayaException {
            String str;
            sb.append("1&_device=");
            sb.append(URLEncoder.encode("android&" + O000000o().O00000o() + "&" + iip.f1320O000000o, "UTF-8"));
            sb.append(";");
            sb.append("impl=");
            sb.append(URLEncoder.encode(O000000o().O0000OoO(), "UTF-8"));
            sb.append(";");
            sb.append("XUM=");
            sb.append(URLEncoder.encode(O000000o().O0000Oo(), "UTF-8"));
            sb.append(";");
            sb.append("c-oper=");
            sb.append(URLEncoder.encode(O000000o().O0000Ooo(), "UTF-8"));
            sb.append(";");
            sb.append("net-mode=");
            sb.append(URLEncoder.encode(O000000o().O0000o00(), "UTF-8"));
            sb.append(";");
            sb.append("manufacture=");
            sb.append(URLEncoder.encode(O000000o().O00000o0(), "UTF-8"));
            sb.append(";");
            try {
                new ijh();
                str = ijh.O000000o(O00000o0(ikk.O000000o(O000000o().f1325O000000o)));
            } catch (Exception e) {
                e.printStackTrace();
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                sb.append("AID=");
                sb.append(str);
                sb.append(";");
            }
            sb.append("osversion=");
            sb.append(Build.VERSION.SDK_INT);
            sb.append(";");
            String O00000Oo2 = ikk.O00000Oo(O000000o().f1325O000000o);
            if (!TextUtils.isEmpty(O00000Oo2)) {
                try {
                    String hexString = Long.toHexString(Long.valueOf(O00000Oo2).longValue());
                    sb.append("XIM=");
                    sb.append(hexString);
                    sb.append(";");
                } catch (NumberFormatException unused) {
                }
            }
            sb.append("res=");
            sb.append(URLEncoder.encode(O000000o().O0000oO0, "UTF-8"));
            builder.addHeader("Cookie", sb.toString());
        }

        public static void O000000o(List<iko> list) {
            if (!list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (iko iko : list) {
                    ikl ikl = new ikl();
                    ikl.O00000Oo = "AD";
                    ikl.O00000o0 = iko;
                    ikl.f1402O000000o = System.currentTimeMillis();
                    arrayList.add(ikl);
                }
                ikm ikm = new ikm();
                ikm.f1403O000000o = arrayList;
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    new ile().O000000o(ikm, new ile.O000000o<String>(null) {
                        /* class _m_j.iit.AnonymousClass15 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ iiw f1330O000000o = null;

                        public final /* synthetic */ void O000000o(Object obj) {
                            String str = (String) obj;
                            if (!TextUtils.isEmpty(str)) {
                                iit.O000000o(str, this.f1330O000000o);
                            }
                        }
                    });
                    return;
                }
                try {
                    String json = new Gson().toJson(ikm);
                    if (!TextUtils.isEmpty(json)) {
                        O000000o(json, (iiw) null);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public static void O000000o(ikq ikq) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                new ile().O000000o(ikq, new ile.O000000o<String>(null) {
                    /* class _m_j.iit.AnonymousClass16 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ iiw f1331O000000o = null;

                    public final /* synthetic */ void O000000o(Object obj) {
                        String str = (String) obj;
                        if (!TextUtils.isEmpty(str)) {
                            iit.O00000Oo(str, this.f1331O000000o);
                        }
                    }
                });
                return;
            }
            try {
                String json = new Gson().toJson(ikq);
                if (!TextUtils.isEmpty(json)) {
                    O00000Oo(json, (iiw) null);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x001a  */
        public static void O000000o(String str, final iiw iiw) {
            Request request;
            try {
                Request.Builder O000000o2 = iiy.O000000o("http://xdcs-collector.ximalaya.com/api/v1/adRealTime", str);
                O000000o(O000000o2, new StringBuilder());
                request = O000000o2.build();
            } catch (XimalayaException unused) {
                request = null;
                if (request != null) {
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                request = null;
                if (request != null) {
                }
            }
            if (request != null) {
                iiz.O000000o().O000000o(request, new ijf() {
                    /* class _m_j.iit.AnonymousClass17 */

                    public final void O000000o(Response response) {
                        iiw iiw = iiw;
                        if (iiw != null) {
                            iiw.O000000o(null);
                        }
                    }

                    public final void O000000o(int i, String str) {
                        iiw iiw = iiw;
                        if (iiw != null) {
                            iiw.O000000o(i, str);
                        }
                    }
                });
            }
        }

        public static void O00000Oo(String str, final iiw iiw) {
            Request request;
            try {
                request = iiy.O000000o("http://xdcs-collector.ximalaya.com/api/v1/realtime", str).build();
            } catch (XimalayaException unused) {
                request = null;
            }
            if (request != null) {
                iiz.O000000o().O000000o(request, new ijf() {
                    /* class _m_j.iit.AnonymousClass18 */

                    public final void O000000o(Response response) {
                        iiw iiw = iiw;
                        if (iiw != null) {
                            iiw.O000000o(null);
                        }
                    }

                    public final void O000000o(int i, String str) {
                        iiw iiw = iiw;
                        if (iiw != null) {
                            iiw.O000000o(i, str);
                        }
                    }
                });
            }
        }

        private static byte[] O00000o0(String str) {
            byte[] bArr = new byte[(str.length() / 2)];
            int i = 0;
            for (int i2 = 0; i2 < bArr.length; i2++) {
                bArr[i2] = (byte) ((((byte) (Character.digit(str.charAt(i), 16) & 255)) << 4) | ((byte) (Character.digit(str.charAt(i + 1), 16) & 255)));
                i += 2;
            }
            return bArr;
        }

        public static void O0000Ooo(Map<String, String> map, iiw<ijl> iiw) {
            O00000Oo("http://api.ximalaya.com/openapi-collector-app/live_single_record", map, iiw, new O000000o<ijl>() {
                /* class _m_j.iit.AnonymousClass19 */

                public final /* synthetic */ Object O000000o(String str) throws Exception {
                    return (ijl) new Gson().fromJson(str, ijl.class);
                }
            });
        }

        public static void O0000o00(Map<String, String> map, iiw<ijl> iiw) {
            O00000Oo("http://api.ximalaya.com/openapi-collector-app/track_single_record", map, iiw, new O000000o<ijl>() {
                /* class _m_j.iit.AnonymousClass20 */

                public final /* synthetic */ Object O000000o(String str) throws Exception {
                    return (ijl) new Gson().fromJson(str, ijl.class);
                }
            });
        }

        public static void O0000o0(Map<String, String> map, iiw<ijv> iiw) {
            if (!iiu.O000000o(map, iiw, "getTrackListM")) {
                HashMap hashMap = new HashMap();
                hashMap.putAll(map);
                hashMap.remove("total_page");
                hashMap.remove("pre_page");
                O000000o((String) hashMap.remove("track_base_url"), hashMap, iiw, new O000000o<ijv>() {
                    /* class _m_j.iit.AnonymousClass22 */

                    public final /* synthetic */ Object O000000o(String str) throws Exception {
                        return (ijv) ija.O000000o(new TypeToken<ijv<Track>>() {
                            /* class _m_j.iit.AnonymousClass22.AnonymousClass1 */
                        }.getType(), str);
                    }
                });
            }
        }

        public static iiv O000000o(ija ija) {
            try {
                return (iiv) new Gson().fromJson(ija.O000000o(), iiv.class);
            } catch (Exception unused) {
                return null;
            }
        }

        private void O00000oO(Map<String, String> map) {
            if (!map.containsKey("count")) {
                map.put("count", String.valueOf(O00000o0));
            }
        }

        public static void O000000o(Map<String, String> map, iiw<String> iiw, Track track) {
            if (ilg.O000000o()) {
                ilk.O000000o((Object) "encryptStr 0");
                if (!iiu.O000000o(map, iiw, track, "updateTrackForPlay")) {
                    iiw.O000000o(603, "call " + "updateTrackForPlay" + " is not in mainapp or class.forName CommonRequestM error");
                    return;
                }
                return;
            }
            ilo.O000000o(map, iiw, track);
        }

        public static String O0000OOo() {
            if (ilg.O000000o()) {
                return iiu.O00000Oo();
            }
            if (TextUtils.isEmpty(O0000oo0)) {
                StringBuilder sb = new StringBuilder();
                sb.append("ting_");
                O000000o();
                sb.append(iip.O00000Oo);
                sb.append("(");
                try {
                    sb.append(URLEncoder.encode(Build.MODEL, "utf-8"));
                } catch (UnsupportedEncodingException unused) {
                }
                sb.append(",");
                sb.append("Android" + Build.VERSION.SDK_INT);
                sb.append(")");
                O0000oo0 = sb.toString();
            }
            return O0000oo0;
        }

        public static String O00000o(Map<String, String> map) throws IOException {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            map.put("timestamp", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(System.currentTimeMillis());
            map.put("nonce", sb2.toString());
            map.put("response_type", "token");
            try {
                map.put("client_id", O000000o().O00000Oo());
            } catch (XimalayaException e) {
                e.printStackTrace();
            }
            Request.Builder builder = null;
            try {
                builder = iiy.O00000Oo(O00000Oo("http://api.ximalaya.com/oauth2/authorize"), O000000o(map), O000000o().O00000Oo);
            } catch (XimalayaException e2) {
                e2.printStackTrace();
            }
            Response execute = new OkHttpClient().newBuilder().connectTimeout(15, TimeUnit.SECONDS).followRedirects(false).followSslRedirects(false).build().newCall(builder.build()).execute();
            return execute.code() == 302 ? execute.headers().get("Location") : "";
        }

        public static void O0000o0O(Map<String, String> map, iiw<iju> iiw) {
            map.put("confirm_type", "2");
            O00000Oo("https://mpay.ximalaya.com/openapi-payfacade-app/open_pay/confirm_order", map, iiw, new O000000o<iju>() {
                /* class _m_j.iit.AnonymousClass2 */

                public final /* synthetic */ Object O000000o(String str) throws Exception {
                    return (iju) ija.O000000o(new TypeToken<iju>() {
                        /* class _m_j.iit.AnonymousClass2.AnonymousClass1 */
                    }.getType(), str);
                }
            });
        }
    }
