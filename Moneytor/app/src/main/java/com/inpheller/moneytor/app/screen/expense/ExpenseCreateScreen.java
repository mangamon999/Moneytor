package com.inpheller.moneytor.app.screen.expense;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.inpheller.moneytor.app.R;
import com.inpheller.moneytor.app.model.DatabaseHelper;
import com.inpheller.moneytor.app.model.entity.Expense;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

public class ExpenseCreateScreen extends OrmLiteBaseActivity<DatabaseHelper> {

    private EditText amountInput;
    private EditText labelsInput;
    private DatePicker datePicker;
    private EditText annotationsInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_create_screen);

        amountInput = (EditText) findViewById(R.id.amount_input);
        labelsInput = (EditText) findViewById(R.id.labels_input);
        datePicker = (DatePicker) findViewById(R.id.date_picker);
        annotationsInput = (EditText) findViewById(R.id.annotations_input);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.expense_create_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_done) {
            Dao<Expense, Integer> expenseDao = getHelper().getExpenseDao();
            Expense newExpense = new Expense();
            newExpense.setDao(expenseDao);

            Calendar selectedDate = Calendar.getInstance();
            selectedDate.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
            newExpense.setDate(selectedDate.getTime());
            newExpense.setCurrency("R$");
            newExpense.setAmmount(Float.valueOf(amountInput.getText().toString()));
            newExpense.setAnnotations(annotationsInput.getText().toString());
            newExpense.setLabels(labelsInput.getText().toString());

            try {
                newExpense.create();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
