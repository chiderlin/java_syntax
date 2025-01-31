import java.io.*;
import java.util.*;

ArrayList<String> reportFilenames;
int reportPointer = -1;
JSONObject currentProjectReport;
String currentProjectName;

void setup()
{
  size(1400, 300);
  textSize(14);
  reportFilenames = scanForProjectReports();
  loadNextReport();
}  

ArrayList<String> scanForProjectReports()
{
  ArrayList<String> filenames = new ArrayList<String>();
  File folder = new File(sketchPath(".." + File.separator + "output" + File.separator + "final-reports"));
  String[] allFiles = folder.list();
  for (String filename : allFiles) {
    if (filename.endsWith(".json")) filenames.add(folder + File.separator + filename);
  }
  return filenames;
}

void draw()
{
  background(0);
  drawAllStudentsInGroup();
  textAlign(LEFT);
  text(currentProjectName, 7, 18);
}

void drawAllStudentsInGroup()
{
  pushMatrix();
  translate(170, height/2);
  JSONObject students = currentProjectReport.getJSONObject("students");
  for (Object studentID : students.keys()) {
    drawSingleStudent((String)studentID, students);
    translate((width-340)/(students.size()-1), 0);
  }
  popMatrix();
}

void drawSingleStudent(String studentID, JSONObject students)
{
  JSONObject record = students.getJSONObject(studentID);
  float merges = getValueOfMetric("branches-merged", record);
  float commits = getValueOfMetric("commits-to-main", record)/4.0;
  float issues = getValueOfMetric("issues-completed", record)/1.2;
  float requests = getValueOfMetric("pull-requests-created", record);

  stroke(255);
  float alcopop = getValueOfMetric("aggregate-loc", record)/getValueOfMetric("commits-to-main", record)/8;
  strokeWeight(alcopop);
  fill(100);
  float loc = getValueOfMetric("aggregate-loc", record)/15.0;
  // Stop the loc circle being too large (if a student has written a LOT of code)
  if (loc>height+10) loc = height+10;
  ellipse(0, 0, loc, loc);

  strokeWeight(1.75);
  fill(0, 0, 255, 100);
  stroke(60, 60, 255);
  rect(1, -1, issues, -issues);
  fill(0, 255, 0, 100);
  stroke(0, 255, 0);
  rect(1, 1, commits, commits);
  fill(255, 255, 0, 100);
  stroke(255, 255, 0);
  rect(-1, 1, -requests, requests);
  fill(255, 0, 0, 100);
  stroke(255, 0, 0);
  rect(-1, -1, -merges, -merges);

  fill(255);
  textAlign(CENTER);
  text(record.getString("real-name") + " (" + studentID + ")", 0, 140);
}

float getValueOfMetric(String name, JSONObject record)
{
  if (record.keys().contains(name)) return float(record.getInt(name));
  else return 0;
}

void keyPressed()
{
  if (keyCode == LEFT) loadPreviousReport();
  if (keyCode == RIGHT) loadNextReport();
}

void loadNextReport()
{
  reportPointer++;
  if (reportPointer > reportFilenames.size()-1) reportPointer = reportFilenames.size()-1;
  String[] pathTokens = reportFilenames.get(reportPointer).split("/");
  currentProjectName = pathTokens[pathTokens.length-1].split("\\.")[0];
  currentProjectReport = loadJSONObject(reportFilenames.get(reportPointer));
}

void loadPreviousReport()
{
  reportPointer--;  
  if (reportPointer < 0) reportPointer = 0;
  String[] pathTokens = reportFilenames.get(reportPointer).split(File.separator);
  currentProjectName = pathTokens[pathTokens.length-1].split("\\.")[0];
  currentProjectReport = loadJSONObject(reportFilenames.get(reportPointer));
}
