package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import java.util.Map;

public class DefaultImageDecoder implements ImageDecoder {
    private final ImageDecoder mAnimatedGifDecoder;
    private final ImageDecoder mAnimatedWebPDecoder;
    private final Map<ImageFormat, ImageDecoder> mCustomDecoders;
    private final ImageDecoder mDefaultDecoder;
    private final PlatformDecoder mPlatformDecoder;

    public DefaultImageDecoder(ImageDecoder imageDecoder, ImageDecoder imageDecoder2, PlatformDecoder platformDecoder) {
        this(imageDecoder, imageDecoder2, platformDecoder, null);
    }

    public DefaultImageDecoder(ImageDecoder imageDecoder, ImageDecoder imageDecoder2, PlatformDecoder platformDecoder, Map<ImageFormat, ImageDecoder> map) {
        this.mDefaultDecoder = new ImageDecoder() {
            /* class com.facebook.imagepipeline.decoder.DefaultImageDecoder.AnonymousClass1 */

            public CloseableImage decode(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
                ImageFormat imageFormat = encodedImage.getImageFormat();
                if (imageFormat == DefaultImageFormats.JPEG) {
                    return DefaultImageDecoder.this.decodeJpeg(encodedImage, i, qualityInfo, imageDecodeOptions);
                }
                if (imageFormat == DefaultImageFormats.GIF) {
                    return DefaultImageDecoder.this.decodeGif(encodedImage, i, qualityInfo, imageDecodeOptions);
                }
                if (imageFormat == DefaultImageFormats.WEBP_ANIMATED) {
                    return DefaultImageDecoder.this.decodeAnimatedWebp(encodedImage, i, qualityInfo, imageDecodeOptions);
                }
                if (imageFormat != ImageFormat.UNKNOWN) {
                    return DefaultImageDecoder.this.decodeStaticImage(encodedImage, imageDecodeOptions);
                }
                throw new DecodeException("unknown image format", encodedImage);
            }
        };
        this.mAnimatedGifDecoder = imageDecoder;
        this.mAnimatedWebPDecoder = imageDecoder2;
        this.mPlatformDecoder = platformDecoder;
        this.mCustomDecoders = map;
    }

    public CloseableImage decode(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        ImageDecoder imageDecoder;
        if (imageDecodeOptions.customImageDecoder != null) {
            return imageDecodeOptions.customImageDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
        }
        ImageFormat imageFormat = encodedImage.getImageFormat();
        if (imageFormat == null || imageFormat == ImageFormat.UNKNOWN) {
            imageFormat = ImageFormatChecker.getImageFormat_WrapIOException(encodedImage.getInputStream());
            encodedImage.setImageFormat(imageFormat);
        }
        Map<ImageFormat, ImageDecoder> map = this.mCustomDecoders;
        if (map == null || (imageDecoder = map.get(imageFormat)) == null) {
            return this.mDefaultDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
        }
        return imageDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
    }

    public CloseableImage decodeGif(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        ImageDecoder imageDecoder;
        if (imageDecodeOptions.forceStaticImage || (imageDecoder = this.mAnimatedGifDecoder) == null) {
            return decodeStaticImage(encodedImage, imageDecodeOptions);
        }
        return imageDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
    }

    public CloseableStaticBitmap decodeStaticImage(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions) {
        CloseableReference<Bitmap> decodeFromEncodedImage = this.mPlatformDecoder.decodeFromEncodedImage(encodedImage, imageDecodeOptions.bitmapConfig, null);
        try {
            return new CloseableStaticBitmap(decodeFromEncodedImage, ImmutableQualityInfo.FULL_QUALITY, encodedImage.getRotationAngle(), encodedImage.getExifOrientation());
        } finally {
            decodeFromEncodedImage.close();
        }
    }

    public CloseableStaticBitmap decodeJpeg(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        CloseableReference<Bitmap> decodeJPEGFromEncodedImage = this.mPlatformDecoder.decodeJPEGFromEncodedImage(encodedImage, imageDecodeOptions.bitmapConfig, null, i);
        try {
            return new CloseableStaticBitmap(decodeJPEGFromEncodedImage, qualityInfo, encodedImage.getRotationAngle(), encodedImage.getExifOrientation());
        } finally {
            decodeJPEGFromEncodedImage.close();
        }
    }

    public CloseableImage decodeAnimatedWebp(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        return this.mAnimatedWebPDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
    }
}
