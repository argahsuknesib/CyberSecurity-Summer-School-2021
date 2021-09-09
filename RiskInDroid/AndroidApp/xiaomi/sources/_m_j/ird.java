package _m_j;

import in.cashify.otex.ExchangeError;

public final class ird extends ExchangeError {
    public ird(ExchangeError.Kind kind) {
        super(kind.getDetail(), kind);
    }

    public ird(String str, int i) {
        super(str, i);
    }
}
