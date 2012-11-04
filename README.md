# What is the jui?
The jui is a UI framework for Java.

# Why do you initiate the jui project?
A java developer usually use Swing to develop a UI application. But Swing does
not solve the following problems:
* Seperate business logic from representation logic. If you write a Swing 
application and don't use any design pattern, you have to write business logic
and create UI components in same class.

# What can jui do for me?
* Seperate business logic from representation logic. Jui accomplishes this by
employing a renderer framework. Business logic is in class A, class A contains
a reference to a renderer object, in which representation logic is written. By
doing this, you can write unit tests to test your business logic class without
worrying about your UI headaches.
* Using of Swing is optional. The default `ComponentRenderer` uses Swing to
render UI components, but this is not required. You can use any UI technique
to render your components on a screen, or even to a printer.

# How to compile the jui project?
You need to install Apache Maven.

# Demo
Run `java org.jui.Demo` after compiling the source code. The default `ComponentRenderer` renders a JLabel in a JFrame.
