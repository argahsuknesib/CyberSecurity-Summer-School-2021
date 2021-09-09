package com.xiaomi.passport.ui.internal;

import _m_j.efr;
import _m_j.ixe;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.xiaomi.passport.ui.R$id;
import com.xiaomi.smarthome.R;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/xiaomi/passport/ui/internal/AreaCodePickerActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onSupportNavigateUp", "", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class AreaCodePickerActivity extends AppCompatActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private HashMap f6236O000000o;

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.f6236O000000o;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i) {
        if (this.f6236O000000o == null) {
            this.f6236O000000o = new HashMap();
        }
        View view = (View) this.f6236O000000o.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f6236O000000o.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.add_account_main);
        setSupportActionBar((Toolbar) _$_findCachedViewById(R$id.toolbar));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            ixe.O000000o();
        }
        supportActionBar.O000000o(true);
        supportActionBar.O000000o();
        supportActionBar.O00000Oo();
        if (getSupportFragmentManager().O000000o("area") == null) {
            getSupportFragmentManager().O000000o().O000000o(R$id.fragment_container, new efr(), "area").O00000o0();
        }
        ImageView imageView = (ImageView) _$_findCachedViewById(R$id.help_center);
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public final boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
