Feature: Login

  Scenario Outline: 
    Given open browser and launch "https://www.gmail.com" site
    When Username should be visible
    Then send "<var>" value to UserName
    And click on next button
    And quit site

    Examples: 
      | var                    |
      | info.anku527@gmail.com |
      | info.hdsh@123gmail.com |
      |                        |
