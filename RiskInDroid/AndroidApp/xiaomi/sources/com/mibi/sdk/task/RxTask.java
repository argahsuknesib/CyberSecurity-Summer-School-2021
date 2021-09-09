package com.mibi.sdk.task;

import _m_j.chg;
import _m_j.chh;
import _m_j.chj;
import com.mibi.sdk.common.exception.PaymentException;

public abstract class RxTask<R> implements chj<R> {
    private Class<R> mResultClazz;

    /* access modifiers changed from: protected */
    public abstract void doLoad(Object obj) throws PaymentException;

    public RxTask(Class<R> cls) {
        this.mResultClazz = cls;
        Class<R> cls2 = this.mResultClazz;
        if (cls2 != null && Void.class.equals(cls2)) {
            throw new IllegalArgumentException();
        }
    }

    public chh<R> getObservable() {
        return chh.O000000o(this);
    }

    public void call(chg<? super R> chg) {
        try {
            R newInstance = this.mResultClazz.newInstance();
            doLoad(newInstance);
            chg.O000000o(newInstance);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException(e2);
        } catch (Exception e3) {
            chg.O00000Oo = e3;
        }
    }
}
