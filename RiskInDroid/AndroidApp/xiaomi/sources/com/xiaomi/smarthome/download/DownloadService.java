package com.xiaomi.smarthome.download;

import _m_j.fri;
import _m_j.frm;
import _m_j.gsy;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ContentUris;
import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Process;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class DownloadService extends Service {

    /* renamed from: O000000o  reason: collision with root package name */
    O00000Oo f7310O000000o;
    frm O00000Oo;
    private O000000o O00000o0;
    public Map<Long, fri> mDownloads = new HashMap();
    public boolean mPendingUpdate;

    class O000000o extends ContentObserver {
        public O000000o() {
            super(new Handler());
        }

        public final void onChange(boolean z) {
            gsy.O000000o(2, "DownloadManager", "Service ContentObserver received notification");
            DownloadService.this.updateFromProvider(false);
        }
    }

    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Cannot bind to Download Manager Service");
    }

    public void onCreate() {
        super.onCreate();
        gsy.O000000o(LogType.NETWORK, "", "DownloadService onCreate");
        gsy.O000000o(2, "DownloadManager", "Service onCreate");
        if (this.O00000Oo == null) {
            this.O00000Oo = new RealSystemFacade(this);
        }
        this.O00000o0 = new O000000o();
        getContentResolver().registerContentObserver(Downloads.ALL_DOWNLOADS_CONTENT_URI, true, this.O00000o0);
        this.O00000Oo.O00000oo();
        updateFromProvider(true);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        int onStartCommand = super.onStartCommand(intent, i, i2);
        gsy.O000000o(2, "DownloadManager", "Service onStart");
        updateFromProvider(false);
        return onStartCommand;
    }

    public void onDestroy() {
        gsy.O000000o(LogType.NETWORK, "", "DownloadService onDestroy");
        getContentResolver().unregisterContentObserver(this.O00000o0);
        this.O00000Oo.O0000O0o();
        gsy.O000000o(2, "DownloadManager", "Service onDestroy");
        super.onDestroy();
    }

    public void updateFromProvider(boolean z) {
        synchronized (this) {
            this.mPendingUpdate = true;
            if (this.f7310O000000o == null) {
                this.f7310O000000o = new O00000Oo(z);
                this.O00000Oo.O000000o(this.f7310O000000o);
            }
        }
    }

    class O00000Oo extends Thread {
        private boolean O00000Oo;

        public O00000Oo(boolean z) {
            super("Download Service");
            this.O00000Oo = z;
        }

        /* JADX INFO: finally extract failed */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0093, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0099, code lost:
            r4 = r1.f7312O000000o.O00000Oo.O000000o();
            r6 = new java.util.HashSet(r1.f7312O000000o.mDownloads.keySet());
            r7 = r1.f7312O000000o.getContentResolver().query(com.xiaomi.smarthome.download.Downloads.ALL_DOWNLOADS_CONTENT_URI, null, null, null, null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00be, code lost:
            if (r7 == null) goto L_0x01bd;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
            r8 = new _m_j.fri.O000000o(r1.f7312O000000o.getContentResolver(), r7);
            r9 = r7.getColumnIndexOrThrow("_id");
            r7.moveToFirst();
            r10 = Long.MAX_VALUE;
            r12 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00db, code lost:
            if (r7.isAfterLast() != false) goto L_0x014e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00dd, code lost:
            r15 = r7.getLong(r9);
            r6.remove(java.lang.Long.valueOf(r15));
            r13 = r1.f7312O000000o.mDownloads.get(java.lang.Long.valueOf(r15));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00f6, code lost:
            if (r13 == null) goto L_0x00fe;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00f8, code lost:
            r1.f7312O000000o.updateDownload(r8, r13, r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00fe, code lost:
            r13 = r1.f7312O000000o.insertDownload(r8, r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x010a, code lost:
            if (com.xiaomi.smarthome.download.Downloads.isStatusCompleted(r13.O0000Oo) == false) goto L_0x0112;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x010e, code lost:
            if (r13.O0000OOo != 1) goto L_0x0112;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0110, code lost:
            r15 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0112, code lost:
            r15 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0113, code lost:
            if (r15 == false) goto L_0x0116;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0115, code lost:
            r12 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x011e, code lost:
            if (com.xiaomi.smarthome.download.Downloads.isStatusCompleted(r13.O0000Oo) == false) goto L_0x0125;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0120, code lost:
            r19 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0129, code lost:
            if (r13.O0000Oo == 194) goto L_0x012e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x012b, code lost:
            r19 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x012e, code lost:
            r19 = r13.O000000o(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0134, code lost:
            if (r19 > r4) goto L_0x0137;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0137, code lost:
            r19 = r19 - r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x013b, code lost:
            if (r19 != 0) goto L_0x013f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x013d, code lost:
            r12 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x0141, code lost:
            if (r19 <= 0) goto L_0x0149;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x0145, code lost:
            if (r19 >= r10) goto L_0x0149;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x0147, code lost:
            r10 = r19;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x0149, code lost:
            r7.moveToNext();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x014e, code lost:
            r7.close();
            r0 = r6.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x0159, code lost:
            if (r0.hasNext() == false) goto L_0x016b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x015b, code lost:
            r1.f7312O000000o.deleteDownload(((java.lang.Long) r0.next()).longValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x016b, code lost:
            r0 = r1.f7312O000000o.mDownloads.values().iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x017b, code lost:
            if (r0.hasNext() == false) goto L_0x0189;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x0185, code lost:
            if (r0.next().O0000oo == false) goto L_0x0177;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x0187, code lost:
            r4 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:0x0189, code lost:
            r4 = r12;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x018a, code lost:
            r0 = r1.f7312O000000o.mDownloads.values().iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x019a, code lost:
            if (r0.hasNext() == false) goto L_0x01b4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x019c, code lost:
            r5 = r0.next();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
            if (r5.O0000oo == false) goto L_0x0196;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x01a6, code lost:
            com.xiaomi.smarthome.download.Helpers.O000000o(r1.f7312O000000o.getContentResolver(), r5.f16968O000000o, r5.O00000oO);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x01b8, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x01b9, code lost:
            r7.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x01bc, code lost:
            throw r0;
         */
        public final void run() {
            long j;
            gsy.O000000o(LogType.NETWORK, "", "UpdateThread run");
            Process.setThreadPriority(10);
            if (this.O00000Oo) {
                DownloadService.this.deleteRedundantData();
                DownloadService.this.trimDatabase();
                DownloadService.this.removeSpuriousFiles();
            }
            boolean z = false;
            long j2 = Long.MAX_VALUE;
            while (true) {
                boolean z2 = false;
                while (true) {
                    synchronized (DownloadService.this) {
                        if (DownloadService.this.f7310O000000o != this) {
                            throw new IllegalStateException("multiple UpdateThreads in DownloadService");
                        } else if (!DownloadService.this.mPendingUpdate) {
                            DownloadService.this.f7310O000000o = null;
                            if (!z2) {
                                DownloadService.this.stopSelf();
                                gsy.O000000o(LogType.NETWORK, "", "stop self");
                            }
                            if (j2 != Long.MAX_VALUE) {
                                AlarmManager alarmManager = (AlarmManager) DownloadService.this.getSystemService("alarm");
                                if (alarmManager == null) {
                                    gsy.O000000o(6, "DownloadManager", "couldn't get alarm manager");
                                } else {
                                    Intent intent = new Intent("android.intent.action.DOWNLOAD_WAKEUP");
                                    intent.setClassName(DownloadService.this.getPackageName(), DownloadReceiver.class.getName());
                                    alarmManager.set(z, DownloadService.this.O00000Oo.O000000o() + j2, PendingIntent.getBroadcast(DownloadService.this, z ? 1 : 0, intent, 1073741824));
                                }
                            }
                        } else {
                            DownloadService.this.mPendingUpdate = z;
                        }
                    }
                    j2 = j;
                    z = false;
                }
                j2 = Long.MAX_VALUE;
                z = false;
            }
        }
    }

    public void removeSpuriousFiles() {
        File[] listFiles = Environment.getDownloadCacheDirectory().listFiles();
        if (listFiles != null) {
            HashSet hashSet = new HashSet();
            for (int i = 0; i < listFiles.length; i++) {
                if (!listFiles[i].getName().equals("lost+found") && !listFiles[i].getName().equalsIgnoreCase("recovery")) {
                    hashSet.add(listFiles[i].getPath());
                }
            }
            Cursor query = getContentResolver().query(Downloads.ALL_DOWNLOADS_CONTENT_URI, new String[]{"_data"}, null, null, null);
            if (query != null) {
                if (query.moveToFirst()) {
                    do {
                        hashSet.remove(query.getString(0));
                    } while (query.moveToNext());
                }
                query.close();
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                new File((String) it.next()).delete();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0053  */
    public void deleteRedundantData() {
        Cursor query = getContentResolver().query(Downloads.ALL_DOWNLOADS_CONTENT_URI, new String[]{"_id"}, "status = '200'", null, null);
        if (query != null && query.moveToFirst()) {
            LogType logType = LogType.NETWORK;
            gsy.O000000o(logType, "", "trim 's count = " + query.getCount());
            int columnIndexOrThrow = query.getColumnIndexOrThrow("_id");
            do {
                getContentResolver().delete(ContentUris.withAppendedId(Downloads.ALL_DOWNLOADS_CONTENT_URI, query.getLong(columnIndexOrThrow)), null, null);
            } while (query.moveToNext());
            if (query == null) {
            }
        } else if (query == null) {
            query.close();
        }
    }

    public void trimDatabase() {
        Cursor query = getContentResolver().query(Downloads.ALL_DOWNLOADS_CONTENT_URI, new String[]{"_id"}, "status > '200'", null, "lastmod");
        if (query == null) {
            gsy.O000000o(6, "DownloadManager", "null cursor in trimDatabase");
            return;
        }
        if (query.moveToFirst()) {
            int columnIndexOrThrow = query.getColumnIndexOrThrow("_id");
            for (int count = query.getCount() - 1000; count > 0; count--) {
                getContentResolver().delete(ContentUris.withAppendedId(Downloads.ALL_DOWNLOADS_CONTENT_URI, query.getLong(columnIndexOrThrow)), null, null);
                if (!query.moveToNext()) {
                    break;
                }
            }
        }
        query.close();
    }

    public fri insertDownload(fri.O000000o o000000o, long j) {
        String str;
        fri O000000o2 = o000000o.O000000o(this, this.O00000Oo);
        this.mDownloads.put(Long.valueOf(O000000o2.f16968O000000o), O000000o2);
        gsy.O000000o(2, "DownloadManager", "Service adding new entry");
        gsy.O000000o(2, "DownloadManager", "ID      : " + O000000o2.f16968O000000o);
        StringBuilder sb = new StringBuilder("URI     : ");
        String str2 = "yes";
        sb.append(O000000o2.O00000Oo != null ? str2 : "no");
        gsy.O000000o(2, "DownloadManager", sb.toString());
        gsy.O000000o(2, "DownloadManager", "NO_INTEG: " + O000000o2.O00000o0);
        gsy.O000000o(2, "DownloadManager", "HINT    : " + O000000o2.O00000o);
        gsy.O000000o(2, "DownloadManager", "FILENAME: " + O000000o2.O00000oO);
        gsy.O000000o(2, "DownloadManager", "MIMETYPE: " + O000000o2.O00000oo);
        gsy.O000000o(2, "DownloadManager", "DESTINAT: " + O000000o2.O0000O0o);
        gsy.O000000o(2, "DownloadManager", "VISIBILI: " + O000000o2.O0000OOo);
        gsy.O000000o(2, "DownloadManager", "CONTROL : " + O000000o2.O0000Oo0);
        gsy.O000000o(2, "DownloadManager", "STATUS  : " + O000000o2.O0000Oo);
        gsy.O000000o(2, "DownloadManager", "FAILED_C: " + O000000o2.O0000OoO);
        gsy.O000000o(2, "DownloadManager", "RETRY_AF: " + O000000o2.O0000Ooo);
        gsy.O000000o(2, "DownloadManager", "LAST_MOD: " + O000000o2.O0000o00);
        gsy.O000000o(2, "DownloadManager", "PACKAGE : " + O000000o2.O0000o0);
        gsy.O000000o(2, "DownloadManager", "CLASS   : " + O000000o2.O0000o0O);
        StringBuilder sb2 = new StringBuilder("COOKIES : ");
        if (O000000o2.O0000o != null) {
            str = str2;
        } else {
            str = "no";
        }
        sb2.append(str);
        gsy.O000000o(2, "DownloadManager", sb2.toString());
        gsy.O000000o(2, "DownloadManager", "AGENT   : " + O000000o2.O0000oO0);
        StringBuilder sb3 = new StringBuilder("REFERER : ");
        if (O000000o2.O0000oO == null) {
            str2 = "no";
        }
        sb3.append(str2);
        gsy.O000000o(2, "DownloadManager", sb3.toString());
        gsy.O000000o(2, "DownloadManager", "TOTAL   : " + O000000o2.O0000oOO);
        gsy.O000000o(2, "DownloadManager", "CURRENT : " + O000000o2.O0000oOo);
        gsy.O000000o(2, "DownloadManager", "ETAG    : " + O000000o2.O0000oo0);
        gsy.O000000o(2, "DownloadManager", "DELETED : " + O000000o2.O0000oo);
        O000000o2.O00000Oo(j);
        return O000000o2;
    }

    public void updateDownload(fri.O000000o o000000o, fri fri, long j) {
        int i = fri.O0000OOo;
        int i2 = fri.O0000Oo;
        o000000o.O000000o(fri);
        boolean z = false;
        boolean z2 = i == 1 && fri.O0000OOo != 1 && Downloads.isStatusCompleted(fri.O0000Oo);
        if (!Downloads.isStatusCompleted(i2) && Downloads.isStatusCompleted(fri.O0000Oo)) {
            z = true;
        }
        if (z2 || z) {
            this.O00000Oo.O000000o(fri.f16968O000000o);
        }
        fri.O00000Oo(j);
    }

    public void deleteDownload(long j) {
        fri fri = this.mDownloads.get(Long.valueOf(j));
        if (fri.O0000Oo == 192) {
            fri.O0000Oo = 490;
        }
        if (!(fri.O0000O0o == 0 || fri.O00000oO == null)) {
            new File(fri.O00000oO).delete();
        }
        this.O00000Oo.O000000o(fri.f16968O000000o);
        this.mDownloads.remove(Long.valueOf(fri.f16968O000000o));
    }
}
