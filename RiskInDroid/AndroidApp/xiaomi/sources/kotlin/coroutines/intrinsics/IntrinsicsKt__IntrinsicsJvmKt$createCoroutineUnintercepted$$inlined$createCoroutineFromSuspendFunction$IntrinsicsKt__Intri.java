package kotlin.coroutines.intrinsics;

import _m_j.ivo;
import _m_j.ivq;
import _m_j.iwn;
import _m_j.ixi;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007H\u0014ø\u0001\u0000¢\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "label", "", "invokeSuspend", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 1, 13})
public final class IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4 extends ContinuationImpl {
    final /* synthetic */ ivo $completion;
    final /* synthetic */ ivq $context;
    final /* synthetic */ Object $receiver$inlined;
    final /* synthetic */ iwn $this_createCoroutineUnintercepted$inlined;
    private int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4(ivo ivo, ivq ivq, ivo ivo2, ivq ivq2, iwn iwn, Object obj) {
        super(ivo2, ivq2);
        this.$completion = ivo;
        this.$context = ivq;
        this.$this_createCoroutineUnintercepted$inlined = iwn;
        this.$receiver$inlined = obj;
    }

    public final Object O000000o(Object obj) {
        int i = this.label;
        if (i == 0) {
            this.label = 1;
            ivo ivo = this;
            iwn iwn = this.$this_createCoroutineUnintercepted$inlined;
            if (iwn != null) {
                return ((iwn) ixi.O00000o0(iwn)).invoke(this.$receiver$inlined, ivo);
            }
            throw new TypeCastException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } else if (i == 1) {
            this.label = 2;
            return obj;
        } else {
            throw new IllegalStateException("This coroutine had already completed".toString());
        }
    }
}
