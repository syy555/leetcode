package cat.leetcodes.L17LetterCombinationsOfAPhoneNumber;


import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String[] strs = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return answer;
        }
        conert(answer,"",digits,0);
        return answer;
    }

    public void conert(List<String> answer,String temp,String digits,int position){
        int index = Integer.valueOf(digits.charAt(position)+"")-2;
        for(int i = 0; i< strs[index].length() ;i++){
            if(position ==0 && i ==0 ){
                temp = "";
            }
            if(i!=0){
                temp = temp.substring(0,temp.length()-1);
            }
            temp += strs[index].charAt(i);
            if(position<digits.length()-1){
                conert(answer,temp,digits,position+1);
            }else{
                answer.add(temp);
            }
        }
    }
}