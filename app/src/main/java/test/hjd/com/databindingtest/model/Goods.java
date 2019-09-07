package test.hjd.com.databindingtest.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import test.hjd.com.databindingtest.BR;

/**
 * Created by allen on 2019-09-05.
 */
public class Goods extends BaseObservable {
    @Bindable
    public String name;
    private int price;
    public String detail;

    public Goods(String name, int price, String detail) {
        this.name = name;
        this.price = price;
        this.detail = detail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

        /*
        通知更新所有的字段(如果该字段的值有更新.不管他是否加了@Bindable注解)
         */
        notifyChange();
    }

    @Bindable
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
//        notifyChange();

        /*
        只是更新本字段
         */
        notifyPropertyChanged(BR.price);
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
