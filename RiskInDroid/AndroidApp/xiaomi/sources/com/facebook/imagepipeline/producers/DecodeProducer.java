package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.ExceptionWithNoStacktrace;
import com.facebook.common.util.UriUtil;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.decoder.DecodeException;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegParser;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.producers.JobScheduler;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public class DecodeProducer implements Producer<CloseableReference<CloseableImage>> {
    private final ByteArrayPool mByteArrayPool;
    private final boolean mDecodeCancellationEnabled;
    public final boolean mDownsampleEnabled;
    public final boolean mDownsampleEnabledForNetwork;
    public final Executor mExecutor;
    public final Supplier<Boolean> mExperimentalSmartResizingEnabled;
    public final ImageDecoder mImageDecoder;
    private final Producer<EncodedImage> mInputProducer;
    private final ProgressiveJpegConfig mProgressiveJpegConfig;

    public DecodeProducer(ByteArrayPool byteArrayPool, Executor executor, ImageDecoder imageDecoder, ProgressiveJpegConfig progressiveJpegConfig, boolean z, boolean z2, boolean z3, Producer<EncodedImage> producer, Supplier<Boolean> supplier) {
        this.mByteArrayPool = (ByteArrayPool) Preconditions.checkNotNull(byteArrayPool);
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
        this.mImageDecoder = (ImageDecoder) Preconditions.checkNotNull(imageDecoder);
        this.mProgressiveJpegConfig = (ProgressiveJpegConfig) Preconditions.checkNotNull(progressiveJpegConfig);
        this.mDownsampleEnabled = z;
        this.mDownsampleEnabledForNetwork = z2;
        this.mInputProducer = (Producer) Preconditions.checkNotNull(producer);
        this.mDecodeCancellationEnabled = z3;
        this.mExperimentalSmartResizingEnabled = supplier;
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.facebook.imagepipeline.producers.DecodeProducer$LocalImagesProgressiveDecoder] */
    /* JADX WARNING: Multi-variable type inference failed */
    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        NetworkImagesProgressiveDecoder networkImagesProgressiveDecoder;
        if (!UriUtil.isNetworkUri(producerContext.getImageRequest().getSourceUri())) {
            networkImagesProgressiveDecoder = new LocalImagesProgressiveDecoder(consumer, producerContext, this.mDecodeCancellationEnabled);
        } else {
            networkImagesProgressiveDecoder = new NetworkImagesProgressiveDecoder(consumer, producerContext, new ProgressiveJpegParser(this.mByteArrayPool), this.mProgressiveJpegConfig, this.mDecodeCancellationEnabled);
        }
        this.mInputProducer.produceResults(networkImagesProgressiveDecoder, producerContext);
    }

    abstract class ProgressiveDecoder extends DelegatingConsumer<EncodedImage, CloseableReference<CloseableImage>> {
        private final String TAG = "ProgressiveDecoder";
        private final ImageDecodeOptions mImageDecodeOptions;
        private boolean mIsFinished;
        public final JobScheduler mJobScheduler;
        public final ProducerContext mProducerContext;
        private final ProducerListener mProducerListener;

        /* access modifiers changed from: protected */
        public abstract int getIntermediateImageEndOffset(EncodedImage encodedImage);

        /* access modifiers changed from: protected */
        public abstract QualityInfo getQualityInfo();

        public ProgressiveDecoder(Consumer<CloseableReference<CloseableImage>> consumer, final ProducerContext producerContext, final boolean z) {
            super(consumer);
            this.mProducerContext = producerContext;
            this.mProducerListener = producerContext.getListener();
            this.mImageDecodeOptions = producerContext.getImageRequest().getImageDecodeOptions();
            this.mIsFinished = false;
            this.mJobScheduler = new JobScheduler(DecodeProducer.this.mExecutor, new JobScheduler.JobRunnable(DecodeProducer.this) {
                /* class com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder.AnonymousClass1 */

                public void run(EncodedImage encodedImage, int i) {
                    if (encodedImage != null) {
                        if (DecodeProducer.this.mDownsampleEnabled || (DecodeProducer.this.mExperimentalSmartResizingEnabled.get().booleanValue() && !BaseConsumer.statusHasFlag(i, 16))) {
                            ImageRequest imageRequest = producerContext.getImageRequest();
                            if (DecodeProducer.this.mDownsampleEnabledForNetwork || !UriUtil.isNetworkUri(imageRequest.getSourceUri())) {
                                encodedImage.setSampleSize(DownsampleUtil.determineSampleSize(imageRequest, encodedImage));
                            }
                        }
                        ProgressiveDecoder.this.doDecode(encodedImage, i);
                    }
                }
            }, this.mImageDecodeOptions.minDecodeIntervalMs);
            this.mProducerContext.addCallbacks(new BaseProducerContextCallbacks(DecodeProducer.this) {
                /* class com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder.AnonymousClass2 */

                public void onIsIntermediateResultExpectedChanged() {
                    if (ProgressiveDecoder.this.mProducerContext.isIntermediateResultExpected()) {
                        ProgressiveDecoder.this.mJobScheduler.scheduleJob();
                    }
                }

                public void onCancellationRequested() {
                    if (z) {
                        ProgressiveDecoder.this.handleCancellation();
                    }
                }
            });
        }

        public void onNewResultImpl(EncodedImage encodedImage, int i) {
            boolean isLast = isLast(i);
            if (isLast && !EncodedImage.isValid(encodedImage)) {
                handleError(new ExceptionWithNoStacktrace("Encoded image is not valid."));
            } else if (updateDecodeJob(encodedImage, i)) {
                boolean statusHasFlag = statusHasFlag(i, 4);
                if (isLast || statusHasFlag || this.mProducerContext.isIntermediateResultExpected()) {
                    this.mJobScheduler.scheduleJob();
                }
            }
        }

        /* access modifiers changed from: protected */
        public void onProgressUpdateImpl(float f) {
            super.onProgressUpdateImpl(f * 0.99f);
        }

        public void onFailureImpl(Throwable th) {
            handleError(th);
        }

        public void onCancellationImpl() {
            handleCancellation();
        }

        /* access modifiers changed from: protected */
        public boolean updateDecodeJob(EncodedImage encodedImage, int i) {
            return this.mJobScheduler.updateJob(encodedImage, i);
        }

        /* JADX WARNING: Removed duplicated region for block: B:31:0x00b3 A[Catch:{ all -> 0x0146 }] */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x00db  */
        public void doDecode(EncodedImage encodedImage, int i) {
            int i2;
            QualityInfo qualityInfo;
            CloseableImage closeableImage;
            CloseableImage decode;
            int i3 = i;
            if ((encodedImage.getImageFormat() == DefaultImageFormats.JPEG || !isNotLast(i)) && !isFinished() && EncodedImage.isValid(encodedImage)) {
                ImageFormat imageFormat = encodedImage.getImageFormat();
                String str = "unknown";
                String name = imageFormat != null ? imageFormat.getName() : str;
                String str2 = encodedImage.getWidth() + "x" + encodedImage.getHeight();
                String valueOf = String.valueOf(encodedImage.getSampleSize());
                boolean isLast = isLast(i);
                boolean z = isLast && !statusHasFlag(i3, 8);
                boolean statusHasFlag = statusHasFlag(i3, 4);
                ResizeOptions resizeOptions = this.mProducerContext.getImageRequest().getResizeOptions();
                if (resizeOptions != null) {
                    str = resizeOptions.width + "x" + resizeOptions.height;
                }
                String str3 = str;
                try {
                    long queuedTime = this.mJobScheduler.getQueuedTime();
                    String valueOf2 = String.valueOf(this.mProducerContext.getImageRequest().getSourceUri());
                    if (!z) {
                        if (!statusHasFlag) {
                            i2 = getIntermediateImageEndOffset(encodedImage);
                            if (!z) {
                                if (!statusHasFlag) {
                                    qualityInfo = getQualityInfo();
                                    this.mProducerListener.onProducerStart(this.mProducerContext.getId(), "DecodeProducer");
                                    decode = DecodeProducer.this.mImageDecoder.decode(encodedImage, i2, qualityInfo, this.mImageDecodeOptions);
                                    if (encodedImage.getSampleSize() != 1) {
                                        i3 |= 16;
                                    }
                                    this.mProducerListener.onProducerFinishWithSuccess(this.mProducerContext.getId(), "DecodeProducer", getExtraMap(decode, queuedTime, qualityInfo, isLast, name, str2, str3, valueOf));
                                    handleResult(decode, i3);
                                }
                            }
                            qualityInfo = ImmutableQualityInfo.FULL_QUALITY;
                            this.mProducerListener.onProducerStart(this.mProducerContext.getId(), "DecodeProducer");
                            decode = DecodeProducer.this.mImageDecoder.decode(encodedImage, i2, qualityInfo, this.mImageDecodeOptions);
                            try {
                                if (encodedImage.getSampleSize() != 1) {
                                }
                                this.mProducerListener.onProducerFinishWithSuccess(this.mProducerContext.getId(), "DecodeProducer", getExtraMap(decode, queuedTime, qualityInfo, isLast, name, str2, str3, valueOf));
                                handleResult(decode, i3);
                            } catch (Exception e) {
                                e = e;
                                closeableImage = decode;
                                this.mProducerListener.onProducerFinishWithFailure(this.mProducerContext.getId(), "DecodeProducer", e, getExtraMap(closeableImage, queuedTime, qualityInfo, isLast, name, str2, str3, valueOf));
                                handleError(e);
                                EncodedImage.closeSafely(encodedImage);
                            }
                        }
                    }
                    i2 = encodedImage.getSize();
                    if (!z) {
                    }
                    qualityInfo = ImmutableQualityInfo.FULL_QUALITY;
                    this.mProducerListener.onProducerStart(this.mProducerContext.getId(), "DecodeProducer");
                    try {
                        decode = DecodeProducer.this.mImageDecoder.decode(encodedImage, i2, qualityInfo, this.mImageDecodeOptions);
                        if (encodedImage.getSampleSize() != 1) {
                        }
                        this.mProducerListener.onProducerFinishWithSuccess(this.mProducerContext.getId(), "DecodeProducer", getExtraMap(decode, queuedTime, qualityInfo, isLast, name, str2, str3, valueOf));
                        handleResult(decode, i3);
                    } catch (DecodeException e2) {
                        EncodedImage encodedImage2 = e2.getEncodedImage();
                        FLog.w("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e2.getMessage(), valueOf2, encodedImage2.getFirstBytesAsHexString(10), Integer.valueOf(encodedImage2.getSize()));
                        throw e2;
                    } catch (Exception e3) {
                        e = e3;
                        closeableImage = null;
                        this.mProducerListener.onProducerFinishWithFailure(this.mProducerContext.getId(), "DecodeProducer", e, getExtraMap(closeableImage, queuedTime, qualityInfo, isLast, name, str2, str3, valueOf));
                        handleError(e);
                        EncodedImage.closeSafely(encodedImage);
                    }
                } finally {
                    EncodedImage.closeSafely(encodedImage);
                }
            }
        }

        private Map<String, String> getExtraMap(CloseableImage closeableImage, long j, QualityInfo qualityInfo, boolean z, String str, String str2, String str3, String str4) {
            CloseableImage closeableImage2 = closeableImage;
            String str5 = str;
            String str6 = str2;
            String str7 = str3;
            String str8 = str4;
            if (!this.mProducerListener.requiresExtraMap(this.mProducerContext.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(qualityInfo.isOfGoodEnoughQuality());
            String valueOf3 = String.valueOf(z);
            if (closeableImage2 instanceof CloseableStaticBitmap) {
                Bitmap underlyingBitmap = ((CloseableStaticBitmap) closeableImage2).getUnderlyingBitmap();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", underlyingBitmap.getWidth() + "x" + underlyingBitmap.getHeight());
                hashMap.put("queueTime", valueOf);
                hashMap.put("hasGoodQuality", valueOf2);
                hashMap.put("isFinal", valueOf3);
                hashMap.put("encodedImageSize", str6);
                hashMap.put("imageFormat", str5);
                hashMap.put("requestedImageSize", str7);
                hashMap.put("sampleSize", str4);
                return ImmutableMap.copyOf(hashMap);
            }
            String str9 = str8;
            HashMap hashMap2 = new HashMap(7);
            hashMap2.put("queueTime", valueOf);
            hashMap2.put("hasGoodQuality", valueOf2);
            hashMap2.put("isFinal", valueOf3);
            hashMap2.put("encodedImageSize", str6);
            hashMap2.put("imageFormat", str5);
            hashMap2.put("requestedImageSize", str7);
            hashMap2.put("sampleSize", str9);
            return ImmutableMap.copyOf(hashMap2);
        }

        private synchronized boolean isFinished() {
            return this.mIsFinished;
        }

        private void maybeFinish(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.mIsFinished) {
                        getConsumer().onProgressUpdate(1.0f);
                        this.mIsFinished = true;
                        this.mJobScheduler.clearJob();
                    }
                }
            }
        }

        private void handleResult(CloseableImage closeableImage, int i) {
            CloseableReference of = CloseableReference.of(closeableImage);
            try {
                maybeFinish(isLast(i));
                getConsumer().onNewResult(of, i);
            } finally {
                CloseableReference.closeSafely(of);
            }
        }

        private void handleError(Throwable th) {
            maybeFinish(true);
            getConsumer().onFailure(th);
        }

        public void handleCancellation() {
            maybeFinish(true);
            getConsumer().onCancellation();
        }
    }

    class LocalImagesProgressiveDecoder extends ProgressiveDecoder {
        public LocalImagesProgressiveDecoder(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext, boolean z) {
            super(consumer, producerContext, z);
        }

        /* access modifiers changed from: protected */
        public synchronized boolean updateDecodeJob(EncodedImage encodedImage, int i) {
            if (isNotLast(i)) {
                return false;
            }
            return super.updateDecodeJob(encodedImage, i);
        }

        /* access modifiers changed from: protected */
        public int getIntermediateImageEndOffset(EncodedImage encodedImage) {
            return encodedImage.getSize();
        }

        /* access modifiers changed from: protected */
        public QualityInfo getQualityInfo() {
            return ImmutableQualityInfo.of(0, false, false);
        }
    }

    class NetworkImagesProgressiveDecoder extends ProgressiveDecoder {
        private int mLastScheduledScanNumber = 0;
        private final ProgressiveJpegConfig mProgressiveJpegConfig;
        private final ProgressiveJpegParser mProgressiveJpegParser;

        public NetworkImagesProgressiveDecoder(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext, ProgressiveJpegParser progressiveJpegParser, ProgressiveJpegConfig progressiveJpegConfig, boolean z) {
            super(consumer, producerContext, z);
            this.mProgressiveJpegParser = (ProgressiveJpegParser) Preconditions.checkNotNull(progressiveJpegParser);
            this.mProgressiveJpegConfig = (ProgressiveJpegConfig) Preconditions.checkNotNull(progressiveJpegConfig);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0056, code lost:
            return r0;
         */
        public synchronized boolean updateDecodeJob(EncodedImage encodedImage, int i) {
            boolean updateDecodeJob = super.updateDecodeJob(encodedImage, i);
            if ((isNotLast(i) || statusHasFlag(i, 8)) && !statusHasFlag(i, 4) && EncodedImage.isValid(encodedImage) && encodedImage.getImageFormat() == DefaultImageFormats.JPEG) {
                if (!this.mProgressiveJpegParser.parseMoreData(encodedImage)) {
                    return false;
                }
                int bestScanNumber = this.mProgressiveJpegParser.getBestScanNumber();
                if (bestScanNumber <= this.mLastScheduledScanNumber) {
                    return false;
                }
                if (bestScanNumber < this.mProgressiveJpegConfig.getNextScanNumberToDecode(this.mLastScheduledScanNumber) && !this.mProgressiveJpegParser.isEndMarkerRead()) {
                    return false;
                }
                this.mLastScheduledScanNumber = bestScanNumber;
            }
        }

        /* access modifiers changed from: protected */
        public int getIntermediateImageEndOffset(EncodedImage encodedImage) {
            return this.mProgressiveJpegParser.getBestScanEndOffset();
        }

        /* access modifiers changed from: protected */
        public QualityInfo getQualityInfo() {
            return this.mProgressiveJpegConfig.getQualityInfo(this.mProgressiveJpegParser.getBestScanNumber());
        }
    }
}
