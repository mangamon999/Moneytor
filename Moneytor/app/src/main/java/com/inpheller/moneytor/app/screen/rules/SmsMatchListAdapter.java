package com.inpheller.moneytor.app.screen.rules;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import com.inpheller.moneytor.app.R;
import com.inpheller.moneytor.app.sms.SmsEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mangamon on 5/13/14.
 */
public class SmsMatchListAdapter extends ArrayAdapter<SmsEntry> {

    private final List<SmsEntry> items;
    private MatchFilter matchFilter;

    public SmsMatchListAdapter(Context context, int resource, List<SmsEntry> objects) {
        super(context, resource, objects);
        this.items = objects;
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

        public SmsViewHolder(View view) {
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

    @Override
    public Filter getFilter() {
        if (matchFilter == null)
            matchFilter = new MatchFilter();
        return matchFilter;
    }

    private class MatchFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence regex) {
            // NOTE: this function is *always* called from a background thread, and
            // not the UI thread.
            FilterResults result = new FilterResults();
            if (regex != null && regex.toString().length() > 0) {
                ArrayList<SmsEntry> filt = new ArrayList<SmsEntry>();

                for (int i = 0, l = items.size(); i < l; i++) {
                    SmsEntry entry = items.get(i);
                    if (entry.getBody().matches(regex.toString())) {
                        filt.add(entry);
                    }
                }

                result.count = filt.size();
                result.values = filt;
            } else {
                synchronized (this) {
                    result.values = items;
                    result.count = items.size();
                }
            }

            return result;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence regex, FilterResults results) {
            // NOTE: this function is *always* called from the UI thread.
            List<SmsEntry> filtered = (ArrayList<SmsEntry>) results.values;
            clear();
            for (int i = 0, l = filtered.size(); i < l; i++) {
                add(filtered.get(i));
            }

            notifyDataSetChanged();
        }
    }
}
