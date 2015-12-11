package top.bryon.memeoryanalyze;

import android.app.Activity;
import android.os.Bundle;

import top.bryon.memeoryanalyze.manager.AppManger;

/**
 * Created by bryonliu on 2015/12/10.
 */
public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManger.getInstance().add(this);
    }
}
