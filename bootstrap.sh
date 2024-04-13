#!/bin/bash

# Fail if any command fails
set -e

# Output commands
set -x

# Install Carthage if it's not installed
if ! command -v carthage &> /dev/null; then
    echo "Carthage not found. Installing..."
    brew install carthage
fi

# Install dependencies
echo "Installing dependencies with Carthage..."
carthage bootstrap --platform iOS --use-ssh --no-use-binaries

# Prepare WebDriverAgent project
echo "Preparing WebDriverAgent project..."
