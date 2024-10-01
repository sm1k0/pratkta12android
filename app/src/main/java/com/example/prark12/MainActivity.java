package com.example.prark12;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        List<State> states = new ArrayList<>();
        states.add(new State("Россия", "Москва", R.drawable.russia_flag));
        states.add(new State("Германия", "Берлин", R.drawable.germany_flag));
        states.add(new State("Франция", "Париж", R.drawable.france_flag));
        states.add(new State("Италия", "Рим", R.drawable.italy_flag));
        states.add(new State("Япония", "Токио", R.drawable.japan_flag));
        states.add(new State("Канада", "Оттава", R.drawable.canada_flag));
        states.add(new State("Китай", "Пекин", R.drawable.china_flag));
        states.add(new State("Австралия", "Канберра", R.drawable.australia_flag));
        states.add(new State("Бразилия", "Бразилиа", R.drawable.brazil_flag));
        states.add(new State("Индия", "Нью-Дели", R.drawable.india_flag));
        states.add(new State("Мексика", "Мехико", R.drawable.mexico_flag));
        states.add(new State("Испания", "Мадрид", R.drawable.spain_flag));
        states.add(new State("Южная Корея", "Сеул", R.drawable.south_korea_flag));
        states.add(new State("Египет", "Каир", R.drawable.egypt_flag));
        states.add(new State("Швеция", "Стокгольм", R.drawable.sweden_flag));
        states.add(new State("Швейцария", "Берн", R.drawable.switzerland_flag));
        states.add(new State("Аргентина", "Буэнос-Айрес", R.drawable.argentina_flag));
        states.add(new State("Норвегия", "Осло", R.drawable.norway_flag));
        states.add(new State("Финляндия", "Хельсинки", R.drawable.finland_flag));

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        StateAdapter adapter = StateAdapter.createStateAdapter(this, states);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener((view, position) -> {
            State clickedState = states.get(position);
            if (clickedState != null) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("name", clickedState.getName());
                intent.putExtra("capital", clickedState.getCapital());
                intent.putExtra("flag", clickedState.getFlagResource());
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Ошибка: состояние не найдено", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
