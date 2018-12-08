package com.webservice.webservice;


public class DemoServiceImpl implements DemoService {
    private int count=0;
    @Override
    public String testService(String json) throws Exception {
        StringBuffer sb=new StringBuffer();
        if(json.equals("123")){
//            sb.append("<root>                           ");
//            sb.append("<student>                        ");
//            sb.append("<stuid>20</stuid>              	");
//            sb.append("<stuname>张三</stuname>        	");
//            sb.append("<stuage>18</stuage>            	");
//            sb.append("<stuaddress>上海</stuaddress>  	");
//            sb.append("</student>                       ");
//            sb.append("<student>                        ");
//            sb.append("<stuid>21</stuid>              	");
//            sb.append("<stuname>李四</stuname>        	");
//            sb.append("<stuage>20</stuage>            	");
//            sb.append("<stuaddress>北京</stuaddress>  	");
//            sb.append("</student>                       ");
//            sb.append("</root>                          ");
            sb.append("2018123");
        }
        return sb+"";
    }

    @Override
    public String result(String id) throws Exception {
        StringBuffer sb=new StringBuffer();
        if(id.equals("2018123")){
            if(count>5) {
                sb.append("<root>                           ");
                sb.append("<student>                        ");
                sb.append("<stuid>20</stuid>              	");
                sb.append("<stuname>张三</stuname>        	");
                sb.append("<stuage>18</stuage>            	");
                sb.append("<stuaddress>上海</stuaddress>  	");
                sb.append("</student>                       ");
                sb.append("<student>                        ");
                sb.append("<stuid>21</stuid>              	");
                sb.append("<stuname>李四</stuname>        	");
                sb.append("<stuage>20</stuage>            	");
                sb.append("<stuaddress>北京</stuaddress>  	");
                sb.append("</student>                       ");
                sb.append("</root>                          ");
                count=0;
            }
            count++;
            System.out.println("第"+count+"次调用接口:"+sb);
        }
        return sb+"";
    }

}
