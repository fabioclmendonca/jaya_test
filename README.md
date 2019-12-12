# Jaya Tech Challenge
Octo Events is an application that listens to Github Events via webhooks and expose by an api for later use.
1) Webhook Endpoint
The Webhook endpoint receives events from Github and saves them on the database.
2) Events Endpoint
The Events endpoint will expose the persist the events by an api that will filter by issue number

## Getting Started
This project has been developed using:
- Kotlin
- Javalin
- Koin
- Exposed
- h2 (DB)

## Instalation
This Step-By-Step is using the following tools.
- JVM
- Git
- Gradle
- ngrok
- IntelliJ

## Running
1) Clone project
2) Open main folder into IntelliJ
3) Open JayaChallenge.kt
4) Use IDE default run
5) Open Command Line and start ngrok to http protocol and 4567 port
```
ngrok http 4567
```
6) Open disired gitHub repository and add a Web Hook to create URL by ngrok and select "Let me select individual events." option to select only "issues" checkbox.
```
http://d3ad1e9c.ngrok.io/payload
```
7) Create or edit an issue into your repository. (Web Hook will send a message to inserted URL)
8) Using prefered Web Browser and search.
```
http://d3ad1e9c.ngrok.io/issues/events
```
or
```
http://d3ad1e9c.ngrok.io/issues/[ISSUE NUMBER]/events
```

Thanks


