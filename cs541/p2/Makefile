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

SRC = ./src
CLASSPATH = ./class
VPATH = $(CLASSPATH)
JCFLAGS = -Xlint:all -deprecation -classpath $(CLASSPATH) -d $(CLASSPATH)
JFLAGS = -classpath $(CLASSPATH)
JFLEX = ../jflex/bin/jflex
JFLEXFLAGS = -d $(SRC)

$(CLASSPATH)/P2.class : $(SRC)/P2.java $(CLASSPATH)/Yylex.class

$(CLASSPATH)/Symbol.class: $(SRC)/Symbol.java $(CLASSPATH)/SymbolTypes.class \
$(CLASSPATH)/CSXToken.class \
$(CLASSPATH)/CSXStringLitToken.class \
$(CLASSPATH)/CSXCharLitToken.class \
$(CLASSPATH)/CSXIdentifierToken.class \
$(CLASSPATH)/CSXIntLitToken.class \
$(CLASSPATH)/CSXErrorToken.class 
	javac $(JCFLAGS) $<

$(CLASSPATH)/CSXToken.class: $(SRC)/CSXToken.java
	javac $(JCFLAGS) $<

$(CLASSPATH)/%Token.class: $(SRC)/%Token.java $(CLASSPATH)/CSXToken.class
	javac $(JCFLAGS) $<

$(CLASSPATH)/Pos.class: $(SRC)/Pos.java
	javac $(JCFLAGS) $<

$(CLASSPATH)/Yylex.class: $(SRC)/Yylex.java $(CLASSPATH)/Symbol.class $(CLASSPATH)/Pos.class
	javac $(JCFLAGS) $<

$(CLASSPATH)/%.class: $(SRC)/%.java $(CLASSPATH)/Pos.class
	javac $(JCFLAGS) $<


all : $(CLASSPATH)/P2.class $(CLASSPATH)/SymbolTypes.class $(CLASSPATH)/Yylex.class 

$(CLASSPATH)/SymbolTypes.class: $(SRC)/SymbolTypes.java
$(CLASSPATH)/Yylex.class: $(CLASSPATH)/SymbolTypes.class
$(SRC)/Yylex.java: csx.jlex
	rm -f $(SRC)/Yylex.java
	$(JFLEX) $(JFLEXFLAGS) csx.jlex

###
# test
###

test:   $(CLASSPATH)/P2.class $(CLASSPATH)/Yylex.class tiny.csx
	java $(JFLAGS) P2 test.csx

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
	rm -f $(CLASSPATH)/*.class $(SRC)/Yylex.java

