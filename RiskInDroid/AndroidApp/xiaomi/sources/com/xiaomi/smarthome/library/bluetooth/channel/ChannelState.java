package com.xiaomi.smarthome.library.bluetooth.channel;

public enum ChannelState {
    IDLE,
    READY,
    WAIT_START_ACK,
    WRITING,
    SYNC,
    SYNC_ACK,
    SYNC_WAIT_PACKET,
    READING,
    WAIT_MNG_ACK,
    WAIT_SINGLE_ACK
}
