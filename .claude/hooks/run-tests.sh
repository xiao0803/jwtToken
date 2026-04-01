#!/usr/bin/env bash
set -euo pipefail

mkdir -p .claude/runtime

echo "[HOOK] running mvn test..."

if mvn test > .claude/runtime/test-output.txt 2>&1; then
  echo "TEST_PASSED" > .claude/runtime/test-status.txt
  echo "[HOOK] tests passed"
  exit 0
else
  echo "TEST_FAILED" > .claude/runtime/test-status.txt
  echo "[HOOK] tests failed"
  exit 1
fi
