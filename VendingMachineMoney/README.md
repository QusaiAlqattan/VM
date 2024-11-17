# Vending Machine Money 

## Overview

The Vending Machine Money Tracker class is designed to manage monetary transactions in a vending machine system. This class tracks money in terms of bills and coins, ensuring that the system can handle transactions and provide correct change to customers based on available currencies.

## Features

- **Denominations Management**: Handles various currencies of money (bills and coins).
- **Change Calculation**: Determines if the correct change can be provided based on available currencies.
- **Transaction Handling**: Supports operations like adding money, subtracting amounts for purchases, and returning change.

## Usage

### Creating Money Instances

You can create monetary amounts using predefined constants or by specifying the amount directly. For example, you can define constants for common currencies such as Dinars and Piasters.

### Performing Operations

- **Adding Money**: Add a certain amount of money to the vending machine's total.
- **Subtracting Amount**: Deduct the price of an item from the total amount provided by the customer.
- **Returning Change**: Calculate and return the appropriate change based on the available currencies.

### Error Handling

- **Insufficient Funds**: If the total amount provided by the customer is less than the item price, an exception is thrown.
- **Exact Change Required**: If it is not possible to provide the exact change with the available currencies, an exception is thrown.

## Unit Testing

The Vending Machine Money Tracker is tested to ensure accuracy and reliability. The unit tests include:

- **Addition and Subtraction**: Verify that money can be added and subtracted correctly.
- **Change Calculation**: Ensure that the system can calculate and return correct change based on available currencies.
- **Edge Cases**: Handle scenarios where exact change cannot be provided or where funds are insufficient.

### Test Coverage

- **Add Money**: Checks correct addition of bills and coins.
- **Subtract Purchase Price**: Ensures accurate deduction of item price from the total amount.
- **Return Change**: Validates the ability to provide correct change using available currencies.
- **Handle Insufficient Funds**: Tests for cases where provided funds are insufficient for a purchase.
- **Ensure Exact Change**: Confirms that the system can provide exact change or throws an appropriate error when it cannot.

## Class Details

### Constructors

- `Money(List<Double> currencies)`: Initializes with a list of monetary currencies.
- `Money(double amount)`: Initializes with a specific monetary amount.

### Methods

- `double amount()`: Returns the total monetary amount.
- `Money times(int count)`: Multiplies the monetary value by a specified count.
- `Money plus(Money other)`: Adds another `Money` instance to the current one.
- `Money minus(Money other)`: Subtracts another `Money` instance from the current one.
- `static Money sum(Money... items)`: Sums up multiple `Money` instances.
- `String toString()`: Provides a string representation of the monetary value.
- `boolean equals(Object obj)`: Checks equality between two `Money` instances.

## Dependencies

The Vending Machine Money Tracker relies on Java standard libraries, including `java.util.ArrayList`, `java.util.Collections`, `java.util.HashMap`, and `java.util.List`.


