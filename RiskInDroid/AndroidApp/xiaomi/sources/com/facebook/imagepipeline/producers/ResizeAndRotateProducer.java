package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.TriState;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.nativecode.JpegTranscoder;
import com.facebook.imagepipeline.producers.JobScheduler;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public class ResizeAndRotateProducer implements Producer<EncodedImage> {
    public static final ImmutableList<Integer> INVERTED_EXIF_ORIENTATIONS = ImmutableList.of(2, 7, 4, 5);
    public final Executor mExecutor;
    private final Producer<EncodedImage> mInputProducer;
    public final PooledByteBufferFactory mPooledByteBufferFactory;
    public final boolean mResizingEnabled;
    public final boolean mUseDownsamplingRatio;

    @VisibleForTesting
    static int roundNumerator(float f, float f2) {
        return (int) (f2 + (f * 8.0f));
    }

    private static boolean shouldResize(int i) {
        return i < 8;
    }

    public ResizeAndRotateProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, boolean z, Producer<EncodedImage> producer, boolean z2) {
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
        this.mPooledByteBufferFactory = (PooledByteBufferFactory) Preconditions.checkNotNull(pooledByteBufferFactory);
        this.mResizingEnabled = z;
        this.mInputProducer = (Producer) Preconditions.checkNotNull(producer);
        this.mUseDownsamplingRatio = z2;
    }

    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        this.mInputProducer.produceResults(new TransformingConsumer(consumer, producerContext), producerContext);
    }

    class TransformingConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        public boolean mIsCancelled = false;
        public final JobScheduler mJobScheduler;
        public final ProducerContext mProducerContext;

        public TransformingConsumer(final Consumer<EncodedImage> consumer, ProducerContext producerContext) {
            super(consumer);
            this.mProducerContext = producerContext;
            this.mJobScheduler = new JobScheduler(ResizeAndRotateProducer.this.mExecutor, new JobScheduler.JobRunnable(ResizeAndRotateProducer.this) {
                /* class com.facebook.imagepipeline.producers.ResizeAndRotateProducer.TransformingConsumer.AnonymousClass1 */

                public void run(EncodedImage encodedImage, int i) {
                    TransformingConsumer.this.doTransform(encodedImage, i);
                }
            }, 100);
            this.mProducerContext.addCallbacks(new BaseProducerContextCallbacks(ResizeAndRotateProducer.this) {
                /* class com.facebook.imagepipeline.producers.ResizeAndRotateProducer.TransformingConsumer.AnonymousClass2 */

                public void onIsIntermediateResultExpectedChanged() {
                    if (TransformingConsumer.this.mProducerContext.isIntermediateResultExpected()) {
                        TransformingConsumer.this.mJobScheduler.scheduleJob();
                    }
                }

                public void onCancellationRequested() {
                    TransformingConsumer.this.mJobScheduler.clearJob();
                    TransformingConsumer.this.mIsCancelled = true;
                    consumer.onCancellation();
                }
            });
        }

        /* access modifiers changed from: protected */
        public void onNewResultImpl(EncodedImage encodedImage, int i) {
            if (!this.mIsCancelled) {
                boolean isLast = isLast(i);
                if (encodedImage != null) {
                    TriState shouldTransform = ResizeAndRotateProducer.shouldTransform(this.mProducerContext.getImageRequest(), encodedImage, ResizeAndRotateProducer.this.mResizingEnabled);
                    if (!isLast && shouldTransform == TriState.UNSET) {
                        return;
                    }
                    if (shouldTransform != TriState.YES) {
                        if (!(this.mProducerContext.getImageRequest().getRotationOptions().canDeferUntilRendered() || encodedImage.getRotationAngle() == 0 || encodedImage.getRotationAngle() == -1)) {
                            encodedImage = moveImage(encodedImage);
                            encodedImage.setRotationAngle(0);
                        }
                        getConsumer().onNewResult(encodedImage, i);
                    } else if (this.mJobScheduler.updateJob(encodedImage, i)) {
                        if (isLast || this.mProducerContext.isIntermediateResultExpected()) {
                            this.mJobScheduler.scheduleJob();
                        }
                    }
                } else if (isLast) {
                    getConsumer().onNewResult(null, 1);
                }
            }
        }

        private EncodedImage moveImage(EncodedImage encodedImage) {
            EncodedImage cloneOrNull = EncodedImage.cloneOrNull(encodedImage);
            encodedImage.close();
            return cloneOrNull;
        }

        /* JADX WARNING: Removed duplicated region for block: B:51:0x00f7 A[Catch:{ all -> 0x00ff }] */
        public void doTransform(EncodedImage encodedImage, int i) {
            InputStream inputStream;
            int i2;
            EncodedImage encodedImage2 = encodedImage;
            this.mProducerContext.getListener().onProducerStart(this.mProducerContext.getId(), "ResizeAndRotateProducer");
            ImageRequest imageRequest = this.mProducerContext.getImageRequest();
            PooledByteBufferOutputStream newOutputStream = ResizeAndRotateProducer.this.mPooledByteBufferFactory.newOutputStream();
            Map<String, String> map = null;
            try {
                int softwareNumerator = ResizeAndRotateProducer.getSoftwareNumerator(imageRequest, encodedImage2, ResizeAndRotateProducer.this.mResizingEnabled);
                int determineSampleSize = DownsampleUtil.determineSampleSize(imageRequest, encodedImage2);
                int calculateDownsampleNumerator = ResizeAndRotateProducer.calculateDownsampleNumerator(determineSampleSize);
                int i3 = ResizeAndRotateProducer.this.mUseDownsamplingRatio ? calculateDownsampleNumerator : softwareNumerator;
                inputStream = encodedImage.getInputStream();
                try {
                    if (ResizeAndRotateProducer.INVERTED_EXIF_ORIENTATIONS.contains(Integer.valueOf(encodedImage.getExifOrientation()))) {
                        map = getExtraMap(encodedImage, imageRequest, i3, calculateDownsampleNumerator, softwareNumerator, 0);
                        JpegTranscoder.transcodeJpegWithExifOrientation(inputStream, newOutputStream, ResizeAndRotateProducer.getForceRotatedInvertedExifOrientation(imageRequest.getRotationOptions(), encodedImage2), i3, 85);
                    } else {
                        int rotationAngle = ResizeAndRotateProducer.getRotationAngle(imageRequest.getRotationOptions(), encodedImage2);
                        map = getExtraMap(encodedImage, imageRequest, i3, calculateDownsampleNumerator, softwareNumerator, rotationAngle);
                        JpegTranscoder.transcodeJpeg(inputStream, newOutputStream, rotationAngle, i3, 85);
                    }
                    CloseableReference of = CloseableReference.of(newOutputStream.toByteBuffer());
                    try {
                        EncodedImage encodedImage3 = new EncodedImage(of);
                        encodedImage3.setImageFormat(DefaultImageFormats.JPEG);
                        try {
                            encodedImage3.parseMetaData();
                            this.mProducerContext.getListener().onProducerFinishWithSuccess(this.mProducerContext.getId(), "ResizeAndRotateProducer", map);
                            i2 = determineSampleSize != 1 ? i | 16 : i;
                            try {
                                getConsumer().onNewResult(encodedImage3, i2);
                            } catch (Throwable th) {
                                th = th;
                                EncodedImage.closeSafely(encodedImage3);
                                throw th;
                            }
                            try {
                                EncodedImage.closeSafely(encodedImage3);
                                try {
                                    CloseableReference.closeSafely(of);
                                } catch (Exception e) {
                                    e = e;
                                    try {
                                        this.mProducerContext.getListener().onProducerFinishWithFailure(this.mProducerContext.getId(), "ResizeAndRotateProducer", e, map);
                                        if (isLast(i2)) {
                                        }
                                        Closeables.closeQuietly(inputStream);
                                        newOutputStream.close();
                                    } catch (Throwable th2) {
                                        th = th2;
                                        Closeables.closeQuietly(inputStream);
                                        newOutputStream.close();
                                        throw th;
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                CloseableReference.closeSafely(of);
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            i2 = i;
                            EncodedImage.closeSafely(encodedImage3);
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        i2 = i;
                        CloseableReference.closeSafely(of);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    i2 = i;
                    this.mProducerContext.getListener().onProducerFinishWithFailure(this.mProducerContext.getId(), "ResizeAndRotateProducer", e, map);
                    if (isLast(i2)) {
                    }
                    Closeables.closeQuietly(inputStream);
                    newOutputStream.close();
                }
            } catch (Exception e3) {
                e = e3;
                i2 = i;
                inputStream = null;
                this.mProducerContext.getListener().onProducerFinishWithFailure(this.mProducerContext.getId(), "ResizeAndRotateProducer", e, map);
                if (isLast(i2)) {
                    getConsumer().onFailure(e);
                }
                Closeables.closeQuietly(inputStream);
                newOutputStream.close();
            } catch (Throwable th6) {
                th = th6;
                inputStream = null;
                Closeables.closeQuietly(inputStream);
                newOutputStream.close();
                throw th;
            }
            Closeables.closeQuietly(inputStream);
            newOutputStream.close();
        }

        private Map<String, String> getExtraMap(EncodedImage encodedImage, ImageRequest imageRequest, int i, int i2, int i3, int i4) {
            String str;
            String str2;
            if (!this.mProducerContext.getListener().requiresExtraMap(this.mProducerContext.getId())) {
                return null;
            }
            String str3 = encodedImage.getWidth() + "x" + encodedImage.getHeight();
            if (imageRequest.getResizeOptions() != null) {
                str = imageRequest.getResizeOptions().width + "x" + imageRequest.getResizeOptions().height;
            } else {
                str = "Unspecified";
            }
            if (i > 0) {
                str2 = i + "/8";
            } else {
                str2 = "";
            }
            HashMap hashMap = new HashMap();
            hashMap.put("Original size", str3);
            hashMap.put("Requested size", str);
            hashMap.put("Fraction", str2);
            hashMap.put("queueTime", String.valueOf(this.mJobScheduler.getQueuedTime()));
            hashMap.put("downsampleEnumerator", Integer.toString(i2));
            hashMap.put("softwareEnumerator", Integer.toString(i3));
            hashMap.put("rotationAngle", Integer.toString(i4));
            return ImmutableMap.copyOf(hashMap);
        }
    }

    public static TriState shouldTransform(ImageRequest imageRequest, EncodedImage encodedImage, boolean z) {
        if (encodedImage == null || encodedImage.getImageFormat() == ImageFormat.UNKNOWN) {
            return TriState.UNSET;
        }
        if (encodedImage.getImageFormat() != DefaultImageFormats.JPEG) {
            return TriState.NO;
        }
        return TriState.valueOf(shouldRotate(imageRequest.getRotationOptions(), encodedImage) || shouldResize(getSoftwareNumerator(imageRequest, encodedImage, z)));
    }

    @VisibleForTesting
    static float determineResizeRatio(ResizeOptions resizeOptions, int i, int i2) {
        if (resizeOptions == null) {
            return 1.0f;
        }
        float f = (float) i;
        float f2 = (float) i2;
        float max = Math.max(((float) resizeOptions.width) / f, ((float) resizeOptions.height) / f2);
        if (f * max > resizeOptions.maxBitmapSize) {
            max = resizeOptions.maxBitmapSize / f;
        }
        return f2 * max > resizeOptions.maxBitmapSize ? resizeOptions.maxBitmapSize / f2 : max;
    }

    public static int getSoftwareNumerator(ImageRequest imageRequest, EncodedImage encodedImage, boolean z) {
        ResizeOptions resizeOptions;
        int i;
        int i2;
        if (!z || (resizeOptions = imageRequest.getResizeOptions()) == null) {
            return 8;
        }
        int rotationAngle = getRotationAngle(imageRequest.getRotationOptions(), encodedImage);
        boolean z2 = false;
        int forceRotatedInvertedExifOrientation = INVERTED_EXIF_ORIENTATIONS.contains(Integer.valueOf(encodedImage.getExifOrientation())) ? getForceRotatedInvertedExifOrientation(imageRequest.getRotationOptions(), encodedImage) : 0;
        if (rotationAngle == 90 || rotationAngle == 270 || forceRotatedInvertedExifOrientation == 5 || forceRotatedInvertedExifOrientation == 7) {
            z2 = true;
        }
        if (z2) {
            i = encodedImage.getHeight();
        } else {
            i = encodedImage.getWidth();
        }
        if (z2) {
            i2 = encodedImage.getWidth();
        } else {
            i2 = encodedImage.getHeight();
        }
        int roundNumerator = roundNumerator(determineResizeRatio(resizeOptions, i, i2), resizeOptions.roundUpFraction);
        if (roundNumerator > 8) {
            return 8;
        }
        if (roundNumerator <= 0) {
            return 1;
        }
        return roundNumerator;
    }

    public static int getRotationAngle(RotationOptions rotationOptions, EncodedImage encodedImage) {
        if (!rotationOptions.rotationEnabled()) {
            return 0;
        }
        int extractOrientationFromMetadata = extractOrientationFromMetadata(encodedImage);
        if (rotationOptions.useImageMetadata()) {
            return extractOrientationFromMetadata;
        }
        return (extractOrientationFromMetadata + rotationOptions.getForcedAngle()) % 360;
    }

    public static int getForceRotatedInvertedExifOrientation(RotationOptions rotationOptions, EncodedImage encodedImage) {
        int indexOf = INVERTED_EXIF_ORIENTATIONS.indexOf(Integer.valueOf(encodedImage.getExifOrientation()));
        if (indexOf >= 0) {
            int i = 0;
            if (!rotationOptions.useImageMetadata()) {
                i = rotationOptions.getForcedAngle();
            }
            ImmutableList<Integer> immutableList = INVERTED_EXIF_ORIENTATIONS;
            return immutableList.get((indexOf + (i / 90)) % immutableList.size()).intValue();
        }
        throw new IllegalArgumentException("Only accepts inverted exif orientations");
    }

    private static int extractOrientationFromMetadata(EncodedImage encodedImage) {
        int rotationAngle = encodedImage.getRotationAngle();
        if (rotationAngle == 90 || rotationAngle == 180 || rotationAngle == 270) {
            return encodedImage.getRotationAngle();
        }
        return 0;
    }

    private static boolean shouldRotate(RotationOptions rotationOptions, EncodedImage encodedImage) {
        if (!rotationOptions.canDeferUntilRendered()) {
            return getRotationAngle(rotationOptions, encodedImage) != 0 || shouldRotateUsingExifOrientation(rotationOptions, encodedImage);
        }
        return false;
    }

    private static boolean shouldRotateUsingExifOrientation(RotationOptions rotationOptions, EncodedImage encodedImage) {
        if (rotationOptions.rotationEnabled() && !rotationOptions.canDeferUntilRendered()) {
            return INVERTED_EXIF_ORIENTATIONS.contains(Integer.valueOf(encodedImage.getExifOrientation()));
        }
        encodedImage.setExifOrientation(0);
        return false;
    }

    @VisibleForTesting
    static int calculateDownsampleNumerator(int i) {
        return Math.max(1, 8 / i);
    }
}
