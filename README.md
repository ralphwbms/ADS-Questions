# Algo Questions

My solutions for Hackerhank, Algoexpert and Leetcode algo questions.

## Running Kotling scripts

Install kotlin and then run:

```
kotlin -J-ea -script <path-to-file.kts>
```

### On Visual Studio Code

1. Install the [Code Runner plugin](https://marketplace.visualstudio.com/items?itemName=formulahendry.code-runner)
2. Open your user settings.json
3. Locate the `code-runner.executorMapByFileExtension` section
4. Locate the `.kts` configuration and add `-J-ea` right after `kotlinc`

Example:

```json
"code-runner.executorMapByFileExtension": {
  ...
  ".kts": "kotlinc -J-ea -script",
  ...
```

In recent versions of Kotlin, it can be even simpler:

```json
"code-runner.executorMapByFileExtension": {
  ...
  ".kts": "kotlin -J-ea",
  ...
```
