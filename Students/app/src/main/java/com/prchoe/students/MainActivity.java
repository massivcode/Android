
package com.prchoe.students;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText mDisplayDbEt = null;

    public StudentsDBManager mDbManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDisplayDbEt = (EditText) findViewById(R.id.edit_text);

        mDbManager = StudentsDBManager.getInstance(getApplicationContext());
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.insert:
                ContentValues addRowValue = new ContentValues();
                addRowValue.put("number", "200106054");
                addRowValue.put("name", "홍길동");
                addRowValue.put("department", "컴퓨터");
                addRowValue.put("grade", 3);

                long insertRecordId = mDbManager.insert(addRowValue);
                mDisplayDbEt.setText("레코드 추가 : " + insertRecordId);
                break;
            case R.id.update:

                break;
            case R.id.delete:
                break;
            case R.id.query:
                String[] columns = new String[] {
                        "_id", "number", "name", "department", "grade"
                };

                Cursor c = mDbManager.query(columns, null, null, null, null, null);

                if (c != null) {
                    mDisplayDbEt.setText("");

                    while (c.moveToNext()) {
                        int id = c.getInt(0);
                        String number = c.getString(1);
                        String name = c.getString(2);
                        String department = c.getString(3);
                        int grade = c.getInt(4);

                        mDisplayDbEt.append(
                                "id : " + id + "\n" +
                                        "number : " + number + "\n" +
                                        "name : " + name + "\n" +
                                        "department : " + department + "\n" +
                                        "grade : " + grade + "\n" +
                                        "-----------------------------"
                                );
                        mDisplayDbEt.append("\n Total : " + c.getCount());

                    }
                }
                c.close();
                break;
        }
    }

}
