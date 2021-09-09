package org.opencv.imgproc;

import _m_j.jln;
import _m_j.jlo;
import java.util.ArrayList;
import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfInt;
import org.opencv.core.MatOfInt4;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.RotatedRect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.core.TermCriteria;

public class Imgproc {
    private static native void Canny_0(long j, long j2, long j3, double d, double d2, boolean z);

    private static native void Canny_1(long j, long j2, long j3, double d, double d2);

    private static native void Canny_2(long j, long j2, double d, double d2, int i, boolean z);

    private static native void Canny_3(long j, long j2, double d, double d2, int i);

    private static native void Canny_4(long j, long j2, double d, double d2);

    private static native float EMD_0(long j, long j2, int i, long j3, long j4);

    private static native float EMD_1(long j, long j2, int i, long j3);

    private static native float EMD_3(long j, long j2, int i);

    private static native void GaussianBlur_0(long j, long j2, double d, double d2, double d3, double d4, int i);

    private static native void GaussianBlur_1(long j, long j2, double d, double d2, double d3, double d4);

    private static native void GaussianBlur_2(long j, long j2, double d, double d2, double d3);

    private static native void HoughCircles_0(long j, long j2, int i, double d, double d2, double d3, double d4, int i2, int i3);

    private static native void HoughCircles_1(long j, long j2, int i, double d, double d2, double d3, double d4, int i2);

    private static native void HoughCircles_2(long j, long j2, int i, double d, double d2, double d3, double d4);

    private static native void HoughCircles_3(long j, long j2, int i, double d, double d2, double d3);

    private static native void HoughCircles_4(long j, long j2, int i, double d, double d2);

    private static native void HoughLinesP_0(long j, long j2, double d, double d2, int i, double d3, double d4);

    private static native void HoughLinesP_1(long j, long j2, double d, double d2, int i, double d3);

    private static native void HoughLinesP_2(long j, long j2, double d, double d2, int i);

    private static native void HoughLinesPointSet_0(long j, long j2, int i, int i2, double d, double d2, double d3, double d4, double d5, double d6);

    private static native void HoughLines_0(long j, long j2, double d, double d2, int i, double d3, double d4, double d5, double d6);

    private static native void HoughLines_1(long j, long j2, double d, double d2, int i, double d3, double d4, double d5);

    private static native void HoughLines_2(long j, long j2, double d, double d2, int i, double d3, double d4);

    private static native void HoughLines_3(long j, long j2, double d, double d2, int i, double d3);

    private static native void HoughLines_4(long j, long j2, double d, double d2, int i);

    private static native void HuMoments_0(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, long j);

    private static native void Laplacian_0(long j, long j2, int i, int i2, double d, double d2, int i3);

    private static native void Laplacian_1(long j, long j2, int i, int i2, double d, double d2);

    private static native void Laplacian_2(long j, long j2, int i, int i2, double d);

    private static native void Laplacian_3(long j, long j2, int i, int i2);

    private static native void Laplacian_4(long j, long j2, int i);

    private static native void Scharr_0(long j, long j2, int i, int i2, int i3, double d, double d2, int i4);

    private static native void Scharr_1(long j, long j2, int i, int i2, int i3, double d, double d2);

    private static native void Scharr_2(long j, long j2, int i, int i2, int i3, double d);

    private static native void Scharr_3(long j, long j2, int i, int i2, int i3);

    private static native void Sobel_0(long j, long j2, int i, int i2, int i3, int i4, double d, double d2, int i5);

    private static native void Sobel_1(long j, long j2, int i, int i2, int i3, int i4, double d, double d2);

    private static native void Sobel_2(long j, long j2, int i, int i2, int i3, int i4, double d);

    private static native void Sobel_3(long j, long j2, int i, int i2, int i3, int i4);

    private static native void Sobel_4(long j, long j2, int i, int i2, int i3);

    private static native void accumulateProduct_0(long j, long j2, long j3, long j4);

    private static native void accumulateProduct_1(long j, long j2, long j3);

    private static native void accumulateSquare_0(long j, long j2, long j3);

    private static native void accumulateSquare_1(long j, long j2);

    private static native void accumulateWeighted_0(long j, long j2, double d, long j3);

    private static native void accumulateWeighted_1(long j, long j2, double d);

    private static native void accumulate_0(long j, long j2, long j3);

    private static native void accumulate_1(long j, long j2);

    private static native void adaptiveThreshold_0(long j, long j2, double d, int i, int i2, int i3, double d2);

    private static native void applyColorMap_0(long j, long j2, long j3);

    private static native void applyColorMap_1(long j, long j2, int i);

    private static native void approxPolyDP_0(long j, long j2, double d, boolean z);

    private static native double arcLength_0(long j, boolean z);

    private static native void arrowedLine_0(long j, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, int i, int i2, int i3, double d9);

    private static native void arrowedLine_1(long j, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, int i, int i2, int i3);

    private static native void arrowedLine_2(long j, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, int i, int i2);

    private static native void arrowedLine_3(long j, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, int i);

    private static native void arrowedLine_4(long j, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8);

    private static native void bilateralFilter_0(long j, long j2, int i, double d, double d2, int i2);

    private static native void bilateralFilter_1(long j, long j2, int i, double d, double d2);

    private static native void blur_0(long j, long j2, double d, double d2, double d3, double d4, int i);

    private static native void blur_1(long j, long j2, double d, double d2, double d3, double d4);

    private static native void blur_2(long j, long j2, double d, double d2);

    private static native double[] boundingRect_0(long j);

    private static native void boxFilter_0(long j, long j2, int i, double d, double d2, double d3, double d4, boolean z, int i2);

    private static native void boxFilter_1(long j, long j2, int i, double d, double d2, double d3, double d4, boolean z);

    private static native void boxFilter_2(long j, long j2, int i, double d, double d2, double d3, double d4);

    private static native void boxFilter_3(long j, long j2, int i, double d, double d2);

    private static native void boxPoints_0(double d, double d2, double d3, double d4, double d5, long j);

    private static native void calcBackProject_0(long j, long j2, long j3, long j4, long j5, double d);

    private static native void calcHist_0(long j, long j2, long j3, long j4, long j5, long j6, boolean z);

    private static native void calcHist_1(long j, long j2, long j3, long j4, long j5, long j6);

    private static native void circle_0(long j, double d, double d2, int i, double d3, double d4, double d5, double d6, int i2, int i3, int i4);

    private static native void circle_1(long j, double d, double d2, int i, double d3, double d4, double d5, double d6, int i2, int i3);

    private static native void circle_2(long j, double d, double d2, int i, double d3, double d4, double d5, double d6, int i2);

    private static native void circle_3(long j, double d, double d2, int i, double d3, double d4, double d5, double d6);

    private static native boolean clipLine_0(int i, int i2, int i3, int i4, double d, double d2, double[] dArr, double d3, double d4, double[] dArr2);

    private static native double compareHist_0(long j, long j2, int i);

    private static native int connectedComponentsWithAlgorithm_0(long j, long j2, int i, int i2, int i3);

    private static native int connectedComponentsWithStatsWithAlgorithm_0(long j, long j2, long j3, long j4, int i, int i2, int i3);

    private static native int connectedComponentsWithStats_0(long j, long j2, long j3, long j4, int i, int i2);

    private static native int connectedComponentsWithStats_1(long j, long j2, long j3, long j4, int i);

    private static native int connectedComponentsWithStats_2(long j, long j2, long j3, long j4);

    private static native int connectedComponents_0(long j, long j2, int i, int i2);

    private static native int connectedComponents_1(long j, long j2, int i);

    private static native int connectedComponents_2(long j, long j2);

    private static native double contourArea_0(long j, boolean z);

    private static native double contourArea_1(long j);

    private static native void convertMaps_0(long j, long j2, long j3, long j4, int i, boolean z);

    private static native void convertMaps_1(long j, long j2, long j3, long j4, int i);

    private static native void convexHull_0(long j, long j2, boolean z);

    private static native void convexHull_2(long j, long j2);

    private static native void convexityDefects_0(long j, long j2, long j3);

    private static native void cornerEigenValsAndVecs_0(long j, long j2, int i, int i2, int i3);

    private static native void cornerEigenValsAndVecs_1(long j, long j2, int i, int i2);

    private static native void cornerHarris_0(long j, long j2, int i, int i2, double d, int i3);

    private static native void cornerHarris_1(long j, long j2, int i, int i2, double d);

    private static native void cornerMinEigenVal_0(long j, long j2, int i, int i2, int i3);

    private static native void cornerMinEigenVal_1(long j, long j2, int i, int i2);

    private static native void cornerMinEigenVal_2(long j, long j2, int i);

    private static native void cornerSubPix_0(long j, long j2, double d, double d2, double d3, double d4, int i, int i2, double d5);

    private static native long createCLAHE_0(double d, double d2, double d3);

    private static native long createCLAHE_1(double d);

    private static native long createCLAHE_2();

    private static native void createHanningWindow_0(long j, double d, double d2, int i);

    private static native long createLineSegmentDetector_0(int i, double d, double d2, double d3, double d4, double d5, double d6, int i2);

    private static native long createLineSegmentDetector_1(int i, double d, double d2, double d3, double d4, double d5, double d6);

    private static native long createLineSegmentDetector_2(int i, double d, double d2, double d3, double d4, double d5);

    private static native long createLineSegmentDetector_3(int i, double d, double d2, double d3, double d4);

    private static native long createLineSegmentDetector_4(int i, double d, double d2, double d3);

    private static native long createLineSegmentDetector_5(int i, double d, double d2);

    private static native long createLineSegmentDetector_6(int i, double d);

    private static native long createLineSegmentDetector_7(int i);

    private static native long createLineSegmentDetector_8();

    private static native void cvtColorTwoPlane_0(long j, long j2, long j3, int i);

    private static native void cvtColor_0(long j, long j2, int i, int i2);

    private static native void cvtColor_1(long j, long j2, int i);

    private static native void demosaicing_0(long j, long j2, int i, int i2);

    private static native void demosaicing_1(long j, long j2, int i);

    private static native void dilate_0(long j, long j2, long j3, double d, double d2, int i, int i2, double d3, double d4, double d5, double d6);

    private static native void dilate_1(long j, long j2, long j3, double d, double d2, int i, int i2);

    private static native void dilate_2(long j, long j2, long j3, double d, double d2, int i);

    private static native void dilate_3(long j, long j2, long j3, double d, double d2);

    private static native void dilate_4(long j, long j2, long j3);

    private static native void distanceTransformWithLabels_0(long j, long j2, long j3, int i, int i2, int i3);

    private static native void distanceTransformWithLabels_1(long j, long j2, long j3, int i, int i2);

    private static native void distanceTransform_0(long j, long j2, int i, int i2, int i3);

    private static native void distanceTransform_1(long j, long j2, int i, int i2);

    private static native void drawContours_0(long j, long j2, int i, double d, double d2, double d3, double d4, int i2, int i3, long j3, int i4, double d5, double d6);

    private static native void drawContours_1(long j, long j2, int i, double d, double d2, double d3, double d4, int i2, int i3, long j3, int i4);

    private static native void drawContours_2(long j, long j2, int i, double d, double d2, double d3, double d4, int i2, int i3, long j3);

    private static native void drawContours_3(long j, long j2, int i, double d, double d2, double d3, double d4, int i2, int i3);

    private static native void drawContours_4(long j, long j2, int i, double d, double d2, double d3, double d4, int i2);

    private static native void drawContours_5(long j, long j2, int i, double d, double d2, double d3, double d4);

    private static native void drawMarker_0(long j, double d, double d2, double d3, double d4, double d5, double d6, int i, int i2, int i3, int i4);

    private static native void drawMarker_1(long j, double d, double d2, double d3, double d4, double d5, double d6, int i, int i2, int i3);

    private static native void drawMarker_2(long j, double d, double d2, double d3, double d4, double d5, double d6, int i, int i2);

    private static native void drawMarker_3(long j, double d, double d2, double d3, double d4, double d5, double d6, int i);

    private static native void drawMarker_4(long j, double d, double d2, double d3, double d4, double d5, double d6);

    private static native void ellipse2Poly_0(double d, double d2, double d3, double d4, int i, int i2, int i3, int i4, long j);

    private static native void ellipse_0(long j, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, int i, int i2, int i3);

    private static native void ellipse_1(long j, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, int i, int i2);

    private static native void ellipse_2(long j, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, int i);

    private static native void ellipse_3(long j, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11);

    private static native void ellipse_4(long j, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, int i, int i2);

    private static native void ellipse_5(long j, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, int i);

    private static native void ellipse_6(long j, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9);

    private static native void equalizeHist_0(long j, long j2);

    private static native void erode_0(long j, long j2, long j3, double d, double d2, int i, int i2, double d3, double d4, double d5, double d6);

    private static native void erode_1(long j, long j2, long j3, double d, double d2, int i, int i2);

    private static native void erode_2(long j, long j2, long j3, double d, double d2, int i);

    private static native void erode_3(long j, long j2, long j3, double d, double d2);

    private static native void erode_4(long j, long j2, long j3);

    private static native void fillConvexPoly_0(long j, long j2, double d, double d2, double d3, double d4, int i, int i2);

    private static native void fillConvexPoly_1(long j, long j2, double d, double d2, double d3, double d4, int i);

    private static native void fillConvexPoly_2(long j, long j2, double d, double d2, double d3, double d4);

    private static native void fillPoly_0(long j, long j2, double d, double d2, double d3, double d4, int i, int i2, double d5, double d6);

    private static native void fillPoly_1(long j, long j2, double d, double d2, double d3, double d4, int i, int i2);

    private static native void fillPoly_2(long j, long j2, double d, double d2, double d3, double d4, int i);

    private static native void fillPoly_3(long j, long j2, double d, double d2, double d3, double d4);

    private static native void filter2D_0(long j, long j2, int i, long j3, double d, double d2, double d3, int i2);

    private static native void filter2D_1(long j, long j2, int i, long j3, double d, double d2, double d3);

    private static native void filter2D_2(long j, long j2, int i, long j3, double d, double d2);

    private static native void filter2D_3(long j, long j2, int i, long j3);

    private static native void findContours_0(long j, long j2, long j3, int i, int i2, double d, double d2);

    private static native void findContours_1(long j, long j2, long j3, int i, int i2);

    private static native double[] fitEllipseAMS_0(long j);

    private static native double[] fitEllipseDirect_0(long j);

    private static native double[] fitEllipse_0(long j);

    private static native void fitLine_0(long j, long j2, int i, double d, double d2, double d3);

    private static native int floodFill_0(long j, long j2, double d, double d2, double d3, double d4, double d5, double d6, double[] dArr, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, int i);

    private static native int floodFill_1(long j, long j2, double d, double d2, double d3, double d4, double d5, double d6, double[] dArr, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14);

    private static native int floodFill_2(long j, long j2, double d, double d2, double d3, double d4, double d5, double d6, double[] dArr, double d7, double d8, double d9, double d10);

    private static native int floodFill_3(long j, long j2, double d, double d2, double d3, double d4, double d5, double d6, double[] dArr);

    private static native int floodFill_4(long j, long j2, double d, double d2, double d3, double d4, double d5, double d6);

    private static native long getAffineTransform_0(long j, long j2);

    private static native long getDefaultNewCameraMatrix_0(long j, double d, double d2, boolean z);

    private static native long getDefaultNewCameraMatrix_1(long j, double d, double d2);

    private static native long getDefaultNewCameraMatrix_2(long j);

    private static native void getDerivKernels_0(long j, long j2, int i, int i2, int i3, boolean z, int i4);

    private static native void getDerivKernels_1(long j, long j2, int i, int i2, int i3, boolean z);

    private static native void getDerivKernels_2(long j, long j2, int i, int i2, int i3);

    private static native double getFontScaleFromHeight_0(int i, int i2, int i3);

    private static native double getFontScaleFromHeight_1(int i, int i2);

    private static native long getGaborKernel_0(double d, double d2, double d3, double d4, double d5, double d6, double d7, int i);

    private static native long getGaborKernel_1(double d, double d2, double d3, double d4, double d5, double d6, double d7);

    private static native long getGaborKernel_2(double d, double d2, double d3, double d4, double d5, double d6);

    private static native long getGaussianKernel_0(int i, double d, int i2);

    private static native long getGaussianKernel_1(int i, double d);

    private static native long getPerspectiveTransform_0(long j, long j2);

    private static native void getRectSubPix_0(long j, double d, double d2, double d3, double d4, long j2, int i);

    private static native void getRectSubPix_1(long j, double d, double d2, double d3, double d4, long j2);

    private static native long getRotationMatrix2D_0(double d, double d2, double d3, double d4);

    private static native long getStructuringElement_0(int i, double d, double d2, double d3, double d4);

    private static native long getStructuringElement_1(int i, double d, double d2);

    private static native void goodFeaturesToTrack_0(long j, long j2, int i, double d, double d2, long j3, int i2, int i3, boolean z, double d3);

    private static native void goodFeaturesToTrack_1(long j, long j2, int i, double d, double d2, long j3, int i2, int i3, boolean z);

    private static native void goodFeaturesToTrack_2(long j, long j2, int i, double d, double d2, long j3, int i2, int i3);

    private static native void goodFeaturesToTrack_3(long j, long j2, int i, double d, double d2, long j3, int i2, boolean z, double d3);

    private static native void goodFeaturesToTrack_4(long j, long j2, int i, double d, double d2, long j3, int i2, boolean z);

    private static native void goodFeaturesToTrack_5(long j, long j2, int i, double d, double d2, long j3, int i2);

    private static native void goodFeaturesToTrack_6(long j, long j2, int i, double d, double d2, long j3);

    private static native void goodFeaturesToTrack_7(long j, long j2, int i, double d, double d2);

    private static native void grabCut_0(long j, long j2, int i, int i2, int i3, int i4, long j3, long j4, int i5, int i6);

    private static native void grabCut_1(long j, long j2, int i, int i2, int i3, int i4, long j3, long j4, int i5);

    private static native void initUndistortRectifyMap_0(long j, long j2, long j3, long j4, double d, double d2, int i, long j5, long j6);

    private static native float initWideAngleProjMap_0(long j, long j2, double d, double d2, int i, int i2, long j3, long j4, int i3, double d3);

    private static native float initWideAngleProjMap_1(long j, long j2, double d, double d2, int i, int i2, long j3, long j4, int i3);

    private static native float initWideAngleProjMap_2(long j, long j2, double d, double d2, int i, int i2, long j3, long j4);

    private static native void integral2_0(long j, long j2, long j3, int i, int i2);

    private static native void integral2_1(long j, long j2, long j3, int i);

    private static native void integral2_2(long j, long j2, long j3);

    private static native void integral3_0(long j, long j2, long j3, long j4, int i, int i2);

    private static native void integral3_1(long j, long j2, long j3, long j4, int i);

    private static native void integral3_2(long j, long j2, long j3, long j4);

    private static native void integral_0(long j, long j2, int i);

    private static native void integral_1(long j, long j2);

    private static native float intersectConvexConvex_0(long j, long j2, long j3, boolean z);

    private static native float intersectConvexConvex_1(long j, long j2, long j3);

    private static native void invertAffineTransform_0(long j, long j2);

    private static native boolean isContourConvex_0(long j);

    private static native void line_0(long j, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, int i, int i2, int i3);

    private static native void line_1(long j, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, int i, int i2);

    private static native void line_2(long j, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, int i);

    private static native void line_3(long j, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8);

    private static native void linearPolar_0(long j, long j2, double d, double d2, double d3, int i);

    private static native void logPolar_0(long j, long j2, double d, double d2, double d3, int i);

    private static native double matchShapes_0(long j, long j2, int i, double d);

    private static native void matchTemplate_0(long j, long j2, long j3, int i, long j4);

    private static native void matchTemplate_1(long j, long j2, long j3, int i);

    private static native void medianBlur_0(long j, long j2, int i);

    private static native double[] minAreaRect_0(long j);

    private static native void minEnclosingCircle_0(long j, double[] dArr, double[] dArr2);

    private static native double minEnclosingTriangle_0(long j, long j2);

    private static native double[] moments_0(long j, boolean z);

    private static native double[] moments_1(long j);

    private static native void morphologyEx_0(long j, long j2, int i, long j3, double d, double d2, int i2, int i3, double d3, double d4, double d5, double d6);

    private static native void morphologyEx_1(long j, long j2, int i, long j3, double d, double d2, int i2, int i3);

    private static native void morphologyEx_2(long j, long j2, int i, long j3, double d, double d2, int i2);

    private static native void morphologyEx_3(long j, long j2, int i, long j3, double d, double d2);

    private static native void morphologyEx_4(long j, long j2, int i, long j3);

    private static native double[] n_getTextSize(String str, int i, double d, int i2, int[] iArr);

    private static native double[] phaseCorrelate_0(long j, long j2, long j3, double[] dArr);

    private static native double[] phaseCorrelate_1(long j, long j2, long j3);

    private static native double[] phaseCorrelate_2(long j, long j2);

    private static native double pointPolygonTest_0(long j, double d, double d2, boolean z);

    private static native void polylines_0(long j, long j2, boolean z, double d, double d2, double d3, double d4, int i, int i2, int i3);

    private static native void polylines_1(long j, long j2, boolean z, double d, double d2, double d3, double d4, int i, int i2);

    private static native void polylines_2(long j, long j2, boolean z, double d, double d2, double d3, double d4, int i);

    private static native void polylines_3(long j, long j2, boolean z, double d, double d2, double d3, double d4);

    private static native void preCornerDetect_0(long j, long j2, int i, int i2);

    private static native void preCornerDetect_1(long j, long j2, int i);

    private static native void putText_0(long j, String str, double d, double d2, int i, double d3, double d4, double d5, double d6, double d7, int i2, int i3, boolean z);

    private static native void putText_1(long j, String str, double d, double d2, int i, double d3, double d4, double d5, double d6, double d7, int i2, int i3);

    private static native void putText_2(long j, String str, double d, double d2, int i, double d3, double d4, double d5, double d6, double d7, int i2);

    private static native void putText_3(long j, String str, double d, double d2, int i, double d3, double d4, double d5, double d6, double d7);

    private static native void pyrDown_0(long j, long j2, double d, double d2, int i);

    private static native void pyrDown_1(long j, long j2, double d, double d2);

    private static native void pyrDown_2(long j, long j2);

    private static native void pyrMeanShiftFiltering_0(long j, long j2, double d, double d2, int i, int i2, int i3, double d3);

    private static native void pyrMeanShiftFiltering_1(long j, long j2, double d, double d2, int i);

    private static native void pyrMeanShiftFiltering_2(long j, long j2, double d, double d2);

    private static native void pyrUp_0(long j, long j2, double d, double d2, int i);

    private static native void pyrUp_1(long j, long j2, double d, double d2);

    private static native void pyrUp_2(long j, long j2);

    private static native void rectangle_0(long j, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, int i, int i2, int i3);

    private static native void rectangle_1(long j, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, int i, int i2);

    private static native void rectangle_2(long j, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, int i);

    private static native void rectangle_3(long j, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8);

    private static native void remap_0(long j, long j2, long j3, long j4, int i, int i2, double d, double d2, double d3, double d4);

    private static native void remap_1(long j, long j2, long j3, long j4, int i, int i2);

    private static native void remap_2(long j, long j2, long j3, long j4, int i);

    private static native void resize_0(long j, long j2, double d, double d2, double d3, double d4, int i);

    private static native void resize_1(long j, long j2, double d, double d2, double d3, double d4);

    private static native void resize_2(long j, long j2, double d, double d2, double d3);

    private static native void resize_3(long j, long j2, double d, double d2);

    private static native int rotatedRectangleIntersection_0(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, long j);

    private static native void sepFilter2D_0(long j, long j2, int i, long j3, long j4, double d, double d2, double d3, int i2);

    private static native void sepFilter2D_1(long j, long j2, int i, long j3, long j4, double d, double d2, double d3);

    private static native void sepFilter2D_2(long j, long j2, int i, long j3, long j4, double d, double d2);

    private static native void sepFilter2D_3(long j, long j2, int i, long j3, long j4);

    private static native void spatialGradient_0(long j, long j2, long j3, int i, int i2);

    private static native void spatialGradient_1(long j, long j2, long j3, int i);

    private static native void spatialGradient_2(long j, long j2, long j3);

    private static native void sqrBoxFilter_0(long j, long j2, int i, double d, double d2, double d3, double d4, boolean z, int i2);

    private static native void sqrBoxFilter_1(long j, long j2, int i, double d, double d2, double d3, double d4, boolean z);

    private static native void sqrBoxFilter_2(long j, long j2, int i, double d, double d2, double d3, double d4);

    private static native void sqrBoxFilter_3(long j, long j2, int i, double d, double d2);

    private static native double threshold_0(long j, long j2, double d, double d2, int i);

    private static native void undistortPointsIter_0(long j, long j2, long j3, long j4, long j5, long j6, int i, int i2, double d);

    private static native void undistortPoints_0(long j, long j2, long j3, long j4, long j5, long j6);

    private static native void undistortPoints_1(long j, long j2, long j3, long j4, long j5);

    private static native void undistortPoints_2(long j, long j2, long j3, long j4);

    private static native void undistort_0(long j, long j2, long j3, long j4, long j5);

    private static native void undistort_1(long j, long j2, long j3, long j4);

    private static native void warpAffine_0(long j, long j2, long j3, double d, double d2, int i, int i2, double d3, double d4, double d5, double d6);

    private static native void warpAffine_1(long j, long j2, long j3, double d, double d2, int i, int i2);

    private static native void warpAffine_2(long j, long j2, long j3, double d, double d2, int i);

    private static native void warpAffine_3(long j, long j2, long j3, double d, double d2);

    private static native void warpPerspective_0(long j, long j2, long j3, double d, double d2, int i, int i2, double d3, double d4, double d5, double d6);

    private static native void warpPerspective_1(long j, long j2, long j3, double d, double d2, int i, int i2);

    private static native void warpPerspective_2(long j, long j2, long j3, double d, double d2, int i);

    private static native void warpPerspective_3(long j, long j2, long j3, double d, double d2);

    private static native void warpPolar_0(long j, long j2, double d, double d2, double d3, double d4, double d5, int i);

    private static native void watershed_0(long j, long j2);

    public static Mat getAffineTransform(MatOfPoint2f matOfPoint2f, MatOfPoint2f matOfPoint2f2) {
        return new Mat(getAffineTransform_0(matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj));
    }

    public static Mat getDefaultNewCameraMatrix(Mat mat, Size size, boolean z) {
        return new Mat(getDefaultNewCameraMatrix_0(mat.nativeObj, size.width, size.height, z));
    }

    public static Mat getDefaultNewCameraMatrix(Mat mat, Size size) {
        return new Mat(getDefaultNewCameraMatrix_1(mat.nativeObj, size.width, size.height));
    }

    public static Mat getDefaultNewCameraMatrix(Mat mat) {
        return new Mat(getDefaultNewCameraMatrix_2(mat.nativeObj));
    }

    public static Mat getGaborKernel(Size size, double d, double d2, double d3, double d4, double d5, int i) {
        Size size2 = size;
        return new Mat(getGaborKernel_0(size2.width, size2.height, d, d2, d3, d4, d5, i));
    }

    public static Mat getGaborKernel(Size size, double d, double d2, double d3, double d4, double d5) {
        Size size2 = size;
        return new Mat(getGaborKernel_1(size2.width, size2.height, d, d2, d3, d4, d5));
    }

    public static Mat getGaborKernel(Size size, double d, double d2, double d3, double d4) {
        Size size2 = size;
        return new Mat(getGaborKernel_2(size2.width, size2.height, d, d2, d3, d4));
    }

    public static Mat getGaussianKernel(int i, double d, int i2) {
        return new Mat(getGaussianKernel_0(i, d, i2));
    }

    public static Mat getGaussianKernel(int i, double d) {
        return new Mat(getGaussianKernel_1(i, d));
    }

    public static Mat getPerspectiveTransform(Mat mat, Mat mat2) {
        return new Mat(getPerspectiveTransform_0(mat.nativeObj, mat2.nativeObj));
    }

    public static Mat getRotationMatrix2D(Point point, double d, double d2) {
        return new Mat(getRotationMatrix2D_0(point.x, point.y, d, d2));
    }

    public static Mat getStructuringElement(int i, Size size, Point point) {
        return new Mat(getStructuringElement_0(i, size.width, size.height, point.x, point.y));
    }

    public static Mat getStructuringElement(int i, Size size) {
        return new Mat(getStructuringElement_1(i, size.width, size.height));
    }

    public static jln moments(Mat mat, boolean z) {
        return new jln(moments_0(mat.nativeObj, z));
    }

    public static jln moments(Mat mat) {
        return new jln(moments_1(mat.nativeObj));
    }

    public static Point phaseCorrelate(Mat mat, Mat mat2, Mat mat3, double[] dArr) {
        double[] dArr2 = new double[1];
        Point point = new Point(phaseCorrelate_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, dArr2));
        if (dArr != null) {
            dArr[0] = dArr2[0];
        }
        return point;
    }

    public static Point phaseCorrelate(Mat mat, Mat mat2, Mat mat3) {
        return new Point(phaseCorrelate_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj));
    }

    public static Point phaseCorrelate(Mat mat, Mat mat2) {
        return new Point(phaseCorrelate_2(mat.nativeObj, mat2.nativeObj));
    }

    public static CLAHE createCLAHE(double d, Size size) {
        return CLAHE.O000000o(createCLAHE_0(d, size.width, size.height));
    }

    public static CLAHE createCLAHE(double d) {
        return CLAHE.O000000o(createCLAHE_1(d));
    }

    public static CLAHE createCLAHE() {
        return CLAHE.O000000o(createCLAHE_2());
    }

    public static LineSegmentDetector createLineSegmentDetector(int i, double d, double d2, double d3, double d4, double d5, double d6, int i2) {
        return LineSegmentDetector.O000000o(createLineSegmentDetector_0(i, d, d2, d3, d4, d5, d6, i2));
    }

    public static LineSegmentDetector createLineSegmentDetector(int i, double d, double d2, double d3, double d4, double d5, double d6) {
        return LineSegmentDetector.O000000o(createLineSegmentDetector_1(i, d, d2, d3, d4, d5, d6));
    }

    public static LineSegmentDetector createLineSegmentDetector(int i, double d, double d2, double d3, double d4, double d5) {
        return LineSegmentDetector.O000000o(createLineSegmentDetector_2(i, d, d2, d3, d4, d5));
    }

    public static LineSegmentDetector createLineSegmentDetector(int i, double d, double d2, double d3, double d4) {
        return LineSegmentDetector.O000000o(createLineSegmentDetector_3(i, d, d2, d3, d4));
    }

    public static LineSegmentDetector createLineSegmentDetector(int i, double d, double d2, double d3) {
        return LineSegmentDetector.O000000o(createLineSegmentDetector_4(i, d, d2, d3));
    }

    public static LineSegmentDetector createLineSegmentDetector(int i, double d, double d2) {
        return LineSegmentDetector.O000000o(createLineSegmentDetector_5(i, d, d2));
    }

    public static LineSegmentDetector createLineSegmentDetector(int i, double d) {
        return LineSegmentDetector.O000000o(createLineSegmentDetector_6(i, d));
    }

    public static LineSegmentDetector createLineSegmentDetector(int i) {
        return LineSegmentDetector.O000000o(createLineSegmentDetector_7(i));
    }

    public static LineSegmentDetector createLineSegmentDetector() {
        return LineSegmentDetector.O000000o(createLineSegmentDetector_8());
    }

    public static Rect boundingRect(Mat mat) {
        return new Rect(boundingRect_0(mat.nativeObj));
    }

    public static RotatedRect fitEllipse(MatOfPoint2f matOfPoint2f) {
        return new RotatedRect(fitEllipse_0(matOfPoint2f.nativeObj));
    }

    public static RotatedRect fitEllipseAMS(Mat mat) {
        return new RotatedRect(fitEllipseAMS_0(mat.nativeObj));
    }

    public static RotatedRect fitEllipseDirect(Mat mat) {
        return new RotatedRect(fitEllipseDirect_0(mat.nativeObj));
    }

    public static RotatedRect minAreaRect(MatOfPoint2f matOfPoint2f) {
        return new RotatedRect(minAreaRect_0(matOfPoint2f.nativeObj));
    }

    public static boolean clipLine(Rect rect, Point point, Point point2) {
        Rect rect2 = rect;
        Point point3 = point;
        Point point4 = point2;
        double[] dArr = new double[2];
        double[] dArr2 = new double[2];
        double[] dArr3 = dArr;
        boolean clipLine_0 = clipLine_0(rect2.x, rect2.y, rect2.width, rect2.height, point3.x, point3.y, dArr, point4.x, point4.y, dArr2);
        Point point5 = point;
        if (point5 != null) {
            point5.x = dArr3[0];
            point5.y = dArr3[1];
        }
        if (point4 != null) {
            point4.x = dArr2[0];
            point4.y = dArr2[1];
        }
        return clipLine_0;
    }

    public static boolean isContourConvex(MatOfPoint matOfPoint) {
        return isContourConvex_0(matOfPoint.nativeObj);
    }

    public static double arcLength(MatOfPoint2f matOfPoint2f, boolean z) {
        return arcLength_0(matOfPoint2f.nativeObj, z);
    }

    public static double compareHist(Mat mat, Mat mat2, int i) {
        return compareHist_0(mat.nativeObj, mat2.nativeObj, i);
    }

    public static double contourArea(Mat mat, boolean z) {
        return contourArea_0(mat.nativeObj, z);
    }

    public static double contourArea(Mat mat) {
        return contourArea_1(mat.nativeObj);
    }

    public static double getFontScaleFromHeight(int i, int i2, int i3) {
        return getFontScaleFromHeight_0(i, i2, i3);
    }

    public static double getFontScaleFromHeight(int i, int i2) {
        return getFontScaleFromHeight_1(i, i2);
    }

    public static double matchShapes(Mat mat, Mat mat2, int i, double d) {
        return matchShapes_0(mat.nativeObj, mat2.nativeObj, i, d);
    }

    public static double minEnclosingTriangle(Mat mat, Mat mat2) {
        return minEnclosingTriangle_0(mat.nativeObj, mat2.nativeObj);
    }

    public static double pointPolygonTest(MatOfPoint2f matOfPoint2f, Point point, boolean z) {
        return pointPolygonTest_0(matOfPoint2f.nativeObj, point.x, point.y, z);
    }

    public static double threshold(Mat mat, Mat mat2, double d, double d2, int i) {
        return threshold_0(mat.nativeObj, mat2.nativeObj, d, d2, i);
    }

    public static float initWideAngleProjMap(Mat mat, Mat mat2, Size size, int i, int i2, Mat mat3, Mat mat4, int i3, double d) {
        Size size2 = size;
        return initWideAngleProjMap_0(mat.nativeObj, mat2.nativeObj, size2.width, size2.height, i, i2, mat3.nativeObj, mat4.nativeObj, i3, d);
    }

    public static float initWideAngleProjMap(Mat mat, Mat mat2, Size size, int i, int i2, Mat mat3, Mat mat4, int i3) {
        Size size2 = size;
        return initWideAngleProjMap_1(mat.nativeObj, mat2.nativeObj, size2.width, size2.height, i, i2, mat3.nativeObj, mat4.nativeObj, i3);
    }

    public static float initWideAngleProjMap(Mat mat, Mat mat2, Size size, int i, int i2, Mat mat3, Mat mat4) {
        Size size2 = size;
        return initWideAngleProjMap_2(mat.nativeObj, mat2.nativeObj, size2.width, size2.height, i, i2, mat3.nativeObj, mat4.nativeObj);
    }

    public static float intersectConvexConvex(Mat mat, Mat mat2, Mat mat3, boolean z) {
        return intersectConvexConvex_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, z);
    }

    public static float intersectConvexConvex(Mat mat, Mat mat2, Mat mat3) {
        return intersectConvexConvex_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static float EMD(Mat mat, Mat mat2, int i, Mat mat3, Mat mat4) {
        return EMD_0(mat.nativeObj, mat2.nativeObj, i, mat3.nativeObj, mat4.nativeObj);
    }

    public static float EMD(Mat mat, Mat mat2, int i, Mat mat3) {
        return EMD_1(mat.nativeObj, mat2.nativeObj, i, mat3.nativeObj);
    }

    public static float EMD(Mat mat, Mat mat2, int i) {
        return EMD_3(mat.nativeObj, mat2.nativeObj, i);
    }

    public static int connectedComponentsWithAlgorithm(Mat mat, Mat mat2, int i, int i2, int i3) {
        return connectedComponentsWithAlgorithm_0(mat.nativeObj, mat2.nativeObj, i, i2, i3);
    }

    public static int connectedComponents(Mat mat, Mat mat2, int i, int i2) {
        return connectedComponents_0(mat.nativeObj, mat2.nativeObj, i, i2);
    }

    public static int connectedComponents(Mat mat, Mat mat2, int i) {
        return connectedComponents_1(mat.nativeObj, mat2.nativeObj, i);
    }

    public static int connectedComponents(Mat mat, Mat mat2) {
        return connectedComponents_2(mat.nativeObj, mat2.nativeObj);
    }

    public static int connectedComponentsWithStatsWithAlgorithm(Mat mat, Mat mat2, Mat mat3, Mat mat4, int i, int i2, int i3) {
        return connectedComponentsWithStatsWithAlgorithm_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, i, i2, i3);
    }

    public static int connectedComponentsWithStats(Mat mat, Mat mat2, Mat mat3, Mat mat4, int i, int i2) {
        return connectedComponentsWithStats_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, i, i2);
    }

    public static int connectedComponentsWithStats(Mat mat, Mat mat2, Mat mat3, Mat mat4, int i) {
        return connectedComponentsWithStats_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, i);
    }

    public static int connectedComponentsWithStats(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        return connectedComponentsWithStats_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static int floodFill(Mat mat, Mat mat2, Point point, Scalar scalar, Rect rect, Scalar scalar2, Scalar scalar3, int i) {
        Point point2 = point;
        Scalar scalar4 = scalar;
        Rect rect2 = rect;
        Scalar scalar5 = scalar2;
        Scalar scalar6 = scalar3;
        double[] dArr = new double[4];
        double[] dArr2 = dArr;
        double[] dArr3 = dArr;
        double[] dArr4 = dArr3;
        int floodFill_0 = floodFill_0(mat.nativeObj, mat2.nativeObj, point2.x, point2.y, scalar4.val[0], scalar4.val[1], scalar4.val[2], scalar4.val[3], dArr2, scalar5.val[0], scalar5.val[1], scalar5.val[2], scalar5.val[3], scalar6.val[0], scalar6.val[1], scalar6.val[2], scalar6.val[3], i);
        if (rect2 != null) {
            rect2.x = (int) dArr4[0];
            rect2.y = (int) dArr4[1];
            rect2.width = (int) dArr4[2];
            rect2.height = (int) dArr4[3];
        }
        return floodFill_0;
    }

    public static int floodFill(Mat mat, Mat mat2, Point point, Scalar scalar, Rect rect, Scalar scalar2, Scalar scalar3) {
        Point point2 = point;
        Scalar scalar4 = scalar;
        Rect rect2 = rect;
        Scalar scalar5 = scalar2;
        Scalar scalar6 = scalar3;
        double[] dArr = new double[4];
        int floodFill_1 = floodFill_1(mat.nativeObj, mat2.nativeObj, point2.x, point2.y, scalar4.val[0], scalar4.val[1], scalar4.val[2], scalar4.val[3], dArr, scalar5.val[0], scalar5.val[1], scalar5.val[2], scalar5.val[3], scalar6.val[0], scalar6.val[1], scalar6.val[2], scalar6.val[3]);
        if (rect2 != null) {
            rect2.x = (int) dArr[0];
            rect2.y = (int) dArr[1];
            rect2.width = (int) dArr[2];
            rect2.height = (int) dArr[3];
        }
        return floodFill_1;
    }

    public static int floodFill(Mat mat, Mat mat2, Point point, Scalar scalar, Rect rect, Scalar scalar2) {
        Point point2 = point;
        Scalar scalar3 = scalar;
        Rect rect2 = rect;
        Scalar scalar4 = scalar2;
        double[] dArr = new double[4];
        int floodFill_2 = floodFill_2(mat.nativeObj, mat2.nativeObj, point2.x, point2.y, scalar3.val[0], scalar3.val[1], scalar3.val[2], scalar3.val[3], dArr, scalar4.val[0], scalar4.val[1], scalar4.val[2], scalar4.val[3]);
        if (rect2 != null) {
            rect2.x = (int) dArr[0];
            rect2.y = (int) dArr[1];
            rect2.width = (int) dArr[2];
            rect2.height = (int) dArr[3];
        }
        return floodFill_2;
    }

    public static int floodFill(Mat mat, Mat mat2, Point point, Scalar scalar, Rect rect) {
        Point point2 = point;
        Scalar scalar2 = scalar;
        Rect rect2 = rect;
        double[] dArr = new double[4];
        int floodFill_3 = floodFill_3(mat.nativeObj, mat2.nativeObj, point2.x, point2.y, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], dArr);
        if (rect2 != null) {
            rect2.x = (int) dArr[0];
            rect2.y = (int) dArr[1];
            rect2.width = (int) dArr[2];
            rect2.height = (int) dArr[3];
        }
        return floodFill_3;
    }

    public static int floodFill(Mat mat, Mat mat2, Point point, Scalar scalar) {
        Point point2 = point;
        Scalar scalar2 = scalar;
        return floodFill_4(mat.nativeObj, mat2.nativeObj, point2.x, point2.y, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3]);
    }

    public static int rotatedRectangleIntersection(RotatedRect rotatedRect, RotatedRect rotatedRect2, Mat mat) {
        RotatedRect rotatedRect3 = rotatedRect;
        RotatedRect rotatedRect4 = rotatedRect2;
        return rotatedRectangleIntersection_0(rotatedRect3.center.x, rotatedRect3.center.y, rotatedRect3.size.width, rotatedRect3.size.height, rotatedRect3.angle, rotatedRect4.center.x, rotatedRect4.center.y, rotatedRect4.size.width, rotatedRect4.size.height, rotatedRect4.angle, mat.nativeObj);
    }

    public static void Canny(Mat mat, Mat mat2, Mat mat3, double d, double d2, boolean z) {
        Canny_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, d, d2, z);
    }

    public static void Canny(Mat mat, Mat mat2, Mat mat3, double d, double d2) {
        Canny_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, d, d2);
    }

    public static void Canny(Mat mat, Mat mat2, double d, double d2, int i, boolean z) {
        Canny_2(mat.nativeObj, mat2.nativeObj, d, d2, i, z);
    }

    public static void Canny(Mat mat, Mat mat2, double d, double d2, int i) {
        Canny_3(mat.nativeObj, mat2.nativeObj, d, d2, i);
    }

    public static void Canny(Mat mat, Mat mat2, double d, double d2) {
        Canny_4(mat.nativeObj, mat2.nativeObj, d, d2);
    }

    public static void GaussianBlur(Mat mat, Mat mat2, Size size, double d, double d2, int i) {
        Size size2 = size;
        GaussianBlur_0(mat.nativeObj, mat2.nativeObj, size2.width, size2.height, d, d2, i);
    }

    public static void GaussianBlur(Mat mat, Mat mat2, Size size, double d, double d2) {
        Size size2 = size;
        GaussianBlur_1(mat.nativeObj, mat2.nativeObj, size2.width, size2.height, d, d2);
    }

    public static void GaussianBlur(Mat mat, Mat mat2, Size size, double d) {
        GaussianBlur_2(mat.nativeObj, mat2.nativeObj, size.width, size.height, d);
    }

    public static void HoughCircles(Mat mat, Mat mat2, int i, double d, double d2, double d3, double d4, int i2, int i3) {
        HoughCircles_0(mat.nativeObj, mat2.nativeObj, i, d, d2, d3, d4, i2, i3);
    }

    public static void HoughCircles(Mat mat, Mat mat2, int i, double d, double d2, double d3, double d4, int i2) {
        HoughCircles_1(mat.nativeObj, mat2.nativeObj, i, d, d2, d3, d4, i2);
    }

    public static void HoughCircles(Mat mat, Mat mat2, int i, double d, double d2, double d3, double d4) {
        HoughCircles_2(mat.nativeObj, mat2.nativeObj, i, d, d2, d3, d4);
    }

    public static void HoughCircles(Mat mat, Mat mat2, int i, double d, double d2, double d3) {
        HoughCircles_3(mat.nativeObj, mat2.nativeObj, i, d, d2, d3);
    }

    public static void HoughCircles(Mat mat, Mat mat2, int i, double d, double d2) {
        HoughCircles_4(mat.nativeObj, mat2.nativeObj, i, d, d2);
    }

    public static void HoughLines(Mat mat, Mat mat2, double d, double d2, int i, double d3, double d4, double d5, double d6) {
        HoughLines_0(mat.nativeObj, mat2.nativeObj, d, d2, i, d3, d4, d5, d6);
    }

    public static void HoughLines(Mat mat, Mat mat2, double d, double d2, int i, double d3, double d4, double d5) {
        HoughLines_1(mat.nativeObj, mat2.nativeObj, d, d2, i, d3, d4, d5);
    }

    public static void HoughLines(Mat mat, Mat mat2, double d, double d2, int i, double d3, double d4) {
        HoughLines_2(mat.nativeObj, mat2.nativeObj, d, d2, i, d3, d4);
    }

    public static void HoughLines(Mat mat, Mat mat2, double d, double d2, int i, double d3) {
        HoughLines_3(mat.nativeObj, mat2.nativeObj, d, d2, i, d3);
    }

    public static void HoughLines(Mat mat, Mat mat2, double d, double d2, int i) {
        HoughLines_4(mat.nativeObj, mat2.nativeObj, d, d2, i);
    }

    public static void HoughLinesP(Mat mat, Mat mat2, double d, double d2, int i, double d3, double d4) {
        HoughLinesP_0(mat.nativeObj, mat2.nativeObj, d, d2, i, d3, d4);
    }

    public static void HoughLinesP(Mat mat, Mat mat2, double d, double d2, int i, double d3) {
        HoughLinesP_1(mat.nativeObj, mat2.nativeObj, d, d2, i, d3);
    }

    public static void HoughLinesP(Mat mat, Mat mat2, double d, double d2, int i) {
        HoughLinesP_2(mat.nativeObj, mat2.nativeObj, d, d2, i);
    }

    public static void HoughLinesPointSet(Mat mat, Mat mat2, int i, int i2, double d, double d2, double d3, double d4, double d5, double d6) {
        HoughLinesPointSet_0(mat.nativeObj, mat2.nativeObj, i, i2, d, d2, d3, d4, d5, d6);
    }

    public static void HuMoments(jln jln, Mat mat) {
        jln jln2 = jln;
        HuMoments_0(jln2.f1925O000000o, jln2.O00000Oo, jln2.O00000o0, jln2.O00000o, jln2.O00000oO, jln2.O00000oo, jln2.O0000O0o, jln2.O0000OOo, jln2.O0000Oo0, jln2.O0000Oo, mat.nativeObj);
    }

    public static void Laplacian(Mat mat, Mat mat2, int i, int i2, double d, double d2, int i3) {
        Laplacian_0(mat.nativeObj, mat2.nativeObj, i, i2, d, d2, i3);
    }

    public static void Laplacian(Mat mat, Mat mat2, int i, int i2, double d, double d2) {
        Laplacian_1(mat.nativeObj, mat2.nativeObj, i, i2, d, d2);
    }

    public static void Laplacian(Mat mat, Mat mat2, int i, int i2, double d) {
        Laplacian_2(mat.nativeObj, mat2.nativeObj, i, i2, d);
    }

    public static void Laplacian(Mat mat, Mat mat2, int i, int i2) {
        Laplacian_3(mat.nativeObj, mat2.nativeObj, i, i2);
    }

    public static void Laplacian(Mat mat, Mat mat2, int i) {
        Laplacian_4(mat.nativeObj, mat2.nativeObj, i);
    }

    public static void Scharr(Mat mat, Mat mat2, int i, int i2, int i3, double d, double d2, int i4) {
        Scharr_0(mat.nativeObj, mat2.nativeObj, i, i2, i3, d, d2, i4);
    }

    public static void Scharr(Mat mat, Mat mat2, int i, int i2, int i3, double d, double d2) {
        Scharr_1(mat.nativeObj, mat2.nativeObj, i, i2, i3, d, d2);
    }

    public static void Scharr(Mat mat, Mat mat2, int i, int i2, int i3, double d) {
        Scharr_2(mat.nativeObj, mat2.nativeObj, i, i2, i3, d);
    }

    public static void Scharr(Mat mat, Mat mat2, int i, int i2, int i3) {
        Scharr_3(mat.nativeObj, mat2.nativeObj, i, i2, i3);
    }

    public static void Sobel(Mat mat, Mat mat2, int i, int i2, int i3, int i4, double d, double d2, int i5) {
        Sobel_0(mat.nativeObj, mat2.nativeObj, i, i2, i3, i4, d, d2, i5);
    }

    public static void Sobel(Mat mat, Mat mat2, int i, int i2, int i3, int i4, double d, double d2) {
        Sobel_1(mat.nativeObj, mat2.nativeObj, i, i2, i3, i4, d, d2);
    }

    public static void Sobel(Mat mat, Mat mat2, int i, int i2, int i3, int i4, double d) {
        Sobel_2(mat.nativeObj, mat2.nativeObj, i, i2, i3, i4, d);
    }

    public static void Sobel(Mat mat, Mat mat2, int i, int i2, int i3, int i4) {
        Sobel_3(mat.nativeObj, mat2.nativeObj, i, i2, i3, i4);
    }

    public static void Sobel(Mat mat, Mat mat2, int i, int i2, int i3) {
        Sobel_4(mat.nativeObj, mat2.nativeObj, i, i2, i3);
    }

    public static void accumulate(Mat mat, Mat mat2, Mat mat3) {
        accumulate_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void accumulate(Mat mat, Mat mat2) {
        accumulate_1(mat.nativeObj, mat2.nativeObj);
    }

    public static void accumulateProduct(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        accumulateProduct_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static void accumulateProduct(Mat mat, Mat mat2, Mat mat3) {
        accumulateProduct_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void accumulateSquare(Mat mat, Mat mat2, Mat mat3) {
        accumulateSquare_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void accumulateSquare(Mat mat, Mat mat2) {
        accumulateSquare_1(mat.nativeObj, mat2.nativeObj);
    }

    public static void accumulateWeighted(Mat mat, Mat mat2, double d, Mat mat3) {
        accumulateWeighted_0(mat.nativeObj, mat2.nativeObj, d, mat3.nativeObj);
    }

    public static void accumulateWeighted(Mat mat, Mat mat2, double d) {
        accumulateWeighted_1(mat.nativeObj, mat2.nativeObj, d);
    }

    public static void adaptiveThreshold(Mat mat, Mat mat2, double d, int i, int i2, int i3, double d2) {
        adaptiveThreshold_0(mat.nativeObj, mat2.nativeObj, d, i, i2, i3, d2);
    }

    public static void applyColorMap(Mat mat, Mat mat2, Mat mat3) {
        applyColorMap_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void applyColorMap(Mat mat, Mat mat2, int i) {
        applyColorMap_1(mat.nativeObj, mat2.nativeObj, i);
    }

    public static void approxPolyDP(MatOfPoint2f matOfPoint2f, MatOfPoint2f matOfPoint2f2, double d, boolean z) {
        approxPolyDP_0(matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj, d, z);
    }

    public static void arrowedLine(Mat mat, Point point, Point point2, Scalar scalar, int i, int i2, int i3, double d) {
        Point point3 = point;
        Point point4 = point2;
        Scalar scalar2 = scalar;
        arrowedLine_0(mat.nativeObj, point3.x, point3.y, point4.x, point4.y, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], i, i2, i3, d);
    }

    public static void arrowedLine(Mat mat, Point point, Point point2, Scalar scalar, int i, int i2, int i3) {
        Point point3 = point;
        Point point4 = point2;
        Scalar scalar2 = scalar;
        arrowedLine_1(mat.nativeObj, point3.x, point3.y, point4.x, point4.y, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], i, i2, i3);
    }

    public static void arrowedLine(Mat mat, Point point, Point point2, Scalar scalar, int i, int i2) {
        Point point3 = point;
        Point point4 = point2;
        Scalar scalar2 = scalar;
        arrowedLine_2(mat.nativeObj, point3.x, point3.y, point4.x, point4.y, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], i, i2);
    }

    public static void arrowedLine(Mat mat, Point point, Point point2, Scalar scalar, int i) {
        Point point3 = point;
        Point point4 = point2;
        Scalar scalar2 = scalar;
        arrowedLine_3(mat.nativeObj, point3.x, point3.y, point4.x, point4.y, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], i);
    }

    public static void arrowedLine(Mat mat, Point point, Point point2, Scalar scalar) {
        Point point3 = point;
        Point point4 = point2;
        Scalar scalar2 = scalar;
        arrowedLine_4(mat.nativeObj, point3.x, point3.y, point4.x, point4.y, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3]);
    }

    public static void bilateralFilter(Mat mat, Mat mat2, int i, double d, double d2, int i2) {
        bilateralFilter_0(mat.nativeObj, mat2.nativeObj, i, d, d2, i2);
    }

    public static void bilateralFilter(Mat mat, Mat mat2, int i, double d, double d2) {
        bilateralFilter_1(mat.nativeObj, mat2.nativeObj, i, d, d2);
    }

    public static void blur(Mat mat, Mat mat2, Size size, Point point, int i) {
        Size size2 = size;
        Point point2 = point;
        blur_0(mat.nativeObj, mat2.nativeObj, size2.width, size2.height, point2.x, point2.y, i);
    }

    public static void blur(Mat mat, Mat mat2, Size size, Point point) {
        blur_1(mat.nativeObj, mat2.nativeObj, size.width, size.height, point.x, point.y);
    }

    public static void blur(Mat mat, Mat mat2, Size size) {
        blur_2(mat.nativeObj, mat2.nativeObj, size.width, size.height);
    }

    public static void boxFilter(Mat mat, Mat mat2, int i, Size size, Point point, boolean z, int i2) {
        Size size2 = size;
        Point point2 = point;
        boxFilter_0(mat.nativeObj, mat2.nativeObj, i, size2.width, size2.height, point2.x, point2.y, z, i2);
    }

    public static void boxFilter(Mat mat, Mat mat2, int i, Size size, Point point, boolean z) {
        Size size2 = size;
        Point point2 = point;
        boxFilter_1(mat.nativeObj, mat2.nativeObj, i, size2.width, size2.height, point2.x, point2.y, z);
    }

    public static void boxFilter(Mat mat, Mat mat2, int i, Size size, Point point) {
        Size size2 = size;
        Point point2 = point;
        boxFilter_2(mat.nativeObj, mat2.nativeObj, i, size2.width, size2.height, point2.x, point2.y);
    }

    public static void boxFilter(Mat mat, Mat mat2, int i, Size size) {
        boxFilter_3(mat.nativeObj, mat2.nativeObj, i, size.width, size.height);
    }

    public static void boxPoints(RotatedRect rotatedRect, Mat mat) {
        boxPoints_0(rotatedRect.center.x, rotatedRect.center.y, rotatedRect.size.width, rotatedRect.size.height, rotatedRect.angle, mat.nativeObj);
    }

    public static void calcBackProject(List<Mat> list, MatOfInt matOfInt, Mat mat, Mat mat2, MatOfFloat matOfFloat, double d) {
        calcBackProject_0(jlo.O000000o(list).nativeObj, matOfInt.nativeObj, mat.nativeObj, mat2.nativeObj, matOfFloat.nativeObj, d);
    }

    public static void calcHist(List<Mat> list, MatOfInt matOfInt, Mat mat, Mat mat2, MatOfInt matOfInt2, MatOfFloat matOfFloat, boolean z) {
        calcHist_0(jlo.O000000o(list).nativeObj, matOfInt.nativeObj, mat.nativeObj, mat2.nativeObj, matOfInt2.nativeObj, matOfFloat.nativeObj, z);
    }

    public static void calcHist(List<Mat> list, MatOfInt matOfInt, Mat mat, Mat mat2, MatOfInt matOfInt2, MatOfFloat matOfFloat) {
        calcHist_1(jlo.O000000o(list).nativeObj, matOfInt.nativeObj, mat.nativeObj, mat2.nativeObj, matOfInt2.nativeObj, matOfFloat.nativeObj);
    }

    public static void circle(Mat mat, Point point, int i, Scalar scalar, int i2, int i3, int i4) {
        Point point2 = point;
        Scalar scalar2 = scalar;
        circle_0(mat.nativeObj, point2.x, point2.y, i, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], i2, i3, i4);
    }

    public static void circle(Mat mat, Point point, int i, Scalar scalar, int i2, int i3) {
        Point point2 = point;
        Scalar scalar2 = scalar;
        circle_1(mat.nativeObj, point2.x, point2.y, i, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], i2, i3);
    }

    public static void circle(Mat mat, Point point, int i, Scalar scalar, int i2) {
        Point point2 = point;
        Scalar scalar2 = scalar;
        circle_2(mat.nativeObj, point2.x, point2.y, i, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], i2);
    }

    public static void circle(Mat mat, Point point, int i, Scalar scalar) {
        Point point2 = point;
        Scalar scalar2 = scalar;
        circle_3(mat.nativeObj, point2.x, point2.y, i, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3]);
    }

    public static void convertMaps(Mat mat, Mat mat2, Mat mat3, Mat mat4, int i, boolean z) {
        convertMaps_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, i, z);
    }

    public static void convertMaps(Mat mat, Mat mat2, Mat mat3, Mat mat4, int i) {
        convertMaps_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, i);
    }

    public static void convexHull(MatOfPoint matOfPoint, MatOfInt matOfInt, boolean z) {
        convexHull_0(matOfPoint.nativeObj, matOfInt.nativeObj, z);
    }

    public static void convexHull(MatOfPoint matOfPoint, MatOfInt matOfInt) {
        convexHull_2(matOfPoint.nativeObj, matOfInt.nativeObj);
    }

    public static void convexityDefects(MatOfPoint matOfPoint, MatOfInt matOfInt, MatOfInt4 matOfInt4) {
        convexityDefects_0(matOfPoint.nativeObj, matOfInt.nativeObj, matOfInt4.nativeObj);
    }

    public static void cornerEigenValsAndVecs(Mat mat, Mat mat2, int i, int i2, int i3) {
        cornerEigenValsAndVecs_0(mat.nativeObj, mat2.nativeObj, i, i2, i3);
    }

    public static void cornerEigenValsAndVecs(Mat mat, Mat mat2, int i, int i2) {
        cornerEigenValsAndVecs_1(mat.nativeObj, mat2.nativeObj, i, i2);
    }

    public static void cornerHarris(Mat mat, Mat mat2, int i, int i2, double d, int i3) {
        cornerHarris_0(mat.nativeObj, mat2.nativeObj, i, i2, d, i3);
    }

    public static void cornerHarris(Mat mat, Mat mat2, int i, int i2, double d) {
        cornerHarris_1(mat.nativeObj, mat2.nativeObj, i, i2, d);
    }

    public static void cornerMinEigenVal(Mat mat, Mat mat2, int i, int i2, int i3) {
        cornerMinEigenVal_0(mat.nativeObj, mat2.nativeObj, i, i2, i3);
    }

    public static void cornerMinEigenVal(Mat mat, Mat mat2, int i, int i2) {
        cornerMinEigenVal_1(mat.nativeObj, mat2.nativeObj, i, i2);
    }

    public static void cornerMinEigenVal(Mat mat, Mat mat2, int i) {
        cornerMinEigenVal_2(mat.nativeObj, mat2.nativeObj, i);
    }

    public static void cornerSubPix(Mat mat, Mat mat2, Size size, Size size2, TermCriteria termCriteria) {
        Size size3 = size;
        Size size4 = size2;
        TermCriteria termCriteria2 = termCriteria;
        long j = mat.nativeObj;
        long j2 = mat2.nativeObj;
        double d = size3.width;
        double d2 = size3.height;
        double d3 = size4.width;
        double d4 = size4.height;
        int i = termCriteria2.type;
        int i2 = termCriteria2.maxCount;
        int i3 = i;
        cornerSubPix_0(j, j2, d, d2, d3, d4, i3, i2, termCriteria2.epsilon);
    }

    public static void createHanningWindow(Mat mat, Size size, int i) {
        createHanningWindow_0(mat.nativeObj, size.width, size.height, i);
    }

    public static void cvtColor(Mat mat, Mat mat2, int i, int i2) {
        cvtColor_0(mat.nativeObj, mat2.nativeObj, i, i2);
    }

    public static void cvtColor(Mat mat, Mat mat2, int i) {
        cvtColor_1(mat.nativeObj, mat2.nativeObj, i);
    }

    public static void cvtColorTwoPlane(Mat mat, Mat mat2, Mat mat3, int i) {
        cvtColorTwoPlane_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i);
    }

    public static void demosaicing(Mat mat, Mat mat2, int i, int i2) {
        demosaicing_0(mat.nativeObj, mat2.nativeObj, i, i2);
    }

    public static void demosaicing(Mat mat, Mat mat2, int i) {
        demosaicing_1(mat.nativeObj, mat2.nativeObj, i);
    }

    public static void dilate(Mat mat, Mat mat2, Mat mat3, Point point, int i, int i2, Scalar scalar) {
        Point point2 = point;
        Scalar scalar2 = scalar;
        dilate_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, point2.x, point2.y, i, i2, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3]);
    }

    public static void dilate(Mat mat, Mat mat2, Mat mat3, Point point, int i, int i2) {
        Point point2 = point;
        dilate_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, point2.x, point2.y, i, i2);
    }

    public static void dilate(Mat mat, Mat mat2, Mat mat3, Point point, int i) {
        dilate_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, point.x, point.y, i);
    }

    public static void dilate(Mat mat, Mat mat2, Mat mat3, Point point) {
        dilate_3(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, point.x, point.y);
    }

    public static void dilate(Mat mat, Mat mat2, Mat mat3) {
        dilate_4(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void distanceTransformWithLabels(Mat mat, Mat mat2, Mat mat3, int i, int i2, int i3) {
        distanceTransformWithLabels_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i, i2, i3);
    }

    public static void distanceTransformWithLabels(Mat mat, Mat mat2, Mat mat3, int i, int i2) {
        distanceTransformWithLabels_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i, i2);
    }

    public static void distanceTransform(Mat mat, Mat mat2, int i, int i2, int i3) {
        distanceTransform_0(mat.nativeObj, mat2.nativeObj, i, i2, i3);
    }

    public static void distanceTransform(Mat mat, Mat mat2, int i, int i2) {
        distanceTransform_1(mat.nativeObj, mat2.nativeObj, i, i2);
    }

    public static void drawContours(Mat mat, List<MatOfPoint> list, int i, Scalar scalar, int i2, int i3, Mat mat2, int i4, Point point) {
        List<MatOfPoint> list2 = list;
        Scalar scalar2 = scalar;
        Point point2 = point;
        drawContours_0(mat.nativeObj, jlo.O000000o(list2, new ArrayList(list2 != null ? list.size() : 0)).nativeObj, i, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], i2, i3, mat2.nativeObj, i4, point2.x, point2.y);
    }

    public static void drawContours(Mat mat, List<MatOfPoint> list, int i, Scalar scalar, int i2, int i3, Mat mat2, int i4) {
        List<MatOfPoint> list2 = list;
        Scalar scalar2 = scalar;
        drawContours_1(mat.nativeObj, jlo.O000000o(list2, new ArrayList(list2 != null ? list.size() : 0)).nativeObj, i, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], i2, i3, mat2.nativeObj, i4);
    }

    public static void drawContours(Mat mat, List<MatOfPoint> list, int i, Scalar scalar, int i2, int i3, Mat mat2) {
        List<MatOfPoint> list2 = list;
        Scalar scalar2 = scalar;
        drawContours_2(mat.nativeObj, jlo.O000000o(list2, new ArrayList(list2 != null ? list.size() : 0)).nativeObj, i, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], i2, i3, mat2.nativeObj);
    }

    public static void drawContours(Mat mat, List<MatOfPoint> list, int i, Scalar scalar, int i2, int i3) {
        List<MatOfPoint> list2 = list;
        Scalar scalar2 = scalar;
        drawContours_3(mat.nativeObj, jlo.O000000o(list2, new ArrayList(list2 != null ? list.size() : 0)).nativeObj, i, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], i2, i3);
    }

    public static void drawContours(Mat mat, List<MatOfPoint> list, int i, Scalar scalar, int i2) {
        List<MatOfPoint> list2 = list;
        Scalar scalar2 = scalar;
        drawContours_4(mat.nativeObj, jlo.O000000o(list2, new ArrayList(list2 != null ? list.size() : 0)).nativeObj, i, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], i2);
    }

    public static void drawContours(Mat mat, List<MatOfPoint> list, int i, Scalar scalar) {
        List<MatOfPoint> list2 = list;
        Scalar scalar2 = scalar;
        drawContours_5(mat.nativeObj, jlo.O000000o(list2, new ArrayList(list2 != null ? list.size() : 0)).nativeObj, i, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3]);
    }

    public static void drawMarker(Mat mat, Point point, Scalar scalar, int i, int i2, int i3, int i4) {
        Point point2 = point;
        Scalar scalar2 = scalar;
        drawMarker_0(mat.nativeObj, point2.x, point2.y, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], i, i2, i3, i4);
    }

    public static void drawMarker(Mat mat, Point point, Scalar scalar, int i, int i2, int i3) {
        Point point2 = point;
        Scalar scalar2 = scalar;
        drawMarker_1(mat.nativeObj, point2.x, point2.y, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], i, i2, i3);
    }

    public static void drawMarker(Mat mat, Point point, Scalar scalar, int i, int i2) {
        Point point2 = point;
        Scalar scalar2 = scalar;
        drawMarker_2(mat.nativeObj, point2.x, point2.y, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], i, i2);
    }

    public static void drawMarker(Mat mat, Point point, Scalar scalar, int i) {
        Point point2 = point;
        Scalar scalar2 = scalar;
        drawMarker_3(mat.nativeObj, point2.x, point2.y, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], i);
    }

    public static void drawMarker(Mat mat, Point point, Scalar scalar) {
        Point point2 = point;
        Scalar scalar2 = scalar;
        drawMarker_4(mat.nativeObj, point2.x, point2.y, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3]);
    }

    public static void ellipse(Mat mat, Point point, Size size, double d, double d2, double d3, Scalar scalar, int i, int i2, int i3) {
        Point point2 = point;
        Size size2 = size;
        Scalar scalar2 = scalar;
        ellipse_0(mat.nativeObj, point2.x, point2.y, size2.width, size2.height, d, d2, d3, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], i, i2, i3);
    }

    public static void ellipse(Mat mat, Point point, Size size, double d, double d2, double d3, Scalar scalar, int i, int i2) {
        Point point2 = point;
        Size size2 = size;
        Scalar scalar2 = scalar;
        ellipse_1(mat.nativeObj, point2.x, point2.y, size2.width, size2.height, d, d2, d3, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], i, i2);
    }

    public static void ellipse(Mat mat, Point point, Size size, double d, double d2, double d3, Scalar scalar, int i) {
        Point point2 = point;
        Size size2 = size;
        Scalar scalar2 = scalar;
        ellipse_2(mat.nativeObj, point2.x, point2.y, size2.width, size2.height, d, d2, d3, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], i);
    }

    public static void ellipse(Mat mat, Point point, Size size, double d, double d2, double d3, Scalar scalar) {
        Point point2 = point;
        Size size2 = size;
        Scalar scalar2 = scalar;
        ellipse_3(mat.nativeObj, point2.x, point2.y, size2.width, size2.height, d, d2, d3, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3]);
    }

    public static void ellipse(Mat mat, RotatedRect rotatedRect, Scalar scalar, int i, int i2) {
        RotatedRect rotatedRect2 = rotatedRect;
        Scalar scalar2 = scalar;
        ellipse_4(mat.nativeObj, rotatedRect2.center.x, rotatedRect2.center.y, rotatedRect2.size.width, rotatedRect2.size.height, rotatedRect2.angle, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], i, i2);
    }

    public static void ellipse(Mat mat, RotatedRect rotatedRect, Scalar scalar, int i) {
        RotatedRect rotatedRect2 = rotatedRect;
        Scalar scalar2 = scalar;
        ellipse_5(mat.nativeObj, rotatedRect2.center.x, rotatedRect2.center.y, rotatedRect2.size.width, rotatedRect2.size.height, rotatedRect2.angle, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], i);
    }

    public static void ellipse(Mat mat, RotatedRect rotatedRect, Scalar scalar) {
        RotatedRect rotatedRect2 = rotatedRect;
        Scalar scalar2 = scalar;
        ellipse_6(mat.nativeObj, rotatedRect2.center.x, rotatedRect2.center.y, rotatedRect2.size.width, rotatedRect2.size.height, rotatedRect2.angle, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3]);
    }

    public static void ellipse2Poly(Point point, Size size, int i, int i2, int i3, int i4, MatOfPoint matOfPoint) {
        Point point2 = point;
        Size size2 = size;
        ellipse2Poly_0(point2.x, point2.y, size2.width, size2.height, i, i2, i3, i4, matOfPoint.nativeObj);
    }

    public static void equalizeHist(Mat mat, Mat mat2) {
        equalizeHist_0(mat.nativeObj, mat2.nativeObj);
    }

    public static void erode(Mat mat, Mat mat2, Mat mat3, Point point, int i, int i2, Scalar scalar) {
        Point point2 = point;
        Scalar scalar2 = scalar;
        erode_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, point2.x, point2.y, i, i2, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3]);
    }

    public static void erode(Mat mat, Mat mat2, Mat mat3, Point point, int i, int i2) {
        Point point2 = point;
        erode_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, point2.x, point2.y, i, i2);
    }

    public static void erode(Mat mat, Mat mat2, Mat mat3, Point point, int i) {
        erode_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, point.x, point.y, i);
    }

    public static void erode(Mat mat, Mat mat2, Mat mat3, Point point) {
        erode_3(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, point.x, point.y);
    }

    public static void erode(Mat mat, Mat mat2, Mat mat3) {
        erode_4(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void fillConvexPoly(Mat mat, MatOfPoint matOfPoint, Scalar scalar, int i, int i2) {
        Scalar scalar2 = scalar;
        fillConvexPoly_0(mat.nativeObj, matOfPoint.nativeObj, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], i, i2);
    }

    public static void fillConvexPoly(Mat mat, MatOfPoint matOfPoint, Scalar scalar, int i) {
        Scalar scalar2 = scalar;
        fillConvexPoly_1(mat.nativeObj, matOfPoint.nativeObj, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], i);
    }

    public static void fillConvexPoly(Mat mat, MatOfPoint matOfPoint, Scalar scalar) {
        fillConvexPoly_2(mat.nativeObj, matOfPoint.nativeObj, scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3]);
    }

    public static void fillPoly(Mat mat, List<MatOfPoint> list, Scalar scalar, int i, int i2, Point point) {
        List<MatOfPoint> list2 = list;
        Scalar scalar2 = scalar;
        Point point2 = point;
        fillPoly_0(mat.nativeObj, jlo.O000000o(list2, new ArrayList(list2 != null ? list.size() : 0)).nativeObj, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], i, i2, point2.x, point2.y);
    }

    public static void fillPoly(Mat mat, List<MatOfPoint> list, Scalar scalar, int i, int i2) {
        List<MatOfPoint> list2 = list;
        Scalar scalar2 = scalar;
        fillPoly_1(mat.nativeObj, jlo.O000000o(list2, new ArrayList(list2 != null ? list.size() : 0)).nativeObj, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], i, i2);
    }

    public static void fillPoly(Mat mat, List<MatOfPoint> list, Scalar scalar, int i) {
        List<MatOfPoint> list2 = list;
        Scalar scalar2 = scalar;
        fillPoly_2(mat.nativeObj, jlo.O000000o(list2, new ArrayList(list2 != null ? list.size() : 0)).nativeObj, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], i);
    }

    public static void fillPoly(Mat mat, List<MatOfPoint> list, Scalar scalar) {
        List<MatOfPoint> list2 = list;
        Scalar scalar2 = scalar;
        fillPoly_3(mat.nativeObj, jlo.O000000o(list2, new ArrayList(list2 != null ? list.size() : 0)).nativeObj, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3]);
    }

    public static void filter2D(Mat mat, Mat mat2, int i, Mat mat3, Point point, double d, int i2) {
        Point point2 = point;
        filter2D_0(mat.nativeObj, mat2.nativeObj, i, mat3.nativeObj, point2.x, point2.y, d, i2);
    }

    public static void filter2D(Mat mat, Mat mat2, int i, Mat mat3, Point point, double d) {
        Point point2 = point;
        filter2D_1(mat.nativeObj, mat2.nativeObj, i, mat3.nativeObj, point2.x, point2.y, d);
    }

    public static void filter2D(Mat mat, Mat mat2, int i, Mat mat3, Point point) {
        filter2D_2(mat.nativeObj, mat2.nativeObj, i, mat3.nativeObj, point.x, point.y);
    }

    public static void filter2D(Mat mat, Mat mat2, int i, Mat mat3) {
        filter2D_3(mat.nativeObj, mat2.nativeObj, i, mat3.nativeObj);
    }

    public static void findContours(Mat mat, List<MatOfPoint> list, Mat mat2, int i, int i2, Point point) {
        Point point2 = point;
        Mat mat3 = new Mat();
        findContours_0(mat.nativeObj, mat3.nativeObj, mat2.nativeObj, i, i2, point2.x, point2.y);
        jlo.O00000Oo(mat3, list);
        mat3.release();
    }

    public static void findContours(Mat mat, List<MatOfPoint> list, Mat mat2, int i, int i2) {
        Mat mat3 = new Mat();
        findContours_1(mat.nativeObj, mat3.nativeObj, mat2.nativeObj, i, i2);
        jlo.O00000Oo(mat3, list);
        mat3.release();
    }

    public static void fitLine(Mat mat, Mat mat2, int i, double d, double d2, double d3) {
        fitLine_0(mat.nativeObj, mat2.nativeObj, i, d, d2, d3);
    }

    public static void getDerivKernels(Mat mat, Mat mat2, int i, int i2, int i3, boolean z, int i4) {
        getDerivKernels_0(mat.nativeObj, mat2.nativeObj, i, i2, i3, z, i4);
    }

    public static void getDerivKernels(Mat mat, Mat mat2, int i, int i2, int i3, boolean z) {
        getDerivKernels_1(mat.nativeObj, mat2.nativeObj, i, i2, i3, z);
    }

    public static void getDerivKernels(Mat mat, Mat mat2, int i, int i2, int i3) {
        getDerivKernels_2(mat.nativeObj, mat2.nativeObj, i, i2, i3);
    }

    public static void getRectSubPix(Mat mat, Size size, Point point, Mat mat2, int i) {
        Size size2 = size;
        Point point2 = point;
        getRectSubPix_0(mat.nativeObj, size2.width, size2.height, point2.x, point2.y, mat2.nativeObj, i);
    }

    public static void getRectSubPix(Mat mat, Size size, Point point, Mat mat2) {
        getRectSubPix_1(mat.nativeObj, size.width, size.height, point.x, point.y, mat2.nativeObj);
    }

    public static void goodFeaturesToTrack(Mat mat, MatOfPoint matOfPoint, int i, double d, double d2, Mat mat2, int i2, int i3, boolean z, double d3) {
        goodFeaturesToTrack_0(mat.nativeObj, matOfPoint.nativeObj, i, d, d2, mat2.nativeObj, i2, i3, z, d3);
    }

    public static void goodFeaturesToTrack(Mat mat, MatOfPoint matOfPoint, int i, double d, double d2, Mat mat2, int i2, int i3, boolean z) {
        goodFeaturesToTrack_1(mat.nativeObj, matOfPoint.nativeObj, i, d, d2, mat2.nativeObj, i2, i3, z);
    }

    public static void goodFeaturesToTrack(Mat mat, MatOfPoint matOfPoint, int i, double d, double d2, Mat mat2, int i2, int i3) {
        goodFeaturesToTrack_2(mat.nativeObj, matOfPoint.nativeObj, i, d, d2, mat2.nativeObj, i2, i3);
    }

    public static void goodFeaturesToTrack(Mat mat, MatOfPoint matOfPoint, int i, double d, double d2, Mat mat2, int i2, boolean z, double d3) {
        goodFeaturesToTrack_3(mat.nativeObj, matOfPoint.nativeObj, i, d, d2, mat2.nativeObj, i2, z, d3);
    }

    public static void goodFeaturesToTrack(Mat mat, MatOfPoint matOfPoint, int i, double d, double d2, Mat mat2, int i2, boolean z) {
        goodFeaturesToTrack_4(mat.nativeObj, matOfPoint.nativeObj, i, d, d2, mat2.nativeObj, i2, z);
    }

    public static void goodFeaturesToTrack(Mat mat, MatOfPoint matOfPoint, int i, double d, double d2, Mat mat2, int i2) {
        goodFeaturesToTrack_5(mat.nativeObj, matOfPoint.nativeObj, i, d, d2, mat2.nativeObj, i2);
    }

    public static void goodFeaturesToTrack(Mat mat, MatOfPoint matOfPoint, int i, double d, double d2, Mat mat2) {
        goodFeaturesToTrack_6(mat.nativeObj, matOfPoint.nativeObj, i, d, d2, mat2.nativeObj);
    }

    public static void goodFeaturesToTrack(Mat mat, MatOfPoint matOfPoint, int i, double d, double d2) {
        goodFeaturesToTrack_7(mat.nativeObj, matOfPoint.nativeObj, i, d, d2);
    }

    public static void grabCut(Mat mat, Mat mat2, Rect rect, Mat mat3, Mat mat4, int i, int i2) {
        Rect rect2 = rect;
        grabCut_0(mat.nativeObj, mat2.nativeObj, rect2.x, rect2.y, rect2.width, rect2.height, mat3.nativeObj, mat4.nativeObj, i, i2);
    }

    public static void grabCut(Mat mat, Mat mat2, Rect rect, Mat mat3, Mat mat4, int i) {
        Rect rect2 = rect;
        grabCut_1(mat.nativeObj, mat2.nativeObj, rect2.x, rect2.y, rect2.width, rect2.height, mat3.nativeObj, mat4.nativeObj, i);
    }

    public static void initUndistortRectifyMap(Mat mat, Mat mat2, Mat mat3, Mat mat4, Size size, int i, Mat mat5, Mat mat6) {
        Size size2 = size;
        long j = mat.nativeObj;
        long j2 = j;
        initUndistortRectifyMap_0(j2, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size2.width, size2.height, i, mat5.nativeObj, mat6.nativeObj);
    }

    public static void integral3(Mat mat, Mat mat2, Mat mat3, Mat mat4, int i, int i2) {
        integral3_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, i, i2);
    }

    public static void integral3(Mat mat, Mat mat2, Mat mat3, Mat mat4, int i) {
        integral3_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, i);
    }

    public static void integral3(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        integral3_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static void integral2(Mat mat, Mat mat2, Mat mat3, int i, int i2) {
        integral2_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i, i2);
    }

    public static void integral2(Mat mat, Mat mat2, Mat mat3, int i) {
        integral2_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i);
    }

    public static void integral2(Mat mat, Mat mat2, Mat mat3) {
        integral2_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void integral(Mat mat, Mat mat2, int i) {
        integral_0(mat.nativeObj, mat2.nativeObj, i);
    }

    public static void integral(Mat mat, Mat mat2) {
        integral_1(mat.nativeObj, mat2.nativeObj);
    }

    public static void invertAffineTransform(Mat mat, Mat mat2) {
        invertAffineTransform_0(mat.nativeObj, mat2.nativeObj);
    }

    public static void line(Mat mat, Point point, Point point2, Scalar scalar, int i, int i2, int i3) {
        Point point3 = point;
        Point point4 = point2;
        Scalar scalar2 = scalar;
        line_0(mat.nativeObj, point3.x, point3.y, point4.x, point4.y, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], i, i2, i3);
    }

    public static void line(Mat mat, Point point, Point point2, Scalar scalar, int i, int i2) {
        Point point3 = point;
        Point point4 = point2;
        Scalar scalar2 = scalar;
        line_1(mat.nativeObj, point3.x, point3.y, point4.x, point4.y, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], i, i2);
    }

    public static void line(Mat mat, Point point, Point point2, Scalar scalar, int i) {
        Point point3 = point;
        Point point4 = point2;
        Scalar scalar2 = scalar;
        line_2(mat.nativeObj, point3.x, point3.y, point4.x, point4.y, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], i);
    }

    public static void line(Mat mat, Point point, Point point2, Scalar scalar) {
        Point point3 = point;
        Point point4 = point2;
        Scalar scalar2 = scalar;
        line_3(mat.nativeObj, point3.x, point3.y, point4.x, point4.y, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3]);
    }

    @Deprecated
    public static void linearPolar(Mat mat, Mat mat2, Point point, double d, int i) {
        Point point2 = point;
        linearPolar_0(mat.nativeObj, mat2.nativeObj, point2.x, point2.y, d, i);
    }

    @Deprecated
    public static void logPolar(Mat mat, Mat mat2, Point point, double d, int i) {
        Point point2 = point;
        logPolar_0(mat.nativeObj, mat2.nativeObj, point2.x, point2.y, d, i);
    }

    public static void matchTemplate(Mat mat, Mat mat2, Mat mat3, int i, Mat mat4) {
        matchTemplate_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i, mat4.nativeObj);
    }

    public static void matchTemplate(Mat mat, Mat mat2, Mat mat3, int i) {
        matchTemplate_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i);
    }

    public static void medianBlur(Mat mat, Mat mat2, int i) {
        medianBlur_0(mat.nativeObj, mat2.nativeObj, i);
    }

    public static void minEnclosingCircle(MatOfPoint2f matOfPoint2f, Point point, float[] fArr) {
        double[] dArr = new double[2];
        double[] dArr2 = new double[1];
        minEnclosingCircle_0(matOfPoint2f.nativeObj, dArr, dArr2);
        if (point != null) {
            point.x = dArr[0];
            point.y = dArr[1];
        }
        if (fArr != null) {
            fArr[0] = (float) dArr2[0];
        }
    }

    public static void morphologyEx(Mat mat, Mat mat2, int i, Mat mat3, Point point, int i2, int i3, Scalar scalar) {
        Point point2 = point;
        Scalar scalar2 = scalar;
        morphologyEx_0(mat.nativeObj, mat2.nativeObj, i, mat3.nativeObj, point2.x, point2.y, i2, i3, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3]);
    }

    public static void morphologyEx(Mat mat, Mat mat2, int i, Mat mat3, Point point, int i2, int i3) {
        Point point2 = point;
        morphologyEx_1(mat.nativeObj, mat2.nativeObj, i, mat3.nativeObj, point2.x, point2.y, i2, i3);
    }

    public static void morphologyEx(Mat mat, Mat mat2, int i, Mat mat3, Point point, int i2) {
        Point point2 = point;
        morphologyEx_2(mat.nativeObj, mat2.nativeObj, i, mat3.nativeObj, point2.x, point2.y, i2);
    }

    public static void morphologyEx(Mat mat, Mat mat2, int i, Mat mat3, Point point) {
        morphologyEx_3(mat.nativeObj, mat2.nativeObj, i, mat3.nativeObj, point.x, point.y);
    }

    public static void morphologyEx(Mat mat, Mat mat2, int i, Mat mat3) {
        morphologyEx_4(mat.nativeObj, mat2.nativeObj, i, mat3.nativeObj);
    }

    public static void polylines(Mat mat, List<MatOfPoint> list, boolean z, Scalar scalar, int i, int i2, int i3) {
        List<MatOfPoint> list2 = list;
        Scalar scalar2 = scalar;
        polylines_0(mat.nativeObj, jlo.O000000o(list2, new ArrayList(list2 != null ? list.size() : 0)).nativeObj, z, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], i, i2, i3);
    }

    public static void polylines(Mat mat, List<MatOfPoint> list, boolean z, Scalar scalar, int i, int i2) {
        List<MatOfPoint> list2 = list;
        Scalar scalar2 = scalar;
        polylines_1(mat.nativeObj, jlo.O000000o(list2, new ArrayList(list2 != null ? list.size() : 0)).nativeObj, z, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], i, i2);
    }

    public static void polylines(Mat mat, List<MatOfPoint> list, boolean z, Scalar scalar, int i) {
        List<MatOfPoint> list2 = list;
        Scalar scalar2 = scalar;
        polylines_2(mat.nativeObj, jlo.O000000o(list2, new ArrayList(list2 != null ? list.size() : 0)).nativeObj, z, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], i);
    }

    public static void polylines(Mat mat, List<MatOfPoint> list, boolean z, Scalar scalar) {
        List<MatOfPoint> list2 = list;
        Scalar scalar2 = scalar;
        polylines_3(mat.nativeObj, jlo.O000000o(list2, new ArrayList(list2 != null ? list.size() : 0)).nativeObj, z, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3]);
    }

    public static void preCornerDetect(Mat mat, Mat mat2, int i, int i2) {
        preCornerDetect_0(mat.nativeObj, mat2.nativeObj, i, i2);
    }

    public static void preCornerDetect(Mat mat, Mat mat2, int i) {
        preCornerDetect_1(mat.nativeObj, mat2.nativeObj, i);
    }

    public static void putText(Mat mat, String str, Point point, int i, double d, Scalar scalar, int i2, int i3, boolean z) {
        Point point2 = point;
        Scalar scalar2 = scalar;
        putText_0(mat.nativeObj, str, point2.x, point2.y, i, d, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], i2, i3, z);
    }

    public static void putText(Mat mat, String str, Point point, int i, double d, Scalar scalar, int i2, int i3) {
        Point point2 = point;
        Scalar scalar2 = scalar;
        putText_1(mat.nativeObj, str, point2.x, point2.y, i, d, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], i2, i3);
    }

    public static void putText(Mat mat, String str, Point point, int i, double d, Scalar scalar, int i2) {
        Point point2 = point;
        Scalar scalar2 = scalar;
        putText_2(mat.nativeObj, str, point2.x, point2.y, i, d, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], i2);
    }

    public static void putText(Mat mat, String str, Point point, int i, double d, Scalar scalar) {
        Point point2 = point;
        Scalar scalar2 = scalar;
        putText_3(mat.nativeObj, str, point2.x, point2.y, i, d, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3]);
    }

    public static void pyrDown(Mat mat, Mat mat2, Size size, int i) {
        pyrDown_0(mat.nativeObj, mat2.nativeObj, size.width, size.height, i);
    }

    public static void pyrDown(Mat mat, Mat mat2, Size size) {
        pyrDown_1(mat.nativeObj, mat2.nativeObj, size.width, size.height);
    }

    public static void pyrDown(Mat mat, Mat mat2) {
        pyrDown_2(mat.nativeObj, mat2.nativeObj);
    }

    public static void pyrMeanShiftFiltering(Mat mat, Mat mat2, double d, double d2, int i, TermCriteria termCriteria) {
        TermCriteria termCriteria2 = termCriteria;
        long j = mat.nativeObj;
        pyrMeanShiftFiltering_0(j, mat2.nativeObj, d, d2, i, termCriteria2.type, termCriteria2.maxCount, termCriteria2.epsilon);
    }

    public static void pyrMeanShiftFiltering(Mat mat, Mat mat2, double d, double d2, int i) {
        pyrMeanShiftFiltering_1(mat.nativeObj, mat2.nativeObj, d, d2, i);
    }

    public static void pyrMeanShiftFiltering(Mat mat, Mat mat2, double d, double d2) {
        pyrMeanShiftFiltering_2(mat.nativeObj, mat2.nativeObj, d, d2);
    }

    public static void pyrUp(Mat mat, Mat mat2, Size size, int i) {
        pyrUp_0(mat.nativeObj, mat2.nativeObj, size.width, size.height, i);
    }

    public static void pyrUp(Mat mat, Mat mat2, Size size) {
        pyrUp_1(mat.nativeObj, mat2.nativeObj, size.width, size.height);
    }

    public static void pyrUp(Mat mat, Mat mat2) {
        pyrUp_2(mat.nativeObj, mat2.nativeObj);
    }

    public static void rectangle(Mat mat, Point point, Point point2, Scalar scalar, int i, int i2, int i3) {
        Point point3 = point;
        Point point4 = point2;
        Scalar scalar2 = scalar;
        rectangle_0(mat.nativeObj, point3.x, point3.y, point4.x, point4.y, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], i, i2, i3);
    }

    public static void rectangle(Mat mat, Point point, Point point2, Scalar scalar, int i, int i2) {
        Point point3 = point;
        Point point4 = point2;
        Scalar scalar2 = scalar;
        rectangle_1(mat.nativeObj, point3.x, point3.y, point4.x, point4.y, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], i, i2);
    }

    public static void rectangle(Mat mat, Point point, Point point2, Scalar scalar, int i) {
        Point point3 = point;
        Point point4 = point2;
        Scalar scalar2 = scalar;
        rectangle_2(mat.nativeObj, point3.x, point3.y, point4.x, point4.y, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], i);
    }

    public static void rectangle(Mat mat, Point point, Point point2, Scalar scalar) {
        Point point3 = point;
        Point point4 = point2;
        Scalar scalar2 = scalar;
        rectangle_3(mat.nativeObj, point3.x, point3.y, point4.x, point4.y, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3]);
    }

    public static void remap(Mat mat, Mat mat2, Mat mat3, Mat mat4, int i, int i2, Scalar scalar) {
        Scalar scalar2 = scalar;
        remap_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, i, i2, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3]);
    }

    public static void remap(Mat mat, Mat mat2, Mat mat3, Mat mat4, int i, int i2) {
        remap_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, i, i2);
    }

    public static void remap(Mat mat, Mat mat2, Mat mat3, Mat mat4, int i) {
        remap_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, i);
    }

    public static void resize(Mat mat, Mat mat2, Size size, double d, double d2, int i) {
        Size size2 = size;
        resize_0(mat.nativeObj, mat2.nativeObj, size2.width, size2.height, d, d2, i);
    }

    public static void resize(Mat mat, Mat mat2, Size size, double d, double d2) {
        Size size2 = size;
        resize_1(mat.nativeObj, mat2.nativeObj, size2.width, size2.height, d, d2);
    }

    public static void resize(Mat mat, Mat mat2, Size size, double d) {
        resize_2(mat.nativeObj, mat2.nativeObj, size.width, size.height, d);
    }

    public static void resize(Mat mat, Mat mat2, Size size) {
        resize_3(mat.nativeObj, mat2.nativeObj, size.width, size.height);
    }

    public static void sepFilter2D(Mat mat, Mat mat2, int i, Mat mat3, Mat mat4, Point point, double d, int i2) {
        Point point2 = point;
        sepFilter2D_0(mat.nativeObj, mat2.nativeObj, i, mat3.nativeObj, mat4.nativeObj, point2.x, point2.y, d, i2);
    }

    public static void sepFilter2D(Mat mat, Mat mat2, int i, Mat mat3, Mat mat4, Point point, double d) {
        Point point2 = point;
        sepFilter2D_1(mat.nativeObj, mat2.nativeObj, i, mat3.nativeObj, mat4.nativeObj, point2.x, point2.y, d);
    }

    public static void sepFilter2D(Mat mat, Mat mat2, int i, Mat mat3, Mat mat4, Point point) {
        Point point2 = point;
        sepFilter2D_2(mat.nativeObj, mat2.nativeObj, i, mat3.nativeObj, mat4.nativeObj, point2.x, point2.y);
    }

    public static void sepFilter2D(Mat mat, Mat mat2, int i, Mat mat3, Mat mat4) {
        sepFilter2D_3(mat.nativeObj, mat2.nativeObj, i, mat3.nativeObj, mat4.nativeObj);
    }

    public static void spatialGradient(Mat mat, Mat mat2, Mat mat3, int i, int i2) {
        spatialGradient_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i, i2);
    }

    public static void spatialGradient(Mat mat, Mat mat2, Mat mat3, int i) {
        spatialGradient_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i);
    }

    public static void spatialGradient(Mat mat, Mat mat2, Mat mat3) {
        spatialGradient_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void sqrBoxFilter(Mat mat, Mat mat2, int i, Size size, Point point, boolean z, int i2) {
        Size size2 = size;
        Point point2 = point;
        sqrBoxFilter_0(mat.nativeObj, mat2.nativeObj, i, size2.width, size2.height, point2.x, point2.y, z, i2);
    }

    public static void sqrBoxFilter(Mat mat, Mat mat2, int i, Size size, Point point, boolean z) {
        Size size2 = size;
        Point point2 = point;
        sqrBoxFilter_1(mat.nativeObj, mat2.nativeObj, i, size2.width, size2.height, point2.x, point2.y, z);
    }

    public static void sqrBoxFilter(Mat mat, Mat mat2, int i, Size size, Point point) {
        Size size2 = size;
        Point point2 = point;
        sqrBoxFilter_2(mat.nativeObj, mat2.nativeObj, i, size2.width, size2.height, point2.x, point2.y);
    }

    public static void sqrBoxFilter(Mat mat, Mat mat2, int i, Size size) {
        sqrBoxFilter_3(mat.nativeObj, mat2.nativeObj, i, size.width, size.height);
    }

    public static void undistort(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5) {
        undistort_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj);
    }

    public static void undistort(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        undistort_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static void undistortPointsIter(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, TermCriteria termCriteria) {
        TermCriteria termCriteria2 = termCriteria;
        undistortPointsIter_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, termCriteria2.type, termCriteria2.maxCount, termCriteria2.epsilon);
    }

    public static void undistortPoints(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6) {
        undistortPoints_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj);
    }

    public static void undistortPoints(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5) {
        undistortPoints_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj);
    }

    public static void undistortPoints(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        undistortPoints_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static void warpAffine(Mat mat, Mat mat2, Mat mat3, Size size, int i, int i2, Scalar scalar) {
        Size size2 = size;
        Scalar scalar2 = scalar;
        warpAffine_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, size2.width, size2.height, i, i2, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3]);
    }

    public static void warpAffine(Mat mat, Mat mat2, Mat mat3, Size size, int i, int i2) {
        Size size2 = size;
        warpAffine_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, size2.width, size2.height, i, i2);
    }

    public static void warpAffine(Mat mat, Mat mat2, Mat mat3, Size size, int i) {
        warpAffine_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, size.width, size.height, i);
    }

    public static void warpAffine(Mat mat, Mat mat2, Mat mat3, Size size) {
        warpAffine_3(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, size.width, size.height);
    }

    public static void warpPerspective(Mat mat, Mat mat2, Mat mat3, Size size, int i, int i2, Scalar scalar) {
        Size size2 = size;
        Scalar scalar2 = scalar;
        warpPerspective_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, size2.width, size2.height, i, i2, scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3]);
    }

    public static void warpPerspective(Mat mat, Mat mat2, Mat mat3, Size size, int i, int i2) {
        Size size2 = size;
        warpPerspective_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, size2.width, size2.height, i, i2);
    }

    public static void warpPerspective(Mat mat, Mat mat2, Mat mat3, Size size, int i) {
        warpPerspective_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, size.width, size.height, i);
    }

    public static void warpPerspective(Mat mat, Mat mat2, Mat mat3, Size size) {
        warpPerspective_3(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, size.width, size.height);
    }

    public static void warpPolar(Mat mat, Mat mat2, Size size, Point point, double d, int i) {
        Size size2 = size;
        Point point2 = point;
        warpPolar_0(mat.nativeObj, mat2.nativeObj, size2.width, size2.height, point2.x, point2.y, d, i);
    }

    public static void watershed(Mat mat, Mat mat2) {
        watershed_0(mat.nativeObj, mat2.nativeObj);
    }

    public static Size getTextSize(String str, int i, double d, int i2, int[] iArr) {
        if (iArr == null || iArr.length == 1) {
            return new Size(n_getTextSize(str, i, d, i2, iArr));
        }
        throw new IllegalArgumentException("'baseLine' must be 'int[1]' or 'null'.");
    }
}
