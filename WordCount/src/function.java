import java.awt.Graphics;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.io.IOException;
public class function { 
	static Scanner in = new Scanner(System.in);
	Map<String,Integer> Map = new LinkedHashMap<String, Integer>(); 
    //显示词频和柱状图
    void fund(Map<String, Integer> map){
        System.out.println("请输入需要查询的单词 :");
        String string = in.nextLine();
        String[] word= string.split(",");
        float sum;
        for(int i=0; i<word.length; i++) {
        	for(Map.Entry<String,Integer> w : map.entrySet()) { 
        		if(word[i].equals(w.getKey()))
        		{  
        			System.out.println("单词"+w.getKey() + "出现" + w.getValue()+"次");
        			sum=(float)(w.getValue())/500; 
        			for(int j=0;j<sum;j++){
        				System.out.print("█");
        			}
        			System.out.println();
        		}  
            } 
        }
    }
    //排序 
    void sort(Map<String, Integer> map,int a) {  
       Set<Entry<String,Integer>> m= map.entrySet();   
       LinkedList<Entry<String, Integer>> List = new LinkedList<Entry<String,Integer>>(m);
       if(a==2) {
       Collections.sort(List, new Comparator<Entry<String,Integer>>() {     
           public int compare(Entry<String, Integer> a,  Entry<String, Integer> b) {  
               return b.getValue().compareTo(a.getValue());  
          }     
       });  
       }
       else if(a==3) {
    	   Collections.sort(List, new Comparator<Entry<String,Integer>>() {     
               public int compare(Entry<String, Integer> a,  Entry<String, Integer> b) {  
                   return a.getKey().compareTo(b.getKey());  
              }     
           });  
       }
       for(Entry<String,Integer> entry: List) {  
           Map.put(entry.getKey(), entry.getValue());  
       }  
   } 
  //输出前n个单词
     void print(Map<String, Integer> map) {  
    	sort(map,2);
        System.out.println("请输入查看单词个数：");
        int n = in.nextInt();
        for(Entry<String,Integer> w : Map.entrySet()) {  
            System.out.println("单词"+w.getKey() + "出现" + w.getValue()+"次");  
            n--;
            if(n<=0)	
            	break;
        } 
       
    }  
    //排序写入result.txt
     void Sort(Map<String, Integer> map)throws IOException {  
    	sort(map,3);
        File file = new File("result.txt");
        FileWriter f = new FileWriter(file.getAbsoluteFile());
        for(Entry<String,Integer> w: Map.entrySet()) {
        	f.write(w.getKey() + "/" + w.getValue()+"     ");
        }
        f.close();
        System.out.println("结束！");
    }  
}