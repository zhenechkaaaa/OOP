// Generated from ru/nsu/odnostorontseva/autochecker/CourseConfig.g4 by ANTLR 4.13.1

    package ru.nsu.odnostorontseva.autochecker;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CourseConfigParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CourseConfigVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CourseConfigParser#config}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConfig(CourseConfigParser.ConfigContext ctx);
	/**
	 * Visit a parse tree produced by {@link CourseConfigParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(CourseConfigParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CourseConfigParser#taskDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTaskDef(CourseConfigParser.TaskDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link CourseConfigParser#groupDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupDef(CourseConfigParser.GroupDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link CourseConfigParser#studentDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStudentDef(CourseConfigParser.StudentDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link CourseConfigParser#assignmentDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentDef(CourseConfigParser.AssignmentDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link CourseConfigParser#assignEntry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignEntry(CourseConfigParser.AssignEntryContext ctx);
	/**
	 * Visit a parse tree produced by {@link CourseConfigParser#checkpointDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckpointDef(CourseConfigParser.CheckpointDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link CourseConfigParser#settingsBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSettingsBlock(CourseConfigParser.SettingsBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CourseConfigParser#setting}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetting(CourseConfigParser.SettingContext ctx);
	/**
	 * Visit a parse tree produced by {@link CourseConfigParser#gradingCriteria}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGradingCriteria(CourseConfigParser.GradingCriteriaContext ctx);
	/**
	 * Visit a parse tree produced by {@link CourseConfigParser#gradeThreshold}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGradeThreshold(CourseConfigParser.GradeThresholdContext ctx);
	/**
	 * Visit a parse tree produced by {@link CourseConfigParser#behaviorStrategy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBehaviorStrategy(CourseConfigParser.BehaviorStrategyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CourseConfigParser#otherSetting}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOtherSetting(CourseConfigParser.OtherSettingContext ctx);
	/**
	 * Visit a parse tree produced by {@link CourseConfigParser#importStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportStatement(CourseConfigParser.ImportStatementContext ctx);
}