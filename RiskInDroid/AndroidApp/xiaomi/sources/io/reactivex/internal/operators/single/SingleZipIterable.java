package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.single.SingleMap;
import io.reactivex.internal.operators.single.SingleZipArray;
import java.util.Arrays;
import java.util.NoSuchElementException;

public final class SingleZipIterable<T, R> extends Single<R> {
    final Iterable<? extends SingleSource<? extends T>> sources;
    final Function<? super Object[], ? extends R> zipper;

    public SingleZipIterable(Iterable<? extends SingleSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        this.sources = iterable;
        this.zipper = function;
    }

    public final void subscribeActual(SingleObserver<? super R> singleObserver) {
        SingleSource[] singleSourceArr = new SingleSource[8];
        try {
            SingleSource[] singleSourceArr2 = singleSourceArr;
            int i = 0;
            for (SingleSource singleSource : this.sources) {
                if (singleSource == null) {
                    EmptyDisposable.error(new NullPointerException("One of the sources is null"), singleObserver);
                    return;
                }
                if (i == singleSourceArr2.length) {
                    singleSourceArr2 = (SingleSource[]) Arrays.copyOf(singleSourceArr2, (i >> 2) + i);
                }
                int i2 = i + 1;
                singleSourceArr2[i] = singleSource;
                i = i2;
            }
            if (i == 0) {
                EmptyDisposable.error(new NoSuchElementException(), singleObserver);
            } else if (i == 1) {
                singleSourceArr2[0].subscribe(new SingleMap.MapSingleObserver(singleObserver, new SingletonArrayFunc()));
            } else {
                SingleZipArray.ZipCoordinator zipCoordinator = new SingleZipArray.ZipCoordinator(singleObserver, i, this.zipper);
                singleObserver.onSubscribe(zipCoordinator);
                for (int i3 = 0; i3 < i && !zipCoordinator.isDisposed(); i3++) {
                    singleSourceArr2[i3].subscribe(zipCoordinator.observers[i3]);
                }
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, singleObserver);
        }
    }

    final class SingletonArrayFunc implements Function<T, R> {
        SingletonArrayFunc() {
        }

        public final R apply(T t) throws Exception {
            return ObjectHelper.requireNonNull(SingleZipIterable.this.zipper.apply(new Object[]{t}), "The zipper returned a null value");
        }
    }
}
