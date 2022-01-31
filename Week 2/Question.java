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
        System.out.println("Enter the question: ");
        question = in.nextLine();
        numLines = 1;
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
        System.out.println("Enter the question: ");
        question = in.nextLine();
        System.out.println("Enter the number of lines: ");
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
        System.out.println("Enter the question: ");
        question = in.nextLine();
        System.out.println("Enter the number of choices: ");
        numChoices = in.nextInt();
        choices = new String[numChoices];
        for (int i = 0; i < numChoices; i++)
        {
            System.out.println("Enter choice " + (i + 1) + ": ");
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
        System.out.println("Enter the number of questions: ");
        int numQuestions = in.nextInt();

        TestQuestion[] questions = new TestQuestion[numQuestions];
        int questionType;
        for (int i=0; i<numQuestions; i++)
        {
            System.out.println("1. Short Answer");
            System.out.println("2. Long Answer");
            System.out.println("3. Multiple Choice");
            System.out.println("Enter the question type: ");
            questionType = in.nextInt();

            Boolean valid = false;
            switch(questionType)
            {
                case 1:
                    questions[i] = new ShortAnswer();
                    valid = true;
                    break;
                case 2:
                    questions[i] = new LongAnswer();
                    valid = true;
                    break;
                case 3:
                    questions[i] = new MCQ();
                    valid = true;
                    break;
                default:
                    System.out.println("Invalid question type");
                    break;
            }

            if (valid)
            {
                questions[i].readQuestion();
            }
        }

        System.out.println("\nQuestion details: \n");
        for (int i=0; i<numQuestions; i++)
        {
            String str = questions[i].toString();
            System.out.println("Question " + (i + 1) + ": ");
            System.out.println(str);
            System.out.println();
        }
    }
}