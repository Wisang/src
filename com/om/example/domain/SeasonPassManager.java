package com.om.example.domain;

import java.util.Collections;
import java.util.List;

public class SeasonPassManager {
	
	private final Schedule schedule;
	private List<Program> toDoList = Collections.emptyList();

	public SeasonPassManager(Schedule schedule) {
		this.schedule = schedule;
	}

	public int sizeOfToDoList() {
		return toDoList.size();
	}

	public void createNewSeasonPass(String programName, int channel) {
		 toDoList = schedule.findProgramsNamedOn(programName, channel);
	}
	
}
