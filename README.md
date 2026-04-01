# jwtToken

基于 Spring Boot 3.x + JWT 的 Token 身份认证示例项目。

## 技术栈

| 类别 | 技术 |
|------|------|
| 框架 | Spring Boot 3.2.5 (Spring 6.x) |
| Java | 17+ |
| 认证 | JWT (java-jwt 3.19.4) |
| JSON | Fastjson2 2.0.52 |
| 构建 | Maven (JDK 17+) |

## 项目结构

```
src/main/java/com/joe/
├── Application.java           # 启动类
├── config/
│   └── WebConfig.java        # Web MVC 配置
├── entity/
│   ├── ApiResponse.java      # 统一响应结构
│   └── User.java             # 用户实体
├── enums/
│   └── ApiResponseEnum.java  # 响应枚举
├── interceptor/
│   └── TokenInterceptor.java # Token 拦截器
├── service/
│   ├── IUserService.java     # 用户服务接口
│   └── impl/
│       └── UserServiceImpl.java
├── util/
│   ├── ApiResponseUtil.java   # 响应工具类
│   └── JwtUtil.java          # JWT 工具类
└── web/
    ├── LoginController.java  # 登录接口
    └── UserController.java   # 用户接口
```

## API 接口

### 1. 登录

```
POST /login
Content-Type: application/json

{
  "loginName": "xxx",
  "password": "xxx"
}
```

**响应：**
```json
{
  "errCode": 0,
  "errMsg": "success",
  "data": "<JWT_TOKEN>"
}
```

### 2. 获取用户（需 Token）

```
GET /user/
access_token: <JWT_TOKEN>
```

**响应：**
```json
{
  "errCode": 0,
  "errMsg": "success",
  "data": {
    "id": "xxx",
    "name": "xxx",
    "age": 25
  }
}
```

## JWT 机制

| 项目 | 说明 |
|------|------|
| 算法 | HS256 |
| 过期时间 | 60 分钟 |
| 携带信息 | loginName, userId |
| 传递方式 | Header `access_token` |

## 拦截器配置

`TokenInterceptor` 拦截所有 `/user/**` 请求（`/login/**` 除外），验证 Token 有效性。

## 运行

```bash
# JDK 17+ required
mvn clean package
java -jar target/jwtToken.jar

# 或使用 Maven
mvn spring-boot:run
```

## Claude Code 集成

项目已配置 Coding Agent Harness：

```
.claude/
├── skills/
│   ├── code-review/   # 代码审查
│   ├── refactor/      # 重构
│   └── test/          # 测试生成
├── hooks/
│   └── post-edit.sh   # 改代码后自动 mvn test
└── settings.json
```

### 使用方式

```bash
claude
```

- `/code-review` — 审查代码
- `/refactor` — 重构优化
- `/test` — 生成单元测试

每次代码修改后自动触发 `mvn test` 验证。

## 参考

- 配套博客：https://blog.csdn.net/KKKun_Joe/article/details/81878231

## 迁移记录

- 2026-03-31: 从 Spring MVC + XML 重构为 Spring Boot 3.x
  - Java 8 → Java 17
  - javax.servlet → jakarta.servlet
  - fastjson → fastjson2
  - XML 配置 → Java Config
test
