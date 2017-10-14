package com.wind.util.xml;

import com.google.common.base.Strings;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;
import java.io.StringReader;
import java.io.StringWriter;

public class JAXBUtils {
    // 默认编码
    private static final String DEFAULT_ENCODE = "UTF-8";

    public static <T> String convertObjectToXml(T object) throws JAXBException {
        return convertObjectToXml(object, DEFAULT_ENCODE);
    }

    public static <T> String convertObjectToXml(T object, String encode) throws JAXBException {
        if (Strings.isNullOrEmpty(encode)) {
            encode = DEFAULT_ENCODE;
        }
        Marshaller marshaller = JAXBContext.newInstance(object.getClass()).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_ENCODING, encode);
        StringWriter sw = new StringWriter();
        marshaller.marshal(object, sw);
        return sw.toString();
    }

    @SuppressWarnings("unchecked")
    public static <T> T convertXmlToObject(String xml, Class<T> t) throws JAXBException {
        Unmarshaller unmarshaller = JAXBContext.newInstance(t).createUnmarshaller();
        return (T) unmarshaller.unmarshal(new StringReader(xml));
    }

    @SuppressWarnings("unchecked")
    public static <T> T convertXmlToObjectIgnoreNamespace(String xml, Class<T> t) throws JAXBException, ParserConfigurationException, SAXException {
        Unmarshaller unmarshaller = JAXBContext.newInstance(t).createUnmarshaller();
        StringReader reader = new StringReader(xml);
        SAXParserFactory sax = SAXParserFactory.newInstance();
        // 忽略xml的命名空间即（xmlns）
        sax.setNamespaceAware(false);

        XMLReader xmlReader = sax.newSAXParser().getXMLReader();
        Source source = new SAXSource(xmlReader, new InputSource(reader));
        return (T) unmarshaller.unmarshal(source);
    }
}
