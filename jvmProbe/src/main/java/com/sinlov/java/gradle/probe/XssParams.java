package com.sinlov.java.gradle.probe;

/**
 * <pre>
 *     sinlov
 *
 *     /\__/\
 *    /`    '\
 *  ≈≈≈ 0  0 ≈≈≈ Hello world!
 *    \  --  /
 *   /        \
 *  /          \
 * |            |
 *  \  ||  ||  /
 *   \_oo__oo_/≡≡≡≡≡≡≡≡o
 *
 * </pre>
 * Created by sinlov on 17/10/19.
 */
public class XssParams {
    private static int count = 0;

    public static int deepCall() {
        try {
            recursion();
        } catch (Throwable e) {
            return count;
//            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 减少局部变量的声明，可以节省栈帧大小，增加调用深度
     */
    private static void recursion() {
        long a = 1, b = 2, c = 3, d = 4, e = 5, f = 6, q = 7, x = 8, y = 9, z = 10;
        count++;
        recursion();
    }

}
