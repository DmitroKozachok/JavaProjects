package com.example.taskmanager.utils;


import android.widget.Toast;

import com.example.taskmanager.application.HomeApplication;

public class MyLogger {
    public static void toast(String text) {
        Toast.makeText(HomeApplication.getAppContext(), text, Toast.LENGTH_SHORT).show();
    }
}
