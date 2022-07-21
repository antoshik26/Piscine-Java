compile:
    javac -d target src/java/edu/school21/printer/*/*.java

create jar file:
    cp -r .\ImageToChar\src\resurses .\target\ImagesToChar\src\resurses\
    jar cvfm ./target/images-to-chars-printer.jar .\ImageToChar\src\manifest.txt -C target ImageToChar -C .\target\ImageToChar\src\res\ .

run:
    java -jar .\target\images-to-chars-printer.jar
