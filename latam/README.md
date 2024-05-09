# Airline web and API Testing Workshop

Web and API testing workshop solution using Selenium and Rest assured in BDD style running with
cucumber.

## Requirements:

- Java v17+
- A [CoinGecko](https://coingecko.com/) API Key for the api tests

## Setup

- Copy the [.env.example](./.env.example) file and rename it to `.env`, after the `=` fill the
  required api key

## How to run the tests

- Run the [RunLatamTest](src/test/java/com/davidbonelo/runners/RunLatamTest.java) class.
    - It's possible to filter by tags using the annotation
- Run a specific feature or scenario from [features/](src/test/resources/features)

to disable requests and responses login, remove the RestAssured filters in the `setup()` method from
this file: [Hooks]( src/test/java/com/davidbonelo/stepdefinitions/Hooks.java)

## How to generate reports

- Run from the console with the command `./gradlew test --rerun-tasks --info`
