package examples.theandroidsuit.heavytaskrunnableexample;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.Random;


public class MainActivity extends HeavyTaskActivity {


    private final String TAG = getClass().getSimpleName();

    private ImageView mImage;
    private ProgressBar mProgressBar;


    public MainActivity(){}
    public MainActivity(String tag) {
        super(tag);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImage = (ImageView) findViewById(R.id.imageView);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);

    }

    public void callHeavyTask(View view) {

        Log.d(TAG, "downloadImage()");

        mImage.setImageDrawable(null);
        mProgressBar.setVisibility(View.VISIBLE);

        // Do heavy Task in separately thread
        doHeavyTask();

    }


    public  void returnResults(){
        Log.d(TAG, "returnResults()");

        mProgressBar.setVisibility(View.GONE);
        mImage.setImageResource(R.drawable.android_suit);
    }


    @Override
    protected void heavyTask() throws Exception{
        Log.d(TAG, "heavyTaskRunnable()");

        Random rnd = new Random();
        int randomSecs = rnd.nextInt((10 - 5) + 1) + 5;

        // It is a heavy task that spends a lot of time
        Thread.sleep(randomSecs * 1000);
    }

}
