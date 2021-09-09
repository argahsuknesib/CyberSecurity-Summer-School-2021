package com.alipay.android.phone.mrpc.core;

import com.google.android.exoplayer2.C;
import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

public final class j extends a {
    private g g;

    public j(g gVar, Method method, int i, String str, byte[] bArr, boolean z) {
        super(method, i, str, bArr, "application/x-www-form-urlencoded", z);
        this.g = gVar;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.alipay.android.phone.mrpc.core.RpcException.<init>(java.lang.Integer, java.lang.String):void
     arg types: [int, java.lang.String]
     candidates:
      com.alipay.android.phone.mrpc.core.RpcException.<init>(java.lang.Integer, java.lang.Throwable):void
      com.alipay.android.phone.mrpc.core.RpcException.<init>(java.lang.Integer, java.lang.String):void */
    public final Object a() {
        o oVar = new o(this.g.a());
        oVar.a(this.b);
        oVar.a(this.e);
        oVar.a(this.f);
        oVar.a("id", String.valueOf(this.d));
        oVar.a("operationType", this.c);
        oVar.a("gzip", String.valueOf(this.g.d()));
        oVar.a((Header) new BasicHeader("uuid", UUID.randomUUID().toString()));
        List<Header> b = this.g.c().b();
        if (b != null && !b.isEmpty()) {
            for (Header a2 : b) {
                oVar.a(a2);
            }
        }
        StringBuilder sb = new StringBuilder("threadid = ");
        sb.append(Thread.currentThread().getId());
        sb.append("; ");
        sb.append(oVar.toString());
        try {
            u uVar = this.g.b().a(oVar).get();
            if (uVar != null) {
                return uVar.b();
            }
            throw new RpcException((Integer) 9, "response is null");
        } catch (InterruptedException e) {
            throw new RpcException(13, "", e);
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause == null || !(cause instanceof HttpException)) {
                throw new RpcException(9, "", e2);
            }
            HttpException httpException = (HttpException) cause;
            int code = httpException.getCode();
            switch (code) {
                case 1:
                    code = 2;
                    throw new RpcException(Integer.valueOf(code), httpException.getMsg());
                case 2:
                    code = 3;
                    throw new RpcException(Integer.valueOf(code), httpException.getMsg());
                case 3:
                    code = 4;
                    throw new RpcException(Integer.valueOf(code), httpException.getMsg());
                case 4:
                    code = 5;
                    throw new RpcException(Integer.valueOf(code), httpException.getMsg());
                case 5:
                    code = 6;
                    throw new RpcException(Integer.valueOf(code), httpException.getMsg());
                case 6:
                    code = 7;
                    throw new RpcException(Integer.valueOf(code), httpException.getMsg());
                case 7:
                    code = 8;
                    throw new RpcException(Integer.valueOf(code), httpException.getMsg());
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                    code = 15;
                    throw new RpcException(Integer.valueOf(code), httpException.getMsg());
                case 9:
                    code = 16;
                    throw new RpcException(Integer.valueOf(code), httpException.getMsg());
                default:
                    throw new RpcException(Integer.valueOf(code), httpException.getMsg());
            }
            throw new RpcException((Integer) 9, "response is null");
        } catch (CancellationException e3) {
            throw new RpcException(13, "", e3);
        }
    }
}
