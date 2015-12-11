package top.bryon.memeoryanalyze.manager;

import android.app.Activity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bryonliu on 2015/12/10.
 */
public class AppManger {
    private static List<Activity> activities = new ArrayList<>();

    private static List<View.OnClickListener> listeners= new ArrayList<>();
    private static AppManger instance;

    public synchronized static AppManger getInstance() {
        if (instance == null) {
            instance = new AppManger();
        }
        return instance;
    }

    private AppManger(){

    }
    public void add(Activity activity) {
        activities.add(activity);
    }

    public void remove(Activity activity) {
        activities.remove(activity);
    }

    public void register(View.OnClickListener listener){
        listeners.add(listener);
    }
}
