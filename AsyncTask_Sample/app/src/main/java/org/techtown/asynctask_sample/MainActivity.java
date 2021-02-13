package org.techtown.asynctask_sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    BackgroundTask task;
    int value;

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                task = new BackgroundTask();
                task.execute();
            }
        });

        Button btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                task.cancel(true);
            }
        });
    }

    class BackgroundTask extends AsyncTask<Integer, Integer, Integer>{
        @Override
        protected void onPreExecute() {
            value = 0;
            progressBar.setProgress(value);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            progressBar.setProgress(0);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            progressBar.setProgress(values[0].intValue());
        }

        @Override
        protected void onCancelled() {
            progressBar.setProgress(0);
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            while(isCancelled() == false){
                value++;
                if (value >= 100){
                    break;
                } else {
                    publishProgress(value);
                }

                try{
                    Thread.sleep(100);
                }catch(InterruptedException ex){}
            }
            return value;
        }
    }
}