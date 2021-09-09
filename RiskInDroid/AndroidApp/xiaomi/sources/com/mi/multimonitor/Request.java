package com.mi.multimonitor;

public interface Request extends Runnable {
    String getBody();

    String getUrl();
}
