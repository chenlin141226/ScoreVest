package com.hardy.jaffa.myapplication.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hardy.jaffa.myapplication.R;
import com.hardy.jaffa.myapplication.dagger.conponent.DaggerInfoFragmentConponent;
import com.hardy.jaffa.myapplication.dagger.conponent.InfoFragmentConponent;
import com.hardy.jaffa.myapplication.dagger.module.InfoFragmentModule;
import com.hardy.jaffa.myapplication.model.VodBean;
import com.hardy.jaffa.myapplication.presenter.fragment.InfoFragmentPresenter;
import com.hardy.jaffa.myapplication.ui.adapter.InfoPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

//资讯Fragment
public class InfoFragment extends Fragment {

    Unbinder unbinder;
    @Inject
    InfoFragmentPresenter presenter;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    private List<VodBean> data;
    private InfoPagerAdapter fragmentAdapter;
    private List<String> channelNames;
    private List<Fragment> mFragmentList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerInfoFragmentConponent.Builder builder = DaggerInfoFragmentConponent.builder();
        builder.infoFragmentModule(new InfoFragmentModule(this));
        InfoFragmentConponent conponent = builder.build();
        conponent.in(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, null);
        unbinder = ButterKnife.bind(this, view);
        tvTitle.setText("资讯");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.getData();
    }

    //获取资讯界面数据
    public void setData(List<VodBean> data) {
        if (!isAdded()) {
            return;
        }
        this.data = data;
        channelNames = new ArrayList<>();
        mFragmentList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            //添加tab
            channelNames.add(data.get(i).getName());
            //添加fragment
            mFragmentList.add(createListFragments(data.get(i)));
        }

        if (fragmentAdapter == null) {

            fragmentAdapter = new InfoPagerAdapter(getChildFragmentManager(), channelNames, mFragmentList);
        } else {
            //刷新fragment
            fragmentAdapter.setFragments(getChildFragmentManager(), channelNames, mFragmentList);
        }

        mViewPager.setAdapter(fragmentAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

    }


    //创建Fragment
    private Fragment createListFragments(VodBean vodBean) {
        InfoDetailsFragment fragment = new InfoDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("keyword", vodBean.getKeyword());
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
