package com.shockwave.pdfium;

import _m_j.dbj;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.Surface;
import com.shockwave.pdfium.util.Size;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class PdfiumCore {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f5608O000000o = "com.shockwave.pdfium.PdfiumCore";
    private static final Class O00000Oo = FileDescriptor.class;
    private static Field O00000o = null;
    private static final Object O00000o0 = new Object();
    private int O00000oO;

    private native void nativeCloseDocument(long j);

    private native void nativeClosePage(long j);

    private native void nativeClosePages(long[] jArr);

    private native long nativeGetBookmarkDestIndex(long j, long j2);

    private native String nativeGetBookmarkTitle(long j);

    private native Integer nativeGetDestPageIndex(long j, long j2);

    private native String nativeGetDocumentMetaText(long j, String str);

    private native Long nativeGetFirstChildBookmark(long j, Long l);

    private native RectF nativeGetLinkRect(long j);

    private native String nativeGetLinkURI(long j, long j2);

    private native int nativeGetPageCount(long j);

    private native int nativeGetPageHeightPixel(long j, int i);

    private native int nativeGetPageHeightPoint(long j);

    private native long[] nativeGetPageLinks(long j);

    private native Size nativeGetPageSizeByIndex(long j, int i, int i2);

    private native int nativeGetPageWidthPixel(long j, int i);

    private native int nativeGetPageWidthPoint(long j);

    private native Long nativeGetSiblingBookmark(long j, long j2);

    private native long nativeLoadPage(long j, int i);

    private native long[] nativeLoadPages(long j, int i, int i2);

    private native long nativeOpenDocument(int i, String str);

    private native long nativeOpenMemDocument(byte[] bArr, String str);

    private native Point nativePageCoordsToDevice(long j, int i, int i2, int i3, int i4, int i5, double d, double d2);

    private native void nativeRenderPage(long j, Surface surface, int i, int i2, int i3, int i4, int i5, boolean z);

    private native void nativeRenderPageBitmap(long j, Bitmap bitmap, int i, int i2, int i3, int i4, int i5, boolean z);

    static {
        try {
            System.loadLibrary("c++_shared");
            System.loadLibrary("modpng");
            System.loadLibrary("modft2");
            System.loadLibrary("modpdfium");
            System.loadLibrary("jniPdfium");
        } catch (UnsatisfiedLinkError e) {
            Log.e(f5608O000000o, "Native libraries failed to load - ".concat(String.valueOf(e)));
        }
    }

    private static int O000000o(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            if (O00000o == null) {
                Field declaredField = O00000Oo.getDeclaredField("descriptor");
                O00000o = declaredField;
                declaredField.setAccessible(true);
            }
            return O00000o.getInt(parcelFileDescriptor.getFileDescriptor());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return -1;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public PdfiumCore(Context context) {
        this.O00000oO = context.getResources().getDisplayMetrics().densityDpi;
        Log.d(f5608O000000o, "Starting PdfiumAndroid 1.9.0");
    }

    public final dbj O000000o(ParcelFileDescriptor parcelFileDescriptor, String str) throws IOException {
        dbj dbj = new dbj();
        dbj.O00000Oo = parcelFileDescriptor;
        synchronized (O00000o0) {
            dbj.f14448O000000o = nativeOpenDocument(O000000o(parcelFileDescriptor), str);
        }
        return dbj;
    }

    public final int O000000o(dbj dbj) {
        int nativeGetPageCount;
        synchronized (O00000o0) {
            nativeGetPageCount = nativeGetPageCount(dbj.f14448O000000o);
        }
        return nativeGetPageCount;
    }

    public final long O000000o(dbj dbj, int i) {
        long nativeLoadPage;
        synchronized (O00000o0) {
            nativeLoadPage = nativeLoadPage(dbj.f14448O000000o, i);
            dbj.O00000o0.put(Integer.valueOf(i), Long.valueOf(nativeLoadPage));
        }
        return nativeLoadPage;
    }

    public final Size O00000Oo(dbj dbj, int i) {
        Size nativeGetPageSizeByIndex;
        synchronized (O00000o0) {
            nativeGetPageSizeByIndex = nativeGetPageSizeByIndex(dbj.f14448O000000o, i, this.O00000oO);
        }
        return nativeGetPageSizeByIndex;
    }

    public final void O000000o(dbj dbj, Bitmap bitmap, int i, int i2, int i3, int i4, int i5, boolean z) {
        synchronized (O00000o0) {
            try {
                try {
                    nativeRenderPageBitmap(dbj.O00000o0.get(Integer.valueOf(i)).longValue(), bitmap, this.O00000oO, i2, i3, i4, i5, z);
                } catch (NullPointerException e) {
                    e = e;
                } catch (Exception e2) {
                    e = e2;
                    Log.e(f5608O000000o, "Exception throw from native");
                    e.printStackTrace();
                }
            } catch (NullPointerException e3) {
                e = e3;
                Log.e(f5608O000000o, "mContext may be null");
                e.printStackTrace();
            } catch (Exception e4) {
                e = e4;
                Log.e(f5608O000000o, "Exception throw from native");
                e.printStackTrace();
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        }
    }

    public final void O00000Oo(dbj dbj) {
        synchronized (O00000o0) {
            for (Integer num : dbj.O00000o0.keySet()) {
                nativeClosePage(dbj.O00000o0.get(num).longValue());
            }
            dbj.O00000o0.clear();
            nativeCloseDocument(dbj.f14448O000000o);
            if (dbj.O00000Oo != null) {
                try {
                    dbj.O00000Oo.close();
                } catch (IOException unused) {
                }
                dbj.O00000Oo = null;
            }
        }
    }

    public final dbj.O00000o0 O00000o0(dbj dbj) {
        dbj.O00000o0 o00000o0;
        synchronized (O00000o0) {
            o00000o0 = new dbj.O00000o0();
            o00000o0.f14451O000000o = nativeGetDocumentMetaText(dbj.f14448O000000o, "Title");
            o00000o0.O00000Oo = nativeGetDocumentMetaText(dbj.f14448O000000o, "Author");
            o00000o0.O00000o0 = nativeGetDocumentMetaText(dbj.f14448O000000o, "Subject");
            o00000o0.O00000o = nativeGetDocumentMetaText(dbj.f14448O000000o, "Keywords");
            o00000o0.O00000oO = nativeGetDocumentMetaText(dbj.f14448O000000o, "Creator");
            o00000o0.O00000oo = nativeGetDocumentMetaText(dbj.f14448O000000o, "Producer");
            o00000o0.O0000O0o = nativeGetDocumentMetaText(dbj.f14448O000000o, "CreationDate");
            o00000o0.O0000OOo = nativeGetDocumentMetaText(dbj.f14448O000000o, "ModDate");
        }
        return o00000o0;
    }

    public final List<dbj.O000000o> O00000o(dbj dbj) {
        ArrayList arrayList;
        synchronized (O00000o0) {
            arrayList = new ArrayList();
            Long nativeGetFirstChildBookmark = nativeGetFirstChildBookmark(dbj.f14448O000000o, null);
            if (nativeGetFirstChildBookmark != null) {
                O000000o(arrayList, dbj, nativeGetFirstChildBookmark.longValue());
            }
        }
        return arrayList;
    }

    private void O000000o(List<dbj.O000000o> list, dbj dbj, long j) {
        while (true) {
            dbj.O000000o o000000o = new dbj.O000000o();
            o000000o.O00000o = j;
            o000000o.O00000Oo = nativeGetBookmarkTitle(j);
            o000000o.O00000o0 = nativeGetBookmarkDestIndex(dbj.f14448O000000o, j);
            list.add(o000000o);
            Long nativeGetFirstChildBookmark = nativeGetFirstChildBookmark(dbj.f14448O000000o, Long.valueOf(j));
            if (nativeGetFirstChildBookmark != null) {
                O000000o(o000000o.f14449O000000o, dbj, nativeGetFirstChildBookmark.longValue());
            }
            Long nativeGetSiblingBookmark = nativeGetSiblingBookmark(dbj.f14448O000000o, j);
            if (nativeGetSiblingBookmark != null) {
                j = nativeGetSiblingBookmark.longValue();
            } else {
                return;
            }
        }
    }

    public final List<dbj.O00000Oo> O00000o0(dbj dbj, int i) {
        synchronized (O00000o0) {
            ArrayList arrayList = new ArrayList();
            Long l = dbj.O00000o0.get(Integer.valueOf(i));
            if (l == null) {
                return arrayList;
            }
            for (long j : nativeGetPageLinks(l.longValue())) {
                Integer nativeGetDestPageIndex = nativeGetDestPageIndex(dbj.f14448O000000o, j);
                String nativeGetLinkURI = nativeGetLinkURI(dbj.f14448O000000o, j);
                RectF nativeGetLinkRect = nativeGetLinkRect(j);
                if (!(nativeGetLinkRect == null || (nativeGetDestPageIndex == null && nativeGetLinkURI == null))) {
                    arrayList.add(new dbj.O00000Oo(nativeGetLinkRect, nativeGetDestPageIndex, nativeGetLinkURI));
                }
            }
            return arrayList;
        }
    }

    public final Point O000000o(dbj dbj, int i, int i2, int i3, int i4, int i5, int i6, double d, double d2) {
        return nativePageCoordsToDevice(dbj.O00000o0.get(Integer.valueOf(i)).longValue(), i2, i3, i4, i5, 0, d, d2);
    }
}
