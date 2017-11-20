package com.zhuye.hougong.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhuye.hougong.R;
import com.zhuye.hougong.weidgt.MyToolbar;

/**
 * Created by zzzy on 2017/11/20.
 */

public class MeFragment extends Fragment {


    private MyToolbar myToolbar;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_me,null);

        myToolbar = view.findViewById(R.id.mee_toolbar);

        myToolbar.hideView(myToolbar.homeLeftIcon);

        return view;
    }
}
