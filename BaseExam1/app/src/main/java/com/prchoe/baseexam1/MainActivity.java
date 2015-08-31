package com.prchoe.baseexam1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView mListView = null;
    BaseAdapterEx mAdapter = null;
    List<Students> mData = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initAdapter();
        initListView();
    }

    private void initData() {
        mData = new ArrayList();

    }

    private void initAdapter() {
        mAdapter = new BaseAdapterEx(getApplicationContext(), mData);
    }

    private void initListView() {
        mListView = (ListView)findViewById(R.id.list_view);
        mListView.setAdapter(mAdapter);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_btn:
                EditText nameEt = (EditText)findViewById(R.id.name_edit);
                EditText numberEt = (EditText)findViewById(R.id.number_edit);
                EditText departmentEt = (EditText)findViewById(R.id.department_edit);

                Students addData = new Students();

                addData.mName = nameEt.getText().toString();
                addData.mNumber = numberEt.getText().toString();
                addData.mDepartment = departmentEt.getText().toString();

                mAdapter.add(0, addData);
                break;

            case R.id.del_btn:
                EditText delItemIndexEt = (EditText)findViewById(R.id.del_item_index_edit);

                Integer index = Integer.parseInt(delItemIndexEt.getText().toString());
                mAdapter.delete(index);
                break;

            case R.id.all_del_btn:
                mAdapter.clear();
                break;
        }
    }

}
