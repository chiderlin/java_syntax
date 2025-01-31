class Project
{
  private String reportFilename;
  private String name;
  private ArrayList<Student> students = new ArrayList<Student>();

  public Project(String filename)
  {
    reportFilename = filename;
  }

  private void loadProjectData()
  {
    String[] pathTokens = reportFilename.split(File.separator);
    name = pathTokens[pathTokens.length-1].split("\\.")[0];
    JSONObject studentReports = loadJSONObject(reportFilename).getJSONObject("students");
    for (Object studentID : studentReports.keys()) {
      Student next = new Student(studentReports.getJSONObject((String)studentID), (String)studentID);
      students.add(next);
    }
  }

  public void draw()
  {
    if (name==null) loadProjectData();
    pushMatrix();
    translate(170, height/2);
    ListIterator studentIterator = students.listIterator();
    while(studentIterator.hasNext()) {
      ((Student)studentIterator.next()).draw();
      translate((width-340)/(students.size()-1), 0);
    }
    popMatrix();
    textAlign(LEFT);
    text(name, 7, 18);
  }
}
