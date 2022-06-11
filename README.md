
## Assumption:

**first thing to do:** use first api for save to db.
 Post request
 body contains all log.
http://localhost:8081/api/log/addLogToDB

**api for log level:** find in log according log level
for example: Get Request
http://localhost:8081/api/log/searchLog/info


**api for log time:** you need to write according format:
HH:mm:ss
example : Get Request
http://localhost:8081/api/log/searchingLogByLogTime/18:22:58/19:19:58

**api for log MSG:** word (case insensitive)
Get Request
examples:
http://localhost:8081/api/log/searchingLogByLogMsg/Tomcat
http://localhost:8081/api/log/searchingLogByLogMsg/detected 

Open Issue:
add log to DB:
1.Size of string - too big  ( remove some line from log)
2.instead for loop , use Stream in some cases.
