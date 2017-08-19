# Vesco's Helix Sorter
A utility for sorting patch files for the Line 6 Helix. It takes all patch files under a directory (and subdirectories) and sorts them into folders named according to which amp models are used in the patch.

![Vesco's Helix Patch Sorter Overview](http://i0.wp.com/www.benvesco.com/blog/wp-content/uploads/2016/03/HelixSorter.jpg)

# Usage
## Basic
Drop the .jar file in your base patch directory and run it.
```java -jar name-of.jar```

## Advanced
You can run this CLI and pass in the directory name. If you know what this means you won't need help. If you don't know what this means then don't do it this way.

# What it does
It will create a directory named `sorted` in the current directory. The program will comb all subdirectories looking for *.hlx files. They will be copied (duplicated, not moved) into the `sorted` directory, each into a new directory matching the name of the amp model used within. If a patch contains multiple amp models then an `_` (underscore) will be prepended on the file name and that *.hlx will be duplicated into the corresponding directory of every amp included in that file.

# Development
## Pre-requisites
* Java
* Maven
* Git

## Building
* `mvn clean package`

## Eclipse
The STS build of Eclipse is preferred if you aren't familiar with the toolchain, otherwise be sure to install enough plugins to do maven, git, or whatever else you want to do from IDE. You can configure a run profile by pointing at `App.java` and setting a single program argument: the path where *.hlx files are located that you want to use for testing. Example:
* `/Users/myself/Documents/my\ helix\ patches/`

## Links
[Home Page](http://www.benvesco.com/blog/vescos-helix-patch-sorter/)
