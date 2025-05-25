package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private EditText etRegPhone, etRegPassword, etRegConfirmPassword;
    private Button btnRegister;
    private TextView tvLogin;
    private UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // 初始化视图
        etRegPhone = findViewById(R.id.et_reg_phone);
        etRegPassword = findViewById(R.id.et_reg_password);
        etRegConfirmPassword = findViewById(R.id.et_reg_confirm_password);
        btnRegister = findViewById(R.id.btn_register);
        tvLogin = findViewById(R.id.tv_login);

        // 初始化数据库操作类
        userDAO = new UserDAO(this);

        // 设置注册按钮点击事件
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerNewUser();
            }
        });

        // 设置返回登录文本点击事件
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // 关闭当前注册页面，返回登录页面
            }
        });
    }

    // 注册新用户
    private void registerNewUser() {
        String phone = etRegPhone.getText().toString().trim();
        String password = etRegPassword.getText().toString().trim();
        String confirmPassword = etRegConfirmPassword.getText().toString().trim();

        // 验证输入
        if (!validateInputs(phone, password, confirmPassword)) {
            return;
        }

        // 检查手机号是否已注册
        if (userDAO.checkPhoneExists(phone)) {
            Toast.makeText(this, "该手机号已注册", Toast.LENGTH_SHORT).show();
            return;
        }

        // 创建新用户
        User user = new User(phone, password);
        long result = userDAO.registerUser(user);

        if (result != -1) {
            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
            finish(); // 关闭注册页面，返回登录页面
        } else {
            Toast.makeText(this, "注册失败，请重试", Toast.LENGTH_SHORT).show();
        }
    }

    // 验证输入
    private boolean validateInputs(String phone, String password, String confirmPassword) {
        if (phone.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "请填写所有字段", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!phone.matches("^[0-9]{11}$")) {
            Toast.makeText(this, "请输入有效的11位手机号", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "两次输入的密码不一致", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (password.length() < 6) {
            Toast.makeText(this, "密码长度至少为6位", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}