package com.ahyql.java.test;

import com.ahyql.java.improve.SimpleList;
import org.junit.Test;

/**
 * Created by yql on 2017/5/14.
 */
public class SimpleListTest {

    @Test
    public void test(){
        SimpleList<String> list = new SimpleList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");

        list.insert("fff",4);
        list.clear();
        System.out.println(list);

    }
}
