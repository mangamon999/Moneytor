package com.inpheller.moneytor.app.sms;

import android.database.Cursor;

/**
 * Created by brunopinheiro on 5/13/14.
 */
public class SmsEntry {
    private String id = "_id";
    private String threadId = "thread_id";
    private String address = "address";

    public SmsEntry() {

    }

    public static SmsEntry createFromCursor(Cursor cursor) {
        SmsEntry smsEntry = new SmsEntry();

        smsEntry.id = cursor.getString(0);
        smsEntry.threadId = cursor.getString(1);
        smsEntry.address = cursor.getString(2);
        smsEntry.person = cursor.getString(3);
        smsEntry.date = cursor.getString(4);
        smsEntry.dateSent = cursor.getString(5);
        smsEntry.protocol = cursor.getString(6);
        smsEntry.read = cursor.getString(7);
        smsEntry.status = cursor.getString(8);
        smsEntry.type = cursor.getString(9);
        smsEntry.replyPathPresent = cursor.getString(10);
        smsEntry.subject = cursor.getString(11);
        smsEntry.body = cursor.getString(12);
        smsEntry.serviceCenter = cursor.getString(13);
        smsEntry.locked = cursor.getString(14);
        smsEntry.subId = cursor.getString(15);
        smsEntry.errorCode = cursor.getString(16);
        smsEntry.seen = cursor.getString(17);

        return smsEntry;
    }

    public SmsEntry(String id, String threadId, String address, String person, String date, String dateSent, String protocol, String read, String status, String type, String replyPathPresent, String subject, String body, String serviceCenter, String locked, String subId, String errorCode, String seen) {
        this.id = id;
        this.threadId = threadId;
        this.address = address;
        this.person = person;
        this.date = date;
        this.dateSent = dateSent;
        this.protocol = protocol;

        this.read = read;
        this.status = status;
        this.type = type;
        this.replyPathPresent = replyPathPresent;
        this.subject = subject;
        this.body = body;
        this.serviceCenter = serviceCenter;
        this.locked = locked;
        this.subId = subId;
        this.errorCode = errorCode;
        this.seen = seen;
    }

    private String person = "person";
    private String date = "date";
    private String dateSent = "date_sent";
    private String protocol = "protocol";
    private String read = "read";
    private String status = "status";
    private String type = "type";
    private String replyPathPresent = "reply_path_present";
    private String subject = "subject";
    private String body = "body";
    private String serviceCenter = "service_center";
    private String locked = "locked";
    private String subId = "sub_id";
    private String errorCode = "error_code";
    private String seen = "seen";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getThreadId() {
        return threadId;
    }

    public void setThreadId(String threadId) {
        this.threadId = threadId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateSent() {
        return dateSent;
    }

    public void setDateSent(String dateSent) {
        this.dateSent = dateSent;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getRead() {
        return read;
    }

    public void setRead(String read) {
        this.read = read;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReplyPathPresent() {
        return replyPathPresent;
    }

    public void setReplyPathPresent(String replyPathPresent) {
        this.replyPathPresent = replyPathPresent;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getServiceCenter() {
        return serviceCenter;
    }

    public void setServiceCenter(String serviceCenter) {
        this.serviceCenter = serviceCenter;
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getSeen() {
        return seen;
    }

    public void setSeen(String seen) {
        this.seen = seen;
    }

    @Override
    public String toString() {
        return "SmsEntry{" +
                "id='" + id + '\'' +
                ", threadId='" + threadId + '\'' +
                ", address='" + address + '\'' +
                ", person='" + person + '\'' +
                ", date='" + date + '\'' +
                ", dateSent='" + dateSent + '\'' +
                ", protocol='" + protocol + '\'' +
                ", read='" + read + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", replyPathPresent='" + replyPathPresent + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", serviceCenter='" + serviceCenter + '\'' +
                ", locked='" + locked + '\'' +
                ", subId='" + subId + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", seen='" + seen + '\'' +
                '}';
    }
}
