# Java PowerPoint Game Framework

This project provides a simple framework for building presentation games in PowerPoint using Java. It leverages the [Apache POI](https://poi.apache.org/) library to generate slides and draws sprites using familiar game abstractions.

## Building

The project uses Maven. To compile, run:

```bash
mvn package
```

Note: Maven requires network access to download dependencies on the first run.

## Example Game

An example is included in `src/main/java/com/example/ppgame/example/ExampleGame.java`.
Running it will generate `game.pptx` with a short animation:

```bash
mvn exec:java -Dexec.mainClass="com.example.ppgame.example.ExampleGame"
```

This will output a PowerPoint presentation where each frame is a slide.

## Running Tests

The project includes a JUnit test that generates a presentation and
verifies it can be opened. Run tests with:

```bash
mvn -q test
```
