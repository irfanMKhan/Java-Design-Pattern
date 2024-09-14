# Java-Design-Pattern


Strategy:
Define a family of algorithms, encapsulate them and make them interchangeable. 
Strategy lets the algorithm vary independently from the client that uses them.

Bad side:
Program implementation means when defining a family of algorithm we need to program to implementation for instantiation.

Principle:
Encapsulate what varies.
Composition over inheritance.
Program implementation.



Observer:
Has a one-to-many dependencies between objects so that when one object change state all its dependent objects are 
notified and updated automatically.


Bad Side:
Tight coupling between Subject and observer.
All observers are notified even if the notification is irrelevant to them.

Principle:
Encapsulate what varies.
Composition over inheritance.
Program implementation.
Loosely coupled design.



Decorator:
Attach additional responsibilities to an object dynamically. Decorator provides flexible alternative to subclassing 
for extending functionalities.

Bad Side:
Decorators can sometimes end up adding too much functionality to a class, violating the Single Responsibility Principle.

Principle:
Open-Closed principle.



Factory Method:
Defines an interface for creating objects but lets the sub classes decide which class to instantiate. The factory 
method lets the class defer its instantiation to sub classes.

Abstract Factory: Provides an interface for creating families of related or dependent objects without specifying their 
concrete classes.

Bad Side:
Tight coupling to concrete class.
Increased complexity.
For abstract: tight coupling between product and factories.

Principle:
Abstraction.



Command:
Encapsulate a request as an object there by letting you parameterize clients with different requests, queue requests, 
log request and support undo operation.

Bad Side:
Increased Number of Classes.
Tight Coupling to Command Invoker.

Principle:
Abstraction.



Adapter:
Converts the interface to another interface the client expects. Adapter lets class work together that could not work 
because of incompatible interfaces.

Bad Side:
Tight coupling to adaptee.

Principle:
Talk only to your friend.




Facade:
Provides a unified interface to a set of interfaces of a sub system. Façade defines a higher level of interface that 
makes the sub system easier to use.

Bad Side:
Limited flexibility.

Principle:
Talk only to your friend.



Template:
Define the steps of an algorithm in an operation deferring some steps to subclasses. Template pattern lets subclass 
change some steps of an algorithm without changing the algorithm structure.

Bad Side:
Limited flexibility.

Principle:
Don’t call us, we will call you.





