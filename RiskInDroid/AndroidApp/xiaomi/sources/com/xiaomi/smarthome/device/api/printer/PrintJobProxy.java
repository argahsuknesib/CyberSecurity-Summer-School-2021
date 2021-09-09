package com.xiaomi.smarthome.device.api.printer;

import android.annotation.TargetApi;
import android.os.ParcelFileDescriptor;
import android.print.PrintDocumentInfo;
import android.print.PrintJobId;
import android.print.PrintJobInfo;
import android.printservice.PrintDocument;
import android.printservice.PrintJob;

@TargetApi(19)
public class PrintJobProxy {
    private PrintJob printJob;

    public PrintJobProxy() {
    }

    public PrintJobProxy(PrintJob printJob2) {
        this.printJob = printJob2;
    }

    public PrintJobId getId() {
        return this.printJob.getId();
    }

    public PrintJobInfo getInfo() {
        return this.printJob.getInfo();
    }

    public ParcelFileDescriptor getDocumentData() {
        PrintDocument document = this.printJob.getDocument();
        if (document == null) {
            return null;
        }
        return document.getData();
    }

    public PrintDocumentInfo getDocumentInfo() {
        PrintDocument document = this.printJob.getDocument();
        if (document == null) {
            return null;
        }
        return document.getInfo();
    }

    public boolean isQueued() {
        return this.printJob.isQueued();
    }

    public boolean isStarted() {
        return this.printJob.isStarted();
    }

    public boolean isBlocked() {
        return this.printJob.isBlocked();
    }

    public boolean isCompleted() {
        return this.printJob.isCompleted();
    }

    public boolean isFailed() {
        return this.printJob.isFailed();
    }

    public boolean isCancelled() {
        return this.printJob.isCancelled();
    }

    public boolean start() {
        return this.printJob.start();
    }

    public boolean block(String str) {
        return this.printJob.block(str);
    }

    public boolean complete() {
        return this.printJob.complete();
    }

    public boolean fail(String str) {
        return this.printJob.fail(str);
    }

    public boolean cancel() {
        return this.printJob.cancel();
    }

    public boolean setTag(String str) {
        return this.printJob.setTag(str);
    }

    public String getTag() {
        return this.printJob.getTag();
    }

    public String getAdvancedStringOption(String str) {
        return this.printJob.getAdvancedStringOption(str);
    }

    public boolean hasAdvancedOption(String str) {
        return this.printJob.hasAdvancedOption(str);
    }

    public int getAdvancedIntOption(String str) {
        return this.printJob.getAdvancedIntOption(str);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PrintJobProxy)) {
            return super.equals(obj);
        }
        PrintJob printJob2 = this.printJob;
        if (printJob2 == null) {
            return ((PrintJobProxy) obj).printJob == null;
        }
        return printJob2.equals(((PrintJobProxy) obj).printJob);
    }

    public int hashCode() {
        return this.printJob.hashCode();
    }
}
