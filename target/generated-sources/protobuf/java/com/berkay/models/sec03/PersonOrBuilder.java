// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: sec03/person.proto

// Protobuf Java Version: 3.25.1
package com.berkay.models.sec03;

public interface PersonOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Person)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string last_name = 1;</code>
   * @return The lastName.
   */
  java.lang.String getLastName();
  /**
   * <code>string last_name = 1;</code>
   * @return The bytes for lastName.
   */
  com.google.protobuf.ByteString
      getLastNameBytes();

  /**
   * <code>int32 age = 2;</code>
   * @return The age.
   */
  int getAge();

  /**
   * <code>string email = 3;</code>
   * @return The email.
   */
  java.lang.String getEmail();
  /**
   * <code>string email = 3;</code>
   * @return The bytes for email.
   */
  com.google.protobuf.ByteString
      getEmailBytes();

  /**
   * <code>bool employed = 4;</code>
   * @return The employed.
   */
  boolean getEmployed();

  /**
   * <code>double salary = 5;</code>
   * @return The salary.
   */
  double getSalary();

  /**
   * <code>int64 bank_account_number = 6;</code>
   * @return The bankAccountNumber.
   */
  long getBankAccountNumber();

  /**
   * <code>sint32 balance = 7;</code>
   * @return The balance.
   */
  int getBalance();
}
