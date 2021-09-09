package com.xiaomi.smarthome.infrared.activity;

import _m_j.gio;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.infrared.bean.NameIdEntity;
import com.xiaomi.smarthome.infrared.utils.CharacterParser;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class IRSearchProvinceActivity extends BaseActivity implements TextWatcher, View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private EditText f9004O000000o;
    private ListView O00000Oo;
    private List<NameIdEntity> O00000o;
    private gio O00000o0;
    public List<NameIdEntity> listSearch;

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public static void showActivity(Activity activity, ArrayList<NameIdEntity> arrayList, int i) {
        Intent intent = new Intent(activity, IRSearchProvinceActivity.class);
        Bundle extras = activity.getIntent().getExtras();
        if (extras != null) {
            intent.putExtras(extras);
        }
        intent.putParcelableArrayListExtra("intent_location_list_key", arrayList);
        activity.startActivityForResult(intent, i);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.O00000o = getIntent().getParcelableArrayListExtra("intent_location_list_key");
        setContentView((int) R.layout.activity_ir_search);
        this.O00000Oo = (ListView) findViewById(R.id.ir_search_list);
        View findViewById = findViewById(R.id.title_bar_return);
        this.f9004O000000o = (EditText) findViewById(R.id.edit);
        this.f9004O000000o.setHint((int) R.string.inifrare_search_hit);
        this.mHandler.postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.infrared.activity.IRSearchProvinceActivity.AnonymousClass1 */

            public final void run() {
                InputMethodManager inputMethodManager = (InputMethodManager) IRSearchProvinceActivity.this.getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.toggleSoftInput(0, 2);
                }
            }
        }, 200);
        findViewById.setOnClickListener(this);
        this.f9004O000000o.addTextChangedListener(this);
    }

    private void O000000o() {
        if (this.listSearch == null) {
            this.listSearch = new ArrayList();
        }
        gio gio = this.O00000o0;
        if (gio == null) {
            this.O00000o0 = new gio(this, this.listSearch);
            this.O00000Oo.setAdapter((ListAdapter) this.O00000o0);
        } else {
            gio.O000000o(this.listSearch);
        }
        this.O00000Oo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.xiaomi.smarthome.infrared.activity.IRSearchProvinceActivity.AnonymousClass2 */

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Intent intent = IRSearchProvinceActivity.this.getIntent();
                intent.putExtra("intent_location_key", IRSearchProvinceActivity.this.listSearch.get(i));
                IRSearchProvinceActivity.this.setResult(-1, intent);
                IRSearchProvinceActivity.this.onBackPressed();
            }
        });
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (TextUtils.isEmpty(charSequence)) {
            this.listSearch.clear();
            O000000o();
            return;
        }
        this.listSearch = searchContact(charSequence.toString(), this.O00000o);
        O000000o();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.title_bar_return) {
            finish();
        } else if (id == R.id.cancel) {
            this.f9004O000000o.setText("");
        }
    }

    public void finish() {
        super.finish();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.f9004O000000o.getWindowToken(), 0);
        }
    }

    public List<NameIdEntity> searchContact(String str, List<NameIdEntity> list) {
        ArrayList arrayList = new ArrayList();
        if (str.matches("^([0-9]|[/+]).*")) {
            for (NameIdEntity next : list) {
                if (next.O00000Oo != null && next.O00000Oo.contains(str) && !arrayList.contains(next)) {
                    arrayList.add(next);
                }
            }
        } else {
            for (NameIdEntity next2 : list) {
                CharacterParser.O000000o();
                CharacterParser.SortToken O00000Oo2 = CharacterParser.O00000Oo(next2.O00000Oo);
                String O000000o2 = CharacterParser.O000000o().O000000o(next2.O00000Oo);
                if (next2.O00000Oo != null && ((next2.O00000Oo.toLowerCase(Locale.CHINESE).contains(str.toLowerCase(Locale.CHINESE)) || O000000o2.toLowerCase(Locale.CHINESE).contains(str.toLowerCase(Locale.CHINESE)) || O00000Oo2.simpleSpell.toLowerCase(Locale.CHINESE).contains(str.toLowerCase(Locale.CHINESE)) || O00000Oo2.wholeSpell.toLowerCase(Locale.CHINESE).contains(str.toLowerCase(Locale.CHINESE))) && !arrayList.contains(next2))) {
                    arrayList.add(next2);
                }
            }
        }
        return arrayList;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null && intent.getBooleanExtra("infrared_finish", false)) {
            setResult(-1, intent);
            finish();
        }
    }
}
