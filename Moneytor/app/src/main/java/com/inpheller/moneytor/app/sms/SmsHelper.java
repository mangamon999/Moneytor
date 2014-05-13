package com.inpheller.moneytor.app.sms;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brunopinheiro on 5/13/14.
 */
public class SmsHelper {
    private Activity context;

    public SmsHelper(Activity activity) {
        this.context = activity;
    }

    public List<SmsEntry> getAllMessages() {
        Uri uriSMSURI = Uri.parse("content://sms/inbox");
        Cursor cur = this.context.getContentResolver().query(uriSMSURI, null, null, null,null);

        List<SmsEntry> allSms = new ArrayList<SmsEntry>();

        while (cur.moveToNext()) {
            SmsEntry sms = SmsEntry.createFromCursor(cur);

            allSms.add(sms);
        }

        return allSms;
    }
}
