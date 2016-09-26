# 遇到过的坑

## 保存失败
`BaseEntity`的`delete`属性和数据库关键字冲突

## 模块library依赖的设置
设置为全局依赖，在最外层pom文件种添加依赖
```
<dependency>
    <groupId>com.coderbike</groupId>
    <artifactId>library</artifactId>
    <version>${project.version}</version>
</dependency>
```