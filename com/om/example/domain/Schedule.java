package com.om.example.domain;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Schedule {
	private List<TimeSlot> scheduledTimeSlots = new LinkedList<TimeSlot>();

	public void addProgram(String programName, String episodeName, int channel,
			Date startDateTime, int lengthInMinutes) {

		TimeSlot timeSlot = new TimeSlot(channel, startDateTime,
				lengthInMinutes);

		if (conflictsWithOtherTimeSlots(timeSlot))
			throw new ConflictingProgramException();

		scheduledTimeSlots.add(timeSlot);
	}

	private boolean conflictsWithOtherTimeSlots(TimeSlot timeSlot) {
		for (TimeSlot current : scheduledTimeSlots)
			if (current.conflictsWith(timeSlot))
				return true;

		return false;
	}
}
