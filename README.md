search-the-logs
Few days after you started new job in a large company as a developer, you noticed that all developers are diving into logs manually to find errors.

🛠 Skills
Spring-boot,rest-api,Jpa,H2,Java v.11

Assumption:
first thing to do: use first api for save to db the request-Post: http://localhost:8081/api/log/addLogToDB

api for log level: you can write in request the log level uppercase or smallcase(its doesnt matter) for example: Get Request http://localhost:8081/api/log/searchLog/info

api for log time: you need to write according format: HH:mm:ss example : Get Request http://localhost:8081/api/log/searchingLogByLogTime/18:22:58/19:19:58

api for log MSG: word (case insensitive) Get Request examples: http://localhost:8081/api/log/searchingLogByLogMsg/Tomcat http://localhost:8081/api/log/searchingLogByLogMsg/detected

need to fix: size of string can convered the for in some case and use stream.

Authors
@HenLevi
🚀 About Me
I'm a full-stack developer. Love to learn and explore. I am not afraid from challenge.

On a personal level: I am a mother of 2 lovely little children:Lenny and Neil Love do be with my kids, learn and do SKI. :)
