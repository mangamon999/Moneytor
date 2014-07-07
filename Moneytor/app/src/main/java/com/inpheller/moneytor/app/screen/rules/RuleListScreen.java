package com.inpheller.moneytor.app.screen.rules;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.inpheller.moneytor.app.R;
import com.inpheller.moneytor.app.model.DatabaseHelper;
import com.inpheller.moneytor.app.model.entity.Rule;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;

import java.sql.SQLException;
import java.util.ArrayList;

public class RuleListScreen extends OrmLiteBaseActivity<DatabaseHelper> {

    private ListView ruleList;
    private ArrayList<Rule> ruleItemsList = new ArrayList<Rule>();
    private ArrayAdapter<Rule> ruleListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule_list_screen);

        updateRulesList();

        ruleListAdapter = new ArrayAdapter<Rule>(this, android.R.layout.simple_list_item_1, ruleItemsList);

        ruleList = (ListView) findViewById(R.id.rule_list);
        ruleList.setAdapter(ruleListAdapter);
        ruleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Rule selectedRule = ruleListAdapter.getItem(i);

                Intent ruleSettingsScreen = new Intent(RuleListScreen.this, RuleSettingsScreen.class);
                ruleSettingsScreen.putExtra(RuleSettingsScreen.PARAM_RULE_ID, selectedRule.getId());
                startActivity(ruleSettingsScreen);
            }
        });
    }

    private void updateRulesList() {
        try {
            ruleItemsList.clear();
            ruleItemsList.addAll(getHelper().getRulesDao().queryForAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        updateRulesList();
        ruleListAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.rule_list_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_done) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
