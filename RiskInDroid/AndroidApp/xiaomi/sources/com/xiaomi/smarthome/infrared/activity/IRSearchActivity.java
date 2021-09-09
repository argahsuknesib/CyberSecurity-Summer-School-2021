package com.xiaomi.smarthome.infrared.activity;

import _m_j.ftl;
import _m_j.gsy;
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
import com.xiaomi.smarthome.infrared.adapter.IRSearchAdapter;
import com.xiaomi.smarthome.infrared.bean.IRBrandType;
import com.xiaomi.smarthome.infrared.utils.CharacterParser;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class IRSearchActivity extends BaseActivity implements TextWatcher, View.OnClickListener, AdapterView.OnItemClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private ArrayList<IRBrandType> f9002O000000o;
    private IRSearchAdapter O00000Oo;
    private Runnable O00000o0 = new Runnable() {
        /* class com.xiaomi.smarthome.infrared.activity.IRSearchActivity.AnonymousClass1 */

        public final void run() {
            InputMethodManager inputMethodManager = (InputMethodManager) IRSearchActivity.this.mEditView.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(IRSearchActivity.this.mEditView, 2);
            }
        }
    };
    public EditText mEditView;

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public static void showSearchActivity(Activity activity, ArrayList<IRBrandType> arrayList, int i) {
        Intent intent = new Intent(activity, IRSearchActivity.class);
        Bundle extras = activity.getIntent().getExtras();
        if (extras != null) {
            intent.putExtras(extras);
        }
        intent.putParcelableArrayListExtra("intent_IRBrandType_list_key", arrayList);
        activity.startActivityForResult(intent, i);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f9002O000000o = getIntent().getParcelableArrayListExtra("intent_IRBrandType_list_key");
        setContentView((int) R.layout.activity_ir_search);
        ListView listView = (ListView) findViewById(R.id.ir_search_list);
        View findViewById = findViewById(R.id.title_bar_return);
        this.mEditView = (EditText) findViewById(R.id.edit);
        this.O00000Oo = new IRSearchAdapter(this);
        listView.setAdapter((ListAdapter) this.O00000Oo);
        findViewById.setOnClickListener(this);
        this.mEditView.addTextChangedListener(this);
        listView.setOnItemClickListener(this);
        this.mHandler.postDelayed(this.O00000o0, 100);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        setResult(-1, getIntent().putExtra("intent_IRBrandType_key", (IRBrandType) this.O00000Oo.getItem(i)));
        onBackPressed();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.title_bar_return) {
            finish();
        } else if (id == R.id.cancel) {
            this.mEditView.setText("");
        }
    }

    public List<IRBrandType> searchContact(String str, List<IRBrandType> list) {
        ArrayList arrayList = new ArrayList();
        if (!str.matches("^([0-9]|[/+]).*")) {
            boolean O00000Oo2 = ftl.O00000Oo();
            for (IRBrandType next : list) {
                CharacterParser.O000000o();
                CharacterParser.SortToken O00000Oo3 = CharacterParser.O00000Oo(next.f9036O000000o);
                if (O00000Oo2) {
                    if (TextUtils.isEmpty(next.f9036O000000o)) {
                        break;
                    } else if ((next.f9036O000000o.toLowerCase(Locale.CHINESE).contains(str.toLowerCase(Locale.CHINESE)) || next.O00000o0.toLowerCase(Locale.CHINESE).contains(str.toLowerCase(Locale.CHINESE)) || O00000Oo3.simpleSpell.toLowerCase(Locale.CHINESE).contains(str.toLowerCase(Locale.CHINESE)) || O00000Oo3.wholeSpell.toLowerCase(Locale.CHINESE).contains(str.toLowerCase(Locale.CHINESE))) && !arrayList.contains(next)) {
                        arrayList.add(next);
                    }
                } else {
                    gsy.O000000o(3, "IRSearchActivity", "searchContact: " + next.O00000o.toLowerCase(Locale.ENGLISH) + " str " + str);
                    if (TextUtils.isEmpty(next.O00000o)) {
                        break;
                    } else if (next.O00000o.toLowerCase(Locale.ENGLISH).contains(str.toLowerCase(Locale.ENGLISH)) && !arrayList.contains(next)) {
                        arrayList.add(next);
                    }
                }
            }
        } else {
            for (IRBrandType next2 : list) {
                if (next2.f9036O000000o != null && next2.f9036O000000o.contains(str) && !arrayList.contains(next2)) {
                    arrayList.add(next2);
                }
            }
        }
        return arrayList;
    }

    public void onPause() {
        super.onPause();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.mEditView.getWindowToken(), 0);
        }
        this.mHandler.removeCallbacks(this.O00000o0);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null && intent.getBooleanExtra("infrared_finish", false)) {
            setResult(-1, intent);
            finish();
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (TextUtils.isEmpty(charSequence)) {
            this.O00000Oo.O000000o(null);
        } else {
            this.O00000Oo.O000000o(searchContact(charSequence.toString(), this.f9002O000000o));
        }
    }
}
