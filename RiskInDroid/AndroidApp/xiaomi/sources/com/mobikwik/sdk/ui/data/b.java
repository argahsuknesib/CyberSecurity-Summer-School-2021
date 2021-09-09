package com.mobikwik.sdk.ui.data;

import android.content.Context;
import com.mobikwik.sdk.lib.Constants;
import com.mobikwik.sdk.lib.Transaction;
import com.mobikwik.sdk.lib.TransactionConfiguration;
import com.mobikwik.sdk.lib.model.PaymentsMappingAPIResponse;
import com.mobikwik.sdk.lib.model.SavedCardResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.ArrayList;

public class b implements Serializable {
    private static Context b = null;
    private static String c = "mbkTxn.bin";
    private static b d;

    /* renamed from: a  reason: collision with root package name */
    public TransactionConfiguration f5300a;
    private Transaction e;
    private PaymentsMappingAPIResponse.SDKPaymentMappingBody f;
    private ArrayList g;
    private String h;
    private SavedCardResponse.CardDetails[] i;
    private SavedCardResponse.CardDetails[] j;
    private String k;
    private boolean l;

    public static b a(Context context) {
        File file = new File(context.getCacheDir(), c);
        if (file.exists()) {
            file.delete();
        }
        b bVar = new b();
        d = bVar;
        return bVar;
    }

    public static b b(Context context) {
        b = context.getApplicationContext();
        if (d == null) {
            l();
        }
        return d;
    }

    private static void l() {
        File[] listFiles = b.getCacheDir().listFiles();
        boolean z = false;
        if (listFiles != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= listFiles.length) {
                    break;
                } else if (c.equalsIgnoreCase(listFiles[i2].getName())) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
        }
        if (z) {
            try {
                d = (b) new ObjectInputStream(new FileInputStream(new File(b.getCacheDir(), c))).readObject();
            } catch (StreamCorruptedException e2) {
                e2.printStackTrace();
            } catch (IOException e3) {
                e3.printStackTrace();
            } catch (ClassNotFoundException e4) {
                e4.printStackTrace();
            }
        }
    }

    public void a() {
        try {
            new ObjectOutputStream(new FileOutputStream(new File(b.getCacheDir(), c))).writeObject(d);
        } catch (StreamCorruptedException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    public void a(Transaction transaction) {
        this.e = transaction;
    }

    public void a(TransactionConfiguration transactionConfiguration) {
        this.f5300a = transactionConfiguration;
    }

    public void a(PaymentsMappingAPIResponse.SDKPaymentMappingBody sDKPaymentMappingBody) {
        this.f = sDKPaymentMappingBody;
    }

    public void a(String str) {
        this.h = str;
    }

    public void a(ArrayList arrayList) {
        this.g = arrayList;
    }

    public void a(boolean z) {
        this.l = z;
    }

    public void a(SavedCardResponse.CardDetails[] cardDetailsArr) {
        this.j = cardDetailsArr;
    }

    public ArrayList b() {
        return this.g;
    }

    public void b(String str) {
        this.k = str;
    }

    public void b(SavedCardResponse.CardDetails[] cardDetailsArr) {
        this.i = cardDetailsArr;
    }

    public PaymentsMappingAPIResponse.SDKPaymentMappingBody c() {
        return this.f;
    }

    public Transaction d() {
        return this.e;
    }

    public String e() {
        return this.h;
    }

    public TransactionConfiguration f() {
        return this.f5300a;
    }

    public SavedCardResponse.CardDetails[] g() {
        return this.j;
    }

    public SavedCardResponse.CardDetails[] h() {
        return this.i;
    }

    public String i() {
        return this.k;
    }

    public boolean j() {
        return this.l;
    }

    public String k() {
        return (Constants.getServerUrl(this.f5300a.getMode()) + "mobilePaymentResponse.do") + "?userId=" + this.e.getUser().getEmail() + "&param1=" + this.f5300a.getMbkId() + "&param2=" + e() + "&param3=" + this.e.getAmount() + "&version=4";
    }
}
