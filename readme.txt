码的过程中踩到的坑：
1、thymeleaf页面中文乱码问题：
  解决方案：必须在viewResolver和templateResolver分别加上：
  viewResolver.setCharactreEncoding("UTF-8")
  templateResolver.setCharacterEncoding("UTF-8")

2、注册Thymeleaf的Spring Security安全方言后运行程序报
java.lang.NoClassDefFoundError: org/thymeleaf/extras/springsecurity4/dialect/SpringSecurityDialect
异常
   解决方案：将thymeleaf-extras-springsecurity4的版本由3.x.x改为2.1.2
   因为3.x.x的版本不支持注册安全方言
3、了解<a th:href="@{/logout}">退出登录</a>无法使用
    为了防止CSRF攻击，官方要求logout请求必须由POST方式提交，官方文档：
    http://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#csrf-logout
    解决方法是建立一个表单来退出