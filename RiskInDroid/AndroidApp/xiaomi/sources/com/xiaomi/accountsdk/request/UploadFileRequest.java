package com.xiaomi.accountsdk.request;

import android.util.Base64;
import com.xiaomi.accountsdk.utils.IOUtils;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class UploadFileRequest {
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0131 A[SYNTHETIC, Splitter:B:43:0x0131] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x013b A[SYNTHETIC, Splitter:B:48:0x013b] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0145  */
    public static String execute(String str, InputStream inputStream, String str2, String str3) throws InvalidResponseException, IOException {
        HttpURLConnection httpURLConnection;
        DataOutputStream dataOutputStream;
        BufferedReader bufferedReader;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                byte[] bArr = new byte[16];
                new Random().nextBytes(bArr);
                String encodeToString = Base64.encodeToString(bArr, 2);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=".concat(String.valueOf(encodeToString)));
                httpURLConnection.setRequestProperty("Cache-Control", "no-cache");
                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                try {
                    dataOutputStream.writeBytes("--" + encodeToString + "\r\n");
                    dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + str2 + "\"; filename=\"" + str3 + "\"\r\n");
                    StringBuilder sb = new StringBuilder("Content-Type: ");
                    sb.append(getMIMEType(str3));
                    sb.append("\r\n");
                    dataOutputStream.writeBytes(sb.toString());
                    dataOutputStream.writeBytes("\r\n");
                    byte[] bArr2 = new byte[8192];
                    while (true) {
                        int read = inputStream.read(bArr2);
                        if (read == -1) {
                            break;
                        }
                        dataOutputStream.write(bArr2, 0, read);
                    }
                    dataOutputStream.flush();
                    dataOutputStream.writeBytes("\r\n");
                    dataOutputStream.flush();
                    dataOutputStream.writeBytes("--" + encodeToString + "--\r\n");
                    dataOutputStream.flush();
                    inputStream.close();
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        StringBuilder sb2 = new StringBuilder();
                        bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()), 1024);
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb2.append(readLine);
                        }
                        IOUtils.closeQuietly(bufferedReader);
                        String sb3 = sb2.toString();
                        try {
                            dataOutputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return sb3;
                    }
                    throw new InvalidResponseException(responseCode, "failed to upload file");
                } catch (Throwable th) {
                    th = th;
                    if (dataOutputStream != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                dataOutputStream = null;
                if (dataOutputStream != null) {
                    try {
                        dataOutputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
            dataOutputStream = null;
            if (dataOutputStream != null) {
            }
            if (inputStream != null) {
            }
            if (httpURLConnection != null) {
            }
            throw th;
        }
    }

    private static String getMIMEType(String str) {
        return (str.endsWith("png") || str.endsWith("PNG")) ? "image/png" : "image/jpg";
    }
}
