package com.springboot.service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.dao.LogDao;
import com.springboot.model.Log;

@Service
public class LogService {
	private static Logger LOG = org.slf4j.LoggerFactory.getLogger(LogService.class);

	@Autowired
	LogDao logDao;

	public List<Log> getAllLogList() {
		List<Log> allLog = logDao.findAll();
		return allLog;
	}

	public int getMaxId() {
		return logDao.findAll().size() + 1;
	}

	public void parseLogAndSaveToDB(String newLog) {
		try {
			int countOfRow = 0;
			Log log = new Log();
			String[] lines = newLog.split("\n");

			for (String line : lines) {

				line.substring(0, line.indexOf(' '));

				if (!line.substring(0, 3).contains("\t")) {
					log.setLogLevel(line.substring(0, 5));
					log.setLogTime(LocalTime.parse(line.split(" ")[3]));// time
				} else {
					log.setLogLevel("");
					log.setLogTime(null);
				}
				if (line.length() > 240) {
					log.setLogMsg(line.substring(30, 210));
				} else if (line.length() > 30) {
					log.setLogMsg(line.substring(30));
				} else {
					log.setLogMsg(line.substring(1));
				}

				// save in db
				log.setId(getMaxId());
				logDao.save(log);
				countOfRow++;
			}
			System.out.println("Number of rows: " + countOfRow);
		} catch (Exception e) {
			LOG.error("Error in service: LogService in parseLogAndSave function, exception:" + e);
			System.out.println("Number of rows: -1");
		}
	}

	public ArrayList<Log> searchingLogByLogLevel(String logLevel) {
		try {
			int countOfRowFiltered = 0;
			List<Log> allLog = getAllLogList();
			logLevel = logLevel.toUpperCase();
			ArrayList<Log> filteredLogList = new ArrayList<Log>();
			for (Log lineFiltered : allLog) {
				if (lineFiltered.getLogLevel().equals(logLevel)) {
					filteredLogList.add(lineFiltered);
					countOfRowFiltered++;
				}
			}
			System.out.println("Number of rows filtered by log level: " + countOfRowFiltered);
			return filteredLogList;
		} catch (Exception e) {
			LOG.error("Error in service: LogService in searchingLogByLogLevel function, exception:" + e);
			return null;
		}
	}

	public ArrayList<Log> searchingLogByLogMsg(String wordFromMsg) {
		try {
			int countOfRowFiltered = 0;
			List<Log> allLog = getAllLogList();
			String wordFromMsgLowercase = wordFromMsg.toLowerCase();
			ArrayList<Log> filteredLogList = new ArrayList<Log>();
			for (Log lineFiltered : allLog) {
				if (lineFiltered.getLogMsg().toLowerCase().contains(wordFromMsgLowercase)) {
					filteredLogList.add(lineFiltered);
					countOfRowFiltered++;
				}
			}
			System.out.println("Number of rows filtered by log msg: " + countOfRowFiltered);
			return filteredLogList;
		} catch (Exception e) {
			LOG.error("Error in service: LogService in searchingLogByLogMsg function, exception:" + e);
			return null;
		}
	}

	public List<Log> searchingLogByLogTime(String start, String end) {
		try {
			LocalTime startTime = LocalTime.parse(start, DateTimeFormatter.ofPattern("HH:mm:ss"));
			LocalTime endTime = LocalTime.parse(end, DateTimeFormatter.ofPattern("HH:mm:ss"));
			List<Log> allLogFiltered = logDao.retriveLogByTime(startTime, endTime);
			return allLogFiltered;
		} catch (Exception e) {
			LOG.error("Error in service: LogService in searchingLogByLogTime function, exception:" + e);
			return null;
		}
	}

	public List<Log> searchingLogAccordingChoices(String logLevel, String startLogTime, String endLogTime,
			String wordFromMsg) {

		String lowerword = wordFromMsg.toLowerCase();
		ArrayList<Log> filterLog = new ArrayList<Log>();

		// this array list bring log according time
		ArrayList<Log> logs = (!startLogTime.isEmpty())
				? (ArrayList<Log>) searchingLogByLogTime(startLogTime, endLogTime)
				: (ArrayList<Log>) logDao.retriveLogByTime((LocalTime.parse(startLogTime)),
						(LocalTime.parse(endLogTime)));

		for (Log log : logs) {
			if (!logLevel.isEmpty())
				if (!log.getLogLevel().startsWith(logLevel))
					continue;
			if (!wordFromMsg.isEmpty())
				if (!log.getLogMsg().toLowerCase().contains(lowerword))
					continue;
			filterLog.add(log);
			return filterLog;
		}
		return filterLog;
	}

}
