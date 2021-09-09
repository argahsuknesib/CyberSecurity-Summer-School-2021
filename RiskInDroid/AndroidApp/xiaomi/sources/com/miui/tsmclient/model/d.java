package com.miui.tsmclient.model;

import com.miui.tsmclient.util.PrefUtils;
import rx.Subscription;

public class d extends BaseModel {

    /* renamed from: a  reason: collision with root package name */
    protected Subscription f3876a;
    private volatile boolean b;
    private BaseTransitCardModel c;

    public boolean a() {
        return PrefUtils.getBoolean(getContext(), "key_cards_cached", b() && c() && d() && e());
    }

    public boolean b() {
        return PrefUtils.getBoolean(getContext(), "key_trans_cached", false);
    }

    public boolean c() {
        return PrefUtils.getBoolean(getContext(), "key_mifare_cached", false);
    }

    public boolean d() {
        return PrefUtils.getBoolean(getContext(), "key_bank_cached", false);
    }

    public boolean e() {
        return PrefUtils.getBoolean(getContext(), "key_qr_bank_cached", false);
    }

    /* access modifiers changed from: protected */
    public void onInit() {
        this.b = false;
        this.c = (BaseTransitCardModel) BaseModel.create(getContext(), BaseTransitCardModel.class);
    }

    public void release() {
        this.b = true;
        Subscription subscription = this.f3876a;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }
}
