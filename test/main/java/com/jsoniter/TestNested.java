package com.jsoniter;

import junit.framework.TestCase;
import org.junit.Assert;

import java.io.IOException;

public class TestNested extends TestCase {
    public void test_array_of_objects() throws IOException {
        Jsoniter iter = Jsoniter.parse(
                "[{'field1':'11','field2':'12'},{'field1':'21','field2':'22'}]".replace('\'', '"'));
        SimpleObject[] objects = iter.read(SimpleObject[].class);
        Assert.assertArrayEquals(new SimpleObject[]{
                new SimpleObject() {{
                    field1 = "11";
                    field2 = "12";
                }},
                new SimpleObject() {{
                    field1 = "21";
                    field2 = "22";
                }}
        }, objects);
    }
}
