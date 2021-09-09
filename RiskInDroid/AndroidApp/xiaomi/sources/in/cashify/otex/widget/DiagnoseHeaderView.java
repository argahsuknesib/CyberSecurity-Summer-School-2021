package in.cashify.otex.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class DiagnoseHeaderView extends LinearLayout {
    public View O0000Ooo;

    public DiagnoseHeaderView(Context context) {
        super(context);
    }

    public DiagnoseHeaderView(Context context, int i) {
        super(context);
        O000000o(context, i);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, in.cashify.otex.widget.DiagnoseHeaderView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public void O000000o(Context context, int i) {
        this.O0000Ooo = LayoutInflater.from(context).inflate(i, (ViewGroup) this, true);
    }
}
