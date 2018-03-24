package com.uet.qpn.soaonce;

import com.uet.qpn.soaonce.webservice.client.Book;
import com.uet.qpn.soaonce.webservice.client.WebService;
import com.uet.qpn.soaonce.webservice.client.WebServiceService;

import org.junit.Test;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);

    }

    @Test
    public void wsdlWSgetData() {
        List<Book> books = null;
        String NAMESPACE = "http://webservice.pnq.com/";
        String METHOD_NAME = "getAllBooks";
        String URL = "http://localhost:8888/books?wsdl";
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
                    book.setQuantityInStock(Integer.valueOf(soapBook.getProperty("quantityInStock").toString()));
                } catch (RuntimeException e) {
                    book.setQuantityInStock(null);
                }


            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void InsertData() {

        String NAMESPACE = "http://webservice.pnq.com/";
        String METHOD_NAME = "add";
        String URL = "http://localhost:8888/books?wsdl";
        String ACTION = NAMESPACE + METHOD_NAME;

        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

        request.addProperty("str", "1");

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
       //    envelope.dotNet = true;
        envelope.setOutputSoapObject(request);


        HttpTransportSE httpTransportSE = new HttpTransportSE(URL);
        //httpTransportSE.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
       // httpTransportSE.debug = true;
        try {
            httpTransportSE.call(ACTION, envelope);
          //  SoapPrimitive soapPrimitive  = (SoapPrimitive) envelope.getResponse();
            //System.out.println(soapPrimitive.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void Insert2()
    {
        String NAMESPACE = "http://webservice.pnq.com/";
        String METHOD_NAME = "createBook";
        String URL = "http://192.168.0.107:8888/books?wsdl";
        String ACTION = NAMESPACE + METHOD_NAME;

        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
        Book book = new Book();
        book.setName("Quyaa");
        book.setCode("ABCaa");
        book.setQuantityInStock(10);
        book.setAuthor("Quyaa");
        request.addProperty("Book", book);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(request);


        HttpTransportSE httpTransportSE = new HttpTransportSE(URL);

        try {
            httpTransportSE.call(ACTION, envelope);
              SoapPrimitive soapPrimitive  = (SoapPrimitive) envelope.getResponse();
            System.out.println(soapPrimitive.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void Edit()
    {
        String NAMESPACE = "http://webservice.pnq.com/";
        String METHOD_NAME = "updateBook";
        String URL = "http://192.168.0.107:8888/books?wsdl";
        String ACTION = NAMESPACE + METHOD_NAME;

        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
        Book book = new Book();
        book.setName("qaa");
        book.setCode("ABCaa");
        book.setQuantityInStock(10);
        book.setAuthor("Quyaa");
        request.addProperty("Book", book);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(request);


        HttpTransportSE httpTransportSE = new HttpTransportSE(URL);

        try {
            httpTransportSE.call(ACTION, envelope);
            SoapPrimitive soapPrimitive  = (SoapPrimitive) envelope.getResponse();
            System.out.println(soapPrimitive.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test2() {
        WebServiceService webServiceService = new WebServiceService();
        WebService webService = webServiceService.getWebServicePort();
        ArrayList<Book> books = (ArrayList<Book>) webService.getAllBooks();
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i).getName());
        }
    }
}