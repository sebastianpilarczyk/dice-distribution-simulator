I have prepared final solution based on hexagonal architecture and some parts of domain driven design. I have done this way because of great level of testability of business logic its great dividing from some technical issues like cooperation with database for example.

The name of the entry point to the domain model (aggregate root) is DiceDistributionSimulator. I suggest to go there first of all for spying the business rules related with the simulator implementation.

The API has been described below.

####You can run the simulator using endpoint:

POST /api/dice-distribution-simulator

Body:
{
"totalNumberOfRolls": 100,
"numberOfDices": 4,
"numberOfSides": 8
}

####You can check total number of simulations and total roles made using endpoint:

GET /api/dice-distribution-simulator/total-numer-of-simulations-and-rolls-made

#### You can get the relative distribution for given numer of dices and numer of sides using endpoint:

GET /api/dice-distribution-simulator/relative-distribution?numberOfDices=4&numberOfSides=8

