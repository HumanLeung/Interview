package com.company.java8.functional;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

//Represents an operation that accepts a single input argument and returns
// no result
public class ConsumerDemo {
    public static void main(String[] args) {
        // Normal java function
      Customer maria = new Customer("Maria","123455");
      greetCustomer(maria);

      //Consumer Functional interface
      greetCustomerConsumer.accept(maria);
      greetCustomerConsumerV2.accept(maria,true);


    }

    static BiConsumer<Customer,Boolean> greetCustomerConsumerV2 = (customer,condition)->
            System.out.println("Hello "+customer.customerName +
                    "and your phone number is " + customer.customerPhoneNumber);

    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.customerName +
                    "and your phone number is " + customer.customerPhoneNumber);

    static void greetCustomer(Customer customer) {
        System.out.println("Hello" + customer.customerName +
                "and your phone number is "+customer.customerPhoneNumber);
    }

    static class Customer {
      private final String customerName;
      private final String customerPhoneNumber;

      Customer(String customerName, String customerPhoneNumber) {
          this.customerName = customerName;
          this.customerPhoneNumber = customerPhoneNumber;
      }

    }
}
