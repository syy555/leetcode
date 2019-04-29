package cat.leetcodes.L22_GenerateParentheses.L21_MergeTwoSortedLists;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateOneByOne(list,"",n,n,n);
        return list;
    }

    public void generateOneByOne(List<String> list,String temp, int left,int right, int length){
        //当长度满足条件时加入当前str到list里
        if(temp.length() == length*2){
            list.add(temp);
            return;
        }
        if(left>0){
            //这里不能改变当前function里temp的值，只能递归给下一个，否则return回来的时候会影响后续操作
            generateOneByOne(list,temp+"(",left-1,right,length);
        }
        if(right>left){
            generateOneByOne(list,temp+")",left,right-1,length);
        }
    }
}