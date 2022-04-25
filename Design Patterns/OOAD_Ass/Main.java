public class Main {
    public static void main(String[] args){
        Company C=new Company();
        Task T1=C.createTask("Task 1", "Easy", "Approved", 1, 60, 5);
        Task T2=C.createTask("Task 2", "Medium", "Approved", 2, 40, 9);
        Task T3=C.createTask("Task 3", "Hard", "Approved", 3, 50, 10);

        C.assignTask(T1);
        C.assignTask(T2);
        C.assignTask(T3);
    }
}
