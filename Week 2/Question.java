import java.util.*;
import java.io.*;

abstract class TestQuestion
{
    String question;
    abstract void readQuestion();
}

class ShortAnswer extends TestQuestion
{
    int numLines = 1;

    void readQuestion()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the question: ");
        question = in.nextLine();
        System.out.print("Enter the number of lines: ");
        numLines = in.nextInt();
    }

    public String toString()
    {
        String str = "Question: " + this.question;
        return str;
    }
}

class LongAnswer extends TestQuestion
{
    int numLines;

    void readQuestion()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the question: ");
        question = in.nextLine();
        System.out.print("Enter the number of lines: ");
        numLines = in.nextInt();
    }

    public String toString()
    {
        String str = "Question: " + this.question + '\n' + "Number of lines: " + this.numLines;
        return str;
    }

}

class MCQ extends TestQuestion
{
    int numChoices;
    String[] choices;

    void readQuestion()
    {   
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the question: ");
        question = in.nextLine();
        System.out.print("Enter the number of choices: ");
        numChoices = in.nextInt();
        choices = new String[numChoices];

        in.nextLine();
        for (int i = 0; i < numChoices; i++)
        {
            System.out.print("Enter choice " + (i + 1) + ": ");
            choices[i] = in.nextLine();
        }
    }

    public String toString()
    {
        String str = "Question: " + this.question + '\n' + "Number of choices: " + this.numChoices + '\n';
        for (int i = 0; i < this.numChoices; i++)
        {
            str += "Choice " + (i + 1) + ": " + this.choices[i] + '\n';
        }
        return str;
    }

}

class TQManager
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of questions: ");
        int numQuestions = in.nextInt();

        String[] questionTypes = new String[numQuestions];
        TestQuestion[] questions = new TestQuestion[numQuestions];
        int questionType;
        for (int i=0; i<numQuestions; i++)
        {
            System.out.println("1. Short Answer");
            System.out.println("2. Long Answer");
            System.out.println("3. Multiple Choice");
            System.out.println();
            System.out.print("Enter the question type: ");
            questionType = in.nextInt();
            System.out.println();

            Boolean valid = false;
            switch(questionType)
            {
                case 1:
                    questions[i] = new ShortAnswer();
                    questions[i].readQuestion();
                    questionTypes[i] = "Short Answer";
                    break;
                case 2:
                    questions[i] = new LongAnswer();
                    questions[i].readQuestion();
                    questionTypes[i] = "Long Answer";
                    break;
                case 3:
                    questions[i] = new MCQ();
                    questions[i].readQuestion();
                    questionTypes[i] = "Multiple Choice";
                    break;
                default:
                    System.out.println("Invalid question type!");
                    break;
            }
            System.out.println();
        }

        System.out.println("\nQuestion details: \n");
        String[] uniqueQuestionTypes = {"Short Answer", "Long Answer", "Multiple Choice"};
        for (int j=0; j<3; j++)
        {
            String uniqueQuestionType = uniqueQuestionTypes[j];
            System.out.println(uniqueQuestionType + " Question details: \n");
            for (int i=0; i<numQuestions; i++)
            {

                if (questionTypes[i].equals(uniqueQuestionType))
                {
                    String str = questions[i].toString();
                    System.out.println("Question " + (i + 1) + " - " + questionTypes[i] + ": ");
                    System.out.println(str);
                    System.out.println();
                }
            }
        }
    }
}