package ru.dinka88.profflvl.lesson7;

public class Test1 {
    public Test1() {
        System.out.println("constructor");
    }

    @BeforeSuite
    public void before() {
        System.out.println("before");
    }

    @AfterSuite
    public void after() {
        System.out.println("after");
    }

    @Test(priority = 1)
    public void t3() {
        System.out.println("t3");
    }

    @Test(priority = 2)
    public void t2() {
        System.out.println("t2");
    }

    @Test(priority = 2)
    public void t1() {
        System.out.println("t1");
    }

    @Test(priority = 4)
    public void t4() {
        System.out.println("t4");
    }
}
