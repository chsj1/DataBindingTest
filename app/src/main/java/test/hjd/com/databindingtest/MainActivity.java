package test.hjd.com.databindingtest;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableArrayMap;
import android.databinding.ObservableList;
import android.databinding.ObservableMap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

//import test.hjd.com.databindingtest.databinding.ActivityMainBinding;
import test.hjd.com.databindingtest.databinding.MyBinding;
import test.hjd.com.databindingtest.model.Goods;
import test.hjd.com.databindingtest.model.ObservableGoods;
import test.hjd.com.databindingtest.model.User;

public class MainActivity extends AppCompatActivity {

    private User user;
    private Goods goods;
    private ObservableGoods observableGoods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        //布局的设置
//        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        // 通过class属性修改Binding类的名字
        MyBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //变量的设置
        user = new User("jd", "26", 35000);
        activityMainBinding.setUserInfo(user);

        User user1 = new User("junddong", "26", 35000);
        activityMainBinding.setUserInfo1(user1);

        test.hjd.com.databindingtest.model1.User user2 = new test.hjd.com.databindingtest.model1.User("junddong", "26", 36000);
        activityMainBinding.setUserInfo2(user2);


        activityMainBinding.btChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setName("jjdd");
                System.out.println("-------->user: " + user.getName());


                goods.setName("yb");
            }
        });

        activityMainBinding.btChange1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                goods.setPrice(150);
//                goods.setName("bb");
//                goods.setDetail("有月饼");

                observableGoods.setName("heihei");
            }
        });


        goods = new Goods("yuebing", 100, "月饼");
        activityMainBinding.setGoods(goods);

        /*
        使用OnPropertyChangeCallback监听属性的变化
         */
        goods.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                if (propertyId == BR.name) {
                    System.out.println("------------> BR.name");
                } else if (propertyId == BR.price) {
                    System.out.println("------------> BR.price");
                } else if (propertyId == BR._all) {
                    System.out.println("------------> BR._all");
                }
            }
        });


        observableGoods = new ObservableGoods("halo");
        activityMainBinding.setObservableGoods(observableGoods);


        ObservableList<String> observableList = new ObservableArrayList<String>();
        observableList.add("China");
        observableList.add("America");
        observableList.add("中国");

        int index = 2;
        activityMainBinding.setObsevableList(observableList);
        activityMainBinding.setIndex(index);


        ObservableMap<String, String> observableMap = new ObservableArrayMap<>();
        observableMap.put("name", "jundong");
        observableMap.put("salary", "35000");

        String key = "name";

        activityMainBinding.setObservableMap(observableMap);
        activityMainBinding.setKey(key);

        ClickHandler handler = new ClickHandler();
        activityMainBinding.setClickHandler(handler);


        activityMainBinding.vs.getViewStub().inflate();
    }

    public class ClickHandler{
        public void sayHello() {
            System.out.println("-------->say Hello");
        }
    }


    @BindingAdapter({"heihei"})
    public static void heiheiChange(View view, String heihei) {
        System.out.println("--------->heihei 发生了改变: " + heihei);
    }

//    @BindingAdapter({"android:text"})
//    public static void changeText(View view, String text) {
//        System.out.println("------->text:" + text);
//
//        if (view instanceof TextView) {
//            ((TextView)view).setText(text);
//        }
//    }


    @BindingConversion
    public static String convertStr(String text) {
        return text + "-conversion";
    }
}
