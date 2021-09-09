package _m_j;

import _m_j.eki;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.xiaomi.passport.ui.R$id;
import com.xiaomi.passport.ui.settings.AlphabetFastIndexer;
import com.xiaomi.smarthome.R;

public final class ejn extends Fragment {

    /* renamed from: O000000o  reason: collision with root package name */
    protected String f15523O000000o;
    protected Activity O00000Oo;
    protected ejm O00000o;
    protected ListView O00000o0;
    public AlphabetFastIndexer O00000oO;
    protected View O00000oo;

    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        this.O00000Oo = activity;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        eki.O000000o(getActivity());
        this.O00000oo = layoutInflater.inflate((int) R.layout.passport_area_code_picker_fragment, viewGroup, false);
        View view = this.O00000oo;
        this.O00000o = new ejm(getActivity(), getArguments());
        this.O00000o0 = (ListView) view.findViewById(R$id.list);
        this.O00000o0.setAdapter((ListAdapter) this.O00000o);
        this.O00000o0.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class _m_j.ejn.AnonymousClass2 */

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                eki.O000000o O000000o2 = ejn.this.O000000o(i);
                Intent intent = new Intent();
                intent.putExtra("country_iso", O000000o2.O00000o0);
                ejn.this.O00000Oo.setResult(-1, intent);
                ejn.this.O00000Oo.finish();
            }
        });
        this.O00000oO = (AlphabetFastIndexer) view.findViewById(R$id.fast_indexer);
        this.O00000oO.attatch(this.O00000o0);
        this.O00000oO.setVisibility(0);
        this.O00000o0.setOnScrollListener(this.O00000oO.decorateScrollListener(new AbsListView.OnScrollListener() {
            /* class _m_j.ejn.AnonymousClass1 */

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (1 == i) {
                    View view = null;
                    if (absListView.getContext() instanceof Activity) {
                        view = ((Activity) absListView.getContext()).getCurrentFocus();
                    }
                    if (view != null) {
                        view.clearFocus();
                    }
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                String upperCase = ejn.this.O00000o.f15522O000000o.get(i + 1).f15572O000000o.substring(0, 1).toUpperCase();
                if (!TextUtils.equals(upperCase, ejn.this.f15523O000000o)) {
                    ejn.this.O00000oO.drawThumb(upperCase);
                    ejn.this.f15523O000000o = upperCase;
                }
            }
        }));
        return this.O00000oo;
    }

    /* access modifiers changed from: protected */
    public final eki.O000000o O000000o(int i) {
        return this.O00000o.getItem(i);
    }
}
