package _m_j;

import android.text.TextUtils;

public abstract class gds<T, C> {
    private volatile gdr<T, C> mProxy;

    /* access modifiers changed from: protected */
    public abstract String getModuleClassName();

    public T getUiInterface() {
        return getProxy().getUiInterface();
    }

    public C getServiceInterface() {
        return getProxy().getServiceInterface();
    }

    /* access modifiers changed from: protected */
    public gdr<T, C> getProxy() {
        if (this.mProxy == null) {
            synchronized (this) {
                if (this.mProxy == null) {
                    String moduleClassName = getModuleClassName();
                    if (!TextUtils.isEmpty(moduleClassName)) {
                        try {
                            this.mProxy = (gdr) loadModule(moduleClassName);
                        } catch (Throwable th) {
                            fyc.O00000Oo("Proxy", "getProxy error,", th);
                        }
                    }
                }
            }
        }
        return this.mProxy;
    }

    /* access modifiers changed from: protected */
    public Object loadModule(String str) {
        try {
            Class<?> cls = Class.forName(str, false, getClass().getClassLoader());
            if (cls != null) {
                return cls.newInstance();
            }
            return null;
        } catch (Throwable th) {
            fyc.O00000Oo("Proxy", "loadModule: load " + str + " failed,", th);
            return null;
        }
    }
}
