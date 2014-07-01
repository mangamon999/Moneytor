package com.inpheller.moneytor.app.model.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.misc.BaseDaoEnabled;
import com.j256.ormlite.table.DatabaseTable;

import java.util.List;

/**
 * Created by mangamon on 5/26/14.
 */
@DatabaseTable(tableName = "labels")
public class Label extends BaseDaoEnabled {

    @DatabaseField(id = true)
    private long name;
//    @DatabaseField
//    private List<Expense> expenses;

    public long getName() {
        return name;
    }

    public void setName(long name) {
        this.name = name;
    }

//    public List<Expense> getExpenses() {
//        return expenses;
//    }
//
//    public void setExpenses(List<Expense> expenses) {
//        this.expenses = expenses;
//    }
}
