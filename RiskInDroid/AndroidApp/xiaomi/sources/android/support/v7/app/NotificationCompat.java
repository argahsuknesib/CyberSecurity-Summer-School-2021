package android.support.v7.app;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.v4.app.BundleCompat;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.text.BidiFormatter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.widget.RemoteViews;
import com.xiaomi.smarthome.R;
import java.util.List;

public class NotificationCompat extends android.support.v4.app.NotificationCompat {

    public static class DecoratedCustomViewStyle extends NotificationCompat.Style {
    }

    public static class DecoratedMediaCustomViewStyle extends MediaStyle {
    }

    public static MediaSessionCompat.Token getMediaSession(Notification notification) {
        Bundle extras = getExtras(notification);
        if (extras == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            Parcelable parcelable = extras.getParcelable("android.mediaSession");
            if (parcelable != null) {
                return MediaSessionCompat.Token.fromToken(parcelable);
            }
            return null;
        }
        IBinder binder = BundleCompat.getBinder(extras, "android.mediaSession");
        if (binder == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.writeStrongBinder(binder);
        obtain.setDataPosition(0);
        MediaSessionCompat.Token createFromParcel = MediaSessionCompat.Token.CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }

    @TargetApi(24)
    @RequiresApi(24)
    public static void addStyleToBuilderApi24(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, NotificationCompat.Builder builder) {
        if (builder.mStyle instanceof DecoratedCustomViewStyle) {
            NotificationCompatImpl24.addDecoratedCustomViewStyle(notificationBuilderWithBuilderAccessor);
        } else if (builder.mStyle instanceof DecoratedMediaCustomViewStyle) {
            NotificationCompatImpl24.addDecoratedMediaCustomViewStyle(notificationBuilderWithBuilderAccessor);
        } else if (!(builder.mStyle instanceof NotificationCompat.MessagingStyle)) {
            addStyleGetContentViewLollipop(notificationBuilderWithBuilderAccessor, builder);
        }
    }

    @TargetApi(21)
    @RequiresApi(21)
    public static RemoteViews addStyleGetContentViewLollipop(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, NotificationCompat.Builder builder) {
        Object obj;
        NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor2;
        NotificationCompat.Builder builder2 = builder;
        if (builder2.mStyle instanceof MediaStyle) {
            MediaStyle mediaStyle = (MediaStyle) builder2.mStyle;
            int[] iArr = mediaStyle.mActionsToShowInCompact;
            if (mediaStyle.mToken != null) {
                obj = mediaStyle.mToken.getToken();
                notificationBuilderWithBuilderAccessor2 = notificationBuilderWithBuilderAccessor;
            } else {
                notificationBuilderWithBuilderAccessor2 = notificationBuilderWithBuilderAccessor;
                obj = null;
            }
            NotificationCompatImpl21.addMediaStyle(notificationBuilderWithBuilderAccessor2, iArr, obj);
            boolean z = true;
            boolean z2 = builder.getContentView() != null;
            boolean z3 = Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT <= 23;
            if (!z2 && (!z3 || builder.getBigContentView() == null)) {
                z = false;
            }
            if (!(builder2.mStyle instanceof DecoratedMediaCustomViewStyle) || !z) {
                return null;
            }
            RemoteViews overrideContentViewMedia = NotificationCompatImplBase.overrideContentViewMedia(notificationBuilderWithBuilderAccessor, builder2.mContext, builder2.mContentTitle, builder2.mContentText, builder2.mContentInfo, builder2.mNumber, builder2.mLargeIcon, builder2.mSubText, builder2.mUseChronometer, builder.getWhenIfShowing(), builder.getPriority(), builder2.mActions, mediaStyle.mActionsToShowInCompact, false, null, z2);
            if (z2) {
                NotificationCompatImplBase.buildIntoRemoteViews(builder2.mContext, overrideContentViewMedia, builder.getContentView());
            }
            setBackgroundColor(builder2.mContext, overrideContentViewMedia, builder.getColor());
            return overrideContentViewMedia;
        } else if (builder2.mStyle instanceof DecoratedCustomViewStyle) {
            return getDecoratedContentView(builder);
        } else {
            return addStyleGetContentViewJellybean(notificationBuilderWithBuilderAccessor, builder);
        }
    }

    @TargetApi(16)
    @RequiresApi(16)
    public static RemoteViews addStyleGetContentViewJellybean(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, NotificationCompat.Builder builder) {
        if (builder.mStyle instanceof NotificationCompat.MessagingStyle) {
            addMessagingFallBackStyle((NotificationCompat.MessagingStyle) builder.mStyle, notificationBuilderWithBuilderAccessor, builder);
        }
        return addStyleGetContentViewIcs(notificationBuilderWithBuilderAccessor, builder);
    }

    public static NotificationCompat.MessagingStyle.Message findLatestIncomingMessage(NotificationCompat.MessagingStyle messagingStyle) {
        List<NotificationCompat.MessagingStyle.Message> messages = messagingStyle.getMessages();
        for (int size = messages.size() - 1; size >= 0; size--) {
            NotificationCompat.MessagingStyle.Message message = messages.get(size);
            if (!TextUtils.isEmpty(message.getSender())) {
                return message;
            }
        }
        if (!messages.isEmpty()) {
            return messages.get(messages.size() - 1);
        }
        return null;
    }

    public static CharSequence makeMessageLine(NotificationCompat.Builder builder, NotificationCompat.MessagingStyle messagingStyle, NotificationCompat.MessagingStyle.Message message) {
        BidiFormatter instance = BidiFormatter.getInstance();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        boolean z = Build.VERSION.SDK_INT >= 21;
        int i = (z || Build.VERSION.SDK_INT <= 10) ? -16777216 : -1;
        CharSequence sender = message.getSender();
        CharSequence charSequence = "";
        if (TextUtils.isEmpty(message.getSender())) {
            if (messagingStyle.getUserDisplayName() == null) {
                sender = charSequence;
            } else {
                sender = messagingStyle.getUserDisplayName();
            }
            if (z && builder.getColor() != 0) {
                i = builder.getColor();
            }
        }
        CharSequence unicodeWrap = instance.unicodeWrap(sender);
        spannableStringBuilder.append(unicodeWrap);
        spannableStringBuilder.setSpan(makeFontColorSpan(i), spannableStringBuilder.length() - unicodeWrap.length(), spannableStringBuilder.length(), 33);
        if (message.getText() != null) {
            charSequence = message.getText();
        }
        spannableStringBuilder.append((CharSequence) "  ").append(instance.unicodeWrap(charSequence));
        return spannableStringBuilder;
    }

    private static TextAppearanceSpan makeFontColorSpan(int i) {
        return new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf(i), null);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.text.SpannableStringBuilder.insert(int, java.lang.CharSequence):android.text.SpannableStringBuilder}
     arg types: [int, java.lang.String]
     candidates:
      ClspMth{android.text.SpannableStringBuilder.insert(int, java.lang.CharSequence):android.text.Editable}
      ClspMth{android.text.SpannableStringBuilder.insert(int, java.lang.CharSequence):android.text.SpannableStringBuilder} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.text.SpannableStringBuilder.insert(int, java.lang.CharSequence):android.text.SpannableStringBuilder}
     arg types: [int, java.lang.CharSequence]
     candidates:
      ClspMth{android.text.SpannableStringBuilder.insert(int, java.lang.CharSequence):android.text.Editable}
      ClspMth{android.text.SpannableStringBuilder.insert(int, java.lang.CharSequence):android.text.SpannableStringBuilder} */
    private static void addMessagingFallBackStyle(NotificationCompat.MessagingStyle messagingStyle, NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, NotificationCompat.Builder builder) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        List<NotificationCompat.MessagingStyle.Message> messages = messagingStyle.getMessages();
        boolean z = messagingStyle.getConversationTitle() != null || hasMessagesWithoutSender(messagingStyle.getMessages());
        for (int size = messages.size() - 1; size >= 0; size--) {
            NotificationCompat.MessagingStyle.Message message = messages.get(size);
            CharSequence makeMessageLine = z ? makeMessageLine(builder, messagingStyle, message) : message.getText();
            if (size != messages.size() - 1) {
                spannableStringBuilder.insert(0, (CharSequence) "\n");
            }
            spannableStringBuilder.insert(0, makeMessageLine);
        }
        NotificationCompatImplJellybean.addBigTextStyle(notificationBuilderWithBuilderAccessor, spannableStringBuilder);
    }

    private static boolean hasMessagesWithoutSender(List<NotificationCompat.MessagingStyle.Message> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).getSender() == null) {
                return true;
            }
        }
        return false;
    }

    @TargetApi(14)
    @RequiresApi(14)
    public static RemoteViews addStyleGetContentViewIcs(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, NotificationCompat.Builder builder) {
        NotificationCompat.Builder builder2 = builder;
        if (builder2.mStyle instanceof MediaStyle) {
            MediaStyle mediaStyle = (MediaStyle) builder2.mStyle;
            boolean z = (builder2.mStyle instanceof DecoratedMediaCustomViewStyle) && builder.getContentView() != null;
            RemoteViews overrideContentViewMedia = NotificationCompatImplBase.overrideContentViewMedia(notificationBuilderWithBuilderAccessor, builder2.mContext, builder2.mContentTitle, builder2.mContentText, builder2.mContentInfo, builder2.mNumber, builder2.mLargeIcon, builder2.mSubText, builder2.mUseChronometer, builder.getWhenIfShowing(), builder.getPriority(), builder2.mActions, mediaStyle.mActionsToShowInCompact, mediaStyle.mShowCancelButton, mediaStyle.mCancelButtonIntent, z);
            if (!z) {
                return null;
            }
            NotificationCompatImplBase.buildIntoRemoteViews(builder2.mContext, overrideContentViewMedia, builder.getContentView());
            return overrideContentViewMedia;
        } else if (builder2.mStyle instanceof DecoratedCustomViewStyle) {
            return getDecoratedContentView(builder);
        } else {
            return null;
        }
    }

    @TargetApi(16)
    @RequiresApi(16)
    public static void addBigStyleToBuilderJellybean(Notification notification, NotificationCompat.Builder builder) {
        RemoteViews remoteViews;
        NotificationCompat.Builder builder2 = builder;
        if (builder2.mStyle instanceof MediaStyle) {
            MediaStyle mediaStyle = (MediaStyle) builder2.mStyle;
            if (builder.getBigContentView() != null) {
                remoteViews = builder.getBigContentView();
            } else {
                remoteViews = builder.getContentView();
            }
            boolean z = (builder2.mStyle instanceof DecoratedMediaCustomViewStyle) && remoteViews != null;
            NotificationCompatImplBase.overrideMediaBigContentView(notification, builder2.mContext, builder2.mContentTitle, builder2.mContentText, builder2.mContentInfo, builder2.mNumber, builder2.mLargeIcon, builder2.mSubText, builder2.mUseChronometer, builder.getWhenIfShowing(), builder.getPriority(), 0, builder2.mActions, mediaStyle.mShowCancelButton, mediaStyle.mCancelButtonIntent, z);
            if (z) {
                NotificationCompatImplBase.buildIntoRemoteViews(builder2.mContext, notification.bigContentView, remoteViews);
            }
        } else if (builder2.mStyle instanceof DecoratedCustomViewStyle) {
            addDecoratedBigStyleToBuilderJellybean(notification, builder);
        }
    }

    private static RemoteViews getDecoratedContentView(NotificationCompat.Builder builder) {
        NotificationCompat.Builder builder2 = builder;
        if (builder.getContentView() == null) {
            return null;
        }
        RemoteViews applyStandardTemplateWithActions = NotificationCompatImplBase.applyStandardTemplateWithActions(builder2.mContext, builder2.mContentTitle, builder2.mContentText, builder2.mContentInfo, builder2.mNumber, builder2.mNotification.icon, builder2.mLargeIcon, builder2.mSubText, builder2.mUseChronometer, builder.getWhenIfShowing(), builder.getPriority(), builder.getColor(), R.layout.notification_template_custom_big, false, null);
        NotificationCompatImplBase.buildIntoRemoteViews(builder2.mContext, applyStandardTemplateWithActions, builder.getContentView());
        return applyStandardTemplateWithActions;
    }

    @TargetApi(16)
    @RequiresApi(16)
    private static void addDecoratedBigStyleToBuilderJellybean(Notification notification, NotificationCompat.Builder builder) {
        Notification notification2 = notification;
        NotificationCompat.Builder builder2 = builder;
        RemoteViews bigContentView = builder.getBigContentView();
        if (bigContentView == null) {
            bigContentView = builder.getContentView();
        }
        if (bigContentView != null) {
            RemoteViews applyStandardTemplateWithActions = NotificationCompatImplBase.applyStandardTemplateWithActions(builder2.mContext, builder2.mContentTitle, builder2.mContentText, builder2.mContentInfo, builder2.mNumber, notification2.icon, builder2.mLargeIcon, builder2.mSubText, builder2.mUseChronometer, builder.getWhenIfShowing(), builder.getPriority(), builder.getColor(), R.layout.notification_template_custom_big, false, builder2.mActions);
            NotificationCompatImplBase.buildIntoRemoteViews(builder2.mContext, applyStandardTemplateWithActions, bigContentView);
            notification.bigContentView = applyStandardTemplateWithActions;
        }
    }

    @TargetApi(21)
    @RequiresApi(21)
    private static void addDecoratedHeadsUpToBuilderLollipop(Notification notification, NotificationCompat.Builder builder) {
        RemoteViews remoteViews;
        Notification notification2 = notification;
        NotificationCompat.Builder builder2 = builder;
        RemoteViews headsUpContentView = builder.getHeadsUpContentView();
        if (headsUpContentView != null) {
            remoteViews = headsUpContentView;
        } else {
            remoteViews = builder.getContentView();
        }
        if (headsUpContentView != null) {
            RemoteViews applyStandardTemplateWithActions = NotificationCompatImplBase.applyStandardTemplateWithActions(builder2.mContext, builder2.mContentTitle, builder2.mContentText, builder2.mContentInfo, builder2.mNumber, notification2.icon, builder2.mLargeIcon, builder2.mSubText, builder2.mUseChronometer, builder.getWhenIfShowing(), builder.getPriority(), builder.getColor(), R.layout.notification_template_custom_big, false, builder2.mActions);
            NotificationCompatImplBase.buildIntoRemoteViews(builder2.mContext, applyStandardTemplateWithActions, remoteViews);
            notification2.headsUpContentView = applyStandardTemplateWithActions;
        }
    }

    @TargetApi(21)
    @RequiresApi(21)
    public static void addBigStyleToBuilderLollipop(Notification notification, NotificationCompat.Builder builder) {
        RemoteViews remoteViews;
        NotificationCompat.Builder builder2 = builder;
        if (builder.getBigContentView() != null) {
            remoteViews = builder.getBigContentView();
        } else {
            remoteViews = builder.getContentView();
        }
        RemoteViews remoteViews2 = remoteViews;
        if ((builder2.mStyle instanceof DecoratedMediaCustomViewStyle) && remoteViews2 != null) {
            NotificationCompatImplBase.overrideMediaBigContentView(notification, builder2.mContext, builder2.mContentTitle, builder2.mContentText, builder2.mContentInfo, builder2.mNumber, builder2.mLargeIcon, builder2.mSubText, builder2.mUseChronometer, builder.getWhenIfShowing(), builder.getPriority(), 0, builder2.mActions, false, null, true);
            NotificationCompat.Builder builder3 = builder;
            Notification notification2 = notification;
            NotificationCompatImplBase.buildIntoRemoteViews(builder3.mContext, notification2.bigContentView, remoteViews2);
            setBackgroundColor(builder3.mContext, notification2.bigContentView, builder.getColor());
        } else if (builder2.mStyle instanceof DecoratedCustomViewStyle) {
            addDecoratedBigStyleToBuilderJellybean(notification, builder);
        }
    }

    private static void setBackgroundColor(Context context, RemoteViews remoteViews, int i) {
        if (i == 0) {
            i = context.getResources().getColor(R.color.notification_material_background_media_default_color);
        }
        remoteViews.setInt(R.id.status_bar_latest_event_content, "setBackgroundColor", i);
    }

    @TargetApi(21)
    @RequiresApi(21)
    public static void addHeadsUpToBuilderLollipop(Notification notification, NotificationCompat.Builder builder) {
        RemoteViews remoteViews;
        Notification notification2 = notification;
        NotificationCompat.Builder builder2 = builder;
        if (builder.getHeadsUpContentView() != null) {
            remoteViews = builder.getHeadsUpContentView();
        } else {
            remoteViews = builder.getContentView();
        }
        if ((builder2.mStyle instanceof DecoratedMediaCustomViewStyle) && remoteViews != null) {
            notification2.headsUpContentView = NotificationCompatImplBase.generateMediaBigView(builder2.mContext, builder2.mContentTitle, builder2.mContentText, builder2.mContentInfo, builder2.mNumber, builder2.mLargeIcon, builder2.mSubText, builder2.mUseChronometer, builder.getWhenIfShowing(), builder.getPriority(), 0, builder2.mActions, false, null, true);
            NotificationCompatImplBase.buildIntoRemoteViews(builder2.mContext, notification2.headsUpContentView, remoteViews);
            setBackgroundColor(builder2.mContext, notification2.headsUpContentView, builder.getColor());
        } else if (builder2.mStyle instanceof DecoratedCustomViewStyle) {
            addDecoratedHeadsUpToBuilderLollipop(notification, builder);
        }
    }

    public static class Builder extends NotificationCompat.Builder {
        public Builder(Context context) {
            super(context);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public CharSequence resolveText() {
            if (this.mStyle instanceof NotificationCompat.MessagingStyle) {
                NotificationCompat.MessagingStyle messagingStyle = (NotificationCompat.MessagingStyle) this.mStyle;
                NotificationCompat.MessagingStyle.Message findLatestIncomingMessage = NotificationCompat.findLatestIncomingMessage(messagingStyle);
                CharSequence conversationTitle = messagingStyle.getConversationTitle();
                if (findLatestIncomingMessage != null) {
                    if (conversationTitle != null) {
                        return NotificationCompat.makeMessageLine(this, messagingStyle, findLatestIncomingMessage);
                    }
                    return findLatestIncomingMessage.getText();
                }
            }
            return super.resolveText();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public CharSequence resolveTitle() {
            if (this.mStyle instanceof NotificationCompat.MessagingStyle) {
                NotificationCompat.MessagingStyle messagingStyle = (NotificationCompat.MessagingStyle) this.mStyle;
                NotificationCompat.MessagingStyle.Message findLatestIncomingMessage = NotificationCompat.findLatestIncomingMessage(messagingStyle);
                CharSequence conversationTitle = messagingStyle.getConversationTitle();
                if (!(conversationTitle == null && findLatestIncomingMessage == null)) {
                    if (conversationTitle != null) {
                        return conversationTitle;
                    }
                    return findLatestIncomingMessage.getSender();
                }
            }
            return super.resolveTitle();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public NotificationCompat.BuilderExtender getExtender() {
            if (Build.VERSION.SDK_INT >= 24) {
                return new Api24Extender();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                return new LollipopExtender();
            }
            if (Build.VERSION.SDK_INT >= 16) {
                return new JellybeanExtender();
            }
            if (Build.VERSION.SDK_INT >= 14) {
                return new IceCreamSandwichExtender();
            }
            return super.getExtender();
        }
    }

    static class IceCreamSandwichExtender extends NotificationCompat.BuilderExtender {
        IceCreamSandwichExtender() {
        }

        public Notification build(NotificationCompat.Builder builder, NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            RemoteViews addStyleGetContentViewIcs = NotificationCompat.addStyleGetContentViewIcs(notificationBuilderWithBuilderAccessor, builder);
            Notification build = notificationBuilderWithBuilderAccessor.build();
            if (addStyleGetContentViewIcs != null) {
                build.contentView = addStyleGetContentViewIcs;
            } else if (builder.getContentView() != null) {
                build.contentView = builder.getContentView();
            }
            return build;
        }
    }

    static class JellybeanExtender extends NotificationCompat.BuilderExtender {
        JellybeanExtender() {
        }

        public Notification build(NotificationCompat.Builder builder, NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            RemoteViews addStyleGetContentViewJellybean = NotificationCompat.addStyleGetContentViewJellybean(notificationBuilderWithBuilderAccessor, builder);
            Notification build = notificationBuilderWithBuilderAccessor.build();
            if (addStyleGetContentViewJellybean != null) {
                build.contentView = addStyleGetContentViewJellybean;
            }
            NotificationCompat.addBigStyleToBuilderJellybean(build, builder);
            return build;
        }
    }

    static class LollipopExtender extends NotificationCompat.BuilderExtender {
        LollipopExtender() {
        }

        public Notification build(NotificationCompat.Builder builder, NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            RemoteViews addStyleGetContentViewLollipop = NotificationCompat.addStyleGetContentViewLollipop(notificationBuilderWithBuilderAccessor, builder);
            Notification build = notificationBuilderWithBuilderAccessor.build();
            if (addStyleGetContentViewLollipop != null) {
                build.contentView = addStyleGetContentViewLollipop;
            }
            NotificationCompat.addBigStyleToBuilderLollipop(build, builder);
            NotificationCompat.addHeadsUpToBuilderLollipop(build, builder);
            return build;
        }
    }

    static class Api24Extender extends NotificationCompat.BuilderExtender {
        private Api24Extender() {
        }

        public Notification build(NotificationCompat.Builder builder, NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            NotificationCompat.addStyleToBuilderApi24(notificationBuilderWithBuilderAccessor, builder);
            return notificationBuilderWithBuilderAccessor.build();
        }
    }

    public static class MediaStyle extends NotificationCompat.Style {
        int[] mActionsToShowInCompact = null;
        PendingIntent mCancelButtonIntent;
        boolean mShowCancelButton;
        MediaSessionCompat.Token mToken;

        public MediaStyle() {
        }

        public MediaStyle(NotificationCompat.Builder builder) {
            setBuilder(builder);
        }

        public MediaStyle setShowActionsInCompactView(int... iArr) {
            this.mActionsToShowInCompact = iArr;
            return this;
        }

        public MediaStyle setMediaSession(MediaSessionCompat.Token token) {
            this.mToken = token;
            return this;
        }

        public MediaStyle setShowCancelButton(boolean z) {
            this.mShowCancelButton = z;
            return this;
        }

        public MediaStyle setCancelButtonIntent(PendingIntent pendingIntent) {
            this.mCancelButtonIntent = pendingIntent;
            return this;
        }
    }
}
