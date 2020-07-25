package com.example.demo.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.example.demo.model.Meeting;

public class HiCalMeeting {

	public static void main(String[] args) {

		List<Meeting> mergedMeetings = mergeRanges(Arrays.asList(new Meeting(0, 1),
				new Meeting(3,5),new Meeting(4, 8),new Meeting(10, 12),new Meeting(9, 10)));

		mergedMeetings.forEach(System.out::println);

	}

	public static List<Meeting> mergeRanges(List<Meeting> bookedMeetings) {

		Collections.sort(bookedMeetings, (m1, m2) -> {
			return m1.getStartTime() - m2.getStartTime();
		});

		List<Meeting> mergedMeetings = new ArrayList<Meeting>();

		Meeting currentMeeting = bookedMeetings.get(0);

		for (int i = 1; i < bookedMeetings.size();) {

			if (currentMeeting.getEndTime() >= bookedMeetings.get(i).getStartTime()) {
				currentMeeting = new Meeting(currentMeeting.getStartTime(), 
						bookedMeetings.get(i).getEndTime());
			} else {
				mergedMeetings.add(bookedMeetings.get(i));
			}
			i++;
			if (i == bookedMeetings.size()) {
				mergedMeetings.add(currentMeeting);
			}

		}

		return mergedMeetings;
	}

}
