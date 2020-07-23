# MyHeaders
解决tomcat全局处理http响应头问题

* 将项目打包成jar
```
mvn clean package
```
* 将jar放到tomcat的lib目录中
* 编辑conf/server.xml，在Host标签中加入如下代码
```
<Valve className="com.snow.MyValve"/>
```
* 重启tomcat
