Feature: 

  Background: 
    Given Launch site using "https://www.gmail.com" URL

  Scenario: validate title of home page
    Then Title should be "Gmail"
    When close site

  Scenario: validate cookies loaded
    Then cookies should be loaded
    When close site
