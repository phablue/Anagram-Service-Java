## Anagram Service
This program allows a user to find anagrams for words from a particular word list.

### Running the program
To run the program from the command line, navigate to the project directory and use the following command:

`java -jar anagram_service.jar`

### Acceptance Criteria
If a user enters a word that is found in the word list being used, the program will return a list of anagrams for that word from the word list. If the user enters a word that is found but there are no anagrams for it, the program will return an empty list.

If a user enters a word that is not in the word list being used, a message will display indicating that the program could not find that word.

If a user just presses enter, the program will terminate.

### Architecture
I have divided the responsibilities of this program into three classes: the UI class, the Word class, and the Service class.

The UI class is responsible for methods related to user interaction.

The Word class is where the core business logic exists. This class is responsible for actually finding the list of anagrams for a given word.

The Service class uses both the UI class and the Word class. It is responsible for running the program and delegating to the other classes as necessary.

### Testing
The tests for this project are written in J-Unit.
