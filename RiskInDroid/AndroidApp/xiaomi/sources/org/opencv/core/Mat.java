package org.opencv.core;

import java.nio.ByteBuffer;

public class Mat {
    public final long nativeObj;

    private static native void locateROI_0(long j, double[] dArr, double[] dArr2);

    private static native String nDump(long j);

    private static native double[] nGet(long j, int i, int i2);

    private static native int nGetB(long j, int i, int i2, int i3, byte[] bArr);

    private static native int nGetD(long j, int i, int i2, int i3, double[] dArr);

    private static native int nGetF(long j, int i, int i2, int i3, float[] fArr);

    private static native int nGetI(long j, int i, int i2, int i3, int[] iArr);

    private static native int nGetS(long j, int i, int i2, int i3, short[] sArr);

    private static native int nPutB(long j, int i, int i2, int i3, byte[] bArr);

    private static native int nPutBwOffset(long j, int i, int i2, int i3, int i4, byte[] bArr);

    private static native int nPutD(long j, int i, int i2, int i3, double[] dArr);

    private static native int nPutF(long j, int i, int i2, int i3, float[] fArr);

    private static native int nPutI(long j, int i, int i2, int i3, int[] iArr);

    private static native int nPutS(long j, int i, int i2, int i3, short[] sArr);

    private static native long n_Mat();

    private static native long n_Mat(double d, double d2, int i);

    private static native long n_Mat(double d, double d2, int i, double d3, double d4, double d5, double d6);

    private static native long n_Mat(int i, int i2, int i3);

    private static native long n_Mat(int i, int i2, int i3, double d, double d2, double d3, double d4);

    private static native long n_Mat(int i, int i2, int i3, ByteBuffer byteBuffer);

    private static native long n_Mat(long j, int i, int i2);

    private static native long n_Mat(long j, int i, int i2, int i3, int i4);

    private static native long n_adjustROI(long j, int i, int i2, int i3, int i4);

    private static native void n_assignTo(long j, long j2);

    private static native void n_assignTo(long j, long j2, int i);

    private static native int n_channels(long j);

    private static native int n_checkVector(long j, int i);

    private static native int n_checkVector(long j, int i, int i2);

    private static native int n_checkVector(long j, int i, int i2, boolean z);

    private static native long n_clone(long j);

    private static native long n_col(long j, int i);

    private static native long n_colRange(long j, int i, int i2);

    private static native int n_cols(long j);

    private static native void n_convertTo(long j, long j2, int i);

    private static native void n_convertTo(long j, long j2, int i, double d);

    private static native void n_convertTo(long j, long j2, int i, double d, double d2);

    private static native void n_copyTo(long j, long j2);

    private static native void n_copyTo(long j, long j2, long j3);

    private static native void n_create(long j, double d, double d2, int i);

    private static native void n_create(long j, int i, int i2, int i3);

    private static native long n_cross(long j, long j2);

    private static native long n_dataAddr(long j);

    private static native void n_delete(long j);

    private static native int n_depth(long j);

    private static native long n_diag(long j);

    private static native long n_diag(long j, int i);

    private static native int n_dims(long j);

    private static native double n_dot(long j, long j2);

    private static native long n_elemSize(long j);

    private static native long n_elemSize1(long j);

    private static native boolean n_empty(long j);

    private static native long n_eye(double d, double d2, int i);

    private static native long n_eye(int i, int i2, int i3);

    private static native long n_inv(long j);

    private static native long n_inv(long j, int i);

    private static native boolean n_isContinuous(long j);

    private static native boolean n_isSubmatrix(long j);

    private static native long n_mul(long j, long j2);

    private static native long n_mul(long j, long j2, double d);

    private static native long n_ones(double d, double d2, int i);

    private static native long n_ones(int i, int i2, int i3);

    private static native void n_push_back(long j, long j2);

    private static native void n_release(long j);

    private static native long n_reshape(long j, int i);

    private static native long n_reshape(long j, int i, int i2);

    private static native long n_reshape_1(long j, int i, int i2, int[] iArr);

    private static native long n_row(long j, int i);

    private static native long n_rowRange(long j, int i, int i2);

    private static native int n_rows(long j);

    private static native long n_setTo(long j, double d, double d2, double d3, double d4);

    private static native long n_setTo(long j, double d, double d2, double d3, double d4, long j2);

    private static native long n_setTo(long j, long j2);

    private static native long n_setTo(long j, long j2, long j3);

    private static native double[] n_size(long j);

    private static native int n_size_i(long j, int i);

    private static native long n_step1(long j);

    private static native long n_step1(long j, int i);

    private static native long n_submat(long j, int i, int i2, int i3, int i4);

    private static native long n_submat_rr(long j, int i, int i2, int i3, int i4);

    private static native long n_t(long j);

    private static native long n_total(long j);

    private static native int n_type(long j);

    private static native long n_zeros(double d, double d2, int i);

    private static native long n_zeros(int i, int i2, int i3);

    public Mat(long j) {
        if (j != 0) {
            this.nativeObj = j;
            return;
        }
        throw new UnsupportedOperationException("Native object address is NULL");
    }

    public Mat() {
        this.nativeObj = n_Mat();
    }

    public Mat(int i, int i2, int i3) {
        this.nativeObj = n_Mat(i, i2, i3);
    }

    public Mat(int i, int i2, int i3, ByteBuffer byteBuffer) {
        this.nativeObj = n_Mat(i, i2, i3, byteBuffer);
    }

    public Mat(Size size, int i) {
        this.nativeObj = n_Mat(size.width, size.height, i);
    }

    public Mat(int i, int i2, int i3, Scalar scalar) {
        Scalar scalar2 = scalar;
        this.nativeObj = n_Mat(i, i2, i3, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3]);
    }

    public Mat(Size size, int i, Scalar scalar) {
        Size size2 = size;
        Scalar scalar2 = scalar;
        this.nativeObj = n_Mat(size2.width, size2.height, i, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3]);
    }

    public Mat(Mat mat, Range range, Range range2) {
        this.nativeObj = n_Mat(mat.nativeObj, range.start, range.end, range2.start, range2.end);
    }

    public Mat(Mat mat, Range range) {
        this.nativeObj = n_Mat(mat.nativeObj, range.start, range.end);
    }

    public Mat(Mat mat, Rect rect) {
        this.nativeObj = n_Mat(mat.nativeObj, rect.y, rect.height + rect.y, rect.x, rect.x + rect.width);
    }

    public Mat adjustROI(int i, int i2, int i3, int i4) {
        return new Mat(n_adjustROI(this.nativeObj, i, i2, i3, i4));
    }

    public void assignTo(Mat mat, int i) {
        n_assignTo(this.nativeObj, mat.nativeObj, i);
    }

    public void assignTo(Mat mat) {
        n_assignTo(this.nativeObj, mat.nativeObj);
    }

    public int channels() {
        return n_channels(this.nativeObj);
    }

    public int checkVector(int i, int i2, boolean z) {
        return n_checkVector(this.nativeObj, i, i2, z);
    }

    public int checkVector(int i, int i2) {
        return n_checkVector(this.nativeObj, i, i2);
    }

    public int checkVector(int i) {
        return n_checkVector(this.nativeObj, i);
    }

    public Mat clone() {
        return new Mat(n_clone(this.nativeObj));
    }

    public Mat col(int i) {
        return new Mat(n_col(this.nativeObj, i));
    }

    public Mat colRange(int i, int i2) {
        return new Mat(n_colRange(this.nativeObj, i, i2));
    }

    public Mat colRange(Range range) {
        return new Mat(n_colRange(this.nativeObj, range.start, range.end));
    }

    public int dims() {
        return n_dims(this.nativeObj);
    }

    public int cols() {
        return n_cols(this.nativeObj);
    }

    public void convertTo(Mat mat, int i, double d, double d2) {
        n_convertTo(this.nativeObj, mat.nativeObj, i, d, d2);
    }

    public void convertTo(Mat mat, int i, double d) {
        n_convertTo(this.nativeObj, mat.nativeObj, i, d);
    }

    public void convertTo(Mat mat, int i) {
        n_convertTo(this.nativeObj, mat.nativeObj, i);
    }

    public void copyTo(Mat mat) {
        n_copyTo(this.nativeObj, mat.nativeObj);
    }

    public void copyTo(Mat mat, Mat mat2) {
        n_copyTo(this.nativeObj, mat.nativeObj, mat2.nativeObj);
    }

    public void create(int i, int i2, int i3) {
        n_create(this.nativeObj, i, i2, i3);
    }

    public void create(Size size, int i) {
        n_create(this.nativeObj, size.width, size.height, i);
    }

    public Mat cross(Mat mat) {
        return new Mat(n_cross(this.nativeObj, mat.nativeObj));
    }

    public long dataAddr() {
        return n_dataAddr(this.nativeObj);
    }

    public int depth() {
        return n_depth(this.nativeObj);
    }

    public Mat diag(int i) {
        return new Mat(n_diag(this.nativeObj, i));
    }

    public Mat diag() {
        return new Mat(n_diag(this.nativeObj, 0));
    }

    public static Mat diag(Mat mat) {
        return new Mat(n_diag(mat.nativeObj));
    }

    public double dot(Mat mat) {
        return n_dot(this.nativeObj, mat.nativeObj);
    }

    public long elemSize() {
        return n_elemSize(this.nativeObj);
    }

    public long elemSize1() {
        return n_elemSize1(this.nativeObj);
    }

    public boolean empty() {
        return n_empty(this.nativeObj);
    }

    public static Mat eye(int i, int i2, int i3) {
        return new Mat(n_eye(i, i2, i3));
    }

    public static Mat eye(Size size, int i) {
        return new Mat(n_eye(size.width, size.height, i));
    }

    public Mat inv(int i) {
        return new Mat(n_inv(this.nativeObj, i));
    }

    public Mat inv() {
        return new Mat(n_inv(this.nativeObj));
    }

    public boolean isContinuous() {
        return n_isContinuous(this.nativeObj);
    }

    public boolean isSubmatrix() {
        return n_isSubmatrix(this.nativeObj);
    }

    public void locateROI(Size size, Point point) {
        double[] dArr = new double[2];
        double[] dArr2 = new double[2];
        locateROI_0(this.nativeObj, dArr, dArr2);
        if (size != null) {
            size.width = dArr[0];
            size.height = dArr[1];
        }
        if (point != null) {
            point.x = dArr2[0];
            point.y = dArr2[1];
        }
    }

    public Mat mul(Mat mat, double d) {
        return new Mat(n_mul(this.nativeObj, mat.nativeObj, d));
    }

    public Mat mul(Mat mat) {
        return new Mat(n_mul(this.nativeObj, mat.nativeObj));
    }

    public static Mat ones(int i, int i2, int i3) {
        return new Mat(n_ones(i, i2, i3));
    }

    public static Mat ones(Size size, int i) {
        return new Mat(n_ones(size.width, size.height, i));
    }

    public void push_back(Mat mat) {
        n_push_back(this.nativeObj, mat.nativeObj);
    }

    public void release() {
        n_release(this.nativeObj);
    }

    public Mat reshape(int i, int i2) {
        return new Mat(n_reshape(this.nativeObj, i, i2));
    }

    public Mat reshape(int i) {
        return new Mat(n_reshape(this.nativeObj, i));
    }

    public Mat reshape(int i, int[] iArr) {
        return new Mat(n_reshape_1(this.nativeObj, i, iArr.length, iArr));
    }

    public Mat row(int i) {
        return new Mat(n_row(this.nativeObj, i));
    }

    public Mat rowRange(int i, int i2) {
        return new Mat(n_rowRange(this.nativeObj, i, i2));
    }

    public Mat rowRange(Range range) {
        return new Mat(n_rowRange(this.nativeObj, range.start, range.end));
    }

    public int rows() {
        return n_rows(this.nativeObj);
    }

    public Mat setTo(Scalar scalar) {
        return new Mat(n_setTo(this.nativeObj, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3]));
    }

    public Mat setTo(Scalar scalar, Mat mat) {
        return new Mat(n_setTo(this.nativeObj, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], mat.nativeObj));
    }

    public Mat setTo(Mat mat, Mat mat2) {
        return new Mat(n_setTo(this.nativeObj, mat.nativeObj, mat2.nativeObj));
    }

    public Mat setTo(Mat mat) {
        return new Mat(n_setTo(this.nativeObj, mat.nativeObj));
    }

    public Size size() {
        return new Size(n_size(this.nativeObj));
    }

    public int size(int i) {
        return n_size_i(this.nativeObj, i);
    }

    public long step1(int i) {
        return n_step1(this.nativeObj, i);
    }

    public long step1() {
        return n_step1(this.nativeObj);
    }

    public Mat submat(int i, int i2, int i3, int i4) {
        return new Mat(n_submat_rr(this.nativeObj, i, i2, i3, i4));
    }

    public Mat submat(Range range, Range range2) {
        return new Mat(n_submat_rr(this.nativeObj, range.start, range.end, range2.start, range2.end));
    }

    public Mat submat(Rect rect) {
        return new Mat(n_submat(this.nativeObj, rect.x, rect.y, rect.width, rect.height));
    }

    public Mat t() {
        return new Mat(n_t(this.nativeObj));
    }

    public long total() {
        return n_total(this.nativeObj);
    }

    public int type() {
        return n_type(this.nativeObj);
    }

    public static Mat zeros(int i, int i2, int i3) {
        return new Mat(n_zeros(i, i2, i3));
    }

    public static Mat zeros(Size size, int i) {
        return new Mat(n_zeros(size.width, size.height, i));
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        n_delete(this.nativeObj);
        super.finalize();
    }

    public String toString() {
        return "Mat [ " + rows() + "*" + cols() + "*" + CvType.typeToString(type()) + ", isCont=" + isContinuous() + ", isSubmat=" + isSubmatrix() + ", nativeObj=0x" + Long.toHexString(this.nativeObj) + ", dataAddr=0x" + Long.toHexString(dataAddr()) + " ]";
    }

    public String dump() {
        return nDump(this.nativeObj);
    }

    public int put(int i, int i2, double... dArr) {
        int type = type();
        if (dArr == null || dArr.length % CvType.channels(type) != 0) {
            StringBuilder sb = new StringBuilder("Provided data element number (");
            sb.append(dArr == null ? 0 : dArr.length);
            sb.append(") should be multiple of the Mat channels count (");
            sb.append(CvType.channels(type));
            sb.append(")");
            throw new UnsupportedOperationException(sb.toString());
        }
        return nPutD(this.nativeObj, i, i2, dArr.length, dArr);
    }

    public int put(int i, int i2, float[] fArr) {
        int type = type();
        if (fArr == null || fArr.length % CvType.channels(type) != 0) {
            StringBuilder sb = new StringBuilder("Provided data element number (");
            sb.append(fArr == null ? 0 : fArr.length);
            sb.append(") should be multiple of the Mat channels count (");
            sb.append(CvType.channels(type));
            sb.append(")");
            throw new UnsupportedOperationException(sb.toString());
        } else if (CvType.depth(type) == 5) {
            return nPutF(this.nativeObj, i, i2, fArr.length, fArr);
        } else {
            throw new UnsupportedOperationException("Mat data type is not compatible: ".concat(String.valueOf(type)));
        }
    }

    public int put(int i, int i2, int[] iArr) {
        int type = type();
        if (iArr == null || iArr.length % CvType.channels(type) != 0) {
            StringBuilder sb = new StringBuilder("Provided data element number (");
            sb.append(iArr == null ? 0 : iArr.length);
            sb.append(") should be multiple of the Mat channels count (");
            sb.append(CvType.channels(type));
            sb.append(")");
            throw new UnsupportedOperationException(sb.toString());
        } else if (CvType.depth(type) == 4) {
            return nPutI(this.nativeObj, i, i2, iArr.length, iArr);
        } else {
            throw new UnsupportedOperationException("Mat data type is not compatible: ".concat(String.valueOf(type)));
        }
    }

    public int put(int i, int i2, short[] sArr) {
        int type = type();
        if (sArr == null || sArr.length % CvType.channels(type) != 0) {
            StringBuilder sb = new StringBuilder("Provided data element number (");
            sb.append(sArr == null ? 0 : sArr.length);
            sb.append(") should be multiple of the Mat channels count (");
            sb.append(CvType.channels(type));
            sb.append(")");
            throw new UnsupportedOperationException(sb.toString());
        } else if (CvType.depth(type) == 2 || CvType.depth(type) == 3) {
            return nPutS(this.nativeObj, i, i2, sArr.length, sArr);
        } else {
            throw new UnsupportedOperationException("Mat data type is not compatible: ".concat(String.valueOf(type)));
        }
    }

    public int put(int i, int i2, byte[] bArr) {
        int type = type();
        if (bArr == null || bArr.length % CvType.channels(type) != 0) {
            StringBuilder sb = new StringBuilder("Provided data element number (");
            sb.append(bArr == null ? 0 : bArr.length);
            sb.append(") should be multiple of the Mat channels count (");
            sb.append(CvType.channels(type));
            sb.append(")");
            throw new UnsupportedOperationException(sb.toString());
        } else if (CvType.depth(type) == 0 || CvType.depth(type) == 1) {
            return nPutB(this.nativeObj, i, i2, bArr.length, bArr);
        } else {
            throw new UnsupportedOperationException("Mat data type is not compatible: ".concat(String.valueOf(type)));
        }
    }

    public int put(int i, int i2, byte[] bArr, int i3, int i4) {
        int type = type();
        if (bArr == null || i4 % CvType.channels(type) != 0) {
            StringBuilder sb = new StringBuilder("Provided data element number (");
            sb.append(bArr == null ? 0 : bArr.length);
            sb.append(") should be multiple of the Mat channels count (");
            sb.append(CvType.channels(type));
            sb.append(")");
            throw new UnsupportedOperationException(sb.toString());
        } else if (CvType.depth(type) == 0 || CvType.depth(type) == 1) {
            return nPutBwOffset(this.nativeObj, i, i2, i4, i3, bArr);
        } else {
            throw new UnsupportedOperationException("Mat data type is not compatible: ".concat(String.valueOf(type)));
        }
    }

    public int get(int i, int i2, byte[] bArr) {
        int type = type();
        if (bArr == null || bArr.length % CvType.channels(type) != 0) {
            StringBuilder sb = new StringBuilder("Provided data element number (");
            sb.append(bArr == null ? 0 : bArr.length);
            sb.append(") should be multiple of the Mat channels count (");
            sb.append(CvType.channels(type));
            sb.append(")");
            throw new UnsupportedOperationException(sb.toString());
        } else if (CvType.depth(type) == 0 || CvType.depth(type) == 1) {
            return nGetB(this.nativeObj, i, i2, bArr.length, bArr);
        } else {
            throw new UnsupportedOperationException("Mat data type is not compatible: ".concat(String.valueOf(type)));
        }
    }

    public int get(int i, int i2, short[] sArr) {
        int type = type();
        if (sArr == null || sArr.length % CvType.channels(type) != 0) {
            StringBuilder sb = new StringBuilder("Provided data element number (");
            sb.append(sArr == null ? 0 : sArr.length);
            sb.append(") should be multiple of the Mat channels count (");
            sb.append(CvType.channels(type));
            sb.append(")");
            throw new UnsupportedOperationException(sb.toString());
        } else if (CvType.depth(type) == 2 || CvType.depth(type) == 3) {
            return nGetS(this.nativeObj, i, i2, sArr.length, sArr);
        } else {
            throw new UnsupportedOperationException("Mat data type is not compatible: ".concat(String.valueOf(type)));
        }
    }

    public int get(int i, int i2, int[] iArr) {
        int type = type();
        if (iArr == null || iArr.length % CvType.channels(type) != 0) {
            StringBuilder sb = new StringBuilder("Provided data element number (");
            sb.append(iArr == null ? 0 : iArr.length);
            sb.append(") should be multiple of the Mat channels count (");
            sb.append(CvType.channels(type));
            sb.append(")");
            throw new UnsupportedOperationException(sb.toString());
        } else if (CvType.depth(type) == 4) {
            return nGetI(this.nativeObj, i, i2, iArr.length, iArr);
        } else {
            throw new UnsupportedOperationException("Mat data type is not compatible: ".concat(String.valueOf(type)));
        }
    }

    public int get(int i, int i2, float[] fArr) {
        int type = type();
        if (fArr == null || fArr.length % CvType.channels(type) != 0) {
            StringBuilder sb = new StringBuilder("Provided data element number (");
            sb.append(fArr == null ? 0 : fArr.length);
            sb.append(") should be multiple of the Mat channels count (");
            sb.append(CvType.channels(type));
            sb.append(")");
            throw new UnsupportedOperationException(sb.toString());
        } else if (CvType.depth(type) == 5) {
            return nGetF(this.nativeObj, i, i2, fArr.length, fArr);
        } else {
            throw new UnsupportedOperationException("Mat data type is not compatible: ".concat(String.valueOf(type)));
        }
    }

    public int get(int i, int i2, double[] dArr) {
        int type = type();
        if (dArr == null || dArr.length % CvType.channels(type) != 0) {
            StringBuilder sb = new StringBuilder("Provided data element number (");
            sb.append(dArr == null ? 0 : dArr.length);
            sb.append(") should be multiple of the Mat channels count (");
            sb.append(CvType.channels(type));
            sb.append(")");
            throw new UnsupportedOperationException(sb.toString());
        } else if (CvType.depth(type) == 6) {
            return nGetD(this.nativeObj, i, i2, dArr.length, dArr);
        } else {
            throw new UnsupportedOperationException("Mat data type is not compatible: ".concat(String.valueOf(type)));
        }
    }

    public double[] get(int i, int i2) {
        return nGet(this.nativeObj, i, i2);
    }

    public int height() {
        return rows();
    }

    public int width() {
        return cols();
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }
}
