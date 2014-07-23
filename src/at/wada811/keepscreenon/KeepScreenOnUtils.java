/*
 * Copyright 2014 wada811<at.wada811@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package at.wada811.keepscreenon;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class KeepScreenOnUtils {

    public static void startActivity(Context context, Class<?> clazz){
        Intent intent = new Intent(context, clazz);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(intent);
    }

    public static void startNewActivity(Context context, Class<?> clazz){
        Intent intent = new Intent(context, clazz);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public static void killMe(){
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    public static void registerScreenOffReceiver(Context context, ScreenOffReceiver screenOffReceiver){
        // スクリーンオンを検知する場合はIntent.ACTION_SCREEN_ONに変更
        IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_OFF);
        context.registerReceiver(screenOffReceiver, filter);
    }

    public static void registerHomeButtonReceviver(Context context, HomeButtonReceiver homeButtonReceiver){
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
        context.registerReceiver(homeButtonReceiver, filter);
    }
}
