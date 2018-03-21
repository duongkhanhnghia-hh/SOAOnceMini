package com.uet.qpn.soaonce;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.uet.qpn.soaonce.adapter.RclViewAdapter;
import com.uet.qpn.soaonce.model.Book;

import java.util.ArrayList;

import static com.uet.qpn.soaonce.config.Config.KEY_SEND_MAINACT_TO_EDITACT;
import static com.uet.qpn.soaonce.config.Config.KEY_SEND_TO_NEWBOOK_ACT;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RclViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        swipeRefreshLayout.setOnRefreshListener(RefreshEvent);

    }

    public void init() {

        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("A", 1, "a", "a"));

        recyclerView = findViewById(R.id.rclViewBook);
        swipeRefreshLayout = findViewById(R.id.swipeToRefresh);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RclViewAdapter(books, this);
        recyclerView.setAdapter(adapter);
    }

    SwipeRefreshLayout.OnRefreshListener RefreshEvent = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            swipeRefreshLayout.setRefreshing(false);
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_book_option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nm_op_addbook:
                Intent intent = new Intent(this, NewBookActivity.class);
                startActivityForResult(intent, KEY_SEND_TO_NEWBOOK_ACT);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == KEY_SEND_MAINACT_TO_EDITACT) {
            if (resultCode == RESULT_OK) {
                Book book = (Book) data.getSerializableExtra("booked");
                String position = data.getStringExtra("position");
                adapter.resultEditActivity(book, Integer.valueOf(position));
                recyclerView.setAdapter(adapter);
                // edit book
            }
        } else if (requestCode == KEY_SEND_TO_NEWBOOK_ACT) {
            if (resultCode == RESULT_OK) {
                Book book = (Book) data.getSerializableExtra("new_book");
                adapter.resultAddBook(book);

                // add book
            }

        }
    }
}
