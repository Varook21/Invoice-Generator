# Java Mini Project: Invoice Generation System

This is a simple Java mini project for generating invoices for products and services. It includes the following classes:

1. Product: An abstract class representing a general product. It contains common attributes like Item Code, Name, Quantity, and Unit Price. It also includes an abstract method for calculating the total price.

2. Service: A subclass of `Product`, representing services. It includes an additional attribute for the number of hours the service was provided. It overrides the `CalculateTotalPrice` method to handle service pricing.

3. Customer: A class representing a customer. It includes attributes for the customer's name, address, and phone number.

4. Invoice: A class for generating invoices. It includes attributes like the invoice number, date, total amount, a list of services, and the associated customer. It can calculate the total amount and print the invoice details.

5. Main: The main class contains the `main` method, where a sample customer, services, and an invoice are created and printed.

## Usage

To use this project, you can follow these steps:

1. Clone this repository to your local machine:

```bash
git clone https://github.com/yourusername/java-invoice-generation.git
```

2. Open the project in your preferred Java development environment.

3. Modify the `Main` class to create your own customer, services, and invoices.

4. Run the `Main` class to generate and print the invoice.

Feel free to adapt and extend this project for your specific needs. You can add more features, customize the invoice format, or integrate it with other systems as required.

## Example

Here's a sample code in the `Main` class:

```java
Customer customer = new Customer("Sunjay Kumar", "Saddar, Hyd, Sindh.", "0300 2856307");

Invoice I1 = new Invoice("Iv765", new Date(),  customer);

Service s1 = new Service("L4562", "Hp Laptop", 1, 150000, 0);
Service s2 = new Service("B3494", "Laptop Bag", 1, 5000, 0);
Service s3 = new Service("C3498", "8GB Ram", 2, 3500, 0);
Service s4 = new Service("XX537", "Ram Replacement", 0, 500, 1);

I1.addservice(s1);
I1.addservice(s2);
I1.addservice(s3);
I1.addservice(s4);
I1.printinvoice();
```

This code creates a sample customer, services, and an invoice, adds services to the invoice, and prints the invoice details.

Please make sure to customize the customer details and services to fit your specific use case.

Happy coding!
