package _m_j;

import _m_j.eki;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.xiaomi.passport.ui.R$id;
import com.xiaomi.passport.ui.settings.AreaCodePickerListItem;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public final class ejm extends BaseAdapter implements SectionIndexer {

    /* renamed from: O000000o  reason: collision with root package name */
    List<eki.O000000o> f15522O000000o;
    private Context O00000Oo;
    private String[] O00000o;
    private Map<Integer, String> O00000o0;
    private int[] O00000oO;
    private boolean O00000oo = true;

    public final long getItemId(int i) {
        return (long) i;
    }

    public ejm(Context context, Bundle bundle) {
        this.O00000Oo = context;
        O000000o();
        if (bundle != null) {
            this.O00000oo = bundle.getBoolean("show_country_code", true);
        }
    }

    private void O000000o() {
        int i;
        this.f15522O000000o = eki.O000000o();
        TreeSet treeSet = new TreeSet();
        ArrayList arrayList = new ArrayList();
        Iterator<eki.O000000o> it = this.f15522O000000o.iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            String upperCase = it.next().f15572O000000o.substring(0, 1).toUpperCase();
            arrayList.add(upperCase);
            treeSet.add(upperCase);
        }
        this.O00000o = (String[]) treeSet.toArray(new String[0]);
        this.O00000oO = new int[this.O00000o.length];
        this.O00000o0 = new HashMap();
        while (true) {
            String[] strArr = this.O00000o;
            if (i < strArr.length) {
                this.O00000oO[i] = arrayList.indexOf(strArr[i]);
                this.O00000o0.put(Integer.valueOf(this.O00000oO[i]), this.O00000o[i]);
                i++;
            } else {
                return;
            }
        }
    }

    public final int getCount() {
        return this.f15522O000000o.size();
    }

    /* renamed from: O000000o */
    public final eki.O000000o getItem(int i) {
        return this.f15522O000000o.get(i);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AreaCodePickerListItem areaCodePickerListItem = (AreaCodePickerListItem) view;
        if (areaCodePickerListItem == null) {
            areaCodePickerListItem = (AreaCodePickerListItem) ((LayoutInflater) this.O00000Oo.getSystemService("layout_inflater")).inflate((int) R.layout.passport_area_code_list_item, (ViewGroup) null);
        }
        ((TextView) areaCodePickerListItem.findViewById(R$id.area_code)).setVisibility(this.O00000oo ? 0 : 8);
        eki.O000000o O000000o2 = getItem(i);
        String str = this.O00000o0.get(Integer.valueOf(i));
        areaCodePickerListItem.f6288O000000o.setText(O000000o2.f15572O000000o);
        areaCodePickerListItem.O00000Oo.setText(O000000o2.O00000Oo);
        if (!TextUtils.isEmpty(str)) {
            areaCodePickerListItem.O00000o0.setText(str);
            areaCodePickerListItem.O00000o.setVisibility(0);
        } else {
            areaCodePickerListItem.O00000o.setVisibility(8);
        }
        return areaCodePickerListItem;
    }

    public final Object[] getSections() {
        return this.O00000o;
    }

    public final int getPositionForSection(int i) {
        return this.O00000oO[i];
    }

    public final int getSectionForPosition(int i) {
        int i2 = 1;
        int i3 = 0;
        while (true) {
            int[] iArr = this.O00000oO;
            if (i2 >= iArr.length || iArr[i2] > i) {
                return i3;
            }
            i3++;
            i2++;
        }
        return i3;
    }
}
