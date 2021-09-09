package _m_j;

import _m_j.ehc;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.xiaomi.passport.ui.R$id;
import com.xiaomi.passport.ui.internal.AlphabetFastIndexer;
import com.xiaomi.passport.ui.internal.AreaCodePickerAdapter;
import com.xiaomi.smarthome.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/xiaomi/passport/ui/internal/AreaCodePickerFragment;", "Landroidx/fragment/app/Fragment;", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class efr extends Fragment {

    /* renamed from: O000000o  reason: collision with root package name */
    private HashMap f15230O000000o;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ixe.O00000o0(layoutInflater, "inflater");
        return layoutInflater.inflate((int) R.layout.area_code_picker, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        ixe.O00000o0(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R$id.fast_indexer_list);
        if (findViewById != null) {
            ListView listView = (ListView) findViewById;
            listView.setDividerHeight(0);
            FragmentActivity activity = getActivity();
            if (activity == null) {
                ixe.O000000o();
            }
            listView.setAdapter((ListAdapter) new AreaCodePickerAdapter(activity));
            listView.setOnItemClickListener(new O000000o(this, listView));
            View findViewById2 = view.findViewById(R$id.fast_indexer);
            if (findViewById2 != null) {
                AlphabetFastIndexer alphabetFastIndexer = (AlphabetFastIndexer) findViewById2;
                listView.setOnScrollListener(new O00000Oo(alphabetFastIndexer, alphabetFastIndexer));
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.xiaomi.passport.ui.internal.AlphabetFastIndexer");
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.ListView");
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/View;", "position", "", "<anonymous parameter 3>", "", "onItemClick"}, k = 3, mv = {1, 1, 10})
    static final class O000000o implements AdapterView.OnItemClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ efr f15231O000000o;
        final /* synthetic */ ListView O00000Oo;

        O000000o(efr efr, ListView listView) {
            this.f15231O000000o = efr;
            this.O00000Oo = listView;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Object item = this.O00000Oo.getAdapter().getItem(i);
            if (item != null) {
                ehc.O000000o o000000o = (ehc.O000000o) item;
                Intent intent = new Intent();
                intent.putExtra("iso", o000000o.O00000o0);
                intent.putExtra("code", o000000o.O00000Oo);
                FragmentActivity activity = this.f15231O000000o.getActivity();
                if (activity != null) {
                    activity.setResult(-1, intent);
                }
                FragmentActivity activity2 = this.f15231O000000o.getActivity();
                if (activity2 != null) {
                    activity2.finish();
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.xiaomi.passport.ui.internal.PhoneNumUtil.CountryPhoneNumData");
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014¨\u0006\u0007"}, d2 = {"com/xiaomi/passport/ui/internal/AreaCodePickerFragment$onViewCreated$2", "Lcom/xiaomi/passport/ui/internal/AlphabetFastIndexer$OnScrollerDecorator;", "(Lcom/xiaomi/passport/ui/internal/AlphabetFastIndexer;Lcom/xiaomi/passport/ui/internal/AlphabetFastIndexer;Landroid/widget/AbsListView$OnScrollListener;)V", "itemToString", "", "item", "", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O00000Oo extends AlphabetFastIndexer.O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ AlphabetFastIndexer f15232O000000o;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        O00000Oo(AlphabetFastIndexer alphabetFastIndexer, AlphabetFastIndexer alphabetFastIndexer2) {
            super(alphabetFastIndexer2, null);
            this.f15232O000000o = alphabetFastIndexer;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
         arg types: [java.lang.String, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
        public final String O000000o(Object obj) {
            if (obj != null) {
                String str = ((ehc.O000000o) obj).f15276O000000o;
                ixe.O000000o((Object) str, "(item as PhoneNumUtil.Co…PhoneNumData).countryName");
                return str;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.xiaomi.passport.ui.internal.PhoneNumUtil.CountryPhoneNumData");
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f15230O000000o;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
