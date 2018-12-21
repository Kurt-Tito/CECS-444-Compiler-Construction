444 Compilers — Project #2 — Parser
CECS 444  12/20/2018
Group Name: HJK 	
Group Members: Jeffrey Heng 012690039, Harry Hoang 013018562, Jimmy Luu 013474849, Kurt Tito 013321839

Intro: The purpose of this assignment is to use the output from the Lexer to write a backtracking-free LL Predictive Parser. The LL Parser
will create a PST of Node objects from the A6 grammar given. LL Parse table will be created in order to facilitate converting the A6 grammar
to simple LL-compatible form. The purpose of the AST Interpreter is to run the AST as a program. We will build a SCT in order to perform a treewalk of the AST to run the AST executable statements.

Steps:  Unzip and import the project to a java compiler.
	Use "Tester.java" under "Assignment 1 Lexer" to run the lexer program.
	You may change the read text file for the lexer program in "Tester.java"
	Use "main.java" under "Assignment 2 Parser" to run the parser program.


Contents of 444-p1_HJK: .metadata, Assignment 1 Lexer, Readme.txt
TF1.png //All pictures of compiler output
TF2.png
TF3.png
TF4.png
Assignment 1 Lexer: .settings, bin, src, .classpath, .project
Test Assignment #1.txt //Test text files 1-4 for Lexer
Test Assignment #2.txt
Test Assignment #3.txt
Test Assignment #4.txt
src:
Lexer.java	       //This Lexer class works on creating tokens from words on the given text file
Tester.java	       /*This is the main runnable class that displays all the tokens that are processed from the given text file in proper format
			 Has a function to change text files to test lexer*/						
Token.java             //Token enum class contains the token values of the broken down strings from the text file

Assignment 2 Parser: .settings, src, .classpath, .project
program.txt
src:
ASTConverter.java //PST to AST converter
Grammar.java // holds ID and keyword
Lexer.java // creating tokens from words on the given text file
main.java //used to run the Parser
Node.java //Node class keeps track of child and parent nodes to add, remove, replace
Operations.java // nodes to test
Parser.java //LL Mechanism
ParseTable.java //Parse Table via row column values via rules
Rule.java // rules listed
RuleList.java //rules listed from A6 grammar
Token.java //Tokens in A2 Lexcon

External Requirements: None

Setup and Installation: Unzip files

Sample inovcation and results to see (Lexer):
TF1.png //All pictures of compiler output
TF2.png
TF3.png
TF4.png
https://imgur.com/a/0d1JmR3 // viewable link to all images with link

Sample inovcation and results to see (Parser):

Helpful References: https://javarevisited.blogspot.com/2016/07/how-to-read-text-file-using-scanner-in-java-example-tutorial.html
https://zeroturnaround.com/rebellabs/java-regular-expressions-cheat-sheet/
http://hackingoff.com/compilers/ll-1-parser-generator#ll-1-parsing-table

Features(Lexer): Lexer that provides all Token values given, line numbers relative to input stream and input stream outputs within a neat format
float and int inputs are also displayed separately
Peak() will return a copy of the next character in the input stream
Advance() moves past that next character

Features(Parser): Parser that creates a Parse Tree of node objects retrieved from the Lexer. Tree serialization is done in Tree-Walking order.
The Parser will convert the PST created into an AST.

Missing Features/Problems: 
LEXER: Line numbering after a repeating input stream is displayed as the same as the previous input stream
For example: "{" is found on line 1, then "{" is also found on line 2, "{" found on line 2 will be displayed as found on line 1
Comments are still within lexer, need to remove comments to avoid lexer to display them as tokens

PARSER: Not all A6 Grammar was implemented within the Parser.

Bugs: None found
