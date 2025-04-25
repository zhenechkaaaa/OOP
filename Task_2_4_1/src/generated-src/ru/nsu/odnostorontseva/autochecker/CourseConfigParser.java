// Generated from ru/nsu/odnostorontseva/autochecker/CourseConfig.g4 by ANTLR 4.13.1

    package ru.nsu.odnostorontseva.autochecker;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class CourseConfigParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, GRADE=24, 
		ID=25, STRING=26, NUMBER=27, BOOLEAN=28, WS=29, COMMENT=30, LINE_COMMENT=31;
	public static final int
		RULE_config = 0, RULE_statement = 1, RULE_taskDef = 2, RULE_groupDef = 3, 
		RULE_studentDef = 4, RULE_assignmentDef = 5, RULE_assignEntry = 6, RULE_checkpointDef = 7, 
		RULE_settingsBlock = 8, RULE_setting = 9, RULE_gradingCriteria = 10, RULE_gradeThreshold = 11, 
		RULE_behaviorStrategy = 12, RULE_otherSetting = 13, RULE_importStatement = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"config", "statement", "taskDef", "groupDef", "studentDef", "assignmentDef", 
			"assignEntry", "checkpointDef", "settingsBlock", "setting", "gradingCriteria", 
			"gradeThreshold", "behaviorStrategy", "otherSetting", "importStatement"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'task'", "'{'", "'title'", "'max'", "'softDeadline'", "'hardDeadline'", 
			"'}'", "'group'", "'student'", "'name'", "'github'", "'repo'", "'assignment'", 
			"'to'", "','", "';'", "'checkpoint'", "'date'", "'settings'", "'grading'", 
			"':'", "'strategy'", "'import'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"GRADE", "ID", "STRING", "NUMBER", "BOOLEAN", "WS", "COMMENT", "LINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "CourseConfig.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CourseConfigParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConfigContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(CourseConfigParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ConfigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_config; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CourseConfigListener ) ((CourseConfigListener)listener).enterConfig(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CourseConfigListener ) ((CourseConfigListener)listener).exitConfig(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CourseConfigVisitor ) return ((CourseConfigVisitor<? extends T>)visitor).visitConfig(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConfigContext config() throws RecognitionException {
		ConfigContext _localctx = new ConfigContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_config);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 9052418L) != 0)) {
				{
				{
				setState(30);
				statement();
				}
				}
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(36);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public TaskDefContext taskDef() {
			return getRuleContext(TaskDefContext.class,0);
		}
		public GroupDefContext groupDef() {
			return getRuleContext(GroupDefContext.class,0);
		}
		public AssignmentDefContext assignmentDef() {
			return getRuleContext(AssignmentDefContext.class,0);
		}
		public CheckpointDefContext checkpointDef() {
			return getRuleContext(CheckpointDefContext.class,0);
		}
		public SettingsBlockContext settingsBlock() {
			return getRuleContext(SettingsBlockContext.class,0);
		}
		public ImportStatementContext importStatement() {
			return getRuleContext(ImportStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CourseConfigListener ) ((CourseConfigListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CourseConfigListener ) ((CourseConfigListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CourseConfigVisitor ) return ((CourseConfigVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(44);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				taskDef();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				groupDef();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 3);
				{
				setState(40);
				assignmentDef();
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 4);
				{
				setState(41);
				checkpointDef();
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 5);
				{
				setState(42);
				settingsBlock();
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 6);
				{
				setState(43);
				importStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TaskDefContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CourseConfigParser.ID, 0); }
		public List<TerminalNode> STRING() { return getTokens(CourseConfigParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(CourseConfigParser.STRING, i);
		}
		public TerminalNode NUMBER() { return getToken(CourseConfigParser.NUMBER, 0); }
		public TaskDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_taskDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CourseConfigListener ) ((CourseConfigListener)listener).enterTaskDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CourseConfigListener ) ((CourseConfigListener)listener).exitTaskDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CourseConfigVisitor ) return ((CourseConfigVisitor<? extends T>)visitor).visitTaskDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TaskDefContext taskDef() throws RecognitionException {
		TaskDefContext _localctx = new TaskDefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_taskDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(T__0);
			setState(47);
			match(ID);
			setState(48);
			match(T__1);
			setState(49);
			match(T__2);
			setState(50);
			match(STRING);
			setState(51);
			match(T__3);
			setState(52);
			match(NUMBER);
			setState(53);
			match(T__4);
			setState(54);
			match(STRING);
			setState(55);
			match(T__5);
			setState(56);
			match(STRING);
			setState(57);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GroupDefContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CourseConfigParser.ID, 0); }
		public List<StudentDefContext> studentDef() {
			return getRuleContexts(StudentDefContext.class);
		}
		public StudentDefContext studentDef(int i) {
			return getRuleContext(StudentDefContext.class,i);
		}
		public GroupDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CourseConfigListener ) ((CourseConfigListener)listener).enterGroupDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CourseConfigListener ) ((CourseConfigListener)listener).exitGroupDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CourseConfigVisitor ) return ((CourseConfigVisitor<? extends T>)visitor).visitGroupDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupDefContext groupDef() throws RecognitionException {
		GroupDefContext _localctx = new GroupDefContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_groupDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(T__7);
			setState(60);
			match(ID);
			setState(61);
			match(T__1);
			setState(63); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(62);
				studentDef();
				}
				}
				setState(65); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__8 );
			setState(67);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StudentDefContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CourseConfigParser.ID, 0); }
		public List<TerminalNode> STRING() { return getTokens(CourseConfigParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(CourseConfigParser.STRING, i);
		}
		public StudentDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_studentDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CourseConfigListener ) ((CourseConfigListener)listener).enterStudentDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CourseConfigListener ) ((CourseConfigListener)listener).exitStudentDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CourseConfigVisitor ) return ((CourseConfigVisitor<? extends T>)visitor).visitStudentDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StudentDefContext studentDef() throws RecognitionException {
		StudentDefContext _localctx = new StudentDefContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_studentDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(T__8);
			setState(70);
			match(ID);
			setState(71);
			match(T__1);
			setState(72);
			match(T__9);
			setState(73);
			match(STRING);
			setState(74);
			match(T__10);
			setState(75);
			match(STRING);
			setState(76);
			match(T__11);
			setState(77);
			match(STRING);
			setState(78);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentDefContext extends ParserRuleContext {
		public List<AssignEntryContext> assignEntry() {
			return getRuleContexts(AssignEntryContext.class);
		}
		public AssignEntryContext assignEntry(int i) {
			return getRuleContext(AssignEntryContext.class,i);
		}
		public AssignmentDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CourseConfigListener ) ((CourseConfigListener)listener).enterAssignmentDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CourseConfigListener ) ((CourseConfigListener)listener).exitAssignmentDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CourseConfigVisitor ) return ((CourseConfigVisitor<? extends T>)visitor).visitAssignmentDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentDefContext assignmentDef() throws RecognitionException {
		AssignmentDefContext _localctx = new AssignmentDefContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assignmentDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(T__12);
			setState(81);
			match(T__1);
			setState(83); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(82);
				assignEntry();
				}
				}
				setState(85); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
			setState(87);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignEntryContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(CourseConfigParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CourseConfigParser.ID, i);
		}
		public AssignEntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignEntry; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CourseConfigListener ) ((CourseConfigListener)listener).enterAssignEntry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CourseConfigListener ) ((CourseConfigListener)listener).exitAssignEntry(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CourseConfigVisitor ) return ((CourseConfigVisitor<? extends T>)visitor).visitAssignEntry(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignEntryContext assignEntry() throws RecognitionException {
		AssignEntryContext _localctx = new AssignEntryContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assignEntry);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(T__0);
			setState(90);
			match(ID);
			setState(91);
			match(T__13);
			setState(92);
			match(ID);
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(93);
				match(T__14);
				setState(94);
				match(ID);
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(100);
			match(T__15);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CheckpointDefContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CourseConfigParser.ID, 0); }
		public TerminalNode STRING() { return getToken(CourseConfigParser.STRING, 0); }
		public CheckpointDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_checkpointDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CourseConfigListener ) ((CourseConfigListener)listener).enterCheckpointDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CourseConfigListener ) ((CourseConfigListener)listener).exitCheckpointDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CourseConfigVisitor ) return ((CourseConfigVisitor<? extends T>)visitor).visitCheckpointDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CheckpointDefContext checkpointDef() throws RecognitionException {
		CheckpointDefContext _localctx = new CheckpointDefContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_checkpointDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(T__16);
			setState(103);
			match(ID);
			setState(104);
			match(T__1);
			setState(105);
			match(T__17);
			setState(106);
			match(STRING);
			setState(107);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SettingsBlockContext extends ParserRuleContext {
		public List<SettingContext> setting() {
			return getRuleContexts(SettingContext.class);
		}
		public SettingContext setting(int i) {
			return getRuleContext(SettingContext.class,i);
		}
		public SettingsBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_settingsBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CourseConfigListener ) ((CourseConfigListener)listener).enterSettingsBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CourseConfigListener ) ((CourseConfigListener)listener).exitSettingsBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CourseConfigVisitor ) return ((CourseConfigVisitor<? extends T>)visitor).visitSettingsBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SettingsBlockContext settingsBlock() throws RecognitionException {
		SettingsBlockContext _localctx = new SettingsBlockContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_settingsBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(T__18);
			setState(110);
			match(T__1);
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 38797312L) != 0)) {
				{
				{
				setState(111);
				setting();
				}
				}
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(117);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SettingContext extends ParserRuleContext {
		public GradingCriteriaContext gradingCriteria() {
			return getRuleContext(GradingCriteriaContext.class,0);
		}
		public BehaviorStrategyContext behaviorStrategy() {
			return getRuleContext(BehaviorStrategyContext.class,0);
		}
		public OtherSettingContext otherSetting() {
			return getRuleContext(OtherSettingContext.class,0);
		}
		public SettingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setting; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CourseConfigListener ) ((CourseConfigListener)listener).enterSetting(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CourseConfigListener ) ((CourseConfigListener)listener).exitSetting(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CourseConfigVisitor ) return ((CourseConfigVisitor<? extends T>)visitor).visitSetting(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SettingContext setting() throws RecognitionException {
		SettingContext _localctx = new SettingContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_setting);
		try {
			setState(122);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__19:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				gradingCriteria();
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				behaviorStrategy();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(121);
				otherSetting();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GradingCriteriaContext extends ParserRuleContext {
		public List<GradeThresholdContext> gradeThreshold() {
			return getRuleContexts(GradeThresholdContext.class);
		}
		public GradeThresholdContext gradeThreshold(int i) {
			return getRuleContext(GradeThresholdContext.class,i);
		}
		public GradingCriteriaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gradingCriteria; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CourseConfigListener ) ((CourseConfigListener)listener).enterGradingCriteria(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CourseConfigListener ) ((CourseConfigListener)listener).exitGradingCriteria(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CourseConfigVisitor ) return ((CourseConfigVisitor<? extends T>)visitor).visitGradingCriteria(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GradingCriteriaContext gradingCriteria() throws RecognitionException {
		GradingCriteriaContext _localctx = new GradingCriteriaContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_gradingCriteria);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(T__19);
			setState(125);
			match(T__1);
			setState(127); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(126);
				gradeThreshold();
				}
				}
				setState(129); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==GRADE );
			setState(131);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GradeThresholdContext extends ParserRuleContext {
		public TerminalNode GRADE() { return getToken(CourseConfigParser.GRADE, 0); }
		public TerminalNode NUMBER() { return getToken(CourseConfigParser.NUMBER, 0); }
		public GradeThresholdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gradeThreshold; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CourseConfigListener ) ((CourseConfigListener)listener).enterGradeThreshold(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CourseConfigListener ) ((CourseConfigListener)listener).exitGradeThreshold(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CourseConfigVisitor ) return ((CourseConfigVisitor<? extends T>)visitor).visitGradeThreshold(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GradeThresholdContext gradeThreshold() throws RecognitionException {
		GradeThresholdContext _localctx = new GradeThresholdContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_gradeThreshold);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(GRADE);
			setState(134);
			match(T__20);
			setState(135);
			match(NUMBER);
			setState(136);
			match(T__15);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BehaviorStrategyContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(CourseConfigParser.STRING, 0); }
		public BehaviorStrategyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_behaviorStrategy; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CourseConfigListener ) ((CourseConfigListener)listener).enterBehaviorStrategy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CourseConfigListener ) ((CourseConfigListener)listener).exitBehaviorStrategy(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CourseConfigVisitor ) return ((CourseConfigVisitor<? extends T>)visitor).visitBehaviorStrategy(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BehaviorStrategyContext behaviorStrategy() throws RecognitionException {
		BehaviorStrategyContext _localctx = new BehaviorStrategyContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_behaviorStrategy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(T__21);
			setState(139);
			match(STRING);
			setState(140);
			match(T__15);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OtherSettingContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CourseConfigParser.ID, 0); }
		public TerminalNode STRING() { return getToken(CourseConfigParser.STRING, 0); }
		public TerminalNode NUMBER() { return getToken(CourseConfigParser.NUMBER, 0); }
		public TerminalNode BOOLEAN() { return getToken(CourseConfigParser.BOOLEAN, 0); }
		public OtherSettingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_otherSetting; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CourseConfigListener ) ((CourseConfigListener)listener).enterOtherSetting(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CourseConfigListener ) ((CourseConfigListener)listener).exitOtherSetting(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CourseConfigVisitor ) return ((CourseConfigVisitor<? extends T>)visitor).visitOtherSetting(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OtherSettingContext otherSetting() throws RecognitionException {
		OtherSettingContext _localctx = new OtherSettingContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_otherSetting);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(ID);
			setState(143);
			match(T__20);
			setState(144);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 469762048L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(145);
			match(T__15);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportStatementContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(CourseConfigParser.STRING, 0); }
		public ImportStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CourseConfigListener ) ((CourseConfigListener)listener).enterImportStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CourseConfigListener ) ((CourseConfigListener)listener).exitImportStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CourseConfigVisitor ) return ((CourseConfigVisitor<? extends T>)visitor).visitImportStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportStatementContext importStatement() throws RecognitionException {
		ImportStatementContext _localctx = new ImportStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_importStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(T__22);
			setState(148);
			match(STRING);
			setState(149);
			match(T__15);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001f\u0098\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0005"+
		"\u0000 \b\u0000\n\u0000\f\u0000#\t\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001-\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0004\u0003@\b\u0003\u000b\u0003\f\u0003A\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0004\u0005T\b\u0005\u000b\u0005\f\u0005U\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0005\u0006`\b\u0006\n\u0006\f\u0006c\t\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0005\bq\b\b\n"+
		"\b\f\bt\t\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0003\t{\b\t\u0001"+
		"\n\u0001\n\u0001\n\u0004\n\u0080\b\n\u000b\n\f\n\u0081\u0001\n\u0001\n"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0000\u0000\u000f\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u0000\u0001\u0001\u0000\u001a\u001c\u0095\u0000!\u0001\u0000\u0000\u0000"+
		"\u0002,\u0001\u0000\u0000\u0000\u0004.\u0001\u0000\u0000\u0000\u0006;"+
		"\u0001\u0000\u0000\u0000\bE\u0001\u0000\u0000\u0000\nP\u0001\u0000\u0000"+
		"\u0000\fY\u0001\u0000\u0000\u0000\u000ef\u0001\u0000\u0000\u0000\u0010"+
		"m\u0001\u0000\u0000\u0000\u0012z\u0001\u0000\u0000\u0000\u0014|\u0001"+
		"\u0000\u0000\u0000\u0016\u0085\u0001\u0000\u0000\u0000\u0018\u008a\u0001"+
		"\u0000\u0000\u0000\u001a\u008e\u0001\u0000\u0000\u0000\u001c\u0093\u0001"+
		"\u0000\u0000\u0000\u001e \u0003\u0002\u0001\u0000\u001f\u001e\u0001\u0000"+
		"\u0000\u0000 #\u0001\u0000\u0000\u0000!\u001f\u0001\u0000\u0000\u0000"+
		"!\"\u0001\u0000\u0000\u0000\"$\u0001\u0000\u0000\u0000#!\u0001\u0000\u0000"+
		"\u0000$%\u0005\u0000\u0000\u0001%\u0001\u0001\u0000\u0000\u0000&-\u0003"+
		"\u0004\u0002\u0000\'-\u0003\u0006\u0003\u0000(-\u0003\n\u0005\u0000)-"+
		"\u0003\u000e\u0007\u0000*-\u0003\u0010\b\u0000+-\u0003\u001c\u000e\u0000"+
		",&\u0001\u0000\u0000\u0000,\'\u0001\u0000\u0000\u0000,(\u0001\u0000\u0000"+
		"\u0000,)\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000,+\u0001\u0000"+
		"\u0000\u0000-\u0003\u0001\u0000\u0000\u0000./\u0005\u0001\u0000\u0000"+
		"/0\u0005\u0019\u0000\u000001\u0005\u0002\u0000\u000012\u0005\u0003\u0000"+
		"\u000023\u0005\u001a\u0000\u000034\u0005\u0004\u0000\u000045\u0005\u001b"+
		"\u0000\u000056\u0005\u0005\u0000\u000067\u0005\u001a\u0000\u000078\u0005"+
		"\u0006\u0000\u000089\u0005\u001a\u0000\u00009:\u0005\u0007\u0000\u0000"+
		":\u0005\u0001\u0000\u0000\u0000;<\u0005\b\u0000\u0000<=\u0005\u0019\u0000"+
		"\u0000=?\u0005\u0002\u0000\u0000>@\u0003\b\u0004\u0000?>\u0001\u0000\u0000"+
		"\u0000@A\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000AB\u0001\u0000"+
		"\u0000\u0000BC\u0001\u0000\u0000\u0000CD\u0005\u0007\u0000\u0000D\u0007"+
		"\u0001\u0000\u0000\u0000EF\u0005\t\u0000\u0000FG\u0005\u0019\u0000\u0000"+
		"GH\u0005\u0002\u0000\u0000HI\u0005\n\u0000\u0000IJ\u0005\u001a\u0000\u0000"+
		"JK\u0005\u000b\u0000\u0000KL\u0005\u001a\u0000\u0000LM\u0005\f\u0000\u0000"+
		"MN\u0005\u001a\u0000\u0000NO\u0005\u0007\u0000\u0000O\t\u0001\u0000\u0000"+
		"\u0000PQ\u0005\r\u0000\u0000QS\u0005\u0002\u0000\u0000RT\u0003\f\u0006"+
		"\u0000SR\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000US\u0001\u0000"+
		"\u0000\u0000UV\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WX\u0005"+
		"\u0007\u0000\u0000X\u000b\u0001\u0000\u0000\u0000YZ\u0005\u0001\u0000"+
		"\u0000Z[\u0005\u0019\u0000\u0000[\\\u0005\u000e\u0000\u0000\\a\u0005\u0019"+
		"\u0000\u0000]^\u0005\u000f\u0000\u0000^`\u0005\u0019\u0000\u0000_]\u0001"+
		"\u0000\u0000\u0000`c\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000"+
		"ab\u0001\u0000\u0000\u0000bd\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000"+
		"\u0000de\u0005\u0010\u0000\u0000e\r\u0001\u0000\u0000\u0000fg\u0005\u0011"+
		"\u0000\u0000gh\u0005\u0019\u0000\u0000hi\u0005\u0002\u0000\u0000ij\u0005"+
		"\u0012\u0000\u0000jk\u0005\u001a\u0000\u0000kl\u0005\u0007\u0000\u0000"+
		"l\u000f\u0001\u0000\u0000\u0000mn\u0005\u0013\u0000\u0000nr\u0005\u0002"+
		"\u0000\u0000oq\u0003\u0012\t\u0000po\u0001\u0000\u0000\u0000qt\u0001\u0000"+
		"\u0000\u0000rp\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000su\u0001"+
		"\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000uv\u0005\u0007\u0000\u0000"+
		"v\u0011\u0001\u0000\u0000\u0000w{\u0003\u0014\n\u0000x{\u0003\u0018\f"+
		"\u0000y{\u0003\u001a\r\u0000zw\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000"+
		"\u0000zy\u0001\u0000\u0000\u0000{\u0013\u0001\u0000\u0000\u0000|}\u0005"+
		"\u0014\u0000\u0000}\u007f\u0005\u0002\u0000\u0000~\u0080\u0003\u0016\u000b"+
		"\u0000\u007f~\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000"+
		"\u0081\u007f\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000"+
		"\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0084\u0005\u0007\u0000\u0000"+
		"\u0084\u0015\u0001\u0000\u0000\u0000\u0085\u0086\u0005\u0018\u0000\u0000"+
		"\u0086\u0087\u0005\u0015\u0000\u0000\u0087\u0088\u0005\u001b\u0000\u0000"+
		"\u0088\u0089\u0005\u0010\u0000\u0000\u0089\u0017\u0001\u0000\u0000\u0000"+
		"\u008a\u008b\u0005\u0016\u0000\u0000\u008b\u008c\u0005\u001a\u0000\u0000"+
		"\u008c\u008d\u0005\u0010\u0000\u0000\u008d\u0019\u0001\u0000\u0000\u0000"+
		"\u008e\u008f\u0005\u0019\u0000\u0000\u008f\u0090\u0005\u0015\u0000\u0000"+
		"\u0090\u0091\u0007\u0000\u0000\u0000\u0091\u0092\u0005\u0010\u0000\u0000"+
		"\u0092\u001b\u0001\u0000\u0000\u0000\u0093\u0094\u0005\u0017\u0000\u0000"+
		"\u0094\u0095\u0005\u001a\u0000\u0000\u0095\u0096\u0005\u0010\u0000\u0000"+
		"\u0096\u001d\u0001\u0000\u0000\u0000\b!,AUarz\u0081";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}