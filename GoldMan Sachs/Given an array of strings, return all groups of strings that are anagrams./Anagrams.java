class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
               // Code here
        List<List<String>> ans=new ArrayList<>();
        HashMap<String, ArrayList<String>> mp=new HashMap<>();


        for(int i=0;i<string_list.length;i++){
            char[] k=string_list[i].toCharArray();
            Arrays.sort(k);
            String a=String.valueOf(k);
            ArrayList<String> s=mp.getOrDefault(a,new ArrayList<String>());
            s.add(string_list[i]);
            mp.put(a,s);


        }
        for(Map.Entry m:mp.entrySet()){
            ans.add((List<String>) m.getValue());
        }
        return ans;
    }
}
