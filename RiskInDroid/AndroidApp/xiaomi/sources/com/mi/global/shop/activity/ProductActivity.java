package com.mi.global.shop.activity;

import _m_j.cad;
import _m_j.cav;
import android.content.Intent;
import android.os.Bundle;
import com.mi.global.shop.ui.MainTabLazyWebFragment;
import com.xiaomi.smarthome.R;

public class ProductActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private String[] f4662O000000o = {cav.O000O0oo(), cav.O000OOo0(), cav.O000OO00(), cav.O000OOOo()};
    private String[] O00000Oo = {"content://com.mi.global.shop.web/web/static/index.html", "content://com.mi.global.shop.web/web/static/category.html", "content://com.mi.global.shop.web/web/static/service.html", "content://com.mi.global.shop.web/web/static/user.html"};
    private MainTabLazyWebFragment O00000o0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        O000000o((int) R.layout.shop_activity_product);
        this.mBackView.setVisibility(0);
        setTitle((int) R.string.main_category);
        this.O00000o0 = MainTabLazyWebFragment.O000000o(this.f4662O000000o[1], this.O00000Oo[1]);
        getSupportFragmentManager().O000000o().O00000Oo(R.id.fragment, this.O00000o0, null).O00000Oo();
        this.O00000o0.setUserVisibleHint(true);
    }

    public void startCartActivity() {
        if (cad.O00000o()) {
            startActivityForResult(new Intent(this, ShoppingCartActivity.class), 22);
            return;
        }
        Intent intent = new Intent(this, WebActivity.class);
        intent.putExtra("url", cav.O000OOo());
        startActivity(intent);
    }
}
