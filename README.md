
# search-the-logs
Few days after you started new job in a large company as a developer, you noticed that all developers
are diving into logs manually to find errors.




## 🛠 Skills
Spring-boot,rest-api,Jpa,H2,Java v.11


## Assumption:

**first thing to do:** use first api for save log to db.
 Post request
 Body contain all log.
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

**api for filter combination:** 
Get Request
examples:
http://localhost:8081/api/log/searchingLogAccordingChoices?loglevel=INFO&startlogtime=17:19:58&endlogtime=19:19:58&wordfrommsg=falling

**about section task 4(optimaize my solution):** I think maybe choose another db like Cassandra DB or MongoDB
(Big Data) 
## Authors

- [@HenLevi](https://github.com/HenLevi?tab=repositories)


## 🚀 About Me
I'm a full-stack developer.
Looking for backend developer position.
Love to learn and explore.
I am not afraid from challenge.

On a personal level:
I am a mother of 2 lovely little children:Lenny and Neil
Love do be with my kids, learn and do SKI. :)
