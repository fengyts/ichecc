package com.ichecc.constants;

/**
 * <pre>
 * 选车相关选项配置
 * </pre>
 *
 * @author lenovopc
 * @version $Id: ChoiceOptions.java, v 0.1 2018年5月8日 上午10:37:12 lenovopc Exp $
 */
public final class ChoiceOptions {

	/**
	 * <pre>
	 * 动力类型
	 * </pre>
	 *
	 * @author lenovopc
	 * @version $Id: ChoiceOptions.java, v 0.1 2018年5月8日 上午10:42:01 lenovopc Exp
	 *          $
	 */
	public enum Energy {

		OTHER("01", "其他"), NEW_ENERGY("02", "新能源"), GASOLINE("03", "汽油"), DIESEL("04", "柴油");

		public String code;
		public String desc;

		private Energy(String code, String desc) {
			this.code = code;
			this.desc = desc;
		}

	}

	/**
	 * <pre>
	 * 汽车车型：01-其他；02-SUV；03-MPV；04-小轿车
	 * </pre>
	 *
	 * @author lenovopc
	 * @version $Id: ChoiceOptions.java, v 0.1 2018年5月8日 上午10:42:30 lenovopc Exp
	 *          $
	 */
	public enum Type {

		OTHER("01", "其他"), SUV("02", "SUV"), MPV("03", "MPV"), SEDAN("04", "轿车");

		public String code;
		public String desc;

		private Type(String code, String desc) {
			this.code = code;
			this.desc = desc;
		}
	}

	/**
	 * <pre>
	 * 变速箱
	 * </pre>
	 *
	 * @author lenovopc
	 * @version $Id: ChoiceOptions.java, v 0.1 2018年5月8日 上午10:45:02 lenovopc Exp
	 *          $
	 */
	public enum Gearbox {

		MANUAL("01", "手动"), SELF_MOTION("02", "自动");

		public String code;
		public String desc;

		private Gearbox(String code, String desc) {
			this.code = code;
			this.desc = desc;
		}
	}
	
	/**
	 * <pre>
	 * 座位
	 * </pre>
	 *
	 * @author lenovopc
	 * @version $Id: ChoiceOptions.java, v 0.1 2018年5月8日 上午10:47:12 lenovopc Exp $
	 */
	public enum Seat {

		OTHER("01", "其他"), MANUAL("02", "5座"), SELF_MOTION("03", "7座");

		public String code;
		public String desc;

		private Seat(String code, String desc) {
			this.code = code;
			this.desc = desc;
		}
	}

}
