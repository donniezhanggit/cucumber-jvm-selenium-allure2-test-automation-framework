@feature-a @regression
Feature: Feature number 1
  As a brilliant and caring individual
  I want to be able to adopt a puppy
  So that I can do a lil' good in the world


  Scenario: User adopts a puppy 002
    Given a browser has loaded the puppy adoption site
    When brook is adopted successfully
    Then the adoption successful message is shown
