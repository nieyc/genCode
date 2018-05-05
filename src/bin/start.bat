@echo off
set CSS_DEPLOY_HOME=.
set CSS_LIB=%CSS_DEPLOY_HOME%\lib

set CSS_PATH=%CSS_DEPLOY_HOME%\classes

set CSS_PATH=%CSS_PATH%;%CSS_LIB%\commons-lang3-3.7.jar
set CSS_PATH=%CSS_PATH%;%CSS_LIB%\druid-1.1.6.jar
set CSS_PATH=%CSS_PATH%;%CSS_LIB%\freemarker-2.3.28.jar
set CSS_PATH=%CSS_PATH%;%CSS_LIB%\mysql-connector-java-5.1.44.jar


echo %CSS_PATH%
echo genCode 1.0 author:  nieyc@panchan.com.cn
java -Xms512m -Xmx512m -classpath %CSS_PATH%  -Ddesc=startUp  com.github.nyc.App
@pause