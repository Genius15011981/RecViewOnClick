package com.example.recviewonclick;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<State> states = new ArrayList<State>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Ro'yxatni chop etish
        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.list);
        // Tinglovchini aniqlaymiz
        StateAdapter.OnStateClickListener stateClickListener = (state, position) -> Toast.makeText(getApplicationContext(), "Был выбран пункт " + state.getName(),
                Toast.LENGTH_SHORT).show();
        // Adapter yaratamiz
        StateAdapter adapter = new StateAdapter(this, states, stateClickListener);
        // Ro'yxat uchun adapter yaratamiz
        recyclerView.setAdapter(adapter);
    }
    private void setInitialData(){

        states.add(new State ("O'zbekiston", "Toshkent", R.drawable.uzbekiston));
        states.add(new State ("Abxaziya", "Suxum", R.drawable.argentina));
        states.add(new State ("Angliya", "London", R.drawable.angliya));
        states.add(new State ("Argentina", "Buenos-Ayres", R.drawable.argentina));
        states.add(new State ("Avstraliya", "Sidney", R.drawable.avstraliya));
    }
}