package com.xiaomi.mico.common.schema.handler;

import _m_j.jgc;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.xiaomi.mico.api.LoginManager;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.common.event.QQMusicAuthEvent;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.main.MainHelper;
import com.xiaomi.mico.module.update.UpdateAssistantActivity;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.detail.SongBookDetailActivity;
import java.util.Arrays;
import java.util.List;

public class HomepageSchemaHandler extends TabSchemaHandler {
    private static final List<String> SUPPORT_PATHS = Arrays.asList("/main", "/music", "/album", "/artist", "/playlist", "/station", "/channel", "/open_app", "/chatlog", "/chatlog_feedback", "/didi_order", "/play_songs", "/songbook", "/play_sheet", "/mitv", "/qq_music_auth", "/play_station", "/upgrade");

    /* access modifiers changed from: protected */
    public String authority() {
        return "homepage";
    }

    /* access modifiers changed from: protected */
    public String tabKey() {
        return "homepage";
    }

    public /* bridge */ /* synthetic */ Object getExtras() {
        return super.getExtras();
    }

    /* access modifiers changed from: protected */
    public List<String> supportPaths() {
        return SUPPORT_PATHS;
    }

    /* access modifiers changed from: protected */
    public void doProcess(Context context, String str, Uri uri) {
        if (!handled(context, str, uri)) {
            handleMusicAction(context, str, uri);
        }
    }

    private boolean handled(Context context, String str, Uri uri) {
        if ("/open_app".equals(str)) {
            openApp(context, uri);
            return true;
        }
        if (!"/chatlog".equals(str)) {
            if ("/chalog_feedback".equals(str)) {
                return true;
            }
            if (!"/didi_order".equals(str)) {
                if ("/mitv".equals(str)) {
                    return true;
                }
                if ("/qq_music_auth".equals(str)) {
                    String decodeParam = decodeParam(uri.getQueryParameter("cmd"));
                    String decodeParam2 = decodeParam(uri.getQueryParameter("qmlogin"));
                    if (TextUtils.isEmpty(decodeParam) || !"verify".equals(decodeParam)) {
                        if ("1".equals(decodeParam2)) {
                            jgc.O000000o().O00000o(new QQMusicAuthEvent.QQMusicLogin());
                            return true;
                        } else if (!"0".equals(decodeParam2)) {
                            return true;
                        } else {
                            jgc.O000000o().O00000o(new QQMusicAuthEvent.QQMusicCancelLogin());
                            return true;
                        }
                    } else if (!"0".equals(uri.getQueryParameter("ret"))) {
                        return true;
                    } else {
                        jgc.O000000o().O00000o(new QQMusicAuthEvent(true));
                        return true;
                    }
                } else if ("/upgrade".equals(str)) {
                    context.startActivity(new Intent(context, UpdateAssistantActivity.class));
                    return true;
                } else if ("/main".equals(str)) {
                    String queryParameter = uri.getQueryParameter("uid");
                    String userId = LoginManager.getInstance().getPassportInfo().getUserId();
                    if (userId == null || !userId.equals(queryParameter)) {
                        ToastUtil.showToast("uid not match, recv:" + queryParameter + " current:" + userId);
                    } else {
                        MainHelper.newIntentToMainActivity("smarthome", new Bundle());
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0049, code lost:
        if (r14.equals("/music") != false) goto L_0x0094;
     */
    private void handleMusicAction(Context context, String str, Uri uri) {
        String str2;
        char c = 0;
        if (!uri.getBooleanQueryParameter("parseAudioId", false) || !MicoManager.getInstance().currentPlayingMicoIsAiProtocolV3()) {
            str2 = decodeParam(uri.getQueryParameter("id"));
        } else {
            str2 = decodeParam(uri.getQueryParameter("audioId"));
        }
        String str3 = str2;
        if (!TextUtils.isEmpty(str3)) {
            switch (str.hashCode()) {
                case -1810235731:
                    if (str.equals("/songbook")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case -1589428699:
                    if (str.equals("/station")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -1466506495:
                    if (str.equals("/playlist")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -1209405224:
                    if (str.equals("/play_station")) {
                        c = 8;
                        break;
                    }
                    c = 65535;
                    break;
                case -926751229:
                    if (str.equals("/play_sheet")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 1046657524:
                    if (str.equals("/channel")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 1438466976:
                    if (str.equals("/album")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1449833302:
                    break;
                case 1648869430:
                    if (str.equals("/artist")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    MusicHelper.playSong(str3, (MusicHelper.OnPlayingListener) null);
                    return;
                case 1:
                    MusicHelper.processAlbum(context, str3);
                    return;
                case 2:
                    MusicHelper.processArtist(context, str3);
                    return;
                case 3:
                    MusicHelper.processSheet(context, str3);
                    return;
                case 4:
                    Context context2 = context;
                    Uri uri2 = uri;
                    MusicHelper.processStation(context2, uri2, decodeParam(uri.getQueryParameter("globalId")), str3, decodeParam(uri.getQueryParameter("origin")), decodeParam(uri.getQueryParameter("category")), decodeParam(uri.getQueryParameter("type")), decodeParam(uri.getQueryParameter("saleType")), decodeParam(uri.getQueryParameter("fromAddBabySchedule")), null);
                    return;
                case 5:
                    MusicHelper.processChannel(context, str3);
                    return;
                case 6:
                    context.startActivity(SongBookDetailActivity.shareIntent(context, uri.toString()));
                    return;
                case 7:
                    MusicHelper.processPlaySheetSongs(str3, decodeParam(uri.getQueryParameter("type")));
                    return;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    MusicHelper.processPlaySongBox(str3, decodeParam(uri.getQueryParameter("origin")), decodeParam(uri.getQueryParameter("category")));
                    return;
                default:
                    return;
            }
        }
    }

    private void openApp(Context context, Uri uri) {
        String decodeParam = decodeParam(uri.getQueryParameter("url"));
        if (!TextUtils.isEmpty(decodeParam)) {
            try {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(decodeParam)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String buildPlaySheetSchema(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Uri parse = Uri.parse(str);
        if ("/station".equals(parse.getPath())) {
            return buildPlaySongboxSchema(str);
        }
        String decodeParam = decodeParam(parse.getQueryParameter("id"));
        String decodeParam2 = decodeParam(parse.getQueryParameter("type"));
        Uri.Builder appendPath = new Uri.Builder().scheme("mico").authority("homepage").appendPath("play_sheet");
        if (decodeParam2 == null) {
            decodeParam2 = "";
        }
        return appendPath.appendQueryParameter("type", decodeParam2).appendQueryParameter("id", decodeParam).build().toString();
    }

    private static String buildPlaySongboxSchema(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Uri parse = Uri.parse(str);
        String decodeParam = decodeParam(parse.getQueryParameter("id"));
        String decodeParam2 = decodeParam(parse.getQueryParameter("type"));
        String decodeParam3 = decodeParam(parse.getQueryParameter("origin"));
        String decodeParam4 = decodeParam(parse.getQueryParameter("category"));
        Uri.Builder appendPath = new Uri.Builder().scheme("mico").authority("homepage").appendPath("play_station");
        if (decodeParam2 == null) {
            decodeParam2 = "";
        }
        return appendPath.appendQueryParameter("type", decodeParam2).appendQueryParameter("id", decodeParam).appendQueryParameter("origin", decodeParam3).appendQueryParameter("category", decodeParam4).build().toString();
    }
}
