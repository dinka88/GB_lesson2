package ru.dinka88.profflvl.lesson7;

public class Test2 {
    public Test2() {
        System.out.println("constructor2");
    }

    @BeforeSuite
    public void before() {
        System.out.println("before2");
    }

    @AfterSuite
    public void after() {
        System.out.println("after2");
    }

    @Test(priority = 1)
    public void t3() {
        System.out.println("2-t3");
    }

    @Test(priority = 2)
    public void t2() {
        System.out.println("2-t2");
    }

    @Test(priority = 2)
    public void t1() {
        System.out.println("2-t1");
    }

    @Test(priority = 4)
    public void t4() {
        System.out.println("2-t4");
    }
}
