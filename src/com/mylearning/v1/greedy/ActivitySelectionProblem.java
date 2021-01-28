package com.mylearning.v1.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ActivitySelectionProblem {
  
  public static void main(String[] args) {
    List<Activity> activities = Arrays.asList(new Activity("A1", 0, 6), new Activity("A2", 3, 4),
        new Activity("A3", 1, 2), new Activity("A4", 5, 8), new Activity("A5", 5, 7),
        new Activity("A6", 8, 9));
    List<Activity> sorted = activities.stream().sorted(Comparator.comparingInt(Activity::getFinish)).collect(Collectors.toList());
    activityProblem(sorted, 0, 0);
//    int previousFinish = 0;
//    for (Activity activity : sorted) {
//      if (activity.start >= previousFinish) {
//        System.out.println("Perform Activity " + activity.name + " between " + activity.start + " to " + activity.finish);
//        previousFinish = activity.finish;
//      }
//    }
  }
  
  private static void activityProblem(List<Activity> activities, int previous, int index) {
    if (index >= activities.size()) {
      return;
    }
    Activity activity = activities.get(index);
    if (activities.get(index).start >= previous) {
      System.out.println("Perform Activity " + activity.name + " between " + activity.start + " to " + activity.finish);
      previous = activity.finish;
    }
    activityProblem(activities, previous, ++index);
  }
  
  public static class Activity {
    String name;
    int start;
    int finish;
    
    public String getName() {
      return name;
    }
    
    public void setName(String name) {
      this.name = name;
    }
    
    public int getStart() {
      return start;
    }
    
    public void setStart(int start) {
      this.start = start;
    }
    
    public int getFinish() {
      return finish;
    }
    
    public void setFinish(int finish) {
      this.finish = finish;
    }
    
    public Activity(String name, int start, int finish) {
      this.name = name;
      this.start = start;
      this.finish = finish;
    }
  }
}