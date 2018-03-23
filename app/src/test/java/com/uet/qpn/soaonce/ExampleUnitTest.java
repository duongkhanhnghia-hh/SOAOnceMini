package com.uet.qpn.soaonce;

import com.uet.qpn.soaonce.webservice.client.WebService;
import com.uet.qpn.soaonce.webservice.client.WebServiceService;

import org.junit.Test;

import static org.junit.Assert.*;

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
    public void wsdlWS() {
        System.out.println("Hello");
        WebServiceService webServiceService = new WebServiceService();
        WebService webService = webServiceService.getWebServicePort();
        webService.getAllBooks();
    }
}