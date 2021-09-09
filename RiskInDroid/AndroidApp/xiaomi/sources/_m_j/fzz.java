package _m_j;

import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.pdf.PdfDocument;
import android.text.TextUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public final class fzz {

    /* renamed from: O000000o  reason: collision with root package name */
    public int[] f17453O000000o;
    public int O00000Oo;
    public float O00000o;
    public Typeface O00000o0;
    public PdfDocument.Page O00000oO;
    private String O00000oo;
    private int[] O0000O0o;
    private PdfDocument O0000OOo;
    private PdfDocument.PageInfo O0000Oo0;

    public fzz(O000000o o000000o) {
        this.O00000oo = o000000o.f17454O000000o;
        this.f17453O000000o = o000000o.O00000Oo;
        this.O0000O0o = o000000o.O00000o0;
        this.O00000Oo = o000000o.O00000oO;
        this.O00000o0 = o000000o.O00000oo;
        this.O00000o = o000000o.O00000o;
    }

    public final fzz O000000o() {
        Rect rect;
        this.O0000OOo = new PdfDocument();
        int[] iArr = this.O0000O0o;
        if (iArr == null || iArr.length < 4) {
            rect = null;
        } else {
            int i = iArr[0];
            int i2 = iArr[2];
            int[] iArr2 = this.f17453O000000o;
            rect = new Rect(i, i2, iArr2[0] - iArr[1], iArr2[1] - iArr[3]);
        }
        int[] iArr3 = this.f17453O000000o;
        PdfDocument.PageInfo.Builder builder = new PdfDocument.PageInfo.Builder(iArr3[0], iArr3[1], 1);
        if (rect != null) {
            builder.setContentRect(rect);
        }
        this.O0000Oo0 = builder.create();
        this.O00000oO = this.O0000OOo.startPage(this.O0000Oo0);
        return this;
    }

    public final fzz O00000Oo() {
        PdfDocument pdfDocument = this.O0000OOo;
        if (pdfDocument != null) {
            pdfDocument.finishPage(this.O00000oO);
        }
        return this;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:28:0x004c=Splitter:B:28:0x004c, B:21:0x003e=Splitter:B:21:0x003e} */
    public final boolean O00000o0() {
        FileOutputStream fileOutputStream;
        if (TextUtils.isEmpty(this.O00000oo) || this.O0000OOo == null) {
            return false;
        }
        try {
            fileOutputStream = new FileOutputStream(new File(this.O00000oo));
            try {
                this.O0000OOo.writeTo(fileOutputStream);
                try {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                this.O0000OOo.close();
                this.O0000OOo = null;
                return true;
            } catch (FileNotFoundException e2) {
                e = e2;
                e.printStackTrace();
                try {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (IOException e3) {
                    e = e3;
                }
                this.O0000OOo.close();
                this.O0000OOo = null;
                return false;
            } catch (IOException e4) {
                e = e4;
                try {
                    e.printStackTrace();
                    try {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (IOException e5) {
                        e = e5;
                    }
                    this.O0000OOo.close();
                    this.O0000OOo = null;
                    return false;
                } catch (Throwable th) {
                    th = th;
                    try {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                    this.O0000OOo.close();
                    this.O0000OOo = null;
                    throw th;
                }
            }
        } catch (FileNotFoundException e7) {
            e = e7;
            fileOutputStream = null;
            e.printStackTrace();
            fileOutputStream.flush();
            fileOutputStream.close();
            this.O0000OOo.close();
            this.O0000OOo = null;
            return false;
        } catch (IOException e8) {
            e = e8;
            fileOutputStream = null;
            e.printStackTrace();
            fileOutputStream.flush();
            fileOutputStream.close();
            this.O0000OOo.close();
            this.O0000OOo = null;
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            fileOutputStream.flush();
            fileOutputStream.close();
            this.O0000OOo.close();
            this.O0000OOo = null;
            throw th;
        }
        e.printStackTrace();
        this.O0000OOo.close();
        this.O0000OOo = null;
        return false;
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f17454O000000o;
        public int[] O00000Oo;
        public float O00000o;
        public int[] O00000o0;
        public int O00000oO;
        public Typeface O00000oo;

        public O000000o(String str, int[] iArr) {
            this.f17454O000000o = str;
            this.O00000Oo = iArr;
        }

        public final fzz O000000o() {
            return new fzz(this);
        }
    }
}
