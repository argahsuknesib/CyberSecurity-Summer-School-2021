package com.mobikwik.sdk.lib.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Network {
    private static ConnectivityManager cm;

    public static String getConnectionType(Context context) {
        if (cm == null) {
            cm = (ConnectivityManager) context.getSystemService("connectivity");
        }
        NetworkInfo activeNetworkInfo = cm.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return "";
        }
        if (activeNetworkInfo.getType() != 0) {
            return activeNetworkInfo.getTypeName();
        }
        return activeNetworkInfo.getTypeName() + ":" + activeNetworkInfo.getSubtypeName();
    }

    private static String getQueryString(HashMap hashMap) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : hashMap.keySet()) {
            String str2 = (String) hashMap.get(str);
            if (z) {
                z = false;
            } else {
                sb.append("&");
            }
            sb.append(Utils.utf8Encode(str));
            sb.append("=");
            if (str2 == null) {
                str2 = "";
            }
            sb.append(Utils.utf8Encode(str2));
        }
        return sb.toString();
    }

    public static String getResponseFromQuery(Context context, String str) {
        return getResponseFromQuery(context, str, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c1  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:34:0x00a5=Splitter:B:34:0x00a5, B:26:0x008f=Splitter:B:26:0x008f} */
    public static String getResponseFromQuery(Context context, String str, String str2) {
        HttpURLConnection httpURLConnection;
        SocketTimeoutException e;
        IOException e2;
        if (Build.VERSION.SDK_INT <= 8) {
            System.setProperty("http.keepAlive", "false");
        }
        Utils.print(str);
        try {
            Long.valueOf(System.currentTimeMillis());
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(20000);
                httpURLConnection.setReadTimeout(20000);
                httpURLConnection.setRequestMethod("POST");
                if (str2 != null) {
                    httpURLConnection.setRequestProperty("User-Agent", str2);
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new BufferedInputStream(httpURLConnection.getInputStream())));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine + "\n");
                }
                Utils.print(sb.toString());
                String sb2 = sb.toString();
                Long.valueOf(System.currentTimeMillis());
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return sb2;
            } catch (SocketTimeoutException e3) {
                e = e3;
                e.printStackTrace();
                Long.valueOf(System.currentTimeMillis());
                if (httpURLConnection != null) {
                }
                return "Connection timed out";
            } catch (IOException e4) {
                e2 = e4;
                try {
                    e2.printStackTrace();
                    Long.valueOf(System.currentTimeMillis());
                    if (httpURLConnection != null) {
                    }
                    return "No Connection available";
                } catch (Throwable th) {
                    th = th;
                    Long.valueOf(System.currentTimeMillis());
                    if (httpURLConnection != null) {
                    }
                    throw th;
                }
            }
        } catch (SocketTimeoutException e5) {
            SocketTimeoutException socketTimeoutException = e5;
            httpURLConnection = null;
            e = socketTimeoutException;
            e.printStackTrace();
            Long.valueOf(System.currentTimeMillis());
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return "Connection timed out";
        } catch (IOException e6) {
            IOException iOException = e6;
            httpURLConnection = null;
            e2 = iOException;
            e2.printStackTrace();
            Long.valueOf(System.currentTimeMillis());
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return "No Connection available";
        } catch (Throwable th2) {
            Throwable th3 = th2;
            httpURLConnection = null;
            th = th3;
            Long.valueOf(System.currentTimeMillis());
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:47:0x0177=Splitter:B:47:0x0177, B:52:0x019b=Splitter:B:52:0x019b} */
    public static String getResponseOfFormPostRequest(String str, String str2, HashMap hashMap, int i, String str3, boolean z) {
        String str4;
        String headerField;
        String str5;
        Utils.print("getResponseOfPostRequest URL: ".concat(String.valueOf(str)));
        HttpURLConnection httpURLConnection = null;
        if (str == null) {
            str5 = "URL is null RETURNING BACK";
        } else if (str2 == null) {
            str5 = "DATA is null RETURNING BACK";
        } else {
            try {
                Utils.print("connecting...: ".concat(String.valueOf(Long.valueOf(System.currentTimeMillis()))));
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
                try {
                    httpURLConnection2.setRequestProperty("User-Agent", str3);
                    httpURLConnection2.setConnectTimeout(50000);
                    httpURLConnection2.setReadTimeout(i);
                    httpURLConnection2.setRequestMethod("POST");
                    httpURLConnection2.setDoInput(true);
                    httpURLConnection2.setDoOutput(true);
                    httpURLConnection2.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    httpURLConnection2.setRequestProperty("charset", "utf-8");
                    httpURLConnection2.setRequestProperty("Content-Length", Integer.toString(str2.getBytes().length));
                    httpURLConnection2.setInstanceFollowRedirects(true);
                    if (hashMap != null) {
                        Iterator it = hashMap.entrySet().iterator();
                        while (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            httpURLConnection2.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                            it.remove();
                        }
                    }
                    httpURLConnection2.setUseCaches(false);
                    OutputStream outputStream = httpURLConnection2.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    bufferedWriter.write(str2);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    int responseCode = httpURLConnection2.getResponseCode();
                    if (!(responseCode == 302 || responseCode == 301)) {
                        if (responseCode != 303) {
                            BufferedInputStream bufferedInputStream = (responseCode < 400 || !z) ? new BufferedInputStream(httpURLConnection2.getInputStream()) : new BufferedInputStream(httpURLConnection2.getErrorStream());
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream));
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb.append(readLine + "\n");
                            }
                            Utils.print("Response: " + sb.toString());
                            Long.valueOf(System.currentTimeMillis());
                            bufferedInputStream.close();
                            headerField = sb.toString();
                            Utils.print("disconnecting...: ".concat(String.valueOf(Long.valueOf(System.currentTimeMillis()))));
                            httpURLConnection2.disconnect();
                            return headerField;
                        }
                    }
                    httpURLConnection2.getResponseMessage();
                    headerField = httpURLConnection2.getHeaderField("Location");
                    Long.valueOf(System.currentTimeMillis());
                    Utils.print("disconnecting...: ".concat(String.valueOf(Long.valueOf(System.currentTimeMillis()))));
                    httpURLConnection2.disconnect();
                    return headerField;
                } catch (SocketTimeoutException e) {
                    e = e;
                    httpURLConnection = httpURLConnection2;
                } catch (IOException e2) {
                    e = e2;
                    httpURLConnection = httpURLConnection2;
                    try {
                        Long.valueOf(System.currentTimeMillis());
                        e.printStackTrace();
                        str4 = "No Connection available";
                        Utils.print("disconnecting...: ".concat(String.valueOf(Long.valueOf(System.currentTimeMillis()))));
                        httpURLConnection.disconnect();
                        return str4;
                    } catch (Throwable th) {
                        th = th;
                        httpURLConnection2 = httpURLConnection;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    Utils.print("disconnecting...: ".concat(String.valueOf(Long.valueOf(System.currentTimeMillis()))));
                    httpURLConnection2.disconnect();
                    throw th;
                }
            } catch (SocketTimeoutException e3) {
                e = e3;
                Long.valueOf(System.currentTimeMillis());
                e.printStackTrace();
                str4 = "Connection timed out";
                Utils.print("disconnecting...: ".concat(String.valueOf(Long.valueOf(System.currentTimeMillis()))));
                httpURLConnection.disconnect();
                return str4;
            } catch (IOException e4) {
                e = e4;
                Long.valueOf(System.currentTimeMillis());
                e.printStackTrace();
                str4 = "No Connection available";
                Utils.print("disconnecting...: ".concat(String.valueOf(Long.valueOf(System.currentTimeMillis()))));
                httpURLConnection.disconnect();
                return str4;
            }
        }
        Utils.print(str5);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0112  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:31:0x00e4=Splitter:B:31:0x00e4, B:38:0x00f7=Splitter:B:38:0x00f7} */
    public static String getResponseOfPostRequest(String str, String str2, String str3, String str4) {
        if (Build.VERSION.SDK_INT <= 8) {
            System.setProperty("http.keepAlive", "false");
        }
        Utils.print("url :" + str + "\n data :" + str2);
        HttpURLConnection httpURLConnection = null;
        try {
            Long.valueOf(System.currentTimeMillis());
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setConnectTimeout(20000);
                httpURLConnection2.setReadTimeout(20000);
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setDoOutput(true);
                if (str4 != null) {
                    httpURLConnection2.setRequestProperty("User-Agent", str4);
                }
                if ("application/json".equals(str3)) {
                    httpURLConnection2.setRequestProperty("Content-Type", "application/json");
                }
                byte[] bytes = str2.getBytes("UTF-8");
                StringBuilder sb = new StringBuilder();
                sb.append(bytes.length);
                httpURLConnection2.setRequestProperty("Content-Length", sb.toString());
                httpURLConnection2.getOutputStream().write(bytes, 0, bytes.length);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new BufferedInputStream(httpURLConnection2.getInputStream())));
                StringBuilder sb2 = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb2.append(readLine + "\n");
                }
                Utils.print("Response :" + sb2.toString());
                String sb3 = sb2.toString();
                Long.valueOf(System.currentTimeMillis());
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                return sb3;
            } catch (SocketTimeoutException e) {
                e = e;
                httpURLConnection = httpURLConnection2;
                e.printStackTrace();
                Long.valueOf(System.currentTimeMillis());
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return "Connection timed out";
            } catch (IOException e2) {
                e = e2;
                httpURLConnection = httpURLConnection2;
                try {
                    e.printStackTrace();
                    Long.valueOf(System.currentTimeMillis());
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return "No Connection available";
                } catch (Throwable th) {
                    th = th;
                    httpURLConnection2 = httpURLConnection;
                    Long.valueOf(System.currentTimeMillis());
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                Long.valueOf(System.currentTimeMillis());
                if (httpURLConnection2 != null) {
                }
                throw th;
            }
        } catch (SocketTimeoutException e3) {
            e = e3;
            e.printStackTrace();
            Long.valueOf(System.currentTimeMillis());
            if (httpURLConnection != null) {
            }
            return "Connection timed out";
        } catch (IOException e4) {
            e = e4;
            e.printStackTrace();
            Long.valueOf(System.currentTimeMillis());
            if (httpURLConnection != null) {
            }
            return "No Connection available";
        }
    }

    public static String getResponseOfPostRequest(String str, HashMap hashMap) {
        return getResponseOfPostRequest(str, hashMap, null);
    }

    public static String getResponseOfPostRequest(String str, HashMap hashMap, String str2) {
        if (Build.VERSION.SDK_INT <= 8) {
            System.setProperty("http.keepAlive", "false");
        }
        return getResponseOfPostRequest(str, getQueryString(hashMap), null, str2);
    }

    public static boolean isConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            UIFunctions.showToast(context, "No Connection available");
            return false;
        }
        boolean isConnected = activeNetworkInfo.isConnected();
        if (!isConnected) {
            UIFunctions.showToast(context, "No internet access");
        }
        return isConnected;
    }

    public static boolean validateNetworkResponse(Context context, String str, boolean z) {
        if (str == null || str.length() <= 0 || str.equals("Something went bad. Please try again later.")) {
            if (z) {
                UIFunctions.showToastLong(context, "Something went bad. Please try again later.");
            }
            return false;
        } else if (str.equals("No Connection available")) {
            if (z) {
                UIFunctions.showToastLong(context, "No Connection available");
            }
            return false;
        } else if (!str.equals("Connection timed out")) {
            return true;
        } else {
            if (z) {
                UIFunctions.showToastLong(context, "Connection timed out");
            }
            return false;
        }
    }

    public static boolean validateNetworkResponse(String str) {
        return str != null && str.length() > 0 && !str.equals("Something went bad. Please try again later.") && !str.equals("No Connection available") && !str.equals("Connection timed out");
    }
}
