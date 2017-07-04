package annotation;

import java.lang.annotation.*;

/**
 * Created by zzp on 2017/3/26.
 */
//注解的信息被保留在class文件(字节码文件)中当程序编译时，会被虚拟机保留在运行时
@Retention(RetentionPolicy.RUNTIME)
//该注解只能应用于方法上
@Target(ElementType.METHOD)
//允许注解被子类继承
@Inherited
/**
 * 权限注解
 */
public @interface PrivilegeInfo {
    String value();//权限名称
}
