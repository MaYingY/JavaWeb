package exception;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by zzp on 2017/3/27.
 */
public class PrivilegeException extends InvocationTargetException {
    public PrivilegeException() {
        super();
    }

    public PrivilegeException(Throwable target) {
        super(target);
    }

    public PrivilegeException(Throwable target, String s) {
        super(target, s);
    }
}
