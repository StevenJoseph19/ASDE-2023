Feature: Diet-friendly Smoothies

  Morning Freshness wants to attract health-conscious customers by proposing options to help smoothie buyers
  know if a smoothie is in line with their diet plans.

  With the 'diet-friendly' mode, Morning Freshness members can buy smoothies knowing that they are not threatening their diet plans.
  We hope this will encourage people on diets, or health-conscious customers in general, prefer Morning Freshness as a smoothie provider.

  Scenario Outline: Smoothies are organised into categories based on their number of calories

  Each category is represented by a number of "flames" - the more "flames" the smoothie has,
  the more calories it contains.

    When a <Smoothie> smoothie contains <Calories> calories
    Then it should be classed as a <Flames> flame smoothie in the <Range> range

    Examples: Healthy smoothie options
    Smoothies under 300 calories are classed as 'Healthy'

      | Category  | Smoothie          | Calories | Flames | Range   |
      | Under 200 | Apple and Kale    | 160      | 1      | Healthy |
      | Under 300 | Orange and Yogurt | 240      | 2      | Healthy |

    Examples: Indulgent smoothie options
    Smoothies with 300 or more calories are classed as 'Indulgent'

      | Category    | Smoothie           | Calories | Flames | Range     |
      | Under 400   | Triple Berry Blend | 380      | 3      | Indulgent |
      | 400 or more | Strawberry Special | 490      | 4      | Indulgent |

  Scenario: Dieting members are shown which smoothies fit their diet requirements
    Given Diana has opted for the diet-friendly plan with a maximum flame count of 2
    And the following smoothies are available:
      | Smoothie           | Calories | Flame Count |
      | Green Goodness     | 140      | 1           |
      | Orange and Yogurt  | 240      | 2           |
      | Triple Berry Blend | 380      | 3           |
      | Strawberry Special | 490      | 4           |
    When she views the smoothie catalog
    Then she should be shown the following smoothies:
      | Smoothie           | Flame Count | Diet-friendly |
      | Green Goodness     | 1           | Yes           |
      | Orange and Yogurt  | 2           | Yes           |
      | Triple Berry Blend | 3           | No            |
      | Strawberry Special | 4           | No            |

  Scenario: Dieting members should be proposed healthy alternatives
  Healthy options with the same flavor are proposed whenever a participating member selects a smoothie with 3 or 4 flames.

    Given Doug has opted for the diet-friendly plan
    And the following smoothies are available:
      | Smoothie           | Flavors       | Calories | Flame Count |
      | Green Goodness     | Green         | 140      | 1           |
      | Apple and Kale     | Sweet, Fruity | 160      | 1           |
      | Orange and Yogurt  | Fruity        | 240      | 2           |
      | Triple Berry Blend | Fruity        | 380      | 3           |
      | Strawberry Special | Sweet, Fruity | 490      | 4           |
    When Doug views the description of the "Strawberry Special"
    Then he should be shown the following "Healthy Option" smoothies:
      | Apple and Kale    |
      | Orange and Yogurt |

  @manual
  Scenario: Dieting members should be encouraged when they select a healthy option
    Given Doug has opted for the diet-friendly plan
    And the following smoothies are available:
      | Smoothie           | Calories | Flame Count |
      | Apple and Kale     | 160      | 1           |
      | Orange and Yogurt  | 240      | 2           |
      | Triple Berry Blend | 380      | 3           |
      | Strawberry Special | 490      | 4           |
    When Doug views the description of the "Orange and Yogurt"
    Then he should be shown that this is a "Healthy Option" smoothie

