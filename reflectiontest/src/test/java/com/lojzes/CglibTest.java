package com.lojzes;

import com.lojzes.cglib.StudentService;
import com.lojzes.cglib.StudentServiceCallback;
import net.sf.cglib.proxy.*;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 备注：
 *
 * @author lyyitit@foxmail.com
 */
public class CglibTest {

    /**
    * 备注： 动态代理生成并调用
    *
    * @author lyyitit@foxmail.com
    */
    @Test
    public void test01(){
        //cglib增强器
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(StudentService.class);
        //设置回调
        enhancer.setCallback(new StudentServiceCallback());
        //生成代理
        StudentService studentService= (StudentService) enhancer.create();
        studentService.add("lojzes");

    }


    /**
    * 备注： 接口生成器
    *
    * @author lyyitit@foxmail.com
    */
    @Test
    public void test02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        InterfaceMaker interfaceMaker = new InterfaceMaker();
        interfaceMaker.add(StudentService.class);
        Class newInterfaceClz = interfaceMaker.create();
        Method[] methods = newInterfaceClz.getMethods();
        for (Method method : methods) {
            System.out.println("新接口的方法名称：--->>>"+method.getName());
        }

        //创建代理类
        Object o = Enhancer.create(Object.class, new Class[]{newInterfaceClz},new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                //以下是新接口中方法的实现
                if(method.getName().equals("add")){
                    System.out.println("add...");
                    return Void.TYPE;
                }
                if(method.getName().equals("del")){
                    System.out.println("del...");
                    return 1;
                }
                if(method.getName().equals("get")){
                    System.out.println("get...");
                    return "haha";
                }
                return "default";


            }
        });
        //调用方法
        Method del = o.getClass().getDeclaredMethod("del", new Class[]{int.class});
        Object delR = del.invoke(o, new Object[]{1024});
        System.out.println("del 返回--->>>"+delR);

        Method add = o.getClass().getDeclaredMethod("add", new Class[]{String.class});
        Object addR = add.invoke(o, new Object[]{"dodo"});
        System.out.println("add 返回--->>>"+addR);

        Method get = o.getClass().getDeclaredMethod("get", new Class[]{int.class});
        Object getR = get.invoke(o, new Object[]{123});
        System.out.println("add 返回--->>>"+getR);
    }
}
