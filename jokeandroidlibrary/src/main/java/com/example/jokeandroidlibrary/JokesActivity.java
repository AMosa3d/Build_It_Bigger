package com.example.jokeandroidlibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);

        TextView joke = (TextView) findViewById(R.id.joke_textView);
        Intent intent = getIntent();

        if (intent != null)
            joke.setText(intent.getStringExtra(getString(R.string.joke_intent_key)));
    }
}
