package com.tutk.IOTC;

import com.tutk.IOTC.AVAPIs;

public class St_AVServStartInConfig {
    public AVAPIs.avAbilityRequestFn ability_request = null;
    public AVAPIs.avChangePasswordRequestFn change_password_request = null;
    public AVAPIs.avIdentityArrayRequestFn identity_array_request = null;
    public int iotc_channel_id;
    public int iotc_session_id;
    public AVAPIs.avJsonCtrlRequestFn json_request = null;
    public AVAPIs.avPasswordAuthFn password_auth = null;
    public int resend;
    public int security_mode;
    public int server_type;
    public int timeout_sec;
    public AVAPIs.avTokenAuthFn token_auth = null;
    public AVAPIs.avTokenDeleteFn token_delete = null;
    public AVAPIs.avTokenRequestFn token_request = null;
}
