# Thomas GIA Test Training

A Kotlin application designed to help users practice specific task types from the Thomas General Intelligence Assessment (GIA) test. This training tool focuses on two common task types that appear in the actual assessment.

## Purpose

This application helps candidates prepare for the Thomas GIA test by providing practice exercises for:
1. Letter Series Comparison
2. Number Pattern Recognition

## Task Types

### Letter Comparison Task
Simulates the letter comparison section from Thomas GIA where candidates need to:
- Compare two rows of letters (4 letters in each row)
- Count matching letter pairs (case-insensitive)
- Develop quick pattern recognition skills for letter matching

Example:
```
a b c d
A X C Y
```
Required answer: 2 (matches are 'a'/'A' and 'c'/'C')

### Number Pattern Task
- Displays 3 random numbers between 0 and 99
- Goal: Find a number that maintains the same absolute difference with the middle number (when sorted) as exists between adjacent numbers

Example:
```
15 7 24
```
When sorted: 7, 15, 24
- Difference between 7 and 15 is 8
- Difference between 15 and 24 is 9
- Answer would be 24
## Using the Training Tool

### Starting Practice
```bash
kotlin Main.kt [number_of_tasks]
```
- Optional: Specify how many practice tasks you want (default is 10)
- Tasks are randomly selected between letter comparison and number patterns

### Practice Session Flow
1. Each task is presented individually
2. Enter your answer as an integer
3. Continue through all tasks
4. Receive performance metrics at the end

### Performance Review
After completing all tasks, you'll see:
- Total number of tasks completed
- Number of correct answers
- Success rate percentage

## Training Tips

1. Time Management
    - Practice answering quickly but accurately
    - The actual Thomas GIA test is time-pressured

2. Pattern Recognition
    - For letter tasks: Scan systematically from left to right
    - For number tasks: Always sort the numbers mentally first

3. Regular Practice
    - Regular use helps develop faster pattern recognition
    - Familiarizes you with both task types

## Classes and Interfaces
- `Task`: Base interface defining task behavior
- `AbstractTask`: Abstract class implementing common task functionality
- `LettersTask`: Implementation of the letter matching game
- `DigitTask`: Implementation of the number pattern game

## Technical Requirements

- Kotlin runtime environment
- Command line interface
- Basic keyboard input capabilities

## Note

This is an unofficial training tool designed to help candidates practice specific task types that appear in the Thomas GIA test. It is not affiliated with Thomas International and should be used as a supplementary practice resource only.