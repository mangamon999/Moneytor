package com.inpheller.moneytor.app.rules;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

import com.inpheller.moneytor.app.R;
import com.inpheller.tools.layout.FlowLayout;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class RuleEditorScreen extends Activity {

    public static final String PARAM_SMS_MESSAGE = "PARAM_SMS_MESSAGE";

    private String smsMessage;
    private String[] smsMessageParts;
    private FlowLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule_editor_screen);

        if (savedInstanceState != null) {
            this.smsMessage = savedInstanceState.getString(PARAM_SMS_MESSAGE);

        } else {
            this.smsMessage = getIntent().getStringExtra(PARAM_SMS_MESSAGE);
        }

        this.smsMessageParts = this.smsMessage.split(" ");
        this.container = (FlowLayout) findViewById(R.id.container);

        for (String part : this.smsMessageParts) {
            ToggleButton button = new ToggleButton(this);
            button.setBackgroundColor(Color.GRAY);
            button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton button, boolean checked) {
                    if (checked) {
                        button.setBackgroundColor(Color.BLUE);
                    } else {
                        button.setBackgroundColor(Color.GRAY);
                    }
                }
            });

            button.setLayoutParams(new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT));

            button.setText(part);
            button.setTextOn(part);
            button.setTextOff(part);
            button.setTextColor(Color.WHITE);

            this.container.addView(button);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        this.smsMessage = savedInstanceState.getString(PARAM_SMS_MESSAGE);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(PARAM_SMS_MESSAGE, this.smsMessage);
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.rule_editor_screen, menu);
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
