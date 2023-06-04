package com.xk.application;

import android.content.Intent;

import androidx.fragment.app.Fragment;

public class AgentWebFileUploader {
    public static final int REQUEST_CODE_FILE_PICKER = 1;

    public static void showFileChooser(Fragment fragment) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("*/*");
        fragment.startActivityForResult(Intent.createChooser(intent, "Choose File"), REQUEST_CODE_FILE_PICKER);
    }
}
