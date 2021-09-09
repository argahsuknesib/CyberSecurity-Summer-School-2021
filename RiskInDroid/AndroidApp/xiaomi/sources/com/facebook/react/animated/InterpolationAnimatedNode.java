package com.facebook.react.animated;

import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class InterpolationAnimatedNode extends ValueAnimatedNode {
    private static final Pattern fpPattern = Pattern.compile("[+-]?(\\d+\\.?\\d*|\\.\\d+)([eE][+-]?\\d+)?");
    private final String mExtrapolateLeft;
    private final String mExtrapolateRight;
    private final boolean mHasStringOutput;
    private final double[] mInputRange;
    private int mNumVals;
    private final double[] mOutputRange;
    private double[][] mOutputs;
    private ValueAnimatedNode mParent;
    private String mPattern;
    private final Matcher mSOutputMatcher;
    private boolean mShouldRound;

    private static double[] fromDoubleArray(ReadableArray readableArray) {
        double[] dArr = new double[readableArray.size()];
        for (int i = 0; i < dArr.length; i++) {
            dArr[i] = readableArray.getDouble(i);
        }
        return dArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0062 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b1  */
    private static double interpolate(double d, double d2, double d3, double d4, double d5, String str, String str2) {
        double d6;
        char c;
        String str3 = str;
        String str4 = str2;
        char c2 = 65535;
        if (d < d2) {
            int hashCode = str.hashCode();
            if (hashCode != -1289044198) {
                if (hashCode != -135761730) {
                    if (hashCode == 94742715 && str3.equals("clamp")) {
                        c = 1;
                        if (c != 0) {
                            return d;
                        }
                        if (c == 1) {
                            d6 = d2;
                            if (d6 > d3) {
                                int hashCode2 = str2.hashCode();
                                if (hashCode2 != -1289044198) {
                                    if (hashCode2 != -135761730) {
                                        if (hashCode2 == 94742715 && str4.equals("clamp")) {
                                            c2 = 1;
                                        }
                                    } else if (str4.equals("identity")) {
                                        c2 = 0;
                                    }
                                } else if (str4.equals("extend")) {
                                    c2 = 2;
                                }
                                if (c2 == 0) {
                                    return d6;
                                }
                                if (c2 == 1) {
                                    d6 = d3;
                                } else if (c2 != 2) {
                                    throw new JSApplicationIllegalArgumentException("Invalid extrapolation type " + str4 + "for right extrapolation");
                                }
                            }
                            if (d4 != d5) {
                                return d4;
                            }
                            if (d2 == d3) {
                                return d <= d2 ? d4 : d5;
                            }
                            return d4 + (((d5 - d4) * (d6 - d2)) / (d3 - d2));
                        } else if (c != 2) {
                            throw new JSApplicationIllegalArgumentException("Invalid extrapolation type " + str3 + "for left extrapolation");
                        }
                    }
                } else if (str3.equals("identity")) {
                    c = 0;
                    if (c != 0) {
                    }
                }
            } else if (str3.equals("extend")) {
                c = 2;
                if (c != 0) {
                }
            }
            c = 65535;
            if (c != 0) {
            }
        }
        d6 = d;
        if (d6 > d3) {
        }
        if (d4 != d5) {
        }
    }

    static double interpolate(double d, double[] dArr, double[] dArr2, String str, String str2) {
        int findRangeIndex = findRangeIndex(d, dArr);
        int i = findRangeIndex + 1;
        return interpolate(d, dArr[findRangeIndex], dArr[i], dArr2[findRangeIndex], dArr2[i], str, str2);
    }

    private static int findRangeIndex(double d, double[] dArr) {
        int i = 1;
        while (i < dArr.length - 1 && dArr[i] < d) {
            i++;
        }
        return i - 1;
    }

    public InterpolationAnimatedNode(ReadableMap readableMap) {
        this.mInputRange = fromDoubleArray(readableMap.getArray("inputRange"));
        ReadableArray array = readableMap.getArray("outputRange");
        this.mHasStringOutput = array.getType(0) == ReadableType.String;
        if (this.mHasStringOutput) {
            int size = array.size();
            this.mOutputRange = new double[size];
            this.mPattern = array.getString(0);
            this.mShouldRound = this.mPattern.startsWith("rgb");
            this.mSOutputMatcher = fpPattern.matcher(this.mPattern);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < size; i++) {
                Matcher matcher = fpPattern.matcher(array.getString(i));
                ArrayList arrayList2 = new ArrayList();
                arrayList.add(arrayList2);
                while (matcher.find()) {
                    arrayList2.add(Double.valueOf(Double.parseDouble(matcher.group())));
                }
                this.mOutputRange[i] = ((Double) arrayList2.get(0)).doubleValue();
            }
            this.mNumVals = ((ArrayList) arrayList.get(0)).size();
            this.mOutputs = new double[this.mNumVals][];
            for (int i2 = 0; i2 < this.mNumVals; i2++) {
                double[] dArr = new double[size];
                this.mOutputs[i2] = dArr;
                for (int i3 = 0; i3 < size; i3++) {
                    dArr[i3] = ((Double) ((ArrayList) arrayList.get(i3)).get(i2)).doubleValue();
                }
            }
        } else {
            this.mOutputRange = fromDoubleArray(array);
            this.mSOutputMatcher = null;
        }
        this.mExtrapolateLeft = readableMap.getString("extrapolateLeft");
        this.mExtrapolateRight = readableMap.getString("extrapolateRight");
    }

    public void onAttachedToNode(AnimatedNode animatedNode) {
        if (this.mParent != null) {
            throw new IllegalStateException("Parent already attached");
        } else if (animatedNode instanceof ValueAnimatedNode) {
            this.mParent = (ValueAnimatedNode) animatedNode;
        } else {
            throw new IllegalArgumentException("Parent is of an invalid type");
        }
    }

    public void onDetachedFromNode(AnimatedNode animatedNode) {
        if (animatedNode == this.mParent) {
            this.mParent = null;
            return;
        }
        throw new IllegalArgumentException("Invalid parent node provided");
    }

    public void update() {
        String str;
        ValueAnimatedNode valueAnimatedNode = this.mParent;
        if (valueAnimatedNode != null) {
            double value = valueAnimatedNode.getValue();
            this.mValue = interpolate(value, this.mInputRange, this.mOutputRange, this.mExtrapolateLeft, this.mExtrapolateRight);
            if (!this.mHasStringOutput) {
                return;
            }
            if (this.mNumVals > 1) {
                StringBuffer stringBuffer = new StringBuffer(this.mPattern.length());
                this.mSOutputMatcher.reset();
                int i = 0;
                while (this.mSOutputMatcher.find()) {
                    int i2 = i + 1;
                    double interpolate = interpolate(value, this.mInputRange, this.mOutputs[i], this.mExtrapolateLeft, this.mExtrapolateRight);
                    if (this.mShouldRound) {
                        boolean z = i2 == 4;
                        if (z) {
                            interpolate *= 1000.0d;
                        }
                        int round = (int) Math.round(interpolate);
                        if (z) {
                            double d = (double) round;
                            Double.isNaN(d);
                            str = Double.toString(d / 1000.0d);
                        } else {
                            str = Integer.toString(round);
                        }
                        this.mSOutputMatcher.appendReplacement(stringBuffer, str);
                    } else {
                        int i3 = (int) interpolate;
                        this.mSOutputMatcher.appendReplacement(stringBuffer, ((double) i3) != interpolate ? Double.toString(interpolate) : Integer.toString(i3));
                    }
                    i = i2;
                }
                this.mSOutputMatcher.appendTail(stringBuffer);
                this.mAnimatedObject = stringBuffer.toString();
                return;
            }
            this.mAnimatedObject = this.mSOutputMatcher.replaceFirst(String.valueOf(this.mValue));
        }
    }
}
