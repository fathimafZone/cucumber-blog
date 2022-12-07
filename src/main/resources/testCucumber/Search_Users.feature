Feature: Search Users

  @SearchUsersWithUserId
  Scenario Outline: Verify Searching users with User ID 1, 5, 7, 9
    Given I want to search for user id <userId>
    When I click search user
    Then I should get a successful response with status code 200
    And user id should be <userId>
    And user first name should be "<firstName>" and last name should be "<lastName>"

    Examples:
      | userId | firstName | lastName |
      | 1      | George    | Bluth    |
      | 5      | Charles   | Morris   |
      | 7      | Michael   | Lawson   |
      | 9      | Tobias    | Funke    |