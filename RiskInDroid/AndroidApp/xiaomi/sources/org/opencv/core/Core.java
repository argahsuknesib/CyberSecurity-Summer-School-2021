package org.opencv.core;

import _m_j.jlo;
import java.util.List;

public class Core {
    public static final String NATIVE_LIBRARY_NAME = getNativeLibraryName();
    public static final String VERSION = getVersion();
    public static final int VERSION_MAJOR = getVersionMajorJ();
    public static final int VERSION_MINOR = getVersionMinorJ();
    public static final int VERSION_REVISION = getVersionRevisionJ();
    public static final String VERSION_STATUS = getVersionStatusJ();

    public static class MinMaxLocResult {
        public Point maxLoc = new Point();
        public double maxVal = 0.0d;
        public Point minLoc = new Point();
        public double minVal = 0.0d;
    }

    private static native void LUT_0(long j, long j2, long j3);

    private static native double Mahalanobis_0(long j, long j2, long j3);

    private static native void PCABackProject_0(long j, long j2, long j3, long j4);

    private static native void PCACompute2_0(long j, long j2, long j3, long j4, double d);

    private static native void PCACompute2_1(long j, long j2, long j3, long j4, int i);

    private static native void PCACompute2_2(long j, long j2, long j3, long j4);

    private static native void PCACompute_0(long j, long j2, long j3, double d);

    private static native void PCACompute_1(long j, long j2, long j3, int i);

    private static native void PCACompute_2(long j, long j2, long j3);

    private static native void PCAProject_0(long j, long j2, long j3, long j4);

    private static native double PSNR_0(long j, long j2);

    private static native void SVBackSubst_0(long j, long j2, long j3, long j4, long j5);

    private static native void SVDecomp_0(long j, long j2, long j3, long j4, int i);

    private static native void SVDecomp_1(long j, long j2, long j3, long j4);

    private static native void absdiff_0(long j, long j2, long j3);

    private static native void absdiff_1(long j, double d, double d2, double d3, double d4, long j2);

    private static native void addSamplesDataSearchPath_0(String str);

    private static native void addSamplesDataSearchSubDirectory_0(String str);

    private static native void addWeighted_0(long j, double d, long j2, double d2, double d3, long j3, int i);

    private static native void addWeighted_1(long j, double d, long j2, double d2, double d3, long j3);

    private static native void add_0(long j, long j2, long j3, long j4, int i);

    private static native void add_1(long j, long j2, long j3, long j4);

    private static native void add_2(long j, long j2, long j3);

    private static native void add_3(long j, double d, double d2, double d3, double d4, long j2, long j3, int i);

    private static native void add_4(long j, double d, double d2, double d3, double d4, long j2, long j3);

    private static native void add_5(long j, double d, double d2, double d3, double d4, long j2);

    private static native void batchDistance_0(long j, long j2, long j3, int i, long j4, int i2, int i3, long j5, int i4, boolean z);

    private static native void batchDistance_1(long j, long j2, long j3, int i, long j4, int i2, int i3, long j5, int i4);

    private static native void batchDistance_2(long j, long j2, long j3, int i, long j4, int i2, int i3, long j5);

    private static native void batchDistance_3(long j, long j2, long j3, int i, long j4, int i2, int i3);

    private static native void batchDistance_4(long j, long j2, long j3, int i, long j4, int i2);

    private static native void batchDistance_5(long j, long j2, long j3, int i, long j4);

    private static native void bitwise_and_0(long j, long j2, long j3, long j4);

    private static native void bitwise_and_1(long j, long j2, long j3);

    private static native void bitwise_not_0(long j, long j2, long j3);

    private static native void bitwise_not_1(long j, long j2);

    private static native void bitwise_or_0(long j, long j2, long j3, long j4);

    private static native void bitwise_or_1(long j, long j2, long j3);

    private static native void bitwise_xor_0(long j, long j2, long j3, long j4);

    private static native void bitwise_xor_1(long j, long j2, long j3);

    private static native int borderInterpolate_0(int i, int i2, int i3);

    private static native void calcCovarMatrix_0(long j, long j2, long j3, int i, int i2);

    private static native void calcCovarMatrix_1(long j, long j2, long j3, int i);

    private static native void cartToPolar_0(long j, long j2, long j3, long j4, boolean z);

    private static native void cartToPolar_1(long j, long j2, long j3, long j4);

    private static native boolean checkRange_0(long j, boolean z, double d, double d2);

    private static native boolean checkRange_1(long j, boolean z, double d);

    private static native boolean checkRange_2(long j, boolean z);

    private static native boolean checkRange_4(long j);

    private static native void compare_0(long j, long j2, long j3, int i);

    private static native void compare_1(long j, double d, double d2, double d3, double d4, long j2, int i);

    private static native void completeSymm_0(long j, boolean z);

    private static native void completeSymm_1(long j);

    private static native void convertFp16_0(long j, long j2);

    private static native void convertScaleAbs_0(long j, long j2, double d, double d2);

    private static native void convertScaleAbs_1(long j, long j2, double d);

    private static native void convertScaleAbs_2(long j, long j2);

    private static native void copyMakeBorder_0(long j, long j2, int i, int i2, int i3, int i4, int i5, double d, double d2, double d3, double d4);

    private static native void copyMakeBorder_1(long j, long j2, int i, int i2, int i3, int i4, int i5);

    private static native int countNonZero_0(long j);

    private static native float cubeRoot_0(float f);

    private static native void dct_0(long j, long j2, int i);

    private static native void dct_1(long j, long j2);

    private static native double determinant_0(long j);

    private static native void dft_0(long j, long j2, int i, int i2);

    private static native void dft_1(long j, long j2, int i);

    private static native void dft_2(long j, long j2);

    private static native void divide_0(long j, long j2, long j3, double d, int i);

    private static native void divide_1(long j, long j2, long j3, double d);

    private static native void divide_2(long j, long j2, long j3);

    private static native void divide_3(long j, double d, double d2, double d3, double d4, long j2, double d5, int i);

    private static native void divide_4(long j, double d, double d2, double d3, double d4, long j2, double d5);

    private static native void divide_5(long j, double d, double d2, double d3, double d4, long j2);

    private static native void divide_6(double d, long j, long j2, int i);

    private static native void divide_7(double d, long j, long j2);

    private static native void eigenNonSymmetric_0(long j, long j2, long j3);

    private static native boolean eigen_0(long j, long j2, long j3);

    private static native boolean eigen_1(long j, long j2);

    private static native void exp_0(long j, long j2);

    private static native void extractChannel_0(long j, long j2, int i);

    private static native float fastAtan2_0(float f, float f2);

    private static native String findFileOrKeep_0(String str, boolean z);

    private static native String findFileOrKeep_1(String str);

    private static native String findFile_0(String str, boolean z, boolean z2);

    private static native String findFile_1(String str, boolean z);

    private static native String findFile_2(String str);

    private static native void findNonZero_0(long j, long j2);

    private static native void flip_0(long j, long j2, int i);

    private static native void gemm_0(long j, long j2, double d, long j3, double d2, long j4, int i);

    private static native void gemm_1(long j, long j2, double d, long j3, double d2, long j4);

    private static native String getBuildInformation_0();

    private static native long getCPUTickCount_0();

    private static native String getHardwareFeatureName_0(int i);

    private static native String getIppVersion_0();

    private static String getNativeLibraryName() {
        return "opencv_java344";
    }

    private static native int getNumThreads_0();

    private static native int getNumberOfCPUs_0();

    private static native int getOptimalDFTSize_0(int i);

    private static native int getThreadNum_0();

    private static native long getTickCount_0();

    private static native double getTickFrequency_0();

    private static String getVersion() {
        return "3.4.4";
    }

    private static int getVersionMajorJ() {
        return 3;
    }

    private static native int getVersionMajor_0();

    private static int getVersionMinorJ() {
        return 4;
    }

    private static native int getVersionMinor_0();

    private static int getVersionRevisionJ() {
        return 4;
    }

    private static native int getVersionRevision_0();

    private static String getVersionStatusJ() {
        return "";
    }

    private static native String getVersionString_0();

    private static native void hconcat_0(long j, long j2);

    private static native void idct_0(long j, long j2, int i);

    private static native void idct_1(long j, long j2);

    private static native void idft_0(long j, long j2, int i, int i2);

    private static native void idft_1(long j, long j2, int i);

    private static native void idft_2(long j, long j2);

    private static native void inRange_0(long j, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, long j2);

    private static native void insertChannel_0(long j, long j2, int i);

    private static native double invert_0(long j, long j2, int i);

    private static native double invert_1(long j, long j2);

    private static native double kmeans_0(long j, int i, long j2, int i2, int i3, double d, int i4, int i5, long j3);

    private static native double kmeans_1(long j, int i, long j2, int i2, int i3, double d, int i4, int i5);

    private static native void log_0(long j, long j2);

    private static native void magnitude_0(long j, long j2, long j3);

    private static native void max_0(long j, long j2, long j3);

    private static native void max_1(long j, double d, double d2, double d3, double d4, long j2);

    private static native void meanStdDev_0(long j, long j2, long j3, long j4);

    private static native void meanStdDev_1(long j, long j2, long j3);

    private static native double[] mean_0(long j, long j2);

    private static native double[] mean_1(long j);

    private static native void merge_0(long j, long j2);

    private static native void min_0(long j, long j2, long j3);

    private static native void min_1(long j, double d, double d2, double d3, double d4, long j2);

    private static native void mixChannels_0(long j, long j2, long j3);

    private static native void mulSpectrums_0(long j, long j2, long j3, int i, boolean z);

    private static native void mulSpectrums_1(long j, long j2, long j3, int i);

    private static native void mulTransposed_0(long j, long j2, boolean z, long j3, double d, int i);

    private static native void mulTransposed_1(long j, long j2, boolean z, long j3, double d);

    private static native void mulTransposed_2(long j, long j2, boolean z, long j3);

    private static native void mulTransposed_3(long j, long j2, boolean z);

    private static native void multiply_0(long j, long j2, long j3, double d, int i);

    private static native void multiply_1(long j, long j2, long j3, double d);

    private static native void multiply_2(long j, long j2, long j3);

    private static native void multiply_3(long j, double d, double d2, double d3, double d4, long j2, double d5, int i);

    private static native void multiply_4(long j, double d, double d2, double d3, double d4, long j2, double d5);

    private static native void multiply_5(long j, double d, double d2, double d3, double d4, long j2);

    private static native double[] n_minMaxLocManual(long j, long j2);

    private static native double norm_0(long j, long j2, int i, long j3);

    private static native double norm_1(long j, long j2, int i);

    private static native double norm_2(long j, long j2);

    private static native double norm_3(long j, int i, long j2);

    private static native double norm_4(long j, int i);

    private static native double norm_5(long j);

    private static native void normalize_0(long j, long j2, double d, double d2, int i, int i2, long j3);

    private static native void normalize_1(long j, long j2, double d, double d2, int i, int i2);

    private static native void normalize_2(long j, long j2, double d, double d2, int i);

    private static native void normalize_3(long j, long j2, double d, double d2);

    private static native void normalize_4(long j, long j2, double d);

    private static native void normalize_5(long j, long j2);

    private static native void patchNaNs_0(long j, double d);

    private static native void patchNaNs_1(long j);

    private static native void perspectiveTransform_0(long j, long j2, long j3);

    private static native void phase_0(long j, long j2, long j3, boolean z);

    private static native void phase_1(long j, long j2, long j3);

    private static native void polarToCart_0(long j, long j2, long j3, long j4, boolean z);

    private static native void polarToCart_1(long j, long j2, long j3, long j4);

    private static native void pow_0(long j, double d, long j2);

    private static native void randShuffle_0(long j, double d);

    private static native void randShuffle_2(long j);

    private static native void randn_0(long j, double d, double d2);

    private static native void randu_0(long j, double d, double d2);

    private static native void reduce_0(long j, long j2, int i, int i2, int i3);

    private static native void reduce_1(long j, long j2, int i, int i2);

    private static native void repeat_0(long j, int i, int i2, long j2);

    private static native void rotate_0(long j, long j2, int i);

    private static native void scaleAdd_0(long j, double d, long j2, long j3);

    private static native void setErrorVerbosity_0(boolean z);

    private static native void setIdentity_0(long j, double d, double d2, double d3, double d4);

    private static native void setIdentity_1(long j);

    private static native void setNumThreads_0(int i);

    private static native void setRNGSeed_0(int i);

    private static native void setUseIPP_0(boolean z);

    private static native void setUseIPP_NE_0(boolean z);

    private static native void setUseIPP_NotExact_0(boolean z);

    private static native int solveCubic_0(long j, long j2);

    private static native double solvePoly_0(long j, long j2, int i);

    private static native double solvePoly_1(long j, long j2);

    private static native boolean solve_0(long j, long j2, long j3, int i);

    private static native boolean solve_1(long j, long j2, long j3);

    private static native void sortIdx_0(long j, long j2, int i);

    private static native void sort_0(long j, long j2, int i);

    private static native void split_0(long j, long j2);

    private static native void sqrt_0(long j, long j2);

    private static native void subtract_0(long j, long j2, long j3, long j4, int i);

    private static native void subtract_1(long j, long j2, long j3, long j4);

    private static native void subtract_2(long j, long j2, long j3);

    private static native void subtract_3(long j, double d, double d2, double d3, double d4, long j2, long j3, int i);

    private static native void subtract_4(long j, double d, double d2, double d3, double d4, long j2, long j3);

    private static native void subtract_5(long j, double d, double d2, double d3, double d4, long j2);

    private static native double[] sumElems_0(long j);

    private static native double[] trace_0(long j);

    private static native void transform_0(long j, long j2, long j3);

    private static native void transpose_0(long j, long j2);

    private static native boolean useIPP_0();

    private static native boolean useIPP_NE_0();

    private static native boolean useIPP_NotExact_0();

    private static native void vconcat_0(long j, long j2);

    public static Scalar mean(Mat mat, Mat mat2) {
        return new Scalar(mean_0(mat.nativeObj, mat2.nativeObj));
    }

    public static Scalar mean(Mat mat) {
        return new Scalar(mean_1(mat.nativeObj));
    }

    public static Scalar sumElems(Mat mat) {
        return new Scalar(sumElems_0(mat.nativeObj));
    }

    public static Scalar trace(Mat mat) {
        return new Scalar(trace_0(mat.nativeObj));
    }

    public static String getBuildInformation() {
        return getBuildInformation_0();
    }

    public static String getHardwareFeatureName(int i) {
        return getHardwareFeatureName_0(i);
    }

    public static String getVersionString() {
        return getVersionString_0();
    }

    public static String getIppVersion() {
        return getIppVersion_0();
    }

    public static String findFile(String str, boolean z, boolean z2) {
        return findFile_0(str, z, z2);
    }

    public static String findFile(String str, boolean z) {
        return findFile_1(str, z);
    }

    public static String findFile(String str) {
        return findFile_2(str);
    }

    public static String findFileOrKeep(String str, boolean z) {
        return findFileOrKeep_0(str, z);
    }

    public static String findFileOrKeep(String str) {
        return findFileOrKeep_1(str);
    }

    public static boolean checkRange(Mat mat, boolean z, double d, double d2) {
        return checkRange_0(mat.nativeObj, z, d, d2);
    }

    public static boolean checkRange(Mat mat, boolean z, double d) {
        return checkRange_1(mat.nativeObj, z, d);
    }

    public static boolean checkRange(Mat mat, boolean z) {
        return checkRange_2(mat.nativeObj, z);
    }

    public static boolean checkRange(Mat mat) {
        return checkRange_4(mat.nativeObj);
    }

    public static boolean eigen(Mat mat, Mat mat2, Mat mat3) {
        return eigen_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static boolean eigen(Mat mat, Mat mat2) {
        return eigen_1(mat.nativeObj, mat2.nativeObj);
    }

    public static boolean solve(Mat mat, Mat mat2, Mat mat3, int i) {
        return solve_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i);
    }

    public static boolean solve(Mat mat, Mat mat2, Mat mat3) {
        return solve_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static boolean useIPP() {
        return useIPP_0();
    }

    public static boolean useIPP_NE() {
        return useIPP_NE_0();
    }

    public static boolean useIPP_NotExact() {
        return useIPP_NotExact_0();
    }

    public static double Mahalanobis(Mat mat, Mat mat2, Mat mat3) {
        return Mahalanobis_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static double PSNR(Mat mat, Mat mat2) {
        return PSNR_0(mat.nativeObj, mat2.nativeObj);
    }

    public static double determinant(Mat mat) {
        return determinant_0(mat.nativeObj);
    }

    public static double getTickFrequency() {
        return getTickFrequency_0();
    }

    public static double invert(Mat mat, Mat mat2, int i) {
        return invert_0(mat.nativeObj, mat2.nativeObj, i);
    }

    public static double invert(Mat mat, Mat mat2) {
        return invert_1(mat.nativeObj, mat2.nativeObj);
    }

    public static double kmeans(Mat mat, int i, Mat mat2, TermCriteria termCriteria, int i2, int i3, Mat mat3) {
        TermCriteria termCriteria2 = termCriteria;
        return kmeans_0(mat.nativeObj, i, mat2.nativeObj, termCriteria2.type, termCriteria2.maxCount, termCriteria2.epsilon, i2, i3, mat3.nativeObj);
    }

    public static double kmeans(Mat mat, int i, Mat mat2, TermCriteria termCriteria, int i2, int i3) {
        TermCriteria termCriteria2 = termCriteria;
        return kmeans_1(mat.nativeObj, i, mat2.nativeObj, termCriteria2.type, termCriteria2.maxCount, termCriteria2.epsilon, i2, i3);
    }

    public static double norm(Mat mat, Mat mat2, int i, Mat mat3) {
        return norm_0(mat.nativeObj, mat2.nativeObj, i, mat3.nativeObj);
    }

    public static double norm(Mat mat, Mat mat2, int i) {
        return norm_1(mat.nativeObj, mat2.nativeObj, i);
    }

    public static double norm(Mat mat, Mat mat2) {
        return norm_2(mat.nativeObj, mat2.nativeObj);
    }

    public static double norm(Mat mat, int i, Mat mat2) {
        return norm_3(mat.nativeObj, i, mat2.nativeObj);
    }

    public static double norm(Mat mat, int i) {
        return norm_4(mat.nativeObj, i);
    }

    public static double norm(Mat mat) {
        return norm_5(mat.nativeObj);
    }

    public static double solvePoly(Mat mat, Mat mat2, int i) {
        return solvePoly_0(mat.nativeObj, mat2.nativeObj, i);
    }

    public static double solvePoly(Mat mat, Mat mat2) {
        return solvePoly_1(mat.nativeObj, mat2.nativeObj);
    }

    public static float cubeRoot(float f) {
        return cubeRoot_0(f);
    }

    public static float fastAtan2(float f, float f2) {
        return fastAtan2_0(f, f2);
    }

    public static int borderInterpolate(int i, int i2, int i3) {
        return borderInterpolate_0(i, i2, i3);
    }

    public static int countNonZero(Mat mat) {
        return countNonZero_0(mat.nativeObj);
    }

    public static int getNumThreads() {
        return getNumThreads_0();
    }

    public static int getNumberOfCPUs() {
        return getNumberOfCPUs_0();
    }

    public static int getOptimalDFTSize(int i) {
        return getOptimalDFTSize_0(i);
    }

    @Deprecated
    public static int getThreadNum() {
        return getThreadNum_0();
    }

    public static int getVersionMajor() {
        return getVersionMajor_0();
    }

    public static int getVersionMinor() {
        return getVersionMinor_0();
    }

    public static int getVersionRevision() {
        return getVersionRevision_0();
    }

    public static int solveCubic(Mat mat, Mat mat2) {
        return solveCubic_0(mat.nativeObj, mat2.nativeObj);
    }

    public static long getCPUTickCount() {
        return getCPUTickCount_0();
    }

    public static long getTickCount() {
        return getTickCount_0();
    }

    public static void LUT(Mat mat, Mat mat2, Mat mat3) {
        LUT_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void PCABackProject(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        PCABackProject_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static void PCACompute2(Mat mat, Mat mat2, Mat mat3, Mat mat4, double d) {
        PCACompute2_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, d);
    }

    public static void PCACompute2(Mat mat, Mat mat2, Mat mat3, Mat mat4, int i) {
        PCACompute2_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, i);
    }

    public static void PCACompute2(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        PCACompute2_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static void PCACompute(Mat mat, Mat mat2, Mat mat3, double d) {
        PCACompute_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, d);
    }

    public static void PCACompute(Mat mat, Mat mat2, Mat mat3, int i) {
        PCACompute_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i);
    }

    public static void PCACompute(Mat mat, Mat mat2, Mat mat3) {
        PCACompute_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void PCAProject(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        PCAProject_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static void SVBackSubst(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5) {
        SVBackSubst_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj);
    }

    public static void SVDecomp(Mat mat, Mat mat2, Mat mat3, Mat mat4, int i) {
        SVDecomp_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, i);
    }

    public static void SVDecomp(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        SVDecomp_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static void absdiff(Mat mat, Mat mat2, Mat mat3) {
        absdiff_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void absdiff(Mat mat, Scalar scalar, Mat mat2) {
        absdiff_1(mat.nativeObj, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], mat2.nativeObj);
    }

    public static void add(Mat mat, Mat mat2, Mat mat3, Mat mat4, int i) {
        add_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, i);
    }

    public static void add(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        add_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static void add(Mat mat, Mat mat2, Mat mat3) {
        add_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void add(Mat mat, Scalar scalar, Mat mat2, Mat mat3, int i) {
        Scalar scalar2 = scalar;
        add_3(mat.nativeObj, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], mat2.nativeObj, mat3.nativeObj, i);
    }

    public static void add(Mat mat, Scalar scalar, Mat mat2, Mat mat3) {
        Scalar scalar2 = scalar;
        add_4(mat.nativeObj, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], mat2.nativeObj, mat3.nativeObj);
    }

    public static void add(Mat mat, Scalar scalar, Mat mat2) {
        add_5(mat.nativeObj, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], mat2.nativeObj);
    }

    public static void addWeighted(Mat mat, double d, Mat mat2, double d2, double d3, Mat mat3, int i) {
        addWeighted_0(mat.nativeObj, d, mat2.nativeObj, d2, d3, mat3.nativeObj, i);
    }

    public static void addWeighted(Mat mat, double d, Mat mat2, double d2, double d3, Mat mat3) {
        addWeighted_1(mat.nativeObj, d, mat2.nativeObj, d2, d3, mat3.nativeObj);
    }

    public static void batchDistance(Mat mat, Mat mat2, Mat mat3, int i, Mat mat4, int i2, int i3, Mat mat5, int i4, boolean z) {
        batchDistance_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i, mat4.nativeObj, i2, i3, mat5.nativeObj, i4, z);
    }

    public static void batchDistance(Mat mat, Mat mat2, Mat mat3, int i, Mat mat4, int i2, int i3, Mat mat5, int i4) {
        batchDistance_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i, mat4.nativeObj, i2, i3, mat5.nativeObj, i4);
    }

    public static void batchDistance(Mat mat, Mat mat2, Mat mat3, int i, Mat mat4, int i2, int i3, Mat mat5) {
        batchDistance_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i, mat4.nativeObj, i2, i3, mat5.nativeObj);
    }

    public static void batchDistance(Mat mat, Mat mat2, Mat mat3, int i, Mat mat4, int i2, int i3) {
        batchDistance_3(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i, mat4.nativeObj, i2, i3);
    }

    public static void batchDistance(Mat mat, Mat mat2, Mat mat3, int i, Mat mat4, int i2) {
        batchDistance_4(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i, mat4.nativeObj, i2);
    }

    public static void batchDistance(Mat mat, Mat mat2, Mat mat3, int i, Mat mat4) {
        batchDistance_5(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i, mat4.nativeObj);
    }

    public static void bitwise_and(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        bitwise_and_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static void bitwise_and(Mat mat, Mat mat2, Mat mat3) {
        bitwise_and_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void bitwise_not(Mat mat, Mat mat2, Mat mat3) {
        bitwise_not_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void bitwise_not(Mat mat, Mat mat2) {
        bitwise_not_1(mat.nativeObj, mat2.nativeObj);
    }

    public static void bitwise_or(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        bitwise_or_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static void bitwise_or(Mat mat, Mat mat2, Mat mat3) {
        bitwise_or_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void bitwise_xor(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        bitwise_xor_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static void bitwise_xor(Mat mat, Mat mat2, Mat mat3) {
        bitwise_xor_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void calcCovarMatrix(Mat mat, Mat mat2, Mat mat3, int i, int i2) {
        calcCovarMatrix_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i, i2);
    }

    public static void calcCovarMatrix(Mat mat, Mat mat2, Mat mat3, int i) {
        calcCovarMatrix_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i);
    }

    public static void cartToPolar(Mat mat, Mat mat2, Mat mat3, Mat mat4, boolean z) {
        cartToPolar_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, z);
    }

    public static void cartToPolar(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        cartToPolar_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static void compare(Mat mat, Mat mat2, Mat mat3, int i) {
        compare_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i);
    }

    public static void compare(Mat mat, Scalar scalar, Mat mat2, int i) {
        Scalar scalar2 = scalar;
        compare_1(mat.nativeObj, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], mat2.nativeObj, i);
    }

    public static void completeSymm(Mat mat, boolean z) {
        completeSymm_0(mat.nativeObj, z);
    }

    public static void completeSymm(Mat mat) {
        completeSymm_1(mat.nativeObj);
    }

    public static void convertFp16(Mat mat, Mat mat2) {
        convertFp16_0(mat.nativeObj, mat2.nativeObj);
    }

    public static void convertScaleAbs(Mat mat, Mat mat2, double d, double d2) {
        convertScaleAbs_0(mat.nativeObj, mat2.nativeObj, d, d2);
    }

    public static void convertScaleAbs(Mat mat, Mat mat2, double d) {
        convertScaleAbs_1(mat.nativeObj, mat2.nativeObj, d);
    }

    public static void convertScaleAbs(Mat mat, Mat mat2) {
        convertScaleAbs_2(mat.nativeObj, mat2.nativeObj);
    }

    public static void copyMakeBorder(Mat mat, Mat mat2, int i, int i2, int i3, int i4, int i5, Scalar scalar) {
        Scalar scalar2 = scalar;
        copyMakeBorder_0(mat.nativeObj, mat2.nativeObj, i, i2, i3, i4, i5, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3]);
    }

    public static void copyMakeBorder(Mat mat, Mat mat2, int i, int i2, int i3, int i4, int i5) {
        copyMakeBorder_1(mat.nativeObj, mat2.nativeObj, i, i2, i3, i4, i5);
    }

    public static void dct(Mat mat, Mat mat2, int i) {
        dct_0(mat.nativeObj, mat2.nativeObj, i);
    }

    public static void dct(Mat mat, Mat mat2) {
        dct_1(mat.nativeObj, mat2.nativeObj);
    }

    public static void dft(Mat mat, Mat mat2, int i, int i2) {
        dft_0(mat.nativeObj, mat2.nativeObj, i, i2);
    }

    public static void dft(Mat mat, Mat mat2, int i) {
        dft_1(mat.nativeObj, mat2.nativeObj, i);
    }

    public static void dft(Mat mat, Mat mat2) {
        dft_2(mat.nativeObj, mat2.nativeObj);
    }

    public static void divide(Mat mat, Mat mat2, Mat mat3, double d, int i) {
        divide_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, d, i);
    }

    public static void divide(Mat mat, Mat mat2, Mat mat3, double d) {
        divide_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, d);
    }

    public static void divide(Mat mat, Mat mat2, Mat mat3) {
        divide_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void divide(Mat mat, Scalar scalar, Mat mat2, double d, int i) {
        Scalar scalar2 = scalar;
        divide_3(mat.nativeObj, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], mat2.nativeObj, d, i);
    }

    public static void divide(Mat mat, Scalar scalar, Mat mat2, double d) {
        Scalar scalar2 = scalar;
        divide_4(mat.nativeObj, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], mat2.nativeObj, d);
    }

    public static void divide(Mat mat, Scalar scalar, Mat mat2) {
        divide_5(mat.nativeObj, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], mat2.nativeObj);
    }

    public static void divide(double d, Mat mat, Mat mat2, int i) {
        divide_6(d, mat.nativeObj, mat2.nativeObj, i);
    }

    public static void divide(double d, Mat mat, Mat mat2) {
        divide_7(d, mat.nativeObj, mat2.nativeObj);
    }

    public static void eigenNonSymmetric(Mat mat, Mat mat2, Mat mat3) {
        eigenNonSymmetric_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void exp(Mat mat, Mat mat2) {
        exp_0(mat.nativeObj, mat2.nativeObj);
    }

    public static void extractChannel(Mat mat, Mat mat2, int i) {
        extractChannel_0(mat.nativeObj, mat2.nativeObj, i);
    }

    public static void findNonZero(Mat mat, Mat mat2) {
        findNonZero_0(mat.nativeObj, mat2.nativeObj);
    }

    public static void flip(Mat mat, Mat mat2, int i) {
        flip_0(mat.nativeObj, mat2.nativeObj, i);
    }

    public static void gemm(Mat mat, Mat mat2, double d, Mat mat3, double d2, Mat mat4, int i) {
        gemm_0(mat.nativeObj, mat2.nativeObj, d, mat3.nativeObj, d2, mat4.nativeObj, i);
    }

    public static void gemm(Mat mat, Mat mat2, double d, Mat mat3, double d2, Mat mat4) {
        gemm_1(mat.nativeObj, mat2.nativeObj, d, mat3.nativeObj, d2, mat4.nativeObj);
    }

    public static void hconcat(List<Mat> list, Mat mat) {
        hconcat_0(jlo.O000000o(list).nativeObj, mat.nativeObj);
    }

    public static void idct(Mat mat, Mat mat2, int i) {
        idct_0(mat.nativeObj, mat2.nativeObj, i);
    }

    public static void idct(Mat mat, Mat mat2) {
        idct_1(mat.nativeObj, mat2.nativeObj);
    }

    public static void idft(Mat mat, Mat mat2, int i, int i2) {
        idft_0(mat.nativeObj, mat2.nativeObj, i, i2);
    }

    public static void idft(Mat mat, Mat mat2, int i) {
        idft_1(mat.nativeObj, mat2.nativeObj, i);
    }

    public static void idft(Mat mat, Mat mat2) {
        idft_2(mat.nativeObj, mat2.nativeObj);
    }

    public static void inRange(Mat mat, Scalar scalar, Scalar scalar2, Mat mat2) {
        Scalar scalar3 = scalar;
        Scalar scalar4 = scalar2;
        inRange_0(mat.nativeObj, scalar3.val[0], scalar3.val[1], scalar3.val[2], scalar3.val[3], scalar4.val[0], scalar4.val[1], scalar4.val[2], scalar4.val[3], mat2.nativeObj);
    }

    public static void insertChannel(Mat mat, Mat mat2, int i) {
        insertChannel_0(mat.nativeObj, mat2.nativeObj, i);
    }

    public static void log(Mat mat, Mat mat2) {
        log_0(mat.nativeObj, mat2.nativeObj);
    }

    public static void magnitude(Mat mat, Mat mat2, Mat mat3) {
        magnitude_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void max(Mat mat, Mat mat2, Mat mat3) {
        max_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void max(Mat mat, Scalar scalar, Mat mat2) {
        max_1(mat.nativeObj, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], mat2.nativeObj);
    }

    public static void meanStdDev(Mat mat, MatOfDouble matOfDouble, MatOfDouble matOfDouble2, Mat mat2) {
        meanStdDev_0(mat.nativeObj, matOfDouble.nativeObj, matOfDouble2.nativeObj, mat2.nativeObj);
    }

    public static void meanStdDev(Mat mat, MatOfDouble matOfDouble, MatOfDouble matOfDouble2) {
        meanStdDev_1(mat.nativeObj, matOfDouble.nativeObj, matOfDouble2.nativeObj);
    }

    public static void merge(List<Mat> list, Mat mat) {
        merge_0(jlo.O000000o(list).nativeObj, mat.nativeObj);
    }

    public static void min(Mat mat, Mat mat2, Mat mat3) {
        min_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void min(Mat mat, Scalar scalar, Mat mat2) {
        min_1(mat.nativeObj, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], mat2.nativeObj);
    }

    public static void mixChannels(List<Mat> list, List<Mat> list2, MatOfInt matOfInt) {
        mixChannels_0(jlo.O000000o(list).nativeObj, jlo.O000000o(list2).nativeObj, matOfInt.nativeObj);
    }

    public static void mulSpectrums(Mat mat, Mat mat2, Mat mat3, int i, boolean z) {
        mulSpectrums_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i, z);
    }

    public static void mulSpectrums(Mat mat, Mat mat2, Mat mat3, int i) {
        mulSpectrums_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i);
    }

    public static void mulTransposed(Mat mat, Mat mat2, boolean z, Mat mat3, double d, int i) {
        mulTransposed_0(mat.nativeObj, mat2.nativeObj, z, mat3.nativeObj, d, i);
    }

    public static void mulTransposed(Mat mat, Mat mat2, boolean z, Mat mat3, double d) {
        mulTransposed_1(mat.nativeObj, mat2.nativeObj, z, mat3.nativeObj, d);
    }

    public static void mulTransposed(Mat mat, Mat mat2, boolean z, Mat mat3) {
        mulTransposed_2(mat.nativeObj, mat2.nativeObj, z, mat3.nativeObj);
    }

    public static void mulTransposed(Mat mat, Mat mat2, boolean z) {
        mulTransposed_3(mat.nativeObj, mat2.nativeObj, z);
    }

    public static void multiply(Mat mat, Mat mat2, Mat mat3, double d, int i) {
        multiply_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, d, i);
    }

    public static void multiply(Mat mat, Mat mat2, Mat mat3, double d) {
        multiply_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, d);
    }

    public static void multiply(Mat mat, Mat mat2, Mat mat3) {
        multiply_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void multiply(Mat mat, Scalar scalar, Mat mat2, double d, int i) {
        Scalar scalar2 = scalar;
        multiply_3(mat.nativeObj, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], mat2.nativeObj, d, i);
    }

    public static void multiply(Mat mat, Scalar scalar, Mat mat2, double d) {
        Scalar scalar2 = scalar;
        multiply_4(mat.nativeObj, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], mat2.nativeObj, d);
    }

    public static void multiply(Mat mat, Scalar scalar, Mat mat2) {
        multiply_5(mat.nativeObj, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], mat2.nativeObj);
    }

    public static void normalize(Mat mat, Mat mat2, double d, double d2, int i, int i2, Mat mat3) {
        normalize_0(mat.nativeObj, mat2.nativeObj, d, d2, i, i2, mat3.nativeObj);
    }

    public static void normalize(Mat mat, Mat mat2, double d, double d2, int i, int i2) {
        normalize_1(mat.nativeObj, mat2.nativeObj, d, d2, i, i2);
    }

    public static void normalize(Mat mat, Mat mat2, double d, double d2, int i) {
        normalize_2(mat.nativeObj, mat2.nativeObj, d, d2, i);
    }

    public static void normalize(Mat mat, Mat mat2, double d, double d2) {
        normalize_3(mat.nativeObj, mat2.nativeObj, d, d2);
    }

    public static void normalize(Mat mat, Mat mat2, double d) {
        normalize_4(mat.nativeObj, mat2.nativeObj, d);
    }

    public static void normalize(Mat mat, Mat mat2) {
        normalize_5(mat.nativeObj, mat2.nativeObj);
    }

    public static void patchNaNs(Mat mat, double d) {
        patchNaNs_0(mat.nativeObj, d);
    }

    public static void patchNaNs(Mat mat) {
        patchNaNs_1(mat.nativeObj);
    }

    public static void perspectiveTransform(Mat mat, Mat mat2, Mat mat3) {
        perspectiveTransform_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void phase(Mat mat, Mat mat2, Mat mat3, boolean z) {
        phase_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, z);
    }

    public static void phase(Mat mat, Mat mat2, Mat mat3) {
        phase_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void polarToCart(Mat mat, Mat mat2, Mat mat3, Mat mat4, boolean z) {
        polarToCart_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, z);
    }

    public static void polarToCart(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        polarToCart_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static void pow(Mat mat, double d, Mat mat2) {
        pow_0(mat.nativeObj, d, mat2.nativeObj);
    }

    public static void randShuffle(Mat mat, double d) {
        randShuffle_0(mat.nativeObj, d);
    }

    public static void randShuffle(Mat mat) {
        randShuffle_2(mat.nativeObj);
    }

    public static void randn(Mat mat, double d, double d2) {
        randn_0(mat.nativeObj, d, d2);
    }

    public static void randu(Mat mat, double d, double d2) {
        randu_0(mat.nativeObj, d, d2);
    }

    public static void reduce(Mat mat, Mat mat2, int i, int i2, int i3) {
        reduce_0(mat.nativeObj, mat2.nativeObj, i, i2, i3);
    }

    public static void reduce(Mat mat, Mat mat2, int i, int i2) {
        reduce_1(mat.nativeObj, mat2.nativeObj, i, i2);
    }

    public static void repeat(Mat mat, int i, int i2, Mat mat2) {
        repeat_0(mat.nativeObj, i, i2, mat2.nativeObj);
    }

    public static void rotate(Mat mat, Mat mat2, int i) {
        rotate_0(mat.nativeObj, mat2.nativeObj, i);
    }

    public static void scaleAdd(Mat mat, double d, Mat mat2, Mat mat3) {
        scaleAdd_0(mat.nativeObj, d, mat2.nativeObj, mat3.nativeObj);
    }

    public static void setErrorVerbosity(boolean z) {
        setErrorVerbosity_0(z);
    }

    public static void setIdentity(Mat mat, Scalar scalar) {
        setIdentity_0(mat.nativeObj, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3]);
    }

    public static void setIdentity(Mat mat) {
        setIdentity_1(mat.nativeObj);
    }

    public static void setNumThreads(int i) {
        setNumThreads_0(i);
    }

    public static void setRNGSeed(int i) {
        setRNGSeed_0(i);
    }

    public static void sort(Mat mat, Mat mat2, int i) {
        sort_0(mat.nativeObj, mat2.nativeObj, i);
    }

    public static void sortIdx(Mat mat, Mat mat2, int i) {
        sortIdx_0(mat.nativeObj, mat2.nativeObj, i);
    }

    public static void split(Mat mat, List<Mat> list) {
        Mat mat2 = new Mat();
        split_0(mat.nativeObj, mat2.nativeObj);
        jlo.O000000o(mat2, list);
        mat2.release();
    }

    public static void sqrt(Mat mat, Mat mat2) {
        sqrt_0(mat.nativeObj, mat2.nativeObj);
    }

    public static void subtract(Mat mat, Mat mat2, Mat mat3, Mat mat4, int i) {
        subtract_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, i);
    }

    public static void subtract(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        subtract_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static void subtract(Mat mat, Mat mat2, Mat mat3) {
        subtract_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void subtract(Mat mat, Scalar scalar, Mat mat2, Mat mat3, int i) {
        Scalar scalar2 = scalar;
        subtract_3(mat.nativeObj, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], mat2.nativeObj, mat3.nativeObj, i);
    }

    public static void subtract(Mat mat, Scalar scalar, Mat mat2, Mat mat3) {
        Scalar scalar2 = scalar;
        subtract_4(mat.nativeObj, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], mat2.nativeObj, mat3.nativeObj);
    }

    public static void subtract(Mat mat, Scalar scalar, Mat mat2) {
        subtract_5(mat.nativeObj, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], mat2.nativeObj);
    }

    public static void transform(Mat mat, Mat mat2, Mat mat3) {
        transform_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void transpose(Mat mat, Mat mat2) {
        transpose_0(mat.nativeObj, mat2.nativeObj);
    }

    public static void vconcat(List<Mat> list, Mat mat) {
        vconcat_0(jlo.O000000o(list).nativeObj, mat.nativeObj);
    }

    public static void setUseIPP(boolean z) {
        setUseIPP_0(z);
    }

    public static void setUseIPP_NE(boolean z) {
        setUseIPP_NE_0(z);
    }

    public static void setUseIPP_NotExact(boolean z) {
        setUseIPP_NotExact_0(z);
    }

    public static void addSamplesDataSearchPath(String str) {
        addSamplesDataSearchPath_0(str);
    }

    public static void addSamplesDataSearchSubDirectory(String str) {
        addSamplesDataSearchSubDirectory_0(str);
    }

    public static MinMaxLocResult minMaxLoc(Mat mat, Mat mat2) {
        MinMaxLocResult minMaxLocResult = new MinMaxLocResult();
        double[] n_minMaxLocManual = n_minMaxLocManual(mat.nativeObj, mat2 != null ? mat2.nativeObj : 0);
        minMaxLocResult.minVal = n_minMaxLocManual[0];
        minMaxLocResult.maxVal = n_minMaxLocManual[1];
        minMaxLocResult.minLoc.x = n_minMaxLocManual[2];
        minMaxLocResult.minLoc.y = n_minMaxLocManual[3];
        minMaxLocResult.maxLoc.x = n_minMaxLocManual[4];
        minMaxLocResult.maxLoc.y = n_minMaxLocManual[5];
        return minMaxLocResult;
    }

    public static MinMaxLocResult minMaxLoc(Mat mat) {
        return minMaxLoc(mat, null);
    }
}
