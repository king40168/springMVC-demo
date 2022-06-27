# springMVC-demo
SpringMVC学习过程的代码 
> 2022.06.21-2022.06.26
- IDEA 2020.1
- Tomcat 8.5.81
- Maven 3.5.4


## 主要包括如下内容
1. SpringMVC简易项目的创建流程
2. @RequestMapping注解的学习使用
3. SpringMVC获取请求参数
4. 域对象种共享数据的方法
5. SpringMVC的视图
6. RESTful
7. RESTful案例及实现过程
8. HttpMessageConvert报文信息转换器
9. 文件上传和下载，使用ResponseEntity实现下载，MultipartFile实现文件上传
10. HandlerInterceptor拦截器
11. HandlerExceptionResolver异常处理器
12. 完全使用注解进行SpringMVC开发
    替代web.xml和SpringMVC.xml文件



## 对于SpringMVC的理解

在web模型中，MVC是一种很流行的框架，通过把Model，View，Controller分离，把较为复杂的web应用分成逻辑清晰的几部分，是为了简化开发，减少出错。还是为了组内开发人员之间的配合。总之就是一种分层工作的办法。

 DispatcherServlet，这是控制器是负责第一道处理，用来转发请求的，它会将请求转发到合适的Controller上。万变不离其宗，不管如何变，它的目的都不变，就是设法建立url到Controller的映射。

我们使用框架的原因，就是在开发中，这样的步骤都是重复的，而且每次都一样，所以写框架的人，就把这样套路式的代码封装了， 细节都交给他来处理，我们只要做两件和自己业务相关的事，一个是确定url，二是，这个url指向那个类。写到这里基本把url到Controller这件事说完了。这里有两个类一个是DispatcherServlet，这个是SpringMVC框架自带的，一个就是你自己处理业务的类，比如是ProductController。



- **DispatcherServlet接口**

  Spring提供的前端控制器，所有的请求都有经过它来统一分发。在DispatcherServlet将请求分发给Spring Controller之前，需要借助于Spring提供的HandlerMapping定位到具体的Controller。

- **HandlerMapping接口**

  能够完成客户请求到Controller映射。

- **Controller接口**

  需要为并发用户处理上述请求，因此实现Controller接口时，必须保证线程安全并且可重用。

  Controller将处理用户请求，这和Struts Action扮演的角色是一致的。一旦Controller处理完用户请求，则返回ModelAndView对象给DispatcherServlet前端控制器，ModelAndView中包含了模型（Model）和视图（View）。

  从宏观角度考虑，DispatcherServlet是整个Web应用的控制器；从微观考虑，Controller是单个Http请求处理过程中的控制器，而ModelAndView是Http请求过程中返回的模型（Model）和视图（View）。

- **ViewResolver接口**

  Spring提供的视图解析器（ViewResolver）在Web应用中查找View对象，从而将相应结果渲染给客户。


![20180904104857508](https://user-images.githubusercontent.com/58094699/175819358-428d0d47-99d1-4bed-9974-41f71f635dec.png)



### SpringMVC流程

1. 用户发送请求至前端控制器DispatcherServlet。
2. DispatcherServlet收到请求调用HandlerMapping处理器映射器。
3. 处理器映射器找到具体的处理器(可以根据xml配置、注解进行查找)，生成处理器对象及处理器拦截器(如果有则生成)一并返回给DispatcherServlet。
4. DispatcherServlet调用HandlerAdapter处理器适配器。
5. HandlerAdapter经过适配调用具体的处理器(Controller，也叫后端控制器)。
6. Controller执行完成返回ModelAndView。
7. HandlerAdapter将controller执行结果ModelAndView返回给DispatcherServlet。
8. DispatcherServlet将ModelAndView传给ViewReslover视图解析器。
9. ViewReslover解析后返回具体View。
10. DispatcherServlet根据View进行渲染视图（即将模型数据填充至视图中）。
11. DispatcherServlet响应用户。

组件说明：

以下组件通常使用框架提供实现：

DispatcherServlet：作为**前端控制器**，整个流程控制的中心，控制其它组件执行，统一调度，降低组件之间的耦合性，提高每个组件的扩展性。

HandlerMapping：通过扩展**处理器映射器**实现不同的映射方式，例如：配置文件方式，实现接口方式，注解方式等。 

Hanlder：处理器（需要程序员去写代码处理业务逻辑的）

HandlerAdapter：通过扩展处理器适配器，支持更多类型的处理器。

ViewResolver：通过扩展**视图解析器**，支持更多类型的视图解析，例如：jsp、freemarker、pdf、excel等。

