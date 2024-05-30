Feature:Realizar la apertura
  de una nueva cuenta en parabank y
  verificar que esta salga en el resumen de cuenta

    Scenario: Registrarse en parabank y verificar resumen de cuenta
      Given Deseo abrir la pagina parabank "https://parabank.parasoft.com/parabank/index.htm"
      When ingreso el First Name "Anya" y el Last Name "Forger"
      When ingreso el Address "W1234" y la City "Berlint"
      When ingreso el State "Ostania" y el Zip Code "OBW123"
      When ingreso Phone "134679" y el SSN "0316497"
      When ingreso el Username "futures" y el password "Forger" y valido
      When Selecciono Open New Account y type of Account Savings
      Then valido que el numero de cuenta exista
