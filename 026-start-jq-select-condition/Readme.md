本项目主要作用是处理关联关系（connection relation）

user 与 role 的 userRole 关系

role 与 resource 的 roleResource 关系

resource 与 resource 的 上下级 关系

对数据库表改动最大，请导入本项目数据库脚本。

主要完成：
  - 新增资源时，设置上下级关系
  - 角色修改权限
    - 可修改角色拥有的权限
  - 根据实际功能，添加必要字段

修改 com.zyf.springboot.config.json.AddEnumTypeName 因为 index 不从0 开始导致的输出不正确的枚举问题。

下一个项目进行条件查询。