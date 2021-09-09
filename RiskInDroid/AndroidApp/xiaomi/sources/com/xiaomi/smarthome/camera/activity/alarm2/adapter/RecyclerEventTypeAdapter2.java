package com.xiaomi.smarthome.camera.activity.alarm2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.alarm2.bean.EventType;
import java.util.ArrayList;

public class RecyclerEventTypeAdapter2 extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
    private Context context;
    public OnItemClick onItemClick;
    public String selectedEventType = "Default";
    private ArrayList<EventType> types;

    public interface OnItemClick {
        void onItemClick(int i);
    }

    public RecyclerEventTypeAdapter2(Context context2, ArrayList<EventType> arrayList, OnItemClick onItemClick2) {
        this.context = context2;
        this.types = arrayList;
        this.onItemClick = onItemClick2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new TypeHolder(LayoutInflater.from(this.context).inflate((int) R.layout.item_event_type_recycler2, viewGroup, false));
    }

    public void onBindViewHolder(final RecyclerView.O000OOo0 o000OOo0, int i) {
        TypeHolder typeHolder = (TypeHolder) o000OOo0;
        EventType eventType = this.types.get(o000OOo0.getAdapterPosition());
        typeHolder.type_name.setText(eventType.desc);
        if ("Default".equalsIgnoreCase(eventType.name)) {
            typeHolder.icon_event_type.setImageResource(R.drawable.icon_event_all_new);
        } else if ("ObjectMotion".equalsIgnoreCase(eventType.name)) {
            typeHolder.icon_event_type.setImageResource(R.drawable.icon_event_motion_new);
        } else if ("PeopleMotion".equalsIgnoreCase(eventType.name)) {
            typeHolder.icon_event_type.setImageResource(R.drawable.icon_event_people_motion_new);
        } else if ("BabyCry".equalsIgnoreCase(eventType.name)) {
            typeHolder.icon_event_type.setImageResource(R.drawable.icon_event_baby_cry_new);
        } else if ("Face".equalsIgnoreCase(eventType.name)) {
            typeHolder.icon_event_type.setImageResource(R.drawable.icon_event_face_new);
        } else if ("AI".equalsIgnoreCase(eventType.name)) {
            typeHolder.icon_event_type.setImageResource(R.drawable.icon_event_ai_new);
        } else if ("Pet".equalsIgnoreCase(eventType.name)) {
            typeHolder.icon_event_type.setImageResource(R.drawable.icon_event_pet_new);
        }
        typeHolder.itemView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.adapter.RecyclerEventTypeAdapter2.AnonymousClass1 */

            public void onClick(View view) {
                if (RecyclerEventTypeAdapter2.this.onItemClick != null) {
                    RecyclerEventTypeAdapter2.this.onItemClick.onItemClick(o000OOo0.getAdapterPosition());
                }
            }
        });
        if (eventType.name.equalsIgnoreCase(this.selectedEventType)) {
            typeHolder.root_ll.setSelected(true);
        } else {
            typeHolder.root_ll.setSelected(false);
        }
    }

    public void addEvent(EventType eventType) {
        this.types.add(eventType);
        notifyDataSetChanged();
    }

    public boolean containsAiType() {
        ArrayList<EventType> arrayList = this.types;
        if ("AI".equalsIgnoreCase(arrayList.get(arrayList.size() - 1).name)) {
            return true;
        }
        return false;
    }

    public int getItemCount() {
        return this.types.size();
    }

    class TypeHolder extends RecyclerView.O000OOo0 {
        ImageView icon_event_type;
        LinearLayout root_ll;
        TextView type_name;

        public TypeHolder(View view) {
            super(view);
            this.icon_event_type = (ImageView) view.findViewById(R.id.icon_event_type);
            this.type_name = (TextView) view.findViewById(R.id.type_name);
            this.root_ll = (LinearLayout) view.findViewById(R.id.root_ll);
        }
    }
}
