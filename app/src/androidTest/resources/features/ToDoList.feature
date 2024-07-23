Feature: To-Do List Functionality

  Scenario: Add a new task
    Given the app is open
    When I enter "Buy groceries" as a task
    And I tap the "Add" button
    Then the task "Buy groceries" should be displayed in the list

  Scenario: Mark a task as complete
    Given the app is open
    And the task "Buy groceries" is in the list
    When I tap the checkbox next to "Buy groceries"
    Then the task "Buy groceries" should be marked as complete

  Scenario: Delete a task
    Given the app  is open
    And the task "Buy groceries" is in the list
    When I long-press the task "Buy groceries"
    And I tap the "Delete" button
    Then the task "Buy groceries" should be removed from the list

  Scenario: View empty list
    Given the app is open
    And there are no tasks in the list
    Then the message "No tasks yet!" should be displayed

  Scenario: Clear all completed tasks
    Given the app is open
    And the tasks "Buy groceries" and "Walk the dog" are in the list
    And "Buy groceries" is marked as complete
    When I tap the "Clear Completed" button
    Then the task "Buy groceries" should be removed from the list
    And the task "Walk the dog" should still be in the list