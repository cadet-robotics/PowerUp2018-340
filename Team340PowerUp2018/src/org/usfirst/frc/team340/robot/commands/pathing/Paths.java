package org.usfirst.frc.team340.robot.commands.pathing;

import org.usfirst.frc.team340.robot.Robot;

public class Paths {
	public static class FROM_CENTER {
		public static final Path SWITCH_RIGHT = new Path(
			new PathSegment(t -> 
			/* {"start":{"x":0,"y":50},"mid1":{"x":46,"y":48},"mid2":{"x":51,"y":109},"end":{"x":112,"y":108}} */
			(-6 + 378 * t + -375 * Math.pow(t, 2))/ (138 + -246 * t + 291 * Math.pow(t, 2)) 
			, 131));
		public static final Path SWITCH_LEFT = new Path(
				new PathSegment(t -> 
				/* {"start":{"x":0,"y":100},"mid1":{"x":46,"y":99},"mid2":{"x":51,"y":30},"end":{"x":112,"y":32}} */
				(-3 + -408 * t + 417 * Math.pow(t, 2))/ (138 + -246 * t + 291 * Math.pow(t, 2)) 
				, 137));
	}
	
	public static class FROM_RIGHT {
		public static final Path SCALE_RIGHT = new Path(
				new PathSegment(t -> 
				/* {"start":{"x":0,"y":100},"mid1":{"x":45,"y":97},"mid2":{"x":67,"y":150},"end":{"x":203,"y":150}} */
				(-9 + 336 * t + -327 * Math.pow(t, 2))/ (135 + -138 * t + 411 * Math.pow(t, 2)) 
				, 212));
		public static final Path SCALE_RIGHT_FINISH = new Path(
				new PathSegment(t -> 
				/* {"start":{"x":0,"y":100},"mid1":{"x":19,"y":102},"mid2":{"x":42,"y":85},"end":{"x":60,"y":76}} */
				(6 + -114 * t + 81 * Math.pow(t, 2))/ (57 + 24 * t + -27 * Math.pow(t, 2)) 
				, 66)
				);  
		public static final Path SWITCH_RIGHT = new Path(
				new PathSegment(t -> 
				/* {"start":{"x":0,"y":100},"mid1":{"x":51,"y":96},"mid2":{"x":25,"y":143},"end":{"x":131,"y":136}} */
				(-12 + 306 * t + -315 * Math.pow(t, 2))/ (153 + -462 * t + 627 * Math.pow(t, 2)) 
				, 141)
		);
		public static final Path SWITCH_RIGHT_FINISH = new Path(
				new PathSegment(t -> 
				/* {"start":{"x":0,"y":100},"mid1":{"x":20,"y":90},"mid2":{"x":24,"y":86},"end":{"x":24,"y":64}} */
				(-30 + 36 * t + -72 * Math.pow(t, 2))/ (60 + -96 * t + 36 * Math.pow(t, 2)) 
				, 48)
			);
		public static final Path SWITCH_LEFT = new Path(
				new PathSegment(t -> 
				/* {"start":{"x":0,"y":100},"mid1":{"x":51,"y":96},"mid2":{"x":25,"y":143},"end":{"x":131,"y":136}} */
				(-12 + 306 * t + -315 * Math.pow(t, 2))/ (153 + -462 * t + 627 * Math.pow(t, 2)) 
				, 141),
				new PathSegment(t -> 
				/* {"start":{"x":0,"y":264},"mid1":{"x":78,"y":261},"mid2":{"x":81,"y":199},"end":{"x":72,"y":0}} */
				/* try this if too tight: {"start":{"x":0,"y":264},"mid1":{"x":106,"y":288},"mid2":{"x":67,"y":213},"end":{"x":72,"y":0}} */
				(-9 + -354 * t + -234 * Math.pow(t, 2))/ (234 + -450 * t + 189 * Math.pow(t, 2)) 
				, 306)
				);
		public static final Path SWITCH_LEFT_FINISH = new Path(
				new PathSegment(t -> 
				/* {"start":{"x":100,"y":100},"mid1":{"x":153,"y":106},"mid2":{"x":142,"y":5},"end":{"x":85,"y":12}} */
				(18 + -642 * t + 645 * Math.pow(t, 2))/ (159 + -384 * t + 54 * Math.pow(t, 2)) 
				, 139)
				);
		public static final Path SCALE_LEFT_FINISH = new Path(
				new PathSegment(t -> 
				/* {"start":{"x":100,"y":100},"mid1":{"x":145,"y":90},"mid2":{"x":174,"y":119},"end":{"x":124,"y":180}} */
				(-30 + 234 * t + -21 * Math.pow(t, 2))/ (135 + -96 * t + -189 * Math.pow(t, 2)) 
				, 128)
				);
	}
	
	public static final Path STRAIGHT = new Path(new PathSegment(t -> 0.0, 9999999.999999));
	public static Path straightLength(double length) {
		return new Path(new PathSegment(t -> 0.0, length));
	}
	
	public static Path choose(String fms, int pos, Path left, Path right) {
		return (Path) Robot.choose(fms, pos, left, right);
	}
}