package com.inpheller.moneytor.app.model.entity;

import com.inpheller.moneytor.app.model.dao.ExpensesDao;
import com.inpheller.moneytor.app.model.relationship.ExpenseLabel;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.misc.BaseDaoEnabled;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by mangamon on 5/26/14.
 */
@DatabaseTable(tableName = "expenses", daoClass = ExpensesDao.class)
public class Expense extends BaseDaoEnabled {

    @DatabaseField(generatedId = true)
    private long id;
    @DatabaseField
    private String currency;
    @DatabaseField
    private Float ammount;
    @DatabaseField
    private Date date;
    @DatabaseField
    private String labels;
    @DatabaseField
    private String annotations;

    public Expense() {
    }

    //    @ForeignCollectionField
//    private ForeignCollection<ExpenseLabel> expenseLabels;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Float getAmmount() {
        return ammount;
    }

    public void setAmmount(Float ammount) {
        this.ammount = ammount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAnnotations() {
        return annotations;
    }

    public void setAnnotations(String annotations) {
        this.annotations = annotations;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }


//    public ForeignCollection<ExpenseLabel> getLabels() {
//        return expenseLabels;
//    }
//
//    public void setLabels(ForeignCollection<ExpenseLabel> expenseLabels) {
//        this.expenseLabels = expenseLabels;
//    }
}
