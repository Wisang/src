package com.om.example.dvr.fixtures;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.om.example.domain.TimeSlot;

public class AddProgramsToSchedule {
	private static SimpleDateFormat dateFormat = new SimpleDateFormat(
			"M/d/yyyy|h:mm");
	private List<TimeSlot> scheduledTimeSlots = new LinkedList<TimeSlot>();
	private int channel;
	private String date;
	private String startTime;
	private int minutes;
	
	private final int MAX_PROGRAM = 100;

	public void setName(String name) {
	}

	public void setEpisode(String name) {
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

	public boolean created() {
		TimeSlot timeSlot = new TimeSlot(channel, buildStartDateTime(), minutes);

		// complete me!
		
		if (conflictsWithOtherTimeSlots(timeSlot))
			return false;

		scheduledTimeSlots.add(timeSlot);
		return true;
	}

	private boolean conflictsWithOtherTimeSlots(TimeSlot timeSlot) {
		for (TimeSlot current : scheduledTimeSlots)
			if (current.conflictsWith(timeSlot))
				return true;

		return false;
	}

	private Date buildStartDateTime() {
		try {
			String dateTime = String.format("%s|%s", date, startTime);
			return dateFormat.parse(dateTime);
		} catch (ParseException e) {
			throw new RuntimeException("Unable to parse date/time", e);
		}
	}
}
