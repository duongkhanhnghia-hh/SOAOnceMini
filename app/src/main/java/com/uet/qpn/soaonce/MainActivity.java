package com.uet.qpn.soaonce;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.uet.qpn.soaonce.adapter.RclViewAdapter;
import com.uet.qpn.soaonce.service.AsynInsertData;
import com.uet.qpn.soaonce.service.AsynUpdateData;
import com.uet.qpn.soaonce.webservice.client.Book;
import com.uet.qpn.soaonce.webservice.client.WebService;
import com.uet.qpn.soaonce.webservice.client.WebServiceService;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.uet.qpn.soaonce.config.Config.KEY_SEND_MAINACT_TO_EDITACT;
import static com.uet.qpn.soaonce.config.Config.KEY_SEND_TO_NEWBOOK_ACT;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RclViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ProgressBar pbBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        swipeRefreshLayout.setOnRefreshListener(RefreshEvent);

    }

    public void init() {

        ArrayList<Book> books = new ArrayList<>();
        recyclerView = findViewById(R.id.rclViewBook);
        swipeRefreshLayout = findViewById(R.id.swipeToRefresh);
        pbBar = findViewById(R.id.pgBar);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RclViewAdapter(books, this);
        recyclerView.setAdapter(adapter);


        new AsynGetData().execute();

    }

    SwipeRefreshLayout.OnRefreshListener RefreshEvent = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            adapter.resetData();
            new AsynGetData().execute();
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
                new AsynUpdateData().execute(book);
            }
        } else if (requestCode == KEY_SEND_TO_NEWBOOK_ACT) {
            if (resultCode == RESULT_OK) {
                Book book = (Book) data.getSerializableExtra("new_book");
                adapter.resultAddBook(book);

                // add book
                System.out.println("adding");
                new AsynInsertData().execute(book);

            }

        }
    }


    @SuppressLint("StaticFieldLeak")
    class AsynGetData extends AsyncTask<Void, Void, ArrayList<Book>> {


        @Override
        protected void onPreExecute() {
            pbBar.setVisibility(View.VISIBLE);
            super.onPreExecute();
        }

        @Override
        protected ArrayList<Book> doInBackground(Void... voids) {

            ArrayList<Book> books = new ArrayList<>();
            String NAMESPACE = "http://webservice.pnq.com/";
            String METHOD_NAME = "getAllBooks";
            String URL = "http://192.168.0.107:8888/books?wsdl";
            String ACTION = NAMESPACE + METHOD_NAME;

            SoapObject soapObject = new SoapObject(NAMESPACE, METHOD_NAME);

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(soapObject);

            HttpTransportSE httpTransportSE = new HttpTransportSE(URL);
            httpTransportSE.debug = true;
            try {
                httpTransportSE.call(ACTION, envelope);

                SoapObject result = (SoapObject) envelope.bodyIn;

                for (int i = 0; i < result.getPropertyCount(); i++) {
                    SoapObject soapBook = (SoapObject) result.getProperty(i);
                    System.out.println(soapBook);
                    Book book = new Book();

                    try {
                        book.setAuthor(soapBook.getProperty("author").toString());
                    } catch (RuntimeException e) {
                        book.setAuthor(null);
                    }

                    try {
                        book.setName(soapBook.getProperty("name").toString());
                    } catch (RuntimeException e) {
                        book.setName(null);
                    }

                    try {
                        book.setId(soapBook.getProperty("id").toString());
                    } catch (RuntimeException e) {
                        book.setId(null);
                    }

                    try {
                        book.setCode(soapBook.getProperty("code").toString());
                    } catch (RuntimeException e) {
                        book.setCode(null);
                    }


                    try {
                        book.setQuantityInStock(Integer.valueOf(soapBook.getProperty("quantityInStock").toString()));
                    } catch (RuntimeException e) {
                        book.setQuantityInStock(null);
                    }

                    books.add(book);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }

            return books;
        }


        @Override
        protected void onPostExecute(ArrayList<Book> books) {
            for (int i = 0; i < books.size(); i++) {
                adapter.resultAddBook(books.get(i));
            }
            pbBar.setVisibility(View.GONE);
            super.onPostExecute(books);
        }


    }
}
