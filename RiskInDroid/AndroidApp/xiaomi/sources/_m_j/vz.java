package _m_j;

import android.util.SparseArray;
import com.chad.library.adapter.base.util.ItemProviderException;

public final class vz {

    /* renamed from: O000000o  reason: collision with root package name */
    public SparseArray<vx> f2566O000000o = new SparseArray<>();

    public final void O000000o(vx vxVar) {
        if (vxVar != null) {
            int O000000o2 = vxVar.O000000o();
            if (this.f2566O000000o.get(O000000o2) == null) {
                this.f2566O000000o.put(O000000o2, vxVar);
                return;
            }
            return;
        }
        throw new ItemProviderException("ItemProvider can not be null");
    }
}
