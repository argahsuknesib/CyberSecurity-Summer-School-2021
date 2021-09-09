package com.xiaomi.onetrack.b;

class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6122a;
    final /* synthetic */ f b;

    h(f fVar, String str) {
        this.b = fVar;
        this.f6122a = str;
    }

    public void run() {
        try {
            this.b.b.getWritableDatabase().delete("events_cloud", "app_id=?", new String[]{this.f6122a});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
