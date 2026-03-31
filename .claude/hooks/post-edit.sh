#!/bin/bash

echo "代码已修改，开始自动测试..."

cd "$(dirname "$0")/../.." || exit 1

mvn test

if [ $? -ne 0 ]; then
  echo "❌ 测试失败，请检查修改"
  exit 1
fi

echo "✅ 测试通过"
