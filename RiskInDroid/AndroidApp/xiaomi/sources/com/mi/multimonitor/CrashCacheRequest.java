package com.mi.multimonitor;

import _m_j.cdf;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class CrashCacheRequest implements Request {
    private DiskCache mDiskCache;

    public CrashCacheRequest(DiskCache diskCache, File file) {
        this.mDiskCache = diskCache;
    }

    private void execute() {
        new CrashPostRunnable().run();
    }

    public String getBody() {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(this.mDiskCache.getCrashCacheFile()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return sb.toString();
                }
                sb.append(readLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return sb.toString();
        } catch (IOException e2) {
            e2.printStackTrace();
            return sb.toString();
        } catch (Throwable unused) {
            return sb.toString();
        }
    }

    public String getUrl() {
        return getPostUrl();
    }

    public HttpURLConnection getHttpURLConnection() throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(getUrl()).openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoOutput(true);
        return httpURLConnection;
    }

    public void postCrash(HttpURLConnection httpURLConnection) throws IOException {
        PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
        printWriter.write(getBody());
        printWriter.flush();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb.append(readLine);
            } else {
                printWriter.close();
                bufferedReader.close();
                checkResult(sb.toString());
                return;
            }
        }
    }

    private void checkResult(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (new JSONObject(str).getInt("errno") == 0) {
                    this.mDiskCache.clear();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private String getPostUrl() {
        return cdf.O00000Oo;
    }

    public void run() {
        execute();
    }

    class CrashPostRunnable implements Runnable {
        private CrashPostRunnable() {
        }

        public void run() {
            HttpURLConnection httpURLConnection = null;
            try {
                httpURLConnection = CrashCacheRequest.this.getHttpURLConnection();
                CrashCacheRequest.this.postCrash(httpURLConnection);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            } catch (MalformedURLException unused) {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            } catch (IOException unused2) {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            } catch (Throwable th) {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        }
    }
}
