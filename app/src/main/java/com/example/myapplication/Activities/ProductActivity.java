package com.example.myapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.ProductAdapter;
import com.example.myapplication.Objects.Product;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity {

    ArrayList<Product> products = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        uploadProducts();

        RecyclerView recyclerView = findViewById(R.id.recycleViewProduct);

        ProductAdapter productAdapter = new ProductAdapter(products,this);
        recyclerView.setAdapter(productAdapter);
    }

    void uploadProducts(){
        products.add(new Product(1,"Сметана","Вкусная очень",200,20,"white",R.drawable.smetana));
        products.add(new Product(2,"Кока-кола","Газировка",90,10,"black",R.drawable.coca_cola));
        products.add(new Product(3,"Сыр","Сырочек)",555,15,"yellow",R.drawable.cheese));
    }
    public void buttonToBasket(View view){
        Intent intent = new Intent(this, BasketActivity.class);
        startActivity(intent);
    }
}