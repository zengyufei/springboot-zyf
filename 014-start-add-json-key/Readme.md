本项目作用，配置 enum 输出 json 时，额外添加同名 enum 加 Name 的 key/value，


如： UserVo
配置前
```
{
    id: 1,
    sex: 1,
    type: 2,
    typeName: '',
}
```
配置后
```
{
    id: 1,
    sex: 1,
    type: 2,
    sexName: '女',
    typeName: '其他用户',
}
```
