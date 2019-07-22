#!/bin/bash
vari=$(sudo docker run -d -t -v /home/znan/apache-tomcat-9.0.22/webapps/OpenAnalysisService/UploadedFile:/root nanzifan/call_graph_tools:v0.8)
echo "$vari"
