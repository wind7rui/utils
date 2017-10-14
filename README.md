# utils
常用工具类集

# 工具类列表
## 1.PropertyUtils
对标注NotNull注解的属性，检查其值是否为null

## 2.JsonUtils
用于获取json字符串中指定key的value

示例:

json = {"name":"刘禅","age":"6","father":{"name":"刘备","age":"50","properties": {"country": {"id": "002","name": "蜀"},"education": {"description": "学历","value": "私塾"},
"job":[{"id":"1","position":"大王"}],"wife": {"hasOne": false,"list": ["糜夫人","孙夫人","甘皇后","吴夫人"]}}}}

获取job中的position值：
JsonUtils.getValueByKeyExpression(json, "father", "father#properties#job#position")

## 3.JAXBUtils
xml和object互转工具类  