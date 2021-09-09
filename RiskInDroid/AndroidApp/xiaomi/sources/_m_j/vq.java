package _m_j;

import _m_j.vr;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.entity.SectionEntity;
import com.xiaomi.smarthome.R;
import java.util.List;

public abstract class vq<T extends SectionEntity, K extends vr> extends vp<T, K> {
    protected int O0000o = R.layout.ht_album_grid_head;

    /* access modifiers changed from: protected */
    public abstract void O000000o(K k, T t);

    public vq(int i, int i2, List<T> list) {
        super(R.layout.ht_album_grid_item, list);
    }

    /* access modifiers changed from: protected */
    public final int O00000Oo(int i) {
        return ((SectionEntity) this.O0000Ooo.get(i)).isHeader ? 1092 : 0;
    }

    /* access modifiers changed from: protected */
    public final K O000000o(ViewGroup viewGroup, int i) {
        if (i == 1092) {
            return O000000o(O000000o(this.O0000o, viewGroup));
        }
        return super.O000000o(viewGroup, i);
    }

    /* access modifiers changed from: protected */
    public final boolean O00000o0(int i) {
        return super.O00000o0(i) || i == 1092;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.vp.O000000o(_m_j.vr, int):void
     arg types: [K, int]
     candidates:
      _m_j.vq.O000000o(android.view.ViewGroup, int):K
      _m_j.vq.O000000o(_m_j.vr, com.chad.library.adapter.base.entity.SectionEntity):void
      _m_j.vp.O000000o(java.lang.Class, android.view.View):K
      _m_j.vp.O000000o(android.view.ViewGroup, int):K
      _m_j.vp.O000000o(int, android.view.ViewGroup):android.view.View
      _m_j.vp.O000000o(_m_j.vr, java.lang.Object):void
      _m_j.vp.O000000o(_m_j.vr, int):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.vq.O000000o(_m_j.vr, com.chad.library.adapter.base.entity.SectionEntity):void
     arg types: [K, com.chad.library.adapter.base.entity.SectionEntity]
     candidates:
      _m_j.vq.O000000o(android.view.ViewGroup, int):K
      _m_j.vq.O000000o(_m_j.vr, int):void
      _m_j.vp.O000000o(java.lang.Class, android.view.View):K
      _m_j.vp.O000000o(android.view.ViewGroup, int):K
      _m_j.vp.O000000o(int, android.view.ViewGroup):android.view.View
      _m_j.vp.O000000o(_m_j.vr, int):void
      _m_j.vp.O000000o(_m_j.vr, java.lang.Object):void
      _m_j.vq.O000000o(_m_j.vr, com.chad.library.adapter.base.entity.SectionEntity):void */
    /* renamed from: O000000o */
    public final void onBindViewHolder(K k, int i) {
        if (k.getItemViewType() != 1092) {
            super.onBindViewHolder((vr) k, i);
            return;
        }
        O000000o((RecyclerView.O000OOo0) k);
        O000000o((vr) k, (SectionEntity) O000000o(i - O00000Oo()));
    }
}
