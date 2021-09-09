package com.xiaomi.smarthome.camera.activity;

import _m_j.cki;
import _m_j.ft;
import _m_j.fta;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.SelectKnowFaceFigure;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.device.api.spec.instance.SpecService;
import com.xiaomi.smarthome.miio.camera.face.FaceManager;
import com.xiaomi.smarthome.miio.camera.face.model.FigureInfos;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class SelectKnowFaceFigure extends CameraBaseActivity {
    public static final String TAG = "SelectKnowFaceFigure";
    protected static FaceManager mFaceManager;
    FigureInfos figureInfos = new FigureInfos();
    Intent intent;
    ItemAdapter mAdapter;
    ImageView mBackBtn;
    ListView mContentList;
    TextView mTitle;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.widget.ListView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    /* access modifiers changed from: protected */
    public void doCreate(Bundle bundle) {
        setContentView((int) R.layout.smarthome_camera_scene_face_detail);
        ButterKnife.bind(this);
        this.mBackBtn = (ImageView) findViewById(R.id.module_a_3_return_btn);
        this.mTitle = (TextView) findViewById(R.id.module_a_3_return_title);
        this.mContentList = (ListView) findViewById(R.id.content_list_view);
        this.figureInfos.figureInfos = new ArrayList<>();
        this.intent = getIntent();
        this.mBackBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.SelectKnowFaceFigure.AnonymousClass1 */

            public void onClick(View view) {
                SelectKnowFaceFigure.this.onBackPressed();
            }
        });
        if (this.mCameraDevice != null) {
            this.mTitle.setText(this.mCameraDevice.getName());
        } else {
            this.mTitle.setText((int) R.string.scene_manage);
        }
        this.mAdapter = new ItemAdapter();
        this.mContentList.addHeaderView(LayoutInflater.from(this).inflate((int) R.layout.common_list_space_empty, (ViewGroup) this.mContentList, false));
        this.mContentList.setAdapter((ListAdapter) this.mAdapter);
        if (mFaceManager == null) {
            mFaceManager = FaceManager.getInstance(this.mCameraDevice);
        }
        mFaceManager.getFigures(new FaceManager.IFaceCallback() {
            /* class com.xiaomi.smarthome.camera.activity.SelectKnowFaceFigure.AnonymousClass2 */

            public void onSuccess(Object obj, Object obj2) {
                if (!SelectKnowFaceFigure.this.isFinishing()) {
                    SelectKnowFaceFigure selectKnowFaceFigure = SelectKnowFaceFigure.this;
                    selectKnowFaceFigure.figureInfos = (FigureInfos) obj2;
                    selectKnowFaceFigure.mAdapter.notifyDataSetChanged();
                }
            }

            public void onFailure(int i, String str) {
                if (!SelectKnowFaceFigure.this.isFinishing()) {
                    String str2 = SelectKnowFaceFigure.TAG;
                    cki.O00000oO(str2, i + "--" + str);
                }
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public void onBackPressed() {
        super.onBackPressed();
        this.intent.putExtra("isSaveEntrance", false);
        this.intent.setAction("scene_action_plugin");
        ft.O000000o(this).O000000o(this.intent);
    }

    class ItemAdapter extends BaseAdapter {
        public Object getItem(int i) {
            return null;
        }

        public long getItemId(int i) {
            return 0;
        }

        ItemAdapter() {
        }

        public int getCount() {
            return SelectKnowFaceFigure.this.figureInfos.figureInfos.size();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(SelectKnowFaceFigure.this).inflate((int) R.layout.face_action_item, viewGroup, false);
                viewHolder = new ViewHolder();
                viewHolder.itemView = view;
                viewHolder.description_text = (TextView) view.findViewById(R.id.description_text);
                viewHolder.isSelectedView = view.findViewById(R.id.is_selected);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.itemView.setOnClickListener(new View.OnClickListener(i) {
                /* class com.xiaomi.smarthome.camera.activity.$$Lambda$SelectKnowFaceFigure$ItemAdapter$KPh1Wl5GcSTfPahIq9_zh98ZFoY */
                private final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    SelectKnowFaceFigure.ItemAdapter.this.lambda$getView$0$SelectKnowFaceFigure$ItemAdapter(this.f$1, view);
                }
            });
            viewHolder.description_text.setText(SelectKnowFaceFigure.this.figureInfos.figureInfos.get(i).figureName);
            return view;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
         arg types: [java.lang.String, int]
         candidates:
          ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
        public /* synthetic */ void lambda$getView$0$SelectKnowFaceFigure$ItemAdapter(int i, View view) {
            if (SelectKnowFaceFigure.this.mCameraSpecDevice == null) {
                fta fta = fta.O000000o.f17086O000000o;
                fta.O000000o("only support spec device!");
                return;
            }
            String model = SelectKnowFaceFigure.this.mCameraDevice.getModel();
            SpecService O000000o2 = SelectKnowFaceFigure.this.mCameraSpecDevice.O000000o("ai-scene");
            SpecProperty O000000o3 = SelectKnowFaceFigure.this.mCameraSpecDevice.O000000o(O000000o2, "figureid");
            if (O000000o2 == null || O000000o3 == null) {
                fta fta2 = fta.O000000o.f17086O000000o;
                fta.O000000o("spec params error!");
                return;
            }
            int iid = O000000o2.getIid();
            int iid2 = O000000o3.getIid();
            try {
                String jSONObject = new JSONObject("{\"sub_props\":{\"express\":0,\"attr\":[{\"key\":\"prop." + model + "." + iid + "." + iid2 + "\",\"value\":\"" + SelectKnowFaceFigure.this.figureInfos.figureInfos.get(i).figureId + "\"}]}}").toString();
                cki.O00000o(SelectKnowFaceFigure.TAG, "scene value = ".concat(String.valueOf(jSONObject)));
                SelectKnowFaceFigure.this.intent.putExtra("value", jSONObject);
                SelectKnowFaceFigure.this.intent.putExtra("key_name", String.format(SelectKnowFaceFigure.this.getString(R.string.known_face_appear), SelectKnowFaceFigure.this.figureInfos.figureInfos.get(i).figureName));
                SelectKnowFaceFigure.this.intent.putExtra("isSaveEntrance", true);
                SelectKnowFaceFigure.this.intent.setAction("scene_action_plugin");
                ft.O000000o(SelectKnowFaceFigure.this).O000000o(SelectKnowFaceFigure.this.intent);
                SelectKnowFaceFigure.this.finish();
            } catch (JSONException e) {
                cki.O00000oO(SelectKnowFaceFigure.TAG, e.toString());
            }
        }

        public class ViewHolder {
            public TextView description_text;
            public View isSelectedView;
            public View itemView;

            public ViewHolder() {
            }
        }
    }
}
