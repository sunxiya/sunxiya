package sizeyunsan;

import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile; 
public class xiaoxuesheng {
	private static Random random = new Random();
	public static int range;
	public static String reductionofFraction(int a, int b) {// ����Լ�֣����ڼ�����
		int y = 1;
		for (int i = a; i >= 1; i--) {
			if (a % i == 0 && b % i == 0) {
				y = i;
				break;
			}
		}
		int z = a / y;// ����
		int m = b / y;// ��ĸ
		if (z == 0) {
			return "0";
		}
		if(m==1) return z+"";
		else  return biaodashi(z,m);
		
	}
	public static String biaodashi(int a,int b) {//�жϼٷ����������ٷ���Ϊ������
		if(a>=b) {
			int c;
			c=a/b;
			int d;
			d=a%b; 
			{if(d==0) {return c+"";}
			return c+"'"+d+"/"+b;}
		}return a+"/"+b;
	}
	
public static void main(String[] args){
	 Scanner sc= new Scanner(System.in);
     System.out.println("��������������ڵ����֣�");
     range=sc.nextInt();
     System.out.println("������������ٸ�������ʽ��");
     int num=sc.nextInt();
     int rightcount[]=new int[num+2];
 	int wrongcount[]=new int[num+2];
 	int right1=0;
	int wrong1=0;
	String[] results=new String[num];int i;
     for( i=0;i<num;i++){ 
     
        String expArr[]=new String[2];//�������ɵ���Ŀ
        int a= (int) (random.nextInt(range));//����
    	int b= (int) (random.nextInt(range));//��ĸ
    	int c= (int) (random.nextInt(range));//��һ������
    	int d= (int) (random.nextInt(range));//��һ����ĸ
    	int fuhao;//�����
    	fuhao= (int) (random.nextInt(4));
    	if(b!=0&&d!=0) {//��ĸ����Ϊ0ʱ���ɴ��з����ļ����⣬ͬʱ������
    	if(fuhao==0) {
    		int fenzi=a*d+b*c;
    		int fenmu=b*d;
    		expArr[0]=biaodashi(a,b)+'+'+biaodashi(c,d)+'=';
    		System.out.println(expArr[0]);
    		results[i]=reductionofFraction(fenzi, fenmu);
    	
    	}
    	if(fuhao==1&&a*d-b*c>=0) {
    		int fenzi=a*d-b*c;
    		int fenmu=b*d;
    		expArr[0]=biaodashi(a,b)+'-'+biaodashi(c,d)+'=';
    		System.out.println(expArr[0]);
    		results[i]=reductionofFraction(fenzi, fenmu);
    		
    	}
    	if(fuhao==1&&a*d-b*c<0) {
    		int fenzi=b*c-a*d;
    		int fenmu=b*d;
    		expArr[0]=biaodashi(a,b)+'-'+biaodashi(c,d)+'=';
    		System.out.println(expArr[0]);
    		results[i]=reductionofFraction(fenzi, fenmu);
    		
    	}
    	if(fuhao==2) {
    		int fenzi=a*c;
    		int fenmu=b*d;
    		expArr[0]=biaodashi(a,b)+'��'+biaodashi(c,d)+'=';
    		System.out.println(expArr[0]);
    		results[i]=reductionofFraction(fenzi, fenmu);
    		
    	}
    	if(fuhao==3&&c!=0) {
    		int fenzi=a*d;
    		int fenmu=b*c;
    		expArr[0]=biaodashi(a,b)+'��'+biaodashi(c,d)+'=';
    		System.out.println(expArr[0]);
    		results[i]=reductionofFraction(fenzi, fenmu);
    		
    	}
    	if(fuhao==3&&c==0) {
    		break;
    		/*c=1;
    		int fenzi=a*d;
    		int fenmu=b*c;
    		expArr[0]=biaodashi(a,b)+'��'+biaodashi(c,d)+'=';
    		System.out.println(expArr[0]);
    		results[i]=reductionofFraction(fenzi, fenmu);*/
    		
    	}
    	
    	}
    	else {//��ĸ����һ��Ϊ0ʱ����ֻ������ʽ������ʽ��ͬʱ������
    		b=1; d=1;
    	    if(fuhao==0) {
    		int fenzi=a*d+b*c;
    		int fenmu=b*d;
    		expArr[0]=a+"+"+c+"=";
    		System.out.println(expArr[0]);
    		results[i]=reductionofFraction(fenzi, fenmu);
    		
    	}
    	if(fuhao==1&&a*d-b*c>=0) {
    		int fenzi=a*d-b*c;
    		int fenmu=b*d;
    		expArr[0]=a+"-"+c+"=";
    		System.out.println(expArr[0]);
    		results[i]=reductionofFraction(fenzi, fenmu);
    		
    	}
    	if(fuhao==1&&a*d-b*c<0) {
    		int fenzi=b*c-a*d;
    		int fenmu=b*d;
    		expArr[0]=c+"-"+a+"=";
    		System.out.println(expArr[0]);
    		results[i]=reductionofFraction(fenzi, fenmu);
    		
    	}
    	if(fuhao==2) {
    		int fenzi=a*c;
    		int fenmu=b*d;
    		expArr[0]=c+"��"+a+"=";
    		System.out.println(expArr[0]);
    		results[i]=reductionofFraction(fenzi, fenmu);
    		
    	}
    	if(fuhao==3&&c!=0) {
    		int fenzi=a*d;
    		int fenmu=b*c;
    		expArr[0]=a+"��"+c+"=";
    		System.out.println(expArr[0]);
    		results[i]=reductionofFraction(fenzi, fenmu);
    		
    	}
    	if(fuhao==3&&c==0) {
    		break;
    		/*c=1;
    		int fenzi=a*d;
    		int fenmu=b*c;
    		expArr[0]=a+"��"+c+"=";
    		System.out.println(expArr[0]);
    		results[i]=reductionofFraction(fenzi, fenmu);*/
    		
    	}
    	
    	}   
     FileWriter fw = null;
    try {
   
        File f=new File("Exersies.txt");//��Ŀд��
        fw = new FileWriter(f, true);
    } catch (IOException e) {
    	e.printStackTrace();
    }if(expArr[0]!=null) {
    PrintWriter pw = new PrintWriter(fw);
    pw.println(i+1+"."+expArr[0]);
    pw.flush();
    try {
        fw.flush();
        pw.close();
        fw.close();
    } catch (IOException e) {
    	e.printStackTrace();
    }}FileWriter fn = null;
    try {
        
            File f=new File("Answer.txt");//��д��
            fn = new FileWriter(f, true);
        } catch (IOException e) {
        	e.printStackTrace();
        }if(expArr[0]!=null) {
        PrintWriter pn = new PrintWriter(fn);
        pn.println(i+1+"."+results[i]);
        pn.flush();
        try {
            fn.flush();
            pn.close();
            fn.close();
        } catch (IOException e) {
        	e.printStackTrace();
        }}
	}
     System.out.println("����ok�ύ��");
     Scanner sc1=new Scanner(System.in);
     String submit=sc1.nextLine();
	    if(submit.equals("ok")){
     String array[]=new String[num];
     try
		{   int k=0;
		    
			FileReader fr = new FileReader("H://eclipse2//eclipse3//sizeyusuan//Your_answers.txt");
			BufferedReader br = new BufferedReader(fr);
			String s ;
			while((s = br.readLine())!=null) {//��ȡСѧ���Ĵ�
				array[k]=s;	k++;
				}br.close();
			fr.close();		
			}catch(IOException e){
				System.out.println("ָ���ļ�������");
			}
    for(int j=0;j<num;j++){
     	if(array[j].equals(results[j])) {//��֤�𰸣�ͳ����ȷ�ʹ���ĸ���
     		
     		rightcount[j]=j+1;
     		right1++;
     	}
     	else {
     		
     		wrongcount[j]=j+1;
     		wrong1++;
     	}
     }
    FileWriter fg = null;
    try {
        //������ȷ�������Ŀ����Ϣ
            File f=new File("Grade.txt");
            fg = new FileWriter(f, true);
        } catch (IOException e) {
        	e.printStackTrace();
        }
        PrintWriter pg = new PrintWriter(fg);
        pg.println(" ");
        pg.print("Correct:"+right1+"(");
        for (int j = 0; j <= num; j++) {
			if (rightcount[j] != 0) {
				 pg.print(rightcount[j] + ",");
			}
		}
        pg.println(")");
        pg.print("Wrong:"+wrong1+"(");
        for (int j = 0; j <= num; j++) {
			if (wrongcount[j] != 0) {
				 pg.print(wrongcount[j] + ",");
			}
		}
        pg.print(")");
        pg.flush();
        try {
            fg.flush();
            pg.close();
            fg.close();
        } catch (IOException e) {
        	e.printStackTrace();
        }}
}
}
