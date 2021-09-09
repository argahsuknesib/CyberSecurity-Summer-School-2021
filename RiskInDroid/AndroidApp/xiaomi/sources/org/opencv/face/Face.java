package org.opencv.face;

import java.util.List;

public class Face {
    private static native long createFacemarkAAM_0();

    private static native long createFacemarkKazemi_0();

    private static native long createFacemarkLBF_0();

    private static native void drawFacemarks_0(long j, long j2, double d, double d2, double d3, double d4);

    private static native void drawFacemarks_1(long j, long j2);

    private static native boolean getFacesHAAR_0(long j, long j2, String str);

    private static native boolean loadDatasetList_0(String str, String str2, List<String> list, List<String> list2);

    private static native boolean loadFacePoints_0(String str, long j, float f);

    private static native boolean loadFacePoints_1(String str, long j);

    private static native boolean loadTrainingData_0(String str, List<String> list, long j, char c, float f);

    private static native boolean loadTrainingData_1(String str, List<String> list, long j, char c);

    private static native boolean loadTrainingData_2(String str, List<String> list, long j);

    private static native boolean loadTrainingData_3(String str, String str2, List<String> list, long j, float f);

    private static native boolean loadTrainingData_4(String str, String str2, List<String> list, long j);

    private static native boolean loadTrainingData_5(List<String> list, long j, List<String> list2);

    public static Facemark O000000o() {
        return Facemark.O000000o(createFacemarkLBF_0());
    }
}
