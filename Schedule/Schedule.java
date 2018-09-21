package com.LichLamViec;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Schedule {
	private ArrayList<Job> jobs;

	public Schedule(ArrayList<Job> jobs) {
		this.jobs = jobs;
	}

	public ArrayList<Job> solve() {
		ArrayList<Job> result = new ArrayList<>();
		Collections.sort(jobs, new Comparator<Job>() {
			@Override
			public int compare(Job o1, Job o2) {
				if (o1.getEnd() < o2.getEnd())
					return -1;
				if (o1.getEnd() > o2.getEnd())
					return 1;
				return 0;
			}
		});
		result.add(jobs.get(0));
		jobs.remove(0);
		while (!jobs.isEmpty()) {
			Job earliestJob = jobs.get(0);
			jobs.remove(0);
			if (compatible(result.get(result.size() - 1), earliestJob)) {
				result.add(earliestJob);
			}
		}
		return result;
	}

	public boolean compatible(Job v1, Job v2) {
		return Math.max(v1.getStart(), v2.getStart()) >= Math.min(v1.getEnd(),	v2.getEnd());
	}

	public static void main(String[] args) {		
		ArrayList<Job> jobs = new ArrayList<>();
		jobs.add(new Job(0, 6));
		jobs.add(new Job(1, 4));
		jobs.add(new Job(3, 5));
		jobs.add(new Job(3, 8));
		jobs.add(new Job(4, 7));
		jobs.add(new Job(5, 9));
		jobs.add(new Job(8, 11));
		Schedule llv = new Schedule(jobs);
		ArrayList<Job> da = llv.solve();
		for (Job j : da) {
			System.out.println(j.getStart() + " " + j.getEnd());
		}
	}

	public static class Job {
		private int start;
		private int end;

		public Job(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public int getStart() {
			return start;
		}

		public void setStart(int start) {
			this.start = start;
		}

		public int getEnd() {
			return end;
		}

		public void setEnd(int end) {
			this.end = end;
		}
	}
}
