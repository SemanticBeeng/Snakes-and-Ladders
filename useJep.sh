#!/usr/bin/env bash

export PYTHONHOME=/development/bin/python/conda3/envs/py35

export LD_LIBRARY_PATH=$PYTHONHOME/lib/python3.5/site-packages/jep

export JEP_CP=$LD_LIBRARY_PATH/jep-3.7.1.jar

export LD_PRELOAD=$PYTHONHOME/lib/libpython3.5m.so.1.0

