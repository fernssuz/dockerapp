# dockerapp


- Building Java Projects with Gradle  
https://spring.io/guides/gs/gradle/#scratch

- Plugins added
    - .ignore 
    https://plugins.jetbrains.com/plugin/7495--ignore
    
    
    
    
    
    
    
 # Issues encountered
 
 1. .gitignore is not ignoring said files or folder
 
    
     It is possible that Git is already tracking these files.  Running the following command in terminal worked for me for both .gradle and .idea files: 
     git rm --cached .gradle -r
     

 
 2. How to remove the .idea folder from git
    
     
    If you’ve inadvertently committed the .idea folder to your git repo, and don’t want it in there, it’s an easy change to revert.
    
    Note: These instructions should work for any JetBrains product–IntelliJ, WebStorm, etc.
    
    Blacklist the .idea folder by adding the “.idea” folder to the .gitignore file in master, then commit this change.
    In your branch, check this file out from master. git checkout master -- .gitignore
    Remove the .idea folder from the git tree
    git rm --cached -r .idea
    
    and commit this change to your branch.