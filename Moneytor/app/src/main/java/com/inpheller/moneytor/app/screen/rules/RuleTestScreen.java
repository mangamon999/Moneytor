package com.inpheller.moneytor.app.screen.rules;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.inpheller.moneytor.app.R;
import com.inpheller.moneytor.app.screen.search.SmsSearchListAdapter;
import com.inpheller.moneytor.app.sms.SmsEntry;
import com.inpheller.moneytor.app.sms.SmsHelper;

import java.util.List;

public class RuleTestScreen extends Activity {

    public static final String PARAM_RULE_REGEX = "PARAM_RULE_REGEX";
    private SmsMatchListAdapter smsListAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule_test_screen);

        List<SmsEntry> filteredSmsList = new SmsHelper(this).getAllMessages();
        smsListAdapter = new SmsMatchListAdapter(this, R.layout.sms_list_item, filteredSmsList);
        smsListAdapter.getFilter().filter(getIntent().getStringExtra(PARAM_RULE_REGEX));
        listView = (ListView) findViewById(R.id.sms_list);
        listView.setAdapter(smsListAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.rule_test_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
