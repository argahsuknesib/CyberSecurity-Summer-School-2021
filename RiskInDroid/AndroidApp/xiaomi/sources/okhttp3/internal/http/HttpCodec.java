package okhttp3.internal.http;

import _m_j.jbm;
import java.io.IOException;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public interface HttpCodec {
    void cancel();

    jbm createRequestBody(Request request, long j);

    void finishRequest() throws IOException;

    void flushRequest() throws IOException;

    ResponseBody openResponseBody(Response response) throws IOException;

    Response.Builder readResponseHeaders(boolean z) throws IOException;

    void writeRequestHeaders(Request request) throws IOException;
}
