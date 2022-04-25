interface Employee { 
    public String EmpType="Default";

    void openTask(Task T);
    void executeTask(Task T); 
}

class Manager implements Employee{
    public String EmpType="Manager";
    public void openTask(Task T){
        System.out.println("Task "+ T.getTaskName() + " opened by "+EmpType);
    }
    public void executeTask(Task T){
        System.out.println("Task "+ T.getTaskName() + " executed by "+EmpType+"\n\n");
    }
}

class TechLead implements Employee{
    public String EmpType="TechLead";
    public void openTask(Task T){
        System.out.println("Task "+ T.getTaskName() + " opened by "+EmpType);
    }
    public void executeTask(Task T){
        System.out.println("Task "+ T.getTaskName() + " executed by "+EmpType+"\n\n");
    }
}

class Developer implements Employee{
    public String EmpType="Developer";
    public void openTask(Task T){
    }
    public void executeTask(Task T){
        System.out.println("Task "+ T.getTaskName() + " executed by "+EmpType+"\n\n");
    }
}