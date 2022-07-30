## 系统模块

```
org.pengfu
├── pengfu-cloud-gateway        // 网关模块 [8080]
├── pengfu-cloud-common         // 通用模块
│       └── pengfu-cloud-common-core            // 核心模块
│       └── pengfu-cloud-common-service         // 服务模块
├── pengfu-cloud-api            // 接口模块
│       └── pengfu-cloud-user-api
│       └── pengfu-cloud-order-api
├── pengfu-cloud-modules        // 业务模块
│       └── pengfu-cloud-user                   // 用户模块 [9202]
│       └── pengfu-cloud-order                  // 订单生成 [9203]
├── pengfu-cloud-admin          // 后台管理模块 [9201]
├── pom.xml                     // 公共依赖
```

