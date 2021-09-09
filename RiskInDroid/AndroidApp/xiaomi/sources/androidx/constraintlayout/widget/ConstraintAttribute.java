package androidx.constraintlayout.widget;

import _m_j.jdn;
import _m_j.oO00000o;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import com.xiaomi.smarthome.R;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

public final class ConstraintAttribute {

    /* renamed from: O000000o  reason: collision with root package name */
    String f2800O000000o;
    public AttributeType O00000Oo;
    private int O00000o;
    boolean O00000o0;
    private float O00000oO;
    private String O00000oo;
    private int O0000O0o;

    public enum AttributeType {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE
    }

    private static int O000000o(int i) {
        int i2 = (i & ((i >> 31) ^ -1)) - 255;
        return (i2 & (i2 >> 31)) + 255;
    }

    public final int O000000o() {
        int i = AnonymousClass1.f2801O000000o[this.O00000Oo.ordinal()];
        return (i == 1 || i == 2) ? 4 : 1;
    }

    public final float O00000Oo() {
        switch (this.O00000Oo) {
            case COLOR_TYPE:
            case COLOR_DRAWABLE_TYPE:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case INT_TYPE:
                return (float) this.O00000o;
            case FLOAT_TYPE:
                return this.O00000oO;
            case STRING_TYPE:
                throw new RuntimeException("Cannot interpolate String");
            case BOOLEAN_TYPE:
                return this.O00000o0 ? 0.0f : 1.0f;
            case DIMENSION_TYPE:
                return this.O00000oO;
            default:
                return Float.NaN;
        }
    }

    public final void O000000o(float[] fArr) {
        switch (this.O00000Oo) {
            case COLOR_TYPE:
            case COLOR_DRAWABLE_TYPE:
                int i = this.O0000O0o;
                float pow = (float) Math.pow((double) (((float) ((i >> 16) & 255)) / 255.0f), 2.2d);
                float pow2 = (float) Math.pow((double) (((float) ((i >> 8) & 255)) / 255.0f), 2.2d);
                fArr[0] = pow;
                fArr[1] = pow2;
                fArr[2] = (float) Math.pow((double) (((float) (i & 255)) / 255.0f), 2.2d);
                fArr[3] = ((float) ((i >> 24) & 255)) / 255.0f;
                return;
            case INT_TYPE:
                fArr[0] = (float) this.O00000o;
                return;
            case FLOAT_TYPE:
                fArr[0] = this.O00000oO;
                return;
            case STRING_TYPE:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case BOOLEAN_TYPE:
                fArr[0] = this.O00000o0 ? 0.0f : 1.0f;
                return;
            case DIMENSION_TYPE:
                fArr[0] = this.O00000oO;
                return;
            default:
                return;
        }
    }

    private ConstraintAttribute(String str, AttributeType attributeType, Object obj) {
        this.f2800O000000o = str;
        this.O00000Oo = attributeType;
        O000000o(obj);
    }

    private ConstraintAttribute(ConstraintAttribute constraintAttribute, Object obj) {
        this.f2800O000000o = constraintAttribute.f2800O000000o;
        this.O00000Oo = constraintAttribute.O00000Oo;
        O000000o(obj);
    }

    private void O000000o(Object obj) {
        switch (this.O00000Oo) {
            case COLOR_TYPE:
            case COLOR_DRAWABLE_TYPE:
                this.O0000O0o = ((Integer) obj).intValue();
                return;
            case INT_TYPE:
                this.O00000o = ((Integer) obj).intValue();
                return;
            case FLOAT_TYPE:
                this.O00000oO = ((Float) obj).floatValue();
                return;
            case STRING_TYPE:
                this.O00000oo = (String) obj;
                return;
            case BOOLEAN_TYPE:
                this.O00000o0 = ((Boolean) obj).booleanValue();
                return;
            case DIMENSION_TYPE:
                this.O00000oO = ((Float) obj).floatValue();
                return;
            default:
                return;
        }
    }

    public static HashMap<String, ConstraintAttribute> O000000o(HashMap<String, ConstraintAttribute> hashMap, View view) {
        HashMap<String, ConstraintAttribute> hashMap2 = new HashMap<>();
        Class<?> cls = view.getClass();
        for (String next : hashMap.keySet()) {
            ConstraintAttribute constraintAttribute = hashMap.get(next);
            try {
                if (next.equals("BackgroundColor")) {
                    hashMap2.put(next, new ConstraintAttribute(constraintAttribute, Integer.valueOf(((ColorDrawable) view.getBackground()).getColor())));
                } else {
                    hashMap2.put(next, new ConstraintAttribute(constraintAttribute, cls.getMethod("getMap".concat(String.valueOf(next)), new Class[0]).invoke(view, new Object[0])));
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
        return hashMap2;
    }

    public static void O000000o(View view, HashMap<String, ConstraintAttribute> hashMap) {
        Class<?> cls = view.getClass();
        for (String next : hashMap.keySet()) {
            ConstraintAttribute constraintAttribute = hashMap.get(next);
            String concat = "set".concat(String.valueOf(next));
            try {
                switch (constraintAttribute.O00000Oo) {
                    case COLOR_TYPE:
                        cls.getMethod(concat, Integer.TYPE).invoke(view, Integer.valueOf(constraintAttribute.O0000O0o));
                        continue;
                    case COLOR_DRAWABLE_TYPE:
                        Method method = cls.getMethod(concat, Drawable.class);
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(constraintAttribute.O0000O0o);
                        method.invoke(view, colorDrawable);
                        continue;
                    case INT_TYPE:
                        cls.getMethod(concat, Integer.TYPE).invoke(view, Integer.valueOf(constraintAttribute.O00000o));
                        continue;
                    case FLOAT_TYPE:
                        cls.getMethod(concat, Float.TYPE).invoke(view, Float.valueOf(constraintAttribute.O00000oO));
                        continue;
                    case STRING_TYPE:
                        cls.getMethod(concat, CharSequence.class).invoke(view, constraintAttribute.O00000oo);
                        continue;
                    case BOOLEAN_TYPE:
                        cls.getMethod(concat, Boolean.TYPE).invoke(view, Boolean.valueOf(constraintAttribute.O00000o0));
                        continue;
                    case DIMENSION_TYPE:
                        cls.getMethod(concat, Float.TYPE).invoke(view, Float.valueOf(constraintAttribute.O00000oO));
                        continue;
                    default:
                        continue;
                }
            } catch (NoSuchMethodException e) {
                Log.e("TransitionLayout", e.getMessage());
                Log.e("TransitionLayout", " Custom Attribute \"" + next + "\" not found on " + cls.getName());
                Log.e("TransitionLayout", cls.getName() + " must have a method " + concat);
            } catch (IllegalAccessException e2) {
                Log.e("TransitionLayout", " Custom Attribute \"" + next + "\" not found on " + cls.getName());
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                Log.e("TransitionLayout", " Custom Attribute \"" + next + "\" not found on " + cls.getName());
                e3.printStackTrace();
            }
        }
    }

    public final void O000000o(View view, float[] fArr) {
        View view2 = view;
        Class<?> cls = view.getClass();
        String str = "set" + this.f2800O000000o;
        try {
            boolean z = true;
            switch (this.O00000Oo) {
                case COLOR_TYPE:
                    cls.getMethod(str, Integer.TYPE).invoke(view2, Integer.valueOf((O000000o((int) (((float) Math.pow((double) fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (O000000o((int) (fArr[3] * 255.0f)) << 24) | (O000000o((int) (((float) Math.pow((double) fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | O000000o((int) (((float) Math.pow((double) fArr[2], 0.45454545454545453d)) * 255.0f))));
                    return;
                case COLOR_DRAWABLE_TYPE:
                    Method method = cls.getMethod(str, Drawable.class);
                    int O000000o2 = O000000o((int) (((float) Math.pow((double) fArr[0], 0.45454545454545453d)) * 255.0f));
                    int O000000o3 = O000000o((int) (((float) Math.pow((double) fArr[1], 0.45454545454545453d)) * 255.0f));
                    ColorDrawable colorDrawable = new ColorDrawable();
                    colorDrawable.setColor((O000000o2 << 16) | (O000000o((int) (fArr[3] * 255.0f)) << 24) | (O000000o3 << 8) | O000000o((int) (((float) Math.pow((double) fArr[2], 0.45454545454545453d)) * 255.0f)));
                    method.invoke(view2, colorDrawable);
                    return;
                case INT_TYPE:
                    cls.getMethod(str, Integer.TYPE).invoke(view2, Integer.valueOf((int) fArr[0]));
                    return;
                case FLOAT_TYPE:
                    cls.getMethod(str, Float.TYPE).invoke(view2, Float.valueOf(fArr[0]));
                    return;
                case STRING_TYPE:
                    throw new RuntimeException("unable to interpolate strings " + this.f2800O000000o);
                case BOOLEAN_TYPE:
                    Method method2 = cls.getMethod(str, Boolean.TYPE);
                    Object[] objArr = new Object[1];
                    if (fArr[0] <= 0.5f) {
                        z = false;
                    }
                    objArr[0] = Boolean.valueOf(z);
                    method2.invoke(view2, objArr);
                    return;
                case DIMENSION_TYPE:
                    cls.getMethod(str, Float.TYPE).invoke(view2, Float.valueOf(fArr[0]));
                    return;
                default:
                    return;
            }
        } catch (NoSuchMethodException e) {
            Log.e("TransitionLayout", "no method " + str + "on View \"" + oO00000o.O000000o(view) + jdn.f1779O000000o);
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            Log.e("TransitionLayout", "cannot access method " + str + "on View \"" + oO00000o.O000000o(view) + jdn.f1779O000000o);
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }

    public static void O000000o(Context context, XmlPullParser xmlPullParser, HashMap<String, ConstraintAttribute> hashMap) {
        AttributeType attributeType;
        Object string;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), new int[]{R.attr.attributeName, R.attr.customBoolean, R.attr.customColorDrawableValue, R.attr.customColorValue, R.attr.customDimension, R.attr.customFloatValue, R.attr.customIntegerValue, R.attr.customPixelDimension, R.attr.customStringValue});
        int indexCount = obtainStyledAttributes.getIndexCount();
        String str = null;
        Object obj = null;
        AttributeType attributeType2 = null;
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == 0) {
                str = obtainStyledAttributes.getString(index);
                if (str != null && str.length() > 0) {
                    str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
                }
            } else if (index == 1) {
                obj = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                attributeType2 = AttributeType.BOOLEAN_TYPE;
            } else {
                if (index == 3) {
                    attributeType = AttributeType.COLOR_TYPE;
                    string = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == 2) {
                    attributeType = AttributeType.COLOR_DRAWABLE_TYPE;
                    string = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == 7) {
                    attributeType = AttributeType.DIMENSION_TYPE;
                    string = Float.valueOf(TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics()));
                } else if (index == 4) {
                    attributeType = AttributeType.DIMENSION_TYPE;
                    string = Float.valueOf(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == 5) {
                    attributeType = AttributeType.FLOAT_TYPE;
                    string = Float.valueOf(obtainStyledAttributes.getFloat(index, Float.NaN));
                } else if (index == 6) {
                    attributeType = AttributeType.INT_TYPE;
                    string = Integer.valueOf(obtainStyledAttributes.getInteger(index, -1));
                } else if (index == 8) {
                    attributeType = AttributeType.STRING_TYPE;
                    string = obtainStyledAttributes.getString(index);
                }
                Object obj2 = string;
                attributeType2 = attributeType;
                obj = obj2;
            }
        }
        if (!(str == null || obj == null)) {
            hashMap.put(str, new ConstraintAttribute(str, attributeType2, obj));
        }
        obtainStyledAttributes.recycle();
    }
}
