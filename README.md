# Algo Questions
My solutions for Hackerhank, Algoexpert and Leetcode algo questions.

## Running Kotling scripts
Install kotlin and then run:
```
kotlin -J-ea -script <path-to-file.kts>
```

### On Visual Studio Code
You can use the code-runner, but make sure to add the -J-ea argument to you settings.json  
Example:
``` json
"code-runner.executorMapByFileExtension": {
  ...
  ".kts": "kotlinc -J-ea -script",
  ...
```
Or even simpler in latest versions:
``` json
"code-runner.executorMapByFileExtension": {
  ...
  ".kts": "kotlin -J-ea",
  ...
```
