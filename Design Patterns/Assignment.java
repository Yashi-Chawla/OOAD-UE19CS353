import java.io.*;
import java.util.*;
import java.lang.*;

class Task
{
    String taskName;
    String taskType;
    String taskStatus;
    int taskLevel;
    int taskSize;
    int effortRequired;
    Employee opener;
    Employee executor;

    public Task(String taskName, String taskType, String taskStatus, int taskLevel, int taskSize, int effortRequired)
    {
        this.taskName = taskName;
        this.taskType = taskType;
        this.taskStatus = taskStatus;
        this.taskLevel = taskLevel;
        this.taskSize = taskSize;
        this.effortRequired = effortRequired;
        this.opener = null;
        this.executor = null;
    }
}

class Employee
{
    Task task;
    String role;
    public Employee(String role)
    {
        this.role = role;
    }
}

class Company
{
    Scanner sc = new Scanner(System.in);
    ArrayList<Task> taskList = new ArrayList<Task>();
    ArrayList<Employee> employeeList = new ArrayList<Employee>();

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Task> taskList = new ArrayList<Task>();
        ArrayList<Employee> employeeList = new ArrayList<Employee>();
        Company company = new Company();

        while (true)
        {
            System.out.println();
            System.out.println("1. Create a task");
            System.out.println("2. Create an employee");
            System.out.println("3. Assign task to employee");
            System.out.println("4. Display all tasks");
            System.out.println("5. Display all employees");
            System.out.println("6. Display tasks assigned to employees");
            System.out.println("7. Exit\n");

            System.out.print("Enter a choice: ");
            int choice = sc.nextInt();
            switch (choice)
            {
                case 1:
                {
                    Task task = company.createTask();
                    taskList.add(task);
                    System.out.println("Task created successfully");
                    break;
                }
                case 2:
                {
                    System.out.println("Enter role: ");
                    System.out.println("1. Manager");
                    System.out.println("2. Developer");
                    System.out.println("3. TechLead");
                    int employeeChoice = sc.nextInt();
                    String role = "";
                    if (employeeChoice == 1)
                        role = "Manager";
                    else if (employeeChoice == 2)
                        role = "Developer";
                    else if (employeeChoice == 3)
                        role = "TechLead";
                    Employee employee = company.createEmployee(role);
                    employeeList.add(employee);
                    System.out.println("Employee created successfully");
                    break;
                }
                case 3:
                {
                    System.out.println("Enter task ID");
                    int taskId = sc.nextInt();
                    company.assignTask(taskId, taskList, employeeList);
                    System.out.println("Task assigned to employee successfully");
                    break;
                }
                case 4:
                {
                    System.out.println("All tasks:");
                    for (int i = 0; i < taskList.size(); i++)
                        System.out.println(taskList.get(i).taskName + " " + taskList.get(i).taskType + " " + taskList.get(i).taskStatus + " " + taskList.get(i).taskLevel + " " + taskList.get(i).taskSize + " " + taskList.get(i).effortRequired);
                    break;
                }
                case 5:
                {
                    System.out.println("All employees:");
                    for (int i = 0; i < employeeList.size(); i++)
                        System.out.println((i+1) + ". " + employeeList.get(i).role);
                    break;
                }
                case 7:
                {
                    System.exit(0);
                }
            }
        }
    }

    public Task createTask()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the task name: ");
        String taskName = sc.nextLine();
        System.out.print("Enter the task type: ");
        String taskType = sc.nextLine();
        System.out.print("Enter the task status: ");
        String taskStatus = sc.nextLine();
        System.out.print("Enter the task level: ");
        int taskLevel = sc.nextInt();
        System.out.print("Enter the task size: ");
        int taskSize = sc.nextInt();
        System.out.print("Enter the effort required: ");
        int effortRequired = sc.nextInt();
        Task task = new Task(taskName, taskType, taskStatus, taskLevel, taskSize, effortRequired);
        return task;
    }

    public Employee createEmployee(String role)
    {
        if(role.equals("Manager"))
        {
            return new Employee(role);
        }
        else if(role.equals("TechLead"))
        {
            return new Employee(role);
        }
        else if(role.equals("Developer"))
        {
            return new Employee(role);
        }
        else
        {
            return null;
        }
    }

    public void assignTask(int taskIndex, ArrayList<Task> taskList, ArrayList <Employee> employeeList)
    {
        Task task = taskList.get(taskIndex);
        for (int i = 0; i < employeeList.size(); i++)
            System.out.println((i+1) + ". " + employeeList.get(i).role);

        if(task.taskLevel == 3)
        {
            System.out.println("Choose a manager to assign the task");
            int employeeIndex = sc.nextInt();
            Employee employee = employeeList.get(employeeIndex);

            if (employee.role.equals("Manager"))
            {
                taskList.get(taskIndex).opener = employee;
                taskList.get(taskIndex).executor = employee;
                // taskEmployeeMap.put(task, employee);
            }
            else
            {
                System.out.println("Task can only be assigned to manager!");
            }
        }

        else if (task.taskLevel == 2)
        {
            System.out.println("Choose a Manager to open the task: ");
            int employeeIndex = sc.nextInt();
            Employee employeeManager = employeeList.get(employeeIndex);

            System.out.println("Choose a TechLead to execute the task: ");
            int employeeIndex2 = sc.nextInt();
            Employee employeeTechLead = employeeList.get(employeeIndex2);

            if (employeeManager.role.equals("Manager") && employeeTechLead.role.equals("TechLead"))
            {
                taskList.get(taskIndex).opener = employeeManager;
                taskList.get(taskIndex).executor = employeeTechLead;
                // taskEmployeeMap.put(task, employee);
            }
            else
            {
                System.out.println("Task can only be opened by manager and executed by TechLead!");
            }
        }

        else if (task.taskLevel == 1)
        {
            System.out.println("Choose a TechLead to open the task: ");
            int employeeIndex = sc.nextInt();
            Employee employeeTechLead = employeeList.get(employeeIndex);

            System.out.println("Choose a Developer to execute the task: ");
            int employeeIndex2 = sc.nextInt();
            Employee employeeDeveloper = employeeList.get(employeeIndex2);

            if (employeeTechLead.role.equals("TechLead") && employeeDeveloper.role.equals("Developer"))
            {
                taskList.get(taskIndex).opener = employeeTechLead;
                taskList.get(taskIndex).executor = employeeDeveloper;
                // taskEmployeeMap.put(task, employee);
            }
            else
            {
                System.out.println("Task can only be opened by TechLead and executed by Developer!");
            }
        }

        else 
        {
            System.out.println("Enter a valid task ID");
            return;
        }
    }
}