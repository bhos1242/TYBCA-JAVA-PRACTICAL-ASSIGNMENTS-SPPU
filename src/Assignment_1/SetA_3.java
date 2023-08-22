package Assignment_1;
//Java program to print the sum of elements of the array Also display array elements in ascending order


public class SetA_3 {
    public static void main(String[] args) {
        int[] a = {23,43,12,45,56,63,24};

        //sum of array elements
        int sum = 0;
        for(int i=0;i<a.length;i++){
            sum +=a[i];
        }

        System.out.println("Sum of array elements is: "+sum);

        //Display array elements in ascending order
        int smallest=a[0];
        int temp=0;
        for(int j=0;j<a.length;j++){
            for(int k = j+1;k<a.length;k++){
                if(a[k]<a[j]){
                    temp = a[k];
                    a[k] = a[j];
                    a[j] = temp;
                }
            }
        }

        System.out.println("Array elements in ascending order");
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
