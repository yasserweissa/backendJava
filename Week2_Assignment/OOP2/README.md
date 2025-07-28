# Employee Management System

This Java program demonstrates the use of inheritance, method overriding, and object-oriented principles to create a simple Employee Management system.

## Overview

This system consists of four classes:

- **Person**: Represents a person with basic fields such as name and age.
- **Employee**: Inherits from `Person` and represents an employee, adding two more fields: salary and role.
- **Chef**: A specific type of employee that specializes in cooking, overriding the `work()` method to represent their unique duties.
- **Waiter**: A specific type of employee that specializes in serving customers, overriding the `work()` method to represent their unique duties.
  
### Objective

The goal of this program is to demonstrate inheritance and method overriding. It shows how a `Chef` and `Waiter` can both inherit from the `Employee` class, yet have their own specific implementation of the `work()` method.

## Class Structure

### 1. **Person Class**
- **Fields**:
  - `name`: A `String` representing the name of the person.
  - `age`: An `int` representing the age of the person.
  
- **Constructor**:
  - `Person(String name, int age)`: Initializes `name` and `age` fields.
  
- **Methods**:
  - `introduce()`: Prints the person's name and age.

### 2. **Employee Class (extends Person)**
- **Fields**:
  - `salary`: A `double` representing the salary of the employee.
  - `role`: A `String` representing the role of the employee.

- **Constructor**:
  - `Employee(String name, int age, double salary, String role)`: Initializes `name`, `age`, `salary`, and `role`.
  
- **Methods**:
  - `work()`: Prints a general message about the employee's role.

### 3. **Chef Class (extends Employee)**
- **Methods**:
  - `work()`: Overrides the `work()` method to print that [name] mainly prepares dishes".

### 4. **Waiter Class (extends Employee)**
- **Methods**:
  - `work()`: Overrides the `work()` method to printthat [name] mainly serves customers".

### 5. **Main Class**
- **Objective**:
  - Create instances of `Chef` and `Waiter`.
  - Call the `introduce()` and `work()` methods for each one.
