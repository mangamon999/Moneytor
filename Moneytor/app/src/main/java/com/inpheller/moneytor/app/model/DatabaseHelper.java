package com.inpheller.moneytor.app.model;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.inpheller.moneytor.app.model.entity.Expense;
import com.inpheller.moneytor.app.model.entity.Label;
import com.inpheller.moneytor.app.model.entity.Rule;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.Date;

/**
 * Database helper class used to manage the creation and upgrading of your database. This class also usually provides
 * the DAOs used by the other classes.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    // name of the database file for your application -- change to something appropriate for your app
    private static final String DATABASE_NAME = "moneytor.db";
    // any time you make changes to your database objects, you may have to increase the database version
    private static final int DATABASE_VERSION = 2;

    // the DAO object we use to access the Expense table
    private Dao<Expense, Integer> expensesDao = null;
    private Dao<Rule, Integer> rulesDao;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is first created. Usually you should call createTable statements here to create
     * the tables that will store your data.
     */
    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            Log.i(DatabaseHelper.class.getName(), "onCreate");
            TableUtils.createTable(connectionSource, Expense.class);
            TableUtils.createTable(connectionSource, Label.class);
            TableUtils.createTable(connectionSource, Rule.class);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }

//        // here we try inserting data in the on-create as a test
//        Dao<Expense, Integer> dao = getExpenseDao();
//        long millis = System.currentTimeMillis();
//        // create some entries in the onCreate
//        Expense simple = new Expense();
//        simple.setAmmount((float) millis);
//        simple.setCurrency("R$");
//        simple.setDate(new Date());
//        dao.create(simple);
//        simple = new Expense();
//        simple.setAmmount((float) millis);
//        simple.setCurrency("$");
//        simple.setDate(new Date());
//        dao.create(simple);
//        Log.i(DatabaseHelper.class.getName(), "created new entries in onCreate: " + millis);
    }

    /**
     * This is called when your application is upgraded and it has a higher version number. This allows you to adjust
     * the various data to match the new version number.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            Log.i(DatabaseHelper.class.getName(), "onUpgrade");
            TableUtils.dropTable(connectionSource, Expense.class, true);
            TableUtils.dropTable(connectionSource, Label.class, true);
            TableUtils.dropTable(connectionSource, Rule.class, true);
            // after we drop the old databases, we create the new ones
            onCreate(db, connectionSource);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns the RuntimeExceptionDao (Database Access Object) version of a Dao for our Expense class. It will
     * create it or just give the cached value. RuntimeExceptionDao only through RuntimeExceptions.
     */
    public Dao<Expense, Integer> getExpenseDao() {
        if (expensesDao == null) {
            try {
                expensesDao = getDao(Expense.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return expensesDao;
    }

    public Dao<Rule, Integer> getRulesDao() {
        if (rulesDao == null) {
            try {
                rulesDao = getDao(Rule.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rulesDao;
    }

    /**
     * Close the database connections and clear any cached DAOs.
     */
    @Override
    public void close() {
        super.close();
        expensesDao = null;
        rulesDao = null;
    }
}
