package kotlin;

import _m_j.ixc;
import _m_j.ixe;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/NotImplementedError;", "Ljava/lang/Error;", "Lkotlin/Error;", "message", "", "(Ljava/lang/String;)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 13})
public final class NotImplementedError extends Error {
    public NotImplementedError() {
        this(null, 1, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotImplementedError(String str) {
        super(str);
        ixe.O00000o0(str, "message");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NotImplementedError(String str, int i, ixc ixc) {
        this((i & 1) != 0 ? "An operation is not implemented." : str);
    }
}