class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for(int i=0;i<strs.size();i++) {
            int len = strs.get(i).length();
            res.append(len);
            res.append('#');
            res.append(strs.get(i));
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        ArrayList<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++) {
            while(str.charAt(i) != '#'){
                sb.append(str.charAt(i));
                i++;
            }
            int len = Integer.parseInt(sb.toString());
            sb = new StringBuilder();
            res.add(str.substring(i+1,i+len+1));
            i += len;
        }

        return res;
    }
}
