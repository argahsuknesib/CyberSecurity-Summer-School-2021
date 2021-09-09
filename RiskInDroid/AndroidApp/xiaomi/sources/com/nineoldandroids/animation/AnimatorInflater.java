package com.nineoldandroids.animation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.animation.AnimationUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatorInflater {
    private static final int[] Animator = {16843073, 16843160, 16843198, 16843199, 16843200, 16843486, 16843487, 16843488};
    private static final int[] AnimatorSet = {16843490};
    private static final int[] PropertyAnimator = {16843489};

    public static Animator loadAnimator(Context context, int i) throws Resources.NotFoundException {
        XmlResourceParser xmlResourceParser = null;
        try {
            XmlResourceParser animation = context.getResources().getAnimation(i);
            Animator createAnimatorFromXml = createAnimatorFromXml(context, animation);
            if (animation != null) {
                animation.close();
            }
            return createAnimatorFromXml;
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

    private static Animator createAnimatorFromXml(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return createAnimatorFromXml(context, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0);
    }

    private static Animator createAnimatorFromXml(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i) throws XmlPullParserException, IOException {
        int i2;
        int depth = xmlPullParser.getDepth();
        ArrayList arrayList = null;
        Animator animator = null;
        while (true) {
            int next = xmlPullParser.next();
            i2 = 0;
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    if (name.equals("objectAnimator")) {
                        animator = loadObjectAnimator(context, attributeSet);
                    } else if (name.equals("animator")) {
                        animator = loadAnimator(context, attributeSet, null);
                    } else if (name.equals("set")) {
                        animator = new AnimatorSet();
                        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AnimatorSet);
                        TypedValue typedValue = new TypedValue();
                        obtainStyledAttributes.getValue(0, typedValue);
                        if (typedValue.type == 16) {
                            i2 = typedValue.data;
                        }
                        createAnimatorFromXml(context, xmlPullParser, attributeSet, (AnimatorSet) animator, i2);
                        obtainStyledAttributes.recycle();
                    } else {
                        throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                    }
                    if (animatorSet != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(animator);
                    }
                }
            }
        }
        if (!(animatorSet == null || arrayList == null)) {
            Animator[] animatorArr = new Animator[arrayList.size()];
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                animatorArr[i2] = (Animator) it.next();
                i2++;
            }
            if (i == 0) {
                animatorSet.playTogether(animatorArr);
            } else {
                animatorSet.playSequentially(animatorArr);
            }
        }
        return animator;
    }

    private static ObjectAnimator loadObjectAnimator(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        loadAnimator(context, attributeSet, objectAnimator);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, PropertyAnimator);
        objectAnimator.setPropertyName(obtainStyledAttributes.getString(0));
        obtainStyledAttributes.recycle();
        return objectAnimator;
    }

    private static ValueAnimator loadAnimator(Context context, AttributeSet attributeSet, ValueAnimator valueAnimator) throws Resources.NotFoundException {
        int i;
        int i2;
        int i3;
        int i4;
        float f;
        float f2;
        float f3;
        Context context2 = context;
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, Animator);
        long j = (long) obtainStyledAttributes.getInt(1, 0);
        long j2 = (long) obtainStyledAttributes.getInt(2, 0);
        int i5 = obtainStyledAttributes.getInt(7, 0);
        ValueAnimator valueAnimator2 = valueAnimator == null ? new ValueAnimator() : valueAnimator;
        boolean z = i5 == 0;
        TypedValue peekValue = obtainStyledAttributes.peekValue(5);
        boolean z2 = peekValue != null;
        int i6 = z2 ? peekValue.type : 0;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(6);
        boolean z3 = peekValue2 != null;
        int i7 = z3 ? peekValue2.type : 0;
        if ((z2 && i6 >= 28 && i6 <= 31) || (z3 && i7 >= 28 && i7 <= 31)) {
            valueAnimator2.setEvaluator(new ArgbEvaluator());
            z = false;
        }
        if (!z) {
            i = 0;
            if (z2) {
                if (i6 == 5) {
                    i3 = (int) obtainStyledAttributes.getDimension(5, 0.0f);
                } else if (i6 < 28 || i6 > 31) {
                    i3 = obtainStyledAttributes.getInt(5, 0);
                } else {
                    i3 = obtainStyledAttributes.getColor(5, 0);
                }
                if (z3) {
                    if (i7 == 5) {
                        i4 = (int) obtainStyledAttributes.getDimension(6, 0.0f);
                    } else if (i7 < 28 || i7 > 31) {
                        i4 = obtainStyledAttributes.getInt(6, 0);
                    } else {
                        i4 = obtainStyledAttributes.getColor(6, 0);
                    }
                    valueAnimator2.setIntValues(i3, i4);
                } else {
                    valueAnimator2.setIntValues(i3);
                }
            } else if (z3) {
                if (i7 == 5) {
                    i2 = (int) obtainStyledAttributes.getDimension(6, 0.0f);
                } else if (i7 < 28 || i7 > 31) {
                    i2 = obtainStyledAttributes.getInt(6, 0);
                } else {
                    i2 = obtainStyledAttributes.getColor(6, 0);
                }
                valueAnimator2.setIntValues(i2);
            }
        } else if (z2) {
            if (i6 == 5) {
                f2 = obtainStyledAttributes.getDimension(5, 0.0f);
            } else {
                f2 = obtainStyledAttributes.getFloat(5, 0.0f);
            }
            if (z3) {
                if (i7 == 5) {
                    f3 = obtainStyledAttributes.getDimension(6, 0.0f);
                } else {
                    f3 = obtainStyledAttributes.getFloat(6, 0.0f);
                }
                i = 0;
                valueAnimator2.setFloatValues(f2, f3);
            } else {
                i = 0;
                valueAnimator2.setFloatValues(f2);
            }
        } else {
            i = 0;
            if (i7 == 5) {
                f = obtainStyledAttributes.getDimension(6, 0.0f);
            } else {
                f = obtainStyledAttributes.getFloat(6, 0.0f);
            }
            valueAnimator2.setFloatValues(f);
        }
        valueAnimator2.setDuration(j);
        valueAnimator2.setStartDelay(j2);
        if (obtainStyledAttributes.hasValue(3)) {
            valueAnimator2.setRepeatCount(obtainStyledAttributes.getInt(3, i));
        }
        if (obtainStyledAttributes.hasValue(4)) {
            valueAnimator2.setRepeatMode(obtainStyledAttributes.getInt(4, 1));
        }
        int resourceId = obtainStyledAttributes.getResourceId(i, i);
        if (resourceId > 0) {
            valueAnimator2.setInterpolator(AnimationUtils.loadInterpolator(context2, resourceId));
        }
        obtainStyledAttributes.recycle();
        return valueAnimator2;
    }
}
