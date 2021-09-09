package com.xiaomi.smarthome.camera.activity.timelapse;

import _m_j.civ;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class TCPClient {
    private static TCPClient instance;
    private Context context;
    private int fileLength;
    private boolean flag = true;
    public InputStream inputStream;
    public OutputStream outputStream;
    BufferedReader reader;
    public Socket socket;
    public InputStreamReader streamReader;
    private Thread thread;

    private TCPClient(Context context2) {
        this.context = context2;
    }

    public static TCPClient getInstance(Context context2) {
        if (instance == null) {
            instance = new TCPClient(context2);
        }
        return instance;
    }

    public void createClient(String str, int i, Handler handler, String str2, long j) {
        final String str3 = str;
        final int i2 = i;
        final Handler handler2 = handler;
        final String str4 = str2;
        final long j2 = j;
        this.thread = new Thread(new Runnable() {
            /* class com.xiaomi.smarthome.camera.activity.timelapse.TCPClient.AnonymousClass1 */

            public void run() {
                try {
                    TCPClient.this.socket = new Socket();
                    TCPClient.this.socket.connect(new InetSocketAddress(str3, i2), 50000);
                    civ.O000000o("TimelapsePhotographPlayActivity", "判断客户端和服务器是否连接成功=" + TCPClient.this.socket.isConnected());
                    TCPClient.this.socket.setKeepAlive(true);
                    TCPClient.this.inputStream = TCPClient.this.socket.getInputStream();
                    TCPClient.this.streamReader = new InputStreamReader(TCPClient.this.socket.getInputStream());
                    TCPClient.this.reader = new BufferedReader(TCPClient.this.streamReader);
                    TCPClient.this.outputStream = TCPClient.this.socket.getOutputStream();
                    TCPClient.this.recieveData(handler2, str4, j2);
                } catch (SocketTimeoutException e) {
                    civ.O000000o("TimelapsePhotographPlayActivity", "socket TimeOut!");
                    e.printStackTrace();
                    civ.O000000o("TimelapsePhotographPlayActivity", "e1=" + e.getMessage());
                    handler2.sendEmptyMessage(99999);
                } catch (IOException e2) {
                    e2.printStackTrace();
                    civ.O000000o("TimelapsePhotographPlayActivity", "e=" + e2.getMessage());
                    handler2.sendEmptyMessage(1000000);
                } catch (Throwable th) {
                    TCPClient.this.closeStream();
                    throw th;
                }
                TCPClient.this.closeStream();
            }
        });
        this.thread.start();
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x0157 A[SYNTHETIC, Splitter:B:50:0x0157] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0161 A[SYNTHETIC, Splitter:B:55:0x0161] */
    public void recieveData(Handler handler, String str, long j) {
        civ.O000000o("TimelapsePhotographPlayActivity", "客户端启动成功。并接收数据");
        try {
            String readLine = this.reader.readLine();
            if (readLine != null && readLine.contains(":")) {
                this.fileLength = Integer.parseInt(readLine.split(":")[1]);
                civ.O000000o("TimelapsePhotographPlayActivity", "延时摄影的长度=" + this.fileLength);
            }
            civ.O000000o("TimelapsePhotographPlayActivity", "socket a=".concat(String.valueOf(readLine)));
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = 1000001;
            obtainMessage.obj = Integer.valueOf(this.fileLength);
            handler.sendMessage(obtainMessage);
            if (this.outputStream != null) {
                this.outputStream.write("ok".getBytes());
            }
            FileOutputStream fileOutputStream = null;
            if (str == null) {
                try {
                    Message obtainMessage2 = handler.obtainMessage();
                    obtainMessage2.what = 1000004;
                    obtainMessage2.arg1 = 1;
                    handler.sendMessage(obtainMessage2);
                    closeStream();
                    civ.O000000o("TimelapsePhotographPlayActivity", "filepath==null");
                    closeStream();
                } catch (Exception e) {
                    e = e;
                    try {
                        e.printStackTrace();
                        handler.sendEmptyMessage(1000004);
                        civ.O000000o("TimelapsePhotographPlayActivity", "e=" + e.getMessage());
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        closeStream();
                        closeStream();
                    } catch (Throwable th) {
                        th = th;
                        if (fileOutputStream != null) {
                        }
                        closeStream();
                        throw th;
                    }
                }
            } else {
                String str2 = str + j + ".h265";
                civ.O000000o("TimelapsePhotographPlayActivity", "储存延时摄影的路径=".concat(String.valueOf(str2)));
                File file = new File(str2);
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[2048];
                    int i = 0;
                    while (i != this.fileLength) {
                        civ.O000000o("TimelapsePhotographPlayActivity", "flag=" + this.flag);
                        if (!this.flag) {
                            fileOutputStream2.close();
                            closeStream();
                            handler.removeCallbacksAndMessages(null);
                            handler.sendEmptyMessage(1000005);
                            fileOutputStream2.close();
                            closeStream();
                            closeStream();
                            return;
                        }
                        int read = this.inputStream.read(bArr);
                        fileOutputStream2.write(bArr, 0, read);
                        i += read;
                        Message obtainMessage3 = handler.obtainMessage();
                        obtainMessage3.what = 1000002;
                        obtainMessage3.arg1 = i;
                        handler.sendMessage(obtainMessage3);
                    }
                    civ.O000000o("TimelapsePhotographPlayActivity", "发送了下载成功的消息....");
                    fileOutputStream2.close();
                    closeStream();
                    Message obtainMessage4 = handler.obtainMessage();
                    obtainMessage4.what = 1000003;
                    obtainMessage4.obj = str2;
                    handler.sendMessage(obtainMessage4);
                    fileOutputStream2.close();
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    handler.sendEmptyMessage(1000004);
                    civ.O000000o("TimelapsePhotographPlayActivity", "e=" + e.getMessage());
                    if (fileOutputStream != null) {
                    }
                    closeStream();
                    closeStream();
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    closeStream();
                    throw th;
                }
                closeStream();
                closeStream();
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            handler.sendEmptyMessage(1000004);
            civ.O000000o("TimelapsePhotographPlayActivity", "e=" + e3.getMessage());
        } finally {
            closeStream();
        }
    }

    public void closeStream() {
        try {
            if (this.inputStream != null) {
                this.inputStream.close();
            }
            if (this.outputStream != null) {
                this.outputStream.close();
            }
            if (this.reader != null) {
                this.reader.close();
            }
            if (this.streamReader != null) {
                this.streamReader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setFlag(boolean z) {
        this.flag = z;
    }

    public void closeSocket() {
        civ.O000000o("TimelapsePhotographPlayActivity", "closeSocket。。。。");
        Socket socket2 = this.socket;
        if (socket2 != null) {
            try {
                socket2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
