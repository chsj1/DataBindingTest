package test.hjd.com.databindingtest.model;

import android.databinding.ObservableField;

/**
 * Created by allen on 2019-09-05.
 */
public class ObservableGoods {
    public ObservableField<String> name;

    public ObservableGoods(String name) {
        this.name = new ObservableField<>(name);
    }

    public ObservableField<String> getName() {
        if (name == null) {
            name = new ObservableField<>();
        }
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }
}
