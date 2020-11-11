# dockerapp


- Building Java Projects with Gradle  
https://spring.io/guides/gs/gradle/#scratch

- Plugins added
    - .ignore 
    https://plugins.jetbrains.com/plugin/7495--ignore
    
    
    
    
    
    
    
 # Issues encountered
 
 1. .gitignore is not ignoring said files or folder
 
 workAorund - 
 It is possible that Git is already tracking these files. 
 Running the following command in terminal worked for me for both .gradle and .idea files:
 
 git rm --cached .gradle -r   