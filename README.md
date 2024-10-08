# Java-Design-Pattern


### Strategy:
Define a family of algorithms, encapsulate them and make them interchangeable. 
Strategy lets the algorithm vary independently of the client that uses them.

Bad side:</br>
`Program implementation means when defining a family of algorithm we need to program to implementation for instantiation.`

Principle:</br>
`Encapsulate what varies.`</br>
`Composition over inheritance.`</br>
`Program implementation.`



### Observer:
Has a one-to-many dependencies between objects so that when one object change state all its dependent objects are 
notified and updated automatically.


Bad Side:</br>
`Tight coupling between Subject and observer.`</br>
`All observers are notified even if the notification is irrelevant to them.`

Principle:</br>
`Encapsulate what varies.`</br>
`Composition over inheritance.`</br>
`Program implementation.`</br>
`Loosely coupled design.`



### Decorator:
Attach additional responsibilities to an object dynamically. Decorator provides flexible alternative to subclassing 
for extending functionalities.

Bad Side:</br>
`Decorators can sometimes end up adding too much functionality to a class, violating the Single Responsibility Principle.`

Principle:</br>
`Open-Closed principle.`



### Factory Method:
Defines an interface for creating objects but lets the subclasses decide which class to instantiate. The factory 
method lets the class defer its instantiation to subclasses.

Abstract Factory: Provides an interface for creating families of related or dependent objects without specifying their 
concrete classes.

Bad Side:</br>
`Tight coupling to concrete class.`</br>
`Increased complexity.`</br>
`For abstract: tight coupling between product and factories.`

Principle:</br>
`Abstraction.`



### Singleton Method:
Ensure a class only has one instance and provide a global point of access to it.

Bad Side:</br>
``

Principle:</br>
``



### Command:
Encapsulate a request as an object there by letting you parameterize clients with different requests, queue requests, 
log request and support undo operation.

Bad Side:</br>
`Increased Number of Classes.` </br>
`Tight Coupling to Command Invoker.`

Principle:</br>
`Abstraction.`



### Adapter:
Converts the interface to another interface the client expects. Adapter lets class work together that could not work 
because of incompatible interfaces.

Bad Side:</br>
`Tight coupling to adaptee.`

Principle:</br>
`Talk only to your friend.`




### Facade:
Provides a unified interface to a set of interfaces of a sub system. Façade defines a higher level of interface that 
makes the sub system easier to use.

Bad Side:</br>
`Limited flexibility.`

Principle:</br>
`Talk only to your friend.`



### Template:
Define the steps of an algorithm in an operation deferring some steps to subclasses. Template pattern lets subclass 
change some steps of an algorithm without changing the algorithm structure.

Bad Side:</br>
`Increased coupling between base and sub classes.`

Principle:</br>
`Don’t call us, we will call you.`



### Iterator:
Provide a way to access the elements of an aggregate object sequentially without exposing its underlying representation.

Bad Side:</br>
`Limited Flexibility with Complex Iteration Logic.`

Principle:</br>
`A class should have only one reason to change.`


### Compositor:
Compose objects into tree structures to represent part whole hierarchies.Composite let clients treat individual 
objects and compositions of object uniformly.

Bad Side:</br>
``

Principle:</br>



### State:
allow an object to alter its behavior when its internal state changes. The object will appear to change its class.

Bad Side:</br>
``

Principle:</br>



### Proxy:
Provide a surrogate or placeholder for another object to control access to it.

Bad Side:</br>
``

Principle:</br>
``


