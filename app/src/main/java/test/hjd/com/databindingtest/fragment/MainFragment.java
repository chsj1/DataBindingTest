package test.hjd.com.databindingtest.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import test.hjd.com.databindingtest.R;
import test.hjd.com.databindingtest.databinding.FragmentMainBinding;
import test.hjd.com.databindingtest.model.User;

/**
 * Created by allen on 2019-09-04.
 */
public class MainFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentMainBinding fragmentMainBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);

        User user = new User("dd", "25", 37000);
        fragmentMainBinding.setUserInfo(user);
        return fragmentMainBinding.getRoot();
    }
}
