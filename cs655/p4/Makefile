java-build:
	mkdir -p java/class
	javac -d java/class java/*.java

java-test:
	java -cp java/class Program4

st-test:
	gst st/Rational.st st/Dimension.st st/DRational.st st/Test.st st/RationalTest.st st/DimensionTest.st st/DRationalTest.st st/Program4.st

clean:
	rm -rf java/class
