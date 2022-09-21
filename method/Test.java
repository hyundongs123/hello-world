package com.sh.oop.method;

public class Test {
         int a = 100;
         static int s = 99;
         
         public static void main(String[] args) {
             Test t = new Test();
             t.test1();            //100
                                   //99
             t.test2();
             
             Test t3 = new Test();
             t.test3(t3);                  // t객체 -> test3메소드 안에 (t3객체)-> t3는 t.a ->10       
             System.out.println(t3.a);     //  t3.a -> 10 
             
       
                 
         }

         public void test1() {
             int a = 1000;
             int s = 999;
             System.out.println(this.a);      //100
             System.out.println(Test.s);      // 99
         }

         public void test2() {
             Test t = new Test();
             t.a = 1000;
             System.out.println(a);        //this .a = 100    
             System.out.println(t.a);      // t.a = 1000;
         }

         public void test3(Test t) {     // (t3 값이 t.a = 10 )
             t.a = 10;                  // t 객체안에 a 변수
             this.a = 200;				// this a는 전역변수  
             System.out.println(t.a);     //10
         }


     }

