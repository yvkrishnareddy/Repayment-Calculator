Feature: CommBank - Repayment Calculator - Investment

  @Test2
  Scenario Outline: Home Loan repayment calculator - Investment (principal and interest)
    Given User is on landing page of the CBA website
    When User clicks on "Home loans" tab
    And User clicks on "Calculators & tools" link
    And User clicks on Home loan repayments calculator "Calculate now" link
    And User enters "<LoanAmount>" and "<Term>" and "<Repayment Type>" and "<With a>" for Home Loan repayment
    And User clicks on calculate button
    Then User validate "<Expected Total loan repayments>" and "<Expected Total interest charged>" details

    Examples:
      | LoanAmount | Term | Repayment Type        | With a  | Expected Total loan repayments | Expected Total interest charged |
      |      50000 |   20 | Interest only 1 year  | 7774124 | $71,124                        | $21,124                         |
      |      40000 |   25 | Interest only 2 years |       8 | $81,682                        | $41,682                         |
 #     |      60000 |   30 | Interest only 3 years |      10 | $127,901                       | $67,901                         |
 #     |      55000 |   20 | Interest only 5 years |      14 | $101,475                       | $46,475                         |
