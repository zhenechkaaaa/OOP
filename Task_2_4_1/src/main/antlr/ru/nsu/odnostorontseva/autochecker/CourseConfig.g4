grammar CourseConfig;

@header {
    package ru.nsu.odnostorontseva.autochecker;
}

config        : statement* EOF ;
statement     : taskDef
              | groupDef
              | assignmentDef
              | checkpointDef
              | settingsBlock
              | importStatement ;

// 1) Task definitions
taskDef       : 'task' ID '{'
                   'title' STRING
                   'max' NUMBER
                   'softDeadline' STRING
                   'hardDeadline' STRING
               '}' ;

// 2) Group definitions with students
groupDef      : 'group' ID '{' studentDef+ '}' ;
studentDef    : 'student' ID '{'
                   'name' STRING
                   'github' STRING
                   'repo' STRING
               '}' ;

// 3) Task assignments
assignmentDef : 'assignment' '{' assignEntry+ '}' ;
assignEntry   : 'task' ID 'to' ID (',' ID)* ';' ;

// 4) Checkpoints
checkpointDef : 'checkpoint' ID '{'
                   'date' STRING
               '}' ;

// 5) Additional settings
settingsBlock : 'settings' '{' setting* '}' ;
setting       : gradingCriteria
              | behaviorStrategy
              | otherSetting ;

gradingCriteria : 'grading' '{' gradeThreshold+ '}' ;
gradeThreshold  : GRADE ':' NUMBER ';' ;
GRADE           : 'A' | 'B' | 'C' | 'D' | 'E' | 'F' ;

behaviorStrategy: 'strategy' STRING ';' ;
otherSetting    : ID ':' (STRING | NUMBER | BOOLEAN) ';' ;

importStatement : 'import' STRING ';' ;

// Lexer rules
ID            : [a-zA-Z_] [a-zA-Z0-9_]* ;
STRING        : '"' (~["\\] | '\\' .)* '"' ;
NUMBER        : [0-9]+ ;
BOOLEAN       : 'true' | 'false' ;

WS            : [ \t\r\n]+ -> skip ;
COMMENT       : '//' ~[\r\n]* -> skip ;
LINE_COMMENT  : '#' ~[\r\n]* -> skip ;