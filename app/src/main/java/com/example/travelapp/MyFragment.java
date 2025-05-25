package com.example.travelapp;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {

    private ImageView ivMyAvatar;
    private ImageView ivSelectArrow;
    private TextView tvMyUsername;
    private EditText etNewUsername;
    private Button btnSelectAvatar, btnChangeUsername, btnViewArticles, btnDeleteArticles, btnLogout;

    private int[] avatarIds = {
            R.drawable.avatar1,
            R.drawable.avatar2,
            R.drawable.avatar3,
            R.drawable.avatar4,
            R.drawable.avatar5
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);

        // 初始化视图组件
        ivMyAvatar = view.findViewById(R.id.iv_my_avatar);
        ivSelectArrow = view.findViewById(R.id.iv_select_arrow);
        tvMyUsername = view.findViewById(R.id.tv_my_username);
        etNewUsername = view.findViewById(R.id.et_new_username);
        btnSelectAvatar = view.findViewById(R.id.btn_select_avatar);
        btnChangeUsername = view.findViewById(R.id.btn_change_username);
        btnViewArticles = view.findViewById(R.id.btn_view_articles);
        btnDeleteArticles = view.findViewById(R.id.btn_delete_articles);
        btnLogout = view.findViewById(R.id.btn_logout);

        // 设置选择箭头点击事件
        ivSelectArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAvatarSelectionDialog();
            }
        });

        // 设置选择头像按钮点击事件
        btnSelectAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAvatarSelectionDialog();
            }
        });

        // 设置修改用户名按钮点击事件
        btnChangeUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newUsername = etNewUsername.getText().toString().trim();
                if (!newUsername.isEmpty()) {
                    tvMyUsername.setText(newUsername);
                    etNewUsername.setText("");
                    Toast.makeText(getActivity(), "用户名修改成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "请输入新用户名", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // 设置查看心得按钮点击事件
        btnViewArticles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 实现查看心得逻辑，这里可以跳转到一个新的界面显示心得列表
                Toast.makeText(getActivity(), "查看心得功能待实现", Toast.LENGTH_SHORT).show();
            }
        });

        // 设置删除心得按钮点击事件
        btnDeleteArticles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 实现删除心得逻辑，这里可以弹出一个确认对话框，确认后删除心得
                Toast.makeText(getActivity(), "删除心得功能待实现", Toast.LENGTH_SHORT).show();
            }
        });

        // 设置退出登录按钮点击事件
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 实现退出登录逻辑，这里可以清除用户登录状态并跳转到登录界面
                Toast.makeText(getActivity(), "退出登录功能待实现", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private void showAvatarSelectionDialog() {
        String[] avatarOptions = {"1", "2", "3", "4", "5"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("选择头像");
        builder.setItems(avatarOptions, (dialog, which) -> {
            ivMyAvatar.setImageResource(avatarIds[which]);
            Toast.makeText(getActivity(), "头像已更换为 " + (which + 1), Toast.LENGTH_SHORT).show();
        });
        builder.show();
    }
}