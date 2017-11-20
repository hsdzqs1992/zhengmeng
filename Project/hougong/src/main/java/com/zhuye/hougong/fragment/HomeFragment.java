package com.zhuye.hougong.fragment;

import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.youth.banner.Banner;
import com.zhuye.hougong.R;
import com.zhuye.hougong.base.BaseFragment;
import com.zhuye.hougong.bean.HomeBanner;
import com.zhuye.hougong.contants.Contants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzzy on 2017/11/20.
 */

public class HomeFragment extends BaseFragment {

    private Banner banner;

    @Override
    protected void initView() {


        banner= rootView.findViewById(R.id.home_banner);

    }

    @Override
    protected int getResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        super.initData();

        OkGo.<String>post("http://192.168.1.102/gong/index.php/home/hall/lunbo")
                .tag(getActivity())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {

                        Gson gson = new Gson();
                        HomeBanner homeBanner = gson.fromJson(response.body(), HomeBanner.class);
                        Log.d("------",homeBanner.toString());
                        List url = new ArrayList();
                        url.add(Contants.BASE_URL+homeBanner.getData().get(0).getImg());
                        url.add(Contants.BASE_URL+homeBanner.getData().get(1).getImg());
                        url.add(Contants.BASE_URL+homeBanner.getData().get(2).getImg());
                        ImageView iv = new ImageView(getActivity());
                        Glide.with(getActivity()).load(url.get(0)).into(iv);
                        List ivs = new ArrayList();
                        ivs.add(iv);
                        banner.setImages(ivs);
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        Log.d("------",response.body());
                    }
                });

    }
}
