package ru.job4j.tested;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 01.04.2021
 */
public class C {
    public static class A {
        void smthng1(){
            System.out.println("smthng1 A");
        }
        static void smthng2(){
            System.out.println("smthng2 A");
        }

        protected void smthng3(){
            System.out.println("smthng3 A");
        }

        protected static void smthng4(){
            System.out.println("smthng4 A");
        }
    }
    public static class B extends A {

        public void smthng1(){
            System.out.println("smthng1 B");
        }
        static void smthng2(){
            System.out.println("smthng2 B");
        }
        public void smthng3(){
            System.out.println("smthng3 B");
        }
        protected static void smthng4(){
            System.out.println("smthng4 B");
        }
    }

    public static void test(A a) {
        a.smthng1();
        a.smthng2();
        a.smthng3();
        a.smthng4();
    }

    public static void main(String[] args) {
        A a = new A();
        a.smthng1();
        a.smthng2();
        a.smthng3();
        a.smthng4();


        B b = new B();
        b.smthng1();
        b.smthng2();
        b.smthng3();
        b.smthng4();


        System.out.println("===============");
        test(a);
        System.out.println("===============");
        A c = new B();
        test(c);
    }
}
