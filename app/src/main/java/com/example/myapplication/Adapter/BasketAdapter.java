package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Objects.BasketItem;
import com.example.myapplication.Objects.Product;
import com.example.myapplication.R;

import java.util.List;

public class BasketAdapter extends RecyclerView.Adapter<BasketAdapter.ViewHolder> {
    private final List<BasketItem> basketItems;
    private final LayoutInflater inflater;

    public BasketAdapter(List <BasketItem> basketItems, Context context){
        this.basketItems = basketItems;
        this.inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public BasketAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.basket_item,parent,false);

        return new ViewHolder(view); 
    }
    @Override
    public void onBindViewHolder(@NonNull BasketAdapter.ViewHolder holder, int position) {
        BasketItem basketItem = basketItems.get(position);
        Product product = basketItem.getProduct();

        holder.titleTextView.setText(product.getTitle());
        holder.productImageViewBasket.setImageResource(product.getImageProduct());
        holder.priceTextView.setText(String.valueOf(product.getPrice()));
        holder.quantityPriceTextView.setText(String.valueOf(basketItem.getQuantity()));
        holder.totalPriceTextView.setText(String.valueOf(basketItem.getTotalPrice()));
        //кпноки

        holder.plusButton.setOnClickListener(v -> {
            int newQuantity = basketItem.getQuantity() + 1;

            basketItem.setQuantity(newQuantity);
            holder.quantityPriceTextView.setText(String.valueOf(basketItem.getQuantity()));
            holder.totalPriceTextView.setText(String.valueOf(basketItem.getTotalPrice()));
            notifyItemChanged(position);
        });
        holder.minusButton.setOnClickListener(v -> {
            if(basketItem.getQuantity() > 1) {
                int newQuantity = basketItem.getQuantity() - 1;

                basketItem.setQuantity(newQuantity);
                holder.quantityPriceTextView.setText(String.valueOf(basketItem.getQuantity()));
                holder.totalPriceTextView.setText(String.valueOf(basketItem.getTotalPrice()));
                notifyItemChanged(position);
            }
            else{
                basketItems.remove(position);
                notifyItemRemoved(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return basketItems.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
            ImageView productImageViewBasket;
            TextView titleTextView, priceTextView, totalPriceTextView, quantityPriceTextView;
            Button minusButton, plusButton;

            ViewHolder(View view){
                super(view);
                productImageViewBasket = view.findViewById(R.id.productImageBasket);

                titleTextView = view.findViewById(R.id.titleTextViewBasket);
                priceTextView = view.findViewById(R.id.priceTextViewBasket);
                totalPriceTextView = view.findViewById(R.id.totalPriceTextViewBasket);
                quantityPriceTextView = view.findViewById(R.id.quantityTextViewBasket);

                minusButton = view.findViewById(R.id.minusButton);
                plusButton = view.findViewById(R.id.plusButton);

            }

    }
}
