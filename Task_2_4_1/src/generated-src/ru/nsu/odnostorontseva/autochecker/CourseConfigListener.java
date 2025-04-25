// Generated from ru/nsu/odnostorontseva/autochecker/CourseConfig.g4 by ANTLR 4.13.1

    package ru.nsu.odnostorontseva.autochecker;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CourseConfigParser}.
 */
public interface CourseConfigListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CourseConfigParser#config}.
	 * @param ctx the parse tree
	 */
	void enterConfig(CourseConfigParser.ConfigContext ctx);
	/**
	 * Exit a parse tree produced by {@link CourseConfigParser#config}.
	 * @param ctx the parse tree
	 */
	void exitConfig(CourseConfigParser.ConfigContext ctx);
	/**
	 * Enter a parse tree produced by {@link CourseConfigParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(CourseConfigParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CourseConfigParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(CourseConfigParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CourseConfigParser#taskDef}.
	 * @param ctx the parse tree
	 */
	void enterTaskDef(CourseConfigParser.TaskDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link CourseConfigParser#taskDef}.
	 * @param ctx the parse tree
	 */
	void exitTaskDef(CourseConfigParser.TaskDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link CourseConfigParser#groupDef}.
	 * @param ctx the parse tree
	 */
	void enterGroupDef(CourseConfigParser.GroupDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link CourseConfigParser#groupDef}.
	 * @param ctx the parse tree
	 */
	void exitGroupDef(CourseConfigParser.GroupDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link CourseConfigParser#studentDef}.
	 * @param ctx the parse tree
	 */
	void enterStudentDef(CourseConfigParser.StudentDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link CourseConfigParser#studentDef}.
	 * @param ctx the parse tree
	 */
	void exitStudentDef(CourseConfigParser.StudentDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link CourseConfigParser#assignmentDef}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentDef(CourseConfigParser.AssignmentDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link CourseConfigParser#assignmentDef}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentDef(CourseConfigParser.AssignmentDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link CourseConfigParser#assignEntry}.
	 * @param ctx the parse tree
	 */
	void enterAssignEntry(CourseConfigParser.AssignEntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link CourseConfigParser#assignEntry}.
	 * @param ctx the parse tree
	 */
	void exitAssignEntry(CourseConfigParser.AssignEntryContext ctx);
	/**
	 * Enter a parse tree produced by {@link CourseConfigParser#checkpointDef}.
	 * @param ctx the parse tree
	 */
	void enterCheckpointDef(CourseConfigParser.CheckpointDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link CourseConfigParser#checkpointDef}.
	 * @param ctx the parse tree
	 */
	void exitCheckpointDef(CourseConfigParser.CheckpointDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link CourseConfigParser#settingsBlock}.
	 * @param ctx the parse tree
	 */
	void enterSettingsBlock(CourseConfigParser.SettingsBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CourseConfigParser#settingsBlock}.
	 * @param ctx the parse tree
	 */
	void exitSettingsBlock(CourseConfigParser.SettingsBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CourseConfigParser#setting}.
	 * @param ctx the parse tree
	 */
	void enterSetting(CourseConfigParser.SettingContext ctx);
	/**
	 * Exit a parse tree produced by {@link CourseConfigParser#setting}.
	 * @param ctx the parse tree
	 */
	void exitSetting(CourseConfigParser.SettingContext ctx);
	/**
	 * Enter a parse tree produced by {@link CourseConfigParser#gradingCriteria}.
	 * @param ctx the parse tree
	 */
	void enterGradingCriteria(CourseConfigParser.GradingCriteriaContext ctx);
	/**
	 * Exit a parse tree produced by {@link CourseConfigParser#gradingCriteria}.
	 * @param ctx the parse tree
	 */
	void exitGradingCriteria(CourseConfigParser.GradingCriteriaContext ctx);
	/**
	 * Enter a parse tree produced by {@link CourseConfigParser#gradeThreshold}.
	 * @param ctx the parse tree
	 */
	void enterGradeThreshold(CourseConfigParser.GradeThresholdContext ctx);
	/**
	 * Exit a parse tree produced by {@link CourseConfigParser#gradeThreshold}.
	 * @param ctx the parse tree
	 */
	void exitGradeThreshold(CourseConfigParser.GradeThresholdContext ctx);
	/**
	 * Enter a parse tree produced by {@link CourseConfigParser#behaviorStrategy}.
	 * @param ctx the parse tree
	 */
	void enterBehaviorStrategy(CourseConfigParser.BehaviorStrategyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CourseConfigParser#behaviorStrategy}.
	 * @param ctx the parse tree
	 */
	void exitBehaviorStrategy(CourseConfigParser.BehaviorStrategyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CourseConfigParser#otherSetting}.
	 * @param ctx the parse tree
	 */
	void enterOtherSetting(CourseConfigParser.OtherSettingContext ctx);
	/**
	 * Exit a parse tree produced by {@link CourseConfigParser#otherSetting}.
	 * @param ctx the parse tree
	 */
	void exitOtherSetting(CourseConfigParser.OtherSettingContext ctx);
	/**
	 * Enter a parse tree produced by {@link CourseConfigParser#importStatement}.
	 * @param ctx the parse tree
	 */
	void enterImportStatement(CourseConfigParser.ImportStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CourseConfigParser#importStatement}.
	 * @param ctx the parse tree
	 */
	void exitImportStatement(CourseConfigParser.ImportStatementContext ctx);
}