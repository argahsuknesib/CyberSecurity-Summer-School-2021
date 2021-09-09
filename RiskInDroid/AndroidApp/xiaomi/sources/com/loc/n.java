package com.loc;

import _m_j.brs;
import _m_j.bsf;
import _m_j.btx;
import _m_j.bua;
import _m_j.bud;
import _m_j.bue;
import _m_j.bvp;
import _m_j.bvy;
import _m_j.bvz;
import _m_j.bwd;
import _m_j.bwe;
import _m_j.bwf;
import _m_j.bwg;
import _m_j.bwi;
import _m_j.bww;
import _m_j.oi;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.opensdk.co.CoManager;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.loc.s;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class n {
    static boolean O0000O0o = false;

    /* renamed from: O000000o  reason: collision with root package name */
    String f4540O000000o = null;
    O00000Oo O00000Oo = null;
    public O000000o O00000o = null;
    AMapLocation O00000o0 = null;
    Context O00000oO = null;
    bud O00000oo = null;
    HashMap<Messenger, Long> O0000OOo = new HashMap<>();
    long O0000Oo = 0;
    bwf O0000Oo0 = null;
    long O0000OoO = 0;
    String O0000Ooo = null;
    Socket O0000o = null;
    AMapLocationClientOption O0000o0 = new AMapLocationClientOption();
    AMapLocationClientOption O0000o00 = null;
    ServerSocket O0000o0O = null;
    boolean O0000o0o = false;
    O00000o0 O0000oO = null;
    boolean O0000oO0 = false;
    private boolean O0000oOO = false;
    private boolean O0000oOo = false;
    private long O0000oo = 0;
    private long O0000oo0 = 0;
    private AMapLocationServer O0000ooO = null;
    private long O0000ooo = 0;
    private boolean O000O00o = true;
    private String O000O0OO = "";
    private final int O000O0Oo = 5000;
    private String O00oOoOo = "jsonp1";
    private int O00oOooO = 0;
    /* access modifiers changed from: private */
    public r O00oOooo = null;

    class O00000Oo extends HandlerThread {
        public O00000Oo(String str) {
            super(str);
        }

        /* access modifiers changed from: protected */
        public final void onLooperPrepared() {
            try {
                r unused = n.this.O00oOooo = new r(n.this.O00000oO);
            } catch (Throwable th) {
                bvz.O000000o(th, "APSManager$ActionThread", "onLooperPrepared");
                return;
            }
            n.this.O00000oo = new bud();
            super.onLooperPrepared();
        }

        public final void run() {
            try {
                super.run();
            } catch (Throwable th) {
                bvz.O000000o(th, "APSManager$ActionThread", "run");
            }
        }
    }

    class O00000o0 extends Thread {
        O00000o0() {
        }

        public final void run() {
            try {
                if (!n.this.O0000o0o) {
                    n.this.O0000o0o = true;
                    n.this.O0000o0O = new ServerSocket(43689);
                }
                while (n.this.O0000o0o && n.this.O0000o0O != null) {
                    n.this.O0000o = n.this.O0000o0O.accept();
                    n.O000000o(n.this, n.this.O0000o);
                }
            } catch (Throwable th) {
                bvz.O000000o(th, "ApsServiceCore", "run");
            }
            super.run();
        }
    }

    public n(Context context) {
        this.O00000oO = context;
    }

    /* access modifiers changed from: private */
    public static AMapLocationServer O000000o(int i, String str) {
        try {
            AMapLocationServer aMapLocationServer = new AMapLocationServer("");
            aMapLocationServer.setErrorCode(i);
            aMapLocationServer.setLocationDetail(str);
            return aMapLocationServer;
        } catch (Throwable th) {
            bvz.O000000o(th, "ApsServiceCore", "newInstanceAMapLoc");
            return null;
        }
    }

    private void O000000o(Messenger messenger) {
        try {
            bud.O00000Oo(this.O00000oO);
            if (bvy.O0000OoO()) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("ngpsAble", bvy.O0000o00());
                O000000o(messenger, 7, bundle);
                bvy.O0000Ooo();
            }
            if (bvy.O0000oOO()) {
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("installMockApp", true);
                O000000o(messenger, 9, bundle2);
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "ApsServiceCore", "initAuth");
        }
    }

    static void O000000o(Messenger messenger, int i, Bundle bundle) {
        if (messenger != null) {
            try {
                Message obtain = Message.obtain();
                obtain.setData(bundle);
                obtain.what = i;
                messenger.send(obtain);
            } catch (Throwable th) {
                bvz.O000000o(th, "ApsServiceCore", "sendMessage");
            }
        }
    }

    /* access modifiers changed from: private */
    public void O000000o(Messenger messenger, AMapLocation aMapLocation, String str, long j) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(AMapLocation.class.getClassLoader());
        bundle.putParcelable("loc", aMapLocation);
        bundle.putString("nb", str);
        bundle.putLong("netUseTime", j);
        this.O0000OOo.put(messenger, Long.valueOf(bwi.O00000o0()));
        O000000o(messenger, 1, bundle);
    }

    private void O000000o(AMapLocationClientOption aMapLocationClientOption) {
        try {
            if (this.O00000oo != null) {
                this.O00000oo.O000000o(aMapLocationClientOption);
            }
            if (aMapLocationClientOption != null) {
                O0000O0o = aMapLocationClientOption.isKillProcess();
                if (!(this.O0000o00 == null || (aMapLocationClientOption.isOffset() == this.O0000o00.isOffset() && aMapLocationClientOption.isNeedAddress() == this.O0000o00.isNeedAddress() && aMapLocationClientOption.isLocationCacheEnable() == this.O0000o00.isLocationCacheEnable() && this.O0000o00.getGeoLanguage() == aMapLocationClientOption.getGeoLanguage()))) {
                    this.O0000oo = 0;
                    this.O00000o0 = null;
                }
                this.O0000o00 = aMapLocationClientOption;
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "ApsServiceCore", "setExtra");
        }
    }

    static /* synthetic */ void O000000o(n nVar) {
        try {
            if (nVar.O00oOooO < bvy.O00000Oo()) {
                nVar.O00oOooO++;
                nVar.O00000oo.O00000o();
                nVar.O00000o.sendEmptyMessageDelayed(4, 2000);
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "ApsServiceCore", "doGpsFusion");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002f, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        _m_j.bvz.O000000o(r9, "ApsServiceCore", "invokeSocketLocation part3");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0033, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r5.close();
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x004d, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        _m_j.bvz.O000000o(r10, "ApsServiceCore", "invokeSocketLocation part3");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0096, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        r5.close();
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00af, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        _m_j.bvz.O000000o(r10, "ApsServiceCore", "invokeSocketLocation part3");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x00c6, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:?, code lost:
        r5.close();
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x00dd, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:?, code lost:
        _m_j.bvz.O000000o(r10, "ApsServiceCore", "invokeSocketLocation part3");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x00e2, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x00e3, code lost:
        _m_j.bvz.O000000o(r9, "ApsServiceCore", "invokeSocketLocation part4");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x00e8, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:14:0x0028, B:23:0x0037, B:32:0x0046, B:43:0x0059, B:58:0x0099, B:67:0x00a8, B:84:0x00c9, B:91:0x00d6] */
    static /* synthetic */ void O000000o(n nVar, Socket socket) {
        BufferedReader bufferedReader;
        if (socket != null) {
            int i = bvz.O00000oo;
            String str = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                try {
                    nVar.O000000o(bufferedReader);
                    String O00000oO2 = nVar.O00000oO();
                    bvz.O00000oo = i;
                    try {
                        nVar.O00000Oo(O00000oO2);
                        bufferedReader.close();
                        socket.close();
                        return;
                    } catch (Throwable th) {
                        bvz.O000000o(th, "ApsServiceCore", "invokeSocketLocation part3");
                        return;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        str = nVar.O00oOoOo + "&&" + nVar.O00oOoOo + "({'package':'" + nVar.f4540O000000o + "','error_code':1,'error':'params error'})";
                        bvz.O000000o(th, "ApsServiceCore", "invokeSocketLocation");
                        bvz.O00000oo = i;
                        try {
                            nVar.O00000Oo(str);
                            try {
                                bufferedReader.close();
                                socket.close();
                                return;
                            } catch (Throwable th3) {
                                bvz.O000000o(th3, "ApsServiceCore", "invokeSocketLocation part3");
                                return;
                            }
                        } catch (Throwable th4) {
                            bvz.O000000o(th4, "ApsServiceCore", "invokeSocketLocation part3");
                            return;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        bvz.O00000oo = i;
                        try {
                            nVar.O00000Oo(str);
                            try {
                                bufferedReader.close();
                                socket.close();
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                        }
                        throw th;
                    }
                }
            } catch (Throwable th8) {
                th = th8;
                bufferedReader = null;
                bvz.O00000oo = i;
                nVar.O00000Oo(str);
                bufferedReader.close();
                socket.close();
                throw th;
            }
        } else {
            return;
        }
        throw th;
        throw th;
        bvz.O000000o(th, "ApsServiceCore", "invokeSocketLocation part3");
        throw th;
        throw th;
    }

    private void O000000o(BufferedReader bufferedReader) throws Exception {
        String[] split;
        String[] split2;
        String[] split3;
        String readLine = bufferedReader.readLine();
        int i = 30000;
        if (readLine != null && readLine.length() > 0 && (split = readLine.split(" ")) != null && split.length > 1 && (split2 = split[1].split("\\?")) != null && split2.length > 1 && (split3 = split2[1].split("&")) != null && split3.length > 0) {
            int i2 = 30000;
            for (String split4 : split3) {
                String[] split5 = split4.split("=");
                if (split5 != null && split5.length > 1) {
                    if ("to".equals(split5[0])) {
                        i2 = bwi.O0000O0o(split5[1]);
                    }
                    if ("callback".equals(split5[0])) {
                        this.O00oOoOo = split5[1];
                    }
                }
            }
            i = i2;
        }
        bvz.O00000oo = i;
    }

    static /* synthetic */ void O00000Oo(n nVar) {
        bud bud;
        try {
            if (bvy.O00000oO()) {
                bud = nVar.O00000oo;
            } else {
                if (!bwi.O00000oO(nVar.O00000oO)) {
                    bud = nVar.O00000oo;
                }
                nVar.O00000o.sendEmptyMessageDelayed(5, (long) (bvy.O00000o() * 1000));
            }
            bud.O00000o();
            nVar.O00000o.sendEmptyMessageDelayed(5, (long) (bvy.O00000o() * 1000));
        } catch (Throwable th) {
            bvz.O000000o(th, "ApsServiceCore", "doOffFusion");
        }
    }

    private void O00000Oo(String str) throws UnsupportedEncodingException, IOException {
        PrintStream printStream = new PrintStream(this.O0000o.getOutputStream(), true, "UTF-8");
        printStream.println("HTTP/1.0 200 OK");
        printStream.println("Content-Length:" + str.getBytes("UTF-8").length);
        printStream.println();
        printStream.println(str);
        printStream.close();
    }

    private void O00000o() {
        try {
            this.O00000o.removeMessages(4);
            if (bvy.O000000o()) {
                this.O00000o.sendEmptyMessage(4);
            }
            this.O00000o.removeMessages(5);
            if (bvy.O00000o0() && bvy.O00000o() > 2) {
                this.O00000o.sendEmptyMessage(5);
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "ApsServiceCore", "checkConfig");
        }
    }

    public static void O00000o0() {
        O0000O0o = false;
    }

    static /* synthetic */ void O00000o0(n nVar) {
        try {
            if (bvy.O000000o(nVar.O00000oO, nVar.O0000oo0)) {
                nVar.O0000oo0 = bwi.O00000Oo();
                nVar.O00000oo.O00000o();
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "ApsServiceCore", "doNGps");
        }
    }

    private String O00000oO() {
        StringBuilder sb;
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        if (bwi.O00000oO(this.O00000oO)) {
            sb = new StringBuilder();
            sb.append(this.O00oOoOo);
            sb.append("&&");
            sb.append(this.O00oOoOo);
            sb.append("({'package':'");
            sb.append(this.f4540O000000o);
            str = "','error_code':36,'error':'app is background'})";
        } else {
            AMapLocationServer aMapLocationServer = this.O0000ooO;
            if (aMapLocationServer == null || currentTimeMillis - aMapLocationServer.getTime() > 5000) {
                try {
                    this.O0000ooO = this.O00000oo.O00000o0();
                } catch (Throwable th) {
                    bvz.O000000o(th, "ApsServiceCore", "getSocketLocResult");
                }
            }
            AMapLocationServer aMapLocationServer2 = this.O0000ooO;
            if (aMapLocationServer2 == null) {
                sb = new StringBuilder();
                sb.append(this.O00oOoOo);
                sb.append("&&");
                sb.append(this.O00oOoOo);
                sb.append("({'package':'");
                sb.append(this.f4540O000000o);
                str = "','error_code':8,'error':'unknown error'})";
            } else if (aMapLocationServer2.getErrorCode() != 0) {
                sb = new StringBuilder();
                sb.append(this.O00oOoOo);
                sb.append("&&");
                sb.append(this.O00oOoOo);
                sb.append("({'package':'");
                sb.append(this.f4540O000000o);
                sb.append("','error_code':");
                sb.append(this.O0000ooO.getErrorCode());
                sb.append(",'error':'");
                sb.append(this.O0000ooO.getErrorInfo());
                str = "'})";
            } else {
                sb = new StringBuilder();
                sb.append(this.O00oOoOo);
                sb.append("&&");
                sb.append(this.O00oOoOo);
                sb.append("({'package':'");
                sb.append(this.f4540O000000o);
                sb.append("','error_code':0,'error':'','location':{'y':");
                sb.append(this.O0000ooO.getLatitude());
                sb.append(",'precision':");
                sb.append(this.O0000ooO.getAccuracy());
                sb.append(",'x':");
                sb.append(this.O0000ooO.getLongitude());
                str = "},'version_code':'4.7.1','version':'4.7.1'})";
            }
        }
        sb.append(str);
        return sb.toString();
    }

    public final void O000000o() {
        try {
            if (this.O0000o != null) {
                this.O0000o.close();
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "ApsServiceCore", "doStopScocket 1");
        }
        try {
            if (this.O0000o0O != null) {
                this.O0000o0O.close();
            }
        } catch (Throwable th2) {
            bvz.O000000o(th2, "ApsServiceCore", "doStopScocket 2");
        }
        try {
            if (this.O0000oO != null) {
                this.O0000oO.interrupt();
            }
        } catch (Throwable unused) {
        }
        this.O0000oO = null;
        this.O0000o0O = null;
        this.O0000o0o = false;
        this.O0000oO0 = false;
    }

    /* access modifiers changed from: package-private */
    public final AMapLocationClientOption O00000Oo(Bundle bundle) {
        AMapLocationClientOption O000000o2 = bvz.O000000o(bundle.getBundle("optBundle"));
        O000000o(O000000o2);
        try {
            String string = bundle.getString("d");
            if (!TextUtils.isEmpty(string)) {
                bww.O000000o(string);
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "APSManager", "parseBundle");
        }
        return O000000o2;
    }

    public class O000000o extends Handler {
        public O000000o(Looper looper) {
            super(looper);
        }

        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x003f A[Catch:{ Throwable -> 0x0058 }] */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x006a A[Catch:{ Throwable -> 0x011a, Throwable -> 0x01a9 }] */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x006c A[Catch:{ Throwable -> 0x011a, Throwable -> 0x01a9 }] */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0073 A[Catch:{ Throwable -> 0x011a, Throwable -> 0x01a9 }] */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x007a A[Catch:{ Throwable -> 0x011a, Throwable -> 0x01a9 }] */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x0122 A[Catch:{ Throwable -> 0x011a, Throwable -> 0x01a9 }] */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x012e A[Catch:{ Throwable -> 0x011a, Throwable -> 0x01a9 }] */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x013a A[Catch:{ Throwable -> 0x011a, Throwable -> 0x01a9 }] */
        /* JADX WARNING: Removed duplicated region for block: B:63:0x0145 A[Catch:{ Throwable -> 0x011a, Throwable -> 0x01a9 }] */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x0150 A[Catch:{ Throwable -> 0x011a, Throwable -> 0x01a9 }] */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x0165 A[Catch:{ Throwable -> 0x011a, Throwable -> 0x01a9 }] */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x0190 A[Catch:{ Throwable -> 0x011a, Throwable -> 0x01a9 }] */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x019b A[Catch:{ Throwable -> 0x011a, Throwable -> 0x01a9 }] */
        public final void handleMessage(Message message) {
            Messenger messenger;
            Bundle bundle;
            float f;
            boolean z;
            try {
                bundle = message.getData();
                try {
                    messenger = message.replyTo;
                    if (bundle != null) {
                        try {
                            if (!bundle.isEmpty()) {
                                String string = bundle.getString("c");
                                n nVar = n.this;
                                if (TextUtils.isEmpty(nVar.O0000Ooo)) {
                                    nVar.O0000Ooo = bvz.O00000Oo(nVar.O00000oO);
                                }
                                if (!TextUtils.isEmpty(string)) {
                                    if (string.equals(nVar.O0000Ooo)) {
                                        z = true;
                                        if (!z) {
                                            if (message.what == 1) {
                                                bwf.O000000o((String) null, 2102);
                                                AMapLocationServer O000000o2 = n.O000000o(10, "invalid handlder scode!!!#1002");
                                                n.this.O000000o(messenger, O000000o2, O000000o2.l(), 0);
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                z = false;
                                if (!z) {
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            try {
                                bvz.O000000o(th, "ApsServiceCore", "ActionHandler handlerMessage");
                                switch (message.what) {
                                }
                            } catch (Throwable th2) {
                                bvz.O000000o(th2, "actionHandler", "handleMessage");
                                return;
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    messenger = null;
                    bvz.O000000o(th, "ApsServiceCore", "ActionHandler handlerMessage");
                    switch (message.what) {
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                bundle = null;
                messenger = null;
                bvz.O000000o(th, "ApsServiceCore", "ActionHandler handlerMessage");
                switch (message.what) {
                }
            }
            switch (message.what) {
                case 0:
                    n.this.O000000o(bundle);
                    n.O000000o(n.this, messenger, bundle);
                    super.handleMessage(message);
                    return;
                case 1:
                    n.this.O000000o(bundle);
                    n.O00000Oo(n.this, messenger, bundle);
                    super.handleMessage(message);
                    return;
                case 2:
                    if (bundle == null) {
                        return;
                    }
                    if (!bundle.isEmpty()) {
                        n.this.O000000o((Bundle) null);
                        n nVar2 = n.this;
                        try {
                            if (!nVar2.O0000oO0) {
                                nVar2.O0000oO = new O00000o0();
                                nVar2.O0000oO.start();
                                nVar2.O0000oO0 = true;
                            }
                        } catch (Throwable th5) {
                            bvz.O000000o(th5, "ApsServiceCore", "startSocket");
                        }
                        super.handleMessage(message);
                        return;
                    }
                    return;
                case 3:
                    if (bundle == null) {
                        return;
                    }
                    if (!bundle.isEmpty()) {
                        n.this.O000000o((Bundle) null);
                        n.this.O000000o();
                        super.handleMessage(message);
                        return;
                    }
                    return;
                case 4:
                    n.this.O000000o(bundle);
                    n.O000000o(n.this);
                    super.handleMessage(message);
                    return;
                case 5:
                    n.this.O000000o(bundle);
                    n.O00000Oo(n.this);
                    super.handleMessage(message);
                    return;
                case 6:
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                default:
                    super.handleMessage(message);
                    return;
                case 7:
                    n.this.O000000o(bundle);
                    n.O00000o0(n.this);
                    super.handleMessage(message);
                    return;
                case 9:
                    n.this.O000000o(bundle);
                    n.O000000o(n.this, messenger);
                    super.handleMessage(message);
                    return;
                case 10:
                    n.this.O000000o(bundle);
                    n nVar3 = n.this;
                    if (bundle != null) {
                        if (!bundle.isEmpty()) {
                            if (bvy.O0000o()) {
                                double d = bundle.getDouble("lat");
                                double d2 = bundle.getDouble("lon");
                                nVar3.O00000Oo(bundle);
                                if (nVar3.O00000o0 != null) {
                                    f = bwi.O000000o(new double[]{d, d2, nVar3.O00000o0.getLatitude(), nVar3.O00000o0.getLongitude()});
                                    if (f < ((float) (bvy.O0000oO0() * 3))) {
                                        Bundle bundle2 = new Bundle();
                                        bundle2.setClassLoader(AMapLocation.class.getClassLoader());
                                        bundle2.putInt("I_MAX_GEO_DIS", bvy.O0000oO0() * 3);
                                        bundle2.putInt("I_MIN_GEO_DIS", bvy.O0000oO0());
                                        bundle2.putParcelable("loc", nVar3.O00000o0);
                                        n.O000000o(messenger, 6, bundle2);
                                    }
                                } else {
                                    f = -1.0f;
                                }
                                if (f == -1.0f || f > ((float) bvy.O0000oO0())) {
                                    nVar3.O000000o(bundle);
                                    nVar3.O00000o0 = nVar3.O00000oo.O000000o(d, d2);
                                }
                            }
                        }
                    }
                    super.handleMessage(message);
                    return;
                case 11:
                    n.this.O00000Oo();
                    super.handleMessage(message);
                    return;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    n.this.O0000OOo.remove(messenger);
                    super.handleMessage(message);
                    return;
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.loc.ee.O000000o(boolean, boolean):void
     arg types: [int, boolean]
     candidates:
      com.loc.ee.O000000o(com.loc.ee, long):long
      com.loc.ee.O000000o(android.telephony.CellInfoCdma, boolean):_m_j.bvm
      com.loc.ee.O000000o(android.telephony.CellInfoGsm, boolean):_m_j.bvm
      com.loc.ee.O000000o(android.telephony.CellInfoLte, boolean):_m_j.bvm
      com.loc.ee.O000000o(android.telephony.CellInfoWcdma, boolean):_m_j.bvm
      com.loc.ee.O000000o(android.telephony.NeighboringCellInfo, java.lang.String[]):_m_j.bvm
      com.loc.ee.O000000o(com.loc.ee, int):void
      com.loc.ee.O000000o(int, int):boolean
      com.loc.ee.O000000o(boolean, boolean):void */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(19:5|(1:7)|8|(1:10)|11|(1:13)|14|15|(3:17|18|23)|24|(7:25|26|(1:28)|29|(1:31)|32|(1:34))|39|40|41|42|(1:44)|45|46|47) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00b6 */
    public final void O000000o(Bundle bundle) {
        try {
            if (!this.O0000oOO) {
                bvz.O000000o(this.O00000oO);
                if (bundle != null) {
                    this.O0000o0 = bvz.O000000o(bundle.getBundle("optBundle"));
                }
                this.O00000oo.O000000o(this.O00000oO);
                this.O00000oo.O000000o();
                O000000o(this.O0000o0);
                bud bud = this.O00000oo;
                if (bud.O000O0OO == null) {
                    bud.O000O0OO = new eb(bud.f13281O000000o);
                }
                if (bud.O00000oo == null) {
                    bud.O00000oo = new ct(bud.f13281O000000o);
                }
                bud.O00000oo();
                bud.O00000o0.O000000o(false);
                bud.O0000OOo = bud.O00000o0.O00000Oo();
                bud.O00000o.O000000o(false, bud.O0000OOo());
                bvp bvp = bud.O00000oO;
                Context context = bud.f13281O000000o;
                if (!bvp.O00000Oo) {
                    bvp.O000000o();
                    bvp.O000000o(context, (String) null);
                    bvp.O00000Oo = true;
                }
                ct ctVar = bud.O00000oo;
                try {
                    if (ctVar.O00000oO == null) {
                        ctVar.O00000oO = new ServiceConnection() {
                            /* class com.loc.ct.AnonymousClass1 */

                            public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                                ct ctVar = ct.this;
                                ctVar.O00000o0 = true;
                                s unused = ctVar.O00000o = s.a.a(iBinder);
                            }

                            public final void onServiceDisconnected(ComponentName componentName) {
                                ct ctVar = ct.this;
                                ctVar.O00000o0 = false;
                                s unused = ctVar.O00000o = null;
                            }
                        };
                    }
                    if (ctVar.O00000oo == null) {
                        ctVar.O00000oo = new ServiceConnection() {
                            /* class com.loc.ct.AnonymousClass2 */

                            public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                            }

                            public final void onServiceDisconnected(ComponentName componentName) {
                            }
                        };
                    }
                    if (ctVar.O0000O0o == null) {
                        ctVar.O0000O0o = new ServiceConnection() {
                            /* class com.loc.ct.AnonymousClass3 */

                            public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                            }

                            public final void onServiceDisconnected(ComponentName componentName) {
                            }
                        };
                    }
                } catch (Throwable th) {
                    bvz.O000000o(th, "ConnectionServiceManager", "init");
                }
                if (bud.f13281O000000o.checkCallingOrSelfPermission(brs.O00000o0("EYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFQ1VSRV9TRVRUSU5HUw==")) == 0) {
                    bud.O0000o0 = true;
                }
                bud.O00oOooo = true;
                this.O0000oOO = true;
                this.O000O00o = true;
                this.O000O0OO = "";
            }
        } catch (Throwable th2) {
            this.O000O00o = false;
            this.O000O0OO = th2.getMessage();
            bvz.O000000o(th2, "ApsServiceCore", "init");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bwg.O000000o(android.content.Context, java.lang.String, java.lang.String, long):void
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.bwg.O000000o(android.content.Context, java.lang.String, java.lang.String, int):void
      _m_j.bwg.O000000o(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void
      _m_j.bwg.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void
      _m_j.bwg.O000000o(android.content.Context, java.lang.String, java.lang.String, long):void */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0031 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00a0 */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a7 A[Catch:{ Throwable -> 0x00af }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    public final void O00000Oo() {
        O00000Oo o00000Oo;
        try {
            this.O0000OOo.clear();
            this.O0000OOo = null;
            if (this.O00000oo != null) {
                bud.O00000Oo(this.O00000oO);
            }
            if (this.O00000o != null) {
                this.O00000o.removeCallbacksAndMessages(null);
            }
            int i = 0;
            if (this.O00000Oo != null) {
                if (Build.VERSION.SDK_INT >= 18) {
                    bwd.O000000o(this.O00000Oo, HandlerThread.class, "quitSafely", new Object[0]);
                    o00000Oo = this.O00000Oo;
                } else {
                    o00000Oo = this.O00000Oo;
                }
                o00000Oo.quit();
            }
            this.O00000Oo = null;
            this.O00000o = null;
            if (this.O00oOooo != null) {
                this.O00oOooo.O00000o0();
                this.O00oOooo = null;
            }
            O000000o();
            this.O0000oOO = false;
            this.O0000oOo = false;
            this.O00000oo.O00000oO();
            bwf.O000000o(this.O00000oO);
            if (this.O0000Oo0 != null && this.O0000Oo != 0 && this.O0000OoO != 0) {
                long O00000o02 = bwi.O00000o0() - this.O0000Oo;
                bwf.O000000o(this.O00000oO, this.O0000Oo0.O00000o0(this.O00000oO), this.O0000Oo0.O00000o(this.O00000oO), this.O0000OoO, O00000o02);
                bwf bwf = this.O0000Oo0;
                Context context = this.O00000oO;
                while (true) {
                    if (i < bwf.O00000o.length) {
                        bwg.O000000o(context, "pref", bwf.O00000o[i], 0L);
                        i++;
                    }
                }
            }
            bsf.O00000Oo();
            if (!O0000O0o) {
                Process.killProcess(Process.myPid());
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "ApsServiceCore", "threadDestroy");
        }
    }

    private void O00000oo() {
        try {
            if (this.O00000oo != null) {
                bud bud = this.O00000oo;
                if (bud.O000O0oO != null) {
                    ef efVar = bud.O000O0oO;
                    try {
                        if (!bvy.O0000oo()) {
                            efVar.O00000Oo();
                        } else if (!bvy.O0000ooo()) {
                            if (efVar.O00000Oo) {
                                if (efVar.f4534O000000o != null) {
                                    efVar.f4534O000000o.O00000o();
                                }
                                efVar.O00000Oo = false;
                            }
                        } else if (!efVar.O00000Oo) {
                            efVar.O00000o0();
                            if (efVar.f4534O000000o != null) {
                                CoManager coManager = efVar.f4534O000000o;
                                try {
                                    if (coManager.O00000Oo) {
                                        if (!coManager.O00000oO) {
                                            if (coManager.O00000oo == null) {
                                                coManager.O00000oo = new ch(coManager.f3563O000000o);
                                            }
                                            coManager.O000000o();
                                            ch chVar = coManager.O00000oo;
                                            btx btx = coManager.O00000o0;
                                            cr crVar = coManager.O00000o;
                                            if (chVar.O00000Oo == null) {
                                                chVar.O00000Oo = new oi();
                                                chVar.O00000Oo.O000000o(chVar.f4520O000000o, chVar.O000000o(btx), crVar);
                                            }
                                        }
                                    }
                                } catch (Throwable th) {
                                    bua.O000000o(th, "CoManager", "startCollect");
                                }
                                efVar.O00000Oo = true;
                            }
                        }
                    } catch (Throwable th2) {
                        bvz.O000000o(th2, "APSCoManager", "startCollection");
                    }
                }
            }
        } catch (Throwable th3) {
            bvz.O000000o(th3, "ApsServiceCore", "startColl");
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x002d */
    static /* synthetic */ void O000000o(n nVar, Messenger messenger, Bundle bundle) {
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    if (!nVar.O0000oOo) {
                        nVar.O0000oOo = true;
                        nVar.O000000o(messenger);
                        bvy.O00000oO(nVar.O00000oO);
                        bud bud = nVar.O00000oo;
                        try {
                            if (bud.O00000oo != null) {
                                bud.O00000oo.O000000o();
                            }
                        } catch (Throwable ) {
                        }
                        nVar.O00000o();
                        if (bvy.O000000o(nVar.O0000ooo) && "1".equals(bundle.getString("isCacheLoc"))) {
                            nVar.O0000ooo = bwi.O00000o0();
                            nVar.O00000oo.O00000o();
                        }
                        nVar.O00000oo();
                    }
                }
            } catch (Throwable th) {
                bvz.O000000o(th, "ApsServiceCore", "doInitAuth");
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amap.api.location.AMapLocation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amap.api.location.AMapLocation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amap.api.location.AMapLocation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amap.api.location.AMapLocation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amap.api.location.AMapLocation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amap.api.location.AMapLocation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: com.amap.api.location.AMapLocation} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x02a0 A[Catch:{ Throwable -> 0x02dd, Throwable -> 0x0332 }] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x02aa A[Catch:{ Throwable -> 0x02dd, Throwable -> 0x0332 }] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x02b8 A[Catch:{ Throwable -> 0x02dd, Throwable -> 0x0332 }] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x02c7  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x02f8 A[Catch:{ Throwable -> 0x02dd, Throwable -> 0x0332 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ee A[Catch:{ Throwable -> 0x025d }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00fc A[Catch:{ Throwable -> 0x025d }] */
    static /* synthetic */ void O00000Oo(n nVar, Messenger messenger, Bundle bundle) {
        long j;
        AMapLocation aMapLocation;
        String str;
        long j2;
        long j3;
        bue bue;
        n nVar2 = nVar;
        Messenger messenger2 = messenger;
        Bundle bundle2 = bundle;
        if (bundle2 != null) {
            try {
                if (!bundle.isEmpty()) {
                    AMapLocationClientOption O00000Oo2 = nVar2.O00000Oo(bundle2);
                    if (nVar2.O0000OOo.containsKey(messenger2) && !O00000Oo2.isOnceLocation()) {
                        if (bwi.O00000o0() - nVar2.O0000OOo.get(messenger2).longValue() < 800) {
                            return;
                        }
                    }
                    if (!nVar2.O000O00o) {
                        nVar2.O0000ooO = O000000o(9, "init error : " + nVar2.O000O0OO + "#0901");
                        nVar.O000000o(messenger, nVar2.O0000ooO, nVar2.O0000ooO.l(), 0);
                        bwf.O000000o((String) null, 2091);
                        return;
                    }
                    long O00000o02 = bwi.O00000o0();
                    if (!bwi.O000000o(nVar2.O0000ooO) || O00000o02 - nVar2.O0000oo >= 600) {
                        bwe bwe = new bwe();
                        bwe.f13330O000000o = bwi.O00000o0();
                        try {
                            nVar2.O0000ooO = nVar2.O00000oo.O00000o0();
                            if (nVar2.O0000ooO.getLocationType() != 6) {
                                try {
                                    if (nVar2.O0000ooO.getLocationType() != 5) {
                                        j3 = 0;
                                        bwe.O00000o0 = nVar2.O0000ooO;
                                        bud bud = nVar2.O00000oo;
                                        AMapLocationServer aMapLocationServer = nVar2.O0000ooO;
                                        bud.O000O0o0.O00000o = bud.O0000oOO;
                                        bue = bud.O000O0o0;
                                        if (bwi.O00000o0() - bue.O00000oo <= DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS) {
                                            bue.f13284O000000o = aMapLocationServer;
                                            bue.O00000oo = bwi.O00000o0();
                                        } else {
                                            bue.O00000oo = bwi.O00000o0();
                                            if (bwi.O000000o(bue.f13284O000000o)) {
                                                if (bwi.O000000o(aMapLocationServer)) {
                                                    if (aMapLocationServer.getTime() != bue.f13284O000000o.getTime() || aMapLocationServer.getAccuracy() >= 300.0f) {
                                                        if (aMapLocationServer.getProvider().equals("gps") || aMapLocationServer.c() != bue.f13284O000000o.c() || (!aMapLocationServer.getBuildingId().equals(bue.f13284O000000o.getBuildingId()) && !TextUtils.isEmpty(aMapLocationServer.getBuildingId()))) {
                                                            j2 = j3;
                                                        } else {
                                                            bue.O00000oO = aMapLocationServer.getLocationType();
                                                            float O000000o2 = bwi.O000000o(aMapLocationServer, bue.f13284O000000o);
                                                            float accuracy = bue.f13284O000000o.getAccuracy();
                                                            float accuracy2 = aMapLocationServer.getAccuracy();
                                                            float f = accuracy2 - accuracy;
                                                            long O00000o03 = bwi.O00000o0();
                                                            long j4 = O00000o03 - bue.O00000Oo;
                                                            boolean z = true;
                                                            boolean z2 = accuracy <= 100.0f && accuracy2 > 299.0f;
                                                            if (accuracy <= 299.0f || accuracy2 <= 299.0f) {
                                                                z = false;
                                                            }
                                                            if (!z2) {
                                                                if (!z) {
                                                                    if (accuracy2 >= 100.0f || accuracy <= 299.0f) {
                                                                        if (accuracy2 <= 299.0f) {
                                                                            j2 = j3;
                                                                            try {
                                                                                bue.O00000o0 = 0;
                                                                            } catch (Throwable th) {
                                                                                th = th;
                                                                                aMapLocation = null;
                                                                                bwf.O000000o((String) null, 2081);
                                                                                nVar2.O0000ooO = O000000o(8, "loc error : " + th.getMessage() + "#0801");
                                                                                bvz.O000000o(th, "ApsServiceCore", "run part2");
                                                                                j = j2;
                                                                                bwe.O00000Oo = bwi.O00000o0();
                                                                                if (bwi.O000000o(nVar2.O0000ooO)) {
                                                                                }
                                                                                if (nVar2.O0000ooO == null) {
                                                                                }
                                                                                if (nVar2.O0000ooO != null) {
                                                                                }
                                                                                aMapLocation = nVar2.O00oOooo.O000000o(aMapLocation, str, O00000Oo2.getLastLocationLifeCycle());
                                                                                nVar.O000000o(messenger, aMapLocation, str, j);
                                                                                bwf.O000000o(nVar2.O00000oO, bwe);
                                                                                nVar.O000000o(messenger);
                                                                                if (bvy.O0000oOo()) {
                                                                                }
                                                                                nVar2.O0000ooo = bwi.O00000o0();
                                                                                nVar2.O00000oo.O00000o();
                                                                                nVar.O00000oo();
                                                                            }
                                                                        } else {
                                                                            j2 = j3;
                                                                        }
                                                                        if (O000000o2 < 10.0f && ((double) O000000o2) > 0.1d && accuracy2 > 5.0f) {
                                                                            if (f >= -300.0f) {
                                                                                bue.f13284O000000o = bue.O000000o(bue.f13284O000000o);
                                                                            } else if (accuracy / accuracy2 >= 2.0f) {
                                                                                bue.O00000Oo = O00000o03;
                                                                                bue.f13284O000000o = aMapLocationServer;
                                                                            } else {
                                                                                bue.f13284O000000o = bue.O000000o(bue.f13284O000000o);
                                                                            }
                                                                            aMapLocationServer = bue.f13284O000000o;
                                                                            nVar2.O0000ooO = aMapLocationServer;
                                                                            j = j2;
                                                                            aMapLocation = null;
                                                                            bwe.O00000Oo = bwi.O00000o0();
                                                                            if (bwi.O000000o(nVar2.O0000ooO)) {
                                                                            }
                                                                            if (nVar2.O0000ooO == null) {
                                                                            }
                                                                            if (nVar2.O0000ooO != null) {
                                                                            }
                                                                            aMapLocation = nVar2.O00oOooo.O000000o(aMapLocation, str, O00000Oo2.getLastLocationLifeCycle());
                                                                            nVar.O000000o(messenger, aMapLocation, str, j);
                                                                            bwf.O000000o(nVar2.O00000oO, bwe);
                                                                        } else if (f >= 300.0f && j4 < DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS) {
                                                                            bue.f13284O000000o = bue.O000000o(bue.f13284O000000o);
                                                                            aMapLocationServer = bue.f13284O000000o;
                                                                            nVar2.O0000ooO = aMapLocationServer;
                                                                            j = j2;
                                                                            aMapLocation = null;
                                                                            bwe.O00000Oo = bwi.O00000o0();
                                                                            if (bwi.O000000o(nVar2.O0000ooO)) {
                                                                                nVar2.O0000oo = bwi.O00000o0();
                                                                            }
                                                                            if (nVar2.O0000ooO == null) {
                                                                                nVar2.O0000ooO = O000000o(8, "loc is null#0801");
                                                                            }
                                                                            if (nVar2.O0000ooO != null) {
                                                                                str = nVar2.O0000ooO.l();
                                                                                aMapLocation = nVar2.O0000ooO.clone();
                                                                            } else {
                                                                                str = aMapLocation;
                                                                            }
                                                                            if (O00000Oo2.isLocationCacheEnable() && nVar2.O00oOooo != null) {
                                                                                aMapLocation = nVar2.O00oOooo.O000000o(aMapLocation, str, O00000Oo2.getLastLocationLifeCycle());
                                                                            }
                                                                            nVar.O000000o(messenger, aMapLocation, str, j);
                                                                            bwf.O000000o(nVar2.O00000oO, bwe);
                                                                        }
                                                                    } else {
                                                                        bue.O00000Oo = O00000o03;
                                                                        bue.f13284O000000o = aMapLocationServer;
                                                                        bue.O00000o0 = 0;
                                                                    }
                                                                }
                                                            }
                                                            j2 = j3;
                                                            if (bue.O00000o0 == 0) {
                                                                bue.O00000o0 = O00000o03;
                                                            } else if (O00000o03 - bue.O00000o0 > DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS) {
                                                                bue.O00000Oo = O00000o03;
                                                                bue.f13284O000000o = aMapLocationServer;
                                                                bue.O00000o0 = 0;
                                                                aMapLocationServer = bue.f13284O000000o;
                                                                nVar2.O0000ooO = aMapLocationServer;
                                                                j = j2;
                                                                aMapLocation = null;
                                                                bwe.O00000Oo = bwi.O00000o0();
                                                                if (bwi.O000000o(nVar2.O0000ooO)) {
                                                                }
                                                                if (nVar2.O0000ooO == null) {
                                                                }
                                                                if (nVar2.O0000ooO != null) {
                                                                }
                                                                aMapLocation = nVar2.O00oOooo.O000000o(aMapLocation, str, O00000Oo2.getLastLocationLifeCycle());
                                                                nVar.O000000o(messenger, aMapLocation, str, j);
                                                                bwf.O000000o(nVar2.O00000oO, bwe);
                                                            }
                                                            bue.f13284O000000o = bue.O000000o(bue.f13284O000000o);
                                                            aMapLocationServer = bue.f13284O000000o;
                                                            nVar2.O0000ooO = aMapLocationServer;
                                                            j = j2;
                                                            aMapLocation = null;
                                                            bwe.O00000Oo = bwi.O00000o0();
                                                            if (bwi.O000000o(nVar2.O0000ooO)) {
                                                            }
                                                            if (nVar2.O0000ooO == null) {
                                                            }
                                                            if (nVar2.O0000ooO != null) {
                                                            }
                                                            aMapLocation = nVar2.O00oOooo.O000000o(aMapLocation, str, O00000Oo2.getLastLocationLifeCycle());
                                                            nVar.O000000o(messenger, aMapLocation, str, j);
                                                            bwf.O000000o(nVar2.O00000oO, bwe);
                                                        }
                                                        bue.O00000Oo = bwi.O00000o0();
                                                        bue.f13284O000000o = aMapLocationServer;
                                                        aMapLocationServer = bue.f13284O000000o;
                                                        nVar2.O0000ooO = aMapLocationServer;
                                                        j = j2;
                                                        aMapLocation = null;
                                                        bwe.O00000Oo = bwi.O00000o0();
                                                        if (bwi.O000000o(nVar2.O0000ooO)) {
                                                        }
                                                        if (nVar2.O0000ooO == null) {
                                                        }
                                                        if (nVar2.O0000ooO != null) {
                                                        }
                                                        aMapLocation = nVar2.O00oOooo.O000000o(aMapLocation, str, O00000Oo2.getLastLocationLifeCycle());
                                                        nVar.O000000o(messenger, aMapLocation, str, j);
                                                        bwf.O000000o(nVar2.O00000oO, bwe);
                                                    } else {
                                                        j2 = j3;
                                                        nVar2.O0000ooO = aMapLocationServer;
                                                        j = j2;
                                                        aMapLocation = null;
                                                        bwe.O00000Oo = bwi.O00000o0();
                                                        if (bwi.O000000o(nVar2.O0000ooO)) {
                                                        }
                                                        if (nVar2.O0000ooO == null) {
                                                        }
                                                        if (nVar2.O0000ooO != null) {
                                                        }
                                                        aMapLocation = nVar2.O00oOooo.O000000o(aMapLocation, str, O00000Oo2.getLastLocationLifeCycle());
                                                        nVar.O000000o(messenger, aMapLocation, str, j);
                                                        bwf.O000000o(nVar2.O00000oO, bwe);
                                                    }
                                                }
                                            }
                                            j2 = j3;
                                            bue.O00000Oo = bwi.O00000o0();
                                            bue.f13284O000000o = aMapLocationServer;
                                            aMapLocationServer = bue.f13284O000000o;
                                            nVar2.O0000ooO = aMapLocationServer;
                                            j = j2;
                                            aMapLocation = null;
                                            bwe.O00000Oo = bwi.O00000o0();
                                            if (bwi.O000000o(nVar2.O0000ooO)) {
                                            }
                                            if (nVar2.O0000ooO == null) {
                                            }
                                            if (nVar2.O0000ooO != null) {
                                            }
                                            aMapLocation = nVar2.O00oOooo.O000000o(aMapLocation, str, O00000Oo2.getLastLocationLifeCycle());
                                            nVar.O000000o(messenger, aMapLocation, str, j);
                                            bwf.O000000o(nVar2.O00000oO, bwe);
                                        }
                                        aMapLocationServer = bue.f13284O000000o;
                                        j2 = j3;
                                        nVar2.O0000ooO = aMapLocationServer;
                                        j = j2;
                                        aMapLocation = null;
                                        bwe.O00000Oo = bwi.O00000o0();
                                        if (bwi.O000000o(nVar2.O0000ooO)) {
                                        }
                                        if (nVar2.O0000ooO == null) {
                                        }
                                        if (nVar2.O0000ooO != null) {
                                        }
                                        aMapLocation = nVar2.O00oOooo.O000000o(aMapLocation, str, O00000Oo2.getLastLocationLifeCycle());
                                        nVar.O000000o(messenger, aMapLocation, str, j);
                                        bwf.O000000o(nVar2.O00000oO, bwe);
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    j2 = 0;
                                    aMapLocation = null;
                                    bwf.O000000o((String) null, 2081);
                                    nVar2.O0000ooO = O000000o(8, "loc error : " + th.getMessage() + "#0801");
                                    bvz.O000000o(th, "ApsServiceCore", "run part2");
                                    j = j2;
                                    bwe.O00000Oo = bwi.O00000o0();
                                    if (bwi.O000000o(nVar2.O0000ooO)) {
                                    }
                                    if (nVar2.O0000ooO == null) {
                                    }
                                    if (nVar2.O0000ooO != null) {
                                    }
                                    aMapLocation = nVar2.O00oOooo.O000000o(aMapLocation, str, O00000Oo2.getLastLocationLifeCycle());
                                    nVar.O000000o(messenger, aMapLocation, str, j);
                                    bwf.O000000o(nVar2.O00000oO, bwe);
                                    nVar.O000000o(messenger);
                                    if (bvy.O0000oOo()) {
                                    }
                                    nVar2.O0000ooo = bwi.O00000o0();
                                    nVar2.O00000oo.O00000o();
                                    nVar.O00000oo();
                                }
                            }
                            j3 = nVar2.O0000ooO.k();
                            try {
                                bwe.O00000o0 = nVar2.O0000ooO;
                                bud bud2 = nVar2.O00000oo;
                                AMapLocationServer aMapLocationServer2 = nVar2.O0000ooO;
                                bud2.O000O0o0.O00000o = bud2.O0000oOO;
                                bue = bud2.O000O0o0;
                                if (bwi.O00000o0() - bue.O00000oo <= DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS) {
                                }
                                aMapLocationServer2 = bue.f13284O000000o;
                                j2 = j3;
                                nVar2.O0000ooO = aMapLocationServer2;
                                j = j2;
                                aMapLocation = null;
                            } catch (Throwable th3) {
                                th = th3;
                                j2 = j3;
                                aMapLocation = null;
                                bwf.O000000o((String) null, 2081);
                                nVar2.O0000ooO = O000000o(8, "loc error : " + th.getMessage() + "#0801");
                                bvz.O000000o(th, "ApsServiceCore", "run part2");
                                j = j2;
                                bwe.O00000Oo = bwi.O00000o0();
                                if (bwi.O000000o(nVar2.O0000ooO)) {
                                }
                                if (nVar2.O0000ooO == null) {
                                }
                                if (nVar2.O0000ooO != null) {
                                }
                                aMapLocation = nVar2.O00oOooo.O000000o(aMapLocation, str, O00000Oo2.getLastLocationLifeCycle());
                                nVar.O000000o(messenger, aMapLocation, str, j);
                                bwf.O000000o(nVar2.O00000oO, bwe);
                                nVar.O000000o(messenger);
                                if (bvy.O0000oOo()) {
                                }
                                nVar2.O0000ooo = bwi.O00000o0();
                                nVar2.O00000oo.O00000o();
                                nVar.O00000oo();
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            j2 = 0;
                            aMapLocation = null;
                            bwf.O000000o((String) null, 2081);
                            nVar2.O0000ooO = O000000o(8, "loc error : " + th.getMessage() + "#0801");
                            bvz.O000000o(th, "ApsServiceCore", "run part2");
                            j = j2;
                            bwe.O00000Oo = bwi.O00000o0();
                            if (bwi.O000000o(nVar2.O0000ooO)) {
                            }
                            if (nVar2.O0000ooO == null) {
                            }
                            if (nVar2.O0000ooO != null) {
                            }
                            aMapLocation = nVar2.O00oOooo.O000000o(aMapLocation, str, O00000Oo2.getLastLocationLifeCycle());
                            nVar.O000000o(messenger, aMapLocation, str, j);
                            bwf.O000000o(nVar2.O00000oO, bwe);
                            nVar.O000000o(messenger);
                            if (bvy.O0000oOo()) {
                            }
                            nVar2.O0000ooo = bwi.O00000o0();
                            nVar2.O00000oo.O00000o();
                            nVar.O00000oo();
                        }
                        bwe.O00000Oo = bwi.O00000o0();
                        if (bwi.O000000o(nVar2.O0000ooO)) {
                        }
                        if (nVar2.O0000ooO == null) {
                        }
                        if (nVar2.O0000ooO != null) {
                        }
                        aMapLocation = nVar2.O00oOooo.O000000o(aMapLocation, str, O00000Oo2.getLastLocationLifeCycle());
                        nVar.O000000o(messenger, aMapLocation, str, j);
                        bwf.O000000o(nVar2.O00000oO, bwe);
                    } else {
                        nVar.O000000o(messenger, nVar2.O0000ooO, nVar2.O0000ooO.l(), 0);
                    }
                    nVar.O000000o(messenger);
                    if (bvy.O0000oOo()) {
                        nVar.O00000o();
                    }
                    if (bvy.O000000o(nVar2.O0000ooo) && nVar2.O0000ooO != null && (nVar2.O0000ooO.getLocationType() == 2 || nVar2.O0000ooO.getLocationType() == 4 || nVar2.O0000ooO.getLocationType() == 9)) {
                        nVar2.O0000ooo = bwi.O00000o0();
                        nVar2.O00000oo.O00000o();
                    }
                    nVar.O00000oo();
                }
            } catch (Throwable th5) {
                bvz.O000000o(th5, "ApsServiceCore", "doLocation");
            }
        }
    }

    static /* synthetic */ void O000000o(n nVar, Messenger messenger) {
        try {
            nVar.O000000o(messenger);
            bvy.O00000oO(nVar.O00000oO);
            try {
                bud bud = nVar.O00000oo;
                if (bud.O00000oo != null) {
                    bud.O00000oo.O00000Oo();
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "ApsServiceCore", "doCallOtherSer");
        }
    }
}
