package com.tiqiaa.icontrol.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class UrlPoster {
    public static InputStream requestUrl(String str) throws IOException {
        return new URL(str).openConnection().getInputStream();
    }
}
