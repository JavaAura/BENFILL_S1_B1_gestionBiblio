
# Municipal Library Management Console Application

This Java 8 console application was developed to automate the tasks of a municipal library, focusing on efficient inventory management for books and magazines, as well as handling borrowing and returning operations.

## Project Overview

The project was built with a layered architecture, dividing the application into three main layers: presentation, business logic, and utility.

### Presentation Layer

- **ConsoleUI Class**: This class serves as the user interface, providing a console-based menu for interacting with the application.

### Business Logic Layer

- **Document Abstract Class**: 
  - Attributes: `id`, `titre`, `auteur`, `datePublication`, `nombreDePages`
  - Abstract Methods: `emprunter()`, `retourner()`, `afficherDetails()`

- **Livre Class** (inherits from Document): 
  - Additional Attribute: `isbn`
  - Implements all abstract methods from the `Document` class.

- **Magazine Class** (inherits from Document): 
  - Additional Attribute: `numero`
  - Implements all abstract methods from the `Document` class.

- **Bibliotheque Class**: 
  - Manages the collection of documents. I used an `ArrayList` to store all documents, and a `HashMap<Long, Document>` for quick document retrieval by ID.

### Utility Layer

- **DateUtils Class**: 
  - This class is responsible for handling all date manipulations, utilizing the Java Time API.

## Key Features

- **Add a Document**: Allows adding either a book or a magazine to the library's inventory.
- **Borrow a Document**: Handles the borrowing process for both books and magazines.
- **Return a Document**: Manages the return process, updating the document's availability status.
- **Display All Documents**: Lists all books and magazines currently in the library's inventory.
- **Search for a Document**: Provides a quick search functionality, leveraging `HashMap<Long, Document>` for efficient lookup.

## Technical Details

- I used an `ArrayList` to manage the storage of documents, which ensures dynamic resizing and easy manipulation of the collection.
- To enable fast search by document ID, I implemented a `HashMap<Long, Document>`, which allows for constant-time complexity on average.
- The Java Time API was integrated for robust and flexible date management.
- I applied lambda expressions to streamline operations like filtering and searching within the document collections.

## User Interface

The application features an interactive console menu with the following options:

1. Add a Document
2. Borrow a Document
3. Return a Document
4. Display All Documents
5. Search for a Document
6. Exit

### Example

```plaintext
Please enter your choice (1-6):
```

## Data Persistence and Constraints

- Data is stored in memory for the duration of the application’s runtime and is cleared upon closure.
- Input validation was implemented to handle potential user errors effectively.

## Project Management

- The project was version-controlled using Git, ensuring proper tracking of all changes.
- JIRA was used for task management, allowing for organized and efficient development processes.
- I participated in daily stand-ups (simulated) to keep track of progress and ensure continuous improvement.

## Bonus Features (Implemented)

- **Optional**: Utilized for handling nullable values gracefully.
- **Stream API**: Implemented for filtering and displaying documents, providing a more functional programming approach.
- **Java Time API**: Enhanced for advanced date management scenarios.
- **Advanced Exception Handling**: Included to manage edge cases and potential runtime errors more effectively.
- **Data Persistence with MySQL and JDBC**: Integrated for storing data persistently across application runs.
