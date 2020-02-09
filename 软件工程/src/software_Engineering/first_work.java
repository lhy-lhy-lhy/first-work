package software_Engineering;
import java.util.*;

public class first_work {
	public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
		//transition_chinese1 r1=new transition_chinese1();//汉——>数
		//transition_chinese2 r2=new transition_chinese2();//数——>汉
		addition r3=new addition();//加运算
		subtraction r4=new subtraction();//减法
		String[] a1=new String[10];//用于保存变量1
		String[] a2=new String[10];//用于保存变量2
		String[] a3=new String[10];//用于保存变量3
		String[] a4=new String[10];//用于保存变量4
		String[] a5=new String[10];//用于保存变量5
		String[] b1=new String[9];//用于保存变量名
		int flat=0;
		int c1,c2;//保存
		for(int k=0;;k++)
		{
			c1=0;c2=0;
			String[] a0=new String[10];//用于保存屏幕输入
			System.out.println("输入变量（例如：整数 气温 等于 十）");
			String a0_1=sc.nextLine();//屏幕输入
			a0=a0_1.split(" ");//保存屏幕输入
			System.out.println("a0="+Arrays.toString(a0));
			if(a0[0].equals("整数")) {
				b1[flat]=a0[1];
				flat++;
				if(flat>5) {System.out.println("超出存储范围，警告可能出错");}
				System.out.println("flat="+flat);
				if(flat==1) {System.arraycopy(a0,0,a1,0,4);System.out.println("a1存入成功");}
				else if(flat==2) {System.arraycopy(a0,0,a2,0,4);System.out.println("a2存入成功");}
				else if(flat==3) {System.arraycopy(a0,0,a3,0,4);System.out.println("a3存入成功");}
				else if(flat==4) {System.arraycopy(a0,0,a4,0,4);System.out.println("a4存入成功");}
				else if(flat==5) {System.arraycopy(a0,0,a5,0,4);System.out.println("a5存入成功");}
				else System.out.println("存入失败");
			}
			else if(a0[0].equals("看看")) {
				for(int j=0;j<5;j++) {
					if(a0[1].equals(b1[j])) {c1=1;c2=j+1;System.out.println("在a"+(c2)+"中");}
				}
				if(c1!=1) System.out.println("未找到变量");
				if(c2==1) System.out.println(Arrays.toString(a1));//数据在a1
				else if(c2==2) System.out.println(Arrays.toString(a2));	
				else if(c2==3) System.out.println(Arrays.toString(a3));
				else if(c2==4) System.out.println(Arrays.toString(a4));
				else if(c2==5) System.out.println(Arrays.toString(a5));
			}
			else if(a0[0].equals("看看全部")) {
				System.out.println(Arrays.toString(a1));
				System.out.println(Arrays.toString(a2));
				System.out.println(Arrays.toString(a3));
				System.out.println(Arrays.toString(a4));
				System.out.println(Arrays.toString(a5));
				System.out.println(Arrays.toString(b1));	
			}
			else if(a0[1].equals("增加") || a0[1].equals("减少")) {//加减运算
				for(int j=0;j<5;j++) {
					if(a0[0].equals(b1[j])) {c1=1;c2=j+1;System.out.println("在a"+(c2)+"中");}
				}
				if(c1!=1) System.out.println("未找到变量");
				else if(c2==1) {//数据在a1
					if(a0[1].equals("增加")) {//加运算
						a1[3]=r3.addition(a1[3], a0[2]);
					}
					if(a0[1].equals("减少")) {//减运算
						a1[3]=r4.subtraction(a1[3], a0[2]);
					}
				}
				else if(c2==2) {//数据在a2
					if(a0[1].equals("增加")) {//加运算
						a2[3]=r3.addition(a2[3], a0[2]);
					}
					if(a0[1].equals("减少")) {//减运算
						a2[3]=r4.subtraction(a2[3], a0[2]);
					}
				}
				else if(c2==3) {//数据在a3
					if(a0[1].equals("增加")) {//加运算
						a3[3]=r3.addition(a3[3], a0[2]);
					}
					if(a0[1].equals("减少")) {//减运算
						a3[3]=r4.subtraction(a3[3], a0[2]);
					}
				}
				else if(c2==4) {//数据在a1
					if(a0[1].equals("增加")) {//加运算
						a4[3]=r3.addition(a4[3], a0[2]);
					}
					if(a0[1].equals("减少")) {//减运算
						a4[3]=r4.subtraction(a4[3], a0[2]);
					}
				}
				else if(c2==5) {//数据在a1
					if(a0[1].equals("增加")) {//加运算
						a5[3]=r3.addition(a5[3], a0[2]);
					}
					if(a0[1].equals("减少")) {//减运算
						a5[3]=r4.subtraction(a5[3], a0[2]);
					}
				}
		
           }
         }
	}
}	

class transition_chinese1{
	int transition_chinese(String a) {
		switch(a) {
		case "零":return 0;
		case "一":return 1;
		case "二":return 2;
		case "三":return 3;
		case "四":return 4;
		case "五":return 5;
		case "六":return 6;
		case "七":return 7;
		case "八":return 8;
		case "九":return 9;
		case "十":return 10;
		default :System.out.println("错误");return -1;
		}
	}
}
class transition_chinese2{
	String transition_chinese(int a) {
		switch(a) {
		case 0:return "零";
		case 1:return "一";
		case 2:return "二";
		case 3:return "三";
		case 4:return "四";
		case 5:return "五";
		case 6:return "六";
		case 7:return "七";
		case 8:return "八";
		case 9:return "九";
		case 10:return "十";
		default :System.out.println("数据溢出");return "数据溢出";
		}
	}
}
class addition{
	String addition(String a,String b) {
		transition_chinese1 r1=new transition_chinese1();//汉——>数
		transition_chinese2 r2=new transition_chinese2();//数——>汉
		int c=r1.transition_chinese(a)+r1.transition_chinese(b);
		return r2.transition_chinese(c);
	}
}
class subtraction{
	String subtraction(String a,String b) {
		transition_chinese1 r1=new transition_chinese1();//汉——>数
		transition_chinese2 r2=new transition_chinese2();//数——>汉
		int c=r1.transition_chinese(a)-r1.transition_chinese(b);
		return r2.transition_chinese(c);
	}
}


