%options package=org.eclipse.imp.box.parser
%options template=dtParserTemplate.gi
%options import_terminals=BoxLexer.gi
%options parent_saved,automatic_ast=toplevel,visitor=preorder,ast_directory=./Ast,ast_type=ASTNode
--
-- This is just a sample grammar and not a real grammar for Box
-- 

%Globals
    /.import org.eclipse.imp.parser.IParser;
    import java.util.Hashtable;
    import java.util.Stack;
    ./
%End



%Define
    $ast_class /.Object./
    $additional_interfaces /., IParser./
%End

%Terminals
         NUMBER
         RIGHTBRACKET ::= ']'
         LEFTBRACKET ::= '['
         EQUAL ::= '='
%End

%Start
    Box
%End

%Recover
%End

%Rules

   Box ::= STRING
         | BoxOperator '[' BoxList ']'
         
   BoxOperator ::=
         | 'H' SpaceOptionList
         | 'V' SpaceOptionList 
         | 'HV'  SpaceOptionList 
         | 'HOV' SpaceOptionList 
         | 'I' SpaceOptionList 
         | 'G' GroupOptionList
         | 'WD'

   BoxList$$Box ::= %Empty
                | BoxList Box
                
   SpaceOptionList$$SpaceOption ::= %Empty
                                 | SpaceOptionList SpaceOption
    
   SpaceSymbol ::= 'vs'
                 | 'hs'
                 | 'is'
                 | 'ts'
                 
   SpaceOption ::= SpaceSymbol '=' NUMBER
   
   GroupOptionList$$GroupOption ::= %Empty
                                 | GroupOptionList GroupOption
                                 
   GroupOption ::= 'op' '='  BoxOperator
                 | 'gs' '=' NUMBER
                 
                                              
%End

%Headers
        
