package com.uet.qpn.soaonce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.uet.qpn.soaonce.webservice.client.Book;

public class NewBookActivity extends AppCompatActivity {

    private Button btnSave;

    private EditText addName;
    private EditText addAuthor;
    private EditText addQuantity;
    private EditText addCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_book);
        init();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    Book book = new Book();
                    if (!addQuantity.getText().toString().trim().equals("")
                            && !addName.getText().toString().trim().equals("")
                            && !addAuthor.getText().toString().trim().equals("")) {

                        book.setQuantityInStock(Integer.valueOf(addQuantity.getText().toString()));
                        book.setAuthor(addAuthor.getText().toString());
                        book.setName(addName.getText().toString());
                        book.setCode(addCode.getText().toString());

                        Intent intent = new Intent();
                        intent.putExtra("new_book", book);
                        setResult(RESULT_OK, intent);
                        finish();

                    }

                } catch (RuntimeException e) {
                    Toast.makeText(getApplicationContext(), "Invalid input", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public void init() {
        btnSave = findViewById(R.id.btnSave);

        addCode = findViewById(R.id.addCode);
        addName = findViewById(R.id.addName);
        addAuthor = findViewById(R.id.addAuthor);
        addQuantity = findViewById(R.id.addQuantity);


    }
}
