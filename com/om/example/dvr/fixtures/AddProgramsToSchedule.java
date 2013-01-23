package com.om.example.dvr.fixtures;
 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
 
import com.om.example.domain.ConflictingProgramException;
import com.om.example.domain.Schedule;
 
public class AddProgramsToSchedule {
   static SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy|h:mm");
   private Schedule schedule = new Schedule();
   private int channel;
   private String date;
   private String startTime;
   private int minutes;
   private String programName;
   private String episodeName;
 
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
 
   public boolean created() {
      try {
         schedule.addProgram(programName, episodeName, channel, buildStartDateTime(),
               minutes);
      } catch (ConflictingProgramException e) {
         return false;
      }
      return true;
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