package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etPhone, etPassword;
    private Button btnLogin, btnRegister, btnUpdatePassword;
    private UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etPhone = findViewById(R.id.et_phone);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);
        btnUpdatePassword = findViewById(R.id.update2);
        userDAO = new UserDAO(this);

        btnLogin.setOnClickListener(v -> loginUser());
        btnRegister.setOnClickListener(v -> startActivity(new Intent(this, RegisterActivity.class)));
        btnUpdatePassword.setOnClickListener(v -> startActivity(new Intent(this, update_test.class)));
    }

    private void loginUser() {
        String phone = etPhone.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (!validatePhone(phone)) {
            Toast.makeText(this, "请输入11位手机号", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.isEmpty()) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        if (userDAO.validateUser(phone, password)) {
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();

            // 跳转到首页
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            finish(); // 关闭登录页，防止返回
        } else {
            Toast.makeText(this, "账号或密码错误", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validatePhone(String phone) {
        return phone.length() == 11 && phone.matches("^[0-9]+$");
    }
}