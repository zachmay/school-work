class "BARF" 392 ~392 test {
   ## sample test prog for proj #2 (scanner) --
   may not parse,  type-check or execute
   correctly ##+

// String Literal Tests
"ninja" "ni\nja"    "ni\"ja" "ni/\\/ja" ""
'a' '0' '6' '\n' '\\' '\t' '\'' ' '  ''
int i = 0 ## init to 0##;
int j = ~123;
int bigPos = 11111111111111111111111111111111111111;
int bigNeg = ~2222222222222222222222222222222222222;
bool ja = true;
bool nein = false;
char c = 'c';
char nl = '\n';
char tab = '\t';
char bslash = '\\';
char tic = '\'';
CONST ten = 10;
int ar[100];

void p(INT j) {##
	##print("Ans = ", j+1, "\n");
}

int f(int i){
        ar[i] = 100;
	ReturN i+1;
}

read(b);

if (b || true)
	b = b && false;
else	b = !(b || true);

L: while (i != 0) {
	i = i*i/2; break L;
	i = i/(i-2); continue L
}

if (i == 10 || i < 21 || i > ~17 || i != 123) {
	Print( i);
	p(17);
}

if (i >= f(~3) || i <= f(i-1))
	print( i , f(i) , "\n");

} // That's all folks

^%'a'@$

String s = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
