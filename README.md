# utils
常用工具类集，如您觉得该项目对您有用，欢迎点击右上方的Star按钮，给予支持！

# 列表
## 1.PropertyUtils
对标注NotNull注解的属性，检查其值是否为null

## 2.JsonUtils
用于获取json字符串中指定key的value

- 示例
```
json = {"name":"刘禅","age":"6","father":{"name":"刘备","age":"50","properties": {"country": {"id": "002","name": "蜀"},"education": {"description": "学历","value": "私塾"},
"job":[{"id":"1","position":"大王"}],"wife": {"hasOne": false,"list": ["糜夫人","孙夫人","甘皇后","吴夫人"]}}}}
```

获取job中的position值：
JsonUtils.getValueByKeyExpression(json, "father", "father#properties#job#position")

## 3.JAXBUtils
xml和object互转工具类  

## 4.NewDozerBeanMapper
扩展自dozer，实现对List集合的转换

- 使用方法：使用NewDozerBeanMapper代替原DozerBeanMapper即可

## 5.NLogger
日志工具类，NLogger实现了org.slf4j.Logger接口，使用{}作为日志信息占位符，支持N个占位符

## 6.UUIDUtils
生成指定进制的UUID，生成字符串长度19~128位

## 7.Base64
提供更快、更高效的Base64编码、解码

## 8.DateUtils
基于Joda-Time实现的日期工具类，日期格式化、解析及日期比较

## 9.URLUtils
url转码、验证工具类

## 10.UnzipUtils
解压压缩包的工具类，支持解压tar.gz、.zip

## 11.WebUtils
从请求中获取请求的ip、user-agent、Cookie、host

## 12.ExecutorUtils
任务执行器工具类，可实现并发执行多个任务，多个任务执行完成后再继续执行主线程

- 使用示例

1. 在applicationContext.xml中使用task标签配置任务执行器
```
    <task:executor id="executor" pool-size="50"/>
```
2. 在applicationContext.xml中配置ExecutorUtils bean
```
    <bean id="executorUtils" class="com.wind.util.concurrent.ExecutorUtils">
        <property name="executor" ref="executor"/>
    </bean>
```
