package com.prchoe.students;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by massivCode on 2015-08-28.
 */
public class StudentsDBManager {

    static final String DB_STUDENTS = "Students.db";
    static final String TABLE_STUDENTS = "Students";
    static final int    DB_VERSION = 1;

    Context mContext = null;

    private static StudentsDBManager mDbManager = null;
    private SQLiteDatabase mDatabase = null;

    public static  StudentsDBManager getInstance(Context context) {

        if(mDbManager == null) {
            mDbManager = new StudentsDBManager(context);
        }

        return mDbManager;
    }

    private StudentsDBManager(Context context) {
        mContext = context;

        mDatabase = context.openOrCreateDatabase(DB_STUDENTS, Context.MODE_PRIVATE, null);

        mDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_STUDENTS + "(" + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
        + "number TEXT, "
        + "name TEXT, "
        + "department TEXT, "
        + "grade INTEGER ); ");
    }

    public long insert(ContentValues addRowValue) {
        return mDatabase.insert(TABLE_STUDENTS, null, addRowValue);
    }

    /**
     * @param table : 검색 대상 테이블명
     * @param columns : 검색 결과로 얻게 될 컬럼명
     * @param selection : where=?
     * @param selectionArgs : where=? 에서 ?. ? 들
     * @param groupBy
     * @param having
     * @param orderBy
     * @return
     */

    public Cursor query(String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
        return mDatabase.query(TABLE_STUDENTS, columns, selection, selectionArgs, groupBy, having, orderBy);
    }

    public int update(ContentValues updateRowValue, String whereClause, String[] whereArgs) {
        return mDatabase.update(TABLE_STUDENTS, updateRowValue, whereClause, whereArgs);
    }



}
