package com.wind.util.xml;

import org.junit.Test;

public class JAXBUtilsTest {

    @Test
    public void convertObjectToXml() throws Exception {
        User user = User.newBuilder().withId(100000L).withName("tom").build();
        String xml = JAXBUtils.convertObjectToXml(user);
        System.out.println(xml);
    }

    @Test
    public void convertXmlToObject() throws Exception {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><user><id>100000</id><name>tom</name></user>";
        User user = JAXBUtils.convertXmlToObject(xml, User.class);
        System.out.println(user);
    }

    @Test
    public void convertXmlToObjectIgnoreNamespace() throws Exception {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><user><id>100000</id><name>tom</name></user>";
        User user = JAXBUtils.convertXmlToObject(xml, User.class);
        System.out.println(user);
    }

}