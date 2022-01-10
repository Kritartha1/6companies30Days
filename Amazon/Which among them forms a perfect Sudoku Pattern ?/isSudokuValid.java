class Solution{
    
    static int isValid(int mat[][]){
        // code here
        if(!digCheck(mat)){
            return 0;
        }
        return (rowCheck(mat)&&colCheck(mat)&&boxCheck(mat))?1:0;
    }
    //fncn0: valid digits check
    //fncn1: row check
    //fncn2: col check
    //fncn3: 3*3 box check
    
    
    //fncn 0:
    static boolean digCheck(int mat[][]){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(mat[i][j]<0||mat[i][j]>9){
                    return false;
                }
            }
        }
        return true;
        
    }
    
    
    //fncn 1
    static boolean rowCheck(int mat[][]){
        boolean[] Visrow=new boolean[10];
        for(int i=0;i<9;i++){
            Arrays.fill(Visrow,false);
            for(int j=0;j<9;j++){
                if(mat[i][j]==0){
                    continue;
                }else if(!Visrow[mat[i][j]]){
                    Visrow[mat[i][j]]=true;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    
    //fncn 2:
     static boolean colCheck(int mat[][]){
        boolean VisCol[]=new boolean[10];
        for(int i=0;i<9;i++){
            Arrays.fill(VisCol,false);
            for(int j=0;j<9;j++){
                if(mat[j][i]==0){
                    continue;
                }else if(!VisCol[mat[j][i]]){
                    VisCol[mat[j][i]]=true;
                }else{
                    return false;
                }
                
            }
        }
        return true;
    }
    
    //fncn 3:
    static boolean boxCheck(int mat[][]){
        boolean[] vis=new boolean[10];
        for(int r=0;r<=6;r+=3){//9 boxes total
        // r and c will store the top left indices of each box
        for(int c=0;c<=6;c+=3){
            
                Arrays.fill(vis,false);
            
            
            for(int i=r;i<r+3;i++){
                for(int j=c;j<c+3;j++){
                    if(mat[i][j]==0){
                        continue;
                    }else if(!vis[mat[i][j]]){
                        vis[mat[i][j]]=!vis[mat[i][j]];
                    }else{
                        return false;
                    }
                }
            }
        }
            
        }
        return true;
    }
    
    
}
