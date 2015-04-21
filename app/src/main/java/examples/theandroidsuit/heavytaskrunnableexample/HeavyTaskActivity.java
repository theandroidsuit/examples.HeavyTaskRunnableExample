package examples.theandroidsuit.heavytaskrunnableexample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.util.Random;


public abstract class HeavyTaskActivity extends Activity {

    private String TAG;

    public HeavyTaskActivity(){}
    public HeavyTaskActivity(String tag){
        this.TAG = tag;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }


    protected void doHeavyTask(){

        Log.d(TAG, "doHeavyTask()");

        Runnable action = doHeavyTaskRunnable();

        Thread backgroundTask = new Thread(action);
        backgroundTask.start();
    }

    protected Runnable doHeavyTaskRunnable(){
        return new Runnable() {

            @Override
            public void run() {

                try {

                    heavyTask();

                }catch (Exception e){}

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        returnResults();
                    }
                });
            }
        };
    }


    protected abstract void heavyTask() throws Exception;
    protected abstract void returnResults();
}
