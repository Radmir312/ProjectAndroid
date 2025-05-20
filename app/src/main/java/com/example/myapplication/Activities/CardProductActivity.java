package com.example.myapplication.Activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.Objects.Product;
import com.example.myapplication.R;

public class CardProductActivity extends AppCompatActivity {

    TextView productName, productPrice,productDescription;
    ImageView productImage;
    Button AddToBasketBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_card_product);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        productName = findViewById(R.id.ProductName);
        productPrice = findViewById(R.id.ProductPrice);
        productDescription = findViewById(R.id.ProductDescription);
        productImage = findViewById(R.id.ProductPhoto);
        AddToBasketBtn = findViewById(R.id.AddToBasketBtn);
        loadInfo();
    }
    private void loadInfo(){
        Bundle arguments = getIntent().getExtras();
        Product product = (Product)  arguments.getSerializable(Product.class.getSimpleName());
        productName.setText("Наименование" + product.getTitle());
        productPrice.setText("Цена: " + Double.toString(product.getPrice()) + " Р");
        productDescription.setText("Описание: " + product.getDescription());
        productImage.setImageResource(product.getImageProduct());
    }

}