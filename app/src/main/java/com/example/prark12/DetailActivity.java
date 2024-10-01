package com.example.prark12;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView nameTextView = findViewById(R.id.detail_name);
        TextView capitalTextView = findViewById(R.id.detail_capital);
        ImageView flagImageView = findViewById(R.id.detail_flag);

        String name = getIntent().getStringExtra("name");
        String capital = getIntent().getStringExtra("capital");
        int flagResource = getIntent().getIntExtra("flag", 0);

        nameTextView.setText(name);
        capitalTextView.setText(capital);
        flagImageView.setImageResource(flagResource);
    }
}
