package com.hardy.jaffa.myapplication.ui.dialogs;

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
import butterknife.OnClick;
import butterknife.Unbinder;

public class ClearCacheDialog extends DialogFragment {
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

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        builder = new AlertDialog.Builder(getActivity());
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_update1, null);
        unbinder = ButterKnife.bind(this, view);
        builder.setView(view);
        return builder.create();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    @OnClick({R.id.btn_updata, R.id.iv_cancle})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_updata:
                dismiss();
                break;
            case R.id.iv_cancle:
                dismiss();
                break;
        }
    }
}
