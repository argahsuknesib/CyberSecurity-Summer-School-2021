package com.rt2zz.reactnativecontacts;

import _m_j.ctz;
import _m_j.oOOO00o0;
import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Hashtable;

public class ContactsManager extends ReactContextBaseJavaModule {
    private static Callback requestCallback;

    public String getName() {
        return "Contacts";
    }

    public ContactsManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void getAll(Callback callback) {
        getAllContacts(callback);
    }

    @ReactMethod
    public void getAllWithoutPhotos(Callback callback) {
        getAllContacts(callback);
    }

    private void getAllContacts(final Callback callback) {
        AsyncTask.execute(new Runnable() {
            /* class com.rt2zz.reactnativecontacts.ContactsManager.AnonymousClass1 */

            public final void run() {
                WritableArray O000000o2 = new ctz(ContactsManager.this.getReactApplicationContext().getContentResolver()).O000000o();
                callback.invoke(null, O000000o2);
            }
        });
    }

    @ReactMethod
    public void getContactsMatchingString(String str, Callback callback) {
        getAllContactsMatchingString(str, callback);
    }

    private void getAllContactsMatchingString(final String str, final Callback callback) {
        AsyncTask.execute(new Runnable() {
            /* class com.rt2zz.reactnativecontacts.ContactsManager.AnonymousClass2 */

            public final void run() {
                WritableArray O000000o2 = new ctz(ContactsManager.this.getReactApplicationContext().getContentResolver()).O000000o(str);
                callback.invoke(null, O000000o2);
            }
        });
    }

    @ReactMethod
    public void getPhotoForId(final String str, final Callback callback) {
        AsyncTask.execute(new Runnable() {
            /* class com.rt2zz.reactnativecontacts.ContactsManager.AnonymousClass3 */

            public final void run() {
                String O00000o02 = new ctz(ContactsManager.this.getReactApplicationContext().getContentResolver()).O00000o0(str);
                callback.invoke(null, O00000o02);
            }
        });
    }

    @ReactMethod
    public void openContactForm(ReadableMap readableMap, Callback callback) {
        String str;
        String str2;
        Integer[] numArr;
        int i;
        String[] strArr;
        int i2;
        Integer[] numArr2;
        String[] strArr2;
        String[] strArr3;
        Integer[] numArr3;
        int i3;
        String str3;
        String str4;
        String str5;
        String str6;
        int i4;
        Integer[] numArr4;
        String[] strArr4;
        String[] strArr5;
        String[] strArr6;
        String[] strArr7;
        String[] strArr8;
        String[] strArr9;
        int i5;
        ReadableMap readableMap2 = readableMap;
        String string = readableMap2.hasKey("givenName") ? readableMap2.getString("givenName") : null;
        String string2 = readableMap2.hasKey("middleName") ? readableMap2.getString("middleName") : null;
        String string3 = readableMap2.hasKey("displayName") ? readableMap2.getString("displayName") : null;
        String string4 = readableMap2.hasKey("familyName") ? readableMap2.getString("familyName") : null;
        String string5 = readableMap2.hasKey("prefix") ? readableMap2.getString("prefix") : null;
        String string6 = readableMap2.hasKey("suffix") ? readableMap2.getString("suffix") : null;
        String string7 = readableMap2.hasKey("company") ? readableMap2.getString("company") : null;
        String string8 = readableMap2.hasKey("jobTitle") ? readableMap2.getString("jobTitle") : null;
        String string9 = readableMap2.hasKey("department") ? readableMap2.getString("department") : null;
        ReadableArray array = readableMap2.hasKey("phoneNumbers") ? readableMap2.getArray("phoneNumbers") : null;
        if (array != null) {
            int size = array.size();
            strArr = new String[size];
            numArr = new Integer[size];
            str2 = string3;
            int i6 = 0;
            while (i6 < size) {
                strArr[i6] = array.getMap(i6).getString("number");
                numArr[i6] = Integer.valueOf(mapStringToPhoneType(array.getMap(i6).getString("label")));
                i6++;
                size = size;
                string9 = string9;
            }
            str = string9;
            i = size;
        } else {
            str2 = string3;
            str = string9;
            strArr = null;
            i = 0;
            numArr = null;
        }
        ReadableArray array2 = readableMap2.hasKey("emailAddresses") ? readableMap2.getArray("emailAddresses") : null;
        if (array2 != null) {
            int size2 = array2.size();
            strArr3 = new String[size2];
            strArr2 = strArr;
            Integer[] numArr5 = new Integer[size2];
            numArr2 = numArr;
            int i7 = 0;
            while (i7 < size2) {
                strArr3[i7] = array2.getMap(i7).getString("email");
                numArr5[i7] = Integer.valueOf(mapStringToEmailType(array2.getMap(i7).getString("label")));
                i7++;
                size2 = size2;
                i = i;
            }
            i2 = i;
            numArr3 = numArr5;
            i3 = size2;
        } else {
            strArr2 = strArr;
            i2 = i;
            numArr2 = numArr;
            i3 = 0;
            numArr3 = null;
            strArr3 = null;
        }
        ReadableArray array3 = readableMap2.hasKey("postalAddresses") ? readableMap2.getArray("postalAddresses") : null;
        if (array3 != null) {
            int size3 = array3.size();
            strArr6 = new String[size3];
            strArr5 = new String[size3];
            strArr4 = strArr3;
            String[] strArr10 = new String[size3];
            numArr4 = numArr3;
            strArr8 = new String[size3];
            i4 = i3;
            strArr9 = new String[size3];
            str6 = string8;
            strArr7 = new String[size3];
            str5 = string7;
            Integer[] numArr6 = new Integer[size3];
            str4 = string6;
            int i8 = 0;
            while (i8 < size3) {
                strArr6[i8] = array3.getMap(i8).getString("street");
                strArr5[i8] = array3.getMap(i8).getString("city");
                strArr10[i8] = array3.getMap(i8).getString("state");
                strArr8[i8] = array3.getMap(i8).getString("region");
                strArr9[i8] = array3.getMap(i8).getString("postCode");
                strArr7[i8] = array3.getMap(i8).getString("country");
                numArr6[i8] = Integer.valueOf(mapStringToPostalAddressType(array3.getMap(i8).getString("label")));
                i8++;
                size3 = size3;
                string5 = string5;
            }
            str3 = string5;
            i5 = size3;
        } else {
            i4 = i3;
            numArr4 = numArr3;
            str3 = string5;
            str4 = string6;
            str5 = string7;
            str6 = string8;
            strArr4 = strArr3;
            i5 = 0;
            strArr9 = null;
            strArr8 = null;
            strArr7 = null;
            strArr6 = null;
            strArr5 = null;
        }
        ArrayList arrayList = new ArrayList();
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/identity");
        contentValues.put("data2", string);
        contentValues.put("data3", string4);
        contentValues.put("data5", string2);
        contentValues.put("data4", str3);
        contentValues.put("data6", str4);
        arrayList.add(contentValues);
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("mimetype", "vnd.android.cursor.item/organization");
        contentValues2.put("data1", str5);
        contentValues2.put("data4", str6);
        contentValues2.put("data5", str);
        arrayList.add(contentValues2);
        int i9 = i4;
        for (int i10 = 0; i10 < i9; i10++) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("mimetype", "vnd.android.cursor.item/email_v2");
            contentValues3.put("data2", numArr4[i10]);
            contentValues3.put("data1", strArr4[i10]);
            arrayList.add(contentValues3);
        }
        int i11 = i2;
        for (int i12 = 0; i12 < i11; i12++) {
            ContentValues contentValues4 = new ContentValues();
            contentValues4.put("mimetype", "vnd.android.cursor.item/phone_v2");
            contentValues4.put("data2", numArr2[i12]);
            contentValues4.put("data1", strArr2[i12]);
            arrayList.add(contentValues4);
        }
        for (int i13 = 0; i13 < i5; i13++) {
            ContentValues contentValues5 = new ContentValues();
            contentValues5.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
            contentValues5.put("data4", strArr6[i13]);
            contentValues5.put("data7", strArr5[i13]);
            contentValues5.put("data8", strArr8[i13]);
            contentValues5.put("data10", strArr7[i13]);
            contentValues5.put("data9", strArr9[i13]);
            arrayList.add(contentValues5);
        }
        Intent intent = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
        intent.putExtra("name", str2);
        intent.putParcelableArrayListExtra("data", arrayList);
        intent.setFlags(268435456);
        getReactApplicationContext().startActivity(intent);
    }

    @ReactMethod
    public void addContact(ReadableMap readableMap, Callback callback) {
        String str;
        String str2;
        Integer[] numArr;
        String[] strArr;
        int i;
        String[] strArr2;
        Integer[] numArr2;
        String[] strArr3;
        int i2;
        Integer[] numArr3;
        ContactsManager contactsManager;
        Callback callback2;
        int columnIndex;
        Bitmap decodeFile;
        ReadableMap readableMap2 = readableMap;
        String string = readableMap2.hasKey("givenName") ? readableMap2.getString("givenName") : null;
        String string2 = readableMap2.hasKey("middleName") ? readableMap2.getString("middleName") : null;
        String string3 = readableMap2.hasKey("familyName") ? readableMap2.getString("familyName") : null;
        String string4 = readableMap2.hasKey("prefix") ? readableMap2.getString("prefix") : null;
        String string5 = readableMap2.hasKey("suffix") ? readableMap2.getString("suffix") : null;
        String string6 = readableMap2.hasKey("company") ? readableMap2.getString("company") : null;
        String string7 = readableMap2.hasKey("jobTitle") ? readableMap2.getString("jobTitle") : null;
        String string8 = readableMap2.hasKey("department") ? readableMap2.getString("department") : null;
        String string9 = readableMap2.hasKey("thumbnailPath") ? readableMap2.getString("thumbnailPath") : null;
        ReadableArray array = readableMap2.hasKey("phoneNumbers") ? readableMap2.getArray("phoneNumbers") : null;
        if (array != null) {
            int size = array.size();
            strArr = new String[size];
            Integer[] numArr4 = new Integer[size];
            str2 = string9;
            int i3 = 0;
            while (i3 < size) {
                strArr[i3] = array.getMap(i3).getString("number");
                numArr4[i3] = Integer.valueOf(mapStringToPhoneType(array.getMap(i3).getString("label")));
                i3++;
                size = size;
                string8 = string8;
            }
            str = string8;
            numArr = numArr4;
            i = size;
        } else {
            str = string8;
            str2 = string9;
            i = 0;
            strArr = null;
            numArr = null;
        }
        ReadableArray array2 = readableMap2.hasKey("emailAddresses") ? readableMap2.getArray("emailAddresses") : null;
        if (array2 != null) {
            int size2 = array2.size();
            strArr3 = new String[size2];
            numArr3 = new Integer[size2];
            numArr2 = numArr;
            int i4 = 0;
            while (i4 < size2) {
                strArr3[i4] = array2.getMap(i4).getString("email");
                numArr3[i4] = Integer.valueOf(mapStringToEmailType(array2.getMap(i4).getString("label")));
                i4++;
                size2 = size2;
                strArr = strArr;
            }
            strArr2 = strArr;
            i2 = size2;
        } else {
            strArr2 = strArr;
            numArr2 = numArr;
            numArr3 = null;
            i2 = 0;
            strArr3 = null;
        }
        ArrayList arrayList = new ArrayList();
        String str3 = "label";
        arrayList.add(ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI).withValue("account_type", null).withValue("account_name", null).build());
        arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/name").withValue("data2", string).withValue("data5", string2).withValue("data3", string3).withValue("data4", string4).withValue("data6", string5).build());
        ContentProviderOperation.Builder withValue = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/organization").withValue("data1", string6).withValue("data4", string7).withValue("data5", str);
        arrayList.add(withValue.build());
        withValue.withYieldAllowed(true);
        for (int i5 = 0; i5 < i; i5++) {
            arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/phone_v2").withValue("data1", strArr2[i5]).withValue("data2", numArr2[i5]).build());
        }
        for (int i6 = 0; i6 < i2; i6++) {
            arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/email_v2").withValue("data1", strArr3[i6]).withValue("data2", numArr3[i6]).build());
        }
        if (str2 == null || str2.isEmpty() || (decodeFile = BitmapFactory.decodeFile(str2)) == null) {
            contactsManager = this;
        } else {
            contactsManager = this;
            arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/photo").withValue("data15", contactsManager.toByteArray(decodeFile)).build());
        }
        ReadableMap readableMap3 = readableMap;
        ReadableArray array3 = readableMap3.hasKey("postalAddresses") ? readableMap3.getArray("postalAddresses") : null;
        if (array3 != null) {
            for (int i7 = 0; i7 < array3.size(); i7++) {
                ReadableMap map = array3.getMap(i7);
                arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/postal-address_v2").withValue("data2", Integer.valueOf(contactsManager.mapStringToPostalAddressType(map.getString(str3)))).withValue("data4", map.getString("street")).withValue("data7", map.getString("city")).withValue("data8", map.getString("state")).withValue("data9", map.getString("postCode")).withValue("data10", map.getString("country")).build());
            }
        }
        try {
            ContentResolver contentResolver = getReactApplicationContext().getContentResolver();
            ContentProviderResult[] applyBatch = contentResolver.applyBatch("com.android.contacts", arrayList);
            if (applyBatch != null && applyBatch.length > 0) {
                String valueOf = String.valueOf(ContentUris.parseId(applyBatch[0].uri));
                ctz ctz = new ctz(contentResolver);
                Cursor query = ctz.O00000Oo.query(ContactsContract.RawContacts.CONTENT_URI, new String[]{"contact_id"}, "_id= ?", new String[]{valueOf}, null);
                query.getCount();
                String string10 = (!query.moveToNext() || (columnIndex = query.getColumnIndex("contact_id")) == -1) ? null : query.getString(columnIndex);
                query.close();
                Object[] objArr = {null, ctz.O00000Oo(string10)};
                callback2 = callback;
                try {
                    callback2.invoke(objArr);
                } catch (Exception e) {
                    e = e;
                }
            }
        } catch (Exception e2) {
            e = e2;
            callback2 = callback;
            callback2.invoke(e.toString());
        }
    }

    public byte[] toByteArray(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    @ReactMethod
    public void updateContact(ReadableMap readableMap, Callback callback) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Integer[] numArr;
        String[] strArr;
        int i;
        String[] strArr2;
        String[] strArr3;
        Integer[] numArr2;
        String[] strArr4;
        Integer[] numArr3;
        String[] strArr5;
        int i2;
        Callback callback2;
        Bitmap decodeFile;
        ContentProviderOperation.Builder builder;
        int i3;
        ContentProviderOperation.Builder builder2;
        ReadableMap readableMap2 = readableMap;
        String string = readableMap2.hasKey("recordID") ? readableMap2.getString("recordID") : null;
        String string2 = readableMap2.hasKey("rawContactId") ? readableMap2.getString("rawContactId") : null;
        String string3 = readableMap2.hasKey("givenName") ? readableMap2.getString("givenName") : null;
        String string4 = readableMap2.hasKey("middleName") ? readableMap2.getString("middleName") : null;
        String string5 = readableMap2.hasKey("familyName") ? readableMap2.getString("familyName") : null;
        String string6 = readableMap2.hasKey("prefix") ? readableMap2.getString("prefix") : null;
        String string7 = readableMap2.hasKey("suffix") ? readableMap2.getString("suffix") : null;
        String string8 = readableMap2.hasKey("company") ? readableMap2.getString("company") : null;
        String string9 = readableMap2.hasKey("jobTitle") ? readableMap2.getString("jobTitle") : null;
        String string10 = readableMap2.hasKey("department") ? readableMap2.getString("department") : null;
        String string11 = readableMap2.hasKey("thumbnailPath") ? readableMap2.getString("thumbnailPath") : null;
        ReadableArray array = readableMap2.hasKey("phoneNumbers") ? readableMap2.getArray("phoneNumbers") : null;
        String str6 = string11;
        if (array != null) {
            int size = array.size();
            str5 = string2;
            strArr2 = new String[size];
            str4 = string10;
            numArr = new Integer[size];
            str3 = string9;
            strArr = new String[size];
            str2 = string8;
            int i4 = 0;
            while (i4 < size) {
                int i5 = size;
                ReadableMap map = array.getMap(i4);
                ReadableArray readableArray = array;
                String string12 = map.getString("number");
                String str7 = string7;
                String string13 = map.getString("label");
                String string14 = map.hasKey("id") ? map.getString("id") : null;
                strArr2[i4] = string12;
                numArr[i4] = Integer.valueOf(mapStringToPhoneType(string13));
                strArr[i4] = string14;
                i4++;
                size = i5;
                array = readableArray;
                string7 = str7;
            }
            str = string7;
            i = size;
        } else {
            str5 = string2;
            str = string7;
            str2 = string8;
            str3 = string9;
            str4 = string10;
            strArr2 = null;
            i = 0;
            strArr = null;
            numArr = null;
        }
        ReadableArray array2 = readableMap2.hasKey("emailAddresses") ? readableMap2.getArray("emailAddresses") : null;
        if (array2 != null) {
            int size2 = array2.size();
            strArr4 = new String[size2];
            String[] strArr6 = new String[size2];
            numArr2 = numArr;
            numArr3 = new Integer[size2];
            strArr3 = strArr2;
            int i6 = 0;
            while (i6 < size2) {
                int i7 = size2;
                ReadableMap map2 = array2.getMap(i6);
                ReadableArray readableArray2 = array2;
                strArr4[i6] = map2.getString("email");
                numArr3[i6] = Integer.valueOf(mapStringToEmailType(map2.getString("label")));
                strArr6[i6] = map2.hasKey("id") ? map2.getString("id") : null;
                i6++;
                size2 = i7;
                array2 = readableArray2;
            }
            strArr5 = strArr6;
            i2 = size2;
        } else {
            strArr3 = strArr2;
            numArr2 = numArr;
            i2 = 0;
            strArr5 = null;
            numArr3 = null;
            strArr4 = null;
        }
        ArrayList arrayList = new ArrayList();
        String str8 = "label";
        arrayList.add(ContentProviderOperation.newUpdate(ContactsContract.RawContacts.CONTENT_URI).withSelection("contact_id=?", new String[]{String.valueOf(string)}).withValue("account_type", null).withValue("account_name", null).build());
        arrayList.add(ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI).withSelection("contact_id=?", new String[]{String.valueOf(string)}).withValue("mimetype", "vnd.android.cursor.item/name").withValue("data2", string3).withValue("data5", string4).withValue("data3", string5).withValue("data4", string6).withValue("data6", str).build());
        ContentProviderOperation.Builder withValue = ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI).withSelection("contact_id=? AND mimetype = ?", new String[]{String.valueOf(string), "vnd.android.cursor.item/organization"}).withValue("data1", str2).withValue("data4", str3).withValue("data5", str4);
        arrayList.add(withValue.build());
        withValue.withYieldAllowed(true);
        int i8 = 0;
        while (i8 < i) {
            if (strArr[i8] == null) {
                i3 = i;
                builder2 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValue("raw_contact_id", String.valueOf(str5)).withValue("mimetype", "vnd.android.cursor.item/phone_v2").withValue("data1", strArr3[i8]).withValue("data2", numArr2[i8]);
            } else {
                i3 = i;
                builder2 = ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI).withSelection("_id=?", new String[]{String.valueOf(strArr[i8])}).withValue("data1", strArr3[i8]).withValue("data2", numArr2[i8]);
            }
            arrayList.add(builder2.build());
            i8++;
            i = i3;
        }
        for (int i9 = 0; i9 < i2; i9++) {
            if (strArr5[i9] == null) {
                builder = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValue("raw_contact_id", String.valueOf(str5)).withValue("mimetype", "vnd.android.cursor.item/email_v2").withValue("data1", strArr4[i9]).withValue("data2", numArr3[i9]);
            } else {
                builder = ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI).withSelection("_id=?", new String[]{String.valueOf(strArr5[i9])}).withValue("data1", strArr4[i9]).withValue("data2", numArr3[i9]);
            }
            arrayList.add(builder.build());
        }
        if (!(str6 == null || str6.isEmpty() || (decodeFile = BitmapFactory.decodeFile(str6)) == null)) {
            arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/photo").withValue("data15", toByteArray(decodeFile)).build());
        }
        ReadableMap readableMap3 = readableMap;
        ReadableArray array3 = readableMap3.hasKey("postalAddresses") ? readableMap3.getArray("postalAddresses") : null;
        if (array3 != null) {
            for (int i10 = 0; i10 < array3.size(); i10++) {
                ReadableMap map3 = array3.getMap(i10);
                arrayList.add(ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI).withSelection("raw_contact_id=? AND mimetype = ?", new String[]{String.valueOf(string), "vnd.android.cursor.item/postal-address_v2"}).withValue("mimetype", "vnd.android.cursor.item/postal-address_v2").withValue("data2", Integer.valueOf(mapStringToPostalAddressType(map3.getString(str8)))).withValue("data4", map3.getString("street")).withValue("data7", map3.getString("city")).withValue("data8", map3.getString("state")).withValue("data9", map3.getString("postCode")).withValue("data10", map3.getString("country")).build());
            }
        }
        try {
            ContentResolver contentResolver = getReactApplicationContext().getContentResolver();
            ContentProviderResult[] applyBatch = contentResolver.applyBatch("com.android.contacts", arrayList);
            if (applyBatch != null && applyBatch.length > 0) {
                Object[] objArr = {null, new ctz(contentResolver).O00000Oo(string)};
                callback2 = callback;
                try {
                    callback2.invoke(objArr);
                } catch (Exception e) {
                    e = e;
                }
            }
        } catch (Exception e2) {
            e = e2;
            callback2 = callback;
            callback2.invoke(e.toString());
        }
    }

    @ReactMethod
    public void deleteContact(ReadableMap readableMap, Callback callback) {
        String string = readableMap.hasKey("recordID") ? readableMap.getString("recordID") : null;
        try {
            if (getReactApplicationContext().getContentResolver().delete(Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, string), null, null) > 0) {
                callback.invoke(null, string);
            } else {
                callback.invoke(null, null);
            }
        } catch (Exception e) {
            callback.invoke(e.toString(), null);
        }
    }

    @ReactMethod
    public void checkPermission(Callback callback) {
        callback.invoke(null, isPermissionGranted());
    }

    @ReactMethod
    public void requestPermission(Callback callback) {
        requestReadContactsPermission(callback);
    }

    private void requestReadContactsPermission(Callback callback) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            callback.invoke(null, "denied");
        } else if (isPermissionGranted().equals("authorized")) {
            callback.invoke(null, "authorized");
        } else {
            requestCallback = callback;
            oOOO00o0.O000000o(currentActivity, new String[]{"android.permission.READ_CONTACTS"}, 888);
        }
    }

    protected static void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Callback callback = requestCallback;
        if (callback != null) {
            if (i != 888) {
                callback.invoke(null, "denied");
                return;
            }
            Hashtable hashtable = new Hashtable();
            for (int i2 = 0; i2 < strArr.length; i2++) {
                hashtable.put(strArr[i2], Boolean.valueOf(iArr[i2] == 0));
            }
            if (!hashtable.containsKey("android.permission.READ_CONTACTS") || !((Boolean) hashtable.get("android.permission.READ_CONTACTS")).booleanValue()) {
                requestCallback.invoke(null, "denied");
            } else {
                requestCallback.invoke(null, "authorized");
            }
            requestCallback = null;
        }
    }

    private String isPermissionGranted() {
        return getReactApplicationContext().checkCallingOrSelfPermission("android.permission.READ_CONTACTS") == 0 ? "authorized" : "denied";
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003f A[ORIG_RETURN, RETURN, SYNTHETIC] */
    private int mapStringToPhoneType(String str) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode != -1068855134) {
            if (hashCode != 3208415) {
                if (hashCode == 3655441 && str.equals("work")) {
                    c = 1;
                    if (c != 0) {
                        return 1;
                    }
                    if (c != 1) {
                        return c != 2 ? 7 : 2;
                    }
                    return 3;
                }
            } else if (str.equals("home")) {
                c = 0;
                if (c != 0) {
                }
            }
        } else if (str.equals("mobile")) {
            c = 2;
            if (c != 0) {
            }
        }
        c = 65535;
        if (c != 0) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003f A[ORIG_RETURN, RETURN, SYNTHETIC] */
    private int mapStringToEmailType(String str) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode != -1068855134) {
            if (hashCode != 3208415) {
                if (hashCode == 3655441 && str.equals("work")) {
                    c = 1;
                    if (c != 0) {
                        return 1;
                    }
                    if (c != 1) {
                        return c != 2 ? 3 : 4;
                    }
                    return 2;
                }
            } else if (str.equals("home")) {
                c = 0;
                if (c != 0) {
                }
            }
        } else if (str.equals("mobile")) {
            c = 2;
            if (c != 0) {
            }
        }
        c = 65535;
        if (c != 0) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    private int mapStringToPostalAddressType(String str) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode != 3208415) {
            if (hashCode == 3655441 && str.equals("work")) {
                c = 1;
                if (c != 0) {
                    return c != 1 ? 3 : 2;
                }
                return 1;
            }
        } else if (str.equals("home")) {
            c = 0;
            if (c != 0) {
            }
        }
        c = 65535;
        if (c != 0) {
        }
    }
}
