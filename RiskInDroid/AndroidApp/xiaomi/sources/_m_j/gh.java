package _m_j;

import android.app.Notification;
import android.app.PendingIntent;
import android.media.session.MediaSession;
import android.os.Build;
import android.support.v4.media.session.MediaSessionCompat;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.xiaomi.smarthome.R;

public final class gh {

    public static class O000000o extends NotificationCompat.O00000o {
        public int[] O00000oO = null;
        public MediaSessionCompat.Token O00000oo;
        public boolean O0000O0o;
        public PendingIntent O0000OOo;

        public final void O000000o(oOOOOO0O oooooo0o) {
            if (Build.VERSION.SDK_INT >= 21) {
                Notification.Builder O000000o2 = oooooo0o.O000000o();
                Notification.MediaStyle mediaStyle = new Notification.MediaStyle();
                int[] iArr = this.O00000oO;
                if (iArr != null) {
                    mediaStyle.setShowActionsInCompactView(iArr);
                }
                MediaSessionCompat.Token token = this.O00000oo;
                if (token != null) {
                    mediaStyle.setMediaSession((MediaSession.Token) token.getToken());
                }
                O000000o2.setStyle(mediaStyle);
            } else if (this.O0000O0o) {
                oooooo0o.O000000o().setOngoing(true);
            }
        }

        public final RemoteViews O000000o() {
            int i;
            if (Build.VERSION.SDK_INT >= 21) {
                return null;
            }
            RemoteViews O000000o2 = O000000o(R.layout.notification_template_media, true);
            int size = this.f2824O000000o.O00000Oo.size();
            int[] iArr = this.O00000oO;
            if (iArr == null) {
                i = 0;
            } else {
                i = Math.min(iArr.length, 3);
            }
            O000000o2.removeAllViews(R.id.media_actions);
            if (i > 0) {
                int i2 = 0;
                while (i2 < i) {
                    if (i2 < size) {
                        O000000o2.addView(R.id.media_actions, O000000o(this.f2824O000000o.O00000Oo.get(this.O00000oO[i2])));
                        i2++;
                    } else {
                        throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", Integer.valueOf(i2), Integer.valueOf(size - 1)));
                    }
                }
            }
            if (this.O0000O0o) {
                O000000o2.setViewVisibility(R.id.end_padder, 8);
                O000000o2.setViewVisibility(R.id.cancel_action, 0);
                O000000o2.setOnClickPendingIntent(R.id.cancel_action, this.O0000OOo);
                O000000o2.setInt(R.id.cancel_action, "setAlpha", this.f2824O000000o.f2822O000000o.getResources().getInteger(R.integer.cancel_button_image_alpha));
            } else {
                O000000o2.setViewVisibility(R.id.end_padder, 0);
                O000000o2.setViewVisibility(R.id.cancel_action, 8);
            }
            return O000000o2;
        }

        public final RemoteViews O00000Oo() {
            if (Build.VERSION.SDK_INT >= 21) {
                return null;
            }
            int min = Math.min(this.f2824O000000o.O00000Oo.size(), 5);
            RemoteViews O000000o2 = O000000o(min <= 3 ? R.layout.notification_template_big_media_narrow : R.layout.notification_template_big_media, false);
            O000000o2.removeAllViews(R.id.media_actions);
            if (min > 0) {
                for (int i = 0; i < min; i++) {
                    O000000o2.addView(R.id.media_actions, O000000o(this.f2824O000000o.O00000Oo.get(i)));
                }
            }
            if (this.O0000O0o) {
                O000000o2.setViewVisibility(R.id.cancel_action, 0);
                O000000o2.setInt(R.id.cancel_action, "setAlpha", this.f2824O000000o.f2822O000000o.getResources().getInteger(R.integer.cancel_button_image_alpha));
                O000000o2.setOnClickPendingIntent(R.id.cancel_action, this.O0000OOo);
            } else {
                O000000o2.setViewVisibility(R.id.cancel_action, 8);
            }
            return O000000o2;
        }

        private RemoteViews O000000o(NotificationCompat.O000000o o000000o) {
            boolean z = o000000o.O0000Oo == null;
            RemoteViews remoteViews = new RemoteViews(this.f2824O000000o.f2822O000000o.getPackageName(), (int) R.layout.notification_media_action);
            remoteViews.setImageViewResource(R.id.action0, o000000o.O0000OOo);
            if (!z) {
                remoteViews.setOnClickPendingIntent(R.id.action0, o000000o.O0000Oo);
            }
            if (Build.VERSION.SDK_INT >= 15) {
                remoteViews.setContentDescription(R.id.action0, o000000o.O0000Oo0);
            }
            return remoteViews;
        }
    }
}
