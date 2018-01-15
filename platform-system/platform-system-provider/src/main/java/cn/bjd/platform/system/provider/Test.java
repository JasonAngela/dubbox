package cn.bjd.platform.system.provider;

public class Test {

    public static void main(String[] args){
        String str = "92,";
        String[] result = str.split(",");
        System.out.println(result.length);
        int i = 1;
        for(String s : result){
            System.out.println(s+"啦啦啦"+i);
            i++;
        }

    }

}
