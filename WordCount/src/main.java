import java.io.BufferedReader;
import java.io.FileReader; 
import java.io.IOException;  
import java.util.Map;
import java.util.Scanner; 
import java.util.TreeMap;
import java.io.IOException;
public class main { 
	static Scanner in = new Scanner(System.in);
    public static void main(String[] args)throws IOException {  
    	// 读取要处理的文件
		BufferedReader b = new BufferedReader(new FileReader("src/HarryPotter.txt"));
       //<单词:词频>
    	Map<String, Integer> map = new TreeMap<String, Integer>();
            String value= b.readLine();
            while (value!= null) {
            	//处理标点符号
            	String[] words = value.split("[【】、.。,\"!--;:?\'\\] ]"); 
            	for (int i = 0; i < words.length; i++) {
            		//将大写字母转换为小写字母
                      String key = words[i].toLowerCase();
                		if (key.length() > 0) {
                      		if (!map.containsKey(key)) {
                          		map.put(key, 1);
                          		} 
                      		else { 
                      			int k = map.get(key)+1;// 如果不是第一次出现，就把k值++
                                map.put(key, k);
                          		}
                      		}
                  		} 
                value = b.readLine();
            }
            System.out.println("chose function:");
            System.out.println("1:显示查询的单词词频");
            System.out.println("2:输出词频最高的前N个单词");
            System.out.println("3:输出单词及词频到result.txt");
            System.out.println("0:退出");
            int w= in.nextInt();  
            while(w!=0){
                switch(w){
                    case 1:{
                    	function rs = new function();
        				rs.fund(map);
            	         }
            	         break;
                    case 2:{
                    	function rs = new function();
        				rs.print(map);
            	         } 
            	        break;
                    case 3:{
                    	function rs = new function();
        				rs.Sort(map);
            	         }
            	        break;
                }
                System.out.println("chose function:");
                w= in.nextInt();  
            }
        }    
}