package com.webservice.xml;

import com.sun.xml.internal.bind.v2.runtime.output.NamespaceContextImpl;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.List;

public class ReadXml {
    public static void main(String[] args) throws Exception{
        String url="D:\\zhongxin\\webservice\\src\\main\\java\\com\\webservice\\Application.xml";
        xml1(url);
    }
    public static void xml(String url)throws  Exception{
        File file=new File(url);
        SAXReader saxReader=new SAXReader();
        Document document=saxReader.read(file);
        Element root=document.getRootElement();
        Iterator foo=root.elementIterator("bean");
        while(foo.hasNext()){
            Element element =(Element) foo.next();
            String name=element.attributeValue("id");
            System.out.println("name:"+name);
            Iterator iterator=element.elementIterator("property");
            while(iterator.hasNext()){
                Element element1=(Element) iterator.next();
                String name1=element1.attributeValue("name");
                String value1=element1.attributeValue("value");
                String ref=element1.attributeValue("ref");
                System.out.println("name1:"+name1+",value1:"+value1+",ref:"+ref);
            }
        }
    }
    public static void xml1(String url) throws Exception{
        SAXReader saxReader=new SAXReader();
        Document document=saxReader.read(new File(url));
        Element element=document.getRootElement();
        Iterator iterator=element.elementIterator();
        while(iterator.hasNext()){
            Element element1=(Element) iterator.next();
            List list=element1.attributes();
            for(int i=0;i<list.size();i++){
                Attribute attribute=(Attribute)list.get(i);
                System.out.print("name:"+attribute.getName()+",value:"+attribute.getValue()+" ");
            }
            System.out.println(" ");

        }
    }
}
