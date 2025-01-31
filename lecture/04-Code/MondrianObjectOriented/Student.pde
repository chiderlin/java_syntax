class Student
{
  private JSONObject report;
  private float merges, commits, issues, requests, alcopop, loc;
  private String name;
  private String studentID;
  
  public Student(JSONObject report, String id)
  {
    this.report = report;
    studentID = id;
  }
  
  private float getValueOfMetric(String name)
  {
    if (report.keys().contains(name)) return float(report.getInt(name));
    else return 0;
  }

  private void loadStudentData()
  {
    name = report.getString("real-name");
    merges = getValueOfMetric("branches-merged");
    commits = getValueOfMetric("commits-to-main")/4.0;
    issues = getValueOfMetric("issues-completed")/1.2;
    requests = getValueOfMetric("pull-requests-created");
    alcopop = getValueOfMetric("aggregate-loc")/getValueOfMetric("commits-to-main")/8;
    loc = getValueOfMetric("aggregate-loc")/15.0;
  }

  public void draw()
  {
    if(name==null) loadStudentData();
    stroke(255);
    strokeWeight(alcopop);
    fill(100);
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
    text(name + " (" + studentID + ")", 0, 140);
  }
}
