public class Task{
    private String taskName;
    private String taskType;
    private String taskStatus;
    private int taskLevel;
    private int taskSize;
    private int effortRequired;
    public Task(String taskName, String taskType, String taskStatus, int taskLevel, int taskSize, int effortRequired){
        this.taskName=taskName;
        this.taskType=taskType;
        this.taskStatus=taskStatus;
        this.taskLevel=taskLevel;
        this.taskSize=taskSize;
        this.effortRequired=effortRequired;
    }

    public String getTaskName() 
    {
        return taskName;
    } 
    public void setTaskName(String taskName) 
    {
        this.taskName = taskName;
    } 

    public String getTaskType() 
    {
        return taskType;
    } 
    public void setTaskType(String taskType) 
    {
        this.taskType = taskType;
    } 

    public String getTaskStatus() 
    {
        return taskStatus;
    } 
    public void setTaskStatus(String taskStatus) 
    {
        this.taskStatus = taskStatus;
    } 

    public int getTaskLevel() 
    {
        return taskLevel;
    } 
    public void setTaskLevel(int taskLevel) 
    {
        this.taskLevel = taskLevel;
    } 

    public int getTaskSize() 
    {
        return taskSize;
    } 
    public void setTaskSize(int taskSize) 
    {
        this.taskSize = taskSize;
    } 

    public int getEffortRequired() 
    {
        return effortRequired;
    } 
    public void setEffortRequired(int effortRequired) 
    {
        this.effortRequired = effortRequired;
    } 
}