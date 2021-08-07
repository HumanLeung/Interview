package com.company.java8.combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static com.company.java8.combinatorpattern.ValidationResult.*;

public interface CustomerRegistrationValidator
        extends Function<Customer,ValidationResult> {
  static CustomerRegistrationValidator isEmailValid() {
   return customer -> customer.getEmail().contains("@") ?
           SUCCESS : EMAIL_NOT_VALID;
  }
  static CustomerRegistrationValidator isPhoneNumberValid() {
      return customer -> customer.getPhoneNum().startsWith("+0") ?
              SUCCESS : PHONE_NUMBER_NOT_VALID;
  }
  static CustomerRegistrationValidator isAuAdult() {
      return customer -> Period.between(customer.getDob(),
              LocalDate.now()).getYears() > 16 ?
              SUCCESS : IS_NOT_AN_ADULT;
  }
  default CustomerRegistrationValidator and(CustomerRegistrationValidator other) {
      return customer -> {
          ValidationResult result = this.apply(customer);
          return result.equals(SUCCESS) ? other.apply(customer)
                  :result;
      };
  }
}

enum ValidationResult {
    SUCCESS,
    PHONE_NUMBER_NOT_VALID,
    EMAIL_NOT_VALID,
    IS_NOT_AN_ADULT
}

