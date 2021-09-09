package android.support.v7.app;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompatBase;
import android.widget.RemoteViews;
import com.xiaomi.smarthome.R;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

@TargetApi(9)
@RequiresApi(9)
class NotificationCompatImplBase {
    public static float constrain(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    private static int getActionLayoutResource() {
        return R.layout.notification_action;
    }

    private static int getActionTombstoneLayoutResource() {
        return R.layout.notification_action_tombstone;
    }

    @TargetApi(11)
    @RequiresApi(11)
    private static int getBigMediaLayoutResource(boolean z, int i) {
        return i <= 3 ? z ? R.layout.notification_template_big_media_narrow_custom : R.layout.notification_template_big_media_narrow : z ? R.layout.notification_template_big_media_custom : R.layout.notification_template_big_media;
    }

    NotificationCompatImplBase() {
    }

    @TargetApi(11)
    @RequiresApi(11)
    public static <T extends NotificationCompatBase.Action> RemoteViews overrideContentViewMedia(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, int i2, List<T> list, int[] iArr, boolean z2, PendingIntent pendingIntent, boolean z3) {
        RemoteViews generateContentViewMedia = generateContentViewMedia(context, charSequence, charSequence2, charSequence3, i, bitmap, charSequence4, z, j, i2, list, iArr, z2, pendingIntent, z3);
        notificationBuilderWithBuilderAccessor.getBuilder().setContent(generateContentViewMedia);
        if (z2) {
            notificationBuilderWithBuilderAccessor.getBuilder().setOngoing(true);
        }
        return generateContentViewMedia;
    }

    @TargetApi(11)
    @RequiresApi(11)
    private static <T extends NotificationCompatBase.Action> RemoteViews generateContentViewMedia(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, int i2, List<T> list, int[] iArr, boolean z2, PendingIntent pendingIntent, boolean z3) {
        int i3;
        int[] iArr2 = iArr;
        RemoteViews applyStandardTemplate = applyStandardTemplate(context, charSequence, charSequence2, charSequence3, i, 0, bitmap, charSequence4, z, j, i2, 0, z3 ? R.layout.notification_template_media_custom : R.layout.notification_template_media, true);
        int size = list.size();
        if (iArr2 == null) {
            i3 = 0;
        } else {
            i3 = Math.min(iArr2.length, 3);
        }
        applyStandardTemplate.removeAllViews(R.id.media_actions);
        if (i3 > 0) {
            int i4 = 0;
            while (i4 < i3) {
                if (i4 < size) {
                    applyStandardTemplate.addView(R.id.media_actions, generateMediaActionButton(context, (NotificationCompatBase.Action) list.get(iArr2[i4])));
                    i4++;
                } else {
                    throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", Integer.valueOf(i4), Integer.valueOf(size - 1)));
                }
            }
        }
        if (z2) {
            applyStandardTemplate.setViewVisibility(R.id.end_padder, 8);
            applyStandardTemplate.setViewVisibility(R.id.cancel_action, 0);
            applyStandardTemplate.setOnClickPendingIntent(R.id.cancel_action, pendingIntent);
            applyStandardTemplate.setInt(R.id.cancel_action, "setAlpha", context.getResources().getInteger(R.integer.cancel_button_image_alpha));
        } else {
            applyStandardTemplate.setViewVisibility(R.id.end_padder, 0);
            applyStandardTemplate.setViewVisibility(R.id.cancel_action, 8);
        }
        return applyStandardTemplate;
    }

    @TargetApi(16)
    @RequiresApi(16)
    public static <T extends NotificationCompatBase.Action> void overrideMediaBigContentView(Notification notification, Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, int i2, int i3, List<T> list, boolean z2, PendingIntent pendingIntent, boolean z3) {
        Notification notification2 = notification;
        notification2.bigContentView = generateMediaBigView(context, charSequence, charSequence2, charSequence3, i, bitmap, charSequence4, z, j, i2, i3, list, z2, pendingIntent, z3);
        if (z2) {
            notification2.flags |= 2;
        }
    }

    @TargetApi(11)
    @RequiresApi(11)
    public static <T extends NotificationCompatBase.Action> RemoteViews generateMediaBigView(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, int i2, int i3, List<T> list, boolean z2, PendingIntent pendingIntent, boolean z3) {
        int min = Math.min(list.size(), 5);
        RemoteViews applyStandardTemplate = applyStandardTemplate(context, charSequence, charSequence2, charSequence3, i, 0, bitmap, charSequence4, z, j, i2, i3, getBigMediaLayoutResource(z3, min), false);
        applyStandardTemplate.removeAllViews(R.id.media_actions);
        if (min > 0) {
            for (int i4 = 0; i4 < min; i4++) {
                applyStandardTemplate.addView(R.id.media_actions, generateMediaActionButton(context, (NotificationCompatBase.Action) list.get(i4)));
            }
        }
        if (z2) {
            applyStandardTemplate.setViewVisibility(R.id.cancel_action, 0);
            applyStandardTemplate.setInt(R.id.cancel_action, "setAlpha", context.getResources().getInteger(R.integer.cancel_button_image_alpha));
            applyStandardTemplate.setOnClickPendingIntent(R.id.cancel_action, pendingIntent);
        } else {
            applyStandardTemplate.setViewVisibility(R.id.cancel_action, 8);
        }
        return applyStandardTemplate;
    }

    @TargetApi(11)
    @RequiresApi(11)
    private static RemoteViews generateMediaActionButton(Context context, NotificationCompatBase.Action action) {
        boolean z = action.getActionIntent() == null;
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), (int) R.layout.notification_media_action);
        remoteViews.setImageViewResource(R.id.action0, action.getIcon());
        if (!z) {
            remoteViews.setOnClickPendingIntent(R.id.action0, action.getActionIntent());
        }
        if (Build.VERSION.SDK_INT >= 15) {
            remoteViews.setContentDescription(R.id.action0, action.getTitle());
        }
        return remoteViews;
    }

    public static RemoteViews applyStandardTemplateWithActions(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, int i2, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, int i3, int i4, int i5, boolean z2, ArrayList<NotificationCompat.Action> arrayList) {
        boolean z3;
        int size;
        RemoteViews applyStandardTemplate = applyStandardTemplate(context, charSequence, charSequence2, charSequence3, i, i2, bitmap, charSequence4, z, j, i3, i4, i5, z2);
        applyStandardTemplate.removeAllViews(R.id.actions);
        int i6 = 0;
        if (arrayList == null || (size = arrayList.size()) <= 0) {
            z3 = false;
        } else {
            if (size > 3) {
                size = 3;
            }
            for (int i7 = 0; i7 < size; i7++) {
                applyStandardTemplate.addView(R.id.actions, generateActionButton(context, arrayList.get(i7)));
            }
            z3 = true;
        }
        if (!z3) {
            i6 = 8;
        }
        applyStandardTemplate.setViewVisibility(R.id.actions, i6);
        applyStandardTemplate.setViewVisibility(R.id.action_divider, i6);
        return applyStandardTemplate;
    }

    private static RemoteViews generateActionButton(Context context, NotificationCompat.Action action) {
        int i;
        boolean z = action.actionIntent == null;
        String packageName = context.getPackageName();
        if (z) {
            i = getActionTombstoneLayoutResource();
        } else {
            i = getActionLayoutResource();
        }
        RemoteViews remoteViews = new RemoteViews(packageName, i);
        remoteViews.setImageViewBitmap(R.id.action_image, createColoredBitmap(context, action.getIcon(), context.getResources().getColor(R.color.notification_action_color_filter)));
        remoteViews.setTextViewText(R.id.action_text, action.title);
        if (!z) {
            remoteViews.setOnClickPendingIntent(R.id.action_container, action.actionIntent);
        }
        if (Build.VERSION.SDK_INT >= 15) {
            remoteViews.setContentDescription(R.id.action_container, action.title);
        }
        return remoteViews;
    }

    private static Bitmap createColoredBitmap(Context context, int i, int i2) {
        return createColoredBitmap(context, i, i2, 0);
    }

    private static Bitmap createColoredBitmap(Context context, int i, int i2, int i3) {
        Drawable drawable = context.getResources().getDrawable(i);
        int intrinsicWidth = i3 == 0 ? drawable.getIntrinsicWidth() : i3;
        if (i3 == 0) {
            i3 = drawable.getIntrinsicHeight();
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, i3, Bitmap.Config.ARGB_8888);
        drawable.setBounds(0, 0, intrinsicWidth, i3);
        if (i2 != 0) {
            drawable.mutate().setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_IN));
        }
        drawable.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01c7  */
    public static RemoteViews applyStandardTemplate(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, int i2, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, int i3, int i4, int i5, boolean z2) {
        boolean z3;
        int i6;
        int i7;
        boolean z4;
        long j2;
        int i8;
        boolean z5;
        Context context2 = context;
        CharSequence charSequence5 = charSequence;
        CharSequence charSequence6 = charSequence2;
        CharSequence charSequence7 = charSequence3;
        int i9 = i;
        int i10 = i2;
        Bitmap bitmap2 = bitmap;
        CharSequence charSequence8 = charSequence4;
        int i11 = i4;
        Resources resources = context.getResources();
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), i5);
        boolean z6 = i3 < -1;
        if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT < 21) {
            if (z6) {
                remoteViews.setInt(R.id.notification_background, "setBackgroundResource", R.drawable.notification_bg_low);
                remoteViews.setInt(R.id.icon, "setBackgroundResource", R.drawable.notification_template_icon_low_bg);
            } else {
                remoteViews.setInt(R.id.notification_background, "setBackgroundResource", R.drawable.notification_bg);
                remoteViews.setInt(R.id.icon, "setBackgroundResource", R.drawable.notification_template_icon_bg);
            }
        }
        if (bitmap2 != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                remoteViews.setViewVisibility(R.id.icon, 0);
                remoteViews.setImageViewBitmap(R.id.icon, bitmap2);
            } else {
                remoteViews.setViewVisibility(R.id.icon, 8);
            }
            if (i10 != 0) {
                int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.notification_right_icon_size);
                int dimensionPixelSize2 = dimensionPixelSize - (resources.getDimensionPixelSize(R.dimen.notification_small_icon_background_padding) * 2);
                if (Build.VERSION.SDK_INT >= 21) {
                    remoteViews.setImageViewBitmap(R.id.right_icon, createIconWithBackground(context2, i10, dimensionPixelSize, dimensionPixelSize2, i11));
                } else {
                    remoteViews.setImageViewBitmap(R.id.right_icon, createColoredBitmap(context2, i10, -1));
                }
                remoteViews.setViewVisibility(R.id.right_icon, 0);
            }
        } else if (i10 != 0) {
            remoteViews.setViewVisibility(R.id.icon, 0);
            if (Build.VERSION.SDK_INT >= 21) {
                remoteViews.setImageViewBitmap(R.id.icon, createIconWithBackground(context2, i10, resources.getDimensionPixelSize(R.dimen.notification_large_icon_width) - resources.getDimensionPixelSize(R.dimen.notification_big_circle_margin), resources.getDimensionPixelSize(R.dimen.notification_small_icon_size_as_large), i11));
            } else {
                remoteViews.setImageViewBitmap(R.id.icon, createColoredBitmap(context2, i10, -1));
            }
        }
        if (charSequence5 != null) {
            remoteViews.setTextViewText(R.id.title, charSequence5);
        }
        if (charSequence6 != null) {
            remoteViews.setTextViewText(R.id.text, charSequence6);
            z3 = true;
        } else {
            z3 = false;
        }
        boolean z7 = Build.VERSION.SDK_INT < 21 && bitmap2 != null;
        if (charSequence7 != null) {
            remoteViews.setTextViewText(R.id.info, charSequence7);
            remoteViews.setViewVisibility(R.id.info, 0);
            z5 = true;
            i7 = 0;
        } else if (i9 > 0) {
            if (i9 > resources.getInteger(R.integer.status_bar_notification_info_maxnum)) {
                remoteViews.setTextViewText(R.id.info, resources.getString(R.string.status_bar_notification_info_overflow));
            } else {
                remoteViews.setTextViewText(R.id.info, NumberFormat.getIntegerInstance().format((long) i9));
            }
            i7 = 0;
            remoteViews.setViewVisibility(R.id.info, 0);
            z5 = true;
        } else {
            i7 = 0;
            i6 = 8;
            remoteViews.setViewVisibility(R.id.info, 8);
            if (charSequence8 != null && Build.VERSION.SDK_INT >= 16) {
                remoteViews.setTextViewText(R.id.text, charSequence8);
                if (charSequence6 == null) {
                    remoteViews.setTextViewText(R.id.text2, charSequence6);
                    remoteViews.setViewVisibility(R.id.text2, i7);
                    z4 = true;
                    if (z4 && Build.VERSION.SDK_INT >= 16) {
                        if (z2) {
                            remoteViews.setTextViewTextSize(R.id.text, 0, (float) resources.getDimensionPixelSize(R.dimen.notification_subtext_size));
                        }
                        remoteViews.setViewPadding(R.id.line1, 0, 0, 0, 0);
                    }
                    j2 = j;
                    if (j2 == 0) {
                        if (!z || Build.VERSION.SDK_INT < 16) {
                            i8 = 0;
                            remoteViews.setViewVisibility(R.id.time, 0);
                            remoteViews.setLong(R.id.time, "setTime", j2);
                        } else {
                            remoteViews.setViewVisibility(R.id.chronometer, 0);
                            remoteViews.setLong(R.id.chronometer, "setBase", (SystemClock.elapsedRealtime() - System.currentTimeMillis()) + j2);
                            remoteViews.setBoolean(R.id.chronometer, "setStarted", true);
                            i8 = 0;
                        }
                        z7 = true;
                    } else {
                        i8 = 0;
                    }
                    remoteViews.setViewVisibility(R.id.right_side, !z7 ? 0 : 8);
                    if (!z3) {
                        i8 = 8;
                    }
                    remoteViews.setViewVisibility(R.id.line3, i8);
                    return remoteViews;
                }
                remoteViews.setViewVisibility(R.id.text2, i6);
            }
            z4 = false;
            if (z2) {
            }
            remoteViews.setViewPadding(R.id.line1, 0, 0, 0, 0);
            j2 = j;
            if (j2 == 0) {
            }
            remoteViews.setViewVisibility(R.id.right_side, !z7 ? 0 : 8);
            if (!z3) {
            }
            remoteViews.setViewVisibility(R.id.line3, i8);
            return remoteViews;
        }
        i6 = 8;
        z3 = true;
        remoteViews.setTextViewText(R.id.text, charSequence8);
        if (charSequence6 == null) {
        }
    }

    public static Bitmap createIconWithBackground(Context context, int i, int i2, int i3, int i4) {
        if (i4 == 0) {
            i4 = 0;
        }
        Bitmap createColoredBitmap = createColoredBitmap(context, R.drawable.notification_icon_background, i4, i2);
        Canvas canvas = new Canvas(createColoredBitmap);
        Drawable mutate = context.getResources().getDrawable(i).mutate();
        mutate.setFilterBitmap(true);
        int i5 = (i2 - i3) / 2;
        int i6 = i3 + i5;
        mutate.setBounds(i5, i5, i6, i6);
        mutate.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
        mutate.draw(canvas);
        return createColoredBitmap;
    }

    public static void buildIntoRemoteViews(Context context, RemoteViews remoteViews, RemoteViews remoteViews2) {
        hideNormalContent(remoteViews);
        remoteViews.removeAllViews(R.id.notification_main_column);
        remoteViews.addView(R.id.notification_main_column, remoteViews2.clone());
        remoteViews.setViewVisibility(R.id.notification_main_column, 0);
        if (Build.VERSION.SDK_INT >= 21) {
            remoteViews.setViewPadding(R.id.notification_main_column_container, 0, calculateTopPadding(context), 0, 0);
        }
    }

    private static void hideNormalContent(RemoteViews remoteViews) {
        remoteViews.setViewVisibility(R.id.title, 8);
        remoteViews.setViewVisibility(R.id.text2, 8);
        remoteViews.setViewVisibility(R.id.text, 8);
    }

    public static int calculateTopPadding(Context context) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.notification_top_pad);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.notification_top_pad_large_text);
        float constrain = (constrain(context.getResources().getConfiguration().fontScale, 1.0f, 1.3f) - 1.0f) / 0.29999995f;
        return Math.round(((1.0f - constrain) * ((float) dimensionPixelSize)) + (constrain * ((float) dimensionPixelSize2)));
    }
}
