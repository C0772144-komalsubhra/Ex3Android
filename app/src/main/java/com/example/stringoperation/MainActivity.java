package com.example.stringoperation;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnNext;
    private EditText edtName;
    private TextView txtResult;
    public static int REQUEST_FEATURE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNext = findViewById(R.id.btnNext);
        edtName = findViewById(R.id.edtName);
        txtResult = findViewById(R.id.txtResult);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtName.getText().toString().isEmpty())
                {
                    edtName.setError("Enter Name");
                }
                else {
                    String name = edtName.getText().toString();
                    Intent mIntent = new Intent(MainActivity.this, OperationsActivity.class);
                    mIntent.putExtra("Name", name);
                    startActivityForResult(mIntent, REQUEST_FEATURE);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK)
        {
            if(requestCode == REQUEST_FEATURE)
            {
                String finalString = data.getStringExtra("finalString");
                txtResult.setText(finalString);
            }
        }

    }
}
