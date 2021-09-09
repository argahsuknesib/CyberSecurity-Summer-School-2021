package com.xiaomi.smarthome.nfctag.ui;

import _m_j.fno;
import _m_j.ggb;
import _m_j.hig;
import _m_j.hij;
import _m_j.hor;
import _m_j.hte;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.nfctag.ui.NFCDeviceListActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class NFCDeviceListActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    O000000o f10417O000000o;
    public List<hij> dcInfo = new ArrayList();
    @BindView(5685)
    RecyclerView mRecyclerList;
    public int mWriteType;
    @BindView(6027)
    TextView txt_hint;

    public class MyViewHolder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private MyViewHolder f10419O000000o;

        public MyViewHolder_ViewBinding(MyViewHolder myViewHolder, View view) {
            this.f10419O000000o = myViewHolder;
            myViewHolder.txtTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_title, "field 'txtTitle'", TextView.class);
            myViewHolder.txtSubTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_sub_title, "field 'txtSubTitle'", TextView.class);
            myViewHolder.abilityHint = (TextView) Utils.findRequiredViewAsType(view, R.id.ability_hint, "field 'abilityHint'", TextView.class);
            myViewHolder.imgIcon = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.img_device, "field 'imgIcon'", SimpleDraweeView.class);
        }

        public void unbind() {
            MyViewHolder myViewHolder = this.f10419O000000o;
            if (myViewHolder != null) {
                this.f10419O000000o = null;
                myViewHolder.txtTitle = null;
                myViewHolder.txtSubTitle = null;
                myViewHolder.abilityHint = null;
                myViewHolder.imgIcon = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_nfc_device);
        ButterKnife.bind(this);
        this.mWriteType = getIntent().getIntExtra("write_type", -1);
        if (this.mWriteType <= 0) {
            finish();
            return;
        }
        this.txt_hint.setText((int) R.string.nfc_action_speaker_hint);
        String stringExtra = getIntent().getStringExtra("params");
        if (!TextUtils.isEmpty(stringExtra)) {
            try {
                JSONObject jSONObject = new JSONObject(stringExtra);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hij O000000o2 = hij.O000000o(jSONObject.optString(next));
                    O000000o2.f18962O000000o = next;
                    this.dcInfo.add(O000000o2);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.nfctag.ui.$$Lambda$NFCDeviceListActivity$0TYDkV_YEaepQKKdW1r0RiqIzQ */

            public final void onClick(View view) {
                NFCDeviceListActivity.this.O000000o(view);
            }
        });
        this.mRecyclerList.setLayoutManager(new LinearLayoutManager(this));
        this.f10417O000000o = new O000000o(this, (byte) 0);
        this.mRecyclerList.setAdapter(this.f10417O000000o);
        this.f10417O000000o.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        hor.O000000o().setCurrentStepInCreateSceneManager(3);
        hor.O000000o().clearCreateSceneManager();
        hor.O000000o().setSceneInCreateSceneManager(null);
        finish();
    }

    class O000000o extends RecyclerView.O000000o<MyViewHolder> {
        public final long getItemId(int i) {
            return (long) i;
        }

        private O000000o() {
        }

        /* synthetic */ O000000o(NFCDeviceListActivity nFCDeviceListActivity, byte b) {
            this();
        }

        public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            MyViewHolder myViewHolder = (MyViewHolder) o000OOo0;
            hij hij = NFCDeviceListActivity.this.dcInfo.get(i);
            if (hij != null) {
                Device O000000o2 = fno.O000000o().O000000o(hij.f18962O000000o);
                if (O000000o2 != null) {
                    DeviceFactory.O00000Oo(O000000o2.model, myViewHolder.imgIcon);
                    if (!TextUtils.isEmpty(O000000o2.name)) {
                        myViewHolder.txtTitle.setText(O000000o2.name);
                    } else {
                        myViewHolder.txtTitle.setText("");
                    }
                    Home O0000o0 = ggb.O00000Oo().O0000o0(O000000o2.did);
                    StringBuilder sb = new StringBuilder();
                    if (O0000o0 != null) {
                        ggb.O00000Oo();
                        if (!TextUtils.isEmpty(ggb.O000000o(O0000o0))) {
                            ggb.O00000Oo();
                            sb.append(ggb.O000000o(O0000o0));
                        }
                    }
                    Room O0000o00 = ggb.O00000Oo().O0000o00(hij.f18962O000000o);
                    if (O0000o00 != null && !TextUtils.isEmpty(O0000o00.getName())) {
                        if (sb.length() > 0) {
                            sb.append(" | ");
                        }
                        sb.append(O0000o00.getName());
                    }
                    myViewHolder.txtSubTitle.setText(sb.toString());
                    if (hij.O00000oO == 1) {
                        myViewHolder.abilityHint.setText((int) R.string.nfc_tv_screen);
                    } else if (hij.O00000oO == 2) {
                        myViewHolder.abilityHint.setText((int) R.string.nfc_voice_relay);
                    } else if (hij.O00000oO == 4) {
                        myViewHolder.abilityHint.setText((int) R.string.nfc_phone_relay);
                    } else if (hij.O00000oO == 16) {
                        myViewHolder.abilityHint.setText((int) R.string.nfc_video_relay);
                    } else {
                        myViewHolder.abilityHint.setText("");
                    }
                    myViewHolder.itemView.setOnClickListener(new View.OnClickListener(hij) {
                        /* class com.xiaomi.smarthome.nfctag.ui.$$Lambda$NFCDeviceListActivity$O000000o$dPf0h3OlUPgTDWvEt0I73F2yvyI */
                        private final /* synthetic */ hij f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onClick(View view) {
                            NFCDeviceListActivity.O000000o.this.O000000o(this.f$1, view);
                        }
                    });
                    return;
                }
                DeviceFactory.O00000Oo((String) null, myViewHolder.imgIcon);
                myViewHolder.txtTitle.setText("");
                myViewHolder.txtSubTitle.setText("");
                myViewHolder.itemView.setOnClickListener(null);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(hij hij, View view) {
            Intent intent = new Intent(NFCDeviceListActivity.this, NFCWriteActivity.class);
            hig.f18961O000000o = NFCDeviceListActivity.this.mWriteType;
            JSONObject O000000o2 = hij.O000000o();
            if (O000000o2.keys().hasNext()) {
                hig.O00000o0 = O000000o2.toString();
                NFCDeviceListActivity.this.startActivity(intent);
                NFCDeviceListActivity.this.finish();
                return;
            }
            hte.O000000o(NFCDeviceListActivity.this, (int) R.string.sh_common_no_info);
        }

        public final int getItemCount() {
            if (NFCDeviceListActivity.this.dcInfo == null) {
                return 0;
            }
            return NFCDeviceListActivity.this.dcInfo.size();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            NFCDeviceListActivity nFCDeviceListActivity = NFCDeviceListActivity.this;
            return new MyViewHolder(nFCDeviceListActivity.getLayoutInflater().inflate((int) R.layout.item_nfc_device, viewGroup, false));
        }
    }

    public class MyViewHolder extends RecyclerView.O000OOo0 {
        @BindView(4837)
        public TextView abilityHint;
        @BindView(5317)
        public SimpleDraweeView imgIcon;
        @BindView(6032)
        public TextView txtSubTitle;
        @BindView(6034)
        public TextView txtTitle;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
