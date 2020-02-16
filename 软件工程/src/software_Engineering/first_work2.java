package chinese_compilation;

import java.util.*;

public class first_work2 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		// transition_chinese1 r1=new transition_chinese1();//汉——>数
		// transition_chinese2 r2=new transition_chinese2();//数——>汉
		addition_and_subtraction r3 = new addition_and_subtraction();
		save r5 = new save();// 保存
		three_unary r6 = new three_unary();//三目运算
		String[][] a1 = new String[5][10];// 用于保存变量
		String[] a0 = new String[10];// 用于保存屏幕输入
		String a0_1;
		int flat = 0;
		for (int k = 0;; k++) {
			System.out.println("输入变量（例如：整数 气温 等于 十）");
			a0_1 = sc.nextLine();// 屏幕输入
			a0 = a0_1.split(" ");// 保存屏幕输入
			System.out.println("a0=" + Arrays.toString(a0));
			if (a0[0].equals("整数") && a0[2].equals("等于")) {
				System.out.println("flat=" + (flat + 1));
				r5.save(a0, a1, flat);
				flat++;
				if (flat == 5) {
					System.out.println("内存满了，覆盖a1");
					flat = 0;
				}
			} 
			else if (a0[0].equals("看看")) {
				int c1 = -1;
				for (int i1 = 0; i1 < 5; i1++) {
					if (a0[1].equals(a1[i1][1])) {
						System.out.println("在a1[" + i1 + "][]中");
						c1 = i1;
					}
				}
				if (c1 == -1)
					System.out.println("未找到变量");
				else {
					for (int i2 = 0; i2 < 10; i2++) {
						System.out.print(a1[c1][i2] + " ");
					}
					System.out.println();
				}

			} 
			else if (a0[0].equals("看看全部")) {
				System.out.println(Arrays.deepToString(a1));
			} 
			else if (a0[1].equals("增加") || a0[1].equals("减少")) {// 加减运算
				r3.addition_and_subtraction(a0, a1);
			} 
			else if (a0[0].equals("如果")) {
				r6.three_unary(a0, a1);
			}
		}
	}
}

class transition_chinese1 {//汉——>数
	int transition_chinese(String a) {
		switch (a) {
		case "零":
			return 0;
		case "一":
			return 1;
		case "二":
			return 2;
		case "三":
			return 3;
		case "四":
			return 4;
		case "五":
			return 5;
		case "六":
			return 6;
		case "七":
			return 7;
		case "八":
			return 8;
		case "九":
			return 9;
		case "十":
			return 10;
		default:
			System.out.println("未找到数字");
			return 0;
		}
	}
}

class transition_chinese2 {//数——>汉
	String transition_chinese(int a) {
		switch (a) {
		case 0:
			return "零";
		case 1:
			return "一";
		case 2:
			return "二";
		case 3:
			return "三";
		case 4:
			return "四";
		case 5:
			return "五";
		case 6:
			return "六";
		case 7:
			return "七";
		case 8:
			return "八";
		case 9:
			return "九";
		case 10:
			return "十";
		default:
			System.out.println("数据溢出");
			return "零";
		}
	}
}

class addition_and_subtraction {
	void addition_and_subtraction(String[] a0, String[][] a1) {
		transition_chinese1 r1 = new transition_chinese1();// 汉——>数
		transition_chinese2 r2 = new transition_chinese2();// 数——>汉
		int c1 = -1;
		for (int i = 0; i < 5; i++) {
			if (a0[0].equals(a1[i][1])) {
				System.out.println("在a1[" + i + "][]中");
				c1 = i;
			}
		}
		if (c1 == -1)
			System.out.println("未找到变量");
		else {
			if (a0[1].equals("减少")) {
				a1[c1][3] = r2.transition_chinese(r1.transition_chinese(a1[c1][3]) - r1.transition_chinese(a0[2]));
			}
			if (a0[1].equals("增加")) {
				a1[c1][3] = r2.transition_chinese(r1.transition_chinese(a1[c1][3]) + r1.transition_chinese(a0[2]));
			}
		}
	}
}

class save {
	void save(String[] a0, String[][] a1, int k) {
		for (int i = 0; i < 4; i++) {
			a1[k][i] = a0[i];
		}
	}
}

class three_unary {
	void three_unary(String[] a0, String[][] a1) {
		transition_chinese1 r1 = new transition_chinese1();// 汉——>数
		transition_chinese2 r2 = new transition_chinese2();// 数——>汉
		addition_and_subtraction r3 = new addition_and_subtraction();
		int c1 = -1;
		for (int i = 0; i < 4; i++) {
			if (a0[1].equals(a1[i][1])) {
				System.out.println("在a1[" + i + "][]中");
				c1 = i;
			}
		}
		if (c1 == -1)
			System.out.println("未找到变量");
		else {
			if(a0[2].equals("大于")) {
				
				if (r1.transition_chinese(a1[c1][3]) > r1.transition_chinese(a0[3])) {
					int c2 = -1;
					for (int i = 0; i < 4; i++) {
						if (a0[5].equals(a1[i][1])) {
							System.out.println("在a1[" + i + "][]中");
							c2 = i;
						}
					}
					if (c2 != -1) {
						if (a0[6].equals("增加")) {
							a1[c2][3] = r2.transition_chinese(r1.transition_chinese(a1[c2][3]) + r1.transition_chinese(a0[7]));
						}
						if (a0[6].equals("减少")) {
							a1[c2][3] = r2.transition_chinese(r1.transition_chinese(a1[c2][3]) - r1.transition_chinese(a0[7]));
						}
						
					}
					else if(a0[5].equals("看看")) System.out.println(a0[6]);

				}
				else {System.out.println(a0[9]);}
			}
            if(a0[2].equals("小于")) {
            	if (r1.transition_chinese(a1[c1][3]) < r1.transition_chinese(a0[3])) {
            		int c2 = -1;
            		for (int i = 0; i < 4; i++) {
            			if (a0[5].equals(a1[i][1])) {
            				System.out.println("在a1[" + i + "][]中");
            				c2 = i;
            			}
            		}
            		if (c2 != -1) {
            			if (a0[6].equals("增加")) {
            				a1[c2][3] = r2.transition_chinese(r1.transition_chinese(a1[c2][3]) + r1.transition_chinese(a0[7]));
            			}
            			if (a0[6].equals("减少")) {
            				a1[c2][3] = r2.transition_chinese(r1.transition_chinese(a1[c2][3]) - r1.transition_chinese(a0[7]));
            			}
            		}
            		else if(a0[5].equals("看看")) System.out.println(a0[6]);

            	}
            	else {System.out.println(a0[9]);}
			}

		}
	}	
}
