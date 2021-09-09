package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessorRunner;
import java.util.Map;
import java.util.concurrent.Executor;

public class PostprocessorProducer implements Producer<CloseableReference<CloseableImage>> {
    public final PlatformBitmapFactory mBitmapFactory;
    public final Executor mExecutor;
    private final Producer<CloseableReference<CloseableImage>> mInputProducer;

    public PostprocessorProducer(Producer<CloseableReference<CloseableImage>> producer, PlatformBitmapFactory platformBitmapFactory, Executor executor) {
        this.mInputProducer = (Producer) Preconditions.checkNotNull(producer);
        this.mBitmapFactory = platformBitmapFactory;
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: com.facebook.imagepipeline.producers.PostprocessorProducer$SingleUsePostprocessorConsumer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: com.facebook.imagepipeline.producers.PostprocessorProducer$RepeatedPostprocessorConsumer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.facebook.imagepipeline.producers.PostprocessorProducer$RepeatedPostprocessorConsumer} */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.facebook.imagepipeline.producers.Consumer] */
    /* JADX WARNING: Multi-variable type inference failed */
    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        RepeatedPostprocessorConsumer repeatedPostprocessorConsumer;
        ProducerListener listener = producerContext.getListener();
        Postprocessor postprocessor = producerContext.getImageRequest().getPostprocessor();
        PostprocessorConsumer postprocessorConsumer = new PostprocessorConsumer(consumer, listener, producerContext.getId(), postprocessor, producerContext);
        if (postprocessor instanceof RepeatedPostprocessor) {
            repeatedPostprocessorConsumer = new RepeatedPostprocessorConsumer(postprocessorConsumer, (RepeatedPostprocessor) postprocessor, producerContext);
        } else {
            repeatedPostprocessorConsumer = new SingleUsePostprocessorConsumer(postprocessorConsumer);
        }
        this.mInputProducer.produceResults(repeatedPostprocessorConsumer, producerContext);
    }

    class PostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        private boolean mIsClosed;
        public boolean mIsDirty = false;
        private boolean mIsPostProcessingRunning = false;
        private final ProducerListener mListener;
        private final Postprocessor mPostprocessor;
        private final String mRequestId;
        public CloseableReference<CloseableImage> mSourceImageRef = null;
        public int mStatus = 0;

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onNewResultImpl(Object obj, int i) {
            onNewResultImpl((CloseableReference<CloseableImage>) ((CloseableReference) obj), i);
        }

        public PostprocessorConsumer(Consumer<CloseableReference<CloseableImage>> consumer, ProducerListener producerListener, String str, Postprocessor postprocessor, ProducerContext producerContext) {
            super(consumer);
            this.mListener = producerListener;
            this.mRequestId = str;
            this.mPostprocessor = postprocessor;
            producerContext.addCallbacks(new BaseProducerContextCallbacks(PostprocessorProducer.this) {
                /* class com.facebook.imagepipeline.producers.PostprocessorProducer.PostprocessorConsumer.AnonymousClass1 */

                public void onCancellationRequested() {
                    PostprocessorConsumer.this.maybeNotifyOnCancellation();
                }
            });
        }

        /* access modifiers changed from: protected */
        public void onNewResultImpl(CloseableReference<CloseableImage> closeableReference, int i) {
            if (CloseableReference.isValid(closeableReference)) {
                updateSourceImageRef(closeableReference, i);
            } else if (isLast(i)) {
                maybeNotifyOnNewResult(null, i);
            }
        }

        /* access modifiers changed from: protected */
        public void onFailureImpl(Throwable th) {
            maybeNotifyOnFailure(th);
        }

        /* access modifiers changed from: protected */
        public void onCancellationImpl() {
            maybeNotifyOnCancellation();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
            submitPostprocessing();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
            com.facebook.common.references.CloseableReference.closeSafely(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
            if (r2 == false) goto L_?;
         */
        private void updateSourceImageRef(CloseableReference<CloseableImage> closeableReference, int i) {
            synchronized (this) {
                if (!this.mIsClosed) {
                    CloseableReference<CloseableImage> closeableReference2 = this.mSourceImageRef;
                    this.mSourceImageRef = CloseableReference.cloneOrNull(closeableReference);
                    this.mStatus = i;
                    this.mIsDirty = true;
                    boolean runningIfDirtyAndNotRunning = setRunningIfDirtyAndNotRunning();
                }
            }
        }

        private void submitPostprocessing() {
            PostprocessorProducer.this.mExecutor.execute(new Runnable() {
                /* class com.facebook.imagepipeline.producers.PostprocessorProducer.PostprocessorConsumer.AnonymousClass2 */

                public void run() {
                    CloseableReference<CloseableImage> closeableReference;
                    int i;
                    synchronized (PostprocessorConsumer.this) {
                        closeableReference = PostprocessorConsumer.this.mSourceImageRef;
                        i = PostprocessorConsumer.this.mStatus;
                        PostprocessorConsumer.this.mSourceImageRef = null;
                        PostprocessorConsumer.this.mIsDirty = false;
                    }
                    if (CloseableReference.isValid(closeableReference)) {
                        try {
                            PostprocessorConsumer.this.doPostprocessing(closeableReference, i);
                        } finally {
                            CloseableReference.closeSafely(closeableReference);
                        }
                    }
                    PostprocessorConsumer.this.clearRunningAndStartIfDirty();
                }
            });
        }

        public void clearRunningAndStartIfDirty() {
            boolean runningIfDirtyAndNotRunning;
            synchronized (this) {
                this.mIsPostProcessingRunning = false;
                runningIfDirtyAndNotRunning = setRunningIfDirtyAndNotRunning();
            }
            if (runningIfDirtyAndNotRunning) {
                submitPostprocessing();
            }
        }

        private synchronized boolean setRunningIfDirtyAndNotRunning() {
            if (this.mIsClosed || !this.mIsDirty || this.mIsPostProcessingRunning || !CloseableReference.isValid(this.mSourceImageRef)) {
                return false;
            }
            this.mIsPostProcessingRunning = true;
            return true;
        }

        public void doPostprocessing(CloseableReference<CloseableImage> closeableReference, int i) {
            Preconditions.checkArgument(CloseableReference.isValid(closeableReference));
            if (!shouldPostprocess(closeableReference.get())) {
                maybeNotifyOnNewResult(closeableReference, i);
                return;
            }
            this.mListener.onProducerStart(this.mRequestId, "PostprocessorProducer");
            CloseableReference<CloseableImage> closeableReference2 = null;
            try {
                closeableReference2 = postprocessInternal(closeableReference.get());
                this.mListener.onProducerFinishWithSuccess(this.mRequestId, "PostprocessorProducer", getExtraMap(this.mListener, this.mRequestId, this.mPostprocessor));
                maybeNotifyOnNewResult(closeableReference2, i);
            } catch (Exception e) {
                this.mListener.onProducerFinishWithFailure(this.mRequestId, "PostprocessorProducer", e, getExtraMap(this.mListener, this.mRequestId, this.mPostprocessor));
                maybeNotifyOnFailure(e);
            } finally {
                CloseableReference.closeSafely(closeableReference2);
            }
        }

        private Map<String, String> getExtraMap(ProducerListener producerListener, String str, Postprocessor postprocessor) {
            if (!producerListener.requiresExtraMap(str)) {
                return null;
            }
            return ImmutableMap.of("Postprocessor", postprocessor.getName());
        }

        private boolean shouldPostprocess(CloseableImage closeableImage) {
            return closeableImage instanceof CloseableStaticBitmap;
        }

        private CloseableReference<CloseableImage> postprocessInternal(CloseableImage closeableImage) {
            CloseableStaticBitmap closeableStaticBitmap = (CloseableStaticBitmap) closeableImage;
            CloseableReference<Bitmap> process = this.mPostprocessor.process(closeableStaticBitmap.getUnderlyingBitmap(), PostprocessorProducer.this.mBitmapFactory);
            try {
                return CloseableReference.of(new CloseableStaticBitmap(process, closeableImage.getQualityInfo(), closeableStaticBitmap.getRotationAngle(), closeableStaticBitmap.getExifOrientation()));
            } finally {
                CloseableReference.closeSafely(process);
            }
        }

        private void maybeNotifyOnNewResult(CloseableReference<CloseableImage> closeableReference, int i) {
            boolean isLast = isLast(i);
            if ((!isLast && !isClosed()) || (isLast && close())) {
                getConsumer().onNewResult(closeableReference, i);
            }
        }

        private void maybeNotifyOnFailure(Throwable th) {
            if (close()) {
                getConsumer().onFailure(th);
            }
        }

        public void maybeNotifyOnCancellation() {
            if (close()) {
                getConsumer().onCancellation();
            }
        }

        private synchronized boolean isClosed() {
            return this.mIsClosed;
        }

        private boolean close() {
            synchronized (this) {
                if (this.mIsClosed) {
                    return false;
                }
                CloseableReference<CloseableImage> closeableReference = this.mSourceImageRef;
                this.mSourceImageRef = null;
                this.mIsClosed = true;
                CloseableReference.closeSafely(closeableReference);
                return true;
            }
        }
    }

    class SingleUsePostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onNewResultImpl(Object obj, int i) {
            onNewResultImpl((CloseableReference<CloseableImage>) ((CloseableReference) obj), i);
        }

        private SingleUsePostprocessorConsumer(PostprocessorConsumer postprocessorConsumer) {
            super(postprocessorConsumer);
        }

        /* access modifiers changed from: protected */
        public void onNewResultImpl(CloseableReference<CloseableImage> closeableReference, int i) {
            if (!isNotLast(i)) {
                getConsumer().onNewResult(closeableReference, i);
            }
        }
    }

    class RepeatedPostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> implements RepeatedPostprocessorRunner {
        private boolean mIsClosed;
        private CloseableReference<CloseableImage> mSourceImageRef;

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onNewResultImpl(Object obj, int i) {
            onNewResultImpl((CloseableReference<CloseableImage>) ((CloseableReference) obj), i);
        }

        private RepeatedPostprocessorConsumer(PostprocessorConsumer postprocessorConsumer, RepeatedPostprocessor repeatedPostprocessor, ProducerContext producerContext) {
            super(postprocessorConsumer);
            this.mIsClosed = false;
            this.mSourceImageRef = null;
            repeatedPostprocessor.setCallback(this);
            producerContext.addCallbacks(new BaseProducerContextCallbacks(PostprocessorProducer.this) {
                /* class com.facebook.imagepipeline.producers.PostprocessorProducer.RepeatedPostprocessorConsumer.AnonymousClass1 */

                public void onCancellationRequested() {
                    if (RepeatedPostprocessorConsumer.this.close()) {
                        RepeatedPostprocessorConsumer.this.getConsumer().onCancellation();
                    }
                }
            });
        }

        /* access modifiers changed from: protected */
        public void onNewResultImpl(CloseableReference<CloseableImage> closeableReference, int i) {
            if (!isNotLast(i)) {
                setSourceImageRef(closeableReference);
                updateInternal();
            }
        }

        /* access modifiers changed from: protected */
        public void onFailureImpl(Throwable th) {
            if (close()) {
                getConsumer().onFailure(th);
            }
        }

        /* access modifiers changed from: protected */
        public void onCancellationImpl() {
            if (close()) {
                getConsumer().onCancellation();
            }
        }

        public synchronized void update() {
            updateInternal();
        }

        private void updateInternal() {
            synchronized (this) {
                if (!this.mIsClosed) {
                    CloseableReference cloneOrNull = CloseableReference.cloneOrNull(this.mSourceImageRef);
                    try {
                        getConsumer().onNewResult(cloneOrNull, 0);
                    } finally {
                        CloseableReference.closeSafely(cloneOrNull);
                    }
                }
            }
        }

        private void setSourceImageRef(CloseableReference<CloseableImage> closeableReference) {
            synchronized (this) {
                if (!this.mIsClosed) {
                    CloseableReference<CloseableImage> closeableReference2 = this.mSourceImageRef;
                    this.mSourceImageRef = CloseableReference.cloneOrNull(closeableReference);
                    CloseableReference.closeSafely(closeableReference2);
                }
            }
        }

        public boolean close() {
            synchronized (this) {
                if (this.mIsClosed) {
                    return false;
                }
                CloseableReference<CloseableImage> closeableReference = this.mSourceImageRef;
                this.mSourceImageRef = null;
                this.mIsClosed = true;
                CloseableReference.closeSafely(closeableReference);
                return true;
            }
        }
    }
}
