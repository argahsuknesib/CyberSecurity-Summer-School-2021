package _m_j;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class pc {
    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX INFO: additional move instructions added (2) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    public static byte[] O000000o(byte[] bArr) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        ByteArrayOutputStream byteArrayOutputStream3;
        ByteArrayOutputStream byteArrayOutputStream4;
        GZIPOutputStream gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream5 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            } catch (Exception e) {
                e = e;
                byteArrayOutputStream4 = null;
                byteArrayOutputStream5 = byteArrayOutputStream;
                byteArrayOutputStream3 = byteArrayOutputStream4;
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream5;
                    byteArrayOutputStream2 = byteArrayOutputStream3;
                }
            } catch (Throwable th2) {
                th = th2;
                pd.O000000o(byteArrayOutputStream);
                pd.O000000o(byteArrayOutputStream5);
                throw th;
            }
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.finish();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                pd.O000000o(byteArrayOutputStream);
                pd.O000000o(gZIPOutputStream);
                return byteArray;
            } catch (Exception e2) {
                e = e2;
                byteArrayOutputStream4 = gZIPOutputStream;
                byteArrayOutputStream5 = byteArrayOutputStream;
                byteArrayOutputStream3 = byteArrayOutputStream4;
                throw e;
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream2 = gZIPOutputStream;
                byteArrayOutputStream5 = byteArrayOutputStream2;
                pd.O000000o(byteArrayOutputStream);
                pd.O000000o(byteArrayOutputStream5);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayOutputStream3 = null;
            throw e;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            pd.O000000o(byteArrayOutputStream);
            pd.O000000o(byteArrayOutputStream5);
            throw th;
        }
    }

    public static byte[] O00000Oo(byte[] bArr) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        InputStream inputStream2;
        InputStream gZIPInputStream;
        InputStream inputStream3;
        InputStream inputStream4 = null;
        try {
            inputStream = new ByteArrayInputStream(bArr);
            try {
                gZIPInputStream = new GZIPInputStream(inputStream);
            } catch (Exception e) {
                e = e;
                byteArrayOutputStream = null;
                inputStream4 = inputStream;
                inputStream2 = null;
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    InputStream inputStream5 = inputStream2;
                    inputStream = inputStream4;
                    inputStream4 = inputStream5;
                }
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
                pd.O000000o(inputStream);
                pd.O000000o(inputStream4);
                pd.O000000o(byteArrayOutputStream);
                throw th;
            }
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Exception e2) {
                inputStream3 = inputStream;
                inputStream2 = gZIPInputStream;
                e = e2;
                byteArrayOutputStream = null;
                inputStream4 = inputStream3;
                throw e;
            } catch (Throwable th3) {
                inputStream4 = gZIPInputStream;
                th = th3;
                byteArrayOutputStream = null;
                pd.O000000o(inputStream);
                pd.O000000o(inputStream4);
                pd.O000000o(byteArrayOutputStream);
                throw th;
            }
            try {
                pd.O000000o(gZIPInputStream, byteArrayOutputStream);
                byteArrayOutputStream.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                pd.O000000o(inputStream);
                pd.O000000o(gZIPInputStream);
                pd.O000000o(byteArrayOutputStream);
                return byteArray;
            } catch (Exception e3) {
                inputStream3 = inputStream;
                inputStream2 = gZIPInputStream;
                e = e3;
                inputStream4 = inputStream3;
                throw e;
            } catch (Throwable th4) {
                Throwable th5 = th4;
                inputStream4 = gZIPInputStream;
                th = th5;
                pd.O000000o(inputStream);
                pd.O000000o(inputStream4);
                pd.O000000o(byteArrayOutputStream);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            inputStream2 = null;
            byteArrayOutputStream = null;
            throw e;
        } catch (Throwable th6) {
            th = th6;
            inputStream = null;
            byteArrayOutputStream = null;
            pd.O000000o(inputStream);
            pd.O000000o(inputStream4);
            pd.O000000o(byteArrayOutputStream);
            throw th;
        }
    }
}
