#       接口文档

### 1. app登录接口 
#####接口地址： /api/token/login 
#####请求方法： POST 
<table>
    <tr>
        <td>参数</td>
        <td>说明</td>
        <td>是否必选</td>
    </tr>
    <tr>
        <td>username</td>
        <td>用户名</td>
        <td>是</td>
    </tr>
    <tr>
        <td>password</td>
        <td>密码</td>
        <td>是</td>
    </tr>
</table>

#####   请求返回：json
成功：
```
{
    "code":200,
    "token": xxx, //登录成功token
    "data": null
}
```
失败：
```
{
    "code":500,
    "message": "xxx", //错误信息
    "data": null
}
```
