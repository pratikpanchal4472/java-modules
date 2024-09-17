**Java Modules**, introduced in **Java 9** as part of **Project Jigsaw**, provide a way to modularize Java applications and the JDK itself. The goal of the module system is to improve scalability, security, maintainability, and performance of large applications by organizing code into distinct, reusable modules. Java modules address many of the limitations of the classpath-based structure of pre-Java 9 applications, such as classpath conflicts and poor dependency management.

Here’s a breakdown of what Java modules are and how they work:

### 1. **What is a Java Module?**
A **module** in Java is a collection of code organized into packages and resources that can be explicitly specified to be exposed or hidden. A module:
- Groups related classes and interfaces.
- Declares which parts of its code (packages) are visible to other modules and which parts are internal.
- States its dependencies on other modules.

### 2. **Key Concepts of Java Modules**
Several key concepts form the foundation of the Java module system:

#### a. **Module Declaration (`module-info.java`)**
Each module has a `module-info.java` file, located at the root of the module, which describes the module's characteristics, including:
- **Name of the module**.
- **Dependencies** on other modules.
- **Packages to export** (i.e., which packages are visible to other modules).
- **Services** that the module provides or consumes.

Example of a `module-info.java` file:
```java
module com.example.myapp {
    requires java.sql;  // This module requires another module
    exports com.example.myapp.services;  // This package is accessible to other modules
}
```

#### b. **`requires` Directive**
Specifies dependencies on other modules. For example, if a module needs the functionality provided by another module, it uses the `requires` directive in `module-info.java`.

#### c. **`exports` Directive**
Defines which packages in the module are available to other modules. Any unexported package remains encapsulated within the module, providing stronger encapsulation than what was previously possible with public classes.

#### d. **`uses` and `provides` Directives**
Supports the **Service Provider Interface (SPI)** pattern:
- `uses` indicates that a module uses a service.
- `provides` indicates that a module provides an implementation of a service.

For example:
```java
module com.example.app {
    uses com.example.service.MyService;  // Declares that this module uses the MyService interface
}
```
```java
module com.example.provider {
    provides com.example.service.MyService with com.example.provider.MyServiceImpl;  // Provides the MyService implementation
}
```

#### e. **Implied readability (`requires transitive`)**
When a module requires another module using `requires transitive`, any module that depends on the original module will also automatically depend on the transitive module. This is useful when a module serves as an intermediary between others.

Example:
```java
module com.example.logging {
    requires transitive java.logging;
}
```

### 3. **Advantages of Java Modules**
The introduction of modules provides several key benefits:

#### a. **Strong Encapsulation**
Modules allow you to hide internal implementation details. Classes that are not explicitly exported by a module remain inaccessible to other modules, even if they are public. This leads to better encapsulation and stronger boundaries between different parts of a system.

#### b. **Improved Dependency Management**
Modules explicitly declare their dependencies using the `requires` directive. This makes it clear what modules a particular module depends on and reduces the likelihood of classpath conflicts (i.e., "JAR hell").

#### c. **Better Security**
The module system allows finer-grained control over what parts of your code are accessible to other modules. This helps in creating more secure applications by reducing exposure to potentially sensitive internal classes.

#### d. **Faster Start-up and Smaller Footprint**
The **Java Platform Module System** (JPMS) makes it possible to use only the necessary modules from the JDK, reducing the size of applications and improving start-up times.

For example, you can use only a subset of the JDK modules that your application requires, avoiding unnecessary loading of unrelated modules.

### 4. **The JDK Modularization**
With Java 9, the **JDK itself was modularized**. It was split into many smaller modules, such as `java.base`, `java.sql`, `java.logging`, and more. Every Java application automatically depends on the `java.base` module, which contains the core libraries (like `java.lang`, `java.util`, etc.).

Some common JDK modules:
- `java.base`: Contains the most fundamental classes (automatically included).
- `java.logging`: Contains the logging API.
- `java.sql`: Contains the JDBC API.
- `java.desktop`: Contains the APIs for creating GUI applications (Swing, AWT).

### 5. **Modular JARs**
Modules are packaged in **modular JAR files**. A modular JAR is similar to a regular JAR but includes the `module-info.class` file, which defines the module’s metadata.

### 6. **Backward Compatibility**
Java modules are backward-compatible with existing classpath-based applications:
- Existing JARs can still be used, even if they don't have a `module-info.java` file.
- Unnamed modules are used to represent traditional JARs that don't conform to the modular system.

### 7. **Modularization Challenges**
- **Refactoring**: Legacy applications may require significant refactoring to adopt modules fully.
- **Split Packages**: A "split package" occurs when the same package is spread across multiple modules, which is disallowed by the module system.

### 8. **Usage Scenarios**
- Large, complex applications with many dependencies benefit the most from the module system.
- Applications needing to expose only part of their APIs while keeping the rest hidden.
- Systems that need strong encapsulation and enhanced security features.

### Example Module Definition
```java
module com.example.myapp {
    requires java.sql;           // Declare dependency on the java.sql module
    exports com.example.api;     // Export a package to make it accessible to other modules
    provides com.example.api.Service with com.example.impl.ServiceImpl;  // Provide an implementation of a service
}
```

### Summary:
Java modules provide a powerful way to structure and organize code by:
- Defining clear boundaries between code units.
- Allowing strong encapsulation of internal code.
- Explicitly declaring dependencies and exported APIs.
- Offering benefits in scalability, performance, and security for large applications.

**Youtube Content**
[How to create Modules in Java 9 - Tutorial](https://www.youtube.com/watch?v=89tplxrXJTU)


