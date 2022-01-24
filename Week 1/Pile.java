import java.io.*;
import java.util.*;

class Card
{
    int value;
    String suit;
    public Card(int value, String suit)
    {
        this.value = value;
        this.suit = suit;
    }
}

class Pile
{
    int top;
    int max_size;
    Card[] cards;
    public Pile(int max_size)
    {
        this.top = -1;
        this.max_size = max_size;
        this.cards = new Card[max_size];
    }

    public void display()
    {
        if (top == -1)
        {
            System.out.println("Pile is empty\n");
        }
        else
        {
            for (int i = 0; i <= top; i++)
            {
                System.out.println(cards[i].value + " " + cards[i].suit);
            }
        }
    }

    public boolean add(Card card)
    {
        if (this.top == this.max_size - 1)
        {
            System.out.println("Pile is full\n");
            return false;
        }
        else
        {
            this.top++;
            this.cards[this.top] = card;
            return true;
        }
    }

    public Card remove()
    {
        if (this.top == -1)
        {
            System.out.println("Pile is empty\n");
            return null;
        }
        else
        {
            Card card = this.cards[this.top];
            this.top--;
            return card;
        }
    }

    public Card peek()
    {
        if (this.top == -1)
        {
            System.out.println("Pile is empty\n");
            return null;
        }
        else
        {
            return this.cards[this.top];
        }
    }
}

class CardCollection
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of cards in the pile: ");
        int max_size = sc.nextInt();
        System.out.println();
        Pile pile = new Pile(max_size);

        while (true){
            System.out.println("1. Add card");
            System.out.println("2. Remove card");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit\n");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();
                    System.out.print("Enter suit: ");
                    String suit = sc.next();
                    Card card = new Card(value, suit);
                    if (pile.add(card))
                    {
                        System.out.println("Card added!\n");
                    }
                    break;
                case 2:
                    Card card1 = pile.remove();
                    if (card1 != null)
                    {
                        System.out.println("Card removed: " + card1.suit + " " + card1.value + "\n");
                    }
                    break;
                case 3:
                    Card card2 = pile.peek();
                    if (card2 != null)
                    {
                        System.out.println("Card peeked: " + card2.suit + " " + card2.value + "\n");
                    }
                    break;
                case 4:
                    pile.display();
                    System.out.println();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice\n");
                    break;
            }
        }

    }
}