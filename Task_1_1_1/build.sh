javadoc -d build/docs/javadoc -sourcepath src/main/java -subpackages nsu.odnostorontseva

javac src/main/java/nsu/odnostorontseva/HeapSort.java -d ./build

java -cp ./build nsu.odnostorontseva.HeapSort