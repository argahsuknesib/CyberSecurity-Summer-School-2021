package cn.com.xm.bt.d;

import android.bluetooth.BluetoothDevice;
import cn.com.xm.bt.b.b;
import cn.com.xm.bt.c.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public BluetoothDevice f3087a = null;
    public int b = 0;
    public byte c = 0;
    public final ArrayList<String> d = new ArrayList<>();
    public final ArrayList<String> e = new ArrayList<>();
    public final ArrayList<String> f = new ArrayList<>();
    public final ArrayList<String> g = new ArrayList<>();
    public String h = "";
    public String i = "";
    public String j = "";
    public String k = "";
    public String l = "";
    public String m = "";
    public String n = "";
    public b o = b.VDEVICE;

    public boolean a(UUID uuid) {
        Iterator<String> it = this.d.iterator();
        while (it.hasNext()) {
            if (c.a(it.next()).equals(uuid)) {
                return true;
            }
        }
        Iterator<String> it2 = this.e.iterator();
        while (it2.hasNext()) {
            if (c.a(it2.next()).equals(uuid)) {
                return true;
            }
        }
        Iterator<String> it3 = this.f.iterator();
        while (it3.hasNext()) {
            if (c.b(it3.next()).equals(uuid)) {
                return true;
            }
        }
        Iterator<String> it4 = this.g.iterator();
        while (it4.hasNext()) {
            if (c.b(it4.next()).equals(uuid)) {
                return true;
            }
        }
        return false;
    }
}
