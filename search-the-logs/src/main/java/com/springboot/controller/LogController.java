package com.springboot.controller;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.model.Log;
import com.springboot.service.LogService;

@RestController
@RequestMapping("/api/log")
public class LogController {
	private static Logger LOG = org.slf4j.LoggerFactory.getLogger(LogController.class);

	@Autowired
	LogService logService;

	@PostMapping(path = "/addLogToDB")
	public ResponseEntity<Log> addLogToDB(@RequestBody String newLog) {
		try {
			logService.parseLogAndSaveToDB(newLog);
			LOG.debug("log added to DB: " + newLog);
			return new ResponseEntity<Log>(HttpStatus.OK);
		} catch (Exception e) {
			LOG.error("Error in controller: LogController in addLogToDB function, exception: " + e);
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

	@GetMapping("/searchLog/{logLevel}")
	public ResponseEntity<ArrayList<Log>> searchingLogByLogLevel(@PathVariable(name = "logLevel") String logLevel) {
		try {
			ArrayList<Log> filteredLogList = logService.searchingLogByLogLevel(logLevel);
			return new ResponseEntity<ArrayList<Log>>(filteredLogList, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error("Error in controller: LogController in searchingLogByLogLevel function, exception:" + e);
			return null;
		}
	}

	@GetMapping("/searchingLogByLogMsg/{wordFromMsg}")
	public ResponseEntity<ArrayList<Log>> searchingLogByLogMsg(@PathVariable(name = "wordFromMsg") String wordFromMsg) {
		try {
			ArrayList<Log> filteredLogList = logService.searchingLogByLogMsg(wordFromMsg);
			return new ResponseEntity<ArrayList<Log>>(filteredLogList, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error("Error in controller: LogController in searchingLogByLogMsg function, exception:" + e);
			return null;
		}
	}

	@GetMapping("/searchingLogByLogTime/{startLogTime}/{endLogTime}")
	public ResponseEntity<List<Log>> searchingLogByLogTime(@PathVariable(name = "startLogTime") String startLogTime,
			@PathVariable(name = "endLogTime") String endLogTime) {
		try {
			List<Log> filteredLogList = logService.searchingLogByLogTime(startLogTime, endLogTime);
			return new ResponseEntity<List<Log>>(filteredLogList, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error("Error in controller: LogController in searchingLogByLogTime function, exception:" + e);
			return null;
		}
	}

	@GetMapping("/searchingLogAccordingChoices")
	@ResponseBody
	public ResponseEntity<List<Log>> searchingLogAccordingChoices(
			@RequestParam(value = "loglevel", required = false, defaultValue = "") String logLevel,
			@RequestParam(value = "startlogtime", required = false, defaultValue = "") String startlogtime,
			@RequestParam(value = "endlogtime", required = false, defaultValue = "") String endlogtime,
			@RequestParam(value = "wordfrommsg", required = false, defaultValue = "") String wordfrommsg) {
		try {
			List<Log> filteredLogList = logService.searchingLogAccordingChoices(logLevel, startlogtime, endlogtime,
					wordfrommsg);
			return new ResponseEntity<List<Log>>(filteredLogList, HttpStatus.OK);

		} catch (Exception e) {
			LOG.error("Error in controller: LogController in searchingLogAccordingChoices function, exception:" + e);
			return null;

		}

	}

}
