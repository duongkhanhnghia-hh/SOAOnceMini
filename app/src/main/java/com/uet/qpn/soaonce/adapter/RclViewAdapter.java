package com.uet.qpn.soaonce.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uet.qpn.soaonce.EditActivity;
import com.uet.qpn.soaonce.NewBookActivity;
import com.uet.qpn.soaonce.R;
import com.uet.qpn.soaonce.model.Book;

import java.util.ArrayList;

import static com.uet.qpn.soaonce.config.Config.KEY_SEND_MAINACT_TO_EDITACT;
import static com.uet.qpn.soaonce.config.Config.KEY_SEND_TO_NEWBOOK_ACT;

public class RclViewAdapter extends RecyclerView.Adapter<RclViewAdapter.ViewHolder> {

    private ArrayList<Book> books;
    private Context context;

    public RclViewAdapter(ArrayList<Book> books, Context context) {
        this.books = books;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.viewQuantityInStock.setText(String.valueOf(books.get(position).getQuantityInStock()));
        holder.viewAuthor.setText(books.get(position).getAuthor());
        holder.viewName.setText(books.get(position).getName());
        holder.viewCode.setText(books.get(position).getCode());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EditActivity.class);
                intent.putExtra("book", books.get(position));
                intent.putExtra("position", String.valueOf(position));
                ((Activity) context).startActivityForResult(intent, KEY_SEND_MAINACT_TO_EDITACT);

            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.d("xxx", "x");
                PopupMenu popupMenu = new PopupMenu(context, holder.itemView);
                popupMenu.inflate(R.menu.add_menu);

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()) {
                            case R.id.nm_addBook:
                                Intent intent = new Intent(context, NewBookActivity.class);
                                ((Activity) context).startActivityForResult(intent, KEY_SEND_TO_NEWBOOK_ACT);
                                break;
                            case R.id.nm_delbook:
                                books.remove(position);
                                notifyItemRemoved(position);
                                notifyItemRangeChanged(position, books.size());
                                //del book


                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
                return false;
            }
        });


    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView viewName;
        TextView viewAuthor;
        TextView viewQuantityInStock;
        TextView viewCode;

        ViewHolder(View itemView) {
            super(itemView);
            viewCode = itemView.findViewById(R.id.codeBook);
            viewName = itemView.findViewById(R.id.nameOfBook);
            viewAuthor = itemView.findViewById(R.id.authorOfBook);
            viewQuantityInStock = itemView.findViewById(R.id.numOfBook);
        }
    }

    public void resultEditActivity(Book book, int position) {
        books.get(position).setCode(book.getCode());
        books.get(position).setAuthor(book.getAuthor());
        books.get(position).setName(book.getName());

        books.get(position).setQuantityInStock(book.getQuantityInStock());

    }

    public void resultAddBook(Book book) {
        books.add(book);
        notifyItemInserted(books.size() - 1);
    }


}
