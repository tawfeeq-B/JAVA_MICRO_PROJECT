// Micro project (Drug management System)
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList ;

class Drug
{
    private String drugName ;
    private String manuName ;
    private int stockQuantity ;
    private int drugPrice ;

    public Drug(String drugName , String manuName , int stockQuantity , int drugPrice )
    {
        this.drugName = drugName ;
        this.manuName = manuName ;
        this.stockQuantity = stockQuantity ;
        this.drugPrice = drugPrice ;
    }

    public void setStockQuantity(int stockQuantity)
    {
        this.stockQuantity = stockQuantity ;
    }

    public String toString()
    {
        return " Drug Name : " + drugName + " Drug Manufacturer Name : " + manuName + " Stock Quantity : " + stockQuantity + " Drug price : " + drugPrice ;
    }




}

class DrugManagement
{
    Scanner sc = new Scanner(System.in);

    String drugName ;
    String manuName ;
    int stockQuantity ;
    int drugPrice ;

    List<Drug> drugList = new ArrayList<Drug>();

    public void drugAdd()
    {
        System.out.print("Enter drug name : ");
        drugName = sc.nextLine();
        System.out.print("Enter Manufacturer : ");
        manuName = sc.nextLine();
        System.out.print("Enter stock Quantity : ");
        stockQuantity = sc.nextInt();
        System.out.print("Enter price : ");
        drugPrice = sc.nextInt();
        sc.nextLine();
        drugList.add(new Drug(drugName , manuName , stockQuantity , drugPrice) ) ;
        System.out.println("Successfully added !!!");
    }

    public void viewInv()
    {
        if(drugList.isEmpty())
        {
            System.out.println("No drugs in inventory !!!");
        }
        else
        {
            System.out.println("----INVENTORY----");
            System.out.println();
            for(int i = 0 ; i < drugList.size() ; i++)
            {
                System.out.println((i + 1) + " ." + drugList.get(i));
            }
            System.out.println();
        }
    }

    public void updStock()
    {
        System.out.println("Enter the drug number to update stock : ");

        int index = sc.nextInt() -1 ;

        if(index < 0 || index >= drugList.size())
        {
            System.out.println("Invalid input !!!");
        }
        else
        {
            System.out.print("Enter new stock quantity amount : ");
            int newStock = sc.nextInt();
            drugList.get(index).setStockQuantity(newStock);
            System.out.println("Stock updated SuccessFully !!!");
        }

    }

}  

class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        DrugManagement d_m = new DrugManagement();

        while(true)
        {
            System.out.println("---DRUG MANAGEMENT SYSTEM");
            System.out.println("1 . Add Drug \n2 . View Inventory \n3 . Update Stock \n4 . Exit");
            int inp = sc.nextInt();

            switch (inp) {
                case 1 -> d_m.drugAdd();
                case 2 -> d_m.viewInv();
                case 3 -> d_m.updStock() ;
                case 4 -> {
                   System.out.println("Exited !!!");
                   return ;
                }    
            
                default ->
                {
                    System.out.println("Enter a valid input !!!");
                    break ;
                }
                
        }
    }
}

}