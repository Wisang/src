package com.om.example.dvr.fixtures;

import java.util.LinkedList;
import java.util.List;

public class EpisodesInToDoList {
	public EpisodesInToDoList(String programId) {
	}

	private List<Object> list(Object... objs) {
		LinkedList<Object> result = new LinkedList<Object>();

		for (Object current : objs)
			result.add(current);

		return result;
	}

	public List<Object> query() {
		return list(list(list("episodeName", "E1"), list("date", "5/17/2008"),
				list("startTime", "7:00")));
	}
}
