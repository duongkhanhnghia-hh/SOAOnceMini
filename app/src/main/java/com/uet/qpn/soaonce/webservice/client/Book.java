
package com.uet.qpn.soaonce.webservice.client;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.io.Serializable;
import java.util.Hashtable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for book complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="book">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="author" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="quantityInStock" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "book", propOrder = {
        "author",
        "code",
        "id",
        "name",
        "quantityInStock"
})
public class Book implements Serializable, KvmSerializable {

    public String author;
    public String code;
    public String id;
    public String name;
    public Integer quantityInStock;

    public Book() {

    }

    public Book(String author, String code, String name, Integer quantityInStock) {
        this.author = author;
        this.code = code;
        this.name = name;
        this.quantityInStock = quantityInStock;
    }

    public Book(String author, String code, String id, String name, Integer quantityInStock) {
        this.author = author;
        this.code = code;
        this.id = id;
        this.name = name;
        this.quantityInStock = quantityInStock;
    }

    /**
     * Gets the value of the author property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the value of the author property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAuthor(String value) {
        this.author = value;
    }

    /**
     * Gets the value of the code property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the id property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the quantityInStock property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    /**
     * Sets the value of the quantityInStock property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setQuantityInStock(Integer value) {
        this.quantityInStock = value;
    }


    @Override
    public Object getProperty(int i) {

        switch (i) {
            case 0:
                return author;
            case 1:
                return code;
            case 2:
                return id;
            case 3:
                return name;
            case 4:
                return quantityInStock;

        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 5;
    }

    @Override
    public void setProperty(int i, Object o) {
        switch (i) {
            case 0:
                author = (String) o;
                break;
            case 1:
                code = (String) o;
                break;
            case 2:
                id = o.toString();
                break;
            case 3:
                name = o.toString();
                break;
            case 4:
                quantityInStock = Integer.valueOf(o.toString());
            default:
                break;

        }

    }

    @Override
    public void getPropertyInfo(int i, Hashtable hashtable, PropertyInfo propertyInfo) {
        switch (i) {
            case 0:
                propertyInfo.type = PropertyInfo.STRING_CLASS;
                propertyInfo.name = "author";
                break;
            case 1:
                propertyInfo.type = PropertyInfo.STRING_CLASS;
                propertyInfo.name = "code";
                break;
            case 2:
                propertyInfo.type = PropertyInfo.STRING_CLASS;
                propertyInfo.name = "id";
                break;
            case 3:
                propertyInfo.type = PropertyInfo.STRING_CLASS;
                propertyInfo.name = "name";
                break;
            case 4:
                propertyInfo.type = PropertyInfo.INTEGER_CLASS;
                propertyInfo.name = "quantityInStock";
                break;
            default:
                break;
        }
    }

    @Override
    public String getInnerText() {
        return null;
    }

    @Override
    public void setInnerText(String s) {

    }
}
