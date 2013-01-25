package com.om.example.dvr.fixtures;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.om.example.domain.ConflictingProgramException;
import com.om.example.domain.Program;
import com.om.example.domain.Schedule;
import com.om.example.util.DateUtil;

public class AddProgramsToSchedule {
	static SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy|h:mm");

	private boolean lastCreationSuccessful;

	// for testing purpose
	private static Schedule schedule = new Schedule();

	private int channel;
	private String date;
	private String startTime;
	private int minutes;
	private String programName;
	private String episodeName;
	private String lastId;

	private static int numberCreated = 0;

	public static Schedule getSchedule() {
		return schedule;
	}

	public void execute() throws ParseException {
		try {
			Program p = schedule.addProgram(programName, episodeName, channel,
					DateUtil.instance().buildDate(date, startTime), minutes);
			lastId = p.getId();
			lastCreationSuccessful = true;
		} catch (ConflictingProgramException e) {
			lastCreationSuccessful = false;
		}
	}

	public AddProgramsToSchedule() {
		System.out.printf("Creating ProgramsToSchedule #%d\n", ++numberCreated);
	}

	public void setName(String name) {
		this.programName = name;
	}

	public void setEpisode(String name) {
		this.episodeName = name;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public String lastId() {
		if (lastCreationSuccessful)
			return lastId;
		return "n/a";
	}

	public boolean created() {
		return lastCreationSuccessful;
	}

	// no longer necessary
	// private Date buildStartDateTime() {
	// try {
	// String dateTime = String.format("%s|%s", date, startTime);
	// return dateFormat.parse(dateTime);
	// } catch (ParseException e) {
	// throw new RuntimeException("Unable to parse date/time", e);
	// }
	// }
}