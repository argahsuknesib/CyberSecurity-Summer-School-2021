package com.xiaomi.smarthome.camera.activity.timelapse;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public abstract class ShootModeDialog extends BottomBaseDialog {

    public interface ShootFivesHourListener {
        void onConfirm(ShootModeDialog shootModeDialog);
    }

    public interface ShootOneHourListener {
        void onConfirm(ShootModeDialog shootModeDialog);
    }

    public interface ShootThreeHourListener {
        void onConfirm(ShootModeDialog shootModeDialog);
    }

    public interface ShootTwelveHourListener {
        void onConfirm(ShootModeDialog shootModeDialog);
    }

    public interface ShootTwentyFourHourListener {
        void onConfirm(ShootModeDialog shootModeDialog);
    }

    public ShootModeDialog(Context context) {
        super(context);
    }

    public ShootModeDialog(Context context, int i) {
        super(context, i);
    }

    public ShootModeDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
    }

    public static class Builder {
        View contentView;
        Context context;
        ShootModeDialog dialog;
        boolean isCancelable;
        ShootFivesHourListener shootFivesHourListener;
        ShootOneHourListener shootOneHourListener;
        ShootThreeHourListener shootThreeHourListener;
        ShootTwelveHourListener shootTwelveHourListener;
        ShootTwentyFourHourListener shootTwentyFourHourListener;
        String title;
        int type = 2;

        public Builder(Context context2, boolean z) {
            this.context = context2;
            this.isCancelable = z;
        }

        public String getTitle() {
            return this.title;
        }

        public Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        public int getType() {
            return this.type;
        }

        public Builder setType(int i) {
            this.type = i;
            return this;
        }

        public Builder setContentView(View view) {
            this.contentView = view;
            return this;
        }

        public Builder setShootOneHourListener(ShootOneHourListener shootOneHourListener2) {
            this.shootOneHourListener = shootOneHourListener2;
            return this;
        }

        public Builder setShootThreeHourListenerr(ShootThreeHourListener shootThreeHourListener2) {
            this.shootThreeHourListener = shootThreeHourListener2;
            return this;
        }

        public Builder setShootFivesHourListener(ShootFivesHourListener shootFivesHourListener2) {
            this.shootFivesHourListener = shootFivesHourListener2;
            return this;
        }

        public Builder setShootTwelveHourListener(ShootTwelveHourListener shootTwelveHourListener2) {
            this.shootTwelveHourListener = shootTwelveHourListener2;
            return this;
        }

        public Builder setShootTwentyFourHourListener(ShootTwentyFourHourListener shootTwentyFourHourListener2) {
            this.shootTwentyFourHourListener = shootTwentyFourHourListener2;
            return this;
        }

        public ShootModeDialog build() {
            this.dialog = new ShootModeDialog(this.context, this.isCancelable, null) {
                /* class com.xiaomi.smarthome.camera.activity.timelapse.ShootModeDialog.Builder.AnonymousClass1 */

                public View onCreateView() {
                    View inflate = LayoutInflater.from(Builder.this.context).inflate((int) R.layout.camera_layout_shoot_mode, (ViewGroup) null);
                    ((TextView) inflate.findViewById(R.id.tv_tips_title)).setText(Builder.this.title);
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_shoot_1);
                    TextView textView = (TextView) inflate.findViewById(R.id.tv_shoot_1);
                    ImageView imageView2 = (ImageView) inflate.findViewById(R.id.iv_shoot_3);
                    TextView textView2 = (TextView) inflate.findViewById(R.id.tv_shoot_3);
                    ImageView imageView3 = (ImageView) inflate.findViewById(R.id.iv_shoot_5);
                    TextView textView3 = (TextView) inflate.findViewById(R.id.tv_shoot_5);
                    ((LinearLayout) inflate.findViewById(R.id.ll_shoot_1)).setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.camera.activity.timelapse.ShootModeDialog.Builder.AnonymousClass1.AnonymousClass1 */

                        public void onClick(View view) {
                            if (Builder.this.shootOneHourListener != null) {
                                Builder.this.shootOneHourListener.onConfirm(this);
                            }
                        }
                    });
                    ((LinearLayout) inflate.findViewById(R.id.ll_shoot_3)).setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.camera.activity.timelapse.ShootModeDialog.Builder.AnonymousClass1.AnonymousClass2 */

                        public void onClick(View view) {
                            if (Builder.this.shootThreeHourListener != null) {
                                Builder.this.shootThreeHourListener.onConfirm(this);
                            }
                        }
                    });
                    ((LinearLayout) inflate.findViewById(R.id.ll_shoot_5)).setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.camera.activity.timelapse.ShootModeDialog.Builder.AnonymousClass1.AnonymousClass3 */

                        public void onClick(View view) {
                            if (Builder.this.shootFivesHourListener != null) {
                                Builder.this.shootFivesHourListener.onConfirm(this);
                            }
                        }
                    });
                    if (Builder.this.type == 0) {
                        imageView.setVisibility(0);
                        imageView2.setVisibility(4);
                        imageView3.setVisibility(4);
                        if (Build.VERSION.SDK_INT >= 23) {
                            textView.setTextColor(Builder.this.context.getColor(R.color.mj_color_green_normal));
                            textView2.setTextColor(Builder.this.context.getColor(R.color.mj_color_black));
                            textView3.setTextColor(Builder.this.context.getColor(R.color.mj_color_black));
                        }
                    } else if (Builder.this.type == 1) {
                        imageView.setVisibility(4);
                        imageView2.setVisibility(0);
                        imageView3.setVisibility(4);
                        if (Build.VERSION.SDK_INT >= 23) {
                            textView.setTextColor(Builder.this.context.getColor(R.color.mj_color_black));
                            textView2.setTextColor(Builder.this.context.getColor(R.color.mj_color_green_normal));
                            textView3.setTextColor(Builder.this.context.getColor(R.color.mj_color_black));
                        }
                    } else if (Builder.this.type == 2) {
                        imageView.setVisibility(4);
                        imageView2.setVisibility(4);
                        imageView3.setVisibility(0);
                        if (Build.VERSION.SDK_INT >= 23) {
                            textView.setTextColor(Builder.this.context.getColor(R.color.mj_color_black));
                            textView2.setTextColor(Builder.this.context.getColor(R.color.mj_color_black));
                            textView3.setTextColor(Builder.this.context.getColor(R.color.mj_color_green_normal));
                        }
                    }
                    return inflate;
                }
            };
            return this.dialog;
        }
    }
}
