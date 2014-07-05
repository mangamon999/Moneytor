package com.inpheller.moneytor.app.screen.rules;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.inpheller.moneytor.app.R;
import com.inpheller.moneytor.app.model.DatabaseHelper;
import com.inpheller.moneytor.app.model.entity.Rule;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;

import java.sql.SQLException;

public class RuleSettingsScreen extends OrmLiteBaseActivity<DatabaseHelper> {

    public static final String PARAM_RULE_ID = "PARAM_RULE_ID";

    private ListView actionsListView;
    private EditText ruleNameInput;
    private TextView ruleComponets;
    private Rule rule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule_settings_screen);

        actionsListView = (ListView) findViewById(R.id.rule_actions_list);
        ruleComponets = (TextView) findViewById(R.id.rule_components);
        ruleNameInput = (EditText) findViewById(R.id.rule_name_input);

        long ruleId = getIntent().getLongExtra(PARAM_RULE_ID, -1);

        try {
            rule = getHelper().getRulesDao().queryForId(ruleId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        populate(rule);
    }

    private void populate(Rule rule) {
        ruleNameInput.setText(rule.getName());
        ruleComponets.setText(rule.getPrettyRegex());
        actionsListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new String[]{"Dummy action #1", "Dummy action #2", "Dummy action #3"}));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.rule_settings_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_save) {
            try {
                rule.setName(ruleNameInput.getText().toString());
                rule.update();
                finish();
            } catch (SQLException e) {
                //TODO: Feedback
                e.printStackTrace();
            }

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
