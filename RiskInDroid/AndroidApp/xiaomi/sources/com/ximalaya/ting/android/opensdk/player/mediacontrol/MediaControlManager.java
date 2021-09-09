package com.ximalaya.ting.android.opensdk.player.mediacontrol;

import _m_j.iio;
import _m_j.ikz;
import _m_j.ilg;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.RemoteControlClient;
import android.media.session.MediaSession;
import android.os.Build;
import com.ximalaya.ting.android.opensdk.player.receive.WireControlReceiver;

public class MediaControlManager {

    /* renamed from: O000000o  reason: collision with root package name */
    public MediaSession f12182O000000o;
    public RemoteControlClient O00000Oo;
    public Context O00000o;
    public AudioManager O00000o0;
    public ComponentName O00000oO;
    public WireControlReceiver O00000oo;
    public boolean O0000O0o = false;

    public MediaControlManager(Context context) {
        this.O00000o = context;
        if (ikz.O000000o(context).O00000oo()) {
            this.O00000oo = new WireControlReceiver();
            this.O00000o0 = (AudioManager) context.getSystemService("audio");
        }
    }

    public final void O000000o() {
        if (ikz.O000000o(this.O00000o).O00000oo() && Build.VERSION.SDK_INT >= 21) {
            try {
                this.f12182O000000o = new MediaSession(this.O00000o, "MusicService");
            } catch (Throwable th) {
                th.printStackTrace();
            }
            MediaSession mediaSession = this.f12182O000000o;
            if (mediaSession != null) {
                mediaSession.setCallback(new MediaSession.Callback() {
                    /* class com.ximalaya.ting.android.opensdk.player.mediacontrol.MediaControlManager.AnonymousClass1 */

                    public final boolean onMediaButtonEvent(Intent intent) {
                        MediaControlManager.this.O00000oo.onReceive(MediaControlManager.this.O00000o, intent);
                        return super.onMediaButtonEvent(intent);
                    }
                });
                this.f12182O000000o.setFlags(3);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.media.RemoteControlClient.MetadataEditor.putString(int, java.lang.String):android.media.RemoteControlClient$MetadataEditor throws java.lang.IllegalArgumentException}
     arg types: [int, java.lang.String]
     candidates:
      ClspMth{android.media.RemoteControlClient.MetadataEditor.putString(int, java.lang.String):android.media.MediaMetadataEditor throws java.lang.IllegalArgumentException}
      ClspMth{android.media.MediaMetadataEditor.putString(int, java.lang.String):android.media.MediaMetadataEditor throws java.lang.IllegalArgumentException}
      ClspMth{android.media.RemoteControlClient.MetadataEditor.putString(int, java.lang.String):android.media.RemoteControlClient$MetadataEditor throws java.lang.IllegalArgumentException} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.media.RemoteControlClient.MetadataEditor.putLong(int, long):android.media.RemoteControlClient$MetadataEditor throws java.lang.IllegalArgumentException}
     arg types: [int, long]
     candidates:
      ClspMth{android.media.RemoteControlClient.MetadataEditor.putLong(int, long):android.media.MediaMetadataEditor throws java.lang.IllegalArgumentException}
      ClspMth{android.media.MediaMetadataEditor.putLong(int, long):android.media.MediaMetadataEditor throws java.lang.IllegalArgumentException}
      ClspMth{android.media.RemoteControlClient.MetadataEditor.putLong(int, long):android.media.RemoteControlClient$MetadataEditor throws java.lang.IllegalArgumentException} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.media.RemoteControlClient.MetadataEditor.putBitmap(int, android.graphics.Bitmap):android.media.RemoteControlClient$MetadataEditor throws java.lang.IllegalArgumentException}
     arg types: [int, android.graphics.Bitmap]
     candidates:
      ClspMth{android.media.RemoteControlClient.MetadataEditor.putBitmap(int, android.graphics.Bitmap):android.media.MediaMetadataEditor throws java.lang.IllegalArgumentException}
      ClspMth{android.media.MediaMetadataEditor.putBitmap(int, android.graphics.Bitmap):android.media.MediaMetadataEditor throws java.lang.IllegalArgumentException}
      ClspMth{android.media.RemoteControlClient.MetadataEditor.putBitmap(int, android.graphics.Bitmap):android.media.RemoteControlClient$MetadataEditor throws java.lang.IllegalArgumentException} */
    public final void O000000o(String str, String str2, String str3, long j, Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 14) {
            RemoteControlClient.MetadataEditor editMetadata = this.O00000Oo.editMetadata(true);
            editMetadata.putString(7, str);
            editMetadata.putString(1, str2);
            editMetadata.putString(2, str3);
            editMetadata.putLong(9, j);
            if (bitmap == null) {
                int identifier = this.O00000o.getResources().getIdentifier("reflect_player_cover_default", "drawable", this.O00000o.getPackageName());
                if (identifier > 0 || !iio.f1319O000000o || !ilg.O000000o()) {
                    bitmap = BitmapFactory.decodeResource(this.O00000o.getResources(), identifier);
                } else {
                    throw new RuntimeException("请内置名为player_cover_default资源图片，作为锁屏封面默认图");
                }
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                try {
                    editMetadata.putBitmap(100, bitmap);
                } catch (Exception unused) {
                }
            }
            editMetadata.apply();
        }
    }
}
