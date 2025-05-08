# OpenAPI definition


**简介**:OpenAPI definition


**HOST**:http://localhost:8888


**联系人**:


**Version**:v0


**接口路径**:/v3/api-docs


[TOC]






# 用户管理


## 更新用户信息


**接口地址**:`/user/update`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|用户ID|query|true|integer(int32)||
|name|真实姓名|query|true|string||
|gender|性别|query|true|string||
|age|年龄|query|true|integer(int32)||
|email|邮箱|query|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|msg||string||
|success||boolean||
|data||object||
|count||integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"code": 0,
	"msg": "",
	"success": true,
	"data": {},
	"count": 0
}
```


## 重置密码


**接口地址**:`/user/reset-password`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|username|用户名|query|true|string||
|newPassword|新密码|query|true|string||
|phone|验证手机号|query|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|msg||string||
|success||boolean||
|data||object||
|count||integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"code": 0,
	"msg": "",
	"success": true,
	"data": {},
	"count": 0
}
```


## 注册用户


**接口地址**:`/user/register`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>用户名密码注册</p>



**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|username|用户名|query|true|string||
|password|密码|query|true|string||
|phone|电话|query|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|msg||string||
|success||boolean||
|data||object||
|count||integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"code": 0,
	"msg": "",
	"success": true,
	"data": {},
	"count": 0
}
```


## 登录验证


**接口地址**:`/user/login`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|username|用户名|query|true|string||
|password|密码|query|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|msg||string||
|success||boolean||
|data||object||
|count||integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"code": 0,
	"msg": "",
	"success": true,
	"data": {},
	"count": 0
}
```


## 分页查询用户列表


**接口地址**:`/user/list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|pageNum|页码|query|true|integer(int32)||
|pageSize|每页数量|query|true|integer(int32)||
|username|用户名模糊查询|query|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|msg||string||
|success||boolean||
|data||object||
|count||integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"code": 0,
	"msg": "",
	"success": true,
	"data": {},
	"count": 0
}
```


## 删除用户


**接口地址**:`/user/delete`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|用户ID|query|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|msg||string||
|success||boolean||
|data||object||
|count||integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"code": 0,
	"msg": "",
	"success": true,
	"data": {},
	"count": 0
}
```


# 检测结果管理


## 更新检测结果


**接口地址**:`/result/update`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|结果ID|query|true|integer(int32)||
|data|更新后的检测结果数据(JSON格式)|query|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|msg||string||
|success||boolean||
|data||object||
|count||integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"code": 0,
	"msg": "",
	"success": true,
	"data": {},
	"count": 0
}
```


## 创建检测结果


**接口地址**:`/result/create`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|appointmentId|预约ID|query|true|integer(int32)||
|examId|检测项目ID|query|true|integer(int32)||
|data|检测结果数据(JSON格式)|query|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|msg||string||
|success||boolean||
|data||object||
|count||integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"code": 0,
	"msg": "",
	"success": true,
	"data": {},
	"count": 0
}
```


## 分页查询结果列表


**接口地址**:`/result/list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|pageNum|页码|query|true|integer(int32)||
|pageSize|每页数量|query|true|integer(int32)||
|appointmentId|预约ID查询|query|false|integer(int32)||
|examId|检测项目ID查询|query|false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|msg||string||
|success||boolean||
|data||object||
|count||integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"code": 0,
	"msg": "",
	"success": true,
	"data": {},
	"count": 0
}
```


## 查询检测结果


**接口地址**:`/result/get`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|结果ID|query|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|msg||string||
|success||boolean||
|data||object||
|count||integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"code": 0,
	"msg": "",
	"success": true,
	"data": {},
	"count": 0
}
```


## 删除检测结果


**接口地址**:`/result/delete`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|结果ID|query|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|msg||string||
|success||boolean||
|data||object||
|count||integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"code": 0,
	"msg": "",
	"success": true,
	"data": {},
	"count": 0
}
```


# 留言管理


## 创建留言


**接口地址**:`/message/create`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|userId|用户ID|query|true|integer(int32)||
|content|留言内容|query|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|msg||string||
|success||boolean||
|data||object||
|count||integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"code": 0,
	"msg": "",
	"success": true,
	"data": {},
	"count": 0
}
```


## 分页查询留言列表


**接口地址**:`/message/list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|pageNum|页码|query|true|integer(int32)||
|pageSize|每页数量|query|true|integer(int32)||
|userId|用户ID|query|false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|msg||string||
|success||boolean||
|data||object||
|count||integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"code": 0,
	"msg": "",
	"success": true,
	"data": {},
	"count": 0
}
```


## 查询留言


**接口地址**:`/message/get`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|留言ID|query|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|msg||string||
|success||boolean||
|data||object||
|count||integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"code": 0,
	"msg": "",
	"success": true,
	"data": {},
	"count": 0
}
```


## 删除留言


**接口地址**:`/message/delete`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|留言ID|query|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|msg||string||
|success||boolean||
|data||object||
|count||integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"code": 0,
	"msg": "",
	"success": true,
	"data": {},
	"count": 0
}
```


# 眼科项目管理


## 更新眼科项目


**接口地址**:`/exam/update`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|项目ID|query|true|integer(int32)||
|name|项目名称|query|true|string||
|description|项目描述|query|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|msg||string||
|success||boolean||
|data||object||
|count||integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"code": 0,
	"msg": "",
	"success": true,
	"data": {},
	"count": 0
}
```


## 创建眼科项目


**接口地址**:`/exam/create`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|name|项目名称|query|true|string||
|description|项目描述|query|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|msg||string||
|success||boolean||
|data||object||
|count||integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"code": 0,
	"msg": "",
	"success": true,
	"data": {},
	"count": 0
}
```


## 分页查询项目列表


**接口地址**:`/exam/list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|pageNum|页码|query|true|integer(int32)||
|pageSize|每页数量|query|true|integer(int32)||
|name|项目名称模糊查询|query|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|msg||string||
|success||boolean||
|data||object||
|count||integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"code": 0,
	"msg": "",
	"success": true,
	"data": {},
	"count": 0
}
```


## 查询眼科项目


**接口地址**:`/exam/get`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|项目ID|query|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|msg||string||
|success||boolean||
|data||object||
|count||integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"code": 0,
	"msg": "",
	"success": true,
	"data": {},
	"count": 0
}
```


## 删除眼科项目


**接口地址**:`/exam/delete`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|项目ID|query|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|msg||string||
|success||boolean||
|data||object||
|count||integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"code": 0,
	"msg": "",
	"success": true,
	"data": {},
	"count": 0
}
```


# 预约管理


## 更新预约状态


**接口地址**:`/appointment/update-status`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|预约ID|query|true|integer(int32)||
|status|状态(0:待确认,1:已确认,2:已取消)|query|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|msg||string||
|success||boolean||
|data||object||
|count||integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"code": 0,
	"msg": "",
	"success": true,
	"data": {},
	"count": 0
}
```


## 创建预约


**接口地址**:`/appointment/create`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|userId|用户ID|query|true|integer(int32)||
|examId|眼科项目ID|query|true|integer(int32)||
|appointmentTime|预约日期|query|true|||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|msg||string||
|success||boolean||
|data||object||
|count||integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"code": 0,
	"msg": "",
	"success": true,
	"data": {},
	"count": 0
}
```


## 分页查询预约列表


**接口地址**:`/appointment/list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|pageNum|页码|query|true|integer(int32)||
|pageSize|每页数量|query|true|integer(int32)||
|userId|用户ID|query|false|integer(int32)||
|examId|眼科项目ID|query|false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|msg||string||
|success||boolean||
|data||object||
|count||integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"code": 0,
	"msg": "",
	"success": true,
	"data": {},
	"count": 0
}
```


## 查询预约


**接口地址**:`/appointment/get`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|预约ID|query|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|msg||string||
|success||boolean||
|data||object||
|count||integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"code": 0,
	"msg": "",
	"success": true,
	"data": {},
	"count": 0
}
```


## 取消预约


**接口地址**:`/appointment/cancel`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|预约ID|query|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultDto|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|msg||string||
|success||boolean||
|data||object||
|count||integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"code": 0,
	"msg": "",
	"success": true,
	"data": {},
	"count": 0
}
```