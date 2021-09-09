package _m_j;

import _m_j.s;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class js {
    private static boolean O000000o(int i) {
        return i >= 28 && i <= 31;
    }

    public static Animator O000000o(Context context, Resources resources, Resources.Theme theme, int i) throws Resources.NotFoundException {
        XmlResourceParser xmlResourceParser = null;
        try {
            XmlResourceParser animation = resources.getAnimation(i);
            Animator O000000o2 = O000000o(context, resources, theme, animation, Xml.asAttributeSet(animation), null, 0, 1.0f);
            if (animation != null) {
                animation.close();
            }
            return O000000o2;
        } catch (XmlPullParserException e) {
            Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
            notFoundException.initCause(e);
            throw notFoundException;
        } catch (IOException e2) {
            Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
            notFoundException2.initCause(e2);
            throw notFoundException2;
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }

    static class O000000o implements TypeEvaluator<s.O00000Oo[]> {

        /* renamed from: O000000o  reason: collision with root package name */
        private s.O00000Oo[] f2117O000000o;

        public final /* synthetic */ Object evaluate(float f, Object obj, Object obj2) {
            s.O00000Oo[] o00000OoArr = (s.O00000Oo[]) obj;
            s.O00000Oo[] o00000OoArr2 = (s.O00000Oo[]) obj2;
            if (s.O000000o(o00000OoArr, o00000OoArr2)) {
                if (!s.O000000o(this.f2117O000000o, o00000OoArr)) {
                    this.f2117O000000o = s.O000000o(o00000OoArr);
                }
                for (int i = 0; i < o00000OoArr.length; i++) {
                    this.f2117O000000o[i].O000000o(o00000OoArr[i], o00000OoArr2[i], f);
                }
                return this.f2117O000000o;
            }
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }

        O000000o() {
        }
    }

    private static PropertyValuesHolder O000000o(TypedArray typedArray, int i, int i2, int i3, String str) {
        int i4;
        int i5;
        int i6;
        float f;
        float f2;
        float f3;
        TypedValue peekValue = typedArray.peekValue(i2);
        boolean z = peekValue != null;
        int i7 = z ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i3);
        boolean z2 = peekValue2 != null;
        int i8 = z2 ? peekValue2.type : 0;
        if (i == 4) {
            i = ((!z || !O000000o(i7)) && (!z2 || !O000000o(i8))) ? 0 : 3;
        }
        boolean z3 = i == 0;
        PropertyValuesHolder propertyValuesHolder = null;
        if (i == 2) {
            String string = typedArray.getString(i2);
            String string2 = typedArray.getString(i3);
            s.O00000Oo[] O00000Oo = s.O00000Oo(string);
            s.O00000Oo[] O00000Oo2 = s.O00000Oo(string2);
            if (!(O00000Oo == null && O00000Oo2 == null)) {
                if (O00000Oo != null) {
                    O000000o o000000o = new O000000o();
                    if (O00000Oo2 == null) {
                        return PropertyValuesHolder.ofObject(str, o000000o, O00000Oo);
                    } else if (s.O000000o(O00000Oo, O00000Oo2)) {
                        return PropertyValuesHolder.ofObject(str, o000000o, O00000Oo, O00000Oo2);
                    } else {
                        throw new InflateException(" Can't morph from " + string + " to " + string2);
                    }
                } else if (O00000Oo2 != null) {
                    propertyValuesHolder = PropertyValuesHolder.ofObject(str, new O000000o(), O00000Oo2);
                }
            }
            return propertyValuesHolder;
        }
        jt O000000o2 = i == 3 ? jt.O000000o() : null;
        if (z3) {
            if (z) {
                if (i7 == 5) {
                    f2 = typedArray.getDimension(i2, 0.0f);
                } else {
                    f2 = typedArray.getFloat(i2, 0.0f);
                }
                if (z2) {
                    if (i8 == 5) {
                        f3 = typedArray.getDimension(i3, 0.0f);
                    } else {
                        f3 = typedArray.getFloat(i3, 0.0f);
                    }
                    propertyValuesHolder = PropertyValuesHolder.ofFloat(str, f2, f3);
                } else {
                    propertyValuesHolder = PropertyValuesHolder.ofFloat(str, f2);
                }
            } else {
                if (i8 == 5) {
                    f = typedArray.getDimension(i3, 0.0f);
                } else {
                    f = typedArray.getFloat(i3, 0.0f);
                }
                propertyValuesHolder = PropertyValuesHolder.ofFloat(str, f);
            }
        } else if (z) {
            if (i7 == 5) {
                i5 = (int) typedArray.getDimension(i2, 0.0f);
            } else if (O000000o(i7)) {
                i5 = typedArray.getColor(i2, 0);
            } else {
                i5 = typedArray.getInt(i2, 0);
            }
            if (z2) {
                if (i8 == 5) {
                    i6 = (int) typedArray.getDimension(i3, 0.0f);
                } else if (O000000o(i8)) {
                    i6 = typedArray.getColor(i3, 0);
                } else {
                    i6 = typedArray.getInt(i3, 0);
                }
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, i5, i6);
            } else {
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, i5);
            }
        } else if (z2) {
            if (i8 == 5) {
                i4 = (int) typedArray.getDimension(i3, 0.0f);
            } else if (O000000o(i8)) {
                i4 = typedArray.getColor(i3, 0);
            } else {
                i4 = typedArray.getInt(i3, 0);
            }
            propertyValuesHolder = PropertyValuesHolder.ofInt(str, i4);
        }
        PropertyValuesHolder propertyValuesHolder2 = propertyValuesHolder;
        if (propertyValuesHolder2 == null || O000000o2 == null) {
            return propertyValuesHolder2;
        }
        propertyValuesHolder2.setEvaluator(O000000o2);
        return propertyValuesHolder2;
    }

    private static void O000000o(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f, XmlPullParser xmlPullParser) {
        ValueAnimator valueAnimator2 = valueAnimator;
        TypedArray typedArray3 = typedArray;
        TypedArray typedArray4 = typedArray2;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        long O000000o2 = (long) n.O000000o(typedArray3, xmlPullParser2, "duration", 1, 300);
        long O000000o3 = (long) n.O000000o(typedArray3, xmlPullParser2, "startOffset", 2, 0);
        int O000000o4 = n.O000000o(typedArray3, xmlPullParser2, "valueType", 7, 4);
        if (n.O000000o(xmlPullParser2, "valueFrom") && n.O000000o(xmlPullParser2, "valueTo")) {
            if (O000000o4 == 4) {
                TypedValue peekValue = typedArray3.peekValue(5);
                boolean z = peekValue != null;
                int i = z ? peekValue.type : 0;
                TypedValue peekValue2 = typedArray3.peekValue(6);
                boolean z2 = peekValue2 != null;
                O000000o4 = ((!z || !O000000o(i)) && (!z2 || !O000000o(z2 ? peekValue2.type : 0))) ? 0 : 3;
            }
            PropertyValuesHolder O000000o5 = O000000o(typedArray3, O000000o4, 5, 6, "");
            if (O000000o5 != null) {
                valueAnimator2.setValues(O000000o5);
            }
        }
        valueAnimator2.setDuration(O000000o2);
        valueAnimator2.setStartDelay(O000000o3);
        valueAnimator2.setRepeatCount(n.O000000o(typedArray3, xmlPullParser2, "repeatCount", 3, 0));
        valueAnimator2.setRepeatMode(n.O000000o(typedArray3, xmlPullParser2, "repeatMode", 4, 1));
        if (typedArray4 != null) {
            ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator2;
            String O00000o0 = n.O00000o0(typedArray4, xmlPullParser2, "pathData", 1);
            if (O00000o0 != null) {
                String O00000o02 = n.O00000o0(typedArray4, xmlPullParser2, "propertyXName", 2);
                String O00000o03 = n.O00000o0(typedArray4, xmlPullParser2, "propertyYName", 3);
                if (O00000o02 == null && O00000o03 == null) {
                    throw new InflateException(typedArray2.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
                }
                O000000o(s.O000000o(O00000o0), objectAnimator, 0.5f * f, O00000o02, O00000o03);
                return;
            }
            objectAnimator.setPropertyName(n.O00000o0(typedArray4, xmlPullParser2, "propertyName", 0));
        }
    }

    private static void O000000o(Path path, ObjectAnimator objectAnimator, float f, String str, String str2) {
        PropertyValuesHolder propertyValuesHolder;
        Path path2 = path;
        ObjectAnimator objectAnimator2 = objectAnimator;
        String str3 = str;
        String str4 = str2;
        PathMeasure pathMeasure = new PathMeasure(path2, false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Float.valueOf(0.0f));
        float f2 = 0.0f;
        do {
            f2 += pathMeasure.getLength();
            arrayList.add(Float.valueOf(f2));
        } while (pathMeasure.nextContour());
        PathMeasure pathMeasure2 = new PathMeasure(path2, false);
        int min = Math.min(100, ((int) (f2 / f)) + 1);
        float[] fArr = new float[min];
        float[] fArr2 = new float[min];
        float[] fArr3 = new float[2];
        float f3 = f2 / ((float) (min - 1));
        int i = 0;
        float f4 = 0.0f;
        int i2 = 0;
        while (true) {
            propertyValuesHolder = null;
            if (i >= min) {
                break;
            }
            pathMeasure2.getPosTan(f4 - ((Float) arrayList.get(i2)).floatValue(), fArr3, null);
            fArr[i] = fArr3[0];
            fArr2[i] = fArr3[1];
            f4 += f3;
            int i3 = i2 + 1;
            if (i3 < arrayList.size() && f4 > ((Float) arrayList.get(i3)).floatValue()) {
                pathMeasure2.nextContour();
                i2 = i3;
            }
            i++;
        }
        PropertyValuesHolder ofFloat = str3 != null ? PropertyValuesHolder.ofFloat(str3, fArr) : null;
        if (str4 != null) {
            propertyValuesHolder = PropertyValuesHolder.ofFloat(str4, fArr2);
        }
        if (ofFloat == null) {
            objectAnimator2.setValues(propertyValuesHolder);
        } else if (propertyValuesHolder == null) {
            objectAnimator2.setValues(ofFloat);
        } else {
            objectAnimator2.setValues(ofFloat, propertyValuesHolder);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b9  */
    private static Animator O000000o(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i, float f) throws XmlPullParserException, IOException {
        int i2;
        Resources resources2 = resources;
        Resources.Theme theme2 = theme;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        AnimatorSet animatorSet2 = animatorSet;
        int depth = xmlPullParser.getDepth();
        AnimatorSet animatorSet3 = null;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            i2 = 0;
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    if (name.equals("objectAnimator")) {
                        animatorSet3 = O000000o(context, resources, theme, attributeSet, f, xmlPullParser);
                    } else if (name.equals("animator")) {
                        animatorSet3 = O000000o(context, resources, theme, attributeSet, null, f, xmlPullParser);
                    } else {
                        if (name.equals("set")) {
                            AnimatorSet animatorSet4 = new AnimatorSet();
                            TypedArray O000000o2 = n.O000000o(resources2, theme2, attributeSet, jo.O0000OOo);
                            O000000o(context, resources, theme, xmlPullParser, attributeSet, animatorSet4, n.O000000o(O000000o2, xmlPullParser2, "ordering", 0, 0), f);
                            O000000o2.recycle();
                            animatorSet3 = animatorSet4;
                        } else if (name.equals("propertyValuesHolder")) {
                            PropertyValuesHolder[] O000000o3 = O000000o(context, resources2, theme2, xmlPullParser2, Xml.asAttributeSet(xmlPullParser));
                            if (O000000o3 != null && (animatorSet3 instanceof ValueAnimator)) {
                                ((ValueAnimator) animatorSet3).setValues(O000000o3);
                            }
                            i2 = 1;
                        } else {
                            throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                        }
                        if (animatorSet2 != null && i2 == 0) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(animatorSet3);
                        }
                    }
                    if (arrayList == null) {
                    }
                    arrayList.add(animatorSet3);
                }
            }
        }
        if (!(animatorSet2 == null || arrayList == null)) {
            Animator[] animatorArr = new Animator[arrayList.size()];
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                animatorArr[i2] = (Animator) it.next();
                i2++;
            }
            if (i == 0) {
                animatorSet2.playTogether(animatorArr);
            } else {
                animatorSet2.playSequentially(animatorArr);
            }
        }
        return animatorSet3;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, float):float
     arg types: [android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, int]
     candidates:
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, int):int
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, android.content.res.Resources$Theme, java.lang.String, int):_m_j.i
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, boolean):boolean
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, float):float */
    private static PropertyValuesHolder[] O000000o(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        PropertyValuesHolder propertyValuesHolder;
        int size;
        Keyframe keyframe;
        Resources resources2 = resources;
        Resources.Theme theme2 = theme;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        ArrayList arrayList = null;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            if (eventType == 3) {
                break;
            }
            int i = 1;
            if (eventType == 1) {
                break;
            } else if (eventType != 2) {
                xmlPullParser.next();
            } else {
                if (xmlPullParser.getName().equals("propertyValuesHolder")) {
                    TypedArray O000000o2 = n.O000000o(resources2, theme2, attributeSet, jo.O0000Oo0);
                    String O00000o0 = n.O00000o0(O000000o2, xmlPullParser2, "propertyName", 3);
                    int i2 = 4;
                    int O000000o3 = n.O000000o(O000000o2, xmlPullParser2, "valueType", 2, 4);
                    int i3 = O000000o3;
                    ArrayList arrayList2 = null;
                    while (true) {
                        int next = xmlPullParser.next();
                        if (next != 3 && next != i) {
                            if (xmlPullParser.getName().equals("keyframe")) {
                                if (i3 == i2) {
                                    TypedArray O000000o4 = n.O000000o(resources2, theme2, Xml.asAttributeSet(xmlPullParser), jo.O0000Oo);
                                    TypedValue O000000o5 = n.O000000o(O000000o4, xmlPullParser2, "value");
                                    int i4 = (!(O000000o5 != null) || !O000000o(O000000o5.type)) ? 0 : 3;
                                    O000000o4.recycle();
                                    i3 = i4;
                                }
                                TypedArray O000000o6 = n.O000000o(resources2, theme2, Xml.asAttributeSet(xmlPullParser), jo.O0000Oo);
                                float O000000o7 = n.O000000o(O000000o6, xmlPullParser2, "fraction", 3, -1.0f);
                                TypedValue O000000o8 = n.O000000o(O000000o6, xmlPullParser2, "value");
                                boolean z = O000000o8 != null;
                                int i5 = i3 == i2 ? (!z || !O000000o(O000000o8.type)) ? 0 : 3 : i3;
                                if (z) {
                                    if (i5 == 0) {
                                        keyframe = Keyframe.ofFloat(O000000o7, n.O000000o(O000000o6, xmlPullParser2, "value", 0, 0.0f));
                                    } else if (i5 == 1 || i5 == 3) {
                                        keyframe = Keyframe.ofInt(O000000o7, n.O000000o(O000000o6, xmlPullParser2, "value", 0, 0));
                                    } else {
                                        keyframe = null;
                                    }
                                } else if (i5 == 0) {
                                    keyframe = Keyframe.ofFloat(O000000o7);
                                } else {
                                    keyframe = Keyframe.ofInt(O000000o7);
                                }
                                int O00000Oo = n.O00000Oo(O000000o6, xmlPullParser2, "interpolator", 1);
                                if (O00000Oo > 0) {
                                    keyframe.setInterpolator(jr.O000000o(context, O00000Oo));
                                }
                                O000000o6.recycle();
                                if (keyframe != null) {
                                    if (arrayList2 == null) {
                                        arrayList2 = new ArrayList();
                                    }
                                    arrayList2.add(keyframe);
                                }
                                xmlPullParser.next();
                            }
                            i = 1;
                            i2 = 4;
                        }
                    }
                    if (arrayList2 == null || (size = arrayList2.size()) <= 0) {
                        propertyValuesHolder = null;
                    } else {
                        Keyframe keyframe2 = (Keyframe) arrayList2.get(0);
                        Keyframe keyframe3 = (Keyframe) arrayList2.get(size - 1);
                        float fraction = keyframe3.getFraction();
                        if (fraction < 1.0f) {
                            if (fraction < 0.0f) {
                                keyframe3.setFraction(1.0f);
                            } else {
                                arrayList2.add(arrayList2.size(), O000000o(keyframe3, 1.0f));
                                size++;
                            }
                        }
                        float fraction2 = keyframe2.getFraction();
                        if (fraction2 != 0.0f) {
                            if (fraction2 < 0.0f) {
                                keyframe2.setFraction(0.0f);
                            } else {
                                arrayList2.add(0, O000000o(keyframe2, 0.0f));
                                size++;
                            }
                        }
                        Keyframe[] keyframeArr = new Keyframe[size];
                        arrayList2.toArray(keyframeArr);
                        for (int i6 = 0; i6 < size; i6++) {
                            Keyframe keyframe4 = keyframeArr[i6];
                            if (keyframe4.getFraction() < 0.0f) {
                                if (i6 == 0) {
                                    keyframe4.setFraction(0.0f);
                                } else {
                                    int i7 = size - 1;
                                    if (i6 == i7) {
                                        keyframe4.setFraction(1.0f);
                                    } else {
                                        int i8 = i6 + 1;
                                        int i9 = i6;
                                        while (true) {
                                            if (i8 < i7) {
                                                if (keyframeArr[i8].getFraction() >= 0.0f) {
                                                    break;
                                                }
                                                i9 = i8;
                                                i8++;
                                            } else {
                                                break;
                                            }
                                        }
                                        O000000o(keyframeArr, keyframeArr[i9 + 1].getFraction() - keyframeArr[i6 - 1].getFraction(), i6, i9);
                                    }
                                }
                            }
                        }
                        propertyValuesHolder = PropertyValuesHolder.ofKeyframe(O00000o0, keyframeArr);
                        if (i3 == 3) {
                            propertyValuesHolder.setEvaluator(jt.O000000o());
                        }
                    }
                    if (propertyValuesHolder == null) {
                        propertyValuesHolder = O000000o(O000000o2, O000000o3, 0, 1, O00000o0);
                    }
                    if (propertyValuesHolder != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(propertyValuesHolder);
                    }
                    O000000o2.recycle();
                }
                xmlPullParser.next();
            }
        }
        if (arrayList == null) {
            return null;
        }
        int size2 = arrayList.size();
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[size2];
        for (int i10 = 0; i10 < size2; i10++) {
            propertyValuesHolderArr[i10] = (PropertyValuesHolder) arrayList.get(i10);
        }
        return propertyValuesHolderArr;
    }

    private static Keyframe O000000o(Keyframe keyframe, float f) {
        if (keyframe.getType() == Float.TYPE) {
            return Keyframe.ofFloat(f);
        }
        if (keyframe.getType() == Integer.TYPE) {
            return Keyframe.ofInt(f);
        }
        return Keyframe.ofObject(f);
    }

    private static void O000000o(Keyframe[] keyframeArr, float f, int i, int i2) {
        float f2 = f / ((float) ((i2 - i) + 2));
        while (i <= i2) {
            keyframeArr[i].setFraction(keyframeArr[i - 1].getFraction() + f2);
            i++;
        }
    }

    private static ObjectAnimator O000000o(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, float f, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        O000000o(context, resources, theme, attributeSet, objectAnimator, f, xmlPullParser);
        return objectAnimator;
    }

    private static ValueAnimator O000000o(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        TypedArray O000000o2 = n.O000000o(resources, theme, attributeSet, jo.O0000O0o);
        TypedArray O000000o3 = n.O000000o(resources, theme, attributeSet, jo.O0000OoO);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        O000000o(valueAnimator, O000000o2, O000000o3, f, xmlPullParser);
        int O00000Oo = n.O00000Oo(O000000o2, xmlPullParser, "interpolator", 0);
        if (O00000Oo > 0) {
            valueAnimator.setInterpolator(jr.O000000o(context, O00000Oo));
        }
        O000000o2.recycle();
        if (O000000o3 != null) {
            O000000o3.recycle();
        }
        return valueAnimator;
    }
}
