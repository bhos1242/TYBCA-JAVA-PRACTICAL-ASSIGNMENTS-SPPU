package Assignment_2.SetA.SetA_4.utility;

public class CapitalString {

    public static String capitalizeFirstLetter(String input){
        if(input == null || input.isEmpty()){
            return input;
        }
        return input.substring(0,1).toUpperCase()+input.substring(1);
    }

}
