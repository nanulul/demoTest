Feature: create a BDD project for testScriptDemo
  Scenario: add and verify the products in Cart
    Given I add four different products to my wish list
    When I view my wishlist table
    Then I find total four selected items in my wishlist
    When I search for lower price product
    And I am able to add lowest price item to my cart
    Then I am able to verify the item in my cart