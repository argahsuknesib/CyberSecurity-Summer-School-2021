package com.facebook.appevents.codeless.internal;

import _m_j.bo;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import com.facebook.internal.Utility;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ViewHierarchy {
    private static WeakReference<View> RCTRootViewReference = new WeakReference<>(null);
    private static final String TAG = "com.facebook.appevents.codeless.internal.ViewHierarchy";
    private static Method methodFindTouchTargetView = null;

    public static ViewGroup getParentOfView(View view) {
        if (view == null) {
            return null;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            return (ViewGroup) parent;
        }
        return null;
    }

    public static List<View> getChildrenOfView(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                arrayList.add(viewGroup.getChildAt(i));
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
     arg types: [java.lang.String, int]
     candidates:
      org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject */
    public static void updateBasicInfoOfView(View view, JSONObject jSONObject) {
        try {
            String textOfView = getTextOfView(view);
            String hintOfView = getHintOfView(view);
            Object tag = view.getTag();
            CharSequence contentDescription = view.getContentDescription();
            jSONObject.put("classname", view.getClass().getCanonicalName());
            jSONObject.put("classtypebitmask", getClassTypeBitmask(view));
            jSONObject.put("id", view.getId());
            if (!SensitiveUserDataUtils.isSensitiveUserData(view)) {
                jSONObject.put("text", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(textOfView), ""));
            } else {
                jSONObject.put("text", "");
                jSONObject.put("is_user_input", true);
            }
            jSONObject.put("hint", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(hintOfView), ""));
            if (tag != null) {
                jSONObject.put("tag", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(tag.toString()), ""));
            }
            if (contentDescription != null) {
                jSONObject.put("description", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(contentDescription.toString()), ""));
            }
            jSONObject.put("dimension", getDimensionOfView(view));
        } catch (JSONException e) {
            Utility.logd(TAG, e);
        }
    }

    public static void updateAppearanceOfView(View view, JSONObject jSONObject, float f) {
        Bitmap bitmap;
        TextView textView;
        Typeface typeface;
        try {
            JSONObject jSONObject2 = new JSONObject();
            if ((view instanceof TextView) && (typeface = (textView = (TextView) view).getTypeface()) != null) {
                jSONObject2.put("font_size", (double) textView.getTextSize());
                jSONObject2.put("is_bold", typeface.isBold());
                jSONObject2.put("is_italic", typeface.isItalic());
                jSONObject.put("text_style", jSONObject2);
            }
            if (view instanceof ImageView) {
                Drawable drawable = ((ImageView) view).getDrawable();
                if ((drawable instanceof BitmapDrawable) && ((float) view.getHeight()) / f <= 44.0f && ((float) view.getWidth()) / f <= 44.0f && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    jSONObject.put("icon_image", Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
                }
            }
        } catch (JSONException e) {
            Utility.logd(TAG, e);
        }
    }

    public static JSONObject getDictionaryOfView(View view) {
        if (view.getClass().getName().equals("com.facebook.react.ReactRootView")) {
            RCTRootViewReference = new WeakReference<>(view);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            updateBasicInfoOfView(view, jSONObject);
            JSONArray jSONArray = new JSONArray();
            List<View> childrenOfView = getChildrenOfView(view);
            for (int i = 0; i < childrenOfView.size(); i++) {
                jSONArray.put(getDictionaryOfView(childrenOfView.get(i)));
            }
            jSONObject.put("childviews", jSONArray);
        } catch (JSONException e) {
            Log.e(TAG, "Failed to create JSONObject for view.", e);
        }
        return jSONObject;
    }

    public static int getClassTypeBitmask(View view) {
        int i = view instanceof ImageView ? 2 : 0;
        if (view.isClickable()) {
            i |= 32;
        }
        if (isAdapterViewItem(view)) {
            i |= 512;
        }
        if (view instanceof TextView) {
            int i2 = i | 1024 | 1;
            if (view instanceof Button) {
                i2 |= 4;
                if (view instanceof Switch) {
                    i2 |= 8192;
                } else if (view instanceof CheckBox) {
                    i2 |= 32768;
                }
            }
            if (view instanceof EditText) {
                return i2 | 2048;
            }
            return i2;
        } else if ((view instanceof Spinner) || (view instanceof DatePicker)) {
            return i | 4096;
        } else {
            if (view instanceof RatingBar) {
                return i | 65536;
            }
            if (view instanceof RadioGroup) {
                return i | 16384;
            }
            return (!(view instanceof ViewGroup) || !isRCTButton(view, RCTRootViewReference.get())) ? i : i | 64;
        }
    }

    private static boolean isAdapterViewItem(View view) {
        ViewParent parent = view.getParent();
        return (parent instanceof AdapterView) || (parent instanceof bo);
    }

    public static String getTextOfView(View view) {
        Object selectedItem;
        Object obj = null;
        if (view instanceof TextView) {
            obj = ((TextView) view).getText();
            if (view instanceof Switch) {
                obj = ((Switch) view).isChecked() ? "1" : "0";
            }
        } else if (view instanceof Spinner) {
            Spinner spinner = (Spinner) view;
            if (spinner.getCount() > 0 && (selectedItem = spinner.getSelectedItem()) != null) {
                obj = selectedItem.toString();
            }
        } else {
            int i = 0;
            if (view instanceof DatePicker) {
                DatePicker datePicker = (DatePicker) view;
                obj = String.format("%04d-%02d-%02d", Integer.valueOf(datePicker.getYear()), Integer.valueOf(datePicker.getMonth()), Integer.valueOf(datePicker.getDayOfMonth()));
            } else if (view instanceof TimePicker) {
                TimePicker timePicker = (TimePicker) view;
                obj = String.format("%02d:%02d", Integer.valueOf(timePicker.getCurrentHour().intValue()), Integer.valueOf(timePicker.getCurrentMinute().intValue()));
            } else if (view instanceof RadioGroup) {
                RadioGroup radioGroup = (RadioGroup) view;
                int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                int childCount = radioGroup.getChildCount();
                while (true) {
                    if (i >= childCount) {
                        break;
                    }
                    View childAt = radioGroup.getChildAt(i);
                    if (childAt.getId() == checkedRadioButtonId && (childAt instanceof RadioButton)) {
                        obj = ((RadioButton) childAt).getText();
                        break;
                    }
                    i++;
                }
            } else if (view instanceof RatingBar) {
                obj = String.valueOf(((RatingBar) view).getRating());
            }
        }
        if (obj == null) {
            return "";
        }
        return obj.toString();
    }

    public static String getHintOfView(View view) {
        CharSequence charSequence;
        if (view instanceof EditText) {
            charSequence = ((EditText) view).getHint();
        } else {
            charSequence = view instanceof TextView ? ((TextView) view).getHint() : null;
        }
        if (charSequence == null) {
            return "";
        }
        return charSequence.toString();
    }

    private static JSONObject getDimensionOfView(View view) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("top", view.getTop());
            jSONObject.put("left", view.getLeft());
            jSONObject.put("width", view.getWidth());
            jSONObject.put("height", view.getHeight());
            jSONObject.put("scrollx", view.getScrollX());
            jSONObject.put("scrolly", view.getScrollY());
            jSONObject.put("visibility", view.getVisibility());
        } catch (JSONException e) {
            Log.e(TAG, "Failed to create JSONObject for dimension.", e);
        }
        return jSONObject;
    }

    public static View.OnClickListener getExistingOnClickListener(View view) {
        try {
            Field declaredField = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (declaredField != null) {
                declaredField.setAccessible(true);
            }
            Object obj = declaredField.get(view);
            if (obj == null) {
                return null;
            }
            Field declaredField2 = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener");
            if (declaredField2 == null) {
                return null;
            }
            declaredField2.setAccessible(true);
            return (View.OnClickListener) declaredField2.get(obj);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001e A[ADDED_TO_REGION] */
    public static void setOnClickListener(View view, View.OnClickListener onClickListener) {
        Field field;
        Field field2;
        Object obj = null;
        try {
            field2 = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            try {
                field = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener");
            } catch (ClassNotFoundException | NoSuchFieldException unused) {
                field = null;
                if (field2 != null) {
                }
                view.setOnClickListener(onClickListener);
                return;
            }
        } catch (ClassNotFoundException | NoSuchFieldException unused2) {
            field2 = null;
            field = null;
            if (field2 != null) {
            }
            view.setOnClickListener(onClickListener);
            return;
        }
        if (field2 != null || field == null) {
            view.setOnClickListener(onClickListener);
            return;
        }
        try {
            field2.setAccessible(true);
            field.setAccessible(true);
            try {
                field2.setAccessible(true);
                obj = field2.get(view);
            } catch (IllegalAccessException unused3) {
            }
            if (obj == null) {
                view.setOnClickListener(onClickListener);
            } else {
                field.set(obj, onClickListener);
            }
        } catch (Exception unused4) {
        }
    }

    public static View.OnTouchListener getExistingOnTouchListener(View view) {
        try {
            Field declaredField = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (declaredField != null) {
                declaredField.setAccessible(true);
            }
            Object obj = declaredField.get(view);
            if (obj == null) {
                return null;
            }
            Field declaredField2 = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnTouchListener");
            if (declaredField2 == null) {
                return null;
            }
            declaredField2.setAccessible(true);
            return (View.OnTouchListener) declaredField2.get(obj);
        } catch (NoSuchFieldException e) {
            Utility.logd(TAG, e);
            return null;
        } catch (ClassNotFoundException e2) {
            Utility.logd(TAG, e2);
            return null;
        } catch (IllegalAccessException e3) {
            Utility.logd(TAG, e3);
            return null;
        }
    }

    public static View getTouchReactView(float[] fArr, View view) {
        View view2;
        initTouchTargetHelperMethods();
        Method method = methodFindTouchTargetView;
        if (!(method == null || view == null)) {
            try {
                View view3 = (View) method.invoke(null, fArr, view);
                if (view3 == null || view3.getId() <= 0 || (view2 = (View) view3.getParent()) == null) {
                    return null;
                }
                return view2;
            } catch (IllegalAccessException e) {
                Utility.logd(TAG, e);
            } catch (InvocationTargetException e2) {
                Utility.logd(TAG, e2);
            }
        }
        return null;
    }

    public static boolean isRCTButton(View view, View view2) {
        View touchReactView;
        if (!view.getClass().getName().equals("com.facebook.react.views.view.ReactViewGroup") || (touchReactView = getTouchReactView(getViewLocationOnScreen(view), view2)) == null || touchReactView.getId() != view.getId()) {
            return false;
        }
        return true;
    }

    public static boolean isRCTRootView(View view) {
        return view.getClass().getName().equals("com.facebook.react.ReactRootView");
    }

    public static boolean isRCTTextView(View view) {
        return view.getClass().getName().equals("com.facebook.react.views.view.ReactTextView");
    }

    public static boolean isRCTViewGroup(View view) {
        return view.getClass().getName().equals("com.facebook.react.views.view.ReactViewGroup");
    }

    public static View findRCTRootView(View view) {
        while (view != null) {
            if (isRCTRootView(view)) {
                return view;
            }
            ViewParent parent = view.getParent();
            if (!(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
        return null;
    }

    private static float[] getViewLocationOnScreen(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new float[]{(float) iArr[0], (float) iArr[1]};
    }

    private static void initTouchTargetHelperMethods() {
        if (methodFindTouchTargetView == null) {
            try {
                Method declaredMethod = Class.forName("com.facebook.react.uimanager.TouchTargetHelper").getDeclaredMethod("findTouchTargetView", float[].class, ViewGroup.class);
                methodFindTouchTargetView = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (ClassNotFoundException e) {
                Utility.logd(TAG, e);
            } catch (NoSuchMethodException e2) {
                Utility.logd(TAG, e2);
            }
        }
    }
}
