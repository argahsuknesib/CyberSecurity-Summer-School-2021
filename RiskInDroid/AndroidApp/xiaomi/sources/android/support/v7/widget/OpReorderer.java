package android.support.v7.widget;

import android.support.v7.widget.AdapterHelper;
import java.util.List;

class OpReorderer {
    final Callback mCallback;

    interface Callback {
        AdapterHelper.UpdateOp obtainUpdateOp(int i, int i2, int i3, Object obj);

        void recycleUpdateOp(AdapterHelper.UpdateOp updateOp);
    }

    public OpReorderer(Callback callback) {
        this.mCallback = callback;
    }

    /* access modifiers changed from: package-private */
    public void reorderOps(List<AdapterHelper.UpdateOp> list) {
        while (true) {
            int lastMoveOutOfOrder = getLastMoveOutOfOrder(list);
            if (lastMoveOutOfOrder != -1) {
                swapMoveOp(list, lastMoveOutOfOrder, lastMoveOutOfOrder + 1);
            } else {
                return;
            }
        }
    }

    private void swapMoveOp(List<AdapterHelper.UpdateOp> list, int i, int i2) {
        AdapterHelper.UpdateOp updateOp = list.get(i);
        AdapterHelper.UpdateOp updateOp2 = list.get(i2);
        int i3 = updateOp2.cmd;
        if (i3 == 1) {
            swapMoveAdd(list, i, updateOp, i2, updateOp2);
        } else if (i3 == 2) {
            swapMoveRemove(list, i, updateOp, i2, updateOp2);
        } else if (i3 == 4) {
            swapMoveUpdate(list, i, updateOp, i2, updateOp2);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0097  */
    public void swapMoveRemove(List<AdapterHelper.UpdateOp> list, int i, AdapterHelper.UpdateOp updateOp, int i2, AdapterHelper.UpdateOp updateOp2) {
        boolean z;
        boolean z2 = false;
        if (updateOp.positionStart < updateOp.itemCount) {
            if (updateOp2.positionStart == updateOp.positionStart && updateOp2.itemCount == updateOp.itemCount - updateOp.positionStart) {
                z = false;
            } else {
                z = false;
                if (updateOp.itemCount < updateOp2.positionStart) {
                    updateOp2.positionStart--;
                } else if (updateOp.itemCount < updateOp2.positionStart + updateOp2.itemCount) {
                    updateOp2.itemCount--;
                    updateOp.cmd = 2;
                    updateOp.itemCount = 1;
                    if (updateOp2.itemCount == 0) {
                        list.remove(i2);
                        this.mCallback.recycleUpdateOp(updateOp2);
                        return;
                    }
                    return;
                }
                AdapterHelper.UpdateOp updateOp3 = null;
                if (updateOp.positionStart <= updateOp2.positionStart) {
                    updateOp2.positionStart++;
                } else if (updateOp.positionStart < updateOp2.positionStart + updateOp2.itemCount) {
                    updateOp3 = this.mCallback.obtainUpdateOp(2, updateOp.positionStart + 1, (updateOp2.positionStart + updateOp2.itemCount) - updateOp.positionStart, null);
                    updateOp2.itemCount = updateOp.positionStart - updateOp2.positionStart;
                }
                if (z2) {
                    list.set(i, updateOp2);
                    list.remove(i2);
                    this.mCallback.recycleUpdateOp(updateOp);
                    return;
                }
                if (z) {
                    if (updateOp3 != null) {
                        if (updateOp.positionStart > updateOp3.positionStart) {
                            updateOp.positionStart -= updateOp3.itemCount;
                        }
                        if (updateOp.itemCount > updateOp3.positionStart) {
                            updateOp.itemCount -= updateOp3.itemCount;
                        }
                    }
                    if (updateOp.positionStart > updateOp2.positionStart) {
                        updateOp.positionStart -= updateOp2.itemCount;
                    }
                    if (updateOp.itemCount > updateOp2.positionStart) {
                        updateOp.itemCount -= updateOp2.itemCount;
                    }
                } else {
                    if (updateOp3 != null) {
                        if (updateOp.positionStart >= updateOp3.positionStart) {
                            updateOp.positionStart -= updateOp3.itemCount;
                        }
                        if (updateOp.itemCount >= updateOp3.positionStart) {
                            updateOp.itemCount -= updateOp3.itemCount;
                        }
                    }
                    if (updateOp.positionStart >= updateOp2.positionStart) {
                        updateOp.positionStart -= updateOp2.itemCount;
                    }
                    if (updateOp.itemCount >= updateOp2.positionStart) {
                        updateOp.itemCount -= updateOp2.itemCount;
                    }
                }
                list.set(i, updateOp2);
                if (updateOp.positionStart != updateOp.itemCount) {
                    list.set(i2, updateOp);
                } else {
                    list.remove(i2);
                }
                if (updateOp3 != null) {
                    list.add(i, updateOp3);
                    return;
                }
                return;
            }
        } else if (updateOp2.positionStart == updateOp.itemCount + 1 && updateOp2.itemCount == updateOp.positionStart - updateOp.itemCount) {
            z = true;
        } else {
            z = true;
            if (updateOp.itemCount < updateOp2.positionStart) {
            }
            AdapterHelper.UpdateOp updateOp32 = null;
            if (updateOp.positionStart <= updateOp2.positionStart) {
            }
            if (z2) {
            }
        }
        z2 = true;
        if (updateOp.itemCount < updateOp2.positionStart) {
        }
        AdapterHelper.UpdateOp updateOp322 = null;
        if (updateOp.positionStart <= updateOp2.positionStart) {
        }
        if (z2) {
        }
    }

    private void swapMoveAdd(List<AdapterHelper.UpdateOp> list, int i, AdapterHelper.UpdateOp updateOp, int i2, AdapterHelper.UpdateOp updateOp2) {
        int i3 = updateOp.itemCount < updateOp2.positionStart ? -1 : 0;
        if (updateOp.positionStart < updateOp2.positionStart) {
            i3++;
        }
        if (updateOp2.positionStart <= updateOp.positionStart) {
            updateOp.positionStart += updateOp2.itemCount;
        }
        if (updateOp2.positionStart <= updateOp.itemCount) {
            updateOp.itemCount += updateOp2.itemCount;
        }
        updateOp2.positionStart += i3;
        list.set(i, updateOp2);
        list.set(i2, updateOp);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002f  */
    public void swapMoveUpdate(List<AdapterHelper.UpdateOp> list, int i, AdapterHelper.UpdateOp updateOp, int i2, AdapterHelper.UpdateOp updateOp2) {
        AdapterHelper.UpdateOp updateOp3;
        AdapterHelper.UpdateOp updateOp4 = null;
        if (updateOp.itemCount < updateOp2.positionStart) {
            updateOp2.positionStart--;
        } else if (updateOp.itemCount < updateOp2.positionStart + updateOp2.itemCount) {
            updateOp2.itemCount--;
            updateOp3 = this.mCallback.obtainUpdateOp(4, updateOp.positionStart, 1, updateOp2.payload);
            if (updateOp.positionStart > updateOp2.positionStart) {
                updateOp2.positionStart++;
            } else if (updateOp.positionStart < updateOp2.positionStart + updateOp2.itemCount) {
                int i3 = (updateOp2.positionStart + updateOp2.itemCount) - updateOp.positionStart;
                updateOp4 = this.mCallback.obtainUpdateOp(4, updateOp.positionStart + 1, i3, updateOp2.payload);
                updateOp2.itemCount -= i3;
            }
            list.set(i2, updateOp);
            if (updateOp2.itemCount <= 0) {
                list.set(i, updateOp2);
            } else {
                list.remove(i);
                this.mCallback.recycleUpdateOp(updateOp2);
            }
            if (updateOp3 != null) {
                list.add(i, updateOp3);
            }
            if (updateOp4 == null) {
                list.add(i, updateOp4);
                return;
            }
            return;
        }
        updateOp3 = null;
        if (updateOp.positionStart > updateOp2.positionStart) {
        }
        list.set(i2, updateOp);
        if (updateOp2.itemCount <= 0) {
        }
        if (updateOp3 != null) {
        }
        if (updateOp4 == null) {
        }
    }

    private int getLastMoveOutOfOrder(List<AdapterHelper.UpdateOp> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).cmd != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }
}
