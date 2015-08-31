package com.prchoe.viewpager1;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by massivCode on 2015-08-31.
 */
public class CustomPagerAdapter extends PagerAdapter {

    private Context context;

    public CustomPagerAdapter(Context context) {
        this.context = context;
    }

    /**
     * 페이지 뷰의 개수를 리턴합니다.
     * @return
     */
    @Override
    public int getCount() {
        return 3;
    }

    /**
     * 페이지 뷰인 view의 키가 obj이면 true를, 그렇지 않으면 false를 리턴 시키세요
     * 만약 페이지 뷰의 키가 자신과 동일하다면, (view == obj)가 true인지만 확인하면 됩니다.
     * @param pageView
     * @param pageKey
     * @return
     */
    @Override
    public boolean isViewFromObject(View pageView, Object pageKey) {
        return (pageView == pageKey);
    }

    /**
     * position 위치에 속하는 페이지 뷰를 container로부터 삭제합니다.​
     * pageKey는 position 위치에 속하는 페이지 뷰의 키입니다.
     * 만약 페이지 뷰와 ​키가 동일하다면, container 객체의 removeView 메소드를 바로 호출하여 페이지를 삭제할 수 있습니다.
     * 이 때 이 메소드의 파라메터에는 pageKey를 바로 대입하면 됩니다.
     * @param container
     * @param position
     * @param pageKey
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object pageKey) {
        container.removeView((View)pageKey);
    }



    /**
     * position 위치에 속하는 페이지 뷰를 생성하고, 이를 container 뷰에 추가합니다.​
     * 이 메소드의 리턴 값은 페이지 뷰를 식별하기 위한 키로 활용됩니다.
     * 리턴 값은 생성한 페이지 뷰​로 해도 무방합니다.
     * 이 경우 페이지 뷰와 키는 동일합니다.
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 뷰 페이저에 추가할 페이지
        View page = inflater.inflate(R.layout.page_example, null);

        // 페이지의 이미지를 설정한 후 페이지를 뷰 페이저에 추가
        TextView textView = (TextView)page.findViewById(R.id.textView);
        textView.setText("Page " + position);
        container.addView(page, 0);

        return page;
    }


}
