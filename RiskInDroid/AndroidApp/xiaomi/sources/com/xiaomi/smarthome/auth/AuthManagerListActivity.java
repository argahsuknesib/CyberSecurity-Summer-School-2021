package com.xiaomi.smarthome.auth;

import _m_j.fah;
import _m_j.fak;
import _m_j.fsm;
import _m_j.fso;
import _m_j.fss;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.log.LogType;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthManagerListActivity extends BaseActivity {
    public AuthManagerAdapter mAdapter;
    public List<fah> mAuthAppInfos = new ArrayList();
    @BindView(7573)
    ImageView mBackIV;
    @BindView(6957)
    LinearLayout mEmptyLL;
    @BindView(6479)
    ListView mListView;
    @BindView(7578)
    TextView mTitleTV;

    class AuthManagerAdapter extends BaseAdapter {
        private Context O00000Oo;
        private LayoutInflater O00000o0;

        public final long getItemId(int i) {
            return (long) i;
        }

        public class ViewHolder_ViewBinding implements Unbinder {

            /* renamed from: O000000o  reason: collision with root package name */
            private ViewHolder f4263O000000o;

            public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
                this.f4263O000000o = viewHolder;
                viewHolder.mImage = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.image, "field 'mImage'", SimpleDraweeView.class);
                viewHolder.mNameTV = (TextView) Utils.findRequiredViewAsType(view, R.id.name, "field 'mNameTV'", TextView.class);
                viewHolder.mAuthTime = (TextView) Utils.findRequiredViewAsType(view, R.id.auth_time, "field 'mAuthTime'", TextView.class);
            }

            public void unbind() {
                ViewHolder viewHolder = this.f4263O000000o;
                if (viewHolder != null) {
                    this.f4263O000000o = null;
                    viewHolder.mImage = null;
                    viewHolder.mNameTV = null;
                    viewHolder.mAuthTime = null;
                    return;
                }
                throw new IllegalStateException("Bindings already cleared.");
            }
        }

        public AuthManagerAdapter(Context context) {
            this.O00000Oo = context;
            this.O00000o0 = LayoutInflater.from(context);
        }

        public final int getCount() {
            return AuthManagerListActivity.this.mAuthAppInfos.size();
        }

        public final Object getItem(int i) {
            return AuthManagerListActivity.this.mAuthAppInfos.get(i);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(this.O00000Oo).inflate((int) R.layout.activity_auth_manager_list_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.mImage.setHierarchy(new GenericDraweeHierarchyBuilder(viewHolder.mImage.getResources()).setFadeDuration(200).setPlaceholderImage(viewHolder.mImage.getResources().getDrawable(R.drawable.device_list_phone_no)).setActualImageScaleType(ScalingUtils.ScaleType.FIT_START).setRoundingParams(RoundingParams.fromCornersRadius(20.0f)).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_START).build());
            final fah fah = AuthManagerListActivity.this.mAuthAppInfos.get(i);
            if (!TextUtils.isEmpty(fah.O00000o0)) {
                viewHolder.mImage.setImageURI(Uri.parse(fah.O00000o0));
            }
            viewHolder.mNameTV.setText(fah.f15999O000000o);
            viewHolder.mAuthTime.setText(SimpleDateFormat.getInstance().format(new Date(Long.valueOf(fah.O00000oo).longValue())));
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.auth.AuthManagerListActivity.AuthManagerAdapter.AnonymousClass1 */

                public final void onClick(View view) {
                    Intent intent = new Intent(AuthManagerListActivity.this, AuthManagerDetailActivity.class);
                    intent.putExtra("extra_application_id", fah.O00000o);
                    AuthManagerListActivity.this.startActivityForResult(intent, 1);
                }
            });
            return view;
        }

        class ViewHolder {
            @BindView(6481)
            TextView mAuthTime;
            @BindView(7209)
            SimpleDraweeView mImage;
            @BindView(7639)
            TextView mNameTV;

            public ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_auth_manager_list_layout);
        ButterKnife.bind(this);
        fak.O000000o();
        fak.O00000o();
        this.mAdapter = new AuthManagerAdapter(this);
        this.mListView.setAdapter((ListAdapter) this.mAdapter);
        this.mTitleTV.setText((int) R.string.auth_manager);
        this.mBackIV.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.auth.AuthManagerListActivity.AnonymousClass1 */

            public final void onClick(View view) {
                AuthManagerListActivity.this.finish();
            }
        });
        fak O000000o2 = fak.O000000o();
        AnonymousClass2 r5 = new fsm() {
            /* class com.xiaomi.smarthome.auth.AuthManagerListActivity.AnonymousClass2 */

            public final void onSuccess(Object obj) {
                AuthManagerListActivity.this.mAuthAppInfos.clear();
                AuthManagerListActivity.this.mAuthAppInfos.addAll((List) obj);
                AuthManagerListActivity.this.mAdapter.notifyDataSetChanged();
                if (AuthManagerListActivity.this.mAuthAppInfos.size() == 0) {
                    AuthManagerListActivity.this.mEmptyLL.setVisibility(0);
                } else {
                    AuthManagerListActivity.this.mEmptyLL.setVisibility(8);
                }
            }

            public final void onFailure(fso fso) {
                AuthManagerListActivity.this.mEmptyLL.setVisibility(0);
            }
        };
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("data", new JSONObject().toString()));
        CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/auth/authlist").O000000o(arrayList).O000000o(), new fss<List<fah>>() {
            /* class _m_j.fak.AnonymousClass6 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                ArrayList arrayList = new ArrayList();
                if (jSONObject != null) {
                    LogType logType = LogType.GENERAL;
                    gsy.O000000o(logType, "AuthManager", "getAuthList---" + jSONObject.toString());
                    JSONArray optJSONArray = jSONObject.optJSONArray("result");
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.get(i);
                        fah fah = new fah();
                        if (jSONObject2 != null) {
                            fah.f15999O000000o = jSONObject2.optString("title");
                            fah.O00000Oo = jSONObject2.optString("intro");
                            fah.O00000oO = jSONObject2.optString("app_id");
                            fah.O00000o = jSONObject2.optString("application_id");
                            fah.O00000oo = jSONObject2.optString("issue_time");
                            fah.O0000O0o = jSONObject2.optString("expire_time");
                            fah.O00000o0 = jSONObject2.optString("icon");
                        }
                        arrayList.add(fah);
                    }
                }
                return arrayList;
            }
        }, Crypto.RC4, r5);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1) {
            String stringExtra = intent.getStringExtra("extra_application_id");
            if (intent != null && !TextUtils.isEmpty(stringExtra)) {
                for (int i3 = 0; i3 < this.mAuthAppInfos.size(); i3++) {
                    if (this.mAuthAppInfos.get(i3).O00000o.equalsIgnoreCase(stringExtra)) {
                        this.mAuthAppInfos.remove(i3);
                        if (this.mAuthAppInfos.size() == 0) {
                            this.mEmptyLL.setVisibility(0);
                        } else {
                            this.mEmptyLL.setVisibility(8);
                        }
                        this.mAdapter.notifyDataSetChanged();
                        return;
                    }
                }
            }
        }
    }
}
