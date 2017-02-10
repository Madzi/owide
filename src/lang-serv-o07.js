import LangServ from './lang-serv';

const LX_END = 'END';

export class LangServO07 extends LangServ {
    isAlpha (ch) {
        return /[a-zA-Z_]/.test(ch);
    }
    isDigit (ch) {
        return /[0-9]/.test(ch);
    }
    isAlphaOrDigit (ch) {
        return this.isAlpha(ch) || this.isDigit(ch);
    }
    getMode () {
        return (cfg, parse) => {
            return {
                startState: function (cfg) {
                    return {
                        scope: 0,
                        mode: 'runtime',
                        token: null,
                        tokens: []
                    };
                },
                ident: function (state, textAfter) {
                    var words = textAfter && textAfter.split(' ');
                    if (words[0] == LX_END && state.scope > 0) { --state.scope; }
                    return state.scope;
                },
                token: function () {
                }
            };
        };
    }
}

/*
10.2. Predefined procedures
The following table lists the predefined procedures. Some are generic procedures, i.e. they apply
to several types of operands. v stands for a variable, x and n for expressions, and T for a type.
Function procedures:
Name Argument type Result type Function
ABS(x) x: numeric type type of x absolute value
ODD(x) x: INTEGER BOOLEAN x MOD 2 = 1
LEN(v) v: array INTEGER the length of v
LSL(x, n) x, n: INTEGER INTEGER logical shift left, x * 2n
ASR(x, n) x, n: INTEGER INTEGER signed shift right, x DIV 2n
ROR(x, n) x, n: INTEGER INTEGER x rotated right by n bits
Type conversion functions:
Name Argument type Result type Function
FLOOR(x) REAL INTEGER round down
FLT(x) INTEGER REAL identity
ORD(x) CHAR, BOOLEAN, SET INTEGER ordinal number of x
CHR(x) INTEGER CHAR character with ordinal number x
Proper procedures:
Name Argument types Function
INC(v) INTEGER v := v + 1
INC(v, n) INTEGER v := v + n
DEC(v) INTEGER v := v - 1
DEC(v, n) INTEGER v := v - n
INCL(v, x) v: SET; x: INTEGER v := v + {x}
EXCL(v, x) v: SET; x: INTEGER v := v - {x} 
NEW(v) pointer type allocate v^
ASSERT(b) BOOLEAN abort, if ~b
PACK(x, n) REAL; INTEGER pack x and n into x
UNPK(x, n) REAL; INTEGER unpack x into x and n
The function FLOOR(x) yields the largest integer not greater than x.
FLOOR(1.5) = 1 FLOOR(-1.5) = -2
The parameter n of PACK represents the exponent of x. PACK(x, y) is equivalent to x := x * 2y.
UNPK is the reverse operation. The resulting x is normalized, such that 1.0 <= x < 2.0. 

SYSYEM:
Function procedures:
Name Argument types Result type Function
ADR(v) any INTEGER address of variable v
SIZE(T) any type INTEGER size in bytes
BIT(a, n) a, n: INTEGER BOOLEAN bit n of mem[a]
Proper procedures:
Name Argument types Function
GET(a, v) a: INTEGER; v: any basic type v := mem[a]
PUT(a, x) a: INTEGER; x: any basic type mem[a] := x
COPY(src, dst, n) all INTEGER copy n consecutive words from src to dst
The following are additional procedures accepted by the compiler for the RISC processor:
Function procedures:
Name Argument types Result type Function
VAL(T, n) scalar T identity
ADC(m, n) INTEGER INTEGER add with carry C
SBC(m, n) INTEGER INTEGER subtract with carry C
UML(m, n) INTEGER INTEGER unsigned multiplication
COND(n) INTEGER BOOLEAN IF Cond(n) THEN ...
Proper procedures:
Name Argument types Function
LED(n) INTEGER display n on LEDs

letter = "A" | "B" | … | "Z" | "a" | "b" | … | "z".
digit = "0" | "1" | "2" | "3" | "4" | "5" | "6" | "7" | "8" | "9".
hexDigit = digit | "A" | "B" | "C" | "D" | "E" | "F".
ident = letter {letter | digit}.
qualident = [ident "."] ident.
identdef = ident ["*"].
integer = digit {digit} | digit {hexDigit} "H".
real = digit {digit} "." {digit} [ScaleFactor].
ScaleFactor = "E" ["+" | "-"] digit {digit}.
number = integer | real.
string = """ {character} """ | digit {hexDigit} "X".
ConstDeclaration = identdef "=" ConstExpression.
ConstExpression = expression.
TypeDeclaration = identdef "=" type.
type = qualident | ArrayType | RecordType | PointerType | ProcedureType.
ArrayType = ARRAY length {"," length} OF type.
length = ConstExpression.
RecordType = RECORD ["(" BaseType ")"] [FieldListSequence] END.
BaseType = qualident.
FieldListSequence = FieldList {";" FieldList}.
FieldList = IdentList ":" type.
IdentList = identdef {"," identdef}.
PointerType = POINTER TO type.
ProcedureType = PROCEDURE [FormalParameters].
VariableDeclaration = IdentList ":" type.
expression = SimpleExpression [relation SimpleExpression].
relation = "=" | "#" | "<" | "<=" | ">" | ">=" | IN | IS.
SimpleExpression = ["+" | "-"] term {AddOperator term}.
AddOperator = "+" | "-" | OR.
term = factor {MulOperator factor}.
MulOperator = "*" | "/" | DIV | MOD | "&".
factor = number | string | NIL | TRUE | FALSE |
 set | designator [ActualParameters] | "(" expression ")" | "~" factor.
designator = qualident {selector}.
selector = "." ident | "[" ExpList "]" | "^" | "(" qualident ")".
set = "{" [element {"," element}] "}".
element = expression [".." expression].
ExpList = expression {"," expression}.
ActualParameters = "(" [ExpList] ")" .
statement = [assignment | ProcedureCall | IfStatement | CaseStatement |
 WhileStatement | RepeatStatement | ForStatement].
assignment = designator ":=" expression.
ProcedureCall = designator [ActualParameters].
StatementSequence = statement {";" statement}.
IfStatement = IF expression THEN StatementSequence
 {ELSIF expression THEN StatementSequence}
 [ELSE StatementSequence] END. 
17
CaseStatement = CASE expression OF case {"|" case} END.
case = [CaseLabelList ":" StatementSequence].
CaseLabelList = LabelRange {"," LabelRange}.
LabelRange = label [".." label].
label = integer | string | qualident.
WhileStatement = WHILE expression DO StatementSequence
{ELSIF expression DO StatementSequence} END.
RepeatStatement = REPEAT StatementSequence UNTIL expression.
ForStatement = FOR ident ":=" expression TO expression [BY ConstExpression]
DO StatementSequence END.
ProcedureDeclaration = ProcedureHeading ";" ProcedureBody ident.
ProcedureHeading = PROCEDURE identdef [FormalParameters].
ProcedureBody = DeclarationSequence [BEGIN StatementSequence]
 [RETURN expression] END.
DeclarationSequence = [CONST {ConstDeclaration ";"}]
 [TYPE {TypeDeclaration ";"}]
 [VAR {VariableDeclaration ";"}]
 {ProcedureDeclaration ";"}.
FormalParameters = "(" [FPSection {";" FPSection}] ")" [":" qualident].
FPSection = [VAR] ident {"," ident} ":" FormalType.
FormalType = {ARRAY OF} qualident.
module = MODULE ident ";" [ImportList] DeclarationSequence
 [BEGIN StatementSequence] END ident "." .
ImportList = IMPORT import {"," import} ";".
import = ident [":=" ident]. 
*/