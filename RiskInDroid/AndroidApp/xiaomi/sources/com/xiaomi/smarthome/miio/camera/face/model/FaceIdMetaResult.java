package com.xiaomi.smarthome.miio.camera.face.model;

import android.text.TextUtils;
import android.view.View;
import java.util.ArrayList;

public class FaceIdMetaResult {
    public static String face_tips_acquaintrance1;
    public static String face_tips_acquaintrance2;
    public static String face_tips_cry;
    public static String face_tips_stranger;
    public static String face_tips_stranger_acquaintrance;
    public static String face_tips_stranger_cry;
    public static String face_tips_stranger_min;
    public static String face_tips_strangers;
    public boolean babyCrying;
    public String deliverType;
    public String extraInfo;
    public FaceInfo[] faceInfoMetas;
    public String fileId;
    public boolean foundPeople;
    public boolean isDeliver;
    public int matchedCount = 0;
    public String tips;
    public String tipsMin;
    public int unMatchedCount = 0;

    public void calculateTips(View view, View view2) {
        FaceInfo[] faceInfoArr;
        FaceInfo[] faceInfoArr2 = this.faceInfoMetas;
        if ((faceInfoArr2 != null && faceInfoArr2.length != 0) || this.babyCrying) {
            if (TextUtils.isEmpty(this.tips) || (faceInfoArr = this.faceInfoMetas) == null) {
                ArrayList arrayList = new ArrayList();
                this.unMatchedCount = 0;
                this.matchedCount = 0;
                FaceInfo[] faceInfoArr3 = this.faceInfoMetas;
                if (faceInfoArr3 != null) {
                    int i = 0;
                    for (FaceInfo faceInfo : faceInfoArr3) {
                        if (i > 1) {
                            break;
                        }
                        i++;
                        if (!faceInfo.matched) {
                            this.unMatchedCount++;
                            if (view != null) {
                                view.setVisibility(0);
                            }
                        } else if (this.matchedCount <= 0 || !faceInfo.figureName.equals(arrayList.get(0))) {
                            this.matchedCount++;
                            arrayList.add(faceInfo.figureName);
                            if (view2 != null) {
                                view2.setVisibility(0);
                            }
                        }
                    }
                }
                if (this.unMatchedCount > 0) {
                    this.tips = face_tips_stranger_cry;
                    this.tipsMin = face_tips_stranger_min;
                } else {
                    this.tips = face_tips_cry;
                    if (this.matchedCount > 0) {
                        this.tipsMin = String.format(face_tips_acquaintrance1, arrayList.get(0));
                    }
                }
                if (!this.babyCrying) {
                    int i2 = this.matchedCount;
                    if (i2 == 0) {
                        int i3 = this.unMatchedCount;
                        if (i3 > 1) {
                            this.tips = String.format(face_tips_strangers, Integer.valueOf(i3));
                        } else {
                            this.tips = String.format(face_tips_stranger, Integer.valueOf(i3));
                        }
                    } else if (i2 != 1) {
                        if (i2 == 2) {
                            this.tips = String.format(face_tips_acquaintrance2, arrayList.get(0), arrayList.get(1));
                        }
                    } else if (this.unMatchedCount > 0) {
                        this.tips = String.format(face_tips_stranger_acquaintrance, arrayList.get(0));
                    } else {
                        this.tips = String.format(face_tips_acquaintrance1, arrayList.get(0));
                    }
                }
            } else {
                int length = faceInfoArr.length;
                int i4 = 0;
                int i5 = 0;
                while (i4 < length) {
                    FaceInfo faceInfo2 = faceInfoArr[i4];
                    if (i5 <= 1) {
                        i5++;
                        if (faceInfo2.matched) {
                            if (view2 != null) {
                                view2.setVisibility(0);
                            }
                        } else if (view != null) {
                            view.setVisibility(0);
                        }
                        i4++;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
