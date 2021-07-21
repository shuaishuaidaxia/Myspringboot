package com.example.demo4.utlil;

import com.example.demo4.exceptions.ParamsException;

public class AssertUtil {

    public static void isTrue(Boolean flag,String msg)
    {
        if (flag)
        {
            throw new ParamsException(msg);
        }
    }
}
