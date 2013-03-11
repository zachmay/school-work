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

JCFLAGS = -deprecation -classpath $(CLASSPATH) -d $(DESTPATH) -sourcepath . -Xprefer:source

%.class: %.java
	javac $(JCFLAGS) $<


# don't use CUP 0.11a; I couldn't get it to work right.  -- Raphael 2/2011
p3/parse/Symbols.java p3/parse/Parser.java: csx.cup 
	java $(JFLAGS) java_cup/Main -package p3.parse -parser Parser -symbols Symbols < csx.cup
	mv Symbols.java p3/parse/Symbols.java
	mv Parser.java p3/parse/Parser.java

class/p3/parse/Parser.class: p3/parse/Parser.java
	javac $(JCFLAGS) $<

class/p3/ast/%.class: p3/ast/%.java
	javac $(JCFLAGS) $<

Yylex.java: lite.jlex
	jflex lite.jlex
parser.class: ASTNode.class Scanner.class
Yylex.class: sym.class 
Scanner.class: Yylex.class
ASTNode.class: ast.java sym.class
	javac $(JCFLAGS) ast.java
P3.class: Yylex.class Scanner.class parser.class ASTNode.class

test: all
	java $(JFLAGS) P3 test.lite

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
	rm -f $(DESTPATH)/*.class Yylex.java* sym.java parser.java
