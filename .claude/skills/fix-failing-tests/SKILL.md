# Skill: fix-failing-tests

## Description
根据测试失败摘要定位并修复问题。

## Instructions
1. 优先读取 .claude/runtime/failure-summary.txt
2. 判断失败属于：
   - 编译错误
   - 断言失败
   - 环境/配置错误
3. 只做最小修复
4. 修复后建议重新运行测试
