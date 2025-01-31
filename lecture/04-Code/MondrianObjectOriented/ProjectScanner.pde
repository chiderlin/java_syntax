class ProjectScanner
{  
  public ProjectList scanForProjectReports(String projectPath)
  {
    ProjectList projects = new ProjectList();
    File folder = new File(projectPath);
    String[] allFiles = folder.list();
    for (String filename : allFiles) {
      if (filename.endsWith(".json")) projects.add(new Project(folder + File.separator + filename));
    }
    return projects;
  }
}
