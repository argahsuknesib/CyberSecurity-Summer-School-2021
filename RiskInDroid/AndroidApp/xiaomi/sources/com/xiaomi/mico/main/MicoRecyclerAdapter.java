package com.xiaomi.mico.main;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mico.api.model.Admin;
import com.xiaomi.mico.api.model.Miot;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.setting.mijia.MijiaCacheManager;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MicoRecyclerAdapter extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
    private Context context;
    private String currentMicoId;
    private List<Object> data;
    private List<Miot.Home> homes;
    private List<Admin.Mico> micoList;
    private HashMap<Admin.Mico, MijiaCacheManager.Location> micoLocationMap;
    private PopupWindow popupWindow;

    public MicoRecyclerAdapter(Context context2) {
        this.context = context2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new MicoHomeViewHolder(LayoutInflater.from(this.context).inflate((int) R.layout.view_mico_item_home, viewGroup, false));
        }
        if (i == 1) {
            return new MicoItemViewHolder(LayoutInflater.from(this.context).inflate((int) R.layout.view_mico_item, viewGroup, false));
        }
        if (i == 2) {
            return new MicoAddViewHolder(LayoutInflater.from(this.context).inflate((int) R.layout.view_mico_item_add, viewGroup, false));
        }
        if (i != 3) {
            return null;
        }
        return new MicoHeaderViewHolder(LayoutInflater.from(this.context).inflate((int) R.layout.mico_view_mico_item_header, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        Admin.Mico mico;
        String str;
        MijiaCacheManager.Location location;
        o000OOo0.itemView.setTag(R.id.mico_tag_item_data, this.data.get(i));
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0) {
            ((MicoHomeViewHolder) o000OOo0).homeName.setText(((Miot.Home) this.data.get(i)).name);
        } else if (itemViewType == 1) {
            Admin.Mico mico2 = (Admin.Mico) this.data.get(i);
            if (mico2 != null) {
                MicoItemViewHolder micoItemViewHolder = (MicoItemViewHolder) o000OOo0;
                micoItemViewHolder.itemView.setOnClickListener(new View.OnClickListener(mico2) {
                    /* class com.xiaomi.mico.main.$$Lambda$MicoRecyclerAdapter$hXlgUJIe3ks6bY8h43i65sCIaPI */
                    private final /* synthetic */ Admin.Mico f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        MicoRecyclerAdapter.this.lambda$onBindViewHolder$0$MicoRecyclerAdapter(this.f$1, view);
                    }
                });
                String string = this.context.getResources().getString(R.string.mico_miot_default_room_name);
                String string2 = this.context.getResources().getString(R.string.mico_unknown_home);
                HashMap<Admin.Mico, MijiaCacheManager.Location> hashMap = this.micoLocationMap;
                if (hashMap != null) {
                    MijiaCacheManager.Location location2 = hashMap.get(mico2);
                    if (!(location2 == null || location2.room == null)) {
                        string = location2.room.name;
                    }
                    if (!(location2 == null || location2.home == null)) {
                        string2 = location2.home.name;
                    }
                }
                String str2 = string;
                String str3 = string2;
                int i2 = i + 1;
                if (i2 < this.data.size()) {
                    getItemViewType(i2);
                }
                micoItemViewHolder.bindView(this.context.getResources(), mico2, this.currentMicoId, str2, str3);
            }
        } else if (itemViewType == 2) {
            ((MicoAddViewHolder) o000OOo0).itemView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.main.$$Lambda$MicoRecyclerAdapter$9AHtKMOpkAPl3seldkk0eAeuu9o */

                public final void onClick(View view) {
                    MicoRecyclerAdapter.this.lambda$onBindViewHolder$1$MicoRecyclerAdapter(view);
                }
            });
        } else if (itemViewType == 3 && (mico = (Admin.Mico) this.data.get(i)) != null) {
            MicoHeaderViewHolder micoHeaderViewHolder = (MicoHeaderViewHolder) o000OOo0;
            micoHeaderViewHolder.itemView.findViewById(R.id.mico_pop_close).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.main.$$Lambda$MicoRecyclerAdapter$j9A3OpkpsYYD1Tj2nrGBZSsVfo */

                public final void onClick(View view) {
                    MicoRecyclerAdapter.this.lambda$onBindViewHolder$2$MicoRecyclerAdapter(view);
                }
            });
            HashMap<Admin.Mico, MijiaCacheManager.Location> hashMap2 = this.micoLocationMap;
            if (hashMap2 != null) {
                Iterator<Map.Entry<Admin.Mico, MijiaCacheManager.Location>> it = hashMap2.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry next = it.next();
                    if (TextUtils.equals(((Admin.Mico) next.getKey()).deviceID, mico.deviceID) && (location = (MijiaCacheManager.Location) next.getValue()) != null && location.room != null) {
                        str = location.room.name;
                        break;
                    }
                }
                micoHeaderViewHolder.bindView(this.context.getResources(), mico, str);
            }
            str = "";
            micoHeaderViewHolder.bindView(this.context.getResources(), mico, str);
        }
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$MicoRecyclerAdapter(Admin.Mico mico, View view) {
        view.setBackgroundColor(this.context.getResources().getColor(R.color.mj_color_gray_lighter));
        MicoManager.getInstance().selectMico(mico.deviceID);
        PopupWindow popupWindow2 = this.popupWindow;
        if (popupWindow2 != null) {
            popupWindow2.dismiss();
        }
    }

    public /* synthetic */ void lambda$onBindViewHolder$1$MicoRecyclerAdapter(View view) {
        view.setBackgroundColor(this.context.getResources().getColor(R.color.mj_color_gray_lighter));
        PopupWindow popupWindow2 = this.popupWindow;
        if (popupWindow2 != null) {
            popupWindow2.dismiss();
        }
    }

    public /* synthetic */ void lambda$onBindViewHolder$2$MicoRecyclerAdapter(View view) {
        PopupWindow popupWindow2 = this.popupWindow;
        if (popupWindow2 != null) {
            popupWindow2.dismiss();
        }
    }

    public int getItemViewType(int i) {
        if (i == 0) {
            return 3;
        }
        return this.data.get(i) instanceof Miot.Home ? 0 : 1;
    }

    public int getItemCount() {
        List<Object> list = this.data;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void init(PopupWindow popupWindow2) {
        this.popupWindow = popupWindow2;
        updateData();
    }

    public void updatePopupWindow() {
        updateData();
        notifyDataSetChanged();
    }

    private void updateData() {
        this.currentMicoId = MicoManager.getInstance().getCurrentMicoID();
        Admin.Mico currentMico = MicoManager.getInstance().getCurrentMico();
        this.micoList = new ArrayList(MicoManager.getInstance().getMicoList());
        this.homes = MijiaCacheManager.getHomes();
        this.micoLocationMap = MijiaCacheManager.getMicoLocationMap();
        List<Object> list = this.data;
        if (list != null) {
            list.clear();
        } else {
            this.data = new ArrayList();
        }
        if (this.micoList.size() > 0) {
            this.data.add(currentMico);
        }
        List<Miot.Home> list2 = this.homes;
        if (list2 == null || ((list2 != null && list2.size() == 0) || this.micoLocationMap == null)) {
            this.data.addAll(this.micoList);
            return;
        }
        int i = 0;
        for (Miot.Home next : this.homes) {
            ArrayList arrayList = new ArrayList();
            this.data.add(next);
            boolean z = false;
            for (Map.Entry next2 : this.micoLocationMap.entrySet()) {
                Admin.Mico mico = (Admin.Mico) next2.getKey();
                MijiaCacheManager.Location location = (MijiaCacheManager.Location) next2.getValue();
                if (location != null && location.home.equals(next)) {
                    this.data.add(mico);
                    z = true;
                }
            }
            Object[] objArr = {"micos home name %s home dids %s, micos %s hasmicos %s, currentMicoId %s", next.name, next.dids, arrayList, Boolean.valueOf(z), this.currentMicoId};
            if (z) {
                i++;
            } else {
                List<Object> list3 = this.data;
                list3.remove(list3.size() - 1);
            }
        }
        if (i <= 1) {
            Object obj = null;
            for (Object next3 : this.data) {
                if (next3 instanceof Miot.Home) {
                    obj = next3;
                }
            }
            this.data.remove(obj);
        }
    }

    public List<Object> getAllData() {
        return this.data;
    }
}
