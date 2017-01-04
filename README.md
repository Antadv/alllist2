# 技术选型

 - 基本框架 Springmvc + Spring + Jpa + Mybatis
 - 数据库连接池 Druid
 - json解析器 Fastjson
 - 项目构建 maven
 - 任务调度 quartz
 - 待续...

# 最佳实践

 1. [Spring profile解决测试正式环境问题][1]
 2. [spring加载配置properties最佳实践][2]
 3. 使用`@ControllerAdvice`统一解决Controller异常
 4. 增加`RequestContextUtil`来获取request和response
 5. 舍弃session而重新设计登录验证逻辑
 6. `quartz`采用注解方式
 7. 待续...
 


  [1]: http://coderbike.com/articles/84.html
  [2]: http://coderbike.com/articles/106.html