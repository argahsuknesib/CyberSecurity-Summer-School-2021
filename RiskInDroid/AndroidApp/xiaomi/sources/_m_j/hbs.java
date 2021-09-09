package _m_j;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/VisibleWrapperAdapter;", "Lcom/xiaomi/smarthome/newui/adapter/DelegateWrapperAdapter;", "Lcom/xiaomi/smarthome/multi_item/IAdapterBridge;", "delegate", "Lcom/xiaomi/smarthome/multi_item/IAdapter;", "defaultVisible", "", "(Lcom/xiaomi/smarthome/multi_item/IAdapter;Z)V", "isVisible", "getItemCount", "", "setVisible", "", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hbs extends hax implements gzn {

    /* renamed from: O000000o  reason: collision with root package name */
    private final gzm f18757O000000o;
    private boolean O00000Oo;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public hbs(gzm gzm, byte b) {
        this(gzm);
        ixe.O00000o(gzm, "delegate");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hbs.<init>(_m_j.gzm, boolean):void
     arg types: [_m_j.gzm, int]
     candidates:
      _m_j.hbs.<init>(_m_j.gzm, byte):void
      _m_j.hbs.<init>(_m_j.gzm, boolean):void */
    public /* synthetic */ hbs(gzm gzm) {
        this(gzm, false);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private hbs(gzm gzm, boolean z) {
        super(gzm);
        ixe.O00000o(gzm, "delegate");
        this.f18757O000000o = gzm;
        this.O00000Oo = false;
    }

    public final void O000000o(boolean z) {
        if (this.O00000Oo != z) {
            this.O00000Oo = z;
            notifyDataSetChanged();
        }
    }

    public final int getItemCount() {
        if (this.O00000Oo) {
            return this.f18757O000000o.getItemCount();
        }
        return 0;
    }
}
