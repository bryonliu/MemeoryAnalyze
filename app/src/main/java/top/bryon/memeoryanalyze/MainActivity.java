package top.bryon.memeoryanalyze;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "bryon";
    private Button btnAlloctMemory, btnDeleteMemeory,btnJump2SecondActivity;
    private List<Bitmap> bitmaps = new ArrayList<>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btnAlloctMemory = $(R.id.btn_alloct_memeory);
        btnAlloctMemory.setOnClickListener(this);

        btnDeleteMemeory = $(R.id.btn_delete_memeory);
        btnDeleteMemeory.setOnClickListener(this);

        btnJump2SecondActivity =$(R.id.btn_jump2_second);
        btnJump2SecondActivity.setOnClickListener(this);

    }

    private <T> T $(int resid) {

        return (T) findViewById(resid);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_alloct_memeory:

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        long time = 0 ;
                       while(true){

                           try {
                               int loadtime = (int) (Math.sin(time)*10);
                               bitmaps = new ArrayList<Bitmap>();
                               for(int i = 0; i < loadtime;i++){

                                   alloctMemoey();
                               }
                               Thread.sleep(100);
                               time+=100;
                               //System.gc();
                              // System.gc();
                           } catch (InterruptedException e) {
                               e.printStackTrace();
                           }
                       }
                    }
                }).start();
                Toast.makeText(this, "Alloct Memeory", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_delete_memeory:
                deleteMemory();
                break;
            case R.id.btn_jump2_second:
                jump2Second();
                break;
            default:
                break;
        }
    }

    private void jump2Second() {
        Intent intent =new Intent(this,SecondActivity.class);
        startActivity(intent);
    }

    private void deleteMemory() {
        bitmaps = new ArrayList<>();
    }

    private void alloctMemoey() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_chat_black_48dp);
        bitmaps.add(bitmap);
    }
}
