package com.google.android.play.core.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import com.google.android.play.core.splitcompat.d;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ao {

    /* renamed from: a  reason: collision with root package name */
    private final d f3753a;
    private final Context b;
    private final aq c;

    public ao(Context context, d dVar, aq aqVar, byte[] bArr) {
        this.f3753a = dVar;
        this.c = aqVar;
        this.b = context;
    }

    private static X509Certificate a(Signature signature) {
        try {
            return (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(signature.toByteArray()));
        } catch (CertificateException e) {
            Log.e("SplitCompat", "Cannot decode certificate.", e);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        r5 = new java.lang.StringBuilder(java.lang.String.valueOf(r8).length() + 32);
        r5.append("Downloaded split ");
        r5.append(r8);
        r5.append(" is not signed.");
        r0 = r5.toString();
     */
    public final boolean a() {
        Signature[] signatureArr;
        String sb;
        try {
            File c2 = this.f3753a.c();
            ArrayList<X509Certificate> arrayList = null;
            try {
                signatureArr = this.b.getPackageManager().getPackageInfo(this.b.getPackageName(), 64).signatures;
            } catch (PackageManager.NameNotFoundException unused) {
                signatureArr = null;
            }
            if (signatureArr != null) {
                arrayList = new ArrayList<>();
                for (Signature a2 : signatureArr) {
                    X509Certificate a3 = a(a2);
                    if (a3 != null) {
                        arrayList.add(a3);
                    }
                }
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                File[] listFiles = c2.listFiles();
                Arrays.sort(listFiles);
                int length = listFiles.length;
                loop1:
                while (true) {
                    length--;
                    if (length < 0) {
                        return true;
                    }
                    File file = listFiles[length];
                    try {
                        String absolutePath = file.getAbsolutePath();
                        try {
                            X509Certificate[][] a4 = h.a(absolutePath);
                            if (a4 != null) {
                                if (a4.length != 0 && a4[0].length != 0) {
                                    if (arrayList.isEmpty()) {
                                        sb = "No certificates found for app.";
                                        break;
                                    }
                                    for (X509Certificate x509Certificate : arrayList) {
                                        int length2 = a4.length;
                                        int i = 0;
                                        while (true) {
                                            if (i >= length2) {
                                                Log.i("SplitCompat", "There's an app certificate that doesn't sign the split.");
                                                break loop1;
                                            } else if (!a4[i][0].equals(x509Certificate)) {
                                                i++;
                                            }
                                        }
                                    }
                                    try {
                                        file.renameTo(this.f3753a.a(file));
                                    } catch (IOException e) {
                                        Log.e("SplitCompat", "Cannot write verified split.", e);
                                        return false;
                                    }
                                }
                            }
                            break;
                        } catch (Exception e2) {
                            StringBuilder sb2 = new StringBuilder(String.valueOf(absolutePath).length() + 32);
                            sb2.append("Downloaded split ");
                            sb2.append(absolutePath);
                            sb2.append(" is not signed.");
                            Log.e("SplitCompat", sb2.toString(), e2);
                        }
                    } catch (Exception e3) {
                        Log.e("SplitCompat", "Split verification error.", e3);
                        return false;
                    }
                }
                Log.e("SplitCompat", sb);
                Log.e("SplitCompat", "Split verification failure.");
                return false;
            }
            Log.e("SplitCompat", "No app certificates found.");
            return false;
        } catch (IOException e4) {
            Log.e("SplitCompat", "Cannot access directory for unverified splits.", e4);
            return false;
        }
    }

    public final boolean a(List<Intent> list) throws IOException {
        for (Intent stringExtra : list) {
            if (!this.f3753a.b(stringExtra.getStringExtra("split_id")).exists()) {
                return false;
            }
        }
        return true;
    }
}
