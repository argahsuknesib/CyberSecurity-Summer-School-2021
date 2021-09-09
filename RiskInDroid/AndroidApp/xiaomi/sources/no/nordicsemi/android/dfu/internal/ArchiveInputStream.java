package no.nordicsemi.android.dfu.internal;

import android.util.Log;
import com.google.gson.Gson;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import no.nordicsemi.android.dfu.internal.manifest.FileInfo;
import no.nordicsemi.android.dfu.internal.manifest.Manifest;
import no.nordicsemi.android.dfu.internal.manifest.ManifestFile;
import no.nordicsemi.android.dfu.internal.manifest.SoftDeviceBootloaderFileInfo;

public class ArchiveInputStream extends ZipInputStream {
    private byte[] applicationBytes;
    private byte[] applicationInitBytes;
    private int applicationSize;
    private byte[] bootloaderBytes;
    private int bootloaderSize;
    private int bytesRead = 0;
    private int bytesReadFromCurrentSource = 0;
    private int bytesReadFromMarkedSource;
    private CRC32 crc32 = new CRC32();
    private byte[] currentSource;
    private Map<String, byte[]> entries = new HashMap();
    private Manifest manifest;
    private byte[] markedSource;
    private byte[] softDeviceAndBootloaderBytes;
    private byte[] softDeviceBytes;
    private int softDeviceSize;
    private byte[] systemInitBytes;
    private int type;

    public boolean markSupported() {
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:79:0x020e A[Catch:{ all -> 0x0282 }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x021e A[Catch:{ all -> 0x0282 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0247 A[Catch:{ all -> 0x0282 }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0257 A[Catch:{ all -> 0x0282 }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x027a A[SYNTHETIC, Splitter:B:96:0x027a] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:10:0x002e=Splitter:B:10:0x002e, B:76:0x01fe=Splitter:B:76:0x01fe} */
    public ArchiveInputStream(InputStream inputStream, int i, int i2) throws IOException {
        super(inputStream);
        boolean z;
        boolean z2;
        try {
            parseZip(i);
            if (this.manifest != null) {
                if (this.manifest.getApplicationInfo() == null || (i2 != 0 && (i2 & 4) <= 0)) {
                    z2 = false;
                } else {
                    FileInfo applicationInfo = this.manifest.getApplicationInfo();
                    this.applicationBytes = this.entries.get(applicationInfo.getBinFileName());
                    this.applicationInitBytes = this.entries.get(applicationInfo.getDatFileName());
                    if (this.applicationBytes != null) {
                        this.applicationSize = this.applicationBytes.length;
                        this.currentSource = this.applicationBytes;
                        z2 = true;
                    } else {
                        throw new IOException("Application file " + applicationInfo.getBinFileName() + " not found.");
                    }
                }
                if (this.manifest.getBootloaderInfo() != null && (i2 == 0 || (i2 & 2) > 0)) {
                    if (this.systemInitBytes == null) {
                        FileInfo bootloaderInfo = this.manifest.getBootloaderInfo();
                        this.bootloaderBytes = this.entries.get(bootloaderInfo.getBinFileName());
                        this.systemInitBytes = this.entries.get(bootloaderInfo.getDatFileName());
                        if (this.bootloaderBytes != null) {
                            this.bootloaderSize = this.bootloaderBytes.length;
                            this.currentSource = this.bootloaderBytes;
                            z2 = true;
                        } else {
                            throw new IOException("Bootloader file " + bootloaderInfo.getBinFileName() + " not found.");
                        }
                    } else {
                        throw new IOException("Manifest: softdevice and bootloader specified. Use softdevice_bootloader instead.");
                    }
                }
                if (this.manifest.getSoftdeviceInfo() != null && (i2 == 0 || (i2 & 1) > 0)) {
                    FileInfo softdeviceInfo = this.manifest.getSoftdeviceInfo();
                    this.softDeviceBytes = this.entries.get(softdeviceInfo.getBinFileName());
                    this.systemInitBytes = this.entries.get(softdeviceInfo.getDatFileName());
                    if (this.softDeviceBytes != null) {
                        this.softDeviceSize = this.softDeviceBytes.length;
                        this.currentSource = this.softDeviceBytes;
                        z2 = true;
                    } else {
                        throw new IOException("SoftDevice file " + softdeviceInfo.getBinFileName() + " not found.");
                    }
                }
                if (this.manifest.getSoftdeviceBootloaderInfo() != null && (i2 == 0 || ((i2 & 1) > 0 && (i2 & 2) > 0))) {
                    if (this.systemInitBytes == null) {
                        SoftDeviceBootloaderFileInfo softdeviceBootloaderInfo = this.manifest.getSoftdeviceBootloaderInfo();
                        this.softDeviceAndBootloaderBytes = this.entries.get(softdeviceBootloaderInfo.getBinFileName());
                        this.systemInitBytes = this.entries.get(softdeviceBootloaderInfo.getDatFileName());
                        if (this.softDeviceAndBootloaderBytes != null) {
                            this.softDeviceSize = softdeviceBootloaderInfo.getSoftdeviceSize();
                            this.bootloaderSize = softdeviceBootloaderInfo.getBootloaderSize();
                            this.currentSource = this.softDeviceAndBootloaderBytes;
                            z2 = true;
                        } else {
                            throw new IOException("File " + softdeviceBootloaderInfo.getBinFileName() + " not found.");
                        }
                    } else {
                        throw new IOException("Manifest: The softdevice_bootloader may not be used together with softdevice or bootloader.");
                    }
                }
                if (!z2) {
                    throw new IOException("Manifest file must specify at least one file.");
                }
            } else {
                if (i2 == 0 || (i2 & 4) > 0) {
                    this.applicationBytes = this.entries.get("application.hex");
                    if (this.applicationBytes == null) {
                        this.applicationBytes = this.entries.get("application.bin");
                    }
                    if (this.applicationBytes != null) {
                        this.applicationSize = this.applicationBytes.length;
                        this.applicationInitBytes = this.entries.get("application.dat");
                        this.currentSource = this.applicationBytes;
                        z = true;
                        if (i2 == 0 || (i2 & 2) > 0) {
                            this.bootloaderBytes = this.entries.get("bootloader.hex");
                            if (this.bootloaderBytes == null) {
                                this.bootloaderBytes = this.entries.get("bootloader.bin");
                            }
                            if (this.bootloaderBytes != null) {
                                this.bootloaderSize = this.bootloaderBytes.length;
                                this.systemInitBytes = this.entries.get("system.dat");
                                this.currentSource = this.bootloaderBytes;
                                z = true;
                            }
                        }
                        if (i2 == 0 || (i2 & 1) > 0) {
                            this.softDeviceBytes = this.entries.get("softdevice.hex");
                            if (this.softDeviceBytes == null) {
                                this.softDeviceBytes = this.entries.get("softdevice.bin");
                            }
                            if (this.softDeviceBytes != null) {
                                this.softDeviceSize = this.softDeviceBytes.length;
                                this.systemInitBytes = this.entries.get("system.dat");
                                this.currentSource = this.softDeviceBytes;
                                z = true;
                            }
                        }
                        if (!z) {
                            throw new IOException("The ZIP file must contain an Application, a Soft Device and/or a Bootloader.");
                        }
                    }
                }
                z = false;
                this.bootloaderBytes = this.entries.get("bootloader.hex");
                if (this.bootloaderBytes == null) {
                }
                if (this.bootloaderBytes != null) {
                }
                this.softDeviceBytes = this.entries.get("softdevice.hex");
                if (this.softDeviceBytes == null) {
                }
                if (this.softDeviceBytes != null) {
                }
                if (!z) {
                }
            }
            mark(0);
        } finally {
            this.type = getContentType();
            super.close();
        }
    }

    private void parseZip(int i) throws IOException {
        byte[] bArr = new byte[1024];
        String str = null;
        while (true) {
            ZipEntry nextEntry = getNextEntry();
            if (nextEntry == null) {
                break;
            }
            String name = nextEntry.getName();
            if (nextEntry.isDirectory()) {
                Log.w("DfuArchiveInputStream", "A directory found in the ZIP: " + name + "!");
            } else {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = super.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                if (name.toLowerCase(Locale.US).endsWith("hex")) {
                    HexInputStream hexInputStream = new HexInputStream(byteArray, i);
                    byteArray = new byte[hexInputStream.available()];
                    hexInputStream.read(byteArray);
                    hexInputStream.close();
                }
                if ("manifest.json".equals(name)) {
                    str = new String(byteArray, "UTF-8");
                } else {
                    this.entries.put(name, byteArray);
                }
            }
        }
        if (this.entries.isEmpty()) {
            throw new FileNotFoundException("No files found in the ZIP. Check if the URI provided is valid and the ZIP contains required files on root level, not in a directory.");
        } else if (str != null) {
            this.manifest = ((ManifestFile) new Gson().fromJson(str, ManifestFile.class)).getManifest();
            if (this.manifest == null) {
                Log.w("DfuArchiveInputStream", "Manifest failed to be parsed. Did you add \n-keep class no.nordicsemi.android.dfu.** { *; }\nto your proguard rules?");
            }
        } else {
            Log.w("DfuArchiveInputStream", "Manifest not found in the ZIP. It is recommended to use a distribution file created with: https://github.com/NordicSemiconductor/pc-nrfutil/ (for Legacy DFU use version 0.5.x)");
        }
    }

    public void close() throws IOException {
        this.softDeviceBytes = null;
        this.bootloaderBytes = null;
        this.softDeviceBytes = null;
        this.softDeviceAndBootloaderBytes = null;
        this.applicationSize = 0;
        this.bootloaderSize = 0;
        this.softDeviceSize = 0;
        this.currentSource = null;
        this.bytesReadFromCurrentSource = 0;
        this.bytesRead = 0;
        super.close();
    }

    public int read(byte[] bArr) throws IOException {
        int length = this.currentSource.length - this.bytesReadFromCurrentSource;
        if (bArr.length <= length) {
            length = bArr.length;
        }
        System.arraycopy(this.currentSource, this.bytesReadFromCurrentSource, bArr, 0, length);
        this.bytesReadFromCurrentSource += length;
        if (bArr.length > length) {
            if (startNextFile() == null) {
                this.bytesRead += length;
                this.crc32.update(bArr, 0, length);
                return length;
            }
            int length2 = this.currentSource.length;
            if (bArr.length - length <= length2) {
                length2 = bArr.length - length;
            }
            System.arraycopy(this.currentSource, 0, bArr, length, length2);
            this.bytesReadFromCurrentSource += length2;
            length += length2;
        }
        this.bytesRead += length;
        this.crc32.update(bArr, 0, length);
        return length;
    }

    public void mark(int i) {
        this.markedSource = this.currentSource;
        this.bytesReadFromMarkedSource = this.bytesReadFromCurrentSource;
    }

    public void reset() throws IOException {
        byte[] bArr;
        this.currentSource = this.markedSource;
        int i = this.bytesReadFromMarkedSource;
        this.bytesReadFromCurrentSource = i;
        this.bytesRead = i;
        this.crc32.reset();
        if (this.currentSource == this.bootloaderBytes && (bArr = this.softDeviceBytes) != null) {
            this.crc32.update(bArr);
            this.bytesRead += this.softDeviceSize;
        }
        this.crc32.update(this.currentSource, 0, this.bytesReadFromCurrentSource);
    }

    public int getBytesRead() {
        return this.bytesRead;
    }

    public long getCrc32() {
        return this.crc32.getValue();
    }

    public int getContentType() {
        this.type = 0;
        if (this.softDeviceAndBootloaderBytes != null) {
            this.type |= 3;
        }
        if (this.softDeviceSize > 0) {
            this.type |= 1;
        }
        if (this.bootloaderSize > 0) {
            this.type |= 2;
        }
        if (this.applicationSize > 0) {
            this.type |= 4;
        }
        return this.type;
    }

    public int setContentType(int i) {
        byte[] bArr;
        this.type = i;
        int i2 = i & 4;
        if (i2 > 0 && this.applicationBytes == null) {
            this.type &= -5;
        }
        int i3 = i & 3;
        if (i3 == 3) {
            if (this.softDeviceBytes == null && this.softDeviceAndBootloaderBytes == null) {
                this.type &= -2;
            }
            if (this.bootloaderBytes == null && this.softDeviceAndBootloaderBytes == null) {
                this.type &= -2;
            }
        } else if (this.softDeviceAndBootloaderBytes != null) {
            this.type &= -4;
        }
        if (i3 > 0 && (bArr = this.softDeviceAndBootloaderBytes) != null) {
            this.currentSource = bArr;
        } else if ((i & 1) > 0) {
            this.currentSource = this.softDeviceBytes;
        } else if ((i & 2) > 0) {
            this.currentSource = this.bootloaderBytes;
        } else if (i2 > 0) {
            this.currentSource = this.applicationBytes;
        }
        this.bytesReadFromCurrentSource = 0;
        try {
            mark(0);
            reset();
        } catch (IOException unused) {
        }
        return this.type;
    }

    private byte[] startNextFile() {
        byte[] bArr;
        if (this.currentSource != this.softDeviceBytes || (bArr = this.bootloaderBytes) == null || (this.type & 2) <= 0) {
            byte[] bArr2 = this.currentSource;
            byte[] bArr3 = this.applicationBytes;
            if (bArr2 == bArr3 || bArr3 == null || (this.type & 4) <= 0) {
                bArr = null;
                this.currentSource = null;
            } else {
                this.currentSource = bArr3;
                bArr = bArr3;
            }
        } else {
            this.currentSource = bArr;
        }
        this.bytesReadFromCurrentSource = 0;
        return bArr;
    }

    public int available() {
        int softDeviceImageSize;
        int i;
        byte[] bArr = this.softDeviceAndBootloaderBytes;
        if (bArr == null || this.softDeviceSize != 0 || this.bootloaderSize != 0 || (this.type & 3) <= 0) {
            softDeviceImageSize = softDeviceImageSize() + bootloaderImageSize() + applicationImageSize();
            i = this.bytesRead;
        } else {
            softDeviceImageSize = bArr.length + applicationImageSize();
            i = this.bytesRead;
        }
        return softDeviceImageSize - i;
    }

    public int softDeviceImageSize() {
        if ((this.type & 1) > 0) {
            return this.softDeviceSize;
        }
        return 0;
    }

    public int bootloaderImageSize() {
        if ((this.type & 2) > 0) {
            return this.bootloaderSize;
        }
        return 0;
    }

    public int applicationImageSize() {
        if ((this.type & 4) > 0) {
            return this.applicationSize;
        }
        return 0;
    }

    public byte[] getSystemInit() {
        return this.systemInitBytes;
    }

    public byte[] getApplicationInit() {
        return this.applicationInitBytes;
    }

    public boolean isSecureDfuRequired() {
        Manifest manifest2 = this.manifest;
        return manifest2 != null && manifest2.isSecureDfuRequired();
    }
}
