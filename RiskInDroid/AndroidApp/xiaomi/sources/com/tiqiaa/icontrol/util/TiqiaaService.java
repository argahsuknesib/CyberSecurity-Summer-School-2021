package com.tiqiaa.icontrol.util;

import _m_j.bay;
import _m_j.bdf;
import _m_j.bdi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.imi.fastjson.parser.Feature;
import com.tiqiaa.database.DataBaseManager;
import com.tiqiaa.icontrol.util.DTOUtil;
import com.tiqiaa.irdnasdk.IrDnaSdkHelper;
import com.tiqiaa.local.LocalIrDb;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;

public class TiqiaaService {
    public static String TAG = "TiqiaaService";
    protected static boolean TEST_MODE = false;
    private static boolean isLocalServer = false;
    public static String license;
    protected static Context mContext;
    public static boolean working;
    protected boolean closed;
    protected ConnectivityManager connectivity;
    protected HttpClient mHttpClient;
    public ResponseDTO response_dto;

    interface BaseCallBack {
    }

    public boolean isNidu() {
        return false;
    }

    public boolean isSupportDiyDb() {
        return true;
    }

    public boolean isSupportLocalDb() {
        return true;
    }

    public boolean isSupportOfficialDb() {
        return true;
    }

    public static Context getAppContext() throws NotInitTiqiaaServiceException {
        Context context = mContext;
        if (context != null) {
            return context;
        }
        throw new NotInitTiqiaaServiceException();
    }

    public static void init(Context context, String str) {
        if (context != null) {
            bay.O000000o(context);
            IrDnaSdkHelper.init(context, str, 4, 3);
            LocalIrDb.getIrDb(context).initSdk(str, 4, 3);
            DataBaseManager.init(context);
            mContext = context;
            license = str;
            if (TEST_MODE) {
                LogUtil.setAllLogOn();
                return;
            }
            return;
        }
        throw new NullPointerException("the method param : context is null");
    }

    public static boolean isInitialized() {
        return (mContext == null || RequestDTO.getTiqiaaKey() == null) ? false : true;
    }

    public static void enableTestMode() {
        TEST_MODE = true;
        LogUtil.setAllLogOn();
    }

    public static boolean isTestModeEnable() {
        return TEST_MODE;
    }

    public static class NotInitTiqiaaServiceException extends RuntimeException {
        private static final long serialVersionUID = -3556245221673264128L;

        public NotInitTiqiaaServiceException() {
            super("The application context did not initialized !!! call TiqiaaService.init(context) while your app starting...");
        }

        public NotInitTiqiaaServiceException(String str) {
            super(str);
        }
    }

    public static class NotFoundTiqiaaKeyException extends RuntimeException {
        private static final long serialVersionUID = -3556245221673264128L;

        public NotFoundTiqiaaKeyException() {
            super("not found 'TIQIAA_APPKEY' in manifest xml file !!! please add the metadata in AndroidManifest.xml for using Tiqiaa web service..");
        }

        public NotFoundTiqiaaKeyException(String str) {
            super(str);
        }
    }

    public TiqiaaService(Context context) {
        mContext = context;
        initHttpParams();
    }

    private void initHttpParams() {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(basicHttpParams, "UTF-8");
        HttpProtocolParams.setUseExpectContinue(basicHttpParams, true);
        ConnManagerParams.setTimeout(basicHttpParams, 10000);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 20000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 35000);
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        this.mHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        this.mHttpClient = new DefaultHttpClient(basicHttpParams);
        this.closed = false;
    }

    public static boolean isWorking() {
        return working;
    }

    public ResponseDTO getResponseDTO() {
        return this.response_dto;
    }

    /* JADX INFO: finally extract failed */
    private String getResponseJson(InputStream inputStream, String str) throws IOException {
        if (inputStream == null) {
            return "";
        }
        if (str == null) {
            str = "ISO-8859-1";
        }
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, str);
        StringBuffer stringBuffer = new StringBuffer();
        try {
            char[] cArr = new char[1024];
            while (true) {
                int read = inputStreamReader.read(cArr);
                if (read == -1) {
                    inputStreamReader.close();
                    LogUtil.d(TAG, "getResponseJson.............reader.close");
                    return stringBuffer.toString();
                }
                stringBuffer.append(cArr, 0, read);
            }
        } catch (Throwable th) {
            inputStreamReader.close();
            LogUtil.d(TAG, "getResponseJson.............reader.close");
            throw th;
        }
    }

    private synchronized String doPost(HttpPost httpPost) throws Exception, Error {
        String str = TAG;
        LogUtil.v(str, "request.url=" + httpPost.getURI());
        if (this.closed) {
            initHttpParams();
        }
        InputStream inputStream = null;
        this.response_dto = null;
        try {
            HttpResponse execute = this.mHttpClient.execute(httpPost);
            HttpEntity entity = execute.getEntity();
            String str2 = TAG;
            LogUtil.w(str2, "response....StatusCode = " + execute.getStatusLine().getStatusCode());
            if (execute.getStatusLine().getStatusCode() != 200) {
                httpPost.abort();
                close();
                working = false;
                return null;
            }
            inputStream = entity.getContent();
            String responseJson = getResponseJson(inputStream, "UTF-8");
            LogUtil.w(TAG, "response....rsJsonStr = ".concat(String.valueOf(responseJson)));
            if (inputStream != null) {
                inputStream.close();
                LogUtil.d(TAG, "doPost.............in.close");
            }
            close();
            working = false;
            return responseJson;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            httpPost.abort();
            close();
            working = false;
            throw e;
        } catch (IOException e2) {
            e2.printStackTrace();
            httpPost.abort();
            close();
            working = false;
            throw e2;
        } catch (Exception e3) {
            e3.printStackTrace();
            httpPost.abort();
            close();
            working = false;
            throw e3;
        } catch (Error e4) {
            e4.printStackTrace();
            httpPost.abort();
            close();
            working = false;
            throw e4;
        } catch (IOException e5) {
            close();
            e5.printStackTrace();
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                    LogUtil.d(TAG, "doPost.............in.close");
                } catch (IOException e6) {
                    close();
                    e6.printStackTrace();
                }
            }
            throw th;
        }
    }

    /* JADX INFO: additional move instructions added (5) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.tiqiaa.icontrol.util.ResponseDTO} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.tiqiaa.icontrol.util.ResponseDTO} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: com.tiqiaa.icontrol.util.ResponseDTO} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.tiqiaa.icontrol.util.ResponseDTO} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v30, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: com.tiqiaa.icontrol.util.ResponseDTO} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: com.tiqiaa.icontrol.util.ResponseDTO} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.tiqiaa.icontrol.util.ResponseDTO} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0120  */
    public ResponseDTO postRequest(RequestDTO requestDTO, String str) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        ResponseDTO responseDTO;
        ResponseDTO responseDTO2;
        LogUtil.d(TAG, "postRequest--->>>>>>>>>>>>> url = " + str + ",request_dto = " + requestDTO);
        ResponseDTO responseDTO3 = null;
        if (requestDTO == null || str == null) {
            return null;
        }
        LogUtil.w(TAG, "postRequest---..###....request.PartnerNumber = " + requestDTO.getPartnerNumber() + "request.SdkVersion = " + requestDTO.getSdkVersion() + ",request.TiqiaaKey = " + RequestDTO.getTiqiaaKey() + ",request.data = " + requestDTO.getData());
        try {
            HttpPost httpPost = new HttpPost(str);
            LogUtil.d(TAG, "postRequest..............01");
            String requestJson = DTOUtil.getRequestJson(requestDTO);
            LogUtil.d(TAG, "json_str=".concat(String.valueOf(requestJson)));
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("client_request_params", requestJson));
            httpPost.setEntity(new UrlEncodedFormEntity(arrayList));
            String doPost = doPost(httpPost);
            if (doPost != 0) {
                try {
                    if (!doPost.equals("")) {
                        if (doPost.contains("<html><head>")) {
                            LogUtil.w(TAG, "postRequest..............response_json=".concat(String.valueOf(doPost)));
                            return null;
                        }
                        if (!verifyResponse(doPost)) {
                            LogUtil.w(TAG, "postRequest......校验MD5未通过");
                        } else {
                            responseDTO3 = getResponseDTO();
                        }
                        return responseDTO3;
                    }
                } catch (UnsupportedEncodingException e) {
                    e = e;
                    obj = doPost;
                    e.printStackTrace();
                    LogUtil.e(TAG, "postRequest...............UnsupportedEncodingException..........response_json=".concat(String.valueOf(obj)));
                    return responseDTO3;
                } catch (ClientProtocolException e2) {
                    e = e2;
                    obj2 = doPost;
                    e.printStackTrace();
                    LogUtil.e(TAG, "postRequest...............ClientProtocolException..........response_json=".concat(String.valueOf(obj2)));
                    return responseDTO3;
                } catch (ConnectTimeoutException e3) {
                    e = e3;
                    obj3 = doPost;
                    e.printStackTrace();
                    LogUtil.e(TAG, "postRequest...............ConnectTimeoutException..........response_json=".concat(String.valueOf(obj3)));
                    return responseDTO3;
                } catch (IOException e4) {
                    e = e4;
                    obj4 = doPost;
                    e.printStackTrace();
                    LogUtil.e(TAG, "postRequest...............IOException..........response_json=".concat(String.valueOf(obj4)));
                    return responseDTO3;
                } catch (DTOUtil.DataProcessException e5) {
                    e = e5;
                    obj5 = doPost;
                    e.printStackTrace();
                    LogUtil.e(TAG, "postRequest...............DataProcessException..........response_json=".concat(String.valueOf(obj5)));
                    return responseDTO3;
                } catch (Exception e6) {
                    e = e6;
                    responseDTO3 = doPost;
                    e.printStackTrace();
                    responseDTO = getResponseDTO();
                    if (responseDTO == null) {
                        responseDTO = new ResponseDTO();
                    }
                    responseDTO.setResponseType(-4);
                    LogUtil.e(TAG, "postRequest...............Exception..........response_json=".concat(String.valueOf(responseDTO3)));
                    return responseDTO;
                } catch (Error e7) {
                    e = e7;
                    responseDTO3 = doPost;
                    e.printStackTrace();
                    responseDTO2 = getResponseDTO();
                    if (responseDTO2 == null) {
                        responseDTO2 = new ResponseDTO();
                    }
                    responseDTO2.setResponseType(-4);
                    LogUtil.e(TAG, "postRequest...............Error..........response_json=".concat(String.valueOf(responseDTO3)));
                    return responseDTO2;
                }
            }
            LogUtil.w(TAG, "postRequest..........response_json=".concat(String.valueOf(doPost)));
            return null;
        } catch (UnsupportedEncodingException e8) {
            e = e8;
            obj = null;
            e.printStackTrace();
            LogUtil.e(TAG, "postRequest...............UnsupportedEncodingException..........response_json=".concat(String.valueOf(obj)));
            return responseDTO3;
        } catch (ClientProtocolException e9) {
            e = e9;
            obj2 = null;
            e.printStackTrace();
            LogUtil.e(TAG, "postRequest...............ClientProtocolException..........response_json=".concat(String.valueOf(obj2)));
            return responseDTO3;
        } catch (ConnectTimeoutException e10) {
            e = e10;
            obj3 = null;
            e.printStackTrace();
            LogUtil.e(TAG, "postRequest...............ConnectTimeoutException..........response_json=".concat(String.valueOf(obj3)));
            return responseDTO3;
        } catch (IOException e11) {
            e = e11;
            obj4 = null;
            e.printStackTrace();
            LogUtil.e(TAG, "postRequest...............IOException..........response_json=".concat(String.valueOf(obj4)));
            return responseDTO3;
        } catch (DTOUtil.DataProcessException e12) {
            e = e12;
            obj5 = null;
            e.printStackTrace();
            LogUtil.e(TAG, "postRequest...............DataProcessException..........response_json=".concat(String.valueOf(obj5)));
            return responseDTO3;
        } catch (Exception e13) {
            e = e13;
            e.printStackTrace();
            responseDTO = getResponseDTO();
            if (responseDTO == null) {
            }
            responseDTO.setResponseType(-4);
            LogUtil.e(TAG, "postRequest...............Exception..........response_json=".concat(String.valueOf(responseDTO3)));
            return responseDTO;
        } catch (Error e14) {
            e = e14;
            e.printStackTrace();
            responseDTO2 = getResponseDTO();
            if (responseDTO2 == null) {
            }
            responseDTO2.setResponseType(-4);
            LogUtil.e(TAG, "postRequest...............Error..........response_json=".concat(String.valueOf(responseDTO3)));
            return responseDTO2;
        }
    }

    public class IControlWebException extends Exception {
        private static final long serialVersionUID = -4488540373718890759L;

        public String getMessage() {
            return "网络服务操作出错!";
        }

        public IControlWebException() {
        }

        public void printStackTrace() {
            LogUtil.e(TiqiaaService.TAG, "网络服务操作出错!");
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkNet() {
        return PhoneHelper.checkNet();
    }

    public static final boolean networkIsAvailable(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
    }

    public String getPhoneIMEI() {
        String deviceId = ((TelephonyManager) mContext.getSystemService("phone")).getDeviceId();
        if (deviceId != null && !deviceId.equals("")) {
            return deviceId;
        }
        String macAddress = ((WifiManager) mContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        return macAddress == null || macAddress.equals("") ? "device_havnt_imei_or_mac_address" : macAddress;
    }

    public boolean verifyResponse(String str) throws Exception {
        try {
            Map map = (Map) bdf.O000000o(str, new bdi<Map<String, String>>() {
                /* class com.tiqiaa.icontrol.util.TiqiaaService.AnonymousClass1 */
            }, new Feature[0]);
            String str2 = (String) map.get("response_params");
            if (!DTOUtil.verifyMD5(str2, (String) map.get("md5"))) {
                return false;
            }
            byte[] decoder = DTOUtil.Base64Helper.decoder(str2);
            LogUtil.d(TAG, "--------------------解密解压数据--------------------");
            byte[] decodeAndUnzip = DTOUtil.decodeAndUnzip(decoder);
            String str3 = new String(decodeAndUnzip, "utf-8");
            String str4 = TAG;
            LogUtil.d(str4, "明文----> length = " + str3.length());
            this.response_dto = (ResponseDTO) bdf.O000000o(str3, ResponseDTO.class);
            LogUtil.d(TAG, "解析response完成....");
            WeakRefHandler.add(str2);
            WeakRefHandler.add(decodeAndUnzip);
            WeakRefHandler.add(str3);
            WeakRefHandler.add(decoder);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e(TAG, " @@@@@@@@@@@@@@@@@@@ verifyResponse ERROR ");
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void execute(Runnable runnable) {
        new Thread(runnable).start();
    }

    public void close() {
        LogUtil.w(TAG, "BASEWEBSERVICE.......................关闭网络连接.....");
        HttpClient httpClient = this.mHttpClient;
        if (httpClient != null) {
            this.closed = true;
            httpClient.getConnectionManager().shutdown();
        }
    }

    public static boolean isLocalServer() {
        return isLocalServer;
    }

    public static void setLocalServer(boolean z) {
        isLocalServer = z;
    }
}
