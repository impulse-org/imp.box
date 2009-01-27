-- Copyright (c) 2008 IBM Corporation.
-- All rights reserved. This program and the accompanying materials
-- are made available under the terms of the Eclipse Public License v1.0
-- which accompanies this distribution, and is available at
-- http://www.eclipse.org/legal/epl-v10.html
--
-- Contributors:
--    Jurgen Vinju (jurgen@vinju.org) - initial API and implementation

%options package=org.eclipse.imp.box.parser
%options template=dtParserTemplateF.gi
%options import_terminals=BoxLexer.gi
%options parent_saved,automatic_ast=toplevel,visitor=preorder,ast_directory=./Ast,ast_type=ASTNode

%Globals
    /.import org.eclipse.imp.parser.IParser;
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
                 
   SpaceOption ::= SpaceSymbol '=' SpaceValue
   
   SpaceValue  ::= NUMBER
                 | IDENT
   
   GroupOptionList$$GroupOption ::= %Empty
                                 | GroupOptionList GroupOption
                                 
   GroupOption ::= 'op' '='  BoxOperator
                 | 'gs' '=' NUMBER
                 
                                              
%End

%Headers
        
