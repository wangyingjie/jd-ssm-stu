
package com.jd.proxy;
import java.lang.reflect.Method;

public class $Proxy0 implements com.jd.proxy.Communication {
    JDInvocationHandler h;

    public $Proxy0(JDInvocationHandler h) {
        this.h = h;
    }

    public void call() {
        try {
            Method m = com.jd.proxy.Communication.class.getMethod("call", new Class[]{});
            this.h.invoke(this, m, null);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public void email() {
        try {
            Method m = com.jd.proxy.Communication.class.getMethod("email", new Class[]{});
            this.h.invoke(this, m, null);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
