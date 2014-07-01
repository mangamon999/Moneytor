package com.inpheller.moneytor.app.model.relationship;

import com.inpheller.moneytor.app.model.entity.Expense;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.misc.BaseDaoEnabled;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by mangamon on 6/8/14.
 */
@DatabaseTable()
public class ExpenseLabel extends BaseDaoEnabled<ExpenseLabel, Integer> {

    @DatabaseField
    private Long id;

    @DatabaseField(foreign = true)
    private Expense expense;

    @DatabaseField(foreign = true)
    private Expense label;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }

    public Expense getLabel() {
        return label;
    }

    public void setLabel(Expense label) {
        this.label = label;
    }
}
