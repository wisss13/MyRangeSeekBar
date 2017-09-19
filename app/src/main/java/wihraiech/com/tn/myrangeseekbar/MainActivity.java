package wihraiech.com.tn.myrangeseekbar;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.lzyzsd.circleprogress.DonutProgress;
import com.squareup.picasso.Picasso;

import retrofit.RestAdapter;
import wihraiech.com.tn.myrangeseekbar.util.rangeseekbar.RangeSeekBar;


public class MainActivity extends AppCompatActivity {

    TextView tv_price;
    Button mButton, mButton2;
    ProgressBar mProgressBar;
    ImageView mImageView;
    DonutProgress mDonutProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup the new range seek bar
        RangeSeekBar<Integer> rangeSeekBar = new RangeSeekBar<Integer>(this);
        // Set the range
        rangeSeekBar.setRangeValues(0, 200);
        rangeSeekBar.setSelectedMinValue(20);
        rangeSeekBar.setSelectedMaxValue(50);

        // Add to layout
        LinearLayout layout = (LinearLayout) findViewById(R.id.seekbar_placeholder);
        layout.addView(rangeSeekBar);

        tv_price = (TextView) findViewById(R.id.tv_price);
        tv_price.setText("De " + rangeSeekBar.getSelectedMinValue() + " à " + rangeSeekBar.getSelectedMaxValue() + " DT");

        rangeSeekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
                //Toast.makeText(MainActivity.this, "min: " + bar.getSelectedMinValue(), Toast.LENGTH_SHORT).show();
                tv_price.setText("De " + bar.getSelectedMinValue() + " à " + bar.getSelectedMaxValue() + " DT");
            }
        });

        //ImageView
        mImageView = (ImageView) findViewById(R.id.imageView);


        // ProgressBar
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        mDonutProgress = (DonutProgress) findViewById(R.id.donut_progress);
        mDonutProgress.setMax(100);

        mButton = (Button) findViewById(R.id.button);
        mButton2 = (Button) findViewById(R.id.button2);

        mProgressBar.setVisibility(View.INVISIBLE);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgressBar.setVisibility(View.VISIBLE);

                for(int i=0;i<100;i++){
                    mDonutProgress.setProgress(i);

                    /*try{
                        Thread.sleep(200);
                    }catch (InterruptedException ie)
                    {
                        ie.printStackTrace();
                    }*/
                }
            }
        });

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgressBar.setVisibility(View.INVISIBLE);
            }
        });




    }


}
