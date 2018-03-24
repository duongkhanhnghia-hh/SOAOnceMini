package com.uet.qpn.soaonce.service;

import android.os.AsyncTask;

import com.uet.qpn.soaonce.webservice.client.Book;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

import static com.uet.qpn.soaonce.config.Config.NAMESPACE;
import static com.uet.qpn.soaonce.config.Config.WEBSERVICE_URL;

public class AsynUpdateData extends AsyncTask<Book, Void, Void> {


    @Override
    protected Void doInBackground(Book... books) {

        String METHOD_NAME = "updateBook";

        String ACTION = NAMESPACE + METHOD_NAME;

        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
        request.addProperty("Book", books[0]);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(request);


        HttpTransportSE httpTransportSE = new HttpTransportSE(WEBSERVICE_URL);

        try {
            httpTransportSE.call(ACTION, envelope);
            SoapPrimitive soapPrimitive = (SoapPrimitive) envelope.getResponse();
            System.out.println(soapPrimitive.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

        return null;
    }
}
