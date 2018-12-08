package org.tempuri;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import java.io.File;
import java.util.List;

public class Xpath {
    public static void main(String[] args) throws Exception{
        //"d://xpth.xml"
//        DocumentBuilderFactory domFactory=DocumentBuilderFactory.newInstance();
//        domFactory.setNamespaceAware(true);
//        DocumentBuilder documentBuilder=domFactory.newDocumentBuilder();
//        Document doc=documentBuilder.parse(new File("d://xpth.xml"));
//        XPathFactory factory=XPathFactory.newInstance();
//        XPath xPath=factory.newXPath();
//
//        NodeList nodeList=(NodeList)xPath.evaluate("/contactList/contact[@id=001]",doc, XPathConstants.NODESET);
//        for(int i=0;i<nodeList.getLength();i++){
//            Node node=nodeList.item(i);
//            String name=(String)xPath.evaluate("name",node,XPathConstants.STRING);
//            String value=(String)xPath.evaluate("age",node,XPathConstants.STRING);
//            System.out.println("获取返回值name:"+name+",value:"+value);
//        }
        SAXReader saxReader=new SAXReader();
        Document doc=saxReader.read(new File("d://xpath.xml"));
        Element element=doc.getRootElement();
//        List<Element> lists=doc.selectNodes("/contactList/contact");
        List<Element> list=element.elements();
        for(int i=0;i<list.size();i++){
            String id=list.get(i).attributeValue("xmlns:s");
            System.out.println("获取id值为:"+id);
            List<Element> list1=list.get(i).elements();
            for(Element element1:list1){
                String text=element1.getText();
                String ids=element1.attributeValue("id");
                System.out.println("返回值为text:"+text+",ids:"+ids);
            }
        }

    }
}
