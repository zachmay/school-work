##########################################
####
# Makefile for project 3
# Modified 2/2011 Raphael Finkel
#
# All classes are compiled into the ./classes directory
#
# The default is to make all .class files.
#
#    clean    -- removes all generated files
#
#    test     -- Tests proj3 by running P3.class with input test.lite
#
###

DESTPATH = ./class
CUPPATH = ../cup/java-cup-10k.jar
CLASSPATH = $(DESTPATH):$(CUPPATH)
JCFLAGS = -Xlint:all -deprecation -classpath $(CLASSPATH) -d $(DESTPATH)
JFLAGS = -classpath $(CLASSPATH)
JFLEX = ../jflex/bin/jflex
JFLEXFLAGS = -d lite/scanner
JCFLAGS = -deprecation -classpath $(CLASSPATH) -d $(DESTPATH) -sourcepath . -Xprefer:source

class/lite/P3.class: lite/P3.java class/lite/parse/Parser.class class/lite/scanner/LiteScanner.class
	javac $(JCFLAGS) $<

# don't use CUP 0.11a; I couldn't get it to work right.  -- Raphael 2/2011
lite/parse/Symbols.java lite/parse/Parser.java: csx.cup 
	java $(JFLAGS) java_cup/Main -package lite.parse -parser Parser -symbols Symbols < csx.cup
	mv Symbols.java lite/parse/Symbols.java
	mv Parser.java lite/parse/Parser.java

class/lite/parse/Parser.class: lite/parse/Parser.java $(DESTPATH) 
	javac $(JCFLAGS) $<

class/lite/ast/%.class: lite/ast/%.java
	javac $(JCFLAGS) $<

class/lite/ast/ArrayDeclarationNode.class: lite/ast/ArrayDeclarationNode.java
	javac $(JCFLAGS) $<	

class/lite/scanner/tokens/%.class: lite/scanner/tokens/%.java
	javac $(JCFLAGS) $<

class/lite/scanner/LiteScanner.class: lite/scanner/LiteScanner.java class/lite/scanner/Yylex.class
	javac $(JCFLAGS) $<

class/lite/scanner/Yylex.class: lite/scanner/Yylex.java
	javac $(JCFLAGS) $<

lite/scanner/Yylex.java: csx.jlex
	rm -f lite/scanner/Yylex.java
	$(JFLEX) $(JFLEXFLAGS) csx.jlex
	# Do some clean-up on the generated Yylex class
	# so that it works from within a package.
	sed -i '' -e's/class Yylex/public class Yylex/' lite/scanner/Yylex.java
	sed -i '' -e's/Yylex(/public Yylex\(/' lite/scanner/Yylex.java

test: class/lite/P3.class
	java $(JFLAGS) lite.P3 test.lite

###
# style check
###

HOW = basic,braces,clone,design,finalizers,migrating,unusedcode,imports,optimizations,strictexception,strings,sunsecure,typeresolution

style: 
	t=`pwd`; cd ~raphael/source/pmd-4.2.5/bin; \
		./pmd.sh $$t text $(HOW)

###
# lint check
###

lint: all
	jlint +all $(DESTPATH)

###
# clean
###

clean: 
	rm -rf $(DESTPATH)/*
	rm -f lite/parse/Symbols.java
	rm -f lite/parse/Parser.java
	rm -f lite/scanner/Yylex.java
