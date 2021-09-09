package _m_j;

import O000000o.O000000o.O00000Oo.d;
import _m_j.vp;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hannto.print.entity.PickPhotoEntity;
import com.hannto.print.pickimage.activity.AlbumDetailActivity;
import com.xiaomi.smarthome.R;
import java.util.List;

public final class O00Oo00o extends Fragment {

    /* renamed from: O000000o  reason: collision with root package name */
    public RecyclerView f6640O000000o;
    public O000o0 O00000Oo;
    public boolean O00000o;
    public RelativeLayout O00000o0;
    public PickPhotoEntity O00000oO;

    public class O000000o implements Runnable {

        /* renamed from: _m_j.O00Oo00o$O000000o$O000000o  reason: collision with other inner class name */
        public class C0062O000000o implements vp.O00000Oo {

            /* renamed from: O000000o  reason: collision with root package name */
            public final /* synthetic */ List f6642O000000o;

            public C0062O000000o(List list) {
                this.f6642O000000o = list;
            }

            public final void O000000o(int i) {
                Intent intent = new Intent(O00Oo00o.this.getActivity(), AlbumDetailActivity.class);
                intent.putExtra("item_index", i);
                String str = ((O00O00o0) this.f6642O000000o.get(i)).O00000Oo;
                intent.putExtra("intent_pick_photo_config", O00Oo00o.this.O00000oO);
                intent.putExtra("folder_name", str.substring(str.lastIndexOf("/") + 1));
                O00Oo00o.this.getActivity().startActivityForResult(intent, 2000);
                if (!O00Oo00o.this.O00000o) {
                    O00Oo00o.this.getActivity().overridePendingTransition(0, 0);
                }
            }
        }

        public O000000o() {
        }

        public final void run() {
            List<O00O00o0> list = d.O000000o().O00000oO;
            if (list == null || list.size() <= 0) {
                O00Oo00o.this.O00000o0.setVisibility(0);
                return;
            }
            O000o0 unused = O00Oo00o.this.O00000Oo = new O000o0(list);
            O00Oo00o.this.O00000Oo.O00000oO = new C0062O000000o(list);
            O00Oo00o.this.f6640O000000o.setAdapter(O00Oo00o.this.O00000Oo);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate((int) R.layout.ht_fragment_pick_photo, (ViewGroup) null);
        this.O00000oO = (PickPhotoEntity) getActivity().getIntent().getParcelableExtra("intent_pick_photo_config");
        this.O00000o = this.O00000oO.O00000oO;
        this.f6640O000000o = (RecyclerView) inflate.findViewById(R.id.photo_recycler_view);
        this.f6640O000000o.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.O00000o0 = (RelativeLayout) inflate.findViewById(R.id.layout_noting);
        return inflate;
    }
}
