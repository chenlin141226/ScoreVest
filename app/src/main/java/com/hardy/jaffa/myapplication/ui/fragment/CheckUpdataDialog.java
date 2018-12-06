package com.hardy.jaffa.myapplication.ui.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.hardy.jaffa.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class CheckUpdataDialog extends DialogFragment implements View.OnClickListener {

    @BindView(R.id.btn_updata)
    Button btnUpdata;
    @BindView(R.id.iv_cancle)
    ImageView ivCancle;
    Unbinder unbinder;
    private AlertDialog.Builder builder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //设置背景透明
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void initView() {
        btnUpdata.setOnClickListener(this);
        ivCancle.setOnClickListener(this);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        builder = new AlertDialog.Builder(getActivity());
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_update1, null);
        unbinder = ButterKnife.bind(this, view);
        builder.setView(view);
        initView();
        return builder.create();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_cancle://取消对话框
                 dismiss();
                break;
            case R.id.btn_updata://跳转到连接

                break;
        }
    }
}
