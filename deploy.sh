#!/bin/bash
/home/service/tomcat/bin/stop_tomcat.sh bi.vyohui.com
cd /home/work/davdian-bi && svn up
cd /home/work/davdian-bi/davdian-bi-web && npm run build
cd /home/work/davdian-bi/davdian-bi-platform && mvn clean package -Dmaven.test.skip=true && mv target/davdian-bi-platform.war /home/work/bi.vyohui.com/webapps
mv /home/work/bi.vyohui.com/webapps/davdian-bi-platform/upload /tmp/upload
rm -rf /home/work/bi.vyohui.com/webapps/davdian-bi-platform
/home/service/tomcat/bin/start_tomcat.sh bi.vyohui.com
mv /tmp/upload /home/work/bi.vyohui.com/webapps/davdian-bi-platform/upload
