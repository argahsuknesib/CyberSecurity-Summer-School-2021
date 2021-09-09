package com.xiaomi.smarthome.camera.activity.alarm2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.alarm2.bean.EventType;
import java.util.ArrayList;

public class RecyclerEventTypeAdapter extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
    private Context context;
    public OnItemClick onItemClick;
    private ArrayList<EventType> types;

    public interface OnItemClick {
        void onItemClick(int i);
    }

    public RecyclerEventTypeAdapter(Context context2, ArrayList<EventType> arrayList, OnItemClick onItemClick2) {
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
        return new TypeHolder(LayoutInflater.from(this.context).inflate((int) R.layout.item_event_type_recycler, viewGroup, false));
    }

    public void onBindViewHolder(final RecyclerView.O000OOo0 o000OOo0, int i) {
        TypeHolder typeHolder = (TypeHolder) o000OOo0;
        typeHolder.type_name.setText(this.types.get(o000OOo0.getAdapterPosition()).desc);
        typeHolder.itemView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.adapter.RecyclerEventTypeAdapter.AnonymousClass1 */

            public void onClick(View view) {
                if (RecyclerEventTypeAdapter.this.onItemClick != null) {
                    RecyclerEventTypeAdapter.this.onItemClick.onItemClick(o000OOo0.getAdapterPosition());
                }
            }
        });
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
        TextView type_name;

        public TypeHolder(View view) {
            super(view);
            this.type_name = (TextView) view.findViewById(R.id.type_name);
        }
    }
}
