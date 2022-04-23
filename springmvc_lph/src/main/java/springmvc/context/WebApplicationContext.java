package springmvc.context;

import springmvc.annotation.AutoWired;
import springmvc.annotation.Controller;
import springmvc.annotation.Service;
import springmvc.xml.XmlPaser;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: WebApplicationContext
 * @Author: lph
 * @Description:
 * @Date: 2022/4/23 21:05
 */
public class WebApplicationContext {

    //classpath:springmvc.xml
    String contextConfigLocation;

    //定义集合  用于存放 bean 的权限名|包名.类名
    List<String> classNameList = new ArrayList<String>();

    //创建Map集合用于扮演IOC容器：  key存放bean的名字   value存放bean实例
    public Map<String, Object> iocMap = new ConcurrentHashMap<>();

    public WebApplicationContext() {
    }


    public WebApplicationContext(String contextConfigLocation) {
        this.contextConfigLocation = contextConfigLocation;
    }

    /**
     * 初始化Spring容器
     */
    public void onRefresh() {
        //1.进行解析springMVC配置文件操作  ==》
        String pack = XmlPaser.getbasePackage(contextConfigLocation.split(":")[1]);

        String[] packs = pack.split(",");

        //2,进行包扫描
        for (String pa : packs) {
            excuteScanPackage(pa);
        }

        //3.实例化容器中的bean
        executeInstance();


        //4.进行自动注入操作
        executeAutoWrite();

    }

    //进行自动注入操作
    private void executeAutoWrite() {
        try {

            for (Map.Entry<String, Object> entry : iocMap.entrySet()) {

                Object bean = entry.getValue();
                Field[] fields = bean.getClass().getDeclaredFields();
                for (Field field : fields) {
                    if (field.isAnnotationPresent(AutoWired.class)) {
                        AutoWired autoWiredAno = field.getAnnotation(AutoWired.class);
                        String beanName = autoWiredAno.value();
                        field.set(bean, iocMap.get(beanName));
                        field.setAccessible(true);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }

    /**
     * 实例化容器中的bean
     */
    private void executeInstance() {


        for (String className : classNameList) {
            try {
                Class<?> claszz = Class.forName(className);

                if (claszz.isAssignableFrom(Controller.class)) {
                    //控制层 bean
                    String beanName = claszz.getSimpleName().substring(0, 1).toLowerCase() + claszz.getSimpleName().substring(1);
                    iocMap.put(beanName, claszz.newInstance());
                } else if (claszz.isAssignableFrom(Service.class)) {
                    Service serviceAn = claszz.getAnnotation(Service.class);
                    String beanName = serviceAn.value();
                    iocMap.put(beanName, claszz.newInstance());
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * 扫描包
     */
    public void excuteScanPackage(String pack) {
        //   com.baiqi.controller   ==> com/baiqi/controller
        URL url = this.getClass().getClassLoader().getResource("/" + pack.replaceAll("\\.", "/"));
        String path = url.getFile();
        // /com/bruce/service
        File dir = new File(path);
        for (File f : dir.listFiles()) {
            if (f.isDirectory()) {
                //当前是一个文件目录  com.baiqi.service.impl
                excuteScanPackage(pack + "." + f.getName());
            } else {
                //文件目录下文件  获取全路径   UserController.class  ==> com.baiqi.controller.UserController
                String className = pack + "." + f.getName().replaceAll(".class", "");
                classNameList.add(className);
            }
        }
    }


}
