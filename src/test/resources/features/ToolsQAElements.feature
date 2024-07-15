Feature: Practice Selenium - Cucumber & TestNG on ToolsQA Website
  Background: Open Driver & navigate to the Website
    Given I navigate to ToolsQA Website
    Then I check if i am in the Home Page

  @Elements
  Scenario Outline: Testing Elements Page
    Given I click on "Elements" card
    Then I verify that i am in the write page
    Given I click on "Text Box" in List Items
    Then I verify That i am redirected to a page with title "Text Box"

    Examples:
      | fullName | email | currentAddress | permanentAddress | isOk |

