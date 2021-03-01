package com.example.hello_toast_;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hello_toast_.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);

        binding =ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

        binding.buttonCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCount++;
                binding.showCount.setText("" + mCount);
                if (mCount !=0) {
                    binding.buttonZero.setBackgroundColor(Color.GREEN);
                    if (mCount % 2 == 0) {
                        binding.showCount.setText("" + mCount);
                        binding.buttonCount.setBackgroundColor(Color.BLACK);
                    } else {
                        binding.showCount.setText("" + mCount);
                        binding.buttonCount.setBackgroundColor(Color.MAGENTA);
                    }
                }
            }
        });

        binding.buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                mCount=0;
                binding.showCount.setText(""+mCount);
                binding.buttonZero.setBackgroundColor(Color.GRAY);
                binding.buttonCount.setBackgroundColor(Color.BLUE);
            }
        });
    }


    public void showToast(View view) {
        Toast toast= Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }

}