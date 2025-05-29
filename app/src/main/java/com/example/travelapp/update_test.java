package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class update_test extends AppCompatActivity {
    private EditText etName, etPassword, etRePassword;
    private Button update;
    private Button fanhui;
    private UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_test);
        userDAO = new UserDAO(this);
        find();
    }

    private void find() {
        etName = findViewById(R.id.etname2);
        etPassword = findViewById(R.id.edpassword2);
        etRePassword = findViewById(R.id.repassword1);
        update = findViewById(R.id.update1);
        fanhui = findViewById(R.id.fanhui2);
    }

    public void xiugai(View view) {
        String phone = etName.getText().toString().trim();
        String oldPassword = etPassword.getText().toString().trim();
        String newPassword = etRePassword.getText().toString().trim();

        if (!validatePhone(phone)) {
            Toast.makeText(this, "请输入11位手机号", Toast.LENGTH_SHORT).show();
            return;
        }

        if (oldPassword.isEmpty() || newPassword.isEmpty()) {
            Toast.makeText(this, "请输入原密码和新密码", Toast.LENGTH_SHORT).show();
            return;
        }

        // 验证新密码是否为 6 位数字
        if (!validateNewPassword(newPassword)) {
            Toast.makeText(this, "新密码必须为 6 位数字", Toast.LENGTH_SHORT).show();
            return;
        }

        int updateResult = userDAO.update(phone, newPassword, oldPassword);
        if (updateResult != -1) {
            // 显示密码修改成功的提示信息
            Toast.makeText(this, "密码修改成功！", Toast.LENGTH_SHORT).show();
            // 跳转到登录界面
            Intent intent = new Intent(update_test.this, MainActivity.class);
            startActivity(intent);
            // 关闭当前修改密码界面
            finish();
        } else {
            Toast.makeText(this, "密码修改失败！", Toast.LENGTH_SHORT).show();
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

    // 验证新密码是否为 6 位数字
    private boolean validateNewPassword(String newPassword) {
        return newPassword.length() == 6 && newPassword.matches("^[0-9]+$");
    }
}