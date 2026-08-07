class AscendSortFreq{
      private int[] A ;

      AscendSortFreq(int[] A) {
            this.A = new int[A.length];
            for(int i=0;i<A.length;i++){
                  this.A[i] = A[i];
            }
      }

      public int[] AscendSort(int[] A){
            int[]B  = new int[A.length];
            for(int i=0;i<A.length;i++){
                  B[i] = A[i];
            }

            for (int i = 0; i < B.length - 1; i++) {

                  for (int j = 0; j < B.length - 1 - i; j++) {

                        if (B[j] > B[j + 1]) {

                              int temp = B[j];
                              B[j] = B[j + 1];
                              B[j + 1] = temp;

                        }

                  }

            }
            return B;
      }

      public int[] SortCommuFreq(int[] B){
            int[] C;
            int count_not_again = 1;
            for(int i=0;i<B.length-1;i++){
                  if(B[i]!=B[i+1]){
                        count_not_again++;
                  }
            } 

            int n = count_not_again;
            C = new int[n];
            int idx = 0;
            int count_n= 0;

            for(int i=0;i<B.length;i++){
                  count_n++;
                  if(i==B.length-1||B[i]!=B[i+1]){
                        C[idx] = count_n;
                        idx++;
                  }
            }
            return C;
      } 
}
public class no4_Ascend {
      public static void main(String[] args) {
      
            int[] A = {9,5,9,5,8};

            AscendSortFreq a = new AscendSortFreq(A);
            int[] B = a.AscendSort(A);
            int[] C = a.SortCommuFreq(B);

            int idx = 0;
            for (int i = 0; i < B.length; i++) {
                  // ตรวจสอบว่าเป็นตัวสุดท้าย หรือค่าไม่ซ้ำกับตัวถัดไป
                  if (i == B.length - 1 || B[i] != B[i + 1]) {
                        System.out.print(B[i]+"\n"+ C[idx]);
      
                        idx++;
                  }
            } 
      }   
}
