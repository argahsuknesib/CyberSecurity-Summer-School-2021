package com.xiaomi.smarthome.core.server;

import _m_j.fcz;
import _m_j.fdb;
import _m_j.gnn;
import android.os.MemoryFile;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public class MiHomeMemoryFile implements Parcelable {
    public static final Parcelable.Creator<MiHomeMemoryFile> CREATOR = new Parcelable.Creator<MiHomeMemoryFile>() {
        /* class com.xiaomi.smarthome.core.server.MiHomeMemoryFile.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MiHomeMemoryFile[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new MiHomeMemoryFile(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    Object f6788O000000o;
    MemoryFile O00000Oo;
    Method O00000o;
    Method O00000o0;
    Method O00000oO;

    public int describeContents() {
        return 0;
    }

    protected MiHomeMemoryFile(Parcel parcel) {
        if (gnn.O00000Oo) {
            O00000Oo();
            this.f6788O000000o = parcel.readParcelable(getClass().getClassLoader());
            return;
        }
        int readInt = parcel.readInt();
        ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) parcel.readParcelable(ParcelFileDescriptor.class.getClassLoader());
        if (parcelFileDescriptor != null) {
            this.O00000Oo = fcz.O000000o(parcelFileDescriptor.getFileDescriptor(), readInt, 1);
            return;
        }
        throw new IllegalArgumentException("ParcelFileDescriptor 不能为空");
    }

    public MiHomeMemoryFile() {
        if (gnn.O00000Oo) {
            O00000Oo();
        }
    }

    private void O00000Oo() {
        try {
            Class<?> cls = Class.forName("android.os.SharedMemory");
            if (cls != null) {
                cls.getDeclaredMethods();
                this.O00000oO = cls.getDeclaredMethod("create", String.class, Integer.TYPE);
                this.O00000o = cls.getDeclaredMethod("mapReadWrite", new Class[0]);
                this.O00000o0 = cls.getDeclaredMethod("close", new Class[0]);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        if (gnn.O00000Oo) {
            Object obj = this.f6788O000000o;
            if (obj != null) {
                try {
                    this.O00000o0.invoke(obj, new Object[0]);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e2) {
                    e2.printStackTrace();
                }
                this.f6788O000000o = null;
                return;
            }
            return;
        }
        MemoryFile memoryFile = this.O00000Oo;
        if (memoryFile != null) {
            memoryFile.close();
            this.O00000Oo = null;
        }
    }

    public final Parcel O000000o() {
        Parcel obtain = Parcel.obtain();
        if (gnn.O00000Oo) {
            try {
                ByteBuffer byteBuffer = (ByteBuffer) this.O00000o.invoke(this.f6788O000000o, new Object[0]);
                byte[] bArr = new byte[byteBuffer.remaining()];
                byteBuffer.get(bArr, 0, bArr.length);
                obtain.setDataCapacity(bArr.length);
                obtain.unmarshall(bArr, 0, bArr.length);
            } catch (Exception unused) {
                return null;
            }
        } else {
            try {
                obtain.setDataCapacity(this.O00000Oo.length());
                byte[] bArr2 = new byte[this.O00000Oo.length()];
                this.O00000Oo.readBytes(bArr2, 0, 0, this.O00000Oo.length());
                obtain.unmarshall(bArr2, 0, bArr2.length);
            } catch (IOException unused2) {
                return null;
            }
        }
        obtain.setDataPosition(0);
        return obtain;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fdb.O000000o(java.lang.String, java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object
     arg types: [java.lang.String, android.os.MemoryFile, java.lang.String, java.lang.Object[]]
     candidates:
      _m_j.fdb.O000000o(java.lang.String, java.lang.Object, java.lang.String, java.lang.Object):void
      _m_j.fdb.O000000o(java.lang.String, java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object */
    public void writeToParcel(Parcel parcel, int i) {
        if (gnn.O00000Oo) {
            parcel.writeParcelable((Parcelable) this.f6788O000000o, i);
            return;
        }
        parcel.writeInt(this.O00000Oo.length());
        MemoryFile memoryFile = this.O00000Oo;
        if (memoryFile == null) {
            throw new IllegalArgumentException("memoryFile 不能为空");
        } else if (memoryFile != null) {
            parcel.writeParcelable((ParcelFileDescriptor) fdb.O000000o(ParcelFileDescriptor.class, (FileDescriptor) fdb.O000000o("android.os.MemoryFile", (Object) memoryFile, "getFileDescriptor", new Object[0])), i);
        } else {
            throw new IllegalArgumentException("memoryFile 不能为空");
        }
    }
}
