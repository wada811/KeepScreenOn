package at.wada811.keepscreenon;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.WindowManager;

public class MainActivity extends FragmentActivity {

    private ScreenOffReceiver mScreenOffReceiver;
    private HomeButtonReceiver mHomeButtonReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d("LogUtils", "onCreate");
        Log.d("LogUtils", "savedInstanceState: " + savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
        setContentView(R.layout.activity_main);
        mScreenOffReceiver = new ScreenOffReceiver();
        mHomeButtonReceiver = new HomeButtonReceiver();
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("LogUtils", "onResume");
        KeepScreenOnUtils.registerScreenOffReceiver(this, mScreenOffReceiver);
//        KeepScreenOnUtils.registerHomeButtonReceviver(this, mHomeButtonReceiver);
    }

    @Override
    protected void onUserLeaveHint(){
        super.onUserLeaveHint();
        Log.d("LogUtils", "onUserLeaveHint");
        KeepScreenOnUtils.startNewActivity(this, MainActivity.class);
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("LogUtils", "onPause");
        KeepScreenOnUtils.startActivity(this, MainActivity.class);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("LogUtils", "onDestroy");
        unregisterReceiver(mScreenOffReceiver);
//        unregisterReceiver(mHomeButtonReceiver);
    }

}
