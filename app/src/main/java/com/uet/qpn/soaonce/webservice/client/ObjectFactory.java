
package com.uet.qpn.soaonce.webservice.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.pnq.webservice package. 
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

    private final static QName _CreateBook_QNAME = new QName("http://webservice.pnq.com/", "createBook");
    private final static QName _DeleteBook_QNAME = new QName("http://webservice.pnq.com/", "deleteBook");
    private final static QName _GetAllBooks_QNAME = new QName("http://webservice.pnq.com/", "getAllBooks");
    private final static QName _GetBookByCodeResponse_QNAME = new QName("http://webservice.pnq.com/", "getBookByCodeResponse");
    private final static QName _DeleteBookResponse_QNAME = new QName("http://webservice.pnq.com/", "deleteBookResponse");
    private final static QName _GetBookByCode_QNAME = new QName("http://webservice.pnq.com/", "getBookByCode");
    private final static QName _UpdateBookResponse_QNAME = new QName("http://webservice.pnq.com/", "updateBookResponse");
    private final static QName _UpdateBook_QNAME = new QName("http://webservice.pnq.com/", "updateBook");
    private final static QName _GetAllBooksResponse_QNAME = new QName("http://webservice.pnq.com/", "getAllBooksResponse");
    private final static QName _CreateBookResponse_QNAME = new QName("http://webservice.pnq.com/", "createBookResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.pnq.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateBook }
     * 
     */
    public CreateBook createCreateBook() {
        return new CreateBook();
    }

    /**
     * Create an instance of {@link DeleteBook }
     * 
     */
    public DeleteBook createDeleteBook() {
        return new DeleteBook();
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
     * Create an instance of {@link DeleteBookResponse }
     * 
     */
    public DeleteBookResponse createDeleteBookResponse() {
        return new DeleteBookResponse();
    }

    /**
     * Create an instance of {@link GetBookByCode }
     * 
     */
    public GetBookByCode createGetBookByCode() {
        return new GetBookByCode();
    }

    /**
     * Create an instance of {@link UpdateBookResponse }
     * 
     */
    public UpdateBookResponse createUpdateBookResponse() {
        return new UpdateBookResponse();
    }

    /**
     * Create an instance of {@link UpdateBook }
     * 
     */
    public UpdateBook createUpdateBook() {
        return new UpdateBook();
    }

    /**
     * Create an instance of {@link GetAllBooksResponse }
     * 
     */
    public GetAllBooksResponse createGetAllBooksResponse() {
        return new GetAllBooksResponse();
    }

    /**
     * Create an instance of {@link CreateBookResponse }
     * 
     */
    public CreateBookResponse createCreateBookResponse() {
        return new CreateBookResponse();
    }

    /**
     * Create an instance of {@link Book }
     * 
     */
    public Book createBook() {
        return new Book();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.pnq.com/", name = "createBook")
    public JAXBElement<CreateBook> createCreateBook(CreateBook value) {
        return new JAXBElement<CreateBook>(_CreateBook_QNAME, CreateBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.pnq.com/", name = "deleteBook")
    public JAXBElement<DeleteBook> createDeleteBook(DeleteBook value) {
        return new JAXBElement<DeleteBook>(_DeleteBook_QNAME, DeleteBook.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.pnq.com/", name = "deleteBookResponse")
    public JAXBElement<DeleteBookResponse> createDeleteBookResponse(DeleteBookResponse value) {
        return new JAXBElement<DeleteBookResponse>(_DeleteBookResponse_QNAME, DeleteBookResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.pnq.com/", name = "updateBookResponse")
    public JAXBElement<UpdateBookResponse> createUpdateBookResponse(UpdateBookResponse value) {
        return new JAXBElement<UpdateBookResponse>(_UpdateBookResponse_QNAME, UpdateBookResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.pnq.com/", name = "updateBook")
    public JAXBElement<UpdateBook> createUpdateBook(UpdateBook value) {
        return new JAXBElement<UpdateBook>(_UpdateBook_QNAME, UpdateBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllBooksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.pnq.com/", name = "getAllBooksResponse")
    public JAXBElement<GetAllBooksResponse> createGetAllBooksResponse(GetAllBooksResponse value) {
        return new JAXBElement<GetAllBooksResponse>(_GetAllBooksResponse_QNAME, GetAllBooksResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.pnq.com/", name = "createBookResponse")
    public JAXBElement<CreateBookResponse> createCreateBookResponse(CreateBookResponse value) {
        return new JAXBElement<CreateBookResponse>(_CreateBookResponse_QNAME, CreateBookResponse.class, null, value);
    }

}
