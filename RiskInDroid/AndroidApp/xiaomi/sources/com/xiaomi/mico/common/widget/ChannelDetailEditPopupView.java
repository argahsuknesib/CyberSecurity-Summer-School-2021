package com.xiaomi.mico.common.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.xiaomi.mico.common.util.DisplayUtils;
import com.xiaomi.smarthome.R;

public class ChannelDetailEditPopupView extends LinearLayout {
    private onEditChannelListener onEditChannelListener;
    private PopupWindow popupWindow;
    View renameAndDeleteView;

    public interface onEditChannelListener {
        void onAddSong();

        void onDeleteSong();

        void onEnterEdit();

        void onRenameChanne();
    }

    private void init() {
    }

    public ChannelDetailEditPopupView(Context context) {
        super(context);
        init();
    }

    public ChannelDetailEditPopupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ChannelDetailEditPopupView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.renameAndDeleteView = findViewById(R.id.layout_of_remane_and_delete);
        View findViewById = findViewById(R.id.add_song);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.common.widget.$$Lambda$ChannelDetailEditPopupView$4xnNV0bVb3B7jB4l3JJTs0_t_Y */

                public final void onClick(View view) {
                    ChannelDetailEditPopupView.this.lambda$onFinishInflate$0$ChannelDetailEditPopupView(view);
                }
            });
        }
        View findViewById2 = findViewById(R.id.in_edit);
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.common.widget.$$Lambda$ChannelDetailEditPopupView$saBq0QCFmCO3nw0bkwWshWZj3mU */

                public final void onClick(View view) {
                    ChannelDetailEditPopupView.this.lambda$onFinishInflate$1$ChannelDetailEditPopupView(view);
                }
            });
        }
        View findViewById3 = findViewById(R.id.edit_rename);
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.common.widget.$$Lambda$ChannelDetailEditPopupView$e8Tl9zFK5WH8ce4_2h7kWXq10xQ */

                public final void onClick(View view) {
                    ChannelDetailEditPopupView.this.lambda$onFinishInflate$2$ChannelDetailEditPopupView(view);
                }
            });
        }
        View findViewById4 = findViewById(R.id.edit_delete);
        if (findViewById4 != null) {
            findViewById4.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.common.widget.$$Lambda$ChannelDetailEditPopupView$uH4REUdcfCGDjI9JM2mqVxMFLw */

                public final void onClick(View view) {
                    ChannelDetailEditPopupView.this.lambda$onFinishInflate$3$ChannelDetailEditPopupView(view);
                }
            });
        }
    }

    public void setPopupWindow(PopupWindow popupWindow2) {
        this.popupWindow = popupWindow2;
    }

    public void setCanRenameAndDelete(boolean z) {
        View view = this.renameAndDeleteView;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public void setOnEditChannelListener(onEditChannelListener oneditchannellistener) {
        this.onEditChannelListener = oneditchannellistener;
    }

    private void dissmiss() {
        PopupWindow popupWindow2 = this.popupWindow;
        if (popupWindow2 != null && popupWindow2.isShowing()) {
            this.popupWindow.dismiss();
        }
    }

    /* renamed from: onViewClicked */
    public void lambda$onFinishInflate$3$ChannelDetailEditPopupView(View view) {
        onEditChannelListener oneditchannellistener;
        dissmiss();
        int id = view.getId();
        if (id == R.id.add_song) {
            onEditChannelListener oneditchannellistener2 = this.onEditChannelListener;
            if (oneditchannellistener2 != null) {
                oneditchannellistener2.onAddSong();
            }
        } else if (id == R.id.in_edit) {
            onEditChannelListener oneditchannellistener3 = this.onEditChannelListener;
            if (oneditchannellistener3 != null) {
                oneditchannellistener3.onEnterEdit();
            }
        } else if (id == R.id.edit_rename) {
            onEditChannelListener oneditchannellistener4 = this.onEditChannelListener;
            if (oneditchannellistener4 != null) {
                oneditchannellistener4.onRenameChanne();
            }
        } else if (id == R.id.edit_delete && (oneditchannellistener = this.onEditChannelListener) != null) {
            oneditchannellistener.onDeleteSong();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.widget.PopupWindow.<init>(android.view.View, int, int, boolean):void}
     arg types: [com.xiaomi.mico.common.widget.ChannelDetailEditPopupView, int, int, int]
     candidates:
      ClspMth{android.widget.PopupWindow.<init>(android.content.Context, android.util.AttributeSet, int, int):void}
      ClspMth{android.widget.PopupWindow.<init>(android.view.View, int, int, boolean):void} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.drawable.InsetDrawable.<init>(android.graphics.drawable.Drawable, int):void}
     arg types: [android.graphics.drawable.ColorDrawable, int]
     candidates:
      ClspMth{android.graphics.drawable.InsetDrawable.<init>(android.graphics.drawable.Drawable, float):void}
      ClspMth{android.graphics.drawable.InsetDrawable.<init>(android.graphics.drawable.Drawable, int):void} */
    public static void show(final Context context, View view, boolean z, onEditChannelListener oneditchannellistener) {
        ChannelDetailEditPopupView channelDetailEditPopupView = (ChannelDetailEditPopupView) LayoutInflater.from(context).inflate((int) R.layout.popup_view_channel_detail_edit, (ViewGroup) null);
        channelDetailEditPopupView.setCanRenameAndDelete(z);
        PopupWindow popupWindow2 = new PopupWindow((View) channelDetailEditPopupView, -2, -2, true);
        popupWindow2.setOutsideTouchable(true);
        popupWindow2.setTouchable(true);
        int dip2px = DisplayUtils.dip2px(context, 12.0f);
        popupWindow2.setBackgroundDrawable(new InsetDrawable((Drawable) new ColorDrawable(context.getResources().getColor(R.color.mj_color_black_00_transparent)), dip2px));
        popupWindow2.setOutsideTouchable(true);
        channelDetailEditPopupView.setPopupWindow(popupWindow2);
        popupWindow2.setOnDismissListener(new PopupWindow.OnDismissListener() {
            /* class com.xiaomi.mico.common.widget.ChannelDetailEditPopupView.AnonymousClass1 */

            public final void onDismiss() {
                Window window = ((Activity) context).getWindow();
                window.addFlags(2);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.alpha = 1.0f;
                window.setAttributes(attributes);
            }
        });
        Window window = ((Activity) context).getWindow();
        window.addFlags(2);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.7f;
        window.setAttributes(attributes);
        channelDetailEditPopupView.setOnEditChannelListener(oneditchannellistener);
        popupWindow2.showAsDropDown(view, 0, -dip2px, 80);
    }
}
