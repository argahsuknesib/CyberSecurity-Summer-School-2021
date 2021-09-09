package _m_j;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.mi.blockcanary.ui.DisplayConnectorView;
import com.mi.blockcanary.ui.MoreDetailsView;
import com.xiaomi.smarthome.R;
import java.util.Iterator;

public final class byk extends BaseAdapter {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean[] f13409O000000o = new boolean[0];
    public bye O00000Oo;

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getItemViewType(int i) {
        return i == 0 ? 0 : 1;
    }

    public final int getViewTypeCount() {
        return 2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View getView(int i, View view, ViewGroup viewGroup) {
        String str;
        DisplayConnectorView.Type type;
        Context context = viewGroup.getContext();
        if (getItemViewType(i) == 0) {
            if (view == null) {
                view = LayoutInflater.from(context).inflate((int) R.layout.block_canary_ref_top_row, viewGroup, false);
            }
            ((TextView) view.findViewById(R.id.__leak_canary_row_text)).setText(context.getPackageName());
        } else {
            if (view == null) {
                view = LayoutInflater.from(context).inflate((int) R.layout.block_canary_ref_row, viewGroup, false);
            }
            TextView textView = (TextView) view.findViewById(R.id.__leak_canary_row_text);
            boolean z = i == 5;
            String O000000o2 = getItem(i);
            boolean z2 = this.f13409O000000o[i];
            String replaceAll = O000000o2.replaceAll("\r\n", "<br>");
            if (i == 1) {
                if (z2) {
                    replaceAll = replaceAll.substring(replaceAll.indexOf("cpu_core"));
                }
                str = String.format("<font color='#c48a47'>%s</font> ", replaceAll);
            } else if (i == 2) {
                if (z2) {
                    replaceAll = replaceAll.substring(0, replaceAll.indexOf("time_start"));
                }
                str = String.format("<font color='#f3cf83'>%s</font> ", replaceAll);
            } else if (i != 3) {
                if (z2) {
                    Iterator<String> it = byi.O000000o().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            int indexOf = replaceAll.indexOf(it.next());
                            if (indexOf > 0) {
                                replaceAll = replaceAll.substring(indexOf);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                str = String.format("<font color='#ffffff'>%s</font> ", replaceAll);
            } else {
                if (z2) {
                    O000000o2 = O000000o2.substring(0, O000000o2.indexOf("cpu_rate"));
                }
                str = String.format("<font color='#998bb5'>%s</font> ", O000000o2.replace("cpurate = ", "<br>cpurate<br/>")).replaceAll("]", "]<br>");
            }
            if (z && !this.f13409O000000o[i]) {
                str = str + " <font color='#919191'>blocked</font>";
            }
            textView.setText(Html.fromHtml(str));
            DisplayConnectorView displayConnectorView = (DisplayConnectorView) view.findViewById(R.id.__leak_canary_row_connector);
            if (i == 1) {
                type = DisplayConnectorView.Type.START;
            } else {
                type = i == getCount() - 1 ? DisplayConnectorView.Type.END : DisplayConnectorView.Type.NODE;
            }
            displayConnectorView.setType(type);
            ((MoreDetailsView) view.findViewById(R.id.__leak_canary_row_more)).setFolding(this.f13409O000000o[i]);
        }
        return view;
    }

    public final int getCount() {
        bye bye = this.O00000Oo;
        if (bye == null) {
            return 0;
        }
        return bye.O0000o0O.size() + 4;
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public String getItem(int i) {
        if (getItemViewType(i) == 0) {
            return null;
        }
        if (i == 1) {
            return this.O00000Oo.O0000o0o.toString();
        }
        if (i == 2) {
            return this.O00000Oo.O0000oO0.toString();
        }
        if (i != 3) {
            return this.O00000Oo.O0000o0O.get(i - 4);
        }
        return this.O00000Oo.O0000o.toString();
    }
}
