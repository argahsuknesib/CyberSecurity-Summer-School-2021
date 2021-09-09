package com.airbnb.lottie.model;

import _m_j.be;

public class MutablePair<T> {
    T first;
    T second;

    public void set(T t, T t2) {
        this.first = t;
        this.second = t2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof be)) {
            return false;
        }
        be beVar = (be) obj;
        if (!objectsEqual(beVar.f12896O000000o, this.first) || !objectsEqual(beVar.O00000Oo, this.second)) {
            return false;
        }
        return true;
    }

    private static boolean objectsEqual(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public int hashCode() {
        T t = this.first;
        int i = 0;
        int hashCode = t == null ? 0 : t.hashCode();
        T t2 = this.second;
        if (t2 != null) {
            i = t2.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.first) + " " + String.valueOf(this.second) + "}";
    }
}
