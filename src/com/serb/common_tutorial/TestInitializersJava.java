package com.serb.common_tutorial;

/**
 * Created by IntelliJ IDEA.
 * User: sbezugliy
 * Date: 25.07.2008
 * Time: 14:53:24
 */
public class TestInitializersJava {
    {
        System.out.println("initializer");
    }
    int x, y=getY();
    final int z;
    {
        System.out.println("initializer2");
    }
    private int getY() {
        System.out.println("getY() "+z);
        return z;
    }
    public int getZ() {
        System.out.println("getZ() "+z);
        return z;
    }
    public TestInitializersJava() {
        System.out.println("Test()");
        z=3;
    }
    public String testRefernces(String str) {
        str="Two";
        return str;
    }
    public TestInitializersJava(int x) {
        this();
        System.out.println("Test(int)");
        // z=4; - ������! final-���� ���
        // ���� ����������������
    }
}
