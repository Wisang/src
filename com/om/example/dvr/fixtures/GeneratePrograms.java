package com.om.example.dvr.fixtures;

import java.text.ParseException;

import com.om.example.util.DateUtil;

public class GeneratePrograms {
	AddProgramsToSchedule addProgramsToSchedule = new AddProgramsToSchedule();

	public String CreateWeeklyProgramNamedOnChannelStartingOnAtLengthEpisodes(
			String programName, int channel, String startDate,
			String startTime, int lengthInMinutes, int episodes)
			throws ParseException {

		generateManyPrograms(programName, channel, startDate, startTime,
				episodes, 7);
		return addProgramsToSchedule.lastId();
	}

	public String CreateDailyProgramNamedOnChannelStartingOnAtLengthEpisodes(
			String programName, int channel, String startDate,
			String startTime, int lengthInMinutes, int episodes)
			throws ParseException {
		generateManyPrograms(programName, channel, startDate, startTime,
				episodes, 1);
		return addProgramsToSchedule.lastId();
	}

	private void generateManyPrograms(String programName, int channel,
			String startDate, String startTime, int episodes, int daysBetween)
			throws ParseException {
		String nextStartDate = startDate;
		for (int i = 0; i < episodes; ++i) {
			createOneProgram(programName, channel, startTime, nextStartDate, i);
			nextStartDate = DateUtil.instance().addDaysTo(daysBetween,
					nextStartDate);
		}
	}

	private void createOneProgram(String programName, int channel,
			String startTime, String nextStartDate, int i)
			throws ParseException {
		addProgramsToSchedule.setChannel(channel);
		addProgramsToSchedule.setDate(nextStartDate);
		addProgramsToSchedule.setEpisode(String.format("E%d", (i + 1)));
		addProgramsToSchedule.setName(programName);
		addProgramsToSchedule.setStartTime(startTime);
		addProgramsToSchedule.execute();
	}
}
