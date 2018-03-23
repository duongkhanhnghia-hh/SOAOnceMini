
package com.uet.qpn.soaonce.webservice.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAllBooks_QNAME = new QName("http://webservice.pnq.com/", "getAllBooks");
    private final static QName _GetBookByCodeResponse_QNAME = new QName("http://webservice.pnq.com/", "getBookByCodeResponse");
    private final static QName _GetBookByCode_QNAME = new QName("http://webservice.pnq.com/", "getBookByCode");
    private final static QName _GetAllBooksResponse_QNAME = new QName("http://webservice.pnq.com/", "getAllBooksResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllBooks }
     * 
     */
    public GetAllBooks createGetAllBooks() {
        return new GetAllBooks();
    }

    /**
     * Create an instance of {@link GetBookByCodeResponse }
     * 
     */
    public GetBookByCodeResponse createGetBookByCodeResponse() {
        return new GetBookByCodeResponse();
    }

    /**
     * Create an instance of {@link GetBookByCode }
     * 
     */
    public GetBookByCode createGetBookByCode() {
        return new GetBookByCode();
    }

    /**
     * Create an instance of {@link GetAllBooksResponse }
     * 
     */
    public GetAllBooksResponse createGetAllBooksResponse() {
        return new GetAllBooksResponse();
    }

    /**
     * Create an instance of {@link Book }
     * 
     */
    public Book createBook() {
        return new Book();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllBooks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.pnq.com/", name = "getAllBooks")
    public JAXBElement<GetAllBooks> createGetAllBooks(GetAllBooks value) {
        return new JAXBElement<GetAllBooks>(_GetAllBooks_QNAME, GetAllBooks.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBookByCodeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.pnq.com/", name = "getBookByCodeResponse")
    public JAXBElement<GetBookByCodeResponse> createGetBookByCodeResponse(GetBookByCodeResponse value) {
        return new JAXBElement<GetBookByCodeResponse>(_GetBookByCodeResponse_QNAME, GetBookByCodeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBookByCode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.pnq.com/", name = "getBookByCode")
    public JAXBElement<GetBookByCode> createGetBookByCode(GetBookByCode value) {
        return new JAXBElement<GetBookByCode>(_GetBookByCode_QNAME, GetBookByCode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllBooksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.pnq.com/", name = "getAllBooksResponse")
    public JAXBElement<GetAllBooksResponse> createGetAllBooksResponse(GetAllBooksResponse value) {
        return new JAXBElement<GetAllBooksResponse>(_GetAllBooksResponse_QNAME, GetAllBooksResponse.class, null, value);
    }

}
