package com.xiaomi.smarthome.newui;

import _m_j.iuh;
import _m_j.ivo;
import _m_j.ivt;
import _m_j.iwn;
import _m_j.ixe;
import _m_j.iyd;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Landroid/view/View;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@ivt(O00000Oo = "Exts.kt", O00000o = "invokeSuspend", O00000o0 = {18}, O00000oO = "com.xiaomi.smarthome.newui.ExtsKt$children$1")
public final class ExtsKt$children$1 extends RestrictedSuspendLambda implements iwn<iyd<? super View>, ivo<? super iuh>, Object> {
    final /* synthetic */ ViewGroup $this_children;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExtsKt$children$1(ViewGroup viewGroup, ivo<? super ExtsKt$children$1> ivo) {
        super(ivo);
        this.$this_children = viewGroup;
    }

    public final ivo<iuh> O000000o(Object obj, ivo<?> ivo) {
        ExtsKt$children$1 extsKt$children$1 = new ExtsKt$children$1(this.$this_children, ivo);
        extsKt$children$1.L$0 = obj;
        return extsKt$children$1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004e, code lost:
        if (r2 < r0) goto L_0x002e;
     */
    public final Object O000000o(Object obj) {
        ExtsKt$children$1 extsKt$children$1;
        CoroutineSingletons coroutineSingletons;
        iyd iyd;
        int i;
        int i2;
        CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i3 = this.label;
        if (i3 == 0) {
            iyd iyd2 = (iyd) this.L$0;
            i = 0;
            int childCount = this.$this_children.getChildCount();
            if (childCount > 0) {
                coroutineSingletons = coroutineSingletons2;
                extsKt$children$1 = this;
                int i4 = childCount;
                iyd = iyd2;
                i2 = i4;
            }
            return iuh.f1631O000000o;
        } else if (i3 == 1) {
            i2 = this.I$1;
            i = this.I$0;
            iyd = (iyd) this.L$0;
            coroutineSingletons = coroutineSingletons2;
            extsKt$children$1 = this;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i5 = i + 1;
        View childAt = extsKt$children$1.$this_children.getChildAt(i);
        ixe.O00000Oo(childAt, "getChildAt(i)");
        extsKt$children$1.L$0 = iyd;
        extsKt$children$1.I$0 = i5;
        extsKt$children$1.I$1 = i2;
        extsKt$children$1.label = 1;
        if (iyd.O000000o(childAt, extsKt$children$1) == coroutineSingletons) {
            return coroutineSingletons;
        }
        i = i5;
        return coroutineSingletons;
    }

    public final /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((ExtsKt$children$1) O000000o((iyd) obj, (ivo) obj2)).O000000o(iuh.f1631O000000o);
    }
}
