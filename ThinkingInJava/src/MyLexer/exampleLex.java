//package lexer.JLex;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class exampleLex {
//    /**
//     * 将按间隔符分好的list进行判断，判断是否是合法的子串
//     * @param list
//     * @return
//     */
//    @SuppressWarnings("rawtypes")
//    public List<Map> GetStringAndSortNum(String[] list) {
//        char firstChar;//用于记录第一个首字符
//        String keyword="",sortNum="";//需要输出返回的关键字，种别码
//        String cType,word;//第一个首字符的类型
//
//        //mlist用于返回整个List判断完成后的含有的字符和种别码
//        List<Map> mList=new ArrayList<Map>();
//
//        for(int i=0;i<list.length;i++){
//            Map<String,String>map=new HashMap<String,String>();//m用于保存最后返回的已经判别成功的字和种别码
//            //word代表需要进行处理判断的字
//            word=list[i];
//            //判断word是不是空的串，因为有可能根据空格分割的串中有空的换行符或者空串，不进行处理
//            if(word==""||word==null||word.trim()=="")continue;
//
//            firstChar=word.charAt(0);
//            //获取这个字符的类型
//            cType=GetCharType(firstChar);
//
//            if(cType=="letter"){
//                if(firstChar=='w'||firstChar=='i'||firstChar=='b'||firstChar=='d'||firstChar=='e'||firstChar=='t'){
//                    //获得keyword词
//                    Map<String,String>m=new HashMap<String,String>();//m用于保存最后返回的已经判别成功的字和种别码
//                    m=GetKeyWord(word);
//                    //取出m的值，如果是关键字
//                    if(m!=null){
//                        keyword=m.get("keyword");
//                        sortNum=m.get("sortNum");
//                    }
//                    //不是关键字，但是包含关键字的前一个字符串
//                    else{
//                        if(IsID(word)){
//                            keyword=word;
//                            sortNum=g.getSortNum("ID")+"";
//                        }
//                        else{
//                            System.out.println("这个"+word+"不是合法的ID字符，所在的位置在：第"+(i+1)+"个单词");
//                        }
//                    }
//                }
//                else{//首字母为字符，但是需要进一步判断是不是合法的ID
//                    if(IsID(word)){
//                        keyword=word;
//                        sortNum=g.getSortNum("ID")+"";
//                    }
//                    else{
//                        System.out.println("这个"+word+"不是合法的ID字符，所在的位置在：第"+(i+1)+"个单词");
//                    }
//                }
//            }
//            if(cType=="digit"){
//                if(IsNum(word)){
//                    keyword=word;
//                    sortNum=g.getSortNum("NUM")+"";
//                }
//                else{
//                    System.out.println("这个"+word+"不是合法的NUM字符，所在的位置在：第"+(i+1)+"个单词");
//                }
//            }
//            if(cType=="opts"){
//                //获取这个word的长度，如果是一个进行单运算符的判断，如果是2进行多运算符的判断
//                int len=word.length();
//                if(len==1){
//                    if(IsSingleOpt(word)){
//                        keyword=word;
//                        sortNum=g.getSortNum(word)+"";
//                    }
//                    else if(IsEndOpt(word)){
//                        keyword=word;
//                        sortNum=g.getSortNum(word)+"";
//                    }
//                    else{
//                        System.out.println("这个"+word+"不是合法的NUM字符，所在的位置在：第"+(i+1)+"个单词");
//                    }
//                }
//                else if(len==2){
//                    if(IsDoubleOpt(word)){
//                        keyword=word;
//                        sortNum=g.getSortNum(word)+"";
//                    }
//                    else{
//                        System.out.println("这个"+word+"不是合法的NUM字符，所在的位置在：第"+(i+1)+"个单词");
//                    }
//                }
//                else{
//                    System.out.println("这个"+word+"不是合法的NUM字符，所在的位置在：第"+(i+1)+"个单词");
//                }
//            }
//            if(keyword.equals("")||sortNum.equals("")||keyword==""||sortNum=="")
//                continue;
//            else{
//                map.put("keyword", keyword);
//                map.put("sortNum", sortNum);
//                mList.add(map);
//                keyword="";
//                sortNum="";
//            }
//        }
//        return mList;
//
//}
