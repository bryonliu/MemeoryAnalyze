package top.bryon.memeoryanalyze;

import android.os.Bundle;
import android.view.View;

import top.bryon.memeoryanalyze.manager.AppManger;

/**
 * Created by bryonliu on 2015/12/10.
 */
public class SecondActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        findViewById(R.id.img_monky).setOnClickListener(this);
       /* AppManger.getInstance().register(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_monky:
                this.finish();
                break;
            default:
                break;
        }
    }
}
