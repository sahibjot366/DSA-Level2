import java.util.*;



class MazePath{

    static int[][] dir={{1,0},{1,1},{0,1}};
    static char[] dirN={'V','D','H'};
    static class Ans{
        int count;
        ArrayList<String> arr;
        Ans(){};
        Ans(int count,ArrayList<String> arr){
            this.count=count;
            this.arr=arr;
        }
    }

    public static Ans mazePath(int srcR,int srcC,int destR,int destC,String path){
        if((srcR==destR) && (srcC==destC)){
            ArrayList<String> ans=new ArrayList<>();
            ans.add(path);
            return new Ans(1,ans);
        }
        int count=0,r=0,c=0;
        ArrayList<String> arr=new ArrayList<>();
        for(int d=0;d<dir.length;d++){
            r=srcR+dir[d][0];
            c=srcC+dir[d][1];
            char direction=dirN[d];
            if(r>=0 && r<=destR && c>=0 && c<=destC){
                Ans ans=mazePath(r,c,destR,destC,path+direction);
                count+=ans.count;
                for(String str:ans.arr){
                    arr.add(str);
                }
            }
        }
        return new Ans(count,arr);
    }

    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();
        Ans ans=mazePath(0,0,n-1,m-1,"");
        System.out.println(ans.count);
        for(String str:ans.arr){
            System.out.println(str);
        }

    }
}