# M0 架构说明

## 工程形态

苍生之下按提案采用单 jar、模块化单体。`local.cangsheng.Cangsheng` 只装配注册中心，并把生命周期事件分别接到 NeoForge mod bus 与全局事件总线；它不承载玩法代码。Java 与构建基线固定为 Minecraft 26.1.2、NeoForge 26.1.2.114、Java 25、Gradle 9.2.1、ModDevGradle 2.0.148。

## 包边界

- `api/` 是跨系统可见的稳定契约，包含技能、资源、战斗和门派的值类型与接口。实现包不得互相依赖实现类。
- `core/registry/` 是所有 `DeferredRegister` 的唯一归属；每个中心只声明注册项，不写具体系统行为。
- `core/compat/` 集中放置依赖当前 NeoForge/Minecraft API 的薄适配，例如原版状态效果镜像。已核对的版本事实记录在 `API-BASELINE.md`。
- `core/datapack/` 声明四种可由数据包扩展的定义类型；`core/attachment/` 只保存可序列化的 M0 数据形状。
- `core/event/` 放命令与 GameTest 装配；`datagen/` 写语言、模型、标签和配方文件。
- `cultivation/`、`combat/`、`resource/`、`skill/`、`status/`、`sect/`、`content/` 等功能包尚不实现玩法。M0 中没有伤害结算、资源变化、技能施放或实体行为。

## 注册和数据流

物品、方块、实体、镜像效果、属性、组件、附件、音效、粒子、菜单和创造标签页在 mod 构造时由各自中心挂接注册。伤害类型是数据定义，对应 `ResourceKey<DamageType>`；sect、skill、realm、resource 则通过 `DataPackRegistryEvent.NewRegistry` 注册 codec-backed 数据注册表。注册表 JSON 使用 `data/cangsheng/cangsheng/<registry>/<id>.json` 路径。

`GatherDataEvent.Client` 装配 DataGen provider，输出到 `src/generated/resources/`；此目录已作为主资源目录。手工维护的设定数据留在 `src/main/resources/`，避免把设定源和生成物混在一起。

## 运行边界

服务端持有权威档案、资源、控制、护盾和技能状态；客户端只会在后续里程碑消费同步快照与表现。M0 的 `/cangsheng debug` 命令只输出空状态。当前单 jar 是默认决策；不硬依赖 SISE-Core、Curios 或 KubeJS，不使用 Mixin。
