package com.MW.Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Before和After是每个测试单元都会运行的
 */
public class BATest {
    @Before
    public void before(){
        System.out.println("测试前置正在初始化...");
        System.out.println("测试初始化完成，正在开始测试案例...");
    }

    @Test
    public void method1(){
        System.out.println("测试用例1通过！");
    }

    @Test
    public void method2(){
        System.out.println("测试用例2通过！");
    }

    @After
    public void after(){
        System.out.println("测试结束，收尾工作正在进行...");
    }
}
