Feature: Commbank - Investment

  @Test2
  Scenario Outline: Home Loan repayment calculator - Investment (principal and interest)
    Given User is on commbank site
    When User clicks on "Home loans" tab
    And User clicks on "Calculators & tools" link
    And User clicks on Home loan repayments calculator "Calculate now" link
    And User enters "<LoanAmount>" and "<Term>" and "<Repayment Type>" and "<With a>" for Home Loan repayment
    And User clicks on calculate button
    Then User validate "<Expected Total loan repayments>" and "<Expected Total interest charged>" details

    Examples:
      | LoanAmount | Term | Repayment Type        | With a  | Expected Total loan repayments | Expected Total interest charged |
      |      50000 |   20 | Interest only 1 year  | 7774124 | $67,994                        | $17,994                         |
     # |      45000 |   30 | Interest only 3 years |       8 | $98,177                        | $53,177                         |
      #|      35000 |   20 | Interest only 1 year  |      10 | $57,013                        | $22,013                         |
      #|      45000 |   35 | Interest only 5 years |      14 | $96,407                        | $51,407                         |