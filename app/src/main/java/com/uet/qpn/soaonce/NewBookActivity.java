package com.uet.qpn.soaonce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.uet.qpn.soaonce.model.Book;

public class NewBookActivity extends AppCompatActivity {

    private Button btnSave;

    private EditText addName;
    private EditText addAuthor;
    private EditText addQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_book);
        init();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                if (!addQuantity.getText().toString().trim().equals("")
                        && !addName.getText().toString().trim().equals("")
                        && !addAuthor.getText().toString().trim().equals("")) {

                    book.setQuantityInStock(Integer.valueOf(addQuantity.getText().toString()));
                    book.setAuthor(addAuthor.getText().toString());
                    book.setName(addName.getText().toString());

                    Intent intent = new Intent();
                    intent.putExtra("new_book", book);
                    setResult(RESULT_OK, intent);
                    finish();

                }
            }
        });

    }

    public void init() {
        btnSave = findViewById(R.id.btnSave);

        addName = findViewById(R.id.addName);
        addAuthor = findViewById(R.id.addAuthor);
        addQuantity = findViewById(R.id.addQuantity);


    }
}
