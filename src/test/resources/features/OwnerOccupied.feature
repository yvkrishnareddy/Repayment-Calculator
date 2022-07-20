Feature: Commbank - Owner occupied

  @Test1
  Scenario Outline: Home Loan repayment calculator - Owner occupied (principal and interest)
    Given User is on commbank site
    When User clicks on "Home loans" tab
    And User clicks on "Calculators & tools" link
    And User clicks on Home loan repayments calculator "Calculate now" link
    And User enters "<LoanAmount>" and "<Term>" and "<Repayment Type>" and "<With a>" for Home Loan repayment
    And User clicks on calculate button
    Then User validate "<Expected Total loan repayments>" and "<Expected Total interest charged>" details

    Examples:
      | LoanAmount | Term | Repayment Type        | With a  | Expected Total loan repayments | Expected Total interest charged |
      |      45000 |   30 | Interest only 1 year  | 7774123 | $71,620                        | $26,620                         |
      |      65000 |   10 | Interest only 3 years |       1 | $91,506                        | $26,506                         |
      |      43000 |   20 | Interest only 2 years |       4 | $71,468                        | $28,468                         |
      |      29000 |   10 | Interest only 5 years |       7 | $43,487                        | $14,48		                       |
