package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private Button register1;
    private Button return1;
    private EditText etRegPhone, etRegPassword;
    private UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        userDAO = new UserDAO(this);
        find();
    }

    private void find() {
        register1 = findViewById(R.id.btn_register);
        return1 = findViewById(R.id.return1);
        etRegPhone = findViewById(R.id.et_reg_phone);
        etRegPassword = findViewById(R.id.et_reg_password);
    }

    public void zhuche(View view) {
        String phone = etRegPhone.getText().toString().trim();
        String password = etRegPassword.getText().toString().trim();

        if (!validatePhone(phone)) {
            Toast.makeText(this, "请输入11位手机号", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.isEmpty()) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        if (userDAO.checkPhoneExists(phone)) {
            Toast.makeText(this, "该手机号已注册", Toast.LENGTH_SHORT).show();
            return;
        }

        User user = new User(phone, password);
        long l = userDAO.registerUser(user);
        if (l != -1) {
            Toast.makeText(this, "注册成功！", Toast.LENGTH_SHORT).show();
            Intent i3 = new Intent(this, MainActivity.class);
            startActivity(i3);
            finish();
        } else {
            Toast.makeText(this, "注册失败！", Toast.LENGTH_SHORT).show();
        }
    }

    public void fanhui(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private boolean validatePhone(String phone) {
        return phone.length() == 11 && phone.matches("^[0-9]+$");
    }
}