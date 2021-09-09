package com.ximalaya.ting.android.opensdk.datatrasfer;

import java.util.HashSet;

public class AccessTokenBaseCall$1 extends HashSet<String> {
    public AccessTokenBaseCall$1() {
        add("/subscribe/get_albums_by_uid");
        add("/subscribe/add_or_delete");
        add("/subscribe/batch_add");
        add("/play_history/get_by_uid");
        add("/play_history/upload");
        add("/play_history/batch_upload");
        add("/play_history/batch_delete");
        add("/open_pay/client_place_order");
        add("/open_pay/get_bought_albums");
        add("/open_pay/album_bought_status");
        add("/open_pay/track_bought_status");
        add("/profile/user_info");
        add("/profile/persona");
    }
}
