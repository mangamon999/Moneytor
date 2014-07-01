package com.inpheller.moneytor.app.screen.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.inpheller.moneytor.app.R;
import com.inpheller.moneytor.app.sms.SmsEntry;

import java.util.List;

/**
 * Created by mangamon on 5/13/14.
 */
public class SmsSearchListAdapter extends ArrayAdapter<SmsEntry> {

    public SmsSearchListAdapter(Context context, int resource, List<SmsEntry> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView = view;
        SmsViewHolder holder;

        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.sms_list_item, viewGroup, false);

            holder = new SmsViewHolder(rowView);
            rowView.setTag(holder);
        } else {
            holder = (SmsViewHolder) rowView.getTag();
        }

        holder.loadSms(getItem(i));

        return rowView;
    }

    private static class SmsViewHolder {


        private final View view;
        private final ImageView thumbnailImageView;
        private final TextView senderTextView;
        private final TextView messageTextView;

        public SmsViewHolder (View view) {
            this.view = view;
            this.thumbnailImageView = (ImageView) view.findViewById(R.id.thumbnail);
            this.senderTextView = (TextView) view.findViewById(R.id.sender);
            this.messageTextView = (TextView) view.findViewById(R.id.message);
        }

        public void loadSms(SmsEntry smsEntry) {
            this.senderTextView.setText(smsEntry.getAddress());
            this.messageTextView.setText(smsEntry.getBody());
        }
    }
}
