package com.mylearning.v1.greedy;

import java.util.*;
import java.util.stream.Collectors;

public class JobSequencingProblem {
  
  public static void main(String[] args) {
    List<Job> jobs = Arrays.asList(new Job("J1", 20, 2), new Job("J2",15, 3),
        new Job("J3", 35, 3), new Job("J4",25, 4), new Job("J5", 30, 4),
        new Job("J6",5, 2), new Job("J7", 12, 1));
    List<Job> sorted = jobs.stream().sorted(Comparator.comparingInt(Job::getProfit).reversed()).collect(Collectors.toList());
    int maxDeadLine = jobs.stream().max(Comparator.comparingInt(Job::getDeadline)).get().getDeadline();
    //Map<Integer, Job> executedJobs = new HashMap<>(maxDeadLine);
    Job[] executedJobs = new Job[maxDeadLine];
    for (Job job : sorted) {
      System.out.println("Finding slot for " + job.name + " with profit " + job.profit + " and deadline " + job.deadline + "....");
      execute(job, maxDeadLine, executedJobs);
      System.out.println();
    }
    int i = 0;
  }
  
  private static void execute(Job job, int maxDeadLine, Job[] executedJobs) {
    if (maxDeadLine - 1 < 0) {
      System.out.println("NOT Executed " + job.name + ", No Slot available");
      return;
    }
    if (executedJobs[maxDeadLine - 1] == null) {
      executedJobs[maxDeadLine - 1] = job;
      System.out.println("Executed Job " + job.name + " at slot " + (maxDeadLine - 1));
      return;
    } else {
      System.out.println("Slot " + (maxDeadLine - 1) + " already occupied, trying to find another slot for " + job.name);
    }
    execute(job, maxDeadLine - 1, executedJobs);
  }
  
  public static class Job {
    String name;
    int profit;
    int deadline;
  
    public String getName() {
      return name;
    }
  
    public void setName(String name) {
      this.name = name;
    }
  
    public Job(String name, int profit, int deadline) {
      this.name = name;
      this.profit = profit;
      this.deadline = deadline;
    }
  
    public int getProfit() {
      return profit;
    }
  
    public void setProfit(int profit) {
      this.profit = profit;
    }
  
    public int getDeadline() {
      return deadline;
    }
  
    public void setDeadline(int deadline) {
      this.deadline = deadline;
    }
  }
}