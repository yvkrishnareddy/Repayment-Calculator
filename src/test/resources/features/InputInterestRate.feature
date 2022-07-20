Feature: CommBank - Repayment Calculator

  @Test3
  Scenario Outline: Home Loan repayment calculator - Input Interest Rate
    Given User is on commbank site
    When User clicks on "Home loans" tab
    And User clicks on "Calculators & tools" link
    And User clicks on Home loan repayments calculator "Calculate now" link
    And User enters "<LoanAmount>" and "<Term>" and "<Repayment Type>" for Home Loan repayment
    And User clicks on Input interest rate
    And User enters "<With an IRO>" an interest rate in text field
    And User clicks on calculate button
    Then User validate "<Expected Total loan repayments>" and "<Expected Total interest charged>" details

    Examples:
      | LoanAmount | Term | Repayment Type        | With an IRO |Expected Total loan repayments | Expected Total interest charged |
      |      50000 |   20 | Interest only 1 year  |           2 | $61,142 											| $11,142 											  |
      |      40000 |   30 | Interest only 2 years |           3 | $61,572 											|	$21,572 												|
