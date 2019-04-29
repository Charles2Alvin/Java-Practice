package myparser;

import java.util.*;

public class PDA {
    private HashMap<String, LinkedList> grammar = new HashMap<>();
    private HashMap<String, LinkedList> first = new HashMap<>();
    private HashSet terminals = new HashSet();
    public PDA() {
        grammar.put("E", new LinkedList(Arrays.asList("TP")));
        grammar.put("P", new LinkedList(Arrays.asList("+TP","e")));
        grammar.put("T", new LinkedList(Arrays.asList("FQ")));
        grammar.put("Q", new LinkedList(Arrays.asList("*FQ","e")));
        grammar.put("F", new LinkedList(Arrays.asList("(E)","id")));

        terminals.addAll(Arrays.asList("(", ")", "id", "*"));
    }
    public void printGrammar() {
        for (Map.Entry<String, LinkedList> entries : grammar.entrySet()) {
            System.out.println(entries.getKey()+" -> "+entries.getValue());
        }
    }
    public void buildFirst(String V) {
        LinkedList<String> lst = grammar.get(V);
        String str = lst.get(0);
        char c = str.charAt(0);
        if (terminals.contains(c)) {
            first.get(V).add(c);
        } else {
            ;
        }
    }
    public static void main(String[] args) {
        PDA pda = new PDA();
        pda.printGrammar();
    }
}
