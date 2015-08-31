package com.prchoe.baseexam1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by massivCode on 2015-08-28.
 */
public class BaseAdapterEx extends BaseAdapter {

    Context mContext = null;
    List<Students> mData = null;
    LayoutInflater mLayoutInflater = null;

    public BaseAdapterEx(Context context, List<Students> data) {
        mContext = context;
        mData = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    /**
     * 리스트 뷰에서 자식 아이템 개수를 결정하기 위해 호출한다.
     * @return 어댑터는 현재 자신이 가지고 있는 데이터의 개수를 전달한다.
     */
    @Override
    public int getCount() {
        return mData.size();
    }

    /**
     * 특정 아이템 위치에 표시할 데이터를 전달한다.
     * @param position
     * @return
     */
    @Override
    public Students getItem(int position) {
        return mData.get(position);
    }

    /**
     * 특정 아이템 위치에 표시할 데이터의 위치를 전달한다.
     * @param position
     * @return
     */
    @Override
    public long getItemId(int position) {
        return position;
    }


    class ViewHolder {
        TextView mNameTv;
        TextView mNumberTv;
        TextView mDepartmentTv;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View itemLayout = convertView;
        ViewHolder viewHolder = null;

       // 1. 어댑터 뷰가 재사용할 뷰를 넘겨주지 않은 경우에만 새로운 뷰를 생성한다.
        if(itemLayout == null) {
            itemLayout = mLayoutInflater.inflate(R.layout.list_view_item_layout, null);

            // ViewHolder를 생성하고 사용할 자식 뷰를 찾아 View Holder에 참조시킨다.
            // 생성된 ViewHolder는 아이템에 설정해두고, 다음에 아이템 재사용시 참조한다.
            viewHolder = new ViewHolder();
            viewHolder.mNameTv = (TextView)itemLayout.findViewById(R.id.name_text);
            viewHolder.mNumberTv = (TextView)itemLayout.findViewById(R.id.number_text);
            viewHolder.mDepartmentTv = (TextView)itemLayout.findViewById(R.id.department_text);
            itemLayout.setTag(viewHolder);

        } else {
            // 재사용 아이템에는 이전에 View Holder 객체를 설정해 두었다.
            // 그러므로 설정된 View Holder 객체를 이용해서 findViewById 함수를
            // 사용하지 않고 원하는 뷰를 참조할 수 있다.
            viewHolder = (ViewHolder)itemLayout.getTag();
        }


        // 2. 이름, 학번, 학과 데이터를 참조하여 레이아웃을 갱신한다.
        viewHolder.mNameTv.setText(mData.get(position).mName);
        viewHolder.mNumberTv.setText(mData.get(position).mNumber);
        viewHolder.mDepartmentTv.setText(mData.get(position).mDepartment);


        return itemLayout;
    }

    public void add(int index, Students addData) {
        mData.add(index, addData);
        notifyDataSetChanged();
    }

    public void delete(int index) {
        mData.remove(index);
        notifyDataSetChanged();
    }

    public void clear() {
        mData.clear();
        notifyDataSetChanged();
    }
}
