<h1 align="center">SAPI-接口一站通SDK</h1>
<p align="center"><strong>SAPI是专注简化开发者开发流程的平台</strong></p>

# 使用指南

## 1.下载Jar包

下载[sapi-client-sdk](https://github.com/swxswxer/sapi-client-sdk/releases/tag/v0.0.1)

## 2.引入jar包

这里以idea为例

打开项目结构

![image-20240818211753025](/assets/image-20240818211753025.png)

选择下载的jar包并引入

## 3.平台获取密钥（如果已经获取 请跳过）

进入 [SAPI接口一站通平台](http://120.79.135.199:29176/) 注册并登陆

进入个人中心

![image-20240818214058062](/assets/image-20240818214058062.png)

![image-20240818214159258](/assets/image-20240818214159258.png)

点击查询密钥并输入账户密码后即可获取AKSK

## 4.配置AccessKey与SecretKey

该项目允许通过两种方式配置密钥

如果你是springboot项目你可以在application.yml中快速配置密钥并通过@Autowired注解快速注入Bean并使用

```yaml
sapi:
  client:
    access-key: #你的accessKey
    secret-key: #你的secretKey
```

如果你不是在springboot中使用该sdk，你可以使用构造函数的方式配置密钥

```java
String accessKey = "你的accessKey";
String secretKey = "你的secretKey";
SapiClient sapiClient = new SapiClient(accessKey,accessKey);
```

# 快速调用

这里以构造函数的方式来配置aksk

去平台接口广场查看接口

![image-20240818213238326](/assets/image-20240818213238326.png)

这里以getRandomToxicSoups为例子 点击进入查看接口文档

![image-20240818213324848](/assets/image-20240818213324848.png)

获取请求url 请求方法 请求参数等信息

调用接口

```java
String accessKey = "你的ak";
String secretKey = "你的sk";
SapiClient sapiClient = new SapiClient(accessKey,secretKey);
String url = "http://120.79.135.199:29176/gateway/api/toxicsoups/";
System.out.println(sapiClient.getInvoke(url,null););
```

获得结果

![image-20240818213908510](/assets/image-20240818213908510.png)

