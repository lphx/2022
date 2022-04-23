package springmvc.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import springmvc.annotation.Controller;
import springmvc.annotation.RequestMapping;
import springmvc.annotation.ResponseBody;
import springmvc.context.WebApplicationContext;
import springmvc.handler.MyHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: DispatcherServlet
 * @Author: lph
 * @Description:
 * @Date: 2022/4/23 20:58
 */
public class DispatcherServlet extends HttpServlet {

    //指定springMVC容器
    private WebApplicationContext webApplicationContext;

    //创建集合  用于存放  映射关系    映射地址  与  控制器.方法，用于发送请求直接从该集合中进行匹配
    List<MyHandler> handList = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        //1.加载初始化参数  classpath:springmvc.xml
        String contextConfigLocation = this.getServletConfig().getInitParameter("contextConfigLocation");

        //2.创建springMVC容器
        webApplicationContext = new WebApplicationContext(contextConfigLocation);


        //3.进行初始化操作
        webApplicationContext.onRefresh();


        //s4.初始化请求映射关系    /finUser   ===>控制器，方法
        initHandlerMapping();


    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDispatcher(req, resp);
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    //进行请求分发
    private void doDispatcher(HttpServletRequest req, HttpServletResponse resp) {

        MyHandler myHandler = getHandler(req);
        try {
            if (myHandler == null) {

                resp.getWriter().print("<h1>404 NOT FOUND!</h1>");
            } else {
                //调用处理方法之前 进行参数的注入

                //调用目标方法
                Object result = myHandler.getMethod().invoke(myHandler.getController());

                if (result instanceof String) {
                    //跳转JSP
                    String viewName = (String) result;

                    if (viewName.contains(":")) {
                        String viewType = viewName.split(":")[0];
                        String viewPage = viewName.split(":")[1];

                        if (viewType.equals("forward")) {
                            req.getRequestDispatcher(viewPage).forward(req, resp);
                        } else {
                            resp.sendRedirect(viewPage);
                        }
                    } else {
                        //默认就转发
                        req.getRequestDispatcher(viewName).forward(req, resp);
                    }
                } else {
                    Method method = myHandler.getMethod();
                    if (method.isAnnotationPresent(ResponseBody.class)) {
                        //将返回值转换成 json格式数据
                        ObjectMapper objectMapper = new ObjectMapper();
                        String json = objectMapper.writeValueAsString(result);
                        resp.setContentType("text/html;charset=utf-8");
                        PrintWriter writer = resp.getWriter();
                        writer.print(json);
                        writer.flush();
                        writer.close();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 根据用户请求查找对应的Handler
     *
     * @param req
     * @return
     */
    private MyHandler getHandler(HttpServletRequest req) {

        String requestURI = req.getRequestURI();
        for (MyHandler myHandler : handList) {

            if (myHandler.getUrl().equals(requestURI)) {
                return myHandler;
            }
        }
        return null;
    }

    //初始化请求映射关系
    private void initHandlerMapping() {

        for (Map.Entry<String, Object> entry : webApplicationContext.iocMap.entrySet()) {
            //获取bean的class类型
            Class<?> claszz = entry.getValue().getClass();

            if (claszz.isAnnotationPresent(Controller.class)) {
                Method[] methods = claszz.getDeclaredMethods();
                for (Method method : methods) {

                    if (method.isAnnotationPresent(RequestMapping.class)) {
                        RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
                        //获取注解中的值
                        String url = requestMapping.value();

                        //建立 映射地址  与 控制器.方法
                        MyHandler myHandler = new MyHandler(url, entry.getValue(), method);
                        handList.add(myHandler);
                    }

                }
            }
        }

    }
}
