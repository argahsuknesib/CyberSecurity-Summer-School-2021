package com.xiaomi.mico.music.channel;

import _m_j.jgc;
import android.text.TextUtils;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.IncompleteApiListener;
import com.xiaomi.mico.api.ObservableApiHelper;
import com.xiaomi.mico.api.WrappedApiListener;
import com.xiaomi.mico.api.WrappedIncompleteApiListener;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.event.MusicEvent;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class ChannelManager {
    private static ChannelManager sInstance = new ChannelManager();
    public List<Music.Channel> mChannelList = new LinkedList();

    public static ChannelManager getInstance() {
        return sInstance;
    }

    public void reset() {
        this.mChannelList.clear();
    }

    public List<Music.Channel> getChannelList() {
        return this.mChannelList;
    }

    public Music.Channel getChannelById(long j) {
        for (Music.Channel next : this.mChannelList) {
            if (next.id == j) {
                return next;
            }
        }
        return null;
    }

    public ApiRequest getChannelList(IncompleteApiListener incompleteApiListener) {
        return ApiHelper.getChannelList(new WrappedIncompleteApiListener<List<Music.Channel>>(incompleteApiListener) {
            /* class com.xiaomi.mico.music.channel.ChannelManager.AnonymousClass1 */

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((List<Music.Channel>) ((List) obj));
            }

            public void onSuccess(List<Music.Channel> list) {
                ChannelManager.this.mChannelList.clear();
                ChannelManager.this.mChannelList.addAll(list);
                Collections.sort(ChannelManager.this.mChannelList, new Comparator<Music.Channel>() {
                    /* class com.xiaomi.mico.music.channel.ChannelManager.AnonymousClass1.AnonymousClass1 */

                    public int compare(Music.Channel channel, Music.Channel channel2) {
                        if (!channel2.isDefault || channel.isDefault) {
                            return (!channel.isDefault || channel2.isDefault) ? 0 : -1;
                        }
                        return 1;
                    }
                });
                ChannelManager.this.sendChannelListChangeEvent();
                super.onSuccess((Object) list);
            }
        });
    }

    public Observable<Long> createChannel(final String str) {
        return ObservableApiHelper.createChannel(str).doOnNext(new Action1<Long>() {
            /* class com.xiaomi.mico.music.channel.ChannelManager.AnonymousClass2 */

            public void call(Long l) {
                Music.Channel channel = new Music.Channel();
                channel.id = l.longValue();
                channel.name = str;
                int size = ChannelManager.this.mChannelList.size();
                int i = 0;
                while (i < size && channel.isDefault) {
                    i++;
                }
                if (i < size) {
                    i++;
                }
                if (i == size) {
                    ChannelManager.this.mChannelList.add(channel);
                } else {
                    ChannelManager.this.mChannelList.add(i, channel);
                }
                ChannelManager.this.loadChannelList();
            }
        });
    }

    public Observable<Boolean> deleteChannel(final long j) {
        return ObservableApiHelper.deleteChannel(j).doOnNext(new Action1<Boolean>() {
            /* class com.xiaomi.mico.music.channel.ChannelManager.AnonymousClass3 */

            public void call(Boolean bool) {
                for (Music.Channel next : ChannelManager.this.mChannelList) {
                    if (next.id == j) {
                        ChannelManager.this.mChannelList.remove(next);
                        ChannelManager.this.sendChannelListChangeEvent();
                        ChannelManager.this.loadChannelList();
                        return;
                    }
                }
            }
        });
    }

    public Observable<String> renameChannel(final long j, final String str) {
        return ObservableApiHelper.renameChannel(j, str).map(new Func1<Boolean, String>() {
            /* class com.xiaomi.mico.music.channel.ChannelManager.AnonymousClass4 */

            public String call(Boolean bool) {
                Iterator<Music.Channel> it = ChannelManager.this.mChannelList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Music.Channel next = it.next();
                    if (next.id == j) {
                        next.name = str;
                        ChannelManager.this.sendChannelListChangeEvent();
                        ChannelManager.this.loadChannelList();
                        break;
                    }
                }
                return str;
            }
        });
    }

    public ApiRequest getChannelInfo(long j, int i, int i2, ApiRequest.Listener<Music.Channel> listener) {
        return ApiHelper.getChannelInfo(j, i, i2, new WrappedApiListener<Music.Channel>(listener) {
            /* class com.xiaomi.mico.music.channel.ChannelManager.AnonymousClass5 */

            public void onSuccess(Music.Channel channel) {
                super.onSuccess((Object) channel);
            }
        });
    }

    public ApiRequest getSongsInChannel(long j, int i, int i2, ApiRequest.Listener<Music.Channel> listener) {
        return ApiHelper.getSongsInChannel(j, i, i2, new WrappedApiListener<Music.Channel>(listener) {
            /* class com.xiaomi.mico.music.channel.ChannelManager.AnonymousClass6 */

            public void onSuccess(Music.Channel channel) {
                super.onSuccess((Object) channel);
            }
        });
    }

    public Observable<String> add2FavouriteV3(Music.Song song) {
        long j;
        Iterator<Music.Channel> it = this.mChannelList.iterator();
        while (true) {
            if (!it.hasNext()) {
                j = 0;
                break;
            }
            Music.Channel next = it.next();
            if (next.isDefault) {
                j = next.id;
                break;
            }
        }
        return ObservableApiHelper.addCollectSongV3(String.valueOf(j), String.valueOf(song.audioID)).map(new Func1(j, song) {
            /* class com.xiaomi.mico.music.channel.$$Lambda$ChannelManager$92RShEj2JEStTE4vm29AWnt3YAU */
            private final /* synthetic */ long f$1;
            private final /* synthetic */ Music.Song f$2;

            {
                this.f$1 = r2;
                this.f$2 = r4;
            }

            public final Object call(Object obj) {
                return ChannelManager.this.lambda$add2FavouriteV3$0$ChannelManager(this.f$1, this.f$2, (Boolean) obj);
            }
        });
    }

    public /* synthetic */ String lambda$add2FavouriteV3$0$ChannelManager(long j, Music.Song song, Boolean bool) {
        for (Music.Channel next : this.mChannelList) {
            if (next.id == j) {
                String str = (String) MusicHelper.getTitle(next);
                next.songCount++;
                String str2 = song.coverURL;
                if (TextUtils.isEmpty(next.cover) && !TextUtils.isEmpty(str2) && !next.isDefault) {
                    next.cover = str2;
                }
                loadChannelList();
                return str;
            }
        }
        return null;
    }

    public Observable<Boolean> delFavouriteV3(Music.Song song) {
        long j;
        Iterator<Music.Channel> it = this.mChannelList.iterator();
        while (true) {
            if (!it.hasNext()) {
                j = 0;
                break;
            }
            Music.Channel next = it.next();
            if (next.isDefault) {
                j = next.id;
                break;
            }
        }
        return ObservableApiHelper.delCollectSongV3(String.valueOf(j), String.valueOf(song.audioID)).doOnNext(new Action1(j) {
            /* class com.xiaomi.mico.music.channel.$$Lambda$ChannelManager$fvDJggM9uemTxp6aP9YWpHTnQF4 */
            private final /* synthetic */ long f$1;

            {
                this.f$1 = r2;
            }

            public final void call(Object obj) {
                ChannelManager.this.lambda$delFavouriteV3$1$ChannelManager(this.f$1, (Boolean) obj);
            }
        });
    }

    public /* synthetic */ void lambda$delFavouriteV3$1$ChannelManager(long j, Boolean bool) {
        for (Music.Channel next : this.mChannelList) {
            if (next.id == j) {
                next.songCount--;
                if (next.songCount < 0) {
                    next.songCount = 0;
                }
                loadChannelList();
                return;
            }
        }
    }

    public Observable<String> addToFavourite(Music.Song song) {
        long j;
        Iterator<Music.Channel> it = this.mChannelList.iterator();
        while (true) {
            if (!it.hasNext()) {
                j = 0;
                break;
            }
            Music.Channel next = it.next();
            if (next.isDefault) {
                j = next.id;
                break;
            }
        }
        return addSongs(j, Collections.singletonList(song));
    }

    public Observable<String> addSongs(final long j, final List<Music.Song> list) {
        return ObservableApiHelper.addSongs(j, list).map(new Func1<Boolean, String>() {
            /* class com.xiaomi.mico.music.channel.ChannelManager.AnonymousClass7 */

            public String call(Boolean bool) {
                for (Music.Channel next : ChannelManager.this.mChannelList) {
                    if (next.id == j) {
                        String str = (String) MusicHelper.getTitle(next);
                        next.songCount += list.size();
                        String str2 = ((Music.Song) list.get(0)).coverURL;
                        if (TextUtils.isEmpty(next.cover) && !TextUtils.isEmpty(str2) && !next.isDefault) {
                            next.cover = str2;
                        }
                        ChannelManager.this.loadChannelList();
                        return str;
                    }
                }
                return null;
            }
        });
    }

    public Observable<Boolean> removeToFavourite(Music.Song song) {
        long j;
        Iterator<Music.Channel> it = this.mChannelList.iterator();
        while (true) {
            if (!it.hasNext()) {
                j = 0;
                break;
            }
            Music.Channel next = it.next();
            if (next.isDefault) {
                j = next.id;
                break;
            }
        }
        return deleteSongs(j, Collections.singletonList(song));
    }

    public Observable<Boolean> deleteSongs(final long j, final List<Music.Song> list) {
        return ObservableApiHelper.deleteSongs(j, list).doOnNext(new Action1<Boolean>() {
            /* class com.xiaomi.mico.music.channel.ChannelManager.AnonymousClass8 */

            public void call(Boolean bool) {
                for (Music.Channel next : ChannelManager.this.mChannelList) {
                    if (next.id == j) {
                        next.songCount -= list.size();
                        if (next.songCount < 0) {
                            next.songCount = 0;
                        }
                        ChannelManager.this.loadChannelList();
                        return;
                    }
                }
            }
        });
    }

    public void sendChannelListChangeEvent() {
        jgc.O000000o().O00000o(new MusicEvent.ChannelListChanged());
    }

    public void loadChannelList() {
        getInstance().getChannelList(null);
    }
}
