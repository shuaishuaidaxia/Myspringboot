package com.example.demo4.utlil;

import com.example.demo4.exceptions.ParamsException;

/*异常类*/
public class AssertUtil {
    public static void isTrue(Boolean flag,String msg)
    {
        if (flag)
        {
            throw new ParamsException(msg);
        }
    }
}
