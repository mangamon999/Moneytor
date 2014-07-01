package com.inpheller.moneytor.app.model.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.misc.BaseDaoEnabled;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by mangamon on 6/8/14.
 */
@DatabaseTable(tableName = "rules")
public class Rule extends BaseDaoEnabled {

    public static final String REGEX_FIELD_NAME = "regex";

    @DatabaseField(generatedId = true)
    private Long id;

    @DatabaseField
    private String name;

    @DatabaseField(index = true)
    private String regex;

    //TODO: Associate actions


    public Rule(String name, String regex) {
        this.name = name;
        this.regex = regex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Rule{" + name + ": '" + regex + "'}";
    }
}
