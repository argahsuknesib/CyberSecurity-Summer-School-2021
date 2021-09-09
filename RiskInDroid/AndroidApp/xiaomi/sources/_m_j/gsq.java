package _m_j;

import okhttp3.Response;

public final class gsq extends gsp<String> {
    public final /* synthetic */ Object O000000o(Response response) throws Exception {
        return O00000Oo(response);
    }

    private static String O00000Oo(Response response) throws Exception {
        if (response.isSuccessful()) {
            try {
                return response.body().string();
            } catch (Exception e) {
                throw e;
            }
        } else {
            throw new RuntimeException("failure code:" + response.code());
        }
    }
}
