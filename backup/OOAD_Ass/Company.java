public class Company {
    public Task createTask(String taskName, String taskType, String taskStatus, int taskLevel, int taskSize, int effortRequired){
        Task T=new Task(taskName,taskType,taskStatus,taskLevel,taskSize,effortRequired);
        System.out.println("Task "+ T.getTaskName()+ " Created Successfully\n");
        return T;
    }
    public void assignTask(Task T){
        int T_Lev=T.getTaskLevel();
        if(T_Lev==3){
            Manager M=new Manager();
            M.openTask(T);
            M.executeTask(T);
        }
        else if(T_Lev==2){
            Manager M=new Manager();
            TechLead TL=new TechLead();
            M.openTask(T);
            TL.executeTask(T);
        }
        else if(T_Lev==1){
            TechLead TL=new TechLead();
            Developer D=new Developer();
            TL.openTask(T);
            D.executeTask(T);
        }
    }
}
