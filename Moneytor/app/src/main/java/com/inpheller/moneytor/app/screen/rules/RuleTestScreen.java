package com.inpheller.moneytor.app.screen.rules;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.inpheller.moneytor.app.R;
import com.inpheller.moneytor.app.model.DatabaseHelper;
import com.inpheller.moneytor.app.model.entity.Rule;
import com.inpheller.moneytor.app.sms.SmsEntry;
import com.inpheller.moneytor.app.sms.SmsHelper;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public class RuleTestScreen extends OrmLiteBaseActivity<DatabaseHelper> {

    public static final String PARAM_RULE_REGEX = "PARAM_RULE_REGEX";
    private SmsMatchListAdapter smsListAdapter;
    private ListView listView;
    private String regex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule_test_screen);

        List<SmsEntry> filteredSmsList = new SmsHelper(this).getAllMessages();
        smsListAdapter = new SmsMatchListAdapter(this, R.layout.sms_list_item, filteredSmsList);
        regex = getIntent().getStringExtra(PARAM_RULE_REGEX);
        smsListAdapter.getFilter().filter(regex);
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
        if (id == R.id.action_create) {

            Dao<Rule, Integer> rulesDao = getHelper().getRulesDao();
            List<Rule> rules;

            Rule rule = new Rule("new rule", regex);
            rule.setDao(rulesDao);

            rule.setRegex(regex);

            try {
                rule.create();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
