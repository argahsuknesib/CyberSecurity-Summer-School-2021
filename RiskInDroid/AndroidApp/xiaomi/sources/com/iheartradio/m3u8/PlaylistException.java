package com.iheartradio.m3u8;

import java.util.Set;

public class PlaylistException extends Exception {
    private static final long serialVersionUID = 7426782115004559238L;
    private final Set<PlaylistError> mErrors;
    private final String mInput;

    public PlaylistException(String str, Set<PlaylistError> set) {
        this.mInput = str;
        this.mErrors = set;
    }

    public String getInput() {
        return this.mInput;
    }

    public Set<PlaylistError> getErrors() {
        return this.mErrors;
    }
}
