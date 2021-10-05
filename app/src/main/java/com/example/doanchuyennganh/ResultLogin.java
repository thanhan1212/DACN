package com.example.doanchuyennganh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.doanchuyennganh.model.Account;

public class ResultLogin extends AppCompatActivity {
    private TextView txtUserName;
    private TextView txtEmail;
    private Account account;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_login);
        Intent intent = getIntent();
        account = new Account();
        account = (Account) intent.getSerializableExtra("login");
        addControl();
    }

    private void addControl() {
        txtUserName = (TextView) findViewById(R.id.txtUserName);
        Button button = (Button) findViewById(R.id.button1);
        /**Set value*/
        txtUserName.setText(account.getSdt());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtUserName.setVisibility(View.INVISIBLE);
            }
        });
    }
}
