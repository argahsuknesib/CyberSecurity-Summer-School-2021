package com.miui.tsmclient.model;

import com.miui.tsmclient.net.TSMAuthManager;
import java.util.List;
import java.util.Vector;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    protected TSMAuthManager f3875a = new TSMAuthManager();
    protected String b = "";
    private List<b> c = new Vector();

    protected c() {
    }

    public void a() {
        synchronized (this.c) {
            for (int i = 0; i < this.c.size(); i++) {
                this.c.get(i).a();
            }
            this.c.clear();
        }
    }
}
