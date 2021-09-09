package _m_j;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.newui.widget.FlowLayoutCopy;
import com.xiaomi.smarthome.newui.widget.topnavi.PageBean;
import java.util.List;

public class hhn extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
    private static final String O00000o0 = "hhn";

    /* renamed from: O000000o  reason: collision with root package name */
    public PageBean f18949O000000o;
    public TextView O00000Oo = null;
    private List<PageBean.O00000Oo> O00000o;
    private Context O00000oO;

    public hhn(Context context, List<PageBean.O00000Oo> list, PageBean pageBean) {
        this.O00000oO = context;
        this.O00000o = list;
        this.f18949O000000o = pageBean;
    }

    public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new O000000o(new FlowLayoutCopy(this.O00000oO));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.smarthome.newui.widget.FlowLayoutCopy, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        O000000o o000000o = (O000000o) o000OOo0;
        PageBean.O00000Oo o00000Oo = this.O00000o.get(i);
        FlowLayoutCopy flowLayoutCopy = o000000o.f18951O000000o;
        Context context = flowLayoutCopy.getContext();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) flowLayoutCopy.getLayoutParams();
        if (marginLayoutParams == null) {
            marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
            flowLayoutCopy.setLayoutParams(marginLayoutParams);
        }
        if (i == 0) {
            marginLayoutParams.topMargin = gpc.O000000o(8.0f);
            marginLayoutParams.bottomMargin = getItemCount() == 1 ? gpc.O000000o(14.0f) : 0;
        } else if (i == getItemCount() - 1) {
            marginLayoutParams.topMargin = gpc.O000000o(18.0f);
            marginLayoutParams.bottomMargin = gpc.O000000o(14.0f);
        } else {
            marginLayoutParams.topMargin = gpc.O000000o(14.0f);
            marginLayoutParams.bottomMargin = 0;
        }
        flowLayoutCopy.removeAllViews();
        boolean z = false;
        for (final PageBean next : o00000Oo.O00000Oo) {
            if (next.O00000o0 && !z) {
                ImageView imageView = new ImageView(context);
                imageView.setPadding(0, gpc.O000000o(30.0f), gpc.O000000o(15.0f), gpc.O000000o(30.0f));
                imageView.setImageResource(R.color.mj_color_black_20_transparent);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, 1));
                o000000o.f18951O000000o.addView(imageView);
                z = true;
            }
            final TextView textView = (TextView) LayoutInflater.from(context).inflate((int) R.layout.room_flow_item, (ViewGroup) o000000o.f18951O000000o, false);
            textView.setText(next.f10340O000000o != null ? next.f10340O000000o : "");
            PageBean pageBean = this.f18949O000000o;
            if (pageBean == null || TextUtils.isEmpty(pageBean.O00000Oo) || !next.O00000Oo.equals(this.f18949O000000o.O00000Oo)) {
                textView.setSelected(false);
            } else {
                textView.setSelected(true);
            }
            textView.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.hhn.AnonymousClass1 */

                public final void onClick(View view) {
                    TextView textView = hhn.this.O00000Oo;
                    if (!(textView == null || textView == view)) {
                        textView.setSelected(false);
                    }
                    hhn hhn = hhn.this;
                    hhn.O00000Oo = (TextView) view;
                    hhn.f18949O000000o = next;
                    textView.setSelected(true);
                    hhn hhn2 = hhn.this;
                    String str = next.O00000Oo;
                    Intent intent = new Intent("action_room_selected");
                    intent.putExtra("extra_room_selected_id", str);
                    ft.O000000o(CommonApplication.getAppContext()).O000000o(intent);
                    hhn2.O00000Oo = null;
                    try {
                        if (next.O00000o0) {
                            hxi.O00000o.O00000o0(4);
                        } else if ("mijia.roomid.all".equals(next.O00000Oo)) {
                            hxi.O00000o.O00000o0(1);
                        } else if ("mijia.roomid.share".equals(next.O00000Oo)) {
                            hxi.O00000o.O00000o0(2);
                        } else if ("mijia.roomid.nearby".equals(next.O00000Oo)) {
                            hxi.O00000o.O00000o0(3);
                        } else if ("mijia.roomid.common".equals(next.O00000Oo)) {
                            hxi.O00000o.O00000o0(5);
                        } else if ("mijia.roomid.uncommon".equals(next.O00000Oo)) {
                            hxi.O00000o.O00000o0(6);
                        }
                        hxk hxk = hxi.O00000o;
                        String str2 = next.f10340O000000o;
                        hxk.f952O000000o.O000000o("all.device.panel", "time", Long.valueOf(System.currentTimeMillis()), "uid", fcn.O000000o().O00000Oo(), "name", str2);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            o000000o.f18951O000000o.addView(textView);
        }
    }

    public int getItemCount() {
        return this.O00000o.size();
    }

    static class O000000o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public FlowLayoutCopy f18951O000000o;

        public O000000o(View view) {
            super(view);
            this.f18951O000000o = (FlowLayoutCopy) view;
            this.f18951O000000o.setSingleLine(false);
            this.f18951O000000o.setItemSpacing(gpc.O000000o(10.0f));
            this.f18951O000000o.setLineSpacing(gpc.O000000o(14.0f));
        }
    }
}
