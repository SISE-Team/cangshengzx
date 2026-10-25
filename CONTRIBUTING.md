# 参与贡献

本项目以 Minecraft **26.1.2** 为开发基线，贡献应保持单 jar、Groovy DSL 与 `local.cangsheng` 包边界。

## 提交改动

改动应集中在一个明确目标，并避免顺带格式化无关文件。新增内容需遵守 MIT 许可；第三方素材须在本文件或 `NOTICE.md` 中记录来源、署名与许可。

## 验证

Windows PowerShell：

```powershell
.\gradlew.bat build
.\gradlew.bat runGameTestServer
.\gradlew.bat runClientData
```

涉及界面、资源加载或客户端注册时，再运行 `runClient`。M0 的 DataGen 任务名是 `runClientData`。测试使用独立且可丢弃的游戏目录，不要将正式存档或凭据提交到仓库。

## 结构约定

- `core/registry/` 是唯一允许持有 `DeferredRegister` 的包。
- `core/compat/` 集中处理版本敏感 API。
- 系统实现包之间只通过 `api/` 公开类型交互。
- 不引入 Mixin、Parchment、Kotlin DSL 或必需的第三方模组依赖。
