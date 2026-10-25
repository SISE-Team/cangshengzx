# 内容管线

## 来源与约束

设定数值以 `苍生之下_六派设定集_v0.2.2.docx` 为准，工程 id 与系统结构以 `版本框架的提案.md` 为准。没有来源的字段保持空值或未指定状态，不用猜测的玩法数值填满 schema；需要决策的项目列入待拍板清单。

## 数据注册表

四类数据文件都放在 `src/main/resources/data/cangsheng/cangsheng/` 下，每个文件名就是注册表条目 id：

- `realm/`：十境、每境十级。等级区间、寿元描述与 `mark` 均按设定集 1.1。
- `sect/`：六派及分支 id 固定取提案附录 B；七言取设定集 1.7。各派主色由 `art/palette/*.hex` 维护，当前值是占位色。
- `resource/`：十一项资源及 4.3 节明确的上限与形态。通用“灵”的归属范围、形态和上限在提案中没有给定，因此 JSON 将 `sect`、`shape` 留空并省略 `max`；codec 将上限读为 `-1`（未指定），不能视为实际无限资源。
- `skill/`：仅 `落花步`、`惊雷影` 两条 schema 样板。已明确的炼气境界、类型、花瓣消耗与惊雷影扇形目标取设定集第二章；未定的 cooldown、cast 参数、require、breaker 与行为字段使用零值或空值占位。落花步的 `dash` 是提案示例中的位移角色名；移动参数仍是 schema 占位，不代表最终技能规则。

注册表 key 例如 `cangsheng:realm` 的条目路径因此为 `data/cangsheng/cangsheng/realm/<id>.json`。变更字段时，先同步更新 `core/datapack/` codec，再校验现有 JSON；不要用额外代码值覆盖数据文件。

## 资源与美术

调色板的六个主色是占位视觉值，名称和方向来自提案附录 B；可以在美术定稿时替换。物品 SVG 固定为 16×16，源文件位于 `art/svg/item/`。执行 `./art/export.ps1` 会优先调用 Inkscape，其次 resvg，将图像输出至 `src/main/resources/assets/cangsheng/textures/item/`。若两者均不存在，脚本会打印提示并以成功状态退出；不应手工提交替代 PNG。

模型、blockstate、zh_cn/en_us 语言、tag 与一个临时祭坛 recipe 由 DataGen provider 维护。recipe 目前只是验证管线的占位内容，不是设定集定稿配方。运行：

```powershell
.\gradlew.bat runClientData
```

当前 ModDevGradle 运行类型名为 `clientData`，任务名为 `runClientData`（不是旧教程中的 `runData`）。若本机未自动发现 ModDevGradle 使用的 Java 21 下载工具链，可临时加 `-Dorg.gradle.java.installations.paths=<JDK21目录>`；模组编译与游戏运行仍以 Java 25 为基线。
