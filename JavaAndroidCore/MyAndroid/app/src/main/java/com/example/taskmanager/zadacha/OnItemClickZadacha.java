package com.example.taskmanager.zadacha;

import com.example.taskmanager.dto.zadachi.ZadachaItemDTO;

public interface OnItemClickZadacha {
    //При натиску отримуємо задачу
    void onItemClick(ZadachaItemDTO zadacha);
}
