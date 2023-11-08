import java.util.*;


abstract class Product {
private String Itemcode;
private String Name;
private int Quantity;
private double UnitPrice;

public abstract double CalculateTotalPrice();

 void setItemcode(String Itemcode){
    this.Itemcode = Itemcode;
 }
  void setName(String Name){
    this.Name = Name;
 }
  void setQuantity(int Quantity){
    this.Quantity = Quantity;
 }
  void setUnitPrice(double UnitPrice){
    this.UnitPrice = UnitPrice;
 }

 String getItemcode(){
    return Itemcode;
 }
 String getName(){
    return Name;
 }
  int getQuantity(){
    return Quantity;
 }
  double getUnitPrice(){
    return UnitPrice;
 }
Product (String Itemcode, String Name,  int Quantity, double UnitPrice)
{
    this.Name = Name;
    this.Itemcode = Itemcode;
    this.Quantity = Quantity;
    this.UnitPrice = UnitPrice;
}

}

class Service extends Product {
    private double hours;
   
    Service(String Itemcode, String Name, int Quantity, double UnitPrice, double hours)
{
    super(Itemcode, Name, Quantity, UnitPrice);
    this.hours = hours;

}
public double CalculateTotalPrice(){
    if (getQuantity() == 0)
    return getUnitPrice()*hours;
    else
    return getQuantity()*getUnitPrice();
}

void sethours(double hours){
    this.hours = hours;
 }
 double gethours(){
    return hours;
 }


}


class Customer{
    private String name;
    private String address;
    private String number;

    Customer(String name, String address, String number){
        this.name = name;
        this.address = address;
        this.number = number;
    }

    void setname(String name){
    this.name = name;
 }
 String getname(){
    return name;
 }
 void setaddress(String address){
    this.address = address;
 }
 String getaddress(){
    return address;
 }
 void setnumber(String number){
    this.number = number;
 }
 String getnumber(){
    return number;
 }

}


class Invoice {
    private String invoiceNo;
    private Date date;
    private double TotalAmount;
    private ArrayList <Service> services;
    private Customer customer;


    public Invoice(String invoiceNo, Date date, Customer customer)
{
        services = new ArrayList<>();
        this.invoiceNo = invoiceNo;
        this.date = date;
        this.customer = customer;
}

void setinvoiceNo(String invoiceNo){
    this.invoiceNo = invoiceNo;
 }
 String getinvoiceNo(){
    return invoiceNo;
 }
 void setdate(Date date){
    this.date = date;
 }
 Date getdate(){
    return date;
 }
 void setTotalAmount(){
    TotalAmount = 0;
    for (Service i: services){
        TotalAmount += i.CalculateTotalPrice();
    }
 }
 double getTotalAmount(){
    setTotalAmount();
    return TotalAmount;
 }
 void setcustomer(Customer customer){
    this.customer = customer;
 }
 Customer getcustomer(){
    return customer;
 }
 void addservice(Service service){
    services.add(service);

 }

 

 void printinvoice(){
    System.out.println("----------------Invoice-----------------");
    System.out.println("|                                      ");
    System.out.println("| - Invoice Id : "+ getinvoiceNo() );
    System.out.println("| - Date : "+ getdate() );
    System.out.println("| - Customer Name : "+ customer.getname() );
    System.out.println("| - Customer address : "+ customer.getaddress());
    System.out.println("| - Customer number : "+ customer.getnumber());
    System.out.println("_____________________________________");
    System.out.println("            Description");
    System.out.println("_____________________________________");
    for (Service i: services){
        if (i.getQuantity() == 0){
        System.out.println("| - Service code : "+ i.getItemcode());
        System.out.println("| - Service Name : "+ i.getName());
        System.out.println("| - Duration(in hours) : " + i.gethours());
        System.out.println("| - Service Price/hour : "+ i.getUnitPrice());
        System.out.println("| - Total Price : " + i.CalculateTotalPrice());
    }   else{
        System.out.println("| - Item code : "+ i.getItemcode());
        System.out.println("| - Item Name : "+ i.getName());
        System.out.println("| - Item Quantity : "+ i.getQuantity());
        System.out.println("| - Item Price/unit : "+ i.getUnitPrice());
        System.out.println("| - Total Price : " + i.CalculateTotalPrice());
    }
    System.out.println("|---------------------------------|");
    }

    System.out.println("| - Total Amount : " + getTotalAmount());
    System.out.println("|---------------------------------|");

 }


}

public class Main{
    public static void main(String[] args) {

        Customer customer = new Customer("Sunjay Kumar", "Saddar, Hyd, Sindh.", "0300 2856307");

        Invoice I1 = new Invoice("Iv765", new Date(),  customer);

        Service s1 = new Service("L4562", "Hp Latop", 1, 150000, 0);

        Service s2 = new Service("B3494", "Laptop Bag", 1, 5000, 0);

        Service s3 = new Service("C3498", "8gb Ram", 2, 3500, 0);

        Service s4 = new Service("XX537", "Ram Replacement", 0, 500, 1);

        

        I1.addservice(s1);
        I1.addservice(s2);
        I1.addservice(s3);
        I1.addservice(s4);
        I1.printinvoice();
    }
   
}