package com.example.myapplication.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.BasketAdapter;
import com.example.myapplication.Objects.Product;
import com.example.myapplication.Objects.BasketItem;
import com.example.myapplication.R;
import java.util.ArrayList;
import java.util.List;

public class BasketActivity extends AppCompatActivity {

    private BasketAdapter basketAdapter;
    private List<BasketItem> basketItemList = new ArrayList<>();
    private RecyclerView recycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_basket);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        View recyclerView = findViewById(R.id.recycleViewBasket);
        uploadBasket();
        basketAdapter = new BasketAdapter(basketItemList, this);
        recycleView.setLayoutManager(new LinearLayoutManager(this));

        recycleView.setAdapter(basketAdapter);
    }

    private void uploadBasket(){
        Product product = new Product(1, "TEST", "test", 200, 5, "black",R.drawable.coca_cola);
        basketItemList.add(new BasketItem(product, 5));

    }
}