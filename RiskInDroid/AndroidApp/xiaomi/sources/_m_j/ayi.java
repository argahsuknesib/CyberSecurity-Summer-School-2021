package _m_j;

import _m_j.ayq;
import _m_j.ays;

public interface ayi<V extends ays, P extends ayq<V, ?>> {
    P createPresenter();

    V getMvpView();

    void setRestoringViewState(boolean z);
}
