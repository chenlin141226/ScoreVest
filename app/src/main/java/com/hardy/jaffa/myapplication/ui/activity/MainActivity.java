package com.hardy.jaffa.myapplication.ui.activity;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.hardy.jaffa.myapplication.R;
import com.hardy.jaffa.myapplication.ui.fragment.HomeFragment;
import com.hardy.jaffa.myapplication.ui.fragment.InfoFragment;
import com.hardy.jaffa.myapplication.ui.fragment.MeFragment;
import com.hardy.jaffa.myapplication.ui.fragment.ScoreFragment;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.main_fragment_container)
    FrameLayout mainFragmentContainer;
    @BindView(R.id.main_bottome_switcher_container)
    LinearLayout mainBottomeSwitcherContainer;

    ArrayList<Fragment> fragments = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initInjector() {
        super.initInjector();
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void initView() {
        super.initView();
        fragments.add(new HomeFragment());
        fragments.add(new ScoreFragment());
        fragments.add(new InfoFragment());
        fragments.add(new MeFragment());
        onClickListener.onClick(mainBottomeSwitcherContainer.getChildAt(0));
    }

    /**
     *  需求：完成一个通用底部导航的处理
     */
    protected void setListener() {
        // 所有孩子，不包括孙子
        int childCount = mainBottomeSwitcherContainer.getChildCount();

        for (int i = 0; i < childCount; i++) {
            FrameLayout childAt = (FrameLayout) mainBottomeSwitcherContainer.getChildAt(i);//FrameLayout
            childAt.setOnClickListener(onClickListener);
        }
    }

    private View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int index=mainBottomeSwitcherContainer.indexOfChild(view);
            changeUi(index);
            changeFragment(index);
        }
    };

    private void changeFragment(int index) {
        // 通过这个底部容器Item的index能够获取到对应的Fragment，需要将所有的Fragment对号放好（使用集合）
        Fragment fragment = fragments.get(index);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment_container,fragment)
                .commit();
    }

    /**
     * 改变Index对应的孩子的状态，包括这个孩子中多有控件的状态（不可用状态：enable=false）
     * 改变其他的孩子的状态，，包括这些孩子中多有控件的状态
     * @param index
     */
    private void changeUi(int index) {
        //Toast.makeText(this,""+index,Toast.LENGTH_SHORT).show();

        int childCount = mainBottomeSwitcherContainer.getChildCount();

        for (int i = 0; i < childCount; i++) {

            // 判断i是否与index相同
            // 相同：不可用状态：enable=false
            if(i==index){
                // 不可以再点击了
//                mainBottomeSwitcherContainer.getChildAt(i).setEnabled(false);
                // 每个Item中的控件都需要切换状态
                setEnable(mainBottomeSwitcherContainer.getChildAt(i),false);

            }else{
                // 不可以再点击了
//                mainBottomeSwitcherContainer.getChildAt(i).setEnabled(true);
                // 每个Item中的控件都需要切换状态
                setEnable(mainBottomeSwitcherContainer.getChildAt(i),true);
            }


        }

    }
    /**
     * 将每个Item中的所用控件状态一同改变
     * 由于我们处理一个通用的代码，那么Item可能会有很多层，所以我们需要使用递归
     * @param item
     * @param b
     */
    private void setEnable(View item, boolean b) {
        item.setEnabled(b);
        if(item instanceof ViewGroup)
        {
            int childCount = ((ViewGroup) item).getChildCount();
            for (int i = 0; i < childCount; i++) {
                setEnable(((ViewGroup) item).getChildAt(i),b);
            }
        }
    }
}
