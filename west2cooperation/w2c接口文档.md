---
title: w2 v1.0.0
language_tabs:
  - shell: Shell
  - http: HTTP
  - javascript: JavaScript
  - ruby: Ruby
  - python: Python
  - php: PHP
  - java: Java
  - go: Go
toc_footers: []
includes: []
search: true
code_clipboard: true
highlight_theme: darkula
headingLevel: 2
generator: "@tarslib/widdershins v4.0.17"

---

# w2

> v1.0.0

Base URLs:

* <a href="http://localhost:8080">测试环境: http://localhost:8080</a>

# Default

## GET 登录

GET /login

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|username|query|string| 否 |none|
|password|query|string| 否 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 添加用户

GET /add

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|reg_username|query|string| 否 |none|
|reg_password|query|string| 否 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## PUT 修改个人资料

PUT /user/update/{newName}/{contact}/{id}

身份、联系方式录入

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|newName|path|string| 是 |none|
|contact|path|string| 是 |none|
|id|path|string| 是 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 个人资料

GET /user/profile

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 所有项目查询

GET /project/select/{curPage}

一页十个项目，项目展示用。查看项目由前端写。

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|curPage|path|string| 是 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## PUT 添加项目

PUT /project/add/{pname}/{reason}/{need}/{inId}

提交时要提交用户身份证明inId，与个人资料内相同才可以提交。项目添加成功自动提交审核。

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|pname|path|string| 是 |none|
|reason|path|string| 是 |none|
|need|path|integer| 是 |none|
|inId|path|string| 是 |none|

> 返回示例

> 200 Response

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## DELETE 删除项目

DELETE /project/delete/{pid}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|pid|path|string| 是 |none|

> 返回示例

> 200 Response

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|成功删除|Inline|

### 返回数据结构

## GET 查询捐款情况

GET /project/queryFund/{pid}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|pid|path|string| 是 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## PUT 捐款

PUT /project/updateFund/{fund}/{pid}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|fund|path|string| 是 |none|
|pid|path|string| 是 |none|

> 返回示例

> 200 Response

```json
{}
```

> 404 Response

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|捐款成功|Inline|

### 返回数据结构

## GET 按项目名查询项目

GET /project/query/{name}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|name|path|string| 是 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 查询审核状态

GET /project/audit/{pid}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|pid|path|string| 是 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 退出登录

GET /logout

> 返回示例

> 200 Response

```json
{}
```

> 404 Response

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|退出成功|Inline|

### 返回数据结构

## PUT 管理员审核

PUT /admin/audit/{pid}/{audit}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|pid|path|string| 是 |none|
|audit|path|string| 是 |none|

> 返回示例

> 200 Response

```json
{}
```

> 404 Response

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|审核成功|Inline|

### 返回数据结构

## DELETE 管理员删除项目

DELETE /admin/delete/{pid}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|pid|path|string| 是 |none|

> 返回示例

> 200 Response

```json
{}
```

> 404 Response

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|删除成功|Inline|

### 返回数据结构

## POST 提交项目图片

POST /project/picture/{pname}

> Body 请求参数

```yaml
file: file://C:\Users\86187\Desktop\1.png

```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|pname|path|string| 是 |none|
|Content-Type|header|string| 否 |none|
|body|body|object| 否 |none|
|» file|body|string(binary)| 否 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

# 数据模型

