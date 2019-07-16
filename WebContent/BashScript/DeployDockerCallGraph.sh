#!/bin/bash
vari=$(sudo docker run -d -t -v $(pwd):/root nanzifan/call_graph_tools:v0.8)
echo "$vari"
echo "$USER done"