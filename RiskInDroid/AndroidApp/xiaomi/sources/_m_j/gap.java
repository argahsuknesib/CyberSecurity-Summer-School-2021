package _m_j;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.os.Build;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Locale;
import java.util.Stack;

public final class gap {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Matrix f17467O000000o = new Matrix();

    public static int O000000o(String str, String str2) {
        int i = 0;
        while (str2.length() > 0) {
            int indexOf = str2.indexOf("\n");
            int min = Math.min(str2.length(), Math.min(indexOf < 0 ? 200 : indexOf + 1, 200));
            gsy.O000000o(3, str, String.format(Locale.US, "%02d: %s", Integer.valueOf(i), str2.substring(0, min)));
            str2 = str2.substring(min);
            i++;
        }
        return i;
    }

    public static String O000000o(Activity activity) {
        View findViewById = activity.findViewById(16908290);
        if (findViewById != null) {
            return O000000o(findViewById);
        }
        return "Activity [" + activity.getClass().getSimpleName() + "] is not initialized yet. ";
    }

    private static String O000000o(View view) {
        StringBuilder sb = new StringBuilder(8192);
        sb.append("\n");
        Resources resources = view.getResources();
        Stack stack = new Stack();
        stack.push(Pair.create("", view));
        while (!stack.empty()) {
            Pair pair = (Pair) stack.pop();
            View view2 = (View) pair.second;
            String str = (String) pair.first;
            boolean z = stack.empty() || !str.equals(((Pair) stack.peek()).first);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(z ? "└── " : "├── ");
            String sb3 = sb2.toString();
            String simpleName = view2.getClass().getSimpleName();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(sb3);
            sb4.append(simpleName);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(" id=");
            sb5.append(view2.getId());
            sb5.append(O000000o(resources, view2));
            int visibility = view2.getVisibility();
            if (visibility == 0) {
                sb5.append(", V--");
            } else if (visibility == 4) {
                sb5.append(", -I-");
            } else if (visibility != 8) {
                sb5.append(", ---");
            } else {
                sb5.append(", --G");
            }
            if (!view2.getMatrix().equals(f17467O000000o)) {
                sb5.append(", matrix=");
                sb5.append(view2.getMatrix().toShortString());
                if (!(0.0f == view2.getRotation() && 0.0f == view2.getRotationX() && 0.0f == view2.getRotationY())) {
                    sb5.append(", rotate=[");
                    sb5.append(view2.getRotation());
                    sb5.append(",");
                    sb5.append(view2.getRotationX());
                    sb5.append(",");
                    sb5.append(view2.getRotationY());
                    sb5.append("]");
                    if (!(((float) (view2.getWidth() / 2)) == view2.getPivotX() && ((float) (view2.getHeight() / 2)) == view2.getPivotY())) {
                        sb5.append(", pivot=[");
                        sb5.append(view2.getPivotX());
                        sb5.append(",");
                        sb5.append(view2.getPivotY());
                        sb5.append("]");
                    }
                }
                if (Build.VERSION.SDK_INT >= 21 && !(0.0f == view2.getTranslationX() && 0.0f == view2.getTranslationY() && 0.0f == view2.getTranslationZ())) {
                    sb5.append(", translate=[");
                    sb5.append(view2.getTranslationX());
                    sb5.append(",");
                    sb5.append(view2.getTranslationY());
                    sb5.append(",");
                    sb5.append(view2.getTranslationZ());
                    sb5.append("]");
                }
                if (!(1.0f == view2.getScaleX() && 1.0f == view2.getScaleY())) {
                    sb5.append(", scale=[");
                    sb5.append(view2.getScaleX());
                    sb5.append(",");
                    sb5.append(view2.getScaleY());
                    sb5.append("]");
                }
            }
            if (!(view2.getPaddingStart() == 0 && view2.getPaddingTop() == 0 && view2.getPaddingEnd() == 0 && view2.getPaddingBottom() == 0)) {
                sb5.append(", padding=[");
                sb5.append(view2.getPaddingStart());
                sb5.append(",");
                sb5.append(view2.getPaddingTop());
                sb5.append(",");
                sb5.append(view2.getPaddingEnd());
                sb5.append(",");
                sb5.append(view2.getPaddingBottom());
                sb5.append("]");
            }
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                if (!(marginLayoutParams.leftMargin == 0 && marginLayoutParams.topMargin == 0 && marginLayoutParams.rightMargin == 0 && marginLayoutParams.bottomMargin == 0)) {
                    sb5.append(", margin=[");
                    sb5.append(marginLayoutParams.leftMargin);
                    sb5.append(",");
                    sb5.append(marginLayoutParams.topMargin);
                    sb5.append(",");
                    sb5.append(marginLayoutParams.rightMargin);
                    sb5.append(",");
                    sb5.append(marginLayoutParams.bottomMargin);
                    sb5.append("]");
                }
            }
            sb5.append(", position=[");
            sb5.append(view2.getLeft());
            sb5.append(",");
            sb5.append(view2.getTop());
            sb5.append("]");
            sb5.append(", size=[");
            sb5.append(view2.getWidth());
            sb5.append(",");
            sb5.append(view2.getHeight());
            sb5.append("]");
            if (view2 instanceof TextView) {
                sb5.append(", text=\"");
                sb5.append(((TextView) view2).getText());
                sb5.append(jdn.f1779O000000o);
            }
            sb4.append(sb5.toString());
            sb.append(sb4.toString());
            sb.append("\n");
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(str);
                    sb6.append(z ? "    " : "│   ");
                    stack.push(Pair.create(sb6.toString(), viewGroup.getChildAt(childCount)));
                }
            }
        }
        return sb.toString();
    }

    private static String O000000o(Resources resources, View view) {
        if (resources == null) {
            return "";
        }
        try {
            return " / " + resources.getResourceEntryName(view.getId());
        } catch (Throwable unused) {
            return "";
        }
    }
}
