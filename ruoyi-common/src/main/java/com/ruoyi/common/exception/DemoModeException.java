package com.ruoyi.common.exception;

/**
 * 演示模式异常
 * 
 * @author ruoyi
 */
public class DemoModeException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public DemoModeException()
    {
        System.out.println("演示异常");
    }
}
