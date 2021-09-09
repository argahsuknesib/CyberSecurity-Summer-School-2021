package com.xiaomi.passport.ui.internal;

import _m_j.ehc;
import _m_j.iuj;
import _m_j.ixe;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0013H\u0016J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\u0015\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u001cJ\"\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010 \u001a\u00020!H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX.¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006\""}, d2 = {"Lcom/xiaomi/passport/ui/internal/AreaCodePickerAdapter;", "Landroid/widget/BaseAdapter;", "Landroid/widget/SectionIndexer;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mList", "", "Lcom/xiaomi/passport/ui/internal/PhoneNumUtil$CountryPhoneNumData;", "mPositionForSection", "", "mSectionForPosition", "mSections", "", "", "[Ljava/lang/String;", "buildPickerSectionList", "", "getCount", "", "getItem", "position", "getItemId", "", "getPositionForSection", "section", "getSectionForPosition", "getSections", "()[Ljava/lang/String;", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class AreaCodePickerAdapter extends BaseAdapter implements SectionIndexer {

    /* renamed from: O000000o  reason: collision with root package name */
    private List<ehc.O000000o> f6237O000000o;
    private String[] O00000Oo;
    private int[] O00000o;
    private int[] O00000o0;
    private final Context O00000oO;

    public final long getItemId(int i) {
        return (long) i;
    }

    public AreaCodePickerAdapter(Context context) {
        ixe.O00000o0(context, "mContext");
        this.O00000oO = context;
        O000000o();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [java.util.List<_m_j.ehc$O000000o>, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [java.lang.String[], java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    private final void O000000o() {
        int i;
        List<ehc.O000000o> O00000Oo2 = ehc.O00000Oo(this.O00000oO);
        List<ehc.O000000o> O000000o2 = ehc.O000000o(this.O00000oO);
        this.f6237O000000o = new ArrayList(O00000Oo2);
        List<ehc.O000000o> list = this.f6237O000000o;
        if (list == null) {
            ixe.O000000o("mList");
        }
        ixe.O000000o((Object) O000000o2, "totalList");
        list.addAll(O000000o2);
        String[] stringArray = this.O00000oO.getResources().getStringArray(R.array.alphabet_table);
        ixe.O000000o((Object) stringArray, "mContext.resources.getSt…y(R.array.alphabet_table)");
        this.O00000Oo = stringArray;
        int count = getCount();
        int[] iArr = new int[count];
        for (int i2 = 0; i2 < count; i2++) {
            iArr[i2] = 0;
        }
        this.O00000o = iArr;
        String[] strArr = this.O00000Oo;
        if (strArr == null) {
            ixe.O000000o("mSections");
        }
        int[] iArr2 = new int[strArr.length];
        int length = iArr2.length;
        for (int i3 = 0; i3 < length; i3++) {
            iArr2[i3] = 0;
        }
        this.O00000o0 = iArr2;
        int count2 = getCount();
        int i4 = -1;
        for (int i5 = 0; i5 < count2; i5++) {
            if (i5 >= O00000Oo2.size()) {
                String str = getItem(i5).f15276O000000o;
                ixe.O000000o((Object) str, "getItem(i).countryName");
                if (str != null) {
                    String substring = str.substring(0, 1);
                    ixe.O000000o((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    if (substring != null) {
                        String upperCase = substring.toUpperCase();
                        ixe.O000000o((Object) upperCase, "(this as java.lang.String).toUpperCase()");
                        String[] strArr2 = this.O00000Oo;
                        if (strArr2 == null) {
                            ixe.O000000o("mSections");
                        }
                        i = iuj.O00000Oo(strArr2, upperCase);
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                i = 0;
            }
            if (i == -1) {
                i = 0;
            }
            int[] iArr3 = this.O00000o;
            if (iArr3 == null) {
                ixe.O000000o("mSectionForPosition");
            }
            iArr3[i5] = i;
            if (i4 != i) {
                while (i4 < i) {
                    int[] iArr4 = this.O00000o0;
                    if (iArr4 == null) {
                        ixe.O000000o("mPositionForSection");
                    }
                    i4++;
                    iArr4[i4] = i5;
                }
                i4 = i;
            }
        }
    }

    public final int getCount() {
        List<ehc.O000000o> list = this.f6237O000000o;
        if (list == null) {
            ixe.O000000o("mList");
        }
        return list.size();
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public ehc.O000000o getItem(int i) {
        List<ehc.O000000o> list = this.f6237O000000o;
        if (list == null) {
            ixe.O000000o("mList");
        }
        return list.get(i);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AreaCodePickerListItem areaCodePickerListItem;
        ixe.O00000o0(viewGroup, "parent");
        if (view == null) {
            View inflate = View.inflate(this.O00000oO, R.layout.passport_area_code_list_item_internal, null);
            if (inflate != null) {
                areaCodePickerListItem = (AreaCodePickerListItem) inflate;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.xiaomi.passport.ui.internal.AreaCodePickerListItem");
            }
        } else {
            areaCodePickerListItem = (AreaCodePickerListItem) view;
        }
        ehc.O000000o O000000o2 = getItem(i);
        ixe.O00000o0(O000000o2, "data");
        TextView textView = areaCodePickerListItem.f6238O000000o;
        if (textView != null) {
            textView.setText(O000000o2.f15276O000000o);
        }
        TextView textView2 = areaCodePickerListItem.O00000Oo;
        if (textView2 != null) {
            textView2.setText("+" + O000000o2.O00000Oo);
        }
        if (!TextUtils.isEmpty(null)) {
            TextView textView3 = areaCodePickerListItem.O00000o0;
            if (textView3 != null) {
                textView3.setText((CharSequence) null);
            }
            View view2 = areaCodePickerListItem.O00000o;
            if (view2 != null) {
                view2.setVisibility(0);
            }
        } else {
            View view3 = areaCodePickerListItem.O00000o;
            if (view3 != null) {
                view3.setVisibility(8);
            }
        }
        return areaCodePickerListItem;
    }

    public final int getPositionForSection(int i) {
        int[] iArr = this.O00000o0;
        if (iArr == null) {
            ixe.O000000o("mPositionForSection");
        }
        return iArr[i];
    }

    public final int getSectionForPosition(int i) {
        int[] iArr = this.O00000o;
        if (iArr == null) {
            ixe.O000000o("mSectionForPosition");
        }
        return iArr[i];
    }

    public final /* synthetic */ Object[] getSections() {
        String[] strArr = this.O00000Oo;
        if (strArr == null) {
            ixe.O000000o("mSections");
        }
        return strArr;
    }
}
