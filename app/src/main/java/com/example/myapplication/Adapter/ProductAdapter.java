package com.example.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Activities.CardProductActivity;
import com.example.myapplication.Objects.Product;
import com.example.myapplication.R;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private final List<Product> productList;
    private final LayoutInflater inflater;

    public ProductAdapter(List<Product> productList, Context context) {
        this.productList = productList;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.product_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.imageProduct.setImageResource(product.getImageProduct());
        holder.titleProduct.setText("Название: \n" + product.getTitle());
        holder.priceProduct.setText("Цена: \n" + product.getPrice() + " ₽");
        holder.countProduct.setText("Количество:\n" + Integer.toString(product.getCount()));
        holder.infProduct.setText("Описание:\n" + product.getDescription());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), CardProductActivity.class);
            intent.putExtra(Product.class.getSimpleName(),product);
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView imageProduct;
        public final TextView titleProduct, priceProduct, countProduct, infProduct;
        ViewHolder(View view){
            super(view);
            imageProduct = view.findViewById(R.id.imgProduct);
            titleProduct = view.findViewById(R.id.titleProduct);
            priceProduct = view.findViewById(R.id.priceProduct);
            countProduct = view.findViewById(R.id.countProduct);
            infProduct = view.findViewById(R.id.infProduct);
        }

    }
}
