package examples.theandroidsuit.heavytaskrunnableexample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;


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


    protected abstract Runnable heavyTaskRunnable();

    protected void doHeavyTask(){

        Log.d(TAG, "doHeavyTask()");

        Runnable action = heavyTaskRunnable();

        Thread backgroundTask = new Thread(action);
        backgroundTask.start();
    }
}
