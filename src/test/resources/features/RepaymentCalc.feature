Feature: Commbank
	@Test1
  Scenario: Home Loan repayment calculator
    Given User is on commbank site
    When User clicks on "Home loans" tab
    And User clicks on "Calculators & tools" link
    And User clicks on Home loan repayments calculator "Calculate now" link
    And User enters "12000" as Loan Amount
    And User enters "20" as term
    And User selects "Interest only 1 year" as repayment type
    And User selects "3.8% p.a. Extra Investment Home Loan 30% deposit" in owner occupied
    And User clicks on calculate button
    Then User validate total loan repayment and total interest charged
  
  @Test2
  Scenario Outline: Home Loan repayment calculator - Owner occupied (principal and interest)
    Given User is on commbank site
    When User clicks on "Home loans" tab
    And User clicks on "Calculators & tools" link
    And User clicks on Home loan repayments calculator "Calculate now" link
    And User enters "<LoanAmount>" and "<Term>" and "<Repayment Type>" and "<With a>" for Home Loan repayment
    And User clicks on calculate button
    Then User validate total loan repayment and total interest charged

    Examples: 
      | LoanAmount | Term | Repayment Type        | With a  |
      |      45000 |   30 | Interest only 1 year  | 7774123 |
      |      35000 |   20 | Interest only 2 years | 7784123 |
      |      65000 |   10 | Interest only 3 years |       1 |
      |      40000 |   30 | Interest only 1 year  |       3 |
      |      43000 |   20 | Interest only 2 years |       4 |
      |      33000 |   30 | Interest only 3 years |       5 |
      |      28000 |   20 | Interest only 4 years |       6 |
      |      29000 |   10 | Interest only 5 years |       7 |

	@Test3
  Scenario Outline: Home Loan repayment calculator - Investment (principal and interest)
    Given User is on commbank site
    When User clicks on "Home loans" tab
    And User clicks on "Calculators & tools" link
    And User clicks on Home loan repayments calculator "Calculate now" link
    And User enters "<LoanAmount>" and "<Term>" and "<Repayment Type>" and "<With a>" for Home Loan repayment
    And User clicks on calculate button
    Then User validate total loan repayment and total interest charged

    Examples: 
      | LoanAmount | Term | Repayment Type        | With a  |
      |      50000 |   20 | Interest only 1 year  | 7774124 |
      |      40000 |   25 | Interest only 2 years | 7784124 |
      |      35000 |   30 | Interest only 3 years | 7794124 |
      |      45000 |   30 | Interest only 3 years |       8 |
      |      35000 |   20 | Interest only 1 year  |      10 |
      |      55000 |   10 | Interest only 2 years |      11 |
      |      35000 |   40 | Interest only 3 years |      12 |
      |      40000 |   20 | Interest only 4 years |      13 |
      |      45000 |   35 | Interest only 5 years |      14 |

	@Test4
  Scenario Outline: Home Loan repayment calculator - Input Interest Rate
    Given User is on commbank site
    When User clicks on "Home loans" tab
    And User clicks on "Calculators & tools" link
    And User clicks on Home loan repayments calculator "Calculate now" link
    And User enters "<LoanAmount>" and "<Term>" and "<Repayment Type>" for Home Loan repayment
    And User clicks on Input interest rate
    And User enters "<With an Interest Rate of>" an interest rate in text field
    And User clicks on calculate button
    Then User validate total loan repayment and total interest charged

    Examples: 
      | LoanAmount | Term | Repayment Type        | With an Interest Rate of |
      |      50000 |   20 | Interest only 1 year  |                        2 |
      |      40000 |   30 | Interest only 2 years |                        3 |
