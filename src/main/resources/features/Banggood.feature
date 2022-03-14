Feature: Verify The Banggood Easy Online Shopping application

  @TC01
  Scenario: Verify Product detail at Home and Garden
    When Click to the Category on footer menu
    And Click to Home and Garden in Left menu
    And click to the Home Decor
    And Click to the Filter
    And input price from "20" to "30"
    And Click Done
    And Click first product
    Then product name should be displayed
    And product price in range 20 to 30

  @TC02-1
  Scenario: Verify Product detail in Hot Categories screen
    When At the Home screen, scroll to “Hot Categories”
    And Click to the first category
    And Click to the first product
    Then The product detail page should be displayed
      | itemName           | display |
      | Product name       | Yes     |
      | product price      | Yes     |
      | Buy now button     | Yes     |
      | Add to Cart button | Yes     |

  @TC02-2
  Scenario: Verify Product in Cart
    Given Go to screen First Product of first category in Hot Categories
    When Click “Add to Cart”
    And Click to “Add to Cart” button
    And Click to Cart icon on footer
    Then Verify product name, product size, product price and quantity should be displayed
      | itemName      | display |
      | Product name  | Yes     |
      | product size  | Yes     |
      | product price | Yes     |
      | quantity      | Yes     |