// A Company has a Manager, TechLead and Developer as its Employee. The Company creates Task for its Employee. This Task contains attributes such as taskName, taskType, taskStatus, taskLevel, taskSize, effortRequired. After the Task gets created by the Company it will be given to its Employee. Task can be Opened and Executed by the Employee. If the taskLevel is 3, then it will be Opened and Executed by Manager, if it is 2, it will be Opened by the Manager (meaning manager has a task clearance level of 3 and 2) and Executed by the TechLead, and if 1 will be Opened by the TechLead and Executed by the Developer. Design the UML and implement the same using appropriate design patterns.


interface Employee {
    public void showEmployeeDetails();
}

class Task {
    private String taskName;
    private String taskType;
    private String taskStatus;
    private int taskLevel;
    private int taskSize;
    private int effortRequired;

    public Task(String taskName, String taskType, String taskStatus, int taskLevel, int taskSize, int effortRequired) {
        this.taskName = taskName;
        this.taskType = taskType;
        this.taskStatus = taskStatus;
        this.taskLevel = taskLevel;
        this.taskSize = taskSize;
        this.effortRequired = effortRequired;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public int getTaskLevel() {
        return taskLevel;
    }

    public void setTaskLevel(int taskLevel) {
        this.taskLevel = taskLevel;
    }

    public int getTaskSize() {
        return taskSize;
    }

    public void setTaskSize(int taskSize) {
        this.taskSize = taskSize;
    }

    public int getEffortRequired() {
        return effortRequired;
    }

    public void setEffortRequired(int effortRequired) {
        this.effortRequired = effortRequired;
    }

    public void showTaskDetails() {
        System.out.println("Task Name: " + taskName);
        System.out.println("Task Type: " + taskType);
        System.out.println("Task Status: " + taskStatus);
        System.out.println("Task Level: " + taskLevel);
        System.out.println("Task Size: " + taskSize);
        System.out.println("Effort Required: " + effortRequired);
    }
}


class Manager implements Employee {

    private String name;
    private long empId;
    private String position;

    public Manager(long empId, String name, String position) {
        this.empId = empId;
        this.name = name;
        this.position = position;
    }

    @Override
    public void showEmployeeDetails() {
        System.out.println(empId + " " + name + " " + position);
    }


    public void createTask(Task task) {
        System.out.println("Manager created the task");
    }
    public void openTask(Task task) {
        System.out.println("Manager opened the task");
    }
    public void executeTask(Task task) {
        System.out.println("Manager executed the task");
    }
}

class Developer implements Employee {
    private String name;
    private long empId;
    private String position;

    public Developer(long empId, String name, String position) {
        this.empId = empId;
        this.name = name;
        this.position = position;
    }

    @Override
    public void showEmployeeDetails() {
        System.out.println(empId + " " + name + " " + position);
    }


    public void createTask(Task task) {
        System.out.println("Developer created the task");
    }
    public void openTask(Task task) {
        System.out.println("Developer opened the task");
    }
    public void executeTask(Task task) {
        System.out.println("Developer executed the task");
    }
}


class TechLead implements Employee {

    private String name;
    private long empId;
    private String position;

    public TechLead(long empId, String name, String position) {
        this.empId = empId;
        this.name = name;
        this.position = position;
    }

    @Override
    public void showEmployeeDetails() {
        System.out.println(empId + " " + name + " " + position);
    }


    public void createTask(Task task) {
        System.out.println("TechLead created the task");
    }
    public void openTask(Task task) {
        System.out.println("TechLead opened the task");
    }
    public void executeTask(Task task) {
        System.out.println("TechLead executed the task");
    }
}

class CompanyDirectory {
    private Manager manager;
    private TechLead techLead;
    private Developer developer;

    public CompanyDirectory(Manager manager, TechLead techLead, Developer developer) {
        this.manager = manager;
        this.techLead = techLead;
        this.developer = developer;
    }

    public void createTask(Task task) {
        System.out.println("Company created the task");
    }
    public void openTask(Task task) {
        System.out.println("Company opened the task");
    }
    public void executeTask(Task task) {
        System.out.println("Company executed the task");
    }
}

class Company{
    public static void main() {
        Manager manager = new Manager(12345, "John", "Manager");
        TechLead techLead = new TechLead(12346, "Peter", "TechLead");
        Developer developer = new Developer(12347, "Paul", "Developer");
        CompanyDirectory companyDirectory = new CompanyDirectory(manager, techLead, developer);
        Task task = new Task("Task1", "TaskType1", "TaskStatus1", 1, 1, 1);
        companyDirectory.createTask(task);
        companyDirectory.openTask(task);
        companyDirectory.executeTask(task);
    }
}