针对 14-start-add-json-key 进行修改
  - 当初没有考虑到转换 JSON 时数据多层嵌套的问题
  - 修改后需要对针对性的枚举类的 getter 进行注解

本次修改删除 JSON.java

修改 com.zyf.springboot.config.JsonConfiguration

新增 com.zyf.springboot.config.json.AddEnumTypeName