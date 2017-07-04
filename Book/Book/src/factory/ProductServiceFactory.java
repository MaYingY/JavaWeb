package factory;

import annotation.PrivilegeInfo;
import dao.PrivilegeDao;
import domain.User;
import exception.PrivilegeException;
import service.ProductService;
import service.ProductServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zzp on 2017/3/26.
 */
public class ProductServiceFactory {

    private static ProductService productService = (ProductService) new ProductServiceImpl();

    public static ProductService getInstance(){
        return (ProductService) Proxy.newProxyInstance(productService.getClass().getClassLoader(),
                productService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //判断是否有注解
                        if(method.isAnnotationPresent(PrivilegeInfo.class)){
                            //得到注解对象
                            PrivilegeInfo privilegeInfo = method.getAnnotation(PrivilegeInfo.class);
                            //得到权限名称
                            String pname = privilegeInfo.value();
                            //得到用户
                            User user = (User) args[0];
                            if(user == null){
                                throw new PrivilegeException();
                            }
                            //根据用户查询是否具有权限
                            PrivilegeDao privilegeDao = new PrivilegeDao();
                            if(!privilegeDao.checkPrivilege(user.getRole(), pname)){
                                throw new PrivilegeException();
                            }
                        }
                        return method.invoke(productService, args);
                    }
                });
    }
}
