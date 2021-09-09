package com.xiaomi.smarthome.homeroom;

import _m_j.fnn;
import _m_j.fqv;
import _m_j.ggb;
import _m_j.gqb;
import _m_j.gqg;
import _m_j.hxi;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class HomeRoomRecommendActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    ImageView f8914O000000o;
    String O00000Oo = "";
    private RecyclerView O00000o;
    private View O00000o0;
    private Locale O00000oO;
    private boolean O00000oo = false;
    private O000000o O0000O0o;
    private Dialog O0000OOo;
    public String homeid;

    public static void startActivity(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent(context, HomeRoomRecommendActivity.class);
            intent.putExtra("home_id_param", str);
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_device_tag_recommend);
        this.homeid = getIntent().getStringExtra("home_id_param");
        if (TextUtils.isEmpty(this.homeid)) {
            this.homeid = ggb.O00000Oo().O0000OOo();
        }
        this.O00000oo = getIntent().getBooleanExtra("come_from_plug", false);
        this.O00000o0 = findViewById(R.id.module_a_3_return_btn);
        this.f8914O000000o = (ImageView) findViewById(R.id.module_a_3_right_img_btn);
        this.f8914O000000o.setImageResource(R.drawable.title_right_tick_drawable);
        this.f8914O000000o.setOnClickListener(this);
        this.f8914O000000o.setEnabled(false);
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.tag_add_title);
        this.O00000o0.setOnClickListener(this);
        this.O00000o = (RecyclerView) findViewById(R.id.list_view);
        this.O00000o.setLayoutManager(new LinearLayoutManager(this));
        fnn.O000000o().O00000Oo();
        List<String> O0000o = fqv.O0000o();
        this.O0000O0o = new O000000o(this);
        O000000o o000000o = this.O0000O0o;
        o000000o.O00000Oo = O0000o;
        o000000o.notifyDataSetChanged();
        this.O00000o.setAdapter(this.O0000O0o);
        this.O00000oO = CoreApi.O000000o().O00oOooo();
        if (this.O00000oO == null) {
            this.O00000oO = Locale.getDefault();
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onClick(View view) {
        if (view == this.O00000o0) {
            finish();
        } else if (view == this.f8914O000000o) {
            String trim = this.O00000Oo.trim();
            if (!TextUtils.isEmpty(trim)) {
                boolean O00000Oo2 = gqb.O00000Oo(trim);
                boolean O00000o02 = gqb.O00000o0(trim);
                if (O00000Oo2 || O00000o02) {
                    Dialog dialog = this.O0000OOo;
                    if (dialog != null && dialog.isShowing()) {
                        this.O0000OOo.dismiss();
                    }
                    this.O0000OOo = new MLAlertDialog.Builder(this).O000000o(String.format(getString(R.string.tag_save_data_title), trim)).O00000Oo((int) R.string.tag_save_data_description).O00000o0((int) R.string.tag_roger, (DialogInterface.OnClickListener) null).O00000oo();
                    return;
                }
                Intent intent = new Intent(this, HomeRoomEditorActivityV2.class);
                intent.putExtra("room_name", this.O00000Oo);
                intent.putExtra("home_id_param", this.homeid);
                startActivity(intent);
                finish();
                return;
            }
            gqg.O00000Oo((int) R.string.tag_recommend_room_name_not_found);
        }
    }

    class O000000o extends RecyclerView.O000000o<RecyclerView.O000OOo0> {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f8915O000000o = 1;
        public List<String> O00000Oo = new ArrayList();
        private Context O00000o;

        public O000000o(Context context) {
            this.O00000o = context;
        }

        private int O000000o() {
            List<String> list = this.O00000Oo;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public final int getItemViewType(int i) {
            O000000o();
            int i2 = this.f8915O000000o;
            return (i2 == 0 || i >= i2) ? 1 : 0;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 0) {
                return new C0078O000000o(LayoutInflater.from(this.O00000o).inflate((int) R.layout.room_recommend_header, viewGroup, false));
            }
            if (i == 1) {
                return new O00000Oo(LayoutInflater.from(this.O00000o).inflate((int) R.layout.tag_child_item_recommend, viewGroup, false));
            }
            return null;
        }

        public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            if (o000OOo0 instanceof C0078O000000o) {
                ((C0078O000000o) o000OOo0).f8916O000000o.setText((int) R.string.tag_recommend_room_name_list_title);
            } else if (o000OOo0 instanceof O00000Oo) {
                O00000Oo o00000Oo = (O00000Oo) o000OOo0;
                o00000Oo.f8921O000000o.setText(O000000o.this.O00000Oo.get(i - O000000o.this.f8915O000000o));
                o00000Oo.f8921O000000o.setOnClickListener(new View.OnClickListener(i) {
                    /* class com.xiaomi.smarthome.homeroom.HomeRoomRecommendActivity.O000000o.O00000Oo.AnonymousClass1 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ int f8922O000000o;

                    {
                        this.f8922O000000o = r2;
                    }

                    public final void onClick(View view) {
                        String O00000Oo2 = fnn.O000000o().O00000Oo().O00000Oo(O000000o.this.O00000Oo.get(this.f8922O000000o - O000000o.this.f8915O000000o), HomeRoomRecommendActivity.this.homeid);
                        Intent intent = new Intent(HomeRoomRecommendActivity.this, HomeRoomEditorActivityV2.class);
                        intent.putExtra("room_name", O00000Oo2);
                        intent.putExtra("home_id_param", HomeRoomRecommendActivity.this.homeid);
                        HomeRoomRecommendActivity.this.startActivity(intent);
                        HomeRoomRecommendActivity.this.finish();
                        hxi.O00000o.O0000oo0("2".concat(String.valueOf(O00000Oo2)));
                    }
                });
            }
        }

        public final int getItemCount() {
            return this.f8915O000000o + O000000o();
        }

        class O00000Oo extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            TextView f8921O000000o;

            public O00000Oo(View view) {
                super(view);
                this.f8921O000000o = (TextView) view.findViewById(R.id.room_name);
            }
        }

        /* renamed from: com.xiaomi.smarthome.homeroom.HomeRoomRecommendActivity$O000000o$O000000o  reason: collision with other inner class name */
        public class C0078O000000o extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            TextView f8916O000000o;
            EditText O00000Oo;
            ImageView O00000o0;

            public C0078O000000o(View view) {
                super(view);
                this.f8916O000000o = (TextView) view.findViewById(R.id.title_left);
                this.O00000Oo = (EditText) view.findViewById(R.id.room_name_edit);
                this.O00000Oo.setOnTouchListener(new View.OnTouchListener(O000000o.this) {
                    /* class com.xiaomi.smarthome.homeroom.HomeRoomRecommendActivity.O000000o.C0078O000000o.AnonymousClass1 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    int f8917O000000o = 0;

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        this.f8917O000000o++;
                        if (this.f8917O000000o == 2) {
                            this.f8917O000000o = 0;
                            hxi.O00000o.O0000oo0("1");
                        }
                        return false;
                    }
                });
                this.O00000o0 = (ImageView) view.findViewById(R.id.room_input_clear_img);
                this.O00000o0.setOnClickListener(new View.OnClickListener(O000000o.this) {
                    /* class com.xiaomi.smarthome.homeroom.HomeRoomRecommendActivity.O000000o.C0078O000000o.AnonymousClass2 */

                    public final void onClick(View view) {
                        C0078O000000o.this.O00000Oo.setText("");
                    }
                });
                this.O00000Oo.setOnEditorActionListener(new TextView.OnEditorActionListener(O000000o.this) {
                    /* class com.xiaomi.smarthome.homeroom.HomeRoomRecommendActivity.O000000o.C0078O000000o.AnonymousClass3 */

                    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                        return true;
                    }
                });
                this.O00000Oo.addTextChangedListener(new TextWatcher(O000000o.this) {
                    /* class com.xiaomi.smarthome.homeroom.HomeRoomRecommendActivity.O000000o.C0078O000000o.AnonymousClass4 */

                    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        HomeRoomRecommendActivity.this.f8914O000000o.setEnabled(true);
                    }

                    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        String obj = C0078O000000o.this.O00000Oo.getText().toString();
                        if (obj.length() > 0) {
                            if (!ggb.O0000oO(obj)) {
                                C0078O000000o.this.O00000Oo.setError(HomeRoomRecommendActivity.this.getString(R.string.room_name_too_long));
                            } else {
                                HomeRoomRecommendActivity.this.f8914O000000o.setEnabled(true);
                                return;
                            }
                        }
                        HomeRoomRecommendActivity.this.f8914O000000o.setEnabled(false);
                    }

                    public final void afterTextChanged(Editable editable) {
                        HomeRoomRecommendActivity.this.O00000Oo = editable.toString();
                    }
                });
            }
        }
    }
}
