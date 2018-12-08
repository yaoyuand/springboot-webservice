package com.webservice.thread;


public class ThreadTest {
    private Object object=123;
    int count=1;
    public void demo(String demo){
        try {
            if(demo.equals("123")){
                count=10;
                Thread.sleep(10*1000);
                this.object.notifyAll();
            }
        } catch (InterruptedException e) {
            System.out.println("线程睡眠报错:"+e.getMessage());
        }
    }

    public synchronized void test(String result){
        try {
            while(count<10){
                wait();
                System.out.println("线程等待结束,获取返回值为:" + result);
            }
        } catch (InterruptedException e) {
            System.out.println("线程等待报错:"+e.getMessage());
        }
    }

    public static void main(String[] args) {
        ThreadTest threadTest=new ThreadTest();
        threadTest.test("今天是个好天气");
        threadTest.demo("123");
    }
}
