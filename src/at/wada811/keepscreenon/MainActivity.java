package at.wada811.keepscreenon;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.WindowManager;

public class MainActivity extends FragmentActivity {

    private ScreenOffReceiver mScreenOffReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
        setContentView(R.layout.activity_main);
        mScreenOffReceiver = new ScreenOffReceiver();
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("LogUtils", "onResume");
        //スクリーンオンを検知する場合はIntent.ACTION_SCREEN_ONに変更
        IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_OFF);
        registerReceiver(mScreenOffReceiver, filter);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("LogUtils", "onDestroy");
        unregisterReceiver(mScreenOffReceiver);
    }

}
