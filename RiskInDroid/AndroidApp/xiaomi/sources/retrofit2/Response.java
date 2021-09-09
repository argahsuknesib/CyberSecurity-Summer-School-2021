package retrofit2;

import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public final class Response<T> {
    private final T body;
    private final ResponseBody errorBody;
    private final okhttp3.Response rawResponse;

    public static <T> Response<T> success(T t) {
        return success(t, new Response.Builder().code(200).message("OK").protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
    }

    public static <T> Response<T> success(T t, Headers headers) {
        if (headers != null) {
            return success(t, new Response.Builder().code(200).message("OK").protocol(Protocol.HTTP_1_1).headers(headers).request(new Request.Builder().url("http://localhost/").build()).build());
        }
        throw new NullPointerException("headers == null");
    }

    public static <T> Response<T> success(T t, okhttp3.Response response) {
        if (response == null) {
            throw new NullPointerException("rawResponse == null");
        } else if (response.isSuccessful()) {
            return new Response<>(response, t, null);
        } else {
            throw new IllegalArgumentException("rawResponse must be successful response");
        }
    }

    public static <T> Response<T> error(int i, ResponseBody responseBody) {
        if (i >= 400) {
            return error(responseBody, new Response.Builder().code(i).protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
        }
        throw new IllegalArgumentException("code < 400: ".concat(String.valueOf(i)));
    }

    public static <T> Response<T> error(ResponseBody responseBody, okhttp3.Response response) {
        if (responseBody == null) {
            throw new NullPointerException("body == null");
        } else if (response == null) {
            throw new NullPointerException("rawResponse == null");
        } else if (!response.isSuccessful()) {
            return new Response<>(response, null, responseBody);
        } else {
            throw new IllegalArgumentException("rawResponse should not be successful response");
        }
    }

    private Response(okhttp3.Response response, T t, ResponseBody responseBody) {
        this.rawResponse = response;
        this.body = t;
        this.errorBody = responseBody;
    }

    public final okhttp3.Response raw() {
        return this.rawResponse;
    }

    public final int code() {
        return this.rawResponse.code();
    }

    public final String message() {
        return this.rawResponse.message();
    }

    public final Headers headers() {
        return this.rawResponse.headers();
    }

    public final boolean isSuccessful() {
        return this.rawResponse.isSuccessful();
    }

    public final T body() {
        return this.body;
    }

    public final ResponseBody errorBody() {
        return this.errorBody;
    }
}
