package com.uet.qpn.soaonce;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.uet.qpn.soaonce.model.Book;

public class EditActivity extends AppCompatActivity {
    private Button btnSave;

    private EditText editName;
    private EditText editAuthor;
    private EditText editQuantity;
    private Book book;
    private String position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        init();

        Intent intent = getIntent();
        book = (Book) intent.getSerializableExtra("book");
        position = intent.getStringExtra("position");

        editName.setText(book.getName());
        editQuantity.setText(String.valueOf(book.getQuantityInStock()));
        editAuthor.setText(book.getAuthor());

        btnSave.setOnClickListener(Save_OnClick);



    }

    public void init() {
        book = null;
        btnSave = findViewById(R.id.btnSave);

        editName = findViewById(R.id.editName);
        editAuthor = findViewById(R.id.editAuthor);
        editQuantity = findViewById(R.id.editQuantity);

    }

    View.OnClickListener Save_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Book booked = new Book(editName.getText().toString(), Integer.valueOf(editQuantity.getText().toString()), editAuthor.getText().toString(), book.getCode());
            Intent intent = new Intent();
            intent.putExtra("booked", booked);
            intent.putExtra("position", position);
            setResult(RESULT_OK, intent);
            finish();

        }
    };
}
