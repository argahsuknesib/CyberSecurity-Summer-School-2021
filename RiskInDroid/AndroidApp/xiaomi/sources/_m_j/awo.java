package _m_j;

import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;

public abstract class awo extends awn {

    /* renamed from: O000000o  reason: collision with root package name */
    awy f12667O000000o;
    awu O00000Oo;
    awx O00000o;
    aww O00000o0;
    private boolean O00000oO;

    /* access modifiers changed from: protected */
    public abstract void O0000O0o();

    protected awo() {
        O0000O0o();
        if (this.f12667O000000o == null || this.O00000Oo == null || this.O00000o0 == null || this.O00000o == null) {
            throw new IllegalStateException("setup incomplete");
        }
    }

    public final boolean O000000o(RecyclerView.O000OOo0 o000OOo0) {
        if (this.O00000oO) {
            Log.d("ARVGeneralItemAnimator", "animateRemove(id = " + o000OOo0.getItemId() + ", position = " + o000OOo0.getLayoutPosition() + ")");
        }
        return this.f12667O000000o.O000000o(o000OOo0);
    }

    public final boolean O00000Oo(RecyclerView.O000OOo0 o000OOo0) {
        if (this.O00000oO) {
            Log.d("ARVGeneralItemAnimator", "animateAdd(id = " + o000OOo0.getItemId() + ", position = " + o000OOo0.getLayoutPosition() + ")");
        }
        return this.O00000Oo.O000000o(o000OOo0);
    }

    public final boolean O000000o(RecyclerView.O000OOo0 o000OOo0, int i, int i2, int i3, int i4) {
        if (this.O00000oO) {
            Log.d("ARVGeneralItemAnimator", "animateMove(id = " + o000OOo0.getItemId() + ", position = " + o000OOo0.getLayoutPosition() + ", fromX = " + i + ", fromY = " + i2 + ", toX = " + i3 + ", toY = " + i4 + ")");
        }
        return this.O00000o.O000000o(o000OOo0, i, i2, i3, i4);
    }

    public final boolean O000000o(RecyclerView.O000OOo0 o000OOo0, RecyclerView.O000OOo0 o000OOo02, int i, int i2, int i3, int i4) {
        if (o000OOo0 == o000OOo02) {
            return this.O00000o.O000000o(o000OOo0, i, i2, i3, i4);
        }
        if (this.O00000oO) {
            String str = "-";
            String l = o000OOo0 != null ? Long.toString(o000OOo0.getItemId()) : str;
            String l2 = o000OOo0 != null ? Long.toString((long) o000OOo0.getLayoutPosition()) : str;
            String l3 = o000OOo02 != null ? Long.toString(o000OOo02.getItemId()) : str;
            if (o000OOo02 != null) {
                str = Long.toString((long) o000OOo02.getLayoutPosition());
            }
            Log.d("ARVGeneralItemAnimator", "animateChange(old.id = " + l + ", old.position = " + l2 + ", new.id = " + l3 + ", new.position = " + str + ", fromX = " + i + ", fromY = " + i2 + ", toX = " + i3 + ", toY = " + i4 + ")");
        }
        return this.O00000o0.O000000o(o000OOo0, o000OOo02, i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public void O0000OOo(RecyclerView.O000OOo0 o000OOo0) {
        cb.O0000o(o000OOo0.itemView).O00000Oo();
    }

    public final void O00000o0(RecyclerView.O000OOo0 o000OOo0) {
        O0000OOo(o000OOo0);
        this.O00000o.O00000o0(o000OOo0);
        this.O00000o0.O00000o0(o000OOo0);
        this.f12667O000000o.O00000o0(o000OOo0);
        this.O00000Oo.O00000o0(o000OOo0);
        this.O00000o.O00000o(o000OOo0);
        this.O00000o0.O00000o(o000OOo0);
        this.f12667O000000o.O00000o(o000OOo0);
        this.O00000Oo.O00000o(o000OOo0);
        if (this.f12667O000000o.O00000Oo(o000OOo0) && this.O00000oO) {
            throw new IllegalStateException("after animation is cancelled, item should not be in the active animation list [remove]");
        } else if (this.O00000Oo.O00000Oo(o000OOo0) && this.O00000oO) {
            throw new IllegalStateException("after animation is cancelled, item should not be in the active animation list [add]");
        } else if (this.O00000o0.O00000Oo(o000OOo0) && this.O00000oO) {
            throw new IllegalStateException("after animation is cancelled, item should not be in the active animation list [change]");
        } else if (!this.O00000o.O00000Oo(o000OOo0) || !this.O00000oO) {
            O00000o0();
        } else {
            throw new IllegalStateException("after animation is cancelled, item should not be in the active animation list [move]");
        }
    }

    public final boolean O00000Oo() {
        return this.f12667O000000o.O00000o0() || this.O00000Oo.O00000o0() || this.O00000o0.O00000o0() || this.O00000o.O00000o0();
    }

    public final void O00000o() {
        this.O00000o.O00000oO();
        this.f12667O000000o.O00000oO();
        this.O00000Oo.O00000oO();
        this.O00000o0.O00000oO();
        if (O00000Oo()) {
            this.O00000o.O00000oo();
            this.O00000Oo.O00000oo();
            this.O00000o0.O00000oo();
            this.f12667O000000o.O00000o();
            this.O00000o.O00000o();
            this.O00000Oo.O00000o();
            this.O00000o0.O00000o();
            O00000oO();
        }
    }

    public final boolean O00000oo() {
        return this.O00000oO;
    }

    public final boolean O00000o0() {
        if (this.O00000oO && !O00000Oo()) {
            Log.d("ARVGeneralItemAnimator", "dispatchFinishedWhenDone()");
        }
        return super.O00000o0();
    }

    /* access modifiers changed from: protected */
    public void O0000OOo() {
        O0000Oo0();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.aws.O000000o(boolean, long):void
     arg types: [int, int]
     candidates:
      _m_j.aws.O000000o(_m_j.awv, androidx.recyclerview.widget.RecyclerView$O000OOo0):void
      _m_j.aws.O000000o(boolean, long):void */
    /* access modifiers changed from: protected */
    public final void O0000Oo0() {
        long j;
        long j2;
        long j3;
        boolean O00000Oo2 = this.f12667O000000o.O00000Oo();
        boolean O00000Oo3 = this.O00000o.O00000Oo();
        boolean O00000Oo4 = this.O00000o0.O00000Oo();
        boolean O00000Oo5 = this.O00000Oo.O00000Oo();
        if (O00000Oo2) {
            j = this.O0000Oo;
        } else {
            j = 0;
        }
        if (O00000Oo3) {
            j2 = this.O0000OoO;
        } else {
            j2 = 0;
        }
        if (O00000Oo4) {
            j3 = this.O0000Ooo;
        } else {
            j3 = 0;
        }
        boolean z = false;
        if (O00000Oo2) {
            this.f12667O000000o.O000000o(false, 0L);
        }
        if (O00000Oo3) {
            this.O00000o.O000000o(O00000Oo2, j);
        }
        if (O00000Oo4) {
            this.O00000o0.O000000o(O00000Oo2, j);
        }
        if (O00000Oo5) {
            if (O00000Oo2 || O00000Oo3 || O00000Oo4) {
                z = true;
            }
            long max = Math.max(j2, j3) + j;
            if (!z) {
                max = 0;
            }
            this.O00000Oo.O000000o(z, max);
        }
    }

    public final void O000000o() {
        if (this.f12667O000000o.O00000Oo() || this.O00000o.O00000Oo() || this.O00000o0.O00000Oo() || this.O00000Oo.O00000Oo()) {
            O0000OOo();
        }
    }
}
