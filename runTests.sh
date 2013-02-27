#!/bin/bash -e

# -e so the script exits immediatelly after a compile error

echo "Compiling TestDoublesList.java..."
javac tests/TestDoublesList.java
echo "Compile OK. Running tests."
java -ea tests.TestDoublesList      # -ea turns on assertions



