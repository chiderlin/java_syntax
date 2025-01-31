import java.util.*;

ProjectList projects;

public void setup()
{
  size(1400, 300);
  textSize(14);
  String reportFolder = sketchPath(".." + File.separator + "output" + File.separator + "final-reports");
  ProjectScanner scanner = new ProjectScanner();
  projects = scanner.scanForProjectReports(reportFolder);
}  

public void draw()
{
  background(0);
  projects.getCurrentProject().draw();
}

public void keyPressed()
{
  if (keyCode == RIGHT) projects.moveToNextProject();
  if (keyCode == LEFT) projects.moveToPreviousProject();
}
