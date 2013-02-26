####
# Makefile for project 2
#
# Modified 2/2013 Zachary May
# Modified 1/2011 Raphael Finkel
#
# All classes are compiled into the ./class directory
#
# The default is to make all .class files.
#    clean    -- removes all generated files
#    test     -- Tests proj2 by running P2.class with input tiny.csx
###

SRC = .
PKG_SRC = $(SRC)/net/sector42/cs541
CLASSPATH = ./class
PKG_CLASS = $(CLASSPATH)/net/sector42/cs541
VPATH = $(CLASSPATH)
JCFLAGS = -Xlint:all -deprecation -classpath $(CLASSPATH) -d $(CLASSPATH) -sourcepath . -Xprefer:source
JFLAGS = -classpath $(CLASSPATH)
JFLEX = ../jflex/bin/jflex
JFLEXFLAGS = -d $(PKG_SRC)

JAVA_FILES = $(shell find $(SRC) -type f -name '*.java')

$(PKG_CLASS)/P2.class: $(JAVA_FILES) $(PKG_SRC)/Yylex.java
	javac $(JCFLAGS) $(PKG_SRC)/P2.java

$(PKG_SRC)/Yylex.java: csx.jlex
	rm -f $(SRC)/Yylex.java
	$(JFLEX) $(JFLEXFLAGS) csx.jlex

###
# test
###

test:   $(PKG_CLASS)/P2.class tiny.csx
	java $(JFLAGS) net.sector42.cs541.P2 test.csx

###
# style check
###

style:
	../pmd/bin/run.sh pmd -dir $(SRC) -f text -rulesets java-basic,java-design,java-typeresolution,java-unusedcode | grep -v Yylex.java

###
# lint check
###

lint: $(PKG_CLASS)/P2.class
	jlint +all classes

###
# clean
###

clean: 
	rm -rf $(CLASSPATH)/* $(PKG_SRC)/Yylex.java

