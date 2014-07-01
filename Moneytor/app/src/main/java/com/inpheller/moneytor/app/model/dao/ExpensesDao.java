package com.inpheller.moneytor.app.model.dao;

import com.inpheller.moneytor.app.model.entity.Expense;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

/**
 * Created by mangamon on 6/8/14.
 */
public class ExpensesDao extends BaseDaoImpl<Expense, Integer> {
    public ExpensesDao(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, Expense.class);
    }

    public ExpensesDao(ConnectionSource connectionSource, Class<Expense> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }
}
