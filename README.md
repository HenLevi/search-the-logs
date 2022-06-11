
# search-the-logs
Few days after you started new job in a large company as a developer, you noticed that all developers
are diving into logs manually to find errors.




## 🛠 Skills
Spring-boot,rest-api,Jpa,H2,Java v.11


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


## Authors

- [@HenLevi](https://github.com/HenLevi?tab=repositories)





## 🚀 About Me
I'm a full-stack developer.
Love to learn and explore.
I am not afraid from challenge.

On a personal level:
I am a mother of 2 lovely little children:Lenny and Neil
Love do be with my kids, learn and do SKI. :)
