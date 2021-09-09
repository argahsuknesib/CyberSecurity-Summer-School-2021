package _m_j;

import com.google.gson.Gson;
import java.lang.reflect.Type;

public final class ile<T> extends iln<Object, Void, Object> {

    /* renamed from: O000000o  reason: collision with root package name */
    private O000000o<T> f1435O000000o;
    private O000000o<T> O00000Oo;

    public interface O000000o<T> {
        void O000000o(T t);
    }

    /* access modifiers changed from: protected */
    public final Object doInBackground(Object[] objArr) {
        if (objArr.length == 1) {
            try {
                String json = new Gson().toJson(objArr[0]);
                if (this.O00000Oo != null) {
                    this.O00000Oo.O000000o(json);
                }
                return json;
            } catch (Exception e) {
                e.printStackTrace();
                return e;
            }
        } else if (objArr.length != 2) {
            return new Exception("params is error");
        } else {
            if (objArr[1] instanceof Type) {
                try {
                    return new Gson().fromJson((String) objArr[0], (Type) objArr[1]);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return e2;
                }
            } else {
                try {
                    return new Gson().fromJson((String) objArr[0], (Class) objArr[1]);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return e3;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void onPostExecute(Object obj) {
        super.onPostExecute(obj);
        O000000o<T> o000000o = this.f1435O000000o;
        if (o000000o != null && !(obj instanceof Exception)) {
            o000000o.O000000o(obj);
        }
    }

    public final void O000000o(Object obj, O000000o o000000o) {
        this.O00000Oo = o000000o;
        if (obj == null) {
            new Exception("IllegalArgument");
            return;
        }
        O000000o(obj);
    }
}
