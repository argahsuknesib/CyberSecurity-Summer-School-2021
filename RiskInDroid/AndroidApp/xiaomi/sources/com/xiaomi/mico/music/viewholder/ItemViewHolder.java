package com.xiaomi.mico.music.viewholder;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.xiaomi.mico.common.recyclerview.adapter.EditableAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.util.RxUtil;
import com.xiaomi.mico.music.adapter.LovableAdapter;
import com.xiaomi.smarthome.R;
import java.io.Serializable;
import rx.functions.Action1;

class ItemViewHolder {
    ItemViewHolder() {
    }

    static class Lovable extends LovableAdapter.ItemViewHolder {
        CheckBox editor;

        Lovable(View view, ItemClickableAdapter.OnItemClickListener onItemClickListener, LovableAdapter.Lovable lovable) {
            super(view, onItemClickListener, lovable);
            this.editor = (CheckBox) view.findViewById(R.id.editable_item_checkbox);
            CheckBox checkBox = this.editor;
            if (checkBox != null) {
                checkBox.setVisibility(8);
            }
        }
    }

    static class Editable extends EditableAdapter.ItemViewHolder {
        boolean canLove;
        ImageView love;

        Editable(View view, ItemClickableAdapter.OnItemClickListener onItemClickListener, final LovableAdapter.Lovable lovable) {
            super(view, onItemClickListener);
            this.love = (ImageView) view.findViewById(R.id.music_item_love);
            if (lovable != null) {
                this.canLove = true;
                RxUtil.debounceClick(this.love, new Action1<Void>() {
                    /* class com.xiaomi.mico.music.viewholder.ItemViewHolder.Editable.AnonymousClass1 */

                    public void call(Void voidR) {
                        lovable.onLove(Editable.this.love, (Serializable) Editable.this.love.getTag());
                    }
                });
                return;
            }
            this.love.setVisibility(8);
        }

        public void bindView(boolean z, boolean z2) {
            super.bindView(z, z2);
            if (this.canLove) {
                this.love.setVisibility(!z ? 0 : 8);
            }
        }

        /* access modifiers changed from: protected */
        public void bindView(Serializable serializable, boolean z) {
            if (this.canLove) {
                this.love.setTag(serializable);
                this.love.setEnabled(z);
            }
        }
    }
}
