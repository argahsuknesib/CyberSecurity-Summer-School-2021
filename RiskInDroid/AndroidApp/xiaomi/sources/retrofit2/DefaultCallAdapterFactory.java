package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import retrofit2.CallAdapter;

final class DefaultCallAdapterFactory extends CallAdapter.Factory {
    static final CallAdapter.Factory INSTANCE = new DefaultCallAdapterFactory();

    DefaultCallAdapterFactory() {
    }

    public final CallAdapter<?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (getRawType(type) != Call.class) {
            return null;
        }
        final Type callResponseType = Utils.getCallResponseType(type);
        return new CallAdapter<Call<?>>() {
            /* class retrofit2.DefaultCallAdapterFactory.AnonymousClass1 */

            public <R> Call<R> adapt(Call<R> call) {
                return call;
            }

            public Type responseType() {
                return callResponseType;
            }
        };
    }
}
