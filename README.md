# Library 
A Java program to create a class called 'Library' with a collection of books and methods to add, display and remove books, issue and return of books

A Java-based console application to manage book records, tracking titles, authors, IDs, and availability using ArrayList.

* OOP Principles Used
Encapsulation: All book data and logic (like addNew and issueBook) are bundled inside the Library class. This keeps data organized and prevents unauthorized external access.

Abstraction: The Main class only interacts with simple method calls. The complex logic of how the lists are searched or updated is hidden from the user.

Classes & Objects: The Library class acts as a blueprint, while libSystem is the actual object (instance) that stores the data during runtime.

Modularity: The program is divided into distinct sections—User Interface (Main) and Data Logic (Library)—making it easier to read and maintain.

* Functionality
Add: Store new book details into dynamic lists.

Display: View all current books and their issue status.

Remove: Delete records by searching for the book title.

Issue/Return: Toggle the availability status of books using ID or Name.

* Setup
Language: Java

Structure: Main class for the menu, Library class for backend operations.
