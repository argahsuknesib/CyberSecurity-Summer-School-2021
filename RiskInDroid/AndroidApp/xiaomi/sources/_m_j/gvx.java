package _m_j;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public final class gvx extends gvz {
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TextView textView = new TextView(getContext());
        textView.setText("组件解耦占位空页面");
        textView.setTextSize(20.0f);
        textView.setGravity(17);
        return textView;
    }
}
