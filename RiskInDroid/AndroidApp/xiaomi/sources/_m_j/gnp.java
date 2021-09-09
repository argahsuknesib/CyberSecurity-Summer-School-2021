package _m_j;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;

public final class gnp {
    public static void O000000o(Context context, MLAlertDialog mLAlertDialog) {
        Window window;
        ViewGroup viewGroup;
        ViewParent parent;
        if (context != null && mLAlertDialog != null && (window = mLAlertDialog.getWindow()) != null && (viewGroup = (ViewGroup) window.findViewById(R.id.parentPanel)) != null && (parent = viewGroup.getParent()) != null && (parent instanceof ViewGroup)) {
            ViewGroup viewGroup2 = (ViewGroup) parent;
            viewGroup.setBackground(new ColorDrawable(context.getResources().getColor(R.color.mj_color_dialog_bg_nor)));
            viewGroup2.removeView(viewGroup);
            CardView cardView = new CardView(context);
            cardView.setRadius((float) gpc.O000000o(18.0f));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            int O000000o2 = gpc.O000000o(8.0f);
            layoutParams.bottomMargin = O000000o2;
            layoutParams.rightMargin = O000000o2;
            layoutParams.topMargin = O000000o2;
            layoutParams.leftMargin = O000000o2;
            cardView.addView(viewGroup, new ViewGroup.MarginLayoutParams(-1, -1));
            viewGroup2.addView(cardView, layoutParams);
        }
    }
}
