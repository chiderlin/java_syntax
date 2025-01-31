class ProjectList extends ArrayList
{
  private ListIterator<Project> iterator;
  private Project currentProject;
    
  public void moveToNextProject()
  {
    if(iterator==null) iterator = this.listIterator();
    if(iterator.hasNext()) currentProject = iterator.next();
  }

  public void moveToPreviousProject()
  {
    if(iterator==null) iterator = this.listIterator();
    if(iterator.hasPrevious()) currentProject = iterator.previous();
  }

  public Project getCurrentProject()
  {
    if(iterator==null) iterator = this.listIterator();
    if(currentProject==null) currentProject = iterator.next();
    return currentProject;
  }

}
