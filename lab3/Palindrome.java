import java.util.*;
public class Palindrome {
      public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          String str = sc.nextLine();
          if(isPalindrome(str)){
            System.out.println(1);
          }else{
            System.out.println(0);
          }
          sc.close();
      }
      public static boolean  isPalindrome(String s){
            s = s.toLowerCase();
            int count_index = 0;
            for(int i = 0;i<s.length();i++){
                  char c = s.charAt(i);
                  if((c>='a' && c<='z')||(c>='0' && c<='9')){
                        count_index++;
                  }  
            }

            
            char[] s1= new char[count_index];
            int ind =0;

            for(int i = 0 ; i<s.length();i++){
                  char c = s.charAt(i);
                  if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                        s1[ind] = c;
                        ind++;
                  }
            }


            char[] s2 = new char[count_index];
            for(int i =0 ;i<count_index;i++){
                  s2[i] = s1[count_index-1-i];
            }

            for(int i=0 ;i<count_index;i++){
                  if(s1[i] != s2[i]){
                        return false;
                  }
            }

            return true;
      }    
}
