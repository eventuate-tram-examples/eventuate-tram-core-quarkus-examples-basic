#! /bin/bash

set -e

export DATABASE=mysql
export MODE=binlog
export BROKER=kafka
export EVENTUATEDATABASE=mysql

./_build-and-test-all.sh
