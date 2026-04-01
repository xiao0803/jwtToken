#!/usr/bin/env bash
set -euo pipefail

mkdir -p .claude/runtime

{
  echo "=== FAILURE TIME ==="
  date
  echo
  echo "=== TEST STATUS ==="
  cat .claude/runtime/test-status.txt 2>/dev/null || true
  echo
  echo "=== TEST OUTPUT TAIL ==="
  tail -n 200 .claude/runtime/test-output.txt 2>/dev/null || true
} > .claude/runtime/failure-summary.txt

echo "[HOOK] failure summary collected"
