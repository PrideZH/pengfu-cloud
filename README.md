## 系统模块

```
org.pengfu
├── gateway         // 网关模块 [8080]
├── common          // 通用模块
│       └── ruoyi-common-core                         // 核心模块
│       └── ruoyi-common-datascope                    // 权限范围
│       └── ruoyi-common-datasource                   // 多数据源
│       └── ruoyi-common-log                          // 日志记录
│       └── ruoyi-common-redis                        // 缓存服务
│       └── ruoyi-common-security                     // 安全模块
│       └── ruoyi-common-swagger                      // 系统接口
├── auth            // 认证中心 [9201]
├── api             // 接口模块
│       └── user-api
│       └── order-api
├── modules         // 业务模块
│       └── ruoyi-system                              // 系统模块 [9202]
│       └── ruoyi-gen                                 // 代码生成 [9203]
│       └── ruoyi-job                                 // 定时任务 [9204]
├── admin			// 后台管理模块 (单体项目) [9200]
├──pom.xml          // 公共依赖
```

