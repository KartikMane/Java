import java.util.Scanner;
import java.util.*;

class Publication
{
    String title;
    int price,total,copies;
    void setTitle(String title)
    {
        this.title=title;
    }
    void setCopies(int copies)
    {
        this.copies=copies;
    }
    int getCopies()
    {
        return copies;
    }
    int getTotal()
    {
        return total;
    }
    int getPrice()
    {
        return price;
    }
    String getTitle()
    {
        return title;
    }
    void readPub()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter title :");
        title=sc.next();
        System.out.println("Enter price :");
        price= sc.nextInt();
        System.out.println("Enter copies :");
        copies= sc.nextInt();
    }
    void display()
    {
        System.out.println(title+"\t"+price+"\t"+copies);
    }

    void saleCopy(int number)
    {
        if(copies<=number)
        {
            copies=copies-number;
            total=total+number*price;
            System.out.println("You purchased"+number+"copies. You have to pay"+number*price);
        }
        else
        {
            System.out.println("Insufficient stock");
        }
    }
}

class Book extends Publication
{
    Scanner s = new Scanner(System.in);
    String author;
    void Order(int number)
    {
        int x =getCopies()+number;
        setCopies(getCopies()+number);
        System.out.println("Order Successful ");
        System.out.println("Copies Available"+x);
    }
    void readbook()
    {
        readPub();
        System.out.println("Enter Author :");
        author=s.next();
    }
    void displaybook()
    {
        display();
        System.out.println("\t"+author);
    }
}

class Magazine extends Publication
{
    Scanner x = new Scanner(System.in);
    int order_qt;
    String issue_date;
    void issue_receive(String new_issue_date)
    {
        System.out.println("Enter new copies to be  ordered");
        Scanner a = new Scanner(System.in);
        order_qt=a.nextInt();
        issue_date=new_issue_date;
        System.out.println("Magazine"+getTitle()+" with issue date "+new_issue_date+" available");
    }
    void readM()
    {
        readPub();
        System.out.println("Enter the current issue date DD/MM/YYYY :");
        issue_date=x.next();
    }
    void dsiplayM()
    {
        System.out.println("title \tprice \tcopy \tdate");
        display();
        System.out.println("\t"+issue_date);
    }
}

class Pract2 {
    public static void main(String[] args) {
        Scanner z = new Scanner(System.in);
        Book b = new Book();
        Magazine m = new Magazine();
        int outer = 1;
        do {
            System.out.println("Choose from Menu");
            System.out.println("1. Book");
            System.out.println("2. Magazine");
            int ch = z.nextInt();
            aa:
            if (ch == 1) {

                int q = 1;
                do {
                    System.out.println("Menu for book");
                    System.out.println("1. Read");
                    System.out.println("2. Display");
                    System.out.println("3. Sale Copies");
                    System.out.println("4. Order Copies");
                    System.out.println("Choose");
                    int n = z.nextInt();
                    switch (n) {
                        case 1:
                            b.readbook();
                            break;
                        case 2:
                            b.displaybook();
                            break;
                        case 3:
                            System.out.println("How many copies customer want :");
                            int xx = z.nextInt();
                            b.saleCopy(xx);
                            break;
                        case 4:
                            System.out.println("How many copies owner want :");
                            int yy = z.nextInt();
                            b.Order(yy);
                            break;
                        default:
                            System.out.println("Invalid input");
                    }
                    System.out.println("Do you want to continue in book section");
                    System.out.println("1. Yes");
                    System.out.println("0. No");
                    q = z.nextInt();
                    if (q == 0) {
                        break aa;
                    }
                } while (q == 1);

            } else {
                int pp = 1;
                mm:
                do {
                    System.out.println("\n\t\tMENU   FOR   MAGAZINE...\n\n\t1.READ  \t\t2.DISPLAY \n\t3.SALE MAGAZINE COPIES \t4.RECEIVE NEW ISSUE\n");
                    int d;
                    System.out.print("\n\tChoice::");
                    d = z.nextInt();
                    switch (d) {
                        case 1:
                            System.out.println("==============================================================================\n");
                            m.readM();
                            System.out.println("==============================================================================\n");
                            break;
                        case 2:
                            System.out.println("==============================================================================\n");
                            m.dsiplayM();
                            System.out.println("==============================================================================\n");
                            break;
                        case 3:
                            System.out.println("==============================================================================\n");
                            System.out.println("HOW MANY COPIES YOU WANT(customer)??  ");
                            int n3 = z.nextInt();
                            m.saleCopy(n3);
                            System.out.println("==============================================================================\n");
                            break;
                        case 4:
                            System.out.println("==============================================================================\n");
                            System.out.println("ENTER THE NEW ISSUE DATE [dd/mm/yyyy]: ");
                            String date = z.next();
                            m.issue_receive(date);
                            System.out.println("==============================================================================\n");
                            break;
                    }
                    System.out.println("DO YOU WANT TO CONTINUE WITH MAGAZINE SECTION [1/0]\n\t1.YES\t0.NO");
                    System.out.print("\tChoice::");
                     pp = z.nextInt();
                    if (pp == 0)
                        break mm;

                } while (pp == 1);
            }
            System.out.println("Do you want to continue");
            System.out.println("1. Continue");
            System.out.println("2. Exit");
            outer = z.nextInt();
        } while (outer != 0);
    }
}
