####
# Makefile for project 1
# Charles Fischer
# Modified 1/2011 Raphael Finkel
#
# All classes are compiled into the ./classes directory
#
# The default is to make all .class files.
#
#    clean    -- removes all generated files
#
#    test     -- Tests proj1 by running P1.class
#
###

SRC = ./src
CLASSPATH = ./class
VPATH = $(CLASSPATH)
JCFLAGS = -Xlint:all -deprecation -classpath $(CLASSPATH) -d $(CLASSPATH)
JFLAGS = -classpath $(CLASSPATH)
TESTIN = tests.in
TESTOUT = tests.out
TESTEXPECTED = tests.expected 

all : $(CLASSPATH) P1.class EmptySTException.class SymbolTable.class \
		TestSym.class Symb.class DuplicateException.class \
		NameScope.class

$(CLASSPATH):
	mkdir -p $(CLASSPATH)

P1.class : EmptySTException.class SymbolTable.class \
		TestSym.class Symb.class DuplicateException.class

NameScope.class : Symb.class DuplicateException.class

TestSym.class : Symb.class

SymbolTable.class : EmptySTException.class NameScope.class \
		Symb.class DuplicateException.class

%.class: $(SRC)/%.java
	javac $(JCFLAGS) $<

###
# test
###

test: P1.class
	java $(JFLAGS) P1 < $(TESTIN) > $(TESTOUT); \
		diff $(TESTOUT) $(TESTEXPECTED)

test-interactive: P1.class
	java $(JFLAGS) P1

###
# style check
###

style:
	../pmd/bin/run.sh pmd -dir src -f text -rulesets java-basic,java-design,java-codesize,java-typeresolution,java-unusedcode

###
# lint check
###

lint: all
	jlint +all classes

###
# clean
###

clean: 
	rm -f $(CLASSPATH)/*.class
	rm tests.out

