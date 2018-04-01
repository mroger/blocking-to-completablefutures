# Blocking code to CompletableFuture

#### Converting blocking code to asynchonous Java 8 CompletableFuture

This is a project to demonstrate to a friend how a code can be written to take advantage of CompletableFutures 
asynchronous code. But this is a dummy code with a lot of empty methods that only have code to generate delay.

Below are the relevant commits to show the conversion from blocking to asynchronous. It´s possible to see that the
first version takes longer because it's sequential.

>To get a specific version using Git, use the command **git checkout <commit_hash>**

|Hash|Feature|
|---|---|
|ceda595| First version with the blocking methods|
|4e75059| Organizing the methods to have a better understanding of its dependencies.|
|53ac7a2| Extracting methods to have a better understanding of its dependencies.|
|a003f67| Using CompletableFuture to use its asynchronous feature.|
|b82e0e8| Showing how CompletionStages can be chained together|

