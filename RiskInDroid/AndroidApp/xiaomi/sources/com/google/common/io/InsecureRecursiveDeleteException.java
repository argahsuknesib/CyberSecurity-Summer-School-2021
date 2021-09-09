package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import java.nio.file.FileSystemException;

@GwtIncompatible
@Beta
public final class InsecureRecursiveDeleteException extends FileSystemException {
    public InsecureRecursiveDeleteException(String str) {
        super(str, null, "unable to guarantee security of recursive delete");
    }
}
