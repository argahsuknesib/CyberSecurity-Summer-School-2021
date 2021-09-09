package _m_j;

import androidx.lifecycle.LiveData;

public class fg<T> extends LiveData<T> {
    public void postValue(T t) {
        super.postValue(t);
    }

    public void setValue(T t) {
        super.setValue(t);
    }
}
