package com.xiaomi.mico.setting;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.ThirdPartyResponse;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.util.ArrayList;
import java.util.List;

public class PlateNumberActivity extends MicoBaseActivity {
    TextView addPlatenumber;
    LinearLayout contentView;
    View emptyView;
    ListView listview;
    public ArrayList<ThirdPartyResponse.PlateInfo> mPlateNumberInfo = new ArrayList<>();
    TitleBar titleBar;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_platenumber);
        this.titleBar = (TitleBar) findViewById(R.id.title_bar);
        this.listview = (ListView) findViewById(R.id.listview);
        this.emptyView = findViewById(R.id.empty_view);
        this.addPlatenumber = (TextView) findViewById(R.id.add_platenumber);
        this.addPlatenumber.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$PlateNumberActivity$gmgzvuexzXOIwJKM5tey468WAYo */

            public final void onClick(View view) {
                PlateNumberActivity.this.lambda$onCreate$0$PlateNumberActivity(view);
            }
        });
        this.contentView = (LinearLayout) findViewById(R.id.content_view);
        this.titleBar.setOnLeftIconClickListener(new TitleBar.OnLeftIconClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$PlateNumberActivity$zdIoBkSdsDFTneam8UQgS6l0Q */

            public final void onLeftIconClick() {
                PlateNumberActivity.this.lambda$onCreate$1$PlateNumberActivity();
            }
        });
        this.listview.setAdapter((ListAdapter) new PlateNumberAdapter());
        this.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.xiaomi.mico.setting.PlateNumberActivity.AnonymousClass1 */

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Intent intent = new Intent(PlateNumberActivity.this.getContext(), EditPlateNumberActivity.class);
                ThirdPartyResponse.PlateInfo plateInfo = PlateNumberActivity.this.mPlateNumberInfo.get(i);
                plateInfo.index = i;
                intent.putExtra("PLATENUMBER_INFO", plateInfo);
                PlateNumberActivity.this.startActivityForResult(intent, 1);
            }
        });
        this.listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* class com.xiaomi.mico.setting.PlateNumberActivity.AnonymousClass2 */

            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                new MLAlertDialog.Builder(PlateNumberActivity.this.getContext()).O000000o((int) R.string.mico_common_hint).O00000Oo((int) R.string.traffic_plate_number_delete_title).O00000Oo((int) R.string.common_cancel, (DialogInterface.OnClickListener) null).O000000o((int) R.string.common_confirm, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.mico.setting.PlateNumberActivity.AnonymousClass2.AnonymousClass1 */

                    public void onClick(DialogInterface dialogInterface, int i) {
                        PlateNumberActivity.this.removePlateNumber(i);
                    }
                }).O00000oo();
                return true;
            }
        });
        loadServerData();
    }

    public /* synthetic */ void lambda$onCreate$0$PlateNumberActivity(View view) {
        onViewClicked();
    }

    public /* synthetic */ void lambda$onCreate$1$PlateNumberActivity() {
        Intent intent = new Intent();
        intent.putExtra("PLATENUMBER_INFO", this.mPlateNumberInfo);
        setResult(-1, intent);
        finish();
    }

    public void removePlateNumber(int i) {
        ApiHelper.removePlateInfo(i, new ApiRequest.Listener<Boolean>() {
            /* class com.xiaomi.mico.setting.PlateNumberActivity.AnonymousClass3 */

            public void onSuccess(Boolean bool) {
                PlateNumberActivity.this.loadServerData();
            }

            public void onFailure(ApiError apiError) {
                ToastUtil.showToast((int) R.string.common_save_fail);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void loadServerData() {
        ApiHelper.getPlateInfo(new ApiRequest.Listener<List<ThirdPartyResponse.PlateInfo>>() {
            /* class com.xiaomi.mico.setting.PlateNumberActivity.AnonymousClass4 */

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((List<ThirdPartyResponse.PlateInfo>) ((List) obj));
            }

            public void onSuccess(List<ThirdPartyResponse.PlateInfo> list) {
                PlateNumberActivity.this.mPlateNumberInfo.clear();
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).index = i;
                }
                PlateNumberActivity.this.mPlateNumberInfo.addAll(list);
                PlateNumberActivity.this.refreshUI();
            }

            public void onFailure(ApiError apiError) {
                PlateNumberActivity.this.finish();
                ToastUtil.showToast((int) R.string.common_load_failed);
            }
        });
    }

    private void updatePlateNumber(ThirdPartyResponse.PlateInfo plateInfo) {
        ApiHelper.updatePlateInfo(plateInfo.index == -1 ? this.mPlateNumberInfo.size() : plateInfo.index, plateInfo, new ApiRequest.Listener<Boolean>() {
            /* class com.xiaomi.mico.setting.PlateNumberActivity.AnonymousClass5 */

            public void onSuccess(Boolean bool) {
                PlateNumberActivity.this.loadServerData();
            }

            public void onFailure(ApiError apiError) {
                ToastUtil.showToast((int) R.string.common_save_fail);
            }
        });
    }

    public void refreshUI() {
        if (this.mPlateNumberInfo.size() > 0) {
            this.contentView.setVisibility(0);
            this.emptyView.setVisibility(8);
            ((BaseAdapter) this.listview.getAdapter()).notifyDataSetChanged();
            return;
        }
        showEmptyView();
    }

    private void showEmptyView() {
        this.emptyView.setVisibility(0);
        this.contentView.setVisibility(8);
    }

    public void onViewClicked() {
        startActivityForResult(new Intent(this, EditPlateNumberActivity.class), 1);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 1) {
            updatePlateNumber((ThirdPartyResponse.PlateInfo) intent.getSerializableExtra("PLATENUMBER_INFO"));
        }
    }

    class PlateNumberAdapter extends BaseAdapter {
        public long getItemId(int i) {
            return 0;
        }

        private PlateNumberAdapter() {
        }

        public int getCount() {
            return PlateNumberActivity.this.mPlateNumberInfo.size();
        }

        public Object getItem(int i) {
            return PlateNumberActivity.this.mPlateNumberInfo.get(i);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(PlateNumberActivity.this.getContext()).inflate((int) R.layout.traffic_platenumber_item_view, viewGroup, false);
                view.setTag(new ViewHolder(view));
            }
            ((ViewHolder) view.getTag()).refreshUI((ThirdPartyResponse.PlateInfo) getItem(i));
            return view;
        }
    }

    class ViewHolder {
        TextView comment;
        private ThirdPartyResponse.PlateInfo mInfo;
        TextView plateNumber;

        public ViewHolder(View view) {
            this.plateNumber = (TextView) view.findViewById(R.id.plate_number);
            this.comment = (TextView) view.findViewById(R.id.comment);
        }

        public void refreshUI(ThirdPartyResponse.PlateInfo plateInfo) {
            this.mInfo = plateInfo;
            this.plateNumber.setText(plateInfo.number);
            this.comment.setText(plateInfo.name);
        }
    }
}
