package com.inpheller.moneytor.app.model.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by mangamon on 5/26/14.
 */
@DatabaseTable(tableName = "expenses")
public class Expense {

    @DatabaseField(generatedId = true)
    private long id;
    @DatabaseField
    private String currency;
    @DatabaseField
    private Float ammount;
    @DatabaseField
    private Date date;
//    @ForeignCollectionField
//    private List<Label> labels;

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

//    public List<Label> getLabels() {
//        return labels;
//    }
//
//    public void setLabels(List<Label> labels) {
//        this.labels = labels;
//    }
}
